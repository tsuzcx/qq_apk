package com.tencent.mobileqq.armap;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.ar.ARNativeBridge;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;
import mqq.app.AppRuntime;

public class ARMapBaseActivity
  extends FragmentActivity
{
  public static final String TAG = "ARMapBaseActivity";
  protected static boolean sIsLoadSoSuc;
  public ArMapInterface app;
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    boolean bool = super.doOnCreate(paramBundle);
    if (QLog.isColorLevel()) {
      QLog.i("ARMapBaseActivity", 2, "sIsLoadSoSuc: " + sIsLoadSoSuc);
    }
    if (!sIsLoadSoSuc) {
      loadSo();
    }
    return bool;
  }
  
  protected String getModuleId()
  {
    return "module_armap";
  }
  
  protected void loadSo()
  {
    sIsLoadSoSuc = ARNativeBridge.loadNativeLibrary();
    QLog.d("ARMapBaseActivity", 1, String.format(Locale.getDefault(), "ARMapBaseActivity innerSo: %b  isSoLoadSuc: %b", new Object[] { Boolean.valueOf(false), Boolean.valueOf(sIsLoadSoSuc) }));
    if (!sIsLoadSoSuc) {}
  }
  
  protected void onAccountChanged()
  {
    super.onAccountChanged();
    if (QLog.isDevelopLevel()) {
      QLog.i("ARMapBaseActivity", 4, "onAccountChanged");
    }
  }
  
  public void updateAppRuntime()
  {
    super.updateAppRuntime();
    AppRuntime localAppRuntime = getAppRuntime();
    if ((localAppRuntime instanceof ArMapInterface)) {
      this.app = ((ArMapInterface)localAppRuntime);
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("ARMapBaseActivity", 4, "updateAppRuntime, " + localAppRuntime);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.ARMapBaseActivity
 * JD-Core Version:    0.7.0.1
 */