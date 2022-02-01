package com.tencent.mobileqq.ar.model;

import com.tencent.mobileqq.ar.arengine.ARLocalControl;

class QQARSession$29
  implements Runnable
{
  public void run()
  {
    if (this.this$0.a == 2)
    {
      if (!QQARSession.a(this.this$0)) {
        return;
      }
      if (this.this$0.h != null) {
        this.this$0.h.a(false, QQARSession.p(this.this$0), QQARSession.q(this.this$0));
      }
      QQARSession.a(this.this$0, 0);
      this.this$0.k = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.QQARSession.29
 * JD-Core Version:    0.7.0.1
 */