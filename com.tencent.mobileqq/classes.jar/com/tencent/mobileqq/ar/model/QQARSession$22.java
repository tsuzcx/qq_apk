package com.tencent.mobileqq.ar.model;

import akmy;
import akso;
import akwn;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.qphone.base.util.QLog;

public class QQARSession$22
  implements Runnable
{
  public QQARSession$22(akwn paramakwn, int paramInt) {}
  
  public void run()
  {
    if (akwn.a(this.this$0) == null) {
      QLog.d("AREngine_QQARSession", 1, "onARAnimationComplete mCurARResourceInfo is null!");
    }
    for (;;)
    {
      return;
      if (this.a == 0)
      {
        if (akwn.a(this.this$0).d()) {
          break label289;
        }
        if ((!akwn.a(this.this$0).h()) && (!akwn.a(this.this$0).g()) && (!akwn.a(this.this$0).k())) {
          break label191;
        }
        if ((!akwn.a(this.this$0).j()) || ((akwn.a(this.this$0).g()) && (akwn.a(this.this$0).j()))) {
          akwn.c(this.this$0, true);
        }
      }
      label289:
      while ((akwn.b(this.this$0)) && (this.this$0.a == 2) && (akwn.a(this.this$0) != null))
      {
        akmy localakmy = new akmy(akwn.a(this.this$0));
        akwn.a(this.this$0).a(1, localakmy, this.a);
        return;
        label191:
        if (!akwn.a(this.this$0).j())
        {
          if (akwn.a(this.this$0) == 1L)
          {
            this.this$0.b(1L);
            akwn.b(this.this$0);
          }
          for (;;)
          {
            this.this$0.k();
            break;
            if (akwn.a(this.this$0) == 2L) {
              this.this$0.m();
            } else if (akwn.a(this.this$0) == 2048L) {
              this.this$0.o();
            }
          }
          if ((akwn.a(this.this$0).g()) && (akwn.a(this.this$0).j())) {
            akwn.c(this.this$0, true);
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