package com.tencent.biz.pubaccount.util.api.impl;

import android.os.Bundle;
import com.tencent.mobileqq.kandian.biz.fastweb.CallJs;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

final class PublicAccountH5AbilityPluginImpl$13
  implements EIPCResultCallback
{
  PublicAccountH5AbilityPluginImpl$13(CallJs paramCallJs, String paramString) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if ((paramEIPCResult != null) && (paramEIPCResult.data != null)) {
      paramEIPCResult = paramEIPCResult.data.getString("action_get_user_info");
    } else {
      paramEIPCResult = "";
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getUserInfoIpc is ");
    ((StringBuilder)localObject).append(paramEIPCResult);
    QLog.e("PublicAccountH5AbilityPlugin", 1, ((StringBuilder)localObject).toString());
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebCallJs;
    if (localObject != null) {
      ((CallJs)localObject).a(this.jdField_a_of_type_JavaLangString, paramEIPCResult);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.api.impl.PublicAccountH5AbilityPluginImpl.13
 * JD-Core Version:    0.7.0.1
 */