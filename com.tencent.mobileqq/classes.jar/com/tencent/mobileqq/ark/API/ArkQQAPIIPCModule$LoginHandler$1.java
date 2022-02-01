package com.tencent.mobileqq.ark.API;

import android.os.Bundle;
import android.text.TextUtils;
import eipc.EIPCResult;

class ArkQQAPIIPCModule$LoginHandler$1
  implements ArkQQAPIIPCModule.LoginHandler.OnLoginEventHandler
{
  ArkQQAPIIPCModule$LoginHandler$1(ArkQQAPIIPCModule.LoginHandler paramLoginHandler, ArkQQAPIIPCModule.IPCMethodCallback paramIPCMethodCallback) {}
  
  public void a(String paramString1, long paramLong, String paramString2, String paramString3)
  {
    Bundle localBundle = new Bundle();
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString3)))
    {
      localBundle.putString("userAccount", paramString1);
      localBundle.putString("openID", paramString2);
      localBundle.putString("openToken", paramString3);
      localBundle.putLong("dstAppID", paramLong);
    }
    this.jdField_a_of_type_ComTencentMobileqqArkAPIArkQQAPIIPCModule$IPCMethodCallback.a(EIPCResult.createResult(0, localBundle));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkQQAPIIPCModule.LoginHandler.1
 * JD-Core Version:    0.7.0.1
 */