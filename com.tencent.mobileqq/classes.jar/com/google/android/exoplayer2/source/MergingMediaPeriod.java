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
    paramCallback = this.periods;
    this.pendingChildPrepareCount = paramCallback.length;
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
    MediaPeriod[] arrayOfMediaPeriod;
    for (;;)
    {
      arrayOfMediaPeriod = this.periods;
      if (i >= arrayOfMediaPeriod.length) {
        break label60;
      }
      if (arrayOfMediaPeriod[i].readDiscontinuity() != -9223372036854775807L) {
        break;
      }
      i += 1;
    }
    throw new IllegalStateException("Child reported discontinuity");
    label60:
    if (l != -9223372036854775807L)
    {
      arrayOfMediaPeriod = this.enabledPeriods;
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
    for (;;)
    {
      MediaPeriod[] arrayOfMediaPeriod = this.enabledPeriods;
      if (i >= arrayOfMediaPeriod.length) {
        return paramLong;
      }
      if (arrayOfMediaPeriod[i].seekToUs(paramLong) != paramLong) {
        break;
      }
      i += 1;
    }
    throw new IllegalStateException("Children seeked to different positions");
    return paramLong;
  }
  
  public long selectTracks(TrackSelection[] paramArrayOfTrackSelection, boolean[] paramArrayOfBoolean1, SampleStream[] paramArrayOfSampleStream, boolean[] paramArrayOfBoolean2, long paramLong)
  {
    int[] arrayOfInt1 = new int[paramArrayOfTrackSelection.length];
    int[] arrayOfInt2 = new int[paramArrayOfTrackSelection.length];
    int i = 0;
    int j;
    while (i < paramArrayOfTrackSelection.length)
    {
      if (paramArrayOfSampleStream[i] == null) {
        j = -1;
      } else {
        j = ((Integer)this.streamPeriodIndices.get(paramArrayOfSampleStream[i])).intValue();
      }
      arrayOfInt1[i] = j;
      arrayOfInt2[i] = -1;
      if (paramArrayOfTrackSelection[i] != null)
      {
        localObject1 = paramArrayOfTrackSelection[i].getTrackGroup();
        j = 0;
        for (;;)
        {
          localObject2 = this.periods;
          if (j >= localObject2.length) {
            break;
          }
          if (localObject2[j].getTrackGroups().indexOf((TrackGroup)localObject1) != -1)
          {
            arrayOfInt2[i] = j;
            break;
          }
          j += 1;
        }
      }
      i += 1;
    }
    this.streamPeriodIndices.clear();
    SampleStream[] arrayOfSampleStream1 = new SampleStream[paramArrayOfTrackSelection.length];
    SampleStream[] arrayOfSampleStream2 = new SampleStream[paramArrayOfTrackSelection.length];
    Object localObject1 = new TrackSelection[paramArrayOfTrackSelection.length];
    Object localObject2 = new ArrayList(this.periods.length);
    i = 0;
    while (i < this.periods.length)
    {
      j = 0;
      while (j < paramArrayOfTrackSelection.length)
      {
        k = arrayOfInt1[j];
        Object localObject4 = null;
        if (k == i) {
          localObject3 = paramArrayOfSampleStream[j];
        } else {
          localObject3 = null;
        }
        arrayOfSampleStream2[j] = localObject3;
        Object localObject3 = localObject4;
        if (arrayOfInt2[j] == i) {
          localObject3 = paramArrayOfTrackSelection[j];
        }
        localObject1[j] = localObject3;
        j += 1;
      }
      long l = this.periods[i].selectTracks((TrackSelection[])localObject1, paramArrayOfBoolean1, arrayOfSampleStream2, paramArrayOfBoolean2, paramLong);
      if (i == 0) {
        paramLong = l;
      } else {
        if (l != paramLong) {
          break label492;
        }
      }
      j = 0;
      int m;
      for (int k = 0; j < paramArrayOfTrackSelection.length; k = m)
      {
        m = arrayOfInt2[j];
        boolean bool = true;
        if (m == i)
        {
          if (arrayOfSampleStream2[j] != null) {
            bool = true;
          } else {
            bool = false;
          }
          Assertions.checkState(bool);
          arrayOfSampleStream1[j] = arrayOfSampleStream2[j];
          this.streamPeriodIndices.put(arrayOfSampleStream2[j], Integer.valueOf(i));
          m = 1;
        }
        else
        {
          m = k;
          if (arrayOfInt1[j] == i)
          {
            if (arrayOfSampleStream2[j] != null) {
              bool = false;
            }
            Assertions.checkState(bool);
            m = k;
          }
        }
        j += 1;
      }
      if (k != 0) {
        ((ArrayList)localObject2).add(this.periods[i]);
      }
      i += 1;
      continue;
      label492:
      throw new IllegalStateException("Children enabled at different positions");
    }
    System.arraycopy(arrayOfSampleStream1, 0, paramArrayOfSampleStream, 0, arrayOfSampleStream1.length);
    this.enabledPeriods = new MediaPeriod[((ArrayList)localObject2).size()];
    ((ArrayList)localObject2).toArray(this.enabledPeriods);
    this.compositeSequenceableLoader = this.compositeSequenceableLoaderFactory.createCompositeSequenceableLoader(this.enabledPeriods);
    return paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.source.MergingMediaPeriod
 * JD-Core Version:    0.7.0.1
 */