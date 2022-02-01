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
  private static final int c = R.style.u;
  @NonNull
  AnimatorListenerAdapter a = new BottomAppBar.1(this);
  @NonNull
  TransformationCallback<FloatingActionButton> b = new BottomAppBar.2(this);
  private final int d;
  private final MaterialShapeDrawable e = new MaterialShapeDrawable();
  @Nullable
  private Animator f;
  @Nullable
  private Animator g;
  private int h;
  private int i;
  private boolean j;
  private final boolean k;
  private final boolean l;
  private final boolean m;
  private int n = 0;
  private ArrayList<BottomAppBar.AnimationListener> o;
  @MenuRes
  private int p = 0;
  private boolean q = false;
  private boolean r = true;
  private BottomAppBar.Behavior s;
  private int t;
  private int u;
  private int v;
  
  public BottomAppBar(@NonNull Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public BottomAppBar(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.e);
  }
  
  public BottomAppBar(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(MaterialThemeOverlay.a(paramContext, paramAttributeSet, paramInt, c), paramAttributeSet, paramInt);
    paramContext = getContext();
    Object localObject = ThemeEnforcement.a(paramContext, paramAttributeSet, R.styleable.T, paramInt, c, new int[0]);
    ColorStateList localColorStateList = MaterialResources.a(paramContext, (TypedArray)localObject, R.styleable.U);
    int i1 = ((TypedArray)localObject).getDimensionPixelSize(R.styleable.V, 0);
    float f1 = ((TypedArray)localObject).getDimensionPixelOffset(R.styleable.Y, 0);
    float f2 = ((TypedArray)localObject).getDimensionPixelOffset(R.styleable.Z, 0);
    float f3 = ((TypedArray)localObject).getDimensionPixelOffset(R.styleable.aa, 0);
    this.h = ((TypedArray)localObject).getInt(R.styleable.W, 0);
    this.i = ((TypedArray)localObject).getInt(R.styleable.X, 0);
    this.j = ((TypedArray)localObject).getBoolean(R.styleable.ab, false);
    this.k = ((TypedArray)localObject).getBoolean(R.styleable.ac, false);
    this.l = ((TypedArray)localObject).getBoolean(R.styleable.ad, false);
    this.m = ((TypedArray)localObject).getBoolean(R.styleable.ae, false);
    ((TypedArray)localObject).recycle();
    this.d = getResources().getDimensionPixelOffset(R.dimen.N);
    localObject = new BottomAppBarTopEdgeTreatment(f1, f2, f3);
    localObject = ShapeAppearanceModel.a().a((EdgeTreatment)localObject).a();
    this.e.setShapeAppearanceModel((ShapeAppearanceModel)localObject);
    this.e.D(2);
    this.e.a(Paint.Style.FILL);
    this.e.a(paramContext);
    setElevation(i1);
    DrawableCompat.setTintList(this.e, localColorStateList);
    ViewCompat.setBackground(this, this.e);
    ViewUtils.a(this, paramAttributeSet, paramInt, c, new BottomAppBar.3(this));
  }
  
  private void a()
  {
    int i1 = this.n;
    this.n = (i1 + 1);
    if (i1 == 0)
    {
      Object localObject = this.o;
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
      this.q = false;
      a(this.p);
      return;
    }
    Object localObject = this.g;
    if (localObject != null) {
      ((Animator)localObject).cancel();
    }
    localObject = new ArrayList();
    if (!e())
    {
      paramInt = 0;
      paramBoolean = false;
    }
    a(paramInt, paramBoolean, (List)localObject);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.playTogether((Collection)localObject);
    this.g = localAnimatorSet;
    this.g.addListener(new BottomAppBar.6(this));
    this.g.start();
  }
  
  private void a(int paramInt, boolean paramBoolean, @NonNull List<Animator> paramList)
  {
    Object localObject = getActionMenuView();
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
    paramFloatingActionButton.b(this.a);
    paramFloatingActionButton.a(new BottomAppBar.9(this));
    paramFloatingActionButton.a(this.b);
  }
  
  private void b()
  {
    int i1 = this.n - 1;
    this.n = i1;
    if (i1 == 0)
    {
      Object localObject = this.o;
      if (localObject != null)
      {
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((BottomAppBar.AnimationListener)((Iterator)localObject).next()).b(this);
        }
      }
    }
  }
  
  private void b(int paramInt, @NonNull List<Animator> paramList)
  {
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(c(), "translationX", new float[] { d(paramInt) });
    localObjectAnimator.setDuration(300L);
    paramList.add(localObjectAnimator);
  }
  
  private void b(@NonNull ActionMenuView paramActionMenuView, int paramInt, boolean paramBoolean)
  {
    a(paramActionMenuView, paramInt, paramBoolean, false);
  }
  
  @Nullable
  private FloatingActionButton c()
  {
    View localView = d();
    if ((localView instanceof FloatingActionButton)) {
      return (FloatingActionButton)localView;
    }
    return null;
  }
  
  private void c(int paramInt)
  {
    if (this.h != paramInt)
    {
      if (!ViewCompat.isLaidOut(this)) {
        return;
      }
      Object localObject = this.f;
      if (localObject != null) {
        ((Animator)localObject).cancel();
      }
      localObject = new ArrayList();
      if (this.i == 1) {
        b(paramInt, (List)localObject);
      } else {
        a(paramInt, (List)localObject);
      }
      AnimatorSet localAnimatorSet = new AnimatorSet();
      localAnimatorSet.playTogether((Collection)localObject);
      this.f = localAnimatorSet;
      this.f.addListener(new BottomAppBar.4(this));
      this.f.start();
    }
  }
  
  private float d(int paramInt)
  {
    boolean bool = ViewUtils.a(this);
    int i1 = 1;
    if (paramInt == 1)
    {
      if (bool) {
        paramInt = this.v;
      } else {
        paramInt = this.u;
      }
      int i2 = this.d;
      int i3 = getMeasuredWidth() / 2;
      if (bool) {
        i1 = -1;
      }
      return (i3 - (i2 + paramInt)) * i1;
    }
    return 0.0F;
  }
  
  @Nullable
  private View d()
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
  
  private boolean e()
  {
    FloatingActionButton localFloatingActionButton = c();
    return (localFloatingActionButton != null) && (localFloatingActionButton.c());
  }
  
  private void f()
  {
    Animator localAnimator = this.g;
    if (localAnimator != null) {
      localAnimator.cancel();
    }
    localAnimator = this.f;
    if (localAnimator != null) {
      localAnimator.cancel();
    }
  }
  
  private void g()
  {
    getTopEdgeTreatment().b(getFabTranslationX());
    View localView = d();
    MaterialShapeDrawable localMaterialShapeDrawable = this.e;
    float f1;
    if ((this.r) && (e())) {
      f1 = 1.0F;
    } else {
      f1 = 0.0F;
    }
    localMaterialShapeDrawable.p(f1);
    if (localView != null)
    {
      localView.setTranslationY(getFabTranslationY());
      localView.setTranslationX(getFabTranslationX());
    }
  }
  
  @Nullable
  private ActionMenuView getActionMenuView()
  {
    int i1 = 0;
    while (i1 < getChildCount())
    {
      View localView = getChildAt(i1);
      if ((localView instanceof ActionMenuView)) {
        return (ActionMenuView)localView;
      }
      i1 += 1;
    }
    return null;
  }
  
  private int getBottomInset()
  {
    return this.t;
  }
  
  private float getFabTranslationX()
  {
    return d(this.h);
  }
  
  private float getFabTranslationY()
  {
    return -getTopEdgeTreatment().c();
  }
  
  private int getLeftInset()
  {
    return this.v;
  }
  
  private int getRightInset()
  {
    return this.u;
  }
  
  @NonNull
  private BottomAppBarTopEdgeTreatment getTopEdgeTreatment()
  {
    return (BottomAppBarTopEdgeTreatment)this.e.getShapeAppearanceModel().k();
  }
  
  private void h()
  {
    ActionMenuView localActionMenuView = getActionMenuView();
    if ((localActionMenuView != null) && (this.g == null))
    {
      localActionMenuView.setAlpha(1.0F);
      if (!e())
      {
        b(localActionMenuView, 0, false);
        return;
      }
      b(localActionMenuView, this.h, this.r);
    }
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
      int i2 = 0;
      for (int i1 = paramInt; i2 < getChildCount(); i1 = paramInt)
      {
        View localView = getChildAt(i2);
        int i3;
        if (((localView.getLayoutParams() instanceof Toolbar.LayoutParams)) && ((((Toolbar.LayoutParams)localView.getLayoutParams()).gravity & 0x800007) == 8388611)) {
          i3 = 1;
        } else {
          i3 = 0;
        }
        paramInt = i1;
        if (i3 != 0) {
          if (paramBoolean) {
            paramInt = Math.min(i1, localView.getLeft());
          } else {
            paramInt = Math.max(i1, localView.getRight());
          }
        }
        i2 += 1;
      }
      if (paramBoolean) {
        paramInt = paramActionMenuView.getRight();
      } else {
        paramInt = paramActionMenuView.getLeft();
      }
      if (paramBoolean) {
        i2 = this.u;
      } else {
        i2 = -this.v;
      }
      return i1 - (paramInt + i2);
    }
    return 0;
  }
  
  public void a(@MenuRes int paramInt)
  {
    if (paramInt != 0)
    {
      this.p = 0;
      getMenu().clear();
      inflateMenu(paramInt);
    }
  }
  
  protected void a(int paramInt, List<Animator> paramList)
  {
    paramList = c();
    if (paramList != null)
    {
      if (paramList.b()) {
        return;
      }
      a();
      paramList.b(new BottomAppBar.5(this, paramInt));
    }
  }
  
  boolean b(@Px int paramInt)
  {
    float f1 = paramInt;
    if (f1 != getTopEdgeTreatment().a())
    {
      getTopEdgeTreatment().a(f1);
      this.e.invalidateSelf();
      return true;
    }
    return false;
  }
  
  @Nullable
  public ColorStateList getBackgroundTint()
  {
    return this.e.O();
  }
  
  @NonNull
  public BottomAppBar.Behavior getBehavior()
  {
    if (this.s == null) {
      this.s = new BottomAppBar.Behavior();
    }
    return this.s;
  }
  
  @Dimension
  public float getCradleVerticalOffset()
  {
    return getTopEdgeTreatment().c();
  }
  
  public int getFabAlignmentMode()
  {
    return this.h;
  }
  
  public int getFabAnimationMode()
  {
    return this.i;
  }
  
  public float getFabCradleMargin()
  {
    return getTopEdgeTreatment().d();
  }
  
  @Dimension
  public float getFabCradleRoundedCornerRadius()
  {
    return getTopEdgeTreatment().e();
  }
  
  public boolean getHideOnScroll()
  {
    return this.j;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    MaterialShapeUtils.a(this, this.e);
    if ((getParent() instanceof ViewGroup)) {
      ((ViewGroup)getParent()).setClipChildren(false);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramBoolean)
    {
      f();
      g();
    }
    h();
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
    this.h = paramParcelable.a;
    this.r = paramParcelable.b;
  }
  
  @NonNull
  protected Parcelable onSaveInstanceState()
  {
    BottomAppBar.SavedState localSavedState = new BottomAppBar.SavedState(super.onSaveInstanceState());
    localSavedState.a = this.h;
    localSavedState.b = this.r;
    return localSavedState;
  }
  
  public void setBackgroundTint(@Nullable ColorStateList paramColorStateList)
  {
    DrawableCompat.setTintList(this.e, paramColorStateList);
  }
  
  public void setCradleVerticalOffset(@Dimension float paramFloat)
  {
    if (paramFloat != getCradleVerticalOffset())
    {
      getTopEdgeTreatment().c(paramFloat);
      this.e.invalidateSelf();
      g();
    }
  }
  
  public void setElevation(float paramFloat)
  {
    this.e.r(paramFloat);
    int i1 = this.e.X();
    int i2 = this.e.aa();
    getBehavior().a(this, i1 - i2);
  }
  
  public void setFabAlignmentMode(int paramInt)
  {
    setFabAlignmentModeAndReplaceMenu(paramInt, 0);
  }
  
  public void setFabAlignmentModeAndReplaceMenu(int paramInt1, @MenuRes int paramInt2)
  {
    this.p = paramInt2;
    this.q = true;
    a(paramInt1, this.r);
    c(paramInt1);
    this.h = paramInt1;
  }
  
  public void setFabAnimationMode(int paramInt)
  {
    this.i = paramInt;
  }
  
  public void setFabCradleMargin(@Dimension float paramFloat)
  {
    if (paramFloat != getFabCradleMargin())
    {
      getTopEdgeTreatment().d(paramFloat);
      this.e.invalidateSelf();
    }
  }
  
  public void setFabCradleRoundedCornerRadius(@Dimension float paramFloat)
  {
    if (paramFloat != getFabCradleRoundedCornerRadius())
    {
      getTopEdgeTreatment().e(paramFloat);
      this.e.invalidateSelf();
    }
  }
  
  public void setHideOnScroll(boolean paramBoolean)
  {
    this.j = paramBoolean;
  }
  
  public void setSubtitle(CharSequence paramCharSequence) {}
  
  public void setTitle(CharSequence paramCharSequence) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.bottomappbar.BottomAppBar
 * JD-Core Version:    0.7.0.1
 */