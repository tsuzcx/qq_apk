package com.tencent.avgame.gamelogic.controller;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.avgame.gameroom.video.AVGameLaunchWebHelper;
import com.tencent.mobileqq.app.avgameshare.AVGameShareUtil.AVGameShareProxy;
import com.tencent.qphone.base.util.QLog;

class GameActivityCenterCtrl$ShowAwardResult$1
  implements AVGameShareUtil.AVGameShareProxy
{
  GameActivityCenterCtrl$ShowAwardResult$1(GameActivityCenterCtrl.ShowAwardResult paramShowAwardResult, Context paramContext, String paramString) {}
  
  public void a(boolean paramBoolean, long paramLong1, long paramLong2, long paramLong3) {}
  
  public void a(boolean paramBoolean, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getShareLinkCallback isSuccess: ");
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).append(" shareUrl: ");
    ((StringBuilder)localObject).append(paramString);
    QLog.d("GameACCtrl", 1, ((StringBuilder)localObject).toString());
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString)))
    {
      localObject = new AVGameLaunchWebHelper((Activity)this.a);
      ((AVGameLaunchWebHelper)localObject).a((Activity)this.a, new GameActivityCenterCtrl.ShowAwardResult.1.1(this, paramString, (AVGameLaunchWebHelper)localObject));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.controller.GameActivityCenterCtrl.ShowAwardResult.1
 * JD-Core Version:    0.7.0.1
 */