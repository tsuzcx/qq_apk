package com.tencent.biz.qqcircle.widgets;

import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class QCircleRecommendImageView$LongPressTimerTask$1
  implements Runnable
{
  QCircleRecommendImageView$LongPressTimerTask$1(QCircleRecommendImageView.LongPressTimerTask paramLongPressTimerTask) {}
  
  public void run()
  {
    try
    {
      QCircleRecommendImageView.LongPressTimerTask.a(this.this$0);
      QCircleRecommendImageView localQCircleRecommendImageView = (QCircleRecommendImageView)QCircleRecommendImageView.LongPressTimerTask.b(this.this$0).get();
      if (localQCircleRecommendImageView == null) {
        return;
      }
      QCircleRecommendImageView.LongPressTimerTask.a(this.this$0, localQCircleRecommendImageView);
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      QLog.e("QCircleRecommend_", 1, localOutOfMemoryError.getMessage());
      localOutOfMemoryError.printStackTrace();
      return;
    }
    catch (Exception localException)
    {
      QLog.e("QCircleRecommend_", 1, localException.getMessage());
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleRecommendImageView.LongPressTimerTask.1
 * JD-Core Version:    0.7.0.1
 */