package com.tencent.mobileqq.activity.recent;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Scroller;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.widget.RandomCoverView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import xgw;

public class DrawerFrame
  extends FrameLayout
  implements Handler.Callback
{
  public static int a;
  public static final boolean a;
  private final float jdField_a_of_type_Float = 0.8F;
  private VelocityTracker jdField_a_of_type_AndroidViewVelocityTracker;
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private Scroller jdField_a_of_type_AndroidWidgetScroller;
  private DrawerFrame.IDrawerCallbacks jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame$IDrawerCallbacks;
  private FrameHelperActivity jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity;
  private WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler;
  private StringBuilder jdField_a_of_type_JavaLangStringBuilder;
  private final float jdField_b_of_type_Float = 0.7F;
  private int jdField_b_of_type_Int;
  private View jdField_b_of_type_AndroidViewView;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  public boolean b;
  private final float jdField_c_of_type_Float = 0.4F;
  private int jdField_c_of_type_Int;
  private View jdField_c_of_type_AndroidViewView;
  private ViewGroup jdField_c_of_type_AndroidViewViewGroup;
  private boolean jdField_c_of_type_Boolean = true;
  private int jdField_d_of_type_Int;
  private ViewGroup jdField_d_of_type_AndroidViewViewGroup;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int;
  private boolean jdField_e_of_type_Boolean;
  private int jdField_f_of_type_Int;
  private boolean jdField_f_of_type_Boolean;
  private int jdField_g_of_type_Int;
  private boolean jdField_g_of_type_Boolean = true;
  private int jdField_h_of_type_Int;
  private boolean jdField_h_of_type_Boolean = true;
  private int i;
  private int j;
  private int k;
  private int l;
  private int m;
  private int n;
  private int o;
  private int p;
  private int q;
  private int r = 0;
  private int s = -1;
  private int t;
  
  static
  {
    jdField_a_of_type_Boolean = QLog.isDevelopLevel();
    jdField_a_of_type_Int = 0;
  }
  
  public DrawerFrame(Context paramContext, ViewGroup paramViewGroup1, ViewGroup paramViewGroup2, View paramView, ViewGroup paramViewGroup3, FrameHelperActivity paramFrameHelperActivity)
  {
    super(paramContext);
    this.jdField_b_of_type_Boolean = true;
    if (paramContext == null) {
      throw new NullPointerException("context is null");
    }
    Resources localResources = paramContext.getResources();
    DisplayMetrics localDisplayMetrics = localResources.getDisplayMetrics();
    this.o = 0;
    this.i = ((int)(localDisplayMetrics.density * 100.0F + 0.5D));
    this.k = localResources.getDimensionPixelSize(2131558887);
    this.jdField_d_of_type_Int = localResources.getDimensionPixelSize(2131558956);
    this.j = 0;
    if (Build.VERSION.SDK_INT >= 11) {
      bool = true;
    }
    this.jdField_g_of_type_Boolean = bool;
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_AndroidWidgetScroller = new Scroller(paramContext, new DrawerFrame.SmoothInterpolator());
    if ((paramContext instanceof Activity)) {}
    for (this.s = DeviceInfoUtil.a((Activity)paramContext);; this.s = paramContext.getResources().getConfiguration().orientation)
    {
      if (jdField_a_of_type_Boolean) {
        a("DrawerFrame", null);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity = paramFrameHelperActivity;
      a(paramViewGroup1, paramViewGroup2, paramView, paramViewGroup3);
      b(this.r, 1);
      return;
    }
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    this.o = 2;
    if (!this.jdField_d_of_type_Boolean)
    {
      b(paramInt, paramBoolean);
      return;
    }
    a(paramBoolean);
  }
  
  private void a(String paramString, Object paramObject)
  {
    if (QLog.isDevelopLevel())
    {
      if (this.jdField_a_of_type_JavaLangStringBuilder != null) {
        break label142;
      }
      this.jdField_a_of_type_JavaLangStringBuilder = new StringBuilder(120);
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaLangStringBuilder.append(paramString).append(", mConfigurationFlag = ").append(this.t).append(", mCurOrientation = ").append(this.s).append(", mDecorOffsetX = ").append(this.jdField_b_of_type_Int).append(", mLeftDrawerWidth = ").append(this.jdField_c_of_type_Int).append(", mConfigurationFlag = ").append(this.t).append(", mWidth = ").append(this.p).append(", mHeight =").append(this.q).append(", param = ").append(paramObject);
      QLog.i("DrawerFrame", 4, this.jdField_a_of_type_JavaLangStringBuilder.toString());
      return;
      label142:
      this.jdField_a_of_type_JavaLangStringBuilder.setLength(0);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    ApngImage.pauseByTag(1);
    if (!d()) {
      return;
    }
    Scroller localScroller;
    int i2;
    int i3;
    if (this.jdField_e_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(1);
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(2);
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(4);
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(3);
      this.jdField_e_of_type_Boolean = true;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame$IDrawerCallbacks != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame$IDrawerCallbacks.a(this.r);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame$IDrawerCallbacks != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame$IDrawerCallbacks.a(this.r, false);
      }
      localScroller = this.jdField_a_of_type_AndroidWidgetScroller;
      i2 = this.jdField_b_of_type_Int;
      i3 = -this.jdField_b_of_type_Int;
      if (!paramBoolean) {
        break label152;
      }
    }
    label152:
    for (int i1 = 300;; i1 = 0)
    {
      localScroller.startScroll(i2, 0, i3, 0, i1);
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(2);
      return;
      if (this.jdField_d_of_type_Boolean) {
        break;
      }
      return;
    }
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    int i2 = 0;
    int i1;
    if (paramInt2 == 1)
    {
      i1 = 8;
      if ((this.jdField_d_of_type_AndroidViewViewGroup != null) && (this.jdField_d_of_type_AndroidViewViewGroup.getVisibility() != i1)) {
        this.jdField_d_of_type_AndroidViewViewGroup.setVisibility(i1);
      }
      if ((paramInt2 != 1) && (paramInt1 != 1)) {
        break label197;
      }
      i1 = 8;
      label50:
      if ((this.jdField_c_of_type_AndroidViewViewGroup != null) && (this.jdField_c_of_type_AndroidViewViewGroup.getVisibility() != i1)) {
        this.jdField_c_of_type_AndroidViewViewGroup.setVisibility(i1);
      }
      if ((paramInt2 != 1) && (paramInt1 != 0)) {
        break label202;
      }
      paramInt1 = 8;
      label88:
      if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewView.getVisibility() != paramInt1)) {
        this.jdField_a_of_type_AndroidViewView.setVisibility(paramInt1);
      }
      if ((paramInt2 != 2) && (paramInt2 != 0)) {
        break label207;
      }
      paramInt1 = 0;
      label125:
      if ((this.jdField_b_of_type_AndroidViewView != null) && (this.jdField_b_of_type_AndroidViewView.getVisibility() != paramInt1) && (this.jdField_h_of_type_Boolean)) {
        this.jdField_b_of_type_AndroidViewView.setVisibility(paramInt1);
      }
      if (paramInt2 != 0) {
        break label213;
      }
    }
    label197:
    label202:
    label207:
    label213:
    for (paramInt1 = i2;; paramInt1 = 8)
    {
      if ((this.jdField_c_of_type_AndroidViewView != null) && (this.jdField_c_of_type_AndroidViewView.getVisibility() != paramInt1)) {
        this.jdField_c_of_type_AndroidViewView.setVisibility(paramInt1);
      }
      return;
      i1 = 0;
      break;
      i1 = 0;
      break label50;
      paramInt1 = 0;
      break label88;
      paramInt1 = 8;
      break label125;
    }
  }
  
  private void b(int paramInt, boolean paramBoolean)
  {
    int i1 = 300;
    if (!d()) {
      return;
    }
    this.r = paramInt;
    if (this.jdField_e_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(1);
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(2);
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(4);
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(3);
      label56:
      if (this.r != 0) {
        break label156;
      }
      this.jdField_c_of_type_AndroidViewViewGroup.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_e_of_type_Boolean = true;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame$IDrawerCallbacks != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame$IDrawerCallbacks.a(this.r);
      }
      switch (paramInt)
      {
      default: 
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame$IDrawerCallbacks != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame$IDrawerCallbacks.a(paramInt, true);
        }
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(1);
        return;
        if (!this.jdField_d_of_type_Boolean) {
          break label56;
        }
        return;
        label156:
        if (this.r == 1) {
          this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        }
        break;
      }
    }
    Scroller localScroller = this.jdField_a_of_type_AndroidWidgetScroller;
    int i2 = this.jdField_b_of_type_Int;
    int i3 = this.jdField_c_of_type_Int;
    int i4 = this.jdField_b_of_type_Int;
    if (paramBoolean) {}
    for (;;)
    {
      localScroller.startScroll(i2, 0, i3 - i4, 0, i1);
      break;
      i1 = 1;
    }
    localScroller = this.jdField_a_of_type_AndroidWidgetScroller;
    i2 = this.jdField_b_of_type_Int;
    i3 = -this.jdField_d_of_type_Int;
    i4 = this.jdField_b_of_type_Int;
    if (paramBoolean) {}
    for (;;)
    {
      localScroller.startScroll(i2, 0, i3 - i4, 0, i1);
      break;
      i1 = 1;
    }
  }
  
  private boolean d()
  {
    return (this.jdField_c_of_type_Boolean) && (this.jdField_c_of_type_AndroidViewViewGroup != null) && (this.jdField_a_of_type_AndroidViewViewGroup != null);
  }
  
  private boolean e()
  {
    if ((this.s == 1) && (this.p > this.q)) {}
    while ((this.s == 0) && (this.p < this.q)) {
      return false;
    }
    return true;
  }
  
  public int a()
  {
    return this.i;
  }
  
  public void a()
  {
    if (this.jdField_b_of_type_AndroidViewView != null) {
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    }
    this.jdField_h_of_type_Boolean = false;
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity != null) && (this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.getActivity() != null) && (this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.getActivity().getAppInterface() != null))
    {
      if (ThemeUtil.isDefaultOrDIYTheme(false)) {
        this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.a(paramInt, true);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.a(paramInt, false);
  }
  
  @TargetApi(11)
  protected void a(int paramInt1, int paramInt2)
  {
    b(paramInt1, 2);
    float f1;
    float f2;
    label42:
    Object localObject;
    if (Build.VERSION.SDK_INT >= 11)
    {
      if (paramInt1 != 0) {
        break label147;
      }
      f1 = paramInt2 / this.jdField_c_of_type_Int;
      if (paramInt1 != 0) {
        break label160;
      }
      f2 = this.i * (f1 - 1.0F);
      if (paramInt1 != 0) {
        break label175;
      }
      localObject = this.jdField_c_of_type_AndroidViewViewGroup;
      label52:
      if (localObject != null) {
        ((View)localObject).setTranslationX(f2);
      }
      if (this.jdField_d_of_type_AndroidViewViewGroup != null) {
        this.jdField_d_of_type_AndroidViewViewGroup.setTranslationX(f2);
      }
      if ((this.jdField_b_of_type_AndroidViewView != null) && (this.jdField_h_of_type_Boolean))
      {
        if (f1 <= 0.6F) {
          break label184;
        }
        a(2131494229);
      }
    }
    for (;;)
    {
      if (Build.VERSION.SDK_INT >= 11) {
        this.jdField_b_of_type_AndroidViewView.setAlpha(f1);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame$IDrawerCallbacks != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame$IDrawerCallbacks.a(this.r, f1);
      }
      return;
      label147:
      f1 = -paramInt2 / this.jdField_d_of_type_Int;
      break;
      label160:
      f2 = -this.i * (f1 - 1.0F);
      break label42;
      label175:
      localObject = this.jdField_a_of_type_AndroidViewView;
      break label52;
      label184:
      a(2131494247);
    }
  }
  
  public void a(ViewGroup paramViewGroup1, ViewGroup paramViewGroup2, View paramView, ViewGroup paramViewGroup3)
  {
    int i1 = ((WindowManager)getContext().getSystemService("window")).getDefaultDisplay().getWidth();
    if (paramViewGroup3 != this.jdField_d_of_type_AndroidViewViewGroup)
    {
      if (this.jdField_d_of_type_AndroidViewViewGroup != null) {
        removeView(this.jdField_d_of_type_AndroidViewViewGroup);
      }
      this.jdField_d_of_type_AndroidViewViewGroup = paramViewGroup3;
      if (this.jdField_d_of_type_AndroidViewViewGroup != null)
      {
        paramViewGroup3 = (RandomCoverView)this.jdField_d_of_type_AndroidViewViewGroup.findViewById(2131371199);
        if (paramViewGroup3 != null)
        {
          RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramViewGroup3.getLayoutParams();
          localLayoutParams.width = (i1 - b());
          localLayoutParams.height = ((int)(localLayoutParams.width / 1.44D));
          if (QLog.isColorLevel()) {
            QLog.d("DrawerFrame", 2, "currentHeaderLayout height:" + localLayoutParams.height + "screenHeight:" + ScreenUtil.jdField_b_of_type_Int);
          }
          paramViewGroup3.setLayoutParams(localLayoutParams);
          paramViewGroup3.setDefaultCoverBg();
        }
        paramViewGroup3 = new FrameLayout.LayoutParams(-1, -1);
        addView(this.jdField_d_of_type_AndroidViewViewGroup, paramViewGroup3);
      }
    }
    if (paramViewGroup2 != this.jdField_c_of_type_AndroidViewViewGroup)
    {
      if (this.jdField_c_of_type_AndroidViewViewGroup != null) {
        removeView(this.jdField_c_of_type_AndroidViewViewGroup);
      }
      this.jdField_c_of_type_AndroidViewViewGroup = paramViewGroup2;
      if (this.jdField_c_of_type_AndroidViewViewGroup != null)
      {
        paramViewGroup2 = this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131364033);
        if (paramViewGroup2 != null)
        {
          paramViewGroup3 = (RelativeLayout.LayoutParams)paramViewGroup2.getLayoutParams();
          paramViewGroup3.height = ((int)((i1 - b()) / 1.44D));
          paramViewGroup2.setLayoutParams(paramViewGroup3);
        }
        paramViewGroup2 = new FrameLayout.LayoutParams(-1, -1, 19);
        addView(this.jdField_c_of_type_AndroidViewViewGroup, paramViewGroup2);
      }
    }
    if (paramView != this.jdField_a_of_type_AndroidViewView)
    {
      if (this.jdField_a_of_type_AndroidViewView != null) {
        removeView(this.jdField_a_of_type_AndroidViewView);
      }
      this.jdField_a_of_type_AndroidViewView = paramView;
      if (this.jdField_a_of_type_AndroidViewView != null)
      {
        paramViewGroup2 = new FrameLayout.LayoutParams(-2, -1, 21);
        addView(this.jdField_a_of_type_AndroidViewView, paramViewGroup2);
      }
    }
    if (paramViewGroup1 != this.jdField_a_of_type_AndroidViewViewGroup)
    {
      if (this.jdField_a_of_type_AndroidViewViewGroup != null)
      {
        removeView(this.jdField_a_of_type_AndroidViewViewGroup);
        if (this.jdField_b_of_type_AndroidViewViewGroup != null)
        {
          this.jdField_b_of_type_AndroidViewViewGroup.removeView(this);
          this.jdField_b_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_AndroidViewViewGroup);
          this.jdField_b_of_type_AndroidViewViewGroup.setOnClickListener(null);
          this.jdField_b_of_type_AndroidViewViewGroup = null;
        }
      }
      this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup1;
      AccessibilityUtil.b(this.jdField_a_of_type_AndroidViewViewGroup, true);
      if (this.jdField_a_of_type_AndroidViewViewGroup != null)
      {
        paramViewGroup1 = this.jdField_a_of_type_AndroidViewViewGroup.getParent();
        if (!(paramViewGroup1 instanceof ViewGroup)) {
          break label730;
        }
        this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)paramViewGroup1);
        this.jdField_b_of_type_AndroidViewViewGroup.removeView(this.jdField_a_of_type_AndroidViewViewGroup);
        paramViewGroup1 = new FrameLayout.LayoutParams(-1, -1);
        addView(this.jdField_a_of_type_AndroidViewViewGroup, paramViewGroup1);
      }
      if ((this.jdField_c_of_type_AndroidViewViewGroup == null) || (!this.jdField_g_of_type_Boolean)) {
        break label755;
      }
      if (this.jdField_b_of_type_AndroidViewView == null)
      {
        this.jdField_b_of_type_AndroidViewView = new View(getContext());
        this.jdField_b_of_type_AndroidViewView.setBackgroundColor(1711276032);
      }
      if (!ThemeUtil.isDefaultOrDIYTheme(false)) {
        break label738;
      }
      this.jdField_h_of_type_Boolean = true;
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      label561:
      paramViewGroup1 = new FrameLayout.LayoutParams(-1, -1);
      if (this.jdField_a_of_type_AndroidViewViewGroup != null) {
        this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_b_of_type_AndroidViewView, paramViewGroup1);
      }
    }
    for (;;)
    {
      if (this.jdField_b_of_type_AndroidViewViewGroup != null)
      {
        this.jdField_b_of_type_AndroidViewViewGroup.addView(this);
        this.jdField_b_of_type_AndroidViewViewGroup.setOnClickListener(new xgw(this));
      }
      if ((this.jdField_c_of_type_AndroidViewViewGroup != null) && (this.jdField_c_of_type_AndroidViewView == null))
      {
        this.jdField_c_of_type_AndroidViewView = new View(getContext());
        this.jdField_c_of_type_AndroidViewView.setFocusable(true);
        this.jdField_c_of_type_AndroidViewView.setFocusableInTouchMode(true);
        this.jdField_c_of_type_AndroidViewView.setClickable(true);
        this.jdField_c_of_type_AndroidViewView.setVisibility(8);
        this.jdField_c_of_type_AndroidViewView.setBackgroundResource(17170445);
        this.jdField_c_of_type_AndroidViewView.setContentDescription("返回 按钮");
        paramViewGroup1 = new FrameLayout.LayoutParams(this.jdField_c_of_type_Int, this.l, 21);
        addView(this.jdField_c_of_type_AndroidViewView, paramViewGroup1);
      }
      return;
      label730:
      this.jdField_b_of_type_AndroidViewViewGroup = null;
      break;
      label738:
      this.jdField_h_of_type_Boolean = false;
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      break label561;
      label755:
      if ((this.jdField_b_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewViewGroup != null)) {
        this.jdField_a_of_type_AndroidViewViewGroup.removeView(this.jdField_b_of_type_AndroidViewView);
      }
    }
  }
  
  public boolean a()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public int b()
  {
    this.k = getContext().getResources().getDimensionPixelSize(2131558887);
    return this.k;
  }
  
  public void b()
  {
    if (this.jdField_b_of_type_AndroidViewView != null) {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    }
    this.jdField_h_of_type_Boolean = true;
  }
  
  public boolean b()
  {
    return this.jdField_d_of_type_Boolean;
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.i("DrawerFrame", 2, "stopMovingOnPause");
    }
    if (this.r == 0)
    {
      if (this.jdField_b_of_type_Int > this.p / 2.0D)
      {
        this.jdField_d_of_type_Boolean = false;
        f();
        return;
      }
      this.jdField_d_of_type_Boolean = true;
      i();
      return;
    }
    if (this.jdField_b_of_type_Int < -(this.jdField_d_of_type_Int / 3.0D * 2.0D))
    {
      this.jdField_d_of_type_Boolean = false;
      g();
      return;
    }
    this.jdField_d_of_type_Boolean = true;
    i();
  }
  
  public boolean c()
  {
    return this.jdField_e_of_type_Boolean;
  }
  
  public void d()
  {
    a(0, true);
  }
  
  public void e()
  {
    a(1, true);
  }
  
  public void f()
  {
    b(0, true);
  }
  
  public void g()
  {
    b(1, true);
  }
  
  public void h()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("DrawerFrame", 4, "resetDrawer()");
    }
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(1);
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(2);
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(4);
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(3);
    this.jdField_e_of_type_Boolean = false;
    this.r = 0;
    this.jdField_b_of_type_Int = 0;
    if (this.jdField_a_of_type_AndroidViewViewGroup != null) {
      this.jdField_a_of_type_AndroidViewViewGroup.offsetLeftAndRight(0 - this.jdField_a_of_type_AndroidViewViewGroup.getLeft());
    }
    a(this.r, this.jdField_b_of_type_Int);
    postInvalidate();
    if (this.jdField_d_of_type_Boolean)
    {
      this.jdField_d_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(4);
    }
    b(this.r, 1);
    jdField_a_of_type_Int = 0;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i1 = 0;
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return true;
                boolean bool = this.jdField_a_of_type_AndroidWidgetScroller.computeScrollOffset();
                i1 = this.jdField_a_of_type_AndroidWidgetScroller.getCurrX();
                int i2 = this.jdField_b_of_type_Int;
                this.jdField_b_of_type_Int = this.jdField_a_of_type_AndroidWidgetScroller.getCurrX();
                if (this.jdField_a_of_type_AndroidViewViewGroup != null)
                {
                  this.jdField_a_of_type_AndroidViewViewGroup.offsetLeftAndRight(i1 - i2);
                  a(this.r, this.jdField_b_of_type_Int);
                }
                postInvalidate();
                if (!bool)
                {
                  this.jdField_e_of_type_Boolean = false;
                  this.jdField_d_of_type_Boolean = true;
                  this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(3);
                  return true;
                }
                this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(1);
                return true;
                bool = this.jdField_a_of_type_AndroidWidgetScroller.computeScrollOffset();
                i1 = this.jdField_a_of_type_AndroidWidgetScroller.getCurrX();
                i2 = this.jdField_b_of_type_Int;
                this.jdField_b_of_type_Int = this.jdField_a_of_type_AndroidWidgetScroller.getCurrX();
                if (this.jdField_a_of_type_AndroidViewViewGroup != null)
                {
                  this.jdField_a_of_type_AndroidViewViewGroup.offsetLeftAndRight(i1 - i2);
                  a(this.r, this.jdField_b_of_type_Int);
                }
                postInvalidate();
                if (!bool)
                {
                  this.jdField_e_of_type_Boolean = false;
                  this.jdField_d_of_type_Boolean = false;
                  if (this.jdField_c_of_type_AndroidViewViewGroup != null) {
                    this.jdField_c_of_type_AndroidViewViewGroup.setVisibility(8);
                  }
                  if (this.jdField_a_of_type_AndroidViewView != null) {
                    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
                  }
                  this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(4);
                  return true;
                }
                this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(2);
                return true;
              } while (this.jdField_e_of_type_Boolean);
              AccessibilityUtil.b(this.jdField_a_of_type_AndroidViewViewGroup, true);
              if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame$IDrawerCallbacks != null) {
                this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame$IDrawerCallbacks.b(this.r, this.o);
              }
              this.o = 0;
              this.r = 0;
              b(this.r, 1);
            } while (!(BaseActivity.sTopActivity instanceof FragmentActivity));
            paramMessage = ((FragmentActivity)BaseActivity.sTopActivity).getSupportFragmentManager().findFragmentByTag(MainFragment.class.getName());
          } while (paramMessage == null);
          i1 = ((MainFragment)paramMessage).a();
          if (i1 == MainFragment.jdField_a_of_type_Int)
          {
            ApngImage.playByTag(2);
            return true;
          }
          if (i1 == MainFragment.jdField_c_of_type_Int)
          {
            ApngImage.playByTag(3);
            return true;
          }
          if (i1 == MainFragment.jdField_d_of_type_Int)
          {
            ApngImage.playByTag(4);
            return true;
          }
          if (i1 == MainFragment.jdField_f_of_type_Int)
          {
            ApngImage.playByTag(5);
            return true;
          }
        } while (i1 != MainFragment.jdField_g_of_type_Int);
        ApngImage.playByTag(8);
        return true;
      } while (this.jdField_e_of_type_Boolean);
      AccessibilityUtil.b(this.jdField_a_of_type_AndroidViewViewGroup, false);
      b(this.r, 0);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame$IDrawerCallbacks != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame$IDrawerCallbacks.a(this.r, this.o);
      }
      this.o = 0;
      ApngImage.playByTag(1);
      return true;
    } while (!b());
    if (this.r == 0)
    {
      i1 = this.jdField_c_of_type_Int - this.jdField_b_of_type_Int;
      this.jdField_b_of_type_Int = this.jdField_c_of_type_Int;
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_AndroidViewViewGroup != null) && (i1 != 0))
      {
        this.jdField_a_of_type_AndroidViewViewGroup.offsetLeftAndRight(i1);
        a(this.r, this.jdField_b_of_type_Int);
        postInvalidate();
      }
      if (!jdField_a_of_type_Boolean) {
        break;
      }
      a("MSG_CONFIGURATION_CHANGED", Integer.valueOf(i1));
      return true;
      if (this.r == 1)
      {
        i1 = -this.jdField_d_of_type_Int - this.jdField_b_of_type_Int;
        this.jdField_b_of_type_Int = (-this.jdField_d_of_type_Int);
      }
    }
  }
  
  public void i()
  {
    a(true);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    if (paramConfiguration.orientation != this.s)
    {
      this.s = paramConfiguration.orientation;
      if ((b()) && (this.t == 0)) {
        this.t = 1;
      }
      if (jdField_a_of_type_Boolean) {
        a("onConfigurationChanged", Boolean.valueOf(b()));
      }
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool2;
    if (!d()) {
      bool2 = bool1;
    }
    int i1;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return bool2;
              bool2 = bool1;
            } while (!this.jdField_b_of_type_Boolean);
            i1 = ViewConfiguration.get(getContext()).getScaledTouchSlop();
            i2 = (int)(paramMotionEvent.getX() + 0.5F);
            i3 = (int)(paramMotionEvent.getY() + 0.5F);
            switch (paramMotionEvent.getAction() & 0xFF)
            {
            default: 
              return false;
            case 0: 
              this.jdField_f_of_type_Int = i2;
              this.jdField_e_of_type_Int = i2;
              this.jdField_h_of_type_Int = i3;
              this.jdField_g_of_type_Int = i3;
              if ((!this.jdField_d_of_type_Boolean) || (this.jdField_e_of_type_Int > this.j)) {
                this.jdField_f_of_type_Boolean = true;
              }
              bool2 = bool1;
            }
          } while (!this.jdField_e_of_type_Boolean);
          if ((this.r == 0) && (this.jdField_e_of_type_Int > this.jdField_b_of_type_Int)) {
            break;
          }
          bool2 = bool1;
        } while (this.r != 1);
        bool2 = bool1;
      } while (this.jdField_e_of_type_Int >= this.p + this.jdField_b_of_type_Int);
      this.jdField_f_of_type_Boolean = true;
      return true;
      bool2 = bool1;
    } while (!this.jdField_f_of_type_Boolean);
    if ((!this.jdField_d_of_type_Boolean) && ((i2 < this.jdField_f_of_type_Int) || (i2 < this.jdField_e_of_type_Int)))
    {
      this.jdField_f_of_type_Boolean = false;
      return false;
    }
    this.jdField_f_of_type_Int = i2;
    this.jdField_h_of_type_Int = i3;
    int i2 = Math.abs(this.jdField_f_of_type_Int - this.jdField_e_of_type_Int);
    int i3 = Math.abs(this.jdField_h_of_type_Int - this.jdField_g_of_type_Int);
    if (this.jdField_d_of_type_Boolean)
    {
      bool1 = bool3;
      if (i2 > i1) {
        bool1 = true;
      }
    }
    for (;;)
    {
      bool2 = bool1;
      if (!bool1) {
        break;
      }
      bool2 = bool1;
      if (!this.jdField_e_of_type_Boolean) {
        break;
      }
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(1);
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(2);
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(4);
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(3);
      return bool1;
      bool1 = bool3;
      if (i2 > i1)
      {
        bool1 = bool3;
        if ((i3 + 0.0F) / i2 < 0.6F) {
          bool1 = true;
        }
      }
    }
    this.jdField_f_of_type_Boolean = false;
    if (((this.jdField_d_of_type_Boolean) && (this.r == 0) && (this.jdField_e_of_type_Int > this.jdField_c_of_type_Int)) || ((this.r == 1) && (this.jdField_e_of_type_Int < this.p - this.jdField_d_of_type_Int)))
    {
      this.o = 3;
      if ((this.jdField_g_of_type_Int >= this.m) && (this.jdField_g_of_type_Int <= this.n)) {
        this.o = 4;
      }
      i();
      this.jdField_f_of_type_Int = -1;
      this.jdField_e_of_type_Int = -1;
      this.jdField_h_of_type_Int = -1;
      this.jdField_g_of_type_Int = -1;
      return true;
    }
    this.jdField_f_of_type_Int = -1;
    this.jdField_e_of_type_Int = -1;
    this.jdField_h_of_type_Int = -1;
    this.jdField_g_of_type_Int = -1;
    return false;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((this.jdField_d_of_type_AndroidViewViewGroup != null) && (this.jdField_d_of_type_AndroidViewViewGroup.getVisibility() != 8)) {
      this.jdField_d_of_type_AndroidViewViewGroup.layout(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    if ((this.jdField_c_of_type_AndroidViewViewGroup != null) && (this.jdField_c_of_type_AndroidViewViewGroup.getVisibility() != 8)) {
      this.jdField_c_of_type_AndroidViewViewGroup.layout(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewView.getVisibility() != 8)) {
      this.jdField_a_of_type_AndroidViewView.layout(paramInt3 - this.jdField_d_of_type_Int, this.m, paramInt3, this.n);
    }
    if ((this.jdField_a_of_type_AndroidViewViewGroup != null) && (this.jdField_a_of_type_AndroidViewViewGroup.getVisibility() != 8)) {
      this.jdField_a_of_type_AndroidViewViewGroup.layout(this.jdField_a_of_type_AndroidViewViewGroup.getLeft(), this.jdField_a_of_type_AndroidViewViewGroup.getTop(), this.jdField_a_of_type_AndroidViewViewGroup.getLeft() + paramInt3, paramInt4);
    }
    if ((this.jdField_c_of_type_AndroidViewView != null) && (this.jdField_c_of_type_AndroidViewView.getVisibility() != 8))
    {
      if (this.r != 0) {
        break label270;
      }
      this.jdField_c_of_type_AndroidViewView.layout(this.jdField_c_of_type_Int, this.m, this.jdField_c_of_type_Int + this.k, this.n);
    }
    label270:
    do
    {
      while (e())
      {
        if (this.t == 2)
        {
          this.t = 0;
          if (!this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.hasMessages(5)) {
            this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(5);
          }
          if (jdField_a_of_type_Boolean) {
            a("onLayout", "valid orientation");
          }
        }
        return;
        if (this.r == 1) {
          this.jdField_c_of_type_AndroidViewView.layout(0, this.m, paramInt3 - this.jdField_d_of_type_Int, this.n);
        }
      }
    } while (!jdField_a_of_type_Boolean);
    a("onLayout", "not valid orientation");
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.p = getMeasuredWidth();
    this.q = getMeasuredHeight();
    this.jdField_c_of_type_Int = (this.p - this.k);
    if (Build.VERSION.SDK_INT >= 11)
    {
      this.l = ((int)(this.q * 0.8F + 0.5D));
      this.m = ((int)(this.q * 0.2F / 2.0F));
      this.n = (this.m + this.l);
      if (this.jdField_a_of_type_AndroidViewView != null) {
        this.jdField_a_of_type_AndroidViewView.getLayoutParams().height = this.l;
      }
      if (!e()) {
        break label177;
      }
      if (this.t == 1)
      {
        this.t = 2;
        if (jdField_a_of_type_Boolean) {
          a("onMeasure", "valid orientation");
        }
      }
    }
    label177:
    while (!jdField_a_of_type_Boolean)
    {
      return;
      this.l = this.q;
      this.m = 0;
      this.n = (this.m + this.l);
      break;
    }
    a("onMeasure", "not valid orientation");
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!d()) {}
    while (!this.jdField_b_of_type_Boolean) {
      return false;
    }
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(getContext());
    int i1 = (int)(paramMotionEvent.getX() + 0.5F);
    int i2 = (int)(paramMotionEvent.getY() + 0.5F);
    int i3 = i1 - this.jdField_f_of_type_Int;
    int i4 = this.jdField_h_of_type_Int;
    if (this.jdField_a_of_type_AndroidViewVelocityTracker == null) {
      this.jdField_a_of_type_AndroidViewVelocityTracker = VelocityTracker.obtain();
    }
    this.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
    this.jdField_f_of_type_Int = i1;
    this.jdField_h_of_type_Int = i2;
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    default: 
      return false;
    case 0: 
      if (this.jdField_e_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(1);
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(2);
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(4);
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(3);
      }
    case 2: 
      ApngImage.pauseAll();
      boolean bool = this.jdField_e_of_type_Boolean;
      this.jdField_e_of_type_Boolean = true;
      if ((!bool) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame$IDrawerCallbacks != null)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame$IDrawerCallbacks.a(this.r);
      }
      this.o = 1;
      if ((this.r == 0) && (this.jdField_b_of_type_Int + i3 > this.jdField_c_of_type_Int)) {
        if (this.jdField_b_of_type_Int != this.jdField_c_of_type_Int)
        {
          this.jdField_d_of_type_Boolean = true;
          this.jdField_a_of_type_AndroidViewViewGroup.offsetLeftAndRight(this.jdField_c_of_type_Int - this.jdField_b_of_type_Int);
          this.jdField_b_of_type_Int = this.jdField_c_of_type_Int;
          a(this.r, this.jdField_b_of_type_Int);
          invalidate();
        }
      }
      for (;;)
      {
        return true;
        if ((this.r == 0) && (this.jdField_b_of_type_Int + i3 < 0))
        {
          if (this.jdField_b_of_type_Int != 0)
          {
            this.jdField_d_of_type_Boolean = false;
            this.jdField_a_of_type_AndroidViewViewGroup.offsetLeftAndRight(0 - this.jdField_a_of_type_AndroidViewViewGroup.getLeft());
            this.jdField_b_of_type_Int = 0;
            a(this.r, this.jdField_b_of_type_Int);
            invalidate();
          }
        }
        else if ((this.r == 1) && (this.jdField_b_of_type_Int + i3 < -this.jdField_d_of_type_Int))
        {
          if (this.jdField_b_of_type_Int != -this.jdField_d_of_type_Int)
          {
            this.jdField_d_of_type_Boolean = true;
            this.jdField_a_of_type_AndroidViewViewGroup.offsetLeftAndRight(-this.jdField_d_of_type_Int - this.jdField_b_of_type_Int);
            this.jdField_b_of_type_Int = (-this.jdField_d_of_type_Int);
            a(this.r, this.jdField_b_of_type_Int);
            invalidate();
          }
        }
        else if ((this.r == 1) && (this.jdField_b_of_type_Int + i3 > 0))
        {
          if (this.jdField_b_of_type_Int != 0)
          {
            this.jdField_d_of_type_Boolean = false;
            this.jdField_a_of_type_AndroidViewViewGroup.offsetLeftAndRight(0 - this.jdField_a_of_type_AndroidViewViewGroup.getLeft());
            this.jdField_b_of_type_Int = 0;
            a(this.r, this.jdField_b_of_type_Int);
            invalidate();
          }
        }
        else
        {
          this.jdField_a_of_type_AndroidViewViewGroup.offsetLeftAndRight(i3);
          this.jdField_b_of_type_Int += i3;
          a(this.r, this.jdField_b_of_type_Int);
          invalidate();
        }
      }
    }
    this.jdField_f_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidViewVelocityTracker.computeCurrentVelocity(1000);
    if (Math.abs(this.jdField_a_of_type_AndroidViewVelocityTracker.getXVelocity()) > localViewConfiguration.getScaledMinimumFlingVelocity()) {
      if (this.r == 0) {
        if (this.jdField_a_of_type_AndroidViewVelocityTracker.getXVelocity() > 0.0F)
        {
          this.jdField_d_of_type_Boolean = false;
          f();
        }
      }
    }
    for (;;)
    {
      return true;
      this.jdField_d_of_type_Boolean = true;
      i();
      continue;
      if (this.jdField_a_of_type_AndroidViewVelocityTracker.getXVelocity() < 0.0F)
      {
        this.jdField_d_of_type_Boolean = false;
        g();
      }
      else
      {
        this.jdField_d_of_type_Boolean = true;
        i();
        continue;
        if (this.r == 0)
        {
          if (this.jdField_b_of_type_Int > this.p / 2.0D)
          {
            this.jdField_d_of_type_Boolean = false;
            f();
          }
          else
          {
            this.jdField_d_of_type_Boolean = true;
            i();
          }
        }
        else if (this.jdField_b_of_type_Int < -(this.jdField_d_of_type_Int / 3.0D * 2.0D))
        {
          this.jdField_d_of_type_Boolean = false;
          g();
        }
        else
        {
          this.jdField_d_of_type_Boolean = true;
          i();
        }
      }
    }
  }
  
  public void setDrawerCallbacks(DrawerFrame.IDrawerCallbacks paramIDrawerCallbacks)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame$IDrawerCallbacks = paramIDrawerCallbacks;
  }
  
  public void setDrawerEnabled(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public void setDrawerShadowFlag(boolean paramBoolean)
  {
    this.jdField_h_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.DrawerFrame
 * JD-Core Version:    0.7.0.1
 */