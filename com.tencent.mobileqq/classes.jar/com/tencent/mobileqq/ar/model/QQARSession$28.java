package com.tencent.mobileqq.ar.model;

import alhb;
import alky;
import com.tencent.qphone.base.util.QLog;

public class QQARSession$28
  implements Runnable
{
  public QQARSession$28(alky paramalky) {}
  
  public void run()
  {
    if ((this.this$0.jdField_a_of_type_Int != 2) || (!alky.a(this.this$0)))
    {
      QLog.d("AREngine_QQARSession", 1, String.format("enterIntoCertainWorkStatus with error status so return", new Object[0]));
      return;
    }
    if (this.this$0.d())
    {
      this.this$0.l();
      alky.c(this.this$0, 0L);
      alky.a(this.this$0, null);
      alky.b(this.this$0, null);
    }
    this.this$0.a(5L);
    alky.d(this.this$0);
    this.this$0.b = false;
    if (this.this$0.jdField_a_of_type_Alhb != null) {
      this.this$0.jdField_a_of_type_Alhb.a(true, alky.a(this.this$0), alky.b(this.this$0));
    }
    alky.a(this.this$0, 1);
    this.this$0.c = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.QQARSession.28
 * JD-Core Version:    0.7.0.1
 */