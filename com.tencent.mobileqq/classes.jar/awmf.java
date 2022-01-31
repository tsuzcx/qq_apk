import android.annotation.TargetApi;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.Interpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.nineoldandroids.animation.Animator.AnimatorListener;
import com.nineoldandroids.animation.ValueAnimator;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.portal.BreathEffectView;
import com.tencent.mobileqq.portal.ConversationHongBao.1;
import com.tencent.mobileqq.portal.FormalView;
import com.tencent.mobileqq.portal.HongbaoCaidanRainView;
import com.tencent.mobileqq.portal.PortalManager;
import com.tencent.mobileqq.portal.PortalManager.LogoConfig;
import com.tencent.mobileqq.portal.PrepareView;
import com.tencent.mobileqq.portal.ProgressViewRed;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HongBaoListView;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.Constants.LogoutReason;

public class awmf
  implements Handler.Callback
{
  int jdField_a_of_type_Int = 0;
  public long a;
  private Activity jdField_a_of_type_AndroidAppActivity;
  CountDownTimer jdField_a_of_type_AndroidOsCountDownTimer = null;
  public Handler a;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private Interpolator jdField_a_of_type_AndroidViewAnimationInterpolator = new AccelerateDecelerateInterpolator();
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  public bhxo a;
  private Animator.AnimatorListener jdField_a_of_type_ComNineoldandroidsAnimationAnimator$AnimatorListener;
  private ValueAnimator jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator;
  Conversation jdField_a_of_type_ComTencentMobileqqActivityConversation;
  private BreathEffectView jdField_a_of_type_ComTencentMobileqqPortalBreathEffectView;
  public FormalView a;
  public PrepareView a;
  private ProgressViewRed jdField_a_of_type_ComTencentMobileqqPortalProgressViewRed;
  public HongBaoListView a;
  public Runnable a;
  String jdField_a_of_type_JavaLangString = "";
  StringBuilder jdField_a_of_type_JavaLangStringBuilder = new StringBuilder(12);
  AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  public boolean a;
  public int b;
  long jdField_b_of_type_Long;
  Handler jdField_b_of_type_AndroidOsHandler = new Handler(ThreadManager.getFileThreadLooper(), this);
  private Animator.AnimatorListener jdField_b_of_type_ComNineoldandroidsAnimationAnimator$AnimatorListener;
  private ValueAnimator jdField_b_of_type_ComNineoldandroidsAnimationValueAnimator;
  private String jdField_b_of_type_JavaLangString;
  StringBuilder jdField_b_of_type_JavaLangStringBuilder = new StringBuilder(8);
  boolean jdField_b_of_type_Boolean = true;
  int c;
  public long c;
  public boolean c;
  public int d;
  long d;
  public boolean d;
  public int e;
  public long e;
  public boolean e;
  private int f;
  public boolean f;
  private boolean g;
  
  public awmf(Conversation paramConversation, ViewGroup paramViewGroup)
  {
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = -1;
    this.jdField_c_of_type_Long = -1L;
    this.jdField_d_of_type_Long = 0L;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    this.jdField_e_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangRunnable = new ConversationHongBao.1(this);
    this.jdField_a_of_type_Bhxo = new awmi(this);
    this.jdField_c_of_type_Boolean = true;
    this.jdField_f_of_type_Int = -1;
    this.jdField_e_of_type_Boolean = true;
    this.jdField_f_of_type_Boolean = bhtb.e();
    this.jdField_a_of_type_ComTencentMobileqqActivityConversation = paramConversation;
    this.jdField_a_of_type_AndroidAppActivity = paramConversation.a();
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
  }
  
  private void a(int paramInt)
  {
    Object localObject1;
    int i;
    long l;
    if (((this.jdField_d_of_type_Int == 3) || (this.jdField_d_of_type_Int == 4) || (this.jdField_d_of_type_Int == 5)) && (this.jdField_a_of_type_ComTencentMobileqqPortalFormalView != null))
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqPortalFormalView.jdField_a_of_type_JavaUtilList;
      i = this.jdField_a_of_type_ComTencentMobileqqPortalFormalView.jdField_a_of_type_Int;
      l = this.jdField_a_of_type_ComTencentMobileqqPortalFormalView.jdField_a_of_type_Long;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ConversationHongBao", 2, "loopIcon logoList=" + localObject1 + ", index=" + paramInt + ", mState=" + this.jdField_d_of_type_Int + ", mode=" + i + ", scrollTime=" + l);
      }
      if ((localObject1 == null) || (((List)localObject1).size() <= paramInt) || (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) || (i != 3))
      {
        return;
        if ((this.jdField_d_of_type_Int == 2) && (this.jdField_a_of_type_ComTencentMobileqqPortalPrepareView != null))
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqPortalPrepareView.jdField_a_of_type_JavaUtilList;
          i = this.jdField_a_of_type_ComTencentMobileqqPortalPrepareView.jdField_a_of_type_Int;
          l = this.jdField_a_of_type_ComTencentMobileqqPortalPrepareView.jdField_a_of_type_Long;
        }
      }
      else
      {
        Object localObject3 = (PortalManager.LogoConfig)((List)localObject1).get(paramInt);
        Bundle localBundle = new Bundle();
        Bitmap localBitmap;
        Object localObject4;
        if (localObject3 != null)
        {
          localBitmap = PortalManager.a(((PortalManager.LogoConfig)localObject3).logoImageMD5, "hb_busi_logo_path");
          localObject4 = ((PortalManager.LogoConfig)localObject3).nameMD5;
          if (this.jdField_d_of_type_Int != 2) {
            break label399;
          }
        }
        label399:
        for (Object localObject2 = "hb_yure_busi_name_path";; localObject2 = "hb_name_path")
        {
          localObject2 = PortalManager.a((String)localObject4, (String)localObject2);
          localObject4 = PortalManager.a(((PortalManager.LogoConfig)localObject3).greetImageMD5, null);
          localObject3 = PortalManager.a(((PortalManager.LogoConfig)localObject3).padantImageMD5, "hb_busi_logo_path");
          localBundle.putParcelable("logoBitmap", localBitmap);
          localBundle.putParcelable("nameBitmap", (Parcelable)localObject2);
          localBundle.putParcelable("greetBitmap", (Parcelable)localObject4);
          localBundle.putParcelable("pandantBitmap", (Parcelable)localObject3);
          i = paramInt + 1;
          paramInt = i;
          if (i >= ((List)localObject1).size()) {
            paramInt = 0;
          }
          this.jdField_a_of_type_AndroidOsHandler.removeMessages(1003);
          Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 1003, localBundle).sendToTarget();
          localObject1 = Message.obtain(this.jdField_b_of_type_AndroidOsHandler, 1004, paramInt, 0, null);
          this.jdField_b_of_type_AndroidOsHandler.sendMessageDelayed((Message)localObject1, l);
          return;
        }
      }
      i = -1;
      localObject1 = null;
      l = 3000L;
    }
  }
  
  private void a(Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3, Bitmap paramBitmap4)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("ConversationHongBao", 2, "updateIcon greetBitmap=" + paramBitmap3 + ", pandantBitmap=" + paramBitmap4 + ", mState=" + this.jdField_d_of_type_Int);
    }
    if (this.jdField_d_of_type_Int == 2) {
      this.jdField_a_of_type_ComTencentMobileqqPortalPrepareView.setLogo(paramBitmap1, paramBitmap2);
    }
    if ((this.jdField_d_of_type_Int == 4) || (this.jdField_d_of_type_Int == 5))
    {
      this.jdField_a_of_type_ComTencentMobileqqPortalFormalView.setProgressLogo(paramBitmap1, true);
      this.jdField_a_of_type_ComTencentMobileqqPortalFormalView.setProgressNameBitmap(paramBitmap2, null, true);
    }
    paramBitmap1 = this.jdField_a_of_type_ComTencentWidgetHongBaoListView;
    if (this.jdField_d_of_type_Int != 3) {}
    for (;;)
    {
      paramBitmap1.setLogo(paramBitmap4, bool);
      if (paramBitmap3 != null) {}
      return;
      bool = false;
    }
  }
  
  private void a(View paramView1, View paramView2)
  {
    this.jdField_f_of_type_Int = (((RelativeLayout.LayoutParams)paramView2.getLayoutParams()).topMargin + paramView2.getHeight());
    paramView2 = (RelativeLayout.LayoutParams)paramView1.getLayoutParams();
    paramView2.addRule(3, 0);
    paramView2.topMargin = this.jdField_f_of_type_Int;
    paramView1.setLayoutParams(paramView2);
    this.g = true;
  }
  
  @TargetApi(11)
  private void a(View paramView1, View paramView2, View paramView3)
  {
    if (!this.g) {
      a(paramView2, paramView1);
    }
    if (this.jdField_f_of_type_Int <= 0) {
      return;
    }
    paramView2 = (RelativeLayout.LayoutParams)paramView1.getLayoutParams();
    if (this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator == null)
    {
      this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator = ValueAnimator.ofInt(new int[] { 0, 1000 });
      this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.setDuration(300L);
      this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.setInterpolator(this.jdField_a_of_type_AndroidViewAnimationInterpolator);
      this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.addUpdateListener(new awmn(this, paramView2, paramView1, paramView3));
      this.jdField_a_of_type_ComNineoldandroidsAnimationAnimator$AnimatorListener = new awmo(this, paramView3);
    }
    this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.removeAllListeners();
    this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.cancel();
    this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.addListener(this.jdField_a_of_type_ComNineoldandroidsAnimationAnimator$AnimatorListener);
    this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.start();
  }
  
  private void a(boolean paramBoolean, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConversationHongBao", 2, "startLoopIcon, forceStart=" + paramBoolean);
    }
    if ((this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (!paramBoolean)) {
      return;
    }
    m();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    Message.obtain(this.jdField_b_of_type_AndroidOsHandler, 1004, 0, 0, null).sendToTarget();
  }
  
  @TargetApi(11)
  private void b(View paramView1, View paramView2, View paramView3)
  {
    if (!this.g) {
      a(paramView2, paramView1);
    }
    if (this.jdField_f_of_type_Int <= 0) {
      return;
    }
    paramView2 = (RelativeLayout.LayoutParams)paramView1.getLayoutParams();
    if (this.jdField_b_of_type_ComNineoldandroidsAnimationValueAnimator == null)
    {
      this.jdField_b_of_type_ComNineoldandroidsAnimationValueAnimator = ValueAnimator.ofInt(new int[] { 0, 1000 });
      this.jdField_b_of_type_ComNineoldandroidsAnimationValueAnimator.setDuration(300L);
      this.jdField_b_of_type_ComNineoldandroidsAnimationValueAnimator.setInterpolator(this.jdField_a_of_type_AndroidViewAnimationInterpolator);
      this.jdField_b_of_type_ComNineoldandroidsAnimationValueAnimator.addUpdateListener(new awmg(this, paramView2, paramView1, paramView3));
      this.jdField_b_of_type_ComNineoldandroidsAnimationAnimator$AnimatorListener = new awmh(this, paramView3, paramView1);
    }
    this.jdField_b_of_type_ComNineoldandroidsAnimationValueAnimator.removeAllListeners();
    this.jdField_b_of_type_ComNineoldandroidsAnimationValueAnimator.cancel();
    this.jdField_b_of_type_ComNineoldandroidsAnimationValueAnimator.addListener(this.jdField_b_of_type_ComNineoldandroidsAnimationAnimator$AnimatorListener);
    this.jdField_b_of_type_ComNineoldandroidsAnimationValueAnimator.start();
  }
  
  private void m()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    this.jdField_b_of_type_AndroidOsHandler.removeMessages(1004);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1003);
  }
  
  private void n()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqPortalPrepareView != null) && (this.jdField_d_of_type_Int == 2))
    {
      this.jdField_a_of_type_ComTencentMobileqqPortalPrepareView.b();
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1006);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1006, 500L);
    }
  }
  
  private void o()
  {
    if (this.jdField_a_of_type_ComTencentWidgetHongBaoListView == null) {}
    int i;
    do
    {
      return;
      i = this.jdField_a_of_type_ComTencentWidgetHongBaoListView.jdField_d_of_type_Int;
      if (this.jdField_d_of_type_Int == 3)
      {
        int j = aepi.a(100.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
        this.jdField_a_of_type_ComTencentWidgetHongBaoListView.a(i - j);
        return;
      }
    } while ((this.jdField_d_of_type_Int != 2) && (this.jdField_d_of_type_Int != 5) && (this.jdField_d_of_type_Int != 4));
    n();
    this.jdField_a_of_type_ComTencentWidgetHongBaoListView.a(i);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidOsCountDownTimer != null)
    {
      this.jdField_a_of_type_AndroidOsCountDownTimer.cancel();
      this.jdField_a_of_type_AndroidOsCountDownTimer = null;
    }
    FrameHelperActivity.b(true);
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
    ((PortalManager)this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a.getManager(79)).d();
    if (this.jdField_a_of_type_ComTencentWidgetHongBaoListView.jdField_c_of_type_Int == -this.jdField_b_of_type_Int)
    {
      this.jdField_a_of_type_ComTencentWidgetHongBaoListView.setSpringbackOffset(0);
      this.jdField_a_of_type_ComTencentWidgetHongBaoListView.springBackTo(0);
    }
  }
  
  void a(long paramLong)
  {
    if (this.jdField_e_of_type_Long == paramLong) {
      return;
    }
    this.jdField_e_of_type_Long = paramLong;
    int j = (int)(paramLong / 1000L);
    int i = j / 60;
    j %= 60;
    int k = (int)paramLong % 100;
    this.jdField_b_of_type_JavaLangStringBuilder.delete(0, this.jdField_b_of_type_JavaLangStringBuilder.length());
    if (i < 10) {
      this.jdField_b_of_type_JavaLangStringBuilder.append("0");
    }
    this.jdField_b_of_type_JavaLangStringBuilder.append(i).append(":");
    if (j < 10) {
      this.jdField_b_of_type_JavaLangStringBuilder.append("0");
    }
    this.jdField_b_of_type_JavaLangStringBuilder.append(j);
    this.jdField_b_of_type_JavaLangStringBuilder.append(".");
    if (k < 10) {
      this.jdField_b_of_type_JavaLangStringBuilder.append("0");
    }
    this.jdField_b_of_type_JavaLangStringBuilder.append(k);
    this.jdField_a_of_type_JavaLangStringBuilder.delete(0, this.jdField_a_of_type_JavaLangStringBuilder.length());
    this.jdField_a_of_type_JavaLangStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_JavaLangStringBuilder.append(this.jdField_b_of_type_JavaLangStringBuilder);
  }
  
  public void a(Constants.LogoutReason paramLogoutReason)
  {
    if (this.jdField_d_of_type_Int == -1) {
      return;
    }
    b();
  }
  
  @TargetApi(11)
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if ((this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator != null) && (this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.isRunning()))
      {
        this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.removeAllListeners();
        this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.cancel();
      }
      l();
      this.jdField_e_of_type_Boolean = true;
    }
    while (this.jdField_e_of_type_Boolean) {
      return;
    }
    this.jdField_e_of_type_Boolean = true;
    a(this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a(), this.jdField_a_of_type_ComTencentMobileqqActivityConversation.b(), this.jdField_a_of_type_ComTencentMobileqqActivityConversation.c());
  }
  
  public boolean a()
  {
    if ((this.jdField_d_of_type_Int == -1) || (this.jdField_a_of_type_ComTencentWidgetHongBaoListView == null)) {}
    while ((!this.jdField_a_of_type_ComTencentWidgetHongBaoListView.mForHongBao) || (!this.jdField_a_of_type_ComTencentWidgetHongBaoListView.h)) {
      return false;
    }
    return true;
  }
  
  public void b()
  {
    a(true);
    if (this.jdField_d_of_type_Int == -1) {}
    while (!a()) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager", 2, "normalMode");
    }
    this.jdField_a_of_type_ComTencentWidgetHongBaoListView.setSpringbackOffset(0);
    this.jdField_a_of_type_ComTencentWidgetHongBaoListView.springBackTo(0);
    FrameHelperActivity.b(true);
    this.jdField_a_of_type_ComTencentWidgetHongBaoListView.d();
    h();
    a();
    this.jdField_a_of_type_ComTencentMobileqqPortalBreathEffectView.g();
    this.jdField_a_of_type_ComTencentMobileqqPortalPrepareView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqPortalFormalView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqPortalProgressViewRed.setVisibility(8);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    m();
    this.jdField_c_of_type_Long = -1L;
    this.jdField_d_of_type_Int = 1;
  }
  
  public void b(long paramLong)
  {
    PortalManager localPortalManager = (PortalManager)this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a.getManager(79);
    long[] arrayOfLong = localPortalManager.a();
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("startCountDown");
      if (arrayOfLong == null) {
        break label78;
      }
    }
    label78:
    for (String str = Arrays.toString(arrayOfLong);; str = "null")
    {
      QLog.d("PortalManager", 2, str);
      if (arrayOfLong != null) {
        break;
      }
      return;
    }
    if (this.jdField_d_of_type_Int != 4)
    {
      this.jdField_d_of_type_Int = 4;
      this.jdField_a_of_type_ComTencentMobileqqPortalProgressViewRed.setAlpha(0);
      this.jdField_a_of_type_ComTencentMobileqqPortalProgressViewRed.setVisibility(0);
      FrameHelperActivity.b(false);
      this.jdField_a_of_type_ComTencentWidgetHongBaoListView.i();
      if ((paramLong != -1L) && (this.jdField_a_of_type_ComTencentWidgetHongBaoListView.jdField_c_of_type_Int == 0))
      {
        this.jdField_a_of_type_ComTencentWidgetHongBaoListView.setSelection(0);
        this.jdField_a_of_type_ComTencentWidgetHongBaoListView.setSpringbackOffset(-this.jdField_b_of_type_Int);
        this.jdField_a_of_type_ComTencentWidgetHongBaoListView.springBackTo(-this.jdField_b_of_type_Int);
      }
      h();
      this.jdField_a_of_type_ComTencentMobileqqPortalBreathEffectView.g();
      m();
    }
    if (paramLong == -1L)
    {
      this.jdField_a_of_type_ComTencentMobileqqPortalFormalView.b(true);
      a(true, this.jdField_a_of_type_ComTencentMobileqqPortalFormalView.jdField_a_of_type_Long);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidOsCountDownTimer != null) {
        this.jdField_a_of_type_AndroidOsCountDownTimer.cancel();
      }
      if ((this.jdField_c_of_type_Boolean) && (this.jdField_d_of_type_Boolean)) {
        localPortalManager.b(2);
      }
      this.jdField_a_of_type_AndroidOsCountDownTimer = new awmj(this, arrayOfLong[1], 40L, arrayOfLong);
      this.jdField_a_of_type_AndroidOsCountDownTimer.start();
      return;
      if (!this.jdField_a_of_type_ComTencentMobileqqPortalFormalView.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentMobileqqPortalFormalView.c();
      }
    }
  }
  
  @TargetApi(11)
  public void b(boolean paramBoolean)
  {
    if ((!this.jdField_e_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqActivityConversation == null)) {
      return;
    }
    this.jdField_e_of_type_Boolean = false;
    if (!paramBoolean)
    {
      b(this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a(), this.jdField_a_of_type_ComTencentMobileqqActivityConversation.b(), this.jdField_a_of_type_ComTencentMobileqqActivityConversation.c());
      return;
    }
    View localView = this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a();
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localView.getLayoutParams();
    localLayoutParams.topMargin = (-this.jdField_f_of_type_Int);
    localView.setLayoutParams(localLayoutParams);
    localView = this.jdField_a_of_type_ComTencentMobileqqActivityConversation.c();
    localView.setVisibility(8);
    if (this.jdField_f_of_type_Boolean) {
      localView.setAlpha(0.0F);
    }
    this.jdField_e_of_type_Boolean = false;
  }
  
  public boolean b()
  {
    if (FrameHelperActivity.b()) {
      if (QLog.isColorLevel()) {
        QLog.d("PortalManager", 2, "showPreGuide" + this.jdField_d_of_type_Int);
      }
    }
    while (this.jdField_a_of_type_ComTencentWidgetHongBaoListView == null) {
      return false;
    }
    o();
    return true;
  }
  
  public void c()
  {
    if (this.jdField_d_of_type_Int == -1) {
      return;
    }
    b();
  }
  
  public boolean c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager", 2, "startGestureGuide, " + this.jdField_d_of_type_Int);
    }
    switch (this.jdField_d_of_type_Int)
    {
    default: 
      return false;
    }
    AnimationSet localAnimationSet = new AnimationSet(false);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation.setStartOffset(1L);
    localAlphaAnimation.setDuration(200L);
    localAlphaAnimation.setInterpolator(new AccelerateInterpolator());
    localAlphaAnimation.setAnimationListener(new awmk(this));
    int i = (int)this.jdField_a_of_type_AndroidViewViewGroup.getResources().getDimension(2131298052);
    int j = -this.jdField_a_of_type_ComTencentWidgetHongBaoListView.a();
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager", 2, "startGestureGuide, " + j + "," + i);
    }
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0, 0.0F, 0, 0.0F, 0, j, 0, i + j);
    localTranslateAnimation.setDuration(1500L);
    localTranslateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
    localTranslateAnimation.setAnimationListener(new awml(this));
    localAnimationSet.addAnimation(localTranslateAnimation);
    localAnimationSet.addAnimation(localAlphaAnimation);
    localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(500L);
    localAlphaAnimation.setStartOffset(1000L);
    localAlphaAnimation.setAnimationListener(new awmm(this));
    localAnimationSet.addAnimation(localAlphaAnimation);
    this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
    this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(localAnimationSet);
    return true;
  }
  
  public void d()
  {
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1002, 800L);
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConversationHongBao", 2, "onResume()");
    }
    if ((this.jdField_a_of_type_AndroidOsHandler == null) || (this.jdField_a_of_type_AndroidOsHandler.hasMessages(1002))) {}
    do
    {
      return;
      this.jdField_d_of_type_Boolean = true;
    } while (!a());
    if (this.jdField_a_of_type_ComTencentMobileqqPortalFormalView != null) {
      this.jdField_a_of_type_ComTencentMobileqqPortalFormalView.b();
    }
    if (this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_b_of_type_Boolean) {
        b();
      }
      this.jdField_a_of_type_Boolean = false;
    }
    switch (this.jdField_d_of_type_Int)
    {
    }
    for (;;)
    {
      f();
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 2000L);
      PortalManager localPortalManager = (PortalManager)this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a.getManager(79);
      if (localPortalManager == null) {
        break;
      }
      localPortalManager.b();
      localPortalManager.f();
      return;
      this.jdField_a_of_type_ComTencentMobileqqPortalBreathEffectView.a();
      if ((this.jdField_a_of_type_ComTencentMobileqqPortalPrepareView != null) && (this.jdField_a_of_type_ComTencentMobileqqPortalPrepareView.jdField_a_of_type_Int == 3))
      {
        a(true, this.jdField_a_of_type_ComTencentMobileqqPortalPrepareView.jdField_a_of_type_Long);
        continue;
        this.jdField_a_of_type_ComTencentMobileqqPortalBreathEffectView.b();
        this.jdField_a_of_type_ComTencentWidgetHongBaoListView.g();
        if ((this.jdField_a_of_type_ComTencentMobileqqPortalFormalView != null) && (this.jdField_a_of_type_ComTencentMobileqqPortalFormalView.jdField_a_of_type_Int == 3)) {
          a(true, this.jdField_a_of_type_ComTencentMobileqqPortalFormalView.jdField_a_of_type_Long);
        }
      }
    }
  }
  
  public void f()
  {
    if (!a()) {
      return;
    }
    switch (this.jdField_d_of_type_Int)
    {
    default: 
      return;
    }
    PortalManager localPortalManager = (PortalManager)this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a.getManager(79);
    if ((!this.jdField_d_of_type_Boolean) || (!this.jdField_c_of_type_Boolean) || (FrameHelperActivity.b()))
    {
      localPortalManager.d();
      FrameHelperActivity.b(true);
      return;
    }
    FrameHelperActivity.b(false);
    localPortalManager.b(2);
  }
  
  public void g()
  {
    this.jdField_d_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.d("ConversationHongBao", 2, "onPause()");
    }
    if (!a()) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqPortalFormalView != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqPortalFormalView.jdField_a_of_type_ComTencentMobileqqPortalHongbaoCaidanRainView != null) {
        this.jdField_a_of_type_ComTencentMobileqqPortalFormalView.jdField_a_of_type_ComTencentMobileqqPortalHongbaoCaidanRainView.setPause(true);
      }
      this.jdField_a_of_type_ComTencentMobileqqPortalFormalView.e();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqPortalPrepareView != null) {
      this.jdField_a_of_type_ComTencentMobileqqPortalPrepareView.c();
    }
    if (this.jdField_a_of_type_ComTencentWidgetHongBaoListView != null) {
      this.jdField_a_of_type_ComTencentWidgetHongBaoListView.h();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqPortalBreathEffectView != null) {
      this.jdField_a_of_type_ComTencentMobileqqPortalBreathEffectView.g();
    }
    if (this.jdField_a_of_type_AndroidOsCountDownTimer != null) {
      this.jdField_a_of_type_AndroidOsCountDownTimer.cancel();
    }
    m();
    f();
  }
  
  public void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager", 2, "stopGestureGuide, " + this.jdField_d_of_type_Int);
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1001);
    this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    Bitmap localBitmap1 = null;
    Bitmap localBitmap2;
    Bitmap localBitmap3;
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 1001: 
      h();
      c();
      return false;
    case 1002: 
      e();
      return false;
    case 1003: 
      paramMessage = (Bundle)paramMessage.obj;
      if (paramMessage != null)
      {
        localBitmap1 = (Bitmap)paramMessage.getParcelable("logoBitmap");
        localBitmap2 = (Bitmap)paramMessage.getParcelable("nameBitmap");
        localBitmap3 = (Bitmap)paramMessage.getParcelable("greetBitmap");
        paramMessage = (Bitmap)paramMessage.getParcelable("pandantBitmap");
      }
      break;
    }
    for (;;)
    {
      a(localBitmap1, localBitmap2, localBitmap3, paramMessage);
      return false;
      a(paramMessage.arg1);
      return false;
      if ((this.jdField_e_of_type_Int == 0) || (this.jdField_d_of_type_Int != 5)) {
        break;
      }
      this.jdField_e_of_type_Int = 0;
      ((PortalManager)this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a.getManager(79)).a(this.jdField_a_of_type_AndroidAppActivity);
      return false;
      if (!this.jdField_d_of_type_Boolean) {
        break;
      }
      paramMessage = (PortalManager)this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a().getAppInterface().getManager(79);
      if (paramMessage == null) {
        break;
      }
      paramMessage.b(4);
      return false;
      paramMessage = null;
      localBitmap3 = null;
      localBitmap2 = null;
    }
  }
  
  public void i()
  {
    if (!a()) {}
    do
    {
      return;
      f();
      this.jdField_a_of_type_ComTencentWidgetHongBaoListView.setSpringbackOffset(0);
      if (this.jdField_a_of_type_ComTencentWidgetHongBaoListView.getScrollY() != 0) {
        this.jdField_a_of_type_ComTencentWidgetHongBaoListView.springBackTo(0);
      }
      a(true);
    } while ((this.jdField_a_of_type_ComTencentMobileqqPortalFormalView == null) || (this.jdField_a_of_type_ComTencentMobileqqPortalFormalView.jdField_a_of_type_ComTencentMobileqqPortalHongbaoCaidanRainView == null));
    this.jdField_a_of_type_ComTencentMobileqqPortalFormalView.jdField_a_of_type_ComTencentMobileqqPortalHongbaoCaidanRainView.setPause(true);
  }
  
  public void j()
  {
    if (!a()) {
      return;
    }
    f();
  }
  
  public void k()
  {
    if (!a()) {
      return;
    }
    switch (this.jdField_d_of_type_Int)
    {
    default: 
      return;
    }
    c();
  }
  
  @TargetApi(11)
  public void l()
  {
    View localView1 = this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a();
    View localView2 = this.jdField_a_of_type_ComTencentMobileqqActivityConversation.c();
    if (localView1 != null)
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localView1.getLayoutParams();
      localLayoutParams.topMargin = 0;
      localView1.setLayoutParams(localLayoutParams);
    }
    if (localView2 != null)
    {
      if (this.jdField_f_of_type_Boolean) {
        localView2.setAlpha(1.0F);
      }
      localView2.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awmf
 * JD-Core Version:    0.7.0.1
 */