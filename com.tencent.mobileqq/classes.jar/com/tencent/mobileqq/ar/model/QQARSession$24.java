package com.tencent.mobileqq.ar.model;

import amwo;
import anby;
import anfx;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;

public class QQARSession$24
  implements Runnable
{
  public QQARSession$24(anfx paramanfx, int paramInt) {}
  
  public void run()
  {
    if (!anfx.a(this.this$0).d())
    {
      if (anfx.a(this.this$0).j()) {
        anfx.c(this.this$0);
      }
      if (anfx.a(this.this$0) != 1L) {
        break label132;
      }
      this.this$0.b(1L);
      anfx.b(this.this$0);
    }
    for (;;)
    {
      this.this$0.k();
      if ((anfx.b(this.this$0)) && (this.this$0.a == 2) && (anfx.a(this.this$0) != null))
      {
        amwo localamwo = new amwo(anfx.a(this.this$0));
        anfx.a(this.this$0).a(3, localamwo, this.a);
      }
      return;
      label132:
      if (anfx.a(this.this$0) == 2L) {
        this.this$0.m();
      } else if (anfx.a(this.this$0) == 2048L) {
        this.this$0.o();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.QQARSession.24
 * JD-Core Version:    0.7.0.1
 */