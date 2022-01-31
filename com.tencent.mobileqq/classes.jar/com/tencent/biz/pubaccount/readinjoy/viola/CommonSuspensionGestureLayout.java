package com.tencent.biz.pubaccount.readinjoy.viola;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.Scroller;
import android.widget.TextView;
import azkz;
import bdoo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.mini.util.DisplayUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.viola.core.ViolaSDKManager;
import com.tencent.viola.ui.dom.style.CornerViewOutlineProvider;
import com.tencent.viola.ui.dom.style.FlexConvertUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
import nrt;
import org.json.JSONObject;
import smb;
import smc;
import smd;
import sme;
import smf;
import smg;
import smh;
import smi;
import smj;

public class CommonSuspensionGestureLayout
  extends FrameLayout
  implements View.OnTouchListener
{
  public static int a;
  public static int b;
  public static int c;
  public static int d;
  public static int e;
  public static int f;
  public static int g;
  public static int h;
  float jdField_a_of_type_Float;
  private long jdField_a_of_type_Long;
  private ObjectAnimator jdField_a_of_type_AndroidAnimationObjectAnimator;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Context jdField_a_of_type_AndroidContentContext;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private VelocityTracker jdField_a_of_type_AndroidViewVelocityTracker;
  private View.OnLayoutChangeListener jdField_a_of_type_AndroidViewView$OnLayoutChangeListener;
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private AnimationSet jdField_a_of_type_AndroidViewAnimationAnimationSet;
  private TranslateAnimation jdField_a_of_type_AndroidViewAnimationTranslateAnimation;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  Scroller jdField_a_of_type_AndroidWidgetScroller;
  private Boolean jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
  private smi jdField_a_of_type_Smi;
  private smj jdField_a_of_type_Smj;
  private boolean jdField_a_of_type_Boolean = true;
  float jdField_b_of_type_Float;
  private View jdField_b_of_type_AndroidViewView;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private TranslateAnimation jdField_b_of_type_AndroidViewAnimationTranslateAnimation;
  private boolean jdField_b_of_type_Boolean = true;
  float jdField_c_of_type_Float;
  private View jdField_c_of_type_AndroidViewView;
  private boolean jdField_c_of_type_Boolean;
  float jdField_d_of_type_Float;
  private View jdField_d_of_type_AndroidViewView;
  private boolean jdField_d_of_type_Boolean = true;
  private float jdField_e_of_type_Float;
  private View jdField_e_of_type_AndroidViewView;
  private boolean jdField_e_of_type_Boolean = true;
  private boolean f;
  private boolean g;
  private boolean h;
  private int jdField_i_of_type_Int;
  private boolean jdField_i_of_type_Boolean;
  private int jdField_j_of_type_Int = 120;
  private boolean jdField_j_of_type_Boolean;
  private int jdField_k_of_type_Int = 10;
  private boolean jdField_k_of_type_Boolean = true;
  private int l = -1;
  private int m;
  private int n;
  private int o;
  private int p = -1;
  private int q;
  
  static
  {
    jdField_b_of_type_Int = 1;
    jdField_c_of_type_Int = 2;
    jdField_d_of_type_Int = 3;
    jdField_e_of_type_Int = 4;
    jdField_f_of_type_Int = 5;
    jdField_g_of_type_Int = 500;
    jdField_h_of_type_Int = 300;
  }
  
  public CommonSuspensionGestureLayout(Context paramContext, Bundle paramBundle)
  {
    super(paramContext, null, 0);
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    if ((this.jdField_a_of_type_AndroidOsBundle != null) && (this.jdField_a_of_type_AndroidOsBundle.containsKey("float_layer_back_view"))) {
      this.jdField_f_of_type_Boolean = this.jdField_a_of_type_AndroidOsBundle.getBoolean("float_layer_back_view", false);
    }
    if ((this.jdField_a_of_type_AndroidOsBundle != null) && (this.jdField_a_of_type_AndroidOsBundle.containsKey("margin_top"))) {
      this.jdField_j_of_type_Int = this.jdField_a_of_type_AndroidOsBundle.getInt("margin_top", 120);
    }
    if ((this.jdField_a_of_type_AndroidOsBundle != null) && (this.jdField_a_of_type_AndroidOsBundle.containsKey("scroll_to_top"))) {
      this.jdField_b_of_type_Boolean = this.jdField_a_of_type_AndroidOsBundle.getBoolean("scroll_to_top", true);
    }
    setOnTouchListener(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    i();
    j();
    k();
    setOnClickListener(new smb(this));
    this.jdField_a_of_type_AndroidViewView$OnLayoutChangeListener = new sme(this);
    addOnLayoutChangeListener(this.jdField_a_of_type_AndroidViewView$OnLayoutChangeListener);
  }
  
  public static int a(Activity paramActivity)
  {
    for (int i1 = 0;; i1 = 0) {
      try
      {
        if (azkz.a(paramActivity.getApplicationContext()))
        {
          int i2 = azkz.d(paramActivity.getApplicationContext());
          i1 = i2;
          int i3;
          label166:
          return i1;
        }
      }
      catch (Exception paramActivity)
      {
        try
        {
          QLog.d("CommonSuspensionGestureLayout", 1, "getNavigationBarHeight " + i1 + ",isNavShow:" + a(paramActivity) + ",build name:" + Build.MANUFACTURER + "，build module:" + Build.MODEL + ",getContentHeight:" + b(paramActivity) + ",screenHeight:" + DisplayUtil.getScreenHeight(paramActivity));
          if (i1 == 0) {
            continue;
          }
          if (!a(paramActivity)) {
            return 0;
          }
          if ((!Build.MANUFACTURER.contains("OnePlus")) || (!Build.MODEL.contains("HD1900")) || (b(paramActivity) < DisplayUtil.getScreenHeight(paramActivity))) {
            continue;
          }
          i2 = b(paramActivity);
          i3 = DisplayUtil.getScreenHeight(paramActivity);
          return i2 - i3;
        }
        catch (Exception paramActivity)
        {
          break label166;
        }
        paramActivity = paramActivity;
        QLog.e("CommonSuspensionGestureLayout", 1, "getNavigationBarHeight error:" + paramActivity.getMessage());
        paramActivity.printStackTrace();
        return i1;
      }
    }
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidWidgetScroller == null) {
      this.jdField_a_of_type_AndroidWidgetScroller = new Scroller(this.jdField_a_of_type_AndroidContentContext);
    }
    if (this.jdField_a_of_type_AndroidViewView == null) {}
    while (this.jdField_i_of_type_Int == jdField_f_of_type_Int) {
      return;
    }
    int i1 = this.jdField_a_of_type_AndroidViewView.getScrollX();
    int i2 = this.jdField_a_of_type_AndroidViewView.getScrollY();
    if ((!this.jdField_a_of_type_Smi.a()) && (((i2 > 0) && (i2 < jdField_h_of_type_Int)) || (i2 >= jdField_h_of_type_Int)))
    {
      this.jdField_i_of_type_Int = jdField_f_of_type_Int;
      this.jdField_a_of_type_AndroidViewView.scrollTo(0, 0);
      postInvalidate();
      return;
    }
    if ((i2 < 0) && (i2 > -jdField_g_of_type_Int))
    {
      this.jdField_i_of_type_Int = jdField_b_of_type_Int;
      if ((!e()) || (this.jdField_e_of_type_Float <= 0.0F) || (!this.jdField_a_of_type_Smi.a()) || (paramBoolean)) {
        break label272;
      }
      this.jdField_i_of_type_Int = jdField_f_of_type_Int;
      this.jdField_a_of_type_AndroidViewView.scrollTo(0, -bdoo.b(this.jdField_j_of_type_Int));
      p();
      postInvalidate();
    }
    for (;;)
    {
      this.jdField_a_of_type_Smj.a(this.jdField_i_of_type_Int);
      return;
      if (i2 <= -jdField_g_of_type_Int)
      {
        this.jdField_i_of_type_Int = jdField_c_of_type_Int;
        break;
      }
      if ((i2 > 0) && (i2 < jdField_h_of_type_Int))
      {
        this.jdField_i_of_type_Int = jdField_d_of_type_Int;
        break;
      }
      if (i2 < jdField_h_of_type_Int) {
        break;
      }
      this.jdField_i_of_type_Int = jdField_e_of_type_Int;
      break;
      label272:
      this.jdField_a_of_type_AndroidWidgetScroller.startScroll(i1, i2, paramInt1 - i1, paramInt2 - i2, paramInt3);
      invalidate();
    }
  }
  
  private void a(FrameLayout paramFrameLayout)
  {
    if (this.jdField_d_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetFrameLayout = new FrameLayout(getContext());
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, bdoo.b(20.0F)));
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundColor(this.l);
      View localView = new View(getContext());
      int i1 = Color.parseColor("#FFB0B3BF");
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(bdoo.b(60.0F), bdoo.b(4.0F));
      localLayoutParams.gravity = 17;
      GradientDrawable localGradientDrawable = new GradientDrawable();
      localGradientDrawable.setCornerRadius(66.0F);
      localGradientDrawable.setColor(i1);
      localView.setBackgroundDrawable(localGradientDrawable);
      localView.setLayoutParams(localLayoutParams);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(localView);
      c(this.jdField_a_of_type_AndroidWidgetFrameLayout);
      paramFrameLayout.addView(this.jdField_a_of_type_AndroidWidgetFrameLayout);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_d_of_type_AndroidViewView.getParent());
    this.jdField_b_of_type_AndroidViewViewGroup.removeView(this.jdField_d_of_type_AndroidViewView);
    FrameLayout.LayoutParams localLayoutParams;
    if (this.jdField_b_of_type_Boolean)
    {
      addView(this.jdField_d_of_type_AndroidViewView);
      localLayoutParams = (FrameLayout.LayoutParams)this.jdField_d_of_type_AndroidViewView.getLayoutParams();
      if (!this.jdField_h_of_type_Boolean) {
        break label130;
      }
      localLayoutParams.height = (this.n + ImmersiveUtils.getStatusBarHeight(BaseApplication.getContext()));
      localLayoutParams.topMargin = 0;
      this.jdField_d_of_type_AndroidViewView.setPadding(0, ImmersiveUtils.getStatusBarHeight(BaseApplication.getContext()), 0, 0);
      this.jdField_d_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
    }
    for (;;)
    {
      if (paramBoolean) {
        this.jdField_a_of_type_AndroidViewView.setPadding(0, this.n, 0, 0);
      }
      this.jdField_d_of_type_AndroidViewView.setVisibility(8);
      return;
      label130:
      localLayoutParams.topMargin = ImmersiveUtils.getStatusBarHeight(BaseApplication.getContext());
      this.jdField_d_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
    }
  }
  
  private void a(boolean paramBoolean, View paramView)
  {
    paramView.setVisibility(0);
    paramView.setLayerType(2, null);
    if (paramBoolean) {}
    for (this.jdField_a_of_type_AndroidAnimationObjectAnimator = ObjectAnimator.ofFloat(paramView, View.ALPHA, new float[] { 0.0F, 1.0F });; this.jdField_a_of_type_AndroidAnimationObjectAnimator = ObjectAnimator.ofFloat(paramView, View.ALPHA, new float[] { 1.0F, 0.0F }))
    {
      this.jdField_a_of_type_AndroidAnimationObjectAnimator.addListener(new smh(this, paramView));
      this.jdField_a_of_type_AndroidAnimationObjectAnimator.setDuration(250L);
      this.jdField_a_of_type_AndroidAnimationObjectAnimator.setInterpolator(new LinearInterpolator());
      this.jdField_a_of_type_AndroidAnimationObjectAnimator.start();
      return;
    }
  }
  
  public static boolean a(Activity paramActivity)
  {
    boolean bool2 = false;
    ViewGroup localViewGroup = (ViewGroup)paramActivity.getWindow().getDecorView();
    boolean bool1 = bool2;
    int i1;
    if (localViewGroup != null) {
      i1 = 0;
    }
    for (;;)
    {
      bool1 = bool2;
      if (i1 < localViewGroup.getChildCount())
      {
        localViewGroup.getChildAt(i1).getContext().getPackageName();
        if ((localViewGroup.getChildAt(i1).getId() != -1) && ("navigationBarBackground".equals(paramActivity.getResources().getResourceEntryName(localViewGroup.getChildAt(i1).getId()))) && (localViewGroup.getChildAt(i1).getHeight() != 0)) {
          bool1 = true;
        }
      }
      else
      {
        return bool1;
      }
      i1 += 1;
    }
  }
  
  public static int b(Activity paramActivity)
  {
    if ((paramActivity != null) && (paramActivity.getWindow() != null) && (paramActivity.getWindow().getDecorView() != null))
    {
      Rect localRect = new Rect();
      paramActivity.getWindow().getDecorView().getWindowVisibleDisplayFrame(localRect);
      return localRect.height();
    }
    return 0;
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    a(true, this.jdField_c_of_type_AndroidViewView);
    l();
    if (paramInt1 != -1) {
      a(paramInt1);
    }
    if (paramInt2 != -1) {
      b(paramInt2);
    }
  }
  
  private void b(boolean paramBoolean)
  {
    if (this.jdField_d_of_type_AndroidViewView == null)
    {
      if ((this.jdField_a_of_type_AndroidWidgetFrameLayout != null) && (this.jdField_a_of_type_AndroidWidgetFrameLayout.getVisibility() != 8)) {
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
      }
      if (Build.VERSION.SDK_INT >= 21)
      {
        this.jdField_b_of_type_AndroidViewView.setOutlineProvider(null);
        this.jdField_b_of_type_AndroidViewView.setClipToOutline(false);
      }
    }
    this.jdField_c_of_type_Boolean = true;
    if ((this.jdField_d_of_type_AndroidViewView != null) && ((this.jdField_d_of_type_AndroidViewView.getAlpha() != 1.0F) || (this.jdField_d_of_type_AndroidViewView.getVisibility() != 0) || (paramBoolean)))
    {
      this.jdField_i_of_type_Boolean = false;
      if ((this.jdField_a_of_type_AndroidAnimationObjectAnimator != null) && ((!this.jdField_a_of_type_AndroidAnimationObjectAnimator.isRunning()) || (paramBoolean))) {
        a(true, this.jdField_d_of_type_AndroidViewView);
      }
    }
    r();
  }
  
  private void c(View paramView)
  {
    if ((Build.VERSION.SDK_INT >= 21) && (this.jdField_k_of_type_Int != 0))
    {
      paramView.setOutlineProvider(new CornerViewOutlineProvider(bdoo.b(this.jdField_k_of_type_Int), FlexConvertUtils.getScreenHeight(getContext()) - bdoo.b(this.jdField_j_of_type_Int), 1));
      paramView.setClipToOutline(true);
    }
  }
  
  public static boolean c()
  {
    return (Build.MANUFACTURER.contains("Xiaomi")) && ((Build.MODEL.contains("MIX 2S")) || (Build.MODEL.contains("MI 8")) || (Build.MODEL.contains("MI 9")) || (Build.MODEL.contains("MIX 2")) || (Build.MODEL.contains("MIX 3")));
  }
  
  private void d(int paramInt)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      if ((this.jdField_a_of_type_AndroidOsBundle != null) && (this.jdField_a_of_type_AndroidOsBundle.containsKey("floating_window_business"))) {
        localJSONObject.put("Float_type", this.jdField_a_of_type_AndroidOsBundle.get("floating_window_business"));
      }
      if ((this.jdField_a_of_type_AndroidOsBundle != null) && (this.jdField_a_of_type_AndroidOsBundle.containsKey("floating_window_scene"))) {
        localJSONObject.put("source", this.jdField_a_of_type_AndroidOsBundle.get("floating_window_scene"));
      }
      localJSONObject.put("type", paramInt);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    nrt.a(null, null, "0X800A9B8", "0X800A9B8", 0, 0, "", "", "", localJSONObject.toString(), false);
  }
  
  private boolean e()
  {
    return (this.jdField_i_of_type_Int == jdField_e_of_type_Int) || (this.jdField_i_of_type_Int == jdField_d_of_type_Int);
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {
      return;
    }
    if (this.jdField_i_of_type_Int == jdField_f_of_type_Int)
    {
      this.jdField_i_of_type_Int = jdField_a_of_type_Int;
      return;
    }
    int i1 = this.jdField_a_of_type_AndroidViewView.getScrollY();
    float f1 = this.jdField_a_of_type_AndroidViewVelocityTracker.getYVelocity(0);
    if (QLog.isColorLevel()) {
      QLog.d("CommonSuspensionGestureLayout", 2, "closeOrSpringBack judge deltaY:" + i1 + ",velocityY:" + f1 + ",mCanCloseFromBottom:" + this.jdField_a_of_type_JavaLangBoolean + " , mStateBottomTime " + (System.currentTimeMillis() - this.jdField_a_of_type_Long) + ", mInterceptDeltaY " + this.jdField_e_of_type_Float);
    }
    if (this.jdField_b_of_type_Boolean)
    {
      if (((i1 < -jdField_g_of_type_Int) && (f1 > -100.0F)) || ((i1 < -50) && (f1 >= 2800.0F)))
      {
        if (this.jdField_c_of_type_Boolean)
        {
          a(0, -bdoo.b(this.jdField_j_of_type_Int), 200, false);
          p();
          return;
        }
        a(i1, 1);
        return;
      }
      if (((i1 > jdField_h_of_type_Int) || (f1 < -6500.0F)) && (this.jdField_a_of_type_JavaLangBoolean.booleanValue()) && (f1 < 100.0F) && (System.currentTimeMillis() - this.jdField_a_of_type_Long >= 200L) && (this.jdField_e_of_type_Float < 0.0F) && (this.jdField_a_of_type_Smi.a()))
      {
        c(i1);
        return;
      }
      if (this.jdField_a_of_type_Smi.a()) {
        if ((this.q < 0) && (this.q > -bdoo.b(this.jdField_j_of_type_Int))) {
          if (this.q <= -bdoo.b(this.jdField_j_of_type_Int)) {}
        }
      }
      for (;;)
      {
        this.jdField_i_of_type_Int = jdField_a_of_type_Int;
        this.jdField_a_of_type_Smj.a(this.jdField_i_of_type_Int);
        return;
        a(0, -bdoo.b(this.jdField_j_of_type_Int), 200, false);
        p();
        continue;
        if ((this.q == 0) && (i1 < -bdoo.b(this.jdField_j_of_type_Int)))
        {
          a(0, -bdoo.b(this.jdField_j_of_type_Int), 200, false);
          p();
          continue;
          a(0, -bdoo.b(this.jdField_j_of_type_Int), 200, true);
        }
      }
    }
    if (((i1 < -jdField_g_of_type_Int) && (f1 > -100.0F)) || ((i1 < -50) && (f1 >= 2800.0F)))
    {
      a(i1, 1);
      return;
    }
    if (((i1 > jdField_h_of_type_Int) || (f1 < -6500.0F)) && (this.jdField_a_of_type_JavaLangBoolean.booleanValue()) && (f1 < 100.0F) && (System.currentTimeMillis() - this.jdField_a_of_type_Long >= 200L) && (this.jdField_e_of_type_Float < 0.0F) && (this.jdField_a_of_type_Smi.a()))
    {
      c(i1);
      return;
    }
    a(0, -bdoo.b(this.jdField_j_of_type_Int), 200, true);
    this.jdField_i_of_type_Int = jdField_a_of_type_Int;
    this.jdField_a_of_type_Smj.a(this.jdField_i_of_type_Int);
  }
  
  private void i()
  {
    this.jdField_c_of_type_AndroidViewView = new View(getContext());
    this.jdField_c_of_type_AndroidViewView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.jdField_c_of_type_AndroidViewView.setBackgroundColor(Color.parseColor("#66000000"));
    addView(this.jdField_c_of_type_AndroidViewView);
  }
  
  private void j()
  {
    if ((this.jdField_f_of_type_Boolean) && (this.jdField_a_of_type_AndroidWidgetLinearLayout == null))
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(getContext());
      Object localObject1 = new FrameLayout.LayoutParams(-2, -2);
      ((FrameLayout.LayoutParams)localObject1).setMargins(0, bdoo.b(40.0F), 0, 0);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(0);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130848987);
      localObject1 = new TextView(getContext());
      Object localObject2 = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject2).setMargins(bdoo.b(12.0F), 0, 0, 0);
      ((LinearLayout.LayoutParams)localObject2).gravity = 16;
      ((TextView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      ((TextView)localObject1).setTextSize(2, 14.0F);
      ((TextView)localObject1).setText("返回");
      localObject2 = new ImageView(getContext());
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams.setMargins(bdoo.b(6.0F), 0, 0, 0);
      localLayoutParams.gravity = 16;
      ((ImageView)localObject2).setLayoutParams(localLayoutParams);
      ((ImageView)localObject2).setBackgroundResource(2130848986);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject2);
      addView(this.jdField_a_of_type_AndroidWidgetLinearLayout);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(new smc(this));
    }
  }
  
  private void k()
  {
    if (this.jdField_a_of_type_AndroidViewAnimationAnimationSet == null)
    {
      this.jdField_a_of_type_AndroidViewAnimationAnimationSet = ((AnimationSet)AnimationUtils.loadAnimation(getContext(), 2130772066));
      this.jdField_a_of_type_AndroidViewAnimationAnimationSet.setDuration(200L);
      this.jdField_a_of_type_AndroidViewAnimationAnimationSet.setInterpolator(new AccelerateDecelerateInterpolator());
      this.jdField_a_of_type_AndroidViewAnimationAnimationSet.setAnimationListener(new smd(this));
    }
  }
  
  private void l()
  {
    this.jdField_a_of_type_AndroidViewViewGroup.addView(this, this.m);
  }
  
  private void m()
  {
    this.jdField_a_of_type_AndroidViewView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimationSet);
  }
  
  private void n()
  {
    b(false);
  }
  
  private void o()
  {
    if ((this.jdField_d_of_type_AndroidViewView != null) && ((this.jdField_d_of_type_AndroidViewView.getAlpha() != 1.0F) || (this.jdField_d_of_type_AndroidViewView.getVisibility() != 0)))
    {
      this.jdField_i_of_type_Boolean = false;
      if ((this.jdField_a_of_type_AndroidAnimationObjectAnimator != null) && (!this.jdField_a_of_type_AndroidAnimationObjectAnimator.isRunning()))
      {
        a();
        a(true, this.jdField_d_of_type_AndroidViewView);
      }
    }
  }
  
  private void p()
  {
    if ((this.jdField_a_of_type_AndroidWidgetFrameLayout != null) && (this.jdField_a_of_type_AndroidWidgetFrameLayout.getVisibility() != 0)) {
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
    }
    c(this.jdField_b_of_type_AndroidViewView);
    this.jdField_c_of_type_Boolean = false;
    this.jdField_i_of_type_Boolean = false;
    if ((this.jdField_d_of_type_AndroidViewView != null) && (this.jdField_d_of_type_AndroidViewView.getVisibility() != 8)) {
      this.jdField_d_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  private void q()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      if ((this.jdField_a_of_type_AndroidOsBundle != null) && (this.jdField_a_of_type_AndroidOsBundle.containsKey("floating_window_business"))) {
        localJSONObject.put("Float_type", this.jdField_a_of_type_AndroidOsBundle.get("floating_window_business"));
      }
      if ((this.jdField_a_of_type_AndroidOsBundle != null) && (this.jdField_a_of_type_AndroidOsBundle.containsKey("floating_window_scene"))) {
        localJSONObject.put("source", this.jdField_a_of_type_AndroidOsBundle.get("floating_window_scene"));
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    nrt.a(null, null, "0X800A9B6", "0X800A9B6", 0, 0, "", "", "", localJSONObject.toString(), false);
  }
  
  private void r()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      if ((this.jdField_a_of_type_AndroidOsBundle != null) && (this.jdField_a_of_type_AndroidOsBundle.containsKey("floating_window_business"))) {
        localJSONObject.put("Float_type", this.jdField_a_of_type_AndroidOsBundle.get("floating_window_business"));
      }
      if ((this.jdField_a_of_type_AndroidOsBundle != null) && (this.jdField_a_of_type_AndroidOsBundle.containsKey("floating_window_scene"))) {
        localJSONObject.put("source", this.jdField_a_of_type_AndroidOsBundle.get("floating_window_scene"));
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    nrt.a(null, null, "0X800A9B7", "0X800A9B7", 0, 0, "", "", "", localJSONObject.toString(), false);
  }
  
  public int a()
  {
    return this.n;
  }
  
  public void a()
  {
    if ((this.jdField_b_of_type_Boolean) && (this.jdField_d_of_type_AndroidViewView != null) && (this.jdField_h_of_type_Boolean) && ((this.jdField_d_of_type_AndroidViewView.getLayoutParams() instanceof FrameLayout.LayoutParams)))
    {
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.jdField_d_of_type_AndroidViewView.getLayoutParams();
      if (localLayoutParams.height != this.n + ImmersiveUtils.getStatusBarHeight(BaseApplication.getContext()))
      {
        localLayoutParams.height = (this.n + ImmersiveUtils.getStatusBarHeight(BaseApplication.getContext()));
        localLayoutParams.topMargin = 0;
        this.jdField_d_of_type_AndroidViewView.setPadding(0, ImmersiveUtils.getStatusBarHeight(BaseApplication.getContext()), 0, 0);
        this.jdField_d_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
      }
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_d_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(paramInt);
    a(this.jdField_d_of_type_AndroidViewView);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Smj.a(true, paramInt1);
      return;
    }
    if (this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation == null) {
      this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation = ((TranslateAnimation)AnimationUtils.loadAnimation(getContext(), 2130772001));
    }
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setAnimationListener(new smf(this, paramInt1, paramInt2));
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setDuration(200L);
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setInterpolator(new AccelerateInterpolator());
    this.jdField_a_of_type_AndroidViewView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation);
    a(false, this.jdField_c_of_type_AndroidViewView);
  }
  
  public void a(View paramView)
  {
    a(paramView, 0.0F);
  }
  
  public void a(View paramView, float paramFloat)
  {
    this.jdField_d_of_type_AndroidViewView = paramView;
    if ((this.jdField_d_of_type_AndroidViewView != null) && ((this.jdField_d_of_type_AndroidViewView.getParent() instanceof ViewGroup)) && (this.p != paramView.hashCode()))
    {
      this.p = paramView.hashCode();
      this.jdField_d_of_type_AndroidViewView.setVisibility(4);
      if (this.n != 0) {
        a(false);
      }
    }
    else
    {
      return;
    }
    this.n = ((int)paramFloat);
    if (this.n == 0)
    {
      this.jdField_d_of_type_AndroidViewView.post(new CommonSuspensionGestureLayout.3(this));
      return;
    }
    a(true);
  }
  
  public void a(BaseActivity paramBaseActivity, int paramInt1, int paramInt2)
  {
    a(paramBaseActivity, paramInt1, paramInt2, false);
  }
  
  public void a(BaseActivity paramBaseActivity, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramBaseActivity;
    this.jdField_a_of_type_AndroidViewView = ((ViewGroup)paramBaseActivity.getWindow().getDecorView()).getChildAt(0);
    if ((this.jdField_a_of_type_AndroidViewView.getParent() instanceof ViewGroup))
    {
      this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_AndroidViewView.getParent());
      this.m = this.jdField_a_of_type_AndroidViewViewGroup.indexOfChild(this.jdField_a_of_type_AndroidViewView);
      paramBaseActivity = new FrameLayout(getContext());
      this.jdField_a_of_type_AndroidViewViewGroup.removeView(this.jdField_a_of_type_AndroidViewView);
      paramBaseActivity.addView(this.jdField_a_of_type_AndroidViewView);
      paramBaseActivity.setBackgroundColor(0);
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView;
      this.jdField_a_of_type_AndroidViewView = paramBaseActivity;
      a(paramBaseActivity);
      addView(paramBaseActivity);
      this.jdField_a_of_type_AndroidViewView.scrollTo(0, -bdoo.b(this.jdField_j_of_type_Int));
      this.q = (-bdoo.b(this.jdField_j_of_type_Int));
      this.jdField_b_of_type_AndroidViewView.setBackgroundColor(this.l);
    }
    c(this.jdField_b_of_type_AndroidViewView);
    if ((this.jdField_b_of_type_Boolean) && (this.n != 0)) {
      this.jdField_a_of_type_AndroidViewView.setPadding(0, this.n, 0, 0);
    }
    if (this.jdField_e_of_type_Boolean)
    {
      if (paramBoolean)
      {
        ViolaSDKManager.getInstance().postOnUiThreadDelay(new CommonSuspensionGestureLayout.5(this, paramInt1, paramInt2), 150L);
        return;
      }
      b(paramInt1, paramInt2);
      m();
      return;
    }
    b(paramInt1, paramInt2);
    if (this.jdField_a_of_type_Smj != null) {
      this.jdField_a_of_type_Smj.a();
    }
    q();
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_AndroidViewView.getScrollY() >= 0;
  }
  
  public boolean a(float paramFloat, MotionEvent paramMotionEvent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CommonSuspensionGestureLayout", 2, "test isAllowedInterceptTouchEvent,positionState:" + this.jdField_a_of_type_Smi.a() + ",deltaY:" + paramFloat + ",event:" + paramMotionEvent.getAction());
    }
    if ((this.jdField_a_of_type_Smi != null) && (paramMotionEvent.getAction() != 0))
    {
      int i1 = this.jdField_a_of_type_Smi.a();
      this.jdField_a_of_type_Smj.b(i1);
      if ((i1 == 1) && (paramFloat > 5.0F)) {
        this.jdField_a_of_type_Long = 0L;
      }
      do
      {
        return true;
        if ((i1 != 2) || (paramFloat >= 0.0F) || (!this.jdField_a_of_type_JavaLangBoolean.booleanValue())) {
          break;
        }
      } while (this.jdField_a_of_type_Long != 0L);
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      return true;
      if ((!this.jdField_a_of_type_Smi.a()) && (paramFloat < -10.0F))
      {
        this.jdField_a_of_type_Long = 0L;
        return true;
      }
      this.jdField_a_of_type_Long = 0L;
      return false;
    }
    return false;
  }
  
  public void b()
  {
    a(0, 0, 100, true);
    n();
    o();
  }
  
  public void b(int paramInt)
  {
    b(this.jdField_b_of_type_AndroidViewView.findViewById(paramInt));
  }
  
  public void b(View paramView)
  {
    this.jdField_e_of_type_AndroidViewView = paramView;
    if ((this.jdField_e_of_type_AndroidViewView != null) && ((this.jdField_e_of_type_AndroidViewView.getParent() instanceof ViewGroup))) {
      this.jdField_e_of_type_AndroidViewView.post(new CommonSuspensionGestureLayout.4(this));
    }
  }
  
  public boolean b()
  {
    return this.jdField_f_of_type_Boolean;
  }
  
  public void c()
  {
    if ((this.jdField_b_of_type_AndroidViewView != null) && (this.jdField_e_of_type_AndroidViewView != null)) {
      if (this.jdField_e_of_type_AndroidViewView.getVisibility() != 8) {
        break label95;
      }
    }
    label95:
    for (int i1 = 0;; i1 = this.jdField_e_of_type_AndroidViewView.getHeight())
    {
      int i2 = i1;
      if (!this.jdField_b_of_type_Boolean)
      {
        i2 = i1;
        if (this.jdField_j_of_type_Int > 0) {
          i2 = i1 + bdoo.b(this.jdField_j_of_type_Int);
        }
      }
      this.jdField_b_of_type_AndroidViewView.setPadding(0, 0, 0, i2);
      QLog.d("CommonSuspensionGestureLayout", 1, "heightPadding " + i2);
      return;
    }
  }
  
  public void c(int paramInt)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Smj.a(false, paramInt);
      return;
    }
    if (this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation == null) {
      this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation = ((TranslateAnimation)AnimationUtils.loadAnimation(getContext(), 2130772136));
    }
    this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setAnimationListener(new smg(this, paramInt));
    this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setDuration(200L);
    this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setInterpolator(new AccelerateInterpolator());
    this.jdField_a_of_type_AndroidViewView.startAnimation(this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation);
    a(false, this.jdField_c_of_type_AndroidViewView);
  }
  
  public void computeScroll()
  {
    if (this.jdField_a_of_type_AndroidWidgetScroller == null) {
      this.jdField_a_of_type_AndroidWidgetScroller = new Scroller(this.jdField_a_of_type_AndroidContentContext);
    }
    if (this.jdField_a_of_type_AndroidViewView == null) {}
    do
    {
      return;
      if (this.jdField_a_of_type_AndroidWidgetScroller.computeScrollOffset())
      {
        if (!this.jdField_b_of_type_Boolean) {
          if (Math.abs(this.jdField_a_of_type_AndroidWidgetScroller.getCurrY()) >= bdoo.b(this.jdField_j_of_type_Int)) {}
        }
        for (;;)
        {
          postInvalidate();
          return;
          this.jdField_a_of_type_AndroidViewView.scrollTo(this.jdField_a_of_type_AndroidWidgetScroller.getCurrX(), this.jdField_a_of_type_AndroidWidgetScroller.getCurrY());
          continue;
          if ((this.jdField_a_of_type_AndroidViewView.getScrollY() <= 0) && (this.jdField_a_of_type_AndroidWidgetScroller.getCurrY() > 0))
          {
            this.jdField_a_of_type_AndroidViewView.scrollTo(this.jdField_a_of_type_AndroidWidgetScroller.getCurrX(), 0);
            n();
            o();
          }
          else
          {
            this.jdField_a_of_type_AndroidViewView.scrollTo(this.jdField_a_of_type_AndroidWidgetScroller.getCurrX(), this.jdField_a_of_type_AndroidWidgetScroller.getCurrY());
          }
        }
      }
    } while ((this.jdField_a_of_type_AndroidViewView.getScrollY() != 0) || (this.jdField_i_of_type_Int == jdField_a_of_type_Int));
    ViolaSDKManager.getInstance().postOnUiThreadDelay(new CommonSuspensionGestureLayout.6(this), 32L);
  }
  
  public void d()
  {
    d(4);
  }
  
  public boolean d()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    float f1 = 0.0F;
    if (paramMotionEvent.getAction() == 0) {
      this.q = this.jdField_a_of_type_AndroidViewView.getScrollY();
    }
    if (this.jdField_j_of_type_Boolean) {
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    if (this.jdField_a_of_type_AndroidViewVelocityTracker == null) {
      this.jdField_a_of_type_AndroidViewVelocityTracker = VelocityTracker.obtain();
    }
    this.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
    if (!this.jdField_a_of_type_Smi.a())
    {
      if ((paramMotionEvent.getAction() != 0) && (paramMotionEvent.getAction() != 2))
      {
        this.jdField_a_of_type_AndroidViewVelocityTracker.computeCurrentVelocity(1000);
        f1 = this.jdField_a_of_type_AndroidViewVelocityTracker.getYVelocity(0);
        if ((this.jdField_a_of_type_AndroidViewView.getScrollY() != -bdoo.b(this.jdField_j_of_type_Int)) && (f1 < 0.0F)) {
          a(0, -bdoo.b(this.jdField_j_of_type_Int), 200, false);
        }
      }
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    if ((this.jdField_b_of_type_Boolean) && (paramMotionEvent.getAction() != 0))
    {
      if (this.q >= 0) {
        break label416;
      }
      if (paramMotionEvent.getAction() != 2) {
        break label339;
      }
      if ((this.jdField_a_of_type_AndroidViewView.getScrollY() < 0) && (paramMotionEvent.getRawY() <= Math.abs(this.jdField_a_of_type_AndroidViewView.getScrollY()))) {
        return super.dispatchTouchEvent(paramMotionEvent);
      }
      if (this.jdField_b_of_type_Float != 0.0F) {
        f1 = paramMotionEvent.getRawY() - this.jdField_b_of_type_Float;
      }
      this.jdField_a_of_type_Float = f1;
      if (this.jdField_a_of_type_Float < -3.0F)
      {
        i1 = (int)(this.jdField_a_of_type_AndroidViewView.getScrollY() - this.jdField_a_of_type_Float);
        if (i1 >= 0) {
          break label328;
        }
        a(0, i1, 0, true);
        if ((this.jdField_d_of_type_AndroidViewView != null) && (this.jdField_d_of_type_AndroidViewView.getVisibility() != 0) && (Math.abs(this.jdField_a_of_type_AndroidViewView.getScrollY()) <= this.n)) {
          o();
        }
      }
    }
    label328:
    label339:
    while ((!this.jdField_c_of_type_Boolean) || (this.jdField_i_of_type_Boolean) || (this.jdField_d_of_type_AndroidViewView == null)) {
      for (;;)
      {
        int i1;
        this.jdField_b_of_type_Float = paramMotionEvent.getRawY();
        return super.dispatchTouchEvent(paramMotionEvent);
        a(0, 0, 0, true);
        continue;
        this.jdField_a_of_type_AndroidViewVelocityTracker.computeCurrentVelocity(1000);
        f1 = this.jdField_a_of_type_AndroidViewVelocityTracker.getYVelocity(0);
        if (Math.abs(this.jdField_a_of_type_AndroidViewView.getScrollY()) <= this.n) {
          b();
        } else if ((f1 < 0.0F) && (Math.abs(f1) >= 3500.0F) && (this.jdField_i_of_type_Int != jdField_f_of_type_Int)) {
          b();
        }
      }
    }
    label416:
    if (this.jdField_b_of_type_Float != 0.0F) {}
    for (f1 = paramMotionEvent.getRawY() - this.jdField_b_of_type_Float;; f1 = 0.0F)
    {
      this.jdField_a_of_type_Float = f1;
      if ((this.jdField_a_of_type_AndroidViewView.getScrollY() >= 0) || (this.jdField_a_of_type_Float <= 0.0F)) {
        break;
      }
      this.jdField_i_of_type_Boolean = true;
      a(false, this.jdField_d_of_type_AndroidViewView);
      break;
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_AndroidViewView$OnLayoutChangeListener != null) {
      removeOnLayoutChangeListener(this.jdField_a_of_type_AndroidViewView$OnLayoutChangeListener);
    }
  }
  
  public void f()
  {
    this.jdField_j_of_type_Boolean = true;
    this.jdField_k_of_type_Boolean = this.jdField_b_of_type_Boolean;
    this.jdField_b_of_type_Boolean = true;
    b();
  }
  
  public void g()
  {
    this.jdField_j_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = this.jdField_k_of_type_Boolean;
    if (!this.jdField_b_of_type_Boolean)
    {
      a(0, -bdoo.b(this.jdField_j_of_type_Int), 200, false);
      p();
    }
  }
  
  protected void onDetachedFromWindow()
  {
    if (this.jdField_a_of_type_AndroidViewVelocityTracker != null) {
      this.jdField_a_of_type_AndroidViewVelocityTracker.recycle();
    }
    e();
    super.onDetachedFromWindow();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    float f1 = 0.0F;
    if ((this.jdField_a_of_type_AndroidViewView == null) || (this.jdField_j_of_type_Boolean)) {
      return false;
    }
    if (this.jdField_d_of_type_Float != 0.0F) {
      f1 = paramMotionEvent.getRawY() - this.jdField_d_of_type_Float;
    }
    this.jdField_e_of_type_Float = f1;
    this.jdField_c_of_type_Float = paramMotionEvent.getRawX();
    this.jdField_d_of_type_Float = paramMotionEvent.getRawY();
    return a(this.jdField_e_of_type_Float, paramMotionEvent);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((this.jdField_a_of_type_AndroidViewView == null) || (paramMotionEvent.getAction() == 0)) {
      return false;
    }
    if ((this.jdField_a_of_type_AndroidViewView.getScrollY() < 0) && (paramMotionEvent.getRawY() <= Math.abs(this.jdField_a_of_type_AndroidViewView.getScrollY())) && (this.jdField_a_of_type_AndroidViewView.getScrollY() >= -bdoo.b(this.jdField_j_of_type_Int))) {
      return false;
    }
    if (this.jdField_a_of_type_AndroidViewVelocityTracker == null) {
      this.jdField_a_of_type_AndroidViewVelocityTracker = VelocityTracker.obtain();
    }
    this.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
    float f1;
    if (this.jdField_d_of_type_Float != 0.0F)
    {
      f1 = paramMotionEvent.getRawY() - this.jdField_d_of_type_Float;
      this.jdField_c_of_type_Float = paramMotionEvent.getRawX();
      this.jdField_d_of_type_Float = paramMotionEvent.getRawY();
      switch (paramMotionEvent.getAction())
      {
      default: 
        this.jdField_a_of_type_AndroidViewVelocityTracker.computeCurrentVelocity(1000);
        f1 = this.jdField_a_of_type_AndroidViewVelocityTracker.getYVelocity(0);
        if ((!this.jdField_a_of_type_Smi.a()) && (this.jdField_a_of_type_AndroidViewView.getScrollY() != -bdoo.b(this.jdField_j_of_type_Int)) && (f1 < 0.0F)) {
          a(0, -bdoo.b(this.jdField_j_of_type_Int), 200, false);
        }
        break;
      }
    }
    for (;;)
    {
      return true;
      f1 = 0.0F;
      break;
      int i1 = (int)(this.jdField_a_of_type_AndroidViewView.getScrollY() - f1);
      if (this.jdField_a_of_type_Smi.a()) {
        a(0, i1, 0, false);
      }
      for (;;)
      {
        return true;
        if (i1 <= this.q) {
          a(0, i1, 0, false);
        }
      }
      if (this.jdField_b_of_type_Boolean)
      {
        if (paramMotionEvent.getRawY() >= Math.abs(this.jdField_a_of_type_AndroidViewView.getScrollY()) + Math.abs(this.jdField_a_of_type_AndroidViewView.getPaddingTop())) {
          h();
        } else if (this.jdField_a_of_type_AndroidViewView.getScrollY() != 0) {
          a(0, 2);
        }
      }
      else {
        h();
      }
    }
  }
  
  public void setBorderRadius(int paramInt)
  {
    this.jdField_k_of_type_Int = paramInt;
  }
  
  public void setCanCloseFromBottom(boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(paramBoolean);
  }
  
  public void setContainerColor(int paramInt)
  {
    this.l = paramInt;
  }
  
  public void setContentMarginTop(int paramInt)
  {
    this.jdField_j_of_type_Int = paramInt;
  }
  
  public void setContentScrollListener(smi paramsmi)
  {
    this.jdField_a_of_type_Smi = paramsmi;
  }
  
  public void setIsAutoSuctionTop(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void setIsNeedInterruptBack(boolean paramBoolean)
  {
    this.jdField_g_of_type_Boolean = paramBoolean;
  }
  
  public void setIsNeedPopAnim(boolean paramBoolean)
  {
    this.jdField_e_of_type_Boolean = paramBoolean;
  }
  
  public void setIsNeedShowBackView(boolean paramBoolean)
  {
    this.jdField_f_of_type_Boolean = paramBoolean;
    if (!this.jdField_f_of_type_Boolean)
    {
      if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      }
      return;
    }
    j();
  }
  
  public void setIsShowGrayBar(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public void setIsStatusImmersive(boolean paramBoolean)
  {
    this.jdField_h_of_type_Boolean = paramBoolean;
  }
  
  public void setIsUseDefaultAnim(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setMaskBackGroundDrawable(Drawable paramDrawable)
  {
    if ((this.jdField_a_of_type_AndroidAppActivity != null) && (this.jdField_a_of_type_AndroidAppActivity.getWindow() != null)) {
      this.jdField_a_of_type_AndroidAppActivity.getWindow().setBackgroundDrawable(paramDrawable);
    }
  }
  
  public void setTitleBarHeight(int paramInt)
  {
    this.n = bdoo.b(paramInt);
  }
  
  public void setViolaGestureListener(smj paramsmj)
  {
    this.jdField_a_of_type_Smj = paramsmj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.CommonSuspensionGestureLayout
 * JD-Core Version:    0.7.0.1
 */