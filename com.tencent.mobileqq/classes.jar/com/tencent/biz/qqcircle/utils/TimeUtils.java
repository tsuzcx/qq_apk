package com.tencent.biz.qqcircle.utils;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class TimeUtils
{
  public static String a(int paramInt)
  {
    int i = paramInt / 1000;
    paramInt = i / 60;
    i %= 60;
    Object localObject;
    if (paramInt < 10)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("0");
      ((StringBuilder)localObject).append(paramInt);
      localObject = ((StringBuilder)localObject).toString();
    }
    else
    {
      localObject = String.valueOf(paramInt);
    }
    if (i < 10) {
      return String.format("%s:0%s", new Object[] { localObject, Integer.valueOf(i) });
    }
    return String.format("%s:%s", new Object[] { localObject, Integer.valueOf(i) });
  }
  
  public static String a(long paramLong, String paramString)
  {
    return new SimpleDateFormat(String.format("yyyy%sMM%sdd", new Object[] { paramString, paramString }), Locale.getDefault()).format(Long.valueOf(paramLong));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.utils.TimeUtils
 * JD-Core Version:    0.7.0.1
 */