package com.tencent.mobileqq.ark.API;

import android.text.TextUtils;
import java.util.HashMap;

class ArkAppQQModule$25
  implements ArkQQAPIIPCModule.LoginHandler.OnLoginEventHandler
{
  ArkAppQQModule$25(ArkAppQQModule paramArkAppQQModule, long paramLong) {}
  
  public void a(String paramString1, long paramLong, String paramString2, String paramString3)
  {
    if ((paramLong > 0L) && (!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString3)))
    {
      paramString1 = this.jdField_a_of_type_ComTencentMobileqqArkAPIArkAppQQModule.a + "_" + paramLong + "_" + paramString1;
      ArkAppQQModule.a(this.jdField_a_of_type_ComTencentMobileqqArkAPIArkAppQQModule).put(paramString1, paramString2);
      ArkAppQQModule.b(this.jdField_a_of_type_ComTencentMobileqqArkAPIArkAppQQModule).put(paramString1, paramString3);
      ArkAppQQModule.c(this.jdField_a_of_type_ComTencentMobileqqArkAPIArkAppQQModule).put(this.jdField_a_of_type_ComTencentMobileqqArkAPIArkAppQQModule.a, String.valueOf(paramLong));
    }
    ArkAppQQModule.a(this.jdField_a_of_type_ComTencentMobileqqArkAPIArkAppQQModule, paramString2, paramString3, this.jdField_a_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppQQModule.25
 * JD-Core Version:    0.7.0.1
 */