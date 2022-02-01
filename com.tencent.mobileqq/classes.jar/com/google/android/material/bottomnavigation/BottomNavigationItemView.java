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
  private static final int[] jdField_a_of_type_ArrayOfInt = { 16842912 };
  private float jdField_a_of_type_Float;
  private final int jdField_a_of_type_Int;
  @Nullable
  private ColorStateList jdField_a_of_type_AndroidContentResColorStateList;
  @Nullable
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private final ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private final TextView jdField_a_of_type_AndroidWidgetTextView;
  @Nullable
  private MenuItemImpl jdField_a_of_type_AndroidxAppcompatViewMenuMenuItemImpl;
  @Nullable
  private BadgeDrawable jdField_a_of_type_ComGoogleAndroidMaterialBadgeBadgeDrawable;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  @Nullable
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  private final TextView jdField_b_of_type_AndroidWidgetTextView;
  private float jdField_c_of_type_Float;
  private int jdField_c_of_type_Int = -1;
  
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
    LayoutInflater.from(paramContext).inflate(R.layout.jdField_a_of_type_Int, this, true);
    setBackgroundResource(R.drawable.jdField_a_of_type_Int);
    this.jdField_a_of_type_Int = paramAttributeSet.getDimensionPixelSize(R.dimen.h);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(R.id.i));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(R.id.j));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(R.id.ab));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(R.id.k));
    this.jdField_a_of_type_AndroidViewViewGroup.setTag(R.id.Y, Integer.valueOf(this.jdField_a_of_type_AndroidViewViewGroup.getPaddingBottom()));
    ViewCompat.setImportantForAccessibility(this.jdField_a_of_type_AndroidWidgetTextView, 2);
    ViewCompat.setImportantForAccessibility(this.jdField_b_of_type_AndroidWidgetTextView, 2);
    setFocusable(true);
    a(this.jdField_a_of_type_AndroidWidgetTextView.getTextSize(), this.jdField_b_of_type_AndroidWidgetTextView.getTextSize());
    paramContext = this.jdField_a_of_type_AndroidWidgetImageView;
    if (paramContext != null) {
      paramContext.addOnLayoutChangeListener(new BottomNavigationItemView.1(this));
    }
  }
  
  private int a()
  {
    ViewGroup localViewGroup = (ViewGroup)getParent();
    int m = localViewGroup.indexOfChild(this);
    int i = 0;
    int k;
    for (int j = 0; i < m; j = k)
    {
      View localView = localViewGroup.getChildAt(i);
      k = j;
      if ((localView instanceof BottomNavigationItemView))
      {
        k = j;
        if (localView.getVisibility() == 0) {
          k = j + 1;
        }
      }
      i += 1;
    }
    return j;
  }
  
  @Nullable
  private FrameLayout a(View paramView)
  {
    ImageView localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramView == localImageView)
    {
      localObject1 = localObject2;
      if (BadgeUtils.jdField_a_of_type_Boolean) {
        localObject1 = (FrameLayout)this.jdField_a_of_type_AndroidWidgetImageView.getParent();
      }
    }
    return localObject1;
  }
  
  private void a(float paramFloat1, float paramFloat2)
  {
    this.jdField_a_of_type_Float = (paramFloat1 - paramFloat2);
    this.jdField_b_of_type_Float = (paramFloat2 * 1.0F / paramFloat1);
    this.jdField_c_of_type_Float = (paramFloat1 * 1.0F / paramFloat2);
  }
  
  private void a(View paramView)
  {
    if (!a()) {
      return;
    }
    BadgeUtils.b(this.jdField_a_of_type_ComGoogleAndroidMaterialBadgeBadgeDrawable, paramView, a(paramView));
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
  
  private boolean a()
  {
    return this.jdField_a_of_type_ComGoogleAndroidMaterialBadgeBadgeDrawable != null;
  }
  
  private void b(@Nullable View paramView)
  {
    if (!a()) {
      return;
    }
    if (paramView != null)
    {
      setClipChildren(false);
      setClipToPadding(false);
      BadgeUtils.a(this.jdField_a_of_type_ComGoogleAndroidMaterialBadgeBadgeDrawable, paramView, a(paramView));
    }
  }
  
  private void c(@Nullable View paramView)
  {
    if (!a()) {
      return;
    }
    if (paramView != null)
    {
      setClipChildren(true);
      setClipToPadding(true);
      BadgeUtils.a(this.jdField_a_of_type_ComGoogleAndroidMaterialBadgeBadgeDrawable, paramView);
    }
    this.jdField_a_of_type_ComGoogleAndroidMaterialBadgeBadgeDrawable = null;
  }
  
  void a()
  {
    c(this.jdField_a_of_type_AndroidWidgetImageView);
  }
  
  void a(@NonNull BadgeDrawable paramBadgeDrawable)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialBadgeBadgeDrawable = paramBadgeDrawable;
    paramBadgeDrawable = this.jdField_a_of_type_AndroidWidgetImageView;
    if (paramBadgeDrawable != null) {
      b(paramBadgeDrawable);
    }
  }
  
  public MenuItemImpl getItemData()
  {
    return this.jdField_a_of_type_AndroidxAppcompatViewMenuMenuItemImpl;
  }
  
  public void initialize(@NonNull MenuItemImpl paramMenuItemImpl, int paramInt)
  {
    this.jdField_a_of_type_AndroidxAppcompatViewMenuMenuItemImpl = paramMenuItemImpl;
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
    MenuItemImpl localMenuItemImpl = this.jdField_a_of_type_AndroidxAppcompatViewMenuMenuItemImpl;
    if ((localMenuItemImpl != null) && (localMenuItemImpl.isCheckable()) && (this.jdField_a_of_type_AndroidxAppcompatViewMenuMenuItemImpl.isChecked())) {
      mergeDrawableStates(arrayOfInt, jdField_a_of_type_ArrayOfInt);
    }
    return arrayOfInt;
  }
  
  public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    Object localObject = this.jdField_a_of_type_ComGoogleAndroidMaterialBadgeBadgeDrawable;
    if ((localObject != null) && (((BadgeDrawable)localObject).isVisible()))
    {
      localObject = this.jdField_a_of_type_AndroidxAppcompatViewMenuMenuItemImpl.getTitle();
      if (!TextUtils.isEmpty(this.jdField_a_of_type_AndroidxAppcompatViewMenuMenuItemImpl.getContentDescription())) {
        localObject = this.jdField_a_of_type_AndroidxAppcompatViewMenuMenuItemImpl.getContentDescription();
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(localObject);
      localStringBuilder.append(", ");
      localStringBuilder.append(this.jdField_a_of_type_ComGoogleAndroidMaterialBadgeBadgeDrawable.a());
      paramAccessibilityNodeInfo.setContentDescription(localStringBuilder.toString());
    }
    paramAccessibilityNodeInfo = AccessibilityNodeInfoCompat.wrap(paramAccessibilityNodeInfo);
    paramAccessibilityNodeInfo.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(0, 1, a(), 1, false, isSelected()));
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
  
  public void setCheckable(boolean paramBoolean)
  {
    refreshDrawableState();
  }
  
  public void setChecked(boolean paramBoolean)
  {
    Object localObject = this.jdField_b_of_type_AndroidWidgetTextView;
    ((TextView)localObject).setPivotX(((TextView)localObject).getWidth() / 2);
    localObject = this.jdField_b_of_type_AndroidWidgetTextView;
    ((TextView)localObject).setPivotY(((TextView)localObject).getBaseline());
    localObject = this.jdField_a_of_type_AndroidWidgetTextView;
    ((TextView)localObject).setPivotX(((TextView)localObject).getWidth() / 2);
    localObject = this.jdField_a_of_type_AndroidWidgetTextView;
    ((TextView)localObject).setPivotY(((TextView)localObject).getBaseline());
    int i = this.jdField_b_of_type_Int;
    float f;
    if (i != -1)
    {
      if (i != 0)
      {
        if (i != 1)
        {
          if (i == 2)
          {
            a(this.jdField_a_of_type_AndroidWidgetImageView, this.jdField_a_of_type_Int, 17);
            this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
            this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
          }
        }
        else
        {
          localObject = this.jdField_a_of_type_AndroidViewViewGroup;
          a((View)localObject, ((Integer)((ViewGroup)localObject).getTag(R.id.Y)).intValue());
          if (paramBoolean)
          {
            a(this.jdField_a_of_type_AndroidWidgetImageView, (int)(this.jdField_a_of_type_Int + this.jdField_a_of_type_Float), 49);
            a(this.jdField_b_of_type_AndroidWidgetTextView, 1.0F, 1.0F, 0);
            localObject = this.jdField_a_of_type_AndroidWidgetTextView;
            f = this.jdField_b_of_type_Float;
            a((View)localObject, f, f, 4);
          }
          else
          {
            a(this.jdField_a_of_type_AndroidWidgetImageView, this.jdField_a_of_type_Int, 49);
            localObject = this.jdField_b_of_type_AndroidWidgetTextView;
            f = this.jdField_c_of_type_Float;
            a((View)localObject, f, f, 4);
            a(this.jdField_a_of_type_AndroidWidgetTextView, 1.0F, 1.0F, 0);
          }
        }
      }
      else
      {
        if (paramBoolean)
        {
          a(this.jdField_a_of_type_AndroidWidgetImageView, this.jdField_a_of_type_Int, 49);
          localObject = this.jdField_a_of_type_AndroidViewViewGroup;
          a((View)localObject, ((Integer)((ViewGroup)localObject).getTag(R.id.Y)).intValue());
          this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        }
        else
        {
          a(this.jdField_a_of_type_AndroidWidgetImageView, this.jdField_a_of_type_Int, 17);
          a(this.jdField_a_of_type_AndroidViewViewGroup, 0);
          this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
      }
    }
    else if (this.jdField_a_of_type_Boolean)
    {
      if (paramBoolean)
      {
        a(this.jdField_a_of_type_AndroidWidgetImageView, this.jdField_a_of_type_Int, 49);
        localObject = this.jdField_a_of_type_AndroidViewViewGroup;
        a((View)localObject, ((Integer)((ViewGroup)localObject).getTag(R.id.Y)).intValue());
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      else
      {
        a(this.jdField_a_of_type_AndroidWidgetImageView, this.jdField_a_of_type_Int, 17);
        a(this.jdField_a_of_type_AndroidViewViewGroup, 0);
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    }
    else
    {
      localObject = this.jdField_a_of_type_AndroidViewViewGroup;
      a((View)localObject, ((Integer)((ViewGroup)localObject).getTag(R.id.Y)).intValue());
      if (paramBoolean)
      {
        a(this.jdField_a_of_type_AndroidWidgetImageView, (int)(this.jdField_a_of_type_Int + this.jdField_a_of_type_Float), 49);
        a(this.jdField_b_of_type_AndroidWidgetTextView, 1.0F, 1.0F, 0);
        localObject = this.jdField_a_of_type_AndroidWidgetTextView;
        f = this.jdField_b_of_type_Float;
        a((View)localObject, f, f, 4);
      }
      else
      {
        a(this.jdField_a_of_type_AndroidWidgetImageView, this.jdField_a_of_type_Int, 49);
        localObject = this.jdField_b_of_type_AndroidWidgetTextView;
        f = this.jdField_c_of_type_Float;
        a((View)localObject, f, f, 4);
        a(this.jdField_a_of_type_AndroidWidgetTextView, 1.0F, 1.0F, 0);
      }
    }
    refreshDrawableState();
    setSelected(paramBoolean);
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    super.setEnabled(paramBoolean);
    this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(paramBoolean);
    this.jdField_b_of_type_AndroidWidgetTextView.setEnabled(paramBoolean);
    this.jdField_a_of_type_AndroidWidgetImageView.setEnabled(paramBoolean);
    if (paramBoolean)
    {
      ViewCompat.setPointerIcon(this, PointerIconCompat.getSystemIcon(getContext(), 1002));
      return;
    }
    ViewCompat.setPointerIcon(this, null);
  }
  
  public void setIcon(@Nullable Drawable paramDrawable)
  {
    if (paramDrawable == this.jdField_a_of_type_AndroidGraphicsDrawableDrawable) {
      return;
    }
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    Object localObject = paramDrawable;
    if (paramDrawable != null)
    {
      localObject = paramDrawable.getConstantState();
      if (localObject != null) {
        paramDrawable = ((Drawable.ConstantState)localObject).newDrawable();
      }
      paramDrawable = DrawableCompat.wrap(paramDrawable).mutate();
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
      ColorStateList localColorStateList = this.jdField_a_of_type_AndroidContentResColorStateList;
      localObject = paramDrawable;
      if (localColorStateList != null)
      {
        DrawableCompat.setTintList(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable, localColorStateList);
        localObject = paramDrawable;
      }
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
  }
  
  public void setIconSize(int paramInt)
  {
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
    localLayoutParams.width = paramInt;
    localLayoutParams.height = paramInt;
    this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
  }
  
  public void setIconTintList(ColorStateList paramColorStateList)
  {
    this.jdField_a_of_type_AndroidContentResColorStateList = paramColorStateList;
    if (this.jdField_a_of_type_AndroidxAppcompatViewMenuMenuItemImpl != null)
    {
      paramColorStateList = this.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
      if (paramColorStateList != null)
      {
        DrawableCompat.setTintList(paramColorStateList, this.jdField_a_of_type_AndroidContentResColorStateList);
        this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.invalidateSelf();
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
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void setLabelVisibilityMode(int paramInt)
  {
    if (this.jdField_b_of_type_Int != paramInt)
    {
      this.jdField_b_of_type_Int = paramInt;
      if (this.jdField_a_of_type_AndroidxAppcompatViewMenuMenuItemImpl != null) {
        paramInt = 1;
      } else {
        paramInt = 0;
      }
      if (paramInt != 0) {
        setChecked(this.jdField_a_of_type_AndroidxAppcompatViewMenuMenuItemImpl.isChecked());
      }
    }
  }
  
  public void setShifting(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean != paramBoolean)
    {
      this.jdField_a_of_type_Boolean = paramBoolean;
      int i;
      if (this.jdField_a_of_type_AndroidxAppcompatViewMenuMenuItemImpl != null) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {
        setChecked(this.jdField_a_of_type_AndroidxAppcompatViewMenuMenuItemImpl.isChecked());
      }
    }
  }
  
  public void setShortcut(boolean paramBoolean, char paramChar) {}
  
  public void setTextAppearanceActive(@StyleRes int paramInt)
  {
    TextViewCompat.setTextAppearance(this.jdField_b_of_type_AndroidWidgetTextView, paramInt);
    a(this.jdField_a_of_type_AndroidWidgetTextView.getTextSize(), this.jdField_b_of_type_AndroidWidgetTextView.getTextSize());
  }
  
  public void setTextAppearanceInactive(@StyleRes int paramInt)
  {
    TextViewCompat.setTextAppearance(this.jdField_a_of_type_AndroidWidgetTextView, paramInt);
    a(this.jdField_a_of_type_AndroidWidgetTextView.getTextSize(), this.jdField_b_of_type_AndroidWidgetTextView.getTextSize());
  }
  
  public void setTextColor(@Nullable ColorStateList paramColorStateList)
  {
    if (paramColorStateList != null)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramColorStateList);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramColorStateList);
    }
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramCharSequence);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(paramCharSequence);
    Object localObject = this.jdField_a_of_type_AndroidxAppcompatViewMenuMenuItemImpl;
    if ((localObject == null) || (TextUtils.isEmpty(((MenuItemImpl)localObject).getContentDescription()))) {
      setContentDescription(paramCharSequence);
    }
    MenuItemImpl localMenuItemImpl = this.jdField_a_of_type_AndroidxAppcompatViewMenuMenuItemImpl;
    localObject = paramCharSequence;
    if (localMenuItemImpl != null) {
      if (TextUtils.isEmpty(localMenuItemImpl.getTooltipText())) {
        localObject = paramCharSequence;
      } else {
        localObject = this.jdField_a_of_type_AndroidxAppcompatViewMenuMenuItemImpl.getTooltipText();
      }
    }
    TooltipCompat.setTooltipText(this, (CharSequence)localObject);
  }
  
  public boolean showsIcon()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.bottomnavigation.BottomNavigationItemView
 * JD-Core Version:    0.7.0.1
 */