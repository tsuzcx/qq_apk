package com.tencent.mobileqq.ar.model;

import albk;
import alha;
import alkz;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.qphone.base.util.QLog;

public class QQARSession$22
  implements Runnable
{
  public QQARSession$22(alkz paramalkz, int paramInt) {}
  
  public void run()
  {
    if (alkz.a(this.this$0) == null) {
      QLog.d("AREngine_QQARSession", 1, "onARAnimationComplete mCurARResourceInfo is null!");
    }
    for (;;)
    {
      return;
      if (this.a == 0)
      {
        if (alkz.a(this.this$0).d()) {
          break label289;
        }
        if ((!alkz.a(this.this$0).h()) && (!alkz.a(this.this$0).g()) && (!alkz.a(this.this$0).k())) {
          break label191;
        }
        if ((!alkz.a(this.this$0).j()) || ((alkz.a(this.this$0).g()) && (alkz.a(this.this$0).j()))) {
          alkz.c(this.this$0, true);
        }
      }
      label289:
      while ((alkz.b(this.this$0)) && (this.this$0.a == 2) && (alkz.a(this.this$0) != null))
      {
        albk localalbk = new albk(alkz.a(this.this$0));
        alkz.a(this.this$0).a(1, localalbk, this.a);
        return;
        label191:
        if (!alkz.a(this.this$0).j())
        {
          if (alkz.a(this.this$0) == 1L)
          {
            this.this$0.b(1L);
            alkz.b(this.this$0);
          }
          for (;;)
          {
            this.this$0.k();
            break;
            if (alkz.a(this.this$0) == 2L) {
              this.this$0.m();
            } else if (alkz.a(this.this$0) == 2048L) {
              this.this$0.o();
            }
          }
          if ((alkz.a(this.this$0).g()) && (alkz.a(this.this$0).j())) {
            alkz.c(this.this$0, true);
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