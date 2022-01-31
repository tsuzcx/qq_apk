package com.tencent.mobileqq.apollo.script;

import aivb;

class SpriteUIHandler$SpriteVisibleRunnable$1
  implements Runnable
{
  SpriteUIHandler$SpriteVisibleRunnable$1(SpriteUIHandler.SpriteVisibleRunnable paramSpriteVisibleRunnable, aivb paramaivb) {}
  
  public void run()
  {
    if (this.a != null)
    {
      if (SpriteUIHandler.SpriteVisibleRunnable.a(this.this$0)) {
        this.a.setVisibility(8);
      }
    }
    else {
      return;
    }
    this.a.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.script.SpriteUIHandler.SpriteVisibleRunnable.1
 * JD-Core Version:    0.7.0.1
 */