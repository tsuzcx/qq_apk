package com.tencent.av.ui;

import com.tencent.av.VideoController;
import com.tencent.av.screenshare.ScreenShareCtrl;
import mdp;

public class DoubleVideoMeetingCtrlUI$1$1
  implements Runnable
{
  public DoubleVideoMeetingCtrlUI$1$1(mdp parammdp) {}
  
  public void run()
  {
    ScreenShareCtrl localScreenShareCtrl = this.a.a.a.a();
    if (localScreenShareCtrl != null) {
      localScreenShareCtrl.a(this.a.a.a(), 1L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.ui.DoubleVideoMeetingCtrlUI.1.1
 * JD-Core Version:    0.7.0.1
 */