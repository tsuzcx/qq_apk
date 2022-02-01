package com.tencent.av.ui;

import com.tencent.av.ui.funchat.filter.EffectFilterPanel;

class AVActivity$MyControlUIObserver$4
  implements Runnable
{
  AVActivity$MyControlUIObserver$4(AVActivity.MyControlUIObserver paramMyControlUIObserver) {}
  
  public void run()
  {
    if (this.a.a.isDestroyed()) {
      return;
    }
    if (this.a.a.aa != null)
    {
      this.a.a.aa.setAnimationTrigger(this.a.a.a());
      this.a.a.aa.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.AVActivity.MyControlUIObserver.4
 * JD-Core Version:    0.7.0.1
 */