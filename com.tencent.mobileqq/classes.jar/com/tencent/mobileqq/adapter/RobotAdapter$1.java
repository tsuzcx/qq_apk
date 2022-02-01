package com.tencent.mobileqq.adapter;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.robot.api.IRobotUtilApi;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService;
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
      ((IRobotUtilApi)QRoute.api(IRobotUtilApi.class)).openRobotProfileCard(RobotAdapter.a(this.a), RobotAdapter.a(this.a), ((RobotAdapter.ViewHolder)localObject).a);
      ITroopRobotService localITroopRobotService = (ITroopRobotService)RobotAdapter.a(this.a).getRuntimeService(ITroopRobotService.class, "all");
      if ((localITroopRobotService != null) && (localITroopRobotService.isRobotUinNeedShowRed(RobotAdapter.a(this.a), ((RobotAdapter.ViewHolder)localObject).a, RobotAdapter.a(this.a)))) {
        localITroopRobotService.removeRobotUinInRed(RobotAdapter.a(this.a), ((RobotAdapter.ViewHolder)localObject).a);
      }
      if (RobotAdapter.a(this.a) != null) {
        ReportController.b(RobotAdapter.a(this.a).app, "dc00898", "", "", "", "0X8009F9F", 0, 0, ((RobotAdapter.ViewHolder)localObject).a, "", "", "");
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.RobotAdapter.1
 * JD-Core Version:    0.7.0.1
 */