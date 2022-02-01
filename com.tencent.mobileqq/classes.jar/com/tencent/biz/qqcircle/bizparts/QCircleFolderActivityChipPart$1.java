package com.tencent.biz.qqcircle.bizparts;

import com.tencent.biz.qqcircle.events.QCircleFuelAnimationEvent;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import vcv;

public class QCircleFolderActivityChipPart$1
  implements Runnable
{
  public QCircleFolderActivityChipPart$1(vcv paramvcv, SimpleBaseEvent paramSimpleBaseEvent) {}
  
  public void run()
  {
    if (vcv.a(this.this$0))
    {
      vcv.a(this.this$0, true);
      vcv.a(this.this$0, (QCircleFuelAnimationEvent)this.a);
      return;
    }
    vcv.a(this.this$0, (QCircleFuelAnimationEvent)this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCircleFolderActivityChipPart.1
 * JD-Core Version:    0.7.0.1
 */