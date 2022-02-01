package com.tencent.mm.plugin.appbrand.widget;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewOutlineProvider;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.qx.a;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;
import com.tencent.mm.plugin.appbrand.ui.j;
import com.tencent.mm.plugin.appbrand.ui.j.a;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class e
  extends FrameLayout
{
  public static final int a = a.e(r.a(), 196);
  public static final int b = a.e(r.a(), 119);
  public static final int c = a.e(r.a(), 176);
  public static final int d = a.e(r.a(), 99);
  public static final int e = a.e(r.a(), 119);
  public static final int f = a.e(r.a(), 196);
  public static final int g = a.e(r.a(), 99);
  public static final int h = a.e(r.a(), 176);
  public static final int i = a.e(r.a(), 8);
  public static final int j = a.e(r.a(), 10);
  public static final int k = a.e(r.a(), 12);
  public static final int l = a.e(r.a(), 1);
  public static final int m = a.e(r.a(), 10);
  public static final int n = a.e(r.a(), 2);
  private static final int o = a.e(r.a(), 32);
  private static final int p = a.e(r.a(), 56);
  private static final int q = a.e(r.a(), 52);
  private static final int r = a.e(r.a(), 6);
  private static final int s = a.e(r.a(), 80);
  private static final int t = a.e(r.a(), 52);
  private static final int u = a.e(r.a(), 1);
  private static final Point v = new Point();
  @NonNull
  private Point A;
  private boolean B;
  @NonNull
  private PointF C;
  @NonNull
  private PointF D;
  private float E;
  private boolean F;
  private boolean G;
  private int H;
  private int I;
  @Nullable
  private Set<e.a> J;
  private int K;
  @Nullable
  private Float L;
  private ViewOutlineProvider M;
  private ValueAnimator N;
  private ViewGroup O;
  private View P;
  private View Q;
  private ViewGroup R;
  private View S;
  private View T;
  private View U;
  private boolean V;
  private boolean W;
  private boolean aa;
  @Nullable
  private j ab;
  @Nullable
  private Integer w = null;
  private int x;
  private int y;
  @NonNull
  private Point z;
  
  public e(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public e(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public e(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramAttributeSet = v;
    this.z = paramAttributeSet;
    this.A = paramAttributeSet;
    this.B = false;
    this.C = new PointF();
    this.D = new PointF();
    this.E = -1.0F;
    this.F = false;
    this.G = false;
    this.J = null;
    this.K = c;
    this.L = null;
    this.M = new e.1(this);
    this.V = true;
    this.W = true;
    this.aa = false;
    this.ab = null;
    b(paramContext);
  }
  
  private int a(int paramInt)
  {
    int i1 = this.z.x;
    int i3 = getMarginHorizontal();
    int i2 = i1 - paramInt - i3;
    i1 = i2;
    if (i2 < 0) {
      i1 = this.A.x - paramInt - i3;
    }
    return i1;
  }
  
  public static Point a(Context paramContext)
  {
    Point localPoint = new Point();
    if (paramContext == null) {
      return localPoint;
    }
    paramContext = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    if (Build.VERSION.SDK_INT >= 17)
    {
      paramContext.getRealSize(localPoint);
      return localPoint;
    }
    if (Build.VERSION.SDK_INT >= 14) {}
    try
    {
      Method localMethod = Display.class.getMethod("getRawHeight", new Class[0]);
      localPoint.x = ((Integer)Display.class.getMethod("getRawWidth", new Class[0]).invoke(paramContext, new Object[0])).intValue();
      localPoint.y = ((Integer)localMethod.invoke(paramContext, new Object[0])).intValue();
      return localPoint;
    }
    catch (Exception localException)
    {
      label114:
      break label114;
    }
    paramContext.getSize(localPoint);
    return localPoint;
    paramContext.getSize(localPoint);
    return localPoint;
  }
  
  private void a(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    float f1 = getX();
    float f2 = getX();
    if ((f1 != paramFloat1) || (f2 != paramFloat2))
    {
      setX(paramFloat1);
      setY(paramFloat2);
      a(paramFloat2, paramBoolean);
    }
  }
  
  private void a(float paramFloat, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      int i1 = getMinY();
      int i2 = b(getHeight());
      float f1 = i1;
      this.E = ((Math.min(Math.max(paramFloat, f1), i2) - f1) / (i2 - i1));
    }
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    ValueAnimator localValueAnimator = this.N;
    if ((localValueAnimator != null) && (localValueAnimator.isRunning())) {
      this.N.cancel();
    }
    this.N = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.N.setInterpolator(new AccelerateDecelerateInterpolator());
    this.N.setDuration(100L);
    this.N.addUpdateListener(new e.2(this, paramInt1, paramInt3, paramInt2, paramInt4));
    this.N.addListener(new e.3(this, paramInt3, paramInt4));
    this.N.start();
  }
  
  private void a(Configuration paramConfiguration)
  {
    Object localObject = (View)getParent();
    if (localObject == null)
    {
      o.e("MicroMsg.AppBrand.AppBrandPipContainerView", "adjustOnConfigurationChanged, null == parentView");
      return;
    }
    this.z = new Point(((View)localObject).getWidth(), ((View)localObject).getHeight());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("adjustOnConfigurationChanged, mParentViewSize: ");
    ((StringBuilder)localObject).append(this.z);
    o.d("MicroMsg.AppBrand.AppBrandPipContainerView", ((StringBuilder)localObject).toString());
    this.A = a(getContext());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("adjustOnConfigurationChanged, mScreenSize: ");
    ((StringBuilder)localObject).append(this.A);
    o.d("MicroMsg.AppBrand.AppBrandPipContainerView", ((StringBuilder)localObject).toString());
    if (this.y != paramConfiguration.orientation)
    {
      this.y = paramConfiguration.orientation;
      int i2 = getMinX();
      int i3 = a(getWidth());
      int i4 = getMinY();
      int i1 = b(getHeight());
      float f1 = getX();
      float f2 = i4;
      float f3 = this.E * (i1 - i4) + f2;
      i2 = (int)Math.max(Math.min(f1, i3), i2);
      i1 = (int)Math.max(Math.min(f3, i1), f2);
      i3 = getTargetPositionXWhenOrientationChanged();
      i4 = f(i1, getHeight());
      o.e("MicroMsg.AppBrand.AppBrandPipContainerView", "adjustOnConfigurationChanged, x: %f, y: %f, startPositionX: %d, startPositionY: %d, targetPositionX: %d, targetPositionY: %d", new Object[] { Float.valueOf(f1), Float.valueOf(f3), Integer.valueOf(i2), Integer.valueOf(i1), Integer.valueOf(i3), Integer.valueOf(i4) });
      a(i2, i1, i3, i4);
    }
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    this.C.x = paramMotionEvent.getRawX();
    this.C.y = paramMotionEvent.getRawY();
    this.D.x = ((int)getX());
    this.D.y = ((int)getY());
    paramMotionEvent = new StringBuilder();
    paramMotionEvent.append("recordPositionWhenActionDown, fingerPosOnDown: ");
    paramMotionEvent.append(this.C);
    paramMotionEvent.append(", viewPosOnDown: ");
    paramMotionEvent.append(this.D);
    o.d("MicroMsg.AppBrand.AppBrandPipContainerView", paramMotionEvent.toString());
  }
  
  private int b(int paramInt)
  {
    int i1 = this.z.y;
    int i3 = getMarginBottom();
    int i2 = i1 - paramInt - i3;
    i1 = i2;
    if (i2 < 0) {
      i1 = this.A.y - paramInt - i3;
    }
    return i1;
  }
  
  private void b(Context paramContext)
  {
    View localView = LayoutInflater.from(paramContext).inflate(2131624222, this);
    setBackgroundColor(0);
    this.T = localView.findViewById(2131428566);
    this.U = localView.findViewById(2131428565);
    this.U.setOutlineProvider(this.M);
    this.U.setClipToOutline(true);
    this.O = ((ViewGroup)localView.findViewById(2131428567));
    this.P = localView.findViewById(2131428564);
    this.Q = localView.findViewById(2131428570);
    this.Q.setVisibility(4);
    this.R = ((ViewGroup)localView.findViewById(2131428571));
    this.R.setVisibility(4);
    this.S = localView.findViewById(2131428572);
    this.S.setVisibility(4);
    a(this.K, j, i, k, l, m, n);
    this.x = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    this.y = paramContext.getResources().getConfiguration().orientation;
    this.A = a(paramContext);
    paramContext = new StringBuilder();
    paramContext.append("init, mScreenSize: ");
    paramContext.append(this.A);
    o.d("MicroMsg.AppBrand.AppBrandPipContainerView", paramContext.toString());
  }
  
  private boolean b(MotionEvent paramMotionEvent)
  {
    return (Math.abs(paramMotionEvent.getRawX() - this.C.x) > this.x) || (Math.abs(paramMotionEvent.getRawY() - this.C.y) > this.x);
  }
  
  private int c(MotionEvent paramMotionEvent)
  {
    int i2 = this.z.x;
    int i1 = i2;
    if (i2 <= 0)
    {
      i1 = this.A.x;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getMotionEventNewPositionX, mParentViewSize: ");
      localStringBuilder.append(this.z);
      localStringBuilder.append(", mScreenSize: ");
      localStringBuilder.append(this.A);
      o.c("MicroMsg.AppBrand.AppBrandPipContainerView", localStringBuilder.toString());
    }
    return (int)Math.max(Math.min(this.D.x + paramMotionEvent.getRawX() - this.C.x, i1 - getWidth()), 0.0F);
  }
  
  private int d(MotionEvent paramMotionEvent)
  {
    int i2 = this.z.y;
    int i1 = i2;
    if (i2 <= 0)
    {
      i1 = this.A.y;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getMotionEventNewPositionY, mParentViewSize: ");
      localStringBuilder.append(this.z);
      localStringBuilder.append(", mScreenSize: ");
      localStringBuilder.append(this.A);
      o.c("MicroMsg.AppBrand.AppBrandPipContainerView", localStringBuilder.toString());
    }
    return (int)Math.max(Math.min(this.D.y + paramMotionEvent.getRawY() - this.C.y, i1 - getHeight()), 0.0F);
  }
  
  @MainThread
  private void d(int paramInt1, int paramInt2)
  {
    Object localObject = this.J;
    if (localObject == null) {
      return;
    }
    localObject = ((Set)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((e.a)((Iterator)localObject).next()).a(paramInt1, paramInt2);
    }
  }
  
  private int e(int paramInt1, int paramInt2)
  {
    int i1 = getMinX();
    if (!g(paramInt1, paramInt2)) {
      i1 = a(paramInt2);
    }
    return i1;
  }
  
  private int f(int paramInt1, int paramInt2)
  {
    int i1 = getMinY();
    if (paramInt1 < i1) {
      return i1;
    }
    i1 = b(paramInt2);
    paramInt2 = paramInt1;
    if (paramInt1 > i1) {
      paramInt2 = i1;
    }
    return paramInt2;
  }
  
  private boolean g(int paramInt1, int paramInt2)
  {
    int i2 = this.z.x;
    int i1 = i2;
    if (i2 <= 0)
    {
      i1 = this.A.x;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isPositionLeft, mParentViewSize: ");
      localStringBuilder.append(this.z);
      localStringBuilder.append(", mScreenSize: ");
      localStringBuilder.append(this.A);
      o.c("MicroMsg.AppBrand.AppBrandPipContainerView", localStringBuilder.toString());
    }
    boolean bool;
    if (paramInt1 + paramInt2 / 2 <= i1 / 2) {
      bool = true;
    } else {
      bool = false;
    }
    this.F = bool;
    return this.F;
  }
  
  private int getMarginBottom()
  {
    if (1 == this.y) {
      return t;
    }
    return q;
  }
  
  private int getMarginHorizontal()
  {
    if (1 == this.y) {
      return r;
    }
    return o;
  }
  
  private int getMarginTopDefault()
  {
    if (1 == this.y) {
      return s;
    }
    return p;
  }
  
  private int getMinX()
  {
    return getMarginHorizontal();
  }
  
  private int getMinY()
  {
    Integer localInteger = this.w;
    if (localInteger != null) {
      return localInteger.intValue();
    }
    return getMarginTopDefault();
  }
  
  private int getTargetPositionXWhenOrientationChanged()
  {
    int i1 = getMinX();
    if (!this.F) {
      i1 = a(getWidth());
    }
    return i1;
  }
  
  public void a()
  {
    if (this.G)
    {
      o.e("MicroMsg.AppBrand.AppBrandPipContainerView", "setInitPositionIfNeed, already set");
      return;
    }
    int i1 = getWidth();
    int i2 = getHeight();
    int i3 = a(i1);
    int i4 = b(i2);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setInitPositionIfNeed, x: ");
    localStringBuilder.append(i3);
    localStringBuilder.append(", y: ");
    localStringBuilder.append(i4);
    o.d("MicroMsg.AppBrand.AppBrandPipContainerView", localStringBuilder.toString());
    setX(i3);
    setY(i4);
    a(getY(), true);
    b(i3, i1);
    c(i4, i2);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("setPosition, mStablePosX: ");
    localStringBuilder.append(this.H);
    localStringBuilder.append(", mStablePosY: ");
    localStringBuilder.append(this.I);
    o.d("MicroMsg.AppBrand.AppBrandPipContainerView", localStringBuilder.toString());
    d(this.H, this.I);
    this.G = true;
  }
  
  public void a(float paramFloat)
  {
    if (!this.W) {
      return;
    }
    this.R.setVisibility(0);
    this.S.setVisibility(0);
    ViewGroup.LayoutParams localLayoutParams = this.S.getLayoutParams();
    localLayoutParams.width = ((int)(this.K * paramFloat / 100.0F));
    this.S.setLayoutParams(localLayoutParams);
    this.L = Float.valueOf(paramFloat);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    b(this.H, paramInt1);
    c(this.I, paramInt2);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("adjustStablePos, mStablePosX: ");
    localStringBuilder.append(this.H);
    localStringBuilder.append(", mStablePosY: ");
    localStringBuilder.append(this.I);
    o.d("MicroMsg.AppBrand.AppBrandPipContainerView", localStringBuilder.toString());
    d(this.H, this.I);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    this.K = paramInt1;
    Object localObject = this.L;
    if (localObject != null) {
      a(((Float)localObject).floatValue());
    }
    this.T.setPadding(paramInt2, paramInt3, paramInt2, paramInt4);
    localObject = (FrameLayout.LayoutParams)this.U.getLayoutParams();
    ((FrameLayout.LayoutParams)localObject).leftMargin = paramInt2;
    ((FrameLayout.LayoutParams)localObject).rightMargin = paramInt2;
    ((FrameLayout.LayoutParams)localObject).topMargin = paramInt3;
    ((FrameLayout.LayoutParams)localObject).bottomMargin = paramInt4;
    this.U.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = new j.a().a(paramInt5).b(Color.parseColor("#4C000000")).c(paramInt6).d(0).e(paramInt7).a();
    if (this.aa)
    {
      j.a(this.T, (Drawable)localObject);
      return;
    }
    this.ab = ((j)localObject);
  }
  
  public void a(int paramInt, @Nullable Configuration paramConfiguration)
  {
    this.w = Integer.valueOf(paramInt - i);
    if (paramConfiguration != null) {
      a(paramConfiguration);
    }
  }
  
  public void a(@NonNull View paramView)
  {
    this.O.addView(paramView);
    paramView.setOutlineProvider(this.M);
    paramView.setClipToOutline(true);
    e();
  }
  
  @MainThread
  public void a(@NonNull e.a parama)
  {
    if (this.J == null) {
      this.J = new HashSet();
    }
    this.J.add(parama);
  }
  
  public void a(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("enableShadow, isEnabled: ");
    localStringBuilder.append(paramBoolean);
    o.d("MicroMsg.AppBrand.AppBrandPipContainerView", localStringBuilder.toString());
    this.aa = paramBoolean;
    if (paramBoolean)
    {
      if (this.ab != null)
      {
        o.d("MicroMsg.AppBrand.AppBrandPipContainerView", "enableShadow, setShadowDrawable");
        j.a(this.T, this.ab);
      }
    }
    else {
      j.a(this.T, null);
    }
  }
  
  public void b()
  {
    o.d("MicroMsg.AppBrand.AppBrandPipContainerView", "disableTouch");
    this.P.setVisibility(4);
    this.V = false;
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    this.H = e(paramInt1, paramInt2);
  }
  
  public void b(@NonNull View paramView)
  {
    this.O.removeView(paramView);
  }
  
  @MainThread
  public void b(@NonNull e.a parama)
  {
    Set localSet = this.J;
    if (localSet == null) {
      return;
    }
    localSet.remove(parama);
    if (this.J.isEmpty()) {
      this.J = null;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    o.d("MicroMsg.AppBrand.AppBrandPipContainerView", "enableTouch");
    View localView = this.P;
    int i1;
    if (paramBoolean) {
      i1 = 0;
    } else {
      i1 = 4;
    }
    localView.setVisibility(i1);
    this.V = true;
  }
  
  public void c()
  {
    o.d("MicroMsg.AppBrand.AppBrandPipContainerView", "disableInfoCovers");
    e();
    f();
    this.W = false;
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    this.I = f(paramInt1, paramInt2);
  }
  
  public void d()
  {
    if (!this.W) {
      return;
    }
    o.d("MicroMsg.AppBrand.AppBrandPipContainerView", "showOnLoading");
    this.Q.setVisibility(0);
  }
  
  public void e()
  {
    o.d("MicroMsg.AppBrand.AppBrandPipContainerView", "showOnLoadEnd");
    this.Q.setVisibility(4);
  }
  
  public void f()
  {
    this.R.setVisibility(4);
    this.S.setVisibility(4);
    this.L = null;
  }
  
  public int getStablePosX()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getStablePosX, mStablePosX: ");
    localStringBuilder.append(this.H);
    o.e("MicroMsg.AppBrand.AppBrandPipContainerView", localStringBuilder.toString());
    return this.H;
  }
  
  public int getStablePosY()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getStablePosY, mStablePosY: ");
    localStringBuilder.append(this.I);
    o.e("MicroMsg.AppBrand.AppBrandPipContainerView", localStringBuilder.toString());
    return this.I;
  }
  
  @SuppressLint({"DrawAllocation"})
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    Object localObject = (View)getParent();
    if (localObject == null)
    {
      o.c("MicroMsg.AppBrand.AppBrandPipContainerView", "onLayout, null == parentView");
      return;
    }
    if (v == this.z)
    {
      this.z = new Point(((View)localObject).getWidth(), ((View)localObject).getHeight());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onLayout, mParentViewSize: ");
      ((StringBuilder)localObject).append(this.z);
      o.d("MicroMsg.AppBrand.AppBrandPipContainerView", ((StringBuilder)localObject).toString());
      a(getY(), true);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.V) {
      return true;
    }
    int i1 = paramMotionEvent.getAction();
    if (i1 != 0)
    {
      if (i1 != 1) {
        if (i1 != 2)
        {
          if (i1 != 3) {
            break label246;
          }
        }
        else
        {
          if ((!this.B) && (b(paramMotionEvent))) {
            this.B = true;
          }
          if (!this.B) {
            break label246;
          }
          a(c(paramMotionEvent), d(paramMotionEvent), false);
          break label246;
        }
      }
      if ((this.B) || (b(paramMotionEvent)))
      {
        if (this.B) {
          this.B = false;
        }
        i1 = c(paramMotionEvent);
        int i2 = getWidth();
        int i3 = d(paramMotionEvent);
        int i4 = getHeight();
        paramMotionEvent = new StringBuilder();
        paramMotionEvent.append("onTouchEvent, startPositionX: ");
        paramMotionEvent.append(i1);
        paramMotionEvent.append(", width: ");
        paramMotionEvent.append(i2);
        paramMotionEvent.append(", startPositionY: ");
        paramMotionEvent.append(i3);
        paramMotionEvent.append(", height: ");
        paramMotionEvent.append(i4);
        o.d("MicroMsg.AppBrand.AppBrandPipContainerView", paramMotionEvent.toString());
        a(i1, i3, e(i1, i2), f(i3, i4));
        return true;
      }
    }
    else
    {
      this.B = false;
      a(paramMotionEvent);
    }
    label246:
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setOnCloseButtonClickListener(@Nullable View.OnClickListener paramOnClickListener)
  {
    this.P.setOnClickListener(paramOnClickListener);
  }
  
  public void setStablePos(Point paramPoint)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setStablePos, stablePos: ");
    localStringBuilder.append(paramPoint);
    o.e("MicroMsg.AppBrand.AppBrandPipContainerView", localStringBuilder.toString());
    this.H = paramPoint.x;
    this.I = paramPoint.y;
    this.G = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.e
 * JD-Core Version:    0.7.0.1
 */