package com.tencent.mobileqq.ar.model;

import amxr;
import anbo;

public class QQARSession$29
  implements Runnable
{
  public void run()
  {
    if ((this.this$0.jdField_a_of_type_Int != 2) || (!anbo.a(this.this$0))) {
      return;
    }
    if (this.this$0.jdField_a_of_type_Amxr != null) {
      this.this$0.jdField_a_of_type_Amxr.a(false, anbo.a(this.this$0), anbo.b(this.this$0));
    }
    anbo.a(this.this$0, 0);
    this.this$0.c = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.QQARSession.29
 * JD-Core Version:    0.7.0.1
 */