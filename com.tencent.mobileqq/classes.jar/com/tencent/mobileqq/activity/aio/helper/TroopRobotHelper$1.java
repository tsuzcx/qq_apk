package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.widget.RobotPanelLayoutBase.RobotPanelLayoutListener;
import mqq.os.MqqHandler;

class TroopRobotHelper$1
  implements RobotPanelLayoutBase.RobotPanelLayoutListener
{
  TroopRobotHelper$1(TroopRobotHelper paramTroopRobotHelper) {}
  
  public void a(String paramString)
  {
    ThreadManager.getUIHandler().post(new TroopRobotHelper.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TroopRobotHelper.1
 * JD-Core Version:    0.7.0.1
 */