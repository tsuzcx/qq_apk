package com.tencent.mobileqq.app.decoupleim;

import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class ThirdPartyLoginBlockUtilImpl$1
  implements EIPCResultCallback
{
  ThirdPartyLoginBlockUtilImpl$1(ThirdPartyLoginBlockUtilImpl paramThirdPartyLoginBlockUtilImpl, String paramString) {}
  
  private void a(EIPCResult paramEIPCResult)
  {
    if (paramEIPCResult.code != 0)
    {
      ThirdPartyLoginBlockUtilImpl.a(this.jdField_a_of_type_ComTencentMobileqqAppDecoupleimThirdPartyLoginBlockUtilImpl).a();
      return;
    }
    ThirdPartyLoginBlockUtilImpl.a(this.jdField_a_of_type_ComTencentMobileqqAppDecoupleimThirdPartyLoginBlockUtilImpl).a(this.jdField_a_of_type_JavaLangString);
  }
  
  private boolean a(EIPCResult paramEIPCResult)
  {
    return (paramEIPCResult == null) || (paramEIPCResult.data == null) || (ThirdPartyLoginBlockUtilImpl.a(this.jdField_a_of_type_ComTencentMobileqqAppDecoupleimThirdPartyLoginBlockUtilImpl) == null);
  }
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if (a(paramEIPCResult))
    {
      QLog.e("ThirdPartyLoginUtilImpl", 1, "toWtLoginOnOpenSdk callback params error");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("code=");
    localStringBuilder.append(paramEIPCResult.code);
    localStringBuilder.append(" ssoResult=");
    localStringBuilder.append(paramEIPCResult.data.getInt("key_sso_ret"));
    QLog.d("ThirdPartyLoginUtilImpl", 1, localStringBuilder.toString());
    a(paramEIPCResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.decoupleim.ThirdPartyLoginBlockUtilImpl.1
 * JD-Core Version:    0.7.0.1
 */