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
  private static final String a = "MaterialButtonToggleGroup";
  private static final int b = R.style.F;
  private final List<MaterialButtonToggleGroup.CornerData> c = new ArrayList();
  private final MaterialButtonToggleGroup.CheckedStateTracker d = new MaterialButtonToggleGroup.CheckedStateTracker(this, null);
  private final MaterialButtonToggleGroup.PressedStateTracker e = new MaterialButtonToggleGroup.PressedStateTracker(this, null);
  private final LinkedHashSet<MaterialButtonToggleGroup.OnButtonCheckedListener> f = new LinkedHashSet();
  private final Comparator<MaterialButton> g = new MaterialButtonToggleGroup.1(this);
  private Integer[] h;
  private boolean i = false;
  private boolean j;
  private boolean k;
  @IdRes
  private int l;
  
  public MaterialButtonToggleGroup(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public MaterialButtonToggleGroup(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.D);
  }
  
  public MaterialButtonToggleGroup(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(MaterialThemeOverlay.a(paramContext, paramAttributeSet, paramInt, b), paramAttributeSet, paramInt);
    paramContext = ThemeEnforcement.a(getContext(), paramAttributeSet, R.styleable.dX, paramInt, b, new int[0]);
    setSingleSelection(paramContext.getBoolean(R.styleable.ea, false));
    this.l = paramContext.getResourceId(R.styleable.dY, -1);
    this.k = paramContext.getBoolean(R.styleable.dZ, false);
    setChildrenDrawingOrderEnabled(true);
    paramContext.recycle();
    ViewCompat.setImportantForAccessibility(this, 1);
  }
  
  private int a(@Nullable View paramView)
  {
    if (!(paramView instanceof MaterialButton)) {
      return -1;
    }
    int m = 0;
    int i1;
    for (int n = 0; m < getChildCount(); n = i1)
    {
      if (getChildAt(m) == paramView) {
        return n;
      }
      i1 = n;
      if ((getChildAt(m) instanceof MaterialButton))
      {
        i1 = n;
        if (d(m)) {
          i1 = n + 1;
        }
      }
      m += 1;
    }
    return -1;
  }
  
  @Nullable
  private MaterialButtonToggleGroup.CornerData a(int paramInt1, int paramInt2, int paramInt3)
  {
    MaterialButtonToggleGroup.CornerData localCornerData = (MaterialButtonToggleGroup.CornerData)this.c.get(paramInt1);
    if (paramInt2 == paramInt3) {
      return localCornerData;
    }
    int m;
    if (getOrientation() == 0) {
      m = 1;
    } else {
      m = 0;
    }
    if (paramInt1 == paramInt2)
    {
      if (m != 0) {
        return MaterialButtonToggleGroup.CornerData.a(localCornerData, this);
      }
      return MaterialButtonToggleGroup.CornerData.c(localCornerData);
    }
    if (paramInt1 == paramInt3)
    {
      if (m != 0) {
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
      this.i = true;
      ((MaterialButton)localView).setChecked(paramBoolean);
      this.i = false;
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
  
  @NonNull
  private LinearLayout.LayoutParams b(@NonNull View paramView)
  {
    paramView = paramView.getLayoutParams();
    if ((paramView instanceof LinearLayout.LayoutParams)) {
      return (LinearLayout.LayoutParams)paramView;
    }
    return new LinearLayout.LayoutParams(paramView.width, paramView.height);
  }
  
  private MaterialButton b(int paramInt)
  {
    return (MaterialButton)getChildAt(paramInt);
  }
  
  private boolean b(int paramInt, boolean paramBoolean)
  {
    Object localObject = getCheckedButtonIds();
    if ((this.k) && (((List)localObject).isEmpty()))
    {
      a(paramInt, true);
      this.l = paramInt;
      return false;
    }
    if ((paramBoolean) && (this.j))
    {
      ((List)localObject).remove(Integer.valueOf(paramInt));
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        paramInt = ((Integer)((Iterator)localObject).next()).intValue();
        a(paramInt, false);
        c(paramInt, false);
      }
    }
    return true;
  }
  
  private void c(int paramInt)
  {
    if (getChildCount() != 0)
    {
      if (paramInt == -1) {
        return;
      }
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)b(paramInt).getLayoutParams();
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
  
  private void c(@IdRes int paramInt, boolean paramBoolean)
  {
    Iterator localIterator = this.f.iterator();
    while (localIterator.hasNext()) {
      ((MaterialButtonToggleGroup.OnButtonCheckedListener)localIterator.next()).a(this, paramInt, paramBoolean);
    }
  }
  
  private void d()
  {
    int n = getFirstVisibleChildIndex();
    if (n == -1) {
      return;
    }
    int m = n + 1;
    while (m < getChildCount())
    {
      MaterialButton localMaterialButton = b(m);
      Object localObject = b(m - 1);
      int i1 = Math.min(localMaterialButton.getStrokeWidth(), ((MaterialButton)localObject).getStrokeWidth());
      localObject = b(localMaterialButton);
      if (getOrientation() == 0)
      {
        MarginLayoutParamsCompat.setMarginEnd((ViewGroup.MarginLayoutParams)localObject, 0);
        MarginLayoutParamsCompat.setMarginStart((ViewGroup.MarginLayoutParams)localObject, -i1);
        ((LinearLayout.LayoutParams)localObject).topMargin = 0;
      }
      else
      {
        ((LinearLayout.LayoutParams)localObject).bottomMargin = 0;
        ((LinearLayout.LayoutParams)localObject).topMargin = (-i1);
        MarginLayoutParamsCompat.setMarginStart((ViewGroup.MarginLayoutParams)localObject, 0);
      }
      localMaterialButton.setLayoutParams((ViewGroup.LayoutParams)localObject);
      m += 1;
    }
    c(n);
  }
  
  private boolean d(int paramInt)
  {
    return getChildAt(paramInt).getVisibility() != 8;
  }
  
  private void e()
  {
    TreeMap localTreeMap = new TreeMap(this.g);
    int n = getChildCount();
    int m = 0;
    while (m < n)
    {
      localTreeMap.put(b(m), Integer.valueOf(m));
      m += 1;
    }
    this.h = ((Integer[])localTreeMap.values().toArray(new Integer[0]));
  }
  
  private void e(int paramInt)
  {
    a(paramInt, true);
    b(paramInt, true);
    setCheckedId(paramInt);
  }
  
  private int getFirstVisibleChildIndex()
  {
    int n = getChildCount();
    int m = 0;
    while (m < n)
    {
      if (d(m)) {
        return m;
      }
      m += 1;
    }
    return -1;
  }
  
  private int getLastVisibleChildIndex()
  {
    int m = getChildCount() - 1;
    while (m >= 0)
    {
      if (d(m)) {
        return m;
      }
      m -= 1;
    }
    return -1;
  }
  
  private int getVisibleButtonCount()
  {
    int m = 0;
    int i1;
    for (int n = 0; m < getChildCount(); n = i1)
    {
      i1 = n;
      if ((getChildAt(m) instanceof MaterialButton))
      {
        i1 = n;
        if (d(m)) {
          i1 = n + 1;
        }
      }
      m += 1;
    }
    return n;
  }
  
  private void setCheckedId(int paramInt)
  {
    this.l = paramInt;
    c(paramInt, true);
  }
  
  private void setGeneratedIdIfNeeded(@NonNull MaterialButton paramMaterialButton)
  {
    if (paramMaterialButton.getId() == -1) {
      paramMaterialButton.setId(ViewCompat.generateViewId());
    }
  }
  
  private void setupButtonChild(@NonNull MaterialButton paramMaterialButton)
  {
    paramMaterialButton.setMaxLines(1);
    paramMaterialButton.setEllipsize(TextUtils.TruncateAt.END);
    paramMaterialButton.setCheckable(true);
    paramMaterialButton.a(this.d);
    paramMaterialButton.setOnPressedChangeListenerInternal(this.e);
    paramMaterialButton.setShouldDrawSurfaceColorStroke(true);
  }
  
  public void a()
  {
    this.i = true;
    int m = 0;
    while (m < getChildCount())
    {
      MaterialButton localMaterialButton = b(m);
      localMaterialButton.setChecked(false);
      c(localMaterialButton.getId(), false);
      m += 1;
    }
    this.i = false;
    setCheckedId(-1);
  }
  
  public void a(@IdRes int paramInt)
  {
    if (paramInt == this.l) {
      return;
    }
    e(paramInt);
  }
  
  public void a(@NonNull MaterialButtonToggleGroup.OnButtonCheckedListener paramOnButtonCheckedListener)
  {
    this.f.add(paramOnButtonCheckedListener);
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    if (!(paramView instanceof MaterialButton))
    {
      Log.e(a, "Child views must be of type MaterialButton.");
      return;
    }
    super.addView(paramView, paramInt, paramLayoutParams);
    paramView = (MaterialButton)paramView;
    setGeneratedIdIfNeeded(paramView);
    setupButtonChild(paramView);
    if (paramView.isChecked())
    {
      b(paramView.getId(), true);
      setCheckedId(paramView.getId());
    }
    paramLayoutParams = paramView.getShapeAppearanceModel();
    this.c.add(new MaterialButtonToggleGroup.CornerData(paramLayoutParams.f(), paramLayoutParams.i(), paramLayoutParams.g(), paramLayoutParams.h()));
    ViewCompat.setAccessibilityDelegate(paramView, new MaterialButtonToggleGroup.2(this));
  }
  
  public boolean b()
  {
    return this.j;
  }
  
  @VisibleForTesting
  void c()
  {
    int n = getChildCount();
    int i1 = getFirstVisibleChildIndex();
    int i2 = getLastVisibleChildIndex();
    int m = 0;
    while (m < n)
    {
      MaterialButton localMaterialButton = b(m);
      if (localMaterialButton.getVisibility() != 8)
      {
        ShapeAppearanceModel.Builder localBuilder = localMaterialButton.getShapeAppearanceModel().n();
        a(localBuilder, a(m, i1, i2));
        localMaterialButton.setShapeAppearanceModel(localBuilder.a());
      }
      m += 1;
    }
  }
  
  protected void dispatchDraw(@NonNull Canvas paramCanvas)
  {
    e();
    super.dispatchDraw(paramCanvas);
  }
  
  @NonNull
  public CharSequence getAccessibilityClassName()
  {
    return MaterialButtonToggleGroup.class.getName();
  }
  
  @IdRes
  public int getCheckedButtonId()
  {
    if (this.j) {
      return this.l;
    }
    return -1;
  }
  
  @NonNull
  public List<Integer> getCheckedButtonIds()
  {
    ArrayList localArrayList = new ArrayList();
    int m = 0;
    while (m < getChildCount())
    {
      MaterialButton localMaterialButton = b(m);
      if (localMaterialButton.isChecked()) {
        localArrayList.add(Integer.valueOf(localMaterialButton.getId()));
      }
      m += 1;
    }
    return localArrayList;
  }
  
  protected int getChildDrawingOrder(int paramInt1, int paramInt2)
  {
    Integer[] arrayOfInteger = this.h;
    if ((arrayOfInteger != null) && (paramInt2 < arrayOfInteger.length)) {
      return arrayOfInteger[paramInt2].intValue();
    }
    Log.w(a, "Child order wasn't updated");
    return paramInt2;
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    int m = this.l;
    if (m != -1) {
      e(m);
    }
  }
  
  public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    paramAccessibilityNodeInfo = AccessibilityNodeInfoCompat.wrap(paramAccessibilityNodeInfo);
    int n = getVisibleButtonCount();
    int m;
    if (b()) {
      m = 1;
    } else {
      m = 2;
    }
    paramAccessibilityNodeInfo.setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(1, n, false, m));
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    c();
    d();
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void setSelectionRequired(boolean paramBoolean)
  {
    this.k = paramBoolean;
  }
  
  public void setSingleSelection(@BoolRes int paramInt)
  {
    setSingleSelection(getResources().getBoolean(paramInt));
  }
  
  public void setSingleSelection(boolean paramBoolean)
  {
    if (this.j != paramBoolean)
    {
      this.j = paramBoolean;
      a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.button.MaterialButtonToggleGroup
 * JD-Core Version:    0.7.0.1
 */