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
    Object localObject3;
    Object localObject4;
    if (i < ((List)localObject1).size())
    {
      localObject3 = (HlsMasterPlaylist.HlsUrl)((List)localObject1).get(i);
      localObject4 = ((HlsMasterPlaylist.HlsUrl)localObject3).format;
      if ((((Format)localObject4).height > 0) || (Util.getCodecsOfType(((Format)localObject4).codecs, 2) != null)) {
        ((ArrayList)localObject2).add(localObject3);
      }
      for (;;)
      {
        i += 1;
        break;
        if (Util.getCodecsOfType(((Format)localObject4).codecs, 1) != null) {
          localArrayList.add(localObject3);
        }
      }
    }
    boolean bool;
    label152:
    int j;
    if (!((ArrayList)localObject2).isEmpty())
    {
      localObject1 = localObject2;
      if (((List)localObject1).isEmpty()) {
        break label337;
      }
      bool = true;
      Assertions.checkArgument(bool);
      localObject3 = (HlsMasterPlaylist.HlsUrl[])((List)localObject1).toArray(new HlsMasterPlaylist.HlsUrl[0]);
      localObject4 = localObject3[0].format.codecs;
      localObject2 = buildSampleStreamWrapper(0, (HlsMasterPlaylist.HlsUrl[])localObject3, paramHlsMasterPlaylist.muxedAudioFormat, paramHlsMasterPlaylist.muxedCaptionFormats, paramLong);
      this.sampleStreamWrappers[0] = localObject2;
      if ((!this.allowChunklessPreparation) || (localObject4 == null)) {
        break label637;
      }
      if (Util.getCodecsOfType((String)localObject4, 2) == null) {
        break label343;
      }
      j = 1;
      label235:
      if (Util.getCodecsOfType((String)localObject4, 1) == null) {
        break label349;
      }
    }
    label337:
    label343:
    label349:
    for (i = 1;; i = 0)
    {
      localArrayList = new ArrayList();
      if (j == 0) {
        break label498;
      }
      localObject1 = new Format[((List)localObject1).size()];
      j = 0;
      while (j < localObject1.length)
      {
        localObject1[j] = deriveVideoFormat(localObject3[j].format);
        j += 1;
      }
      if (localArrayList.size() < ((List)localObject1).size()) {
        ((List)localObject1).removeAll(localArrayList);
      }
      break;
      bool = false;
      break label152;
      j = 0;
      break label235;
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
      label498:
      if (i != 0)
      {
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
    }
    else
    {
      ((HlsSampleStreamWrapper)localObject2).prepareWithMasterPlaylistInfo(new TrackGroupArray((TrackGroup[])localArrayList.toArray(new TrackGroup[0])), 0);
      return;
    }
    throw new IllegalArgumentException("Unexpected codecs attribute: " + (String)localObject4);
    label637:
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
    if (j < ((List)localObject1).size())
    {
      localObject2 = (HlsMasterPlaylist.HlsUrl)((List)localObject1).get(j);
      Object localObject3 = Collections.emptyList();
      localObject3 = buildSampleStreamWrapper(1, new HlsMasterPlaylist.HlsUrl[] { localObject2 }, null, (List)localObject3, paramLong);
      this.sampleStreamWrappers[i] = localObject3;
      Format localFormat = ((HlsMasterPlaylist.HlsUrl)localObject2).format;
      if ((this.allowChunklessPreparation) && (localFormat.codecs != null)) {
        ((HlsSampleStreamWrapper)localObject3).prepareWithMasterPlaylistInfo(new TrackGroupArray(new TrackGroup[] { new TrackGroup(new Format[] { ((HlsMasterPlaylist.HlsUrl)localObject2).format }) }), 0);
      }
      for (;;)
      {
        j += 1;
        i += 1;
        break;
        ((HlsSampleStreamWrapper)localObject3).continuePreparing();
      }
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
    if (this.trackGroups != null) {
      this.callback.onContinueLoadingRequested(this);
    }
    for (;;)
    {
      return;
      HlsSampleStreamWrapper[] arrayOfHlsSampleStreamWrapper = this.sampleStreamWrappers;
      int j = arrayOfHlsSampleStreamWrapper.length;
      int i = 0;
      while (i < j)
      {
        arrayOfHlsSampleStreamWrapper[i].continuePreparing();
        i += 1;
      }
    }
  }
  
  private static Format deriveMuxedAudioFormat(Format paramFormat1, Format paramFormat2, int paramInt)
  {
    int j = 0;
    String str2;
    int i;
    String str1;
    if (paramFormat2 != null)
    {
      str2 = paramFormat2.codecs;
      i = paramFormat2.channelCount;
      j = paramFormat2.selectionFlags;
      str1 = paramFormat2.language;
      paramFormat2 = str2;
    }
    for (;;)
    {
      str2 = MimeTypes.getMediaMimeType(paramFormat2);
      return Format.createAudioSampleFormat(paramFormat1.id, str2, paramFormat2, paramInt, -1, i, -1, null, null, j, str1);
      paramFormat2 = Util.getCodecsOfType(paramFormat1.codecs, 1);
      str1 = null;
      i = -1;
    }
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
    if (this.enabledSampleStreamWrappers.length > 0)
    {
      boolean bool = this.enabledSampleStreamWrappers[0].seekToUs(paramLong, false);
      int i = 1;
      while (i < this.enabledSampleStreamWrappers.length)
      {
        this.enabledSampleStreamWrappers[i].seekToUs(paramLong, bool);
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
    int[] arrayOfInt1 = new int[paramArrayOfTrackSelection.length];
    int[] arrayOfInt2 = new int[paramArrayOfTrackSelection.length];
    int i = 0;
    label32:
    Object localObject;
    if (i < paramArrayOfTrackSelection.length)
    {
      if (paramArrayOfSampleStream[i] == null)
      {
        j = -1;
        arrayOfInt1[i] = j;
        arrayOfInt2[i] = -1;
        if (paramArrayOfTrackSelection[i] != null)
        {
          localObject = paramArrayOfTrackSelection[i].getTrackGroup();
          j = 0;
        }
      }
      for (;;)
      {
        if (j < this.sampleStreamWrappers.length)
        {
          if (this.sampleStreamWrappers[j].getTrackGroups().indexOf((TrackGroup)localObject) != -1) {
            arrayOfInt2[i] = j;
          }
        }
        else
        {
          i += 1;
          break;
          j = ((Integer)this.streamWrapperIndices.get(paramArrayOfSampleStream[i])).intValue();
          break label32;
        }
        j += 1;
      }
    }
    boolean bool1 = false;
    this.streamWrapperIndices.clear();
    SampleStream[] arrayOfSampleStream1 = new SampleStream[paramArrayOfTrackSelection.length];
    SampleStream[] arrayOfSampleStream2 = new SampleStream[paramArrayOfTrackSelection.length];
    TrackSelection[] arrayOfTrackSelection = new TrackSelection[paramArrayOfTrackSelection.length];
    HlsSampleStreamWrapper[] arrayOfHlsSampleStreamWrapper = new HlsSampleStreamWrapper[this.sampleStreamWrappers.length];
    int j = 0;
    i = 0;
    int k;
    if (j < this.sampleStreamWrappers.length)
    {
      k = 0;
      if (k < paramArrayOfTrackSelection.length)
      {
        if (arrayOfInt1[k] == j)
        {
          localObject = paramArrayOfSampleStream[k];
          label225:
          arrayOfSampleStream2[k] = localObject;
          if (arrayOfInt2[k] != j) {
            break label270;
          }
        }
        label270:
        for (localObject = paramArrayOfTrackSelection[k];; localObject = null)
        {
          arrayOfTrackSelection[k] = localObject;
          k += 1;
          break;
          localObject = null;
          break label225;
        }
      }
      localObject = this.sampleStreamWrappers[j];
      boolean bool3 = ((HlsSampleStreamWrapper)localObject).selectTracks(arrayOfTrackSelection, paramArrayOfBoolean1, arrayOfSampleStream2, paramArrayOfBoolean2, paramLong, bool1);
      int m = 0;
      k = 0;
      if (k < paramArrayOfTrackSelection.length)
      {
        label337:
        int n;
        if (arrayOfInt2[k] == j) {
          if (arrayOfSampleStream2[k] != null)
          {
            bool2 = true;
            Assertions.checkState(bool2);
            arrayOfSampleStream1[k] = arrayOfSampleStream2[k];
            n = 1;
            this.streamWrapperIndices.put(arrayOfSampleStream2[k], Integer.valueOf(j));
          }
        }
        do
        {
          k += 1;
          m = n;
          break;
          bool2 = false;
          break label337;
          n = m;
        } while (arrayOfInt1[k] != j);
        if (arrayOfSampleStream2[k] == null) {}
        for (boolean bool2 = true;; bool2 = false)
        {
          Assertions.checkState(bool2);
          n = m;
          break;
        }
      }
      if (m == 0) {
        break label569;
      }
      arrayOfHlsSampleStreamWrapper[i] = localObject;
      k = i + 1;
      if (i == 0)
      {
        ((HlsSampleStreamWrapper)localObject).setIsTimestampMaster(true);
        if ((!bool3) && (this.enabledSampleStreamWrappers.length != 0) && (localObject == this.enabledSampleStreamWrappers[0])) {
          break label517;
        }
        this.timestampAdjusterProvider.reset();
        bool1 = true;
        i = k;
      }
    }
    label517:
    label569:
    for (;;)
    {
      j += 1;
      break;
      ((HlsSampleStreamWrapper)localObject).setIsTimestampMaster(false);
      i = k;
      continue;
      System.arraycopy(arrayOfSampleStream1, 0, paramArrayOfSampleStream, 0, arrayOfSampleStream1.length);
      this.enabledSampleStreamWrappers = ((HlsSampleStreamWrapper[])Arrays.copyOf(arrayOfHlsSampleStreamWrapper, i));
      this.compositeSequenceableLoader = this.compositeSequenceableLoaderFactory.createCompositeSequenceableLoader(this.enabledSampleStreamWrappers);
      return paramLong;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.source.hls.HlsMediaPeriod
 * JD-Core Version:    0.7.0.1
 */