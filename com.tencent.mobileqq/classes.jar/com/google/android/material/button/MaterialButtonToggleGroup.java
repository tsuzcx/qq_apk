package com.google.android.material.button;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import androidx.annotation.BoolRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat.CollectionInfoCompat;
import com.google.android.material.R.attr;
import com.google.android.material.R.style;
import com.google.android.material.R.styleable;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.ShapeAppearanceModel.Builder;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

public class MaterialButtonToggleGroup
  extends LinearLayout
{
  private static final int jdField_a_of_type_Int = R.style.D;
  private static final String jdField_a_of_type_JavaLangString = "MaterialButtonToggleGroup";
  private final MaterialButtonToggleGroup.CheckedStateTracker jdField_a_of_type_ComGoogleAndroidMaterialButtonMaterialButtonToggleGroup$CheckedStateTracker = new MaterialButtonToggleGroup.CheckedStateTracker(this, null);
  private final MaterialButtonToggleGroup.PressedStateTracker jdField_a_of_type_ComGoogleAndroidMaterialButtonMaterialButtonToggleGroup$PressedStateTracker = new MaterialButtonToggleGroup.PressedStateTracker(this, null);
  private final Comparator<MaterialButton> jdField_a_of_type_JavaUtilComparator = new MaterialButtonToggleGroup.1(this);
  private final LinkedHashSet<MaterialButtonToggleGroup.OnButtonCheckedListener> jdField_a_of_type_JavaUtilLinkedHashSet = new LinkedHashSet();
  private final List<MaterialButtonToggleGroup.CornerData> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean = false;
  private Integer[] jdField_a_of_type_ArrayOfJavaLangInteger;
  @IdRes
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  
  public MaterialButtonToggleGroup(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public MaterialButtonToggleGroup(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.w);
  }
  
  public MaterialButtonToggleGroup(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(MaterialThemeOverlay.a(paramContext, paramAttributeSet, paramInt, jdField_a_of_type_Int), paramAttributeSet, paramInt);
    paramContext = ThemeEnforcement.a(getContext(), paramAttributeSet, R.styleable.Q, paramInt, jdField_a_of_type_Int, new int[0]);
    setSingleSelection(paramContext.getBoolean(R.styleable.cC, false));
    this.jdField_b_of_type_Int = paramContext.getResourceId(R.styleable.cA, -1);
    this.c = paramContext.getBoolean(R.styleable.cB, false);
    setChildrenDrawingOrderEnabled(true);
    paramContext.recycle();
    ViewCompat.setImportantForAccessibility(this, 1);
  }
  
  private int a()
  {
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      if (a(i)) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  private int a(@Nullable View paramView)
  {
    if (!(paramView instanceof MaterialButton)) {
      return -1;
    }
    int i = 0;
    int k;
    for (int j = 0; i < getChildCount(); j = k)
    {
      if (getChildAt(i) == paramView) {
        return j;
      }
      k = j;
      if ((getChildAt(i) instanceof MaterialButton))
      {
        k = j;
        if (a(i)) {
          k = j + 1;
        }
      }
      i += 1;
    }
    return -1;
  }
  
  @NonNull
  private LinearLayout.LayoutParams a(@NonNull View paramView)
  {
    paramView = paramView.getLayoutParams();
    if ((paramView instanceof LinearLayout.LayoutParams)) {
      return (LinearLayout.LayoutParams)paramView;
    }
    return new LinearLayout.LayoutParams(paramView.width, paramView.height);
  }
  
  private MaterialButton a(int paramInt)
  {
    return (MaterialButton)getChildAt(paramInt);
  }
  
  @Nullable
  private MaterialButtonToggleGroup.CornerData a(int paramInt1, int paramInt2, int paramInt3)
  {
    MaterialButtonToggleGroup.CornerData localCornerData = (MaterialButtonToggleGroup.CornerData)this.jdField_a_of_type_JavaUtilList.get(paramInt1);
    if (paramInt2 == paramInt3) {
      return localCornerData;
    }
    int i;
    if (getOrientation() == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (paramInt1 == paramInt2)
    {
      if (i != 0) {
        return MaterialButtonToggleGroup.CornerData.a(localCornerData, this);
      }
      return MaterialButtonToggleGroup.CornerData.c(localCornerData);
    }
    if (paramInt1 == paramInt3)
    {
      if (i != 0) {
        return MaterialButtonToggleGroup.CornerData.b(localCornerData, this);
      }
      return MaterialButtonToggleGroup.CornerData.d(localCornerData);
    }
    return null;
  }
  
  private void a(@IdRes int paramInt, boolean paramBoolean)
  {
    View localView = findViewById(paramInt);
    if ((localView instanceof MaterialButton))
    {
      this.jdField_a_of_type_Boolean = true;
      ((MaterialButton)localView).setChecked(paramBoolean);
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  private void a(@NonNull MaterialButton paramMaterialButton)
  {
    if (paramMaterialButton.getId() == -1) {
      paramMaterialButton.setId(ViewCompat.generateViewId());
    }
  }
  
  private static void a(ShapeAppearanceModel.Builder paramBuilder, @Nullable MaterialButtonToggleGroup.CornerData paramCornerData)
  {
    if (paramCornerData == null)
    {
      paramBuilder.a(0.0F);
      return;
    }
    paramBuilder.b(paramCornerData.a).e(paramCornerData.d).c(paramCornerData.b).d(paramCornerData.c);
  }
  
  private boolean a(int paramInt)
  {
    return getChildAt(paramInt).getVisibility() != 8;
  }
  
  private boolean a(int paramInt, boolean paramBoolean)
  {
    Object localObject = a();
    if ((this.c) && (((List)localObject).isEmpty()))
    {
      a(paramInt, true);
      this.jdField_b_of_type_Int = paramInt;
      return false;
    }
    if ((paramBoolean) && (this.jdField_b_of_type_Boolean))
    {
      ((List)localObject).remove(Integer.valueOf(paramInt));
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        paramInt = ((Integer)((Iterator)localObject).next()).intValue();
        a(paramInt, false);
        b(paramInt, false);
      }
    }
    return true;
  }
  
  private int b()
  {
    int i = getChildCount() - 1;
    while (i >= 0)
    {
      if (a(i)) {
        return i;
      }
      i -= 1;
    }
    return -1;
  }
  
  private void b(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    b(paramInt, true);
  }
  
  private void b(@IdRes int paramInt, boolean paramBoolean)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedHashSet.iterator();
    while (localIterator.hasNext()) {
      ((MaterialButtonToggleGroup.OnButtonCheckedListener)localIterator.next()).a(this, paramInt, paramBoolean);
    }
  }
  
  private void b(@NonNull MaterialButton paramMaterialButton)
  {
    paramMaterialButton.setMaxLines(1);
    paramMaterialButton.setEllipsize(TextUtils.TruncateAt.END);
    paramMaterialButton.setCheckable(true);
    paramMaterialButton.a(this.jdField_a_of_type_ComGoogleAndroidMaterialButtonMaterialButtonToggleGroup$CheckedStateTracker);
    paramMaterialButton.a(this.jdField_a_of_type_ComGoogleAndroidMaterialButtonMaterialButtonToggleGroup$PressedStateTracker);
    paramMaterialButton.a(true);
  }
  
  private int c()
  {
    int i = 0;
    int k;
    for (int j = 0; i < getChildCount(); j = k)
    {
      k = j;
      if ((getChildAt(i) instanceof MaterialButton))
      {
        k = j;
        if (a(i)) {
          k = j + 1;
        }
      }
      i += 1;
    }
    return j;
  }
  
  private void c()
  {
    int j = a();
    if (j == -1) {
      return;
    }
    int i = j + 1;
    while (i < getChildCount())
    {
      MaterialButton localMaterialButton = a(i);
      Object localObject = a(i - 1);
      int k = Math.min(localMaterialButton.b(), ((MaterialButton)localObject).b());
      localObject = a(localMaterialButton);
      if (getOrientation() == 0)
      {
        MarginLayoutParamsCompat.setMarginEnd((ViewGroup.MarginLayoutParams)localObject, 0);
        MarginLayoutParamsCompat.setMarginStart((ViewGroup.MarginLayoutParams)localObject, -k);
        ((LinearLayout.LayoutParams)localObject).topMargin = 0;
      }
      else
      {
        ((LinearLayout.LayoutParams)localObject).bottomMargin = 0;
        ((LinearLayout.LayoutParams)localObject).topMargin = (-k);
        MarginLayoutParamsCompat.setMarginStart((ViewGroup.MarginLayoutParams)localObject, 0);
      }
      localMaterialButton.setLayoutParams((ViewGroup.LayoutParams)localObject);
      i += 1;
    }
    c(j);
  }
  
  private void c(int paramInt)
  {
    if (getChildCount() != 0)
    {
      if (paramInt == -1) {
        return;
      }
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)a(paramInt).getLayoutParams();
      if (getOrientation() == 1)
      {
        localLayoutParams.topMargin = 0;
        localLayoutParams.bottomMargin = 0;
        return;
      }
      MarginLayoutParamsCompat.setMarginEnd(localLayoutParams, 0);
      MarginLayoutParamsCompat.setMarginStart(localLayoutParams, 0);
      localLayoutParams.leftMargin = 0;
      localLayoutParams.rightMargin = 0;
    }
  }
  
  private void d()
  {
    TreeMap localTreeMap = new TreeMap(this.jdField_a_of_type_JavaUtilComparator);
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      localTreeMap.put(a(i), Integer.valueOf(i));
      i += 1;
    }
    this.jdField_a_of_type_ArrayOfJavaLangInteger = ((Integer[])localTreeMap.values().toArray(new Integer[0]));
  }
  
  private void d(int paramInt)
  {
    a(paramInt, true);
    a(paramInt, true);
    b(paramInt);
  }
  
  @NonNull
  public List<Integer> a()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < getChildCount())
    {
      MaterialButton localMaterialButton = a(i);
      if (localMaterialButton.isChecked()) {
        localArrayList.add(Integer.valueOf(localMaterialButton.getId()));
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
    int i = 0;
    while (i < getChildCount())
    {
      MaterialButton localMaterialButton = a(i);
      localMaterialButton.setChecked(false);
      b(localMaterialButton.getId(), false);
      i += 1;
    }
    this.jdField_a_of_type_Boolean = false;
    b(-1);
  }
  
  public void a(@IdRes int paramInt)
  {
    if (paramInt == this.jdField_b_of_type_Int) {
      return;
    }
    d(paramInt);
  }
  
  public void a(@NonNull MaterialButtonToggleGroup.OnButtonCheckedListener paramOnButtonCheckedListener)
  {
    this.jdField_a_of_type_JavaUtilLinkedHashSet.add(paramOnButtonCheckedListener);
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    if (!(paramView instanceof MaterialButton))
    {
      Log.e(jdField_a_of_type_JavaLangString, "Child views must be of type MaterialButton.");
      return;
    }
    super.addView(paramView, paramInt, paramLayoutParams);
    paramView = (MaterialButton)paramView;
    a(paramView);
    b(paramView);
    if (paramView.isChecked())
    {
      a(paramView.getId(), true);
      b(paramView.getId());
    }
    paramLayoutParams = paramView.a();
    this.jdField_a_of_type_JavaUtilList.add(new MaterialButtonToggleGroup.CornerData(paramLayoutParams.a(), paramLayoutParams.d(), paramLayoutParams.b(), paramLayoutParams.c()));
    ViewCompat.setAccessibilityDelegate(paramView, new MaterialButtonToggleGroup.2(this));
  }
  
  @VisibleForTesting
  void b()
  {
    int j = getChildCount();
    int k = a();
    int m = b();
    int i = 0;
    while (i < j)
    {
      MaterialButton localMaterialButton = a(i);
      if (localMaterialButton.getVisibility() != 8)
      {
        ShapeAppearanceModel.Builder localBuilder = localMaterialButton.a().b();
        a(localBuilder, a(i, k, m));
        localMaterialButton.setShapeAppearanceModel(localBuilder.a());
      }
      i += 1;
    }
  }
  
  protected void dispatchDraw(@NonNull Canvas paramCanvas)
  {
    d();
    super.dispatchDraw(paramCanvas);
  }
  
  @NonNull
  public CharSequence getAccessibilityClassName()
  {
    return MaterialButtonToggleGroup.class.getName();
  }
  
  protected int getChildDrawingOrder(int paramInt1, int paramInt2)
  {
    Integer[] arrayOfInteger = this.jdField_a_of_type_ArrayOfJavaLangInteger;
    if ((arrayOfInteger != null) && (paramInt2 < arrayOfInteger.length)) {
      return arrayOfInteger[paramInt2].intValue();
    }
    Log.w(jdField_a_of_type_JavaLangString, "Child order wasn't updated");
    return paramInt2;
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    int i = this.jdField_b_of_type_Int;
    if (i != -1) {
      d(i);
    }
  }
  
  public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    paramAccessibilityNodeInfo = AccessibilityNodeInfoCompat.wrap(paramAccessibilityNodeInfo);
    int j = c();
    int i;
    if (a()) {
      i = 1;
    } else {
      i = 2;
    }
    paramAccessibilityNodeInfo.setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(1, j, false, i));
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    b();
    c();
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void setSelectionRequired(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public void setSingleSelection(@BoolRes int paramInt)
  {
    setSingleSelection(getResources().getBoolean(paramInt));
  }
  
  public void setSingleSelection(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_Boolean != paramBoolean)
    {
      this.jdField_b_of_type_Boolean = paramBoolean;
      a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.button.MaterialButtonToggleGroup
 * JD-Core Version:    0.7.0.1
 */