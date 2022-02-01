package com.tencent.luggage.wxa.qz;

import android.content.Context;

public class d
{
  public static String a(Context paramContext, int paramInt)
  {
    int i = paramInt >> 8 & 0xFF;
    if (i == 0)
    {
      paramContext = new StringBuilder();
      paramContext.append("");
      paramContext.append(paramInt >> 24 & 0xF);
      paramContext.append(".");
      paramContext.append(paramInt >> 16 & 0xFF);
      return paramContext.toString();
    }
    paramContext = new StringBuilder();
    paramContext.append("");
    paramContext.append(paramInt >> 24 & 0xF);
    paramContext.append(".");
    paramContext.append(paramInt >> 16 & 0xFF);
    paramContext.append(".");
    paramContext.append(i);
    return paramContext.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qz.d
 * JD-Core Version:    0.7.0.1
 */