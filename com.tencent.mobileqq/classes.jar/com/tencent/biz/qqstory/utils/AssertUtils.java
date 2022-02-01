package com.tencent.biz.qqstory.utils;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.imcore.proxy.basic.CaughtExceptionReportProxy;

public class AssertUtils
{
  private static final boolean DEBUG = false;
  private static final String TAG = "Q.qqstory.AssertUtils";
  
  public static <T> void assertNotNull_DEBUG(T paramT)
  {
    if (paramT == null)
    {
      paramT = StoryDebugUtils.StoryExceptionCallback.a("StoryAssertUtils Exception!");
      CaughtExceptionReportProxy.e(paramT, "StoryAssertUtils assertNotNull_DEBUG()");
      SLog.c("Q.qqstory.AssertUtils", "assertNotNull_DEBUG failed: ", paramT);
    }
  }
  
  public static void assertTrue(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("assertTrue failed:");
      localStringBuilder.append(getStackTrace(4));
      SLog.e("Q.qqstory.AssertUtils", localStringBuilder.toString());
    }
  }
  
  public static void assertTrue(boolean paramBoolean, @NonNull String paramString)
  {
    if (paramBoolean) {
      return;
    }
    SLog.e("Q.qqstory.AssertUtils", paramString);
  }
  
  public static void assertTrue(boolean paramBoolean, @NonNull String paramString, Object... paramVarArgs)
  {
    if (paramBoolean) {
      return;
    }
    SLog.e("Q.qqstory.AssertUtils", String.format(null, paramString, paramVarArgs));
  }
  
  public static void checkNotEmpty(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return;
    }
    paramString = new StringBuilder();
    paramString.append("checkNotEmpty failed :");
    paramString.append(getStackTrace(2));
    SLog.e("Q.qqstory.AssertUtils", paramString.toString());
  }
  
  public static <T> T checkNotNull(T paramT)
  {
    if (paramT == null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkNotNull failed:");
      localStringBuilder.append(getStackTrace(2));
      SLog.e("Q.qqstory.AssertUtils", localStringBuilder.toString());
    }
    return paramT;
  }
  
  public static void fail(String paramString, Object... paramVarArgs)
  {
    if (paramVarArgs.length != 0) {
      paramString = String.format(paramString, paramVarArgs);
    }
    SLog.e("Q.qqstory.AssertUtils", paramString);
  }
  
  public static String getStackTrace(int paramInt)
  {
    for (;;)
    {
      try
      {
        localObject = new RuntimeException("getStackTrace").getStackTrace();
        localStringBuilder1 = new StringBuilder();
        i = paramInt;
        if (localObject.length > paramInt) {
          continue;
        }
        i = localObject.length;
      }
      catch (Exception localException)
      {
        Object localObject;
        StringBuilder localStringBuilder1;
        int i;
        StringBuilder localStringBuilder2;
        continue;
        paramInt = 2;
        continue;
      }
      if (paramInt >= i) {
        continue;
      }
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("\n");
      localStringBuilder2.append(localObject[paramInt].toString());
      localStringBuilder1.append(localStringBuilder2.toString());
      paramInt += 1;
    }
    localObject = localStringBuilder1.toString();
    return localObject;
    return "";
  }
  
  public static void mainThreadCheck() {}
  
  public static void notMainThreadCheck() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.utils.AssertUtils
 * JD-Core Version:    0.7.0.1
 */