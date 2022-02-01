package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.mobileqq.troop.widget.RobotPanelLayoutBase.GetListDataCallback;

class TroopRobotShortcutBarService$6
  implements RobotPanelLayoutBase.GetListDataCallback
{
  TroopRobotShortcutBarService$6(TroopRobotShortcutBarService paramTroopRobotShortcutBarService) {}
  
  public void a(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (TroopRobotShortcutBarService.b(this.a).equals(paramString)))
    {
      this.a.e(true);
      this.a.b(true);
      return;
    }
    this.a.e(false);
    this.a.b(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TroopRobotShortcutBarService.6
 * JD-Core Version:    0.7.0.1
 */