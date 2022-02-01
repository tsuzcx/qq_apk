package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuView.ItemView;
import androidx.appcompat.widget.TooltipCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.PointerIconCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat.CollectionItemInfoCompat;
import androidx.core.widget.TextViewCompat;
import com.google.android.material.R.dimen;
import com.google.android.material.R.drawable;
import com.google.android.material.R.id;
import com.google.android.material.R.layout;
import com.google.android.material.R.string;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.badge.BadgeUtils;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class BottomNavigationItemView
  extends FrameLayout
  implements MenuView.ItemView
{
  private static final int[] a = { 16842912 };
  private final int b;
  private float c;
  private float d;
  private float e;
  private int f;
  private boolean g;
  private ImageView h;
  private final ViewGroup i;
  private final TextView j;
  private final TextView k;
  private int l = -1;
  @Nullable
  private MenuItemImpl m;
  @Nullable
  private ColorStateList n;
  @Nullable
  private Drawable o;
  @Nullable
  private Drawable p;
  @Nullable
  private BadgeDrawable q;
  
  public BottomNavigationItemView(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public BottomNavigationItemView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public BottomNavigationItemView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramAttributeSet = getResources();
    LayoutInflater.from(paramContext).inflate(R.layout.a, this, true);
    setBackgroundResource(R.drawable.a);
    this.b = paramAttributeSet.getDimensionPixelSize(R.dimen.h);
    this.h = ((ImageView)findViewById(R.id.i));
    this.i = ((ViewGroup)findViewById(R.id.j));
    this.j = ((TextView)findViewById(R.id.ab));
    this.k = ((TextView)findViewById(R.id.k));
    this.i.setTag(R.id.Y, Integer.valueOf(this.i.getPaddingBottom()));
    ViewCompat.setImportantForAccessibility(this.j, 2);
    ViewCompat.setImportantForAccessibility(this.k, 2);
    setFocusable(true);
    a(this.j.getTextSize(), this.k.getTextSize());
    paramContext = this.h;
    if (paramContext != null) {
      paramContext.addOnLayoutChangeListener(new BottomNavigationItemView.1(this));
    }
  }
  
  private void a(float paramFloat1, float paramFloat2)
  {
    this.c = (paramFloat1 - paramFloat2);
    this.d = (paramFloat2 * 1.0F / paramFloat1);
    this.e = (paramFloat1 * 1.0F / paramFloat2);
  }
  
  private void a(View paramView)
  {
    if (!b()) {
      return;
    }
    BadgeUtils.b(this.q, paramView, d(paramView));
  }
  
  private static void a(@NonNull View paramView, float paramFloat1, float paramFloat2, int paramInt)
  {
    paramView.setScaleX(paramFloat1);
    paramView.setScaleY(paramFloat2);
    paramView.setVisibility(paramInt);
  }
  
  private static void a(@NonNull View paramView, int paramInt)
  {
    paramView.setPadding(paramView.getPaddingLeft(), paramView.getPaddingTop(), paramView.getPaddingRight(), paramInt);
  }
  
  private static void a(@NonNull View paramView, int paramInt1, int paramInt2)
  {
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)paramView.getLayoutParams();
    localLayoutParams.topMargin = paramInt1;
    localLayoutParams.gravity = paramInt2;
    paramView.setLayoutParams(localLayoutParams);
  }
  
  private void b(@Nullable View paramView)
  {
    if (!b()) {
      return;
    }
    if (paramView != null)
    {
      setClipChildren(false);
      setClipToPadding(false);
      BadgeUtils.a(this.q, paramView, d(paramView));
    }
  }
  
  private boolean b()
  {
    return this.q != null;
  }
  
  private void c(@Nullable View paramView)
  {
    if (!b()) {
      return;
    }
    if (paramView != null)
    {
      setClipChildren(true);
      setClipToPadding(true);
      BadgeUtils.a(this.q, paramView);
    }
    this.q = null;
  }
  
  @Nullable
  private FrameLayout d(View paramView)
  {
    ImageView localImageView = this.h;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramView == localImageView)
    {
      localObject1 = localObject2;
      if (BadgeUtils.a) {
        localObject1 = (FrameLayout)this.h.getParent();
      }
    }
    return localObject1;
  }
  
  private int getItemVisiblePosition()
  {
    ViewGroup localViewGroup = (ViewGroup)getParent();
    int i4 = localViewGroup.indexOfChild(this);
    int i1 = 0;
    int i3;
    for (int i2 = 0; i1 < i4; i2 = i3)
    {
      View localView = localViewGroup.getChildAt(i1);
      i3 = i2;
      if ((localView instanceof BottomNavigationItemView))
      {
        i3 = i2;
        if (localView.getVisibility() == 0) {
          i3 = i2 + 1;
        }
      }
      i1 += 1;
    }
    return i2;
  }
  
  void a()
  {
    c(this.h);
  }
  
  @Nullable
  BadgeDrawable getBadge()
  {
    return this.q;
  }
  
  public MenuItemImpl getItemData()
  {
    return this.m;
  }
  
  public int getItemPosition()
  {
    return this.l;
  }
  
  public void initialize(@NonNull MenuItemImpl paramMenuItemImpl, int paramInt)
  {
    this.m = paramMenuItemImpl;
    setCheckable(paramMenuItemImpl.isCheckable());
    setChecked(paramMenuItemImpl.isChecked());
    setEnabled(paramMenuItemImpl.isEnabled());
    setIcon(paramMenuItemImpl.getIcon());
    setTitle(paramMenuItemImpl.getTitle());
    setId(paramMenuItemImpl.getItemId());
    if (!TextUtils.isEmpty(paramMenuItemImpl.getContentDescription())) {
      setContentDescription(paramMenuItemImpl.getContentDescription());
    }
    CharSequence localCharSequence;
    if (!TextUtils.isEmpty(paramMenuItemImpl.getTooltipText())) {
      localCharSequence = paramMenuItemImpl.getTooltipText();
    } else {
      localCharSequence = paramMenuItemImpl.getTitle();
    }
    TooltipCompat.setTooltipText(this, localCharSequence);
    if (paramMenuItemImpl.isVisible()) {
      paramInt = 0;
    } else {
      paramInt = 8;
    }
    setVisibility(paramInt);
  }
  
  public int[] onCreateDrawableState(int paramInt)
  {
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 1);
    MenuItemImpl localMenuItemImpl = this.m;
    if ((localMenuItemImpl != null) && (localMenuItemImpl.isCheckable()) && (this.m.isChecked())) {
      mergeDrawableStates(arrayOfInt, a);
    }
    return arrayOfInt;
  }
  
  public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    Object localObject = this.q;
    if ((localObject != null) && (((BadgeDrawable)localObject).isVisible()))
    {
      localObject = this.m.getTitle();
      if (!TextUtils.isEmpty(this.m.getContentDescription())) {
        localObject = this.m.getContentDescription();
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(localObject);
      localStringBuilder.append(", ");
      localStringBuilder.append(this.q.g());
      paramAccessibilityNodeInfo.setContentDescription(localStringBuilder.toString());
    }
    paramAccessibilityNodeInfo = AccessibilityNodeInfoCompat.wrap(paramAccessibilityNodeInfo);
    paramAccessibilityNodeInfo.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(0, 1, getItemVisiblePosition(), 1, false, isSelected()));
    if (isSelected())
    {
      paramAccessibilityNodeInfo.setClickable(false);
      paramAccessibilityNodeInfo.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLICK);
    }
    paramAccessibilityNodeInfo.setRoleDescription(getResources().getString(R.string.h));
  }
  
  public boolean prefersCondensedTitle()
  {
    return false;
  }
  
  void setBadge(@NonNull BadgeDrawable paramBadgeDrawable)
  {
    this.q = paramBadgeDrawable;
    paramBadgeDrawable = this.h;
    if (paramBadgeDrawable != null) {
      b(paramBadgeDrawable);
    }
  }
  
  public void setCheckable(boolean paramBoolean)
  {
    refreshDrawableState();
  }
  
  public void setChecked(boolean paramBoolean)
  {
    Object localObject = this.k;
    ((TextView)localObject).setPivotX(((TextView)localObject).getWidth() / 2);
    localObject = this.k;
    ((TextView)localObject).setPivotY(((TextView)localObject).getBaseline());
    localObject = this.j;
    ((TextView)localObject).setPivotX(((TextView)localObject).getWidth() / 2);
    localObject = this.j;
    ((TextView)localObject).setPivotY(((TextView)localObject).getBaseline());
    int i1 = this.f;
    float f1;
    if (i1 != -1)
    {
      if (i1 != 0)
      {
        if (i1 != 1)
        {
          if (i1 == 2)
          {
            a(this.h, this.b, 17);
            this.k.setVisibility(8);
            this.j.setVisibility(8);
          }
        }
        else
        {
          localObject = this.i;
          a((View)localObject, ((Integer)((ViewGroup)localObject).getTag(R.id.Y)).intValue());
          if (paramBoolean)
          {
            a(this.h, (int)(this.b + this.c), 49);
            a(this.k, 1.0F, 1.0F, 0);
            localObject = this.j;
            f1 = this.d;
            a((View)localObject, f1, f1, 4);
          }
          else
          {
            a(this.h, this.b, 49);
            localObject = this.k;
            f1 = this.e;
            a((View)localObject, f1, f1, 4);
            a(this.j, 1.0F, 1.0F, 0);
          }
        }
      }
      else
      {
        if (paramBoolean)
        {
          a(this.h, this.b, 49);
          localObject = this.i;
          a((View)localObject, ((Integer)((ViewGroup)localObject).getTag(R.id.Y)).intValue());
          this.k.setVisibility(0);
        }
        else
        {
          a(this.h, this.b, 17);
          a(this.i, 0);
          this.k.setVisibility(4);
        }
        this.j.setVisibility(4);
      }
    }
    else if (this.g)
    {
      if (paramBoolean)
      {
        a(this.h, this.b, 49);
        localObject = this.i;
        a((View)localObject, ((Integer)((ViewGroup)localObject).getTag(R.id.Y)).intValue());
        this.k.setVisibility(0);
      }
      else
      {
        a(this.h, this.b, 17);
        a(this.i, 0);
        this.k.setVisibility(4);
      }
      this.j.setVisibility(4);
    }
    else
    {
      localObject = this.i;
      a((View)localObject, ((Integer)((ViewGroup)localObject).getTag(R.id.Y)).intValue());
      if (paramBoolean)
      {
        a(this.h, (int)(this.b + this.c), 49);
        a(this.k, 1.0F, 1.0F, 0);
        localObject = this.j;
        f1 = this.d;
        a((View)localObject, f1, f1, 4);
      }
      else
      {
        a(this.h, this.b, 49);
        localObject = this.k;
        f1 = this.e;
        a((View)localObject, f1, f1, 4);
        a(this.j, 1.0F, 1.0F, 0);
      }
    }
    refreshDrawableState();
    setSelected(paramBoolean);
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    super.setEnabled(paramBoolean);
    this.j.setEnabled(paramBoolean);
    this.k.setEnabled(paramBoolean);
    this.h.setEnabled(paramBoolean);
    if (paramBoolean)
    {
      ViewCompat.setPointerIcon(this, PointerIconCompat.getSystemIcon(getContext(), 1002));
      return;
    }
    ViewCompat.setPointerIcon(this, null);
  }
  
  public void setIcon(@Nullable Drawable paramDrawable)
  {
    if (paramDrawable == this.o) {
      return;
    }
    this.o = paramDrawable;
    Object localObject = paramDrawable;
    if (paramDrawable != null)
    {
      localObject = paramDrawable.getConstantState();
      if (localObject != null) {
        paramDrawable = ((Drawable.ConstantState)localObject).newDrawable();
      }
      paramDrawable = DrawableCompat.wrap(paramDrawable).mutate();
      this.p = paramDrawable;
      ColorStateList localColorStateList = this.n;
      localObject = paramDrawable;
      if (localColorStateList != null)
      {
        DrawableCompat.setTintList(this.p, localColorStateList);
        localObject = paramDrawable;
      }
    }
    this.h.setImageDrawable((Drawable)localObject);
  }
  
  public void setIconSize(int paramInt)
  {
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.h.getLayoutParams();
    localLayoutParams.width = paramInt;
    localLayoutParams.height = paramInt;
    this.h.setLayoutParams(localLayoutParams);
  }
  
  public void setIconTintList(ColorStateList paramColorStateList)
  {
    this.n = paramColorStateList;
    if (this.m != null)
    {
      paramColorStateList = this.p;
      if (paramColorStateList != null)
      {
        DrawableCompat.setTintList(paramColorStateList, this.n);
        this.p.invalidateSelf();
      }
    }
  }
  
  public void setItemBackground(int paramInt)
  {
    Drawable localDrawable;
    if (paramInt == 0) {
      localDrawable = null;
    } else {
      localDrawable = ContextCompat.getDrawable(getContext(), paramInt);
    }
    setItemBackground(localDrawable);
  }
  
  public void setItemBackground(@Nullable Drawable paramDrawable)
  {
    Drawable localDrawable = paramDrawable;
    if (paramDrawable != null)
    {
      localDrawable = paramDrawable;
      if (paramDrawable.getConstantState() != null) {
        localDrawable = paramDrawable.getConstantState().newDrawable().mutate();
      }
    }
    ViewCompat.setBackground(this, localDrawable);
  }
  
  public void setItemPosition(int paramInt)
  {
    this.l = paramInt;
  }
  
  public void setLabelVisibilityMode(int paramInt)
  {
    if (this.f != paramInt)
    {
      this.f = paramInt;
      if (this.m != null) {
        paramInt = 1;
      } else {
        paramInt = 0;
      }
      if (paramInt != 0) {
        setChecked(this.m.isChecked());
      }
    }
  }
  
  public void setShifting(boolean paramBoolean)
  {
    if (this.g != paramBoolean)
    {
      this.g = paramBoolean;
      int i1;
      if (this.m != null) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      if (i1 != 0) {
        setChecked(this.m.isChecked());
      }
    }
  }
  
  public void setShortcut(boolean paramBoolean, char paramChar) {}
  
  public void setTextAppearanceActive(@StyleRes int paramInt)
  {
    TextViewCompat.setTextAppearance(this.k, paramInt);
    a(this.j.getTextSize(), this.k.getTextSize());
  }
  
  public void setTextAppearanceInactive(@StyleRes int paramInt)
  {
    TextViewCompat.setTextAppearance(this.j, paramInt);
    a(this.j.getTextSize(), this.k.getTextSize());
  }
  
  public void setTextColor(@Nullable ColorStateList paramColorStateList)
  {
    if (paramColorStateList != null)
    {
      this.j.setTextColor(paramColorStateList);
      this.k.setTextColor(paramColorStateList);
    }
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    this.j.setText(paramCharSequence);
    this.k.setText(paramCharSequence);
    Object localObject = this.m;
    if ((localObject == null) || (TextUtils.isEmpty(((MenuItemImpl)localObject).getContentDescription()))) {
      setContentDescription(paramCharSequence);
    }
    MenuItemImpl localMenuItemImpl = this.m;
    localObject = paramCharSequence;
    if (localMenuItemImpl != null) {
      if (TextUtils.isEmpty(localMenuItemImpl.getTooltipText())) {
        localObject = paramCharSequence;
      } else {
        localObject = this.m.getTooltipText();
      }
    }
    TooltipCompat.setTooltipText(this, (CharSequence)localObject);
  }
  
  public boolean showsIcon()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.bottomnavigation.BottomNavigationItemView
 * JD-Core Version:    0.7.0.1
 */