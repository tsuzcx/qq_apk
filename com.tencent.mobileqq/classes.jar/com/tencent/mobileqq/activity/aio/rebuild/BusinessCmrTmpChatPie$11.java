package com.tencent.mobileqq.activity.aio.rebuild;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.ui.CustomMenuBar;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class BusinessCmrTmpChatPie$11
  implements View.OnClickListener
{
  BusinessCmrTmpChatPie$11(BusinessCmrTmpChatPie paramBusinessCmrTmpChatPie) {}
  
  public void onClick(View paramView)
  {
    com.tencent.mobileqq.activity.aio.AIOUtils.o = true;
    this.a.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setVisibility(8);
    this.a.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.BusinessCmrTmpChatPie.11
 * JD-Core Version:    0.7.0.1
 */