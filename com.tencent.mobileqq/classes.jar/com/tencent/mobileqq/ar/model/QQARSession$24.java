package com.tencent.mobileqq.ar.model;

import amrz;
import amxp;
import anbo;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;

public class QQARSession$24
  implements Runnable
{
  public QQARSession$24(anbo paramanbo, int paramInt) {}
  
  public void run()
  {
    if (!anbo.a(this.this$0).d())
    {
      if (anbo.a(this.this$0).j()) {
        anbo.c(this.this$0);
      }
      if (anbo.a(this.this$0) != 1L) {
        break label132;
      }
      this.this$0.b(1L);
      anbo.b(this.this$0);
    }
    for (;;)
    {
      this.this$0.k();
      if ((anbo.b(this.this$0)) && (this.this$0.a == 2) && (anbo.a(this.this$0) != null))
      {
        amrz localamrz = new amrz(anbo.a(this.this$0));
        anbo.a(this.this$0).a(3, localamrz, this.a);
      }
      return;
      label132:
      if (anbo.a(this.this$0) == 2L) {
        this.this$0.m();
      } else if (anbo.a(this.this$0) == 2048L) {
        this.this$0.o();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.QQARSession.24
 * JD-Core Version:    0.7.0.1
 */