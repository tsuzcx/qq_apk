package com.tencent.biz.qqcircle.fragments.person;

import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.adapter.QCircleFakeAdapter;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.biz.richframework.part.PartManager;
import java.util.ArrayList;

class QCirclePersonalBaseBottomFragment$6
  implements Runnable
{
  QCirclePersonalBaseBottomFragment$6(QCirclePersonalBaseBottomFragment paramQCirclePersonalBaseBottomFragment) {}
  
  public void run()
  {
    if ((QCirclePluginUtil.d(this.this$0.f)) && (this.this$0.e != null) && (this.this$0.e.getDataList() != null) && (this.this$0.e.getDataList().size() > 0) && (this.this$0.D() != null) && (this.this$0.D().p() != null))
    {
      this.this$0.D().p().a("publish_show_or_hide", Boolean.valueOf(true));
      this.this$0.D().p().a("personal_page_show_publish_guide", Boolean.valueOf(false));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.person.QCirclePersonalBaseBottomFragment.6
 * JD-Core Version:    0.7.0.1
 */