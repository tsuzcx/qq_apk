package com.tencent.mobileqq.ark.api.module;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.ark.ipc.IPCAsyncMethodHandler;
import com.tencent.mobileqq.ark.ipc.IPCMethodCallback;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;

public class ArkQQAPIIPCModule$GetPSKeyAsyncHandler
  implements IPCAsyncMethodHandler
{
  private void a(AppRuntime paramAppRuntime, String paramString, ArkQQAPIIPCModule.GetPSKeyAsyncHandler.OnGetPSKeyHandler paramOnGetPSKeyHandler)
  {
    if (paramAppRuntime == null) {
      return;
    }
    TicketManager localTicketManager = (TicketManager)paramAppRuntime.getManager(2);
    String str = localTicketManager.getPskey(paramAppRuntime.getCurrentAccountUin(), paramString);
    if (!TextUtils.isEmpty(str))
    {
      if (paramOnGetPSKeyHandler != null) {
        paramOnGetPSKeyHandler.a(str);
      }
      return;
    }
    str = paramAppRuntime.getCurrentAccountUin();
    paramAppRuntime = new ArkQQAPIIPCModule.GetPSKeyAsyncHandler.2(this, localTicketManager, paramAppRuntime, paramString, paramOnGetPSKeyHandler);
    localTicketManager.getPskey(str, 16L, new String[] { paramString }, paramAppRuntime);
  }
  
  public String a()
  {
    return "QQ.GetPSKeyAsync";
  }
  
  public void a(Bundle paramBundle, IPCMethodCallback paramIPCMethodCallback)
  {
    if (MobileQQ.sProcessId != 1)
    {
      QLog.i("ArkApp.GetPSKeyAsyncHandler", 1, "onCall, app interface is null");
      paramIPCMethodCallback.a(EIPCResult.createResult(-102, new Bundle()));
      return;
    }
    paramBundle = paramBundle.getString("domain", "");
    if (TextUtils.isEmpty(paramBundle))
    {
      QLog.i("ArkApp.GetPSKeyAsyncHandler", 1, "onCall, domain is empty");
      paramIPCMethodCallback.a(EIPCResult.createResult(0, new Bundle()));
      return;
    }
    a(MobileQQ.sMobileQQ.waitAppRuntime(null), paramBundle, new ArkQQAPIIPCModule.GetPSKeyAsyncHandler.1(this, paramIPCMethodCallback));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.module.ArkQQAPIIPCModule.GetPSKeyAsyncHandler
 * JD-Core Version:    0.7.0.1
 */