package com.tencent.avgame.gamelogic.controller;

import android.content.Context;
import android.content.Intent;
import com.tencent.avgame.gamelogic.data.GameActivityCenterEntry;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.avgameshare.AVGameShareUtil.AVGameShareProxy;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

class GameActivityCenterCtrl$1
  implements AVGameShareUtil.AVGameShareProxy
{
  GameActivityCenterCtrl$1(GameActivityCenterCtrl paramGameActivityCenterCtrl, String paramString) {}
  
  public void a(boolean paramBoolean, long paramLong1, long paramLong2, long paramLong3) {}
  
  public void a(boolean paramBoolean, String paramString)
  {
    Object localObject1;
    if (GameActivityCenterCtrl.a(this.b) == null) {
      localObject1 = null;
    } else {
      localObject1 = (Context)GameActivityCenterCtrl.a(this.b).get();
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = BaseApplicationImpl.getContext();
    }
    if ((localObject2 != null) && (GameActivityCenterCtrl.b(this.b) != null) && (GameActivityCenterCtrl.b(this.b).a()))
    {
      GameActivityCenterCtrl.a(this.b, true);
      localObject1 = new Intent((Context)localObject2, QQBrowserActivity.class);
      ((Intent)localObject1).putExtra("url", GameActivityCenterCtrl.b(this.b).c);
      ((Intent)localObject1).putExtra("avgame_share_link", paramString);
      ((Intent)localObject1).putExtra("avgame_share_name", this.a);
      ((Context)localObject2).startActivity((Intent)localObject1);
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getShareLinkCallback, ctx[");
      ((StringBuilder)localObject1).append(localObject2);
      ((StringBuilder)localObject1).append("], entry[");
      ((StringBuilder)localObject1).append(GameActivityCenterCtrl.b(this.b));
      ((StringBuilder)localObject1).append("], shareName[");
      ((StringBuilder)localObject1).append(this.a);
      ((StringBuilder)localObject1).append("], shareUrl[");
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append("]");
      QLog.i("GameACCtrl", 2, ((StringBuilder)localObject1).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.controller.GameActivityCenterCtrl.1
 * JD-Core Version:    0.7.0.1
 */