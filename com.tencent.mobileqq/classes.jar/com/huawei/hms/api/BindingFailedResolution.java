package com.huawei.hms.api;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.view.KeyEvent;
import com.huawei.hms.activity.IBridgeActivityDelegate;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.Util;

public class BindingFailedResolution
  implements ServiceConnection, IBridgeActivityDelegate
{
  private static final Object a = new Object();
  private Activity b;
  private boolean c = true;
  private BindingFailedResolution.a d;
  private Handler e = null;
  private Handler f = null;
  
  private void a()
  {
    if (this.f != null) {
      this.f.removeMessages(3);
    }
    for (;;)
    {
      this.f.sendEmptyMessageDelayed(3, 2000L);
      return;
      this.f = new Handler(Looper.getMainLooper(), new BindingFailedResolution.1(this));
    }
  }
  
  private void a(int paramInt)
  {
    Activity localActivity = getActivity();
    if ((localActivity == null) || (localActivity.isFinishing())) {
      return;
    }
    HMSLog.i("BindingFailedResolution", "finishBridgeActivity：" + paramInt);
    Intent localIntent = new Intent();
    localIntent.putExtra("intent.extra.RESULT", paramInt);
    localActivity.setResult(-1, localIntent);
    localActivity.finish();
  }
  
  private void a(Activity paramActivity)
  {
    Intent localIntent = new Intent();
    localIntent.setClassName(HMSPackageManager.getInstance(paramActivity.getApplicationContext()).getHMSPackageName(), "com.huawei.hms.core.activity.JumpActivity");
    HMSLog.i("BindingFailedResolution", "onBridgeActivityCreate：try to start HMS");
    try
    {
      paramActivity.startActivityForResult(localIntent, getRequestCode());
      return;
    }
    catch (Throwable paramActivity)
    {
      HMSLog.e("BindingFailedResolution", "ActivityNotFoundException：" + paramActivity.getMessage());
      if (this.f != null)
      {
        this.f.removeMessages(3);
        this.f = null;
      }
      b();
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.c)
    {
      this.c = false;
      onStartResult(paramBoolean);
    }
  }
  
  private void b()
  {
    Activity localActivity = getActivity();
    if (localActivity == null)
    {
      HMSLog.e("BindingFailedResolution", "In connect, bind core try fail");
      a(false);
      return;
    }
    Intent localIntent = new Intent("com.huawei.hms.core.aidlservice");
    localIntent.setPackage(HMSPackageManager.getInstance(localActivity.getApplicationContext()).getHMSPackageName());
    synchronized (a)
    {
      if (localActivity.bindService(localIntent, this, 1))
      {
        c();
        return;
      }
    }
    HMSLog.e("BindingFailedResolution", "In connect, bind core try fail");
    a(false);
  }
  
  private void c()
  {
    if (this.e != null) {
      this.e.removeMessages(2);
    }
    for (;;)
    {
      this.e.sendEmptyMessageDelayed(2, 5000L);
      return;
      this.e = new Handler(Looper.getMainLooper(), new BindingFailedResolution.2(this));
    }
  }
  
  private void d()
  {
    synchronized (a)
    {
      if (this.e != null)
      {
        this.e.removeMessages(2);
        this.e = null;
      }
      return;
    }
  }
  
  private void e()
  {
    Activity localActivity = getActivity();
    if ((localActivity == null) || (localActivity.isFinishing())) {
      return;
    }
    if (this.d == null) {
      this.d = new BindingFailedResolution.a(null);
    }
    for (;;)
    {
      HMSLog.e("BindingFailedResolution", "showPromptdlg to resolve conn error");
      this.d.show(localActivity, new BindingFailedResolution.3(this));
      return;
      this.d.dismiss();
    }
  }
  
  protected Activity getActivity()
  {
    return this.b;
  }
  
  public int getRequestCode()
  {
    return 2003;
  }
  
  public void onBridgeActivityCreate(Activity paramActivity)
  {
    this.b = paramActivity;
    a.a.a(this.b);
    a();
    a(paramActivity);
  }
  
  public void onBridgeActivityDestroy()
  {
    d();
    a.a.b(this.b);
    this.b = null;
  }
  
  public boolean onBridgeActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 != getRequestCode()) {
      return false;
    }
    HMSLog.i("BindingFailedResolution", "onBridgeActivityResult");
    if (this.f != null)
    {
      this.f.removeMessages(3);
      this.f = null;
    }
    b();
    return true;
  }
  
  public void onBridgeConfigurationChanged()
  {
    if (this.d == null) {
      return;
    }
    HMSLog.i("BindingFailedResolution", "re show prompt dialog");
    e();
  }
  
  public void onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    HMSLog.i("BindingFailedResolution", "On key up when resolve conn error");
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    d();
    a(true);
    paramComponentName = getActivity();
    if (paramComponentName == null) {
      return;
    }
    Util.unBindServiceCatchException(paramComponentName, this);
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName) {}
  
  protected void onStartResult(boolean paramBoolean)
  {
    if (getActivity() == null) {
      return;
    }
    if (paramBoolean)
    {
      a(0);
      return;
    }
    e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hms.api.BindingFailedResolution
 * JD-Core Version:    0.7.0.1
 */