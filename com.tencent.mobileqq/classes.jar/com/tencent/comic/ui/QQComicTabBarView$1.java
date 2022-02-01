package com.tencent.comic.ui;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class QQComicTabBarView$1
  extends Handler
{
  QQComicTabBarView$1(QQComicTabBarView paramQQComicTabBarView, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2) {
          return;
        }
        paramMessage = this.a;
        paramMessage.b = 1.0F;
        paramMessage.a(paramMessage.i, this.a.h);
        paramMessage = this.a;
        paramMessage.i = paramMessage.h;
        QQComicTabBarView.c(this.a);
        return;
      }
      if (this.a.b < 1.0F)
      {
        paramMessage = this.a;
        paramMessage.b += 0.05F;
        QQComicTabBarView.b(this.a);
        super.sendMessageDelayed(this.a.a.obtainMessage(1), 16L);
        return;
      }
      super.sendMessageDelayed(this.a.a.obtainMessage(2), 16L);
      return;
    }
    paramMessage = this.a;
    paramMessage.b = 0.0F;
    QQComicTabBarView.a(paramMessage);
    super.sendMessageDelayed(this.a.a.obtainMessage(1), 16L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.comic.ui.QQComicTabBarView.1
 * JD-Core Version:    0.7.0.1
 */