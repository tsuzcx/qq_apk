package com.tencent.gamecenter.common.util;

import android.graphics.Outline;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.tencent.mobileqq.activity.aio.AIOUtils;

class GameCenterAPIJavaScript$4
  extends ViewOutlineProvider
{
  GameCenterAPIJavaScript$4(GameCenterAPIJavaScript paramGameCenterAPIJavaScript) {}
  
  public void getOutline(View paramView, Outline paramOutline)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      paramOutline.setRoundRect(0, 0, paramView.getWidth(), paramView.getHeight(), AIOUtils.b(5.0F, paramView.getResources()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gamecenter.common.util.GameCenterAPIJavaScript.4
 * JD-Core Version:    0.7.0.1
 */