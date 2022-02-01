package com.tencent.mobileqq.apollo.ipc;

import android.os.Bundle;
import com.tencent.mobileqq.apollo.res.api.IApolloResManager.ApolloDressInfoListener;
import eipc.EIPCResult;
import java.util.HashMap;

class ApolloIPCModule$2
  implements IApolloResManager.ApolloDressInfoListener
{
  ApolloIPCModule$2(ApolloIPCModule paramApolloIPCModule, Bundle paramBundle, int paramInt) {}
  
  public void a(HashMap<Integer, String> paramHashMap, String paramString, int paramInt)
  {
    EIPCResult localEIPCResult = new EIPCResult();
    if (paramHashMap != null) {
      paramInt = 0;
    }
    localEIPCResult.code = paramInt;
    localEIPCResult.data = this.jdField_a_of_type_AndroidOsBundle;
    localEIPCResult.data.putSerializable("apolloDressInfo", paramHashMap);
    localEIPCResult.data.putString("apolloErrMsg", paramString);
    this.jdField_a_of_type_ComTencentMobileqqApolloIpcApolloIPCModule.callbackResult(this.jdField_a_of_type_Int, localEIPCResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ipc.ApolloIPCModule.2
 * JD-Core Version:    0.7.0.1
 */