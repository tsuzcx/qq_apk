package com.tencent.av.ui;

import com.tencent.av.VideoController;
import com.tencent.av.screenshare.ScreenShareCtrl;

class MultiVideoCtrlLayerUI4NewGroupChat$8$1
  implements Runnable
{
  MultiVideoCtrlLayerUI4NewGroupChat$8$1(MultiVideoCtrlLayerUI4NewGroupChat.8 param8, long paramLong) {}
  
  public void run()
  {
    ScreenShareCtrl localScreenShareCtrl = this.b.b.am.aF();
    if (localScreenShareCtrl != null) {
      localScreenShareCtrl.a(this.b.b.U(), this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.MultiVideoCtrlLayerUI4NewGroupChat.8.1
 * JD-Core Version:    0.7.0.1
 */