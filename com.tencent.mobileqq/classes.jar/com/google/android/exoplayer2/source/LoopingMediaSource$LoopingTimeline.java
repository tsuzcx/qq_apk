package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.util.Assertions;

final class LoopingMediaSource$LoopingTimeline
  extends AbstractConcatenatedTimeline
{
  private final int childPeriodCount;
  private final Timeline childTimeline;
  private final int childWindowCount;
  private final int loopCount;
  
  public LoopingMediaSource$LoopingTimeline(Timeline paramTimeline, int paramInt)
  {
    super(false, new ShuffleOrder.UnshuffledShuffleOrder(paramInt));
    this.childTimeline = paramTimeline;
    this.childPeriodCount = paramTimeline.getPeriodCount();
    this.childWindowCount = paramTimeline.getWindowCount();
    this.loopCount = paramInt;
    if (this.childPeriodCount > 0)
    {
      if (paramInt <= 2147483647 / this.childPeriodCount) {
        bool = true;
      }
      Assertions.checkState(bool, "LoopingMediaSource contains too many periods");
    }
  }
  
  protected int getChildIndexByChildUid(Object paramObject)
  {
    if (!(paramObject instanceof Integer)) {
      return -1;
    }
    return ((Integer)paramObject).intValue();
  }
  
  protected int getChildIndexByPeriodIndex(int paramInt)
  {
    return paramInt / this.childPeriodCount;
  }
  
  protected int getChildIndexByWindowIndex(int paramInt)
  {
    return paramInt / this.childWindowCount;
  }
  
  protected Object getChildUidByChildIndex(int paramInt)
  {
    return Integer.valueOf(paramInt);
  }
  
  protected int getFirstPeriodIndexByChildIndex(int paramInt)
  {
    return this.childPeriodCount * paramInt;
  }
  
  protected int getFirstWindowIndexByChildIndex(int paramInt)
  {
    return this.childWindowCount * paramInt;
  }
  
  public int getPeriodCount()
  {
    return this.childPeriodCount * this.loopCount;
  }
  
  protected Timeline getTimelineByChildIndex(int paramInt)
  {
    return this.childTimeline;
  }
  
  public int getWindowCount()
  {
    return this.childWindowCount * this.loopCount;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.source.LoopingMediaSource.LoopingTimeline
 * JD-Core Version:    0.7.0.1
 */