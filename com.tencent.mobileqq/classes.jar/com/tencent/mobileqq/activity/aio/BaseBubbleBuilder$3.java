package com.tencent.mobileqq.activity.aio;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.troop.essencemsg.TroopEssenceUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class BaseBubbleBuilder$3
  implements View.OnClickListener
{
  BaseBubbleBuilder$3(BaseBubbleBuilder paramBaseBubbleBuilder, long paramLong, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if ((paramView == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a == null)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      TroopEssenceUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder.jdField_a_of_type_AndroidContentContext, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.3
 * JD-Core Version:    0.7.0.1
 */