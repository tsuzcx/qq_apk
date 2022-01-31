package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.util.Assertions;
import java.util.ArrayList;
import java.util.IdentityHashMap;

final class MergingMediaPeriod
  implements MediaPeriod, MediaPeriod.Callback
{
  private MediaPeriod.Callback callback;
  private SequenceableLoader compositeSequenceableLoader;
  private final CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory;
  private MediaPeriod[] enabledPeriods;
  private int pendingChildPrepareCount;
  public final MediaPeriod[] periods;
  private final IdentityHashMap<SampleStream, Integer> streamPeriodIndices;
  private TrackGroupArray trackGroups;
  
  public MergingMediaPeriod(CompositeSequenceableLoaderFactory paramCompositeSequenceableLoaderFactory, MediaPeriod... paramVarArgs)
  {
    this.compositeSequenceableLoaderFactory = paramCompositeSequenceableLoaderFactory;
    this.periods = paramVarArgs;
    this.streamPeriodIndices = new IdentityHashMap();
  }
  
  public boolean continueLoading(long paramLong)
  {
    return this.compositeSequenceableLoader.continueLoading(paramLong);
  }
  
  public void discardBuffer(long paramLong, boolean paramBoolean)
  {
    MediaPeriod[] arrayOfMediaPeriod = this.enabledPeriods;
    int j = arrayOfMediaPeriod.length;
    int i = 0;
    while (i < j)
    {
      arrayOfMediaPeriod[i].discardBuffer(paramLong, paramBoolean);
      i += 1;
    }
  }
  
  public long getAdjustedSeekPositionUs(long paramLong, SeekParameters paramSeekParameters)
  {
    return this.enabledPeriods[0].getAdjustedSeekPositionUs(paramLong, paramSeekParameters);
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
    MediaPeriod[] arrayOfMediaPeriod = this.periods;
    int j = arrayOfMediaPeriod.length;
    int i = 0;
    while (i < j)
    {
      arrayOfMediaPeriod[i].maybeThrowPrepareError();
      i += 1;
    }
  }
  
  public void onContinueLoadingRequested(MediaPeriod paramMediaPeriod)
  {
    if (this.trackGroups == null) {
      return;
    }
    this.callback.onContinueLoadingRequested(this);
  }
  
  public void onPrepared(MediaPeriod paramMediaPeriod)
  {
    int i = this.pendingChildPrepareCount - 1;
    this.pendingChildPrepareCount = i;
    if (i > 0) {
      return;
    }
    paramMediaPeriod = this.periods;
    int k = paramMediaPeriod.length;
    i = 0;
    int j = 0;
    while (i < k)
    {
      j += paramMediaPeriod[i].getTrackGroups().length;
      i += 1;
    }
    paramMediaPeriod = new TrackGroup[j];
    MediaPeriod[] arrayOfMediaPeriod = this.periods;
    int m = arrayOfMediaPeriod.length;
    j = 0;
    i = 0;
    while (j < m)
    {
      TrackGroupArray localTrackGroupArray = arrayOfMediaPeriod[j].getTrackGroups();
      int n = localTrackGroupArray.length;
      k = 0;
      while (k < n)
      {
        paramMediaPeriod[i] = localTrackGroupArray.get(k);
        k += 1;
        i += 1;
      }
      j += 1;
    }
    this.trackGroups = new TrackGroupArray(paramMediaPeriod);
    this.callback.onPrepared(this);
  }
  
  public void prepare(MediaPeriod.Callback paramCallback, long paramLong)
  {
    this.callback = paramCallback;
    this.pendingChildPrepareCount = this.periods.length;
    paramCallback = this.periods;
    int j = paramCallback.length;
    int i = 0;
    while (i < j)
    {
      paramCallback[i].prepare(this, paramLong);
      i += 1;
    }
  }
  
  public long readDiscontinuity()
  {
    long l = this.periods[0].readDiscontinuity();
    int i = 1;
    while (i < this.periods.length)
    {
      if (this.periods[i].readDiscontinuity() != -9223372036854775807L) {
        throw new IllegalStateException("Child reported discontinuity");
      }
      i += 1;
    }
    if (l != -9223372036854775807L)
    {
      MediaPeriod[] arrayOfMediaPeriod = this.enabledPeriods;
      int j = arrayOfMediaPeriod.length;
      i = 0;
      while (i < j)
      {
        MediaPeriod localMediaPeriod = arrayOfMediaPeriod[i];
        if ((localMediaPeriod != this.periods[0]) && (localMediaPeriod.seekToUs(l) != l)) {
          throw new IllegalStateException("Children seeked to different positions");
        }
        i += 1;
      }
    }
    return l;
  }
  
  public void reevaluateBuffer(long paramLong)
  {
    this.compositeSequenceableLoader.reevaluateBuffer(paramLong);
  }
  
  public long seekToUs(long paramLong)
  {
    paramLong = this.enabledPeriods[0].seekToUs(paramLong);
    int i = 1;
    while (i < this.enabledPeriods.length)
    {
      if (this.enabledPeriods[i].seekToUs(paramLong) != paramLong) {
        throw new IllegalStateException("Children seeked to different positions");
      }
      i += 1;
    }
    return paramLong;
  }
  
  public long selectTracks(TrackSelection[] paramArrayOfTrackSelection, boolean[] paramArrayOfBoolean1, SampleStream[] paramArrayOfSampleStream, boolean[] paramArrayOfBoolean2, long paramLong)
  {
    int[] arrayOfInt1 = new int[paramArrayOfTrackSelection.length];
    int[] arrayOfInt2 = new int[paramArrayOfTrackSelection.length];
    int i = 0;
    int j;
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
        if (j < this.periods.length)
        {
          if (this.periods[j].getTrackGroups().indexOf((TrackGroup)localObject) != -1) {
            arrayOfInt2[i] = j;
          }
        }
        else
        {
          i += 1;
          break;
          j = ((Integer)this.streamPeriodIndices.get(paramArrayOfSampleStream[i])).intValue();
          break label32;
        }
        j += 1;
      }
    }
    this.streamPeriodIndices.clear();
    SampleStream[] arrayOfSampleStream1 = new SampleStream[paramArrayOfTrackSelection.length];
    SampleStream[] arrayOfSampleStream2 = new SampleStream[paramArrayOfTrackSelection.length];
    TrackSelection[] arrayOfTrackSelection = new TrackSelection[paramArrayOfTrackSelection.length];
    ArrayList localArrayList = new ArrayList(this.periods.length);
    i = 0;
    while (i < this.periods.length)
    {
      j = 0;
      if (j < paramArrayOfTrackSelection.length)
      {
        if (arrayOfInt1[j] == i)
        {
          localObject = paramArrayOfSampleStream[j];
          label225:
          arrayOfSampleStream2[j] = localObject;
          if (arrayOfInt2[j] != i) {
            break label270;
          }
        }
        label270:
        for (localObject = paramArrayOfTrackSelection[j];; localObject = null)
        {
          arrayOfTrackSelection[j] = localObject;
          j += 1;
          break;
          localObject = null;
          break label225;
        }
      }
      long l2 = this.periods[i].selectTracks(arrayOfTrackSelection, paramArrayOfBoolean1, arrayOfSampleStream2, paramArrayOfBoolean2, paramLong);
      long l1;
      int k;
      label314:
      label342:
      int m;
      if (i == 0)
      {
        l1 = l2;
        k = 0;
        j = 0;
        if (j >= paramArrayOfTrackSelection.length) {
          break label462;
        }
        if (arrayOfInt2[j] != i) {
          break label419;
        }
        if (arrayOfSampleStream2[j] == null) {
          break label413;
        }
        bool = true;
        Assertions.checkState(bool);
        arrayOfSampleStream1[j] = arrayOfSampleStream2[j];
        m = 1;
        this.streamPeriodIndices.put(arrayOfSampleStream2[j], Integer.valueOf(i));
      }
      label413:
      label419:
      do
      {
        j += 1;
        k = m;
        break label314;
        l1 = paramLong;
        if (l2 == paramLong) {
          break;
        }
        throw new IllegalStateException("Children enabled at different positions");
        bool = false;
        break label342;
        m = k;
      } while (arrayOfInt1[j] != i);
      if (arrayOfSampleStream2[j] == null) {}
      for (boolean bool = true;; bool = false)
      {
        Assertions.checkState(bool);
        m = k;
        break;
      }
      label462:
      if (k != 0) {
        localArrayList.add(this.periods[i]);
      }
      i += 1;
      paramLong = l1;
    }
    System.arraycopy(arrayOfSampleStream1, 0, paramArrayOfSampleStream, 0, arrayOfSampleStream1.length);
    this.enabledPeriods = new MediaPeriod[localArrayList.size()];
    localArrayList.toArray(this.enabledPeriods);
    this.compositeSequenceableLoader = this.compositeSequenceableLoaderFactory.createCompositeSequenceableLoader(this.enabledPeriods);
    return paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.source.MergingMediaPeriod
 * JD-Core Version:    0.7.0.1
 */