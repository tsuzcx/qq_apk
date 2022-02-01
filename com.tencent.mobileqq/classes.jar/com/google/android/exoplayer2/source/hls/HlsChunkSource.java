package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.BehindLiveWindowException;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.chunk.Chunk;
import com.google.android.exoplayer2.source.chunk.ChunkedTrackBlacklistUtil;
import com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist.HlsUrl;
import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist.Segment;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import com.google.android.exoplayer2.util.UriUtil;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.math.BigInteger;
import java.util.List;

class HlsChunkSource
{
  private final DataSource encryptionDataSource;
  private byte[] encryptionIv;
  private String encryptionIvString;
  private byte[] encryptionKey;
  private Uri encryptionKeyUri;
  private HlsMasterPlaylist.HlsUrl expectedPlaylistUrl;
  private final HlsExtractorFactory extractorFactory;
  private IOException fatalError;
  private boolean independentSegments;
  private boolean isTimestampMaster;
  private long liveEdgeTimeUs;
  private final DataSource mediaDataSource;
  private final List<Format> muxedCaptionFormats;
  private final HlsPlaylistTracker playlistTracker;
  private byte[] scratchSpace;
  private final TimestampAdjusterProvider timestampAdjusterProvider;
  private final TrackGroup trackGroup;
  private TrackSelection trackSelection;
  private final HlsMasterPlaylist.HlsUrl[] variants;
  
  public HlsChunkSource(HlsExtractorFactory paramHlsExtractorFactory, HlsPlaylistTracker paramHlsPlaylistTracker, HlsMasterPlaylist.HlsUrl[] paramArrayOfHlsUrl, HlsDataSourceFactory paramHlsDataSourceFactory, TimestampAdjusterProvider paramTimestampAdjusterProvider, List<Format> paramList)
  {
    this.extractorFactory = paramHlsExtractorFactory;
    this.playlistTracker = paramHlsPlaylistTracker;
    this.variants = paramArrayOfHlsUrl;
    this.timestampAdjusterProvider = paramTimestampAdjusterProvider;
    this.muxedCaptionFormats = paramList;
    this.liveEdgeTimeUs = -9223372036854775807L;
    paramHlsExtractorFactory = new Format[paramArrayOfHlsUrl.length];
    paramHlsPlaylistTracker = new int[paramArrayOfHlsUrl.length];
    int i = 0;
    while (i < paramArrayOfHlsUrl.length)
    {
      paramHlsExtractorFactory[i] = paramArrayOfHlsUrl[i].format;
      paramHlsPlaylistTracker[i] = i;
      i += 1;
    }
    this.mediaDataSource = paramHlsDataSourceFactory.createDataSource(1);
    this.encryptionDataSource = paramHlsDataSourceFactory.createDataSource(3);
    this.trackGroup = new TrackGroup(paramHlsExtractorFactory);
    this.trackSelection = new HlsChunkSource.InitializationTrackSelection(this.trackGroup, paramHlsPlaylistTracker);
  }
  
  private void clearEncryptionData()
  {
    this.encryptionKeyUri = null;
    this.encryptionKey = null;
    this.encryptionIvString = null;
    this.encryptionIv = null;
  }
  
  private HlsChunkSource.EncryptionKeyChunk newEncryptionKeyChunk(Uri paramUri, String paramString, int paramInt1, int paramInt2, Object paramObject)
  {
    paramUri = new DataSpec(paramUri, 0L, -1L, null, 1);
    return new HlsChunkSource.EncryptionKeyChunk(this.encryptionDataSource, paramUri, this.variants[paramInt1].format, paramInt2, paramObject, this.scratchSpace, paramString);
  }
  
