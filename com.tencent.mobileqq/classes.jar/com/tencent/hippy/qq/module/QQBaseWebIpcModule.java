package com.tencent.hippy.qq.module;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.Toast;
import anvx;
import ascz;
import ashz;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.hippy.qq.app.HippyQQEngine;
import com.tencent.mobileqq.emosm.Client;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.qphone.base.util.QLog;

public class QQBaseWebIpcModule
  extends QQBaseModule
{
  private static final String TAG = "HippyQQBaseWebIpcModule";
  public ascz mOnRemoteResp = new QQBaseWebIpcModule.1(this);
  
  public QQBaseWebIpcModule(HippyEngineContext paramHippyEngineContext)
  {
    super(paramHippyEngineContext);
    if (!ashz.a().a()) {
      ashz.a().a().doBindService(BaseApplicationImpl.getApplication().getApplicationContext());
    }
    ashz.a().a(this.mOnRemoteResp);
  }
  
  public void destroy()
  {
    ashz.a().b(this.mOnRemoteResp);
  }
  
  protected Activity getActivity()
  {
    Fragment localFragment = getFragment();
    if (localFragment == null) {
      return null;
    }
    return localFragment.getActivity();
  }
  
  protected Fragment getFragment()
  {
    HippyQQEngine localHippyQQEngine = HippyQQEngine.getEngineInstance(this.mContext.getEngineId());
    if (localHippyQQEngine == null) {
      return null;
    }
    return localHippyQQEngine.getFragment();
  }
  
  protected void onBindedToClient() {}
  
  protected void onDisconnectWithService() {}
  
  protected void onPushMsg(Bundle paramBundle) {}
  
  protected void onResponse(Bundle paramBundle) {}
  
  public void sendRemoteReq(Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!ashz.a().a())
    {
      if (paramBoolean2) {
        Toast.makeText(BaseApplicationImpl.getApplication(), anvx.a(2131715415), 0).show();
      }
      QLog.e("", 1, "sendRemoteReq error ipc service not ready");
      return;
    }
    if (paramBoolean1)
    {
      ashz.a().b(paramBundle);
      return;
    }
    ashz.a().a(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.hippy.qq.module.QQBaseWebIpcModule
 * JD-Core Version:    0.7.0.1
 */