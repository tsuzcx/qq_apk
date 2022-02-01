package com.huawei.hms.framework.common;

public class CheckParamUtils
{
  private static final String TAG = "CheckParamUtils";
  
  public static <T> T checkNotNull(T paramT, String paramString)
  {
    if (paramT != null) {
      return paramT;
    }
    throw new NullPointerException(paramString);
  }
  
  public static int checkNumParam(int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString)
  {
    if (paramInt1 <= paramInt3)
    {
      if (paramInt1 < paramInt2) {
        return paramInt4;
      }
      Logger.d("CheckParamUtils", paramString);
      return paramInt1;
    }
    return paramInt4;
  }
  
  public static long checkNumParam(long paramLong1, long paramLong2, long paramLong3, long paramLong4, String paramString)
  {
    if (paramLong1 <= paramLong3)
    {
      if (paramLong1 < paramLong2) {
        return paramLong4;
      }
      Logger.d("CheckParamUtils", paramString);
      return paramLong1;
    }
    return paramLong4;
  }
  
  public static void checkOffsetAndCount(long paramLong1, long paramLong2, long paramLong3)
  {
    if (((paramLong2 | paramLong3) >= 0L) && (paramLong2 <= paramLong1) && (paramLong1 - paramLong2 >= paramLong3)) {
      return;
    }
    throw new ArrayIndexOutOfBoundsException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.framework.common.CheckParamUtils
 * JD-Core Version:    0.7.0.1
 */