package com.tencent.mobileqq.ar.model;

import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;

class QQARSession$19
  implements Runnable
{
  public void run()
  {
    if ((QQARSession.l(this.this$0) != null) && (!QQARSession.l(this.this$0).d()))
    {
      if (QQARSession.l(this.this$0).j()) {
        QQARSession.m(this.this$0);
      }
      if (QQARSession.n(this.this$0) == 1L)
      {
        this.this$0.b(1L);
        QQARSession.j(this.this$0);
      }
      else if (QQARSession.n(this.this$0) == 2L)
      {
        this.this$0.B();
      }
      else if (QQARSession.n(this.this$0) == 2048L)
      {
        this.this$0.D();
      }
      this.this$0.x();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.QQARSession.19
 * JD-Core Version:    0.7.0.1
 */