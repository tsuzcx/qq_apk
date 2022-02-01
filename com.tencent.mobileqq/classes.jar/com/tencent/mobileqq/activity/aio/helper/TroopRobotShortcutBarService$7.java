package com.tencent.mobileqq.activity.aio.helper;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.troop.widget.RobotPanelLayoutBase.GetListDataCallback;

class TroopRobotShortcutBarService$7
  implements RobotPanelLayoutBase.GetListDataCallback
{
  TroopRobotShortcutBarService$7(TroopRobotShortcutBarService paramTroopRobotShortcutBarService) {}
  
  public void a(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (!TextUtils.isEmpty(TroopRobotShortcutBarService.c(this.a).b)) && (TroopRobotShortcutBarService.c(this.a).b.equals(paramString)))
    {
      this.a.b(true);
      return;
    }
    this.a.b(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TroopRobotShortcutBarService.7
 * JD-Core Version:    0.7.0.1
 */