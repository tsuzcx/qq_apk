package com.tencent.mobileqq.ar.model;

import apar;
import apeo;
import com.tencent.qphone.base.util.QLog;

public class QQARSession$28
  implements Runnable
{
  public QQARSession$28(apeo paramapeo) {}
  
  public void run()
  {
    if ((this.this$0.jdField_a_of_type_Int != 2) || (!apeo.a(this.this$0)))
    {
      QLog.d("AREngine_QQARSession", 1, String.format("enterIntoCertainWorkStatus with error status so return", new Object[0]));
      return;
    }
    if (this.this$0.d())
    {
      this.this$0.l();
      apeo.c(this.this$0, 0L);
      apeo.a(this.this$0, null);
      apeo.b(this.this$0, null);
    }
    this.this$0.a(5L);
    apeo.d(this.this$0);
    this.this$0.b = false;
    if (this.this$0.jdField_a_of_type_Apar != null) {
      this.this$0.jdField_a_of_type_Apar.a(true, apeo.a(this.this$0), apeo.b(this.this$0));
    }
    apeo.a(this.this$0, 1);
    this.this$0.c = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.QQARSession.28
 * JD-Core Version:    0.7.0.1
 */