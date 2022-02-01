package com.tencent.av.ui;

import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;

class DoubleVideoMeetingCtrlUI$7
  implements Runnable
{
  DoubleVideoMeetingCtrlUI$7(DoubleVideoMeetingCtrlUI paramDoubleVideoMeetingCtrlUI, long paramLong) {}
  
  public void run()
  {
    if (this.this$0.a == null) {
      return;
    }
    if (this.this$0.a.a().aw)
    {
      this.this$0.a.a(this.a, 4, false, false);
      DoubleVideoMeetingCtrlUI localDoubleVideoMeetingCtrlUI = this.this$0;
      localDoubleVideoMeetingCtrlUI.c = true;
      localDoubleVideoMeetingCtrlUI.a.l();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.DoubleVideoMeetingCtrlUI.7
 * JD-Core Version:    0.7.0.1
 */