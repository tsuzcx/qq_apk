package com.tencent.mobileqq.ar.model;

import aksq;
import akwn;

public class QQARSession$29
  implements Runnable
{
  public void run()
  {
    if ((this.this$0.jdField_a_of_type_Int != 2) || (!akwn.a(this.this$0))) {
      return;
    }
    if (this.this$0.jdField_a_of_type_Aksq != null) {
      this.this$0.jdField_a_of_type_Aksq.a(false, akwn.a(this.this$0), akwn.b(this.this$0));
    }
    akwn.a(this.this$0, 0);
    this.this$0.c = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.QQARSession.29
 * JD-Core Version:    0.7.0.1
 */