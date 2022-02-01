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
    long l2 = this.liveEdgeTimeUs;
    long l1 = -9223372036854775807L;
    int i;
    if (l2 != -9223372036854775807L) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      l1 = this.liveEdgeTimeUs - paramLong;
    }
    return l1;
  }
  
  private void setEncryptionData(Uri paramUri, String paramString, byte[] paramArrayOfByte)
  {
    if (Util.toLowerInvariant(paramString).startsWith("0x")) {
      localObject = paramString.substring(2);
    } else {
      localObject = paramString;
    }
    Object localObject = new BigInteger((String)localObject, 16).toByteArray();
    byte[] arrayOfByte = new byte[16];
    int i;
    if (localObject.length > 16) {
      i = localObject.length - 16;
    } else {
      i = 0;
    }
    System.arraycopy(localObject, i, arrayOfByte, arrayOfByte.length - localObject.length + i, localObject.length - i);
    this.encryptionKeyUri = paramUri;
    this.encryptionKey = paramArrayOfByte;
    this.encryptionIvString = paramString;
    this.encryptionIv = arrayOfByte;
  }
  
  private void updateLiveEdgeTimeUs(HlsMediaPlaylist paramHlsMediaPlaylist)
  {
    long l;
    if (paramHlsMediaPlaylist.hasEndTag) {
      l = -9223372036854775807L;
    } else {
      l = paramHlsMediaPlaylist.getEndTimeUs();
    }
    this.liveEdgeTimeUs = l;
  }
  
  public void getNextChunk(HlsMediaChunk paramHlsMediaChunk, long paramLong1, long paramLong2, HlsChunkSource.HlsChunkHolder paramHlsChunkHolder)
  {
    if (paramHlsMediaChunk == null) {
      i = -1;
    } else {
      i = this.trackGroup.indexOf(paramHlsMediaChunk.trackFormat);
    }
    DataSpec localDataSpec1 = null;
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
    int j = this.trackSelection.getSelectedIndexInTrackGroup();
    boolean bool = false;
    int k;
    if (i != j) {
      k = 1;
    } else {
      k = 0;
    }
    HlsMasterPlaylist.HlsUrl localHlsUrl = this.variants[j];
    if (!this.playlistTracker.isSnapshotValid(localHlsUrl))
    {
      paramHlsChunkHolder.playlist = localHlsUrl;
      this.expectedPlaylistUrl = localHlsUrl;
      return;
    }
    HlsMediaPlaylist localHlsMediaPlaylist = this.playlistTracker.getPlaylistSnapshot(localHlsUrl);
    this.independentSegments = localHlsMediaPlaylist.hasIndependentSegmentsTag;
    updateLiveEdgeTimeUs(localHlsMediaPlaylist);
    if ((paramHlsMediaChunk != null) && (k == 0))
    {
      paramLong1 = paramHlsMediaChunk.getNextChunkIndex();
      i = j;
    }
    else
    {
      if ((paramHlsMediaChunk != null) && (!this.independentSegments)) {
        paramLong2 = paramHlsMediaChunk.startTimeUs;
      }
      if ((!localHlsMediaPlaylist.hasEndTag) && (paramLong2 >= localHlsMediaPlaylist.getEndTimeUs()))
      {
        paramLong1 = localHlsMediaPlaylist.mediaSequence;
        paramLong2 = localHlsMediaPlaylist.segments.size();
        i = j;
        paramLong1 += paramLong2;
      }
      else
      {
        localObject1 = localHlsMediaPlaylist.segments;
        if ((!this.playlistTracker.isLive()) || (paramHlsMediaChunk == null)) {
          bool = true;
        }
        paramLong1 = Util.binarySearchFloor((List)localObject1, Long.valueOf(paramLong2), true, bool) + localHlsMediaPlaylist.mediaSequence;
        if ((paramLong1 < localHlsMediaPlaylist.mediaSequence) && (paramHlsMediaChunk != null))
        {
          localHlsUrl = this.variants[i];
          localHlsMediaPlaylist = this.playlistTracker.getPlaylistSnapshot(localHlsUrl);
          paramLong1 = paramHlsMediaChunk.getNextChunkIndex();
        }
        else
        {
          i = j;
        }
      }
    }
    if (paramLong1 < localHlsMediaPlaylist.mediaSequence)
    {
      this.fatalError = new BehindLiveWindowException();
      return;
    }
    j = (int)(paramLong1 - localHlsMediaPlaylist.mediaSequence);
    if (j >= localHlsMediaPlaylist.segments.size())
    {
      if (localHlsMediaPlaylist.hasEndTag)
      {
        paramHlsChunkHolder.endOfStream = true;
        return;
      }
      paramHlsChunkHolder.playlist = localHlsUrl;
      this.expectedPlaylistUrl = localHlsUrl;
      return;
    }
    Object localObject1 = (HlsMediaPlaylist.Segment)localHlsMediaPlaylist.segments.get(j);
    if (((HlsMediaPlaylist.Segment)localObject1).fullSegmentEncryptionKeyUri != null)
    {
      localObject2 = UriUtil.resolveToUri(localHlsMediaPlaylist.baseUri, ((HlsMediaPlaylist.Segment)localObject1).fullSegmentEncryptionKeyUri);
      if (!((Uri)localObject2).equals(this.encryptionKeyUri))
      {
        paramHlsChunkHolder.chunk = newEncryptionKeyChunk((Uri)localObject2, ((HlsMediaPlaylist.Segment)localObject1).encryptionIV, i, this.trackSelection.getSelectionReason(), this.trackSelection.getSelectionData());
        return;
      }
      if (!Util.areEqual(((HlsMediaPlaylist.Segment)localObject1).encryptionIV, this.encryptionIvString)) {
        setEncryptionData((Uri)localObject2, ((HlsMediaPlaylist.Segment)localObject1).encryptionIV, this.encryptionKey);
      }
    }
    else
    {
      clearEncryptionData();
    }
    Object localObject2 = localHlsMediaPlaylist.initializationSegment;
    if (localObject2 != null) {
      localDataSpec1 = new DataSpec(UriUtil.resolveToUri(localHlsMediaPlaylist.baseUri, ((HlsMediaPlaylist.Segment)localObject2).url), ((HlsMediaPlaylist.Segment)localObject2).byterangeOffset, ((HlsMediaPlaylist.Segment)localObject2).byterangeLength, null);
    }
    paramLong2 = localHlsMediaPlaylist.startTimeUs - this.playlistTracker.getInitialStartTimeUs() + ((HlsMediaPlaylist.Segment)localObject1).relativeStartTimeUs;
    int i = localHlsMediaPlaylist.discontinuitySequence + ((HlsMediaPlaylist.Segment)localObject1).relativeDiscontinuitySequence;
    localObject2 = this.timestampAdjusterProvider.getAdjuster(i);
    DataSpec localDataSpec2 = new DataSpec(UriUtil.resolveToUri(localHlsMediaPlaylist.baseUri, ((HlsMediaPlaylist.Segment)localObject1).url), ((HlsMediaPlaylist.Segment)localObject1).byterangeOffset, ((HlsMediaPlaylist.Segment)localObject1).byterangeLength, null);
    paramHlsChunkHolder.chunk = new HlsMediaChunk(this.extractorFactory, this.mediaDataSource, localDataSpec2, localDataSpec1, localHlsUrl, this.muxedCaptionFormats, this.trackSelection.getSelectionReason(), this.trackSelection.getSelectionData(), paramLong2, paramLong2 + ((HlsMediaPlaylist.Segment)localObject1).durationUs, paramLong1, i, ((HlsMediaPlaylist.Segment)localObject1).hasGapTag, this.isTimestampMaster, (TimestampAdjuster)localObject2, paramHlsMediaChunk, localHlsMediaPlaylist.drmInitData, this.encryptionKey, this.encryptionIv);
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
    Object localObject = this.fatalError;
    if (localObject == null)
    {
      localObject = this.expectedPlaylistUrl;
      if (localObject != null) {
        this.playlistTracker.maybeThrowPlaylistRefreshError((HlsMasterPlaylist.HlsUrl)localObject);
      }
      return;
    }
    throw ((Throwable)localObject);
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
    if (paramBoolean)
    {
      TrackSelection localTrackSelection = this.trackSelection;
      if (ChunkedTrackBlacklistUtil.maybeBlacklistTrack(localTrackSelection, localTrackSelection.indexOf(this.trackGroup.indexOf(paramChunk.trackFormat)), paramIOException)) {
        return true;
      }
    }
    return false;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.source.hls.HlsChunkSource
 * JD-Core Version:    0.7.0.1
 */