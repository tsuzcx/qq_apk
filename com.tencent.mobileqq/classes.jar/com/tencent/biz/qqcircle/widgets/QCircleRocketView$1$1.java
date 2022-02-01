package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.os.Vibrator;

class QCircleRocketView$1$1
  implements Runnable
{
  QCircleRocketView$1$1(QCircleRocketView.1 param1) {}
  
  public void run()
  {
    QCircleRocketView.a(this.a.d, this.a.b, this.a.c);
    try
    {
      Vibrator localVibrator = (Vibrator)this.a.d.getContext().getSystemService("vibrator");
      if ((this.a.b == 10) && (this.a.c == 3))
      {
        localVibrator.vibrate(100L);
        return;
      }
      localVibrator.vibrate(50L);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleRocketView.1.1
 * JD-Core Version:    0.7.0.1
 */