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
import android.view.Menu;
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
  private static final int b = R.style.k;
  @NonNull
  @VisibleForTesting
  final BottomNavigationMenuView a;
  @NonNull
  private final MenuBuilder c;
  private final BottomNavigationPresenter d = new BottomNavigationPresenter();
  @Nullable
  private ColorStateList e;
  private MenuInflater f;
  private BottomNavigationView.OnNavigationItemSelectedListener g;
  private BottomNavigationView.OnNavigationItemReselectedListener h;
  
  public BottomNavigationView(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public BottomNavigationView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.f);
  }
  
  public BottomNavigationView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(MaterialThemeOverlay.a(paramContext, paramAttributeSet, paramInt, b), paramAttributeSet, paramInt);
    paramContext = getContext();
    this.c = new BottomNavigationMenu(paramContext);
    this.a = new BottomNavigationMenuView(paramContext);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 17;
    this.a.setLayoutParams(localLayoutParams);
    this.d.a(this.a);
    this.d.a(1);
    this.a.setPresenter(this.d);
    this.c.addMenuPresenter(this.d);
    this.d.initForMenu(getContext(), this.c);
    paramAttributeSet = ThemeEnforcement.b(paramContext, paramAttributeSet, R.styleable.af, paramInt, R.style.k, new int[] { R.styleable.ao, R.styleable.an });
    if (paramAttributeSet.hasValue(R.styleable.al))
    {
      this.a.setIconTintList(paramAttributeSet.getColorStateList(R.styleable.al));
    }
    else
    {
      localObject = this.a;
      ((BottomNavigationMenuView)localObject).setIconTintList(((BottomNavigationMenuView)localObject).a(16842808));
    }
    setItemIconSize(paramAttributeSet.getDimensionPixelSize(R.styleable.ak, getResources().getDimensionPixelSize(R.dimen.e)));
    if (paramAttributeSet.hasValue(R.styleable.ao)) {
      setItemTextAppearanceInactive(paramAttributeSet.getResourceId(R.styleable.ao, 0));
    }
    if (paramAttributeSet.hasValue(R.styleable.an)) {
      setItemTextAppearanceActive(paramAttributeSet.getResourceId(R.styleable.an, 0));
    }
    if (paramAttributeSet.hasValue(R.styleable.ap)) {
      setItemTextColor(paramAttributeSet.getColorStateList(R.styleable.ap));
    }
    if ((getBackground() == null) || ((getBackground() instanceof ColorDrawable))) {
      ViewCompat.setBackground(this, a(paramContext));
    }
    if (paramAttributeSet.hasValue(R.styleable.ah)) {
      setElevation(paramAttributeSet.getDimensionPixelSize(R.styleable.ah, 0));
    }
    Object localObject = MaterialResources.a(paramContext, paramAttributeSet, R.styleable.ag);
    DrawableCompat.setTintList(getBackground().mutate(), (ColorStateList)localObject);
    setLabelVisibilityMode(paramAttributeSet.getInteger(R.styleable.aq, -1));
    setItemHorizontalTranslationEnabled(paramAttributeSet.getBoolean(R.styleable.aj, true));
    paramInt = paramAttributeSet.getResourceId(R.styleable.ai, 0);
    if (paramInt != 0) {
      this.a.setItemBackgroundRes(paramInt);
    } else {
      setItemRippleColor(MaterialResources.a(paramContext, paramAttributeSet, R.styleable.am));
    }
    if (paramAttributeSet.hasValue(R.styleable.ar)) {
      a(paramAttributeSet.getResourceId(R.styleable.ar, 0));
    }
    paramAttributeSet.recycle();
    addView(this.a, localLayoutParams);
    if (b()) {
      b(paramContext);
    }
    this.c.setCallback(new BottomNavigationView.1(this));
    a();
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
  
  private void b(Context paramContext)
  {
    View localView = new View(paramContext);
    localView.setBackgroundColor(ContextCompat.getColor(paramContext, R.color.a));
    localView.setLayoutParams(new FrameLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.i)));
    addView(localView);
  }
  
  private boolean b()
  {
    return (Build.VERSION.SDK_INT < 21) && (!(getBackground() instanceof MaterialShapeDrawable));
  }
  
  private MenuInflater getMenuInflater()
  {
    if (this.f == null) {
      this.f = new SupportMenuInflater(getContext());
    }
    return this.f;
  }
  
  public void a(int paramInt)
  {
    this.d.a(true);
    getMenuInflater().inflate(paramInt, this.c);
    this.d.a(false);
    this.d.updateMenuView(true);
  }
  
  @Nullable
  public Drawable getItemBackground()
  {
    return this.a.getItemBackground();
  }
  
  @Deprecated
  @DrawableRes
  public int getItemBackgroundResource()
  {
    return this.a.getItemBackgroundRes();
  }
  
  @Dimension
  public int getItemIconSize()
  {
    return this.a.getItemIconSize();
  }
  
  @Nullable
  public ColorStateList getItemIconTintList()
  {
    return this.a.getIconTintList();
  }
  
  @Nullable
  public ColorStateList getItemRippleColor()
  {
    return this.e;
  }
  
  @StyleRes
  public int getItemTextAppearanceActive()
  {
    return this.a.getItemTextAppearanceActive();
  }
  
  @StyleRes
  public int getItemTextAppearanceInactive()
  {
    return this.a.getItemTextAppearanceInactive();
  }
  
  @Nullable
  public ColorStateList getItemTextColor()
  {
    return this.a.getItemTextColor();
  }
  
  public int getLabelVisibilityMode()
  {
    return this.a.getLabelVisibilityMode();
  }
  
  public int getMaxItemCount()
  {
    return 5;
  }
  
  @NonNull
  public Menu getMenu()
  {
    return this.c;
  }
  
  @IdRes
  public int getSelectedItemId()
  {
    return this.a.getSelectedItemId();
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
    this.c.restorePresenterStates(paramParcelable.a);
  }
  
  protected Parcelable onSaveInstanceState()
  {
    BottomNavigationView.SavedState localSavedState = new BottomNavigationView.SavedState(super.onSaveInstanceState());
    localSavedState.a = new Bundle();
    this.c.savePresenterStates(localSavedState.a);
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
    this.a.setItemBackground(paramDrawable);
    this.e = null;
  }
  
  public void setItemBackgroundResource(@DrawableRes int paramInt)
  {
    this.a.setItemBackgroundRes(paramInt);
    this.e = null;
  }
  
  public void setItemHorizontalTranslationEnabled(boolean paramBoolean)
  {
    if (this.a.a() != paramBoolean)
    {
      this.a.setItemHorizontalTranslationEnabled(paramBoolean);
      this.d.updateMenuView(false);
    }
  }
  
  public void setItemIconSize(@Dimension int paramInt)
  {
    this.a.setItemIconSize(paramInt);
  }
  
  public void setItemIconSizeRes(@DimenRes int paramInt)
  {
    setItemIconSize(getResources().getDimensionPixelSize(paramInt));
  }
  
  public void setItemIconTintList(@Nullable ColorStateList paramColorStateList)
  {
    this.a.setIconTintList(paramColorStateList);
  }
  
  public void setItemOnTouchListener(int paramInt, @Nullable View.OnTouchListener paramOnTouchListener)
  {
    this.a.setItemOnTouchListener(paramInt, paramOnTouchListener);
  }
  
  public void setItemRippleColor(@Nullable ColorStateList paramColorStateList)
  {
    if (this.e == paramColorStateList)
    {
      if ((paramColorStateList == null) && (this.a.getItemBackground() != null)) {
        this.a.setItemBackground(null);
      }
      return;
    }
    this.e = paramColorStateList;
    if (paramColorStateList == null)
    {
      this.a.setItemBackground(null);
      return;
    }
    paramColorStateList = RippleUtils.a(paramColorStateList);
    if (Build.VERSION.SDK_INT >= 21)
    {
      this.a.setItemBackground(new RippleDrawable(paramColorStateList, null, null));
      return;
    }
    Object localObject = new GradientDrawable();
    ((GradientDrawable)localObject).setCornerRadius(1.0E-005F);
    localObject = DrawableCompat.wrap((Drawable)localObject);
    DrawableCompat.setTintList((Drawable)localObject, paramColorStateList);
    this.a.setItemBackground((Drawable)localObject);
  }
  
  public void setItemTextAppearanceActive(@StyleRes int paramInt)
  {
    this.a.setItemTextAppearanceActive(paramInt);
  }
  
  public void setItemTextAppearanceInactive(@StyleRes int paramInt)
  {
    this.a.setItemTextAppearanceInactive(paramInt);
  }
  
  public void setItemTextColor(@Nullable ColorStateList paramColorStateList)
  {
    this.a.setItemTextColor(paramColorStateList);
  }
  
  public void setLabelVisibilityMode(int paramInt)
  {
    if (this.a.getLabelVisibilityMode() != paramInt)
    {
      this.a.setLabelVisibilityMode(paramInt);
      this.d.updateMenuView(false);
    }
  }
  
  public void setOnNavigationItemReselectedListener(@Nullable BottomNavigationView.OnNavigationItemReselectedListener paramOnNavigationItemReselectedListener)
  {
    this.h = paramOnNavigationItemReselectedListener;
  }
  
  public void setOnNavigationItemSelectedListener(@Nullable BottomNavigationView.OnNavigationItemSelectedListener paramOnNavigationItemSelectedListener)
  {
    this.g = paramOnNavigationItemSelectedListener;
  }
  
  public void setSelectedItemId(@IdRes int paramInt)
  {
    MenuItem localMenuItem = this.c.findItem(paramInt);
    if ((localMenuItem != null) && (!this.c.performItemAction(localMenuItem, this.d, 0))) {
      localMenuItem.setChecked(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.bottomnavigation.BottomNavigationView
 * JD-Core Version:    0.7.0.1
 */