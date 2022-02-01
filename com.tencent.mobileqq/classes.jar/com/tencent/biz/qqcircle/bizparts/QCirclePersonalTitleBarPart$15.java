package com.tencent.biz.qqcircle.bizparts;

import android.widget.ImageView;
import com.tencent.biz.qqcircle.events.QCircleFuelAnimationEvent;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import vdr;
import vqo;

public class QCirclePersonalTitleBarPart$15
  implements Runnable
{
  public QCirclePersonalTitleBarPart$15(vdr paramvdr, SimpleBaseEvent paramSimpleBaseEvent) {}
  
  public void run()
  {
    vqo.a().a(((QCircleFuelAnimationEvent)this.a).getPublishTask());
    vqo.a().a(vdr.c(this.this$0), vdr.a(this.this$0), vdr.d(this.this$0), vdr.e(this.this$0), vdr.f(this.this$0), true);
    vdr.f(this.this$0).postDelayed(new QCirclePersonalTitleBarPart.15.1(this), 2100L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCirclePersonalTitleBarPart.15
 * JD-Core Version:    0.7.0.1
 */