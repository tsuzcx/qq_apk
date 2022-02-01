package com.tencent.gamecenter.activities;

import com.tencent.gamecenter.common.util.ScreenshotManager;
import com.tencent.gamecenter.common.util.ScreenshotManager.ShotCallback;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;

class GameCenterActivity$GameCenterFragment$1
  implements ScreenshotManager.ShotCallback
{
  GameCenterActivity$GameCenterFragment$1(GameCenterActivity.GameCenterFragment paramGameCenterFragment, WebView paramWebView) {}
  
  public void a(int paramInt, String paramString)
  {
    paramString = new StringBuilder();
    paramString.append("addShot res code=");
    paramString.append(paramInt);
    QLog.i("GameCenterFragment", 1, paramString.toString());
    if (paramInt == 304) {
      ScreenshotManager.a().a(this.jdField_a_of_type_ComTencentSmttSdkWebView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gamecenter.activities.GameCenterActivity.GameCenterFragment.1
 * JD-Core Version:    0.7.0.1
 */