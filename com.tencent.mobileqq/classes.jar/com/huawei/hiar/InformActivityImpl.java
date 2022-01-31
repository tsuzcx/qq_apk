package com.huawei.hiar;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.huawei.hiar.exceptions.ARUnavailableConnectServerTimeOutException;
import com.huawei.hiar.exceptions.ARUnavailableDeviceNotCompatibleException;
import com.huawei.hiar.exceptions.ARUnavailableEmuiNotCompatibleException;
import com.huawei.hiar.exceptions.ARUnavailableUserDeclinedInstallationException;

public class InformActivityImpl
{
  private static final String ACTION_HUAWEI_DOWNLOAD_QUIK = "com.huawei.appmarket.intent.action.AppDetail";
  private static final String HUAWEI_MARTKET_NAME = "com.huawei.appmarket";
  private static final String PACKAGENAME_QUIK = "com.huawei.arengine.service";
  private static final String PACKAGE_NAME_KEY = "APP_PACKAGENAME";
  static final String TAG = InformActivityImpl.class.getSimpleName();
  ARUnavailableDeviceNotCompatibleException deviceFatal;
  ARUnavailableEmuiNotCompatibleException emuiFatal;
  private HuaweiArApkBase.ARAvailability mAvailability;
  private Activity otherActivity;
  ARUnavailableConnectServerTimeOutException timeoutFatal;
  ARUnavailableUserDeclinedInstallationException userFatal;
  
  private static void downloadARServiceApp(Activity paramActivity)
  {
    Intent localIntent = new Intent("com.huawei.appmarket.intent.action.AppDetail");
    localIntent.putExtra("APP_PACKAGENAME", "com.huawei.arengine.service");
    localIntent.setPackage("com.huawei.appmarket");
    localIntent.setFlags(268435456);
    if ((paramActivity == null) || (localIntent == null)) {
      return;
    }
    try
    {
      paramActivity.startActivity(localIntent);
      return;
    }
    catch (SecurityException paramActivity)
    {
      Log.w(TAG, "the target app has no permission of media");
      return;
    }
    catch (ActivityNotFoundException paramActivity)
    {
      Log.w(TAG, "the target activity is not found: " + paramActivity.getMessage());
      return;
    }
    catch (Exception paramActivity)
    {
      Log.w(TAG, "start activity failed, message: " + paramActivity.getMessage());
    }
  }
  
  private void handlePart()
  {
    if (this.mAvailability.isUnsupported())
    {
      Log.d(TAG, "runcheckAvailability: availability.isUnSupported()");
      if (this.mAvailability == HuaweiArApkBase.ARAvailability.UNSUPPORTED_DEVICE_NOT_CAPABLE)
      {
        Log.d(TAG, "showEducationDialog: throw new ARUnavailableDeviceNotCompatibleException()");
        j.b().b = this.deviceFatal;
        finish();
      }
    }
    else
    {
      return;
    }
    Log.d(TAG, "showEducationDialog: throw new ARUnavailableEmuiNotCompatibleException();");
    j.b().b = this.emuiFatal;
    finish();
  }
  
  private void showEducationDialog()
  {
    Log.d(TAG, "showEducationDialog: ");
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(this.otherActivity);
    if (this.mAvailability.isSupported())
    {
      Log.d(TAG, "runcheckAvailability: availability.isSupported()");
      localBuilder.setMessage(R.string.__arengine_install_app);
      localBuilder.setNegativeButton(R.string.__arengine_cancel, new InformActivityImpl.1(this));
      localBuilder.setPositiveButton(R.string.__arengine_install, new InformActivityImpl.2(this));
      localBuilder.show();
    }
    if (this.mAvailability.isUnknown())
    {
      Log.d(TAG, "runcheckAvailability: availability.isUnknown()");
      if (this.mAvailability != HuaweiArApkBase.ARAvailability.UNKNOWN_ERROR) {
        break label144;
      }
      localBuilder.setMessage(R.string.__arengine_unknow_error);
    }
    for (;;)
    {
      localBuilder.setPositiveButton(R.string.__arengine_set_wireless, new InformActivityImpl.3(this));
      localBuilder.show();
      return;
      label144:
      localBuilder.setMessage(R.string.__arengine_unknow_timeout);
    }
  }
  
  public void finish()
  {
    Log.d(TAG, "finish: ");
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    Log.d(TAG, "InformActivity onCreate");
    if (this.otherActivity == null)
    {
      Log.e(TAG, "InformActivity otherActivity is null");
      return;
    }
    if (this.otherActivity.getIntent() == null)
    {
      Log.e(TAG, "InformActivity intent is null");
      return;
    }
    this.mAvailability = HuaweiArApkBase.ARAvailability.forNumber(((Integer)this.otherActivity.getIntent().getSerializableExtra("message")).intValue());
    this.userFatal = ((ARUnavailableUserDeclinedInstallationException)this.otherActivity.getIntent().getSerializableExtra("userexception"));
    this.emuiFatal = ((ARUnavailableEmuiNotCompatibleException)this.otherActivity.getIntent().getSerializableExtra("emuiexception"));
    this.deviceFatal = ((ARUnavailableDeviceNotCompatibleException)this.otherActivity.getIntent().getSerializableExtra("deviceexception"));
    this.timeoutFatal = ((ARUnavailableConnectServerTimeOutException)this.otherActivity.getIntent().getSerializableExtra("timeoutexception"));
    Log.d(TAG, "onCreate: mAvailability=" + this.mAvailability);
    this.otherActivity.setFinishOnTouchOutside(false);
    handlePart();
    showEducationDialog();
    j.b().b = this.userFatal;
  }
  
  protected void onDestroy()
  {
    Log.d(TAG, "onDestroy: ");
  }
  
  protected void onPause()
  {
    Log.d(TAG, "onPause: ");
  }
  
  protected void onResume()
  {
    Log.d(TAG, "onResume: ");
  }
  
  protected void onStart()
  {
    Log.d(TAG, "onStart: ");
  }
  
  protected void onStop()
  {
    Log.d(TAG, "onStop: ");
  }
  
  protected void setActivity(Activity paramActivity)
  {
    Log.d(TAG, "setActivity..." + paramActivity);
    this.otherActivity = paramActivity;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.huawei.hiar.InformActivityImpl
 * JD-Core Version:    0.7.0.1
 */