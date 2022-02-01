package com.tencent.biz.qqcircle.publish.activity;

import com.tencent.biz.qqcircle.widgets.comment.SoftKeyboardStateHelper.SoftKeyboardStateListener;
import com.tencent.qphone.base.util.QLog;

class QCirclePublishContentPart$6
  implements SoftKeyboardStateHelper.SoftKeyboardStateListener
{
  QCirclePublishContentPart$6(QCirclePublishContentPart paramQCirclePublishContentPart) {}
  
  public void a()
  {
    QLog.d("[QcirclePublish]QCirclePublishContentPart", 1, "onSoftKeyboardClosed");
  }
  
  public void a(int paramInt)
  {
    QLog.d("[QcirclePublish]QCirclePublishContentPart", 1, "onSoftKeyboardOpened");
    if (this.a.d != paramInt)
    {
      QCirclePublishContentPart localQCirclePublishContentPart = this.a;
      localQCirclePublishContentPart.d = paramInt;
      QCirclePublishContentPart.d(localQCirclePublishContentPart);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.activity.QCirclePublishContentPart.6
 * JD-Core Version:    0.7.0.1
 */