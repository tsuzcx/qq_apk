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
    switch (paramInt)
    {
    default: 
      return "";
    case 1: 
      return "PRE_GRAB";
    case 2: 
      return "ON_GRAB";
    }
    return "MINI_GAME";
  }
  
  public static boolean a(TimeInfo paramTimeInfo)
  {
    return (paramTimeInfo.begin > 0L) && (paramTimeInfo.end > paramTimeInfo.begin);
  }
  
  public static boolean a(TimeInfo paramTimeInfo, long paramLong)
  {
    boolean bool = true;
    if (paramTimeInfo == null) {
      QLog.w("shua2021_", 1, "isInTime --> timeInfo is null");
    }
    while (!a(paramTimeInfo)) {
      return false;
    }
    if ((paramTimeInfo.begin <= paramLong) && (paramLong <= paramTimeInfo.end)) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public static boolean b(TimeInfo paramTimeInfo, long paramLong)
  {
    boolean bool = true;
    if (paramTimeInfo == null) {
      QLog.w("shua2021_", 1, "isInTimeButNotEnd --> timeInfo is null");
    }
    while (!a(paramTimeInfo)) {
      return false;
    }
    if ((paramTimeInfo.begin <= paramLong) && (paramLong < paramTimeInfo.end)) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.Const
 * JD-Core Version:    0.7.0.1
 */