package com.tencent.common.app;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.remote.QRemoteProxy;
import com.tencent.mobileqq.qroute.remote.QRemoteResult;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import mqq.app.remote.ServiceRemoteProxy;

public class QRouteIPCModule
  extends QIPCModule
{
  private static QRouteIPCModule a;
  
  public QRouteIPCModule(String paramString)
  {
    super(paramString);
  }
  
  public static QRouteIPCModule a()
  {
    try
    {
      if (a == null)
      {
        a = new QRouteIPCModule("QRouteIPCModule");
        QIPCClientHelper.getInstance().register(a);
      }
      QRouteIPCModule localQRouteIPCModule = a;
      return localQRouteIPCModule;
    }
    finally {}
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("action:");
      ((StringBuilder)localObject).append(paramString);
      QLog.i("QRouteIPCModule", 2, ((StringBuilder)localObject).toString());
    }
    if ((!TextUtils.isEmpty(paramString)) && (paramString.contains("$")))
    {
      localObject = paramString.split("\\$");
      if (localObject.length != 3)
      {
        paramBundle = new StringBuilder();
        paramBundle.append("wrong action, action = ");
        paramBundle.append(paramString);
        return EIPCResult.createExceptionResult(new IllegalStateException(paramBundle.toString()));
      }
      if (localObject[0].compareTo("callApi") == 0)
      {
        paramString = QRemoteProxy.callInMainProcess(paramString, paramBundle, paramInt);
        if (paramString != null)
        {
          paramBundle = EIPCResult.createResult(paramString.code, paramString.data);
          paramBundle.e = paramString.throwable;
          return paramBundle;
        }
      }
      else if (localObject[0].compareTo("callService") == 0)
      {
        paramString = ServiceRemoteProxy.callInMainProcess(paramString, paramBundle, paramInt);
        if (paramString != null) {
          return paramString;
        }
      }
      paramString = new StringBuilder();
      paramString.append("QRemoteProxy.callInMainProcess result is null, callType=");
      paramString.append(localObject[0]);
      return EIPCResult.createExceptionResult(new IllegalStateException(paramString.toString()));
    }
    return EIPCResult.createExceptionResult(new IllegalStateException("wrong action"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.common.app.QRouteIPCModule
 * JD-Core Version:    0.7.0.1
 */