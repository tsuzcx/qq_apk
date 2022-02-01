package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;

public final class ClippingMediaPeriod
  implements MediaPeriod, MediaPeriod.Callback
{
  private MediaPeriod.Callback callback;
  long endUs;
  public final MediaPeriod mediaPeriod;
  private long pendingInitialDiscontinuityPositionUs;
  private ClippingMediaPeriod.ClippingSampleStream[] sampleStreams;
  long startUs;
  
  public ClippingMediaPeriod(MediaPeriod paramMediaPeriod, boolean paramBoolean)
  {
    this.mediaPeriod = paramMediaPeriod;
    this.sampleStreams = new ClippingMediaPeriod.ClippingSampleStream[0];
    long l;
    if (paramBoolean) {
      l = 0L;
    } else {
      l = -9223372036854775807L;
    }
    this.pendingInitialDiscontinuityPositionUs = l;
    this.startUs = -9223372036854775807L;
    this.endUs = -9223372036854775807L;
  }
  
  private SeekParameters clipSeekParameters(long paramLong, SeekParameters paramSeekParameters)
  {
    long l1 = Math.min(paramLong - this.startUs, paramSeekParameters.toleranceBeforeUs);
    long l2 = this.endUs;
    if (l2 == -9223372036854775808L) {
      paramLong = paramSeekParameters.toleranceAfterUs;
    } else {
      paramLong = Math.min(l2 - paramLong, paramSeekParameters.toleranceAfterUs);
    }
    if ((l1 == paramSeekParameters.toleranceBeforeUs) && (paramLong == paramSeekParameters.toleranceAfterUs)) {
      return paramSeekParameters;
    }
    return new SeekParameters(l1, paramLong);
  }
  
  private static boolean shouldKeepInitialDiscontinuity(long paramLong, TrackSelection[] paramArrayOfTrackSelection)
  {
    if (paramLong != 0L)
    {
      int j = paramArrayOfTrackSelection.length;
      int i = 0;
      while (i < j)
      {
        TrackSelection localTrackSelection = paramArrayOfTrackSelection[i];
        if ((localTrackSelection != null) && (!MimeTypes.isAudio(localTrackSelection.getSelectedFormat().sampleMimeType))) {
          return true;
        }
        i += 1;
      }
    }
    return false;
  }
  
  public boolean continueLoading(long paramLong)
  {
    return this.mediaPeriod.continueLoading(paramLong + this.startUs);
  }
  
  public void discardBuffer(long paramLong, boolean paramBoolean)
  {
    this.mediaPeriod.discardBuffer(paramLong + this.startUs, paramBoolean);
  }
  
  public long getAdjustedSeekPositionUs(long paramLong, SeekParameters paramSeekParameters)
  {
    long l = this.startUs;
    if (paramLong == l) {
      return 0L;
    }
    paramLong += l;
    paramSeekParameters = clipSeekParameters(paramLong, paramSeekParameters);
    return this.mediaPeriod.getAdjustedSeekPositionUs(paramLong, paramSeekParameters) - this.startUs;
  }
  
  public long getBufferedPositionUs()
  {
    long l1 = this.mediaPeriod.getBufferedPositionUs();
    if (l1 != -9223372036854775808L)
    {
      long l2 = this.endUs;
      if ((l2 != -9223372036854775808L) && (l1 >= l2)) {
        return -9223372036854775808L;
      }
      return Math.max(0L, l1 - this.startUs);
    }
    return -9223372036854775808L;
  }
  
  public long getNextLoadPositionUs()
  {
    long l1 = this.mediaPeriod.getNextLoadPositionUs();
    if (l1 != -9223372036854775808L)
    {
      long l2 = this.endUs;
      if ((l2 != -9223372036854775808L) && (l1 >= l2)) {
        return -9223372036854775808L;
      }
      return l1 - this.startUs;
    }
    return -9223372036854775808L;
  }
  
  public TrackGroupArray getTrackGroups()
  {
    return this.mediaPeriod.getTrackGroups();
  }
  
  boolean isPendingInitialDiscontinuity()
  {
    return this.pendingInitialDiscontinuityPositionUs != -9223372036854775807L;
  }
  
  public void maybeThrowPrepareError()
  {
    this.mediaPeriod.maybeThrowPrepareError();
  }
  
  public void onContinueLoadingRequested(MediaPeriod paramMediaPeriod)
  {
    this.callback.onContinueLoadingRequested(this);
  }
  
  public void onPrepared(MediaPeriod paramMediaPeriod)
  {
    boolean bool;
    if ((this.startUs != -9223372036854775807L) && (this.endUs != -9223372036854775807L)) {
      bool = true;
    } else {
      bool = false;
    }
    Assertions.checkState(bool);
    this.callback.onPrepared(this);
  }
  
  public void prepare(MediaPeriod.Callback paramCallback, long paramLong)
  {
    this.callback = paramCallback;
    this.mediaPeriod.prepare(this, this.startUs + paramLong);
  }
  
  public long readDiscontinuity()
  {
    if (isPendingInitialDiscontinuity())
    {
      l1 = this.pendingInitialDiscontinuityPositionUs;
      this.pendingInitialDiscontinuityPositionUs = -9223372036854775807L;
      l2 = readDiscontinuity();
      if (l2 != -9223372036854775807L) {
        l1 = l2;
      }
      return l1;
    }
    long l1 = this.mediaPeriod.readDiscontinuity();
    if (l1 == -9223372036854775807L) {
      return -9223372036854775807L;
    }
    long l2 = this.startUs;
    boolean bool2 = true;
    if (l1 >= l2) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    Assertions.checkState(bool1);
    l2 = this.endUs;
    boolean bool1 = bool2;
    if (l2 != -9223372036854775808L) {
      if (l1 <= l2) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
    }
    Assertions.checkState(bool1);
    return l1 - this.startUs;
  }
  
  public void reevaluateBuffer(long paramLong)
  {
    this.mediaPeriod.reevaluateBuffer(paramLong + this.startUs);
  }
  
  public long seekToUs(long paramLong)
  {
    this.pendingInitialDiscontinuityPositionUs = -9223372036854775807L;
    ClippingMediaPeriod.ClippingSampleStream[] arrayOfClippingSampleStream = this.sampleStreams;
    int j = arrayOfClippingSampleStream.length;
    boolean bool2 = false;
    int i = 0;
    while (i < j)
    {
      ClippingMediaPeriod.ClippingSampleStream localClippingSampleStream = arrayOfClippingSampleStream[i];
      if (localClippingSampleStream != null) {
        localClippingSampleStream.clearSentEos();
      }
      i += 1;
    }
    long l = paramLong + this.startUs;
    paramLong = this.mediaPeriod.seekToUs(l);
    if (paramLong != l)
    {
      bool1 = bool2;
      if (paramLong < this.startUs) {
        break label121;
      }
      l = this.endUs;
      if (l != -9223372036854775808L)
      {
        bool1 = bool2;
        if (paramLong > l) {
          break label121;
        }
      }
    }
    boolean bool1 = true;
    label121:
    Assertions.checkState(bool1);
    return paramLong - this.startUs;
  }
  
  public long selectTracks(TrackSelection[] paramArrayOfTrackSelection, boolean[] paramArrayOfBoolean1, SampleStream[] paramArrayOfSampleStream, boolean[] paramArrayOfBoolean2, long paramLong)
  {
    this.sampleStreams = new ClippingMediaPeriod.ClippingSampleStream[paramArrayOfSampleStream.length];
    SampleStream[] arrayOfSampleStream = new SampleStream[paramArrayOfSampleStream.length];
    int j = 0;
    int i = 0;
    for (;;)
    {
      int k = paramArrayOfSampleStream.length;
      SampleStream localSampleStream = null;
      if (i >= k) {
        break;
      }
      ClippingMediaPeriod.ClippingSampleStream[] arrayOfClippingSampleStream = this.sampleStreams;
      arrayOfClippingSampleStream[i] = ((ClippingMediaPeriod.ClippingSampleStream)paramArrayOfSampleStream[i]);
      if (arrayOfClippingSampleStream[i] != null) {
        localSampleStream = arrayOfClippingSampleStream[i].childStream;
      }
      arrayOfSampleStream[i] = localSampleStream;
      i += 1;
    }
    long l2 = this.mediaPeriod.selectTracks(paramArrayOfTrackSelection, paramArrayOfBoolean1, arrayOfSampleStream, paramArrayOfBoolean2, paramLong + this.startUs) - this.startUs;
    long l1;
    if ((isPendingInitialDiscontinuity()) && (paramLong == 0L) && (shouldKeepInitialDiscontinuity(this.startUs, paramArrayOfTrackSelection))) {
      l1 = l2;
    } else {
      l1 = -9223372036854775807L;
    }
    this.pendingInitialDiscontinuityPositionUs = l1;
    if (l2 != paramLong) {
      if (l2 >= 0L)
      {
        paramLong = this.endUs;
        if ((paramLong == -9223372036854775808L) || (this.startUs + l2 <= paramLong)) {}
      }
      else
      {
        bool = false;
        break label215;
      }
    }
    boolean bool = true;
    label215:
    Assertions.checkState(bool);
    i = j;
    while (i < paramArrayOfSampleStream.length)
    {
      if (arrayOfSampleStream[i] == null) {
        this.sampleStreams[i] = null;
      } else if ((paramArrayOfSampleStream[i] == null) || (this.sampleStreams[i].childStream != arrayOfSampleStream[i])) {
        this.sampleStreams[i] = new ClippingMediaPeriod.ClippingSampleStream(this, arrayOfSampleStream[i]);
      }
      paramArrayOfSampleStream[i] = this.sampleStreams[i];
      i += 1;
    }
    return l2;
  }
  
  public void setClipping(long paramLong1, long paramLong2)
  {
    this.startUs = paramLong1;
    this.endUs = paramLong2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.source.ClippingMediaPeriod
 * JD-Core Version:    0.7.0.1
 */