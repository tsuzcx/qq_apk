package com.tencent.av.ui;

import com.tencent.av.VideoController;
import com.tencent.av.utils.CharacterUtil;

class VideoInviteActivity$4
  implements QavInOutAnimation.QavOutAnimationListener
{
  VideoInviteActivity$4(VideoInviteActivity paramVideoInviteActivity, long paramLong, boolean paramBoolean) {}
  
  public void a()
  {
    if (this.c.Q != null)
    {
      this.c.Q.setViewEnable(2131441182, false);
      this.c.Q.setViewEnable(2131428972, false);
      this.c.Q.setViewEnable(2131428983, false);
      this.c.Q.setViewEnable(2131428982, false);
    }
  }
  
  public void b()
  {
    if (this.c.G)
    {
      this.c.d().a(this.a, this.c.o, 1, true);
      long l = CharacterUtil.b(this.c.o);
      this.c.d().a(this.a, 3, l);
      VideoInviteActivity localVideoInviteActivity = this.c;
      localVideoInviteActivity.F = true;
      localVideoInviteActivity.d().a(this.a, l, 1);
      localVideoInviteActivity = this.c;
      localVideoInviteActivity.s = true;
      localVideoInviteActivity.finish();
    }
    else
    {
      this.c.d().a(this.a, this.c.o, 1, false);
      this.c.d().a(this.c.o, 248);
      this.c.d().b(248);
      if (this.b) {
        this.c.d().b(this.c.o, 1);
      }
      this.c.finish();
    }
    this.c.overridePendingTransition(0, 2130772285);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.VideoInviteActivity.4
 * JD-Core Version:    0.7.0.1
 */