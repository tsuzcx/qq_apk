package com.tencent.mobileqq.apollo;

import android.os.Bundle;
import com.tencent.mobileqq.apollo.api.res.IApolloResManager.ApolloDressInfoListener;
import eipc.EIPCResult;
import java.util.HashMap;

class ApolloClientQIPCModule$6
  implements IApolloResManager.ApolloDressInfoListener
{
  ApolloClientQIPCModule$6(ApolloClientQIPCModule paramApolloClientQIPCModule, Bundle paramBundle, int paramInt) {}
  
  public void a(HashMap<Integer, String> paramHashMap, String paramString, int paramInt)
  {
    EIPCResult localEIPCResult = new EIPCResult();
    if (paramHashMap == null) {}
    for (;;)
    {
      localEIPCResult.code = paramInt;
      localEIPCResult.data = this.jdField_a_of_type_AndroidOsBundle;
      localEIPCResult.data.putSerializable("apolloDressInfo", paramHashMap);
      localEIPCResult.data.putString("apolloErrMsg", paramString);
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloClientQIPCModule.callbackResult(this.jdField_a_of_type_Int, localEIPCResult);
      return;
      paramInt = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloClientQIPCModule.6
 * JD-Core Version:    0.7.0.1
 */