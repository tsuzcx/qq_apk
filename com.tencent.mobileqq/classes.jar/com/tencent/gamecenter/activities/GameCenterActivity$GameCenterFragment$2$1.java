package com.tencent.gamecenter.activities;

import com.tencent.gamecenter.common.util.ScreenshotManager.ShotCallback;
import com.tencent.qphone.base.util.QLog;

class GameCenterActivity$GameCenterFragment$2$1
  implements ScreenshotManager.ShotCallback
{
  GameCenterActivity$GameCenterFragment$2$1(GameCenterActivity.GameCenterFragment.2 param2) {}
  
  public void a(int paramInt, String paramString)
  {
    paramString = new StringBuilder();
    paramString.append("removeShotMask code=");
    paramString.append(paramInt);
    QLog.i("GameCenterFragment", 1, paramString.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gamecenter.activities.GameCenterActivity.GameCenterFragment.2.1
 * JD-Core Version:    0.7.0.1
 */