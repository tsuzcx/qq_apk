package com.huawei.hms.common.internal;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.os.IBinder;
import com.huawei.hms.adapter.BinderAdapter;
import com.huawei.hms.adapter.BinderAdapter.BinderCallBack;
import com.huawei.hms.api.ConnectionResult;
import com.huawei.hms.core.aidl.d.a;
import com.huawei.hms.support.log.HMSLog;

class BaseHmsClient$1
  implements BinderAdapter.BinderCallBack
{
  BaseHmsClient$1(BaseHmsClient paramBaseHmsClient) {}
  
  public void onBinderFailed(int paramInt)
  {
    onBinderFailed(paramInt, null);
  }
  
  public void onBinderFailed(int paramInt, PendingIntent paramPendingIntent)
  {
    BaseHmsClient.a(this.a, new ConnectionResult(10, paramPendingIntent));
    BaseHmsClient.a(this.a, null);
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    HMSLog.i("BaseHmsClient", "Enter onServiceConnected.");
    BaseHmsClient.a(this.a, d.a.a(paramIBinder));
    if (BaseHmsClient.a(this.a) == null)
    {
      HMSLog.e("BaseHmsClient", "Failed to get service as interface, trying to unbind.");
      BaseHmsClient.b(this.a).unBind();
      BaseHmsClient.a(this.a, 1);
      BaseHmsClient.b(this.a, 10);
      return;
    }
    this.a.onConnecting();
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    HMSLog.i("BaseHmsClient", "Enter onServiceDisconnected.");
    BaseHmsClient.a(this.a, 1);
    if (BaseHmsClient.c(this.a) != null) {
      BaseHmsClient.c(this.a).onConnectionSuspended(1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.common.internal.BaseHmsClient.1
 * JD-Core Version:    0.7.0.1
 */