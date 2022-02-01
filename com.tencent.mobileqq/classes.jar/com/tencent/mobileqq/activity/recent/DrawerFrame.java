package com.tencent.mobileqq.activity.recent;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
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
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.widget.RandomCoverView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.util.HashMap;
import java.util.Map;

public class DrawerFrame
  extends FrameLayout
  implements Handler.Callback
{
  public static final boolean a = ;
  public static int b = 0;
  private int A;
  private int B;
  private int C;
  private int D;
  private int E;
  private int F;
  private int G;
  private View H;
  private int I;
  private int J;
  private int K;
  private int L;
  private int M;
  private boolean N;
  private boolean O;
  private DrawerFrame.StoryTouchEventInterceptor P;
  private Map<Integer, DrawerFrame.StoryTouchEventInterceptor> Q;
  private boolean R;
  private FrameHelperActivity S;
  private StringBuilder T;
  public boolean c;
  protected DrawerFrame.ContentViewOutlineProvider d;
  private boolean e = true;
  private boolean f;
  private boolean g;
  private boolean h;
  private boolean i;
  private int j;
  private int k;
  private int l;
  private int m;
  private int n;
  private int o;
  private int p;
  private WeakReferenceHandler q;
  private Scroller r;
  private ViewGroup s;
  private ViewGroup t;
  private ViewGroup u;
  private View v;
  private ViewGroup w;
  private View x;
  private VelocityTracker y;
  private DrawerFrame.IDrawerCallbacks z;
  
  public DrawerFrame(Context paramContext, ViewGroup paramViewGroup1, ViewGroup paramViewGroup2, View paramView, ViewGroup paramViewGroup3, FrameHelperActivity paramFrameHelperActivity)
  {
    super(paramContext);
    boolean bool = false;
    this.f = false;
    this.g = false;
    this.h = false;
    this.i = true;
    this.j = 0;
    this.K = 0;
    this.L = -1;
    this.M = 0;
    this.N = true;
    this.O = true;
    this.Q = new HashMap();
    this.c = true;
    this.d = new DrawerFrame.ContentViewOutlineProvider();
    if (paramContext != null)
    {
      Resources localResources = paramContext.getResources();
      DisplayMetrics localDisplayMetrics = localResources.getDisplayMetrics();
      this.G = 0;
      double d1 = localDisplayMetrics.density * 100.0F;
      Double.isNaN(d1);
      this.A = ((int)(d1 + 0.5D));
      this.C = localResources.getDimensionPixelSize(2131299233);
      this.l = localResources.getDimensionPixelSize(2131299649);
      this.B = 0;
      if (Build.VERSION.SDK_INT >= 11) {
        bool = true;
      }
      this.i = bool;
      this.q = new WeakReferenceHandler(Looper.getMainLooper(), this);
      this.r = new Scroller(paramContext, new DrawerFrame.BezierInterpolator(0.165F, 0.84F, 0.44F, 1.0F));
      if ((paramContext instanceof Activity)) {
        this.L = DeviceInfoUtil.a((Activity)paramContext);
      } else {
        this.L = paramContext.getResources().getConfiguration().orientation;
      }
      if (a) {
        a("DrawerFrame", null);
      }
      this.S = paramFrameHelperActivity;
      a(paramViewGroup1, paramViewGroup2, paramView, paramViewGroup3);
      c(this.K, 1);
      setBackgroundColor(Color.parseColor("#000000"));
      return;
    }
    throw new NullPointerException("context is null");
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    this.G = 2;
    if (!this.f)
    {
      b(paramInt, paramBoolean);
      return;
    }
    b(paramBoolean);
  }
  
  private void a(View paramView)
  {
    View localView = this.v;
    if (paramView != localView)
    {
      if (localView != null) {
        removeView(localView);
      }
      this.v = paramView;
      if (this.v != null)
      {
        paramView = new FrameLayout.LayoutParams(-2, -1, 21);
        addView(this.v, paramView);
      }
    }
  }
  
  private void a(ViewGroup paramViewGroup)
  {
    ViewGroup localViewGroup = this.s;
    if (paramViewGroup != localViewGroup)
    {
      if (localViewGroup != null)
      {
        removeView(localViewGroup);
        localViewGroup = this.t;
        if (localViewGroup != null)
        {
          localViewGroup.removeView(this);
          this.t.addView(this.s);
          this.t.setOnClickListener(null);
          this.t = null;
        }
      }
      this.s = paramViewGroup;
      AccessibilityUtil.b(this.s, true);
      paramViewGroup = this.s;
      if (paramViewGroup != null)
      {
        paramViewGroup = paramViewGroup.getParent();
        if ((paramViewGroup instanceof ViewGroup))
        {
          this.t = ((ViewGroup)paramViewGroup);
          this.t.removeView(this.s);
        }
        else
        {
          this.t = null;
        }
        paramViewGroup = new FrameLayout.LayoutParams(-1, -1);
        addView(this.s, paramViewGroup);
      }
      if (this.i)
      {
        if (this.x == null)
        {
          this.x = new View(getContext());
          this.x.setBackgroundColor(-16777216);
          this.x.setAlpha(0.0F);
        }
        this.N = true;
        paramViewGroup = new FrameLayout.LayoutParams(-1, -1);
        addView(this.x, paramViewGroup);
      }
      else
      {
        paramViewGroup = this.x;
        if (paramViewGroup != null) {
          removeView(paramViewGroup);
        }
      }
      paramViewGroup = this.t;
      if (paramViewGroup != null)
      {
        paramViewGroup.addView(this);
        this.t.setOnClickListener(new DrawerFrame.1(this));
      }
    }
  }
  
  private void a(ViewGroup paramViewGroup, int paramInt1, int paramInt2)
  {
    Object localObject = this.w;
    if (paramViewGroup != localObject)
    {
      if (localObject != null) {
        removeView((View)localObject);
      }
      this.w = paramViewGroup;
      paramViewGroup = this.w;
      if (paramViewGroup != null)
      {
        paramViewGroup = (RandomCoverView)paramViewGroup.findViewById(2131447715);
        if (paramViewGroup != null)
        {
          localObject = (RelativeLayout.LayoutParams)paramViewGroup.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject).width = -1;
          ((RelativeLayout.LayoutParams)localObject).height = paramInt2;
          paramViewGroup.setLayoutParams((ViewGroup.LayoutParams)localObject);
          paramViewGroup.setDefaultCoverBg();
        }
        paramViewGroup = new FrameLayout.LayoutParams(-1, -1);
        addView(this.w, paramViewGroup);
      }
    }
  }
  
  private void a(String paramString, Object paramObject)
  {
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = this.T;
      if (localStringBuilder == null) {
        this.T = new StringBuilder(120);
      } else {
        localStringBuilder.setLength(0);
      }
      localStringBuilder = this.T;
      localStringBuilder.append(paramString);
      localStringBuilder.append(", mConfigurationFlag = ");
      localStringBuilder.append(this.M);
      localStringBuilder.append(", mCurOrientation = ");
      localStringBuilder.append(this.L);
      localStringBuilder.append(", mDecorOffsetX = ");
      localStringBuilder.append(this.j);
      localStringBuilder.append(", mLeftDrawerWidth = ");
      localStringBuilder.append(this.k);
      localStringBuilder.append(", mConfigurationFlag = ");
      localStringBuilder.append(this.M);
      localStringBuilder.append(", mWidth = ");
      localStringBuilder.append(this.I);
      localStringBuilder.append(", mHeight =");
      localStringBuilder.append(this.J);
      localStringBuilder.append(", param = ");
      localStringBuilder.append(paramObject);
      QLog.i("DrawerFrame", 4, this.T.toString());
    }
  }
  
  private boolean a(int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool1 = this.h;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    if ((!this.f) && ((paramInt2 < this.n) || (paramInt2 < this.m)))
    {
      this.h = false;
      return false;
    }
    this.n = paramInt2;
    this.p = paramInt3;
    paramInt2 = Math.abs(this.n - this.m);
    paramInt3 = Math.abs(this.p - this.o);
    if (this.f)
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
    if ((bool1) && (this.g))
    {
      this.q.removeMessages(1);
      this.q.removeMessages(2);
      this.q.removeMessages(4);
      this.q.removeMessages(3);
    }
    return bool1;
  }
  
  private boolean a(ViewConfiguration paramViewConfiguration)
  {
    this.h = false;
    this.g = false;
    this.y.computeCurrentVelocity(1000);
    if (Math.abs(this.y.getXVelocity()) > paramViewConfiguration.getScaledMinimumFlingVelocity())
    {
      if (this.K == 0)
      {
        if (this.y.getXVelocity() > 0.0F)
        {
          this.f = false;
          f();
          return true;
        }
        this.f = true;
        i();
        return true;
      }
      if (this.y.getXVelocity() < 0.0F)
      {
        this.f = false;
        g();
        return true;
      }
      this.f = true;
      i();
      return true;
    }
    if (this.K == 0)
    {
      d1 = this.j;
      d2 = this.I;
      Double.isNaN(d2);
      if (d1 > d2 / 2.0D)
      {
        this.f = false;
        f();
        return true;
      }
      this.f = true;
      i();
      return true;
    }
    double d1 = this.j;
    double d2 = this.l;
    Double.isNaN(d2);
    if (d1 < -(d2 / 3.0D * 2.0D))
    {
      this.f = false;
      g();
      return true;
    }
    this.f = true;
    i();
    return true;
  }
  
  private void b(int paramInt, boolean paramBoolean)
  {
    if (!n()) {
      return;
    }
    this.K = paramInt;
    if (this.g)
    {
      this.q.removeMessages(1);
      this.q.removeMessages(2);
      this.q.removeMessages(4);
      this.q.removeMessages(3);
    }
    else if (this.f)
    {
      return;
    }
    int i1 = this.K;
    if (i1 == 0) {
      this.u.setVisibility(0);
    } else if (i1 == 1) {
      this.v.setVisibility(0);
    }
    this.g = true;
    Object localObject = this.z;
    if (localObject != null) {
      ((DrawerFrame.IDrawerCallbacks)localObject).a(this.K);
    }
    int i2;
    int i3;
    if (paramInt != 0)
    {
      if (paramInt == 1)
      {
        localObject = this.r;
        i2 = this.j;
        i3 = -this.l;
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
      localObject = this.r;
      i2 = this.j;
      i3 = this.k;
      if (paramBoolean) {
        i1 = 300;
      } else {
        i1 = 1;
      }
      ((Scroller)localObject).startScroll(i2, 0, i3 - i2, 0, i1);
    }
    localObject = this.z;
    if (localObject != null) {
      ((DrawerFrame.IDrawerCallbacks)localObject).a(paramInt, true);
    }
    this.q.sendEmptyMessage(1);
  }
  
  private void b(ViewGroup paramViewGroup)
  {
    ViewGroup localViewGroup = this.u;
    if (paramViewGroup != localViewGroup)
    {
      if (localViewGroup != null) {
        removeView(localViewGroup);
      }
      this.u = paramViewGroup;
      if (this.u != null)
      {
        paramViewGroup = new FrameLayout.LayoutParams(-1, -1, 19);
        addView(this.u, paramViewGroup);
      }
    }
  }
  
  private void b(boolean paramBoolean)
  {
    ApngImage.pauseByTag(1);
    if (!n()) {
      return;
    }
    if (this.g)
    {
      this.q.removeMessages(1);
      this.q.removeMessages(2);
      this.q.removeMessages(4);
      this.q.removeMessages(3);
    }
    else if (!this.f)
    {
      return;
    }
    this.g = true;
    Object localObject = this.z;
    if (localObject != null) {
      ((DrawerFrame.IDrawerCallbacks)localObject).a(this.K);
    }
    localObject = this.z;
    if (localObject != null) {
      ((DrawerFrame.IDrawerCallbacks)localObject).a(this.K, false);
    }
    localObject = this.r;
    int i2 = this.j;
    int i3 = -i2;
    int i1;
    if (paramBoolean) {
      i1 = 300;
    } else {
      i1 = 0;
    }
    ((Scroller)localObject).startScroll(i2, 0, i3, 0, i1);
    this.q.sendEmptyMessage(2);
  }
  
  private boolean b(int paramInt)
  {
    ApngImage.pauseAll();
    boolean bool = this.g;
    this.g = true;
    if (!bool)
    {
      DrawerFrame.IDrawerCallbacks localIDrawerCallbacks = this.z;
      if (localIDrawerCallbacks != null)
      {
        localIDrawerCallbacks.a(this.K);
        if (QQTheme.isSimpleWhite()) {
          this.s.setBackgroundColor(-1);
        } else {
          this.s.setBackgroundColor(0);
        }
      }
    }
    this.G = 1;
    int i1 = this.K;
    int i2;
    int i3;
    if (i1 == 0)
    {
      i2 = this.j;
      i3 = this.k;
      if (i2 + paramInt > i3)
      {
        if (i2 == i3) {
          break label320;
        }
        this.f = true;
        this.j = i3;
        a(i1, this.j);
        invalidate();
        return true;
      }
    }
    i1 = this.K;
    if (i1 == 0)
    {
      i2 = this.j;
      if (i2 + paramInt < 0)
      {
        if (i2 == 0) {
          break label320;
        }
        this.f = false;
        this.j = 0;
        a(i1, this.j);
        invalidate();
        return true;
      }
    }
    i1 = this.K;
    if (i1 == 1)
    {
      i2 = this.j;
      i3 = this.l;
      if (i2 + paramInt < -i3)
      {
        if (i2 == -i3) {
          break label320;
        }
        this.f = true;
        this.j = (-i3);
        a(i1, this.j);
        invalidate();
        return true;
      }
    }
    i1 = this.K;
    if (i1 == 1)
    {
      i2 = this.j;
      if (i2 + paramInt > 0)
      {
        if (i2 == 0) {
          break label320;
        }
        this.f = false;
        this.j = 0;
        a(i1, this.j);
        invalidate();
        return true;
      }
    }
    this.j += paramInt;
    a(this.K, this.j);
    invalidate();
    label320:
    return true;
  }
  
  private boolean b(int paramInt1, int paramInt2)
  {
    this.n = paramInt1;
    this.m = paramInt1;
    this.p = paramInt2;
    this.o = paramInt2;
    if ((!this.f) || (this.m > this.B)) {
      this.h = true;
    }
    if ((this.g) && (((this.K == 0) && (this.m > this.j)) || ((this.K == 1) && (this.m < this.I + this.j))))
    {
      this.h = true;
      return true;
    }
    return false;
  }
  
  private void c(int paramInt1, int paramInt2)
  {
    int i2 = 8;
    int i1;
    if (paramInt2 == 1) {
      i1 = 8;
    } else {
      i1 = 0;
    }
    Object localObject = this.w;
    if ((localObject != null) && (((ViewGroup)localObject).getVisibility() != i1)) {
      this.w.setVisibility(i1);
    }
    if ((paramInt2 != 1) && (paramInt1 != 1)) {
      i1 = 0;
    } else {
      i1 = 8;
    }
    localObject = this.u;
    if ((localObject != null) && (((ViewGroup)localObject).getVisibility() != i1)) {
      this.u.setVisibility(i1);
    }
    if ((paramInt2 != 1) && (paramInt1 != 0)) {
      paramInt1 = 0;
    } else {
      paramInt1 = 8;
    }
    localObject = this.v;
    if ((localObject != null) && (((View)localObject).getVisibility() != paramInt1)) {
      this.v.setVisibility(paramInt1);
    }
    if ((paramInt2 != 2) && (paramInt2 != 0)) {
      paramInt1 = 8;
    } else {
      paramInt1 = 0;
    }
    localObject = this.x;
    if ((localObject != null) && (((View)localObject).getVisibility() != paramInt1) && (this.N)) {
      this.x.setVisibility(paramInt1);
    }
    paramInt1 = i2;
    if (paramInt2 == 0) {
      paramInt1 = 0;
    }
    localObject = this.H;
    if ((localObject != null) && (((View)localObject).getVisibility() != paramInt1)) {
      this.H.setVisibility(paramInt1);
    }
  }
  
  private boolean l()
  {
    this.h = false;
    if (((this.f) && (this.K == 0) && (this.m > this.k)) || ((this.K == 1) && (this.m < this.I - this.l)))
    {
      this.G = 3;
      int i1 = this.o;
      if ((i1 >= this.E) && (i1 <= this.F)) {
        this.G = 4;
      }
      i();
      this.n = -1;
      this.m = -1;
      this.p = -1;
      this.o = -1;
      return true;
    }
    this.n = -1;
    this.m = -1;
    this.p = -1;
    this.o = -1;
    return false;
  }
  
  private void m()
  {
    if (this.g)
    {
      this.q.removeMessages(1);
      this.q.removeMessages(2);
      this.q.removeMessages(4);
      this.q.removeMessages(3);
    }
  }
  
  private boolean n()
  {
    return (this.e) && (this.u != null) && (this.s != null);
  }
  
  private void o()
  {
    if (j())
    {
      int i1 = this.K;
      int i2;
      if (i1 == 0)
      {
        i2 = this.k;
        i1 = i2 - this.j;
        this.j = i2;
      }
      else if (i1 == 1)
      {
        i2 = this.l;
        i1 = -i2 - this.j;
        this.j = (-i2);
      }
      else
      {
        i1 = 0;
      }
      ViewGroup localViewGroup = this.s;
      if ((localViewGroup != null) && (i1 != 0))
      {
        localViewGroup.offsetLeftAndRight(i1);
        a(this.K, this.j);
        postInvalidate();
      }
      if (a) {
        a("MSG_CONFIGURATION_CHANGED", Integer.valueOf(i1));
      }
    }
  }
  
  private boolean p()
  {
    if (this.g) {
      return true;
    }
    AccessibilityUtil.b(this.s, false);
    c(this.K, 0);
    DrawerFrame.IDrawerCallbacks localIDrawerCallbacks = this.z;
    if (localIDrawerCallbacks != null) {
      localIDrawerCallbacks.a(this.K, this.G);
    }
    this.G = 0;
    this.O = false;
    ApngImage.playByTag(1);
    return false;
  }
  
  private boolean q()
  {
    if (this.g) {
      return true;
    }
    AccessibilityUtil.b(this.s, true);
    Object localObject = this.z;
    if (localObject != null) {
      ((DrawerFrame.IDrawerCallbacks)localObject).b(this.K, this.G);
    }
    this.G = 0;
    this.K = 0;
    this.O = true;
    c(this.K, 1);
    if ((BaseActivity.sTopActivity instanceof BaseActivity))
    {
      localObject = (QBaseFragment)BaseActivity.sTopActivity.getSupportFragmentManager().findFragmentByTag(MainFragment.class.getName());
      if (localObject != null)
      {
        int i1 = ((MainFragment)localObject).w();
        if (i1 == FrameControllerUtil.a)
        {
          ApngImage.playByTag(2);
          return false;
        }
        if (i1 == FrameControllerUtil.c)
        {
          ApngImage.playByTag(3);
          return false;
        }
        if (i1 == FrameControllerUtil.d)
        {
          ApngImage.playByTag(4);
          return false;
        }
        if (i1 == FrameControllerUtil.f)
        {
          ApngImage.playByTag(5);
          return false;
        }
        if (i1 == FrameControllerUtil.g) {
          ApngImage.playByTag(8);
        }
      }
    }
    return false;
  }
  
  private void r()
  {
    boolean bool = this.r.computeScrollOffset();
    this.r.getCurrX();
    int i1 = this.j;
    this.j = this.r.getCurrX();
    if (this.s != null) {
      a(this.K, this.j);
    }
    postInvalidate();
    if (!bool)
    {
      this.g = false;
      this.f = false;
      Object localObject = this.u;
      if (localObject != null) {
        ((ViewGroup)localObject).setVisibility(8);
      }
      localObject = this.v;
      if (localObject != null) {
        ((View)localObject).setVisibility(8);
      }
      this.q.sendEmptyMessage(4);
      return;
    }
    this.q.sendEmptyMessage(2);
  }
  
  private void s()
  {
    boolean bool = this.r.computeScrollOffset();
    this.r.getCurrX();
    int i1 = this.j;
    this.j = this.r.getCurrX();
    if (this.s != null) {
      a(this.K, this.j);
    }
    postInvalidate();
    if (!bool)
    {
      this.g = false;
      this.f = true;
      this.q.sendEmptyMessage(3);
      return;
    }
    this.q.sendEmptyMessage(1);
  }
  
  private boolean t()
  {
    if ((this.L == 1) && (this.I > this.J)) {
      return false;
    }
    return (this.L != 0) || (this.I >= this.J);
  }
  
  public void a()
  {
    View localView = this.x;
    if (localView != null) {
      localView.setVisibility(0);
    }
    this.N = true;
  }
  
  public void a(int paramInt)
  {
    this.Q.remove(Integer.valueOf(paramInt));
  }
  
  @TargetApi(11)
  protected void a(int paramInt1, int paramInt2)
  {
    c(paramInt1, 2);
    if (Build.VERSION.SDK_INT >= 11)
    {
      float f1;
      if (paramInt1 == 0)
      {
        f1 = paramInt2;
        paramInt1 = this.k;
      }
      else
      {
        f1 = -paramInt2;
        paramInt1 = this.l;
      }
      f1 /= paramInt1;
      float f2 = 1.0F - 0.1F * f1;
      Object localObject = this.s;
      ((ViewGroup)localObject).setPivotX(((ViewGroup)localObject).getWidth() / 2.0F);
      localObject = this.s;
      ((ViewGroup)localObject).setPivotY(((ViewGroup)localObject).getHeight() / 2.0F);
      localObject = this.s;
      if (localObject != null)
      {
        ((ViewGroup)localObject).setScaleX(f2);
        this.s.setScaleY(f2);
        a(this.s, 30.0F * f1);
      }
      localObject = this.x;
      if (localObject != null) {
        ((View)localObject).setAlpha(0.5F * f1);
      }
      localObject = this.w;
      if (localObject != null) {
        ((ViewGroup)localObject).setTranslationX(paramInt2 - this.k);
      }
      this.u.setTranslationX(paramInt2 - this.k);
      localObject = this.z;
      if (localObject != null) {
        ((DrawerFrame.IDrawerCallbacks)localObject).a(this.K, f1);
      }
    }
  }
  
  protected void a(View paramView, float paramFloat)
  {
    if (paramView == null) {
      return;
    }
    if (paramFloat > 0.0F)
    {
      this.d.a(DisplayUtil.a(BaseApplication.getContext(), paramFloat));
      paramView.setOutlineProvider(this.d);
      paramView.setClipToOutline(true);
      return;
    }
    paramView.setOutlineProvider(null);
    paramView.setClipToOutline(false);
  }
  
  public void a(ViewGroup paramViewGroup1, ViewGroup paramViewGroup2, View paramView, ViewGroup paramViewGroup3)
  {
    int i1 = ((WindowManager)getContext().getSystemService("window")).getDefaultDisplay().getWidth();
    int i2 = i1 - getTargetWidth();
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
    a(paramViewGroup1);
    a(paramViewGroup3, i2, i3);
    b(paramViewGroup2);
    a(paramView);
    if ((this.u != null) && (this.H == null))
    {
      this.H = new View(getContext());
      this.H.setFocusable(true);
      this.H.setFocusableInTouchMode(true);
      this.H.setClickable(true);
      this.H.setVisibility(8);
      this.H.setBackgroundResource(17170445);
      this.H.setContentDescription(HardCodeUtil.a(2131901641));
      paramViewGroup1 = new FrameLayout.LayoutParams(this.k, this.D, 21);
      addView(this.H, paramViewGroup1);
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
    Object localObject = (RandomCoverView)this.w.findViewById(2131447715);
    if (localObject != null)
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((RandomCoverView)localObject).getLayoutParams();
      localLayoutParams.width = (ScreenUtil.SCREEN_WIDTH - getTargetWidth());
      localLayoutParams.height = ScreenUtil.dip2px(170.0F);
      ((RandomCoverView)localObject).setLayoutParams(localLayoutParams);
      ((RandomCoverView)localObject).setDefaultCoverBg();
    }
  }
  
  public boolean b()
  {
    return this.e;
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.i("DrawerFrame", 2, "stopMovingOnPause");
    }
    if (this.K == 0)
    {
      d1 = this.j;
      d2 = this.I;
      Double.isNaN(d2);
      if (d1 > d2 / 2.0D)
      {
        this.f = false;
        f();
        return;
      }
      this.f = true;
      i();
      return;
    }
    double d1 = this.j;
    double d2 = this.l;
    Double.isNaN(d2);
    if (d1 < -(d2 / 3.0D * 2.0D))
    {
      this.f = false;
      g();
      return;
    }
    this.f = true;
    i();
  }
  
  public void d()
  {
    a(0, true);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    Object localObject1 = (QQAppInterface)this.S.getQBaseActivity().getAppRuntime();
    Object localObject2;
    if ((BaseActivity.sTopActivity instanceof BaseActivity))
    {
      localObject2 = (QBaseFragment)BaseActivity.sTopActivity.getSupportFragmentManager().findFragmentByTag(MainFragment.class.getName());
      if (localObject2 != null)
      {
        i1 = ((MainFragment)localObject2).w();
        break label63;
      }
    }
    int i1 = -1;
    label63:
    boolean bool2;
    if ((!((QQAppInterface)localObject1).isInCallList) && (this.O))
    {
      localObject1 = MotionEvent.obtain(paramMotionEvent);
      if ((localObject1 != null) && (i1 != -1))
      {
        localObject2 = (DrawerFrame.StoryTouchEventInterceptor)this.Q.get(Integer.valueOf(i1));
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
      this.R = false;
    }
    if ((this.R) && (!bool2)) {
      paramMotionEvent.setAction(0);
    }
    this.R = bool2;
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
  
  public DrawerFrame.IDrawerCallbacks getDrawerCallbacks()
  {
    return this.z;
  }
  
  public int getDrawerContentTranslatexMax()
  {
    return this.A;
  }
  
  public View getRightDrawerContent()
  {
    return this.v;
  }
  
  public int getTargetWidth()
  {
    this.C = getContext().getResources().getDimensionPixelSize(2131299233);
    return this.C;
  }
  
  public void h()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("DrawerFrame", 4, "resetDrawer()");
    }
    this.q.removeMessages(1);
    this.q.removeMessages(2);
    this.q.removeMessages(4);
    this.q.removeMessages(3);
    this.g = false;
    this.K = 0;
    this.j = 0;
    ViewGroup localViewGroup = this.s;
    if (localViewGroup != null) {
      localViewGroup.offsetLeftAndRight(0 - localViewGroup.getLeft());
    }
    a(this.K, this.j);
    postInvalidate();
    if (this.f)
    {
      this.f = false;
      this.q.sendEmptyMessage(4);
    }
    c(this.K, 1);
    b = 0;
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
            o();
            return true;
          }
          if (q()) {
            return true;
          }
        }
        else if (p())
        {
          return true;
        }
      }
      else
      {
        r();
        return true;
      }
    }
    else {
      s();
    }
    return true;
  }
  
  public void i()
  {
    b(true);
  }
  
  public boolean j()
  {
    return this.f;
  }
  
  public boolean k()
  {
    return this.g;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    if (paramConfiguration.orientation != this.L)
    {
      this.L = paramConfiguration.orientation;
      if ((j()) && (this.M == 0)) {
        this.M = 1;
      }
      if (a) {
        a("onConfigurationChanged", Boolean.valueOf(j()));
      }
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!n()) {
      return false;
    }
    if (!this.c) {
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
      return l();
    }
    return b(i2, i3);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Object localObject = this.w;
    if ((localObject != null) && (((ViewGroup)localObject).getVisibility() != 8)) {
      this.w.layout(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    localObject = this.u;
    if ((localObject != null) && (((ViewGroup)localObject).getVisibility() != 8)) {
      this.u.layout(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    localObject = this.x;
    if (localObject != null) {
      ((View)localObject).layout(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    localObject = this.v;
    if ((localObject != null) && (((View)localObject).getVisibility() != 8)) {
      this.v.layout(paramInt3 - this.l, this.E, paramInt3, this.F);
    }
    localObject = this.s;
    if ((localObject != null) && (((ViewGroup)localObject).getVisibility() != 8))
    {
      localObject = this.s;
      ((ViewGroup)localObject).layout(((ViewGroup)localObject).getLeft(), this.s.getTop(), this.s.getLeft() + paramInt3, paramInt4);
    }
    localObject = this.H;
    if ((localObject != null) && (((View)localObject).getVisibility() != 8))
    {
      paramInt1 = this.K;
      if (paramInt1 == 0)
      {
        localObject = this.H;
        paramInt1 = this.k;
        ((View)localObject).layout(paramInt1, this.E, this.C + paramInt1, this.F);
      }
      else if (paramInt1 == 1)
      {
        this.H.layout(0, this.E, paramInt3 - this.l, this.F);
      }
    }
    if (t())
    {
      if (this.M == 2)
      {
        this.M = 0;
        if (!this.q.hasMessages(5)) {
          this.q.sendEmptyMessage(5);
        }
        if (a) {
          a("onLayout", "valid orientation");
        }
      }
    }
    else if (a) {
      a("onLayout", "not valid orientation");
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.I = getMeasuredWidth();
    this.J = getMeasuredHeight();
    this.k = (this.I - this.C);
    if (Build.VERSION.SDK_INT >= 11)
    {
      paramInt1 = this.J;
      double d1 = paramInt1 * 0.9F;
      Double.isNaN(d1);
      this.D = ((int)(d1 + 0.5D));
      this.E = ((int)(paramInt1 * 0.1F / 2.0F));
      this.F = (this.E + this.D);
    }
    else
    {
      this.D = this.J;
      this.E = 0;
      this.F = (this.E + this.D);
    }
    View localView = this.v;
    if (localView != null) {
      localView.getLayoutParams().height = this.D;
    }
    if (t())
    {
      if (this.M == 1)
      {
        this.M = 2;
        if (a) {
          a("onMeasure", "valid orientation");
        }
      }
    }
    else if (a) {
      a("onMeasure", "not valid orientation");
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!n()) {
      return false;
    }
    if (!this.c) {
      return false;
    }
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(getContext());
    int i1 = (int)(paramMotionEvent.getX() + 0.5F);
    int i3 = (int)(paramMotionEvent.getY() + 0.5F);
    int i2 = this.n;
    int i4 = this.p;
    if (this.y == null) {
      this.y = VelocityTracker.obtain();
    }
    this.y.addMovement(paramMotionEvent);
    this.n = i1;
    this.p = i3;
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
      m();
    }
    return b(i1 - i2);
  }
  
  public void setDrawerCallbacks(DrawerFrame.IDrawerCallbacks paramIDrawerCallbacks)
  {
    this.z = paramIDrawerCallbacks;
  }
  
  public void setDrawerEnabled(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public void setDrawerShadowFlag(boolean paramBoolean)
  {
    this.N = paramBoolean;
  }
  
  public void setMiniAppTouchEventInterceptor(int paramInt, DrawerFrame.StoryTouchEventInterceptor paramStoryTouchEventInterceptor)
  {
    this.Q.put(Integer.valueOf(paramInt), paramStoryTouchEventInterceptor);
  }
  
  public void setStoryTouchEventInterceptor(DrawerFrame.StoryTouchEventInterceptor paramStoryTouchEventInterceptor)
  {
    this.P = paramStoryTouchEventInterceptor;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.DrawerFrame
 * JD-Core Version:    0.7.0.1
 */