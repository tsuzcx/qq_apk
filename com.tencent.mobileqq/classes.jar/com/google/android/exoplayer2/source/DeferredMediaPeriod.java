package com.google.android.exoplayer2.source;

import android.support.annotation.Nullable;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.upstream.Allocator;
import java.io.IOException;

public final class DeferredMediaPeriod
  implements MediaPeriod, MediaPeriod.Callback
{
  private final Allocator allocator;
  private MediaPeriod.Callback callback;
  private final MediaSource.MediaPeriodId id;
  @Nullable
  private DeferredMediaPeriod.PrepareErrorListener listener;
  private MediaPeriod mediaPeriod;
  public final MediaSource mediaSource;
  private boolean notifiedPrepareError;
  private long preparePositionUs;
  
  public DeferredMediaPeriod(MediaSource paramMediaSource, MediaSource.MediaPeriodId paramMediaPeriodId, Allocator paramAllocator)
  {
    this.id = paramMediaPeriodId;
    this.allocator = paramAllocator;
    this.mediaSource = paramMediaSource;
  }
  
  public boolean continueLoading(long paramLong)
  {
    return (this.mediaPeriod != null) && (this.mediaPeriod.continueLoading(paramLong));
  }
  
  public void createPeriod()
  {
    this.mediaPeriod = this.mediaSource.createPeriod(this.id, this.allocator);
    if (this.callback != null) {
      this.mediaPeriod.prepare(this, this.preparePositionUs);
    }
  }
  
  public void discardBuffer(long paramLong, boolean paramBoolean)
  {
    this.mediaPeriod.discardBuffer(paramLong, paramBoolean);
  }
  
  public long getAdjustedSeekPositionUs(long paramLong, SeekParameters paramSeekParameters)
  {
    return this.mediaPeriod.getAdjustedSeekPositionUs(paramLong, paramSeekParameters);
  }
  
  public long getBufferedPositionUs()
  {
    return this.mediaPeriod.getBufferedPositionUs();
  }
  
  public long getNextLoadPositionUs()
  {
    return this.mediaPeriod.getNextLoadPositionUs();
  }
  
  public TrackGroupArray getTrackGroups()
  {
    return this.mediaPeriod.getTrackGroups();
  }
  
  public void maybeThrowPrepareError()
  {
    try
    {
      if (this.mediaPeriod != null)
      {
        this.mediaPeriod.maybeThrowPrepareError();
        return;
      }
      this.mediaSource.maybeThrowSourceInfoRefreshError();
      return;
    }
    catch (IOException localIOException)
    {
      if (this.listener == null) {
        throw localIOException;
      }
      if (!this.notifiedPrepareError)
      {
        this.notifiedPrepareError = true;
        this.listener.onPrepareError(localIOException);
      }
    }
  }
  
  public void onContinueLoadingRequested(MediaPeriod paramMediaPeriod)
  {
    this.callback.onContinueLoadingRequested(this);
  }
  
  public void onPrepared(MediaPeriod paramMediaPeriod)
  {
    this.callback.onPrepared(this);
  }
  
  public void prepare(MediaPeriod.Callback paramCallback, long paramLong)
  {
    this.callback = paramCallback;
    this.preparePositionUs = paramLong;
    if (this.mediaPeriod != null) {
      this.mediaPeriod.prepare(this, paramLong);
    }
  }
  
  public long readDiscontinuity()
  {
    return this.mediaPeriod.readDiscontinuity();
  }
  
  public void reevaluateBuffer(long paramLong)
  {
    this.mediaPeriod.reevaluateBuffer(paramLong);
  }
  
  public void releasePeriod()
  {
    if (this.mediaPeriod != null) {
      this.mediaSource.releasePeriod(this.mediaPeriod);
    }
  }
  
  public long seekToUs(long paramLong)
  {
    return this.mediaPeriod.seekToUs(paramLong);
  }
  
  public long selectTracks(TrackSelection[] paramArrayOfTrackSelection, boolean[] paramArrayOfBoolean1, SampleStream[] paramArrayOfSampleStream, boolean[] paramArrayOfBoolean2, long paramLong)
  {
    return this.mediaPeriod.selectTracks(paramArrayOfTrackSelection, paramArrayOfBoolean1, paramArrayOfSampleStream, paramArrayOfBoolean2, paramLong);
  }
  
  public void setPrepareErrorListener(DeferredMediaPeriod.PrepareErrorListener paramPrepareErrorListener)
  {
    this.listener = paramPrepareErrorListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.source.DeferredMediaPeriod
 * JD-Core Version:    0.7.0.1
 */