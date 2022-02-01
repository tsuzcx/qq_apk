package com.tencent.common.app;

import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qroute.remote.IQRemoteProxy;
import com.tencent.mobileqq.qroute.remote.IQRemoteResultCallback;
import com.tencent.mobileqq.qroute.remote.QRemoteResult;
import eipc.EIPCResult;

class BaseApplicationImpl$3
  implements IQRemoteProxy
{
  BaseApplicationImpl$3(BaseApplicationImpl paramBaseApplicationImpl) {}
  
  public void callServerAsync(String paramString, Bundle paramBundle, IQRemoteResultCallback paramIQRemoteResultCallback) {}
  
  public QRemoteResult callServerSync(String paramString, Bundle paramBundle)
  {
    paramString = QIPCClientHelper.getInstance().callServer("QRouteIPCModule", paramString, paramBundle);
    paramBundle = new QRemoteResult();
    paramBundle.code = paramString.code;
    paramBundle.data = paramString.data;
    paramBundle.throwable = paramString.e;
    return paramBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.common.app.BaseApplicationImpl.3
 * JD-Core Version:    0.7.0.1
 */