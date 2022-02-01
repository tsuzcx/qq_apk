package com.tencent.hippy.qq.module;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.Toast;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.hippy.qq.app.HippyQQEngine;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.emosm.Client;
import com.tencent.mobileqq.emosm.Client.OnRemoteRespObserver;
import com.tencent.mobileqq.emosm.web.WebIPCOperator;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.qphone.base.util.QLog;

public class QQBaseWebIpcModule
  extends QQBaseModule
{
  private static final String TAG = "HippyQQBaseWebIpcModule";
  boolean mIsStartService = false;
  public Client.OnRemoteRespObserver mOnRemoteResp = new QQBaseWebIpcModule.1(this);
  
  public QQBaseWebIpcModule(HippyEngineContext paramHippyEngineContext)
  {
    this(paramHippyEngineContext, true);
  }
  
  public QQBaseWebIpcModule(HippyEngineContext paramHippyEngineContext, boolean paramBoolean)
  {
    super(paramHippyEngineContext);
    this.mIsStartService = paramBoolean;
    if (this.mIsStartService)
    {
      if (!WebIPCOperator.a().a()) {
        WebIPCOperator.a().a().doBindService(BaseApplicationImpl.getApplication().getApplicationContext());
      }
      WebIPCOperator.a().a(this.mOnRemoteResp);
    }
  }
  
  public void destroy()
  {
    if (this.mIsStartService) {
      WebIPCOperator.a().b(this.mOnRemoteResp);
    }
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
    if (!WebIPCOperator.a().a())
    {
      if (paramBoolean2) {
        Toast.makeText(BaseApplicationImpl.getApplication(), HardCodeUtil.a(2131715881), 0).show();
      }
      QLog.e("", 1, "sendRemoteReq error ipc service not ready");
      return;
    }
    if (paramBoolean1)
    {
      WebIPCOperator.a().b(paramBundle);
      return;
    }
    WebIPCOperator.a().a(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.module.QQBaseWebIpcModule
 * JD-Core Version:    0.7.0.1
 */