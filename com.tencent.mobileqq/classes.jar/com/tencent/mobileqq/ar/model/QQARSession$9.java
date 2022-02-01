package com.tencent.mobileqq.ar.model;

import com.tencent.mobileqq.ar.arengine.ARCloudRecogResult;

class QQARSession$9
  implements Runnable
{
  QQARSession$9(QQARSession paramQQARSession, boolean paramBoolean) {}
  
  public void run()
  {
    boolean bool = QQARSession.d(this.this$0);
    int j = 0;
    if (bool)
    {
      if (QQARSession.e(this.this$0) != null) {
        QQARSession.c(this.this$0, false);
      }
      return;
    }
    int i = j;
    if (QQARSession.f(this.this$0) != null)
    {
      i = j;
      if (QQARSession.f(this.this$0).j != null)
      {
        i = j;
        if (QQARSession.b(this.this$0))
        {
          i = j;
          if (this.this$0.a == 2) {
            i = 1;
          }
        }
      }
    }
    if ((this.a) && (i != 0))
    {
      QQARSession localQQARSession = this.this$0;
      QQARSession.a(localQQARSession, QQARSession.f(localQQARSession).j);
      return;
    }
    if (i != 0)
    {
      if (QQARSession.e(this.this$0) != null) {
        QQARSession.c(this.this$0, true);
      }
      this.this$0.C();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.QQARSession.9
 * JD-Core Version:    0.7.0.1
 */