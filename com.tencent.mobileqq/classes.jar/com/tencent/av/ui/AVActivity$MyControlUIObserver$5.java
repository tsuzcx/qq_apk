package com.tencent.av.ui;

import com.tencent.mobileqq.utils.AudioHelper;

class AVActivity$MyControlUIObserver$5
  implements Runnable
{
  AVActivity$MyControlUIObserver$5(AVActivity.MyControlUIObserver paramMyControlUIObserver) {}
  
  public void run()
  {
    long l = AudioHelper.b();
    this.a.a.a.F(l);
    QavPanel localQavPanel = this.a.a.a.a();
    if (localQavPanel != null) {
      localQavPanel.g();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.AVActivity.MyControlUIObserver.5
 * JD-Core Version:    0.7.0.1
 */