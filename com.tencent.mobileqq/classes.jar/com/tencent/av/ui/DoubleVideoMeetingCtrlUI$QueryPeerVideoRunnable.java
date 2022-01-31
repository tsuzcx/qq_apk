package com.tencent.av.ui;

import com.tencent.qphone.base.util.QLog;

class DoubleVideoMeetingCtrlUI$QueryPeerVideoRunnable
  implements Runnable
{
  public String a;
  
  DoubleVideoMeetingCtrlUI$QueryPeerVideoRunnable(DoubleVideoMeetingCtrlUI paramDoubleVideoMeetingCtrlUI) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.c, 2, "QueryPeerVideoRunnable-->Function Name = " + this.a);
    }
    this.this$0.p();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.ui.DoubleVideoMeetingCtrlUI.QueryPeerVideoRunnable
 * JD-Core Version:    0.7.0.1
 */