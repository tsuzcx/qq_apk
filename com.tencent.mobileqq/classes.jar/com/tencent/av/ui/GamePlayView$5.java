package com.tencent.av.ui;

import com.tencent.av.gameplay.ARNativeBridge;

class GamePlayView$5
  implements Runnable
{
  GamePlayView$5(GamePlayView paramGamePlayView, boolean paramBoolean) {}
  
  public void run()
  {
    try
    {
      GamePlayView.a(this.this$0).native_stopEmitter(this.a);
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      localUnsatisfiedLinkError.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.ui.GamePlayView.5
 * JD-Core Version:    0.7.0.1
 */