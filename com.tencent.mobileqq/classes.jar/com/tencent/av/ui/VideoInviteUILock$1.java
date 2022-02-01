package com.tencent.av.ui;

import android.content.Intent;
import com.tencent.qphone.base.util.QLog;

class VideoInviteUILock$1
  implements QavPanel.SlideAcceptListener
{
  VideoInviteUILock$1(VideoInviteUILock paramVideoInviteUILock, long paramLong) {}
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (VideoInviteUILock.a(this.jdField_a_of_type_ComTencentAvUiVideoInviteUILock)) {
        return;
      }
      if (this.jdField_a_of_type_ComTencentAvUiVideoInviteUILock.a.getIntent().getBooleanExtra("isDoubleVideoMeeting", false)) {
        this.jdField_a_of_type_ComTencentAvUiVideoInviteUILock.a("0X80051FE");
      }
      for (;;)
      {
        QLog.w("VideoInviteUILock", 1, "SlideAcceptListener, seq[" + this.jdField_a_of_type_Long + "]");
        this.jdField_a_of_type_ComTencentAvUiVideoInviteUILock.a.d = true;
        this.jdField_a_of_type_ComTencentAvUiVideoInviteUILock.a.c(this.jdField_a_of_type_Long);
        return;
        if (this.jdField_a_of_type_ComTencentAvUiVideoInviteUILock.a.b) {
          this.jdField_a_of_type_ComTencentAvUiVideoInviteUILock.a("0X8004201");
        } else {
          this.jdField_a_of_type_ComTencentAvUiVideoInviteUILock.a("0X8004205");
        }
      }
    }
    if (this.jdField_a_of_type_ComTencentAvUiVideoInviteUILock.a.b)
    {
      this.jdField_a_of_type_ComTencentAvUiVideoInviteUILock.a("0X800439E");
      return;
    }
    this.jdField_a_of_type_ComTencentAvUiVideoInviteUILock.a("0X80043FD");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.VideoInviteUILock.1
 * JD-Core Version:    0.7.0.1
 */