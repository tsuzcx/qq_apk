package com.tencent.mobileqq.ar.model;

import alac;
import alag;
import alaj;
import allg;
import com.tencent.qphone.base.util.QLog;

public class UniformGLRenderManagerImpl$2
  implements Runnable
{
  public UniformGLRenderManagerImpl$2(allg paramallg, alac paramalac, alag paramalag) {}
  
  public void run()
  {
    alac localalac = this.jdField_a_of_type_Alac;
    allg localallg = this.this$0;
    int i = allg.jdField_a_of_type_Int;
    localallg = this.this$0;
    localalac.a(i, allg.b);
    localalac = this.this$0.jdField_a_of_type_Alac;
    this.this$0.jdField_a_of_type_Alac = this.jdField_a_of_type_Alac;
    if (QLog.isColorLevel()) {
      QLog.d("HSRender", 2, "onARStateChanged, queueEvent");
    }
    if ((localalac != null) && (localalac != this.this$0.jdField_a_of_type_Alac)) {
      localalac.f();
    }
    if (this.this$0.jdField_a_of_type_Alac == null) {
      return;
    }
    if ((this.jdField_a_of_type_Alag.jdField_a_of_type_Int == 5) && ((this.jdField_a_of_type_Alag.jdField_a_of_type_Long == 2L) || (this.jdField_a_of_type_Alag.jdField_a_of_type_Long == 2048L))) {}
    for (boolean bool = true;; bool = false)
    {
      this.this$0.jdField_a_of_type_Alaj.a();
      this.this$0.jdField_a_of_type_Alaj.a(bool, this.jdField_a_of_type_Alag);
      this.this$0.jdField_a_of_type_Alac.c();
      this.this$0.jdField_a_of_type_Alac.d();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.UniformGLRenderManagerImpl.2
 * JD-Core Version:    0.7.0.1
 */