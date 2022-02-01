package com.tencent.mobileqq.ar.model;

import apfk;
import apku;
import apos;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.qphone.base.util.QLog;

public class QQARSession$22
  implements Runnable
{
  public QQARSession$22(apos paramapos, int paramInt) {}
  
  public void run()
  {
    if (apos.a(this.this$0) == null) {
      QLog.d("AREngine_QQARSession", 1, "onARAnimationComplete mCurARResourceInfo is null!");
    }
    for (;;)
    {
      return;
      if (this.a == 0)
      {
        if (apos.a(this.this$0).d()) {
          break label289;
        }
        if ((!apos.a(this.this$0).h()) && (!apos.a(this.this$0).g()) && (!apos.a(this.this$0).k())) {
          break label191;
        }
        if ((!apos.a(this.this$0).j()) || ((apos.a(this.this$0).g()) && (apos.a(this.this$0).j()))) {
          apos.c(this.this$0, true);
        }
      }
      label289:
      while ((apos.b(this.this$0)) && (this.this$0.a == 2) && (apos.a(this.this$0) != null))
      {
        apfk localapfk = new apfk(apos.a(this.this$0));
        apos.a(this.this$0).a(1, localapfk, this.a);
        return;
        label191:
        if (!apos.a(this.this$0).j())
        {
          if (apos.a(this.this$0) == 1L)
          {
            this.this$0.b(1L);
            apos.b(this.this$0);
          }
          for (;;)
          {
            this.this$0.m();
            break;
            if (apos.a(this.this$0) == 2L) {
              this.this$0.o();
            } else if (apos.a(this.this$0) == 2048L) {
              this.this$0.q();
            }
          }
          if ((apos.a(this.this$0).g()) && (apos.a(this.this$0).j())) {
            apos.c(this.this$0, true);
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