package com.tencent.av.ui;

import com.tencent.mobileqq.utils.AudioHelper;
import mbu;

public class AVActivity$MyControlUIObserver$5
  implements Runnable
{
  public AVActivity$MyControlUIObserver$5(mbu parammbu) {}
  
  public void run()
  {
    long l = AudioHelper.b();
    this.a.a.a.E(l);
    QavPanel localQavPanel = this.a.a.a.a();
    if (localQavPanel != null) {
      localQavPanel.g();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.ui.AVActivity.MyControlUIObserver.5
 * JD-Core Version:    0.7.0.1
 */