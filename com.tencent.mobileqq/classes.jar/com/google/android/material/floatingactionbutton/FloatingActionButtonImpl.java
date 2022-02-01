package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.ViewCompat;
import com.google.android.material.R.animator;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.AnimatorSetCompat;
import com.google.android.material.animation.ImageMatrixProperty;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.animation.MotionTiming;
import com.google.android.material.internal.StateListAnimator;
import com.google.android.material.ripple.RippleDrawableCompat;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shadow.ShadowViewDelegate;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class FloatingActionButtonImpl
{
  static final TimeInterpolator a = AnimationUtils.c;
  static final int[] m = { 16842919, 16842910 };
  static final int[] n = { 16843623, 16842908, 16842910 };
  static final int[] o = { 16842908, 16842910 };
  static final int[] p = { 16843623, 16842910 };
  static final int[] q = { 16842910 };
  static final int[] r = new int[0];
  private float A;
  private float B = 1.0F;
  private int C;
  private int D = 0;
  private ArrayList<Animator.AnimatorListener> E;
  private ArrayList<Animator.AnimatorListener> F;
  private ArrayList<FloatingActionButtonImpl.InternalTransformationCallback> G;
  private final Rect H = new Rect();
  private final RectF I = new RectF();
  private final RectF J = new RectF();
  private final Matrix K = new Matrix();
  @Nullable
  private ViewTreeObserver.OnPreDrawListener L;
  @Nullable
  ShapeAppearanceModel b;
  @Nullable
  MaterialShapeDrawable c;
  @Nullable
  Drawable d;
  @Nullable
  BorderDrawable e;
  @Nullable
  Drawable f;
  boolean g;
  boolean h = true;
  float i;
  float j;
  float k;
  int l;
  final FloatingActionButton s;
  final ShadowViewDelegate t;
  @NonNull
  private final StateListAnimator u;
  @Nullable
  private MotionSpec v;
  @Nullable
  private MotionSpec w;
  @Nullable
  private Animator x;
  @Nullable
  private MotionSpec y;
  @Nullable
  private MotionSpec z;
  
  FloatingActionButtonImpl(FloatingActionButton paramFloatingActionButton, ShadowViewDelegate paramShadowViewDelegate)
  {
    this.s = paramFloatingActionButton;
    this.t = paramShadowViewDelegate;
    this.u = new StateListAnimator();
    this.u.a(m, a(new FloatingActionButtonImpl.ElevateToPressedTranslationZAnimation(this)));
    this.u.a(n, a(new FloatingActionButtonImpl.ElevateToHoveredFocusedTranslationZAnimation(this)));
    this.u.a(o, a(new FloatingActionButtonImpl.ElevateToHoveredFocusedTranslationZAnimation(this)));
    this.u.a(p, a(new FloatingActionButtonImpl.ElevateToHoveredFocusedTranslationZAnimation(this)));
    this.u.a(q, a(new FloatingActionButtonImpl.ResetElevationAnimation(this)));
    this.u.a(r, a(new FloatingActionButtonImpl.DisabledElevationAnimation(this)));
    this.A = this.s.getRotation();
  }
  
  @NonNull
  private ViewTreeObserver.OnPreDrawListener A()
  {
    if (this.L == null) {
      this.L = new FloatingActionButtonImpl.5(this);
    }
    return this.L;
  }
  
  private boolean B()
  {
    return (ViewCompat.isLaidOut(this.s)) && (!this.s.isInEditMode());
  }
  
  @NonNull
  private AnimatorSet a(@NonNull MotionSpec paramMotionSpec, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    ArrayList localArrayList = new ArrayList();
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.s, View.ALPHA, new float[] { paramFloat1 });
    paramMotionSpec.b("opacity").a(localObjectAnimator);
    localArrayList.add(localObjectAnimator);
    localObjectAnimator = ObjectAnimator.ofFloat(this.s, View.SCALE_X, new float[] { paramFloat2 });
    paramMotionSpec.b("scale").a(localObjectAnimator);
    a(localObjectAnimator);
    localArrayList.add(localObjectAnimator);
    localObjectAnimator = ObjectAnimator.ofFloat(this.s, View.SCALE_Y, new float[] { paramFloat2 });
    paramMotionSpec.b("scale").a(localObjectAnimator);
    a(localObjectAnimator);
    localArrayList.add(localObjectAnimator);
    a(paramFloat3, this.K);
    localObjectAnimator = ObjectAnimator.ofObject(this.s, new ImageMatrixProperty(), new FloatingActionButtonImpl.3(this), new Matrix[] { new Matrix(this.K) });
    paramMotionSpec.b("iconScale").a(localObjectAnimator);
    localArrayList.add(localObjectAnimator);
    paramMotionSpec = new AnimatorSet();
    AnimatorSetCompat.a(paramMotionSpec, localArrayList);
    return paramMotionSpec;
  }
  
  @NonNull
  private ValueAnimator a(@NonNull FloatingActionButtonImpl.ShadowAnimatorImpl paramShadowAnimatorImpl)
  {
    ValueAnimator localValueAnimator = new ValueAnimator();
    localValueAnimator.setInterpolator(a);
    localValueAnimator.setDuration(100L);
    localValueAnimator.addListener(paramShadowAnimatorImpl);
    localValueAnimator.addUpdateListener(paramShadowAnimatorImpl);
    localValueAnimator.setFloatValues(new float[] { 0.0F, 1.0F });
    return localValueAnimator;
  }
  
  private void a(float paramFloat, @NonNull Matrix paramMatrix)
  {
    paramMatrix.reset();
    Drawable localDrawable = this.s.getDrawable();
    if ((localDrawable != null) && (this.C != 0))
    {
      RectF localRectF1 = this.I;
      RectF localRectF2 = this.J;
      localRectF1.set(0.0F, 0.0F, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
      int i1 = this.C;
      localRectF2.set(0.0F, 0.0F, i1, i1);
      paramMatrix.setRectToRect(localRectF1, localRectF2, Matrix.ScaleToFit.CENTER);
      i1 = this.C;
      paramMatrix.postScale(paramFloat, paramFloat, i1 / 2.0F, i1 / 2.0F);
    }
  }
  
  private void a(ObjectAnimator paramObjectAnimator)
  {
    if (Build.VERSION.SDK_INT != 26) {
      return;
    }
    paramObjectAnimator.setEvaluator(new FloatingActionButtonImpl.4(this));
  }
  
  private MotionSpec y()
  {
    if (this.v == null) {
      this.v = MotionSpec.a(this.s.getContext(), R.animator.b);
    }
    return (MotionSpec)Preconditions.checkNotNull(this.v);
  }
  
  private MotionSpec z()
  {
    if (this.w == null) {
      this.w = MotionSpec.a(this.s.getContext(), R.animator.a);
    }
    return (MotionSpec)Preconditions.checkNotNull(this.w);
  }
  
  float a()
  {
    return this.i;
  }
  
  final void a(float paramFloat)
  {
    if (this.i != paramFloat)
    {
      this.i = paramFloat;
      a(this.i, this.j, this.k);
    }
  }
  
  void a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    o();
    e(paramFloat1);
  }
  
  void a(int paramInt)
  {
    this.l = paramInt;
  }
  
  void a(@NonNull Animator.AnimatorListener paramAnimatorListener)
  {
    if (this.E == null) {
      this.E = new ArrayList();
    }
    this.E.add(paramAnimatorListener);
  }
  
  void a(@Nullable ColorStateList paramColorStateList)
  {
    Object localObject = this.c;
    if (localObject != null) {
      ((MaterialShapeDrawable)localObject).setTintList(paramColorStateList);
    }
    localObject = this.e;
    if (localObject != null) {
      ((BorderDrawable)localObject).a(paramColorStateList);
    }
  }
  
  void a(ColorStateList paramColorStateList1, @Nullable PorterDuff.Mode paramMode, ColorStateList paramColorStateList2, int paramInt)
  {
    this.c = u();
    this.c.setTintList(paramColorStateList1);
    if (paramMode != null) {
      this.c.setTintMode(paramMode);
    }
    this.c.H(-12303292);
    this.c.a(this.s.getContext());
    paramColorStateList1 = new RippleDrawableCompat(this.c.getShapeAppearanceModel());
    paramColorStateList1.setTintList(RippleUtils.b(paramColorStateList2));
    this.d = paramColorStateList1;
    this.f = new LayerDrawable(new Drawable[] { (Drawable)Preconditions.checkNotNull(this.c), paramColorStateList1 });
  }
  
  void a(@Nullable PorterDuff.Mode paramMode)
  {
    MaterialShapeDrawable localMaterialShapeDrawable = this.c;
    if (localMaterialShapeDrawable != null) {
      localMaterialShapeDrawable.setTintMode(paramMode);
    }
  }
  
  void a(@NonNull Rect paramRect)
  {
    if (this.g) {
      i1 = (this.l - this.s.getSizeDimension()) / 2;
    } else {
      i1 = 0;
    }
    float f1;
    if (this.h) {
      f1 = a() + this.k;
    } else {
      f1 = 0.0F;
    }
    int i2 = Math.max(i1, (int)Math.ceil(f1));
    int i1 = Math.max(i1, (int)Math.ceil(f1 * 1.5F));
    paramRect.set(i2, i1, i2, i1);
  }
  
  final void a(@Nullable MotionSpec paramMotionSpec)
  {
    this.y = paramMotionSpec;
  }
  
  void a(@NonNull FloatingActionButtonImpl.InternalTransformationCallback paramInternalTransformationCallback)
  {
    if (this.G == null) {
      this.G = new ArrayList();
    }
    this.G.add(paramInternalTransformationCallback);
  }
  
  void a(@Nullable FloatingActionButtonImpl.InternalVisibilityChangedListener paramInternalVisibilityChangedListener, boolean paramBoolean)
  {
    if (w()) {
      return;
    }
    Object localObject = this.x;
    if (localObject != null) {
      ((Animator)localObject).cancel();
    }
    if (B())
    {
      localObject = this.z;
      if (localObject == null) {
        localObject = z();
      }
      localObject = a((MotionSpec)localObject, 0.0F, 0.0F, 0.0F);
      ((AnimatorSet)localObject).addListener(new FloatingActionButtonImpl.1(this, paramBoolean, paramInternalVisibilityChangedListener));
      paramInternalVisibilityChangedListener = this.F;
      if (paramInternalVisibilityChangedListener != null)
      {
        paramInternalVisibilityChangedListener = paramInternalVisibilityChangedListener.iterator();
        while (paramInternalVisibilityChangedListener.hasNext()) {
          ((AnimatorSet)localObject).addListener((Animator.AnimatorListener)paramInternalVisibilityChangedListener.next());
        }
      }
      ((AnimatorSet)localObject).start();
      return;
    }
    localObject = this.s;
    int i1;
    if (paramBoolean) {
      i1 = 8;
    } else {
      i1 = 4;
    }
    ((FloatingActionButton)localObject).a(i1, paramBoolean);
    if (paramInternalVisibilityChangedListener != null) {
      paramInternalVisibilityChangedListener.b();
    }
  }
  
  final void a(@NonNull ShapeAppearanceModel paramShapeAppearanceModel)
  {
    this.b = paramShapeAppearanceModel;
    Object localObject = this.c;
    if (localObject != null) {
      ((MaterialShapeDrawable)localObject).setShapeAppearanceModel(paramShapeAppearanceModel);
    }
    localObject = this.d;
    if ((localObject instanceof Shapeable)) {
      ((Shapeable)localObject).setShapeAppearanceModel(paramShapeAppearanceModel);
    }
    localObject = this.e;
    if (localObject != null) {
      ((BorderDrawable)localObject).a(paramShapeAppearanceModel);
    }
  }
  
  void a(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  void a(int[] paramArrayOfInt)
  {
    this.u.a(paramArrayOfInt);
  }
  
  float b()
  {
    return this.j;
  }
  
  final void b(float paramFloat)
  {
    if (this.j != paramFloat)
    {
      this.j = paramFloat;
      a(this.i, this.j, this.k);
    }
  }
  
  final void b(int paramInt)
  {
    if (this.C != paramInt)
    {
      this.C = paramInt;
      d();
    }
  }
  
  public void b(@NonNull Animator.AnimatorListener paramAnimatorListener)
  {
    if (this.F == null) {
      this.F = new ArrayList();
    }
    this.F.add(paramAnimatorListener);
  }
  
  void b(@Nullable ColorStateList paramColorStateList)
  {
    Drawable localDrawable = this.d;
    if (localDrawable != null) {
      DrawableCompat.setTintList(localDrawable, RippleUtils.b(paramColorStateList));
    }
  }
  
  void b(@NonNull Rect paramRect)
  {
    Preconditions.checkNotNull(this.f, "Didn't initialize content background");
    if (p())
    {
      paramRect = new InsetDrawable(this.f, paramRect.left, paramRect.top, paramRect.right, paramRect.bottom);
      this.t.a(paramRect);
      return;
    }
    this.t.a(this.f);
  }
  
  final void b(@Nullable MotionSpec paramMotionSpec)
  {
    this.z = paramMotionSpec;
  }
  
  void b(@Nullable FloatingActionButtonImpl.InternalVisibilityChangedListener paramInternalVisibilityChangedListener, boolean paramBoolean)
  {
    if (v()) {
      return;
    }
    Object localObject = this.x;
    if (localObject != null) {
      ((Animator)localObject).cancel();
    }
    if (B())
    {
      if (this.s.getVisibility() != 0)
      {
        this.s.setAlpha(0.0F);
        this.s.setScaleY(0.0F);
        this.s.setScaleX(0.0F);
        d(0.0F);
      }
      localObject = this.y;
      if (localObject == null) {
        localObject = y();
      }
      localObject = a((MotionSpec)localObject, 1.0F, 1.0F, 1.0F);
      ((AnimatorSet)localObject).addListener(new FloatingActionButtonImpl.2(this, paramBoolean, paramInternalVisibilityChangedListener));
      paramInternalVisibilityChangedListener = this.E;
      if (paramInternalVisibilityChangedListener != null)
      {
        paramInternalVisibilityChangedListener = paramInternalVisibilityChangedListener.iterator();
        while (paramInternalVisibilityChangedListener.hasNext()) {
          ((AnimatorSet)localObject).addListener((Animator.AnimatorListener)paramInternalVisibilityChangedListener.next());
        }
      }
      ((AnimatorSet)localObject).start();
      return;
    }
    this.s.a(0, paramBoolean);
    this.s.setAlpha(1.0F);
    this.s.setScaleY(1.0F);
    this.s.setScaleX(1.0F);
    d(1.0F);
    if (paramInternalVisibilityChangedListener != null) {
      paramInternalVisibilityChangedListener.a();
    }
  }
  
  void b(boolean paramBoolean)
  {
    this.h = paramBoolean;
    o();
  }
  
  float c()
  {
    return this.k;
  }
  
  final void c(float paramFloat)
  {
    if (this.k != paramFloat)
    {
      this.k = paramFloat;
      a(this.i, this.j, this.k);
    }
  }
  
  final void d()
  {
    d(this.B);
  }
  
  final void d(float paramFloat)
  {
    this.B = paramFloat;
    Matrix localMatrix = this.K;
    a(paramFloat, localMatrix);
    this.s.setImageMatrix(localMatrix);
  }
  
  @Nullable
  final ShapeAppearanceModel e()
  {
    return this.b;
  }
  
  void e(float paramFloat)
  {
    MaterialShapeDrawable localMaterialShapeDrawable = this.c;
    if (localMaterialShapeDrawable != null) {
      localMaterialShapeDrawable.r(paramFloat);
    }
  }
  
  @Nullable
  final MotionSpec f()
  {
    return this.y;
  }
  
  @Nullable
  final MotionSpec g()
  {
    return this.z;
  }
  
  final boolean h()
  {
    return (!this.g) || (this.s.getSizeDimension() >= this.l);
  }
  
  boolean i()
  {
    return this.g;
  }
  
  void j()
  {
    this.u.a();
  }
  
  void k()
  {
    Object localObject = this.G;
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((FloatingActionButtonImpl.InternalTransformationCallback)((Iterator)localObject).next()).a();
      }
    }
  }
  
  void l()
  {
    Object localObject = this.G;
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((FloatingActionButtonImpl.InternalTransformationCallback)((Iterator)localObject).next()).b();
      }
    }
  }
  
  @Nullable
  final Drawable m()
  {
    return this.f;
  }
  
  void n() {}
  
  final void o()
  {
    Rect localRect = this.H;
    a(localRect);
    b(localRect);
    this.t.a(localRect.left, localRect.top, localRect.right, localRect.bottom);
  }
  
  boolean p()
  {
    return true;
  }
  
  void q()
  {
    MaterialShapeDrawable localMaterialShapeDrawable = this.c;
    if (localMaterialShapeDrawable != null) {
      MaterialShapeUtils.a(this.s, localMaterialShapeDrawable);
    }
    if (s()) {
      this.s.getViewTreeObserver().addOnPreDrawListener(A());
    }
  }
  
  void r()
  {
    ViewTreeObserver localViewTreeObserver = this.s.getViewTreeObserver();
    ViewTreeObserver.OnPreDrawListener localOnPreDrawListener = this.L;
    if (localOnPreDrawListener != null)
    {
      localViewTreeObserver.removeOnPreDrawListener(localOnPreDrawListener);
      this.L = null;
    }
  }
  
  boolean s()
  {
    return true;
  }
  
  void t()
  {
    float f1 = this.s.getRotation();
    if (this.A != f1)
    {
      this.A = f1;
      x();
    }
  }
  
  MaterialShapeDrawable u()
  {
    return new MaterialShapeDrawable((ShapeAppearanceModel)Preconditions.checkNotNull(this.b));
  }
  
  boolean v()
  {
    int i1 = this.s.getVisibility();
    boolean bool2 = false;
    boolean bool1 = false;
    if (i1 != 0)
    {
      if (this.D == 2) {
        bool1 = true;
      }
      return bool1;
    }
    bool1 = bool2;
    if (this.D != 1) {
      bool1 = true;
    }
    return bool1;
  }
  
  boolean w()
  {
    int i1 = this.s.getVisibility();
    boolean bool2 = false;
    boolean bool1 = false;
    if (i1 == 0)
    {
      if (this.D == 1) {
        bool1 = true;
      }
      return bool1;
    }
    bool1 = bool2;
    if (this.D != 2) {
      bool1 = true;
    }
    return bool1;
  }
  
  void x()
  {
    if (Build.VERSION.SDK_INT == 19) {
      if (this.A % 90.0F != 0.0F)
      {
        if (this.s.getLayerType() != 1) {
          this.s.setLayerType(1, null);
        }
      }
      else if (this.s.getLayerType() != 0) {
        this.s.setLayerType(0, null);
      }
    }
    MaterialShapeDrawable localMaterialShapeDrawable = this.c;
    if (localMaterialShapeDrawable != null) {
      localMaterialShapeDrawable.G((int)this.A);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
 * JD-Core Version:    0.7.0.1
 */