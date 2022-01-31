package com.tencent.mobileqq.ar.model;

import amvh;
import amvl;
import amvo;
import angf;
import com.tencent.qphone.base.util.QLog;

public class UniformGLRenderManagerImpl$2
  implements Runnable
{
  public UniformGLRenderManagerImpl$2(angf paramangf, amvh paramamvh, amvl paramamvl) {}
  
  public void run()
  {
    amvh localamvh = this.jdField_a_of_type_Amvh;
    angf localangf = this.this$0;
    int i = angf.jdField_a_of_type_Int;
    localangf = this.this$0;
    localamvh.a(i, angf.b);
    localamvh = this.this$0.jdField_a_of_type_Amvh;
    this.this$0.jdField_a_of_type_Amvh = this.jdField_a_of_type_Amvh;
    if (QLog.isColorLevel()) {
      QLog.d("HSRender", 2, "onARStateChanged, queueEvent");
    }
    if ((localamvh != null) && (localamvh != this.this$0.jdField_a_of_type_Amvh)) {
      localamvh.f();
    }
    if (this.this$0.jdField_a_of_type_Amvh == null) {
      return;
    }
    if ((this.jdField_a_of_type_Amvl.jdField_a_of_type_Int == 5) && ((this.jdField_a_of_type_Amvl.jdField_a_of_type_Long == 2L) || (this.jdField_a_of_type_Amvl.jdField_a_of_type_Long == 2048L))) {}
    for (boolean bool = true;; bool = false)
    {
      this.this$0.jdField_a_of_type_Amvo.a();
      this.this$0.jdField_a_of_type_Amvo.a(bool, this.jdField_a_of_type_Amvl);
      this.this$0.jdField_a_of_type_Amvh.c();
      this.this$0.jdField_a_of_type_Amvh.d();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.UniformGLRenderManagerImpl.2
 * JD-Core Version:    0.7.0.1
 */