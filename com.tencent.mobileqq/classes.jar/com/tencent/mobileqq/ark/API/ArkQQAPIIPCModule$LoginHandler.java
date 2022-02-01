package com.tencent.mobileqq.ark.API;

import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import mqq.manager.WtloginManager;
import mqq.observer.WtloginObserver;

public class ArkQQAPIIPCModule$LoginHandler
  implements ArkQQAPIIPCModule.IPCAsyncMethodHandler
{
  private WtloginObserver a;
  
  private void a(long paramLong1, long paramLong2, ArkQQAPIIPCModule.LoginHandler.OnLoginEventHandler paramOnLoginEventHandler)
  {
    QQAppInterface localQQAppInterface = ArkQQAPIIPCModule.a();
    if (localQQAppInterface == null)
    {
      paramOnLoginEventHandler.a(null, 0L, null, null);
      return;
    }
    if (this.a == null) {
      this.a = new ArkQQAPIIPCModule.LoginHandler.2(this, paramOnLoginEventHandler);
    }
    ((WtloginManager)localQQAppInterface.getManager(1)).getOpenKeyWithoutPasswd(localQQAppInterface.getCurrentUin(), paramLong1, paramLong2, this.a);
  }
  
  public void a(Bundle paramBundle, ArkQQAPIIPCModule.IPCMethodCallback paramIPCMethodCallback)
  {
    if (ArkQQAPIIPCModule.a() == null)
    {
      QLog.e("ArkApp.LoginHandler", 1, "LoginHandler.onCall, qq app is null");
      paramIPCMethodCallback.a(EIPCResult.createResult(-102, new Bundle()));
      return;
    }
    long l1 = paramBundle.getLong("srcAppID", 0L);
    long l2 = paramBundle.getLong("dstAppID", 0L);
    if ((l1 == 0L) || (l2 == 0L))
    {
      paramIPCMethodCallback.a(EIPCResult.createResult(0, new Bundle()));
      return;
    }
    a(l1, l2, new ArkQQAPIIPCModule.LoginHandler.1(this, paramIPCMethodCallback));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkQQAPIIPCModule.LoginHandler
 * JD-Core Version:    0.7.0.1
 */