package com.huawei.hms.common.internal;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Intent;
import android.os.IBinder;
import com.huawei.hms.adapter.BinderAdapter;
import com.huawei.hms.adapter.BinderAdapter.BinderCallBack;
import com.huawei.hms.api.ConnectionResult;
import com.huawei.hms.core.aidl.d.a;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.Util;

class BaseHmsClient$1
  implements BinderAdapter.BinderCallBack
{
  BaseHmsClient$1(BaseHmsClient paramBaseHmsClient) {}
  
  public void onBinderFailed(int paramInt)
  {
    onBinderFailed(paramInt, null);
  }
  
  public void onBinderFailed(int paramInt, Intent paramIntent)
  {
    if (paramIntent != null)
    {
      Activity localActivity = Util.getActiveActivity(this.this$0.getClientSettings().getCpActivity(), this.this$0.getContext());
      if (localActivity != null)
      {
        HMSLog.i("BaseHmsClient", "onBinderFailed: SDK try to resolve and reConnect!");
        localActivity.startActivity(paramIntent);
        return;
      }
      HMSLog.i("BaseHmsClient", "onBinderFailed: return pendingIntent to kit and cp");
      paramIntent = PendingIntent.getActivity(BaseHmsClient.access$400(this.this$0), 11, paramIntent, 134217728);
      BaseHmsClient.access$500(this.this$0, new ConnectionResult(10, paramIntent));
      BaseHmsClient.access$002(this.this$0, null);
      return;
    }
    HMSLog.i("BaseHmsClient", "onBinderFailed: pendingIntent is null!");
    BaseHmsClient.access$500(this.this$0, new ConnectionResult(10, null));
    BaseHmsClient.access$002(this.this$0, null);
  }
  
  public void onNullBinding(ComponentName paramComponentName)
  {
    BaseHmsClient.access$200(this.this$0, 1);
    BaseHmsClient.access$300(this.this$0, 10);
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    HMSLog.i("BaseHmsClient", "Enter onServiceConnected.");
    BaseHmsClient.access$002(this.this$0, d.a.a(paramIBinder));
    if (BaseHmsClient.access$000(this.this$0) == null)
    {
      HMSLog.e("BaseHmsClient", "Failed to get service as interface, trying to unbind.");
      BaseHmsClient.access$100(this.this$0).unBind();
      BaseHmsClient.access$200(this.this$0, 1);
      BaseHmsClient.access$300(this.this$0, 10);
      return;
    }
    this.this$0.onConnecting();
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    HMSLog.i("BaseHmsClient", "Enter onServiceDisconnected.");
    BaseHmsClient.access$200(this.this$0, 1);
    if (BaseHmsClient.access$600(this.this$0) != null) {
      BaseHmsClient.access$600(this.this$0).onConnectionSuspended(1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.common.internal.BaseHmsClient.1
 * JD-Core Version:    0.7.0.1
 */