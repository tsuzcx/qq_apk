package com.tencent.biz.widgets;

import android.view.View;
import java.util.List;

class TabLayout$TabAdapter$1
  implements Runnable
{
  TabLayout$TabAdapter$1(TabLayout.TabAdapter paramTabAdapter, int paramInt, View paramView) {}
  
  public void run()
  {
    this.this$0.jdField_a_of_type_ComTencentBizWidgetsTabLayout.setChildView(this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidViewView);
    this.this$0.jdField_a_of_type_ComTencentBizWidgetsTabLayout.setChildWidth(this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidViewView.getMeasuredWidth());
    int i;
    if (this.this$0.jdField_a_of_type_JavaUtilList == null) {
      i = 0;
    } else {
      i = this.this$0.jdField_a_of_type_JavaUtilList.size();
    }
    if (this.this$0.jdField_a_of_type_ComTencentBizWidgetsTabLayout.a() == i) {
      this.this$0.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.widgets.TabLayout.TabAdapter.1
 * JD-Core Version:    0.7.0.1
 */