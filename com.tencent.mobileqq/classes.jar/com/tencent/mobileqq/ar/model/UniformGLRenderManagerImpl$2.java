package com.tencent.mobileqq.ar.model;

import com.tencent.mobileqq.ar.ARRenderModel.ARBaseRender;
import com.tencent.mobileqq.ar.ARRenderModel.ARRenderResourceInfo;
import com.tencent.mobileqq.ar.ARRenderModel.ARRenerArumentManager;
import com.tencent.qphone.base.util.QLog;

class UniformGLRenderManagerImpl$2
  implements Runnable
{
  UniformGLRenderManagerImpl$2(UniformGLRenderManagerImpl paramUniformGLRenderManagerImpl, ARBaseRender paramARBaseRender, ARRenderResourceInfo paramARRenderResourceInfo) {}
  
  public void run()
  {
    ARBaseRender localARBaseRender = this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARBaseRender;
    UniformGLRenderManagerImpl localUniformGLRenderManagerImpl = this.this$0;
    int i = UniformGLRenderManagerImpl.jdField_a_of_type_Int;
    localUniformGLRenderManagerImpl = this.this$0;
    localARBaseRender.a(i, UniformGLRenderManagerImpl.b);
    localARBaseRender = this.this$0.jdField_a_of_type_ComTencentMobileqqArARRenderModelARBaseRender;
    this.this$0.jdField_a_of_type_ComTencentMobileqqArARRenderModelARBaseRender = this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARBaseRender;
    if (QLog.isColorLevel()) {
      QLog.d("HSRender", 2, "onARStateChanged, queueEvent");
    }
    if ((localARBaseRender != null) && (localARBaseRender != this.this$0.jdField_a_of_type_ComTencentMobileqqArARRenderModelARBaseRender)) {
      localARBaseRender.f();
    }
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqArARRenderModelARBaseRender == null) {
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderResourceInfo.jdField_a_of_type_Int == 5) && ((this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderResourceInfo.jdField_a_of_type_Long == 2L) || (this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderResourceInfo.jdField_a_of_type_Long == 2048L))) {}
    for (boolean bool = true;; bool = false)
    {
      this.this$0.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenerArumentManager.a();
      this.this$0.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenerArumentManager.a(bool, this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderResourceInfo);
      this.this$0.jdField_a_of_type_ComTencentMobileqqArARRenderModelARBaseRender.c();
      this.this$0.jdField_a_of_type_ComTencentMobileqqArARRenderModelARBaseRender.d();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.UniformGLRenderManagerImpl.2
 * JD-Core Version:    0.7.0.1
 */