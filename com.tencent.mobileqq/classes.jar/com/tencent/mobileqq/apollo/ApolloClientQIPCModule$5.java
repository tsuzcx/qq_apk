package com.tencent.mobileqq.apollo;

import android.os.Bundle;
import com.tencent.mobileqq.apollo.api.res.impl.ApolloResManagerImpl.ApolloRoleInfoListener;
import eipc.EIPCResult;

class ApolloClientQIPCModule$5
  implements ApolloResManagerImpl.ApolloRoleInfoListener
{
  ApolloClientQIPCModule$5(ApolloClientQIPCModule paramApolloClientQIPCModule, Bundle paramBundle, int paramInt) {}
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    EIPCResult localEIPCResult = new EIPCResult();
    if (paramString1 == null) {}
    for (;;)
    {
      localEIPCResult.code = paramInt;
      localEIPCResult.data = this.jdField_a_of_type_AndroidOsBundle;
      localEIPCResult.data.putString("apolloRoleDir", paramString1);
      localEIPCResult.data.putString("apolloErrMsg", paramString2);
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloClientQIPCModule.callbackResult(this.jdField_a_of_type_Int, localEIPCResult);
      return;
      paramInt = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloClientQIPCModule.5
 * JD-Core Version:    0.7.0.1
 */