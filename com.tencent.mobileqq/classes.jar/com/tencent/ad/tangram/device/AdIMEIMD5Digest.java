package com.tencent.ad.tangram.device;

import android.content.Context;
import android.support.annotation.Keep;
import android.text.TextUtils;

@Keep
public class AdIMEIMD5Digest
{
  private static final String TAG = "AdIMEIMD5Digest";
  
  public static String get(Context paramContext)
  {
    paramContext = AdImei.getIMEI();
    if (TextUtils.isEmpty(paramContext)) {}
    do
    {
      return null;
      paramContext = AdDeviceIdMD5Digest.get(paramContext);
    } while (TextUtils.isEmpty(paramContext));
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.device.AdIMEIMD5Digest
 * JD-Core Version:    0.7.0.1
 */