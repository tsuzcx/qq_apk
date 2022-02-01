package com.tencent.biz.pubaccount.weishi_new.util;

import androidx.annotation.NonNull;
import java.text.DecimalFormat;

public class WSTextFormatter
{
  public static final DecimalFormat a = new DecimalFormat("0.0");
  
  @NonNull
  public static String a(int paramInt)
  {
    return a(paramInt, "w");
  }
  
  @NonNull
  private static String a(long paramLong, String paramString)
  {
    if (paramLong <= 0L) {
      return Integer.toString(0);
    }
    if (paramLong < 10000L) {
      return Long.toString(paramLong);
    }
    if (paramLong < 99999500L)
    {
      d = (float)paramLong / 10000.0F;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(a.format(d));
      localStringBuilder.append(paramString);
      return localStringBuilder.toString();
    }
    if (paramLong < 100000000L) {
      return "1.0亿";
    }
    double d = (float)paramLong / 1.0E+008F;
    paramString = new StringBuilder();
    paramString.append(a.format(d));
    paramString.append("亿");
    return paramString.toString();
  }
  
  @NonNull
  public static String b(int paramInt)
  {
    return a(paramInt, "万");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.util.WSTextFormatter
 * JD-Core Version:    0.7.0.1
 */