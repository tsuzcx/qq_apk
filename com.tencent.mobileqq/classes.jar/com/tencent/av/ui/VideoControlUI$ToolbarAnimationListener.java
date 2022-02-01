package com.tencent.av.ui;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.tips.TipsUtil;
import com.tencent.av.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;

class VideoControlUI$ToolbarAnimationListener
  implements Animation.AnimationListener
{
  int a = 0;
  
  VideoControlUI$ToolbarAnimationListener(VideoControlUI paramVideoControlUI, int paramInt)
  {
    this.a = paramInt;
  }
  
  @TargetApi(11)
  public void onAnimationEnd(Animation paramAnimation)
  {
    long l = AudioHelper.c();
    this.b.al.a().removeCallbacks(this.b.bj);
    if ((this.b.al != null) && (paramAnimation != null) && (2 == this.a)) {
      this.b.al.a(new Object[] { Integer.valueOf(118), Boolean.valueOf(this.b.af), Boolean.valueOf(false), Long.valueOf(paramAnimation.getDuration()) });
    }
    String str = this.b.X;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onAnimationEnd, mToolBarType[");
    localStringBuilder.append(this.a);
    localStringBuilder.append("], animation[");
    localStringBuilder.append(paramAnimation);
    localStringBuilder.append("], mToolbarDisplay[");
    localStringBuilder.append(this.b.af);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(l);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    if (!this.b.af)
    {
      if (this.b.aB != null) {
        this.b.aB.setVisibility(4);
      }
      if (this.b.aC != null) {
        this.b.aC.setVisibility(0);
      }
      if (this.b.aA != null) {
        this.b.aA.setVisibility(4);
      }
      if (Build.VERSION.SDK_INT >= 19) {
        this.b.an.setBackgroundColor(0);
      }
      TipsUtil.b(this.b.al, true);
      paramAnimation = this.b;
      paramAnimation.bh = 0;
      if (paramAnimation.am != null)
      {
        paramAnimation = this.b.am.k();
        if (((paramAnimation.aQ == 2) || (paramAnimation.aQ == 1)) && (!this.b.am.k().q()))
        {
          paramAnimation = this.b;
          paramAnimation.a(l, 360 - paramAnimation.aJ);
        }
      }
    }
    else
    {
      if (this.b.aB != null) {
        this.b.aB.setVisibility(0);
      }
      if (this.b.aC != null) {
        this.b.aC.setVisibility(8);
      }
      if (this.b.aA != null)
      {
        this.b.aA.setVisibility(0);
        this.b.aA.setAlpha(1.0F);
      }
      if (this.b.aP != null)
      {
        if (QLog.isColorLevel()) {
          QLog.e(this.b.X, 2, "onAnimationEnd, change member list ui to visible");
        }
        this.b.aP.setVisibility(0);
      }
      VideoControlUI.a(this.b, true);
      paramAnimation = this.b;
      paramAnimation.bh = 5;
      if (paramAnimation.am != null)
      {
        paramAnimation = this.b.am.k();
        if ((paramAnimation.aQ == 2) || (paramAnimation.aQ == 1)) {
          this.b.a(l, 0.0F);
        }
      }
    }
    paramAnimation = this.b;
    paramAnimation.bi = false;
    paramAnimation.al.a(new Object[] { Integer.valueOf(102) });
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    Object localObject = this.b;
    ((VideoControlUI)localObject).bi = true;
    if ((((VideoControlUI)localObject).al != null) && (paramAnimation != null) && (2 == this.a)) {
      this.b.al.a(new Object[] { Integer.valueOf(118), Boolean.valueOf(this.b.af), Boolean.valueOf(true), Long.valueOf(paramAnimation.getDuration()) });
    }
    localObject = this.b.X;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(this.a);
    localStringBuilder.append("]onAnimationStart[");
    localStringBuilder.append(paramAnimation);
    localStringBuilder.append("]");
    QLog.w((String)localObject, 1, localStringBuilder.toString());
    paramAnimation = this.b;
    VideoControlUI.a(paramAnimation, (int)(paramAnimation.aG.getDuration() / 5L));
    if (this.b.af)
    {
      this.b.bh = 0;
    }
    else
    {
      paramAnimation = this.b;
      paramAnimation.bh = 5;
      VideoControlUI.a(paramAnimation, false);
    }
    this.b.al.a().post(this.b.bj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.VideoControlUI.ToolbarAnimationListener
 * JD-Core Version:    0.7.0.1
 */