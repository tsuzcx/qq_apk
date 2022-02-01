package com.tencent.mobileqq.ar.model;

import aoty;
import aouc;
import aouf;
import apew;
import com.tencent.qphone.base.util.QLog;

public class UniformGLRenderManagerImpl$2
  implements Runnable
{
  public UniformGLRenderManagerImpl$2(apew paramapew, aoty paramaoty, aouc paramaouc) {}
  
  public void run()
  {
    aoty localaoty = this.jdField_a_of_type_Aoty;
    apew localapew = this.this$0;
    int i = apew.jdField_a_of_type_Int;
    localapew = this.this$0;
    localaoty.a(i, apew.b);
    localaoty = this.this$0.jdField_a_of_type_Aoty;
    this.this$0.jdField_a_of_type_Aoty = this.jdField_a_of_type_Aoty;
    if (QLog.isColorLevel()) {
      QLog.d("HSRender", 2, "onARStateChanged, queueEvent");
    }
    if ((localaoty != null) && (localaoty != this.this$0.jdField_a_of_type_Aoty)) {
      localaoty.f();
    }
    if (this.this$0.jdField_a_of_type_Aoty == null) {
      return;
    }
    if ((this.jdField_a_of_type_Aouc.jdField_a_of_type_Int == 5) && ((this.jdField_a_of_type_Aouc.jdField_a_of_type_Long == 2L) || (this.jdField_a_of_type_Aouc.jdField_a_of_type_Long == 2048L))) {}
    for (boolean bool = true;; bool = false)
    {
      this.this$0.jdField_a_of_type_Aouf.a();
      this.this$0.jdField_a_of_type_Aouf.a(bool, this.jdField_a_of_type_Aouc);
      this.this$0.jdField_a_of_type_Aoty.c();
      this.this$0.jdField_a_of_type_Aoty.d();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.UniformGLRenderManagerImpl.2
 * JD-Core Version:    0.7.0.1
 */