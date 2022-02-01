package com.google.android.material.navigation;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.R.style;
import com.google.android.material.R.styleable;
import com.google.android.material.internal.NavigationMenu;
import com.google.android.material.internal.NavigationMenuPresenter;
import com.google.android.material.internal.ScrimInsetsFrameLayout;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.ShapeAppearanceModel.Builder;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

public class NavigationView
  extends ScrimInsetsFrameLayout
{
  private static final int[] d = { 16842912 };
  private static final int[] e = { -16842910 };
  private static final int f = R.style.o;
  NavigationView.OnNavigationItemSelectedListener c;
  @NonNull
  private final NavigationMenu g;
  private final NavigationMenuPresenter h = new NavigationMenuPresenter();
  private final int i;
  private final int[] j = new int[2];
  private MenuInflater k;
  private ViewTreeObserver.OnGlobalLayoutListener l;
  
  public NavigationView(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public NavigationView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, com.google.android.material.R.attr.M);
  }
  
  public NavigationView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(MaterialThemeOverlay.a(paramContext, paramAttributeSet, paramInt, f), paramAttributeSet, paramInt);
    Context localContext = getContext();
    this.g = new NavigationMenu(localContext);
    TintTypedArray localTintTypedArray = ThemeEnforcement.b(localContext, paramAttributeSet, R.styleable.fk, paramInt, f, new int[0]);
    if (localTintTypedArray.hasValue(R.styleable.fl)) {
      ViewCompat.setBackground(this, localTintTypedArray.getDrawable(R.styleable.fl));
    }
    if ((getBackground() == null) || ((getBackground() instanceof ColorDrawable)))
    {
      paramAttributeSet = ShapeAppearanceModel.a(localContext, paramAttributeSet, paramInt, f).a();
      paramContext = getBackground();
      paramAttributeSet = new MaterialShapeDrawable(paramAttributeSet);
      if ((paramContext instanceof ColorDrawable)) {
        paramAttributeSet.g(ColorStateList.valueOf(((ColorDrawable)paramContext).getColor()));
      }
      paramAttributeSet.a(localContext);
      ViewCompat.setBackground(this, paramAttributeSet);
    }
    if (localTintTypedArray.hasValue(R.styleable.fo)) {
      setElevation(localTintTypedArray.getDimensionPixelSize(R.styleable.fo, 0));
    }
    setFitsSystemWindows(localTintTypedArray.getBoolean(R.styleable.fm, false));
    this.i = localTintTypedArray.getDimensionPixelSize(R.styleable.fn, 0);
    if (localTintTypedArray.hasValue(R.styleable.fu)) {
      paramAttributeSet = localTintTypedArray.getColorStateList(R.styleable.fu);
    } else {
      paramAttributeSet = c(16842808);
    }
    int m;
    if (localTintTypedArray.hasValue(R.styleable.fD))
    {
      paramInt = localTintTypedArray.getResourceId(R.styleable.fD, 0);
      m = 1;
    }
    else
    {
      m = 0;
      paramInt = 0;
    }
    if (localTintTypedArray.hasValue(R.styleable.ft)) {
      setItemIconSize(localTintTypedArray.getDimensionPixelSize(R.styleable.ft, 0));
    }
    paramContext = null;
    if (localTintTypedArray.hasValue(R.styleable.fE)) {
      paramContext = localTintTypedArray.getColorStateList(R.styleable.fE);
    }
    Object localObject = paramContext;
    if (m == 0)
    {
      localObject = paramContext;
      if (paramContext == null) {
        localObject = c(16842806);
      }
    }
    Drawable localDrawable = localTintTypedArray.getDrawable(R.styleable.fq);
    paramContext = localDrawable;
    if (localDrawable == null)
    {
      paramContext = localDrawable;
      if (a(localTintTypedArray)) {
        paramContext = b(localTintTypedArray);
      }
    }
    if (localTintTypedArray.hasValue(R.styleable.fr))
    {
      n = localTintTypedArray.getDimensionPixelSize(R.styleable.fr, 0);
      this.h.d(n);
    }
    int n = localTintTypedArray.getDimensionPixelSize(R.styleable.fs, 0);
    setItemMaxLines(localTintTypedArray.getInt(R.styleable.fv, 1));
    this.g.setCallback(new NavigationView.1(this));
    this.h.a(1);
    this.h.initForMenu(localContext, this.g);
    this.h.a(paramAttributeSet);
    this.h.h(getOverScrollMode());
    if (m != 0) {
      this.h.c(paramInt);
    }
    this.h.b((ColorStateList)localObject);
    this.h.a(paramContext);
    this.h.e(n);
    this.g.addMenuPresenter(this.h);
    addView((View)this.h.getMenuView(this));
    if (localTintTypedArray.hasValue(R.styleable.fF)) {
      a(localTintTypedArray.getResourceId(R.styleable.fF, 0));
    }
    if (localTintTypedArray.hasValue(R.styleable.fp)) {
      b(localTintTypedArray.getResourceId(R.styleable.fp, 0));
    }
    localTintTypedArray.recycle();
    a();
  }
  
  private void a()
  {
    this.l = new NavigationView.2(this);
    getViewTreeObserver().addOnGlobalLayoutListener(this.l);
  }
  
  private boolean a(@NonNull TintTypedArray paramTintTypedArray)
  {
    return (paramTintTypedArray.hasValue(R.styleable.fw)) || (paramTintTypedArray.hasValue(R.styleable.fx));
  }
  
  @NonNull
  private final Drawable b(@NonNull TintTypedArray paramTintTypedArray)
  {
    int m = paramTintTypedArray.getResourceId(R.styleable.fw, 0);
    int n = paramTintTypedArray.getResourceId(R.styleable.fx, 0);
    MaterialShapeDrawable localMaterialShapeDrawable = new MaterialShapeDrawable(ShapeAppearanceModel.a(getContext(), m, n).a());
    localMaterialShapeDrawable.g(MaterialResources.a(getContext(), paramTintTypedArray, R.styleable.fy));
    return new InsetDrawable(localMaterialShapeDrawable, paramTintTypedArray.getDimensionPixelSize(R.styleable.fB, 0), paramTintTypedArray.getDimensionPixelSize(R.styleable.fC, 0), paramTintTypedArray.getDimensionPixelSize(R.styleable.fA, 0), paramTintTypedArray.getDimensionPixelSize(R.styleable.fz, 0));
  }
  
  @Nullable
  private ColorStateList c(int paramInt)
  {
    Object localObject = new TypedValue();
    if (!getContext().getTheme().resolveAttribute(paramInt, (TypedValue)localObject, true)) {
      return null;
    }
    ColorStateList localColorStateList = AppCompatResources.getColorStateList(getContext(), ((TypedValue)localObject).resourceId);
    if (!getContext().getTheme().resolveAttribute(androidx.appcompat.R.attr.colorPrimary, (TypedValue)localObject, true)) {
      return null;
    }
    paramInt = ((TypedValue)localObject).data;
    int m = localColorStateList.getDefaultColor();
    localObject = e;
    int[] arrayOfInt1 = d;
    int[] arrayOfInt2 = EMPTY_STATE_SET;
    int n = localColorStateList.getColorForState(e, m);
    return new ColorStateList(new int[][] { localObject, arrayOfInt1, arrayOfInt2 }, new int[] { n, paramInt, m });
  }
  
  private MenuInflater getMenuInflater()
  {
    if (this.k == null) {
      this.k = new SupportMenuInflater(getContext());
    }
    return this.k;
  }
  
  public void a(int paramInt)
  {
    this.h.a(true);
    getMenuInflater().inflate(paramInt, this.g);
    this.h.a(false);
    this.h.updateMenuView(false);
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  protected void a(@NonNull WindowInsetsCompat paramWindowInsetsCompat)
  {
    this.h.a(paramWindowInsetsCompat);
  }
  
  public View b(@LayoutRes int paramInt)
  {
    return this.h.b(paramInt);
  }
  
  @Nullable
  public MenuItem getCheckedItem()
  {
    return this.h.a();
  }
  
  public int getHeaderCount()
  {
    return this.h.b();
  }
  
  @Nullable
  public Drawable getItemBackground()
  {
    return this.h.e();
  }
  
  @Dimension
  public int getItemHorizontalPadding()
  {
    return this.h.f();
  }
  
  @Dimension
  public int getItemIconPadding()
  {
    return this.h.g();
  }
  
  @Nullable
  public ColorStateList getItemIconTintList()
  {
    return this.h.c();
  }
  
  public int getItemMaxLines()
  {
    return this.h.h();
  }
  
  @Nullable
  public ColorStateList getItemTextColor()
  {
    return this.h.d();
  }
  
  @NonNull
  public Menu getMenu()
  {
    return this.g;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    MaterialShapeUtils.a(this);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (Build.VERSION.SDK_INT < 16)
    {
      getViewTreeObserver().removeGlobalOnLayoutListener(this.l);
      return;
    }
    getViewTreeObserver().removeOnGlobalLayoutListener(this.l);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int m = View.MeasureSpec.getMode(paramInt1);
    if (m != -2147483648)
    {
      if (m == 0) {
        paramInt1 = View.MeasureSpec.makeMeasureSpec(this.i, 1073741824);
      }
    }
    else {
      paramInt1 = View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(paramInt1), this.i), 1073741824);
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof NavigationView.SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (NavigationView.SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    this.g.restorePresenterStates(paramParcelable.a);
  }
  
  protected Parcelable onSaveInstanceState()
  {
    NavigationView.SavedState localSavedState = new NavigationView.SavedState(super.onSaveInstanceState());
    localSavedState.a = new Bundle();
    this.g.savePresenterStates(localSavedState.a);
    return localSavedState;
  }
  
  public void setCheckedItem(@IdRes int paramInt)
  {
    MenuItem localMenuItem = this.g.findItem(paramInt);
    if (localMenuItem != null) {
      this.h.a((MenuItemImpl)localMenuItem);
    }
  }
  
  public void setCheckedItem(@NonNull MenuItem paramMenuItem)
  {
    paramMenuItem = this.g.findItem(paramMenuItem.getItemId());
    if (paramMenuItem != null)
    {
      this.h.a((MenuItemImpl)paramMenuItem);
      return;
    }
    throw new IllegalArgumentException("Called setCheckedItem(MenuItem) with an item that is not in the current menu.");
  }
  
  public void setElevation(float paramFloat)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      super.setElevation(paramFloat);
    }
    MaterialShapeUtils.a(this, paramFloat);
  }
  
  public void setItemBackground(@Nullable Drawable paramDrawable)
  {
    this.h.a(paramDrawable);
  }
  
  public void setItemBackgroundResource(@DrawableRes int paramInt)
  {
    setItemBackground(ContextCompat.getDrawable(getContext(), paramInt));
  }
  
  public void setItemHorizontalPadding(@Dimension int paramInt)
  {
    this.h.d(paramInt);
  }
  
  public void setItemHorizontalPaddingResource(@DimenRes int paramInt)
  {
    this.h.d(getResources().getDimensionPixelSize(paramInt));
  }
  
  public void setItemIconPadding(@Dimension int paramInt)
  {
    this.h.e(paramInt);
  }
  
  public void setItemIconPaddingResource(int paramInt)
  {
    this.h.e(getResources().getDimensionPixelSize(paramInt));
  }
  
  public void setItemIconSize(@Dimension int paramInt)
  {
    this.h.g(paramInt);
  }
  
  public void setItemIconTintList(@Nullable ColorStateList paramColorStateList)
  {
    this.h.a(paramColorStateList);
  }
  
  public void setItemMaxLines(int paramInt)
  {
    this.h.f(paramInt);
  }
  
  public void setItemTextAppearance(@StyleRes int paramInt)
  {
    this.h.c(paramInt);
  }
  
  public void setItemTextColor(@Nullable ColorStateList paramColorStateList)
  {
    this.h.b(paramColorStateList);
  }
  
  public void setNavigationItemSelectedListener(@Nullable NavigationView.OnNavigationItemSelectedListener paramOnNavigationItemSelectedListener)
  {
    this.c = paramOnNavigationItemSelectedListener;
  }
  
  public void setOverScrollMode(int paramInt)
  {
    super.setOverScrollMode(paramInt);
    NavigationMenuPresenter localNavigationMenuPresenter = this.h;
    if (localNavigationMenuPresenter != null) {
      localNavigationMenuPresenter.h(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.navigation.NavigationView
 * JD-Core Version:    0.7.0.1
 */