package com.tencent.mobileqq.activity.aio.core;

import com.tencent.mobileqq.activity.aio.helper.TroopRobotHelper;
import com.tencent.mobileqq.troop.widget.RobotPanelLayoutBase.GetListDataCallback;

class TroopChatPie$30
  implements RobotPanelLayoutBase.GetListDataCallback
{
  TroopChatPie$30(TroopChatPie paramTroopChatPie) {}
  
  public void a(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (this.a.f.equals(paramString)))
    {
      TroopChatPie.a(this.a, true);
      paramString = (TroopRobotHelper)this.a.a(23);
      if (paramString != null) {
        paramString.a(true);
      }
    }
    do
    {
      return;
      TroopChatPie.a(this.a, false);
      paramString = (TroopRobotHelper)this.a.a(23);
    } while (paramString == null);
    paramString.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.TroopChatPie.30
 * JD-Core Version:    0.7.0.1
 */