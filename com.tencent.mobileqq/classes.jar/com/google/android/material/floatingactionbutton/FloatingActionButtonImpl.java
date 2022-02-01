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
  static final TimeInterpolator jdField_a_of_type_AndroidAnimationTimeInterpolator = AnimationUtils.c;
  static final int[] jdField_a_of_type_ArrayOfInt = { 16842919, 16842910 };
  static final int[] jdField_b_of_type_ArrayOfInt = { 16843623, 16842908, 16842910 };
  static final int[] jdField_c_of_type_ArrayOfInt = { 16842908, 16842910 };
  static final int[] jdField_d_of_type_ArrayOfInt = { 16843623, 16842910 };
  static final int[] jdField_e_of_type_ArrayOfInt = { 16842910 };
  static final int[] f = new int[0];
  float jdField_a_of_type_Float;
  int jdField_a_of_type_Int;
  @Nullable
  private Animator jdField_a_of_type_AndroidAnimationAnimator;
  private final Matrix jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
  private final Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private final RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  @Nullable
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  @Nullable
  private ViewTreeObserver.OnPreDrawListener jdField_a_of_type_AndroidViewViewTreeObserver$OnPreDrawListener;
  @Nullable
  private MotionSpec jdField_a_of_type_ComGoogleAndroidMaterialAnimationMotionSpec;
  @Nullable
  BorderDrawable jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonBorderDrawable;
  final FloatingActionButton jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonFloatingActionButton;
  @NonNull
  private final StateListAnimator jdField_a_of_type_ComGoogleAndroidMaterialInternalStateListAnimator;
  final ShadowViewDelegate jdField_a_of_type_ComGoogleAndroidMaterialShadowShadowViewDelegate;
  @Nullable
  MaterialShapeDrawable jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable;
  @Nullable
  ShapeAppearanceModel jdField_a_of_type_ComGoogleAndroidMaterialShapeShapeAppearanceModel;
  private ArrayList<Animator.AnimatorListener> jdField_a_of_type_JavaUtilArrayList;
  boolean jdField_a_of_type_Boolean;
  float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private final RectF jdField_b_of_type_AndroidGraphicsRectF = new RectF();
  @Nullable
  Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  @Nullable
  private MotionSpec jdField_b_of_type_ComGoogleAndroidMaterialAnimationMotionSpec;
  private ArrayList<Animator.AnimatorListener> jdField_b_of_type_JavaUtilArrayList;
  boolean jdField_b_of_type_Boolean = true;
  float jdField_c_of_type_Float;
  private int jdField_c_of_type_Int = 0;
  @Nullable
  private MotionSpec jdField_c_of_type_ComGoogleAndroidMaterialAnimationMotionSpec;
  private ArrayList<FloatingActionButtonImpl.InternalTransformationCallback> jdField_c_of_type_JavaUtilArrayList;
  private float jdField_d_of_type_Float;
  @Nullable
  private MotionSpec jdField_d_of_type_ComGoogleAndroidMaterialAnimationMotionSpec;
  private float jdField_e_of_type_Float = 1.0F;
  
  FloatingActionButtonImpl(FloatingActionButton paramFloatingActionButton, ShadowViewDelegate paramShadowViewDelegate)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonFloatingActionButton = paramFloatingActionButton;
    this.jdField_a_of_type_ComGoogleAndroidMaterialShadowShadowViewDelegate = paramShadowViewDelegate;
    this.jdField_a_of_type_ComGoogleAndroidMaterialInternalStateListAnimator = new StateListAnimator();
    this.jdField_a_of_type_ComGoogleAndroidMaterialInternalStateListAnimator.a(jdField_a_of_type_ArrayOfInt, a(new FloatingActionButtonImpl.ElevateToPressedTranslationZAnimation(this)));
    this.jdField_a_of_type_ComGoogleAndroidMaterialInternalStateListAnimator.a(jdField_b_of_type_ArrayOfInt, a(new FloatingActionButtonImpl.ElevateToHoveredFocusedTranslationZAnimation(this)));
    this.jdField_a_of_type_ComGoogleAndroidMaterialInternalStateListAnimator.a(jdField_c_of_type_ArrayOfInt, a(new FloatingActionButtonImpl.ElevateToHoveredFocusedTranslationZAnimation(this)));
    this.jdField_a_of_type_ComGoogleAndroidMaterialInternalStateListAnimator.a(jdField_d_of_type_ArrayOfInt, a(new FloatingActionButtonImpl.ElevateToHoveredFocusedTranslationZAnimation(this)));
    this.jdField_a_of_type_ComGoogleAndroidMaterialInternalStateListAnimator.a(jdField_e_of_type_ArrayOfInt, a(new FloatingActionButtonImpl.ResetElevationAnimation(this)));
    this.jdField_a_of_type_ComGoogleAndroidMaterialInternalStateListAnimator.a(f, a(new FloatingActionButtonImpl.DisabledElevationAnimation(this)));
    this.jdField_d_of_type_Float = this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonFloatingActionButton.getRotation();
  }
  
  @NonNull
  private AnimatorSet a(@NonNull MotionSpec paramMotionSpec, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    ArrayList localArrayList = new ArrayList();
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonFloatingActionButton, View.ALPHA, new float[] { paramFloat1 });
    paramMotionSpec.a("opacity").a(localObjectAnimator);
    localArrayList.add(localObjectAnimator);
    localObjectAnimator = ObjectAnimator.ofFloat(this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonFloatingActionButton, View.SCALE_X, new float[] { paramFloat2 });
    paramMotionSpec.a("scale").a(localObjectAnimator);
    a(localObjectAnimator);
    localArrayList.add(localObjectAnimator);
    localObjectAnimator = ObjectAnimator.ofFloat(this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonFloatingActionButton, View.SCALE_Y, new float[] { paramFloat2 });
    paramMotionSpec.a("scale").a(localObjectAnimator);
    a(localObjectAnimator);
    localArrayList.add(localObjectAnimator);
    a(paramFloat3, this.jdField_a_of_type_AndroidGraphicsMatrix);
    localObjectAnimator = ObjectAnimator.ofObject(this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonFloatingActionButton, new ImageMatrixProperty(), new FloatingActionButtonImpl.3(this), new Matrix[] { new Matrix(this.jdField_a_of_type_AndroidGraphicsMatrix) });
    paramMotionSpec.a("iconScale").a(localObjectAnimator);
    localArrayList.add(localObjectAnimator);
    paramMotionSpec = new AnimatorSet();
    AnimatorSetCompat.a(paramMotionSpec, localArrayList);
    return paramMotionSpec;
  }
  
  @NonNull
  private ValueAnimator a(@NonNull FloatingActionButtonImpl.ShadowAnimatorImpl paramShadowAnimatorImpl)
  {
    ValueAnimator localValueAnimator = new ValueAnimator();
    localValueAnimator.setInterpolator(jdField_a_of_type_AndroidAnimationTimeInterpolator);
    localValueAnimator.setDuration(100L);
    localValueAnimator.addListener(paramShadowAnimatorImpl);
    localValueAnimator.addUpdateListener(paramShadowAnimatorImpl);
    localValueAnimator.setFloatValues(new float[] { 0.0F, 1.0F });
    return localValueAnimator;
  }
  
  @NonNull
  private ViewTreeObserver.OnPreDrawListener a()
  {
    if (this.jdField_a_of_type_AndroidViewViewTreeObserver$OnPreDrawListener == null) {
      this.jdField_a_of_type_AndroidViewViewTreeObserver$OnPreDrawListener = new FloatingActionButtonImpl.5(this);
    }
    return this.jdField_a_of_type_AndroidViewViewTreeObserver$OnPreDrawListener;
  }
  
  private MotionSpec a()
  {
    if (this.jdField_a_of_type_ComGoogleAndroidMaterialAnimationMotionSpec == null) {
      this.jdField_a_of_type_ComGoogleAndroidMaterialAnimationMotionSpec = MotionSpec.a(this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonFloatingActionButton.getContext(), R.animator.jdField_b_of_type_Int);
    }
    return (MotionSpec)Preconditions.checkNotNull(this.jdField_a_of_type_ComGoogleAndroidMaterialAnimationMotionSpec);
  }
  
  private void a(float paramFloat, @NonNull Matrix paramMatrix)
  {
    paramMatrix.reset();
    Drawable localDrawable = this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonFloatingActionButton.getDrawable();
    if ((localDrawable != null) && (this.jdField_b_of_type_Int != 0))
    {
      RectF localRectF1 = this.jdField_a_of_type_AndroidGraphicsRectF;
      RectF localRectF2 = this.jdField_b_of_type_AndroidGraphicsRectF;
      localRectF1.set(0.0F, 0.0F, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
      int i = this.jdField_b_of_type_Int;
      localRectF2.set(0.0F, 0.0F, i, i);
      paramMatrix.setRectToRect(localRectF1, localRectF2, Matrix.ScaleToFit.CENTER);
      i = this.jdField_b_of_type_Int;
      paramMatrix.postScale(paramFloat, paramFloat, i / 2.0F, i / 2.0F);
    }
  }
  
  private void a(ObjectAnimator paramObjectAnimator)
  {
    if (Build.VERSION.SDK_INT != 26) {
      return;
    }
    paramObjectAnimator.setEvaluator(new FloatingActionButtonImpl.4(this));
  }
  
  private MotionSpec b()
  {
    if (this.jdField_b_of_type_ComGoogleAndroidMaterialAnimationMotionSpec == null) {
      this.jdField_b_of_type_ComGoogleAndroidMaterialAnimationMotionSpec = MotionSpec.a(this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonFloatingActionButton.getContext(), R.animator.jdField_a_of_type_Int);
    }
    return (MotionSpec)Preconditions.checkNotNull(this.jdField_b_of_type_ComGoogleAndroidMaterialAnimationMotionSpec);
  }
  
  private boolean g()
  {
    return (ViewCompat.isLaidOut(this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonFloatingActionButton)) && (!this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonFloatingActionButton.isInEditMode());
  }
  
  float a()
  {
    return this.jdField_a_of_type_Float;
  }
  
  MaterialShapeDrawable a()
  {
    return new MaterialShapeDrawable((ShapeAppearanceModel)Preconditions.checkNotNull(this.jdField_a_of_type_ComGoogleAndroidMaterialShapeShapeAppearanceModel));
  }
  
  @Nullable
  final ShapeAppearanceModel a()
  {
    return this.jdField_a_of_type_ComGoogleAndroidMaterialShapeShapeAppearanceModel;
  }
  
  final void a()
  {
    d(this.jdField_e_of_type_Float);
  }
  
  final void a(float paramFloat)
  {
    if (this.jdField_a_of_type_Float != paramFloat)
    {
      this.jdField_a_of_type_Float = paramFloat;
      a(this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, this.jdField_c_of_type_Float);
    }
  }
  
  void a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    f();
    e(paramFloat1);
  }
  
  void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  void a(@NonNull Animator.AnimatorListener paramAnimatorListener)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(paramAnimatorListener);
  }
  
  void a(@Nullable ColorStateList paramColorStateList)
  {
    Object localObject = this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable;
    if (localObject != null) {
      ((MaterialShapeDrawable)localObject).setTintList(paramColorStateList);
    }
    localObject = this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonBorderDrawable;
    if (localObject != null) {
      ((BorderDrawable)localObject).a(paramColorStateList);
    }
  }
  
  void a(ColorStateList paramColorStateList1, @Nullable PorterDuff.Mode paramMode, ColorStateList paramColorStateList2, int paramInt)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable = a();
    this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable.setTintList(paramColorStateList1);
    if (paramMode != null) {
      this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable.setTintMode(paramMode);
    }
    this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable.G(-12303292);
    this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable.a(this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonFloatingActionButton.getContext());
    paramColorStateList1 = new RippleDrawableCompat(this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable.a());
    paramColorStateList1.setTintList(RippleUtils.b(paramColorStateList2));
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramColorStateList1;
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = new LayerDrawable(new Drawable[] { (Drawable)Preconditions.checkNotNull(this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable), paramColorStateList1 });
  }
  
  void a(@Nullable PorterDuff.Mode paramMode)
  {
    MaterialShapeDrawable localMaterialShapeDrawable = this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable;
    if (localMaterialShapeDrawable != null) {
      localMaterialShapeDrawable.setTintMode(paramMode);
    }
  }
  
  void a(@NonNull Rect paramRect)
  {
    if (this.jdField_a_of_type_Boolean) {
      i = (this.jdField_a_of_type_Int - this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonFloatingActionButton.b()) / 2;
    } else {
      i = 0;
    }
    float f1;
    if (this.jdField_b_of_type_Boolean) {
      f1 = a() + this.jdField_c_of_type_Float;
    } else {
      f1 = 0.0F;
    }
    int j = Math.max(i, (int)Math.ceil(f1));
    int i = Math.max(i, (int)Math.ceil(f1 * 1.5F));
    paramRect.set(j, i, j, i);
  }
  
  final void a(@Nullable MotionSpec paramMotionSpec)
  {
    this.jdField_c_of_type_ComGoogleAndroidMaterialAnimationMotionSpec = paramMotionSpec;
  }
  
  void a(@NonNull FloatingActionButtonImpl.InternalTransformationCallback paramInternalTransformationCallback)
  {
    if (this.jdField_c_of_type_JavaUtilArrayList == null) {
      this.jdField_c_of_type_JavaUtilArrayList = new ArrayList();
    }
    this.jdField_c_of_type_JavaUtilArrayList.add(paramInternalTransformationCallback);
  }
  
  void a(@Nullable FloatingActionButtonImpl.InternalVisibilityChangedListener paramInternalVisibilityChangedListener, boolean paramBoolean)
  {
    if (f()) {
      return;
    }
    Object localObject = this.jdField_a_of_type_AndroidAnimationAnimator;
    if (localObject != null) {
      ((Animator)localObject).cancel();
    }
    if (g())
    {
      localObject = this.jdField_d_of_type_ComGoogleAndroidMaterialAnimationMotionSpec;
      if (localObject == null) {
        localObject = b();
      }
      localObject = a((MotionSpec)localObject, 0.0F, 0.0F, 0.0F);
      ((AnimatorSet)localObject).addListener(new FloatingActionButtonImpl.1(this, paramBoolean, paramInternalVisibilityChangedListener));
      paramInternalVisibilityChangedListener = this.jdField_b_of_type_JavaUtilArrayList;
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
    localObject = this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonFloatingActionButton;
    int i;
    if (paramBoolean) {
      i = 8;
    } else {
      i = 4;
    }
    ((FloatingActionButton)localObject).a(i, paramBoolean);
    if (paramInternalVisibilityChangedListener != null) {
      paramInternalVisibilityChangedListener.b();
    }
  }
  
  final void a(@NonNull ShapeAppearanceModel paramShapeAppearanceModel)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialShapeShapeAppearanceModel = paramShapeAppearanceModel;
    Object localObject = this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable;
    if (localObject != null) {
      ((MaterialShapeDrawable)localObject).setShapeAppearanceModel(paramShapeAppearanceModel);
    }
    localObject = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    if ((localObject instanceof Shapeable)) {
      ((Shapeable)localObject).setShapeAppearanceModel(paramShapeAppearanceModel);
    }
    localObject = this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonBorderDrawable;
    if (localObject != null) {
      ((BorderDrawable)localObject).a(paramShapeAppearanceModel);
    }
  }
  
  void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  void a(int[] paramArrayOfInt)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialInternalStateListAnimator.a(paramArrayOfInt);
  }
  
  final boolean a()
  {
    return (!this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonFloatingActionButton.b() >= this.jdField_a_of_type_Int);
  }
  
  void b()
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialInternalStateListAnimator.a();
  }
  
  final void b(float paramFloat)
  {
    if (this.jdField_b_of_type_Float != paramFloat)
    {
      this.jdField_b_of_type_Float = paramFloat;
      a(this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, this.jdField_c_of_type_Float);
    }
  }
  
  final void b(int paramInt)
  {
    if (this.jdField_b_of_type_Int != paramInt)
    {
      this.jdField_b_of_type_Int = paramInt;
      a();
    }
  }
  
  public void b(@NonNull Animator.AnimatorListener paramAnimatorListener)
  {
    if (this.jdField_b_of_type_JavaUtilArrayList == null) {
      this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    }
    this.jdField_b_of_type_JavaUtilArrayList.add(paramAnimatorListener);
  }
  
  void b(@Nullable ColorStateList paramColorStateList)
  {
    Drawable localDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    if (localDrawable != null) {
      DrawableCompat.setTintList(localDrawable, RippleUtils.b(paramColorStateList));
    }
  }
  
  void b(@NonNull Rect paramRect)
  {
    Preconditions.checkNotNull(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable, "Didn't initialize content background");
    if (c())
    {
      paramRect = new InsetDrawable(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable, paramRect.left, paramRect.top, paramRect.right, paramRect.bottom);
      this.jdField_a_of_type_ComGoogleAndroidMaterialShadowShadowViewDelegate.a(paramRect);
      return;
    }
    this.jdField_a_of_type_ComGoogleAndroidMaterialShadowShadowViewDelegate.a(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable);
  }
  
  final void b(@Nullable MotionSpec paramMotionSpec)
  {
    this.jdField_d_of_type_ComGoogleAndroidMaterialAnimationMotionSpec = paramMotionSpec;
  }
  
  void b(@Nullable FloatingActionButtonImpl.InternalVisibilityChangedListener paramInternalVisibilityChangedListener, boolean paramBoolean)
  {
    if (e()) {
      return;
    }
    Object localObject = this.jdField_a_of_type_AndroidAnimationAnimator;
    if (localObject != null) {
      ((Animator)localObject).cancel();
    }
    if (g())
    {
      if (this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonFloatingActionButton.getVisibility() != 0)
      {
        this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonFloatingActionButton.setAlpha(0.0F);
        this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonFloatingActionButton.setScaleY(0.0F);
        this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonFloatingActionButton.setScaleX(0.0F);
        d(0.0F);
      }
      localObject = this.jdField_c_of_type_ComGoogleAndroidMaterialAnimationMotionSpec;
      if (localObject == null) {
        localObject = a();
      }
      localObject = a((MotionSpec)localObject, 1.0F, 1.0F, 1.0F);
      ((AnimatorSet)localObject).addListener(new FloatingActionButtonImpl.2(this, paramBoolean, paramInternalVisibilityChangedListener));
      paramInternalVisibilityChangedListener = this.jdField_a_of_type_JavaUtilArrayList;
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
    this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonFloatingActionButton.a(0, paramBoolean);
    this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonFloatingActionButton.setAlpha(1.0F);
    this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonFloatingActionButton.setScaleY(1.0F);
    this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonFloatingActionButton.setScaleX(1.0F);
    d(1.0F);
    if (paramInternalVisibilityChangedListener != null) {
      paramInternalVisibilityChangedListener.a();
    }
  }
  
  void b(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    f();
  }
  
  boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  void c()
  {
    Object localObject = this.jdField_c_of_type_JavaUtilArrayList;
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((FloatingActionButtonImpl.InternalTransformationCallback)((Iterator)localObject).next()).a();
      }
    }
  }
  
  final void c(float paramFloat)
  {
    if (this.jdField_c_of_type_Float != paramFloat)
    {
      this.jdField_c_of_type_Float = paramFloat;
      a(this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, this.jdField_c_of_type_Float);
    }
  }
  
  boolean c()
  {
    return true;
  }
  
  void d()
  {
    Object localObject = this.jdField_c_of_type_JavaUtilArrayList;
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((FloatingActionButtonImpl.InternalTransformationCallback)((Iterator)localObject).next()).b();
      }
    }
  }
  
  final void d(float paramFloat)
  {
    this.jdField_e_of_type_Float = paramFloat;
    Matrix localMatrix = this.jdField_a_of_type_AndroidGraphicsMatrix;
    a(paramFloat, localMatrix);
    this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonFloatingActionButton.setImageMatrix(localMatrix);
  }
  
  boolean d()
  {
    return true;
  }
  
  void e() {}
  
  void e(float paramFloat)
  {
    MaterialShapeDrawable localMaterialShapeDrawable = this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable;
    if (localMaterialShapeDrawable != null) {
      localMaterialShapeDrawable.r(paramFloat);
    }
  }
  
  boolean e()
  {
    int i = this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonFloatingActionButton.getVisibility();
    boolean bool2 = false;
    boolean bool1 = false;
    if (i != 0)
    {
      if (this.jdField_c_of_type_Int == 2) {
        bool1 = true;
      }
      return bool1;
    }
    bool1 = bool2;
    if (this.jdField_c_of_type_Int != 1) {
      bool1 = true;
    }
    return bool1;
  }
  
  final void f()
  {
    Rect localRect = this.jdField_a_of_type_AndroidGraphicsRect;
    a(localRect);
    b(localRect);
    this.jdField_a_of_type_ComGoogleAndroidMaterialShadowShadowViewDelegate.a(localRect.left, localRect.top, localRect.right, localRect.bottom);
  }
  
  boolean f()
  {
    int i = this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonFloatingActionButton.getVisibility();
    boolean bool2 = false;
    boolean bool1 = false;
    if (i == 0)
    {
      if (this.jdField_c_of_type_Int == 1) {
        bool1 = true;
      }
      return bool1;
    }
    bool1 = bool2;
    if (this.jdField_c_of_type_Int != 2) {
      bool1 = true;
    }
    return bool1;
  }
  
  void g()
  {
    MaterialShapeDrawable localMaterialShapeDrawable = this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable;
    if (localMaterialShapeDrawable != null) {
      MaterialShapeUtils.a(this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonFloatingActionButton, localMaterialShapeDrawable);
    }
    if (d()) {
      this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonFloatingActionButton.getViewTreeObserver().addOnPreDrawListener(a());
    }
  }
  
  void h()
  {
    ViewTreeObserver localViewTreeObserver = this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonFloatingActionButton.getViewTreeObserver();
    ViewTreeObserver.OnPreDrawListener localOnPreDrawListener = this.jdField_a_of_type_AndroidViewViewTreeObserver$OnPreDrawListener;
    if (localOnPreDrawListener != null)
    {
      localViewTreeObserver.removeOnPreDrawListener(localOnPreDrawListener);
      this.jdField_a_of_type_AndroidViewViewTreeObserver$OnPreDrawListener = null;
    }
  }
  
  void i()
  {
    float f1 = this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonFloatingActionButton.getRotation();
    if (this.jdField_d_of_type_Float != f1)
    {
      this.jdField_d_of_type_Float = f1;
      j();
    }
  }
  
  void j()
  {
    if (Build.VERSION.SDK_INT == 19) {
      if (this.jdField_d_of_type_Float % 90.0F != 0.0F)
      {
        if (this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonFloatingActionButton.getLayerType() != 1) {
          this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonFloatingActionButton.setLayerType(1, null);
        }
      }
      else if (this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonFloatingActionButton.getLayerType() != 0) {
        this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonFloatingActionButton.setLayerType(0, null);
      }
    }
    MaterialShapeDrawable localMaterialShapeDrawable = this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable;
    if (localMaterialShapeDrawable != null) {
      localMaterialShapeDrawable.F((int)this.jdField_d_of_type_Float);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
 * JD-Core Version:    0.7.0.1
 */