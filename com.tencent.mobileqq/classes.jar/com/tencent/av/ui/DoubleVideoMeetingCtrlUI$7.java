package com.tencent.av.ui;

import com.tencent.av.VideoController;
import lff;

class DoubleVideoMeetingCtrlUI$7
  implements Runnable
{
  DoubleVideoMeetingCtrlUI$7(DoubleVideoMeetingCtrlUI paramDoubleVideoMeetingCtrlUI, long paramLong) {}
  
  public void run()
  {
    if (this.this$0.a == null) {}
    while (!this.this$0.a.a().aG) {
      return;
    }
    this.this$0.a.a(this.a, 4, false, false);
    this.this$0.c = true;
    this.this$0.a.k();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.ui.DoubleVideoMeetingCtrlUI.7
 * JD-Core Version:    0.7.0.1
 */