package com.google.android.material.bottomsheet;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.annotation.VisibleForTesting;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior;
import androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.customview.widget.ViewDragHelper;
import androidx.customview.widget.ViewDragHelper.Callback;
import com.google.android.material.R.attr;
import com.google.android.material.R.dimen;
import com.google.android.material.R.string;
import com.google.android.material.R.style;
import com.google.android.material.R.styleable;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.ShapeAppearanceModel.Builder;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BottomSheetBehavior<V extends View>
  extends CoordinatorLayout.Behavior<V>
{
  private static final int F = R.style.l;
  private boolean A;
  private ShapeAppearanceModel B;
  private boolean C;
  private BottomSheetBehavior<V>.SettleRunnable D = null;
  @Nullable
  private ValueAnimator E;
  private boolean G;
  private boolean H = true;
  private boolean I;
  private int J;
  private boolean K;
  private int L;
  @NonNull
  private final ArrayList<BottomSheetBehavior.BottomSheetCallback> M = new ArrayList();
  @Nullable
  private VelocityTracker N;
  private int O;
  @Nullable
  private Map<View, Integer> P;
  private int Q = -1;
  private final ViewDragHelper.Callback R = new BottomSheetBehavior.4(this);
  int a;
  int b;
  int c;
  float d = 0.5F;
  int e;
  float f = -1.0F;
  boolean g;
  int h = 4;
  @Nullable
  ViewDragHelper i;
  int j;
  int k;
  @Nullable
  WeakReference<V> l;
  @Nullable
  WeakReference<View> m;
  int n;
  boolean o;
  private int p = 0;
  private boolean q = true;
  private boolean r = false;
  private float s;
  private int t;
  private boolean u;
  private int v;
  private int w;
  private boolean x;
  private MaterialShapeDrawable y;
  private int z;
  
  public BottomSheetBehavior() {}
  
  public BottomSheetBehavior(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.w = paramContext.getResources().getDimensionPixelSize(R.dimen.af);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.as);
    this.x = localTypedArray.hasValue(R.styleable.aE);
    boolean bool = localTypedArray.hasValue(R.styleable.au);
    if (bool) {
      a(paramContext, paramAttributeSet, bool, MaterialResources.a(paramContext, localTypedArray, R.styleable.au));
    } else {
      a(paramContext, paramAttributeSet, bool);
    }
    i();
    if (Build.VERSION.SDK_INT >= 21) {
      this.f = localTypedArray.getDimension(R.styleable.at, -1.0F);
    }
    paramAttributeSet = localTypedArray.peekValue(R.styleable.aA);
    if ((paramAttributeSet != null) && (paramAttributeSet.data == -1)) {
      a(paramAttributeSet.data);
    } else {
      a(localTypedArray.getDimensionPixelSize(R.styleable.aA, -1));
    }
    b(localTypedArray.getBoolean(R.styleable.az, false));
    e(localTypedArray.getBoolean(R.styleable.aD, false));
    a(localTypedArray.getBoolean(R.styleable.ax, true));
    c(localTypedArray.getBoolean(R.styleable.aC, false));
    d(localTypedArray.getBoolean(R.styleable.av, true));
    c(localTypedArray.getInt(R.styleable.aB, 0));
    a(localTypedArray.getFloat(R.styleable.ay, 0.5F));
    paramAttributeSet = localTypedArray.peekValue(R.styleable.aw);
    if ((paramAttributeSet != null) && (paramAttributeSet.type == 16)) {
      b(paramAttributeSet.data);
    } else {
      b(localTypedArray.getDimensionPixelOffset(R.styleable.aw, 0));
    }
    localTypedArray.recycle();
    this.s = ViewConfiguration.get(paramContext).getScaledMaximumFlingVelocity();
  }
  
  private int a(V paramV, @StringRes int paramInt1, int paramInt2)
  {
    return ViewCompat.addAccessibilityAction(paramV, paramV.getResources().getString(paramInt1), i(paramInt2));
  }
  
  private void a(@NonNull Context paramContext, AttributeSet paramAttributeSet, boolean paramBoolean)
  {
    a(paramContext, paramAttributeSet, paramBoolean, null);
  }
  
  private void a(@NonNull Context paramContext, AttributeSet paramAttributeSet, boolean paramBoolean, @Nullable ColorStateList paramColorStateList)
  {
    if (this.x)
    {
      this.B = ShapeAppearanceModel.a(paramContext, paramAttributeSet, R.attr.h, F).a();
      this.y = new MaterialShapeDrawable(this.B);
      this.y.a(paramContext);
      if ((paramBoolean) && (paramColorStateList != null))
      {
        this.y.g(paramColorStateList);
        return;
      }
      paramAttributeSet = new TypedValue();
      paramContext.getTheme().resolveAttribute(16842801, paramAttributeSet, true);
      this.y.setTint(paramAttributeSet.data);
    }
  }
  
  private void a(V paramV, AccessibilityNodeInfoCompat.AccessibilityActionCompat paramAccessibilityActionCompat, int paramInt)
  {
    ViewCompat.replaceAccessibilityAction(paramV, paramAccessibilityActionCompat, null, i(paramInt));
  }
  
  private void a(@NonNull BottomSheetBehavior.SavedState paramSavedState)
  {
    int i1 = this.p;
    if (i1 == 0) {
      return;
    }
    if ((i1 == -1) || ((i1 & 0x1) == 1)) {
      this.t = paramSavedState.b;
    }
    i1 = this.p;
    if ((i1 == -1) || ((i1 & 0x2) == 2)) {
      this.q = paramSavedState.c;
    }
    i1 = this.p;
    if ((i1 == -1) || ((i1 & 0x4) == 4)) {
      this.g = paramSavedState.d;
    }
    i1 = this.p;
    if ((i1 == -1) || ((i1 & 0x8) == 8)) {
      this.G = paramSavedState.e;
    }
  }
  
  @NonNull
  public static <V extends View> BottomSheetBehavior<V> b(@NonNull V paramV)
  {
    paramV = paramV.getLayoutParams();
    if ((paramV instanceof CoordinatorLayout.LayoutParams))
    {
      paramV = ((CoordinatorLayout.LayoutParams)paramV).getBehavior();
      if ((paramV instanceof BottomSheetBehavior)) {
        return (BottomSheetBehavior)paramV;
      }
      throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
    }
    throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
  }
  
  private void c(@NonNull View paramView)
  {
    if ((Build.VERSION.SDK_INT >= 29) && (!c()) && (!this.u)) {
      ViewUtils.a(paramView, new BottomSheetBehavior.3(this));
    }
  }
  
  private int e()
  {
    if (this.u) {
      return Math.min(Math.max(this.v, this.k - this.j * 9 / 16), this.L);
    }
    if (!this.A)
    {
      int i1 = this.z;
      if (i1 > 0) {
        return Math.max(this.t, i1 + this.w);
      }
    }
    return this.t;
  }
  
  private void f()
  {
    int i1 = e();
    if (this.q)
    {
      this.e = Math.max(this.k - i1, this.b);
      return;
    }
    this.e = (this.k - i1);
  }
  
  private void f(boolean paramBoolean)
  {
    if (this.l != null)
    {
      f();
      if (this.h == 4)
      {
        View localView = (View)this.l.get();
        if (localView != null)
        {
          if (paramBoolean)
          {
            g(this.h);
            return;
          }
          localView.requestLayout();
        }
      }
    }
  }
  
  private void g()
  {
    this.c = ((int)(this.k * (1.0F - this.d)));
  }
  
  private void g(int paramInt)
  {
    View localView = (View)this.l.get();
    if (localView == null) {
      return;
    }
    ViewParent localViewParent = localView.getParent();
    if ((localViewParent != null) && (localViewParent.isLayoutRequested()) && (ViewCompat.isAttachedToWindow(localView)))
    {
      localView.post(new BottomSheetBehavior.1(this, localView, paramInt));
      return;
    }
    a(localView, paramInt);
  }
  
  private void g(boolean paramBoolean)
  {
    Object localObject = this.l;
    if (localObject == null) {
      return;
    }
    localObject = ((View)((WeakReference)localObject).get()).getParent();
    if (!(localObject instanceof CoordinatorLayout)) {
      return;
    }
    localObject = (CoordinatorLayout)localObject;
    int i2 = ((CoordinatorLayout)localObject).getChildCount();
    if ((Build.VERSION.SDK_INT >= 16) && (paramBoolean)) {
      if (this.P == null) {
        this.P = new HashMap(i2);
      } else {
        return;
      }
    }
    int i1 = 0;
    while (i1 < i2)
    {
      View localView = ((CoordinatorLayout)localObject).getChildAt(i1);
      if (localView != this.l.get()) {
        if (paramBoolean)
        {
          if (Build.VERSION.SDK_INT >= 16) {
            this.P.put(localView, Integer.valueOf(localView.getImportantForAccessibility()));
          }
          if (this.r) {
            ViewCompat.setImportantForAccessibility(localView, 4);
          }
        }
        else if (this.r)
        {
          Map localMap = this.P;
          if ((localMap != null) && (localMap.containsKey(localView))) {
            ViewCompat.setImportantForAccessibility(localView, ((Integer)this.P.get(localView)).intValue());
          }
        }
      }
      i1 += 1;
    }
    if (!paramBoolean)
    {
      this.P = null;
      return;
    }
    if (this.r) {
      ((View)this.l.get()).sendAccessibilityEvent(8);
    }
  }
  
  private void h()
  {
    this.n = -1;
    VelocityTracker localVelocityTracker = this.N;
    if (localVelocityTracker != null)
    {
      localVelocityTracker.recycle();
      this.N = null;
    }
  }
  
  private void h(int paramInt)
  {
    if (paramInt == 2) {
      return;
    }
    boolean bool;
    if (paramInt == 3) {
      bool = true;
    } else {
      bool = false;
    }
    if (this.C != bool)
    {
      this.C = bool;
      if (this.y != null)
      {
        ValueAnimator localValueAnimator = this.E;
        if (localValueAnimator != null)
        {
          if (localValueAnimator.isRunning())
          {
            this.E.reverse();
            return;
          }
          float f1;
          if (bool) {
            f1 = 0.0F;
          } else {
            f1 = 1.0F;
          }
          this.E.setFloatValues(new float[] { 1.0F - f1, f1 });
          this.E.start();
        }
      }
    }
  }
  
  private AccessibilityViewCommand i(int paramInt)
  {
    return new BottomSheetBehavior.5(this, paramInt);
  }
  
  private void i()
  {
    this.E = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.E.setDuration(500L);
    this.E.addUpdateListener(new BottomSheetBehavior.2(this));
  }
  
  private float j()
  {
    VelocityTracker localVelocityTracker = this.N;
    if (localVelocityTracker == null) {
      return 0.0F;
    }
    localVelocityTracker.computeCurrentVelocity(1000, this.s);
    return this.N.getYVelocity(this.n);
  }
  
  private void k()
  {
    Object localObject = this.l;
    if (localObject == null) {
      return;
    }
    localObject = (View)((WeakReference)localObject).get();
    if (localObject == null) {
      return;
    }
    ViewCompat.removeAccessibilityAction((View)localObject, 524288);
    ViewCompat.removeAccessibilityAction((View)localObject, 262144);
    ViewCompat.removeAccessibilityAction((View)localObject, 1048576);
    int i1 = this.Q;
    if (i1 != -1) {
      ViewCompat.removeAccessibilityAction((View)localObject, i1);
    }
    int i2 = this.h;
    i1 = 6;
    if (i2 != 6) {
      this.Q = a((View)localObject, R.string.a, 6);
    }
    if ((this.g) && (this.h != 5)) {
      a((View)localObject, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_DISMISS, 5);
    }
    i2 = this.h;
    if (i2 != 3)
    {
      if (i2 != 4)
      {
        if (i2 != 6) {
          return;
        }
        a((View)localObject, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_COLLAPSE, 4);
        a((View)localObject, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_EXPAND, 3);
        return;
      }
      if (this.q) {
        i1 = 3;
      }
      a((View)localObject, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_EXPAND, i1);
      return;
    }
    if (this.q) {
      i1 = 4;
    }
    a((View)localObject, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_COLLAPSE, i1);
  }
  
  public int a()
  {
    if (this.q) {
      return this.b;
    }
    return this.a;
  }
  
  @Nullable
  @VisibleForTesting
  View a(View paramView)
  {
    if (ViewCompat.isNestedScrollingEnabled(paramView)) {
      return paramView;
    }
    if ((paramView instanceof ViewGroup))
    {
      paramView = (ViewGroup)paramView;
      int i1 = 0;
      int i2 = paramView.getChildCount();
      while (i1 < i2)
      {
        View localView = a(paramView.getChildAt(i1));
        if (localView != null) {
          return localView;
        }
        i1 += 1;
      }
    }
    return null;
  }
  
  public void a(@FloatRange(from=0.0D, to=1.0D) float paramFloat)
  {
    if ((paramFloat > 0.0F) && (paramFloat < 1.0F))
    {
      this.d = paramFloat;
      if (this.l != null) {
        g();
      }
      return;
    }
    throw new IllegalArgumentException("ratio must be a float value between 0 and 1");
  }
  
  public void a(int paramInt)
  {
    a(paramInt, false);
  }
  
  public final void a(int paramInt, boolean paramBoolean)
  {
    int i1 = 1;
    if (paramInt == -1)
    {
      if (!this.u)
      {
        this.u = true;
        paramInt = i1;
        break label63;
      }
    }
    else {
      if ((this.u) || (this.t != paramInt)) {
        break label47;
      }
    }
    paramInt = 0;
    break label63;
    label47:
    this.u = false;
    this.t = Math.max(0, paramInt);
    paramInt = i1;
    label63:
    if (paramInt != 0) {
      f(paramBoolean);
    }
  }
  
  void a(@NonNull View paramView, int paramInt)
  {
    int i1;
    if (paramInt == 4)
    {
      i1 = this.e;
    }
    else if (paramInt == 6)
    {
      i1 = this.c;
      if (this.q)
      {
        int i2 = this.b;
        if (i1 <= i2)
        {
          i1 = i2;
          paramInt = 3;
          break label84;
        }
      }
    }
    else if (paramInt == 3)
    {
      i1 = a();
    }
    else
    {
      if ((!this.g) || (paramInt != 5)) {
        break label93;
      }
      i1 = this.k;
    }
    label84:
    a(paramView, paramInt, i1, false);
    return;
    label93:
    paramView = new StringBuilder();
    paramView.append("Illegal state argument: ");
    paramView.append(paramInt);
    throw new IllegalArgumentException(paramView.toString());
  }
  
  void a(View paramView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Object localObject = this.i;
    if ((localObject != null) && (paramBoolean ? ((ViewDragHelper)localObject).settleCapturedViewAt(paramView.getLeft(), paramInt2) : ((ViewDragHelper)localObject).smoothSlideViewTo(paramView, paramView.getLeft(), paramInt2))) {
      paramInt2 = 1;
    } else {
      paramInt2 = 0;
    }
    if (paramInt2 != 0)
    {
      e(2);
      h(paramInt1);
      if (this.D == null) {
        this.D = new BottomSheetBehavior.SettleRunnable(this, paramView, paramInt1);
      }
      if (!BottomSheetBehavior.SettleRunnable.a(this.D))
      {
        localObject = this.D;
        ((BottomSheetBehavior.SettleRunnable)localObject).a = paramInt1;
        ViewCompat.postOnAnimation(paramView, (Runnable)localObject);
        BottomSheetBehavior.SettleRunnable.a(this.D, true);
        return;
      }
      this.D.a = paramInt1;
      return;
    }
    e(paramInt1);
  }
  
  @Deprecated
  public void a(BottomSheetBehavior.BottomSheetCallback paramBottomSheetCallback)
  {
    Log.w("BottomSheetBehavior", "BottomSheetBehavior now supports multiple callbacks. `setBottomSheetCallback()` removes all existing callbacks, including ones set internally by library authors, which may result in unintended behavior. This may change in the future. Please use `addBottomSheetCallback()` and `removeBottomSheetCallback()` instead to set your own callbacks.");
    this.M.clear();
    if (paramBottomSheetCallback != null) {
      this.M.add(paramBottomSheetCallback);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.q == paramBoolean) {
      return;
    }
    this.q = paramBoolean;
    if (this.l != null) {
      f();
    }
    int i1;
    if ((this.q) && (this.h == 6)) {
      i1 = 3;
    } else {
      i1 = this.h;
    }
    e(i1);
    k();
  }
  
  boolean a(@NonNull View paramView, float paramFloat)
  {
    if (this.G) {
      return true;
    }
    if (paramView.getTop() < this.e) {
      return false;
    }
    int i1 = e();
    return Math.abs(paramView.getTop() + paramFloat * 0.1F - this.e) / i1 > 0.5F;
  }
  
  public void b(int paramInt)
  {
    if (paramInt >= 0)
    {
      this.a = paramInt;
      return;
    }
    throw new IllegalArgumentException("offset must be greater than or equal to 0");
  }
  
  public void b(@NonNull BottomSheetBehavior.BottomSheetCallback paramBottomSheetCallback)
  {
    if (!this.M.contains(paramBottomSheetCallback)) {
      this.M.add(paramBottomSheetCallback);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.g != paramBoolean)
    {
      this.g = paramBoolean;
      if ((!paramBoolean) && (this.h == 5)) {
        d(4);
      }
      k();
    }
  }
  
  public boolean b()
  {
    return this.g;
  }
  
  public void c(int paramInt)
  {
    this.p = paramInt;
  }
  
  public void c(@NonNull BottomSheetBehavior.BottomSheetCallback paramBottomSheetCallback)
  {
    this.M.remove(paramBottomSheetCallback);
  }
  
  public void c(boolean paramBoolean)
  {
    this.G = paramBoolean;
  }
  
  public boolean c()
  {
    return this.A;
  }
  
  public int d()
  {
    return this.h;
  }
  
  public void d(int paramInt)
  {
    if (paramInt == this.h) {
      return;
    }
    if (this.l == null)
    {
      if ((paramInt == 4) || (paramInt == 3) || (paramInt == 6) || ((this.g) && (paramInt == 5))) {
        this.h = paramInt;
      }
      return;
    }
    g(paramInt);
  }
  
  public void d(boolean paramBoolean)
  {
    this.H = paramBoolean;
  }
  
  void e(int paramInt)
  {
    if (this.h == paramInt) {
      return;
    }
    this.h = paramInt;
    Object localObject = this.l;
    if (localObject == null) {
      return;
    }
    localObject = (View)((WeakReference)localObject).get();
    if (localObject == null) {
      return;
    }
    int i1 = 0;
    if (paramInt == 3) {
      g(true);
    } else if ((paramInt == 6) || (paramInt == 5) || (paramInt == 4)) {
      g(false);
    }
    h(paramInt);
    while (i1 < this.M.size())
    {
      ((BottomSheetBehavior.BottomSheetCallback)this.M.get(i1)).onStateChanged((View)localObject, paramInt);
      i1 += 1;
    }
    k();
  }
  
  public void e(boolean paramBoolean)
  {
    this.A = paramBoolean;
  }
  
  void f(int paramInt)
  {
    View localView = (View)this.l.get();
    if ((localView != null) && (!this.M.isEmpty()))
    {
      int i1 = this.e;
      float f2;
      if ((paramInt <= i1) && (i1 != a()))
      {
        i1 = this.e;
        f2 = i1 - paramInt;
        f1 = i1 - a();
      }
      else
      {
        i1 = this.e;
        f2 = i1 - paramInt;
        f1 = this.k - i1;
      }
      float f1 = f2 / f1;
      paramInt = 0;
      while (paramInt < this.M.size())
      {
        ((BottomSheetBehavior.BottomSheetCallback)this.M.get(paramInt)).onSlide(localView, f1);
        paramInt += 1;
      }
    }
  }
  
  public void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams paramLayoutParams)
  {
    super.onAttachedToLayoutParams(paramLayoutParams);
    this.l = null;
    this.i = null;
  }
  
  public void onDetachedFromLayoutParams()
  {
    super.onDetachedFromLayoutParams();
    this.l = null;
    this.i = null;
  }
  
  public boolean onInterceptTouchEvent(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull V paramV, @NonNull MotionEvent paramMotionEvent)
  {
    boolean bool1 = paramV.isShown();
    boolean bool2 = false;
    if ((bool1) && (this.H))
    {
      int i1 = paramMotionEvent.getActionMasked();
      if (i1 == 0) {
        h();
      }
      if (this.N == null) {
        this.N = VelocityTracker.obtain();
      }
      this.N.addMovement(paramMotionEvent);
      Object localObject2 = null;
      if (i1 != 0)
      {
        if ((i1 == 1) || (i1 == 3))
        {
          this.o = false;
          this.n = -1;
          if (this.I)
          {
            this.I = false;
            return false;
          }
        }
      }
      else
      {
        int i2 = (int)paramMotionEvent.getX();
        this.O = ((int)paramMotionEvent.getY());
        if (this.h != 2)
        {
          localObject1 = this.m;
          if (localObject1 != null) {
            localObject1 = (View)((WeakReference)localObject1).get();
          } else {
            localObject1 = null;
          }
          if ((localObject1 != null) && (paramCoordinatorLayout.isPointInChildBounds((View)localObject1, i2, this.O)))
          {
            this.n = paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex());
            this.o = true;
          }
        }
        if ((this.n == -1) && (!paramCoordinatorLayout.isPointInChildBounds(paramV, i2, this.O))) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        this.I = bool1;
      }
      if (!this.I)
      {
        paramV = this.i;
        if ((paramV != null) && (paramV.shouldInterceptTouchEvent(paramMotionEvent))) {
          return true;
        }
      }
      Object localObject1 = this.m;
      paramV = localObject2;
      if (localObject1 != null) {
        paramV = (View)((WeakReference)localObject1).get();
      }
      bool1 = bool2;
      if (i1 == 2)
      {
        bool1 = bool2;
        if (paramV != null)
        {
          bool1 = bool2;
          if (!this.I)
          {
            bool1 = bool2;
            if (this.h != 1)
            {
              bool1 = bool2;
              if (!paramCoordinatorLayout.isPointInChildBounds(paramV, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()))
              {
                bool1 = bool2;
                if (this.i != null)
                {
                  bool1 = bool2;
                  if (Math.abs(this.O - paramMotionEvent.getY()) > this.i.getTouchSlop()) {
                    bool1 = true;
                  }
                }
              }
            }
          }
        }
      }
      return bool1;
    }
    this.I = true;
    return false;
  }
  
  public boolean onLayoutChild(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull V paramV, int paramInt)
  {
    if ((ViewCompat.getFitsSystemWindows(paramCoordinatorLayout)) && (!ViewCompat.getFitsSystemWindows(paramV))) {
      paramV.setFitsSystemWindows(true);
    }
    if (this.l == null)
    {
      this.v = paramCoordinatorLayout.getResources().getDimensionPixelSize(R.dimen.j);
      c(paramV);
      this.l = new WeakReference(paramV);
      if (this.x)
      {
        localMaterialShapeDrawable = this.y;
        if (localMaterialShapeDrawable != null) {
          ViewCompat.setBackground(paramV, localMaterialShapeDrawable);
        }
      }
      MaterialShapeDrawable localMaterialShapeDrawable = this.y;
      if (localMaterialShapeDrawable != null)
      {
        float f2 = this.f;
        float f1 = f2;
        if (f2 == -1.0F) {
          f1 = ViewCompat.getElevation(paramV);
        }
        localMaterialShapeDrawable.r(f1);
        boolean bool;
        if (this.h == 3) {
          bool = true;
        } else {
          bool = false;
        }
        this.C = bool;
        localMaterialShapeDrawable = this.y;
        if (this.C) {
          f1 = 0.0F;
        } else {
          f1 = 1.0F;
        }
        localMaterialShapeDrawable.p(f1);
      }
      k();
      if (ViewCompat.getImportantForAccessibility(paramV) == 0) {
        ViewCompat.setImportantForAccessibility(paramV, 1);
      }
    }
    if (this.i == null) {
      this.i = ViewDragHelper.create(paramCoordinatorLayout, this.R);
    }
    int i1 = paramV.getTop();
    paramCoordinatorLayout.onLayoutChild(paramV, paramInt);
    this.j = paramCoordinatorLayout.getWidth();
    this.k = paramCoordinatorLayout.getHeight();
    this.L = paramV.getHeight();
    this.b = Math.max(0, this.k - this.L);
    g();
    f();
    paramInt = this.h;
    if (paramInt == 3)
    {
      ViewCompat.offsetTopAndBottom(paramV, a());
    }
    else if (paramInt == 6)
    {
      ViewCompat.offsetTopAndBottom(paramV, this.c);
    }
    else if ((this.g) && (paramInt == 5))
    {
      ViewCompat.offsetTopAndBottom(paramV, this.k);
    }
    else
    {
      paramInt = this.h;
      if (paramInt == 4) {
        ViewCompat.offsetTopAndBottom(paramV, this.e);
      } else if ((paramInt == 1) || (paramInt == 2)) {
        ViewCompat.offsetTopAndBottom(paramV, i1 - paramV.getTop());
      }
    }
    this.m = new WeakReference(a(paramV));
    return true;
  }
  
  public boolean onNestedPreFling(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull V paramV, @NonNull View paramView, float paramFloat1, float paramFloat2)
  {
    WeakReference localWeakReference = this.m;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localWeakReference != null)
    {
      bool1 = bool2;
      if (paramView == localWeakReference.get()) {
        if (this.h == 3)
        {
          bool1 = bool2;
          if (!super.onNestedPreFling(paramCoordinatorLayout, paramV, paramView, paramFloat1, paramFloat2)) {}
        }
        else
        {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public void onNestedPreScroll(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull V paramV, @NonNull View paramView, int paramInt1, int paramInt2, @NonNull int[] paramArrayOfInt, int paramInt3)
  {
    if (paramInt3 == 1) {
      return;
    }
    paramCoordinatorLayout = this.m;
    if (paramCoordinatorLayout != null) {
      paramCoordinatorLayout = (View)paramCoordinatorLayout.get();
    } else {
      paramCoordinatorLayout = null;
    }
    if (paramView != paramCoordinatorLayout) {
      return;
    }
    paramInt1 = paramV.getTop();
    paramInt3 = paramInt1 - paramInt2;
    if (paramInt2 > 0)
    {
      if (paramInt3 < a())
      {
        paramArrayOfInt[1] = (paramInt1 - a());
        ViewCompat.offsetTopAndBottom(paramV, -paramArrayOfInt[1]);
        e(3);
      }
      else
      {
        if (!this.H) {
          return;
        }
        paramArrayOfInt[1] = paramInt2;
        ViewCompat.offsetTopAndBottom(paramV, -paramInt2);
        e(1);
      }
    }
    else if ((paramInt2 < 0) && (!paramView.canScrollVertically(-1)))
    {
      int i1 = this.e;
      if ((paramInt3 > i1) && (!this.g))
      {
        paramArrayOfInt[1] = (paramInt1 - i1);
        ViewCompat.offsetTopAndBottom(paramV, -paramArrayOfInt[1]);
        e(4);
      }
      else
      {
        if (!this.H) {
          return;
        }
        paramArrayOfInt[1] = paramInt2;
        ViewCompat.offsetTopAndBottom(paramV, -paramInt2);
        e(1);
      }
    }
    f(paramV.getTop());
    this.J = paramInt2;
    this.K = true;
  }
  
  public void onNestedScroll(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull V paramV, @NonNull View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, @NonNull int[] paramArrayOfInt) {}
  
  public void onRestoreInstanceState(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull V paramV, @NonNull Parcelable paramParcelable)
  {
    paramParcelable = (BottomSheetBehavior.SavedState)paramParcelable;
    super.onRestoreInstanceState(paramCoordinatorLayout, paramV, paramParcelable.getSuperState());
    a(paramParcelable);
    if ((paramParcelable.a != 1) && (paramParcelable.a != 2))
    {
      this.h = paramParcelable.a;
      return;
    }
    this.h = 4;
  }
  
  @NonNull
  public Parcelable onSaveInstanceState(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull V paramV)
  {
    return new BottomSheetBehavior.SavedState(super.onSaveInstanceState(paramCoordinatorLayout, paramV), this);
  }
  
  public boolean onStartNestedScroll(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull V paramV, @NonNull View paramView1, @NonNull View paramView2, int paramInt1, int paramInt2)
  {
    boolean bool = false;
    this.J = 0;
    this.K = false;
    if ((paramInt1 & 0x2) != 0) {
      bool = true;
    }
    return bool;
  }
  
  public void onStopNestedScroll(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull V paramV, @NonNull View paramView, int paramInt)
  {
    paramInt = paramV.getTop();
    int i2 = a();
    int i1 = 3;
    if (paramInt == i2)
    {
      e(3);
      return;
    }
    paramCoordinatorLayout = this.m;
    if ((paramCoordinatorLayout != null) && (paramView == paramCoordinatorLayout.get()))
    {
      if (!this.K) {
        return;
      }
      if (this.J > 0)
      {
        if (this.q)
        {
          paramInt = this.b;
          break label354;
        }
        i2 = paramV.getTop();
        paramInt = this.c;
        if (i2 <= paramInt)
        {
          paramInt = this.a;
          break label354;
        }
      }
      else
      {
        if ((this.g) && (a(paramV, j())))
        {
          paramInt = this.k;
          i1 = 5;
          break label354;
        }
        if (this.J == 0)
        {
          paramInt = paramV.getTop();
          if (this.q)
          {
            if (Math.abs(paramInt - this.b) < Math.abs(paramInt - this.e))
            {
              paramInt = this.b;
              break label354;
            }
            paramInt = this.e;
          }
          else
          {
            i2 = this.c;
            if (paramInt < i2)
            {
              if (paramInt < Math.abs(paramInt - this.e))
              {
                paramInt = this.a;
                break label354;
              }
              paramInt = this.c;
              break label338;
            }
            if (Math.abs(paramInt - i2) < Math.abs(paramInt - this.e))
            {
              paramInt = this.c;
              break label338;
            }
            paramInt = this.e;
          }
        }
        else
        {
          if (!this.q) {
            break label303;
          }
        }
      }
      for (paramInt = this.e;; paramInt = this.e)
      {
        i1 = 4;
        break;
        label303:
        paramInt = paramV.getTop();
        if (Math.abs(paramInt - this.c) < Math.abs(paramInt - this.e))
        {
          paramInt = this.c;
          label338:
          i1 = 6;
          break;
        }
      }
      label354:
      a(paramV, i1, paramInt, false);
      this.K = false;
    }
  }
  
  public boolean onTouchEvent(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull V paramV, @NonNull MotionEvent paramMotionEvent)
  {
    if (!paramV.isShown()) {
      return false;
    }
    int i1 = paramMotionEvent.getActionMasked();
    if ((this.h == 1) && (i1 == 0)) {
      return true;
    }
    paramCoordinatorLayout = this.i;
    if (paramCoordinatorLayout != null) {
      paramCoordinatorLayout.processTouchEvent(paramMotionEvent);
    }
    if (i1 == 0) {
      h();
    }
    if (this.N == null) {
      this.N = VelocityTracker.obtain();
    }
    this.N.addMovement(paramMotionEvent);
    if ((this.i != null) && (i1 == 2) && (!this.I) && (Math.abs(this.O - paramMotionEvent.getY()) > this.i.getTouchSlop())) {
      this.i.captureChildView(paramV, paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex()));
    }
    return this.I ^ true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.bottomsheet.BottomSheetBehavior
 * JD-Core Version:    0.7.0.1
 */