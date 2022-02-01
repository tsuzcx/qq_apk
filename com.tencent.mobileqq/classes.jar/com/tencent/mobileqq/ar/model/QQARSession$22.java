package com.tencent.mobileqq.ar.model;

import aoci;
import aohs;
import aolr;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.qphone.base.util.QLog;

public class QQARSession$22
  implements Runnable
{
  public QQARSession$22(aolr paramaolr, int paramInt) {}
  
  public void run()
  {
    if (aolr.a(this.this$0) == null) {
      QLog.d("AREngine_QQARSession", 1, "onARAnimationComplete mCurARResourceInfo is null!");
    }
    for (;;)
    {
      return;
      if (this.a == 0)
      {
        if (aolr.a(this.this$0).d()) {
          break label289;
        }
        if ((!aolr.a(this.this$0).h()) && (!aolr.a(this.this$0).g()) && (!aolr.a(this.this$0).k())) {
          break label191;
        }
        if ((!aolr.a(this.this$0).j()) || ((aolr.a(this.this$0).g()) && (aolr.a(this.this$0).j()))) {
          aolr.c(this.this$0, true);
        }
      }
      label289:
      while ((aolr.b(this.this$0)) && (this.this$0.a == 2) && (aolr.a(this.this$0) != null))
      {
        aoci localaoci = new aoci(aolr.a(this.this$0));
        aolr.a(this.this$0).a(1, localaoci, this.a);
        return;
        label191:
        if (!aolr.a(this.this$0).j())
        {
          if (aolr.a(this.this$0) == 1L)
          {
            this.this$0.b(1L);
            aolr.b(this.this$0);
          }
          for (;;)
          {
            this.this$0.m();
            break;
            if (aolr.a(this.this$0) == 2L) {
              this.this$0.o();
            } else if (aolr.a(this.this$0) == 2048L) {
              this.this$0.q();
            }
          }
          if ((aolr.a(this.this$0).g()) && (aolr.a(this.this$0).j())) {
            aolr.c(this.this$0, true);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.QQARSession.22
 * JD-Core Version:    0.7.0.1
 */