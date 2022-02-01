package com.tencent.mobileqq.ark.API;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

public class ArkQQAPIIPCModule$GetNicknameByViewHandler
  implements ArkQQAPIIPCModule.IPCSyncMethodHandler
{
  private String a(QQAppInterface paramQQAppInterface, String paramString)
  {
    Object localObject = null;
    String str = null;
    SessionInfo localSessionInfo = ArkAppModuleBase.a();
    if (!TextUtils.isEmpty(paramString))
    {
      if (localSessionInfo != null) {
        str = ContactUtils.a(paramQQAppInterface, localSessionInfo, paramString.equals(paramQQAppInterface.getCurrentUin()), paramString);
      }
      if (str != null)
      {
        localObject = str;
        if (!TextUtils.equals(str, paramString)) {}
      }
      else
      {
        str = ContactUtils.q(paramQQAppInterface, paramString);
        localObject = str;
        if (TextUtils.isEmpty(str)) {
          localObject = ContactUtils.a(paramQQAppInterface, paramString, 0);
        }
      }
    }
    return localObject;
  }
  
  public EIPCResult a(Bundle paramBundle)
  {
    Object localObject = ArkQQAPIIPCModule.a();
    if (localObject == null)
    {
      QLog.e("ArkApp.GetNicknameByViewHandler", 1, "Handler_GetNickName.onCall, qq app is null");
      return EIPCResult.createResult(-102, new Bundle());
    }
    paramBundle = a((QQAppInterface)localObject, paramBundle.getString("Uin", ((QQAppInterface)localObject).getCurrentAccountUin()));
    localObject = new Bundle();
    if (TextUtils.isEmpty(paramBundle))
    {
      QLog.e("ArkApp.GetNicknameByViewHandler", 1, "Handler_GetNickName.onCall, nickname is empty");
      ((Bundle)localObject).putString("Nickname", "");
    }
    for (;;)
    {
      return EIPCResult.createResult(0, (Bundle)localObject);
      ((Bundle)localObject).putString("Nickname", paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkQQAPIIPCModule.GetNicknameByViewHandler
 * JD-Core Version:    0.7.0.1
 */