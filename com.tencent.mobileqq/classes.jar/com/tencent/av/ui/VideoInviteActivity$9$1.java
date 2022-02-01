package com.tencent.av.ui;

import com.tencent.av.VideoController;
import com.tencent.qphone.base.util.QLog;

class VideoInviteActivity$9$1
  implements QavInOutAnimation.QavOutAnimationListener
{
  VideoInviteActivity$9$1(VideoInviteActivity.9 param9, int paramInt) {}
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity$9.a.jdField_a_of_type_ComTencentAvUiQavPanel != null)
    {
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity$9.a.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131373510, false);
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity$9.a.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131363119, false);
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity$9.a.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131363130, false);
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity$9.a.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131363129, false);
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity$9.a.a().a(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity$9.a.c, 250);
    this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity$9.a.a().b(250);
    this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity$9.a.a().b(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity$9.a.c, this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity$9.a.e = true;
    QLog.d(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity$9.a.jdField_a_of_type_JavaLangString, 1, "onClose()-> onOutAnimationEnd ->finish  ");
    this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity$9.a.finish();
    this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity$9.a.overridePendingTransition(0, 2130772219);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.VideoInviteActivity.9.1
 * JD-Core Version:    0.7.0.1
 */