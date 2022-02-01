package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.Timeline.Period;
import com.google.android.exoplayer2.Timeline.Window;

final class ClippingMediaSource$ClippingTimeline
  extends ForwardingTimeline
{
  private final long endUs;
  private final long startUs;
  
  public ClippingMediaSource$ClippingTimeline(Timeline paramTimeline, long paramLong1, long paramLong2)
  {
    super(paramTimeline);
    if (paramTimeline.getPeriodCount() == 1)
    {
      if (paramTimeline.getPeriod(0, new Timeline.Period()).getPositionInWindowUs() == 0L)
      {
        paramTimeline = paramTimeline.getWindow(0, new Timeline.Window(), false);
        long l = paramLong2;
        if (paramLong2 == -9223372036854775808L) {
          l = paramTimeline.durationUs;
        }
        paramLong2 = l;
        if (paramTimeline.durationUs != -9223372036854775807L)
        {
          paramLong2 = l;
          if (l > paramTimeline.durationUs) {
            paramLong2 = paramTimeline.durationUs;
          }
          if ((paramLong1 != 0L) && (!paramTimeline.isSeekable)) {
            throw new ClippingMediaSource.IllegalClippingException(2);
          }
          if (paramLong1 > paramLong2) {
            throw new ClippingMediaSource.IllegalClippingException(3);
          }
        }
        this.startUs = paramLong1;
        this.endUs = paramLong2;
        return;
      }
      throw new ClippingMediaSource.IllegalClippingException(1);
    }
    throw new ClippingMediaSource.IllegalClippingException(0);
  }
  
  public Timeline.Period getPeriod(int paramInt, Timeline.Period paramPeriod, boolean paramBoolean)
  {
    paramPeriod = this.timeline.getPeriod(0, paramPeriod, paramBoolean);
    long l2 = this.endUs;
    long l1 = -9223372036854775807L;
    if (l2 != -9223372036854775807L) {
      l1 = l2 - this.startUs;
    }
    paramPeriod.durationUs = l1;
    return paramPeriod;
  }
  
  public Timeline.Window getWindow(int paramInt, Timeline.Window paramWindow, boolean paramBoolean, long paramLong)
  {
    paramWindow = this.timeline.getWindow(0, paramWindow, paramBoolean, paramLong);
    paramLong = this.endUs;
    if (paramLong != -9223372036854775807L) {
      paramLong -= this.startUs;
    } else {
      paramLong = -9223372036854775807L;
    }
    paramWindow.durationUs = paramLong;
    if (paramWindow.defaultPositionUs != -9223372036854775807L)
    {
      paramWindow.defaultPositionUs = Math.max(paramWindow.defaultPositionUs, this.startUs);
      if (this.endUs == -9223372036854775807L) {
        paramLong = paramWindow.defaultPositionUs;
      } else {
        paramLong = Math.min(paramWindow.defaultPositionUs, this.endUs);
      }
      paramWindow.defaultPositionUs = paramLong;
      paramWindow.defaultPositionUs -= this.startUs;
    }
    paramLong = C.usToMs(this.startUs);
    if (paramWindow.presentationStartTimeMs != -9223372036854775807L) {
      paramWindow.presentationStartTimeMs += paramLong;
    }
    if (paramWindow.windowStartTimeMs != -9223372036854775807L) {
      paramWindow.windowStartTimeMs += paramLong;
    }
    return paramWindow;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.source.ClippingMediaSource.ClippingTimeline
 * JD-Core Version:    0.7.0.1
 */