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
  private static final int a = R.style.x;
  @Dimension
  private int b;
  @Dimension
  private int c;
  private boolean d;
  private boolean e;
  @Nullable
  private ChipGroup.OnCheckedChangeListener f;
  private final ChipGroup.CheckedStateTracker g = new ChipGroup.CheckedStateTracker(this, null);
  @NonNull
  private ChipGroup.PassThroughHierarchyChangeListener h = new ChipGroup.PassThroughHierarchyChangeListener(this, null);
  @IdRes
  private int i = -1;
  private boolean j = false;
  
  public ChipGroup(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ChipGroup(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.j);
  }
  
  public ChipGroup(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(MaterialThemeOverlay.a(paramContext, paramAttributeSet, paramInt, a), paramAttributeSet, paramInt);
    paramContext = ThemeEnforcement.a(getContext(), paramAttributeSet, R.styleable.by, paramInt, a, new int[0]);
    paramInt = paramContext.getDimensionPixelOffset(R.styleable.bA, 0);
    setChipSpacingHorizontal(paramContext.getDimensionPixelOffset(R.styleable.bB, paramInt));
    setChipSpacingVertical(paramContext.getDimensionPixelOffset(R.styleable.bC, paramInt));
    setSingleLine(paramContext.getBoolean(R.styleable.bE, false));
    setSingleSelection(paramContext.getBoolean(R.styleable.bF, false));
    setSelectionRequired(paramContext.getBoolean(R.styleable.bD, false));
    paramInt = paramContext.getResourceId(R.styleable.bz, -1);
    if (paramInt != -1) {
      this.i = paramInt;
    }
    paramContext.recycle();
    super.setOnHierarchyChangeListener(this.h);
    ViewCompat.setImportantForAccessibility(this, 1);
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    this.i = paramInt;
    ChipGroup.OnCheckedChangeListener localOnCheckedChangeListener = this.f;
    if ((localOnCheckedChangeListener != null) && (this.d) && (paramBoolean)) {
      localOnCheckedChangeListener.a(this, paramInt);
    }
  }
  
  private void b(@IdRes int paramInt, boolean paramBoolean)
  {
    View localView = findViewById(paramInt);
    if ((localView instanceof Chip))
    {
      this.j = true;
      ((Chip)localView).setChecked(paramBoolean);
      this.j = false;
    }
  }
  
  private int getChipCount()
  {
    int k = 0;
    int n;
    for (int m = 0; k < getChildCount(); m = n)
    {
      n = m;
      if ((getChildAt(k) instanceof Chip)) {
        n = m + 1;
      }
      k += 1;
    }
    return m;
  }
  
  private void setCheckedId(int paramInt)
  {
    a(paramInt, true);
  }
  
  int a(@Nullable View paramView)
  {
    if (!(paramView instanceof Chip)) {
      return -1;
    }
    int k = 0;
    int n;
    for (int m = 0; k < getChildCount(); m = n)
    {
      n = m;
      if ((getChildAt(k) instanceof Chip))
      {
        if ((Chip)getChildAt(k) == paramView) {
          return m;
        }
        n = m + 1;
      }
      k += 1;
    }
    return -1;
  }
  
  public void a()
  {
    this.j = true;
    int k = 0;
    while (k < getChildCount())
    {
      View localView = getChildAt(k);
      if ((localView instanceof Chip)) {
        ((Chip)localView).setChecked(false);
      }
      k += 1;
    }
    this.j = false;
    setCheckedId(-1);
  }
  
  public void a(@IdRes int paramInt)
  {
    int k = this.i;
    if (paramInt == k) {
      return;
    }
    if ((k != -1) && (this.d)) {
      b(k, false);
    }
    if (paramInt != -1) {
      b(paramInt, true);
    }
    setCheckedId(paramInt);
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramView instanceof Chip))
    {
      Chip localChip = (Chip)paramView;
      if (localChip.isChecked())
      {
        int k = this.i;
        if ((k != -1) && (this.d)) {
          b(k, false);
        }
        setCheckedId(localChip.getId());
      }
    }
    super.addView(paramView, paramInt, paramLayoutParams);
  }
  
  public boolean b()
  {
    return super.b();
  }
  
  public boolean c()
  {
    return this.d;
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
  
  @IdRes
  public int getCheckedChipId()
  {
    if (this.d) {
      return this.i;
    }
    return -1;
  }
  
  @NonNull
  public List<Integer> getCheckedChipIds()
  {
    ArrayList localArrayList = new ArrayList();
    int k = 0;
    while (k < getChildCount())
    {
      View localView = getChildAt(k);
      if (((localView instanceof Chip)) && (((Chip)localView).isChecked()))
      {
        localArrayList.add(Integer.valueOf(localView.getId()));
        if (this.d) {
          return localArrayList;
        }
      }
      k += 1;
    }
    return localArrayList;
  }
  
  @Dimension
  public int getChipSpacingHorizontal()
  {
    return this.b;
  }
  
  @Dimension
  public int getChipSpacingVertical()
  {
    return this.c;
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    int k = this.i;
    if (k != -1)
    {
      b(k, true);
      setCheckedId(this.i);
    }
  }
  
  public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    paramAccessibilityNodeInfo = AccessibilityNodeInfoCompat.wrap(paramAccessibilityNodeInfo);
    int k;
    if (b()) {
      k = getChipCount();
    } else {
      k = -1;
    }
    int n = getRowCount();
    int m;
    if (c()) {
      m = 1;
    } else {
      m = 2;
    }
    paramAccessibilityNodeInfo.setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(n, k, false, m));
  }
  
  public void setChipSpacing(@Dimension int paramInt)
  {
    setChipSpacingHorizontal(paramInt);
    setChipSpacingVertical(paramInt);
  }
  
  public void setChipSpacingHorizontal(@Dimension int paramInt)
  {
    if (this.b != paramInt)
    {
      this.b = paramInt;
      setItemSpacing(paramInt);
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
    if (this.c != paramInt)
    {
      this.c = paramInt;
      setLineSpacing(paramInt);
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
    this.f = paramOnCheckedChangeListener;
  }
  
  public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener paramOnHierarchyChangeListener)
  {
    ChipGroup.PassThroughHierarchyChangeListener.a(this.h, paramOnHierarchyChangeListener);
  }
  
  public void setSelectionRequired(boolean paramBoolean)
  {
    this.e = paramBoolean;
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
    if (this.d != paramBoolean)
    {
      this.d = paramBoolean;
      a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.chip.ChipGroup
 * JD-Core Version:    0.7.0.1
 */