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
import com.huawei.hms.common.internal.BindResolveClients;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.ui.AbstractPromptDialog;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.Util;

public class BindingFailedResolution
  implements ServiceConnection, IBridgeActivityDelegate
{
  private static final Object f = new Object();
  private Activity a;
  private boolean b = true;
  private BindingFailedResolution.d c;
  private Handler d = null;
  private Handler e = null;
  
  private void a()
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
    synchronized (f)
    {
      if (localActivity.bindService(localIntent, this, 1))
      {
        c();
        return;
      }
      HMSLog.e("BindingFailedResolution", "In connect, bind core try fail");
      a(false);
      return;
    }
  }
  
  private void a(int paramInt)
  {
    Activity localActivity = getActivity();
    if (localActivity != null)
    {
      if (localActivity.isFinishing()) {
        return;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("finishBridgeActivity：");
      ((StringBuilder)localObject).append(paramInt);
      HMSLog.i("BindingFailedResolution", ((StringBuilder)localObject).toString());
      localObject = new Intent();
      ((Intent)localObject).putExtra("intent.extra.RESULT", paramInt);
      localActivity.setResult(-1, (Intent)localObject);
      localActivity.finish();
    }
  }
  
  private void a(Activity paramActivity)
  {
    Object localObject = new Intent();
    ((Intent)localObject).setClassName(HMSPackageManager.getInstance(paramActivity.getApplicationContext()).getHMSPackageName(), "com.huawei.hms.core.activity.JumpActivity");
    HMSLog.i("BindingFailedResolution", "onBridgeActivityCreate：try to start HMS");
    try
    {
      paramActivity.startActivityForResult((Intent)localObject, getRequestCode());
      return;
    }
    finally
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("ActivityNotFoundException：");
      ((StringBuilder)localObject).append(paramActivity.getMessage());
      HMSLog.e("BindingFailedResolution", ((StringBuilder)localObject).toString());
      paramActivity = this.e;
      if (paramActivity != null)
      {
        paramActivity.removeMessages(3);
        this.e = null;
      }
      a();
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.b)
    {
      this.b = false;
      onStartResult(paramBoolean);
    }
  }
  
  private void b()
  {
    synchronized (f)
    {
      if (this.d != null)
      {
        this.d.removeMessages(2);
        this.d = null;
      }
      return;
    }
  }
  
  private void c()
  {
    Handler localHandler = this.d;
    if (localHandler != null) {
      localHandler.removeMessages(2);
    } else {
      this.d = new Handler(Looper.getMainLooper(), new BindingFailedResolution.b(this));
    }
    this.d.sendEmptyMessageDelayed(2, 5000L);
  }
  
  private void d()
  {
    Handler localHandler = this.e;
    if (localHandler != null) {
      localHandler.removeMessages(3);
    } else {
      this.e = new Handler(Looper.getMainLooper(), new BindingFailedResolution.a(this));
    }
    this.e.sendEmptyMessageDelayed(3, 4000L);
  }
  
  private void e()
  {
    Activity localActivity = getActivity();
    if (localActivity != null)
    {
      if (localActivity.isFinishing()) {
        return;
      }
      BindingFailedResolution.d locald = this.c;
      if (locald == null) {
        this.c = new BindingFailedResolution.d(null);
      } else {
        locald.dismiss();
      }
      HMSLog.i("BindingFailedResolution", "showPromptdlg to resolve conn error");
      this.c.show(localActivity, new BindingFailedResolution.c(this));
    }
  }
  
  protected Activity getActivity()
  {
    return this.a;
  }
  
  public int getRequestCode()
  {
    return 2003;
  }
  
  public void onBridgeActivityCreate(Activity paramActivity)
  {
    this.a = paramActivity;
    a.b.a(this.a);
    d();
    a(paramActivity);
  }
  
  public void onBridgeActivityDestroy()
  {
    b();
    a.b.b(this.a);
    this.a = null;
  }
  
  public boolean onBridgeActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 != getRequestCode()) {
      return false;
    }
    HMSLog.i("BindingFailedResolution", "onBridgeActivityResult");
    paramIntent = this.e;
    if (paramIntent != null)
    {
      paramIntent.removeMessages(3);
      this.e = null;
    }
    a();
    return true;
  }
  
  public void onBridgeConfigurationChanged()
  {
    if (this.c == null) {
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
    b();
    a(true);
    paramComponentName = getActivity();
    if (paramComponentName == null) {
      return;
    }
    Util.unBindServiceCatchException(paramComponentName, this);
    HMSLog.i("BindingFailedResolution", "test connect success, try to reConnect and reply message");
    BindResolveClients.getInstance().notifyClientReconnect();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.api.BindingFailedResolution
 * JD-Core Version:    0.7.0.1
 */