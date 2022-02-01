package com.huawei.hiar;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import com.huawei.hiar.annotations.UsedByReflection;
import com.huawei.hiar.exceptions.ARFatalException;
import com.huawei.hiar.exceptions.ARUnavailableConnectServerTimeOutException;
import com.huawei.hiar.exceptions.ARUnavailableDeviceNotCompatibleException;
import com.huawei.hiar.exceptions.ARUnavailableEmuiNotCompatibleException;
import com.huawei.hiar.exceptions.ARUnavailableUserDeclinedInstallationException;

public class j
  extends HuaweiArApkBase
{
  private static int f = 0;
  private static final String g = j.class.getSimpleName();
  private static final j h = new j();
  boolean a;
  RuntimeException b;
  private boolean c;
  private k d;
  private HuaweiArApkBase.ARAvailability e;
  private long i;
  private int j;
  
  public static j b()
  {
    return h;
  }
  
  @UsedByReflection("")
  public static void jumpToAppMarket(Context paramContext)
  {
    if (b().b != null)
    {
      if ((b().b instanceof ARUnavailableUserDeclinedInstallationException))
      {
        Log.w(g, "UserDeclinedInstallation!");
        return;
      }
      Log.d(g, "installFailure != null");
    }
    Log.d(g, "jumpToAppMarket");
    paramContext.startActivity(new Intent(paramContext, LoaderActivity.class).putExtra("message", HuaweiArApkBase.ARAvailability.SUPPORTED_APK_TOO_OLD.nativeCode).putExtra("userexception", new ARUnavailableUserDeclinedInstallationException()).putExtra("implActivityName", "com.huawei.hiar.InformActivityImpl"));
  }
  
  public HuaweiArApkBase.ARAvailability a(Context paramContext)
  {
    if (c(paramContext)) {
      return HuaweiArApkBase.ARAvailability.SUPPORTED_INSTALLED;
    }
    try
    {
      if (((this.e == null) || (this.e.isUnknown())) && (!this.c))
      {
        this.c = true;
        a(paramContext, new j.1(this));
      }
      if (this.e != null) {
        return this.e;
      }
    }
    finally {}
    if (this.c) {
      return HuaweiArApkBase.ARAvailability.UNKNOWN_CHECKING;
    }
    Log.e(g, "checkAvailability: request run but result is null");
    return HuaweiArApkBase.ARAvailability.UNKNOWN_ERROR;
  }
  
  public HuaweiArApkBase.ARInstallStatus a(Activity paramActivity, boolean paramBoolean)
  {
    f = 0;
    Log.d(g, "requestInstall: ");
    ARUnavailableEmuiNotCompatibleException localARUnavailableEmuiNotCompatibleException = new ARUnavailableEmuiNotCompatibleException();
    ARUnavailableDeviceNotCompatibleException localARUnavailableDeviceNotCompatibleException = new ARUnavailableDeviceNotCompatibleException();
    ARUnavailableUserDeclinedInstallationException localARUnavailableUserDeclinedInstallationException = new ARUnavailableUserDeclinedInstallationException();
    ARUnavailableConnectServerTimeOutException localARUnavailableConnectServerTimeOutException = new ARUnavailableConnectServerTimeOutException();
    if (c(paramActivity))
    {
      this.a = false;
      return HuaweiArApkBase.ARInstallStatus.INSTALLED;
    }
    if (this.b != null)
    {
      if (paramBoolean)
      {
        Log.d(g, "Clearing previous failure: ", this.b);
        this.b = null;
      }
    }
    else
    {
      if (!this.a) {
        break label145;
      }
      return HuaweiArApkBase.ARInstallStatus.INSTALL_REQUESTED;
    }
    Log.d(g, "requestInstall: throw this.installFailure=" + this.b);
    this.a = false;
    throw this.b;
    label145:
    long l = SystemClock.uptimeMillis();
    if (l - this.i > 5000L) {
      this.j = 0;
    }
    this.j += 1;
    this.i = l;
    if (this.j > 2) {
      throw new ARFatalException("Requesting AREngine installation too rapidly.");
    }
    a(paramActivity, localARUnavailableEmuiNotCompatibleException, localARUnavailableDeviceNotCompatibleException, localARUnavailableUserDeclinedInstallationException, localARUnavailableConnectServerTimeOutException);
    this.a = true;
    Log.d(g, "requestInstall: return ARInstallStatus.INSTALL_REQUESTED");
    return HuaweiArApkBase.ARInstallStatus.INSTALL_REQUESTED;
  }
  
  public void a(Activity paramActivity, ARUnavailableEmuiNotCompatibleException paramARUnavailableEmuiNotCompatibleException, ARUnavailableDeviceNotCompatibleException paramARUnavailableDeviceNotCompatibleException, ARUnavailableUserDeclinedInstallationException paramARUnavailableUserDeclinedInstallationException, ARUnavailableConnectServerTimeOutException paramARUnavailableConnectServerTimeOutException)
  {
    HuaweiArApkBase.ARAvailability localARAvailability = b().a(paramActivity);
    Log.d(g, "runcheckAvailability: availability=" + localARAvailability);
    if (localARAvailability.isTransient()) {
      new Handler().postDelayed(new j.2(this, paramActivity, paramARUnavailableEmuiNotCompatibleException, paramARUnavailableDeviceNotCompatibleException, paramARUnavailableUserDeclinedInstallationException, paramARUnavailableConnectServerTimeOutException), 500L);
    }
    if ((!localARAvailability.isTransient()) && (f == 0))
    {
      f += 1;
      paramActivity.startActivity(new Intent(paramActivity, LoaderActivity.class).putExtra("message", localARAvailability.nativeCode).putExtra("userexception", paramARUnavailableUserDeclinedInstallationException).putExtra("emuiexception", paramARUnavailableEmuiNotCompatibleException).putExtra("deviceexception", paramARUnavailableDeviceNotCompatibleException).putExtra("timeoutexception", paramARUnavailableConnectServerTimeOutException).putExtra("implActivityName", "com.huawei.hiar.InformActivityImpl"));
    }
  }
  
  public void a(Context paramContext, HuaweiArApkBase.ICheckAvailabilityCallback paramICheckAvailabilityCallback)
  {
    if (c(paramContext)) {
      paramICheckAvailabilityCallback.onResult(HuaweiArApkBase.ARAvailability.SUPPORTED_INSTALLED);
    }
    b(paramContext).a(paramContext, paramICheckAvailabilityCallback);
  }
  
  public boolean a(String paramString)
  {
    String str = m.a("ro.build.date.utc", "");
    if (str == null) {
      Log.w(g, "emuiVersionSupported: system prop ro.build.date.utc is lost");
    }
    while (Long.valueOf(paramString).longValue() > Long.valueOf(str).longValue()) {
      return false;
    }
    return true;
  }
  
  k b(Context paramContext)
  {
    try
    {
      if (this.d == null) {
        this.d = k.a(paramContext);
      }
      paramContext = this.d;
      return paramContext;
    }
    finally {}
  }
  
  public boolean c(Context paramContext)
  {
    return e(paramContext) >= 49;
  }
  
  public boolean d(Context paramContext)
  {
    return e(paramContext) != -1;
  }
  
  int e(Context paramContext)
  {
    try
    {
      int k = paramContext.getPackageManager().getPackageInfo("com.huawei.arengine.service", 0).versionCode;
      Log.i(g, "Android version:" + k);
      return k;
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hiar.j
 * JD-Core Version:    0.7.0.1
 */