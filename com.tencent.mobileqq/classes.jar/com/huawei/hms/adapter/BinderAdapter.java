package com.huawei.hms.adapter;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ApplicationInfo;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.text.TextUtils;
import com.huawei.hms.api.BindingFailedResolution;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.Util;

public class BinderAdapter
  implements ServiceConnection
{
  private static final Object e = new Object();
  private Context a;
  private String b;
  private String c;
  private BinderAdapter.BinderCallBack d;
  private Handler f = null;
  
  public BinderAdapter(Context paramContext, String paramString1, String paramString2)
  {
    this.a = paramContext;
    this.b = paramString1;
    this.c = paramString2;
  }
  
  private void a()
  {
    if (this.f != null) {
      this.f.removeMessages(1001);
    }
    for (;;)
    {
      this.f.sendEmptyMessageDelayed(1001, 5000L);
      return;
      this.f = new Handler(Looper.getMainLooper(), new BinderAdapter.1(this));
    }
  }
  
  private void b()
  {
    BinderAdapter.BinderCallBack localBinderCallBack = f();
    if (localBinderCallBack != null) {
      localBinderCallBack.onBinderFailed(-1);
    }
  }
  
  private void c()
  {
    if ((TextUtils.isEmpty(this.b)) || (TextUtils.isEmpty(this.c))) {
      d();
    }
    Intent localIntent = new Intent(this.b);
    localIntent.setPackage(this.c);
    synchronized (e)
    {
      if (this.a.bindService(localIntent, this, 1))
      {
        a();
        return;
      }
      d();
      return;
    }
  }
  
  private void d()
  {
    HMSLog.e("BinderAdapter", "In connect, bind core service fail");
    Object localObject = new ComponentName(this.a.getApplicationInfo().packageName, "com.huawei.hms.activity.BridgeActivity");
    Intent localIntent = new Intent();
    localIntent.setComponent((ComponentName)localObject);
    localIntent.putExtra("intent.extra.DELEGATE_CLASS_OBJECT", BindingFailedResolution.class.getName());
    localObject = PendingIntent.getActivity(this.a, 11, localIntent, 134217728);
    this.d.onBinderFailed(-1, (PendingIntent)localObject);
  }
  
  private void e()
  {
    synchronized (e)
    {
      if (this.f != null)
      {
        this.f.removeMessages(1001);
        this.f = null;
      }
      return;
    }
  }
  
  private BinderAdapter.BinderCallBack f()
  {
    return this.d;
  }
  
  public void binder(BinderAdapter.BinderCallBack paramBinderCallBack)
  {
    if (paramBinderCallBack == null) {
      return;
    }
    this.d = paramBinderCallBack;
    c();
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    HMSLog.i("BinderAdapter", "Enter onServiceConnected.");
    e();
    BinderAdapter.BinderCallBack localBinderCallBack = f();
    if (localBinderCallBack != null) {
      localBinderCallBack.onServiceConnected(paramComponentName, paramIBinder);
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    HMSLog.i("BinderAdapter", "Enter onServiceDisconnected.");
    BinderAdapter.BinderCallBack localBinderCallBack = f();
    if (localBinderCallBack != null) {
      localBinderCallBack.onServiceDisconnected(paramComponentName);
    }
  }
  
  public void unBind()
  {
    Util.unBindServiceCatchException(this.a, this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hms.adapter.BinderAdapter
 * JD-Core Version:    0.7.0.1
 */