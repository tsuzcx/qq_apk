package com.tencent.ad.tangram.device;

import android.content.Context;
import android.text.TextUtils;

public final class a
{
  private static final String TAG = "AdAndroidIdMD5Digest";
  private static String androidIdMD5Digest;
  
  public static String get(Context paramContext)
  {
    if (!TextUtils.isEmpty(androidIdMD5Digest)) {
      return androidIdMD5Digest;
    }
    paramContext = b.getAndroidId(paramContext);
    if (TextUtils.isEmpty(paramContext)) {}
    for (;;)
    {
      return androidIdMD5Digest;
      paramContext = get(paramContext);
      if (!TextUtils.isEmpty(paramContext)) {
        androidIdMD5Digest = paramContext;
      }
    }
  }
  
  public static String get(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      paramString = null;
      String str;
      do
      {
        return paramString;
        paramString = com.tencent.ad.tangram.util.a.md5(paramString, "UTF-8");
        if (TextUtils.isEmpty(paramString)) {
          break;
        }
        str = paramString.toLowerCase();
        paramString = str;
      } while (!TextUtils.isEmpty(str));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.device.a
 * JD-Core Version:    0.7.0.1
 */