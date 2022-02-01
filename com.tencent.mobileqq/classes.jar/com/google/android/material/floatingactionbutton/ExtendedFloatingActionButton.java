package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import androidx.annotation.AnimatorRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior;
import androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior;
import androidx.core.view.ViewCompat;
import com.google.android.material.R.attr;
import com.google.android.material.R.style;
import com.google.android.material.R.styleable;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.ShapeAppearanceModel.Builder;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.util.Iterator;
import java.util.List;

public class ExtendedFloatingActionButton
  extends MaterialButton
  implements CoordinatorLayout.AttachedBehavior
{
  private static final int jdField_a_of_type_Int = R.style.B;
  static final Property<View, Float> jdField_a_of_type_AndroidUtilProperty = new ExtendedFloatingActionButton.4(Float.class, "width");
  static final Property<View, Float> jdField_b_of_type_AndroidUtilProperty = new ExtendedFloatingActionButton.5(Float.class, "height");
  static final Property<View, Float> jdField_c_of_type_AndroidUtilProperty = new ExtendedFloatingActionButton.6(Float.class, "paddingStart");
  static final Property<View, Float> jdField_d_of_type_AndroidUtilProperty = new ExtendedFloatingActionButton.7(Float.class, "paddingEnd");
  @NonNull
  protected ColorStateList a;
  @NonNull
  private final CoordinatorLayout.Behavior<ExtendedFloatingActionButton> jdField_a_of_type_AndroidxCoordinatorlayoutWidgetCoordinatorLayout$Behavior;
  private final AnimatorTracker jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonAnimatorTracker = new AnimatorTracker();
  @NonNull
  private final MotionStrategy jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonMotionStrategy;
  private boolean jdField_a_of_type_Boolean = true;
  private int jdField_b_of_type_Int = 0;
  @NonNull
  private final MotionStrategy jdField_b_of_type_ComGoogleAndroidMaterialFloatingactionbuttonMotionStrategy;
  private boolean jdField_b_of_type_Boolean = false;
  private final int jdField_c_of_type_Int;
  private final MotionStrategy jdField_c_of_type_ComGoogleAndroidMaterialFloatingactionbuttonMotionStrategy = new ExtendedFloatingActionButton.ShowStrategy(this, this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonAnimatorTracker);
  private boolean jdField_c_of_type_Boolean = false;
  private int jdField_d_of_type_Int;
  private final MotionStrategy jdField_d_of_type_ComGoogleAndroidMaterialFloatingactionbuttonMotionStrategy = new ExtendedFloatingActionButton.HideStrategy(this, this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonAnimatorTracker);
  private int e;
  
  public ExtendedFloatingActionButton(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ExtendedFloatingActionButton(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.q);
  }
  
  public ExtendedFloatingActionButton(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(MaterialThemeOverlay.a(paramContext, paramAttributeSet, paramInt, jdField_a_of_type_Int), paramAttributeSet, paramInt);
    paramContext = getContext();
    this.jdField_a_of_type_AndroidxCoordinatorlayoutWidgetCoordinatorLayout$Behavior = new ExtendedFloatingActionButton.ExtendedFloatingActionButtonBehavior(paramContext, paramAttributeSet);
    TypedArray localTypedArray = ThemeEnforcement.a(paramContext, paramAttributeSet, R.styleable.x, paramInt, jdField_a_of_type_Int, new int[0]);
    MotionSpec localMotionSpec1 = MotionSpec.a(paramContext, localTypedArray, R.styleable.bC);
    MotionSpec localMotionSpec2 = MotionSpec.a(paramContext, localTypedArray, R.styleable.bB);
    MotionSpec localMotionSpec3 = MotionSpec.a(paramContext, localTypedArray, R.styleable.bA);
    MotionSpec localMotionSpec4 = MotionSpec.a(paramContext, localTypedArray, R.styleable.bD);
    this.jdField_c_of_type_Int = localTypedArray.getDimensionPixelSize(R.styleable.bz, -1);
    this.jdField_d_of_type_Int = ViewCompat.getPaddingStart(this);
    this.e = ViewCompat.getPaddingEnd(this);
    AnimatorTracker localAnimatorTracker = new AnimatorTracker();
    this.jdField_b_of_type_ComGoogleAndroidMaterialFloatingactionbuttonMotionStrategy = new ExtendedFloatingActionButton.ChangeSizeStrategy(this, localAnimatorTracker, new ExtendedFloatingActionButton.1(this), true);
    this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonMotionStrategy = new ExtendedFloatingActionButton.ChangeSizeStrategy(this, localAnimatorTracker, new ExtendedFloatingActionButton.2(this), false);
    this.jdField_c_of_type_ComGoogleAndroidMaterialFloatingactionbuttonMotionStrategy.a(localMotionSpec1);
    this.jdField_d_of_type_ComGoogleAndroidMaterialFloatingactionbuttonMotionStrategy.a(localMotionSpec2);
    this.jdField_b_of_type_ComGoogleAndroidMaterialFloatingactionbuttonMotionStrategy.a(localMotionSpec3);
    this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonMotionStrategy.a(localMotionSpec4);
    localTypedArray.recycle();
    setShapeAppearanceModel(ShapeAppearanceModel.a(paramContext, paramAttributeSet, paramInt, jdField_a_of_type_Int, ShapeAppearanceModel.a).a());
    a();
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidContentResColorStateList = getTextColors();
  }
  
  private void a(@NonNull MotionStrategy paramMotionStrategy, @Nullable ExtendedFloatingActionButton.OnChangedCallback paramOnChangedCallback)
  {
    if (paramMotionStrategy.a()) {
      return;
    }
    if (!d())
    {
      paramMotionStrategy.c();
      paramMotionStrategy.a(paramOnChangedCallback);
      return;
    }
    measure(0, 0);
    AnimatorSet localAnimatorSet = paramMotionStrategy.a();
    localAnimatorSet.addListener(new ExtendedFloatingActionButton.3(this, paramMotionStrategy, paramOnChangedCallback));
    paramMotionStrategy = paramMotionStrategy.a().iterator();
    while (paramMotionStrategy.hasNext()) {
      localAnimatorSet.addListener((Animator.AnimatorListener)paramMotionStrategy.next());
    }
    localAnimatorSet.start();
  }
  
  private boolean b()
  {
    int i = getVisibility();
    boolean bool2 = false;
    boolean bool1 = false;
    if (i != 0)
    {
      if (this.jdField_b_of_type_Int == 2) {
        bool1 = true;
      }
      return bool1;
    }
    bool1 = bool2;
    if (this.jdField_b_of_type_Int != 1) {
      bool1 = true;
    }
    return bool1;
  }
  
  private boolean c()
  {
    int i = getVisibility();
    boolean bool2 = false;
    boolean bool1 = false;
    if (i == 0)
    {
      if (this.jdField_b_of_type_Int == 1) {
        bool1 = true;
      }
      return bool1;
    }
    bool1 = bool2;
    if (this.jdField_b_of_type_Int != 2) {
      bool1 = true;
    }
    return bool1;
  }
  
  private boolean d()
  {
    return ((ViewCompat.isLaidOut(this)) || ((!b()) && (this.jdField_c_of_type_Boolean))) && (!isInEditMode());
  }
  
  protected void a(@NonNull ColorStateList paramColorStateList)
  {
    super.setTextColor(paramColorStateList);
  }
  
  @VisibleForTesting
  int c()
  {
    int j = this.jdField_c_of_type_Int;
    int i = j;
    if (j < 0) {
      i = Math.min(ViewCompat.getPaddingStart(this), ViewCompat.getPaddingEnd(this)) * 2 + a();
    }
    return i;
  }
  
  int d()
  {
    return (c() - a()) / 2;
  }
  
  @NonNull
  public CoordinatorLayout.Behavior<ExtendedFloatingActionButton> getBehavior()
  {
    return this.jdField_a_of_type_AndroidxCoordinatorlayoutWidgetCoordinatorLayout$Behavior;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if ((this.jdField_a_of_type_Boolean) && (TextUtils.isEmpty(getText())) && (a() != null))
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonMotionStrategy.c();
    }
  }
  
  public void setAnimateShowBeforeLayout(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public void setExtendMotionSpec(@Nullable MotionSpec paramMotionSpec)
  {
    this.jdField_b_of_type_ComGoogleAndroidMaterialFloatingactionbuttonMotionStrategy.a(paramMotionSpec);
  }
  
  public void setExtendMotionSpecResource(@AnimatorRes int paramInt)
  {
    setExtendMotionSpec(MotionSpec.a(getContext(), paramInt));
  }
  
  public void setExtended(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean == paramBoolean) {
      return;
    }
    MotionStrategy localMotionStrategy;
    if (paramBoolean) {
      localMotionStrategy = this.jdField_b_of_type_ComGoogleAndroidMaterialFloatingactionbuttonMotionStrategy;
    } else {
      localMotionStrategy = this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonMotionStrategy;
    }
    if (localMotionStrategy.a()) {
      return;
    }
    localMotionStrategy.c();
  }
  
  public void setHideMotionSpec(@Nullable MotionSpec paramMotionSpec)
  {
    this.jdField_d_of_type_ComGoogleAndroidMaterialFloatingactionbuttonMotionStrategy.a(paramMotionSpec);
  }
  
  public void setHideMotionSpecResource(@AnimatorRes int paramInt)
  {
    setHideMotionSpec(MotionSpec.a(getContext(), paramInt));
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((this.jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_Boolean))
    {
      this.jdField_d_of_type_Int = ViewCompat.getPaddingStart(this);
      this.e = ViewCompat.getPaddingEnd(this);
    }
  }
  
  public void setPaddingRelative(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.setPaddingRelative(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((this.jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_Boolean))
    {
      this.jdField_d_of_type_Int = paramInt1;
      this.e = paramInt3;
    }
  }
  
  public void setShowMotionSpec(@Nullable MotionSpec paramMotionSpec)
  {
    this.jdField_c_of_type_ComGoogleAndroidMaterialFloatingactionbuttonMotionStrategy.a(paramMotionSpec);
  }
  
  public void setShowMotionSpecResource(@AnimatorRes int paramInt)
  {
    setShowMotionSpec(MotionSpec.a(getContext(), paramInt));
  }
  
  public void setShrinkMotionSpec(@Nullable MotionSpec paramMotionSpec)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonMotionStrategy.a(paramMotionSpec);
  }
  
  public void setShrinkMotionSpecResource(@AnimatorRes int paramInt)
  {
    setShrinkMotionSpec(MotionSpec.a(getContext(), paramInt));
  }
  
  public void setTextColor(int paramInt)
  {
    super.setTextColor(paramInt);
    a();
  }
  
  public void setTextColor(@NonNull ColorStateList paramColorStateList)
  {
    super.setTextColor(paramColorStateList);
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
 * JD-Core Version:    0.7.0.1
 */