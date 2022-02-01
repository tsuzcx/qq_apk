package com.tencent.luggage.wxa.hd;

import com.tencent.luggage.wxa.qz.o;
import java.lang.reflect.Method;

public class h
{
  private static Class<?> a;
  private static Method b;
  private static Method c;
  
  static
  {
    try
    {
      a = Class.forName("android.os.SystemProperties");
      b = a.getDeclaredMethod("get", new Class[] { String.class });
      c = a.getDeclaredMethod("getInt", new Class[] { String.class, Integer.TYPE });
      b.setAccessible(true);
      c.setAccessible(true);
      return;
    }
    catch (Exception localException)
    {
      o.a("MicroMsg.SystemProperties", localException, "", new Object[0]);
    }
  }
  
  public static int a(String paramString, int paramInt)
  {
    try
    {
      int i = ((Integer)c.invoke(null, new Object[] { paramString, Integer.valueOf(paramInt) })).intValue();
      return i;
    }
    catch (Exception paramString)
    {
      o.a("MicroMsg.SystemProperties", paramString, "", new Object[0]);
    }
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.hd.h
 * JD-Core Version:    0.7.0.1
 */