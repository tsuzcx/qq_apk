package com.tencent.mobileqq.apollo.aioChannel;

import akrx;
import com.tencent.mobileqq.apollo.IApolloRunnableTask;
import com.tencent.qphone.base.util.QLog;

class ApolloCmdChannel$5
  extends IApolloRunnableTask
{
  ApolloCmdChannel$5(ApolloCmdChannel paramApolloCmdChannel, akrx paramakrx, String paramString) {}
  
  public String a()
  {
    return "handleWebEvent";
  }
  
  public void run()
  {
    this.this$0.callbackEngineWrapper(this.jdField_a_of_type_Akrx.isJsRuntime(), this.jdField_a_of_type_Akrx.getRuntimeState(), 0, "sc.apolloGameWebMessage.local", this.jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.ApolloDataChannel", 2, "handleWebEvent data:" + this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel.5
 * JD-Core Version:    0.7.0.1
 */