package com.tencent.av.ui;

import com.tencent.av.VideoController;
import com.tencent.av.screenshare.ScreenShareCtrl;

class DoubleVideoMeetingCtrlUI$1$1
  implements Runnable
{
  DoubleVideoMeetingCtrlUI$1$1(DoubleVideoMeetingCtrlUI.1 param1) {}
  
  public void run()
  {
    ScreenShareCtrl localScreenShareCtrl = this.a.b.am.aF();
    if (localScreenShareCtrl != null) {
      localScreenShareCtrl.a(this.a.b.U(), 1L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.DoubleVideoMeetingCtrlUI.1.1
 * JD-Core Version:    0.7.0.1
 */