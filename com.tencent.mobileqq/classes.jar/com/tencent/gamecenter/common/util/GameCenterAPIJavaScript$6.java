package com.tencent.gamecenter.common.util;

import com.tencent.mobileqq.gamecenter.media.GameCenterVideoViewController.OnProgressChangeListener;
import java.util.Map;

class GameCenterAPIJavaScript$6
  implements GameCenterVideoViewController.OnProgressChangeListener
{
  GameCenterAPIJavaScript$6(GameCenterAPIJavaScript paramGameCenterAPIJavaScript) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    GameCenterAPIJavaScript.VideoViewInfo localVideoViewInfo = (GameCenterAPIJavaScript.VideoViewInfo)GameCenterAPIJavaScript.access$100(this.a).get(Integer.valueOf(paramInt2));
    if (localVideoViewInfo != null)
    {
      localVideoViewInfo.e = (paramInt1 / 1000);
      GameCenterAPIJavaScript localGameCenterAPIJavaScript = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(localVideoViewInfo.j);
      localStringBuilder.append("(");
      localStringBuilder.append(localVideoViewInfo.a());
      localStringBuilder.append(");");
      localGameCenterAPIJavaScript.callJs(localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gamecenter.common.util.GameCenterAPIJavaScript.6
 * JD-Core Version:    0.7.0.1
 */