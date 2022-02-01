package com.tencent.gamecenter.common.util;

import android.view.View;
import android.widget.FrameLayout;
import com.tencent.biz.ui.TouchWebView.OnScrollChangedListener;

class GameCenterAPIJavaScript$3
  implements TouchWebView.OnScrollChangedListener
{
  GameCenterAPIJavaScript$3(GameCenterAPIJavaScript paramGameCenterAPIJavaScript) {}
  
  public void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    if (GameCenterAPIJavaScript.access$000(this.a) != null) {
      GameCenterAPIJavaScript.access$000(this.a).scrollBy(0, paramInt2 - paramInt4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gamecenter.common.util.GameCenterAPIJavaScript.3
 * JD-Core Version:    0.7.0.1
 */