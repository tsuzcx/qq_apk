package com.tencent.mobileqq.ark.API;

import android.os.Bundle;

final class ArkQQAPIIPCModule$9
  extends ArkQQAPIIPCModule.MethodLogin
{
  ArkQQAPIIPCModule$9(long paramLong1, long paramLong2, ArkQQAPIIPCModule.LoginHandler.OnLoginEventHandler paramOnLoginEventHandler, long paramLong3)
  {
    super(paramLong1, paramLong2);
  }
  
  public void a(boolean paramBoolean, Bundle paramBundle)
  {
    String str2 = null;
    String str3;
    String str1;
    if (paramBoolean)
    {
      str3 = paramBundle.getString("userAccount", null);
      str1 = paramBundle.getString("userAccount", null);
      str2 = paramBundle.getString("openToken", null);
    }
    for (paramBundle = str3;; paramBundle = null)
    {
      this.jdField_a_of_type_ComTencentMobileqqArkAPIArkQQAPIIPCModule$LoginHandler$OnLoginEventHandler.a(paramBundle, this.jdField_a_of_type_Long, str1, str2);
      return;
      str1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkQQAPIIPCModule.9
 * JD-Core Version:    0.7.0.1
 */