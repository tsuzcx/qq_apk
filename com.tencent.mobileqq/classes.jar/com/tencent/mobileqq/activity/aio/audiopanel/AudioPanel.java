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
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
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
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.receipt.ReceiptHelper;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.util.AccessibilityUtils;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.XEditTextEx;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class AudioPanel
  extends LinearLayout
  implements Handler.Callback, View.OnClickListener, ViewPager.OnPageChangeListener, AudioTransitionAnimManager.TransitionAnimListener
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
    int[] arrayOfInt = jdField_a_of_type_ArrayOfInt;
    jdField_a_of_type_Int = arrayOfInt[1] - arrayOfInt[0];
    jdField_a_of_type_AndroidWidgetPopupWindow = null;
    if (Build.VERSION.SDK_INT >= 16) {
      n = 55;
    } else if (Build.VERSION.SDK_INT > 9) {
      n = 65;
    } else {
      n = 85;
    }
    jdField_j_of_type_Int = n;
    int i1 = jdField_j_of_type_Int;
    if (Build.VERSION.SDK_INT >= 16) {
      n = 4;
    } else if (Build.VERSION.SDK_INT > 9) {
      n = 6;
    } else {
      n = 8;
    }
    jdField_k_of_type_Int = i1 - n;
    int n = jdField_j_of_type_Int;
    i1 = jdField_k_of_type_Int;
    jdField_b_of_type_Float = (n + i1) * 0.52F / 1200.0F;
    l = (n + i1) * -40 / 1200;
  }
  
  public AudioPanel(Context paramContext)
  {
    super(paramContext);
  }
  
  public AudioPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private int a(int paramInt)
  {
    int n = paramInt;
    if (paramInt > 2) {
      n = 2;
    }
    paramInt = n;
    if (n < 0) {
      paramInt = 0;
    }
    return paramInt;
  }
  
  public static View a(Context paramContext, ViewGroup paramViewGroup1, ViewGroup paramViewGroup2)
  {
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup1.getParent();
    int i1 = localViewGroup.getChildCount();
    int n = 0;
    while (n < i1)
    {
      if (localViewGroup.getChildAt(n) == paramViewGroup1) {
        break label46;
      }
      n += 1;
    }
    n = -1;
    label46:
    paramViewGroup2 = null;
    if (n >= 0)
    {
      paramViewGroup2 = new View(paramContext);
      paramContext = new RelativeLayout.LayoutParams(-1, paramViewGroup1.getHeight());
      paramContext.addRule(6, paramViewGroup1.getId());
      paramContext.addRule(8, paramViewGroup1.getId());
      paramViewGroup2.setLayoutParams(paramContext);
      localViewGroup.addView(paramViewGroup2, n);
    }
    return paramViewGroup2;
  }
  
  public static PopupWindow a()
  {
    return jdField_a_of_type_AndroidWidgetPopupWindow;
  }
  
  public static PopupWindow a(Context paramContext, int paramInt1, int paramInt2, View paramView, int paramInt3, int paramInt4, int paramInt5)
  {
    PopupWindow localPopupWindow = jdField_a_of_type_AndroidWidgetPopupWindow;
    if ((localPopupWindow != null) && (localPopupWindow.isShowing())) {
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
      if (QLog.isColorLevel()) {
        QLog.e("AudioPanel", 2, paramContext, new Object[0]);
      }
    }
    if (paramView.getWindowToken() != null) {
      jdField_a_of_type_AndroidWidgetPopupWindow.showAtLocation(paramView, paramInt3, paramInt4, paramInt5);
    }
    return jdField_a_of_type_AndroidWidgetPopupWindow;
  }
  
  private void a(float paramFloat)
  {
    float f1 = this.jdField_a_of_type_Float;
    if (f1 == 0.0F)
    {
      this.jdField_a_of_type_Float = paramFloat;
      return;
    }
    paramFloat -= f1;
    int n = 0;
    if (paramFloat > 0.0F) {
      n = 1;
    } else if (paramFloat < 0.0F) {
      n = -1;
    }
    if (this.jdField_i_of_type_Int != n)
    {
      this.jdField_i_of_type_Boolean = true;
      this.jdField_i_of_type_Int = n;
    }
  }
  
  private void a(int paramInt1, int paramInt2, float paramFloat)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doPageScrolledTransitionAnim() curItem is:");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" nextItem=");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(" needDoPageScrolledTransitionAnim=");
      localStringBuilder.append(this.jdField_i_of_type_Boolean);
      localStringBuilder.append(" nextdirect=");
      localStringBuilder.append(this.jdField_i_of_type_Int);
      QLog.d("AIOAudioPanel", 2, localStringBuilder.toString());
    }
    paramInt2 = a(paramInt2);
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
  
  private void b(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doTransitionAnimByNextItem lastSelectItem is:");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" nextItem=");
      localStringBuilder.append(paramInt2);
      QLog.d("AIOAudioPanel", 2, localStringBuilder.toString());
    }
    if (!AudioTransitionAnimManager.a().a()) {
      return;
    }
    int n = paramInt1;
    if (paramInt1 < 0) {
      n = a();
    }
    if (n != paramInt2)
    {
      this.jdField_g_of_type_Int = AudioTransitionAnimUtils.a(n, paramInt2);
      a(getContext(), this.jdField_j_of_type_Boolean);
    }
  }
  
  private int c()
  {
    AudioPanelViewPager localAudioPanelViewPager = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager;
    if (localAudioPanelViewPager != null)
    {
      int n = localAudioPanelViewPager.getCurrentItem();
      if (n != 0)
      {
        if (n != 1)
        {
          if (n == 2) {
            return this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.getContext().getResources().getColor(2131167045);
          }
        }
        else {
          return this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.getContext().getResources().getColor(2131167045);
        }
      }
      else {
        return this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.getContext().getResources().getColor(2131167045);
      }
    }
    return -15158044;
  }
  
  private void c(int paramInt)
  {
    int n = a();
    if (paramInt == 2131377744) {
      paramInt = 1;
    } else if (paramInt == 2131376280) {
      paramInt = 2;
    } else if (paramInt == 2131380989) {
      paramInt = 0;
    } else {
      paramInt = -1;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doClickItemTransitionAnim() lastSelectItem is:");
      localStringBuilder.append(n);
      localStringBuilder.append(" nextItem=");
      localStringBuilder.append(paramInt);
      QLog.d("AIOAudioPanel", 2, localStringBuilder.toString());
    }
    if ((paramInt >= 0) && (paramInt != n))
    {
      c(true);
      this.jdField_j_of_type_Boolean = true;
      b(n, paramInt);
    }
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.getCurrentItem() == 1)
    {
      Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToSpeakPanel;
      if (localObject1 != null)
      {
        Object localObject2 = ((PressToSpeakPanel)localObject1).a();
        localObject1 = new Rect();
        ((ImageView)localObject2).getGlobalVisibleRect((Rect)localObject1);
        localObject2 = new Rect();
        super.getGlobalVisibleRect((Rect)localObject2);
        int n = ((Rect)localObject1).left - ((Rect)localObject2).left;
        int i1 = ((Rect)localObject1).top - ((Rect)localObject2).top;
        this.jdField_c_of_type_Float = TypedValue.applyDimension(1, 30.0F, getResources().getDisplayMetrics());
        this.jdField_a_of_type_AndroidGraphicsRect = new Rect(n, i1, ((Rect)localObject1).width() + n, ((Rect)localObject1).height() + i1);
        this.m = 40;
        this.jdField_d_of_type_Float = 0.98F;
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("initAndStartHollowRoundAnim:");
          ((StringBuilder)localObject1).append(this.m);
          ((StringBuilder)localObject1).append(", ");
          ((StringBuilder)localObject1).append(this.jdField_d_of_type_Float);
          QLog.d("HollowRound", 2, ((StringBuilder)localObject1).toString());
        }
        this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
        this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
        this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
        i();
      }
    }
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_AndroidGraphicsRect != null)
    {
      this.m += l;
      this.jdField_d_of_type_Float += jdField_b_of_type_Float;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("updateHollowRoundAnim:");
        localStringBuilder.append(this.m);
        localStringBuilder.append(", ");
        localStringBuilder.append(this.jdField_d_of_type_Float);
        QLog.d("HollowRound", 2, localStringBuilder.toString());
      }
    }
  }
  
  private void i()
  {
    Rect localRect = this.jdField_b_of_type_AndroidGraphicsRect;
    if (localRect == null)
    {
      super.invalidate();
      return;
    }
    super.invalidate(localRect);
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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPageScrollStateChanged()   SCROLL_STATE_DRAGGING curItemWhenPageStatusChangeToDrag=");
      localStringBuilder.append(this.jdField_h_of_type_Int);
      localStringBuilder.append(" needDoPageScrolledTransitionAnim=");
      localStringBuilder.append(this.jdField_i_of_type_Boolean);
      QLog.d("AIOAudioPanel", 2, localStringBuilder.toString());
    }
  }
  
  private void k()
  {
    this.jdField_h_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPttTextTransitionAnim.setCurrentItem(a());
    if (!this.jdField_j_of_type_Boolean)
    {
      LottieDrawable localLottieDrawable = this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable;
      if (localLottieDrawable != null)
      {
        localLottieDrawable.endAnimation();
        f();
      }
    }
  }
  
  public int a()
  {
    AudioPanelViewPager localAudioPanelViewPager = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager;
    if (localAudioPanelViewPager != null) {
      return localAudioPanelViewPager.getCurrentItem();
    }
    return -1;
  }
  
  public void a()
  {
    int n = 0;
    AudioPanelAioHelper.jdField_a_of_type_Boolean = false;
    e();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelAdapter.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      ViewGroup localViewGroup = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelAdapter.jdField_a_of_type_AndroidViewViewGroup;
      Object localObject2 = null;
      int i1 = localViewGroup.getChildCount();
      Object localObject1;
      for (;;)
      {
        localObject1 = localObject2;
        if (n >= i1) {
          break;
        }
        localObject1 = localViewGroup.getChildAt(n);
        if (((View)localObject1).getVisibility() == 0) {
          break;
        }
        n += 1;
      }
      if ((localObject1 != null) && ((localObject1 instanceof AudioPanelCallback))) {
        ((AudioPanelCallback)localObject1).b();
      }
    }
    b(true);
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.getCurrentItem() != paramInt)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.setCurrentItem(paramInt);
      requestLayout();
      ViewGroup localViewGroup = this.jdField_b_of_type_AndroidViewViewGroup;
      a(localViewGroup, localViewGroup.getChildAt(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.getCurrentItem()), this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.getContext().getResources().getColor(2131167046), c());
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    if ((localObject != null) && (!((BaseChatPie)localObject).r()))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("oldPanel=");
        ((StringBuilder)localObject).append(paramInt1);
        ((StringBuilder)localObject).append(" newPanel=");
        ((StringBuilder)localObject).append(paramInt2);
        ((StringBuilder)localObject).append(" text.length ");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a.getText().length());
        QLog.d("doPanelChanged", 2, ((StringBuilder)localObject).toString());
      }
      if (paramInt2 == 2)
      {
        if ((paramInt1 != 2) && (AIOInputTypeHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) {
          a(false);
        }
      }
      else {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a.getText().length();
      }
    }
  }
  
  public void a(Animator paramAnimator, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      paramAnimator = new StringBuilder();
      paramAnimator.append("onAnimationEnd AudioPanel mCurAnimType:");
      paramAnimator.append(this.jdField_g_of_type_Int);
      paramAnimator.append(",type= ");
      paramAnimator.append(paramInt);
      paramAnimator.append(" isPageViewStartDragger=");
      paramAnimator.append(this.jdField_h_of_type_Boolean);
      QLog.d("AudioPanel", 2, paramAnimator.toString());
    }
    if (!AudioTransitionAnimUtils.b(paramInt)) {
      return;
    }
    this.jdField_j_of_type_Boolean = false;
    if (!this.jdField_h_of_type_Boolean) {
      f();
    }
  }
  
  public void a(Context paramContext, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("playTransitionAnimByType AudioTransitionAnimManager animType:");
      ((StringBuilder)localObject).append(this.jdField_g_of_type_Int);
      ((StringBuilder)localObject).append(" mCurLottieDrawable=");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable);
      QLog.d("AIOAudioPanel", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = AudioTransitionAnimManager.a();
    ((AudioTransitionAnimManager)localObject).a(this);
    LottieDrawable localLottieDrawable = this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable;
    if (localLottieDrawable != null) {
      ((AudioTransitionAnimManager)localObject).a(localLottieDrawable);
    } else {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    }
    this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable = ((AudioTransitionAnimManager)localObject).a(paramContext, this.jdField_g_of_type_Int);
    paramContext = this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable;
    if (paramContext != null) {
      ((AudioTransitionAnimManager)localObject).a(paramContext, this.jdField_g_of_type_Int, this.jdField_a_of_type_AndroidWidgetImageView, paramBoolean);
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
      while (n < i1)
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
          else if (n == 0)
          {
            localObject = this.jdField_c_of_type_AndroidWidgetTextView;
            if (localObject != null)
            {
              ((TextView)localObject).setTextColor(paramInt1);
              this.jdField_c_of_type_AndroidWidgetTextView.setTextSize(2, 13.0F);
            }
          }
        }
        else if (paramView != null)
        {
          if ((paramView instanceof TextView))
          {
            localObject = (TextView)paramView;
            ((TextView)localObject).setTextColor(paramInt2);
            ((TextView)localObject).setTextSize(2, 15.0F);
          }
          else if ((paramView instanceof FrameLayout))
          {
            localObject = this.jdField_c_of_type_AndroidWidgetTextView;
            if (localObject != null)
            {
              ((TextView)localObject).setTextColor(paramInt2);
              this.jdField_c_of_type_AndroidWidgetTextView.setTextSize(2, 15.0F);
              BabyQHandler.a(this.jdField_a_of_type_AndroidViewView);
            }
          }
        }
        n += 1;
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
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager = ((AudioPanelViewPager)findViewById(2131372284));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131363024));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131363025));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPttTextTransitionAnim = ((PttTextTransitionAnim)findViewById(2131373191));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131372277));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377744));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131376280));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131380989));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131380983);
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131372276));
    if (((ReceiptHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(118)).jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelAdapter = new AudioPanelAdapter(paramQQAppInterface, paramBaseChatPie, this, this.jdField_a_of_type_AndroidViewViewGroup, this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout, this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.a(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelAdapter);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.setOnPageChangeListener(this);
    paramBaseChatPie = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager;
    int i1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelAdapter.getCount();
    int n = 1;
    paramBaseChatPie.setCurrentItem(Math.min(1, i1 - 1));
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(c());
    this.jdField_c_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    paramSessionInfo = getResources().getDrawable(2130850615);
    paramBaseChatPie = null;
    if ((paramSessionInfo instanceof BitmapDrawable)) {
      paramBaseChatPie = ((BitmapDrawable)paramSessionInfo).getBitmap();
    } else if ((paramSessionInfo instanceof SkinnableBitmapDrawable)) {
      paramBaseChatPie = ((SkinnableBitmapDrawable)paramSessionInfo).getBitmap();
    }
    paramBaseChatPie = new BitmapDrawable(paramBaseChatPie);
    paramBaseChatPie.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
    paramBaseChatPie.setDither(true);
    setBackgroundDrawable(paramBaseChatPie);
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(3);
    if (QLog.isColorLevel())
    {
      paramBaseChatPie = new StringBuilder();
      paramBaseChatPie.append("AudioPanel.init() is called,time is:");
      paramBaseChatPie.append(System.currentTimeMillis());
      QLog.d("AIOAudioPanel", 2, paramBaseChatPie.toString());
    }
    if (Utils.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a))
    {
      paramBaseChatPie = (BabyQHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.BABY_Q_HANDLER);
      if (paramBaseChatPie.a(2))
      {
        paramBaseChatPie.a();
        BabyQHandler.a(getContext(), this.jdField_a_of_type_AndroidViewView);
      }
    }
    AudioTransitionAnimManager.a().a(this);
    VideoReport.setElementId(this, "em_aio_voice_panel");
    VideoReport.setElementExposePolicy(this, ExposurePolicy.REPORT_ALL);
    paramQQAppInterface = ((IRedTouchManager)paramQQAppInterface.getRuntimeService(IRedTouchManager.class, "")).getAppInfoByPath("103100.103300");
    if ((paramQQAppInterface == null) || (paramQQAppInterface.iNewFlag.get() != 1)) {
      n = 0;
    }
    VideoReport.setElementParam(this, "is_red_tips_before", Integer.valueOf(n));
  }
  
  public void a(LottieDrawable paramLottieDrawable, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDrawableLoaded AudioPanel mCurAnimType:");
      localStringBuilder.append(this.jdField_g_of_type_Int);
      localStringBuilder.append(",type= ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" drawable=");
      localStringBuilder.append(paramLottieDrawable);
      QLog.d("AudioPanel", 2, localStringBuilder.toString());
    }
    if (!AudioTransitionAnimUtils.b(paramInt)) {
      return;
    }
    if (this.jdField_g_of_type_Int == paramInt)
    {
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable = paramLottieDrawable;
      if (this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable != null)
      {
        ThreadManager.getUIHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
        ThreadManager.getUIHandler().post(this.jdField_a_of_type_JavaLangRunnable);
      }
    }
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
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelAdapter.jdField_a_of_type_AndroidViewViewGroup;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localObject1 != null)
    {
      ViewGroup localViewGroup = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelAdapter.jdField_a_of_type_AndroidViewViewGroup;
      Object localObject2 = null;
      int i1 = localViewGroup.getChildCount();
      int n = 0;
      for (;;)
      {
        localObject1 = localObject2;
        if (n >= i1) {
          break;
        }
        localObject1 = localViewGroup.getChildAt(n);
        if (((View)localObject1).getVisibility() == 0) {
          break;
        }
        n += 1;
      }
      bool1 = bool2;
      if (localObject1 != null)
      {
        bool1 = bool2;
        if ((localObject1 instanceof AudioPanelCallback)) {
          bool1 = ((AudioPanelCallback)localObject1).a();
        }
      }
    }
    b(true);
    return bool1;
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
    int n = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.c();
    Object localObject2 = null;
    if (n != 36) {
      jdField_a_of_type_AndroidWidgetPopupWindow = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelAdapter.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      ViewGroup localViewGroup = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelAdapter.jdField_a_of_type_AndroidViewViewGroup;
      int i1 = localViewGroup.getChildCount();
      n = 0;
      Object localObject1;
      for (;;)
      {
        localObject1 = localObject2;
        if (n >= i1) {
          break;
        }
        localObject1 = localViewGroup.getChildAt(n);
        if (((View)localObject1).getVisibility() == 0) {
          break;
        }
        n += 1;
      }
      if ((localObject1 != null) && ((localObject1 instanceof AudioPanelCallback))) {
        ((AudioPanelCallback)localObject1).c();
      }
    }
    e();
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
    if (!AudioTransitionAnimManager.a().a()) {
      return;
    }
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("showAnimMask needStopLastAnim=");
        ((StringBuilder)localObject).append(paramBoolean);
        QLog.d("AudioPanel", 2, ((StringBuilder)localObject).toString());
      }
      if (paramBoolean)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable;
        if ((localObject != null) && (((LottieDrawable)localObject).isAnimating())) {
          this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.endAnimation();
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable != null) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      }
    }
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
      if (this.m <= 0)
      {
        if (!this.jdField_k_of_type_Boolean)
        {
          a(true);
          return;
        }
        b(false);
        return;
      }
      float f3 = localRect.width() / 2;
      float f2 = this.jdField_d_of_type_Float * f3;
      float f1 = this.jdField_c_of_type_Float;
      if (f2 <= f3 + f1) {
        if (f2 > f3) {
          f1 = f2 - f3;
        } else {
          f1 = 0.0F;
        }
      }
      if (f1 > 0.0F)
      {
        f3 = f1 / 2.0F;
        this.jdField_a_of_type_AndroidGraphicsPaint.setColor(Color.argb(this.m, 0, 0, 255));
        this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(f1);
        paramCanvas.drawCircle(localRect.centerX(), localRect.centerY(), f2 - f3, this.jdField_a_of_type_AndroidGraphicsPaint);
      }
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(2, jdField_j_of_type_Int);
    }
  }
  
  public void e()
  {
    int n = ((AudioPanelAioHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(128)).jdField_b_of_type_Int;
    if (n < 0) {
      return;
    }
    ((AudioPanelAioHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(128)).jdField_b_of_type_Int = -1;
    ThreadManager.post(new AudioPanel.1(this, n), 8, null, false);
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AudioPanel", 2, "hideAnimLayout ");
    }
    RelativeLayout localRelativeLayout = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
    if (localRelativeLayout != null) {
      localRelativeLayout.setVisibility(8);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1)
    {
      g();
      return true;
    }
    if (paramMessage.what == 2)
    {
      h();
      i();
      return true;
    }
    if (paramMessage.what == 3)
    {
      paramMessage = ((IRedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IRedTouchManager.class, "")).getAppInfoByPath("103100.103300.103301");
      RedTouch localRedTouch = new RedTouch(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(), this.jdField_c_of_type_AndroidWidgetTextView).b(53).a();
      this.jdField_c_of_type_AndroidWidgetTextView.setTag(localRedTouch);
      localRedTouch.a(paramMessage);
    }
    return true;
  }
  
  public void onClick(View paramView)
  {
    int i2 = paramView.getId();
    c(i2);
    int i1 = 0;
    int n;
    if (i2 == 2131377744)
    {
      setCurrentPannel(1, false);
      n = 1;
    }
    else if (i2 == 2131376280)
    {
      setCurrentPannel(2, false);
      n = 2;
    }
    else
    {
      n = i1;
      if (i2 == 2131380989)
      {
        setCurrentPannel(0, false);
        ((IRedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IRedTouchManager.class, "")).onRedTouchItemClick("103100.103300.103301");
        localObject = this.jdField_c_of_type_AndroidWidgetTextView.getTag();
        if ((localObject != null) && ((localObject instanceof RedTouch))) {
          ((RedTouch)localObject).d();
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout;
        n = i1;
        if (localObject != null)
        {
          ((PanelIconLinearLayout)localObject).setShowRed(2, false);
          n = i1;
        }
      }
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(n);
    ReportController.b((AppRuntime)localObject, "CliOper", "", "", "changevoice", "0X8006F4D", 0, 0, localStringBuilder.toString(), "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int n = paramMotionEvent.getAction() & 0xFF;
    if (n == 0) {
      getParent().requestDisallowInterceptTouchEvent(true);
    } else if ((n == 1) || (n == 3)) {
      getParent().requestDisallowInterceptTouchEvent(false);
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((!this.jdField_b_of_type_Boolean) || (this.jdField_d_of_type_Boolean))
    {
      this.jdField_d_of_type_Boolean = false;
      paramInt2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.getCurrentItem();
      Object localObject = this.jdField_b_of_type_AndroidViewViewGroup.getChildAt(paramInt2);
      if (localObject != null)
      {
        paramInt1 = (paramInt3 - paramInt1 - ((View)localObject).getWidth()) / 2;
        paramInt2 = ((View)localObject).getLeft();
        localObject = this.jdField_b_of_type_AndroidViewViewGroup;
        ((ViewGroup)localObject).scrollTo(paramInt2 - paramInt1, ((ViewGroup)localObject).getScrollY());
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    try
    {
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.getLayoutParams();
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.getCurrentItem() == 0) {
        boolean bool = ListenChangeVoicePanel.jdField_b_of_type_Boolean;
      }
      label26:
      super.onMeasure(paramInt1, paramInt2);
      return;
    }
    catch (Exception localException)
    {
      break label26;
    }
  }
  
  public void onPageScrollStateChanged(int paramInt)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onPageScrollStateChanged() is called,state is:");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" onPageScrolled=");
      ((StringBuilder)localObject).append(this.jdField_h_of_type_Boolean);
      QLog.d("AIOAudioPanel", 2, ((StringBuilder)localObject).toString());
    }
    if (paramInt == 1)
    {
      j();
      return;
    }
    if (paramInt == 0)
    {
      k();
      if (a() == 0)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "changevoice", "0X8006F4C", 0, 0, "1", "", "", "");
        ((IRedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IRedTouchManager.class, "")).onRedTouchItemClick("103100.103300.103301");
        localObject = this.jdField_c_of_type_AndroidWidgetTextView.getTag();
        if ((localObject != null) && ((localObject instanceof RedTouch))) {
          ((RedTouch)localObject).d();
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout;
        if (localObject != null) {
          ((PanelIconLinearLayout)localObject).setShowRed(2, false);
        }
      }
    }
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    paramInt2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.getWidth() + this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.getPageMargin();
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
    } else if (paramFloat > 0.0F) {
      paramInt1 = this.jdField_e_of_type_Int + 1;
    } else {
      paramInt1 = this.jdField_e_of_type_Int;
    }
    a(paramFloat);
    int n;
    int i1;
    if (!this.jdField_j_of_type_Boolean)
    {
      n = this.jdField_i_of_type_Int;
      if (n != 0)
      {
        i1 = this.jdField_h_of_type_Int;
        a(i1, n + i1, paramFloat);
      }
    }
    Object localObject = this.jdField_b_of_type_AndroidViewViewGroup.getChildAt(this.jdField_e_of_type_Int);
    View localView = this.jdField_b_of_type_AndroidViewViewGroup.getChildAt(paramInt1);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPageScrolled() is called,pageBeforeScroll is:");
      localStringBuilder.append(this.jdField_e_of_type_Int);
      localStringBuilder.append(",nextPage is:");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(",vpWidthWithMargin is:");
      localStringBuilder.append(paramInt2);
      QLog.d("AIOAudioPanel", 2, localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPageScrolled vpRelativeScrollX is:");
      localStringBuilder.append(paramFloat);
      localStringBuilder.append(",vpScrollXBeforeScroll is:");
      localStringBuilder.append(this.jdField_c_of_type_Int);
      localStringBuilder.append(",pdScrollXBeforeScroll is:");
      localStringBuilder.append(this.jdField_d_of_type_Int);
      localStringBuilder.append(" viewPager.getScrollX()=");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.getScrollX());
      localStringBuilder.append(" curItem=");
      localStringBuilder.append(this.jdField_h_of_type_Int);
      QLog.d("AIOAudioPanel", 2, localStringBuilder.toString());
    }
    if ((localObject != null) && (localView != null))
    {
      paramInt1 = ((View)localObject).getLeft();
      n = ((View)localObject).getWidth() / 2;
      i1 = localView.getLeft();
      int i2 = localView.getWidth() / 2;
      paramFloat = Math.abs(paramFloat / paramInt2);
      paramInt1 = (int)((i1 + i2 - (paramInt1 + n)) * paramFloat);
      localObject = this.jdField_b_of_type_AndroidViewViewGroup;
      ((ViewGroup)localObject).scrollTo(this.jdField_d_of_type_Int + paramInt1, ((ViewGroup)localObject).getScrollY());
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onPageSelected() is called,position is:");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" onPageScrolled=");
      ((StringBuilder)localObject).append(this.jdField_h_of_type_Boolean);
      QLog.d("AIOAudioPanel", 2, ((StringBuilder)localObject).toString());
    }
    if (paramInt == 0) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005471", "0X8005471", 0, 0, "", "", "", "");
    } else if (paramInt == 1) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A1D2", "0X800A1D2", 0, 0, "", "", "", "");
    }
    Object localObject = this.jdField_b_of_type_AndroidViewViewGroup;
    a((ViewGroup)localObject, ((ViewGroup)localObject).getChildAt(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.getCurrentItem()), this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.getContext().getResources().getColor(2131167046), c());
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(paramInt, this.jdField_c_of_type_Boolean, this.jdField_e_of_type_Boolean);
    this.jdField_e_of_type_Boolean = false;
    if (AppSetting.jdField_d_of_type_Boolean)
    {
      localObject = this.jdField_a_of_type_ArrayOfJavaLangString;
      if ((localObject != null) && (paramInt < localObject.length))
      {
        int n = 0;
        while (n < this.jdField_b_of_type_AndroidViewViewGroup.getChildCount())
        {
          localObject = this.jdField_b_of_type_AndroidViewViewGroup.getChildAt(n);
          if ((localObject != null) && (n < this.jdField_a_of_type_ArrayOfJavaLangString.length))
          {
            if ((localObject instanceof TextView)) {
              localObject = (TextView)localObject;
            } else {
              localObject = (TextView)((View)localObject).findViewById(2131380989);
            }
            this.jdField_a_of_type_ArrayOfJavaLangString[n] = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131689829, new Object[] { ((TextView)localObject).getText() });
            if (paramInt == n)
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append(HardCodeUtil.a(2131701016));
              localStringBuilder.append(this.jdField_a_of_type_ArrayOfJavaLangString[n]);
              ((TextView)localObject).setContentDescription(localStringBuilder.toString());
            }
            else
            {
              ((TextView)localObject).setContentDescription(this.jdField_a_of_type_ArrayOfJavaLangString[n]);
            }
          }
          n += 1;
        }
        localObject = this.jdField_b_of_type_AndroidViewViewGroup;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(HardCodeUtil.a(2131701015));
        localStringBuilder.append(this.jdField_a_of_type_ArrayOfJavaLangString[paramInt]);
        AccessibilityUtils.a((View)localObject, localStringBuilder.toString());
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public void setCurrentPannel(int paramInt, boolean paramBoolean)
  {
    if (paramInt >= 0)
    {
      if (paramInt >= 3) {
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.getCurrentItem() != paramInt)
      {
        this.jdField_e_of_type_Boolean = paramBoolean;
        this.jdField_f_of_type_Boolean = paramBoolean;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.setCurrentItem(paramInt);
        requestLayout();
        ViewGroup localViewGroup = this.jdField_b_of_type_AndroidViewViewGroup;
        a(localViewGroup, localViewGroup.getChildAt(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.getCurrentItem()), this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.getContext().getResources().getColor(2131167046), c());
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.jdField_a_of_type_Boolean) {
        this.jdField_f_of_type_Int = (-paramInt);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPttTextTransitionAnim.setCurrentItem(paramInt);
    }
  }
  
  public void setReceiptMode(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelAdapter.a(paramBoolean);
    this.jdField_g_of_type_Boolean = true;
    PressToSpeakPanel localPressToSpeakPanel = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToSpeakPanel;
    if (localPressToSpeakPanel != null) {
      localPressToSpeakPanel.setUseOnce(true);
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
      QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(a());
      ReportController.b(localQQAppInterface, "CliOper", "", "", "changevoice", "0X8006F49", 0, 0, localStringBuilder.toString(), "", "", "");
      if (a() == 0) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "changevoice", "0X8006F4C", 0, 0, "0", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.AudioPanel
 * JD-Core Version:    0.7.0.1
 */