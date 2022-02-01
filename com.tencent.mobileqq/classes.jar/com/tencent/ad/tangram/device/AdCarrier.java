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
    if (paramContext == null) {}
    do
    {
      do
      {
        return null;
        paramContext = paramContext.getApplicationContext();
      } while (paramContext == null);
      paramContext = paramContext.getSystemService("phone");
    } while (!(paramContext instanceof TelephonyManager));
    paramContext = (TelephonyManager)TelephonyManager.class.cast(paramContext);
    try
    {
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
    if (TextUtils.isEmpty(paramContext)) {}
    do
    {
      return 0;
      if ((paramContext.startsWith("46000")) || (paramContext.startsWith("46002")) || (paramContext.startsWith("46007")) || (paramContext.startsWith("46008"))) {
        return 1;
      }
      if ((paramContext.startsWith("46001")) || (paramContext.startsWith("46006")) || (paramContext.startsWith("46009"))) {
        return 2;
      }
    } while ((!paramContext.startsWith("46003")) && (!paramContext.startsWith("46005")) && (!paramContext.startsWith("46011")));
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ad.tangram.device.AdCarrier
 * JD-Core Version:    0.7.0.1
 */