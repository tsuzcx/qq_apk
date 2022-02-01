package com.tencent.hippy.qq.view.video.gamecenter;

import avdp;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.qphone.base.util.QLog;

class GameCenterVideoView$1
  implements avdp
{
  GameCenterVideoView$1(GameCenterVideoView paramGameCenterVideoView) {}
  
  public void onAudioMute(boolean paramBoolean, int paramInt) {}
  
  public void onSrceenModeChanged(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameCenterVideoView", 2, new Object[] { "onSrceenModeChanged, fullScreen:", Boolean.valueOf(paramBoolean) });
    }
    HippyMap localHippyMap = new HippyMap();
    localHippyMap.pushBoolean("isFullScreen", paramBoolean);
    this.this$0.sendEvent("onFullScreenChanged", localHippyMap);
  }
  
  public void onVideoStatusChanged(int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.hippy.qq.view.video.gamecenter.GameCenterVideoView.1
 * JD-Core Version:    0.7.0.1
 */