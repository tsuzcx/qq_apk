package com.tencent.mobileqq.ark.api.module;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ipc.IPCSyncMethodHandler;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import mqq.manager.TicketManager;

public class ArkQQAPIIPCModule$GetPSKeyHandler
  implements IPCSyncMethodHandler
{
  public EIPCResult a(Bundle paramBundle)
  {
    Object localObject1 = ArkQQAPIIPCModule.a();
    if (localObject1 == null)
    {
      QLog.e("ArkApp.GetPSKeyHandler", 1, "GetPSKeyHandler.onCall, qq app is null");
      return EIPCResult.createResult(-102, new Bundle());
    }
    paramBundle = paramBundle.getString("Domain", "");
    Object localObject2 = ((TicketManager)((QQAppInterface)localObject1).getManager(2)).getPskey(((QQAppInterface)localObject1).getCurrentAccountUin(), paramBundle);
    localObject1 = new Bundle();
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("GetPSKeyHandler.onCall, pskey is empty, domain=");
      ((StringBuilder)localObject2).append(paramBundle);
      QLog.e("ArkApp.GetPSKeyHandler", 1, ((StringBuilder)localObject2).toString());
      ((Bundle)localObject1).putString("PSKey", "");
    }
    else
    {
      ((Bundle)localObject1).putString("PSKey", (String)localObject2);
    }
    return EIPCResult.createResult(0, (Bundle)localObject1);
  }
  
  public String a()
  {
    return "QQ.GetPSKey";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.module.ArkQQAPIIPCModule.GetPSKeyHandler
 * JD-Core Version:    0.7.0.1
 */