package com.tencent.gamecenter.common.util;

import com.tencent.mobileqq.gamecenter.media.GameCenterVideoViewController.VideoStatusChangeListener;
import java.util.Map;

class GameCenterAPIJavaScript$5
  implements GameCenterVideoViewController.VideoStatusChangeListener
{
  GameCenterAPIJavaScript$5(GameCenterAPIJavaScript paramGameCenterAPIJavaScript) {}
  
  public void onAudioMute(boolean paramBoolean, int paramInt)
  {
    GameCenterAPIJavaScript.VideoViewInfo localVideoViewInfo = (GameCenterAPIJavaScript.VideoViewInfo)GameCenterAPIJavaScript.access$100(this.a).get(Integer.valueOf(paramInt));
    if (localVideoViewInfo != null)
    {
      localVideoViewInfo.a = paramBoolean;
      this.a.callJs(localVideoViewInfo.e + "(" + localVideoViewInfo.a() + ");");
    }
  }
  
  public void onSrceenModeChanged(boolean paramBoolean, int paramInt)
  {
    GameCenterAPIJavaScript.VideoViewInfo localVideoViewInfo = (GameCenterAPIJavaScript.VideoViewInfo)GameCenterAPIJavaScript.access$100(this.a).get(Integer.valueOf(paramInt));
    if (localVideoViewInfo != null)
    {
      localVideoViewInfo.c = paramBoolean;
      this.a.callJs(localVideoViewInfo.d + "(" + localVideoViewInfo.a() + ");");
    }
  }
  
  public void onVideoStatusChanged(int paramInt1, int paramInt2)
  {
    GameCenterAPIJavaScript.VideoViewInfo localVideoViewInfo;
    if (paramInt1 == 3)
    {
      localVideoViewInfo = (GameCenterAPIJavaScript.VideoViewInfo)GameCenterAPIJavaScript.access$100(this.a).get(Integer.valueOf(paramInt2));
      if (localVideoViewInfo != null) {
        this.a.callJs(localVideoViewInfo.g + "(" + localVideoViewInfo.a() + ");");
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (paramInt1 != 5) {
              break;
            }
            localVideoViewInfo = (GameCenterAPIJavaScript.VideoViewInfo)GameCenterAPIJavaScript.access$100(this.a).get(Integer.valueOf(paramInt2));
          } while (localVideoViewInfo == null);
          this.a.callJs(localVideoViewInfo.f + "(" + localVideoViewInfo.a() + ");");
          return;
          if (paramInt1 != 7) {
            break;
          }
          localVideoViewInfo = (GameCenterAPIJavaScript.VideoViewInfo)GameCenterAPIJavaScript.access$100(this.a).get(Integer.valueOf(paramInt2));
        } while (localVideoViewInfo == null);
        this.a.callJs(localVideoViewInfo.h + "(" + localVideoViewInfo.a() + ");");
        return;
      } while (paramInt1 != 0);
      localVideoViewInfo = (GameCenterAPIJavaScript.VideoViewInfo)GameCenterAPIJavaScript.access$100(this.a).get(Integer.valueOf(paramInt2));
    } while (localVideoViewInfo == null);
    this.a.callJs(localVideoViewInfo.i + "(" + localVideoViewInfo.a() + ");");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gamecenter.common.util.GameCenterAPIJavaScript.5
 * JD-Core Version:    0.7.0.1
 */