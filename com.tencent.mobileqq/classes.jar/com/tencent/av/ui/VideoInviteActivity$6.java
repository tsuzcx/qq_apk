package com.tencent.av.ui;

import com.tencent.av.VideoController;
import com.tencent.av.utils.CharacterUtil;

class VideoInviteActivity$6
  implements QavInOutAnimation.QavOutAnimationListener
{
  VideoInviteActivity$6(VideoInviteActivity paramVideoInviteActivity, long paramLong) {}
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.a != null)
    {
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.a.setViewEnable(2131373510, false);
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.a.setViewEnable(2131363119, false);
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.a.setViewEnable(2131363130, false);
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.a.setViewEnable(2131363129, false);
    }
  }
  
  public void b()
  {
    VideoInviteActivity localVideoInviteActivity = this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity;
    localVideoInviteActivity.d = false;
    if (localVideoInviteActivity.i)
    {
      long l = CharacterUtil.a(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.c);
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.a().a(this.jdField_a_of_type_Long, 3, l);
      if (!this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.h)
      {
        localVideoInviteActivity = this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity;
        localVideoInviteActivity.h = true;
        localVideoInviteActivity.a().a(this.jdField_a_of_type_Long, l, 2);
      }
      localVideoInviteActivity = this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity;
      localVideoInviteActivity.e = true;
      localVideoInviteActivity.finish();
    }
    else
    {
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.a().a(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.c, 246);
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.a().b(246);
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.a().b(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.c, 0);
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.finish();
    }
    this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.overridePendingTransition(0, 2130772219);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.VideoInviteActivity.6
 * JD-Core Version:    0.7.0.1
 */