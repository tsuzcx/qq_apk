package com.tencent.biz.subscribe.comment;

import com.tencent.mobileqq.app.HardCodeUtil;

public class Formatter
{
  public static String a(long paramLong)
  {
    long l = paramLong;
    if (paramLong < 0L) {
      l = 0L;
    }
    Object localObject1 = HardCodeUtil.a(2131704823);
    if (l < 10000L) {
      return String.valueOf(l);
    }
    if (l < 10000000L)
    {
      d = l;
      Double.isNaN(d);
      localObject1 = String.valueOf(d / 10000.0D + 0.05D);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(((String)localObject1).substring(0, ((String)localObject1).indexOf(".") + 2));
      ((StringBuilder)localObject2).append("w");
      return ((StringBuilder)localObject2).toString();
    }
    if (l < 100000000L)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(l / 10000L);
      ((StringBuilder)localObject1).append("w");
      return ((StringBuilder)localObject1).toString();
    }
    double d = l;
    Double.isNaN(d);
    Object localObject2 = String.valueOf(d / 100000000.0D);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(((String)localObject2).substring(0, ((String)localObject2).indexOf(".") + 2));
    localStringBuilder.append((String)localObject1);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.comment.Formatter
 * JD-Core Version:    0.7.0.1
 */