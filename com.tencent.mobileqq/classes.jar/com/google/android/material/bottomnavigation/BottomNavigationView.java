package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R.attr;
import com.google.android.material.R.color;
import com.google.android.material.R.dimen;
import com.google.android.material.R.style;
import com.google.android.material.R.styleable;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

public class BottomNavigationView
  extends FrameLayout
{
  private static final int jdField_a_of_type_Int = R.style.i;
  @Nullable
  private ColorStateList jdField_a_of_type_AndroidContentResColorStateList;
  private MenuInflater jdField_a_of_type_AndroidViewMenuInflater;
  @NonNull
  private final MenuBuilder jdField_a_of_type_AndroidxAppcompatViewMenuMenuBuilder;
  @NonNull
  @VisibleForTesting
  final BottomNavigationMenuView jdField_a_of_type_ComGoogleAndroidMaterialBottomnavigationBottomNavigationMenuView;
  private final BottomNavigationPresenter jdField_a_of_type_ComGoogleAndroidMaterialBottomnavigationBottomNavigationPresenter = new BottomNavigationPresenter();
  private BottomNavigationView.OnNavigationItemReselectedListener jdField_a_of_type_ComGoogleAndroidMaterialBottomnavigationBottomNavigationView$OnNavigationItemReselectedListener;
  private BottomNavigationView.OnNavigationItemSelectedListener jdField_a_of_type_ComGoogleAndroidMaterialBottomnavigationBottomNavigationView$OnNavigationItemSelectedListener;
  
  public BottomNavigationView(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public BottomNavigationView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.d);
  }
  
  public BottomNavigationView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(MaterialThemeOverlay.a(paramContext, paramAttributeSet, paramInt, jdField_a_of_type_Int), paramAttributeSet, paramInt);
    paramContext = getContext();
    this.jdField_a_of_type_AndroidxAppcompatViewMenuMenuBuilder = new BottomNavigationMenu(paramContext);
    this.jdField_a_of_type_ComGoogleAndroidMaterialBottomnavigationBottomNavigationMenuView = new BottomNavigationMenuView(paramContext);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 17;
    this.jdField_a_of_type_ComGoogleAndroidMaterialBottomnavigationBottomNavigationMenuView.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_ComGoogleAndroidMaterialBottomnavigationBottomNavigationPresenter.a(this.jdField_a_of_type_ComGoogleAndroidMaterialBottomnavigationBottomNavigationMenuView);
    this.jdField_a_of_type_ComGoogleAndroidMaterialBottomnavigationBottomNavigationPresenter.a(1);
    this.jdField_a_of_type_ComGoogleAndroidMaterialBottomnavigationBottomNavigationMenuView.setPresenter(this.jdField_a_of_type_ComGoogleAndroidMaterialBottomnavigationBottomNavigationPresenter);
    this.jdField_a_of_type_AndroidxAppcompatViewMenuMenuBuilder.addMenuPresenter(this.jdField_a_of_type_ComGoogleAndroidMaterialBottomnavigationBottomNavigationPresenter);
    this.jdField_a_of_type_ComGoogleAndroidMaterialBottomnavigationBottomNavigationPresenter.initForMenu(getContext(), this.jdField_a_of_type_AndroidxAppcompatViewMenuMenuBuilder);
    paramAttributeSet = ThemeEnforcement.a(paramContext, paramAttributeSet, R.styleable.g, paramInt, R.style.i, new int[] { R.styleable.L, R.styleable.K });
    if (paramAttributeSet.hasValue(R.styleable.I))
    {
      this.jdField_a_of_type_ComGoogleAndroidMaterialBottomnavigationBottomNavigationMenuView.setIconTintList(paramAttributeSet.getColorStateList(R.styleable.I));
    }
    else
    {
      localObject = this.jdField_a_of_type_ComGoogleAndroidMaterialBottomnavigationBottomNavigationMenuView;
      ((BottomNavigationMenuView)localObject).setIconTintList(((BottomNavigationMenuView)localObject).a(16842808));
    }
    setItemIconSize(paramAttributeSet.getDimensionPixelSize(R.styleable.H, getResources().getDimensionPixelSize(R.dimen.e)));
    if (paramAttributeSet.hasValue(R.styleable.L)) {
      setItemTextAppearanceInactive(paramAttributeSet.getResourceId(R.styleable.L, 0));
    }
    if (paramAttributeSet.hasValue(R.styleable.K)) {
      setItemTextAppearanceActive(paramAttributeSet.getResourceId(R.styleable.K, 0));
    }
    if (paramAttributeSet.hasValue(R.styleable.M)) {
      setItemTextColor(paramAttributeSet.getColorStateList(R.styleable.M));
    }
    if ((getBackground() == null) || ((getBackground() instanceof ColorDrawable))) {
      ViewCompat.setBackground(this, a(paramContext));
    }
    if (paramAttributeSet.hasValue(R.styleable.E)) {
      setElevation(paramAttributeSet.getDimensionPixelSize(R.styleable.E, 0));
    }
    Object localObject = MaterialResources.a(paramContext, paramAttributeSet, R.styleable.D);
    DrawableCompat.setTintList(getBackground().mutate(), (ColorStateList)localObject);
    setLabelVisibilityMode(paramAttributeSet.getInteger(R.styleable.N, -1));
    setItemHorizontalTranslationEnabled(paramAttributeSet.getBoolean(R.styleable.G, true));
    paramInt = paramAttributeSet.getResourceId(R.styleable.F, 0);
    if (paramInt != 0) {
      this.jdField_a_of_type_ComGoogleAndroidMaterialBottomnavigationBottomNavigationMenuView.setItemBackgroundRes(paramInt);
    } else {
      setItemRippleColor(MaterialResources.a(paramContext, paramAttributeSet, R.styleable.J));
    }
    if (paramAttributeSet.hasValue(R.styleable.O)) {
      a(paramAttributeSet.getResourceId(R.styleable.O, 0));
    }
    paramAttributeSet.recycle();
    addView(this.jdField_a_of_type_ComGoogleAndroidMaterialBottomnavigationBottomNavigationMenuView, localLayoutParams);
    if (a()) {
      a(paramContext);
    }
    this.jdField_a_of_type_AndroidxAppcompatViewMenuMenuBuilder.setCallback(new BottomNavigationView.1(this));
    a();
  }
  
  private MenuInflater a()
  {
    if (this.jdField_a_of_type_AndroidViewMenuInflater == null) {
      this.jdField_a_of_type_AndroidViewMenuInflater = new SupportMenuInflater(getContext());
    }
    return this.jdField_a_of_type_AndroidViewMenuInflater;
  }
  
  @NonNull
  private MaterialShapeDrawable a(Context paramContext)
  {
    MaterialShapeDrawable localMaterialShapeDrawable = new MaterialShapeDrawable();
    Drawable localDrawable = getBackground();
    if ((localDrawable instanceof ColorDrawable)) {
      localMaterialShapeDrawable.g(ColorStateList.valueOf(((ColorDrawable)localDrawable).getColor()));
    }
    localMaterialShapeDrawable.a(paramContext);
    return localMaterialShapeDrawable;
  }
  
  private void a()
  {
    ViewUtils.a(this, new BottomNavigationView.2(this));
  }
  
  private void a(Context paramContext)
  {
    View localView = new View(paramContext);
    localView.setBackgroundColor(ContextCompat.getColor(paramContext, R.color.jdField_a_of_type_Int));
    localView.setLayoutParams(new FrameLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.i)));
    addView(localView);
  }
  
  private boolean a()
  {
    return (Build.VERSION.SDK_INT < 21) && (!(getBackground() instanceof MaterialShapeDrawable));
  }
  
  @IdRes
  public int a()
  {
    return this.jdField_a_of_type_ComGoogleAndroidMaterialBottomnavigationBottomNavigationMenuView.b();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialBottomnavigationBottomNavigationPresenter.a(true);
    a().inflate(paramInt, this.jdField_a_of_type_AndroidxAppcompatViewMenuMenuBuilder);
    this.jdField_a_of_type_ComGoogleAndroidMaterialBottomnavigationBottomNavigationPresenter.a(false);
    this.jdField_a_of_type_ComGoogleAndroidMaterialBottomnavigationBottomNavigationPresenter.updateMenuView(true);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    MaterialShapeUtils.a(this);
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof BottomNavigationView.SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (BottomNavigationView.SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    this.jdField_a_of_type_AndroidxAppcompatViewMenuMenuBuilder.restorePresenterStates(paramParcelable.a);
  }
  
  protected Parcelable onSaveInstanceState()
  {
    BottomNavigationView.SavedState localSavedState = new BottomNavigationView.SavedState(super.onSaveInstanceState());
    localSavedState.a = new Bundle();
    this.jdField_a_of_type_AndroidxAppcompatViewMenuMenuBuilder.savePresenterStates(localSavedState.a);
    return localSavedState;
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
    this.jdField_a_of_type_ComGoogleAndroidMaterialBottomnavigationBottomNavigationMenuView.setItemBackground(paramDrawable);
    this.jdField_a_of_type_AndroidContentResColorStateList = null;
  }
  
  public void setItemBackgroundResource(@DrawableRes int paramInt)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialBottomnavigationBottomNavigationMenuView.setItemBackgroundRes(paramInt);
    this.jdField_a_of_type_AndroidContentResColorStateList = null;
  }
  
  public void setItemHorizontalTranslationEnabled(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComGoogleAndroidMaterialBottomnavigationBottomNavigationMenuView.a() != paramBoolean)
    {
      this.jdField_a_of_type_ComGoogleAndroidMaterialBottomnavigationBottomNavigationMenuView.setItemHorizontalTranslationEnabled(paramBoolean);
      this.jdField_a_of_type_ComGoogleAndroidMaterialBottomnavigationBottomNavigationPresenter.updateMenuView(false);
    }
  }
  
  public void setItemIconSize(@Dimension int paramInt)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialBottomnavigationBottomNavigationMenuView.setItemIconSize(paramInt);
  }
  
  public void setItemIconSizeRes(@DimenRes int paramInt)
  {
    setItemIconSize(getResources().getDimensionPixelSize(paramInt));
  }
  
  public void setItemIconTintList(@Nullable ColorStateList paramColorStateList)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialBottomnavigationBottomNavigationMenuView.setIconTintList(paramColorStateList);
  }
  
  public void setItemOnTouchListener(int paramInt, @Nullable View.OnTouchListener paramOnTouchListener)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialBottomnavigationBottomNavigationMenuView.setItemOnTouchListener(paramInt, paramOnTouchListener);
  }
  
  public void setItemRippleColor(@Nullable ColorStateList paramColorStateList)
  {
    if (this.jdField_a_of_type_AndroidContentResColorStateList == paramColorStateList)
    {
      if ((paramColorStateList == null) && (this.jdField_a_of_type_ComGoogleAndroidMaterialBottomnavigationBottomNavigationMenuView.a() != null)) {
        this.jdField_a_of_type_ComGoogleAndroidMaterialBottomnavigationBottomNavigationMenuView.setItemBackground(null);
      }
      return;
    }
    this.jdField_a_of_type_AndroidContentResColorStateList = paramColorStateList;
    if (paramColorStateList == null)
    {
      this.jdField_a_of_type_ComGoogleAndroidMaterialBottomnavigationBottomNavigationMenuView.setItemBackground(null);
      return;
    }
    paramColorStateList = RippleUtils.a(paramColorStateList);
    if (Build.VERSION.SDK_INT >= 21)
    {
      this.jdField_a_of_type_ComGoogleAndroidMaterialBottomnavigationBottomNavigationMenuView.setItemBackground(new RippleDrawable(paramColorStateList, null, null));
      return;
    }
    Object localObject = new GradientDrawable();
    ((GradientDrawable)localObject).setCornerRadius(1.0E-005F);
    localObject = DrawableCompat.wrap((Drawable)localObject);
    DrawableCompat.setTintList((Drawable)localObject, paramColorStateList);
    this.jdField_a_of_type_ComGoogleAndroidMaterialBottomnavigationBottomNavigationMenuView.setItemBackground((Drawable)localObject);
  }
  
  public void setItemTextAppearanceActive(@StyleRes int paramInt)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialBottomnavigationBottomNavigationMenuView.setItemTextAppearanceActive(paramInt);
  }
  
  public void setItemTextAppearanceInactive(@StyleRes int paramInt)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialBottomnavigationBottomNavigationMenuView.setItemTextAppearanceInactive(paramInt);
  }
  
  public void setItemTextColor(@Nullable ColorStateList paramColorStateList)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialBottomnavigationBottomNavigationMenuView.setItemTextColor(paramColorStateList);
  }
  
  public void setLabelVisibilityMode(int paramInt)
  {
    if (this.jdField_a_of_type_ComGoogleAndroidMaterialBottomnavigationBottomNavigationMenuView.a() != paramInt)
    {
      this.jdField_a_of_type_ComGoogleAndroidMaterialBottomnavigationBottomNavigationMenuView.setLabelVisibilityMode(paramInt);
      this.jdField_a_of_type_ComGoogleAndroidMaterialBottomnavigationBottomNavigationPresenter.updateMenuView(false);
    }
  }
  
  public void setOnNavigationItemReselectedListener(@Nullable BottomNavigationView.OnNavigationItemReselectedListener paramOnNavigationItemReselectedListener)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialBottomnavigationBottomNavigationView$OnNavigationItemReselectedListener = paramOnNavigationItemReselectedListener;
  }
  
  public void setOnNavigationItemSelectedListener(@Nullable BottomNavigationView.OnNavigationItemSelectedListener paramOnNavigationItemSelectedListener)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialBottomnavigationBottomNavigationView$OnNavigationItemSelectedListener = paramOnNavigationItemSelectedListener;
  }
  
  public void setSelectedItemId(@IdRes int paramInt)
  {
    MenuItem localMenuItem = this.jdField_a_of_type_AndroidxAppcompatViewMenuMenuBuilder.findItem(paramInt);
    if ((localMenuItem != null) && (!this.jdField_a_of_type_AndroidxAppcompatViewMenuMenuBuilder.performItemAction(localMenuItem, this.jdField_a_of_type_ComGoogleAndroidMaterialBottomnavigationBottomNavigationPresenter, 0))) {
      localMenuItem.setChecked(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.bottomnavigation.BottomNavigationView
 * JD-Core Version:    0.7.0.1
 */