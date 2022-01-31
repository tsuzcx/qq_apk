package com.tencent.ad.tangram.device;

import android.content.Context;
import android.support.annotation.Keep;
import android.text.TextUtils;
import com.tencent.ad.tangram.util.a;

@Keep
public final class AdDeviceIdMD5Digest
{
  private static final String TAG = "AdDeviceIdMD5Digest";
  private static String deviceIdMD5Digest;
  
  public static String get(Context paramContext)
  {
    if (!TextUtils.isEmpty(deviceIdMD5Digest)) {
      return deviceIdMD5Digest;
    }
    paramContext = b.getDeviceId(paramContext);
    if (TextUtils.isEmpty(paramContext)) {}
    for (;;)
    {
      return deviceIdMD5Digest;
      paramContext = get(paramContext);
      if (!TextUtils.isEmpty(paramContext)) {
        deviceIdMD5Digest = paramContext;
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
        paramString = paramString.toLowerCase();
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
 * Qualified Name:     com.tencent.ad.tangram.device.AdDeviceIdMD5Digest
 * JD-Core Version:    0.7.0.1
 */