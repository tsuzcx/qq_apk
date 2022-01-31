package com.tencent.mobileqq.ar.model;

import aklr;
import aklv;
import akly;
import akwv;
import com.tencent.qphone.base.util.QLog;

public class UniformGLRenderManagerImpl$2
  implements Runnable
{
  public UniformGLRenderManagerImpl$2(akwv paramakwv, aklr paramaklr, aklv paramaklv) {}
  
  public void run()
  {
    aklr localaklr = this.jdField_a_of_type_Aklr;
    akwv localakwv = this.this$0;
    int i = akwv.jdField_a_of_type_Int;
    localakwv = this.this$0;
    localaklr.a(i, akwv.b);
    localaklr = this.this$0.jdField_a_of_type_Aklr;
    this.this$0.jdField_a_of_type_Aklr = this.jdField_a_of_type_Aklr;
    if (QLog.isColorLevel()) {
      QLog.d("HSRender", 2, "onARStateChanged, queueEvent");
    }
    if ((localaklr != null) && (localaklr != this.this$0.jdField_a_of_type_Aklr)) {
      localaklr.f();
    }
    if (this.this$0.jdField_a_of_type_Aklr == null) {
      return;
    }
    if ((this.jdField_a_of_type_Aklv.jdField_a_of_type_Int == 5) && ((this.jdField_a_of_type_Aklv.jdField_a_of_type_Long == 2L) || (this.jdField_a_of_type_Aklv.jdField_a_of_type_Long == 2048L))) {}
    for (boolean bool = true;; bool = false)
    {
      this.this$0.jdField_a_of_type_Akly.a();
      this.this$0.jdField_a_of_type_Akly.a(bool, this.jdField_a_of_type_Aklv);
      this.this$0.jdField_a_of_type_Aklr.c();
      this.this$0.jdField_a_of_type_Aklr.d();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.UniformGLRenderManagerImpl.2
 * JD-Core Version:    0.7.0.1
 */