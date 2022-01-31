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
import bbbr;
import bcpw;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.DoubleVideoCtrlUI;
import com.tencent.av.ui.VideoControlUI;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import lgf;
import lzl;
import mck;

public class SmallScreenVideoControlUI
  implements Animation.AnimationListener
{
  protected Resources a;
  protected TextView a;
  protected VideoController a;
  protected VideoAppInterface a;
  SmallScreenService jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService;
  SmallScreenVideoControlUI.TimmerRunnable jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI$TimmerRunnable = null;
  protected WeakReference<Context> a;
  protected mck a;
  View[] jdField_a_of_type_ArrayOfAndroidViewView = new View[2];
  String b;
  protected boolean b;
  String c = "DEVICE_EARPHONE;DEVICE_SPEAKERPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;";
  protected boolean c;
  protected int e = 0;
  
  public SmallScreenVideoControlUI(VideoAppInterface paramVideoAppInterface, SmallScreenService paramSmallScreenService, mck parammck)
  {
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService = paramSmallScreenService;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService);
    this.jdField_a_of_type_AndroidContentResResources = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService.getResources();
    if (this.jdField_a_of_type_AndroidContentResResources == null)
    {
      QLog.d("SmallScreenVideoControlUI", 1, "mRes is null. exit video progress");
      paramVideoAppInterface = paramSmallScreenService.getString(2131720738) + " 0x03";
      bcpw.a(paramSmallScreenService.getApplicationContext(), paramVideoAppInterface, 0).a();
      paramSmallScreenService.stopSelf();
      return;
    }
    this.jdField_a_of_type_ComTencentAvVideoController = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    if (this.jdField_a_of_type_ComTencentAvVideoController == null)
    {
      QLog.d("SmallScreenVideoControlUI", 1, "mVideoController is null. exit video progress");
      paramVideoAppInterface = this.jdField_a_of_type_AndroidContentResResources.getString(2131720738) + " 0x04";
      bcpw.a(paramSmallScreenService.getApplicationContext(), paramVideoAppInterface, 0).a();
      paramSmallScreenService.stopSelf();
      return;
    }
    this.jdField_a_of_type_Mck = parammck;
  }
  
  public int a(int paramInt)
  {
    DoubleVideoCtrlUI.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramInt);
    return 0;
  }
  
  public void a() {}
  
  protected void a(int paramInt) {}
  
  public void a(long paramLong)
  {
    QLog.w("SmallScreenVideoControlUI", 1, "onDestroy, mUIState[" + this.e + "->" + 6 + "], seq[" + paramLong + "]");
    this.e = 6;
    u();
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI$TimmerRunnable);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
    }
    this.jdField_a_of_type_AndroidContentResResources = null;
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    this.jdField_a_of_type_ComTencentAvVideoController = null;
    this.jdField_a_of_type_ArrayOfAndroidViewView = null;
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI$TimmerRunnable = null;
    this.jdField_a_of_type_Mck = null;
    this.jdField_a_of_type_AndroidWidgetTextView = null;
  }
  
  public void a(String paramString1, String paramString2) {}
  
  public void a(String paramString, boolean paramBoolean) {}
  
  public void a(boolean paramBoolean)
  {
    QLog.d("SmallScreenVideoControlUI", 1, "onCreate");
    this.e = 1;
    j();
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void b()
  {
    this.e = 2;
  }
  
  @TargetApi(11)
  public void b(int paramInt)
  {
    if ((!this.jdField_a_of_type_ComTencentAvVideoController.a().j) && (this.jdField_a_of_type_ComTencentAvVideoController.a().k)) {}
  }
  
  public void b(boolean paramBoolean) {}
  
  public void c() {}
  
  public void c(int paramInt)
  {
    QLog.d("SmallScreenVideoControlUI", 1, "onClose type = " + paramInt);
    if ((this.jdField_a_of_type_ComTencentAvVideoController.a().m()) || (this.jdField_a_of_type_ComTencentAvVideoController.f))
    {
      d(paramInt);
      u();
      return;
    }
    if ((paramInt == 25) || (paramInt == 56)) {
      d(paramInt);
    }
    for (;;)
    {
      v();
      return;
      if ((paramInt == 2) && (this.jdField_a_of_type_ComTencentAvVideoController.c()) && (this.jdField_a_of_type_ComTencentAvVideoController.a().n()))
      {
        d(65);
        bbbr.a(2131230741, 1, new lzl(this));
      }
    }
  }
  
  public void d() {}
  
  void d(int paramInt)
  {
    a(VideoControlUI.a(this.jdField_a_of_type_ComTencentAvVideoController.a(), paramInt));
  }
  
  public void e()
  {
    this.e = 3;
  }
  
  public void g()
  {
    this.e = 4;
  }
  
  protected void j()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService.a.findViewById(2131372514));
    this.jdField_a_of_type_ArrayOfAndroidViewView[0] = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService.b.findViewById(2131372235);
    this.jdField_a_of_type_ArrayOfAndroidViewView[1] = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService.a.findViewById(2131372235);
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (this.jdField_a_of_type_ArrayOfAndroidViewView != null)
    {
      int i = 0;
      while (i < this.jdField_a_of_type_ArrayOfAndroidViewView.length)
      {
        if (this.jdField_a_of_type_ArrayOfAndroidViewView[i] != null) {
          this.jdField_a_of_type_ArrayOfAndroidViewView[i].setVisibility(8);
        }
        i += 1;
      }
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
  
  public void q()
  {
    QLog.d("SmallScreenVideoControlUI", 1, "onStop");
    this.e = 5;
    u();
  }
  
  public void r()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoControlUI", 2, "onPauseAudio");
    }
  }
  
  public void s()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoControlUI", 2, "onResumeAudio");
    }
  }
  
  public void t()
  {
    if (this.jdField_b_of_type_Boolean) {}
    while (((this.e < 2) || (this.e > 4)) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().j())) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoControlUI", 2, "startTimer");
    }
    this.jdField_b_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI$TimmerRunnable == null) {
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI$TimmerRunnable = new SmallScreenVideoControlUI.TimmerRunnable(this);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI$TimmerRunnable, 0L);
  }
  
  public void u()
  {
    if (!this.jdField_b_of_type_Boolean) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("SmallScreenVideoControlUI", 2, "stopTimer");
      }
      this.jdField_b_of_type_Boolean = false;
    } while (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI$TimmerRunnable == null);
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI$TimmerRunnable);
    }
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI$TimmerRunnable = null;
  }
  
  protected void v()
  {
    if (this.jdField_a_of_type_ArrayOfAndroidViewView != null)
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
      while (i < this.jdField_a_of_type_ArrayOfAndroidViewView.length)
      {
        if (this.jdField_a_of_type_ArrayOfAndroidViewView[i] != null)
        {
          this.jdField_a_of_type_ArrayOfAndroidViewView[i].setVisibility(0);
          this.jdField_a_of_type_ArrayOfAndroidViewView[i].startAnimation(localAlphaAnimation);
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenVideoControlUI
 * JD-Core Version:    0.7.0.1
 */