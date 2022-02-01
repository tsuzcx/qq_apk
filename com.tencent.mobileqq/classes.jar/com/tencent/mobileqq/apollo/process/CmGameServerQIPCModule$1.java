package com.tencent.mobileqq.apollo.process;

import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.capture.ReadInJoyCameraCaptureSoManager.Callback;
import eipc.EIPCResult;

class CmGameServerQIPCModule$1
  implements ReadInJoyCameraCaptureSoManager.Callback
{
  CmGameServerQIPCModule$1(CmGameServerQIPCModule paramCmGameServerQIPCModule, int paramInt) {}
  
  public void a(int paramInt)
  {
    CmGameServerQIPCModule.b = false;
    if (paramInt == 1)
    {
      EIPCResult localEIPCResult = EIPCResult.createResult(0, new Bundle());
      this.jdField_a_of_type_ComTencentMobileqqApolloProcessCmGameServerQIPCModule.callbackResult(this.jdField_a_of_type_Int, localEIPCResult);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.CmGameServerQIPCModule.1
 * JD-Core Version:    0.7.0.1
 */