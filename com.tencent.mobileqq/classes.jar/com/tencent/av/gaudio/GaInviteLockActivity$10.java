package com.tencent.av.gaudio;

import com.tencent.av.ui.QavInOutAnimation.QavOutAnimationListener;
import com.tencent.av.ui.QavPanel;

class GaInviteLockActivity$10
  implements QavInOutAnimation.QavOutAnimationListener
{
  GaInviteLockActivity$10(GaInviteLockActivity paramGaInviteLockActivity) {}
  
  public void a()
  {
    if (this.a.a != null)
    {
      this.a.a.setViewEnable(2131373939, false);
      this.a.a.setViewEnable(2131373938, false);
      this.a.a.setViewEnable(2131363179, false);
    }
  }
  
  public void b()
  {
    this.a.finish();
    this.a.overridePendingTransition(0, 2130772192);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.gaudio.GaInviteLockActivity.10
 * JD-Core Version:    0.7.0.1
 */