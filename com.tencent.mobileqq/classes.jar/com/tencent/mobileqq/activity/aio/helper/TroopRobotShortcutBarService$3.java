package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.mobileqq.troop.widget.RobotPanelLayoutBase.GetListDataCallback;

class TroopRobotShortcutBarService$3
  implements RobotPanelLayoutBase.GetListDataCallback
{
  TroopRobotShortcutBarService$3(TroopRobotShortcutBarService paramTroopRobotShortcutBarService, String paramString) {}
  
  public void a(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (this.a.equals(paramString)))
    {
      TroopRobotShortcutBarService.a(this.b, true);
      this.b.b(true);
      return;
    }
    TroopRobotShortcutBarService.a(this.b, false);
    this.b.b(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TroopRobotShortcutBarService.3
 * JD-Core Version:    0.7.0.1
 */