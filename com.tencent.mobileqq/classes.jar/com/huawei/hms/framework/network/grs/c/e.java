package com.huawei.hms.framework.network.grs.c;

import com.huawei.hms.framework.common.Logger;

public class e
{
  private static final String a = e.class.getSimpleName();
  
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
        Logger.v(a, "isSpExpire false.");
        return false;
      }
      Logger.v(a, "isSpExpire true.");
      return true;
    }
    catch (NumberFormatException paramLong)
    {
      Logger.v(a, "isSpExpire spValue NumberFormatException.");
    }
    return true;
  }
  
  public static boolean a(Long paramLong, long paramLong1)
  {
    if (paramLong == null) {
      Logger.v(a, "Method isTimeWillExpire input param expireTime is null.");
    }
    for (;;)
    {
      return true;
      try
      {
        long l = System.currentTimeMillis();
        if (paramLong.longValue() - (l + paramLong1) >= 0L)
        {
          Logger.v(a, "isSpExpire false.");
          return false;
        }
      }
      catch (NumberFormatException paramLong)
      {
        Logger.v(a, "isSpExpire spValue NumberFormatException.");
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hms.framework.network.grs.c.e
 * JD-Core Version:    0.7.0.1
 */