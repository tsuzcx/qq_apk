package com.tencent.ad.tangram.device;

import android.content.Context;
import android.support.annotation.Keep;
import android.text.TextUtils;
import com.tencent.ad.tangram.util.a;

@Keep
public final class AdMacAddressMD5Digest
{
  private static String macAddressMD5Digest;
  
  public static String get(Context paramContext)
  {
    if (!TextUtils.isEmpty(macAddressMD5Digest)) {
      return macAddressMD5Digest;
    }
    paramContext = c.get(paramContext);
    if (TextUtils.isEmpty(paramContext)) {}
    for (;;)
    {
      return macAddressMD5Digest;
      paramContext = get(paramContext);
      if (!TextUtils.isEmpty(paramContext)) {
        macAddressMD5Digest = paramContext;
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
        paramString = paramString.replaceAll(":", "");
        if (TextUtils.isEmpty(paramString)) {
          break;
        }
        paramString = paramString.toUpperCase();
        if (TextUtils.isEmpty(paramString)) {
          break;
        }
        paramString = a.md5(paramString, "UTF-8");
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
 * Qualified Name:     com.tencent.ad.tangram.device.AdMacAddressMD5Digest
 * JD-Core Version:    0.7.0.1
 */