package com.tencent.mobileqq.apollo;

import com.tencent.mobileqq.apollo.screenshot.ApolloAvatarVideoProcessor.OnProcessFinishListener;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

class ApolloClientQIPCModule$1
  implements ApolloAvatarVideoProcessor.OnProcessFinishListener
{
  ApolloClientQIPCModule$1(ApolloClientQIPCModule paramApolloClientQIPCModule, int paramInt1, int paramInt2) {}
  
  public void a(boolean paramBoolean, int paramInt)
  {
    paramInt = 1;
    if (QLog.isColorLevel()) {
      QLog.i("cm_res", 1, "handleSetAvatar isDynamic: " + this.jdField_a_of_type_Int + " isSuccess:" + paramBoolean);
    }
    EIPCResult localEIPCResult = new EIPCResult();
    if (paramBoolean) {
      paramInt = 0;
    }
    localEIPCResult.code = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqApolloApolloClientQIPCModule.callbackResult(this.b, localEIPCResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloClientQIPCModule.1
 * JD-Core Version:    0.7.0.1
 */