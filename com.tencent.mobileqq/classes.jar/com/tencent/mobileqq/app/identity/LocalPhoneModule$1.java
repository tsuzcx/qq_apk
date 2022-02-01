package com.tencent.mobileqq.app.identity;

import java.util.List;
import tencent.im.login.GetLocalPhone.LocalPhoneCodeData;

class LocalPhoneModule$1
  implements LocalPhoneModule.UrlTokenCallback
{
  LocalPhoneModule$1(LocalPhoneModule paramLocalPhoneModule, LocalPhoneModule.MaskPhoneCallback paramMaskPhoneCallback) {}
  
  public void a(int paramInt, Exception paramException)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppIdentityLocalPhoneModule$MaskPhoneCallback.a(paramInt, paramException);
  }
  
  public void a(List<GetLocalPhone.LocalPhoneCodeData> paramList)
  {
    LocalPhoneModule.a(this.jdField_a_of_type_ComTencentMobileqqAppIdentityLocalPhoneModule, paramList, this.jdField_a_of_type_ComTencentMobileqqAppIdentityLocalPhoneModule$MaskPhoneCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.identity.LocalPhoneModule.1
 * JD-Core Version:    0.7.0.1
 */