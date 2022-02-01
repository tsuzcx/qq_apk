package com.tencent.biz.qqcircle.bizparts;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.qcircle.api.event.QCircleFuelAnimationEvent;

class QCircleFolderActivityChipPart$1
  implements Runnable
{
  QCircleFolderActivityChipPart$1(QCircleFolderActivityChipPart paramQCircleFolderActivityChipPart, SimpleBaseEvent paramSimpleBaseEvent) {}
  
  public void run()
  {
    if (QCircleFolderActivityChipPart.a(this.this$0))
    {
      QCircleFolderActivityChipPart.a(this.this$0, true);
      QCircleFolderActivityChipPart.a(this.this$0, (QCircleFuelAnimationEvent)this.a);
      return;
    }
    QCircleFolderActivityChipPart.b(this.this$0, (QCircleFuelAnimationEvent)this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCircleFolderActivityChipPart.1
 * JD-Core Version:    0.7.0.1
 */