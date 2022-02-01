package com.tencent.mobileqq.ark.API;

import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

public class ArkQQAPIIPCModule$GetUinHandler
  implements ArkQQAPIIPCModule.IPCSyncMethodHandler
{
  public EIPCResult a(Bundle paramBundle)
  {
    paramBundle = ArkQQAPIIPCModule.a();
    if (paramBundle == null)
    {
      QLog.e("ArkApp.GetUinHandler", 1, "Handler_GetNickName.onCall, qq app is null");
      return EIPCResult.createResult(-102, new Bundle());
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("Uin", paramBundle.getCurrentAccountUin());
    return EIPCResult.createResult(0, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkQQAPIIPCModule.GetUinHandler
 * JD-Core Version:    0.7.0.1
 */