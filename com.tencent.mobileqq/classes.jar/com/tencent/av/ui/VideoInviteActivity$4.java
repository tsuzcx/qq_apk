package com.tencent.av.ui;

import com.tencent.av.VideoController;
import com.tencent.av.utils.CharacterUtil;

class VideoInviteActivity$4
  implements QavInOutAnimation.QavOutAnimationListener
{
  VideoInviteActivity$4(VideoInviteActivity paramVideoInviteActivity, long paramLong, boolean paramBoolean) {}
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.a != null)
    {
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.a.setViewEnable(2131373938, false);
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.a.setViewEnable(2131363179, false);
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.a.setViewEnable(2131363191, false);
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.a.setViewEnable(2131363190, false);
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.i)
    {
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.a().a(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.c, 1, true);
      long l = CharacterUtil.a(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.c);
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.a().a(this.jdField_a_of_type_Long, 3, l);
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.h = true;
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.a().a(this.jdField_a_of_type_Long, l, 1);
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.e = true;
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.finish();
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.overridePendingTransition(0, 2130772192);
      return;
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.a().a(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.c, 1, false);
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.a().a(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.c, 248);
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.a().b(248);
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.a().b(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.c, 1);
      }
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.VideoInviteActivity.4
 * JD-Core Version:    0.7.0.1
 */