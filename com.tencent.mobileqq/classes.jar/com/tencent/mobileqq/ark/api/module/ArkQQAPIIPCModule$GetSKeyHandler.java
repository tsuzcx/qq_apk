package com.tencent.mobileqq.ark.api.module;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ipc.IPCSyncMethodHandler;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import mqq.manager.TicketManager;

public class ArkQQAPIIPCModule$GetSKeyHandler
  implements IPCSyncMethodHandler
{
  public EIPCResult a(Bundle paramBundle)
  {
    paramBundle = ArkQQAPIIPCModule.d();
    if (paramBundle == null)
    {
      QLog.e("ArkApp.GetSKeyHandler", 1, "GetSKeyHandler.onCall, qq app is null");
      return EIPCResult.createResult(-102, new Bundle());
    }
    paramBundle = ((TicketManager)paramBundle.getManager(2)).getSkey(paramBundle.getCurrentAccountUin());
    Bundle localBundle = new Bundle();
    if (TextUtils.isEmpty(paramBundle))
    {
      QLog.e("ArkApp.GetSKeyHandler", 1, "GetSKeyHandler.onCall, skey is empty");
      localBundle.putString("SKey", "");
    }
    else
    {
      localBundle.putString("SKey", paramBundle);
    }
    return EIPCResult.createResult(0, localBundle);
  }
  
  public String a()
  {
    return "QQ.GetSKey";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.module.ArkQQAPIIPCModule.GetSKeyHandler
 * JD-Core Version:    0.7.0.1
 */