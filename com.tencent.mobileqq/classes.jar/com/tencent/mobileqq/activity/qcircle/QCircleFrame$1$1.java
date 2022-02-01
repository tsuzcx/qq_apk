package com.tencent.mobileqq.activity.qcircle;

import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.qphone.base.util.QLog;

class QCircleFrame$1$1
  implements Runnable
{
  QCircleFrame$1$1(QCircleFrame.1 param1) {}
  
  public void run()
  {
    if (QCircleFrame.a(this.a.a) != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("add mQCircleTabView : ");
      localStringBuilder.append(QCircleFrame.a(this.a.a));
      QLog.d("QCircleFrame", 1, localStringBuilder.toString());
      QCircleFrame.a(this.a.a).addView(QCircleFrame.a(this.a.a), new FrameLayout.LayoutParams(-1, -1));
      QCircleFrame.a(this.a.a).setBackgroundColor(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qcircle.QCircleFrame.1.1
 * JD-Core Version:    0.7.0.1
 */