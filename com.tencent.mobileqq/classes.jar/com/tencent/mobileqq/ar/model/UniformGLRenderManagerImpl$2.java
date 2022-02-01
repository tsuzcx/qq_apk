package com.tencent.mobileqq.ar.model;

import apho;
import aphs;
import aphv;
import apsm;
import com.tencent.qphone.base.util.QLog;

public class UniformGLRenderManagerImpl$2
  implements Runnable
{
  public UniformGLRenderManagerImpl$2(apsm paramapsm, apho paramapho, aphs paramaphs) {}
  
  public void run()
  {
    apho localapho = this.jdField_a_of_type_Apho;
    apsm localapsm = this.this$0;
    int i = apsm.jdField_a_of_type_Int;
    localapsm = this.this$0;
    localapho.a(i, apsm.b);
    localapho = this.this$0.jdField_a_of_type_Apho;
    this.this$0.jdField_a_of_type_Apho = this.jdField_a_of_type_Apho;
    if (QLog.isColorLevel()) {
      QLog.d("HSRender", 2, "onARStateChanged, queueEvent");
    }
    if ((localapho != null) && (localapho != this.this$0.jdField_a_of_type_Apho)) {
      localapho.f();
    }
    if (this.this$0.jdField_a_of_type_Apho == null) {
      return;
    }
    if ((this.jdField_a_of_type_Aphs.jdField_a_of_type_Int == 5) && ((this.jdField_a_of_type_Aphs.jdField_a_of_type_Long == 2L) || (this.jdField_a_of_type_Aphs.jdField_a_of_type_Long == 2048L))) {}
    for (boolean bool = true;; bool = false)
    {
      this.this$0.jdField_a_of_type_Aphv.a();
      this.this$0.jdField_a_of_type_Aphv.a(bool, this.jdField_a_of_type_Aphs);
      this.this$0.jdField_a_of_type_Apho.c();
      this.this$0.jdField_a_of_type_Apho.d();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.UniformGLRenderManagerImpl.2
 * JD-Core Version:    0.7.0.1
 */