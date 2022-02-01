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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onGetActivityEntry, [isSuccess: ");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(", errorCode: ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", errorMsg:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", entry: ");
      localStringBuilder.append(paramGameActivityCenterEntry);
      localStringBuilder.append("]");
      QLog.i("GameACCtrl", 2, localStringBuilder.toString());
    }
    if (paramBoolean)
    {
      GameActivityCenterCtrl.a(this.a, paramGameActivityCenterEntry);
      AVGameHandler.a().c().post(new GameActivityCenterCtrl.RefreshEntryTask());
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onSyncShareGame, [isSuccess: ");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(", errorCode: ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", errorMsg:");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(", playGameId: ");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(", jumpUrl: ");
      localStringBuilder.append(paramString3);
      localStringBuilder.append("]");
      QLog.i("GameACCtrl", 2, localStringBuilder.toString());
    }
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString3))) {
      AVGameHandler.a().c().post(new GameActivityCenterCtrl.ShowAwardResult(paramString3));
    }
    if (paramBoolean) {
      GameActivityCenterCtrl.b(this.a, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.controller.GameActivityCenterCtrl.2
 * JD-Core Version:    0.7.0.1
 */