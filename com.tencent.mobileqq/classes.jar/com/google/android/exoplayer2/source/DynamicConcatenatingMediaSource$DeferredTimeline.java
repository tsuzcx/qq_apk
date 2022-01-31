package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.Timeline.Period;
import com.google.android.exoplayer2.util.Util;

final class DynamicConcatenatingMediaSource$DeferredTimeline
  extends ForwardingTimeline
{
  private static final Object DUMMY_ID = new Object();
  private static final DynamicConcatenatingMediaSource.DummyTimeline dummyTimeline = new DynamicConcatenatingMediaSource.DummyTimeline(null);
  private static final Timeline.Period period = new Timeline.Period();
  private final Object replacedId;
  
  public DynamicConcatenatingMediaSource$DeferredTimeline()
  {
    this(dummyTimeline, null);
  }
  
  private DynamicConcatenatingMediaSource$DeferredTimeline(Timeline paramTimeline, Object paramObject)
  {
    super(paramTimeline);
    this.replacedId = paramObject;
  }
  
  public DeferredTimeline cloneWithNewTimeline(Timeline paramTimeline)
  {
    if ((this.replacedId == null) && (paramTimeline.getPeriodCount() > 0)) {}
    for (Object localObject = paramTimeline.getPeriod(0, period, true).uid;; localObject = this.replacedId) {
      return new DeferredTimeline(paramTimeline, localObject);
    }
  }
  
  public int getIndexOfPeriod(Object paramObject)
  {
    Timeline localTimeline = this.timeline;
    Object localObject = paramObject;
    if (DUMMY_ID.equals(paramObject)) {
      localObject = this.replacedId;
    }
    return localTimeline.getIndexOfPeriod(localObject);
  }
  
  public Timeline.Period getPeriod(int paramInt, Timeline.Period paramPeriod, boolean paramBoolean)
  {
    this.timeline.getPeriod(paramInt, paramPeriod, paramBoolean);
    if (Util.areEqual(paramPeriod.uid, this.replacedId)) {
      paramPeriod.uid = DUMMY_ID;
    }
    return paramPeriod;
  }
  
  public Timeline getTimeline()
  {
    return this.timeline;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.source.DynamicConcatenatingMediaSource.DeferredTimeline
 * JD-Core Version:    0.7.0.1
 */