package com.tencent.mobileqq.ark.api.module;

import android.os.Bundle;

final class ArkQQAPIIPCModule$6
  extends ArkQQAPIIPCModule.MethodLogin
{
  ArkQQAPIIPCModule$6(long paramLong1, long paramLong2, ArkQQAPIIPCModule.LoginHandler.OnLoginEventHandler paramOnLoginEventHandler, long paramLong3)
  {
    super(paramLong1, paramLong2);
  }
  
  public void a(boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject2;
    Object localObject1;
    Object localObject3;
    if (paramBoolean)
    {
      localObject2 = paramBundle.getString("userAccount", null);
      localObject1 = paramBundle.getString("userAccount", null);
      localObject3 = paramBundle.getString("openToken", null);
      paramBundle = (Bundle)localObject1;
      localObject1 = localObject3;
      localObject3 = localObject1;
    }
    else
    {
      localObject1 = null;
      paramBundle = (Bundle)localObject1;
      localObject3 = paramBundle;
      localObject2 = localObject1;
    }
    this.jdField_a_of_type_ComTencentMobileqqArkApiModuleArkQQAPIIPCModule$LoginHandler$OnLoginEventHandler.a((String)localObject2, this.jdField_a_of_type_Long, paramBundle, (String)localObject3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.module.ArkQQAPIIPCModule.6
 * JD-Core Version:    0.7.0.1
 */