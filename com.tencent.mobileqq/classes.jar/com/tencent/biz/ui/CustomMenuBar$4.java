package com.tencent.biz.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class CustomMenuBar$4
  implements View.OnClickListener
{
  CustomMenuBar$4(CustomMenuBar paramCustomMenuBar, String paramString, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.a != null) {
      this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.a.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, 1);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.ui.CustomMenuBar.4
 * JD-Core Version:    0.7.0.1
 */