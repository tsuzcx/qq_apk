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
    if ((paramBoolean) && (!TextUtils.isEmpty(TroopRobotShortcutBarService.a(this.a).a)) && (TroopRobotShortcutBarService.a(this.a).a.equals(paramString)))
    {
      this.a.a(true);
      return;
    }
    this.a.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TroopRobotShortcutBarService.7
 * JD-Core Version:    0.7.0.1
 */