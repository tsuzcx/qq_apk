package com.google.android.material.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Paint.Style;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Dimension;
import androidx.annotation.MenuRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.Toolbar.LayoutParams;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R.attr;
import com.google.android.material.R.dimen;
import com.google.android.material.R.style;
import com.google.android.material.R.styleable;
import com.google.android.material.animation.TransformationCallback;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.EdgeTreatment;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.ShapeAppearanceModel.Builder;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class BottomAppBar
  extends Toolbar
  implements CoordinatorLayout.AttachedBehavior
{
  private static final int jdField_a_of_type_Int = R.style.s;
  @Nullable
  private Animator jdField_a_of_type_AndroidAnimationAnimator;
  @NonNull
  AnimatorListenerAdapter jdField_a_of_type_AndroidAnimationAnimatorListenerAdapter = new BottomAppBar.1(this);
  @NonNull
  TransformationCallback<FloatingActionButton> jdField_a_of_type_ComGoogleAndroidMaterialAnimationTransformationCallback = new BottomAppBar.2(this);
  private BottomAppBar.Behavior jdField_a_of_type_ComGoogleAndroidMaterialBottomappbarBottomAppBar$Behavior;
  private final MaterialShapeDrawable jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable = new MaterialShapeDrawable();
  private ArrayList<BottomAppBar.AnimationListener> jdField_a_of_type_JavaUtilArrayList;
  private boolean jdField_a_of_type_Boolean;
  private final int jdField_b_of_type_Int;
  @Nullable
  private Animator jdField_b_of_type_AndroidAnimationAnimator;
  private final boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private final boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private final boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int = 0;
  private boolean jdField_e_of_type_Boolean = false;
  @MenuRes
  private int jdField_f_of_type_Int = 0;
  private boolean jdField_f_of_type_Boolean = true;
  private int g;
  private int h;
  private int i;
  
  public BottomAppBar(@NonNull Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public BottomAppBar(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.jdField_c_of_type_Int);
  }
  
  public BottomAppBar(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(MaterialThemeOverlay.a(paramContext, paramAttributeSet, paramInt, jdField_a_of_type_Int), paramAttributeSet, paramInt);
    paramContext = getContext();
    Object localObject = ThemeEnforcement.a(paramContext, paramAttributeSet, R.styleable.f, paramInt, jdField_a_of_type_Int, new int[0]);
    ColorStateList localColorStateList = MaterialResources.a(paramContext, (TypedArray)localObject, R.styleable.s);
    int j = ((TypedArray)localObject).getDimensionPixelSize(R.styleable.t, 0);
    float f1 = ((TypedArray)localObject).getDimensionPixelOffset(R.styleable.w, 0);
    float f2 = ((TypedArray)localObject).getDimensionPixelOffset(R.styleable.x, 0);
    float f3 = ((TypedArray)localObject).getDimensionPixelOffset(R.styleable.y, 0);
    this.jdField_c_of_type_Int = ((TypedArray)localObject).getInt(R.styleable.u, 0);
    this.jdField_d_of_type_Int = ((TypedArray)localObject).getInt(R.styleable.v, 0);
    this.jdField_a_of_type_Boolean = ((TypedArray)localObject).getBoolean(R.styleable.z, false);
    this.jdField_b_of_type_Boolean = ((TypedArray)localObject).getBoolean(R.styleable.A, false);
    this.jdField_c_of_type_Boolean = ((TypedArray)localObject).getBoolean(R.styleable.B, false);
    this.jdField_d_of_type_Boolean = ((TypedArray)localObject).getBoolean(R.styleable.C, false);
    ((TypedArray)localObject).recycle();
    this.jdField_b_of_type_Int = getResources().getDimensionPixelOffset(R.dimen.N);
    localObject = new BottomAppBarTopEdgeTreatment(f1, f2, f3);
    localObject = ShapeAppearanceModel.a().a((EdgeTreatment)localObject).a();
    this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable.setShapeAppearanceModel((ShapeAppearanceModel)localObject);
    this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable.D(2);
    this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable.a(Paint.Style.FILL);
    this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable.a(paramContext);
    setElevation(j);
    DrawableCompat.setTintList(this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable, localColorStateList);
    ViewCompat.setBackground(this, this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable);
    ViewUtils.a(this, paramAttributeSet, paramInt, jdField_a_of_type_Int, new BottomAppBar.3(this));
  }
  
  private float a(int paramInt)
  {
    boolean bool = ViewUtils.a(this);
    int j = 1;
    if (paramInt == 1)
    {
      if (bool) {
        paramInt = this.i;
      } else {
        paramInt = this.h;
      }
      int k = this.jdField_b_of_type_Int;
      int m = getMeasuredWidth() / 2;
      if (bool) {
        j = -1;
      }
      return (m - (k + paramInt)) * j;
    }
    return 0.0F;
  }
  
  private int a()
  {
    return this.g;
  }
  
  @Nullable
  private View a()
  {
    if (!(getParent() instanceof CoordinatorLayout)) {
      return null;
    }
    Iterator localIterator = ((CoordinatorLayout)getParent()).getDependents(this).iterator();
    while (localIterator.hasNext())
    {
      View localView = (View)localIterator.next();
      if (((localView instanceof FloatingActionButton)) || ((localView instanceof ExtendedFloatingActionButton))) {
        return localView;
      }
    }
    return null;
  }
  
  @Nullable
  private ActionMenuView a()
  {
    int j = 0;
    while (j < getChildCount())
    {
      View localView = getChildAt(j);
      if ((localView instanceof ActionMenuView)) {
        return (ActionMenuView)localView;
      }
      j += 1;
    }
    return null;
  }
  
  @NonNull
  private BottomAppBarTopEdgeTreatment a()
  {
    return (BottomAppBarTopEdgeTreatment)this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable.a().b();
  }
  
  @Nullable
  private FloatingActionButton a()
  {
    View localView = a();
    if ((localView instanceof FloatingActionButton)) {
      return (FloatingActionButton)localView;
    }
    return null;
  }
  
  private void a()
  {
    int j = this.jdField_e_of_type_Int;
    this.jdField_e_of_type_Int = (j + 1);
    if (j == 0)
    {
      Object localObject = this.jdField_a_of_type_JavaUtilArrayList;
      if (localObject != null)
      {
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((BottomAppBar.AnimationListener)((Iterator)localObject).next()).a(this);
        }
      }
    }
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    if (!ViewCompat.isLaidOut(this))
    {
      this.jdField_e_of_type_Boolean = false;
      a(this.jdField_f_of_type_Int);
      return;
    }
    Object localObject = this.jdField_b_of_type_AndroidAnimationAnimator;
    if (localObject != null) {
      ((Animator)localObject).cancel();
    }
    localObject = new ArrayList();
    if (!b())
    {
      paramInt = 0;
      paramBoolean = false;
    }
    a(paramInt, paramBoolean, (List)localObject);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.playTogether((Collection)localObject);
    this.jdField_b_of_type_AndroidAnimationAnimator = localAnimatorSet;
    this.jdField_b_of_type_AndroidAnimationAnimator.addListener(new BottomAppBar.6(this));
    this.jdField_b_of_type_AndroidAnimationAnimator.start();
  }
  
  private void a(int paramInt, boolean paramBoolean, @NonNull List<Animator> paramList)
  {
    Object localObject = a();
    if (localObject == null) {
      return;
    }
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(localObject, "alpha", new float[] { 1.0F });
    if (Math.abs(((ActionMenuView)localObject).getTranslationX() - a((ActionMenuView)localObject, paramInt, paramBoolean)) > 1.0F)
    {
      ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(localObject, "alpha", new float[] { 0.0F });
      localObjectAnimator2.addListener(new BottomAppBar.7(this, (ActionMenuView)localObject, paramInt, paramBoolean));
      localObject = new AnimatorSet();
      ((AnimatorSet)localObject).setDuration(150L);
      ((AnimatorSet)localObject).playSequentially(new Animator[] { localObjectAnimator2, localObjectAnimator1 });
      paramList.add(localObject);
      return;
    }
    if (((ActionMenuView)localObject).getAlpha() < 1.0F) {
      paramList.add(localObjectAnimator1);
    }
  }
  
  private void a(@NonNull ActionMenuView paramActionMenuView, int paramInt, boolean paramBoolean)
  {
    a(paramActionMenuView, paramInt, paramBoolean, false);
  }
  
  private void a(@NonNull ActionMenuView paramActionMenuView, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    BottomAppBar.8 local8 = new BottomAppBar.8(this, paramActionMenuView, paramInt, paramBoolean1);
    if (paramBoolean2)
    {
      paramActionMenuView.post(local8);
      return;
    }
    local8.run();
  }
  
  private void a(@NonNull FloatingActionButton paramFloatingActionButton)
  {
    paramFloatingActionButton.b(this.jdField_a_of_type_AndroidAnimationAnimatorListenerAdapter);
    paramFloatingActionButton.a(new BottomAppBar.9(this));
    paramFloatingActionButton.a(this.jdField_a_of_type_ComGoogleAndroidMaterialAnimationTransformationCallback);
  }
  
  private int b()
  {
    return this.h;
  }
  
  private void b()
  {
    int j = this.jdField_e_of_type_Int - 1;
    this.jdField_e_of_type_Int = j;
    if (j == 0)
    {
      Object localObject = this.jdField_a_of_type_JavaUtilArrayList;
      if (localObject != null)
      {
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((BottomAppBar.AnimationListener)((Iterator)localObject).next()).b(this);
        }
      }
    }
  }
  
  private void b(int paramInt)
  {
    if (this.jdField_c_of_type_Int != paramInt)
    {
      if (!ViewCompat.isLaidOut(this)) {
        return;
      }
      Object localObject = this.jdField_a_of_type_AndroidAnimationAnimator;
      if (localObject != null) {
        ((Animator)localObject).cancel();
      }
      localObject = new ArrayList();
      if (this.jdField_d_of_type_Int == 1) {
        b(paramInt, (List)localObject);
      } else {
        a(paramInt, (List)localObject);
      }
      AnimatorSet localAnimatorSet = new AnimatorSet();
      localAnimatorSet.playTogether((Collection)localObject);
      this.jdField_a_of_type_AndroidAnimationAnimator = localAnimatorSet;
      this.jdField_a_of_type_AndroidAnimationAnimator.addListener(new BottomAppBar.4(this));
      this.jdField_a_of_type_AndroidAnimationAnimator.start();
    }
  }
  
  private void b(int paramInt, @NonNull List<Animator> paramList)
  {
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(a(), "translationX", new float[] { a(paramInt) });
    localObjectAnimator.setDuration(300L);
    paramList.add(localObjectAnimator);
  }
  
  private boolean b()
  {
    FloatingActionButton localFloatingActionButton = a();
    return (localFloatingActionButton != null) && (localFloatingActionButton.c());
  }
  
  private int c()
  {
    return this.i;
  }
  
  private void c()
  {
    Animator localAnimator = this.jdField_b_of_type_AndroidAnimationAnimator;
    if (localAnimator != null) {
      localAnimator.cancel();
    }
    localAnimator = this.jdField_a_of_type_AndroidAnimationAnimator;
    if (localAnimator != null) {
      localAnimator.cancel();
    }
  }
  
  private float d()
  {
    return -a().c();
  }
  
  private void d()
  {
    a().b(e());
    View localView = a();
    MaterialShapeDrawable localMaterialShapeDrawable = this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable;
    float f1;
    if ((this.jdField_f_of_type_Boolean) && (b())) {
      f1 = 1.0F;
    } else {
      f1 = 0.0F;
    }
    localMaterialShapeDrawable.p(f1);
    if (localView != null)
    {
      localView.setTranslationY(d());
      localView.setTranslationX(e());
    }
  }
  
  private float e()
  {
    return a(this.jdField_c_of_type_Int);
  }
  
  private void e()
  {
    ActionMenuView localActionMenuView = a();
    if ((localActionMenuView != null) && (this.jdField_b_of_type_AndroidAnimationAnimator == null))
    {
      localActionMenuView.setAlpha(1.0F);
      if (!b())
      {
        a(localActionMenuView, 0, false);
        return;
      }
      a(localActionMenuView, this.jdField_c_of_type_Int, this.jdField_f_of_type_Boolean);
    }
  }
  
  public float a()
  {
    return a().d();
  }
  
  protected int a(@NonNull ActionMenuView paramActionMenuView, int paramInt, boolean paramBoolean)
  {
    if (paramInt == 1)
    {
      if (!paramBoolean) {
        return 0;
      }
      paramBoolean = ViewUtils.a(this);
      if (paramBoolean) {
        paramInt = getMeasuredWidth();
      } else {
        paramInt = 0;
      }
      int k = 0;
      for (int j = paramInt; k < getChildCount(); j = paramInt)
      {
        View localView = getChildAt(k);
        int m;
        if (((localView.getLayoutParams() instanceof Toolbar.LayoutParams)) && ((((Toolbar.LayoutParams)localView.getLayoutParams()).gravity & 0x800007) == 8388611)) {
          m = 1;
        } else {
          m = 0;
        }
        paramInt = j;
        if (m != 0) {
          if (paramBoolean) {
            paramInt = Math.min(j, localView.getLeft());
          } else {
            paramInt = Math.max(j, localView.getRight());
          }
        }
        k += 1;
      }
      if (paramBoolean) {
        paramInt = paramActionMenuView.getRight();
      } else {
        paramInt = paramActionMenuView.getLeft();
      }
      if (paramBoolean) {
        k = this.h;
      } else {
        k = -this.i;
      }
      return j - (paramInt + k);
    }
    return 0;
  }
  
  @NonNull
  public BottomAppBar.Behavior a()
  {
    if (this.jdField_a_of_type_ComGoogleAndroidMaterialBottomappbarBottomAppBar$Behavior == null) {
      this.jdField_a_of_type_ComGoogleAndroidMaterialBottomappbarBottomAppBar$Behavior = new BottomAppBar.Behavior();
    }
    return this.jdField_a_of_type_ComGoogleAndroidMaterialBottomappbarBottomAppBar$Behavior;
  }
  
  public void a(@MenuRes int paramInt)
  {
    if (paramInt != 0)
    {
      this.jdField_f_of_type_Int = 0;
      getMenu().clear();
      inflateMenu(paramInt);
    }
  }
  
  protected void a(int paramInt, List<Animator> paramList)
  {
    paramList = a();
    if (paramList != null)
    {
      if (paramList.b()) {
        return;
      }
      a();
      paramList.b(new BottomAppBar.5(this, paramInt));
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  boolean a(@Px int paramInt)
  {
    float f1 = paramInt;
    if (f1 != a().a())
    {
      a().a(f1);
      this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable.invalidateSelf();
      return true;
    }
    return false;
  }
  
  @Dimension
  public float b()
  {
    return a().e();
  }
  
  @Dimension
  public float c()
  {
    return a().c();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    MaterialShapeUtils.a(this, this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable);
    if ((getParent() instanceof ViewGroup)) {
      ((ViewGroup)getParent()).setClipChildren(false);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramBoolean)
    {
      c();
      d();
    }
    e();
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof BottomAppBar.SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (BottomAppBar.SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    this.jdField_c_of_type_Int = paramParcelable.jdField_a_of_type_Int;
    this.jdField_f_of_type_Boolean = paramParcelable.jdField_a_of_type_Boolean;
  }
  
  @NonNull
  protected Parcelable onSaveInstanceState()
  {
    BottomAppBar.SavedState localSavedState = new BottomAppBar.SavedState(super.onSaveInstanceState());
    localSavedState.jdField_a_of_type_Int = this.jdField_c_of_type_Int;
    localSavedState.jdField_a_of_type_Boolean = this.jdField_f_of_type_Boolean;
    return localSavedState;
  }
  
  public void setBackgroundTint(@Nullable ColorStateList paramColorStateList)
  {
    DrawableCompat.setTintList(this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable, paramColorStateList);
  }
  
  public void setCradleVerticalOffset(@Dimension float paramFloat)
  {
    if (paramFloat != c())
    {
      a().c(paramFloat);
      this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable.invalidateSelf();
      d();
    }
  }
  
  public void setElevation(float paramFloat)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable.r(paramFloat);
    int j = this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable.a();
    int k = this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable.c();
    a().a(this, j - k);
  }
  
  public void setFabAlignmentMode(int paramInt)
  {
    setFabAlignmentModeAndReplaceMenu(paramInt, 0);
  }
  
  public void setFabAlignmentModeAndReplaceMenu(int paramInt1, @MenuRes int paramInt2)
  {
    this.jdField_f_of_type_Int = paramInt2;
    this.jdField_e_of_type_Boolean = true;
    a(paramInt1, this.jdField_f_of_type_Boolean);
    b(paramInt1);
    this.jdField_c_of_type_Int = paramInt1;
  }
  
  public void setFabAnimationMode(int paramInt)
  {
    this.jdField_d_of_type_Int = paramInt;
  }
  
  public void setFabCradleMargin(@Dimension float paramFloat)
  {
    if (paramFloat != a())
    {
      a().d(paramFloat);
      this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable.invalidateSelf();
    }
  }
  
  public void setFabCradleRoundedCornerRadius(@Dimension float paramFloat)
  {
    if (paramFloat != b())
    {
      a().e(paramFloat);
      this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable.invalidateSelf();
    }
  }
  
  public void setHideOnScroll(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setSubtitle(CharSequence paramCharSequence) {}
  
  public void setTitle(CharSequence paramCharSequence) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.bottomappbar.BottomAppBar
 * JD-Core Version:    0.7.0.1
 */