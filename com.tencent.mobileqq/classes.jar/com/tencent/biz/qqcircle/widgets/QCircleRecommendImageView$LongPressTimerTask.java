package com.tencent.biz.qqcircle.widgets;

import android.os.Handler;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.TimerTask;

class QCircleRecommendImageView$LongPressTimerTask
  extends TimerTask
{
  private WeakReference<QCircleRecommendImageView> a;
  private int b;
  
  public QCircleRecommendImageView$LongPressTimerTask(QCircleRecommendImageView paramQCircleRecommendImageView)
  {
    this.a = new WeakReference(paramQCircleRecommendImageView);
    this.b = 0;
  }
  
  private void a()
  {
    if (this.b != 0) {
      return;
    }
    QCircleRecommendImageView localQCircleRecommendImageView = (QCircleRecommendImageView)this.a.get();
    if (localQCircleRecommendImageView == null) {
      return;
    }
    if ((QCircleRecommendImageView.d(localQCircleRecommendImageView) != 0) && (QCircleRecommendImageView.i(localQCircleRecommendImageView)) && (!QCircleRecommendImageView.j(localQCircleRecommendImageView)))
    {
      this.b = 2;
      return;
    }
    this.b = 1;
  }
  
  private void a(QCircleRecommendImageView paramQCircleRecommendImageView)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleLongPressType:");
    localStringBuilder.append(this.b);
    QLog.d("QCircleRecommend_", 1, localStringBuilder.toString());
    int i = this.b;
    if (i == 1)
    {
      QCircleRecommendImageView.a(paramQCircleRecommendImageView, 1, "long_press");
      return;
    }
    if (i == 2) {
      QCircleRecommendImageView.k(paramQCircleRecommendImageView);
    }
  }
  
  public void run()
  {
    RFThreadManager.getUIHandler().post(new QCircleRecommendImageView.LongPressTimerTask.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleRecommendImageView.LongPressTimerTask
 * JD-Core Version:    0.7.0.1
 */