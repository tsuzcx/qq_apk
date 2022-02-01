package com.tencent.biz.qqcircle.immersive.personal.part;

import android.widget.ImageView;
import com.tencent.biz.qqcircle.manager.QCircleFuelAnimationManager;
import com.tencent.mobileqq.qcircle.api.event.QCircleFuelAnimationEvent;

class QFSPersonalTitleBarPart$17
  implements Runnable
{
  QFSPersonalTitleBarPart$17(QFSPersonalTitleBarPart paramQFSPersonalTitleBarPart, QCircleFuelAnimationEvent paramQCircleFuelAnimationEvent) {}
  
  public void run()
  {
    if (QFSPersonalTitleBarPart.l(this.this$0) == null) {
      return;
    }
    QCircleFuelAnimationManager.a().a(this.a.getPublishTask());
    QCircleFuelAnimationManager.a().a(QFSPersonalTitleBarPart.m(this.this$0), QFSPersonalTitleBarPart.n(this.this$0), QFSPersonalTitleBarPart.l(this.this$0), true);
    QFSPersonalTitleBarPart.l(this.this$0).postDelayed(new QFSPersonalTitleBarPart.17.1(this), 2100L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.personal.part.QFSPersonalTitleBarPart.17
 * JD-Core Version:    0.7.0.1
 */