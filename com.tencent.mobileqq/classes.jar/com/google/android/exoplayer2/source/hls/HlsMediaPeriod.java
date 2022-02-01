package com.google.android.exoplayer2.source.hls;

import android.os.Handler;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.source.CompositeSequenceableLoaderFactory;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaPeriod.Callback;
import com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.SequenceableLoader;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist.HlsUrl;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.PlaylistEventListener;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;

public final class HlsMediaPeriod
  implements MediaPeriod, HlsSampleStreamWrapper.Callback, HlsPlaylistTracker.PlaylistEventListener
{
  private final Allocator allocator;
  private final boolean allowChunklessPreparation;
  private MediaPeriod.Callback callback;
  private SequenceableLoader compositeSequenceableLoader;
  private final CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory;
  private final Handler continueLoadingHandler;
  private final HlsDataSourceFactory dataSourceFactory;
  private HlsSampleStreamWrapper[] enabledSampleStreamWrappers;
  private final MediaSourceEventListener.EventDispatcher eventDispatcher;
  private final HlsExtractorFactory extractorFactory;
  private final int minLoadableRetryCount;
  private int pendingPrepareCount;
  private final HlsPlaylistTracker playlistTracker;
  private HlsSampleStreamWrapper[] sampleStreamWrappers;
  private final IdentityHashMap<SampleStream, Integer> streamWrapperIndices;
  private final TimestampAdjusterProvider timestampAdjusterProvider;
  private TrackGroupArray trackGroups;
  
  public HlsMediaPeriod(HlsExtractorFactory paramHlsExtractorFactory, HlsPlaylistTracker paramHlsPlaylistTracker, HlsDataSourceFactory paramHlsDataSourceFactory, int paramInt, MediaSourceEventListener.EventDispatcher paramEventDispatcher, Allocator paramAllocator, CompositeSequenceableLoaderFactory paramCompositeSequenceableLoaderFactory, boolean paramBoolean)
  {
    this.extractorFactory = paramHlsExtractorFactory;
    this.playlistTracker = paramHlsPlaylistTracker;
    this.dataSourceFactory = paramHlsDataSourceFactory;
    this.minLoadableRetryCount = paramInt;
    this.eventDispatcher = paramEventDispatcher;
    this.allocator = paramAllocator;
    this.compositeSequenceableLoaderFactory = paramCompositeSequenceableLoaderFactory;
    this.allowChunklessPreparation = paramBoolean;
    this.streamWrapperIndices = new IdentityHashMap();
    this.timestampAdjusterProvider = new TimestampAdjusterProvider();
    this.continueLoadingHandler = new Handler();
    this.sampleStreamWrappers = new HlsSampleStreamWrapper[0];
    this.enabledSampleStreamWrappers = new HlsSampleStreamWrapper[0];
  }
  
  private void buildAndPrepareMainSampleStreamWrapper(HlsMasterPlaylist paramHlsMasterPlaylist, long paramLong)
  {
    Object localObject1 = new ArrayList(paramHlsMasterPlaylist.variants);
    Object localObject2 = new ArrayList();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < ((List)localObject1).size())
    {
      localObject3 = (HlsMasterPlaylist.HlsUrl)((List)localObject1).get(i);
      localObject4 = ((HlsMasterPlaylist.HlsUrl)localObject3).format;
      if ((((Format)localObject4).height <= 0) && (Util.getCodecsOfType(((Format)localObject4).codecs, 2) == null))
      {
        if (Util.getCodecsOfType(((Format)localObject4).codecs, 1) != null) {
          localArrayList.add(localObject3);
        }
      }
      else {
        ((ArrayList)localObject2).add(localObject3);
      }
      i += 1;
    }
    if (!((ArrayList)localObject2).isEmpty()) {
      localObject1 = localObject2;
    } else if (localArrayList.size() < ((List)localObject1).size()) {
      ((List)localObject1).removeAll(localArrayList);
    }
    Assertions.checkArgument(((List)localObject1).isEmpty() ^ true);
    Object localObject3 = (HlsMasterPlaylist.HlsUrl[])((List)localObject1).toArray(new HlsMasterPlaylist.HlsUrl[0]);
    Object localObject4 = localObject3[0].format.codecs;
    localObject2 = buildSampleStreamWrapper(0, (HlsMasterPlaylist.HlsUrl[])localObject3, paramHlsMasterPlaylist.muxedAudioFormat, paramHlsMasterPlaylist.muxedCaptionFormats, paramLong);
    this.sampleStreamWrappers[0] = localObject2;
    if ((this.allowChunklessPreparation) && (localObject4 != null))
    {
      int j;
      if (Util.getCodecsOfType((String)localObject4, 2) != null) {
        j = 1;
      } else {
        j = 0;
      }
      if (Util.getCodecsOfType((String)localObject4, 1) != null) {
        i = 1;
      } else {
        i = 0;
      }
      localArrayList = new ArrayList();
      if (j != 0)
      {
        localObject1 = new Format[((List)localObject1).size()];
        j = 0;
        while (j < localObject1.length)
        {
          localObject1[j] = deriveVideoFormat(localObject3[j].format);
          j += 1;
        }
        localArrayList.add(new TrackGroup((Format[])localObject1));
        if ((i != 0) && ((paramHlsMasterPlaylist.muxedAudioFormat != null) || (paramHlsMasterPlaylist.audios.isEmpty()))) {
          localArrayList.add(new TrackGroup(new Format[] { deriveMuxedAudioFormat(localObject3[0].format, paramHlsMasterPlaylist.muxedAudioFormat, -1) }));
        }
        paramHlsMasterPlaylist = paramHlsMasterPlaylist.muxedCaptionFormats;
        if (paramHlsMasterPlaylist != null)
        {
          i = 0;
          while (i < paramHlsMasterPlaylist.size())
          {
            localArrayList.add(new TrackGroup(new Format[] { (Format)paramHlsMasterPlaylist.get(i) }));
            i += 1;
          }
        }
      }
      else
      {
        if (i == 0) {
          break label600;
        }
        localObject1 = new Format[((List)localObject1).size()];
        i = 0;
        while (i < localObject1.length)
        {
          localObject4 = localObject3[i].format;
          localObject1[i] = deriveMuxedAudioFormat((Format)localObject4, paramHlsMasterPlaylist.muxedAudioFormat, ((Format)localObject4).bitrate);
          i += 1;
        }
        localArrayList.add(new TrackGroup((Format[])localObject1));
      }
      ((HlsSampleStreamWrapper)localObject2).prepareWithMasterPlaylistInfo(new TrackGroupArray((TrackGroup[])localArrayList.toArray(new TrackGroup[0])), 0);
      return;
      label600:
      paramHlsMasterPlaylist = new StringBuilder();
      paramHlsMasterPlaylist.append("Unexpected codecs attribute: ");
      paramHlsMasterPlaylist.append((String)localObject4);
      throw new IllegalArgumentException(paramHlsMasterPlaylist.toString());
    }
    ((HlsSampleStreamWrapper)localObject2).setIsTimestampMaster(true);
    ((HlsSampleStreamWrapper)localObject2).continuePreparing();
  }
  
  private void buildAndPrepareSampleStreamWrappers(long paramLong)
  {
    Object localObject2 = this.playlistTracker.getMasterPlaylist();
    Object localObject1 = ((HlsMasterPlaylist)localObject2).audios;
    List localList = ((HlsMasterPlaylist)localObject2).subtitles;
    int i = ((List)localObject1).size() + 1 + localList.size();
    this.sampleStreamWrappers = new HlsSampleStreamWrapper[i];
    this.pendingPrepareCount = i;
    buildAndPrepareMainSampleStreamWrapper((HlsMasterPlaylist)localObject2, paramLong);
    int j = 0;
    i = 1;
    while (j < ((List)localObject1).size())
    {
      localObject2 = (HlsMasterPlaylist.HlsUrl)((List)localObject1).get(j);
      Object localObject3 = Collections.emptyList();
      localObject3 = buildSampleStreamWrapper(1, new HlsMasterPlaylist.HlsUrl[] { localObject2 }, null, (List)localObject3, paramLong);
      this.sampleStreamWrappers[i] = localObject3;
      Format localFormat = ((HlsMasterPlaylist.HlsUrl)localObject2).format;
      if ((this.allowChunklessPreparation) && (localFormat.codecs != null)) {
        ((HlsSampleStreamWrapper)localObject3).prepareWithMasterPlaylistInfo(new TrackGroupArray(new TrackGroup[] { new TrackGroup(new Format[] { ((HlsMasterPlaylist.HlsUrl)localObject2).format }) }), 0);
      } else {
        ((HlsSampleStreamWrapper)localObject3).continuePreparing();
      }
      j += 1;
      i += 1;
    }
    j = 0;
    while (j < localList.size())
    {
      localObject1 = (HlsMasterPlaylist.HlsUrl)localList.get(j);
      localObject2 = Collections.emptyList();
      localObject2 = buildSampleStreamWrapper(3, new HlsMasterPlaylist.HlsUrl[] { localObject1 }, null, (List)localObject2, paramLong);
      this.sampleStreamWrappers[i] = localObject2;
      ((HlsSampleStreamWrapper)localObject2).prepareWithMasterPlaylistInfo(new TrackGroupArray(new TrackGroup[] { new TrackGroup(new Format[] { ((HlsMasterPlaylist.HlsUrl)localObject1).format }) }), 0);
      j += 1;
      i += 1;
    }
    this.enabledSampleStreamWrappers = this.sampleStreamWrappers;
  }
  
  private HlsSampleStreamWrapper buildSampleStreamWrapper(int paramInt, HlsMasterPlaylist.HlsUrl[] paramArrayOfHlsUrl, Format paramFormat, List<Format> paramList, long paramLong)
  {
    return new HlsSampleStreamWrapper(paramInt, this, new HlsChunkSource(this.extractorFactory, this.playlistTracker, paramArrayOfHlsUrl, this.dataSourceFactory, this.timestampAdjusterProvider, paramList), this.allocator, paramLong, paramFormat, this.minLoadableRetryCount, this.eventDispatcher);
  }
  
  private void continuePreparingOrLoading()
  {
    if (this.trackGroups != null)
    {
      this.callback.onContinueLoadingRequested(this);
      return;
    }
    HlsSampleStreamWrapper[] arrayOfHlsSampleStreamWrapper = this.sampleStreamWrappers;
    int j = arrayOfHlsSampleStreamWrapper.length;
    int i = 0;
    while (i < j)
    {
      arrayOfHlsSampleStreamWrapper[i].continuePreparing();
      i += 1;
    }
  }
  
  private static Format deriveMuxedAudioFormat(Format paramFormat1, Format paramFormat2, int paramInt)
  {
    int i;
    int j;
    String str1;
    if (paramFormat2 != null)
    {
      str2 = paramFormat2.codecs;
      i = paramFormat2.channelCount;
      j = paramFormat2.selectionFlags;
      str1 = paramFormat2.language;
      paramFormat2 = str2;
    }
    else
    {
      paramFormat2 = Util.getCodecsOfType(paramFormat1.codecs, 1);
      str1 = null;
      i = -1;
      j = 0;
    }
    String str2 = MimeTypes.getMediaMimeType(paramFormat2);
    return Format.createAudioSampleFormat(paramFormat1.id, str2, paramFormat2, paramInt, -1, i, -1, null, null, j, str1);
  }
  
  private static Format deriveVideoFormat(Format paramFormat)
  {
    String str1 = Util.getCodecsOfType(paramFormat.codecs, 2);
    String str2 = MimeTypes.getMediaMimeType(str1);
    return Format.createVideoSampleFormat(paramFormat.id, str2, str1, paramFormat.bitrate, -1, paramFormat.width, paramFormat.height, paramFormat.frameRate, null, null);
  }
  
  public boolean continueLoading(long paramLong)
  {
    return this.compositeSequenceableLoader.continueLoading(paramLong);
  }
  
  public void discardBuffer(long paramLong, boolean paramBoolean)
  {
    HlsSampleStreamWrapper[] arrayOfHlsSampleStreamWrapper = this.enabledSampleStreamWrappers;
    int j = arrayOfHlsSampleStreamWrapper.length;
    int i = 0;
    while (i < j)
    {
      arrayOfHlsSampleStreamWrapper[i].discardBuffer(paramLong, paramBoolean);
      i += 1;
    }
  }
  
  public long getAdjustedSeekPositionUs(long paramLong, SeekParameters paramSeekParameters)
  {
    return paramLong;
  }
  
  public long getBufferedPositionUs()
  {
    return this.compositeSequenceableLoader.getBufferedPositionUs();
  }
  
  public long getNextLoadPositionUs()
  {
    return this.compositeSequenceableLoader.getNextLoadPositionUs();
  }
  
  public TrackGroupArray getTrackGroups()
  {
    return this.trackGroups;
  }
  
  public void maybeThrowPrepareError()
  {
    HlsSampleStreamWrapper[] arrayOfHlsSampleStreamWrapper = this.sampleStreamWrappers;
    int j = arrayOfHlsSampleStreamWrapper.length;
    int i = 0;
    while (i < j)
    {
      arrayOfHlsSampleStreamWrapper[i].maybeThrowPrepareError();
      i += 1;
    }
  }
  
  public void onContinueLoadingRequested(HlsSampleStreamWrapper paramHlsSampleStreamWrapper)
  {
    if (this.trackGroups == null) {
      return;
    }
    this.callback.onContinueLoadingRequested(this);
  }
  
  public void onPlaylistBlacklisted(HlsMasterPlaylist.HlsUrl paramHlsUrl, long paramLong)
  {
    HlsSampleStreamWrapper[] arrayOfHlsSampleStreamWrapper = this.sampleStreamWrappers;
    int j = arrayOfHlsSampleStreamWrapper.length;
    int i = 0;
    while (i < j)
    {
      arrayOfHlsSampleStreamWrapper[i].onPlaylistBlacklisted(paramHlsUrl, paramLong);
      i += 1;
    }
    continuePreparingOrLoading();
  }
  
  public void onPlaylistChanged()
  {
    continuePreparingOrLoading();
  }
  
  public void onPlaylistRefreshRequired(HlsMasterPlaylist.HlsUrl paramHlsUrl)
  {
    this.playlistTracker.refreshPlaylist(paramHlsUrl);
  }
  
  public void onPrepared()
  {
    int i = this.pendingPrepareCount - 1;
    this.pendingPrepareCount = i;
    if (i > 0) {
      return;
    }
    Object localObject = this.sampleStreamWrappers;
    int k = localObject.length;
    i = 0;
    int j = 0;
    while (i < k)
    {
      j += localObject[i].getTrackGroups().length;
      i += 1;
    }
    localObject = new TrackGroup[j];
    HlsSampleStreamWrapper[] arrayOfHlsSampleStreamWrapper = this.sampleStreamWrappers;
    int m = arrayOfHlsSampleStreamWrapper.length;
    j = 0;
    i = 0;
    while (j < m)
    {
      HlsSampleStreamWrapper localHlsSampleStreamWrapper = arrayOfHlsSampleStreamWrapper[j];
      int n = localHlsSampleStreamWrapper.getTrackGroups().length;
      k = 0;
      while (k < n)
      {
        localObject[i] = localHlsSampleStreamWrapper.getTrackGroups().get(k);
        k += 1;
        i += 1;
      }
      j += 1;
    }
    this.trackGroups = new TrackGroupArray((TrackGroup[])localObject);
    this.callback.onPrepared(this);
  }
  
  public void prepare(MediaPeriod.Callback paramCallback, long paramLong)
  {
    this.callback = paramCallback;
    this.playlistTracker.addListener(this);
    buildAndPrepareSampleStreamWrappers(paramLong);
  }
  
  public long readDiscontinuity()
  {
    return -9223372036854775807L;
  }
  
  public void reevaluateBuffer(long paramLong)
  {
    this.compositeSequenceableLoader.reevaluateBuffer(paramLong);
  }
  
  public void release()
  {
    this.playlistTracker.removeListener(this);
    this.continueLoadingHandler.removeCallbacksAndMessages(null);
    HlsSampleStreamWrapper[] arrayOfHlsSampleStreamWrapper = this.sampleStreamWrappers;
    int j = arrayOfHlsSampleStreamWrapper.length;
    int i = 0;
    while (i < j)
    {
      arrayOfHlsSampleStreamWrapper[i].release();
      i += 1;
    }
  }
  
  public long seekToUs(long paramLong)
  {
    HlsSampleStreamWrapper[] arrayOfHlsSampleStreamWrapper = this.enabledSampleStreamWrappers;
    if (arrayOfHlsSampleStreamWrapper.length > 0)
    {
      boolean bool = arrayOfHlsSampleStreamWrapper[0].seekToUs(paramLong, false);
      int i = 1;
      for (;;)
      {
        arrayOfHlsSampleStreamWrapper = this.enabledSampleStreamWrappers;
        if (i >= arrayOfHlsSampleStreamWrapper.length) {
          break;
        }
        arrayOfHlsSampleStreamWrapper[i].seekToUs(paramLong, bool);
        i += 1;
      }
      if (bool) {
        this.timestampAdjusterProvider.reset();
      }
    }
    return paramLong;
  }
  
  public long selectTracks(TrackSelection[] paramArrayOfTrackSelection, boolean[] paramArrayOfBoolean1, SampleStream[] paramArrayOfSampleStream, boolean[] paramArrayOfBoolean2, long paramLong)
  {
    Object localObject1 = paramArrayOfSampleStream;
    int[] arrayOfInt1 = new int[paramArrayOfTrackSelection.length];
    int[] arrayOfInt2 = new int[paramArrayOfTrackSelection.length];
    int i = 0;
    Object localObject3;
    while (i < paramArrayOfTrackSelection.length)
    {
      if (localObject1[i] == null) {
        j = -1;
      } else {
        j = ((Integer)this.streamWrapperIndices.get(localObject1[i])).intValue();
      }
      arrayOfInt1[i] = j;
      arrayOfInt2[i] = -1;
      if (paramArrayOfTrackSelection[i] != null)
      {
        localObject2 = paramArrayOfTrackSelection[i].getTrackGroup();
        j = 0;
        for (;;)
        {
          localObject3 = this.sampleStreamWrappers;
          if (j >= localObject3.length) {
            break;
          }
          if (localObject3[j].getTrackGroups().indexOf((TrackGroup)localObject2) != -1)
          {
            arrayOfInt2[i] = j;
            break;
          }
          j += 1;
        }
      }
      i += 1;
    }
    this.streamWrapperIndices.clear();
    SampleStream[] arrayOfSampleStream1 = new SampleStream[paramArrayOfTrackSelection.length];
    SampleStream[] arrayOfSampleStream2 = new SampleStream[paramArrayOfTrackSelection.length];
    localObject1 = new TrackSelection[paramArrayOfTrackSelection.length];
    Object localObject2 = new HlsSampleStreamWrapper[this.sampleStreamWrappers.length];
    i = 0;
    int j = 0;
    boolean bool1 = false;
    while (j < this.sampleStreamWrappers.length)
    {
      int k = 0;
      HlsSampleStreamWrapper[] arrayOfHlsSampleStreamWrapper;
      while (k < paramArrayOfTrackSelection.length)
      {
        m = arrayOfInt1[k];
        arrayOfHlsSampleStreamWrapper = null;
        if (m == j) {
          localObject3 = paramArrayOfSampleStream[k];
        } else {
          localObject3 = null;
        }
        arrayOfSampleStream2[k] = localObject3;
        localObject3 = arrayOfHlsSampleStreamWrapper;
        if (arrayOfInt2[k] == j) {
          localObject3 = paramArrayOfTrackSelection[k];
        }
        localObject1[k] = localObject3;
        k += 1;
      }
      localObject3 = this.sampleStreamWrappers[j];
      boolean bool3 = ((HlsSampleStreamWrapper)localObject3).selectTracks((TrackSelection[])localObject1, paramArrayOfBoolean1, arrayOfSampleStream2, paramArrayOfBoolean2, paramLong, bool1);
      k = 0;
      int n;
      for (int m = 0;; m = n)
      {
        n = paramArrayOfTrackSelection.length;
        boolean bool2 = true;
        if (k >= n) {
          break;
        }
        if (arrayOfInt2[k] == j)
        {
          if (arrayOfSampleStream2[k] != null) {
            bool2 = true;
          } else {
            bool2 = false;
          }
          Assertions.checkState(bool2);
          arrayOfSampleStream1[k] = arrayOfSampleStream2[k];
          this.streamWrapperIndices.put(arrayOfSampleStream2[k], Integer.valueOf(j));
          n = 1;
        }
        else
        {
          n = m;
          if (arrayOfInt1[k] == j)
          {
            if (arrayOfSampleStream2[k] != null) {
              bool2 = false;
            }
            Assertions.checkState(bool2);
            n = m;
          }
        }
        k += 1;
      }
      if (m != 0)
      {
        localObject2[i] = localObject3;
        k = i + 1;
        if (i == 0)
        {
          ((HlsSampleStreamWrapper)localObject3).setIsTimestampMaster(true);
          if (!bool3)
          {
            arrayOfHlsSampleStreamWrapper = this.enabledSampleStreamWrappers;
            if (arrayOfHlsSampleStreamWrapper.length != 0) {
              if (localObject3 == arrayOfHlsSampleStreamWrapper[0]) {
                break label535;
              }
            }
          }
          this.timestampAdjusterProvider.reset();
          i = k;
          bool1 = true;
          break label542;
        }
        else
        {
          ((HlsSampleStreamWrapper)localObject3).setIsTimestampMaster(false);
        }
        label535:
        i = k;
      }
      label542:
      j += 1;
    }
    System.arraycopy(arrayOfSampleStream1, 0, paramArrayOfSampleStream, 0, arrayOfSampleStream1.length);
    this.enabledSampleStreamWrappers = ((HlsSampleStreamWrapper[])Arrays.copyOf((Object[])localObject2, i));
    this.compositeSequenceableLoader = this.compositeSequenceableLoaderFactory.createCompositeSequenceableLoader(this.enabledSampleStreamWrappers);
    return paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.source.hls.HlsMediaPeriod
 * JD-Core Version:    0.7.0.1
 */