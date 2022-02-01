package com.tencent.gamecenter.common.util;

import com.tencent.mobileqq.gamecenter.media.GameCenterVideoViewController.OnDanmakuChangeListener;
import java.util.Map;

class GameCenterAPIJavaScript$8
  implements GameCenterVideoViewController.OnDanmakuChangeListener
{
  GameCenterAPIJavaScript$8(GameCenterAPIJavaScript paramGameCenterAPIJavaScript) {}
  
  public void a(boolean paramBoolean, int paramInt)
  {
    GameCenterAPIJavaScript.VideoViewInfo localVideoViewInfo = (GameCenterAPIJavaScript.VideoViewInfo)GameCenterAPIJavaScript.access$100(this.a).get(Integer.valueOf(paramInt));
    if (localVideoViewInfo != null)
    {
      localVideoViewInfo.d = paramBoolean;
      this.a.callJs(localVideoViewInfo.l + "(" + localVideoViewInfo.a() + ");");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gamecenter.common.util.GameCenterAPIJavaScript.8
 * JD-Core Version:    0.7.0.1
 */