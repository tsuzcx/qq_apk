package com.huawei.hms.api;

import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.os.Build.VERSION;
import com.huawei.hms.support.common.ActivityMgr;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.Checker;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.PackageManagerHelper;
import com.huawei.hms.utils.PackageManagerHelper.PackageStates;

public abstract class HuaweiMobileServicesUtil
{
  public static final String HMS_ERROR_DIALOG = "HuaweiMobileServicesErrorDialog";
  
  public static Dialog getErrorDialog(int paramInt1, Activity paramActivity, int paramInt2)
  {
    return HuaweiApiAvailability.getInstance().getErrorDialog(paramActivity, paramInt1, paramInt2, null);
  }
  
  public static Dialog getErrorDialog(int paramInt1, Activity paramActivity, int paramInt2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    return HuaweiApiAvailability.getInstance().getErrorDialog(paramActivity, paramInt1, paramInt2, paramOnCancelListener);
  }
  
  public static String getErrorString(int paramInt)
  {
    return HuaweiApiAvailability.getInstance().getErrorString(paramInt);
  }
  
  @Deprecated
  public static String getOpenSourceSoftwareLicenseInfo(Context paramContext)
  {
    return "";
  }
  
  public static Context getRemoteContext(Context paramContext)
  {
    try
    {
      paramContext = paramContext.createPackageContext(HMSPackageManager.getInstance(paramContext).getHMSPackageName(), 2);
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      label15:
      break label15;
    }
    return null;
  }
  
  public static Resources getRemoteResource(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getResourcesForApplication(HMSPackageManager.getInstance(paramContext).getHMSPackageName());
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      label17:
      break label17;
    }
    return null;
  }
  
  public static int isHuaweiMobileServicesAvailable(Context paramContext)
  {
    return HuaweiApiAvailability.getInstance().isHuaweiMobileServicesAvailable(paramContext);
  }
  
  public static int isHuaweiMobileServicesAvailable(Context paramContext, int paramInt)
  {
    Checker.checkNonNull(paramContext, "context must not be null.");
    if (Build.VERSION.SDK_INT < 16) {
      return 21;
    }
    Object localObject1 = new PackageManagerHelper(paramContext);
    String str = HMSPackageManager.getInstance(paramContext).getHMSPackageName();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("hmsPackageName is ");
    ((StringBuilder)localObject2).append(str);
    HMSLog.i("HuaweiMobileServicesUtil", ((StringBuilder)localObject2).toString());
    localObject2 = ((PackageManagerHelper)localObject1).getPackageStates(str);
    if (PackageManagerHelper.PackageStates.NOT_INSTALLED.equals(localObject2))
    {
      HMSLog.i("HuaweiMobileServicesUtil", "HMS is not installed");
      return 1;
    }
    if (PackageManagerHelper.PackageStates.DISABLED.equals(localObject2))
    {
      HMSLog.i("HuaweiMobileServicesUtil", "HMS is disabled");
      return 3;
    }
    localObject2 = HMSPackageManager.getInstance(paramContext).getHMSPackageStates();
    if (PackageManagerHelper.PackageStates.NOT_INSTALLED.equals(localObject2))
    {
      localObject1 = ((PackageManagerHelper)localObject1).getPackageSignature(str);
      if ((!"B92825C2BD5D6D6D1E7F39EECD17843B7D9016F611136B75441BC6F4D3F00F05".equalsIgnoreCase((String)localObject1)) && (!"3517262215D8D3008CBF888750B6418EDC4D562AC33ED6874E0D73ABA667BC3C".equalsIgnoreCase((String)localObject1)) && (!"3517262215D8D3008CBF888750B6418EDC4D562AC33ED6874E0D73ABA667BC3C".equalsIgnoreCase((String)localObject1))) {
        return 9;
      }
    }
    int i = HMSPackageManager.getInstance(paramContext).getHmsVersionCode();
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("connect versionCode:");
    ((StringBuilder)localObject1).append(i);
    HMSLog.i("HuaweiMobileServicesUtil", ((StringBuilder)localObject1).toString());
    if (HMSPackageManager.getInstance(paramContext).isApkUpdateNecessary(paramInt))
    {
      HMSLog.i("HuaweiMobileServicesUtil", "The current version does not meet the minimum version requirements");
      return 2;
    }
    return 0;
  }
  
  public static boolean isUserRecoverableError(int paramInt)
  {
    return HuaweiApiAvailability.getInstance().isUserResolvableError(paramInt);
  }
  
  public static boolean popupErrDlgFragment(int paramInt1, Activity paramActivity, int paramInt2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    return HuaweiApiAvailability.getInstance().showErrorDialogFragment(paramActivity, paramInt1, paramInt2, paramOnCancelListener);
  }
  
  public static boolean popupErrDlgFragment(int paramInt1, Activity paramActivity, Fragment paramFragment, int paramInt2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    return HuaweiApiAvailability.getInstance().showErrorDialogFragment(paramActivity, paramInt1, paramFragment, paramInt2, paramOnCancelListener);
  }
  
  public static void setApplication(Application paramApplication)
  {
    ActivityMgr.INST.init(paramApplication);
  }
  
  public static boolean showErrorDialogFragment(int paramInt1, Activity paramActivity, int paramInt2)
  {
    return HuaweiApiAvailability.getInstance().showErrorDialogFragment(paramActivity, paramInt1, paramInt2, null);
  }
  
  public static void showErrorNotification(int paramInt, Context paramContext)
  {
    HuaweiApiAvailability.getInstance().showErrorNotification(paramContext, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.api.HuaweiMobileServicesUtil
 * JD-Core Version:    0.7.0.1
 */