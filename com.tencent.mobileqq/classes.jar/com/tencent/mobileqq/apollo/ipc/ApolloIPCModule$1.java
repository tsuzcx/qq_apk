package com.tencent.mobileqq.apollo.ipc;

import android.os.Bundle;
import com.tencent.mobileqq.apollo.res.api.IApolloResManager.ApolloRoleInfoListener;
import eipc.EIPCResult;

class ApolloIPCModule$1
  implements IApolloResManager.ApolloRoleInfoListener
{
  ApolloIPCModule$1(ApolloIPCModule paramApolloIPCModule, Bundle paramBundle, int paramInt) {}
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    EIPCResult localEIPCResult = new EIPCResult();
    if (paramString1 != null) {
      paramInt = 0;
    }
    localEIPCResult.code = paramInt;
    localEIPCResult.data = this.jdField_a_of_type_AndroidOsBundle;
    localEIPCResult.data.putString("apolloRoleDir", paramString1);
    localEIPCResult.data.putString("apolloErrMsg", paramString2);
    this.jdField_a_of_type_ComTencentMobileqqApolloIpcApolloIPCModule.callbackResult(this.jdField_a_of_type_Int, localEIPCResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ipc.ApolloIPCModule.1
 * JD-Core Version:    0.7.0.1
 */