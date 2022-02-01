package com.google.android.exoplayer2.source;

import android.util.Pair;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.Timeline.Period;
import com.google.android.exoplayer2.Timeline.Window;

abstract class AbstractConcatenatedTimeline
  extends Timeline
{
  private final int childCount;
  private final boolean isAtomic;
  private final ShuffleOrder shuffleOrder;
  
  public AbstractConcatenatedTimeline(boolean paramBoolean, ShuffleOrder paramShuffleOrder)
  {
    this.isAtomic = paramBoolean;
    this.shuffleOrder = paramShuffleOrder;
    this.childCount = paramShuffleOrder.getLength();
  }
  
  private int getNextChildIndex(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {
      return this.shuffleOrder.getNextIndex(paramInt);
    }
    if (paramInt < this.childCount - 1) {
      return paramInt + 1;
    }
    return -1;
  }
  
  private int getPreviousChildIndex(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {
      return this.shuffleOrder.getPreviousIndex(paramInt);
    }
    if (paramInt > 0) {
      return paramInt - 1;
    }
    return -1;
  }
  
  protected abstract int getChildIndexByChildUid(Object paramObject);
  
  protected abstract int getChildIndexByPeriodIndex(int paramInt);
  
  protected abstract int getChildIndexByWindowIndex(int paramInt);
  
  protected abstract Object getChildUidByChildIndex(int paramInt);
  
  protected abstract int getFirstPeriodIndexByChildIndex(int paramInt);
  
  public int getFirstWindowIndex(boolean paramBoolean)
  {
    if (this.childCount == 0) {
      return -1;
    }
    boolean bool = this.isAtomic;
    int i = 0;
    if (bool) {
      paramBoolean = false;
    }
    if (paramBoolean) {
      i = this.shuffleOrder.getFirstIndex();
    }
    while (getTimelineByChildIndex(i).isEmpty())
    {
      int j = getNextChildIndex(i, paramBoolean);
      i = j;
      if (j == -1) {
        return -1;
      }
    }
    return getFirstWindowIndexByChildIndex(i) + getTimelineByChildIndex(i).getFirstWindowIndex(paramBoolean);
  }
  
  protected abstract int getFirstWindowIndexByChildIndex(int paramInt);
  
  public final int getIndexOfPeriod(Object paramObject)
  {
    if (!(paramObject instanceof Pair)) {
      return -1;
    }
    Object localObject = (Pair)paramObject;
    paramObject = ((Pair)localObject).first;
    localObject = ((Pair)localObject).second;
    int i = getChildIndexByChildUid(paramObject);
    if (i == -1) {
      return -1;
    }
    int j = getTimelineByChildIndex(i).getIndexOfPeriod(localObject);
    if (j == -1) {
      return -1;
    }
    return getFirstPeriodIndexByChildIndex(i) + j;
  }
  
  public int getLastWindowIndex(boolean paramBoolean)
  {
    if (this.childCount == 0) {
      return -1;
    }
    if (this.isAtomic) {
      paramBoolean = false;
    }
    int i;
    if (paramBoolean) {
      i = this.shuffleOrder.getLastIndex();
    } else {
      i = this.childCount - 1;
    }
    while (getTimelineByChildIndex(i).isEmpty())
    {
      int j = getPreviousChildIndex(i, paramBoolean);
      i = j;
      if (j == -1) {
        return -1;
      }
    }
    return getFirstWindowIndexByChildIndex(i) + getTimelineByChildIndex(i).getLastWindowIndex(paramBoolean);
  }
  
  public int getNextWindowIndex(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    boolean bool = this.isAtomic;
    int j = 0;
    int i = paramInt2;
    if (bool)
    {
      i = paramInt2;
      if (paramInt2 == 1) {
        i = 2;
      }
      paramBoolean = false;
    }
    int k = getChildIndexByWindowIndex(paramInt1);
    int m = getFirstWindowIndexByChildIndex(k);
    Timeline localTimeline = getTimelineByChildIndex(k);
    if (i == 2) {
      paramInt2 = j;
    } else {
      paramInt2 = i;
    }
    paramInt1 = localTimeline.getNextWindowIndex(paramInt1 - m, paramInt2, paramBoolean);
    if (paramInt1 != -1) {
      return m + paramInt1;
    }
    for (paramInt1 = getNextChildIndex(k, paramBoolean); (paramInt1 != -1) && (getTimelineByChildIndex(paramInt1).isEmpty()); paramInt1 = getNextChildIndex(paramInt1, paramBoolean)) {}
    if (paramInt1 != -1) {
      return getFirstWindowIndexByChildIndex(paramInt1) + getTimelineByChildIndex(paramInt1).getFirstWindowIndex(paramBoolean);
    }
    if (i == 2) {
      return getFirstWindowIndex(paramBoolean);
    }
    return -1;
  }
  
  public final Timeline.Period getPeriod(int paramInt, Timeline.Period paramPeriod, boolean paramBoolean)
  {
    int i = getChildIndexByPeriodIndex(paramInt);
    int j = getFirstWindowIndexByChildIndex(i);
    int k = getFirstPeriodIndexByChildIndex(i);
    getTimelineByChildIndex(i).getPeriod(paramInt - k, paramPeriod, paramBoolean);
    paramPeriod.windowIndex += j;
    if (paramBoolean) {
      paramPeriod.uid = Pair.create(getChildUidByChildIndex(i), paramPeriod.uid);
    }
    return paramPeriod;
  }
  
  public int getPreviousWindowIndex(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    boolean bool = this.isAtomic;
    int j = 0;
    int i = paramInt2;
    if (bool)
    {
      i = paramInt2;
      if (paramInt2 == 1) {
        i = 2;
      }
      paramBoolean = false;
    }
    int k = getChildIndexByWindowIndex(paramInt1);
    int m = getFirstWindowIndexByChildIndex(k);
    Timeline localTimeline = getTimelineByChildIndex(k);
    if (i == 2) {
      paramInt2 = j;
    } else {
      paramInt2 = i;
    }
    paramInt1 = localTimeline.getPreviousWindowIndex(paramInt1 - m, paramInt2, paramBoolean);
    if (paramInt1 != -1) {
      return m + paramInt1;
    }
    for (paramInt1 = getPreviousChildIndex(k, paramBoolean); (paramInt1 != -1) && (getTimelineByChildIndex(paramInt1).isEmpty()); paramInt1 = getPreviousChildIndex(paramInt1, paramBoolean)) {}
    if (paramInt1 != -1) {
      return getFirstWindowIndexByChildIndex(paramInt1) + getTimelineByChildIndex(paramInt1).getLastWindowIndex(paramBoolean);
    }
    if (i == 2) {
      return getLastWindowIndex(paramBoolean);
    }
    return -1;
  }
  
  protected abstract Timeline getTimelineByChildIndex(int paramInt);
  
  public final Timeline.Window getWindow(int paramInt, Timeline.Window paramWindow, boolean paramBoolean, long paramLong)
  {
    int i = getChildIndexByWindowIndex(paramInt);
    int j = getFirstWindowIndexByChildIndex(i);
    int k = getFirstPeriodIndexByChildIndex(i);
    getTimelineByChildIndex(i).getWindow(paramInt - j, paramWindow, paramBoolean, paramLong);
    paramWindow.firstPeriodIndex += k;
    paramWindow.lastPeriodIndex += k;
    return paramWindow;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.source.AbstractConcatenatedTimeline
 * JD-Core Version:    0.7.0.1
 */