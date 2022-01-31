package com.tencent.mobileqq.apollo.aioChannel;

import akne;
import akni;
import com.tencent.mobileqq.apollo.IApolloRunnableTask;
import com.tencent.qphone.base.util.QLog;

public class ApolloRenderRunner$1
  extends IApolloRunnableTask
{
  public ApolloRenderRunner$1(akne paramakne, akni paramakni, long paramLong, ApolloCmdChannel paramApolloCmdChannel, int paramInt, String paramString1, String paramString2) {}
  
  public String a()
  {
    return "callbackEngine_" + this.jdField_a_of_type_JavaLangString;
  }
  
  public void run()
  {
    if ((this.jdField_a_of_type_Akni != null) && (this.jdField_a_of_type_Long == this.jdField_a_of_type_Akni.getRuntimeState()))
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel.callbackEngineWrapper(this.jdField_a_of_type_Akni.isJsRuntime(), this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.b);
      if (QLog.isColorLevel()) {
        QLog.d("apollochannel_JsRenderRunner", 2, "apolloSurfaceView.queueEvent mNativeSSOReqMgr.callbackEngine cmd:" + this.jdField_a_of_type_JavaLangString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aioChannel.ApolloRenderRunner.1
 * JD-Core Version:    0.7.0.1
 */