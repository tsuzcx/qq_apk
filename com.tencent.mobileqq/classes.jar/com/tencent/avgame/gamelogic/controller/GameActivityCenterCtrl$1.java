package com.tencent.avgame.gamelogic.controller;

import android.app.Activity;
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
    if (GameActivityCenterCtrl.a(this.jdField_a_of_type_ComTencentAvgameGamelogicControllerGameActivityCenterCtrl) == null) {}
    for (Object localObject1 = null;; localObject1 = (Activity)GameActivityCenterCtrl.a(this.jdField_a_of_type_ComTencentAvgameGamelogicControllerGameActivityCenterCtrl).get())
    {
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = BaseApplicationImpl.getContext();
      }
      if ((localObject2 != null) && (GameActivityCenterCtrl.a(this.jdField_a_of_type_ComTencentAvgameGamelogicControllerGameActivityCenterCtrl) != null) && (GameActivityCenterCtrl.a(this.jdField_a_of_type_ComTencentAvgameGamelogicControllerGameActivityCenterCtrl).a()))
      {
        GameActivityCenterCtrl.a(this.jdField_a_of_type_ComTencentAvgameGamelogicControllerGameActivityCenterCtrl, true);
        localObject1 = new Intent((Context)localObject2, QQBrowserActivity.class);
        ((Intent)localObject1).putExtra("url", GameActivityCenterCtrl.a(this.jdField_a_of_type_ComTencentAvgameGamelogicControllerGameActivityCenterCtrl).b);
        ((Intent)localObject1).putExtra("avgame_share_link", paramString);
        ((Intent)localObject1).putExtra("avgame_share_name", this.jdField_a_of_type_JavaLangString);
        ((Context)localObject2).startActivity((Intent)localObject1);
      }
      if (QLog.isColorLevel()) {
        QLog.i("GameACCtrl", 2, "getShareLinkCallback, ctx[" + localObject2 + "], entry[" + GameActivityCenterCtrl.a(this.jdField_a_of_type_ComTencentAvgameGamelogicControllerGameActivityCenterCtrl) + "], shareName[" + this.jdField_a_of_type_JavaLangString + "], shareUrl[" + paramString + "]");
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.controller.GameActivityCenterCtrl.1
 * JD-Core Version:    0.7.0.1
 */