package com.tencent.biz.qqcircle.widgets;

import com.tencent.mobileqq.bubble.QQAnimationDrawable;
import com.tencent.qphone.base.util.QLog;

class QCircleRocketView$2
  implements Runnable
{
  QCircleRocketView$2(QCircleRocketView paramQCircleRocketView, FrameAnimationView paramFrameAnimationView, QQAnimationDrawable paramQQAnimationDrawable, int paramInt) {}
  
  public void run()
  {
    QLog.d("QQAnimationDrawable", 1, "postDelay end");
    QLog.d("QQAnimationDrawable", 1, "hide");
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsFrameAnimationView.setVisibility(4);
    this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.d();
    QCircleRocketView.a(this.this$0, this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleRocketView.2
 * JD-Core Version:    0.7.0.1
 */