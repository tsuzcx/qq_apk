package com.tencent.mobileqq.activity.aio;

import aekt;
import aeoj;
import aeok;
import aeom;
import aeon;
import aeoo;
import aeop;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import aojg;
import aojh;
import asdz;
import com.tencent.TMG.utils.QLog;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ticker.TickerView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.IntimateInfo;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.dinifly.LottieComposition.Factory;
import com.tencent.mobileqq.dinifly.OnCompositionLoadedListener;
import java.io.File;
import java.io.FileInputStream;

public class IntimateTitleSwitchView
  extends FrameLayout
  implements View.OnClickListener
{
  float jdField_a_of_type_Float;
  int jdField_a_of_type_Int;
  aeop jdField_a_of_type_Aeop;
  ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  Context jdField_a_of_type_AndroidContentContext;
  public ViewGroup a;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  TickerView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTickerTickerView;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  IntimateInfo jdField_a_of_type_ComTencentMobileqqDataIntimateInfo;
  public DiniFlyAnimationView a;
  Runnable jdField_a_of_type_JavaLangRunnable = new IntimateTitleSwitchView.1(this);
  public boolean a;
  float jdField_b_of_type_Float;
  int jdField_b_of_type_Int;
  ValueAnimator jdField_b_of_type_AndroidAnimationValueAnimator;
  public ViewGroup b;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  TickerView jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTickerTickerView;
  Runnable jdField_b_of_type_JavaLangRunnable = new IntimateTitleSwitchView.2(this);
  boolean jdField_b_of_type_Boolean = false;
  float jdField_c_of_type_Float;
  int jdField_c_of_type_Int = 80;
  public ViewGroup c;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  Runnable jdField_c_of_type_JavaLangRunnable = new IntimateTitleSwitchView.3(this);
  public boolean c;
  float jdField_d_of_type_Float;
  int jdField_d_of_type_Int = 100;
  ViewGroup jdField_d_of_type_AndroidViewViewGroup;
  TextView jdField_d_of_type_AndroidWidgetTextView;
  Runnable jdField_d_of_type_JavaLangRunnable = new IntimateTitleSwitchView.4(this);
  boolean jdField_d_of_type_Boolean = false;
  int jdField_e_of_type_Int = 80;
  TextView jdField_e_of_type_AndroidWidgetTextView;
  private Runnable jdField_e_of_type_JavaLangRunnable = new IntimateTitleSwitchView.6(this);
  boolean jdField_e_of_type_Boolean = false;
  public int f;
  TextView jdField_f_of_type_AndroidWidgetTextView;
  boolean jdField_f_of_type_Boolean = false;
  boolean g = false;
  
  public IntimateTitleSwitchView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public IntimateTitleSwitchView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public IntimateTitleSwitchView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    paramContext = LayoutInflater.from(paramContext).inflate(2131559201, this, true);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramContext.findViewById(2131368407));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTickerTickerView = ((TickerView)paramContext.findViewById(2131368391));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2131368390));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2131368388));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2131362107));
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)paramContext.findViewById(2131368408));
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTickerTickerView = ((TickerView)paramContext.findViewById(2131368405));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2131368404));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2131368403));
    this.jdField_d_of_type_AndroidViewViewGroup = ((ViewGroup)paramContext.findViewById(2131368401));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2131376120));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramContext.findViewById(2131376119));
    this.jdField_c_of_type_AndroidViewViewGroup = ((ViewGroup)paramContext.findViewById(2131368406));
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView = ((DiniFlyAnimationView)paramContext.findViewById(2131368402));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTickerTickerView.setCharacterLists(new String[] { "9876543210" });
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTickerTickerView.setAnimationDuration(2000L);
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTickerTickerView.setCharacterLists(new String[] { "9876543210" });
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTickerTickerView.setAnimationDuration(2000L);
    this.jdField_d_of_type_AndroidViewViewGroup.setOnClickListener(this);
    this.jdField_c_of_type_AndroidViewViewGroup.setOnClickListener(this);
    this.jdField_c_of_type_Int = aojh.a().jdField_a_of_type_Int;
    this.jdField_d_of_type_Int = aojh.a().jdField_b_of_type_Int;
    this.jdField_e_of_type_Int = aojh.a().jdField_c_of_type_Int;
    this.jdField_f_of_type_Int = aekt.a(180.0F, getResources());
    this.jdField_a_of_type_AndroidViewViewGroup.setTranslationX(0.0F);
    this.jdField_b_of_type_AndroidViewViewGroup.setTranslationX(this.jdField_f_of_type_Int);
  }
  
  private void a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (!this.jdField_c_of_type_Boolean)) {}
    String str2;
    do
    {
      do
      {
        return;
        localObject = (asdz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(323);
      } while (localObject == null);
      str2 = ((asdz)localObject).a(this.jdField_a_of_type_Int, paramBoolean);
    } while (TextUtils.isEmpty(str2));
    Object localObject = new File(str2).getParent();
    if (((String)localObject).endsWith("/")) {}
    String str1;
    for (localObject = (String)localObject + "images";; str1 = localThrowable + "/images") {
      try
      {
        localObject = new aeok(this, (String)localObject);
        LottieComposition.Factory.fromInputStream(getContext(), new FileInputStream(str2), (OnCompositionLoadedListener)localObject);
        this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(0);
        return;
      }
      catch (Throwable localThrowable)
      {
        QLog.d("IntimateTitleSwitchView", 0, "startScoreLottieAnim error:" + localThrowable.getMessage());
        return;
      }
    }
  }
  
  private boolean a()
  {
    boolean bool = true;
    StringBuilder localStringBuilder;
    if (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo != null) {
      if ((this.jdField_a_of_type_Int == 3) || (this.jdField_a_of_type_Int == 2) || (this.jdField_a_of_type_Int == 1))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.currentScore < this.jdField_c_of_type_Int) {
          break label136;
        }
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder().append("canSwitch res: ").append(bool).append("  mCurrentShowType:").append(this.jdField_b_of_type_Int).append(" score:");
          if (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo == null) {
            break label141;
          }
        }
      }
    }
    label136:
    label141:
    for (int i = this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.currentScore;; i = 0)
    {
      QLog.d("IntimateTitleSwitchView", 0, i);
      return bool;
      if (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.currentScore >= this.jdField_e_of_type_Int) {
        break;
      }
      bool = false;
      break;
    }
  }
  
  private boolean b()
  {
    boolean bool = true;
    if (this.jdField_b_of_type_Int == 4) {
      bool = false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("IntimateTitleSwitchView", 0, "canUpdateAnim res: " + bool + "  mCurrentShowType:" + this.jdField_b_of_type_Int);
    }
    return bool;
  }
  
  private boolean c()
  {
    if ((this.jdField_a_of_type_AndroidAnimationValueAnimator != null) && (this.jdField_a_of_type_AndroidAnimationValueAnimator.isRunning())) {}
    for (int i = 1;; i = 0) {
      return (a()) && (this.jdField_b_of_type_Int != 4) && (i == 0);
    }
  }
  
  private void f()
  {
    if (QLog.isColorLevel()) {
      QLog.i("IntimateTitleSwitchView", 0, "checkAndStartSwitchAnim mIsResumed:" + this.jdField_c_of_type_Boolean + " mCurrentShowType:" + this.jdField_b_of_type_Int + " mIntimateInfo:" + this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo);
    }
    if ((!this.jdField_c_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo == null) || ((this.jdField_a_of_type_AndroidAnimationValueAnimator != null) && (this.jdField_a_of_type_AndroidAnimationValueAnimator.isRunning()))) {}
    do
    {
      return;
      removeCallbacks(this.jdField_e_of_type_JavaLangRunnable);
      removeCallbacks(this.jdField_d_of_type_JavaLangRunnable);
      removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
      removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
      removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      if ((b()) && (this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.lastAnimAfterFriendDays != this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.beFriendDays) && (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.beFriendDays > 0))
      {
        postDelayed(this.jdField_a_of_type_JavaLangRunnable, 300L);
        return;
      }
      if ((b()) && (!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.lastAnimAfterScore != this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.currentScore))
      {
        postDelayed(this.jdField_c_of_type_JavaLangRunnable, 300L);
        return;
      }
      postDelayed(this.jdField_e_of_type_JavaLangRunnable, 2000L);
    } while (this.jdField_a_of_type_Boolean);
    m();
  }
  
  private void g()
  {
    if (QLog.isColorLevel()) {
      QLog.i("IntimateTitleSwitchView", 0, "onSwitchAnimEnd");
    }
    if ((!this.jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_Boolean))
    {
      this.jdField_b_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        QLog.i("IntimateTitleSwitchView", 0, "onFirstShowScorePage");
      }
      if (this.jdField_a_of_type_Aeop != null) {
        this.jdField_a_of_type_Aeop.m();
      }
    }
    if (this.jdField_c_of_type_Boolean)
    {
      removeCallbacks(this.jdField_e_of_type_JavaLangRunnable);
      removeCallbacks(this.jdField_d_of_type_JavaLangRunnable);
      removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
      removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
      removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.lastAnimAfterFriendDays != this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.beFriendDays) && (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.beFriendDays > 0)) {
        postDelayed(this.jdField_a_of_type_JavaLangRunnable, 300L);
      }
    }
    else
    {
      return;
    }
    if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.lastAnimAfterScore != this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.currentScore))
    {
      postDelayed(this.jdField_c_of_type_JavaLangRunnable, 300L);
      return;
    }
    postDelayed(this.jdField_e_of_type_JavaLangRunnable, 2000L);
    if (!this.jdField_a_of_type_Boolean)
    {
      m();
      return;
    }
    n();
  }
  
  private void h()
  {
    if (QLog.isColorLevel()) {
      QLog.i("IntimateTitleSwitchView", 0, "clearSwitchAnim mIsResumed:" + this.jdField_c_of_type_Boolean);
    }
    if ((this.jdField_a_of_type_AndroidAnimationValueAnimator != null) && (this.jdField_a_of_type_AndroidAnimationValueAnimator.isRunning())) {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
    }
    removeCallbacks(this.jdField_e_of_type_JavaLangRunnable);
  }
  
  private void i()
  {
    int k = Math.max(0, this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.lastAnimAfterFriendDays);
    int j = Math.max(0, this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.beFriendDays);
    if (QLog.isColorLevel()) {
      QLog.i("IntimateTitleSwitchView", 0, "smoothUpdateDays fromDays:" + k + " toDays:" + j);
    }
    if (k <= 0)
    {
      int m = String.valueOf(j).length();
      localObject = "";
      i = 0;
      while ((i < m) && (i < 5))
      {
        localObject = (String)localObject + "0";
        i += 1;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTickerTickerView.setText((String)localObject, false);
    }
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTickerTickerView;
    if (j > k) {}
    for (int i = 1;; i = 2)
    {
      ((TickerView)localObject).setPreferredScrollingDirection(i);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTickerTickerView.setDigitalAnimWidthSpeedIncrement(true);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTickerTickerView.setIgnoreWidthAnim(true);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTickerTickerView.setText(String.valueOf(j));
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
      removeCallbacks(this.jdField_e_of_type_JavaLangRunnable);
      postDelayed(this.jdField_b_of_type_JavaLangRunnable, 2500L);
      if (this.jdField_a_of_type_Aeop != null) {
        this.jdField_a_of_type_Aeop.o();
      }
      return;
    }
  }
  
  private void j()
  {
    boolean bool = false;
    int i = Math.max(0, this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.lastAnimAfterScore);
    int j = Math.max(0, this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.currentScore);
    if (QLog.isColorLevel()) {
      QLog.i("IntimateTitleSwitchView", 0, "smoothUpdateScores fromScore:" + i + " toScore:" + j);
    }
    if ((this.jdField_a_of_type_Int == 3) || (this.jdField_a_of_type_Int == 2) || (this.jdField_a_of_type_Int == 1))
    {
      if (j > i) {
        bool = true;
      }
      a(bool);
    }
    TickerView localTickerView = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTickerTickerView;
    if (j > i) {}
    for (i = 1;; i = 2)
    {
      localTickerView.setPreferredScrollingDirection(i);
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTickerTickerView.setDigitalAnimWidthSpeedIncrement(true);
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTickerTickerView.setIgnoreWidthAnim(true);
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTickerTickerView.setText(String.valueOf(j));
      removeCallbacks(this.jdField_d_of_type_JavaLangRunnable);
      removeCallbacks(this.jdField_e_of_type_JavaLangRunnable);
      postDelayed(this.jdField_d_of_type_JavaLangRunnable, 2500L);
      if (this.jdField_a_of_type_Aeop != null) {
        this.jdField_a_of_type_Aeop.n();
      }
      return;
    }
  }
  
  private void k()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.getVisibility() == 0) || (this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.isAnimating()))
    {
      this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.cancelAnimation();
      this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.removeAllLottieOnCompositionLoadedListener();
    }
  }
  
  private void l()
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.i("IntimateTitleSwitchView", 0, "switchTitleView mShowingDaysPage:" + this.jdField_a_of_type_Boolean);
    }
    if ((!a()) && (this.jdField_a_of_type_Boolean)) {
      return;
    }
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator == null)
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofInt(new int[] { 0, this.jdField_f_of_type_Int });
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(300L);
      this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new aeom(this));
      this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(new aeon(this));
    }
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator.isRunning()) {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
    }
    removeCallbacks(this.jdField_e_of_type_JavaLangRunnable);
    if (!this.jdField_a_of_type_Boolean) {}
    for (;;)
    {
      this.jdField_a_of_type_Boolean = bool;
      this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
      return;
      bool = false;
    }
  }
  
  private void m()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo == null) {
      n();
    }
    do
    {
      return;
      if ((this.jdField_a_of_type_Int != 3) && (this.jdField_a_of_type_Int != 2) && (this.jdField_a_of_type_Int != 1))
      {
        n();
        return;
      }
      aojg localaojg = aojh.a();
      if ((this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.currentScore >= localaojg.jdField_b_of_type_Int) || (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.currentScore < localaojg.jdField_a_of_type_Int))
      {
        n();
        return;
      }
    } while ((this.jdField_b_of_type_AndroidAnimationValueAnimator != null) && (this.jdField_b_of_type_AndroidAnimationValueAnimator.isRunning()));
    if (this.jdField_b_of_type_AndroidAnimationValueAnimator == null)
    {
      this.jdField_b_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.jdField_b_of_type_AndroidAnimationValueAnimator.setInterpolator(new LinearInterpolator());
      this.jdField_b_of_type_AndroidAnimationValueAnimator.setDuration(1500L);
      this.jdField_b_of_type_AndroidAnimationValueAnimator.setRepeatCount(-1);
      this.jdField_b_of_type_AndroidAnimationValueAnimator.addUpdateListener(new aeoo(this));
      this.jdField_b_of_type_AndroidAnimationValueAnimator.addListener(new aeoj(this));
    }
    this.jdField_b_of_type_AndroidAnimationValueAnimator.start();
  }
  
  private void n()
  {
    if ((this.jdField_b_of_type_AndroidAnimationValueAnimator != null) && (this.jdField_b_of_type_AndroidAnimationValueAnimator.isRunning())) {
      this.jdField_b_of_type_AndroidAnimationValueAnimator.cancel();
    }
  }
  
  public void a()
  {
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.i("IntimateTitleSwitchView", 0, "onDrawerClosed mIsResumed:" + this.jdField_c_of_type_Boolean);
    }
    h();
    k();
    n();
  }
  
  public void a(IntimateInfo paramIntimateInfo, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo = paramIntimateInfo;
    this.jdField_a_of_type_Int = paramInt;
    int m = this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.beFriendDays;
    int i = this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.currentScore;
    int j = i;
    int k = m;
    if (b())
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.currentScore >= 0) {
        i = Math.max(0, this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.lastAnimAfterScore);
      }
      j = i;
      k = m;
      if (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.beFriendDays > 0)
      {
        k = Math.max(0, this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.lastAnimAfterFriendDays);
        j = i;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("IntimateTitleSwitchView", 0, "updateIntimateInfo beFriendDays: " + k + "  score:" + j);
    }
    if (k >= -1) {
      if (k == 0)
      {
        str = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131693704);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTickerTickerView.setText(str, false);
        this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTickerTickerView.setText(String.valueOf(j), false);
        if (paramInt != 3) {
          break label554;
        }
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131693706);
        if (j < this.jdField_d_of_type_Int)
        {
          this.jdField_e_of_type_AndroidWidgetTextView.setText(2131693746);
          label233:
          this.jdField_f_of_type_AndroidWidgetTextView.setText(2131693740);
          this.jdField_c_of_type_AndroidWidgetTextView.setBackgroundResource(2130840245);
          j = 2131165681;
          i = 2131165680;
          paramInt = 2130840245;
          this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840230);
          label276:
          this.jdField_c_of_type_AndroidViewViewGroup.setContentDescription(this.jdField_e_of_type_AndroidWidgetTextView.getText() + " " + this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.currentScore);
          if (TextUtils.isEmpty(paramIntimateInfo.addFriendWording)) {
            break label806;
          }
          this.jdField_c_of_type_AndroidWidgetTextView.setText(paramIntimateInfo.addFriendWording);
          this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
          label348:
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTickerTickerView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(j));
          this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(j));
          this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(j));
          this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(i));
          this.jdField_c_of_type_AndroidWidgetTextView.setBackgroundResource(paramInt);
          this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTickerTickerView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(j));
          this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(j));
          this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(j));
          this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(i));
          this.jdField_d_of_type_AndroidViewViewGroup.setBackgroundResource(paramInt);
          label514:
          f();
        }
      }
      else
      {
        if (k != -1) {
          break label858;
        }
      }
    }
    label554:
    label858:
    for (String str = "999+";; str = String.valueOf(k))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      break;
      this.jdField_e_of_type_AndroidWidgetTextView.setText(2131693745);
      break label233;
      if (paramInt == 2)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131693705);
        if (j < this.jdField_d_of_type_Int) {
          this.jdField_e_of_type_AndroidWidgetTextView.setText(2131693744);
        }
        for (;;)
        {
          this.jdField_f_of_type_AndroidWidgetTextView.setText(2131693739);
          this.jdField_c_of_type_AndroidWidgetTextView.setBackgroundResource(2130840243);
          this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840229);
          j = 2131165679;
          i = 2131165678;
          paramInt = 2130840243;
          break;
          this.jdField_e_of_type_AndroidWidgetTextView.setText(2131693743);
        }
      }
      if (paramInt == 1)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131693707);
        if (j < this.jdField_d_of_type_Int) {
          this.jdField_e_of_type_AndroidWidgetTextView.setText(2131693748);
        }
        for (;;)
        {
          this.jdField_f_of_type_AndroidWidgetTextView.setText(2131693741);
          this.jdField_c_of_type_AndroidWidgetTextView.setBackgroundResource(2130840247);
          j = 2131165683;
          i = 2131165682;
          paramInt = 2130840247;
          this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840231);
          break;
          this.jdField_e_of_type_AndroidWidgetTextView.setText(2131693747);
        }
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131693702);
      this.jdField_e_of_type_AndroidWidgetTextView.setText(2131693742);
      this.jdField_f_of_type_AndroidWidgetTextView.setText(2131693738);
      this.jdField_c_of_type_AndroidWidgetTextView.setBackgroundResource(2130840241);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840232);
      j = 2131165684;
      i = 2131165685;
      paramInt = 2130840241;
      break label276;
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      break label348;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTickerTickerView.setText("");
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetTextView.setText("");
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(4);
      break label514;
    }
  }
  
  public void b()
  {
    this.jdField_c_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.i("IntimateTitleSwitchView", 0, "onDrawerOpened mIsResumed:" + this.jdField_c_of_type_Boolean);
    }
    f();
  }
  
  public void c()
  {
    this.jdField_c_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.i("IntimateTitleSwitchView", 0, "onPaused mIsResumed:" + this.jdField_c_of_type_Boolean);
    }
    h();
    k();
    n();
    removeCallbacks(this.jdField_d_of_type_JavaLangRunnable);
    removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
    removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public void d()
  {
    if (this.jdField_b_of_type_Int == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.i("IntimateTitleSwitchView", 0, "onResumed mIsOpened:" + this.jdField_d_of_type_Boolean);
      }
      if (!this.jdField_d_of_type_Boolean) {
        return;
      }
    }
    this.jdField_c_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.i("IntimateTitleSwitchView", 0, "onResumed mIsResumed:" + this.jdField_c_of_type_Boolean);
    }
    f();
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if ((!this.jdField_f_of_type_Boolean) && (!c()))
    {
      bool2 = super.dispatchTouchEvent(paramMotionEvent);
      return bool2;
    }
    float f1 = paramMotionEvent.getRawX();
    float f2 = paramMotionEvent.getRawY();
    switch (paramMotionEvent.getAction())
    {
    default: 
      return false;
    case 0: 
      this.jdField_a_of_type_Float = f1;
      this.jdField_b_of_type_Float = f2;
      this.jdField_e_of_type_Boolean = false;
      this.jdField_f_of_type_Boolean = true;
      this.jdField_c_of_type_Float = f1;
      this.jdField_d_of_type_Float = f2;
      this.g = false;
      return super.dispatchTouchEvent(paramMotionEvent);
    case 2: 
      if ((this.jdField_a_of_type_Float - f1 > 8.0F) && (Math.abs(f2 - this.jdField_b_of_type_Float) < Math.abs(f1 - this.jdField_a_of_type_Float)) && (this.jdField_f_of_type_Boolean) && (!this.jdField_e_of_type_Boolean)) {
        this.jdField_e_of_type_Boolean = true;
      }
      if (f1 - this.jdField_a_of_type_Float > 50.0F) {
        this.g = true;
      }
      if ((this.jdField_e_of_type_Boolean) && (!this.g)) {}
      for (;;)
      {
        this.jdField_c_of_type_Float = f1;
        this.jdField_d_of_type_Float = f2;
        bool2 = bool1;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("IntimateTitleSwitchView", 0, "dispatchTouchEvent move mMoveLeft:" + this.jdField_e_of_type_Boolean + " mIgnoreMove:" + this.g);
        return bool1;
        bool1 = super.dispatchTouchEvent(paramMotionEvent);
      }
    }
    if ((this.jdField_a_of_type_Float - f1 > 16.0F) && (Math.abs(f2 - this.jdField_b_of_type_Float) < Math.abs(f1 - this.jdField_a_of_type_Float)) && (this.jdField_f_of_type_Boolean) && (this.jdField_e_of_type_Boolean) && (!this.g)) {
      l();
    }
    for (bool1 = bool2;; bool1 = super.dispatchTouchEvent(paramMotionEvent))
    {
      if (QLog.isColorLevel()) {
        QLog.i("IntimateTitleSwitchView", 0, "dispatchTouchEvent up mMoveLeft:" + this.jdField_e_of_type_Boolean + " mIgnoreMove:" + this.g + " ret:" + bool1 + " dx " + (this.jdField_a_of_type_Float - f1) + "  dy" + (f2 - this.jdField_b_of_type_Float));
      }
      this.jdField_e_of_type_Boolean = false;
      this.jdField_f_of_type_Boolean = false;
      this.g = false;
      return bool1;
    }
  }
  
  public void e()
  {
    h();
    k();
    n();
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator != null)
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.removeAllUpdateListeners();
      this.jdField_a_of_type_AndroidAnimationValueAnimator.removeAllListeners();
      this.jdField_a_of_type_AndroidAnimationValueAnimator = null;
    }
    if (this.jdField_b_of_type_AndroidAnimationValueAnimator != null)
    {
      this.jdField_b_of_type_AndroidAnimationValueAnimator.removeAllListeners();
      this.jdField_b_of_type_AndroidAnimationValueAnimator.removeAllUpdateListeners();
      this.jdField_b_of_type_AndroidAnimationValueAnimator = null;
    }
    this.jdField_c_of_type_Boolean = false;
    removeCallbacks(this.jdField_d_of_type_JavaLangRunnable);
    removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
    removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    removeCallbacks(this.jdField_e_of_type_JavaLangRunnable);
    this.jdField_a_of_type_Aeop = null;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return;
    } while (this.jdField_a_of_type_Aeop == null);
    this.jdField_a_of_type_Aeop.l();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    super.onTouchEvent(paramMotionEvent);
    if (paramMotionEvent.getAction() == 0) {
      return true;
    }
    return this.jdField_e_of_type_Boolean;
  }
  
  public void setApp(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public void setCallBack(aeop paramaeop)
  {
    this.jdField_a_of_type_Aeop = paramaeop;
  }
  
  public void setCurrentShowType(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IntimateTitleSwitchView", 0, "setCurrentShowType showType: " + paramInt + "  old:" + this.jdField_b_of_type_Int + "  this:" + this);
    }
    this.jdField_b_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.IntimateTitleSwitchView
 * JD-Core Version:    0.7.0.1
 */