package com.tencent.av.ui;

import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.tips.TipsUtil;
import com.tencent.qphone.base.util.QLog;

class DoubleVideoMeetingCtrlUI$RequestVideoTimeoutRunnale
  implements Runnable
{
  DoubleVideoMeetingCtrlUI$RequestVideoTimeoutRunnale(DoubleVideoMeetingCtrlUI paramDoubleVideoMeetingCtrlUI) {}
  
  public void run()
  {
    if (this.this$0.am == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.this$0.X, 2, "RequestVideoTimeoutRunnale-->VideoControl is null");
      }
      return;
    }
    this.this$0.am.f("Meeting_RequestVideoTimeoutRunnale");
    this.this$0.e(true);
    TipsUtil.b(this.this$0.al, 1036);
    TipsUtil.b(this.this$0.al, 1037);
    this.this$0.am.k().b(this.this$0.k, true, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.DoubleVideoMeetingCtrlUI.RequestVideoTimeoutRunnale
 * JD-Core Version:    0.7.0.1
 */