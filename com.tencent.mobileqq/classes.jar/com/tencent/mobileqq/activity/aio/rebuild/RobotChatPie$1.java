package com.tencent.mobileqq.activity.aio.rebuild;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.helper.TroopRobotHelper;
import com.tencent.mobileqq.troop.widget.RobotPanelLayoutBase.GetListDataCallback;

class RobotChatPie$1
  implements RobotPanelLayoutBase.GetListDataCallback
{
  RobotChatPie$1(RobotChatPie paramRobotChatPie) {}
  
  public void a(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (!TextUtils.isEmpty(this.a.a.a)) && (this.a.a.a.equals(paramString)))
    {
      paramString = (TroopRobotHelper)this.a.a(23);
      if (paramString != null) {
        paramString.a(true);
      }
    }
    do
    {
      return;
      paramString = (TroopRobotHelper)this.a.a(23);
    } while (paramString == null);
    paramString.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.RobotChatPie.1
 * JD-Core Version:    0.7.0.1
 */