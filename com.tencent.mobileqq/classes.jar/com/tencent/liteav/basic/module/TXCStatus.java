package com.tencent.liteav.basic.module;

public class TXCStatus
{
  public static long a(String paramString, int paramInt)
  {
    return a(paramString, paramInt, 0);
  }
  
  public static long a(String paramString, int paramInt1, int paramInt2)
  {
    return nativeStatusGetIntValue(paramString, paramInt1, paramInt2);
  }
  
  public static void a(String paramString)
  {
    nativeStatusStartRecord(paramString);
  }
  
  public static boolean a(String paramString, int paramInt1, int paramInt2, Object paramObject)
  {
    if (paramString != null)
    {
      if (paramString.length() == 0) {
        return false;
      }
      if (paramObject == null) {
        return false;
      }
      if ((paramObject instanceof Double)) {
        return nativeStatusSetDoubleValue(paramString, paramInt1, paramInt2, ((Double)paramObject).doubleValue());
      }
      if ((paramObject instanceof String)) {
        return nativeStatusSetStrValue(paramString, paramInt1, paramInt2, (String)paramObject);
      }
      if ((paramObject instanceof Long)) {
        return nativeStatusSetIntValue(paramString, paramInt1, paramInt2, ((Long)paramObject).longValue());
      }
      return nativeStatusSetIntValue(paramString, paramInt1, paramInt2, ((Integer)paramObject).intValue());
    }
    return false;
  }
  
  public static boolean a(String paramString, int paramInt, Object paramObject)
  {
    return a(paramString, paramInt, 0, paramObject);
  }
  
  public static String b(String paramString, int paramInt)
  {
    return b(paramString, paramInt, 0);
  }
  
  public static String b(String paramString, int paramInt1, int paramInt2)
  {
    return nativeStatusGetStrValue(paramString, paramInt1, paramInt2);
  }
  
  public static void b(String paramString)
  {
    nativeStatusStopRecord(paramString);
  }
  
  public static int c(String paramString, int paramInt)
  {
    return c(paramString, paramInt, 0);
  }
  
  public static int c(String paramString, int paramInt1, int paramInt2)
  {
    return (int)nativeStatusGetIntValue(paramString, paramInt1, paramInt2);
  }
  
  public static double d(String paramString, int paramInt)
  {
    return d(paramString, paramInt, 0);
  }
  
  public static double d(String paramString, int paramInt1, int paramInt2)
  {
    return nativeStatusGetDoubleValue(paramString, paramInt1, paramInt2);
  }
  
  private static native double nativeStatusGetDoubleValue(String paramString, int paramInt1, int paramInt2);
  
  private static native long nativeStatusGetIntValue(String paramString, int paramInt1, int paramInt2);
  
  private static native String nativeStatusGetStrValue(String paramString, int paramInt1, int paramInt2);
  
  private static native boolean nativeStatusSetDoubleValue(String paramString, int paramInt1, int paramInt2, double paramDouble);
  
  private static native boolean nativeStatusSetIntValue(String paramString, int paramInt1, int paramInt2, long paramLong);
  
  private static native boolean nativeStatusSetStrValue(String paramString1, int paramInt1, int paramInt2, String paramString2);
  
  private static native void nativeStatusStartRecord(String paramString);
  
  private static native void nativeStatusStopRecord(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.basic.module.TXCStatus
 * JD-Core Version:    0.7.0.1
 */