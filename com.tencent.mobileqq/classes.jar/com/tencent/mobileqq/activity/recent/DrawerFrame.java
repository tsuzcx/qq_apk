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
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Scroller;
import androidx.fragment.app.FragmentManager;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.activity.home.MainFragment;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.RandomCoverView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.util.HashMap;
import java.util.Map;

public class DrawerFrame
  extends FrameLayout
  implements Handler.Callback
{
  public static int a;
  public static final boolean a;
  private VelocityTracker jdField_a_of_type_AndroidViewVelocityTracker;
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private Scroller jdField_a_of_type_AndroidWidgetScroller;
  private DrawerFrame.IDrawerCallbacks jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame$IDrawerCallbacks;
  private DrawerFrame.StoryTouchEventInterceptor jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame$StoryTouchEventInterceptor;
  private FrameHelperActivity jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity;
  private WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler;
  private StringBuilder jdField_a_of_type_JavaLangStringBuilder;
  private Map<Integer, DrawerFrame.StoryTouchEventInterceptor> jdField_a_of_type_JavaUtilMap;
  private int jdField_b_of_type_Int;
  private View jdField_b_of_type_AndroidViewView;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  public boolean b;
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
  private boolean jdField_g_of_type_Boolean;
  private int jdField_h_of_type_Int;
  private boolean jdField_h_of_type_Boolean;
  private int jdField_i_of_type_Int;
  private boolean jdField_i_of_type_Boolean;
  private int jdField_j_of_type_Int;
  private boolean jdField_j_of_type_Boolean;
  private int k;
  private int l;
  private int m;
  private int n;
  private int o;
  private int p;
  private int q;
  private int r;
  private int s;
  private int t;
  
  static
  {
    jdField_a_of_type_Boolean = QLog.isDevelopLevel();
    jdField_a_of_type_Int = 0;
  }
  
  public DrawerFrame(Context paramContext, ViewGroup paramViewGroup1, ViewGroup paramViewGroup2, View paramView, ViewGroup paramViewGroup3, FrameHelperActivity paramFrameHelperActivity)
  {
    super(paramContext);
    boolean bool = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_g_of_type_Boolean = true;
    this.jdField_b_of_type_Int = 0;
    this.r = 0;
    this.s = -1;
    this.t = 0;
    this.jdField_h_of_type_Boolean = true;
    this.jdField_i_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_b_of_type_Boolean = true;
    if (paramContext != null)
    {
      Resources localResources = paramContext.getResources();
      DisplayMetrics localDisplayMetrics = localResources.getDisplayMetrics();
      this.o = 0;
      double d1 = localDisplayMetrics.density * 100.0F;
      Double.isNaN(d1);
      this.jdField_i_of_type_Int = ((int)(d1 + 0.5D));
      this.k = localResources.getDimensionPixelSize(2131298519);
      this.jdField_d_of_type_Int = localResources.getDimensionPixelSize(2131298927);
      this.jdField_j_of_type_Int = 0;
      if (Build.VERSION.SDK_INT >= 11) {
        bool = true;
      }
      this.jdField_g_of_type_Boolean = bool;
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
      this.jdField_a_of_type_AndroidWidgetScroller = new Scroller(paramContext, new DrawerFrame.SmoothInterpolator());
      if ((paramContext instanceof Activity)) {
        this.s = DeviceInfoUtil.a((Activity)paramContext);
      } else {
        this.s = paramContext.getResources().getConfiguration().orientation;
      }
      if (jdField_a_of_type_Boolean) {
        a("DrawerFrame", null);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity = paramFrameHelperActivity;
      a(paramViewGroup1, paramViewGroup2, paramView, paramViewGroup3);
      b(this.r, 1);
      return;
    }
    throw new NullPointerException("context is null");
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    this.o = 2;
    if (!this.jdField_d_of_type_Boolean)
    {
      b(paramInt, paramBoolean);
      return;
    }
    b(paramBoolean);
  }
  
  private void a(View paramView)
  {
    View localView = this.jdField_a_of_type_AndroidViewView;
    if (paramView != localView)
    {
      if (localView != null) {
        removeView(localView);
      }
      this.jdField_a_of_type_AndroidViewView = paramView;
      if (this.jdField_a_of_type_AndroidViewView != null)
      {
        paramView = new FrameLayout.LayoutParams(-2, -1, 21);
        addView(this.jdField_a_of_type_AndroidViewView, paramView);
      }
    }
  }
  
  private void a(ViewGroup paramViewGroup)
  {
    ViewGroup localViewGroup = this.jdField_a_of_type_AndroidViewViewGroup;
    if (paramViewGroup != localViewGroup)
    {
      if (localViewGroup != null)
      {
        removeView(localViewGroup);
        localViewGroup = this.jdField_b_of_type_AndroidViewViewGroup;
        if (localViewGroup != null)
        {
          localViewGroup.removeView(this);
          this.jdField_b_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_AndroidViewViewGroup);
          this.jdField_b_of_type_AndroidViewViewGroup.setOnClickListener(null);
          this.jdField_b_of_type_AndroidViewViewGroup = null;
        }
      }
      this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
      AccessibilityUtil.b(this.jdField_a_of_type_AndroidViewViewGroup, true);
      paramViewGroup = this.jdField_a_of_type_AndroidViewViewGroup;
      if (paramViewGroup != null)
      {
        paramViewGroup = paramViewGroup.getParent();
        if ((paramViewGroup instanceof ViewGroup))
        {
          this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)paramViewGroup);
          this.jdField_b_of_type_AndroidViewViewGroup.removeView(this.jdField_a_of_type_AndroidViewViewGroup);
        }
        else
        {
          this.jdField_b_of_type_AndroidViewViewGroup = null;
        }
        paramViewGroup = new FrameLayout.LayoutParams(-1, -1);
        addView(this.jdField_a_of_type_AndroidViewViewGroup, paramViewGroup);
      }
      if ((this.jdField_c_of_type_AndroidViewViewGroup != null) && (this.jdField_g_of_type_Boolean))
      {
        if (this.jdField_b_of_type_AndroidViewView == null)
        {
          this.jdField_b_of_type_AndroidViewView = new View(getContext());
          this.jdField_b_of_type_AndroidViewView.setBackgroundColor(0);
        }
        if (ThemeUtil.isDefaultOrDIYTheme(false))
        {
          this.jdField_h_of_type_Boolean = true;
          this.jdField_b_of_type_AndroidViewView.setVisibility(0);
        }
        else
        {
          this.jdField_h_of_type_Boolean = false;
          this.jdField_b_of_type_AndroidViewView.setVisibility(8);
        }
        paramViewGroup = new FrameLayout.LayoutParams(-1, -1);
        localViewGroup = this.jdField_a_of_type_AndroidViewViewGroup;
        if (localViewGroup != null) {
          localViewGroup.addView(this.jdField_b_of_type_AndroidViewView, paramViewGroup);
        }
      }
      else
      {
        paramViewGroup = this.jdField_b_of_type_AndroidViewView;
        if (paramViewGroup != null)
        {
          localViewGroup = this.jdField_a_of_type_AndroidViewViewGroup;
          if (localViewGroup != null) {
            localViewGroup.removeView(paramViewGroup);
          }
        }
      }
      paramViewGroup = this.jdField_b_of_type_AndroidViewViewGroup;
      if (paramViewGroup != null)
      {
        paramViewGroup.addView(this);
        this.jdField_b_of_type_AndroidViewViewGroup.setOnClickListener(new DrawerFrame.1(this));
      }
    }
  }
  
  private void a(ViewGroup paramViewGroup, int paramInt1, int paramInt2)
  {
    Object localObject = this.jdField_d_of_type_AndroidViewViewGroup;
    if (paramViewGroup != localObject)
    {
      if (localObject != null) {
        removeView((View)localObject);
      }
      this.jdField_d_of_type_AndroidViewViewGroup = paramViewGroup;
      paramViewGroup = this.jdField_d_of_type_AndroidViewViewGroup;
      if (paramViewGroup != null)
      {
        paramViewGroup = (RandomCoverView)paramViewGroup.findViewById(2131378997);
        if (paramViewGroup != null)
        {
          localObject = (RelativeLayout.LayoutParams)paramViewGroup.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject).width = -1;
          ((RelativeLayout.LayoutParams)localObject).height = paramInt2;
          paramViewGroup.setLayoutParams((ViewGroup.LayoutParams)localObject);
          paramViewGroup.setDefaultCoverBg();
        }
        paramViewGroup = new FrameLayout.LayoutParams(-1, -1);
        addView(this.jdField_d_of_type_AndroidViewViewGroup, paramViewGroup);
      }
    }
  }
  
  private void a(String paramString, Object paramObject)
  {
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = this.jdField_a_of_type_JavaLangStringBuilder;
      if (localStringBuilder == null) {
        this.jdField_a_of_type_JavaLangStringBuilder = new StringBuilder(120);
      } else {
        localStringBuilder.setLength(0);
      }
      localStringBuilder = this.jdField_a_of_type_JavaLangStringBuilder;
      localStringBuilder.append(paramString);
      localStringBuilder.append(", mConfigurationFlag = ");
      localStringBuilder.append(this.t);
      localStringBuilder.append(", mCurOrientation = ");
      localStringBuilder.append(this.s);
      localStringBuilder.append(", mDecorOffsetX = ");
      localStringBuilder.append(this.jdField_b_of_type_Int);
      localStringBuilder.append(", mLeftDrawerWidth = ");
      localStringBuilder.append(this.jdField_c_of_type_Int);
      localStringBuilder.append(", mConfigurationFlag = ");
      localStringBuilder.append(this.t);
      localStringBuilder.append(", mWidth = ");
      localStringBuilder.append(this.p);
      localStringBuilder.append(", mHeight =");
      localStringBuilder.append(this.q);
      localStringBuilder.append(", param = ");
      localStringBuilder.append(paramObject);
      QLog.i("DrawerFrame", 4, this.jdField_a_of_type_JavaLangStringBuilder.toString());
    }
  }
  
  private boolean a(int paramInt)
  {
    ApngImage.pauseAll();
    boolean bool = this.jdField_e_of_type_Boolean;
    this.jdField_e_of_type_Boolean = true;
    Object localObject;
    if (!bool)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame$IDrawerCallbacks;
      if (localObject != null) {
        ((DrawerFrame.IDrawerCallbacks)localObject).a(this.r);
      }
    }
    this.o = 1;
    int i1;
    int i2;
    if (this.r == 0)
    {
      i1 = this.jdField_b_of_type_Int;
      i2 = this.jdField_c_of_type_Int;
      if (i1 + paramInt > i2)
      {
        if (i1 == i2) {
          break label362;
        }
        this.jdField_d_of_type_Boolean = true;
        this.jdField_a_of_type_AndroidViewViewGroup.offsetLeftAndRight(i2 - i1);
        this.jdField_b_of_type_Int = this.jdField_c_of_type_Int;
        a(this.r, this.jdField_b_of_type_Int);
        invalidate();
        return true;
      }
    }
    if (this.r == 0)
    {
      i1 = this.jdField_b_of_type_Int;
      if (i1 + paramInt < 0)
      {
        if (i1 == 0) {
          break label362;
        }
        this.jdField_d_of_type_Boolean = false;
        localObject = this.jdField_a_of_type_AndroidViewViewGroup;
        ((ViewGroup)localObject).offsetLeftAndRight(0 - ((ViewGroup)localObject).getLeft());
        this.jdField_b_of_type_Int = 0;
        a(this.r, this.jdField_b_of_type_Int);
        invalidate();
        return true;
      }
    }
    if (this.r == 1)
    {
      i1 = this.jdField_b_of_type_Int;
      i2 = this.jdField_d_of_type_Int;
      if (i1 + paramInt < -i2)
      {
        if (i1 == -i2) {
          break label362;
        }
        this.jdField_d_of_type_Boolean = true;
        this.jdField_a_of_type_AndroidViewViewGroup.offsetLeftAndRight(-i2 - i1);
        this.jdField_b_of_type_Int = (-this.jdField_d_of_type_Int);
        a(this.r, this.jdField_b_of_type_Int);
        invalidate();
        return true;
      }
    }
    if (this.r == 1)
    {
      i1 = this.jdField_b_of_type_Int;
      if (i1 + paramInt > 0)
      {
        if (i1 == 0) {
          break label362;
        }
        this.jdField_d_of_type_Boolean = false;
        localObject = this.jdField_a_of_type_AndroidViewViewGroup;
        ((ViewGroup)localObject).offsetLeftAndRight(0 - ((ViewGroup)localObject).getLeft());
        this.jdField_b_of_type_Int = 0;
        a(this.r, this.jdField_b_of_type_Int);
        invalidate();
        return true;
      }
    }
    this.jdField_a_of_type_AndroidViewViewGroup.offsetLeftAndRight(paramInt);
    this.jdField_b_of_type_Int += paramInt;
    a(this.r, this.jdField_b_of_type_Int);
    invalidate();
    label362:
    return true;
  }
  
  private boolean a(int paramInt1, int paramInt2)
  {
    this.jdField_f_of_type_Int = paramInt1;
    this.jdField_e_of_type_Int = paramInt1;
    this.jdField_h_of_type_Int = paramInt2;
    this.jdField_g_of_type_Int = paramInt2;
    if ((!this.jdField_d_of_type_Boolean) || (this.jdField_e_of_type_Int > this.jdField_j_of_type_Int)) {
      this.jdField_f_of_type_Boolean = true;
    }
    if ((this.jdField_e_of_type_Boolean) && (((this.r == 0) && (this.jdField_e_of_type_Int > this.jdField_b_of_type_Int)) || ((this.r == 1) && (this.jdField_e_of_type_Int < this.p + this.jdField_b_of_type_Int))))
    {
      this.jdField_f_of_type_Boolean = true;
      return true;
    }
    return false;
  }
  
  private boolean a(int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool1 = this.jdField_f_of_type_Boolean;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    if ((!this.jdField_d_of_type_Boolean) && ((paramInt2 < this.jdField_f_of_type_Int) || (paramInt2 < this.jdField_e_of_type_Int)))
    {
      this.jdField_f_of_type_Boolean = false;
      return false;
    }
    this.jdField_f_of_type_Int = paramInt2;
    this.jdField_h_of_type_Int = paramInt3;
    paramInt2 = Math.abs(this.jdField_f_of_type_Int - this.jdField_e_of_type_Int);
    paramInt3 = Math.abs(this.jdField_h_of_type_Int - this.jdField_g_of_type_Int);
    if (this.jdField_d_of_type_Boolean)
    {
      bool1 = bool2;
      if (paramInt2 <= paramInt1) {}
    }
    else
    {
      do
      {
        bool1 = true;
        break;
        bool1 = bool2;
        if (paramInt2 <= paramInt1) {
          break;
        }
        bool1 = bool2;
      } while ((paramInt3 + 0.0F) / paramInt2 < 0.6F);
    }
    if ((bool1) && (this.jdField_e_of_type_Boolean))
    {
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(1);
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(2);
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(4);
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(3);
    }
    return bool1;
  }
  
  private boolean a(ViewConfiguration paramViewConfiguration)
  {
    this.jdField_f_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidViewVelocityTracker.computeCurrentVelocity(1000);
    if (Math.abs(this.jdField_a_of_type_AndroidViewVelocityTracker.getXVelocity()) > paramViewConfiguration.getScaledMinimumFlingVelocity())
    {
      if (this.r == 0)
      {
        if (this.jdField_a_of_type_AndroidViewVelocityTracker.getXVelocity() > 0.0F)
        {
          this.jdField_d_of_type_Boolean = false;
          f();
          return true;
        }
        this.jdField_d_of_type_Boolean = true;
        i();
        return true;
      }
      if (this.jdField_a_of_type_AndroidViewVelocityTracker.getXVelocity() < 0.0F)
      {
        this.jdField_d_of_type_Boolean = false;
        g();
        return true;
      }
      this.jdField_d_of_type_Boolean = true;
      i();
      return true;
    }
    if (this.r == 0)
    {
      d1 = this.jdField_b_of_type_Int;
      d2 = this.p;
      Double.isNaN(d2);
      if (d1 > d2 / 2.0D)
      {
        this.jdField_d_of_type_Boolean = false;
        f();
        return true;
      }
      this.jdField_d_of_type_Boolean = true;
      i();
      return true;
    }
    double d1 = this.jdField_b_of_type_Int;
    double d2 = this.jdField_d_of_type_Int;
    Double.isNaN(d2);
    if (d1 < -(d2 / 3.0D * 2.0D))
    {
      this.jdField_d_of_type_Boolean = false;
      g();
      return true;
    }
    this.jdField_d_of_type_Boolean = true;
    i();
    return true;
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    int i2 = 8;
    int i1;
    if (paramInt2 == 1) {
      i1 = 8;
    } else {
      i1 = 0;
    }
    Object localObject = this.jdField_d_of_type_AndroidViewViewGroup;
    if ((localObject != null) && (((ViewGroup)localObject).getVisibility() != i1)) {
      this.jdField_d_of_type_AndroidViewViewGroup.setVisibility(i1);
    }
    if ((paramInt2 != 1) && (paramInt1 != 1)) {
      i1 = 0;
    } else {
      i1 = 8;
    }
    localObject = this.jdField_c_of_type_AndroidViewViewGroup;
    if ((localObject != null) && (((ViewGroup)localObject).getVisibility() != i1)) {
      this.jdField_c_of_type_AndroidViewViewGroup.setVisibility(i1);
    }
    if ((paramInt2 != 1) && (paramInt1 != 0)) {
      paramInt1 = 0;
    } else {
      paramInt1 = 8;
    }
    localObject = this.jdField_a_of_type_AndroidViewView;
    if ((localObject != null) && (((View)localObject).getVisibility() != paramInt1)) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(paramInt1);
    }
    if ((paramInt2 != 2) && (paramInt2 != 0)) {
      paramInt1 = 8;
    } else {
      paramInt1 = 0;
    }
    localObject = this.jdField_b_of_type_AndroidViewView;
    if ((localObject != null) && (((View)localObject).getVisibility() != paramInt1) && (this.jdField_h_of_type_Boolean)) {
      this.jdField_b_of_type_AndroidViewView.setVisibility(paramInt1);
    }
    paramInt1 = i2;
    if (paramInt2 == 0) {
      paramInt1 = 0;
    }
    localObject = this.jdField_c_of_type_AndroidViewView;
    if ((localObject != null) && (((View)localObject).getVisibility() != paramInt1)) {
      this.jdField_c_of_type_AndroidViewView.setVisibility(paramInt1);
    }
  }
  
  private void b(int paramInt, boolean paramBoolean)
  {
    if (!e()) {
      return;
    }
    this.r = paramInt;
    if (this.jdField_e_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(1);
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(2);
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(4);
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(3);
    }
    else if (this.jdField_d_of_type_Boolean)
    {
      return;
    }
    int i1 = this.r;
    if (i1 == 0) {
      this.jdField_c_of_type_AndroidViewViewGroup.setVisibility(0);
    } else if (i1 == 1) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    this.jdField_e_of_type_Boolean = true;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame$IDrawerCallbacks;
    if (localObject != null) {
      ((DrawerFrame.IDrawerCallbacks)localObject).a(this.r);
    }
    int i2;
    int i3;
    if (paramInt != 0)
    {
      if (paramInt == 1)
      {
        localObject = this.jdField_a_of_type_AndroidWidgetScroller;
        i2 = this.jdField_b_of_type_Int;
        i3 = -this.jdField_d_of_type_Int;
        if (paramBoolean) {
          i1 = 300;
        } else {
          i1 = 1;
        }
        ((Scroller)localObject).startScroll(i2, 0, i3 - i2, 0, i1);
      }
    }
    else
    {
      localObject = this.jdField_a_of_type_AndroidWidgetScroller;
      i2 = this.jdField_b_of_type_Int;
      i3 = this.jdField_c_of_type_Int;
      if (paramBoolean) {
        i1 = 300;
      } else {
        i1 = 1;
      }
      ((Scroller)localObject).startScroll(i2, 0, i3 - i2, 0, i1);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame$IDrawerCallbacks;
    if (localObject != null) {
      ((DrawerFrame.IDrawerCallbacks)localObject).a(paramInt, true);
    }
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(1);
  }
  
  private void b(ViewGroup paramViewGroup)
  {
    ViewGroup localViewGroup = this.jdField_c_of_type_AndroidViewViewGroup;
    if (paramViewGroup != localViewGroup)
    {
      if (localViewGroup != null) {
        removeView(localViewGroup);
      }
      this.jdField_c_of_type_AndroidViewViewGroup = paramViewGroup;
      if (this.jdField_c_of_type_AndroidViewViewGroup != null)
      {
        paramViewGroup = new FrameLayout.LayoutParams(-1, -1, 19);
        addView(this.jdField_c_of_type_AndroidViewViewGroup, paramViewGroup);
      }
    }
  }
  
  private void b(boolean paramBoolean)
  {
    ApngImage.pauseByTag(1);
    if (!e()) {
      return;
    }
    if (this.jdField_e_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(1);
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(2);
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(4);
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(3);
    }
    else if (!this.jdField_d_of_type_Boolean)
    {
      return;
    }
    this.jdField_e_of_type_Boolean = true;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame$IDrawerCallbacks;
    if (localObject != null) {
      ((DrawerFrame.IDrawerCallbacks)localObject).a(this.r);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame$IDrawerCallbacks;
    if (localObject != null) {
      ((DrawerFrame.IDrawerCallbacks)localObject).a(this.r, false);
    }
    localObject = this.jdField_a_of_type_AndroidWidgetScroller;
    int i2 = this.jdField_b_of_type_Int;
    int i3 = -i2;
    int i1;
    if (paramBoolean) {
      i1 = 300;
    } else {
      i1 = 0;
    }
    ((Scroller)localObject).startScroll(i2, 0, i3, 0, i1);
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(2);
  }
  
  private boolean d()
  {
    this.jdField_f_of_type_Boolean = false;
    if (((this.jdField_d_of_type_Boolean) && (this.r == 0) && (this.jdField_e_of_type_Int > this.jdField_c_of_type_Int)) || ((this.r == 1) && (this.jdField_e_of_type_Int < this.p - this.jdField_d_of_type_Int)))
    {
      this.o = 3;
      int i1 = this.jdField_g_of_type_Int;
      if ((i1 >= this.m) && (i1 <= this.n)) {
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
  
  private boolean e()
  {
    return (this.jdField_c_of_type_Boolean) && (this.jdField_c_of_type_AndroidViewViewGroup != null) && (this.jdField_a_of_type_AndroidViewViewGroup != null);
  }
  
  private boolean f()
  {
    if (this.jdField_e_of_type_Boolean) {
      return true;
    }
    AccessibilityUtil.b(this.jdField_a_of_type_AndroidViewViewGroup, false);
    b(this.r, 0);
    DrawerFrame.IDrawerCallbacks localIDrawerCallbacks = this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame$IDrawerCallbacks;
    if (localIDrawerCallbacks != null) {
      localIDrawerCallbacks.a(this.r, this.o);
    }
    this.o = 0;
    this.jdField_i_of_type_Boolean = false;
    ApngImage.playByTag(1);
    return false;
  }
  
  private boolean g()
  {
    if (this.jdField_e_of_type_Boolean) {
      return true;
    }
    AccessibilityUtil.b(this.jdField_a_of_type_AndroidViewViewGroup, true);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame$IDrawerCallbacks;
    if (localObject != null) {
      ((DrawerFrame.IDrawerCallbacks)localObject).b(this.r, this.o);
    }
    this.o = 0;
    this.r = 0;
    this.jdField_i_of_type_Boolean = true;
    b(this.r, 1);
    if ((BaseActivity.sTopActivity instanceof BaseActivity))
    {
      localObject = (QBaseFragment)BaseActivity.sTopActivity.getSupportFragmentManager().findFragmentByTag(MainFragment.class.getName());
      if (localObject != null)
      {
        int i1 = ((MainFragment)localObject).a();
        if (i1 == FrameControllerUtil.jdField_a_of_type_Int)
        {
          ApngImage.playByTag(2);
          return false;
        }
        if (i1 == FrameControllerUtil.jdField_c_of_type_Int)
        {
          ApngImage.playByTag(3);
          return false;
        }
        if (i1 == FrameControllerUtil.jdField_d_of_type_Int)
        {
          ApngImage.playByTag(4);
          return false;
        }
        if (i1 == FrameControllerUtil.jdField_f_of_type_Int)
        {
          ApngImage.playByTag(5);
          return false;
        }
        if (i1 == FrameControllerUtil.jdField_g_of_type_Int) {
          ApngImage.playByTag(8);
        }
      }
    }
    return false;
  }
  
  private boolean h()
  {
    if ((this.s == 1) && (this.p > this.q)) {
      return false;
    }
    return (this.s != 0) || (this.p >= this.q);
  }
  
  private void j()
  {
    if (this.jdField_e_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(1);
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(2);
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(4);
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(3);
    }
  }
  
  private void k()
  {
    if (b())
    {
      int i1 = this.r;
      int i2;
      if (i1 == 0)
      {
        i2 = this.jdField_c_of_type_Int;
        i1 = i2 - this.jdField_b_of_type_Int;
        this.jdField_b_of_type_Int = i2;
      }
      else if (i1 == 1)
      {
        i2 = this.jdField_d_of_type_Int;
        i1 = -i2 - this.jdField_b_of_type_Int;
        this.jdField_b_of_type_Int = (-i2);
      }
      else
      {
        i1 = 0;
      }
      ViewGroup localViewGroup = this.jdField_a_of_type_AndroidViewViewGroup;
      if ((localViewGroup != null) && (i1 != 0))
      {
        localViewGroup.offsetLeftAndRight(i1);
        a(this.r, this.jdField_b_of_type_Int);
        postInvalidate();
      }
      if (jdField_a_of_type_Boolean) {
        a("MSG_CONFIGURATION_CHANGED", Integer.valueOf(i1));
      }
    }
  }
  
  private void l()
  {
    boolean bool = this.jdField_a_of_type_AndroidWidgetScroller.computeScrollOffset();
    int i1 = this.jdField_a_of_type_AndroidWidgetScroller.getCurrX();
    int i2 = this.jdField_b_of_type_Int;
    this.jdField_b_of_type_Int = this.jdField_a_of_type_AndroidWidgetScroller.getCurrX();
    Object localObject = this.jdField_a_of_type_AndroidViewViewGroup;
    if (localObject != null)
    {
      ((ViewGroup)localObject).offsetLeftAndRight(i1 - i2);
      a(this.r, this.jdField_b_of_type_Int);
    }
    postInvalidate();
    if (!bool)
    {
      this.jdField_e_of_type_Boolean = false;
      this.jdField_d_of_type_Boolean = false;
      localObject = this.jdField_c_of_type_AndroidViewViewGroup;
      if (localObject != null) {
        ((ViewGroup)localObject).setVisibility(8);
      }
      localObject = this.jdField_a_of_type_AndroidViewView;
      if (localObject != null) {
        ((View)localObject).setVisibility(8);
      }
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(4);
      return;
    }
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(2);
  }
  
  private void m()
  {
    boolean bool = this.jdField_a_of_type_AndroidWidgetScroller.computeScrollOffset();
    int i1 = this.jdField_a_of_type_AndroidWidgetScroller.getCurrX();
    int i2 = this.jdField_b_of_type_Int;
    this.jdField_b_of_type_Int = this.jdField_a_of_type_AndroidWidgetScroller.getCurrX();
    ViewGroup localViewGroup = this.jdField_a_of_type_AndroidViewViewGroup;
    if (localViewGroup != null)
    {
      localViewGroup.offsetLeftAndRight(i1 - i2);
      a(this.r, this.jdField_b_of_type_Int);
    }
    postInvalidate();
    if (!bool)
    {
      this.jdField_e_of_type_Boolean = false;
      this.jdField_d_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(3);
      return;
    }
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(1);
  }
  
  public int a()
  {
    this.k = getContext().getResources().getDimensionPixelSize(2131298519);
    return this.k;
  }
  
  public void a()
  {
    View localView = this.jdField_b_of_type_AndroidViewView;
    if (localView != null) {
      localView.setVisibility(8);
    }
    this.jdField_h_of_type_Boolean = false;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(paramInt));
  }
  
  @TargetApi(11)
  protected void a(int paramInt1, int paramInt2)
  {
    b(paramInt1, 2);
    if (Build.VERSION.SDK_INT >= 11)
    {
      float f1;
      if (paramInt1 == 0)
      {
        f1 = paramInt2;
        paramInt2 = this.jdField_c_of_type_Int;
      }
      else
      {
        f1 = -paramInt2;
        paramInt2 = this.jdField_d_of_type_Int;
      }
      f1 /= paramInt2;
      if (paramInt1 == 0) {
        paramInt2 = this.p;
      } else {
        paramInt2 = -this.p;
      }
      float f2 = paramInt2 * (f1 - 1.0F);
      if (paramInt1 == 0) {
        localObject = this.jdField_c_of_type_AndroidViewViewGroup;
      } else {
        localObject = this.jdField_a_of_type_AndroidViewView;
      }
      if (localObject != null) {
        ((View)localObject).setTranslationX(f2);
      }
      Object localObject = this.jdField_d_of_type_AndroidViewViewGroup;
      if (localObject != null) {
        ((ViewGroup)localObject).setTranslationX(f2);
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame$IDrawerCallbacks;
      if (localObject != null) {
        ((DrawerFrame.IDrawerCallbacks)localObject).a(this.r, f1);
      }
    }
  }
  
  public void a(ViewGroup paramViewGroup1, ViewGroup paramViewGroup2, View paramView, ViewGroup paramViewGroup3)
  {
    int i1 = ((WindowManager)getContext().getSystemService("window")).getDefaultDisplay().getWidth();
    int i2 = i1 - a();
    int i3 = ScreenUtil.dip2px(170.0F);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Screen:(");
      localStringBuilder.append(i1);
      localStringBuilder.append(",");
      localStringBuilder.append(ScreenUtil.SCREEN_HIGHT);
      localStringBuilder.append(") cover:(");
      localStringBuilder.append(i2);
      localStringBuilder.append(",");
      localStringBuilder.append(i3);
      localStringBuilder.append(")");
      QLog.d("DrawerFrame", 2, localStringBuilder.toString());
    }
    a(paramViewGroup3, i2, i3);
    b(paramViewGroup2);
    a(paramView);
    a(paramViewGroup1);
    if ((this.jdField_c_of_type_AndroidViewViewGroup != null) && (this.jdField_c_of_type_AndroidViewView == null))
    {
      this.jdField_c_of_type_AndroidViewView = new View(getContext());
      this.jdField_c_of_type_AndroidViewView.setFocusable(true);
      this.jdField_c_of_type_AndroidViewView.setFocusableInTouchMode(true);
      this.jdField_c_of_type_AndroidViewView.setClickable(true);
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      this.jdField_c_of_type_AndroidViewView.setBackgroundResource(17170445);
      this.jdField_c_of_type_AndroidViewView.setContentDescription(HardCodeUtil.a(2131703692));
      paramViewGroup1 = new FrameLayout.LayoutParams(this.jdField_c_of_type_Int, this.l, 21);
      addView(this.jdField_c_of_type_AndroidViewView, paramViewGroup1);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onMultiWindowModeChanged, isInMultiWindowMode:");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("DrawerFrame", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = (RandomCoverView)this.jdField_d_of_type_AndroidViewViewGroup.findViewById(2131378997);
    if (localObject != null)
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((RandomCoverView)localObject).getLayoutParams();
      localLayoutParams.width = (ScreenUtil.SCREEN_WIDTH - a());
      localLayoutParams.height = ScreenUtil.dip2px(170.0F);
      ((RandomCoverView)localObject).setLayoutParams(localLayoutParams);
      ((RandomCoverView)localObject).setDefaultCoverBg();
    }
  }
  
  public boolean a()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public void b()
  {
    View localView = this.jdField_b_of_type_AndroidViewView;
    if (localView != null) {
      localView.setVisibility(0);
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
      d1 = this.jdField_b_of_type_Int;
      d2 = this.p;
      Double.isNaN(d2);
      if (d1 > d2 / 2.0D)
      {
        this.jdField_d_of_type_Boolean = false;
        f();
        return;
      }
      this.jdField_d_of_type_Boolean = true;
      i();
      return;
    }
    double d1 = this.jdField_b_of_type_Int;
    double d2 = this.jdField_d_of_type_Int;
    Double.isNaN(d2);
    if (d1 < -(d2 / 3.0D * 2.0D))
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
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    Object localObject1 = (QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.getQBaseActivity().getAppRuntime();
    Object localObject2;
    if ((BaseActivity.sTopActivity instanceof BaseActivity))
    {
      localObject2 = (QBaseFragment)BaseActivity.sTopActivity.getSupportFragmentManager().findFragmentByTag(MainFragment.class.getName());
      if (localObject2 != null)
      {
        i1 = ((MainFragment)localObject2).a();
        break label63;
      }
    }
    int i1 = -1;
    label63:
    boolean bool2;
    if ((!((QQAppInterface)localObject1).isInCallList) && (this.jdField_i_of_type_Boolean))
    {
      localObject1 = MotionEvent.obtain(paramMotionEvent);
      if ((localObject1 != null) && (i1 != -1))
      {
        localObject2 = (DrawerFrame.StoryTouchEventInterceptor)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(i1));
        if (localObject2 != null)
        {
          bool1 = ((DrawerFrame.StoryTouchEventInterceptor)localObject2).interceptDrawer(this, (MotionEvent)localObject1);
          break label133;
        }
      }
      boolean bool1 = false;
      label133:
      bool2 = bool1;
      if (localObject1 != null)
      {
        ((MotionEvent)localObject1).recycle();
        bool2 = bool1;
      }
    }
    else
    {
      bool2 = false;
    }
    if (paramMotionEvent.getAction() == 0) {
      this.jdField_j_of_type_Boolean = false;
    }
    if ((this.jdField_j_of_type_Boolean) && (!bool2)) {
      paramMotionEvent.setAction(0);
    }
    this.jdField_j_of_type_Boolean = bool2;
    if (bool2) {
      return true;
    }
    return super.dispatchTouchEvent(paramMotionEvent);
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
    ViewGroup localViewGroup = this.jdField_a_of_type_AndroidViewViewGroup;
    if (localViewGroup != null) {
      localViewGroup.offsetLeftAndRight(0 - localViewGroup.getLeft());
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
    int i1 = paramMessage.what;
    if (i1 != 1)
    {
      if (i1 != 2)
      {
        if (i1 != 3)
        {
          if (i1 != 4)
          {
            if (i1 != 5) {
              return true;
            }
            k();
            return true;
          }
          if (g()) {
            return true;
          }
        }
        else if (f())
        {
          return true;
        }
      }
      else
      {
        l();
        return true;
      }
    }
    else {
      m();
    }
    return true;
  }
  
  public void i()
  {
    b(true);
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
    if (!e()) {
      return false;
    }
    if (!this.jdField_b_of_type_Boolean) {
      return false;
    }
    int i1 = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    int i2 = (int)(paramMotionEvent.getX() + 0.5F);
    int i3 = (int)(paramMotionEvent.getY() + 0.5F);
    int i4 = paramMotionEvent.getAction() & 0xFF;
    if (i4 != 0)
    {
      if (i4 != 1)
      {
        if (i4 != 2) {
          return false;
        }
        return a(i1, i2, i3);
      }
      return d();
    }
    return a(i2, i3);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Object localObject = this.jdField_d_of_type_AndroidViewViewGroup;
    if ((localObject != null) && (((ViewGroup)localObject).getVisibility() != 8)) {
      this.jdField_d_of_type_AndroidViewViewGroup.layout(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    localObject = this.jdField_c_of_type_AndroidViewViewGroup;
    if ((localObject != null) && (((ViewGroup)localObject).getVisibility() != 8)) {
      this.jdField_c_of_type_AndroidViewViewGroup.layout(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    localObject = this.jdField_a_of_type_AndroidViewView;
    if ((localObject != null) && (((View)localObject).getVisibility() != 8)) {
      this.jdField_a_of_type_AndroidViewView.layout(paramInt3 - this.jdField_d_of_type_Int, this.m, paramInt3, this.n);
    }
    localObject = this.jdField_a_of_type_AndroidViewViewGroup;
    if ((localObject != null) && (((ViewGroup)localObject).getVisibility() != 8))
    {
      localObject = this.jdField_a_of_type_AndroidViewViewGroup;
      ((ViewGroup)localObject).layout(((ViewGroup)localObject).getLeft(), this.jdField_a_of_type_AndroidViewViewGroup.getTop(), this.jdField_a_of_type_AndroidViewViewGroup.getLeft() + paramInt3, paramInt4);
    }
    localObject = this.jdField_c_of_type_AndroidViewView;
    if ((localObject != null) && (((View)localObject).getVisibility() != 8))
    {
      paramInt1 = this.r;
      if (paramInt1 == 0)
      {
        localObject = this.jdField_c_of_type_AndroidViewView;
        paramInt1 = this.jdField_c_of_type_Int;
        ((View)localObject).layout(paramInt1, this.m, this.k + paramInt1, this.n);
      }
      else if (paramInt1 == 1)
      {
        this.jdField_c_of_type_AndroidViewView.layout(0, this.m, paramInt3 - this.jdField_d_of_type_Int, this.n);
      }
    }
    if (h())
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
    }
    else if (jdField_a_of_type_Boolean) {
      a("onLayout", "not valid orientation");
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.p = getMeasuredWidth();
    this.q = getMeasuredHeight();
    this.jdField_c_of_type_Int = (this.p - this.k);
    if (Build.VERSION.SDK_INT >= 11)
    {
      paramInt1 = this.q;
      double d1 = paramInt1 * 0.8F;
      Double.isNaN(d1);
      this.l = ((int)(d1 + 0.5D));
      this.m = ((int)(paramInt1 * 0.2F / 2.0F));
      this.n = (this.m + this.l);
    }
    else
    {
      this.l = this.q;
      this.m = 0;
      this.n = (this.m + this.l);
    }
    View localView = this.jdField_a_of_type_AndroidViewView;
    if (localView != null) {
      localView.getLayoutParams().height = this.l;
    }
    if (h())
    {
      if (this.t == 1)
      {
        this.t = 2;
        if (jdField_a_of_type_Boolean) {
          a("onMeasure", "valid orientation");
        }
      }
    }
    else if (jdField_a_of_type_Boolean) {
      a("onMeasure", "not valid orientation");
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!e()) {
      return false;
    }
    if (!this.jdField_b_of_type_Boolean) {
      return false;
    }
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(getContext());
    int i1 = (int)(paramMotionEvent.getX() + 0.5F);
    int i3 = (int)(paramMotionEvent.getY() + 0.5F);
    int i2 = this.jdField_f_of_type_Int;
    int i4 = this.jdField_h_of_type_Int;
    if (this.jdField_a_of_type_AndroidViewVelocityTracker == null) {
      this.jdField_a_of_type_AndroidViewVelocityTracker = VelocityTracker.obtain();
    }
    this.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
    this.jdField_f_of_type_Int = i1;
    this.jdField_h_of_type_Int = i3;
    i3 = paramMotionEvent.getAction() & 0xFF;
    if (i3 != 0)
    {
      if (i3 != 1)
      {
        if (i3 != 2) {
          return false;
        }
      }
      else {
        return a(localViewConfiguration);
      }
    }
    else {
      j();
    }
    return a(i1 - i2);
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
  
  public void setMiniAppTouchEventInterceptor(int paramInt, DrawerFrame.StoryTouchEventInterceptor paramStoryTouchEventInterceptor)
  {
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), paramStoryTouchEventInterceptor);
  }
  
  public void setStoryTouchEventInterceptor(DrawerFrame.StoryTouchEventInterceptor paramStoryTouchEventInterceptor)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame$StoryTouchEventInterceptor = paramStoryTouchEventInterceptor;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.DrawerFrame
 * JD-Core Version:    0.7.0.1
 */