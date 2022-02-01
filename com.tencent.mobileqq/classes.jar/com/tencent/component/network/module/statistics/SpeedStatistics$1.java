package com.tencent.component.network.module.statistics;

import java.util.Comparator;

final class SpeedStatistics$1
  implements Comparator<SpeedStatistics.StatisticsUnit>
{
  public int compare(SpeedStatistics.StatisticsUnit paramStatisticsUnit1, SpeedStatistics.StatisticsUnit paramStatisticsUnit2)
  {
    if (paramStatisticsUnit1.startTime > paramStatisticsUnit2.startTime) {
      return -1;
    }
    if (paramStatisticsUnit1.startTime < paramStatisticsUnit2.startTime) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.component.network.module.statistics.SpeedStatistics.1
 * JD-Core Version:    0.7.0.1
 */