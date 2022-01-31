package com.tencent.mobileqq.ar.model;

import albk;
import alha;
import alkz;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;

public class QQARSession$24
  implements Runnable
{
  public QQARSession$24(alkz paramalkz, int paramInt) {}
  
  public void run()
  {
    if (!alkz.a(this.this$0).d())
    {
      if (alkz.a(this.this$0).j()) {
        alkz.c(this.this$0);
      }
      if (alkz.a(this.this$0) != 1L) {
        break label132;
      }
      this.this$0.b(1L);
      alkz.b(this.this$0);
    }
    for (;;)
    {
      this.this$0.k();
      if ((alkz.b(this.this$0)) && (this.this$0.a == 2) && (alkz.a(this.this$0) != null))
      {
        albk localalbk = new albk(alkz.a(this.this$0));
        alkz.a(this.this$0).a(3, localalbk, this.a);
      }
      return;
      label132:
      if (alkz.a(this.this$0) == 2L) {
        this.this$0.m();
      } else if (alkz.a(this.this$0) == 2048L) {
        this.this$0.o();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.QQARSession.24
 * JD-Core Version:    0.7.0.1
 */