  private long resolveTimeToLiveEdgeUs(long paramLong)
  {
    long l = -9223372036854775807L;
    if (this.liveEdgeTimeUs != -9223372036854775807L) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        l = this.liveEdgeTimeUs - paramLong;
      }
      return l;
    }
  }
  
  private void setEncryptionData(Uri paramUri, String paramString, byte[] paramArrayOfByte)
  {
    Object localObject;
    byte[] arrayOfByte;
    if (Util.toLowerInvariant(paramString).startsWith("0x"))
    {
      localObject = paramString.substring(2);
      localObject = new BigInteger((String)localObject, 16).toByteArray();
      arrayOfByte = new byte[16];
      if (localObject.length <= 16) {
        break label110;
      }
    }
    label110:
    for (int i = localObject.length - 16;; i = 0)
    {
      System.arraycopy(localObject, i, arrayOfByte, arrayOfByte.length - localObject.length + i, localObject.length - i);
      this.encryptionKeyUri = paramUri;
      this.encryptionKey = paramArrayOfByte;
      this.encryptionIvString = paramString;
      this.encryptionIv = arrayOfByte;
      return;
      localObject = paramString;
      break;
    }
  }
  
  private void updateLiveEdgeTimeUs(HlsMediaPlaylist paramHlsMediaPlaylist)
  {
    if (paramHlsMediaPlaylist.hasEndTag) {}
    for (long l = -9223372036854775807L;; l = paramHlsMediaPlaylist.getEndTimeUs())
    {
      this.liveEdgeTimeUs = l;
      return;
    }
  }
  
  public void getNextChunk(HlsMediaChunk paramHlsMediaChunk, long paramLong1, long paramLong2, HlsChunkSource.HlsChunkHolder paramHlsChunkHolder)
  {
    int i;
    int j;
    if (paramHlsMediaChunk == null)
    {
      i = -1;
      this.expectedPlaylistUrl = null;
      long l4 = paramLong2 - paramLong1;
      long l3 = resolveTimeToLiveEdgeUs(paramLong1);
      long l1 = l4;
      long l2 = l3;
      if (paramHlsMediaChunk != null)
      {
        l1 = l4;
        l2 = l3;
        if (!this.independentSegments)
        {
          long l5 = paramHlsMediaChunk.getDurationUs();
          l4 = Math.max(0L, l4 - l5);
          l1 = l4;
          l2 = l3;
          if (l3 != -9223372036854775807L)
          {
            l2 = Math.max(0L, l3 - l5);
            l1 = l4;
          }
        }
      }
      this.trackSelection.updateSelectedTrack(paramLong1, l1, l2);
      j = this.trackSelection.getSelectedIndexInTrackGroup();
      if (i == j) {
        break label187;
      }
    }
    Object localObject1;
    label187:
    for (int k = 1;; k = 0)
    {
      localObject1 = this.variants[j];
      if (this.playlistTracker.isSnapshotValid((HlsMasterPlaylist.HlsUrl)localObject1)) {
        break label193;
      }
      paramHlsChunkHolder.playlist = ((HlsMasterPlaylist.HlsUrl)localObject1);
      this.expectedPlaylistUrl = ((HlsMasterPlaylist.HlsUrl)localObject1);
      return;
      i = this.trackGroup.indexOf(paramHlsMediaChunk.trackFormat);
      break;
    }
    label193:
    Object localObject2 = this.playlistTracker.getPlaylistSnapshot((HlsMasterPlaylist.HlsUrl)localObject1);
    this.independentSegments = ((HlsMediaPlaylist)localObject2).hasIndependentSegmentsTag;
    updateLiveEdgeTimeUs((HlsMediaPlaylist)localObject2);
    Object localObject3;
    if ((paramHlsMediaChunk == null) || (k != 0))
    {
      paramLong1 = paramLong2;
      if (paramHlsMediaChunk != null)
      {
        if (this.independentSegments) {
          paramLong1 = paramLong2;
        }
      }
      else
      {
        if ((((HlsMediaPlaylist)localObject2).hasEndTag) || (paramLong1 < ((HlsMediaPlaylist)localObject2).getEndTimeUs())) {
          break label327;
        }
        paramLong1 = ((HlsMediaPlaylist)localObject2).mediaSequence + ((HlsMediaPlaylist)localObject2).segments.size();
        localObject3 = localObject2;
        i = j;
        localObject2 = localObject1;
        localObject1 = localObject3;
      }
    }
    for (;;)
    {
      if (paramLong1 < ((HlsMediaPlaylist)localObject1).mediaSequence)
      {
        this.fatalError = new BehindLiveWindowException();
        return;
        paramLong1 = paramHlsMediaChunk.startTimeUs;
        break;
        label327:
        localObject3 = ((HlsMediaPlaylist)localObject2).segments;
        if ((!this.playlistTracker.isLive()) || (paramHlsMediaChunk == null)) {}
        for (boolean bool = true;; bool = false)
        {
          paramLong1 = Util.binarySearchFloor((List)localObject3, Long.valueOf(paramLong1), true, bool) + ((HlsMediaPlaylist)localObject2).mediaSequence;
          if ((paramLong1 >= ((HlsMediaPlaylist)localObject2).mediaSequence) || (paramHlsMediaChunk == null)) {
            break label839;
          }
          localObject2 = this.variants[i];
          localObject1 = this.playlistTracker.getPlaylistSnapshot((HlsMasterPlaylist.HlsUrl)localObject2);
          paramLong1 = paramHlsMediaChunk.getNextChunkIndex();
          break;
        }
        paramLong1 = paramHlsMediaChunk.getNextChunkIndex();
        localObject3 = localObject1;
        i = j;
        localObject1 = localObject2;
        localObject2 = localObject3;
        continue;
      }
      j = (int)(paramLong1 - ((HlsMediaPlaylist)localObject1).mediaSequence);
      if (j >= ((HlsMediaPlaylist)localObject1).segments.size())
      {
        if (((HlsMediaPlaylist)localObject1).hasEndTag)
        {
          paramHlsChunkHolder.endOfStream = true;
          return;
        }
        paramHlsChunkHolder.playlist = ((HlsMasterPlaylist.HlsUrl)localObject2);
        this.expectedPlaylistUrl = ((HlsMasterPlaylist.HlsUrl)localObject2);
        return;
      }
      HlsMediaPlaylist.Segment localSegment = (HlsMediaPlaylist.Segment)((HlsMediaPlaylist)localObject1).segments.get(j);
      if (localSegment.fullSegmentEncryptionKeyUri != null)
      {
        localObject3 = UriUtil.resolveToUri(((HlsMediaPlaylist)localObject1).baseUri, localSegment.fullSegmentEncryptionKeyUri);
        if (!((Uri)localObject3).equals(this.encryptionKeyUri))
        {
          paramHlsChunkHolder.chunk = newEncryptionKeyChunk((Uri)localObject3, localSegment.encryptionIV, i, this.trackSelection.getSelectionReason(), this.trackSelection.getSelectionData());
          return;
        }
        if (!Util.areEqual(localSegment.encryptionIV, this.encryptionIvString)) {
          setEncryptionData((Uri)localObject3, localSegment.encryptionIV, this.encryptionKey);
        }
        localObject3 = ((HlsMediaPlaylist)localObject1).initializationSegment;
        if (localObject3 == null) {
          break label833;
        }
      }
      label833:
      for (localObject3 = new DataSpec(UriUtil.resolveToUri(((HlsMediaPlaylist)localObject1).baseUri, ((HlsMediaPlaylist.Segment)localObject3).url), ((HlsMediaPlaylist.Segment)localObject3).byterangeOffset, ((HlsMediaPlaylist.Segment)localObject3).byterangeLength, null);; localObject3 = null)
      {
        paramLong2 = ((HlsMediaPlaylist)localObject1).startTimeUs - this.playlistTracker.getInitialStartTimeUs() + localSegment.relativeStartTimeUs;
        i = ((HlsMediaPlaylist)localObject1).discontinuitySequence + localSegment.relativeDiscontinuitySequence;
        TimestampAdjuster localTimestampAdjuster = this.timestampAdjusterProvider.getAdjuster(i);
        DataSpec localDataSpec = new DataSpec(UriUtil.resolveToUri(((HlsMediaPlaylist)localObject1).baseUri, localSegment.url), localSegment.byterangeOffset, localSegment.byterangeLength, null);
        paramHlsChunkHolder.chunk = new HlsMediaChunk(this.extractorFactory, this.mediaDataSource, localDataSpec, (DataSpec)localObject3, (HlsMasterPlaylist.HlsUrl)localObject2, this.muxedCaptionFormats, this.trackSelection.getSelectionReason(), this.trackSelection.getSelectionData(), paramLong2, paramLong2 + localSegment.durationUs, paramLong1, i, localSegment.hasGapTag, this.isTimestampMaster, localTimestampAdjuster, paramHlsMediaChunk, ((HlsMediaPlaylist)localObject1).drmInitData, this.encryptionKey, this.encryptionIv);
        return;
        clearEncryptionData();
        break;
      }
      label839:
      localObject3 = localObject1;
      i = j;
      localObject1 = localObject2;
      localObject2 = localObject3;
    }
  }
  
  public TrackGroup getTrackGroup()
  {
    return this.trackGroup;
  }
  
  public TrackSelection getTrackSelection()
  {
    return this.trackSelection;
  }
  
  public void maybeThrowError()
  {
    if (this.fatalError != null) {
      throw this.fatalError;
    }
    if (this.expectedPlaylistUrl != null) {
      this.playlistTracker.maybeThrowPlaylistRefreshError(this.expectedPlaylistUrl);
    }
  }
  
  public void onChunkLoadCompleted(Chunk paramChunk)
  {
    if ((paramChunk instanceof HlsChunkSource.EncryptionKeyChunk))
    {
      paramChunk = (HlsChunkSource.EncryptionKeyChunk)paramChunk;
      this.scratchSpace = paramChunk.getDataHolder();
      setEncryptionData(paramChunk.dataSpec.uri, paramChunk.iv, paramChunk.getResult());
    }
  }
  
  public boolean onChunkLoadError(Chunk paramChunk, boolean paramBoolean, IOException paramIOException)
  {
    return (paramBoolean) && (ChunkedTrackBlacklistUtil.maybeBlacklistTrack(this.trackSelection, this.trackSelection.indexOf(this.trackGroup.indexOf(paramChunk.trackFormat)), paramIOException));
  }
  
  public void onPlaylistBlacklisted(HlsMasterPlaylist.HlsUrl paramHlsUrl, long paramLong)
  {
    int i = this.trackGroup.indexOf(paramHlsUrl.format);
    if (i != -1)
    {
      i = this.trackSelection.indexOf(i);
      if (i != -1) {
        this.trackSelection.blacklist(i, paramLong);
      }
    }
  }
  
  public void reset()
  {
    this.fatalError = null;
  }
  
  public void selectTracks(TrackSelection paramTrackSelection)
  {
    this.trackSelection = paramTrackSelection;
  }
  
  public void setIsTimestampMaster(boolean paramBoolean)
  {
    this.isTimestampMaster = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.source.hls.HlsChunkSource
 * JD-Core Version:    0.7.0.1
 */