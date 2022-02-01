package com.tencent.biz.qqstory.utils;

import com.tencent.biz.qqstory.channel.CmdTaskManger;

public class FeedUtils
{
  public static String a(int paramInt)
  {
    for (;;)
    {
      try
      {
        localObject = new RuntimeException("getStackTrace").getStackTrace();
        localStringBuilder = new StringBuilder();
        i = paramInt;
        if (localObject.length > paramInt) {
          continue;
        }
        i = localObject.length;
      }
      catch (Exception localException)
      {
        Object localObject;
        StringBuilder localStringBuilder;
        int i;
        continue;
        paramInt = 2;
        continue;
      }
      if (paramInt >= i) {
        continue;
      }
      localStringBuilder.append(localObject[paramInt].toString());
      paramInt += 1;
    }
    localObject = localStringBuilder.toString();
    return localObject;
    return "";
  }
  
  public static void a(String paramString, int paramInt, long paramLong)
  {
    if (paramLong <= 0L)
    {
      paramString = new StringBuilder();
      paramString.append("unLikeRecommendFeed failed, because recommendId=");
      paramString.append(paramLong);
      AssertUtils.fail(paramString.toString(), new Object[0]);
      return;
    }
    FeedUtils.1 local1 = new FeedUtils.1();
    local1.f = paramString;
    local1.g = paramInt;
    local1.i = paramLong;
    local1.h = 1;
    CmdTaskManger.a().a(local1, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.utils.FeedUtils
 * JD-Core Version:    0.7.0.1
 */