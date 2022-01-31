package com.tencent.mobileqq.ar.model;

import alad;
import alah;
import alak;
import allh;
import com.tencent.qphone.base.util.QLog;

public class UniformGLRenderManagerImpl$2
  implements Runnable
{
  public UniformGLRenderManagerImpl$2(allh paramallh, alad paramalad, alah paramalah) {}
  
  public void run()
  {
    alad localalad = this.jdField_a_of_type_Alad;
    allh localallh = this.this$0;
    int i = allh.jdField_a_of_type_Int;
    localallh = this.this$0;
    localalad.a(i, allh.b);
    localalad = this.this$0.jdField_a_of_type_Alad;
    this.this$0.jdField_a_of_type_Alad = this.jdField_a_of_type_Alad;
    if (QLog.isColorLevel()) {
      QLog.d("HSRender", 2, "onARStateChanged, queueEvent");
    }
    if ((localalad != null) && (localalad != this.this$0.jdField_a_of_type_Alad)) {
      localalad.f();
    }
    if (this.this$0.jdField_a_of_type_Alad == null) {
      return;
    }
    if ((this.jdField_a_of_type_Alah.jdField_a_of_type_Int == 5) && ((this.jdField_a_of_type_Alah.jdField_a_of_type_Long == 2L) || (this.jdField_a_of_type_Alah.jdField_a_of_type_Long == 2048L))) {}
    for (boolean bool = true;; bool = false)
    {
      this.this$0.jdField_a_of_type_Alak.a();
      this.this$0.jdField_a_of_type_Alak.a(bool, this.jdField_a_of_type_Alah);
      this.this$0.jdField_a_of_type_Alad.c();
      this.this$0.jdField_a_of_type_Alad.d();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.UniformGLRenderManagerImpl.2
 * JD-Core Version:    0.7.0.1
 */