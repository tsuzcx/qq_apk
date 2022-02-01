package com.tencent.mobileqq.ar.model;

import aoci;
import aohs;
import aolr;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;

public class QQARSession$24
  implements Runnable
{
  public QQARSession$24(aolr paramaolr, int paramInt) {}
  
  public void run()
  {
    if (!aolr.a(this.this$0).d())
    {
      if (aolr.a(this.this$0).j()) {
        aolr.c(this.this$0);
      }
      if (aolr.a(this.this$0) != 1L) {
        break label132;
      }
      this.this$0.b(1L);
      aolr.b(this.this$0);
    }
    for (;;)
    {
      this.this$0.m();
      if ((aolr.b(this.this$0)) && (this.this$0.a == 2) && (aolr.a(this.this$0) != null))
      {
        aoci localaoci = new aoci(aolr.a(this.this$0));
        aolr.a(this.this$0).a(3, localaoci, this.a);
      }
      return;
      label132:
      if (aolr.a(this.this$0) == 2L) {
        this.this$0.o();
      } else if (aolr.a(this.this$0) == 2048L) {
        this.this$0.q();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.QQARSession.24
 * JD-Core Version:    0.7.0.1
 */