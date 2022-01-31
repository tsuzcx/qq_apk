package com.tencent.mobileqq.ar.model;

import aksq;
import akwn;
import com.tencent.qphone.base.util.QLog;

public class QQARSession$28
  implements Runnable
{
  public QQARSession$28(akwn paramakwn) {}
  
  public void run()
  {
    if ((this.this$0.jdField_a_of_type_Int != 2) || (!akwn.a(this.this$0)))
    {
      QLog.d("AREngine_QQARSession", 1, String.format("enterIntoCertainWorkStatus with error status so return", new Object[0]));
      return;
    }
    if (this.this$0.d())
    {
      this.this$0.l();
      akwn.c(this.this$0, 0L);
      akwn.a(this.this$0, null);
      akwn.b(this.this$0, null);
    }
    this.this$0.a(5L);
    akwn.d(this.this$0);
    this.this$0.b = false;
    if (this.this$0.jdField_a_of_type_Aksq != null) {
      this.this$0.jdField_a_of_type_Aksq.a(true, akwn.a(this.this$0), akwn.b(this.this$0));
    }
    akwn.a(this.this$0, 1);
    this.this$0.c = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.QQARSession.28
 * JD-Core Version:    0.7.0.1
 */