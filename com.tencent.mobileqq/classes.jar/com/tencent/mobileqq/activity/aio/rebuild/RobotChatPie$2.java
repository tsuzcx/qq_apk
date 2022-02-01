package com.tencent.mobileqq.activity.aio.rebuild;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.troop.utils.RobotUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class RobotChatPie$2
  implements View.OnClickListener
{
  RobotChatPie$2(RobotChatPie paramRobotChatPie) {}
  
  public void onClick(View paramView)
  {
    if (!this.a.I) {
      RobotUtils.a(this.a.jdField_a_of_type_AndroidContentContext, null, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.RobotChatPie.2
 * JD-Core Version:    0.7.0.1
 */