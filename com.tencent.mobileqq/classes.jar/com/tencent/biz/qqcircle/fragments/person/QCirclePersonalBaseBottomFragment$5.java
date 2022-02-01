package com.tencent.biz.qqcircle.fragments.person;

import com.tencent.biz.qqcircle.adapter.QCircleFakeAdapter;
import com.tencent.biz.richframework.part.BasePartFragment;
import java.util.ArrayList;
import zxk;

class QCirclePersonalBaseBottomFragment$5
  implements Runnable
{
  QCirclePersonalBaseBottomFragment$5(QCirclePersonalBaseBottomFragment paramQCirclePersonalBaseBottomFragment) {}
  
  public void run()
  {
    if ((this.this$0.a == null) || (this.this$0.a.getDataList() == null) || (this.this$0.a.getDataList().size() == 0)) {
      this.this$0.a().a().a("publish_show_or_hide", Boolean.valueOf(false));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.person.QCirclePersonalBaseBottomFragment.5
 * JD-Core Version:    0.7.0.1
 */