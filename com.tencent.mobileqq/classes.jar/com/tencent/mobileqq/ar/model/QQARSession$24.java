package com.tencent.mobileqq.ar.model;

import apfk;
import apku;
import apos;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;

public class QQARSession$24
  implements Runnable
{
  public QQARSession$24(apos paramapos, int paramInt) {}
  
  public void run()
  {
    if (!apos.a(this.this$0).d())
    {
      if (apos.a(this.this$0).j()) {
        apos.c(this.this$0);
      }
      if (apos.a(this.this$0) != 1L) {
        break label132;
      }
      this.this$0.b(1L);
      apos.b(this.this$0);
    }
    for (;;)
    {
      this.this$0.m();
      if ((apos.b(this.this$0)) && (this.this$0.a == 2) && (apos.a(this.this$0) != null))
      {
        apfk localapfk = new apfk(apos.a(this.this$0));
        apos.a(this.this$0).a(3, localapfk, this.a);
      }
      return;
      label132:
      if (apos.a(this.this$0) == 2L) {
        this.this$0.o();
      } else if (apos.a(this.this$0) == 2048L) {
        this.this$0.q();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.QQARSession.24
 * JD-Core Version:    0.7.0.1
 */