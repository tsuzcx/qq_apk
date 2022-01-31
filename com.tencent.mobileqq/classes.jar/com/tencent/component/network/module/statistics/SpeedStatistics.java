package com.tencent.component.network.module.statistics;

import com.tencent.component.network.module.statistics.common.SortedFixedLinkedList;
import java.util.Comparator;

public class SpeedStatistics
{
  private static final int UPDATE_AVERAGE_SPEED_INTERVAL = 2;
  private static final Comparator<SpeedStatistics.StatisticsUnit> sUnitComparator = new SpeedStatistics.1();
  private float mAverageSpeed;
  private int mAverageSpeedCount = 0;
  private final SortedFixedLinkedList<SpeedStatistics.StatisticsUnit> mStatisticList = new SortedFixedLinkedList(100, sUnitComparator, false);
  private int mStatisticsCount;
  
  private static long gapBetween(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    if (paramLong3 > paramLong2) {
      return paramLong3 - paramLong2;
    }
    if (paramLong1 > paramLong4) {
      return paramLong1 - paramLong4;
    }
    return 0L;
  }
  
  public static SpeedStatistics getInstance()
  {
    return SpeedStatistics.InstanceHolder.INSTANCE;
  }
  
  private static long max(long paramLong1, long paramLong2)
  {
    if (paramLong1 > paramLong2) {
      return paramLong1;
    }
    return paramLong2;
  }
  
  private static int min(int paramInt1, int paramInt2)
  {
    if (paramInt1 < paramInt2) {
      return paramInt1;
    }
    return paramInt2;
  }
  
  private static long min(long paramLong1, long paramLong2)
  {
    if (paramLong1 < paramLong2) {
      return paramLong1;
    }
    return paramLong2;
  }
  
  private boolean shouldUpdateAverageSpeed()
  {
    int i = this.mAverageSpeedCount;
    this.mAverageSpeedCount = (i + 1);
    if (i < 2) {
      return false;
    }
    this.mAverageSpeedCount = 0;
    return true;
  }
  
  private void updateAverageSpeed(int paramInt)
  {
    int i = this.mStatisticList.size();
    if (paramInt > 0)
    {
      paramInt = min(i, paramInt);
      if (paramInt > 0) {
        break label31;
      }
    }
    label31:
    long l1;
    long l4;
    do
    {
      return;
      paramInt = i;
      break;
      SpeedStatistics.StatisticsUnit localStatisticsUnit = (SpeedStatistics.StatisticsUnit)this.mStatisticList.get(paramInt - 1);
      long l2 = localStatisticsUnit.startTime;
      l1 = localStatisticsUnit.endTime;
      long l3 = 0L;
      l4 = 0L;
      paramInt -= 1;
      while (paramInt >= 0)
      {
        localStatisticsUnit = (SpeedStatistics.StatisticsUnit)this.mStatisticList.get(paramInt);
        l4 += localStatisticsUnit.bytesSize;
        long l6 = localStatisticsUnit.startTime;
        long l5 = localStatisticsUnit.endTime;
        l3 += gapBetween(l2, l1, l6, l5);
        l2 = min(l2, l6);
        l1 = max(l1, l5);
        paramInt -= 1;
      }
      l1 = l1 - l2 - l3;
    } while (l1 <= 0L);
    double d1 = l4 / 1024.0D;
    double d2 = l1 / 1000.0D;
    if ((d1 > 0.0D) && (d2 > 0.0D)) {}
    for (float f = (float)(d1 / d2);; f = 0.0F)
    {
      this.mAverageSpeed = f;
      return;
    }
  }
  
  public float getAverageSpeed()
  {
    return this.mAverageSpeed;
  }
  
  public int getStatisticsCount()
  {
    return this.mStatisticsCount;
  }
  
  public void report(long paramLong1, long paramLong2, long paramLong3)
  {
    if (paramLong1 < 51200L) {
      return;
    }
    SpeedStatistics.StatisticsUnit localStatisticsUnit = new SpeedStatistics.StatisticsUnit();
    localStatisticsUnit.bytesSize = paramLong1;
    localStatisticsUnit.startTime = min(paramLong2, paramLong3);
    localStatisticsUnit.endTime = max(paramLong2, paramLong3);
    synchronized (this.mStatisticList)
    {
      this.mStatisticList.add(localStatisticsUnit);
      this.mStatisticsCount += 1;
      if (shouldUpdateAverageSpeed()) {
        updateAverageSpeed(5);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.module.statistics.SpeedStatistics
 * JD-Core Version:    0.7.0.1
 */