package com.tencent.mobileqq.ark.API;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.item.ArkAppContainer;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

public class ArkQQAPIIPCModule$GetNicknameHandler
  implements ArkQQAPIIPCModule.IPCSyncMethodHandler
{
  public EIPCResult a(Bundle paramBundle)
  {
    QQAppInterface localQQAppInterface = ArkQQAPIIPCModule.a();
    if (localQQAppInterface == null)
    {
      QLog.e("ArkApp.GetNicknameHandler", 1, "Handler_GetNickName.onCall, qq app is null");
      return EIPCResult.createResult(-102, new Bundle());
    }
    String str = paramBundle.getString("Uin", localQQAppInterface.getCurrentAccountUin());
    Object localObject = null;
    if (!TextUtils.isEmpty(ArkAppContainer.a)) {
      localObject = ContactUtils.g(localQQAppInterface, ArkAppContainer.a, str);
    }
    if (localObject != null)
    {
      paramBundle = (Bundle)localObject;
      if (!TextUtils.equals((CharSequence)localObject, str)) {}
    }
    else
    {
      localObject = ContactUtils.q(localQQAppInterface, str);
      paramBundle = (Bundle)localObject;
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        paramBundle = ContactUtils.a(localQQAppInterface, str, 0);
      }
    }
    localObject = new Bundle();
    if (TextUtils.isEmpty(paramBundle))
    {
      QLog.i("ArkApp.GetNicknameHandler", 1, "GetNicknameHandler.onCall, nickname is empty");
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
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkQQAPIIPCModule.GetNicknameHandler
 * JD-Core Version:    0.7.0.1
 */