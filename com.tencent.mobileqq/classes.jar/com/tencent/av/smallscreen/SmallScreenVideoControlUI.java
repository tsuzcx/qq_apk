package com.tencent.av.smallscreen;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Handler;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.ControlUIObserver;
import com.tencent.av.utils.TipsManager;
import com.tencent.av.utils.TraeHelper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import jpi;

public class SmallScreenVideoControlUI
  implements Animation.AnimationListener
{
  public Resources a;
  public TextView a;
  public VideoController a;
  public VideoAppInterface a;
  SmallScreenService jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService;
  public ControlUIObserver a;
  public TipsManager a;
  public WeakReference a;
  View[] jdField_a_of_type_ArrayOfAndroidViewView = new View[2];
  public TextView b;
  public String b;
  public boolean b;
  String c = "DEVICE_EARPHONE;DEVICE_SPEAKERPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;";
  public boolean c;
  boolean d = false;
  public int e;
  Runnable e;
  
  public SmallScreenVideoControlUI(VideoAppInterface paramVideoAppInterface, SmallScreenService paramSmallScreenService, ControlUIObserver paramControlUIObserver)
  {
    this.jdField_e_of_type_Int = 0;
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_e_of_type_JavaLangRunnable = null;
    this.jdField_a_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService = paramSmallScreenService;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService);
    this.jdField_a_of_type_AndroidContentResResources = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService.getResources();
    if (this.jdField_a_of_type_AndroidContentResResources == null)
    {
      QLog.d("SmallScreenVideoControlUI", 1, "mRes is null. exit video progress");
      paramVideoAppInterface = paramSmallScreenService.getString(2131428790) + " 0x03";
      QQToast.a(paramSmallScreenService.getApplicationContext(), paramVideoAppInterface, 0).a();
      paramSmallScreenService.stopSelf();
      return;
    }
    this.jdField_a_of_type_ComTencentAvVideoController = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    if (this.jdField_a_of_type_ComTencentAvVideoController == null)
    {
      QLog.d("SmallScreenVideoControlUI", 1, "mVideoController is null. exit video progress");
      paramVideoAppInterface = this.jdField_a_of_type_AndroidContentResResources.getString(2131428790) + " 0x04";
      QQToast.a(paramSmallScreenService.getApplicationContext(), paramVideoAppInterface, 0).a();
      paramSmallScreenService.stopSelf();
      return;
    }
    this.jdField_a_of_type_ComTencentAvUiControlUIObserver = paramControlUIObserver;
  }
  
  public int a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) {
      this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(38, paramInt);
    }
    return 0;
  }
  
  public void a() {}
  
  protected void a(int paramInt) {}
  
  public void a(String paramString1, String paramString2) {}
  
  public void a(String paramString, boolean paramBoolean) {}
  
  public void a(boolean paramBoolean)
  {
    QLog.d("SmallScreenVideoControlUI", 1, "onCreate");
    this.jdField_e_of_type_Int = 1;
    k();
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((this.d == paramBoolean2) || (this.jdField_a_of_type_ComTencentAvVideoController == null) || (this.jdField_a_of_type_ComTencentAvVideoController.k() != 5)) {}
    TraeHelper localTraeHelper;
    do
    {
      do
      {
        return;
        this.d = paramBoolean2;
        localTraeHelper = TraeHelper.a();
        if (!paramBoolean2) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("SmallScreenVideoControlUI", 2, "onPhoneCalling call start isSelf: " + paramBoolean1 + ",deviceName: " + this.jdField_a_of_type_ComTencentAvVideoController.a().o);
        }
        if (localTraeHelper != null) {
          localTraeHelper.b();
        }
      } while (this.jdField_a_of_type_ComTencentAvVideoController == null);
      this.jdField_a_of_type_ComTencentAvVideoController.a().u = this.jdField_a_of_type_ComTencentAvVideoController.a().o;
      return;
      if (QLog.isColorLevel()) {
        QLog.d("SmallScreenVideoControlUI", 2, "onPhoneCalling call end isSelf: " + paramBoolean1 + ",mAudioStateBeforePhoneCall: " + this.jdField_a_of_type_ComTencentAvVideoController.a().u + ",mAudioSesstionType:" + this.c);
      }
    } while ((localTraeHelper == null) || (this.jdField_a_of_type_ComTencentAvVideoController == null));
    if ("DEVICE_SPEAKERPHONE".equals(this.jdField_a_of_type_ComTencentAvVideoController.a().u))
    {
      localTraeHelper.a("DEVICE_EARPHONE;DEVICE_SPEAKERPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;");
      return;
    }
    if ("DEVICE_EARPHONE".equals(this.jdField_a_of_type_ComTencentAvVideoController.a().u))
    {
      localTraeHelper.a("DEVICE_SPEAKERPHONE;DEVICE_EARPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;");
      return;
    }
    localTraeHelper.a(this.c);
  }
  
  public void b()
  {
    this.jdField_e_of_type_Int = 2;
  }
  
  @TargetApi(11)
  public void b(int paramInt)
  {
    if ((Build.VERSION.SDK_INT > 11) && ((this.jdField_a_of_type_ComTencentAvVideoController.a().f) || (this.jdField_a_of_type_ComTencentAvVideoController.a().g)) && (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null)) {
      this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a.setRotation(360 - paramInt);
    }
  }
  
  public void b(boolean paramBoolean) {}
  
  public void c()
  {
    QLog.d("SmallScreenVideoControlUI", 1, "onDestroy");
    this.jdField_e_of_type_Int = 6;
    w();
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_e_of_type_JavaLangRunnable);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
    }
    this.jdField_a_of_type_AndroidContentResResources = null;
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    this.jdField_a_of_type_ComTencentAvVideoController = null;
    this.jdField_a_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_ComTencentAvUtilsTipsManager = null;
    this.jdField_a_of_type_ArrayOfAndroidViewView = null;
    this.jdField_e_of_type_JavaLangRunnable = null;
    this.jdField_a_of_type_ComTencentAvUiControlUIObserver = null;
    this.jdField_b_of_type_AndroidWidgetTextView = null;
  }
  
  public void c(int paramInt)
  {
    QLog.d("SmallScreenVideoControlUI", 1, "onClose type = " + paramInt);
    if ((this.jdField_a_of_type_ComTencentAvVideoController.a().g()) || (this.jdField_a_of_type_ComTencentAvVideoController.f))
    {
      d(paramInt);
      w();
      return;
    }
    if ((paramInt == 25) || (paramInt == 56)) {
      d(paramInt);
    }
    x();
  }
  
  public void d() {}
  
  void d(int paramInt)
  {
    int i = 2131429068;
    int j = 2131429412;
    switch (paramInt)
    {
    default: 
      i = 2131429412;
    case 12: 
    case 43: 
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().i == 1011) {
        if (paramInt == 9) {
          paramInt = j;
        }
      }
      break;
    }
    for (;;)
    {
      a(paramInt);
      return;
      i = 2131429400;
      break;
      i = 2131429412;
      break;
      i = 2131429410;
      break;
      i = 2131429071;
      break;
      i = 2131429412;
      break;
      i = 2131429412;
      break;
      paramInt = 2131429397;
      if (this.jdField_a_of_type_ComTencentAvVideoController.f)
      {
        paramInt = 2131429419;
        continue;
        paramInt = i;
      }
    }
  }
  
  public void e() {}
  
  public void f()
  {
    this.jdField_e_of_type_Int = 3;
  }
  
  public void h()
  {
    this.jdField_e_of_type_Int = 4;
  }
  
  protected void k()
  {
    TextView localTextView = (TextView)this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService.a.findViewById(2131365357);
    this.jdField_b_of_type_AndroidWidgetTextView = localTextView;
    this.jdField_a_of_type_AndroidWidgetTextView = localTextView;
    this.jdField_a_of_type_ArrayOfAndroidViewView[0] = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService.b.findViewById(2131365361);
    this.jdField_a_of_type_ArrayOfAndroidViewView[1] = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService.a.findViewById(2131365361);
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
  
  public void s()
  {
    QLog.d("SmallScreenVideoControlUI", 1, "onStop");
    this.jdField_e_of_type_Int = 5;
    w();
  }
  
  public void t()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoControlUI", 2, "onPauseAudio");
    }
    if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) {
      this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(29, true);
    }
  }
  
  public void u()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoControlUI", 2, "onResumeAudio");
    }
    if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) {
      this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(29, false);
    }
  }
  
  public void v()
  {
    if (this.jdField_b_of_type_Boolean) {}
    while (((this.jdField_e_of_type_Int < 2) || (this.jdField_e_of_type_Int > 4)) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().f())) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoControlUI", 2, "startTimer");
    }
    this.jdField_b_of_type_Boolean = true;
    if (this.jdField_e_of_type_JavaLangRunnable == null) {
      this.jdField_e_of_type_JavaLangRunnable = new jpi(this);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_e_of_type_JavaLangRunnable, 0L);
  }
  
  public void w()
  {
    if (!this.jdField_b_of_type_Boolean) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("SmallScreenVideoControlUI", 2, "stopTimer");
      }
      this.jdField_b_of_type_Boolean = false;
    } while (this.jdField_e_of_type_JavaLangRunnable == null);
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_e_of_type_JavaLangRunnable);
    }
    this.jdField_e_of_type_JavaLangRunnable = null;
  }
  
  public void x()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenVideoControlUI
 * JD-Core Version:    0.7.0.1
 */