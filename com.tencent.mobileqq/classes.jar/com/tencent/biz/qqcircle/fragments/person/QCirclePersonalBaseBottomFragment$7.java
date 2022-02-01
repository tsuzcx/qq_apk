package com.tencent.biz.qqcircle.fragments.person;

import com.tencent.biz.qqcircle.adapter.QCircleFakeAdapter;
import com.tencent.biz.qqcircle.events.QCircleFeedEvent;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.biz.richframework.part.BlockPart;
import com.tencent.biz.richframework.part.IStatusViewProvider;
import com.tencent.biz.richframework.part.PartManager;
import com.tencent.biz.richframework.part.block.BlockContainer;
import java.util.ArrayList;

class QCirclePersonalBaseBottomFragment$7
  implements Runnable
{
  QCirclePersonalBaseBottomFragment$7(QCirclePersonalBaseBottomFragment paramQCirclePersonalBaseBottomFragment, SimpleBaseEvent paramSimpleBaseEvent) {}
  
  public void run()
  {
    if ((this.this$0.e == null) || (this.this$0.e.getDataList() == null) || (this.this$0.e.getDataList().size() == 0))
    {
      if ((this.this$0.D() != null) && (this.this$0.D().p() != null))
      {
        this.this$0.D().p().a("publish_show_or_hide", Boolean.valueOf(true));
        if (((QCircleFeedEvent)this.a).mTargetPage != 9) {
          this.this$0.D().p().a("personal_page_show_publish_guide", Boolean.valueOf(true));
        }
      }
      if (this.this$0.c != null) {
        this.this$0.c.i().getStatusInterface().a(this.this$0.g);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.person.QCirclePersonalBaseBottomFragment.7
 * JD-Core Version:    0.7.0.1
 */