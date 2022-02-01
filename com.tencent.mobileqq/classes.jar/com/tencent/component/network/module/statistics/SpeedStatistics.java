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
    int j = this.mStatisticList.size();
    int i = j;
    if (paramInt > 0) {
      i = min(j, paramInt);
    }
    if (i <= 0) {
      return;
    }
    Object localObject = this.mStatisticList;
    paramInt = i - 1;
    localObject = (SpeedStatistics.StatisticsUnit)((SortedFixedLinkedList)localObject).get(paramInt);
    long l3 = ((SpeedStatistics.StatisticsUnit)localObject).startTime;
    long l2 = ((SpeedStatistics.StatisticsUnit)localObject).endTime;
    long l1 = 0L;
    long l4 = l1;
    while (paramInt >= 0)
    {
      localObject = (SpeedStatistics.StatisticsUnit)this.mStatisticList.get(paramInt);
      long l5 = ((SpeedStatistics.StatisticsUnit)localObject).bytesSize;
      long l7 = ((SpeedStatistics.StatisticsUnit)localObject).startTime;
      long l6 = ((SpeedStatistics.StatisticsUnit)localObject).endTime;
      l4 += gapBetween(l3, l2, l7, l6);
      l3 = min(l3, l7);
      l2 = max(l2, l6);
      paramInt -= 1;
      l1 += l5;
    }
    l2 = l2 - l3 - l4;
    if (l2 <= 0L) {
      return;
    }
    double d1 = l1;
    Double.isNaN(d1);
    d1 /= 1024.0D;
    double d2 = l2;
    Double.isNaN(d2);
    d2 /= 1000.0D;
    float f;
    if ((d1 > 0.0D) && (d2 > 0.0D)) {
      f = (float)(d1 / d2);
    } else {
      f = 0.0F;
    }
    this.mAverageSpeed = f;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.component.network.module.statistics.SpeedStatistics
 * JD-Core Version:    0.7.0.1
 */