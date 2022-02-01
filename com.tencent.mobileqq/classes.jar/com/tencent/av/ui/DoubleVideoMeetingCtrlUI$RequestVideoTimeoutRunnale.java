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
    if (this.this$0.jdField_a_of_type_ComTencentAvVideoController == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.this$0.d, 2, "RequestVideoTimeoutRunnale-->VideoControl is null");
      }
      return;
    }
    this.this$0.jdField_a_of_type_ComTencentAvVideoController.a("Meeting_RequestVideoTimeoutRunnale");
    this.this$0.d(true);
    TipsUtil.a(this.this$0.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1036);
    TipsUtil.a(this.this$0.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1037);
    this.this$0.jdField_a_of_type_ComTencentAvVideoController.a().a(this.this$0.b, true, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.DoubleVideoMeetingCtrlUI.RequestVideoTimeoutRunnale
 * JD-Core Version:    0.7.0.1
 */