package com.tencent.mobileqq.ar.model;

import albj;
import algz;
import alky;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;

public class QQARSession$23
  implements Runnable
{
  public QQARSession$23(alky paramalky, int paramInt) {}
  
  public void run()
  {
    if (!alky.a(this.this$0).d())
    {
      if (alky.a(this.this$0).j()) {
        alky.c(this.this$0);
      }
      if (alky.a(this.this$0) != 1L) {
        break label132;
      }
      this.this$0.b(1L);
      alky.b(this.this$0);
    }
    for (;;)
    {
      this.this$0.k();
      if ((alky.b(this.this$0)) && (this.this$0.a == 2) && (alky.a(this.this$0) != null))
      {
        albj localalbj = new albj(alky.a(this.this$0));
        alky.a(this.this$0).a(2, localalbj, this.a);
      }
      return;
      label132:
      if (alky.a(this.this$0) == 2L) {
        this.this$0.m();
      } else if (alky.a(this.this$0) == 2048L) {
        this.this$0.o();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.QQARSession.23
 * JD-Core Version:    0.7.0.1
 */