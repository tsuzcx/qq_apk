package com.tencent.ad.tangram.device;

import android.content.Context;
import android.support.annotation.Keep;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.ad.tangram.log.AdLog;

@Keep
public final class AdCarrier
{
  private static final String TAG = "AdCarrier";
  
  public static final String getCode(Context paramContext)
  {
    AdLog.i("AdCarrier", "getCode");
    if (paramContext == null) {
      return null;
    }
    paramContext = paramContext.getApplicationContext();
    if (paramContext == null) {
      return null;
    }
    try
    {
      paramContext = paramContext.getSystemService("phone");
      if (!(paramContext instanceof TelephonyManager)) {
        return null;
      }
      paramContext = (TelephonyManager)TelephonyManager.class.cast(paramContext);
      if (paramContext == null) {
        return null;
      }
      if (paramContext.getSimState() == 5) {
        return paramContext.getSimOperator();
      }
      AdLog.i("AdCarrier", "getCode error");
      return null;
    }
    catch (Throwable paramContext)
    {
      AdLog.i("AdCarrier", "getCode", paramContext);
    }
    return null;
  }
  
  public static final int getType(Context paramContext)
  {
    paramContext = getCode(paramContext);
    boolean bool = TextUtils.isEmpty(paramContext);
    int i = 0;
    if (bool) {
      return 0;
    }
    if ((!paramContext.startsWith("46000")) && (!paramContext.startsWith("46002")) && (!paramContext.startsWith("46007")) && (!paramContext.startsWith("46008")))
    {
      if ((!paramContext.startsWith("46001")) && (!paramContext.startsWith("46006")) && (!paramContext.startsWith("46009")))
      {
        if ((paramContext.startsWith("46003")) || (paramContext.startsWith("46005")) || (paramContext.startsWith("46011"))) {
          return 3;
        }
      }
      else {
        return 2;
      }
    }
    else {
      i = 1;
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.device.AdCarrier
 * JD-Core Version:    0.7.0.1
 */