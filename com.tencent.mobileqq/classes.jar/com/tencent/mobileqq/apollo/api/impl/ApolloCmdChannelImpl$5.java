package com.tencent.mobileqq.apollo.api.impl;

import com.tencent.mobileqq.apollo.IApolloRunnableTask;
import com.tencent.mobileqq.apollo.api.render.IRenderRunner;
import com.tencent.qphone.base.util.QLog;

class ApolloCmdChannelImpl$5
  extends IApolloRunnableTask
{
  ApolloCmdChannelImpl$5(ApolloCmdChannelImpl paramApolloCmdChannelImpl, IRenderRunner paramIRenderRunner, String paramString) {}
  
  public String a()
  {
    return "handleWebEvent";
  }
  
  public void run()
  {
    this.this$0.callbackEngineWrapper(this.jdField_a_of_type_ComTencentMobileqqApolloApiRenderIRenderRunner.isJsRuntime(), this.jdField_a_of_type_ComTencentMobileqqApolloApiRenderIRenderRunner.getRuntimeState(), 0, "sc.apolloGameWebMessage.local", this.jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_cmgame_process.ApolloDataChannel", 2, "handleWebEvent data:" + this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.impl.ApolloCmdChannelImpl.5
 * JD-Core Version:    0.7.0.1
 */