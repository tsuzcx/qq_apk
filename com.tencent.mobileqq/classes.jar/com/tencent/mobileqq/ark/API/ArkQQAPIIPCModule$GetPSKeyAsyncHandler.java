package com.tencent.mobileqq.ark.API;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import mqq.manager.TicketManager;

public class ArkQQAPIIPCModule$GetPSKeyAsyncHandler
  implements ArkQQAPIIPCModule.IPCAsyncMethodHandler
{
  private void a(QQAppInterface paramQQAppInterface, String paramString, ArkQQAPIIPCModule.GetPSKeyAsyncHandler.OnGetPSKeyHandler paramOnGetPSKeyHandler)
  {
    if (paramQQAppInterface == null) {}
    TicketManager localTicketManager;
    do
    {
      return;
      localTicketManager = (TicketManager)paramQQAppInterface.getManager(2);
      str = localTicketManager.getPskey(paramQQAppInterface.getCurrentAccountUin(), paramString);
      if (TextUtils.isEmpty(str)) {
        break;
      }
    } while (paramOnGetPSKeyHandler == null);
    paramOnGetPSKeyHandler.a(str);
    return;
    String str = paramQQAppInterface.getCurrentAccountUin();
    paramQQAppInterface = new ArkQQAPIIPCModule.GetPSKeyAsyncHandler.2(this, localTicketManager, paramQQAppInterface, paramString, paramOnGetPSKeyHandler);
    localTicketManager.getPskey(str, 16L, new String[] { paramString }, paramQQAppInterface);
  }
  
  public void a(Bundle paramBundle, ArkQQAPIIPCModule.IPCMethodCallback paramIPCMethodCallback)
  {
    QQAppInterface localQQAppInterface = ArkQQAPIIPCModule.a();
    if (localQQAppInterface == null)
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
    a(localQQAppInterface, paramBundle, new ArkQQAPIIPCModule.GetPSKeyAsyncHandler.1(this, paramIPCMethodCallback));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkQQAPIIPCModule.GetPSKeyAsyncHandler
 * JD-Core Version:    0.7.0.1
 */