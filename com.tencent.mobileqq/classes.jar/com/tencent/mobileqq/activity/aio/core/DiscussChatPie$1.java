package com.tencent.mobileqq.activity.aio.core;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.item.VideoItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class DiscussChatPie$1
  implements View.OnClickListener
{
  DiscussChatPie$1(DiscussChatPie paramDiscussChatPie) {}
  
  public void onClick(View paramView)
  {
    VideoItemBuilder.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.a(), this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, 1, false, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.DiscussChatPie.1
 * JD-Core Version:    0.7.0.1
 */