package com.tencent.mobileqq.apollo.script;

import android.view.View;
import com.tencent.mobileqq.cmshow.engine.render.ICMShowView;

class SpriteUIHandler$SpriteVisibleRunnable$1
  implements Runnable
{
  SpriteUIHandler$SpriteVisibleRunnable$1(SpriteUIHandler.SpriteVisibleRunnable paramSpriteVisibleRunnable, ICMShowView paramICMShowView) {}
  
  public void run()
  {
    if (this.a == null) {
      return;
    }
    if (SpriteUIHandler.SpriteVisibleRunnable.a(this.this$0))
    {
      this.a.getView().setVisibility(8);
      return;
    }
    this.a.getView().setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.script.SpriteUIHandler.SpriteVisibleRunnable.1
 * JD-Core Version:    0.7.0.1
 */