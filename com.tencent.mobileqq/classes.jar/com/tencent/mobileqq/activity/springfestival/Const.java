package com.tencent.mobileqq.activity.springfestival;

import com.tencent.mobileqq.activity.springfestival.entry.model.ITime;
import com.tencent.mobileqq.activity.springfestival.entry.model.TimeInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Comparator;

public class Const
{
  public static Comparator<ITime> a = new Const.1();
  
  public static int a(long paramLong1, long paramLong2)
  {
    if (paramLong1 == paramLong2) {
      return 0;
    }
    if (paramLong1 > paramLong2) {
      return 1;
    }
    return -1;
  }
  
  public static TimeInfo a(TimeInfo paramTimeInfo1, TimeInfo paramTimeInfo2)
  {
    return paramTimeInfo2;
  }
  
  public static String a(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3) {
          return "";
        }
        return "MINI_GAME";
      }
      return "ON_GRAB";
    }
    return "PRE_GRAB";
  }
  
  public static boolean a(TimeInfo paramTimeInfo)
  {
    return (paramTimeInfo.begin > 0L) && (paramTimeInfo.end > paramTimeInfo.begin);
  }
  
  public static boolean a(TimeInfo paramTimeInfo, long paramLong)
  {
    if (paramTimeInfo == null)
    {
      QLog.w("shua2021_", 1, "isInTime --> timeInfo is null");
      return false;
    }
    if (!a(paramTimeInfo)) {
      return false;
    }
    return (paramTimeInfo.begin <= paramLong) && (paramLong <= paramTimeInfo.end);
  }
  
  public static boolean b(TimeInfo paramTimeInfo, long paramLong)
  {
    if (paramTimeInfo == null)
    {
      QLog.w("shua2021_", 1, "isInTimeButNotEnd --> timeInfo is null");
      return false;
    }
    if (!a(paramTimeInfo)) {
      return false;
    }
    return (paramTimeInfo.begin <= paramLong) && (paramLong < paramTimeInfo.end);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.Const
 * JD-Core Version:    0.7.0.1
 */