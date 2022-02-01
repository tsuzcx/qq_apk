package com.tencent.mobileqq.ar.model;

import aobb;
import aobf;
import aobi;
import aolz;
import com.tencent.qphone.base.util.QLog;

public class UniformGLRenderManagerImpl$2
  implements Runnable
{
  public UniformGLRenderManagerImpl$2(aolz paramaolz, aobb paramaobb, aobf paramaobf) {}
  
  public void run()
  {
    aobb localaobb = this.jdField_a_of_type_Aobb;
    aolz localaolz = this.this$0;
    int i = aolz.jdField_a_of_type_Int;
    localaolz = this.this$0;
    localaobb.a(i, aolz.b);
    localaobb = this.this$0.jdField_a_of_type_Aobb;
    this.this$0.jdField_a_of_type_Aobb = this.jdField_a_of_type_Aobb;
    if (QLog.isColorLevel()) {
      QLog.d("HSRender", 2, "onARStateChanged, queueEvent");
    }
    if ((localaobb != null) && (localaobb != this.this$0.jdField_a_of_type_Aobb)) {
      localaobb.f();
    }
    if (this.this$0.jdField_a_of_type_Aobb == null) {
      return;
    }
    if ((this.jdField_a_of_type_Aobf.jdField_a_of_type_Int == 5) && ((this.jdField_a_of_type_Aobf.jdField_a_of_type_Long == 2L) || (this.jdField_a_of_type_Aobf.jdField_a_of_type_Long == 2048L))) {}
    for (boolean bool = true;; bool = false)
    {
      this.this$0.jdField_a_of_type_Aobi.a();
      this.this$0.jdField_a_of_type_Aobi.a(bool, this.jdField_a_of_type_Aobf);
      this.this$0.jdField_a_of_type_Aobb.c();
      this.this$0.jdField_a_of_type_Aobb.d();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.UniformGLRenderManagerImpl.2
 * JD-Core Version:    0.7.0.1
 */