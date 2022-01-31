package com.tencent.mobileqq.ar.config;

import java.util.Comparator;
import java.util.Date;

class WorldCupShareInfo$1
  implements Comparator
{
  WorldCupShareInfo$1(WorldCupShareInfo paramWorldCupShareInfo) {}
  
  public int compare(WorldCupShareInfo.Match paramMatch1, WorldCupShareInfo.Match paramMatch2)
  {
    paramMatch1 = this.this$0.getDate(paramMatch1.begin_time);
    paramMatch2 = this.this$0.getDate(paramMatch2.begin_time);
    if (paramMatch1 != null) {}
    for (long l1 = paramMatch1.getTime();; l1 = 0L)
    {
      if (paramMatch2 != null) {}
      for (long l2 = paramMatch2.getTime();; l2 = 0L)
      {
        l1 = l2 - l1;
        int i = 0;
        if (l1 > 0L) {
          i = 1;
        }
        while (l1 >= 0L) {
          return i;
        }
        return -1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ar.config.WorldCupShareInfo.1
 * JD-Core Version:    0.7.0.1
 */