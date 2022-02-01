package com.tencent.mobileqq.app.identity;

import com.tencent.mobileqq.servlet.LocalPhoneServlet;
import java.util.List;
import tencent.im.login.GetLocalPhone.LocalPhoneCodeData;

class LocalPhoneModule$2
  implements LocalPhoneModule.UrlTokenCallback
{
  public void a(int paramInt, Exception paramException)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppIdentityLocalPhoneModule$PhoneNumCallback.a(paramInt, paramException);
  }
  
  public void a(List<GetLocalPhone.LocalPhoneCodeData> paramList)
  {
    paramList = LocalPhoneServlet.a(LocalPhoneModule.a(this.jdField_a_of_type_ComTencentMobileqqAppIdentityLocalPhoneModule), LocalPhoneModule.a(this.jdField_a_of_type_ComTencentMobileqqAppIdentityLocalPhoneModule), LocalPhoneModule.b(this.jdField_a_of_type_ComTencentMobileqqAppIdentityLocalPhoneModule), LocalPhoneModule.c(this.jdField_a_of_type_ComTencentMobileqqAppIdentityLocalPhoneModule), "", "", LocalPhoneModule.d(this.jdField_a_of_type_ComTencentMobileqqAppIdentityLocalPhoneModule), paramList);
    LocalPhoneModule.a(this.jdField_a_of_type_ComTencentMobileqqAppIdentityLocalPhoneModule, paramList, this.jdField_a_of_type_ComTencentMobileqqAppIdentityLocalPhoneModule$PhoneNumCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.identity.LocalPhoneModule.2
 * JD-Core Version:    0.7.0.1
 */