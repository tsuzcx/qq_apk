package com.tencent.mobileqq.ar.codeEngine;

import com.tencent.mobileqq.ar.BaseArConfigListener;
import com.tencent.mobileqq.ar.RemoteArConfigManager;
import com.tencent.qphone.base.util.QLog;

class MiniCodeController$MiniCodeBaseArConfigListener
  extends BaseArConfigListener
{
  private final RemoteArConfigManager jdField_a_of_type_ComTencentMobileqqArRemoteArConfigManager;
  
  public MiniCodeController$MiniCodeBaseArConfigListener(MiniCodeController paramMiniCodeController, RemoteArConfigManager paramRemoteArConfigManager)
  {
    this.jdField_a_of_type_ComTencentMobileqqArRemoteArConfigManager = paramRemoteArConfigManager;
  }
  
  public void a()
  {
    MiniCodeController.a(this.jdField_a_of_type_ComTencentMobileqqArCodeEngineMiniCodeController, true);
    MiniCodeController.b(this.jdField_a_of_type_ComTencentMobileqqArCodeEngineMiniCodeController, false);
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqArRemoteArConfigManager.c();
    if (QLog.isColorLevel()) {
      QLog.i("MiniRecog.MiniCodeController", 2, String.format("onConnectReady isMiniResConfigReady=%b", new Object[] { Boolean.valueOf(bool) }));
    }
    this.jdField_a_of_type_ComTencentMobileqqArCodeEngineMiniCodeController.a();
    this.jdField_a_of_type_ComTencentMobileqqArCodeEngineMiniCodeController.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.codeEngine.MiniCodeController.MiniCodeBaseArConfigListener
 * JD-Core Version:    0.7.0.1
 */