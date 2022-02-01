package com.tencent.av.ui;

import com.tencent.av.ui.funchat.filter.EffectFilterPanel;
import mbd;

public class AVActivity$MyControlUIObserver$4
  implements Runnable
{
  public AVActivity$MyControlUIObserver$4(mbd parammbd) {}
  
  public void run()
  {
    if (this.a.a.isDestroyed()) {}
    while (this.a.a.a == null) {
      return;
    }
    this.a.a.a.setAnimationTrigger(this.a.a.a());
    this.a.a.a.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.ui.AVActivity.MyControlUIObserver.4
 * JD-Core Version:    0.7.0.1
 */