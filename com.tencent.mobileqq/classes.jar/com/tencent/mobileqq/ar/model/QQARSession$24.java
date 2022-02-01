package com.tencent.mobileqq.ar.model;

import aovf;
import apap;
import apeo;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;

public class QQARSession$24
  implements Runnable
{
  public QQARSession$24(apeo paramapeo, int paramInt) {}
  
  public void run()
  {
    if (!apeo.a(this.this$0).d())
    {
      if (apeo.a(this.this$0).j()) {
        apeo.c(this.this$0);
      }
      if (apeo.a(this.this$0) != 1L) {
        break label132;
      }
      this.this$0.b(1L);
      apeo.b(this.this$0);
    }
    for (;;)
    {
      this.this$0.k();
      if ((apeo.b(this.this$0)) && (this.this$0.a == 2) && (apeo.a(this.this$0) != null))
      {
        aovf localaovf = new aovf(apeo.a(this.this$0));
        apeo.a(this.this$0).a(3, localaovf, this.a);
      }
      return;
      label132:
      if (apeo.a(this.this$0) == 2L) {
        this.this$0.m();
      } else if (apeo.a(this.this$0) == 2048L) {
        this.this$0.o();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.QQARSession.24
 * JD-Core Version:    0.7.0.1
 */