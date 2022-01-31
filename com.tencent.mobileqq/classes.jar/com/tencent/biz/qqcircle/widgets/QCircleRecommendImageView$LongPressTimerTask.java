package com.tencent.biz.qqcircle.widgets;

import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import java.util.TimerTask;
import mqq.util.WeakReference;

class QCircleRecommendImageView$LongPressTimerTask
  extends TimerTask
{
  private WeakReference<QCircleRecommendImageView> a;
  
  public QCircleRecommendImageView$LongPressTimerTask(QCircleRecommendImageView paramQCircleRecommendImageView)
  {
    this.a = new WeakReference(paramQCircleRecommendImageView);
  }
  
  public void run()
  {
    ThreadManagerV2.getUIHandlerV2().post(new QCircleRecommendImageView.LongPressTimerTask.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleRecommendImageView.LongPressTimerTask
 * JD-Core Version:    0.7.0.1
 */