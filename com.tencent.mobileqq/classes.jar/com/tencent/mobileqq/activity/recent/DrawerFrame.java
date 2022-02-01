package com.tencent.mobileqq.activity.recent;

import alfp;
import alfq;
import alfr;
import alfs;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.Fragment;
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
import anvx;
import bgyd;
import bkys;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.activity.home.MainFragment;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.widget.RandomCoverView;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

public class DrawerFrame
  extends FrameLayout
  implements Handler.Callback
{
  public static int a;
  public static final boolean a;
  private alfq jdField_a_of_type_Alfq;
  private alfs jdField_a_of_type_Alfs;
  private VelocityTracker jdField_a_of_type_AndroidViewVelocityTracker;
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private Scroller jdField_a_of_type_AndroidWidgetScroller;
  private bkys jdField_a_of_type_Bkys;
  private FrameHelperActivity jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity;
  private StringBuilder jdField_a_of_type_JavaLangStringBuilder;
  private Map<Integer, alfs> jdField_a_of_type_JavaUtilMap = new HashMap();
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
  private boolean jdField_g_of_type_Boolean = true;
  private int jdField_h_of_type_Int;
  private boolean jdField_h_of_type_Boolean = true;
  private int jdField_i_of_type_Int;
  private boolean jdField_i_of_type_Boolean = true;
  private int jdField_j_of_type_Int;
  private boolean jdField_j_of_type_Boolean;
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
    this.jdField_i_of_type_Int = ((int)(localDisplayMetrics.density * 100.0F + 0.5D));
    this.k = localResources.getDimensionPixelSize(2131298438);
    this.jdField_d_of_type_Int = localResources.getDimensionPixelSize(2131298835);
    this.jdField_j_of_type_Int = 0;
    if (Build.VERSION.SDK_INT >= 11) {
      bool = true;
    }
    this.jdField_g_of_type_Boolean = bool;
    this.jdField_a_of_type_Bkys = new bkys(Looper.getMainLooper(), this);
    this.jdField_a_of_type_AndroidWidgetScroller = new Scroller(paramContext, new alfr());
    if ((paramContext instanceof Activity)) {}
    for (this.s = DeviceInfoUtil.getScreenOrientation((Activity)paramContext);; this.s = paramContext.getResources().getConfiguration().orientation)
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
    b(paramBoolean);
  }
  
  private void a(View paramView)
  {
    if (paramView != this.jdField_a_of_type_AndroidViewView)
    {
      if (this.jdField_a_of_type_AndroidViewView != null) {
        removeView(this.jdField_a_of_type_AndroidViewView);
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
    if (paramViewGroup != this.jdField_a_of_type_AndroidViewViewGroup)
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
      this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
      bgyd.b(this.jdField_a_of_type_AndroidViewViewGroup, true);
      if (this.jdField_a_of_type_AndroidViewViewGroup != null)
      {
        paramViewGroup = this.jdField_a_of_type_AndroidViewViewGroup.getParent();
        if (!(paramViewGroup instanceof ViewGroup)) {
          break label259;
        }
        this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)paramViewGroup);
        this.jdField_b_of_type_AndroidViewViewGroup.removeView(this.jdField_a_of_type_AndroidViewViewGroup);
        paramViewGroup = new FrameLayout.LayoutParams(-1, -1);
        addView(this.jdField_a_of_type_AndroidViewViewGroup, paramViewGroup);
      }
      if ((this.jdField_c_of_type_AndroidViewViewGroup == null) || (!this.jdField_g_of_type_Boolean)) {
        break label284;
      }
      if (this.jdField_b_of_type_AndroidViewView == null)
      {
        this.jdField_b_of_type_AndroidViewView = new View(getContext());
        this.jdField_b_of_type_AndroidViewView.setBackgroundColor(0);
      }
      if (!ThemeUtil.isDefaultOrDIYTheme(false)) {
        break label267;
      }
      this.jdField_h_of_type_Boolean = true;
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      label199:
      paramViewGroup = new FrameLayout.LayoutParams(-1, -1);
      if (this.jdField_a_of_type_AndroidViewViewGroup != null) {
        this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_b_of_type_AndroidViewView, paramViewGroup);
      }
    }
    for (;;)
    {
      if (this.jdField_b_of_type_AndroidViewViewGroup != null)
      {
        this.jdField_b_of_type_AndroidViewViewGroup.addView(this);
        this.jdField_b_of_type_AndroidViewViewGroup.setOnClickListener(new alfp(this));
      }
      return;
      label259:
      this.jdField_b_of_type_AndroidViewViewGroup = null;
      break;
      label267:
      this.jdField_h_of_type_Boolean = false;
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      break label199;
      label284:
      if ((this.jdField_b_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewViewGroup != null)) {
        this.jdField_a_of_type_AndroidViewViewGroup.removeView(this.jdField_b_of_type_AndroidViewView);
      }
    }
  }
  
  private void a(ViewGroup paramViewGroup, int paramInt1, int paramInt2)
  {
    if (paramViewGroup != this.jdField_d_of_type_AndroidViewViewGroup)
    {
      if (this.jdField_d_of_type_AndroidViewViewGroup != null) {
        removeView(this.jdField_d_of_type_AndroidViewViewGroup);
      }
      this.jdField_d_of_type_AndroidViewViewGroup = paramViewGroup;
      if (this.jdField_d_of_type_AndroidViewViewGroup != null)
      {
        paramViewGroup = (RandomCoverView)this.jdField_d_of_type_AndroidViewViewGroup.findViewById(2131379220);
        if (paramViewGroup != null)
        {
          RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramViewGroup.getLayoutParams();
          localLayoutParams.width = paramInt1;
          localLayoutParams.height = paramInt2;
          paramViewGroup.setLayoutParams(localLayoutParams);
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
      if (this.jdField_a_of_type_JavaLangStringBuilder != null) {
        break label150;
      }
      this.jdField_a_of_type_JavaLangStringBuilder = new StringBuilder(120);
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaLangStringBuilder.append(paramString).append(", mConfigurationFlag = ").append(this.t).append(", mCurOrientation = ").append(this.s).append(", mDecorOffsetX = ").append(this.jdField_b_of_type_Int).append(", mLeftDrawerWidth = ").append(this.jdField_c_of_type_Int).append(", mConfigurationFlag = ").append(this.t).append(", mWidth = ").append(this.p).append(", mHeight =").append(this.q).append(", param = ").append(paramObject);
      QLog.i("DrawerFrame", 4, this.jdField_a_of_type_JavaLangStringBuilder.toString());
      return;
      label150:
      this.jdField_a_of_type_JavaLangStringBuilder.setLength(0);
    }
  }
  
  private boolean a(int paramInt)
  {
    ApngImage.pauseAll();
    boolean bool = this.jdField_e_of_type_Boolean;
    this.jdField_e_of_type_Boolean = true;
    if ((!bool) && (this.jdField_a_of_type_Alfq != null)) {
      this.jdField_a_of_type_Alfq.a(this.r);
    }
    this.o = 1;
    if ((this.r == 0) && (this.jdField_b_of_type_Int + paramInt > this.jdField_c_of_type_Int)) {
      if (this.jdField_b_of_type_Int != this.jdField_c_of_type_Int)
      {
        this.jdField_d_of_type_Boolean = true;
        this.jdField_a_of_type_AndroidViewViewGroup.offsetLeftAndRight(this.jdField_c_of_type_Int - this.jdField_b_of_type_Int);
        this.jdField_b_of_type_Int = this.jdField_c_of_type_Int;
        a(this.r, this.jdField_b_of_type_Int);
        invalidate();
      }
    }
    do
    {
      do
      {
        do
        {
          return true;
          if ((this.r != 0) || (this.jdField_b_of_type_Int + paramInt >= 0)) {
            break;
          }
        } while (this.jdField_b_of_type_Int == 0);
        this.jdField_d_of_type_Boolean = false;
        this.jdField_a_of_type_AndroidViewViewGroup.offsetLeftAndRight(0 - this.jdField_a_of_type_AndroidViewViewGroup.getLeft());
        this.jdField_b_of_type_Int = 0;
        a(this.r, this.jdField_b_of_type_Int);
        invalidate();
        return true;
        if ((this.r != 1) || (this.jdField_b_of_type_Int + paramInt >= -this.jdField_d_of_type_Int)) {
          break;
        }
      } while (this.jdField_b_of_type_Int == -this.jdField_d_of_type_Int);
      this.jdField_d_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidViewViewGroup.offsetLeftAndRight(-this.jdField_d_of_type_Int - this.jdField_b_of_type_Int);
      this.jdField_b_of_type_Int = (-this.jdField_d_of_type_Int);
      a(this.r, this.jdField_b_of_type_Int);
      invalidate();
      return true;
      if ((this.r != 1) || (this.jdField_b_of_type_Int + paramInt <= 0)) {
        break;
      }
    } while (this.jdField_b_of_type_Int == 0);
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidViewViewGroup.offsetLeftAndRight(0 - this.jdField_a_of_type_AndroidViewViewGroup.getLeft());
    this.jdField_b_of_type_Int = 0;
    a(this.r, this.jdField_b_of_type_Int);
    invalidate();
    return true;
    this.jdField_a_of_type_AndroidViewViewGroup.offsetLeftAndRight(paramInt);
    this.jdField_b_of_type_Int += paramInt;
    a(this.r, this.jdField_b_of_type_Int);
    invalidate();
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
    boolean bool2 = false;
    boolean bool1 = false;
    if (!this.jdField_f_of_type_Boolean)
    {
      bool2 = bool1;
      return bool2;
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
      if (paramInt2 > paramInt1) {
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
      this.jdField_a_of_type_Bkys.removeMessages(1);
      this.jdField_a_of_type_Bkys.removeMessages(2);
      this.jdField_a_of_type_Bkys.removeMessages(4);
      this.jdField_a_of_type_Bkys.removeMessages(3);
      return bool1;
      bool1 = bool2;
      if (paramInt2 > paramInt1)
      {
        bool1 = bool2;
        if ((paramInt3 + 0.0F) / paramInt2 < 0.6F) {
          bool1 = true;
        }
      }
    }
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
      if (this.jdField_b_of_type_Int > this.p / 2.0D)
      {
        this.jdField_d_of_type_Boolean = false;
        f();
        return true;
      }
      this.jdField_d_of_type_Boolean = true;
      i();
      return true;
    }
    if (this.jdField_b_of_type_Int < -(this.jdField_d_of_type_Int / 3.0D * 2.0D))
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
    if (!e()) {
      return;
    }
    this.r = paramInt;
    if (this.jdField_e_of_type_Boolean)
    {
      this.jdField_a_of_type_Bkys.removeMessages(1);
      this.jdField_a_of_type_Bkys.removeMessages(2);
      this.jdField_a_of_type_Bkys.removeMessages(4);
      this.jdField_a_of_type_Bkys.removeMessages(3);
      label56:
      if (this.r != 0) {
        break label156;
      }
      this.jdField_c_of_type_AndroidViewViewGroup.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_e_of_type_Boolean = true;
      if (this.jdField_a_of_type_Alfq != null) {
        this.jdField_a_of_type_Alfq.a(this.r);
      }
      switch (paramInt)
      {
      default: 
        if (this.jdField_a_of_type_Alfq != null) {
          this.jdField_a_of_type_Alfq.a(paramInt, true);
        }
        this.jdField_a_of_type_Bkys.sendEmptyMessage(1);
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
  
  private void b(ViewGroup paramViewGroup)
  {
    if (paramViewGroup != this.jdField_c_of_type_AndroidViewViewGroup)
    {
      if (this.jdField_c_of_type_AndroidViewViewGroup != null) {
        removeView(this.jdField_c_of_type_AndroidViewViewGroup);
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
    Scroller localScroller;
    int i2;
    int i3;
    if (this.jdField_e_of_type_Boolean)
    {
      this.jdField_a_of_type_Bkys.removeMessages(1);
      this.jdField_a_of_type_Bkys.removeMessages(2);
      this.jdField_a_of_type_Bkys.removeMessages(4);
      this.jdField_a_of_type_Bkys.removeMessages(3);
      this.jdField_e_of_type_Boolean = true;
      if (this.jdField_a_of_type_Alfq != null) {
        this.jdField_a_of_type_Alfq.a(this.r);
      }
      if (this.jdField_a_of_type_Alfq != null) {
        this.jdField_a_of_type_Alfq.a(this.r, false);
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
      this.jdField_a_of_type_Bkys.sendEmptyMessage(2);
      return;
      if (this.jdField_d_of_type_Boolean) {
        break;
      }
      return;
    }
  }
  
  private boolean d()
  {
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
  
  private boolean e()
  {
    return (this.jdField_c_of_type_Boolean) && (this.jdField_c_of_type_AndroidViewViewGroup != null) && (this.jdField_a_of_type_AndroidViewViewGroup != null);
  }
  
  private boolean f()
  {
    if (this.jdField_e_of_type_Boolean) {
      return true;
    }
    bgyd.b(this.jdField_a_of_type_AndroidViewViewGroup, false);
    b(this.r, 0);
    if (this.jdField_a_of_type_Alfq != null) {
      this.jdField_a_of_type_Alfq.a(this.r, this.o);
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
    bgyd.b(this.jdField_a_of_type_AndroidViewViewGroup, true);
    if (this.jdField_a_of_type_Alfq != null) {
      this.jdField_a_of_type_Alfq.b(this.r, this.o);
    }
    this.o = 0;
    this.r = 0;
    this.jdField_i_of_type_Boolean = true;
    b(this.r, 1);
    int i1;
    if ((BaseActivity.sTopActivity instanceof FragmentActivity))
    {
      Fragment localFragment = ((FragmentActivity)BaseActivity.sTopActivity).getSupportFragmentManager().findFragmentByTag(MainFragment.class.getName());
      if (localFragment != null)
      {
        i1 = ((MainFragment)localFragment).a();
        if (i1 != MainFragment.jdField_b_of_type_Int) {
          break label118;
        }
        ApngImage.playByTag(2);
      }
    }
    for (;;)
    {
      return false;
      label118:
      if (i1 == MainFragment.jdField_d_of_type_Int) {
        ApngImage.playByTag(3);
      } else if (i1 == MainFragment.jdField_e_of_type_Int) {
        ApngImage.playByTag(4);
      } else if (i1 == MainFragment.jdField_g_of_type_Int) {
        ApngImage.playByTag(5);
      } else if (i1 == MainFragment.jdField_h_of_type_Int) {
        ApngImage.playByTag(8);
      }
    }
  }
  
  private boolean h()
  {
    if ((this.s == 1) && (this.p > this.q)) {}
    while ((this.s == 0) && (this.p < this.q)) {
      return false;
    }
    return true;
  }
  
  private void j()
  {
    if (this.jdField_e_of_type_Boolean)
    {
      this.jdField_a_of_type_Bkys.removeMessages(1);
      this.jdField_a_of_type_Bkys.removeMessages(2);
      this.jdField_a_of_type_Bkys.removeMessages(4);
      this.jdField_a_of_type_Bkys.removeMessages(3);
    }
  }
  
  private void k()
  {
    int i1;
    if (b())
    {
      i1 = 0;
      if (this.r != 0) {
        break label87;
      }
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
      if (jdField_a_of_type_Boolean) {
        a("MSG_CONFIGURATION_CHANGED", Integer.valueOf(i1));
      }
      return;
      label87:
      if (this.r == 1)
      {
        i1 = -this.jdField_d_of_type_Int - this.jdField_b_of_type_Int;
        this.jdField_b_of_type_Int = (-this.jdField_d_of_type_Int);
      }
    }
  }
  
  private void l()
  {
    boolean bool = this.jdField_a_of_type_AndroidWidgetScroller.computeScrollOffset();
    int i1 = this.jdField_a_of_type_AndroidWidgetScroller.getCurrX();
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
      this.jdField_d_of_type_Boolean = false;
      if (this.jdField_c_of_type_AndroidViewViewGroup != null) {
        this.jdField_c_of_type_AndroidViewViewGroup.setVisibility(8);
      }
      if (this.jdField_a_of_type_AndroidViewView != null) {
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      }
      this.jdField_a_of_type_Bkys.sendEmptyMessage(4);
      return;
    }
    this.jdField_a_of_type_Bkys.sendEmptyMessage(2);
  }
  
  private void m()
  {
    boolean bool = this.jdField_a_of_type_AndroidWidgetScroller.computeScrollOffset();
    int i1 = this.jdField_a_of_type_AndroidWidgetScroller.getCurrX();
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
      this.jdField_a_of_type_Bkys.sendEmptyMessage(3);
      return;
    }
    this.jdField_a_of_type_Bkys.sendEmptyMessage(1);
  }
  
  public int a()
  {
    return this.jdField_i_of_type_Int;
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
    this.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(paramInt));
  }
  
  @TargetApi(11)
  protected void a(int paramInt1, int paramInt2)
  {
    b(paramInt1, 2);
    float f1;
    float f2;
    if (Build.VERSION.SDK_INT >= 11)
    {
      if (paramInt1 != 0) {
        break label102;
      }
      f1 = paramInt2 / this.jdField_c_of_type_Int;
      if (paramInt1 != 0) {
        break label115;
      }
      f2 = this.p * (f1 - 1.0F);
      label42:
      if (paramInt1 != 0) {
        break label130;
      }
    }
    label130:
    for (Object localObject = this.jdField_c_of_type_AndroidViewViewGroup;; localObject = this.jdField_a_of_type_AndroidViewView)
    {
      if (localObject != null) {
        ((View)localObject).setTranslationX(f2);
      }
      if (this.jdField_d_of_type_AndroidViewViewGroup != null) {
        this.jdField_d_of_type_AndroidViewViewGroup.setTranslationX(f2);
      }
      if (this.jdField_a_of_type_Alfq != null) {
        this.jdField_a_of_type_Alfq.a(this.r, f1);
      }
      return;
      label102:
      f1 = -paramInt2 / this.jdField_d_of_type_Int;
      break;
      label115:
      f2 = -this.p * (f1 - 1.0F);
      break label42;
    }
  }
  
  public void a(ViewGroup paramViewGroup1, ViewGroup paramViewGroup2, View paramView, ViewGroup paramViewGroup3)
  {
    int i1 = ((WindowManager)getContext().getSystemService("window")).getDefaultDisplay().getWidth();
    int i2 = i1 - b();
    int i3 = ScreenUtil.dip2px(170.0F);
    if (QLog.isColorLevel()) {
      QLog.d("DrawerFrame", 2, "Screen:(" + i1 + "," + ScreenUtil.SCREEN_HIGHT + ") cover:(" + i2 + "," + i3 + ")");
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
      this.jdField_c_of_type_AndroidViewView.setContentDescription(anvx.a(2131703013));
      paramViewGroup1 = new FrameLayout.LayoutParams(this.jdField_c_of_type_Int, this.l, 21);
      addView(this.jdField_c_of_type_AndroidViewView, paramViewGroup1);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DrawerFrame", 2, "onMultiWindowModeChanged, isInMultiWindowMode:" + paramBoolean);
    }
    RandomCoverView localRandomCoverView = (RandomCoverView)this.jdField_d_of_type_AndroidViewViewGroup.findViewById(2131379220);
    if (localRandomCoverView != null)
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localRandomCoverView.getLayoutParams();
      localLayoutParams.width = (ScreenUtil.SCREEN_WIDTH - b());
      localLayoutParams.height = ScreenUtil.dip2px(170.0F);
      localRandomCoverView.setLayoutParams(localLayoutParams);
      localRandomCoverView.setDefaultCoverBg();
    }
  }
  
  public boolean a()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public int b()
  {
    this.k = getContext().getResources().getDimensionPixelSize(2131298438);
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
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.getActivity().app;
    Object localObject2;
    if ((BaseActivity.sTopActivity instanceof FragmentActivity))
    {
      localObject2 = ((FragmentActivity)BaseActivity.sTopActivity).getSupportFragmentManager().findFragmentByTag(MainFragment.class.getName());
      if (localObject2 == null) {}
    }
    for (int i1 = ((MainFragment)localObject2).a();; i1 = -1)
    {
      boolean bool1;
      if ((!((QQAppInterface)localObject1).isInCallList) && (this.jdField_i_of_type_Boolean))
      {
        localObject1 = MotionEvent.obtain(paramMotionEvent);
        if ((localObject1 != null) && (i1 != -1))
        {
          localObject2 = (alfs)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(i1));
          if (localObject2 != null)
          {
            bool1 = ((alfs)localObject2).interceptDrawer(this, (MotionEvent)localObject1);
            bool2 = bool1;
            if (localObject1 != null) {
              ((MotionEvent)localObject1).recycle();
            }
          }
        }
      }
      for (boolean bool2 = bool1;; bool2 = false)
      {
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
        bool1 = false;
        break;
      }
    }
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
    this.jdField_a_of_type_Bkys.removeMessages(1);
    this.jdField_a_of_type_Bkys.removeMessages(2);
    this.jdField_a_of_type_Bkys.removeMessages(4);
    this.jdField_a_of_type_Bkys.removeMessages(3);
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
      this.jdField_a_of_type_Bkys.sendEmptyMessage(4);
    }
    b(this.r, 1);
    jdField_a_of_type_Int = 0;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 1: 
    case 2: 
    case 4: 
    case 3: 
      do
      {
        do
        {
          return true;
          m();
          return true;
          l();
          return true;
        } while (!g());
        return true;
      } while (!f());
      return true;
    }
    k();
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
    if (!e()) {}
    while (!this.jdField_b_of_type_Boolean) {
      return false;
    }
    int i1 = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    int i2 = (int)(paramMotionEvent.getX() + 0.5F);
    int i3 = (int)(paramMotionEvent.getY() + 0.5F);
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    default: 
      return false;
    case 0: 
      return a(i2, i3);
    case 2: 
      return a(i1, i2, i3);
    }
    return d();
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
      while (h())
      {
        if (this.t == 2)
        {
          this.t = 0;
          if (!this.jdField_a_of_type_Bkys.hasMessages(5)) {
            this.jdField_a_of_type_Bkys.sendEmptyMessage(5);
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
      if (!h()) {
        break label178;
      }
      if (this.t == 1)
      {
        this.t = 2;
        if (jdField_a_of_type_Boolean) {
          a("onMeasure", "valid orientation");
        }
      }
    }
    label178:
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
    if (!e()) {}
    while (!this.jdField_b_of_type_Boolean) {
      return false;
    }
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(getContext());
    int i1 = (int)(paramMotionEvent.getX() + 0.5F);
    int i2 = (int)(paramMotionEvent.getY() + 0.5F);
    int i3 = this.jdField_f_of_type_Int;
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
      j();
    case 2: 
      return a(i1 - i3);
    }
    return a(localViewConfiguration);
  }
  
  public void setDrawerCallbacks(alfq paramalfq)
  {
    this.jdField_a_of_type_Alfq = paramalfq;
  }
  
  public void setDrawerEnabled(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public void setDrawerShadowFlag(boolean paramBoolean)
  {
    this.jdField_h_of_type_Boolean = paramBoolean;
  }
  
  public void setMiniAppTouchEventInterceptor(int paramInt, alfs paramalfs)
  {
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), paramalfs);
  }
  
  public void setStoryTouchEventInterceptor(alfs paramalfs)
  {
    this.jdField_a_of_type_Alfs = paramalfs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.DrawerFrame
 * JD-Core Version:    0.7.0.1
 */