package com.tencent.av.ui;

import com.tencent.av.VideoController;
import com.tencent.av.app.GAudioUIObserver;
import com.tencent.av.utils.TraeHelper;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;

class VideoInviteActivity$10
  extends GAudioUIObserver
{
  VideoInviteActivity$10(VideoInviteActivity paramVideoInviteActivity) {}
  
  public void a(long paramLong, int paramInt)
  {
    long l = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.w(this.a.jdField_a_of_type_JavaLangString, 1, "onDestroyInviteUI, relationId[" + paramLong + "], seq[" + l + "]");
    }
    boolean bool = this.a.i;
    if ((bool) && (this.a.c != null) && (this.a.c.equals(String.valueOf(paramLong))))
    {
      super.a(paramLong);
      TraeHelper.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      this.a.a(l);
      if ((bool) && (this.a.c.length() > 2) && (paramLong != 0L))
      {
        paramLong = Long.valueOf(this.a.c).longValue();
        if (!this.a.h)
        {
          this.a.h = true;
          if (paramInt != 1) {
            break label255;
          }
          this.a.a().a(l, paramLong, 7);
        }
      }
    }
    for (;;)
    {
      this.a.e = true;
      if ((!this.a.l) || (this.a.jdField_a_of_type_ComTencentAvUiQavInOutAnimation == null) || (this.a.f())) {
        break;
      }
      this.a.jdField_a_of_type_ComTencentAvUiQavInOutAnimation.a(new VideoInviteActivity.10.1(this));
      return;
      label255:
      if (paramInt == 2) {
        this.a.a().a(l, paramLong, 2);
      }
    }
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.VideoInviteActivity.10
 * JD-Core Version:    0.7.0.1
 */