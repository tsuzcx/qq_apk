package com.huawei.hms.adapter;

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
  private static final Object LOCK_CONNECT_TIMEOUT_HANDLER = new Object();
  private static final int MSG_CONN_TIMEOUT = 1001;
  private static final String TAG = "BinderAdapter";
  private boolean bindfail = false;
  private BinderAdapter.BinderCallBack callback;
  private String mAction;
  private Handler mBinderTimeoutHandler = null;
  private Context mContext;
  private String mService;
  
  public BinderAdapter(Context paramContext, String paramString1, String paramString2)
  {
    this.mContext = paramContext;
    this.mAction = paramString1;
    this.mService = paramString2;
  }
  
  private void bindCoreService()
  {
    if ((TextUtils.isEmpty(this.mAction)) || (TextUtils.isEmpty(this.mService))) {
      getBindFailPendingIntent();
    }
    Intent localIntent = new Intent(this.mAction);
    localIntent.setPackage(this.mService);
    synchronized (LOCK_CONNECT_TIMEOUT_HANDLER)
    {
      if (this.mContext.bindService(localIntent, this, 1))
      {
        postConnDelayHandle();
        return;
      }
      this.bindfail = true;
      getBindFailPendingIntent();
      return;
    }
  }
  
  private void binderServiceFailed()
  {
    BinderAdapter.BinderCallBack localBinderCallBack = getCallBack();
    if (localBinderCallBack != null) {
      localBinderCallBack.onBinderFailed(-1);
    }
  }
  
  private void cancelConnDelayHandle()
  {
    synchronized (LOCK_CONNECT_TIMEOUT_HANDLER)
    {
      if (this.mBinderTimeoutHandler != null)
      {
        this.mBinderTimeoutHandler.removeMessages(1001);
        this.mBinderTimeoutHandler = null;
      }
      return;
    }
  }
  
  private void getBindFailPendingIntent()
  {
    HMSLog.e("BinderAdapter", "In connect, bind core service fail");
    ComponentName localComponentName = new ComponentName(this.mContext.getApplicationInfo().packageName, "com.huawei.hms.activity.BridgeActivity");
    Intent localIntent = new Intent();
    localIntent.setComponent(localComponentName);
    localIntent.putExtra("intent.extra.DELEGATE_CLASS_OBJECT", BindingFailedResolution.class.getName());
    this.callback.onBinderFailed(-1, localIntent);
  }
  
  private BinderAdapter.BinderCallBack getCallBack()
  {
    return this.callback;
  }
  
  private void postConnDelayHandle()
  {
    Handler localHandler = this.mBinderTimeoutHandler;
    if (localHandler != null) {
      localHandler.removeMessages(1001);
    } else {
      this.mBinderTimeoutHandler = new Handler(Looper.getMainLooper(), new BinderAdapter.1(this));
    }
    this.mBinderTimeoutHandler.sendEmptyMessageDelayed(1001, 5000L);
  }
  
  public void binder(BinderAdapter.BinderCallBack paramBinderCallBack)
  {
    if (paramBinderCallBack == null) {
      return;
    }
    this.callback = paramBinderCallBack;
    bindCoreService();
  }
  
  public void onNullBinding(ComponentName paramComponentName)
  {
    HMSLog.e("BinderAdapter", "Enter onNullBinding, than unBind.");
    if (this.bindfail)
    {
      this.bindfail = false;
      return;
    }
    unBind();
    cancelConnDelayHandle();
    BinderAdapter.BinderCallBack localBinderCallBack = getCallBack();
    if (localBinderCallBack != null) {
      localBinderCallBack.onNullBinding(paramComponentName);
    }
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    HMSLog.i("BinderAdapter", "Enter onServiceConnected.");
    cancelConnDelayHandle();
    BinderAdapter.BinderCallBack localBinderCallBack = getCallBack();
    if (localBinderCallBack != null) {
      localBinderCallBack.onServiceConnected(paramComponentName, paramIBinder);
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    HMSLog.i("BinderAdapter", "Enter onServiceDisconnected.");
    BinderAdapter.BinderCallBack localBinderCallBack = getCallBack();
    if (localBinderCallBack != null) {
      localBinderCallBack.onServiceDisconnected(paramComponentName);
    }
  }
  
  public void unBind()
  {
    Util.unBindServiceCatchException(this.mContext, this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.adapter.BinderAdapter
 * JD-Core Version:    0.7.0.1
 */