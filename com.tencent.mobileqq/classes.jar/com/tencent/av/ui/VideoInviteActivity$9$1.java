package com.tencent.av.ui;

import com.tencent.av.VideoController;
import com.tencent.qphone.base.util.QLog;

class VideoInviteActivity$9$1
  implements QavInOutAnimation.QavOutAnimationListener
{
  VideoInviteActivity$9$1(VideoInviteActivity.9 param9, int paramInt) {}
  
  public void a()
  {
    if (this.b.b.Q != null)
    {
      this.b.b.Q.setViewEnable(2131441182, false);
      this.b.b.Q.setViewEnable(2131428972, false);
      this.b.b.Q.setViewEnable(2131428983, false);
      this.b.b.Q.setViewEnable(2131428982, false);
    }
  }
  
  public void b()
  {
    this.b.b.d().a(this.b.b.o, 250);
    this.b.b.d().b(250);
    this.b.b.d().b(this.b.b.o, this.a);
    this.b.b.s = true;
    QLog.d(this.b.b.a, 1, "onClose()-> onOutAnimationEnd ->finish  ");
    this.b.b.finish();
    this.b.b.overridePendingTransition(0, 2130772285);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.VideoInviteActivity.9.1
 * JD-Core Version:    0.7.0.1
 */