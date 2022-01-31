package com.tencent.av.ui;

import com.tencent.av.VideoController;
import com.tencent.av.screenshare.ScreenShareCtrl;

class DoubleVideoMeetingCtrlUI$6
  implements Runnable
{
  DoubleVideoMeetingCtrlUI$6(DoubleVideoMeetingCtrlUI paramDoubleVideoMeetingCtrlUI, AVActivity paramAVActivity, boolean paramBoolean, long paramLong) {}
  
  public void run()
  {
    this.this$0.c();
    this.jdField_a_of_type_ComTencentAvUiAVActivity.a(4, false);
    if ((this.jdField_a_of_type_Boolean) && (this.this$0.a != null))
    {
      this.this$0.g(this.jdField_a_of_type_Long, 2131695840);
      ScreenShareCtrl localScreenShareCtrl = this.this$0.a.a();
      if (localScreenShareCtrl != null) {
        localScreenShareCtrl.a(this.this$0.a(), this.jdField_a_of_type_Long);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.ui.DoubleVideoMeetingCtrlUI.6
 * JD-Core Version:    0.7.0.1
 */