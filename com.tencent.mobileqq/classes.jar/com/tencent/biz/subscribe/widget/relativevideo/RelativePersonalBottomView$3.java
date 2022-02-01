package com.tencent.biz.subscribe.widget.relativevideo;

import android.app.Activity;
import androidx.viewpager.widget.ViewPager;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.subscribe.event.SubDraftChangeEvent;
import com.tencent.biz.subscribe.event.SubscribeFeedsEvent;
import java.util.List;

class RelativePersonalBottomView$3
  implements Runnable
{
  RelativePersonalBottomView$3(RelativePersonalBottomView paramRelativePersonalBottomView, SimpleBaseEvent paramSimpleBaseEvent) {}
  
  public void run()
  {
    if ((RelativePersonalBottomView.b(this.this$0) != null) && (RelativePersonalBottomView.b(this.this$0).getContext() != null) && (!((Activity)RelativePersonalBottomView.b(this.this$0).getContext()).isFinishing()))
    {
      SimpleBaseEvent localSimpleBaseEvent = this.a;
      if ((localSimpleBaseEvent instanceof SubDraftChangeEvent))
      {
        RelativePersonalBottomView.f(this.this$0);
        if ((((SubDraftChangeEvent)this.a).getIsSave()) && (RelativePersonalBottomView.e(this.this$0).size() > 1) && (RelativePersonalBottomView.b(this.this$0).getCurrentItem() != 1)) {
          RelativePersonalBottomView.b(this.this$0).setCurrentItem(1);
        }
      }
      else if (((localSimpleBaseEvent instanceof SubscribeFeedsEvent)) && (RelativePersonalBottomView.b(this.this$0).getCurrentItem() != 0) && (((SubscribeFeedsEvent)this.a).mState == 1))
      {
        RelativePersonalBottomView.b(this.this$0).setCurrentItem(0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.relativevideo.RelativePersonalBottomView.3
 * JD-Core Version:    0.7.0.1
 */