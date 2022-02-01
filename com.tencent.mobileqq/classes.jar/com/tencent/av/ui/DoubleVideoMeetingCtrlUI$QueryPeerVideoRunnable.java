package com.tencent.av.ui;

import com.tencent.qphone.base.util.QLog;

class DoubleVideoMeetingCtrlUI$QueryPeerVideoRunnable
  implements Runnable
{
  public String a = null;
  
  DoubleVideoMeetingCtrlUI$QueryPeerVideoRunnable(DoubleVideoMeetingCtrlUI paramDoubleVideoMeetingCtrlUI) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      String str = this.this$0.d;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("QueryPeerVideoRunnable-->Function Name = ");
      localStringBuilder.append(this.a);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    this.this$0.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.DoubleVideoMeetingCtrlUI.QueryPeerVideoRunnable
 * JD-Core Version:    0.7.0.1
 */