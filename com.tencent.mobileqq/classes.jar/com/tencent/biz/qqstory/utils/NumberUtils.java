package com.tencent.biz.qqstory.utils;

import com.tencent.biz.qqstory.support.logging.SLog;

public class NumberUtils
{
  public static long a(String paramString, long paramLong)
  {
    try
    {
      long l = Long.valueOf(paramString).longValue();
      return l;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label10:
      StringBuilder localStringBuilder;
      break label10;
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("Invalid num string ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", return default number ");
    localStringBuilder.append(paramLong);
    SLog.d("NumberUtils", localStringBuilder.toString());
    return paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.utils.NumberUtils
 * JD-Core Version:    0.7.0.1
 */