package com.tencent.mobileqq.apollo.script;

import android.view.View;
import com.tencent.mobileqq.cmshow.engine.render.ICMShowView;

class SpriteUIHandler$6
  implements Runnable
{
  SpriteUIHandler$6(SpriteUIHandler paramSpriteUIHandler, ICMShowView paramICMShowView, boolean paramBoolean) {}
  
  public void run()
  {
    ICMShowView localICMShowView = this.a;
    if (localICMShowView == null) {
      return;
    }
    if (this.b)
    {
      localICMShowView.getView().setVisibility(8);
      return;
    }
    localICMShowView.getView().setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.script.SpriteUIHandler.6
 * JD-Core Version:    0.7.0.1
 */