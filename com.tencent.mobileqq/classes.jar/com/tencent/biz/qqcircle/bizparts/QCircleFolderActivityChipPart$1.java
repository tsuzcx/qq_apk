package com.tencent.biz.qqcircle.bizparts;

import com.tencent.biz.qqcircle.events.QCircleFuelAnimationEvent;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import vbf;

public class QCircleFolderActivityChipPart$1
  implements Runnable
{
  public QCircleFolderActivityChipPart$1(vbf paramvbf, SimpleBaseEvent paramSimpleBaseEvent) {}
  
  public void run()
  {
    if (vbf.a(this.this$0))
    {
      vbf.a(this.this$0, true);
      vbf.a(this.this$0, (QCircleFuelAnimationEvent)this.a);
      return;
    }
    vbf.a(this.this$0, (QCircleFuelAnimationEvent)this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCircleFolderActivityChipPart.1
 * JD-Core Version:    0.7.0.1
 */