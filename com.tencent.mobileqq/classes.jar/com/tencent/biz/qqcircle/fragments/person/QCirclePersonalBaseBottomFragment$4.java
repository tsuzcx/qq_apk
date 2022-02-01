package com.tencent.biz.qqcircle.fragments.person;

import aabf;
import com.tencent.biz.qqcircle.adapter.QCircleFakeAdapter;
import com.tencent.biz.richframework.part.BasePartFragment;
import java.util.ArrayList;
import uzg;

class QCirclePersonalBaseBottomFragment$4
  implements Runnable
{
  QCirclePersonalBaseBottomFragment$4(QCirclePersonalBaseBottomFragment paramQCirclePersonalBaseBottomFragment) {}
  
  public void run()
  {
    if ((uzg.a(this.this$0.jdField_a_of_type_JavaLangString)) && (this.this$0.jdField_a_of_type_ComTencentBizQqcircleAdapterQCircleFakeAdapter != null) && (this.this$0.jdField_a_of_type_ComTencentBizQqcircleAdapterQCircleFakeAdapter.getDataList() != null) && (this.this$0.jdField_a_of_type_ComTencentBizQqcircleAdapterQCircleFakeAdapter.getDataList().size() > 0) && (this.this$0.a() != null) && (this.this$0.a().a() != null)) {
      this.this$0.a().a().a("publish_show_or_hide", Boolean.valueOf(true));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.person.QCirclePersonalBaseBottomFragment.4
 * JD-Core Version:    0.7.0.1
 */