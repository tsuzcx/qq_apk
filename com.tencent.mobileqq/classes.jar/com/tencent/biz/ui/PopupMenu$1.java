package com.tencent.biz.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class PopupMenu$1
  implements View.OnClickListener
{
  PopupMenu$1(PopupMenu paramPopupMenu, String paramString, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentBizUiPopupMenu.a != null) {
      this.jdField_a_of_type_ComTencentBizUiPopupMenu.a.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, 2);
    }
    paramView.post(new PopupMenu.1.1(this));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.ui.PopupMenu.1
 * JD-Core Version:    0.7.0.1
 */