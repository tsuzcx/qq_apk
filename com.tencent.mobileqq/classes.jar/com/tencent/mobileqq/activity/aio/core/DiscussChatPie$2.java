package com.tencent.mobileqq.activity.aio.core;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;

class DiscussChatPie$2
  implements View.OnClickListener
{
  DiscussChatPie$2(DiscussChatPie paramDiscussChatPie, String paramString) {}
  
  public void onClick(View paramView)
  {
    if ((DiscussChatPie.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreDiscussChatPie) != null) && (DiscussChatPie.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreDiscussChatPie).isShowing())) {
      DiscussChatPie.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreDiscussChatPie).dismiss();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreDiscussChatPie.a != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreDiscussChatPie.a.isShowing()))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreDiscussChatPie.a.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreDiscussChatPie.a = null;
    }
    DiscussChatPie.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreDiscussChatPie, this.jdField_a_of_type_JavaLangString);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.DiscussChatPie.2
 * JD-Core Version:    0.7.0.1
 */