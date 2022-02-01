package com.tencent.biz.qqcircle.widgets;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class QCircleGuideBubbleView$BubbleHandler
  extends Handler
{
  private QCircleGuideBubbleView$BubbleHandler(QCircleGuideBubbleView paramQCircleGuideBubbleView)
  {
    super(Looper.getMainLooper());
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2) {
        return;
      }
      this.a.b();
      return;
    }
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleGuideBubbleView.BubbleHandler
 * JD-Core Version:    0.7.0.1
 */