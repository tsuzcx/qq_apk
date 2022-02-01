package com.tencent.avgame.gamelogic.controller;

import android.app.Activity;
import com.tencent.avgame.gamelogic.data.GameActivityCenterEntry;
import com.tencent.avgame.ui.IAVGameRootContainer;

class GameActivityCenterCtrl$RefreshEntryTask
  implements Runnable
{
  public void run()
  {
    Object localObject = GameActivityCenterCtrl.a();
    Activity localActivity = GameActivityCenterCtrl.a((GameActivityCenterCtrl)localObject);
    localObject = GameActivityCenterCtrl.a((GameActivityCenterCtrl)localObject);
    if (((localActivity instanceof IAVGameRootContainer)) && (!localActivity.isFinishing())) {
      ((IAVGameRootContainer)localActivity).refreshActivityCenter((GameActivityCenterEntry)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.controller.GameActivityCenterCtrl.RefreshEntryTask
 * JD-Core Version:    0.7.0.1
 */