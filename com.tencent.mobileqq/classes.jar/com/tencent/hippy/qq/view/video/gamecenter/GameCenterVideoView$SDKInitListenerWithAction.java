package com.tencent.hippy.qq.view.video.gamecenter;

import com.tencent.mobileqq.videoplatform.SDKInitListener;
import com.tencent.qphone.base.util.QLog;

class GameCenterVideoView$SDKInitListenerWithAction
  implements SDKInitListener
{
  Runnable action;
  
  GameCenterVideoView$SDKInitListenerWithAction(GameCenterVideoView paramGameCenterVideoView, Runnable paramRunnable)
  {
    this.action = paramRunnable;
  }
  
  public void onSDKInited(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.this$0.post(this.action);
    }
    for (;;)
    {
      GameCenterVideoView.access$2202(this.this$0, null);
      return;
      QLog.e("GameCenterVideoView", 1, "initSDKAsync failed");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.view.video.gamecenter.GameCenterVideoView.SDKInitListenerWithAction
 * JD-Core Version:    0.7.0.1
 */