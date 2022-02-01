package com.tencent.biz.qqcircle.bizparts;

import android.widget.ImageView;
import com.tencent.biz.qqcircle.manager.QCircleFuelAnimationManager;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.qcircle.api.event.QCircleFuelAnimationEvent;

class QCirclePersonalTitleBarPart$16
  implements Runnable
{
  QCirclePersonalTitleBarPart$16(QCirclePersonalTitleBarPart paramQCirclePersonalTitleBarPart, SimpleBaseEvent paramSimpleBaseEvent) {}
  
  public void run()
  {
    if (QCirclePersonalTitleBarPart.p(this.this$0) == null) {
      return;
    }
    QCircleFuelAnimationManager.a().a(((QCircleFuelAnimationEvent)this.a).getPublishTask());
    QCircleFuelAnimationManager.a().a(QCirclePersonalTitleBarPart.q(this.this$0), QCirclePersonalTitleBarPart.r(this.this$0), QCirclePersonalTitleBarPart.p(this.this$0), true);
    QCirclePersonalTitleBarPart.p(this.this$0).postDelayed(new QCirclePersonalTitleBarPart.16.1(this), 2100L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCirclePersonalTitleBarPart.16
 * JD-Core Version:    0.7.0.1
 */