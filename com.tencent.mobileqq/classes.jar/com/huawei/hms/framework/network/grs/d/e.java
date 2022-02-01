package com.huawei.hms.framework.network.grs.d;

import com.huawei.hms.framework.common.Logger;

public class e
{
  private static final String a = "e";
  
  public static boolean a(Long paramLong)
  {
    if (paramLong == null)
    {
      Logger.v(a, "Method isTimeExpire input param expireTime is null.");
      return true;
    }
    try
    {
      long l = System.currentTimeMillis();
      if (paramLong.longValue() - l >= 0L)
      {
        paramLong = a;
        Logger.v(paramLong, "isSpExpire false.");
        return false;
      }
      paramLong = a;
      Logger.v(paramLong, "isSpExpire true.");
      return true;
    }
    catch (NumberFormatException paramLong)
    {
      label53:
      break label53;
    }
    Logger.v(a, "isSpExpire spValue NumberFormatException.");
    return true;
  }
  
  public static boolean a(Long paramLong, long paramLong1)
  {
    if (paramLong == null)
    {
      Logger.v(a, "Method isTimeWillExpire input param expireTime is null.");
      return true;
    }
    try
    {
      long l = System.currentTimeMillis();
      if (paramLong.longValue() - (l + paramLong1) < 0L) {
        break label51;
      }
      paramLong = a;
      Logger.v(paramLong, "isSpExpire false.");
      return false;
    }
    catch (NumberFormatException paramLong)
    {
      label43:
      label51:
      break label43;
    }
    Logger.v(a, "isSpExpire spValue NumberFormatException.");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.framework.network.grs.d.e
 * JD-Core Version:    0.7.0.1
 */