package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;

final class ConcatenatingMediaSource$ConcatenatedTimeline
  extends AbstractConcatenatedTimeline
{
  private final int[] sourcePeriodOffsets;
  private final int[] sourceWindowOffsets;
  private final Timeline[] timelines;
  
  public ConcatenatingMediaSource$ConcatenatedTimeline(Timeline[] paramArrayOfTimeline, boolean paramBoolean, ShuffleOrder paramShuffleOrder)
  {
    super(paramBoolean, paramShuffleOrder);
    paramShuffleOrder = new int[paramArrayOfTimeline.length];
    int[] arrayOfInt = new int[paramArrayOfTimeline.length];
    int i = 0;
    long l = 0L;
    int j = 0;
    if (i < paramArrayOfTimeline.length)
    {
      Timeline localTimeline = paramArrayOfTimeline[i];
      l += localTimeline.getPeriodCount();
      if (l <= 2147483647L) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        Assertions.checkState(paramBoolean, "ConcatenatingMediaSource children contain too many periods");
        paramShuffleOrder[i] = ((int)l);
        j += localTimeline.getWindowCount();
        arrayOfInt[i] = j;
        i += 1;
        break;
      }
    }
    this.timelines = paramArrayOfTimeline;
    this.sourcePeriodOffsets = paramShuffleOrder;
    this.sourceWindowOffsets = arrayOfInt;
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
    return Util.binarySearchFloor(this.sourcePeriodOffsets, paramInt + 1, false, false) + 1;
  }
  
  protected int getChildIndexByWindowIndex(int paramInt)
  {
    return Util.binarySearchFloor(this.sourceWindowOffsets, paramInt + 1, false, false) + 1;
  }
  
  protected Object getChildUidByChildIndex(int paramInt)
  {
    return Integer.valueOf(paramInt);
  }
  
  protected int getFirstPeriodIndexByChildIndex(int paramInt)
  {
    if (paramInt == 0) {
      return 0;
    }
    return this.sourcePeriodOffsets[(paramInt - 1)];
  }
  
  protected int getFirstWindowIndexByChildIndex(int paramInt)
  {
    if (paramInt == 0) {
      return 0;
    }
    return this.sourceWindowOffsets[(paramInt - 1)];
  }
  
  public int getPeriodCount()
  {
    return this.sourcePeriodOffsets[(this.sourcePeriodOffsets.length - 1)];
  }
  
  protected Timeline getTimelineByChildIndex(int paramInt)
  {
    return this.timelines[paramInt];
  }
  
  public int getWindowCount()
  {
    return this.sourceWindowOffsets[(this.sourceWindowOffsets.length - 1)];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.source.ConcatenatingMediaSource.ConcatenatedTimeline
 * JD-Core Version:    0.7.0.1
 */