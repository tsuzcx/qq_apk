package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.widget.RobotPanelLayoutBase.RobotPanelLayoutListener;
import mqq.os.MqqHandler;

class TroopRobotShortcutBarService$1
  implements RobotPanelLayoutBase.RobotPanelLayoutListener
{
  TroopRobotShortcutBarService$1(TroopRobotShortcutBarService paramTroopRobotShortcutBarService) {}
  
  public void a(String paramString)
  {
    ThreadManager.getUIHandler().post(new TroopRobotShortcutBarService.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TroopRobotShortcutBarService.1
 * JD-Core Version:    0.7.0.1
 */