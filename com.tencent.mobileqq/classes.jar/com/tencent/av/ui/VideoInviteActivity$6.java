package com.tencent.av.ui;

import com.tencent.av.VideoController;
import com.tencent.av.utils.CharacterUtil;

class VideoInviteActivity$6
  implements QavInOutAnimation.QavOutAnimationListener
{
  VideoInviteActivity$6(VideoInviteActivity paramVideoInviteActivity, long paramLong) {}
  
  public void a()
  {
    if (this.b.Q != null)
    {
      this.b.Q.setViewEnable(2131441182, false);
      this.b.Q.setViewEnable(2131428972, false);
      this.b.Q.setViewEnable(2131428983, false);
      this.b.Q.setViewEnable(2131428982, false);
    }
  }
  
  public void b()
  {
    VideoInviteActivity localVideoInviteActivity = this.b;
    localVideoInviteActivity.r = false;
    if (localVideoInviteActivity.G)
    {
      long l = CharacterUtil.b(this.b.o);
      this.b.d().a(this.a, 3, l);
      if (!this.b.F)
      {
        localVideoInviteActivity = this.b;
        localVideoInviteActivity.F = true;
        localVideoInviteActivity.d().a(this.a, l, 2);
      }
      localVideoInviteActivity = this.b;
      localVideoInviteActivity.s = true;
      localVideoInviteActivity.finish();
    }
    else
    {
      this.b.d().a(this.b.o, 246);
      this.b.d().b(246);
      this.b.d().b(this.b.o, 0);
      this.b.finish();
    }
    this.b.overridePendingTransition(0, 2130772285);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.VideoInviteActivity.6
 * JD-Core Version:    0.7.0.1
 */