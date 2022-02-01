package com.tencent.biz.qqcircle.richframework.widget.timer;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class QCircleVideoTimerManager$1
  extends Handler
{
  QCircleVideoTimerManager$1(QCircleVideoTimerManager paramQCircleVideoTimerManager, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3) {
          return;
        }
        QCircleVideoTimerManager.a(this.a);
        return;
      }
      QCircleVideoTimerManager.b(this.a, (IVideoTimerListener)paramMessage.obj);
      return;
    }
    QCircleVideoTimerManager.a(this.a, (IVideoTimerListener)paramMessage.obj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.richframework.widget.timer.QCircleVideoTimerManager.1
 * JD-Core Version:    0.7.0.1
 */