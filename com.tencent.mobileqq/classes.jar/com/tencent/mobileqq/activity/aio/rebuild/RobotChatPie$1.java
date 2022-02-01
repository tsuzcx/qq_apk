package com.tencent.mobileqq.activity.aio.rebuild;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.troop.utils.RobotUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class RobotChatPie$1
  implements View.OnClickListener
{
  RobotChatPie$1(RobotChatPie paramRobotChatPie) {}
  
  public void onClick(View paramView)
  {
    if (!this.a.aY) {
      RobotUtils.a(this.a.e, null, this.a.ah.b);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.RobotChatPie.1
 * JD-Core Version:    0.7.0.1
 */