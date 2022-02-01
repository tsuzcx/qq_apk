package com.tencent.av.ui;

import com.tencent.av.VideoController;

class AVActivity$MyControlUIObserver$3
  implements Runnable
{
  AVActivity$MyControlUIObserver$3(AVActivity.MyControlUIObserver paramMyControlUIObserver, DoubleVideoCtrlUI paramDoubleVideoCtrlUI) {}
  
  public void run()
  {
    QavPanel localQavPanel = this.a.aA;
    int i;
    if (this.b.a.I.ac) {
      i = 2;
    } else {
      i = 0;
    }
    localQavPanel.a(true, i, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.AVActivity.MyControlUIObserver.3
 * JD-Core Version:    0.7.0.1
 */