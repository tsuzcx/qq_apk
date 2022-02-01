package com.google.android.exoplayer2.source;

import android.support.annotation.Nullable;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.util.Assertions;
import java.util.ArrayList;

public final class ClippingMediaSource
  extends CompositeMediaSource<Void>
{
  private ClippingMediaSource.IllegalClippingException clippingError;
  private final boolean enableInitialDiscontinuity;
  private final long endUs;
  private final ArrayList<ClippingMediaPeriod> mediaPeriods;
  private final MediaSource mediaSource;
  private MediaSource.Listener sourceListener;
  private final long startUs;
  
  public ClippingMediaSource(MediaSource paramMediaSource, long paramLong1, long paramLong2)
  {
    this(paramMediaSource, paramLong1, paramLong2, true);
  }
  
  public ClippingMediaSource(MediaSource paramMediaSource, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    if (paramLong1 >= 0L) {}
    for (boolean bool = true;; bool = false)
    {
      Assertions.checkArgument(bool);
      this.mediaSource = ((MediaSource)Assertions.checkNotNull(paramMediaSource));
      this.startUs = paramLong1;
      this.endUs = paramLong2;
      this.enableInitialDiscontinuity = paramBoolean;
      this.mediaPeriods = new ArrayList();
      return;
    }
  }
  
  public MediaPeriod createPeriod(MediaSource.MediaPeriodId paramMediaPeriodId, Allocator paramAllocator)
  {
    paramMediaPeriodId = new ClippingMediaPeriod(this.mediaSource.createPeriod(paramMediaPeriodId, paramAllocator), this.enableInitialDiscontinuity);
    this.mediaPeriods.add(paramMediaPeriodId);
    paramMediaPeriodId.setClipping(this.startUs, this.endUs);
    return paramMediaPeriodId;
  }
  
  public void maybeThrowSourceInfoRefreshError()
  {
    if (this.clippingError != null) {
      throw this.clippingError;
    }
    super.maybeThrowSourceInfoRefreshError();
  }
  
  protected void onChildSourceInfoRefreshed(Void paramVoid, MediaSource paramMediaSource, Timeline paramTimeline, @Nullable Object paramObject)
  {
    if (this.clippingError != null) {}
    for (;;)
    {
      return;
      try
      {
        paramVoid = new ClippingMediaSource.ClippingTimeline(paramTimeline, this.startUs, this.endUs);
        this.sourceListener.onSourceInfoRefreshed(this, paramVoid, paramObject);
        int j = this.mediaPeriods.size();
        int i = 0;
        while (i < j)
        {
          ((ClippingMediaPeriod)this.mediaPeriods.get(i)).setClipping(this.startUs, this.endUs);
          i += 1;
        }
        return;
      }
      catch (ClippingMediaSource.IllegalClippingException paramVoid)
      {
        this.clippingError = paramVoid;
      }
    }
  }
  
  public void prepareSource(ExoPlayer paramExoPlayer, boolean paramBoolean, MediaSource.Listener paramListener)
  {
    super.prepareSource(paramExoPlayer, paramBoolean, paramListener);
    this.sourceListener = paramListener;
    prepareChildSource(null, this.mediaSource);
  }
  
  public void releasePeriod(MediaPeriod paramMediaPeriod)
  {
    Assertions.checkState(this.mediaPeriods.remove(paramMediaPeriod));
    this.mediaSource.releasePeriod(((ClippingMediaPeriod)paramMediaPeriod).mediaPeriod);
  }
  
  public void releaseSource()
  {
    super.releaseSource();
    this.clippingError = null;
    this.sourceListener = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.source.ClippingMediaSource
 * JD-Core Version:    0.7.0.1
 */