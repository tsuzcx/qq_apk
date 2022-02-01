package com.google.android.exoplayer2.source.ads;

import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.Timeline.Period;
import com.google.android.exoplayer2.Timeline.Window;
import com.google.android.exoplayer2.source.ForwardingTimeline;
import com.google.android.exoplayer2.util.Assertions;

final class SinglePeriodAdTimeline
  extends ForwardingTimeline
{
  private final AdPlaybackState adPlaybackState;
  
  public SinglePeriodAdTimeline(Timeline paramTimeline, AdPlaybackState paramAdPlaybackState)
  {
    super(paramTimeline);
    int i = paramTimeline.getPeriodCount();
    boolean bool2 = false;
    if (i == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    Assertions.checkState(bool1);
    boolean bool1 = bool2;
    if (paramTimeline.getWindowCount() == 1) {
      bool1 = true;
    }
    Assertions.checkState(bool1);
    this.adPlaybackState = paramAdPlaybackState;
  }
  
  public Timeline.Period getPeriod(int paramInt, Timeline.Period paramPeriod, boolean paramBoolean)
  {
    this.timeline.getPeriod(paramInt, paramPeriod, paramBoolean);
    paramPeriod.set(paramPeriod.id, paramPeriod.uid, paramPeriod.windowIndex, paramPeriod.durationUs, paramPeriod.getPositionInWindowUs(), this.adPlaybackState);
    return paramPeriod;
  }
  
  public Timeline.Window getWindow(int paramInt, Timeline.Window paramWindow, boolean paramBoolean, long paramLong)
  {
    paramWindow = super.getWindow(paramInt, paramWindow, paramBoolean, paramLong);
    if (paramWindow.durationUs == -9223372036854775807L) {
      paramWindow.durationUs = this.adPlaybackState.contentDurationUs;
    }
    return paramWindow;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.source.ads.SinglePeriodAdTimeline
 * JD-Core Version:    0.7.0.1
 */