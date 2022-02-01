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
  private static final int[] jdField_a_of_type_ArrayOfInt = { 16842912 };
  private int jdField_a_of_type_Int;
  private ColorStateList jdField_a_of_type_AndroidContentResColorStateList;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private final CheckedTextView jdField_a_of_type_AndroidWidgetCheckedTextView;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private MenuItemImpl jdField_a_of_type_AndroidxAppcompatViewMenuMenuItemImpl;
  private final AccessibilityDelegateCompat jdField_a_of_type_AndroidxCoreViewAccessibilityDelegateCompat = new NavigationMenuItemView.1(this);
  boolean c;
  private boolean d;
  private boolean e;
  
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
    this.jdField_a_of_type_AndroidWidgetCheckedTextView = ((CheckedTextView)findViewById(R.id.g));
    this.jdField_a_of_type_AndroidWidgetCheckedTextView.setDuplicateParentStateEnabled(true);
    ViewCompat.setAccessibilityDelegate(this.jdField_a_of_type_AndroidWidgetCheckedTextView, this.jdField_a_of_type_AndroidxCoreViewAccessibilityDelegateCompat);
  }
  
  @Nullable
  private StateListDrawable a()
  {
    TypedValue localTypedValue = new TypedValue();
    if (getContext().getTheme().resolveAttribute(R.attr.colorControlHighlight, localTypedValue, true))
    {
      StateListDrawable localStateListDrawable = new StateListDrawable();
      localStateListDrawable.addState(jdField_a_of_type_ArrayOfInt, new ColorDrawable(localTypedValue.data));
      localStateListDrawable.addState(EMPTY_STATE_SET, new ColorDrawable(0));
      return localStateListDrawable;
    }
    return null;
  }
  
  private void a(@Nullable View paramView)
  {
    if (paramView != null)
    {
      if (this.jdField_a_of_type_AndroidWidgetFrameLayout == null) {
        this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)((ViewStub)findViewById(R.id.f)).inflate());
      }
      this.jdField_a_of_type_AndroidWidgetFrameLayout.removeAllViews();
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(paramView);
    }
  }
  
  private boolean a()
  {
    return (this.jdField_a_of_type_AndroidxAppcompatViewMenuMenuItemImpl.getTitle() == null) && (this.jdField_a_of_type_AndroidxAppcompatViewMenuMenuItemImpl.getIcon() == null) && (this.jdField_a_of_type_AndroidxAppcompatViewMenuMenuItemImpl.getActionView() != null);
  }
  
  private void b()
  {
    Object localObject;
    if (a())
    {
      this.jdField_a_of_type_AndroidWidgetCheckedTextView.setVisibility(8);
      localObject = this.jdField_a_of_type_AndroidWidgetFrameLayout;
      if (localObject != null)
      {
        localObject = (LinearLayoutCompat.LayoutParams)((FrameLayout)localObject).getLayoutParams();
        ((LinearLayoutCompat.LayoutParams)localObject).width = -1;
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
    else
    {
      this.jdField_a_of_type_AndroidWidgetCheckedTextView.setVisibility(0);
      localObject = this.jdField_a_of_type_AndroidWidgetFrameLayout;
      if (localObject != null)
      {
        localObject = (LinearLayoutCompat.LayoutParams)((FrameLayout)localObject).getLayoutParams();
        ((LinearLayoutCompat.LayoutParams)localObject).width = -2;
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
  }
  
  public void a()
  {
    FrameLayout localFrameLayout = this.jdField_a_of_type_AndroidWidgetFrameLayout;
    if (localFrameLayout != null) {
      localFrameLayout.removeAllViews();
    }
    this.jdField_a_of_type_AndroidWidgetCheckedTextView.setCompoundDrawables(null, null, null, null);
  }
  
  void a(ColorStateList paramColorStateList)
  {
    this.jdField_a_of_type_AndroidContentResColorStateList = paramColorStateList;
    boolean bool;
    if (this.jdField_a_of_type_AndroidContentResColorStateList != null) {
      bool = true;
    } else {
      bool = false;
    }
    this.e = bool;
    paramColorStateList = this.jdField_a_of_type_AndroidxAppcompatViewMenuMenuItemImpl;
    if (paramColorStateList != null) {
      setIcon(paramColorStateList.getIcon());
    }
  }
  
  public MenuItemImpl getItemData()
  {
    return this.jdField_a_of_type_AndroidxAppcompatViewMenuMenuItemImpl;
  }
  
  public void initialize(@NonNull MenuItemImpl paramMenuItemImpl, int paramInt)
  {
    this.jdField_a_of_type_AndroidxAppcompatViewMenuMenuItemImpl = paramMenuItemImpl;
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
      ViewCompat.setBackground(this, a());
    }
    setCheckable(paramMenuItemImpl.isCheckable());
    setChecked(paramMenuItemImpl.isChecked());
    setEnabled(paramMenuItemImpl.isEnabled());
    setTitle(paramMenuItemImpl.getTitle());
    setIcon(paramMenuItemImpl.getIcon());
    a(paramMenuItemImpl.getActionView());
    setContentDescription(paramMenuItemImpl.getContentDescription());
    TooltipCompat.setTooltipText(this, paramMenuItemImpl.getTooltipText());
    b();
  }
  
  protected int[] onCreateDrawableState(int paramInt)
  {
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 1);
    MenuItemImpl localMenuItemImpl = this.jdField_a_of_type_AndroidxAppcompatViewMenuMenuItemImpl;
    if ((localMenuItemImpl != null) && (localMenuItemImpl.isCheckable()) && (this.jdField_a_of_type_AndroidxAppcompatViewMenuMenuItemImpl.isChecked())) {
      mergeDrawableStates(arrayOfInt, jdField_a_of_type_ArrayOfInt);
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
      this.jdField_a_of_type_AndroidxCoreViewAccessibilityDelegateCompat.sendAccessibilityEvent(this.jdField_a_of_type_AndroidWidgetCheckedTextView, 2048);
    }
  }
  
  public void setChecked(boolean paramBoolean)
  {
    refreshDrawableState();
    this.jdField_a_of_type_AndroidWidgetCheckedTextView.setChecked(paramBoolean);
  }
  
  public void setHorizontalPadding(int paramInt)
  {
    setPadding(paramInt, 0, paramInt, 0);
  }
  
  public void setIcon(@Nullable Drawable paramDrawable)
  {
    int i;
    if (paramDrawable != null)
    {
      Object localObject = paramDrawable;
      if (this.e)
      {
        localObject = paramDrawable.getConstantState();
        if (localObject != null) {
          paramDrawable = ((Drawable.ConstantState)localObject).newDrawable();
        }
        localObject = DrawableCompat.wrap(paramDrawable).mutate();
        DrawableCompat.setTintList((Drawable)localObject, this.jdField_a_of_type_AndroidContentResColorStateList);
      }
      i = this.jdField_a_of_type_Int;
      ((Drawable)localObject).setBounds(0, 0, i, i);
      paramDrawable = (Drawable)localObject;
    }
    else if (this.d)
    {
      if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)
      {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = ResourcesCompat.getDrawable(getResources(), R.drawable.h, getContext().getTheme());
        paramDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        if (paramDrawable != null)
        {
          i = this.jdField_a_of_type_Int;
          paramDrawable.setBounds(0, 0, i, i);
        }
      }
      paramDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    }
    TextViewCompat.setCompoundDrawablesRelative(this.jdField_a_of_type_AndroidWidgetCheckedTextView, paramDrawable, null, null, null);
  }
  
  public void setIconPadding(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetCheckedTextView.setCompoundDrawablePadding(paramInt);
  }
  
  public void setIconSize(@Dimension int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void setMaxLines(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetCheckedTextView.setMaxLines(paramInt);
  }
  
  public void setNeedsEmptyIcon(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public void setShortcut(boolean paramBoolean, char paramChar) {}
  
  public void setTextAppearance(int paramInt)
  {
    TextViewCompat.setTextAppearance(this.jdField_a_of_type_AndroidWidgetCheckedTextView, paramInt);
  }
  
  public void setTextColor(ColorStateList paramColorStateList)
  {
    this.jdField_a_of_type_AndroidWidgetCheckedTextView.setTextColor(paramColorStateList);
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    this.jdField_a_of_type_AndroidWidgetCheckedTextView.setText(paramCharSequence);
  }
  
  public boolean showsIcon()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.internal.NavigationMenuItemView
 * JD-Core Version:    0.7.0.1
 */