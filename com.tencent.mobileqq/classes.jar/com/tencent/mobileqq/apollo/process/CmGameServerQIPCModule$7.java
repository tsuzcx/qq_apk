package com.tencent.mobileqq.apollo.process;

import com.tencent.mobileqq.apollo.request.ApolloRequestCallbackManager.ApolloRspCallback;
import eipc.EIPCResult;

class CmGameServerQIPCModule$7
  implements ApolloRequestCallbackManager.ApolloRspCallback
{
  CmGameServerQIPCModule$7(CmGameServerQIPCModule paramCmGameServerQIPCModule, int paramInt) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString)
  {
    if (paramBoolean) {}
    for (int i = 0;; i = -1)
    {
      paramString = EIPCResult.createResult(i, null);
      this.jdField_a_of_type_ComTencentMobileqqApolloProcessCmGameServerQIPCModule.callbackResult(this.jdField_a_of_type_Int, paramString);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.CmGameServerQIPCModule.7
 * JD-Core Version:    0.7.0.1
 */