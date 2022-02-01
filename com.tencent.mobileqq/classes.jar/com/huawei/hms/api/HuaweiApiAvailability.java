package com.huawei.hms.api;

import android.app.Activity;
import android.app.Dialog;
import android.app.Fragment;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.api.HuaweiApiCallable;
import java.util.HashMap;
import java.util.Map;

public abstract class HuaweiApiAvailability
{
  public static final String ACTIVITY_NAME = "com.huawei.hms.core.activity.JumpActivity";
  public static final String APPID_HMS = "C10132067";
  public static final String APPID_HMS_TV = "C100636709";
  public static final String HMS_API_NAME_GAME = "HuaweiGame.API";
  public static final String HMS_API_NAME_IAP = "HuaweiIap.API";
  public static final String HMS_API_NAME_ID = "HuaweiID.API";
  public static final String HMS_API_NAME_OD = "HuaweiOpenDevice.API";
  public static final String HMS_API_NAME_PAY = "HuaweiPay.API";
  public static final String HMS_API_NAME_PPS = "HuaweiPPSkit.API";
  public static final String HMS_API_NAME_PUSH = "HuaweiPush.API";
  public static final String HMS_API_NAME_SNS = "HuaweiSns.API";
  public static final int HMS_JSON_VERSION_MIN = 30000000;
  public static final int HMS_SDK_VERSION_CODE = 50000301;
  public static final String HMS_SDK_VERSION_NAME = "5.0.0.301";
  public static final int HMS_VERSION_CODE_GAME = 20503000;
  public static final int HMS_VERSION_CODE_IAP = 20700300;
  public static final int HMS_VERSION_CODE_ID = 30000000;
  public static final int HMS_VERSION_CODE_MIN = 20503000;
  public static final int HMS_VERSION_CODE_OD = 20601000;
  public static final int HMS_VERSION_CODE_PAY = 20503000;
  public static final int HMS_VERSION_CODE_PPS = 20700300;
  public static final int HMS_VERSION_CODE_PUSH = 20503000;
  public static final int HMS_VERSION_CODE_SNS = 20503000;
  public static final int HMS_VERSION_MAX = 20600000;
  public static final int HMS_VERSION_MIN = 20503000;
  public static final int NOTICE_VERSION_CODE = 20600000;
  public static final String SERVICES_ACTION = "com.huawei.hms.core.aidlservice";
  @Deprecated
  public static final String SERVICES_PACKAGE = "com.huawei.hwid";
  @Deprecated
  public static final String SERVICES_PACKAGE_TV = "com.huawei.hwid.tv";
  @Deprecated
  public static final String SERVICES_SIGNATURE = "B92825C2BD5D6D6D1E7F39EECD17843B7D9016F611136B75441BC6F4D3F00F05";
  @Deprecated
  public static final String SERVICES_SIGNATURE_CAR = "3517262215D8D3008CBF888750B6418EDC4D562AC33ED6874E0D73ABA667BC3C";
  @Deprecated
  public static final String SERVICES_SIGNATURE_TV = "3517262215D8D3008CBF888750B6418EDC4D562AC33ED6874E0D73ABA667BC3C";
  public static int SERVICES_VERSION_CODE = 30000100;
  private static final Map<String, Integer> a = new HashMap();
  
  static
  {
    a.put("HuaweiID.API", Integer.valueOf(30000000));
    a.put("HuaweiSns.API", Integer.valueOf(20503000));
    a.put("HuaweiPay.API", Integer.valueOf(20503000));
    a.put("HuaweiPush.API", Integer.valueOf(20503000));
    a.put("HuaweiGame.API", Integer.valueOf(20503000));
    a.put("HuaweiOpenDevice.API", Integer.valueOf(20601000));
    a.put("HuaweiIap.API", Integer.valueOf(20700300));
    a.put("HuaweiPPSkit.API", Integer.valueOf(20700300));
  }
  
  public static Map<String, Integer> getApiMap()
  {
    return a;
  }
  
  public static HuaweiApiAvailability getInstance()
  {
    return b.a();
  }
  
  public static int getServicesVersionCode()
  {
    return SERVICES_VERSION_CODE;
  }
  
  public static void setServicesVersionCode(int paramInt)
  {
    SERVICES_VERSION_CODE = paramInt;
  }
  
  public abstract Task<Void> checkApiAccessible(HuaweiApi<?> paramHuaweiApi, HuaweiApi<?>... paramVarArgs);
  
  public abstract Task<Void> checkApiAccessible(HuaweiApiCallable paramHuaweiApiCallable, HuaweiApiCallable... paramVarArgs);
  
  public abstract PendingIntent getErrPendingIntent(Context paramContext, int paramInt1, int paramInt2);
  
  public abstract PendingIntent getErrPendingIntent(Context paramContext, ConnectionResult paramConnectionResult);
  
  public abstract Dialog getErrorDialog(Activity paramActivity, int paramInt1, int paramInt2);
  
  public abstract Dialog getErrorDialog(Activity paramActivity, int paramInt1, int paramInt2, DialogInterface.OnCancelListener paramOnCancelListener);
  
  public abstract String getErrorString(int paramInt);
  
  public abstract Task<Void> getHuaweiServicesReady(Activity paramActivity);
  
  public abstract Intent getResolveErrorIntent(Activity paramActivity, int paramInt);
  
  public abstract PendingIntent getResolveErrorPendingIntent(Activity paramActivity, int paramInt);
  
  public abstract int isHuaweiMobileNoticeAvailable(Context paramContext);
  
  public abstract int isHuaweiMobileServicesAvailable(Context paramContext);
  
  public abstract int isHuaweiMobileServicesAvailable(Context paramContext, int paramInt);
  
  public abstract boolean isUserResolvableError(int paramInt);
  
  public abstract boolean isUserResolvableError(int paramInt, PendingIntent paramPendingIntent);
  
  public abstract void popupErrNotification(Context paramContext, ConnectionResult paramConnectionResult);
  
  public abstract void resolveError(Activity paramActivity, int paramInt1, int paramInt2);
  
  public abstract void resolveError(Activity paramActivity, int paramInt1, int paramInt2, PendingIntent paramPendingIntent);
  
  public abstract boolean showErrorDialogFragment(Activity paramActivity, int paramInt1, int paramInt2);
  
  public abstract boolean showErrorDialogFragment(Activity paramActivity, int paramInt1, int paramInt2, DialogInterface.OnCancelListener paramOnCancelListener);
  
  public abstract boolean showErrorDialogFragment(Activity paramActivity, int paramInt1, Fragment paramFragment, int paramInt2, DialogInterface.OnCancelListener paramOnCancelListener);
  
  public abstract void showErrorNotification(Context paramContext, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.api.HuaweiApiAvailability
 * JD-Core Version:    0.7.0.1
 */