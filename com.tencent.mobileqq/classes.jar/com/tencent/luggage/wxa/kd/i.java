package com.tencent.luggage.wxa.kd;

import com.tencent.luggage.wxa.jx.c;

public class i
{
  public static int a(c paramc, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramc.hashCode());
    localStringBuilder.append("#");
    localStringBuilder.append(System.currentTimeMillis());
    localStringBuilder.append("#");
    localStringBuilder.append(paramLong);
    return localStringBuilder.toString().hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kd.i
 * JD-Core Version:    0.7.0.1
 */