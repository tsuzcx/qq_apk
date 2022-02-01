package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.mobileqq.activity.aio.helper.TroopRobotHelper;
import com.tencent.mobileqq.troop.widget.RobotPanelLayoutBase.GetListDataCallback;

class HotChatPie$2
  implements RobotPanelLayoutBase.GetListDataCallback
{
  HotChatPie$2(HotChatPie paramHotChatPie) {}
  
  public void a(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (this.a.f.equals(paramString)))
    {
      this.a.R = true;
      paramString = (TroopRobotHelper)this.a.a(23);
      if (paramString != null) {
        paramString.a(true);
      }
    }
    do
    {
      return;
      this.a.R = false;
      paramString = (TroopRobotHelper)this.a.a(23);
    } while (paramString == null);
    paramString.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.HotChatPie.2
 * JD-Core Version:    0.7.0.1
 */