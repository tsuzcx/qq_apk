package com.google.android.material.bottomnavigation;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.R.attr;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuView;
import androidx.core.util.Pools.Pool;
import androidx.core.util.Pools.SynchronizedPool;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat.CollectionInfoCompat;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.transition.AutoTransition;
import androidx.transition.TransitionManager;
import androidx.transition.TransitionSet;
import com.google.android.material.R.dimen;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.internal.TextScale;
import java.util.ArrayList;
import java.util.HashSet;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class BottomNavigationMenuView
  extends ViewGroup
  implements MenuView
{
  private static final int[] jdField_a_of_type_ArrayOfInt = { 16842912 };
  private static final int[] jdField_b_of_type_ArrayOfInt = { -16842910 };
  private final int jdField_a_of_type_Int;
  private ColorStateList jdField_a_of_type_AndroidContentResColorStateList;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  @NonNull
  private final SparseArray<View.OnTouchListener> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray(5);
  @NonNull
  private final View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private MenuBuilder jdField_a_of_type_AndroidxAppcompatViewMenuMenuBuilder;
  private final Pools.Pool<BottomNavigationItemView> jdField_a_of_type_AndroidxCoreUtilPools$Pool = new Pools.SynchronizedPool(5);
  @NonNull
  private final TransitionSet jdField_a_of_type_AndroidxTransitionTransitionSet;
  private BottomNavigationPresenter jdField_a_of_type_ComGoogleAndroidMaterialBottomnavigationBottomNavigationPresenter;
  private boolean jdField_a_of_type_Boolean;
  @Nullable
  private BottomNavigationItemView[] jdField_a_of_type_ArrayOfComGoogleAndroidMaterialBottomnavigationBottomNavigationItemView;
  private final int jdField_b_of_type_Int;
  private ColorStateList jdField_b_of_type_AndroidContentResColorStateList;
  @NonNull
  private SparseArray<BadgeDrawable> jdField_b_of_type_AndroidUtilSparseArray = new SparseArray(5);
  private final int jdField_c_of_type_Int;
  @Nullable
  private final ColorStateList jdField_c_of_type_AndroidContentResColorStateList;
  private int[] jdField_c_of_type_ArrayOfInt;
  private final int d;
  private final int e;
  private int f;
  private int g = 0;
  private int h = 0;
  @Dimension
  private int i;
  @StyleRes
  private int j;
  @StyleRes
  private int k;
  private int l;
  
  public BottomNavigationMenuView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public BottomNavigationMenuView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = getResources();
    this.jdField_a_of_type_Int = paramContext.getDimensionPixelSize(R.dimen.f);
    this.jdField_b_of_type_Int = paramContext.getDimensionPixelSize(R.dimen.g);
    this.jdField_c_of_type_Int = paramContext.getDimensionPixelSize(R.dimen.jdField_b_of_type_Int);
    this.d = paramContext.getDimensionPixelSize(R.dimen.jdField_c_of_type_Int);
    this.e = paramContext.getDimensionPixelSize(R.dimen.d);
    this.jdField_c_of_type_AndroidContentResColorStateList = a(16842808);
    this.jdField_a_of_type_AndroidxTransitionTransitionSet = new AutoTransition();
    this.jdField_a_of_type_AndroidxTransitionTransitionSet.setOrdering(0);
    this.jdField_a_of_type_AndroidxTransitionTransitionSet.setDuration(115L);
    this.jdField_a_of_type_AndroidxTransitionTransitionSet.setInterpolator(new FastOutSlowInInterpolator());
    this.jdField_a_of_type_AndroidxTransitionTransitionSet.addTransition(new TextScale());
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new BottomNavigationMenuView.1(this);
    this.jdField_c_of_type_ArrayOfInt = new int[5];
    ViewCompat.setImportantForAccessibility(this, 1);
  }
  
  private BottomNavigationItemView a()
  {
    BottomNavigationItemView localBottomNavigationItemView2 = (BottomNavigationItemView)this.jdField_a_of_type_AndroidxCoreUtilPools$Pool.acquire();
    BottomNavigationItemView localBottomNavigationItemView1 = localBottomNavigationItemView2;
    if (localBottomNavigationItemView2 == null) {
      localBottomNavigationItemView1 = new BottomNavigationItemView(getContext());
    }
    return localBottomNavigationItemView1;
  }
  
  private void a(@NonNull BottomNavigationItemView paramBottomNavigationItemView)
  {
    int m = paramBottomNavigationItemView.getId();
    if (!a(m)) {
      return;
    }
    BadgeDrawable localBadgeDrawable = (BadgeDrawable)this.jdField_b_of_type_AndroidUtilSparseArray.get(m);
    if (localBadgeDrawable != null) {
      paramBottomNavigationItemView.a(localBadgeDrawable);
    }
  }
  
  private boolean a(int paramInt)
  {
    return paramInt != -1;
  }
  
  private boolean a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == -1)
    {
      if (paramInt2 > 3) {
        return true;
      }
    }
    else if (paramInt1 == 0) {
      return true;
    }
    return false;
  }
  
  private void c()
  {
    HashSet localHashSet = new HashSet();
    int i1 = 0;
    int n = 0;
    int m;
    for (;;)
    {
      m = i1;
      if (n >= this.jdField_a_of_type_AndroidxAppcompatViewMenuMenuBuilder.size()) {
        break;
      }
      localHashSet.add(Integer.valueOf(this.jdField_a_of_type_AndroidxAppcompatViewMenuMenuBuilder.getItem(n).getItemId()));
      n += 1;
    }
    while (m < this.jdField_b_of_type_AndroidUtilSparseArray.size())
    {
      n = this.jdField_b_of_type_AndroidUtilSparseArray.keyAt(m);
      if (!localHashSet.contains(Integer.valueOf(n))) {
        this.jdField_b_of_type_AndroidUtilSparseArray.delete(n);
      }
      m += 1;
    }
  }
  
  public int a()
  {
    return this.f;
  }
  
  @Nullable
  public ColorStateList a(int paramInt)
  {
    Object localObject = new TypedValue();
    if (!getContext().getTheme().resolveAttribute(paramInt, (TypedValue)localObject, true)) {
      return null;
    }
    ColorStateList localColorStateList = AppCompatResources.getColorStateList(getContext(), ((TypedValue)localObject).resourceId);
    if (!getContext().getTheme().resolveAttribute(R.attr.colorPrimary, (TypedValue)localObject, true)) {
      return null;
    }
    paramInt = ((TypedValue)localObject).data;
    int m = localColorStateList.getDefaultColor();
    localObject = jdField_b_of_type_ArrayOfInt;
    int[] arrayOfInt1 = jdField_a_of_type_ArrayOfInt;
    int[] arrayOfInt2 = EMPTY_STATE_SET;
    int n = localColorStateList.getColorForState(jdField_b_of_type_ArrayOfInt, m);
    return new ColorStateList(new int[][] { localObject, arrayOfInt1, arrayOfInt2 }, new int[] { n, paramInt, m });
  }
  
  @Nullable
  public Drawable a()
  {
    BottomNavigationItemView[] arrayOfBottomNavigationItemView = this.jdField_a_of_type_ArrayOfComGoogleAndroidMaterialBottomnavigationBottomNavigationItemView;
    if ((arrayOfBottomNavigationItemView != null) && (arrayOfBottomNavigationItemView.length > 0)) {
      return arrayOfBottomNavigationItemView[0].getBackground();
    }
    return this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  }
  
  SparseArray<BadgeDrawable> a()
  {
    return this.jdField_b_of_type_AndroidUtilSparseArray;
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public void a()
  {
    removeAllViews();
    Object localObject1 = this.jdField_a_of_type_ArrayOfComGoogleAndroidMaterialBottomnavigationBottomNavigationItemView;
    int n;
    Object localObject2;
    if (localObject1 != null)
    {
      n = localObject1.length;
      m = 0;
      while (m < n)
      {
        localObject2 = localObject1[m];
        if (localObject2 != null)
        {
          this.jdField_a_of_type_AndroidxCoreUtilPools$Pool.release(localObject2);
          ((BottomNavigationItemView)localObject2).a();
        }
        m += 1;
      }
    }
    if (this.jdField_a_of_type_AndroidxAppcompatViewMenuMenuBuilder.size() == 0)
    {
      this.g = 0;
      this.h = 0;
      this.jdField_a_of_type_ArrayOfComGoogleAndroidMaterialBottomnavigationBottomNavigationItemView = null;
      return;
    }
    c();
    this.jdField_a_of_type_ArrayOfComGoogleAndroidMaterialBottomnavigationBottomNavigationItemView = new BottomNavigationItemView[this.jdField_a_of_type_AndroidxAppcompatViewMenuMenuBuilder.size()];
    boolean bool = a(this.f, this.jdField_a_of_type_AndroidxAppcompatViewMenuMenuBuilder.getVisibleItems().size());
    int m = 0;
    while (m < this.jdField_a_of_type_AndroidxAppcompatViewMenuMenuBuilder.size())
    {
      this.jdField_a_of_type_ComGoogleAndroidMaterialBottomnavigationBottomNavigationPresenter.a(true);
      this.jdField_a_of_type_AndroidxAppcompatViewMenuMenuBuilder.getItem(m).setCheckable(true);
      this.jdField_a_of_type_ComGoogleAndroidMaterialBottomnavigationBottomNavigationPresenter.a(false);
      localObject1 = a();
      this.jdField_a_of_type_ArrayOfComGoogleAndroidMaterialBottomnavigationBottomNavigationItemView[m] = localObject1;
      ((BottomNavigationItemView)localObject1).setIconTintList(this.jdField_a_of_type_AndroidContentResColorStateList);
      ((BottomNavigationItemView)localObject1).setIconSize(this.i);
      ((BottomNavigationItemView)localObject1).setTextColor(this.jdField_c_of_type_AndroidContentResColorStateList);
      ((BottomNavigationItemView)localObject1).setTextAppearanceInactive(this.j);
      ((BottomNavigationItemView)localObject1).setTextAppearanceActive(this.k);
      ((BottomNavigationItemView)localObject1).setTextColor(this.jdField_b_of_type_AndroidContentResColorStateList);
      localObject2 = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      if (localObject2 != null) {
        ((BottomNavigationItemView)localObject1).setItemBackground((Drawable)localObject2);
      } else {
        ((BottomNavigationItemView)localObject1).setItemBackground(this.l);
      }
      ((BottomNavigationItemView)localObject1).setShifting(bool);
      ((BottomNavigationItemView)localObject1).setLabelVisibilityMode(this.f);
      localObject2 = (MenuItemImpl)this.jdField_a_of_type_AndroidxAppcompatViewMenuMenuBuilder.getItem(m);
      ((BottomNavigationItemView)localObject1).initialize((MenuItemImpl)localObject2, 0);
      ((BottomNavigationItemView)localObject1).setItemPosition(m);
      n = ((MenuItemImpl)localObject2).getItemId();
      ((BottomNavigationItemView)localObject1).setOnTouchListener((View.OnTouchListener)this.jdField_a_of_type_AndroidUtilSparseArray.get(n));
      ((BottomNavigationItemView)localObject1).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      int i1 = this.g;
      if ((i1 != 0) && (n == i1)) {
        this.h = m;
      }
      a((BottomNavigationItemView)localObject1);
      addView((View)localObject1);
      m += 1;
    }
    this.h = Math.min(this.jdField_a_of_type_AndroidxAppcompatViewMenuMenuBuilder.size() - 1, this.h);
    this.jdField_a_of_type_AndroidxAppcompatViewMenuMenuBuilder.getItem(this.h).setChecked(true);
  }
  
  void a(int paramInt)
  {
    int n = this.jdField_a_of_type_AndroidxAppcompatViewMenuMenuBuilder.size();
    int m = 0;
    while (m < n)
    {
      MenuItem localMenuItem = this.jdField_a_of_type_AndroidxAppcompatViewMenuMenuBuilder.getItem(m);
      if (paramInt == localMenuItem.getItemId())
      {
        this.g = paramInt;
        this.h = m;
        localMenuItem.setChecked(true);
        return;
      }
      m += 1;
    }
  }
  
  void a(SparseArray<BadgeDrawable> paramSparseArray)
  {
    this.jdField_b_of_type_AndroidUtilSparseArray = paramSparseArray;
    BottomNavigationItemView[] arrayOfBottomNavigationItemView = this.jdField_a_of_type_ArrayOfComGoogleAndroidMaterialBottomnavigationBottomNavigationItemView;
    if (arrayOfBottomNavigationItemView != null)
    {
      int n = arrayOfBottomNavigationItemView.length;
      int m = 0;
      while (m < n)
      {
        BottomNavigationItemView localBottomNavigationItemView = arrayOfBottomNavigationItemView[m];
        localBottomNavigationItemView.a((BadgeDrawable)paramSparseArray.get(localBottomNavigationItemView.getId()));
        m += 1;
      }
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public int b()
  {
    return this.g;
  }
  
  public void b()
  {
    Object localObject = this.jdField_a_of_type_AndroidxAppcompatViewMenuMenuBuilder;
    if (localObject != null)
    {
      if (this.jdField_a_of_type_ArrayOfComGoogleAndroidMaterialBottomnavigationBottomNavigationItemView == null) {
        return;
      }
      int n = ((MenuBuilder)localObject).size();
      if (n != this.jdField_a_of_type_ArrayOfComGoogleAndroidMaterialBottomnavigationBottomNavigationItemView.length)
      {
        a();
        return;
      }
      int i1 = this.g;
      int m = 0;
      while (m < n)
      {
        localObject = this.jdField_a_of_type_AndroidxAppcompatViewMenuMenuBuilder.getItem(m);
        if (((MenuItem)localObject).isChecked())
        {
          this.g = ((MenuItem)localObject).getItemId();
          this.h = m;
        }
        m += 1;
      }
      if (i1 != this.g) {
        TransitionManager.beginDelayedTransition(this, this.jdField_a_of_type_AndroidxTransitionTransitionSet);
      }
      boolean bool = a(this.f, this.jdField_a_of_type_AndroidxAppcompatViewMenuMenuBuilder.getVisibleItems().size());
      m = 0;
      while (m < n)
      {
        this.jdField_a_of_type_ComGoogleAndroidMaterialBottomnavigationBottomNavigationPresenter.a(true);
        this.jdField_a_of_type_ArrayOfComGoogleAndroidMaterialBottomnavigationBottomNavigationItemView[m].setLabelVisibilityMode(this.f);
        this.jdField_a_of_type_ArrayOfComGoogleAndroidMaterialBottomnavigationBottomNavigationItemView[m].setShifting(bool);
        this.jdField_a_of_type_ArrayOfComGoogleAndroidMaterialBottomnavigationBottomNavigationItemView[m].initialize((MenuItemImpl)this.jdField_a_of_type_AndroidxAppcompatViewMenuMenuBuilder.getItem(m), 0);
        this.jdField_a_of_type_ComGoogleAndroidMaterialBottomnavigationBottomNavigationPresenter.a(false);
        m += 1;
      }
    }
  }
  
  public int getWindowAnimations()
  {
    return 0;
  }
  
  public void initialize(MenuBuilder paramMenuBuilder)
  {
    this.jdField_a_of_type_AndroidxAppcompatViewMenuMenuBuilder = paramMenuBuilder;
  }
  
  public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    AccessibilityNodeInfoCompat.wrap(paramAccessibilityNodeInfo).setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(1, this.jdField_a_of_type_AndroidxAppcompatViewMenuMenuBuilder.getVisibleItems().size(), false, 1));
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int m = getChildCount();
    int n = paramInt4 - paramInt2;
    paramInt2 = 0;
    paramInt4 = 0;
    while (paramInt2 < m)
    {
      View localView = getChildAt(paramInt2);
      if (localView.getVisibility() != 8)
      {
        if (ViewCompat.getLayoutDirection(this) == 1)
        {
          int i1 = paramInt3 - paramInt1 - paramInt4;
          localView.layout(i1 - localView.getMeasuredWidth(), 0, i1, n);
        }
        else
        {
          localView.layout(paramInt4, 0, localView.getMeasuredWidth() + paramInt4, n);
        }
        paramInt4 += localView.getMeasuredWidth();
      }
      paramInt2 += 1;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i1 = View.MeasureSpec.getSize(paramInt1);
    int m = this.jdField_a_of_type_AndroidxAppcompatViewMenuMenuBuilder.getVisibleItems().size();
    int i2 = getChildCount();
    int i3 = View.MeasureSpec.makeMeasureSpec(this.e, 1073741824);
    Object localObject;
    int n;
    if ((a(this.f, m)) && (this.jdField_a_of_type_Boolean))
    {
      localObject = getChildAt(this.h);
      paramInt2 = this.d;
      paramInt1 = paramInt2;
      if (((View)localObject).getVisibility() != 8)
      {
        ((View)localObject).measure(View.MeasureSpec.makeMeasureSpec(this.jdField_c_of_type_Int, -2147483648), i3);
        paramInt1 = Math.max(paramInt2, ((View)localObject).getMeasuredWidth());
      }
      if (((View)localObject).getVisibility() != 8) {
        paramInt2 = 1;
      } else {
        paramInt2 = 0;
      }
      paramInt2 = m - paramInt2;
      n = Math.min(i1 - this.jdField_b_of_type_Int * paramInt2, Math.min(paramInt1, this.jdField_c_of_type_Int));
      m = i1 - n;
      if (paramInt2 == 0) {
        paramInt1 = 1;
      } else {
        paramInt1 = paramInt2;
      }
      i1 = Math.min(m / paramInt1, this.jdField_a_of_type_Int);
      paramInt2 = m - paramInt2 * i1;
      paramInt1 = 0;
    }
    while (paramInt1 < i2)
    {
      if (getChildAt(paramInt1).getVisibility() != 8)
      {
        localObject = this.jdField_c_of_type_ArrayOfInt;
        if (paramInt1 == this.h) {
          m = n;
        } else {
          m = i1;
        }
        localObject[paramInt1] = m;
        m = paramInt2;
        if (paramInt2 > 0)
        {
          localObject = this.jdField_c_of_type_ArrayOfInt;
          localObject[paramInt1] += 1;
          m = paramInt2 - 1;
        }
      }
      else
      {
        this.jdField_c_of_type_ArrayOfInt[paramInt1] = 0;
        m = paramInt2;
      }
      paramInt1 += 1;
      paramInt2 = m;
      continue;
      if (m == 0) {
        paramInt1 = 1;
      } else {
        paramInt1 = m;
      }
      n = Math.min(i1 / paramInt1, this.jdField_c_of_type_Int);
      paramInt2 = i1 - m * n;
      paramInt1 = 0;
      while (paramInt1 < i2)
      {
        if (getChildAt(paramInt1).getVisibility() != 8)
        {
          localObject = this.jdField_c_of_type_ArrayOfInt;
          localObject[paramInt1] = n;
          m = paramInt2;
          if (paramInt2 > 0)
          {
            localObject[paramInt1] += 1;
            m = paramInt2 - 1;
          }
        }
        else
        {
          this.jdField_c_of_type_ArrayOfInt[paramInt1] = 0;
          m = paramInt2;
        }
        paramInt1 += 1;
        paramInt2 = m;
      }
    }
    paramInt1 = 0;
    paramInt2 = 0;
    while (paramInt1 < i2)
    {
      localObject = getChildAt(paramInt1);
      if (((View)localObject).getVisibility() != 8)
      {
        ((View)localObject).measure(View.MeasureSpec.makeMeasureSpec(this.jdField_c_of_type_ArrayOfInt[paramInt1], 1073741824), i3);
        ((View)localObject).getLayoutParams().width = ((View)localObject).getMeasuredWidth();
        paramInt2 += ((View)localObject).getMeasuredWidth();
      }
      paramInt1 += 1;
    }
    setMeasuredDimension(View.resolveSizeAndState(paramInt2, View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824), 0), View.resolveSizeAndState(this.e, i3, 0));
  }
  
  public void setIconTintList(ColorStateList paramColorStateList)
  {
    this.jdField_a_of_type_AndroidContentResColorStateList = paramColorStateList;
    BottomNavigationItemView[] arrayOfBottomNavigationItemView = this.jdField_a_of_type_ArrayOfComGoogleAndroidMaterialBottomnavigationBottomNavigationItemView;
    if (arrayOfBottomNavigationItemView != null)
    {
      int n = arrayOfBottomNavigationItemView.length;
      int m = 0;
      while (m < n)
      {
        arrayOfBottomNavigationItemView[m].setIconTintList(paramColorStateList);
        m += 1;
      }
    }
  }
  
  public void setItemBackground(@Nullable Drawable paramDrawable)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    BottomNavigationItemView[] arrayOfBottomNavigationItemView = this.jdField_a_of_type_ArrayOfComGoogleAndroidMaterialBottomnavigationBottomNavigationItemView;
    if (arrayOfBottomNavigationItemView != null)
    {
      int n = arrayOfBottomNavigationItemView.length;
      int m = 0;
      while (m < n)
      {
        arrayOfBottomNavigationItemView[m].setItemBackground(paramDrawable);
        m += 1;
      }
    }
  }
  
  public void setItemBackgroundRes(int paramInt)
  {
    this.l = paramInt;
    BottomNavigationItemView[] arrayOfBottomNavigationItemView = this.jdField_a_of_type_ArrayOfComGoogleAndroidMaterialBottomnavigationBottomNavigationItemView;
    if (arrayOfBottomNavigationItemView != null)
    {
      int n = arrayOfBottomNavigationItemView.length;
      int m = 0;
      while (m < n)
      {
        arrayOfBottomNavigationItemView[m].setItemBackground(paramInt);
        m += 1;
      }
    }
  }
  
  public void setItemHorizontalTranslationEnabled(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setItemIconSize(@Dimension int paramInt)
  {
    this.i = paramInt;
    BottomNavigationItemView[] arrayOfBottomNavigationItemView = this.jdField_a_of_type_ArrayOfComGoogleAndroidMaterialBottomnavigationBottomNavigationItemView;
    if (arrayOfBottomNavigationItemView != null)
    {
      int n = arrayOfBottomNavigationItemView.length;
      int m = 0;
      while (m < n)
      {
        arrayOfBottomNavigationItemView[m].setIconSize(paramInt);
        m += 1;
      }
    }
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public void setItemOnTouchListener(int paramInt, @Nullable View.OnTouchListener paramOnTouchListener)
  {
    if (paramOnTouchListener == null) {
      this.jdField_a_of_type_AndroidUtilSparseArray.remove(paramInt);
    } else {
      this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, paramOnTouchListener);
    }
    BottomNavigationItemView[] arrayOfBottomNavigationItemView = this.jdField_a_of_type_ArrayOfComGoogleAndroidMaterialBottomnavigationBottomNavigationItemView;
    if (arrayOfBottomNavigationItemView != null)
    {
      int n = arrayOfBottomNavigationItemView.length;
      int m = 0;
      while (m < n)
      {
        BottomNavigationItemView localBottomNavigationItemView = arrayOfBottomNavigationItemView[m];
        if (localBottomNavigationItemView.getItemData().getItemId() == paramInt) {
          localBottomNavigationItemView.setOnTouchListener(paramOnTouchListener);
        }
        m += 1;
      }
    }
  }
  
  public void setItemTextAppearanceActive(@StyleRes int paramInt)
  {
    this.k = paramInt;
    BottomNavigationItemView[] arrayOfBottomNavigationItemView = this.jdField_a_of_type_ArrayOfComGoogleAndroidMaterialBottomnavigationBottomNavigationItemView;
    if (arrayOfBottomNavigationItemView != null)
    {
      int n = arrayOfBottomNavigationItemView.length;
      int m = 0;
      while (m < n)
      {
        BottomNavigationItemView localBottomNavigationItemView = arrayOfBottomNavigationItemView[m];
        localBottomNavigationItemView.setTextAppearanceActive(paramInt);
        ColorStateList localColorStateList = this.jdField_b_of_type_AndroidContentResColorStateList;
        if (localColorStateList != null) {
          localBottomNavigationItemView.setTextColor(localColorStateList);
        }
        m += 1;
      }
    }
  }
  
  public void setItemTextAppearanceInactive(@StyleRes int paramInt)
  {
    this.j = paramInt;
    BottomNavigationItemView[] arrayOfBottomNavigationItemView = this.jdField_a_of_type_ArrayOfComGoogleAndroidMaterialBottomnavigationBottomNavigationItemView;
    if (arrayOfBottomNavigationItemView != null)
    {
      int n = arrayOfBottomNavigationItemView.length;
      int m = 0;
      while (m < n)
      {
        BottomNavigationItemView localBottomNavigationItemView = arrayOfBottomNavigationItemView[m];
        localBottomNavigationItemView.setTextAppearanceInactive(paramInt);
        ColorStateList localColorStateList = this.jdField_b_of_type_AndroidContentResColorStateList;
        if (localColorStateList != null) {
          localBottomNavigationItemView.setTextColor(localColorStateList);
        }
        m += 1;
      }
    }
  }
  
  public void setItemTextColor(ColorStateList paramColorStateList)
  {
    this.jdField_b_of_type_AndroidContentResColorStateList = paramColorStateList;
    BottomNavigationItemView[] arrayOfBottomNavigationItemView = this.jdField_a_of_type_ArrayOfComGoogleAndroidMaterialBottomnavigationBottomNavigationItemView;
    if (arrayOfBottomNavigationItemView != null)
    {
      int n = arrayOfBottomNavigationItemView.length;
      int m = 0;
      while (m < n)
      {
        arrayOfBottomNavigationItemView[m].setTextColor(paramColorStateList);
        m += 1;
      }
    }
  }
  
  public void setLabelVisibilityMode(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void setPresenter(BottomNavigationPresenter paramBottomNavigationPresenter)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialBottomnavigationBottomNavigationPresenter = paramBottomNavigationPresenter;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.bottomnavigation.BottomNavigationMenuView
 * JD-Core Version:    0.7.0.1
 */