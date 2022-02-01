package com.tencent.gdtad.api.banner.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class GdtDownloadNumFormatter
{
  private static final Double a = Double.valueOf(10000.0D);
  private static final Double b = Double.valueOf(1000000.0D);
  private static final Double c = Double.valueOf(100000000.0D);
  
  public static Double a(double paramDouble, int paramInt, boolean paramBoolean)
  {
    BigDecimal localBigDecimal = new BigDecimal(paramDouble);
    if (paramBoolean) {
      return Double.valueOf(localBigDecimal.setScale(paramInt, RoundingMode.HALF_UP).doubleValue());
    }
    return Double.valueOf(localBigDecimal.setScale(paramInt, RoundingMode.DOWN).doubleValue());
  }
  
  public static String a(long paramLong)
  {
    double d1 = paramLong;
    double d2;
    double d3;
    if ((d1 > a.doubleValue()) && (d1 < c.doubleValue()))
    {
      d2 = a.doubleValue();
      Double.isNaN(d1);
      d2 = d1 / d2;
      d3 = a.doubleValue();
      Double.isNaN(d1);
      if (d1 % d3 < a.doubleValue() / 2.0D) {
        d1 = a(d2, 1, false).doubleValue();
      } else {
        d1 = a(d2, 1, true).doubleValue();
      }
      if (d1 == a.doubleValue())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(d1 / a.doubleValue());
        localStringBuilder.append("亿人已下载");
        return localStringBuilder.toString();
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(d1);
      localStringBuilder.append("万人已下载");
      return localStringBuilder.toString();
    }
    if (d1 > c.doubleValue())
    {
      d2 = c.doubleValue();
      Double.isNaN(d1);
      d2 = d1 / d2;
      d3 = c.doubleValue();
      Double.isNaN(d1);
      if (d1 % d3 < c.doubleValue() / 2.0D) {
        d1 = a(d2, 1, false).doubleValue();
      } else {
        d1 = a(d2, 1, true).doubleValue();
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(d1);
      localStringBuilder.append("亿人已下载");
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(String.valueOf(paramLong));
    localStringBuilder.append("人已下载");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.api.banner.utils.GdtDownloadNumFormatter
 * JD-Core Version:    0.7.0.1
 */