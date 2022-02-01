package com.tencent.av.smallscreen;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.TextView;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.ControlUIObserver;
import com.tencent.av.ui.DoubleVideoCtrlUI;
import com.tencent.av.ui.VideoControlUI;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class SmallScreenVideoControlUI
  implements Animation.AnimationListener
{
  protected ControlUIObserver A;
  protected TextView B = null;
  View[] C = new View[2];
  String D = "DEVICE_EARPHONE;DEVICE_SPEAKERPHONE;DEVICE_BLUETOOTH_HEADSET;DEVICE_WIRED_HEADSET;";
  SmallScreenService q;
  protected int r = 0;
  protected boolean s = false;
  protected boolean t = false;
  String u = null;
  SmallScreenVideoControlUI.TimmerRunnable v = null;
  protected Resources w = null;
  protected WeakReference<Context> x = null;
  public VideoAppInterface y = null;
  protected VideoController z = null;
  
  public SmallScreenVideoControlUI(VideoAppInterface paramVideoAppInterface, SmallScreenService paramSmallScreenService, ControlUIObserver paramControlUIObserver)
  {
    this.q = paramSmallScreenService;
    this.y = paramVideoAppInterface;
    this.x = new WeakReference(this.q);
    this.w = this.q.getResources();
    if (this.w == null)
    {
      QLog.d("SmallScreenVideoControlUI", 1, "mRes is null. exit video progress");
      paramVideoAppInterface = new StringBuilder();
      paramVideoAppInterface.append(paramSmallScreenService.getString(2131917844));
      paramVideoAppInterface.append(" 0x03");
      paramVideoAppInterface = paramVideoAppInterface.toString();
      QQToast.makeText(paramSmallScreenService.getApplicationContext(), paramVideoAppInterface, 0).show();
      paramSmallScreenService.stopSelf();
      return;
    }
    this.z = this.y.b();
    if (this.z == null)
    {
      QLog.d("SmallScreenVideoControlUI", 1, "mVideoController is null. exit video progress");
      paramVideoAppInterface = new StringBuilder();
      paramVideoAppInterface.append(this.w.getString(2131917844));
      paramVideoAppInterface.append(" 0x04");
      paramVideoAppInterface = paramVideoAppInterface.toString();
      QQToast.makeText(paramSmallScreenService.getApplicationContext(), paramVideoAppInterface, 0).show();
      paramSmallScreenService.stopSelf();
      return;
    }
    this.A = paramControlUIObserver;
  }
  
  public void a() {}
  
  protected void a(int paramInt) {}
  
  public void a(long paramLong)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onDestroy, mUIState[");
    ((StringBuilder)localObject).append(this.r);
    ((StringBuilder)localObject).append("->");
    ((StringBuilder)localObject).append(6);
    ((StringBuilder)localObject).append("], seq[");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append("]");
    QLog.w("SmallScreenVideoControlUI", 1, ((StringBuilder)localObject).toString());
    this.r = 6;
    w();
    localObject = this.y;
    if (localObject != null)
    {
      ((VideoAppInterface)localObject).a().removeCallbacks(this.v);
      this.y = null;
    }
    this.w = null;
    this.x = null;
    this.z = null;
    this.C = null;
    this.v = null;
    this.A = null;
    this.B = null;
  }
  
  public void a(String paramString1, String paramString2) {}
  
  public void a(String paramString, boolean paramBoolean) {}
  
  public void a(boolean paramBoolean)
  {
    QLog.d("SmallScreenVideoControlUI", 1, "onCreate");
    this.r = 1;
    j();
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void b()
  {
    this.r = 2;
  }
  
  public void b(boolean paramBoolean) {}
  
  public int c(int paramInt)
  {
    DoubleVideoCtrlUI.a(this.y, paramInt);
    return 0;
  }
  
  public void c() {}
  
  public void d() {}
  
  @TargetApi(11)
  public void d(int paramInt)
  {
    if (!this.z.k().H) {
      boolean bool = this.z.k().I;
    }
  }
  
  public void e()
  {
    this.r = 3;
  }
  
  public void e(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onClose type = ");
    localStringBuilder.append(paramInt);
    QLog.d("SmallScreenVideoControlUI", 1, localStringBuilder.toString());
    if (this.z.k().m())
    {
      g(paramInt);
      w();
      return;
    }
    if ((paramInt != 25) && (paramInt != 56))
    {
      if ((paramInt == 2) && (this.z.l()) && (this.z.k().n()))
      {
        g(65);
        AudioUtil.a(2131230813, 1, new SmallScreenVideoControlUI.1(this));
      }
    }
    else {
      g(paramInt);
    }
    x();
  }
  
  protected void f(int paramInt)
  {
    g(65);
    AudioUtil.a(2131230813, 1, new SmallScreenVideoControlUI.2(this));
    x();
  }
  
  public void g()
  {
    this.r = 4;
  }
  
  void g(int paramInt)
  {
    int i = VideoControlUI.a(this.z.k(), paramInt);
    if (paramInt == 3) {
      i = 2131893622;
    }
    a(i);
  }
  
  protected void j()
  {
    Object localObject = this.q;
    if (localObject == null) {
      return;
    }
    localObject = ((SmallScreenService)localObject).b(1);
    SmallScreenRelativeLayout localSmallScreenRelativeLayout = this.q.b(0);
    if (localSmallScreenRelativeLayout != null)
    {
      if (localObject == null) {
        return;
      }
      this.B = ((TextView)localSmallScreenRelativeLayout.findViewById(2013331469));
      this.C[0] = ((SmallScreenRelativeLayout)localObject).findViewById(2013331462);
      this.C[1] = localSmallScreenRelativeLayout.findViewById(2013331462);
    }
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (this.C != null)
    {
      int i = 0;
      for (;;)
      {
        paramAnimation = this.C;
        if (i >= paramAnimation.length) {
          break;
        }
        if (paramAnimation[i] != null) {
          paramAnimation[i].setVisibility(8);
        }
        i += 1;
      }
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
  
  public void s()
  {
    QLog.d("SmallScreenVideoControlUI", 1, "onStop");
    this.r = 5;
    w();
  }
  
  public void t()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoControlUI", 2, "onPauseAudio");
    }
  }
  
  public void u()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoControlUI", 2, "onResumeAudio");
    }
  }
  
  public void v()
  {
    if (this.s) {
      return;
    }
    int i = this.r;
    if (((i < 2) || (i > 4)) && (!this.z.k().j())) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoControlUI", 2, "startTimer");
    }
    this.s = true;
    if (this.v == null) {
      this.v = new SmallScreenVideoControlUI.TimmerRunnable(this);
    }
    this.y.a().postDelayed(this.v, 0L);
  }
  
  public void w()
  {
    if (!this.s) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoControlUI", 2, "stopTimer");
    }
    this.s = false;
    if (this.v != null)
    {
      VideoAppInterface localVideoAppInterface = this.y;
      if (localVideoAppInterface != null) {
        localVideoAppInterface.a().removeCallbacks(this.v);
      }
      this.v = null;
    }
  }
  
  protected void x()
  {
    if (this.C != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SmallScreenVideoControlUI", 2, "setScreenDarken");
      }
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
      localAlphaAnimation.setDuration(100L);
      localAlphaAnimation.setRepeatMode(2);
      localAlphaAnimation.setRepeatCount(6);
      localAlphaAnimation.setFillAfter(true);
      localAlphaAnimation.setAnimationListener(this);
      int i = 0;
      for (;;)
      {
        View[] arrayOfView = this.C;
        if (i >= arrayOfView.length) {
          break;
        }
        if (arrayOfView[i] != null)
        {
          arrayOfView[i].setVisibility(0);
          this.C[i].startAnimation(localAlphaAnimation);
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenVideoControlUI
 * JD-Core Version:    0.7.0.1
 */