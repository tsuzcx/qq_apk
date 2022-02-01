package com.tencent.mobileqq.adapter;

import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.RobotUtils;
import com.tencent.mobileqq.troop.utils.TroopRobotManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class RobotAdapter$1
  implements View.OnClickListener
{
  RobotAdapter$1(RobotAdapter paramRobotAdapter) {}
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if ((localObject != null) && ((localObject instanceof RobotAdapter.ViewHolder)))
    {
      localObject = (RobotAdapter.ViewHolder)localObject;
      RobotUtils.a(RobotAdapter.a(this.a), RobotAdapter.a(this.a), ((RobotAdapter.ViewHolder)localObject).a);
      TroopRobotManager localTroopRobotManager = (TroopRobotManager)RobotAdapter.a(this.a).getManager(QQManagerFactory.TROOP_ROBOT_MANAGER);
      if ((localTroopRobotManager != null) && (localTroopRobotManager.a(RobotAdapter.a(this.a), ((RobotAdapter.ViewHolder)localObject).a, RobotAdapter.a(this.a)))) {
        localTroopRobotManager.a(RobotAdapter.a(this.a), ((RobotAdapter.ViewHolder)localObject).a);
      }
      if (RobotAdapter.a(this.a) != null) {
        break label121;
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label121:
      ReportController.b(RobotAdapter.a(this.a).app, "dc00898", "", "", "", "0X8009F9F", 0, 0, ((RobotAdapter.ViewHolder)localObject).a, "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.RobotAdapter.1
 * JD-Core Version:    0.7.0.1
 */