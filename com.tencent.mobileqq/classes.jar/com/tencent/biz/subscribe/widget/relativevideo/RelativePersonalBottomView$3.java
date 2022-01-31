package com.tencent.biz.subscribe.widget.relativevideo;

import com.tencent.biz.subscribe.event.SimpleBaseEvent;
import com.tencent.biz.subscribe.event.SubDraftChangeEvent;

class RelativePersonalBottomView$3
  implements Runnable
{
  RelativePersonalBottomView$3(RelativePersonalBottomView paramRelativePersonalBottomView, SimpleBaseEvent paramSimpleBaseEvent) {}
  
  public void run()
  {
    if ((this.a instanceof SubDraftChangeEvent)) {
      RelativePersonalBottomView.a(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.relativevideo.RelativePersonalBottomView.3
 * JD-Core Version:    0.7.0.1
 */