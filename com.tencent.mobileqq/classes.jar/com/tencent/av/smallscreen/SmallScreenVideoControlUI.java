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
  protected Resources a;
  protected TextView a;
  protected VideoController a;
  public VideoAppInterface a;
  SmallScreenService jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService;
  SmallScreenVideoControlUI.TimmerRunnable jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI$TimmerRunnable = null;
  protected ControlUIObserver a;
  protected WeakReference<Context> a;
  View[] jdField_a_of_type_ArrayOfAndroidViewView = new View[2];
  String b;
  protected boolean b;
  String c;
  protected boolean c;
  protected int e = 0;
  
  public SmallScreenVideoControlUI(VideoAppInterface paramVideoAppInterface, SmallScreenService paramSmallScreenService, ControlUIObserver paramControlUIObserver)
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_a_of_type_AndroidContentResResources = null;
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
    this.jdField_a_of_type_ComTencentAvVideoController = null;
    this.jdField_a_of_type_AndroidWidgetTextView = null;
    this.jdField_c_of_type_JavaLangString = "DEVICE_EARPHONE;DEVICE_SPEAKERPHONE;DEVICE_BLUETOOTH_HEADSET;DEVICE_WIRED_HEADSET;";
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService = paramSmallScreenService;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService);
    this.jdField_a_of_type_AndroidContentResResources = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService.getResources();
    if (this.jdField_a_of_type_AndroidContentResResources == null)
    {
      QLog.d("SmallScreenVideoControlUI", 1, "mRes is null. exit video progress");
      paramVideoAppInterface = new StringBuilder();
      paramVideoAppInterface.append(paramSmallScreenService.getString(2131720211));
      paramVideoAppInterface.append(" 0x03");
      paramVideoAppInterface = paramVideoAppInterface.toString();
      QQToast.a(paramSmallScreenService.getApplicationContext(), paramVideoAppInterface, 0).a();
      paramSmallScreenService.stopSelf();
      return;
    }
    this.jdField_a_of_type_ComTencentAvVideoController = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    if (this.jdField_a_of_type_ComTencentAvVideoController == null)
    {
      QLog.d("SmallScreenVideoControlUI", 1, "mVideoController is null. exit video progress");
      paramVideoAppInterface = new StringBuilder();
      paramVideoAppInterface.append(this.jdField_a_of_type_AndroidContentResResources.getString(2131720211));
      paramVideoAppInterface.append(" 0x04");
      paramVideoAppInterface = paramVideoAppInterface.toString();
      QQToast.a(paramSmallScreenService.getApplicationContext(), paramVideoAppInterface, 0).a();
      paramSmallScreenService.stopSelf();
      return;
    }
    this.jdField_a_of_type_ComTencentAvUiControlUIObserver = paramControlUIObserver;
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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onDestroy, mUIState[");
    ((StringBuilder)localObject).append(this.e);
    ((StringBuilder)localObject).append("->");
    ((StringBuilder)localObject).append(6);
    ((StringBuilder)localObject).append("], seq[");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append("]");
    QLog.w("SmallScreenVideoControlUI", 1, ((StringBuilder)localObject).toString());
    this.e = 6;
    t();
    localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface;
    if (localObject != null)
    {
      ((VideoAppInterface)localObject).a().removeCallbacks(this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI$TimmerRunnable);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
    }
    this.jdField_a_of_type_AndroidContentResResources = null;
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    this.jdField_a_of_type_ComTencentAvVideoController = null;
    this.jdField_a_of_type_ArrayOfAndroidViewView = null;
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI$TimmerRunnable = null;
    this.jdField_a_of_type_ComTencentAvUiControlUIObserver = null;
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
  
  public void b(boolean paramBoolean) {}
  
  public void c() {}
  
  @TargetApi(11)
  public void c(int paramInt)
  {
    if (!this.jdField_a_of_type_ComTencentAvVideoController.a().j) {
      boolean bool = this.jdField_a_of_type_ComTencentAvVideoController.a().k;
    }
  }
  
  public void d() {}
  
  public void d(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onClose type = ");
    localStringBuilder.append(paramInt);
    QLog.d("SmallScreenVideoControlUI", 1, localStringBuilder.toString());
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().m())
    {
      e(paramInt);
      t();
      return;
    }
    if ((paramInt != 25) && (paramInt != 56))
    {
      if ((paramInt == 2) && (this.jdField_a_of_type_ComTencentAvVideoController.e()) && (this.jdField_a_of_type_ComTencentAvVideoController.a().n()))
      {
        e(65);
        AudioUtil.a(2131230745, 1, new SmallScreenVideoControlUI.1(this));
      }
    }
    else {
      e(paramInt);
    }
    u();
  }
  
  public void e()
  {
    this.e = 3;
  }
  
  void e(int paramInt)
  {
    a(VideoControlUI.a(this.jdField_a_of_type_ComTencentAvVideoController.a(), paramInt));
  }
  
  public void g()
  {
    this.e = 4;
  }
  
  protected void j()
  {
    Object localObject = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService;
    if (localObject == null) {
      return;
    }
    localObject = ((SmallScreenService)localObject).a(1);
    SmallScreenRelativeLayout localSmallScreenRelativeLayout = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService.a(0);
    if (localSmallScreenRelativeLayout != null)
    {
      if (localObject == null) {
        return;
      }
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localSmallScreenRelativeLayout.findViewById(2013331469));
      this.jdField_a_of_type_ArrayOfAndroidViewView[0] = ((SmallScreenRelativeLayout)localObject).findViewById(2013331462);
      this.jdField_a_of_type_ArrayOfAndroidViewView[1] = localSmallScreenRelativeLayout.findViewById(2013331462);
    }
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (this.jdField_a_of_type_ArrayOfAndroidViewView != null)
    {
      int i = 0;
      for (;;)
      {
        paramAnimation = this.jdField_a_of_type_ArrayOfAndroidViewView;
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
  
  public void p()
  {
    QLog.d("SmallScreenVideoControlUI", 1, "onStop");
    this.e = 5;
    t();
  }
  
  public void q()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoControlUI", 2, "onPauseAudio");
    }
  }
  
  public void r()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoControlUI", 2, "onResumeAudio");
    }
  }
  
  public void s()
  {
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    int i = this.e;
    if (((i < 2) || (i > 4)) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().j())) {
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
  
  public void t()
  {
    if (!this.jdField_b_of_type_Boolean) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoControlUI", 2, "stopTimer");
    }
    this.jdField_b_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI$TimmerRunnable != null)
    {
      VideoAppInterface localVideoAppInterface = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface;
      if (localVideoAppInterface != null) {
        localVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI$TimmerRunnable);
      }
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI$TimmerRunnable = null;
    }
  }
  
  protected void u()
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
      for (;;)
      {
        View[] arrayOfView = this.jdField_a_of_type_ArrayOfAndroidViewView;
        if (i >= arrayOfView.length) {
          break;
        }
        if (arrayOfView[i] != null)
        {
          arrayOfView[i].setVisibility(0);
          this.jdField_a_of_type_ArrayOfAndroidViewView[i].startAnimation(localAlphaAnimation);
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenVideoControlUI
 * JD-Core Version:    0.7.0.1
 */