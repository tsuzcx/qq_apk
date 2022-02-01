package com.tencent.mobileqq.ar.model;

import apiv;
import apof;
import apse;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;

public class QQARSession$24
  implements Runnable
{
  public QQARSession$24(apse paramapse, int paramInt) {}
  
  public void run()
  {
    if (!apse.a(this.this$0).d())
    {
      if (apse.a(this.this$0).j()) {
        apse.c(this.this$0);
      }
      if (apse.a(this.this$0) != 1L) {
        break label132;
      }
      this.this$0.b(1L);
      apse.b(this.this$0);
    }
    for (;;)
    {
      this.this$0.k();
      if ((apse.b(this.this$0)) && (this.this$0.a == 2) && (apse.a(this.this$0) != null))
      {
        apiv localapiv = new apiv(apse.a(this.this$0));
        apse.a(this.this$0).a(3, localapiv, this.a);
      }
      return;
      label132:
      if (apse.a(this.this$0) == 2L) {
        this.this$0.m();
      } else if (apse.a(this.this$0) == 2048L) {
        this.this$0.o();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.QQARSession.24
 * JD-Core Version:    0.7.0.1
 */