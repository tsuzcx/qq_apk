package com.tencent.ad.tangram.net;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.Keep;
import android.telephony.TelephonyManager;
import com.tencent.ad.tangram.log.AdLog;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@Keep
public final class AdNet
{
  private static final String TAG = "AdNet";
  
  public static int getType(Context paramContext)
  {
    if (paramContext == null) {
      return 0;
    }
    paramContext = paramContext.getApplicationContext();
    if (paramContext == null) {
      return 0;
    }
    try
    {
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (paramContext == null) {
        return 0;
      }
      Object localObject3 = paramContext.getActiveNetworkInfo();
      if (localObject3 == null) {
        return 0;
      }
      switch (((NetworkInfo)localObject3).getType())
      {
      case 0: 
      case 2: 
      case 3: 
      case 4: 
      case 5: 
        paramContext = TelephonyManager.class.getDeclaredField("NETWORK_CLASS_2_G").get(TelephonyManager.class);
        Object localObject1 = TelephonyManager.class.getDeclaredField("NETWORK_CLASS_3_G").get(TelephonyManager.class);
        Object localObject2 = TelephonyManager.class.getDeclaredField("NETWORK_CLASS_4_G").get(TelephonyManager.class);
        localObject3 = TelephonyManager.class.getDeclaredMethod("getNetworkClass", new Class[] { Integer.TYPE }).invoke(TelephonyManager.class, new Object[] { Integer.valueOf(((NetworkInfo)localObject3).getSubtype()) });
        if (localObject3.equals(paramContext)) {
          return 2;
        }
        if (localObject3.equals(localObject1)) {
          return 3;
        }
        boolean bool = localObject3.equals(localObject2);
        if (bool) {
          return 4;
        }
        return 0;
      }
    }
    catch (Throwable paramContext)
    {
      AdLog.e("AdNet", "getType", paramContext);
      return 0;
    }
    return 0;
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.net.AdNet
 * JD-Core Version:    0.7.0.1
 */