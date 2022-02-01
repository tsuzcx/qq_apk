package com.tencent.biz.qqcircle.bizparts;

import android.widget.ImageView;
import com.tencent.biz.qqcircle.events.QCircleFuelAnimationEvent;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import vcb;
import vog;

public class QCirclePersonalTitleBarPart$13
  implements Runnable
{
  public QCirclePersonalTitleBarPart$13(vcb paramvcb, SimpleBaseEvent paramSimpleBaseEvent) {}
  
  public void run()
  {
    vog.a().a(((QCircleFuelAnimationEvent)this.a).getPublishTask());
    vog.a().a(vcb.c(this.this$0), vcb.a(this.this$0), vcb.d(this.this$0), vcb.e(this.this$0), vcb.f(this.this$0), true);
    vcb.f(this.this$0).postDelayed(new QCirclePersonalTitleBarPart.13.1(this), 2100L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCirclePersonalTitleBarPart.13
 * JD-Core Version:    0.7.0.1
 */