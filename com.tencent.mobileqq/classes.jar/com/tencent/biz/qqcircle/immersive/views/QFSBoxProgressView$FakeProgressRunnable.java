package com.tencent.biz.qqcircle.immersive.views;

import android.os.Handler;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;

class QFSBoxProgressView$FakeProgressRunnable
  implements Runnable
{
  QFSBoxProgressView$FakeProgressRunnable(QFSBoxProgressView paramQFSBoxProgressView) {}
  
  public void run()
  {
    QFSBoxProgressView.e(this.this$0);
    QFSBoxProgressView localQFSBoxProgressView = this.this$0;
    int i = QFSBoxProgressView.a(localQFSBoxProgressView, QFSBoxProgressView.f(localQFSBoxProgressView), QFSBoxProgressView.g(this.this$0));
    QFSBoxProgressView.c(this.this$0).setProgress(i);
    if (i <= QFSBoxProgressView.h(this.this$0)) {
      RFThreadManager.getUIHandler().postDelayed(this, 200L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.views.QFSBoxProgressView.FakeProgressRunnable
 * JD-Core Version:    0.7.0.1
 */