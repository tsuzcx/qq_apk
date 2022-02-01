package com.tencent.av.ui;

import com.tencent.av.VideoController;
import com.tencent.qphone.base.util.QLog;
import lfe;
import mbf;

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
    mbf.a(this.this$0.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1036);
    mbf.a(this.this$0.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1037);
    this.this$0.jdField_a_of_type_ComTencentAvVideoController.a().a(this.this$0.b, true, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.ui.DoubleVideoMeetingCtrlUI.RequestVideoTimeoutRunnale
 * JD-Core Version:    0.7.0.1
 */