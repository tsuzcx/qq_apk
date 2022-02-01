package com.tencent.biz.qqstory.utils;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.statistics.CaughtExceptionReport;

public class AssertUtils
{
  public static <T> T a(T paramT)
  {
    if (paramT == null) {
      SLog.e("Q.qqstory.AssertUtils", "checkNotNull failed:" + a(2));
    }
    return paramT;
  }
  
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
          break label87;
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
        localStringBuilder.append("\n" + localObject[paramInt].toString());
        paramInt += 1;
      }
      else
      {
        localObject = localStringBuilder.toString();
        return localObject;
        label87:
        paramInt = 2;
      }
    }
  }
  
  public static void a() {}
  
  public static <T> void a(T paramT)
  {
    if (paramT == null)
    {
      paramT = StoryDebugUtils.StoryExceptionCallback.a("StoryAssertUtils Exception!");
      CaughtExceptionReport.a(paramT, "StoryAssertUtils assertNotNull_DEBUG()");
      SLog.c("Q.qqstory.AssertUtils", "assertNotNull_DEBUG failed: ", paramT);
    }
  }
  
  public static void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return;
    }
    SLog.e("Q.qqstory.AssertUtils", "checkNotEmpty failed :" + a(2));
  }
  
  public static void a(String paramString, Object... paramVarArgs)
  {
    if (paramVarArgs.length == 0) {}
    for (;;)
    {
      SLog.e("Q.qqstory.AssertUtils", paramString);
      return;
      paramString = String.format(paramString, paramVarArgs);
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    if (!paramBoolean) {
      SLog.e("Q.qqstory.AssertUtils", "assertTrue failed:" + a(4));
    }
  }
  
  public static void a(boolean paramBoolean, @NonNull String paramString)
  {
    if (paramBoolean) {
      return;
    }
    SLog.e("Q.qqstory.AssertUtils", paramString);
  }
  
  public static void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.utils.AssertUtils
 * JD-Core Version:    0.7.0.1
 */