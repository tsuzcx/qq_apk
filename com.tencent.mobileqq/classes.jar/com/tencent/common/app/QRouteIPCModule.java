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
    if (QLog.isColorLevel()) {
      QLog.i("QRouteIPCModule", 2, "action:" + paramString);
    }
    if ((TextUtils.isEmpty(paramString)) || (!paramString.contains("$"))) {
      paramString = EIPCResult.createExceptionResult(new IllegalStateException("wrong action"));
    }
    String[] arrayOfString;
    do
    {
      return paramString;
      arrayOfString = paramString.split("\\$");
      if (arrayOfString.length != 3) {
        return EIPCResult.createExceptionResult(new IllegalStateException("wrong action, action = " + paramString));
      }
      if (arrayOfString[0].compareTo("callApi") == 0)
      {
        paramString = QRemoteProxy.callInMainProcess(paramString, paramBundle, paramInt);
        if (paramString == null) {
          break;
        }
        paramBundle = EIPCResult.createResult(paramString.code, paramString.data);
        paramBundle.e = paramString.throwable;
        return paramBundle;
      }
      if (arrayOfString[0].compareTo("callService") != 0) {
        break;
      }
      paramBundle = ServiceRemoteProxy.callInMainProcess(paramString, paramBundle, paramInt);
      paramString = paramBundle;
    } while (paramBundle != null);
    return EIPCResult.createExceptionResult(new IllegalStateException("QRemoteProxy.callInMainProcess result is null, callType=" + arrayOfString[0]));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.common.app.QRouteIPCModule
 * JD-Core Version:    0.7.0.1
 */