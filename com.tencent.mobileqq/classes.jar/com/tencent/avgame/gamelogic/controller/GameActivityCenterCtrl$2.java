package com.tencent.avgame.gamelogic.controller;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.avgame.gamelogic.data.GameActivityCenterEntry;
import com.tencent.avgame.gamelogic.observer.GameRoomObserver;
import com.tencent.avgame.ui.AVGameHandler;
import com.tencent.qphone.base.util.QLog;

class GameActivityCenterCtrl$2
  extends GameRoomObserver
{
  GameActivityCenterCtrl$2(GameActivityCenterCtrl paramGameActivityCenterCtrl) {}
  
  public void a(boolean paramBoolean, int paramInt, String paramString, GameActivityCenterEntry paramGameActivityCenterEntry)
  {
    if (QLog.isColorLevel()) {
      QLog.i("GameACCtrl", 2, "onGetActivityEntry, [isSuccess: " + paramBoolean + ", errorCode: " + paramInt + ", errorMsg:" + paramString + ", entry: " + paramGameActivityCenterEntry + "]");
    }
    if (paramBoolean)
    {
      GameActivityCenterCtrl.a(this.a, paramGameActivityCenterEntry);
      AVGameHandler.a().b().post(new GameActivityCenterCtrl.RefreshEntryTask());
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.i("GameACCtrl", 2, "onSyncShareGame, [isSuccess: " + paramBoolean + ", errorCode: " + paramInt + ", errorMsg:" + paramString1 + ", playGameId: " + paramString2 + ", jumpUrl: " + paramString3 + "]");
    }
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString3))) {
      AVGameHandler.a().b().post(new GameActivityCenterCtrl.ShowAwardResult(paramString3));
    }
    if (paramBoolean) {
      GameActivityCenterCtrl.a(this.a, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.controller.GameActivityCenterCtrl.2
 * JD-Core Version:    0.7.0.1
 */