package com.google.android.material.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R.attr;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuView.ItemView;
import androidx.appcompat.widget.LinearLayoutCompat.LayoutParams;
import androidx.appcompat.widget.TooltipCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import com.google.android.material.R.dimen;
import com.google.android.material.R.drawable;
import com.google.android.material.R.id;
import com.google.android.material.R.layout;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class NavigationMenuItemView
  extends ForegroundLinearLayout
  implements MenuView.ItemView
{
  private static final int[] d = { 16842912 };
  boolean c;
  private int e;
  private boolean f;
  private final CheckedTextView g;
  private FrameLayout h;
  private MenuItemImpl i;
  private ColorStateList j;
  private boolean k;
  private Drawable l;
  private final AccessibilityDelegateCompat m = new NavigationMenuItemView.1(this);
  
  public NavigationMenuItemView(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public NavigationMenuItemView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public NavigationMenuItemView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setOrientation(0);
    LayoutInflater.from(paramContext).inflate(R.layout.j, this, true);
    setIconSize(paramContext.getResources().getDimensionPixelSize(R.dimen.m));
    this.g = ((CheckedTextView)findViewById(R.id.g));
    this.g.setDuplicateParentStateEnabled(true);
    ViewCompat.setAccessibilityDelegate(this.g, this.m);
  }
  
  private boolean b()
  {
    return (this.i.getTitle() == null) && (this.i.getIcon() == null) && (this.i.getActionView() != null);
  }
  
  private void c()
  {
    Object localObject;
    if (b())
    {
      this.g.setVisibility(8);
      localObject = this.h;
      if (localObject != null)
      {
        localObject = (LinearLayoutCompat.LayoutParams)((FrameLayout)localObject).getLayoutParams();
        ((LinearLayoutCompat.LayoutParams)localObject).width = -1;
        this.h.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
    else
    {
      this.g.setVisibility(0);
      localObject = this.h;
      if (localObject != null)
      {
        localObject = (LinearLayoutCompat.LayoutParams)((FrameLayout)localObject).getLayoutParams();
        ((LinearLayoutCompat.LayoutParams)localObject).width = -2;
        this.h.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
  }
  
  @Nullable
  private StateListDrawable d()
  {
    TypedValue localTypedValue = new TypedValue();
    if (getContext().getTheme().resolveAttribute(R.attr.colorControlHighlight, localTypedValue, true))
    {
      StateListDrawable localStateListDrawable = new StateListDrawable();
      localStateListDrawable.addState(d, new ColorDrawable(localTypedValue.data));
      localStateListDrawable.addState(EMPTY_STATE_SET, new ColorDrawable(0));
      return localStateListDrawable;
    }
    return null;
  }
  
  private void setActionView(@Nullable View paramView)
  {
    if (paramView != null)
    {
      if (this.h == null) {
        this.h = ((FrameLayout)((ViewStub)findViewById(R.id.f)).inflate());
      }
      this.h.removeAllViews();
      this.h.addView(paramView);
    }
  }
  
  public void a()
  {
    FrameLayout localFrameLayout = this.h;
    if (localFrameLayout != null) {
      localFrameLayout.removeAllViews();
    }
    this.g.setCompoundDrawables(null, null, null, null);
  }
  
  public MenuItemImpl getItemData()
  {
    return this.i;
  }
  
  public void initialize(@NonNull MenuItemImpl paramMenuItemImpl, int paramInt)
  {
    this.i = paramMenuItemImpl;
    if (paramMenuItemImpl.getItemId() > 0) {
      setId(paramMenuItemImpl.getItemId());
    }
    if (paramMenuItemImpl.isVisible()) {
      paramInt = 0;
    } else {
      paramInt = 8;
    }
    setVisibility(paramInt);
    if (getBackground() == null) {
      ViewCompat.setBackground(this, d());
    }
    setCheckable(paramMenuItemImpl.isCheckable());
    setChecked(paramMenuItemImpl.isChecked());
    setEnabled(paramMenuItemImpl.isEnabled());
    setTitle(paramMenuItemImpl.getTitle());
    setIcon(paramMenuItemImpl.getIcon());
    setActionView(paramMenuItemImpl.getActionView());
    setContentDescription(paramMenuItemImpl.getContentDescription());
    TooltipCompat.setTooltipText(this, paramMenuItemImpl.getTooltipText());
    c();
  }
  
  protected int[] onCreateDrawableState(int paramInt)
  {
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 1);
    MenuItemImpl localMenuItemImpl = this.i;
    if ((localMenuItemImpl != null) && (localMenuItemImpl.isCheckable()) && (this.i.isChecked())) {
      mergeDrawableStates(arrayOfInt, d);
    }
    return arrayOfInt;
  }
  
  public boolean prefersCondensedTitle()
  {
    return false;
  }
  
  public void setCheckable(boolean paramBoolean)
  {
    refreshDrawableState();
    if (this.c != paramBoolean)
    {
      this.c = paramBoolean;
      this.m.sendAccessibilityEvent(this.g, 2048);
    }
  }
  
  public void setChecked(boolean paramBoolean)
  {
    refreshDrawableState();
    this.g.setChecked(paramBoolean);
  }
  
  public void setHorizontalPadding(int paramInt)
  {
    setPadding(paramInt, 0, paramInt, 0);
  }
  
  public void setIcon(@Nullable Drawable paramDrawable)
  {
    int n;
    if (paramDrawable != null)
    {
      Object localObject = paramDrawable;
      if (this.k)
      {
        localObject = paramDrawable.getConstantState();
        if (localObject != null) {
          paramDrawable = ((Drawable.ConstantState)localObject).newDrawable();
        }
        localObject = DrawableCompat.wrap(paramDrawable).mutate();
        DrawableCompat.setTintList((Drawable)localObject, this.j);
      }
      n = this.e;
      ((Drawable)localObject).setBounds(0, 0, n, n);
      paramDrawable = (Drawable)localObject;
    }
    else if (this.f)
    {
      if (this.l == null)
      {
        this.l = ResourcesCompat.getDrawable(getResources(), R.drawable.h, getContext().getTheme());
        paramDrawable = this.l;
        if (paramDrawable != null)
        {
          n = this.e;
          paramDrawable.setBounds(0, 0, n, n);
        }
      }
      paramDrawable = this.l;
    }
    TextViewCompat.setCompoundDrawablesRelative(this.g, paramDrawable, null, null, null);
  }
  
  public void setIconPadding(int paramInt)
  {
    this.g.setCompoundDrawablePadding(paramInt);
  }
  
  public void setIconSize(@Dimension int paramInt)
  {
    this.e = paramInt;
  }
  
  void setIconTintList(ColorStateList paramColorStateList)
  {
    this.j = paramColorStateList;
    boolean bool;
    if (this.j != null) {
      bool = true;
    } else {
      bool = false;
    }
    this.k = bool;
    paramColorStateList = this.i;
    if (paramColorStateList != null) {
      setIcon(paramColorStateList.getIcon());
    }
  }
  
  public void setMaxLines(int paramInt)
  {
    this.g.setMaxLines(paramInt);
  }
  
  public void setNeedsEmptyIcon(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public void setShortcut(boolean paramBoolean, char paramChar) {}
  
  public void setTextAppearance(int paramInt)
  {
    TextViewCompat.setTextAppearance(this.g, paramInt);
  }
  
  public void setTextColor(ColorStateList paramColorStateList)
  {
    this.g.setTextColor(paramColorStateList);
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    this.g.setText(paramCharSequence);
  }
  
  public boolean showsIcon()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.internal.NavigationMenuItemView
 * JD-Core Version:    0.7.0.1
 */