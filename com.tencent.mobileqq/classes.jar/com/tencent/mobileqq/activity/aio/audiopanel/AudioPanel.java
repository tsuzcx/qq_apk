package com.tencent.mobileqq.activity.aio.audiopanel;

import android.animation.Animator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build.VERSION;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.Editable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.AIOInputTypeHelper;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.app.BabyQHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.util.AccessibilityUtils;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.XEditTextEx;
import mqq.os.MqqHandler;

public class AudioPanel
  extends LinearLayout
  implements Handler.Callback, ViewPager.OnPageChangeListener, View.OnClickListener, AudioTransitionAnimManager.TransitionAnimListener
{
  private static final int jdField_a_of_type_Int;
  private static PopupWindow jdField_a_of_type_AndroidWidgetPopupWindow;
  private static final int[] jdField_a_of_type_ArrayOfInt = { 1038, 1948, 2857, 3766, 4675, 5584, 6493, 7402, 8311, 10000 };
  private static final float jdField_b_of_type_Float;
  private static final int jdField_j_of_type_Int;
  private static final int jdField_k_of_type_Int;
  private static final int l;
  private float jdField_a_of_type_Float;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private InputLinearLayout jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private AudioPanelAdapter jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelAdapter;
  private AudioPanelViewPager jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager;
  private PressToSpeakPanel jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToSpeakPanel;
  private PttTextTransitionAnim jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPttTextTransitionAnim;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private PanelIconLinearLayout jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private LottieDrawable jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable;
  private WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
  private Runnable jdField_a_of_type_JavaLangRunnable = new AudioPanel.2(this);
  private boolean jdField_a_of_type_Boolean;
  private String[] jdField_a_of_type_ArrayOfJavaLangString = new String[3];
  private int jdField_b_of_type_Int = 1;
  private Rect jdField_b_of_type_AndroidGraphicsRect;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean = false;
  private float jdField_c_of_type_Float;
  private int jdField_c_of_type_Int;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private boolean jdField_c_of_type_Boolean = false;
  private float jdField_d_of_type_Float;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean = false;
  private int jdField_e_of_type_Int;
  private boolean jdField_e_of_type_Boolean = false;
  private int jdField_f_of_type_Int = -1;
  private boolean jdField_f_of_type_Boolean = false;
  private int jdField_g_of_type_Int = -1;
  private boolean jdField_g_of_type_Boolean = false;
  private int jdField_h_of_type_Int;
  private boolean jdField_h_of_type_Boolean = false;
  private int jdField_i_of_type_Int = 0;
  private boolean jdField_i_of_type_Boolean = false;
  private boolean jdField_j_of_type_Boolean = false;
  private boolean jdField_k_of_type_Boolean;
  private int m;
  
  static
  {
    jdField_a_of_type_Int = jdField_a_of_type_ArrayOfInt[1] - jdField_a_of_type_ArrayOfInt[0];
    jdField_a_of_type_AndroidWidgetPopupWindow = null;
    int n;
    int i1;
    if (Build.VERSION.SDK_INT >= 16)
    {
      n = 55;
      jdField_j_of_type_Int = n;
      i1 = jdField_j_of_type_Int;
      if (Build.VERSION.SDK_INT < 16) {
        break label179;
      }
      n = 4;
    }
    for (;;)
    {
      jdField_k_of_type_Int = i1 - n;
      jdField_b_of_type_Float = (jdField_j_of_type_Int + jdField_k_of_type_Int) * 0.52F / 1200.0F;
      l = (jdField_j_of_type_Int + jdField_k_of_type_Int) * -40 / 1200;
      return;
      if (Build.VERSION.SDK_INT > 9)
      {
        n = 65;
        break;
      }
      n = 85;
      break;
      label179:
      if (Build.VERSION.SDK_INT > 9) {
        n = 6;
      } else {
        n = 8;
      }
    }
  }
  
  public AudioPanel(Context paramContext)
  {
    super(paramContext);
  }
  
  public AudioPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public static int a(int paramInt)
  {
    int n = 8000;
    if (paramInt < 5000) {
      n = 4000;
    }
    for (;;)
    {
      paramInt = Math.min((int)(n * 0.3F / jdField_a_of_type_Int), jdField_a_of_type_ArrayOfInt.length - 1);
      return jdField_a_of_type_ArrayOfInt[paramInt];
      if (paramInt >= 8000) {
        if (paramInt < 10000) {
          n = 10000;
        } else if (paramInt < 14000) {
          n = 13000;
        } else if (paramInt < 18000) {
          n = 16000;
        } else if (paramInt < 23000) {
          n = 19000;
        } else if (paramInt < 27000) {
          n = 22000;
        } else if (paramInt < 32000) {
          n = 25000;
        } else if (paramInt < 35000) {
          n = 28000;
        } else if (paramInt < 40000) {
          n = 32000;
        } else if (paramInt < 50000) {
          n = 40000;
        } else {
          n = 40000;
        }
      }
    }
  }
  
  public static View a(Context paramContext, ViewGroup paramViewGroup1, ViewGroup paramViewGroup2)
  {
    paramViewGroup2 = (ViewGroup)paramViewGroup1.getParent();
    int i1 = paramViewGroup2.getChildCount();
    int n = 0;
    if (n < i1) {
      if (paramViewGroup2.getChildAt(n) != paramViewGroup1) {}
    }
    for (;;)
    {
      if (n >= 0)
      {
        paramContext = new View(paramContext);
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, paramViewGroup1.getHeight());
        localLayoutParams.addRule(6, paramViewGroup1.getId());
        localLayoutParams.addRule(8, paramViewGroup1.getId());
        paramContext.setLayoutParams(localLayoutParams);
        paramViewGroup2.addView(paramContext, n);
        return paramContext;
        n += 1;
        break;
      }
      return null;
      n = -1;
    }
  }
  
  public static PopupWindow a()
  {
    return jdField_a_of_type_AndroidWidgetPopupWindow;
  }
  
  public static PopupWindow a(Context paramContext, int paramInt1, int paramInt2, View paramView, int paramInt3, int paramInt4, int paramInt5)
  {
    if ((jdField_a_of_type_AndroidWidgetPopupWindow != null) && (jdField_a_of_type_AndroidWidgetPopupWindow.isShowing())) {
      return jdField_a_of_type_AndroidWidgetPopupWindow;
    }
    paramContext = new View(paramContext);
    paramContext.setBackgroundColor(1275068416);
    jdField_a_of_type_AndroidWidgetPopupWindow = new PopupWindow(paramContext, paramInt1, paramInt2);
    try
    {
      if (Build.VERSION.SDK_INT >= 22) {
        jdField_a_of_type_AndroidWidgetPopupWindow.setAttachedInDecor(false);
      }
      jdField_a_of_type_AndroidWidgetPopupWindow.setClippingEnabled(false);
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("AudioPanel", 2, paramContext, new Object[0]);
        }
      }
    }
    if (paramView.getWindowToken() != null) {
      jdField_a_of_type_AndroidWidgetPopupWindow.showAtLocation(paramView, paramInt3, paramInt4, paramInt5);
    }
    return jdField_a_of_type_AndroidWidgetPopupWindow;
  }
  
  public static String a(double paramDouble)
  {
    if (paramDouble < 1000.0D) {}
    int i1;
    for (int n = 0;; n = (int)(paramDouble / 1000.0D + 0.5D))
    {
      i1 = n / 60;
      n %= 60;
      if (n >= 10) {
        break;
      }
      return i1 + ":0" + n;
    }
    return i1 + ":" + n;
  }
  
  private void a(float paramFloat)
  {
    if (this.jdField_a_of_type_Float == 0.0F) {
      this.jdField_a_of_type_Float = paramFloat;
    }
    for (;;)
    {
      return;
      paramFloat -= this.jdField_a_of_type_Float;
      int n = 0;
      if (paramFloat > 0.0F) {
        n = 1;
      }
      while (this.jdField_i_of_type_Int != n)
      {
        this.jdField_i_of_type_Boolean = true;
        this.jdField_i_of_type_Int = n;
        return;
        if (paramFloat < 0.0F) {
          n = -1;
        }
      }
    }
  }
  
  private void a(int paramInt1, int paramInt2, float paramFloat)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "doPageScrolledTransitionAnim() curItem is:" + paramInt1 + " nextItem=" + paramInt2 + " needDoPageScrolledTransitionAnim=" + this.jdField_i_of_type_Boolean + " nextdirect=" + this.jdField_i_of_type_Int);
    }
    paramInt2 = b(paramInt2);
    if ((this.jdField_i_of_type_Boolean) && (paramInt1 != paramInt2))
    {
      b(paramInt1, paramInt2);
      this.jdField_i_of_type_Boolean = false;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPttTextTransitionAnim.setScrollDis(paramFloat, this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.getWidth());
    if ((this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable != null) && (!this.jdField_i_of_type_Boolean))
    {
      float f1 = paramFloat;
      if (Math.abs(paramFloat) > this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.getWidth()) {
        f1 = Math.abs(paramFloat) - this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.getWidth();
      }
      paramFloat = AudioTransitionAnimUtils.a(f1, this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.getWidth());
      AudioTransitionAnimManager.a().a(this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable, paramFloat, this.jdField_g_of_type_Int, this.jdField_j_of_type_Boolean);
    }
  }
  
  private int b(int paramInt)
  {
    int n = 2;
    if (paramInt > 2) {
      paramInt = n;
    }
    for (;;)
    {
      n = paramInt;
      if (paramInt < 0) {
        n = 0;
      }
      return n;
    }
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "doTransitionAnimByNextItem lastSelectItem is:" + paramInt1 + " nextItem=" + paramInt2);
    }
    if (!AudioTransitionAnimManager.a().a()) {}
    int n;
    do
    {
      return;
      n = paramInt1;
      if (paramInt1 < 0) {
        n = a();
      }
    } while (n == paramInt2);
    this.jdField_g_of_type_Int = AudioTransitionAnimUtils.a(n, paramInt2);
    a(getContext(), this.jdField_j_of_type_Boolean);
  }
  
  private int c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager != null) {}
    switch (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.getCurrentItem())
    {
    default: 
      return -15158044;
    case 0: 
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.getContext().getResources().getColor(2131167022);
    case 1: 
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.getContext().getResources().getColor(2131167022);
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.getContext().getResources().getColor(2131167022);
  }
  
  private void c(int paramInt)
  {
    int n = -1;
    int i1 = a();
    if (paramInt == 2131378335) {
      n = 1;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOAudioPanel", 2, "doClickItemTransitionAnim() lastSelectItem is:" + i1 + " nextItem=" + n);
      }
      if ((n >= 0) && (n != i1))
      {
        c(true);
        this.jdField_j_of_type_Boolean = true;
        b(i1, n);
      }
      return;
      if (paramInt == 2131376784) {
        n = 2;
      } else if (paramInt == 2131381759) {
        n = 0;
      }
    }
  }
  
  private void g()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.getCurrentItem() == 1) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToSpeakPanel != null))
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToSpeakPanel.a();
      Rect localRect = new Rect();
      ((ImageView)localObject).getGlobalVisibleRect(localRect);
      localObject = new Rect();
      super.getGlobalVisibleRect((Rect)localObject);
      int n = localRect.left - ((Rect)localObject).left;
      int i1 = localRect.top - ((Rect)localObject).top;
      this.jdField_c_of_type_Float = TypedValue.applyDimension(1, 30.0F, getResources().getDisplayMetrics());
      this.jdField_a_of_type_AndroidGraphicsRect = new Rect(n, i1, localRect.width() + n, localRect.height() + i1);
      this.m = 40;
      this.jdField_d_of_type_Float = 0.98F;
      if (QLog.isColorLevel()) {
        QLog.d("HollowRound", 2, "initAndStartHollowRoundAnim:" + this.m + ", " + this.jdField_d_of_type_Float);
      }
      this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
      this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
      i();
    }
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_AndroidGraphicsRect != null)
    {
      this.m += l;
      this.jdField_d_of_type_Float += jdField_b_of_type_Float;
      if (QLog.isColorLevel()) {
        QLog.d("HollowRound", 2, "updateHollowRoundAnim:" + this.m + ", " + this.jdField_d_of_type_Float);
      }
    }
  }
  
  private void i()
  {
    if (this.jdField_b_of_type_AndroidGraphicsRect == null)
    {
      super.invalidate();
      return;
    }
    super.invalidate(this.jdField_b_of_type_AndroidGraphicsRect);
  }
  
  private void j()
  {
    c(true);
    this.jdField_h_of_type_Boolean = true;
    this.jdField_h_of_type_Int = a();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPttTextTransitionAnim.setCurrentItem(this.jdField_h_of_type_Int);
    this.jdField_a_of_type_Float = 0.0F;
    this.jdField_i_of_type_Int = 0;
    this.jdField_b_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "onPageScrollStateChanged()   SCROLL_STATE_DRAGGING curItemWhenPageStatusChangeToDrag=" + this.jdField_h_of_type_Int + " needDoPageScrolledTransitionAnim=" + this.jdField_i_of_type_Boolean);
    }
  }
  
  private void k()
  {
    this.jdField_h_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPttTextTransitionAnim.setCurrentItem(a());
    if ((!this.jdField_j_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.endAnimation();
      f();
    }
  }
  
  public int a()
  {
    int n = -1;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager != null) {
      n = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.getCurrentItem();
    }
    return n;
  }
  
  public void a()
  {
    BaseChatPie.z = false;
    e();
    int n;
    View localView;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelAdapter.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      ViewGroup localViewGroup = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelAdapter.jdField_a_of_type_AndroidViewViewGroup;
      int i1 = localViewGroup.getChildCount();
      n = 0;
      if (n >= i1) {
        break label87;
      }
      localView = localViewGroup.getChildAt(n);
      if (localView.getVisibility() != 0) {
        break label80;
      }
    }
    for (;;)
    {
      if ((localView != null) && ((localView instanceof AudioPanelCallback))) {
        ((AudioPanelCallback)localView).b();
      }
      b(true);
      return;
      label80:
      n += 1;
      break;
      label87:
      localView = null;
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.getCurrentItem() != paramInt)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.setCurrentItem(paramInt);
      requestLayout();
      a(this.jdField_b_of_type_AndroidViewViewGroup, this.jdField_b_of_type_AndroidViewViewGroup.getChildAt(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.getCurrentItem()), this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.getContext().getResources().getColor(2131167023), c());
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.C()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("doPanelChanged", 2, "oldPanel=" + paramInt1 + " newPanel=" + paramInt2 + " text.length " + this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a.getText().length());
      }
      if (paramInt2 != 2) {
        break label110;
      }
      if ((paramInt1 != 2) && (AIOInputTypeHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) {
        a(false);
      }
    }
    label110:
    while (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a.getText().length() != 0) {
      return;
    }
  }
  
  public void a(Animator paramAnimator, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AudioPanel", 2, "onAnimationEnd AudioPanel mCurAnimType:" + this.jdField_g_of_type_Int + ",type= " + paramInt + " isPageViewStartDragger=" + this.jdField_h_of_type_Boolean);
    }
    if (!AudioTransitionAnimUtils.b(paramInt)) {}
    do
    {
      return;
      this.jdField_j_of_type_Boolean = false;
    } while (this.jdField_h_of_type_Boolean);
    f();
  }
  
  public void a(Context paramContext, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "playTransitionAnimByType AudioTransitionAnimManager animType:" + this.jdField_g_of_type_Int + " mCurLottieDrawable=" + this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable);
    }
    AudioTransitionAnimManager localAudioTransitionAnimManager = AudioTransitionAnimManager.a();
    localAudioTransitionAnimManager.a(this);
    if (this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable != null) {
      localAudioTransitionAnimManager.a(this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable = localAudioTransitionAnimManager.a(paramContext, this.jdField_g_of_type_Int);
      if (this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable != null) {
        localAudioTransitionAnimManager.a(this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable, this.jdField_g_of_type_Int, this.jdField_a_of_type_AndroidWidgetImageView, paramBoolean);
      }
      return;
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    }
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    if (this.jdField_f_of_type_Boolean)
    {
      this.jdField_f_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(0, this.jdField_c_of_type_Boolean, false);
    }
  }
  
  void a(ViewGroup paramViewGroup, View paramView, int paramInt1, int paramInt2)
  {
    if (paramViewGroup != null)
    {
      int i1 = paramViewGroup.getChildCount();
      int i2 = a();
      int n = 0;
      if (n < i1)
      {
        Object localObject;
        if (n != i2)
        {
          localObject = paramViewGroup.getChildAt(n);
          if ((localObject instanceof TextView))
          {
            localObject = (TextView)localObject;
            ((TextView)localObject).setTextColor(paramInt1);
            ((TextView)localObject).setTextSize(2, 13.0F);
          }
        }
        for (;;)
        {
          n += 1;
          break;
          if ((n == 0) && (this.jdField_c_of_type_AndroidWidgetTextView != null))
          {
            this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(paramInt1);
            this.jdField_c_of_type_AndroidWidgetTextView.setTextSize(2, 13.0F);
            continue;
            if (paramView != null) {
              if ((paramView instanceof TextView))
              {
                localObject = (TextView)paramView;
                ((TextView)localObject).setTextColor(paramInt2);
                ((TextView)localObject).setTextSize(2, 15.0F);
              }
              else if (((paramView instanceof FrameLayout)) && (this.jdField_c_of_type_AndroidWidgetTextView != null))
              {
                this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(paramInt2);
                this.jdField_c_of_type_AndroidWidgetTextView.setTextSize(2, 15.0F);
                BabyQHandler.a(this.jdField_a_of_type_AndroidViewView);
              }
            }
          }
        }
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo, InputLinearLayout paramInputLinearLayout, PanelIconLinearLayout paramPanelIconLinearLayout)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout = paramInputLinearLayout;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout = paramPanelIconLinearLayout;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager = ((AudioPanelViewPager)findViewById(2131372706));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131363084));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131363085));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPttTextTransitionAnim = ((PttTextTransitionAnim)findViewById(2131373616));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131372699));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378335));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131376784));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131381759));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131381753);
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131372698));
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.F) {
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelAdapter = new AudioPanelAdapter(paramQQAppInterface, paramBaseChatPie, this, this.jdField_a_of_type_AndroidViewViewGroup, this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout, this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.a(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelAdapter);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.setOnPageChangeListener(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.setCurrentItem(Math.min(1, this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelAdapter.getCount() - 1));
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(c());
    this.jdField_c_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    paramBaseChatPie = getResources().getDrawable(2130850689);
    if ((paramBaseChatPie instanceof BitmapDrawable)) {
      paramBaseChatPie = ((BitmapDrawable)paramBaseChatPie).getBitmap();
    }
    for (;;)
    {
      paramBaseChatPie = new BitmapDrawable(paramBaseChatPie);
      if (paramBaseChatPie != null)
      {
        paramBaseChatPie.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        paramBaseChatPie.setDither(true);
        setBackgroundDrawable(paramBaseChatPie);
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(3);
        if (QLog.isColorLevel()) {
          QLog.d("AIOAudioPanel", 2, "AudioPanel.init() is called,time is:" + System.currentTimeMillis());
        }
        if (Utils.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a))
        {
          paramQQAppInterface = (BabyQHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.BABY_Q_HANDLER);
          if (paramQQAppInterface.a(2))
          {
            paramQQAppInterface.a();
            BabyQHandler.a(getContext(), this.jdField_a_of_type_AndroidViewView);
          }
        }
        AudioTransitionAnimManager.a().a(this);
        return;
        if (!(paramBaseChatPie instanceof SkinnableBitmapDrawable)) {
          break label496;
        }
        paramBaseChatPie = ((SkinnableBitmapDrawable)paramBaseChatPie).getBitmap();
        break;
        if (QLog.isColorLevel()) {
          QLog.d("AIOAudioPanel", 2, "AudioPanel background is null:");
        }
      }
      label496:
      paramBaseChatPie = null;
    }
  }
  
  public void a(LottieDrawable paramLottieDrawable, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AudioPanel", 2, "onDrawableLoaded AudioPanel mCurAnimType:" + this.jdField_g_of_type_Int + ",type= " + paramInt + " drawable=" + paramLottieDrawable);
    }
    if (!AudioTransitionAnimUtils.b(paramInt)) {}
    do
    {
      do
      {
        return;
      } while (this.jdField_g_of_type_Int != paramInt);
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable = paramLottieDrawable;
    } while (this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable == null);
    ThreadManager.getUIHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    ThreadManager.getUIHandler().post(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public void a(boolean paramBoolean)
  {
    int n = 0;
    b(false);
    this.jdField_k_of_type_Boolean = paramBoolean;
    WeakReferenceHandler localWeakReferenceHandler = this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler;
    if (paramBoolean) {
      n = 600;
    }
    localWeakReferenceHandler.sendEmptyMessageDelayed(1, n + 1200);
  }
  
  public boolean a()
  {
    int n;
    View localView;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelAdapter.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      ViewGroup localViewGroup = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelAdapter.jdField_a_of_type_AndroidViewViewGroup;
      int i1 = localViewGroup.getChildCount();
      n = 0;
      if (n >= i1) {
        break label91;
      }
      localView = localViewGroup.getChildAt(n);
      if (localView.getVisibility() != 0) {}
    }
    for (;;)
    {
      if ((localView != null) && ((localView instanceof AudioPanelCallback))) {}
      for (boolean bool = ((AudioPanelCallback)localView).a();; bool = false)
      {
        b(true);
        return bool;
        n += 1;
        break;
      }
      label91:
      localView = null;
    }
  }
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public void b()
  {
    this.jdField_g_of_type_Int = -1;
    ThreadManager.getUIHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    AudioTransitionAnimManager.a().a();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.g() != 36) {
      jdField_a_of_type_AndroidWidgetPopupWindow = null;
    }
    int n;
    View localView;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelAdapter.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      ViewGroup localViewGroup = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelAdapter.jdField_a_of_type_AndroidViewViewGroup;
      int i1 = localViewGroup.getChildCount();
      n = 0;
      if (n >= i1) {
        break label115;
      }
      localView = localViewGroup.getChildAt(n);
      if (localView.getVisibility() != 0) {
        break label108;
      }
    }
    for (;;)
    {
      if ((localView != null) && ((localView instanceof AudioPanelCallback))) {
        ((AudioPanelCallback)localView).c();
      }
      e();
      return;
      label108:
      n += 1;
      break;
      label115:
      localView = null;
    }
  }
  
  public void b(int paramInt)
  {
    if (!AudioTransitionAnimManager.a().a()) {
      return;
    }
    c(true);
    this.jdField_g_of_type_Int = AudioTransitionAnimUtils.a(paramInt);
    this.jdField_j_of_type_Boolean = true;
    a(getContext(), true);
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidGraphicsRect != null)
    {
      this.jdField_a_of_type_AndroidGraphicsRect = null;
      this.jdField_b_of_type_AndroidGraphicsRect = null;
    }
    this.jdField_k_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(2);
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(1);
    if (paramBoolean) {
      i();
    }
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelAdapter.jdField_b_of_type_AndroidViewViewGroup != null) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelAdapter.jdField_b_of_type_AndroidViewViewGroup instanceof ListenChangeVoicePanel)))
    {
      ((AudioPanelCallback)this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelAdapter.jdField_b_of_type_AndroidViewViewGroup).c();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelAdapter.jdField_b_of_type_AndroidViewViewGroup = null;
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if (!AudioTransitionAnimManager.a().a()) {}
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null);
      if (QLog.isColorLevel()) {
        QLog.d("AudioPanel", 2, "showAnimMask needStopLastAnim=" + paramBoolean);
      }
      if ((paramBoolean) && (this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable != null) && (this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.isAnimating())) {
        this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.endAnimation();
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable == null);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_AndroidGraphicsRect != null) {
      b(true);
    }
  }
  
  public void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    Rect localRect = this.jdField_a_of_type_AndroidGraphicsRect;
    if (localRect != null)
    {
      if (this.m > 0) {
        break label42;
      }
      if (!this.jdField_k_of_type_Boolean) {
        a(true);
      }
    }
    else
    {
      return;
    }
    b(false);
    return;
    label42:
    float f1 = localRect.width() / 2;
    float f2 = this.jdField_d_of_type_Float * f1;
    if (f2 > this.jdField_c_of_type_Float + f1) {
      f1 = this.jdField_c_of_type_Float;
    }
    for (;;)
    {
      if (f1 > 0.0F)
      {
        float f3 = f1 / 2.0F;
        this.jdField_a_of_type_AndroidGraphicsPaint.setColor(Color.argb(this.m, 0, 0, 255));
        this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(f1);
        paramCanvas.drawCircle(localRect.centerX(), localRect.centerY(), f2 - f3, this.jdField_a_of_type_AndroidGraphicsPaint);
      }
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(2, jdField_j_of_type_Int);
      return;
      if (f2 > f1) {
        f1 = f2 - f1;
      } else {
        f1 = 0.0F;
      }
    }
  }
  
  public void e()
  {
    int n = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_e_of_type_Int;
    if (n < 0) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_e_of_type_Int = -1;
    ThreadManager.post(new AudioPanel.1(this, n), 8, null, false);
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AudioPanel", 2, "hideAnimLayout ");
    }
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1) {
      g();
    }
    do
    {
      return true;
      if (paramMessage.what == 2)
      {
        h();
        i();
        return true;
      }
    } while (paramMessage.what != 3);
    paramMessage = ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH)).a("103100.103300.103301");
    RedTouch localRedTouch = new RedTouch(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(), this.jdField_c_of_type_AndroidWidgetTextView).b(53).a();
    this.jdField_c_of_type_AndroidWidgetTextView.setTag(localRedTouch);
    localRedTouch.a(paramMessage);
    return true;
  }
  
  public void onClick(View paramView)
  {
    int n = paramView.getId();
    c(n);
    if (n == 2131378335)
    {
      setCurrentPannel(1, false);
      n = 1;
    }
    for (;;)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "changevoice", "0X8006F4D", 0, 0, "" + n, "", "", "");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (n == 2131376784)
      {
        setCurrentPannel(2, false);
        n = 2;
      }
      else
      {
        if (n == 2131381759)
        {
          setCurrentPannel(0, false);
          ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH)).b("103100.103300.103301");
          Object localObject = this.jdField_c_of_type_AndroidWidgetTextView.getTag();
          if ((localObject != null) && ((localObject instanceof RedTouch))) {
            ((RedTouch)localObject).d();
          }
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null) {
            this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setShowRed(2, false);
          }
        }
        n = 0;
      }
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int n = paramMotionEvent.getAction() & 0xFF;
    if (n == 0) {
      getParent().requestDisallowInterceptTouchEvent(true);
    }
    for (;;)
    {
      return super.onInterceptTouchEvent(paramMotionEvent);
      if ((n == 1) || (n == 3)) {
        getParent().requestDisallowInterceptTouchEvent(false);
      }
    }
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((!this.jdField_b_of_type_Boolean) || (this.jdField_d_of_type_Boolean))
    {
      this.jdField_d_of_type_Boolean = false;
      paramInt2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.getCurrentItem();
      View localView = this.jdField_b_of_type_AndroidViewViewGroup.getChildAt(paramInt2);
      if (localView != null)
      {
        paramInt1 = (paramInt3 - paramInt1 - localView.getWidth()) / 2;
        paramInt2 = localView.getLeft();
        this.jdField_b_of_type_AndroidViewViewGroup.scrollTo(paramInt2 - paramInt1, this.jdField_b_of_type_AndroidViewViewGroup.getScrollY());
      }
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    try
    {
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.getLayoutParams();
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.getCurrentItem() == 0)
      {
        boolean bool = ListenChangeVoicePanel.jdField_b_of_type_Boolean;
        if (!bool) {}
      }
    }
    catch (Exception localException)
    {
      label30:
      break label30;
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void onPageScrollStateChanged(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "onPageScrollStateChanged() is called,state is:" + paramInt + " onPageScrolled=" + this.jdField_h_of_type_Boolean);
    }
    if (paramInt == 1) {
      j();
    }
    do
    {
      do
      {
        do
        {
          return;
        } while (paramInt != 0);
        k();
      } while (a() != 0);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "changevoice", "0X8006F4C", 0, 0, "1", "", "", "");
      ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH)).b("103100.103300.103301");
      Object localObject = this.jdField_c_of_type_AndroidWidgetTextView.getTag();
      if ((localObject != null) && ((localObject instanceof RedTouch))) {
        ((RedTouch)localObject).d();
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout == null);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setShowRed(2, false);
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    paramInt1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.getWidth();
    paramInt2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.getPageMargin() + paramInt1;
    if (!this.jdField_b_of_type_Boolean)
    {
      this.jdField_e_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.getCurrentItem();
      this.jdField_c_of_type_Int = ((this.jdField_e_of_type_Int + this.jdField_f_of_type_Int) * paramInt2);
      this.jdField_d_of_type_Int = this.jdField_b_of_type_AndroidViewViewGroup.getScrollX();
      this.jdField_b_of_type_Boolean = true;
    }
    paramFloat = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.getScrollX() - this.jdField_c_of_type_Int;
    if (paramFloat < 0.0F) {
      paramInt1 = this.jdField_e_of_type_Int - 1;
    }
    for (;;)
    {
      a(paramFloat);
      if ((!this.jdField_j_of_type_Boolean) && (this.jdField_i_of_type_Int != 0)) {
        a(this.jdField_h_of_type_Int, this.jdField_h_of_type_Int + this.jdField_i_of_type_Int, paramFloat);
      }
      View localView1 = this.jdField_b_of_type_AndroidViewViewGroup.getChildAt(this.jdField_e_of_type_Int);
      View localView2 = this.jdField_b_of_type_AndroidViewViewGroup.getChildAt(paramInt1);
      if (QLog.isColorLevel())
      {
        QLog.d("AIOAudioPanel", 2, "onPageScrolled() is called,pageBeforeScroll is:" + this.jdField_e_of_type_Int + ",nextPage is:" + paramInt1 + ",vpWidthWithMargin is:" + paramInt2);
        QLog.d("AIOAudioPanel", 2, "onPageScrolled vpRelativeScrollX is:" + paramFloat + ",vpScrollXBeforeScroll is:" + this.jdField_c_of_type_Int + ",pdScrollXBeforeScroll is:" + this.jdField_d_of_type_Int + " viewPager.getScrollX()=" + this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.getScrollX() + " curItem=" + this.jdField_h_of_type_Int);
      }
      if ((localView1 != null) && (localView2 != null))
      {
        paramInt1 = localView1.getLeft();
        int n = localView1.getWidth() / 2;
        int i1 = localView2.getLeft();
        int i2 = localView2.getWidth() / 2;
        paramFloat = Math.abs(paramFloat / paramInt2);
        paramInt1 = (int)((i1 + i2 - (paramInt1 + n)) * paramFloat);
        this.jdField_b_of_type_AndroidViewViewGroup.scrollTo(paramInt1 + this.jdField_d_of_type_Int, this.jdField_b_of_type_AndroidViewViewGroup.getScrollY());
      }
      return;
      if (paramFloat > 0.0F) {
        paramInt1 = this.jdField_e_of_type_Int + 1;
      } else {
        paramInt1 = this.jdField_e_of_type_Int;
      }
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "onPageSelected() is called,position is:" + paramInt + " onPageScrolled=" + this.jdField_h_of_type_Boolean);
    }
    int n;
    label173:
    Object localObject;
    if (paramInt == 0)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005471", "0X8005471", 0, 0, "", "", "", "");
      a(this.jdField_b_of_type_AndroidViewViewGroup, this.jdField_b_of_type_AndroidViewViewGroup.getChildAt(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.getCurrentItem()), this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.getContext().getResources().getColor(2131167023), c());
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(paramInt, this.jdField_c_of_type_Boolean, this.jdField_e_of_type_Boolean);
      this.jdField_e_of_type_Boolean = false;
      if ((!AppSetting.jdField_d_of_type_Boolean) || (this.jdField_a_of_type_ArrayOfJavaLangString == null) || (paramInt >= this.jdField_a_of_type_ArrayOfJavaLangString.length)) {
        return;
      }
      n = 0;
      if (n >= this.jdField_b_of_type_AndroidViewViewGroup.getChildCount()) {
        break label363;
      }
      localObject = this.jdField_b_of_type_AndroidViewViewGroup.getChildAt(n);
      if ((localObject != null) && (n < this.jdField_a_of_type_ArrayOfJavaLangString.length))
      {
        if (!(localObject instanceof TextView)) {
          break label336;
        }
        localObject = (TextView)localObject;
        label218:
        this.jdField_a_of_type_ArrayOfJavaLangString[n] = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131689915, new Object[] { ((TextView)localObject).getText() });
        if (paramInt != n) {
          break label350;
        }
        ((TextView)localObject).setContentDescription(HardCodeUtil.a(2131700873) + this.jdField_a_of_type_ArrayOfJavaLangString[n]);
      }
    }
    for (;;)
    {
      n += 1;
      break label173;
      if (paramInt != 1) {
        break;
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A1D2", "0X800A1D2", 0, 0, "", "", "", "");
      break;
      label336:
      localObject = (TextView)((View)localObject).findViewById(2131381759);
      break label218;
      label350:
      ((TextView)localObject).setContentDescription(this.jdField_a_of_type_ArrayOfJavaLangString[n]);
    }
    label363:
    AccessibilityUtils.a(this.jdField_b_of_type_AndroidViewViewGroup, HardCodeUtil.a(2131700872) + this.jdField_a_of_type_ArrayOfJavaLangString[paramInt]);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public void setCurrentPannel(int paramInt, boolean paramBoolean)
  {
    if ((paramInt < 0) || (paramInt >= 3)) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.getCurrentItem() != paramInt)
    {
      this.jdField_e_of_type_Boolean = paramBoolean;
      this.jdField_f_of_type_Boolean = paramBoolean;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.setCurrentItem(paramInt);
      requestLayout();
      a(this.jdField_b_of_type_AndroidViewViewGroup, this.jdField_b_of_type_AndroidViewViewGroup.getChildAt(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.getCurrentItem()), this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.getContext().getResources().getColor(2131167023), c());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.jdField_a_of_type_Boolean) {
      this.jdField_f_of_type_Int = (-paramInt);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPttTextTransitionAnim.setCurrentItem(paramInt);
  }
  
  public void setReceiptMode(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelAdapter.a(paramBoolean);
    this.jdField_g_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToSpeakPanel != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToSpeakPanel.setUseOnce(true);
    }
  }
  
  public void setSpeakPanel(PressToSpeakPanel paramPressToSpeakPanel)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToSpeakPanel = paramPressToSpeakPanel;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToSpeakPanel.setUseOnce(this.jdField_g_of_type_Boolean);
  }
  
  public void setStatus(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setStatus(paramInt);
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_Boolean = false;
    }
    if (paramInt == 0)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "changevoice", "0X8006F49", 0, 0, "" + a(), "", "", "");
      if (a() == 0) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "changevoice", "0X8006F4C", 0, 0, "0", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.AudioPanel
 * JD-Core Version:    0.7.0.1
 */