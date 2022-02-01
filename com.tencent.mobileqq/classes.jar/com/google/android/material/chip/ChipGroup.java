package com.google.android.material.chip;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.OnHierarchyChangeListener;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.BoolRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat.CollectionInfoCompat;
import com.google.android.material.R.attr;
import com.google.android.material.R.style;
import com.google.android.material.R.styleable;
import com.google.android.material.internal.FlowLayout;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.util.ArrayList;
import java.util.List;

public class ChipGroup
  extends FlowLayout
{
  private static final int jdField_a_of_type_Int = R.style.v;
  private final ChipGroup.CheckedStateTracker jdField_a_of_type_ComGoogleAndroidMaterialChipChipGroup$CheckedStateTracker = new ChipGroup.CheckedStateTracker(this, null);
  @Nullable
  private ChipGroup.OnCheckedChangeListener jdField_a_of_type_ComGoogleAndroidMaterialChipChipGroup$OnCheckedChangeListener;
  @NonNull
  private ChipGroup.PassThroughHierarchyChangeListener jdField_a_of_type_ComGoogleAndroidMaterialChipChipGroup$PassThroughHierarchyChangeListener = new ChipGroup.PassThroughHierarchyChangeListener(this, null);
  private boolean jdField_a_of_type_Boolean;
  @Dimension
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  @Dimension
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean = false;
  @IdRes
  private int d = -1;
  
  public ChipGroup(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ChipGroup(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.g);
  }
  
  public ChipGroup(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(MaterialThemeOverlay.a(paramContext, paramAttributeSet, paramInt, jdField_a_of_type_Int), paramAttributeSet, paramInt);
    paramContext = ThemeEnforcement.a(getContext(), paramAttributeSet, R.styleable.k, paramInt, jdField_a_of_type_Int, new int[0]);
    paramInt = paramContext.getDimensionPixelOffset(R.styleable.aS, 0);
    setChipSpacingHorizontal(paramContext.getDimensionPixelOffset(R.styleable.aT, paramInt));
    setChipSpacingVertical(paramContext.getDimensionPixelOffset(R.styleable.aU, paramInt));
    setSingleLine(paramContext.getBoolean(R.styleable.aW, false));
    setSingleSelection(paramContext.getBoolean(R.styleable.aX, false));
    setSelectionRequired(paramContext.getBoolean(R.styleable.aV, false));
    paramInt = paramContext.getResourceId(R.styleable.aR, -1);
    if (paramInt != -1) {
      this.d = paramInt;
    }
    paramContext.recycle();
    super.setOnHierarchyChangeListener(this.jdField_a_of_type_ComGoogleAndroidMaterialChipChipGroup$PassThroughHierarchyChangeListener);
    ViewCompat.setImportantForAccessibility(this, 1);
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    this.d = paramInt;
    ChipGroup.OnCheckedChangeListener localOnCheckedChangeListener = this.jdField_a_of_type_ComGoogleAndroidMaterialChipChipGroup$OnCheckedChangeListener;
    if ((localOnCheckedChangeListener != null) && (this.jdField_a_of_type_Boolean) && (paramBoolean)) {
      localOnCheckedChangeListener.a(this, paramInt);
    }
  }
  
  private int b()
  {
    int i = 0;
    int k;
    for (int j = 0; i < getChildCount(); j = k)
    {
      k = j;
      if ((getChildAt(i) instanceof Chip)) {
        k = j + 1;
      }
      i += 1;
    }
    return j;
  }
  
  private void b(@IdRes int paramInt, boolean paramBoolean)
  {
    View localView = findViewById(paramInt);
    if ((localView instanceof Chip))
    {
      this.jdField_c_of_type_Boolean = true;
      ((Chip)localView).setChecked(paramBoolean);
      this.jdField_c_of_type_Boolean = false;
    }
  }
  
  private void d(int paramInt)
  {
    a(paramInt, true);
  }
  
  int a(@Nullable View paramView)
  {
    if (!(paramView instanceof Chip)) {
      return -1;
    }
    int i = 0;
    int k;
    for (int j = 0; i < getChildCount(); j = k)
    {
      k = j;
      if ((getChildAt(i) instanceof Chip))
      {
        if ((Chip)getChildAt(i) == paramView) {
          return j;
        }
        k = j + 1;
      }
      i += 1;
    }
    return -1;
  }
  
  @NonNull
  public List<Integer> a()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < getChildCount())
    {
      View localView = getChildAt(i);
      if (((localView instanceof Chip)) && (((Chip)localView).isChecked()))
      {
        localArrayList.add(Integer.valueOf(localView.getId()));
        if (this.jdField_a_of_type_Boolean) {
          return localArrayList;
        }
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public void a()
  {
    this.jdField_c_of_type_Boolean = true;
    int i = 0;
    while (i < getChildCount())
    {
      View localView = getChildAt(i);
      if ((localView instanceof Chip)) {
        ((Chip)localView).setChecked(false);
      }
      i += 1;
    }
    this.jdField_c_of_type_Boolean = false;
    d(-1);
  }
  
  public void a(@IdRes int paramInt)
  {
    int i = this.d;
    if (paramInt == i) {
      return;
    }
    if ((i != -1) && (this.jdField_a_of_type_Boolean)) {
      b(i, false);
    }
    if (paramInt != -1) {
      b(paramInt, true);
    }
    d(paramInt);
  }
  
  public boolean a()
  {
    return super.a();
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramView instanceof Chip))
    {
      Chip localChip = (Chip)paramView;
      if (localChip.isChecked())
      {
        int i = this.d;
        if ((i != -1) && (this.jdField_a_of_type_Boolean)) {
          b(i, false);
        }
        d(localChip.getId());
      }
    }
    super.addView(paramView, paramInt, paramLayoutParams);
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return (super.checkLayoutParams(paramLayoutParams)) && ((paramLayoutParams instanceof ChipGroup.LayoutParams));
  }
  
  @NonNull
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new ChipGroup.LayoutParams(-2, -2);
  }
  
  @NonNull
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new ChipGroup.LayoutParams(getContext(), paramAttributeSet);
  }
  
  @NonNull
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return new ChipGroup.LayoutParams(paramLayoutParams);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    int i = this.d;
    if (i != -1)
    {
      b(i, true);
      d(this.d);
    }
  }
  
  public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    paramAccessibilityNodeInfo = AccessibilityNodeInfoCompat.wrap(paramAccessibilityNodeInfo);
    int i;
    if (a()) {
      i = b();
    } else {
      i = -1;
    }
    int k = a();
    int j;
    if (b()) {
      j = 1;
    } else {
      j = 2;
    }
    paramAccessibilityNodeInfo.setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(k, i, false, j));
  }
  
  public void setChipSpacing(@Dimension int paramInt)
  {
    setChipSpacingHorizontal(paramInt);
    setChipSpacingVertical(paramInt);
  }
  
  public void setChipSpacingHorizontal(@Dimension int paramInt)
  {
    if (this.jdField_b_of_type_Int != paramInt)
    {
      this.jdField_b_of_type_Int = paramInt;
      c(paramInt);
      requestLayout();
    }
  }
  
  public void setChipSpacingHorizontalResource(@DimenRes int paramInt)
  {
    setChipSpacingHorizontal(getResources().getDimensionPixelOffset(paramInt));
  }
  
  public void setChipSpacingResource(@DimenRes int paramInt)
  {
    setChipSpacing(getResources().getDimensionPixelOffset(paramInt));
  }
  
  public void setChipSpacingVertical(@Dimension int paramInt)
  {
    if (this.jdField_c_of_type_Int != paramInt)
    {
      this.jdField_c_of_type_Int = paramInt;
      b(paramInt);
      requestLayout();
    }
  }
  
  public void setChipSpacingVerticalResource(@DimenRes int paramInt)
  {
    setChipSpacingVertical(getResources().getDimensionPixelOffset(paramInt));
  }
  
  @Deprecated
  public void setDividerDrawableHorizontal(Drawable paramDrawable)
  {
    throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
  }
  
  @Deprecated
  public void setDividerDrawableVertical(@Nullable Drawable paramDrawable)
  {
    throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
  }
  
  @Deprecated
  public void setFlexWrap(int paramInt)
  {
    throw new UnsupportedOperationException("Changing flex wrap not allowed. ChipGroup exposes a singleLine attribute instead.");
  }
  
  public void setOnCheckedChangeListener(ChipGroup.OnCheckedChangeListener paramOnCheckedChangeListener)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialChipChipGroup$OnCheckedChangeListener = paramOnCheckedChangeListener;
  }
  
  public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener paramOnHierarchyChangeListener)
  {
    ChipGroup.PassThroughHierarchyChangeListener.a(this.jdField_a_of_type_ComGoogleAndroidMaterialChipChipGroup$PassThroughHierarchyChangeListener, paramOnHierarchyChangeListener);
  }
  
  public void setSelectionRequired(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  @Deprecated
  public void setShowDividerHorizontal(int paramInt)
  {
    throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
  }
  
  @Deprecated
  public void setShowDividerVertical(int paramInt)
  {
    throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
  }
  
  public void setSingleLine(@BoolRes int paramInt)
  {
    setSingleLine(getResources().getBoolean(paramInt));
  }
  
  public void setSingleLine(boolean paramBoolean)
  {
    super.setSingleLine(paramBoolean);
  }
  
  public void setSingleSelection(@BoolRes int paramInt)
  {
    setSingleSelection(getResources().getBoolean(paramInt));
  }
  
  public void setSingleSelection(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean != paramBoolean)
    {
      this.jdField_a_of_type_Boolean = paramBoolean;
      a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.chip.ChipGroup
 * JD-Core Version:    0.7.0.1
 */