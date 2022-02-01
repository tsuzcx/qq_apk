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
  private static final int jdField_a_of_type_Int = R.style.m;
  private static final int[] jdField_a_of_type_ArrayOfInt = { 16842912 };
  private static final int[] jdField_b_of_type_ArrayOfInt = { -16842910 };
  private MenuInflater jdField_a_of_type_AndroidViewMenuInflater;
  private ViewTreeObserver.OnGlobalLayoutListener jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener;
  @NonNull
  private final NavigationMenu jdField_a_of_type_ComGoogleAndroidMaterialInternalNavigationMenu;
  private final NavigationMenuPresenter jdField_a_of_type_ComGoogleAndroidMaterialInternalNavigationMenuPresenter = new NavigationMenuPresenter();
  NavigationView.OnNavigationItemSelectedListener jdField_a_of_type_ComGoogleAndroidMaterialNavigationNavigationView$OnNavigationItemSelectedListener;
  private final int jdField_b_of_type_Int;
  private final int[] c = new int[2];
  
  public NavigationView(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public NavigationView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, com.google.android.material.R.attr.F);
  }
  
  public NavigationView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(MaterialThemeOverlay.a(paramContext, paramAttributeSet, paramInt, jdField_a_of_type_Int), paramAttributeSet, paramInt);
    Context localContext = getContext();
    this.jdField_a_of_type_ComGoogleAndroidMaterialInternalNavigationMenu = new NavigationMenu(localContext);
    TintTypedArray localTintTypedArray = ThemeEnforcement.a(localContext, paramAttributeSet, R.styleable.ah, paramInt, jdField_a_of_type_Int, new int[0]);
    if (localTintTypedArray.hasValue(R.styleable.dt)) {
      ViewCompat.setBackground(this, localTintTypedArray.getDrawable(R.styleable.dt));
    }
    if ((getBackground() == null) || ((getBackground() instanceof ColorDrawable)))
    {
      paramAttributeSet = ShapeAppearanceModel.a(localContext, paramAttributeSet, paramInt, jdField_a_of_type_Int).a();
      paramContext = getBackground();
      paramAttributeSet = new MaterialShapeDrawable(paramAttributeSet);
      if ((paramContext instanceof ColorDrawable)) {
        paramAttributeSet.g(ColorStateList.valueOf(((ColorDrawable)paramContext).getColor()));
      }
      paramAttributeSet.a(localContext);
      ViewCompat.setBackground(this, paramAttributeSet);
    }
    if (localTintTypedArray.hasValue(R.styleable.dw)) {
      setElevation(localTintTypedArray.getDimensionPixelSize(R.styleable.dw, 0));
    }
    setFitsSystemWindows(localTintTypedArray.getBoolean(R.styleable.du, false));
    this.jdField_b_of_type_Int = localTintTypedArray.getDimensionPixelSize(R.styleable.dv, 0);
    if (localTintTypedArray.hasValue(R.styleable.dC)) {
      paramAttributeSet = localTintTypedArray.getColorStateList(R.styleable.dC);
    } else {
      paramAttributeSet = a(16842808);
    }
    int i;
    if (localTintTypedArray.hasValue(R.styleable.dL))
    {
      paramInt = localTintTypedArray.getResourceId(R.styleable.dL, 0);
      i = 1;
    }
    else
    {
      i = 0;
      paramInt = 0;
    }
    if (localTintTypedArray.hasValue(R.styleable.dB)) {
      setItemIconSize(localTintTypedArray.getDimensionPixelSize(R.styleable.dB, 0));
    }
    paramContext = null;
    if (localTintTypedArray.hasValue(R.styleable.dM)) {
      paramContext = localTintTypedArray.getColorStateList(R.styleable.dM);
    }
    Object localObject = paramContext;
    if (i == 0)
    {
      localObject = paramContext;
      if (paramContext == null) {
        localObject = a(16842806);
      }
    }
    Drawable localDrawable = localTintTypedArray.getDrawable(R.styleable.dy);
    paramContext = localDrawable;
    if (localDrawable == null)
    {
      paramContext = localDrawable;
      if (a(localTintTypedArray)) {
        paramContext = a(localTintTypedArray);
      }
    }
    if (localTintTypedArray.hasValue(R.styleable.dz))
    {
      j = localTintTypedArray.getDimensionPixelSize(R.styleable.dz, 0);
      this.jdField_a_of_type_ComGoogleAndroidMaterialInternalNavigationMenuPresenter.c(j);
    }
    int j = localTintTypedArray.getDimensionPixelSize(R.styleable.dA, 0);
    setItemMaxLines(localTintTypedArray.getInt(R.styleable.dD, 1));
    this.jdField_a_of_type_ComGoogleAndroidMaterialInternalNavigationMenu.setCallback(new NavigationView.1(this));
    this.jdField_a_of_type_ComGoogleAndroidMaterialInternalNavigationMenuPresenter.a(1);
    this.jdField_a_of_type_ComGoogleAndroidMaterialInternalNavigationMenuPresenter.initForMenu(localContext, this.jdField_a_of_type_ComGoogleAndroidMaterialInternalNavigationMenu);
    this.jdField_a_of_type_ComGoogleAndroidMaterialInternalNavigationMenuPresenter.a(paramAttributeSet);
    this.jdField_a_of_type_ComGoogleAndroidMaterialInternalNavigationMenuPresenter.g(getOverScrollMode());
    if (i != 0) {
      this.jdField_a_of_type_ComGoogleAndroidMaterialInternalNavigationMenuPresenter.b(paramInt);
    }
    this.jdField_a_of_type_ComGoogleAndroidMaterialInternalNavigationMenuPresenter.b((ColorStateList)localObject);
    this.jdField_a_of_type_ComGoogleAndroidMaterialInternalNavigationMenuPresenter.a(paramContext);
    this.jdField_a_of_type_ComGoogleAndroidMaterialInternalNavigationMenuPresenter.d(j);
    this.jdField_a_of_type_ComGoogleAndroidMaterialInternalNavigationMenu.addMenuPresenter(this.jdField_a_of_type_ComGoogleAndroidMaterialInternalNavigationMenuPresenter);
    addView((View)this.jdField_a_of_type_ComGoogleAndroidMaterialInternalNavigationMenuPresenter.getMenuView(this));
    if (localTintTypedArray.hasValue(R.styleable.dN)) {
      a(localTintTypedArray.getResourceId(R.styleable.dN, 0));
    }
    if (localTintTypedArray.hasValue(R.styleable.dx)) {
      a(localTintTypedArray.getResourceId(R.styleable.dx, 0));
    }
    localTintTypedArray.recycle();
    a();
  }
  
  @Nullable
  private ColorStateList a(int paramInt)
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
    int i = localColorStateList.getDefaultColor();
    localObject = jdField_b_of_type_ArrayOfInt;
    int[] arrayOfInt1 = jdField_a_of_type_ArrayOfInt;
    int[] arrayOfInt2 = EMPTY_STATE_SET;
    int j = localColorStateList.getColorForState(jdField_b_of_type_ArrayOfInt, i);
    return new ColorStateList(new int[][] { localObject, arrayOfInt1, arrayOfInt2 }, new int[] { j, paramInt, i });
  }
  
  @NonNull
  private final Drawable a(@NonNull TintTypedArray paramTintTypedArray)
  {
    int i = paramTintTypedArray.getResourceId(R.styleable.dE, 0);
    int j = paramTintTypedArray.getResourceId(R.styleable.dF, 0);
    MaterialShapeDrawable localMaterialShapeDrawable = new MaterialShapeDrawable(ShapeAppearanceModel.a(getContext(), i, j).a());
    localMaterialShapeDrawable.g(MaterialResources.a(getContext(), paramTintTypedArray, R.styleable.dG));
    return new InsetDrawable(localMaterialShapeDrawable, paramTintTypedArray.getDimensionPixelSize(R.styleable.dJ, 0), paramTintTypedArray.getDimensionPixelSize(R.styleable.dK, 0), paramTintTypedArray.getDimensionPixelSize(R.styleable.dI, 0), paramTintTypedArray.getDimensionPixelSize(R.styleable.dH, 0));
  }
  
  private MenuInflater a()
  {
    if (this.jdField_a_of_type_AndroidViewMenuInflater == null) {
      this.jdField_a_of_type_AndroidViewMenuInflater = new SupportMenuInflater(getContext());
    }
    return this.jdField_a_of_type_AndroidViewMenuInflater;
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = new NavigationView.2(this);
    getViewTreeObserver().addOnGlobalLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
  }
  
  private boolean a(@NonNull TintTypedArray paramTintTypedArray)
  {
    return (paramTintTypedArray.hasValue(R.styleable.dE)) || (paramTintTypedArray.hasValue(R.styleable.dF));
  }
  
  public View a(@LayoutRes int paramInt)
  {
    return this.jdField_a_of_type_ComGoogleAndroidMaterialInternalNavigationMenuPresenter.a(paramInt);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialInternalNavigationMenuPresenter.a(true);
    a().inflate(paramInt, this.jdField_a_of_type_ComGoogleAndroidMaterialInternalNavigationMenu);
    this.jdField_a_of_type_ComGoogleAndroidMaterialInternalNavigationMenuPresenter.a(false);
    this.jdField_a_of_type_ComGoogleAndroidMaterialInternalNavigationMenuPresenter.updateMenuView(false);
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  protected void a(@NonNull WindowInsetsCompat paramWindowInsetsCompat)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialInternalNavigationMenuPresenter.a(paramWindowInsetsCompat);
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
      getViewTreeObserver().removeGlobalOnLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
      return;
    }
    getViewTreeObserver().removeOnGlobalLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getMode(paramInt1);
    if (i != -2147483648)
    {
      if (i == 0) {
        paramInt1 = View.MeasureSpec.makeMeasureSpec(this.jdField_b_of_type_Int, 1073741824);
      }
    }
    else {
      paramInt1 = View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(paramInt1), this.jdField_b_of_type_Int), 1073741824);
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
    this.jdField_a_of_type_ComGoogleAndroidMaterialInternalNavigationMenu.restorePresenterStates(paramParcelable.a);
  }
  
  protected Parcelable onSaveInstanceState()
  {
    NavigationView.SavedState localSavedState = new NavigationView.SavedState(super.onSaveInstanceState());
    localSavedState.a = new Bundle();
    this.jdField_a_of_type_ComGoogleAndroidMaterialInternalNavigationMenu.savePresenterStates(localSavedState.a);
    return localSavedState;
  }
  
  public void setCheckedItem(@IdRes int paramInt)
  {
    MenuItem localMenuItem = this.jdField_a_of_type_ComGoogleAndroidMaterialInternalNavigationMenu.findItem(paramInt);
    if (localMenuItem != null) {
      this.jdField_a_of_type_ComGoogleAndroidMaterialInternalNavigationMenuPresenter.a((MenuItemImpl)localMenuItem);
    }
  }
  
  public void setCheckedItem(@NonNull MenuItem paramMenuItem)
  {
    paramMenuItem = this.jdField_a_of_type_ComGoogleAndroidMaterialInternalNavigationMenu.findItem(paramMenuItem.getItemId());
    if (paramMenuItem != null)
    {
      this.jdField_a_of_type_ComGoogleAndroidMaterialInternalNavigationMenuPresenter.a((MenuItemImpl)paramMenuItem);
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
    this.jdField_a_of_type_ComGoogleAndroidMaterialInternalNavigationMenuPresenter.a(paramDrawable);
  }
  
  public void setItemBackgroundResource(@DrawableRes int paramInt)
  {
    setItemBackground(ContextCompat.getDrawable(getContext(), paramInt));
  }
  
  public void setItemHorizontalPadding(@Dimension int paramInt)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialInternalNavigationMenuPresenter.c(paramInt);
  }
  
  public void setItemHorizontalPaddingResource(@DimenRes int paramInt)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialInternalNavigationMenuPresenter.c(getResources().getDimensionPixelSize(paramInt));
  }
  
  public void setItemIconPadding(@Dimension int paramInt)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialInternalNavigationMenuPresenter.d(paramInt);
  }
  
  public void setItemIconPaddingResource(int paramInt)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialInternalNavigationMenuPresenter.d(getResources().getDimensionPixelSize(paramInt));
  }
  
  public void setItemIconSize(@Dimension int paramInt)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialInternalNavigationMenuPresenter.f(paramInt);
  }
  
  public void setItemIconTintList(@Nullable ColorStateList paramColorStateList)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialInternalNavigationMenuPresenter.a(paramColorStateList);
  }
  
  public void setItemMaxLines(int paramInt)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialInternalNavigationMenuPresenter.e(paramInt);
  }
  
  public void setItemTextAppearance(@StyleRes int paramInt)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialInternalNavigationMenuPresenter.b(paramInt);
  }
  
  public void setItemTextColor(@Nullable ColorStateList paramColorStateList)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialInternalNavigationMenuPresenter.b(paramColorStateList);
  }
  
  public void setNavigationItemSelectedListener(@Nullable NavigationView.OnNavigationItemSelectedListener paramOnNavigationItemSelectedListener)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialNavigationNavigationView$OnNavigationItemSelectedListener = paramOnNavigationItemSelectedListener;
  }
  
  public void setOverScrollMode(int paramInt)
  {
    super.setOverScrollMode(paramInt);
    NavigationMenuPresenter localNavigationMenuPresenter = this.jdField_a_of_type_ComGoogleAndroidMaterialInternalNavigationMenuPresenter;
    if (localNavigationMenuPresenter != null) {
      localNavigationMenuPresenter.g(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.navigation.NavigationView
 * JD-Core Version:    0.7.0.1
 */