package com.tencent.mobileqq.ar.model;

import apiv;
import apof;
import apse;

public class QQARSession$21
  implements Runnable
{
  public QQARSession$21(apse paramapse, int paramInt) {}
  
  public void run()
  {
    if ((apse.b(this.this$0)) && (this.this$0.a == 2) && (apse.a(this.this$0) != null))
    {
      apiv localapiv = new apiv(apse.a(this.this$0));
      apse.a(this.this$0).a(0, localapiv, this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.QQARSession.21
 * JD-Core Version:    0.7.0.1
 */