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
          break label69;
        }
        i = localObject.length;
      }
      catch (Exception localException)
      {
        Object localObject;
        StringBuilder localStringBuilder;
        int i;
        return "";
      }
      if (paramInt < i)
      {
        localStringBuilder.append(localObject[paramInt].toString());
        paramInt += 1;
      }
      else
      {
        localObject = localStringBuilder.toString();
        return localObject;
        label69:
        paramInt = 2;
      }
    }
  }
  
  public static void a(String paramString, int paramInt, long paramLong)
  {
    if (paramLong <= 0L)
    {
      AssertUtils.a("unLikeRecommendFeed failed, because recommendId=" + paramLong, new Object[0]);
      return;
    }
    FeedUtils.1 local1 = new FeedUtils.1();
    local1.jdField_b_of_type_JavaLangString = paramString;
    local1.c = paramInt;
    local1.jdField_b_of_type_Long = paramLong;
    local1.d = 1;
    CmdTaskManger.a().a(local1, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.utils.FeedUtils
 * JD-Core Version:    0.7.0.1
 */