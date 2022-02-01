package com.google.android.exoplayer2;

import android.util.Pair;
import com.google.android.exoplayer2.util.Assertions;

public abstract class Timeline
{
  public static final Timeline EMPTY = new Timeline.1();
  
  public int getFirstWindowIndex(boolean paramBoolean)
  {
    if (isEmpty()) {
      return -1;
    }
    return 0;
  }
  
  public abstract int getIndexOfPeriod(Object paramObject);
  
  public int getLastWindowIndex(boolean paramBoolean)
  {
    if (isEmpty()) {
      return -1;
    }
    return getWindowCount() - 1;
  }
  
  public final int getNextPeriodIndex(int paramInt1, Timeline.Period paramPeriod, Timeline.Window paramWindow, int paramInt2, boolean paramBoolean)
  {
    int i = getPeriod(paramInt1, paramPeriod).windowIndex;
    if (getWindow(i, paramWindow).lastPeriodIndex == paramInt1)
    {
      paramInt1 = getNextWindowIndex(i, paramInt2, paramBoolean);
      if (paramInt1 == -1) {
        return -1;
      }
      return getWindow(paramInt1, paramWindow).firstPeriodIndex;
    }
    return paramInt1 + 1;
  }
  
  public int getNextWindowIndex(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    switch (paramInt2)
    {
    default: 
      throw new IllegalStateException();
    case 0: 
      if (paramInt1 == getLastWindowIndex(paramBoolean)) {
        return -1;
      }
      return paramInt1 + 1;
    case 1: 
      return paramInt1;
    }
    if (paramInt1 == getLastWindowIndex(paramBoolean)) {
      return getFirstWindowIndex(paramBoolean);
    }
    return paramInt1 + 1;
  }
  
  public final Timeline.Period getPeriod(int paramInt, Timeline.Period paramPeriod)
  {
    return getPeriod(paramInt, paramPeriod, false);
  }
  
  public abstract Timeline.Period getPeriod(int paramInt, Timeline.Period paramPeriod, boolean paramBoolean);
  
  public abstract int getPeriodCount();
  
  public final Pair<Integer, Long> getPeriodPosition(Timeline.Window paramWindow, Timeline.Period paramPeriod, int paramInt, long paramLong)
  {
    return getPeriodPosition(paramWindow, paramPeriod, paramInt, paramLong, 0L);
  }
  
  public final Pair<Integer, Long> getPeriodPosition(Timeline.Window paramWindow, Timeline.Period paramPeriod, int paramInt, long paramLong1, long paramLong2)
  {
    Assertions.checkIndex(paramInt, 0, getWindowCount());
    getWindow(paramInt, paramWindow, false, paramLong2);
    paramLong2 = paramLong1;
    if (paramLong1 == -9223372036854775807L)
    {
      paramLong1 = paramWindow.getDefaultPositionUs();
      paramLong2 = paramLong1;
      if (paramLong1 == -9223372036854775807L) {
        return null;
      }
    }
    paramInt = paramWindow.firstPeriodIndex;
    paramLong2 = paramWindow.getPositionInFirstPeriodUs() + paramLong2;
    for (paramLong1 = getPeriod(paramInt, paramPeriod).getDurationUs(); (paramLong1 != -9223372036854775807L) && (paramLong2 >= paramLong1) && (paramInt < paramWindow.lastPeriodIndex); paramLong1 = getPeriod(paramInt, paramPeriod).getDurationUs())
    {
      paramLong2 -= paramLong1;
      paramInt += 1;
    }
    return Pair.create(Integer.valueOf(paramInt), Long.valueOf(paramLong2));
  }
  
  public int getPreviousWindowIndex(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    switch (paramInt2)
    {
    default: 
      throw new IllegalStateException();
    case 0: 
      if (paramInt1 == getFirstWindowIndex(paramBoolean)) {
        return -1;
      }
      return paramInt1 - 1;
    case 1: 
      return paramInt1;
    }
    if (paramInt1 == getFirstWindowIndex(paramBoolean)) {
      return getLastWindowIndex(paramBoolean);
    }
    return paramInt1 - 1;
  }
  
  public final Timeline.Window getWindow(int paramInt, Timeline.Window paramWindow)
  {
    return getWindow(paramInt, paramWindow, false);
  }
  
  public final Timeline.Window getWindow(int paramInt, Timeline.Window paramWindow, boolean paramBoolean)
  {
    return getWindow(paramInt, paramWindow, paramBoolean, 0L);
  }
  
  public abstract Timeline.Window getWindow(int paramInt, Timeline.Window paramWindow, boolean paramBoolean, long paramLong);
  
  public abstract int getWindowCount();
  
  public final boolean isEmpty()
  {
    return getWindowCount() == 0;
  }
  
  public final boolean isLastPeriod(int paramInt1, Timeline.Period paramPeriod, Timeline.Window paramWindow, int paramInt2, boolean paramBoolean)
  {
    return getNextPeriodIndex(paramInt1, paramPeriod, paramWindow, paramInt2, paramBoolean) == -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.Timeline
 * JD-Core Version:    0.7.0.1
 */