package com.tencent.mobileqq.ar.model;

import amqs;
import amqw;
import amqz;
import anbw;
import com.tencent.qphone.base.util.QLog;

public class UniformGLRenderManagerImpl$2
  implements Runnable
{
  public UniformGLRenderManagerImpl$2(anbw paramanbw, amqs paramamqs, amqw paramamqw) {}
  
  public void run()
  {
    amqs localamqs = this.jdField_a_of_type_Amqs;
    anbw localanbw = this.this$0;
    int i = anbw.jdField_a_of_type_Int;
    localanbw = this.this$0;
    localamqs.a(i, anbw.b);
    localamqs = this.this$0.jdField_a_of_type_Amqs;
    this.this$0.jdField_a_of_type_Amqs = this.jdField_a_of_type_Amqs;
    if (QLog.isColorLevel()) {
      QLog.d("HSRender", 2, "onARStateChanged, queueEvent");
    }
    if ((localamqs != null) && (localamqs != this.this$0.jdField_a_of_type_Amqs)) {
      localamqs.f();
    }
    if (this.this$0.jdField_a_of_type_Amqs == null) {
      return;
    }
    if ((this.jdField_a_of_type_Amqw.jdField_a_of_type_Int == 5) && ((this.jdField_a_of_type_Amqw.jdField_a_of_type_Long == 2L) || (this.jdField_a_of_type_Amqw.jdField_a_of_type_Long == 2048L))) {}
    for (boolean bool = true;; bool = false)
    {
      this.this$0.jdField_a_of_type_Amqz.a();
      this.this$0.jdField_a_of_type_Amqz.a(bool, this.jdField_a_of_type_Amqw);
      this.this$0.jdField_a_of_type_Amqs.c();
      this.this$0.jdField_a_of_type_Amqs.d();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.UniformGLRenderManagerImpl.2
 * JD-Core Version:    0.7.0.1
 */