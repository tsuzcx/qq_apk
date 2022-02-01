package com.tencent.ad.tangram.device;

import android.content.Context;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.util.e;

final class o
{
  private static final String TAG = "AdSIMCard";
  private static String subscriberId;
  
  public static String getSubscriberId(Context paramContext, boolean paramBoolean)
  {
    if (!TextUtils.isEmpty(subscriberId)) {
      return subscriberId;
    }
    if (((!paramBoolean) || (e.checkPermission(paramContext, "android.permission.READ_PHONE_STATE"))) && (Build.VERSION.SDK_INT < 29) && (paramContext != null))
    {
      paramContext = paramContext.getApplicationContext();
      if (paramContext != null) {
        try
        {
          paramContext = paramContext.getSystemService("phone");
          if ((paramContext instanceof TelephonyManager))
          {
            paramContext = (TelephonyManager)TelephonyManager.class.cast(paramContext);
            if (paramContext != null)
            {
              paramContext = paramContext.getSubscriberId();
              if (!TextUtils.isEmpty(paramContext)) {
                subscriberId = paramContext;
              }
            }
          }
        }
        catch (Throwable paramContext)
        {
          AdLog.i("AdSIMCard", "getSubscriberId", paramContext);
        }
      }
    }
    return subscriberId;
  }
  
  public static String getSubscriberIdCache(Context paramContext)
  {
    return subscriberId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.device.o
 * JD-Core Version:    0.7.0.1
 */