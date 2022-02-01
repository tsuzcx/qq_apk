package com.tencent.av.ui;

import com.tencent.av.utils.AudioHelper;

class AVActivity$MyControlUIObserver$5
  implements Runnable
{
  AVActivity$MyControlUIObserver$5(AVActivity.MyControlUIObserver paramMyControlUIObserver) {}
  
  public void run()
  {
    long l = AudioHelper.c();
    this.a.a.K.M(l);
    QavPanel localQavPanel = this.a.a.K.al();
    if (localQavPanel != null) {
      localQavPanel.f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.AVActivity.MyControlUIObserver.5
 * JD-Core Version:    0.7.0.1
 */