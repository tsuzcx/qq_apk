package com.google.android.exoplayer2.source;

import android.support.annotation.Nullable;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.util.Assertions;

public final class LoopingMediaSource
  extends CompositeMediaSource<Void>
{
  private int childPeriodCount;
  private final MediaSource childSource;
  private MediaSource.Listener listener;
  private final int loopCount;
  
  public LoopingMediaSource(MediaSource paramMediaSource)
  {
    this(paramMediaSource, 2147483647);
  }
  
  public LoopingMediaSource(MediaSource paramMediaSource, int paramInt)
  {
    if (paramInt > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Assertions.checkArgument(bool);
      this.childSource = paramMediaSource;
      this.loopCount = paramInt;
      return;
    }
  }
  
  public MediaPeriod createPeriod(MediaSource.MediaPeriodId paramMediaPeriodId, Allocator paramAllocator)
  {
    if (this.loopCount != 2147483647) {
      return this.childSource.createPeriod(paramMediaPeriodId.copyWithPeriodIndex(paramMediaPeriodId.periodIndex % this.childPeriodCount), paramAllocator);
    }
    return this.childSource.createPeriod(paramMediaPeriodId, paramAllocator);
  }
  
  protected void onChildSourceInfoRefreshed(Void paramVoid, MediaSource paramMediaSource, Timeline paramTimeline, @Nullable Object paramObject)
  {
    this.childPeriodCount = paramTimeline.getPeriodCount();
    if (this.loopCount != 2147483647) {}
    for (paramVoid = new LoopingMediaSource.LoopingTimeline(paramTimeline, this.loopCount);; paramVoid = new LoopingMediaSource.InfinitelyLoopingTimeline(paramTimeline))
    {
      this.listener.onSourceInfoRefreshed(this, paramVoid, paramObject);
      return;
    }
  }
  
  public void prepareSource(ExoPlayer paramExoPlayer, boolean paramBoolean, MediaSource.Listener paramListener)
  {
    super.prepareSource(paramExoPlayer, paramBoolean, paramListener);
    this.listener = paramListener;
    prepareChildSource(null, this.childSource);
  }
  
  public void releasePeriod(MediaPeriod paramMediaPeriod)
  {
    this.childSource.releasePeriod(paramMediaPeriod);
  }
  
  public void releaseSource()
  {
    super.releaseSource();
    this.listener = null;
    this.childPeriodCount = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.source.LoopingMediaSource
 * JD-Core Version:    0.7.0.1
 */