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
    if (paramTimeline.getPeriodCount() != 1) {
      throw new ClippingMediaSource.IllegalClippingException(0);
    }
    if (paramTimeline.getPeriod(0, new Timeline.Period()).getPositionInWindowUs() != 0L) {
      throw new ClippingMediaSource.IllegalClippingException(1);
    }
    paramTimeline = paramTimeline.getWindow(0, new Timeline.Window(), false);
    long l1 = paramLong2;
    if (paramLong2 == -9223372036854775808L) {
      l1 = paramTimeline.durationUs;
    }
    long l2 = l1;
    if (paramTimeline.durationUs != -9223372036854775807L)
    {
      paramLong2 = l1;
      if (l1 > paramTimeline.durationUs) {
        paramLong2 = paramTimeline.durationUs;
      }
      if ((paramLong1 != 0L) && (!paramTimeline.isSeekable)) {
        throw new ClippingMediaSource.IllegalClippingException(2);
      }
      l2 = paramLong2;
      if (paramLong1 > paramLong2) {
        throw new ClippingMediaSource.IllegalClippingException(3);
      }
    }
    this.startUs = paramLong1;
    this.endUs = l2;
  }
  
  public Timeline.Period getPeriod(int paramInt, Timeline.Period paramPeriod, boolean paramBoolean)
  {
    long l = -9223372036854775807L;
    paramPeriod = this.timeline.getPeriod(0, paramPeriod, paramBoolean);
    if (this.endUs != -9223372036854775807L) {
      l = this.endUs - this.startUs;
    }
    paramPeriod.durationUs = l;
    return paramPeriod;
  }
  
  public Timeline.Window getWindow(int paramInt, Timeline.Window paramWindow, boolean paramBoolean, long paramLong)
  {
    paramWindow = this.timeline.getWindow(0, paramWindow, paramBoolean, paramLong);
    if (this.endUs != -9223372036854775807L)
    {
      paramLong = this.endUs - this.startUs;
      paramWindow.durationUs = paramLong;
      if (paramWindow.defaultPositionUs != -9223372036854775807L)
      {
        paramWindow.defaultPositionUs = Math.max(paramWindow.defaultPositionUs, this.startUs);
        if (this.endUs != -9223372036854775807L) {
          break label166;
        }
      }
    }
    label166:
    for (paramLong = paramWindow.defaultPositionUs;; paramLong = Math.min(paramWindow.defaultPositionUs, this.endUs))
    {
      paramWindow.defaultPositionUs = paramLong;
      paramWindow.defaultPositionUs -= this.startUs;
      paramLong = C.usToMs(this.startUs);
      if (paramWindow.presentationStartTimeMs != -9223372036854775807L) {
        paramWindow.presentationStartTimeMs += paramLong;
      }
      if (paramWindow.windowStartTimeMs != -9223372036854775807L) {
        paramWindow.windowStartTimeMs = (paramLong + paramWindow.windowStartTimeMs);
      }
      return paramWindow;
      paramLong = -9223372036854775807L;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.source.ClippingMediaSource.ClippingTimeline
 * JD-Core Version:    0.7.0.1
 */