package com.sina.weibo.sdk.net;

import android.content.Context;
import android.text.TextUtils;

public class HttpManager
{
  static
  {
    System.loadLibrary("weibosdkcore");
  }
  
  public static String a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (!TextUtils.isEmpty(paramString1)) {
      localStringBuilder.append(paramString1);
    }
    if (!TextUtils.isEmpty(paramString2)) {
      localStringBuilder.append(paramString2);
    }
    if (!TextUtils.isEmpty(paramString3)) {
      localStringBuilder.append(paramString3);
    }
    return calcOauthSignNative(paramContext, localStringBuilder.toString(), paramString4);
  }
  
  private static native String calcOauthSignNative(Context paramContext, String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.sina.weibo.sdk.net.HttpManager
 * JD-Core Version:    0.7.0.1
 */