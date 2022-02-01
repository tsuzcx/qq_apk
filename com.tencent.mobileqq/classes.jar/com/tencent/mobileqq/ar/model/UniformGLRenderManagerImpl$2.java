package com.tencent.mobileqq.ar.model;

import aped;
import apeh;
import apek;
import appa;
import com.tencent.qphone.base.util.QLog;

public class UniformGLRenderManagerImpl$2
  implements Runnable
{
  public UniformGLRenderManagerImpl$2(appa paramappa, aped paramaped, apeh paramapeh) {}
  
  public void run()
  {
    aped localaped = this.jdField_a_of_type_Aped;
    appa localappa = this.this$0;
    int i = appa.jdField_a_of_type_Int;
    localappa = this.this$0;
    localaped.a(i, appa.b);
    localaped = this.this$0.jdField_a_of_type_Aped;
    this.this$0.jdField_a_of_type_Aped = this.jdField_a_of_type_Aped;
    if (QLog.isColorLevel()) {
      QLog.d("HSRender", 2, "onARStateChanged, queueEvent");
    }
    if ((localaped != null) && (localaped != this.this$0.jdField_a_of_type_Aped)) {
      localaped.f();
    }
    if (this.this$0.jdField_a_of_type_Aped == null) {
      return;
    }
    if ((this.jdField_a_of_type_Apeh.jdField_a_of_type_Int == 5) && ((this.jdField_a_of_type_Apeh.jdField_a_of_type_Long == 2L) || (this.jdField_a_of_type_Apeh.jdField_a_of_type_Long == 2048L))) {}
    for (boolean bool = true;; bool = false)
    {
      this.this$0.jdField_a_of_type_Apek.a();
      this.this$0.jdField_a_of_type_Apek.a(bool, this.jdField_a_of_type_Apeh);
      this.this$0.jdField_a_of_type_Aped.c();
      this.this$0.jdField_a_of_type_Aped.d();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.UniformGLRenderManagerImpl.2
 * JD-Core Version:    0.7.0.1
 */