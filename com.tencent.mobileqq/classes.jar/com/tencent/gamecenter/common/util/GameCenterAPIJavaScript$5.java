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
      GameCenterAPIJavaScript localGameCenterAPIJavaScript = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(localVideoViewInfo.e);
      localStringBuilder.append("(");
      localStringBuilder.append(localVideoViewInfo.a());
      localStringBuilder.append(");");
      localGameCenterAPIJavaScript.callJs(localStringBuilder.toString());
    }
  }
  
  public void onSrceenModeChanged(boolean paramBoolean, int paramInt)
  {
    GameCenterAPIJavaScript.VideoViewInfo localVideoViewInfo = (GameCenterAPIJavaScript.VideoViewInfo)GameCenterAPIJavaScript.access$100(this.a).get(Integer.valueOf(paramInt));
    if (localVideoViewInfo != null)
    {
      localVideoViewInfo.c = paramBoolean;
      GameCenterAPIJavaScript localGameCenterAPIJavaScript = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(localVideoViewInfo.d);
      localStringBuilder.append("(");
      localStringBuilder.append(localVideoViewInfo.a());
      localStringBuilder.append(");");
      localGameCenterAPIJavaScript.callJs(localStringBuilder.toString());
    }
  }
  
  public void onVideoStatusChanged(int paramInt1, int paramInt2)
  {
    GameCenterAPIJavaScript.VideoViewInfo localVideoViewInfo;
    GameCenterAPIJavaScript localGameCenterAPIJavaScript;
    StringBuilder localStringBuilder;
    if (paramInt1 == 3)
    {
      localVideoViewInfo = (GameCenterAPIJavaScript.VideoViewInfo)GameCenterAPIJavaScript.access$100(this.a).get(Integer.valueOf(paramInt2));
      if (localVideoViewInfo != null)
      {
        localGameCenterAPIJavaScript = this.a;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(localVideoViewInfo.g);
        localStringBuilder.append("(");
        localStringBuilder.append(localVideoViewInfo.a());
        localStringBuilder.append(");");
        localGameCenterAPIJavaScript.callJs(localStringBuilder.toString());
      }
    }
    else if (paramInt1 == 5)
    {
      localVideoViewInfo = (GameCenterAPIJavaScript.VideoViewInfo)GameCenterAPIJavaScript.access$100(this.a).get(Integer.valueOf(paramInt2));
      if (localVideoViewInfo != null)
      {
        localGameCenterAPIJavaScript = this.a;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(localVideoViewInfo.f);
        localStringBuilder.append("(");
        localStringBuilder.append(localVideoViewInfo.a());
        localStringBuilder.append(");");
        localGameCenterAPIJavaScript.callJs(localStringBuilder.toString());
      }
    }
    else if (paramInt1 == 7)
    {
      localVideoViewInfo = (GameCenterAPIJavaScript.VideoViewInfo)GameCenterAPIJavaScript.access$100(this.a).get(Integer.valueOf(paramInt2));
      if (localVideoViewInfo != null)
      {
        localGameCenterAPIJavaScript = this.a;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(localVideoViewInfo.h);
        localStringBuilder.append("(");
        localStringBuilder.append(localVideoViewInfo.a());
        localStringBuilder.append(");");
        localGameCenterAPIJavaScript.callJs(localStringBuilder.toString());
      }
    }
    else if (paramInt1 == 0)
    {
      localVideoViewInfo = (GameCenterAPIJavaScript.VideoViewInfo)GameCenterAPIJavaScript.access$100(this.a).get(Integer.valueOf(paramInt2));
      if (localVideoViewInfo != null)
      {
        localGameCenterAPIJavaScript = this.a;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(localVideoViewInfo.i);
        localStringBuilder.append("(");
        localStringBuilder.append(localVideoViewInfo.a());
        localStringBuilder.append(");");
        localGameCenterAPIJavaScript.callJs(localStringBuilder.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gamecenter.common.util.GameCenterAPIJavaScript.5
 * JD-Core Version:    0.7.0.1
 */