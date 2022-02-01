package com.tencent.hippy.qq.module;

import android.os.Bundle;
import android.widget.Toast;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.emosm.OnRemoteRespObserver;
import com.tencent.mobileqq.emosm.api.IWebIPCOperatorApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.qphone.base.util.QLog;

public class QQBaseWebIpcModule
  extends QQBaseModule
{
  private static final String TAG = "HippyQQBaseWebIpcModule";
  boolean mIsStartService = false;
  public OnRemoteRespObserver mOnRemoteResp = new QQBaseWebIpcModule.1(this);
  
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
      if (!((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).isServiceClientBinded()) {
        ((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).doBindService(BaseApplicationImpl.getApplication().getApplicationContext());
      }
      ((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).registerObserver(this.mOnRemoteResp);
    }
  }
  
  public void destroy()
  {
    if (this.mIsStartService) {
      ((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).unRegisterObserver(this.mOnRemoteResp);
    }
  }
  
  protected void onBindedToClient() {}
  
  protected void onDisconnectWithService() {}
  
  protected void onPushMsg(Bundle paramBundle) {}
  
  protected void onResponse(Bundle paramBundle) {}
  
  public void sendRemoteReq(Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).isServiceClientBinded())
    {
      if (paramBoolean2) {
        Toast.makeText(BaseApplicationImpl.getApplication(), HardCodeUtil.a(2131913261), 0).show();
      }
      QLog.e("", 1, "sendRemoteReq error ipc service not ready");
      return;
    }
    if (paramBoolean1)
    {
      ((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).sendServiceIpcReqWithoutTimeout(paramBundle);
      return;
    }
    ((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).sendServiceIpcReq(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.module.QQBaseWebIpcModule
 * JD-Core Version:    0.7.0.1
 */