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
  private static final int[] a = { 16842912 };
  private static final int[] b = { -16842910 };
  private BottomNavigationPresenter A;
  private MenuBuilder B;
  @NonNull
  private final TransitionSet c;
  private final int d;
  private final int e;
  private final int f;
  private final int g;
  private final int h;
  @NonNull
  private final View.OnClickListener i;
  private final Pools.Pool<BottomNavigationItemView> j = new Pools.SynchronizedPool(5);
  @NonNull
  private final SparseArray<View.OnTouchListener> k = new SparseArray(5);
  private boolean l;
  private int m;
  @Nullable
  private BottomNavigationItemView[] n;
  private int o = 0;
  private int p = 0;
  private ColorStateList q;
  @Dimension
  private int r;
  private ColorStateList s;
  @Nullable
  private final ColorStateList t;
  @StyleRes
  private int u;
  @StyleRes
  private int v;
  private Drawable w;
  private int x;
  private int[] y;
  @NonNull
  private SparseArray<BadgeDrawable> z = new SparseArray(5);
  
  public BottomNavigationMenuView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public BottomNavigationMenuView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = getResources();
    this.d = paramContext.getDimensionPixelSize(R.dimen.f);
    this.e = paramContext.getDimensionPixelSize(R.dimen.g);
    this.f = paramContext.getDimensionPixelSize(R.dimen.b);
    this.g = paramContext.getDimensionPixelSize(R.dimen.c);
    this.h = paramContext.getDimensionPixelSize(R.dimen.d);
    this.t = a(16842808);
    this.c = new AutoTransition();
    this.c.setOrdering(0);
    this.c.setDuration(115L);
    this.c.setInterpolator(new FastOutSlowInInterpolator());
    this.c.addTransition(new TextScale());
    this.i = new BottomNavigationMenuView.1(this);
    this.y = new int[5];
    ViewCompat.setImportantForAccessibility(this, 1);
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
  
  private boolean c(int paramInt)
  {
    return paramInt != -1;
  }
  
  private void d()
  {
    HashSet localHashSet = new HashSet();
    int i3 = 0;
    int i2 = 0;
    int i1;
    for (;;)
    {
      i1 = i3;
      if (i2 >= this.B.size()) {
        break;
      }
      localHashSet.add(Integer.valueOf(this.B.getItem(i2).getItemId()));
      i2 += 1;
    }
    while (i1 < this.z.size())
    {
      i2 = this.z.keyAt(i1);
      if (!localHashSet.contains(Integer.valueOf(i2))) {
        this.z.delete(i2);
      }
      i1 += 1;
    }
  }
  
  private BottomNavigationItemView getNewItem()
  {
    BottomNavigationItemView localBottomNavigationItemView2 = (BottomNavigationItemView)this.j.acquire();
    BottomNavigationItemView localBottomNavigationItemView1 = localBottomNavigationItemView2;
    if (localBottomNavigationItemView2 == null) {
      localBottomNavigationItemView1 = new BottomNavigationItemView(getContext());
    }
    return localBottomNavigationItemView1;
  }
  
  private void setBadgeIfNeeded(@NonNull BottomNavigationItemView paramBottomNavigationItemView)
  {
    int i1 = paramBottomNavigationItemView.getId();
    if (!c(i1)) {
      return;
    }
    BadgeDrawable localBadgeDrawable = (BadgeDrawable)this.z.get(i1);
    if (localBadgeDrawable != null) {
      paramBottomNavigationItemView.setBadge(localBadgeDrawable);
    }
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
    int i1 = localColorStateList.getDefaultColor();
    localObject = b;
    int[] arrayOfInt1 = a;
    int[] arrayOfInt2 = EMPTY_STATE_SET;
    int i2 = localColorStateList.getColorForState(b, i1);
    return new ColorStateList(new int[][] { localObject, arrayOfInt1, arrayOfInt2 }, new int[] { i2, paramInt, i1 });
  }
  
  public boolean a()
  {
    return this.l;
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public void b()
  {
    removeAllViews();
    Object localObject1 = this.n;
    int i2;
    Object localObject2;
    if (localObject1 != null)
    {
      i2 = localObject1.length;
      i1 = 0;
      while (i1 < i2)
      {
        localObject2 = localObject1[i1];
        if (localObject2 != null)
        {
          this.j.release(localObject2);
          ((BottomNavigationItemView)localObject2).a();
        }
        i1 += 1;
      }
    }
    if (this.B.size() == 0)
    {
      this.o = 0;
      this.p = 0;
      this.n = null;
      return;
    }
    d();
    this.n = new BottomNavigationItemView[this.B.size()];
    boolean bool = a(this.m, this.B.getVisibleItems().size());
    int i1 = 0;
    while (i1 < this.B.size())
    {
      this.A.a(true);
      this.B.getItem(i1).setCheckable(true);
      this.A.a(false);
      localObject1 = getNewItem();
      this.n[i1] = localObject1;
      ((BottomNavigationItemView)localObject1).setIconTintList(this.q);
      ((BottomNavigationItemView)localObject1).setIconSize(this.r);
      ((BottomNavigationItemView)localObject1).setTextColor(this.t);
      ((BottomNavigationItemView)localObject1).setTextAppearanceInactive(this.u);
      ((BottomNavigationItemView)localObject1).setTextAppearanceActive(this.v);
      ((BottomNavigationItemView)localObject1).setTextColor(this.s);
      localObject2 = this.w;
      if (localObject2 != null) {
        ((BottomNavigationItemView)localObject1).setItemBackground((Drawable)localObject2);
      } else {
        ((BottomNavigationItemView)localObject1).setItemBackground(this.x);
      }
      ((BottomNavigationItemView)localObject1).setShifting(bool);
      ((BottomNavigationItemView)localObject1).setLabelVisibilityMode(this.m);
      localObject2 = (MenuItemImpl)this.B.getItem(i1);
      ((BottomNavigationItemView)localObject1).initialize((MenuItemImpl)localObject2, 0);
      ((BottomNavigationItemView)localObject1).setItemPosition(i1);
      i2 = ((MenuItemImpl)localObject2).getItemId();
      ((BottomNavigationItemView)localObject1).setOnTouchListener((View.OnTouchListener)this.k.get(i2));
      ((BottomNavigationItemView)localObject1).setOnClickListener(this.i);
      int i3 = this.o;
      if ((i3 != 0) && (i2 == i3)) {
        this.p = i1;
      }
      setBadgeIfNeeded((BottomNavigationItemView)localObject1);
      addView((View)localObject1);
      i1 += 1;
    }
    this.p = Math.min(this.B.size() - 1, this.p);
    this.B.getItem(this.p).setChecked(true);
  }
  
  void b(int paramInt)
  {
    int i2 = this.B.size();
    int i1 = 0;
    while (i1 < i2)
    {
      MenuItem localMenuItem = this.B.getItem(i1);
      if (paramInt == localMenuItem.getItemId())
      {
        this.o = paramInt;
        this.p = i1;
        localMenuItem.setChecked(true);
        return;
      }
      i1 += 1;
    }
  }
  
  public void c()
  {
    Object localObject = this.B;
    if (localObject != null)
    {
      if (this.n == null) {
        return;
      }
      int i2 = ((MenuBuilder)localObject).size();
      if (i2 != this.n.length)
      {
        b();
        return;
      }
      int i3 = this.o;
      int i1 = 0;
      while (i1 < i2)
      {
        localObject = this.B.getItem(i1);
        if (((MenuItem)localObject).isChecked())
        {
          this.o = ((MenuItem)localObject).getItemId();
          this.p = i1;
        }
        i1 += 1;
      }
      if (i3 != this.o) {
        TransitionManager.beginDelayedTransition(this, this.c);
      }
      boolean bool = a(this.m, this.B.getVisibleItems().size());
      i1 = 0;
      while (i1 < i2)
      {
        this.A.a(true);
        this.n[i1].setLabelVisibilityMode(this.m);
        this.n[i1].setShifting(bool);
        this.n[i1].initialize((MenuItemImpl)this.B.getItem(i1), 0);
        this.A.a(false);
        i1 += 1;
      }
    }
  }
  
  SparseArray<BadgeDrawable> getBadgeDrawables()
  {
    return this.z;
  }
  
  @Nullable
  public ColorStateList getIconTintList()
  {
    return this.q;
  }
  
  @Nullable
  public Drawable getItemBackground()
  {
    BottomNavigationItemView[] arrayOfBottomNavigationItemView = this.n;
    if ((arrayOfBottomNavigationItemView != null) && (arrayOfBottomNavigationItemView.length > 0)) {
      return arrayOfBottomNavigationItemView[0].getBackground();
    }
    return this.w;
  }
  
  @Deprecated
  public int getItemBackgroundRes()
  {
    return this.x;
  }
  
  @Dimension
  public int getItemIconSize()
  {
    return this.r;
  }
  
  @StyleRes
  public int getItemTextAppearanceActive()
  {
    return this.v;
  }
  
  @StyleRes
  public int getItemTextAppearanceInactive()
  {
    return this.u;
  }
  
  public ColorStateList getItemTextColor()
  {
    return this.s;
  }
  
  public int getLabelVisibilityMode()
  {
    return this.m;
  }
  
  public int getSelectedItemId()
  {
    return this.o;
  }
  
  public int getWindowAnimations()
  {
    return 0;
  }
  
  public void initialize(MenuBuilder paramMenuBuilder)
  {
    this.B = paramMenuBuilder;
  }
  
  public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    AccessibilityNodeInfoCompat.wrap(paramAccessibilityNodeInfo).setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(1, this.B.getVisibleItems().size(), false, 1));
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i1 = getChildCount();
    int i2 = paramInt4 - paramInt2;
    paramInt2 = 0;
    paramInt4 = 0;
    while (paramInt2 < i1)
    {
      View localView = getChildAt(paramInt2);
      if (localView.getVisibility() != 8)
      {
        if (ViewCompat.getLayoutDirection(this) == 1)
        {
          int i3 = paramInt3 - paramInt1 - paramInt4;
          localView.layout(i3 - localView.getMeasuredWidth(), 0, i3, i2);
        }
        else
        {
          localView.layout(paramInt4, 0, localView.getMeasuredWidth() + paramInt4, i2);
        }
        paramInt4 += localView.getMeasuredWidth();
      }
      paramInt2 += 1;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i3 = View.MeasureSpec.getSize(paramInt1);
    int i1 = this.B.getVisibleItems().size();
    int i4 = getChildCount();
    int i5 = View.MeasureSpec.makeMeasureSpec(this.h, 1073741824);
    Object localObject;
    int i2;
    if ((a(this.m, i1)) && (this.l))
    {
      localObject = getChildAt(this.p);
      paramInt2 = this.g;
      paramInt1 = paramInt2;
      if (((View)localObject).getVisibility() != 8)
      {
        ((View)localObject).measure(View.MeasureSpec.makeMeasureSpec(this.f, -2147483648), i5);
        paramInt1 = Math.max(paramInt2, ((View)localObject).getMeasuredWidth());
      }
      if (((View)localObject).getVisibility() != 8) {
        paramInt2 = 1;
      } else {
        paramInt2 = 0;
      }
      paramInt2 = i1 - paramInt2;
      i2 = Math.min(i3 - this.e * paramInt2, Math.min(paramInt1, this.f));
      i1 = i3 - i2;
      if (paramInt2 == 0) {
        paramInt1 = 1;
      } else {
        paramInt1 = paramInt2;
      }
      i3 = Math.min(i1 / paramInt1, this.d);
      paramInt2 = i1 - paramInt2 * i3;
      paramInt1 = 0;
    }
    while (paramInt1 < i4)
    {
      if (getChildAt(paramInt1).getVisibility() != 8)
      {
        localObject = this.y;
        if (paramInt1 == this.p) {
          i1 = i2;
        } else {
          i1 = i3;
        }
        localObject[paramInt1] = i1;
        i1 = paramInt2;
        if (paramInt2 > 0)
        {
          localObject = this.y;
          localObject[paramInt1] += 1;
          i1 = paramInt2 - 1;
        }
      }
      else
      {
        this.y[paramInt1] = 0;
        i1 = paramInt2;
      }
      paramInt1 += 1;
      paramInt2 = i1;
      continue;
      if (i1 == 0) {
        paramInt1 = 1;
      } else {
        paramInt1 = i1;
      }
      i2 = Math.min(i3 / paramInt1, this.f);
      paramInt2 = i3 - i1 * i2;
      paramInt1 = 0;
      while (paramInt1 < i4)
      {
        if (getChildAt(paramInt1).getVisibility() != 8)
        {
          localObject = this.y;
          localObject[paramInt1] = i2;
          i1 = paramInt2;
          if (paramInt2 > 0)
          {
            localObject[paramInt1] += 1;
            i1 = paramInt2 - 1;
          }
        }
        else
        {
          this.y[paramInt1] = 0;
          i1 = paramInt2;
        }
        paramInt1 += 1;
        paramInt2 = i1;
      }
    }
    paramInt1 = 0;
    paramInt2 = 0;
    while (paramInt1 < i4)
    {
      localObject = getChildAt(paramInt1);
      if (((View)localObject).getVisibility() != 8)
      {
        ((View)localObject).measure(View.MeasureSpec.makeMeasureSpec(this.y[paramInt1], 1073741824), i5);
        ((View)localObject).getLayoutParams().width = ((View)localObject).getMeasuredWidth();
        paramInt2 += ((View)localObject).getMeasuredWidth();
      }
      paramInt1 += 1;
    }
    setMeasuredDimension(View.resolveSizeAndState(paramInt2, View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824), 0), View.resolveSizeAndState(this.h, i5, 0));
  }
  
  void setBadgeDrawables(SparseArray<BadgeDrawable> paramSparseArray)
  {
    this.z = paramSparseArray;
    BottomNavigationItemView[] arrayOfBottomNavigationItemView = this.n;
    if (arrayOfBottomNavigationItemView != null)
    {
      int i2 = arrayOfBottomNavigationItemView.length;
      int i1 = 0;
      while (i1 < i2)
      {
        BottomNavigationItemView localBottomNavigationItemView = arrayOfBottomNavigationItemView[i1];
        localBottomNavigationItemView.setBadge((BadgeDrawable)paramSparseArray.get(localBottomNavigationItemView.getId()));
        i1 += 1;
      }
    }
  }
  
  public void setIconTintList(ColorStateList paramColorStateList)
  {
    this.q = paramColorStateList;
    BottomNavigationItemView[] arrayOfBottomNavigationItemView = this.n;
    if (arrayOfBottomNavigationItemView != null)
    {
      int i2 = arrayOfBottomNavigationItemView.length;
      int i1 = 0;
      while (i1 < i2)
      {
        arrayOfBottomNavigationItemView[i1].setIconTintList(paramColorStateList);
        i1 += 1;
      }
    }
  }
  
  public void setItemBackground(@Nullable Drawable paramDrawable)
  {
    this.w = paramDrawable;
    BottomNavigationItemView[] arrayOfBottomNavigationItemView = this.n;
    if (arrayOfBottomNavigationItemView != null)
    {
      int i2 = arrayOfBottomNavigationItemView.length;
      int i1 = 0;
      while (i1 < i2)
      {
        arrayOfBottomNavigationItemView[i1].setItemBackground(paramDrawable);
        i1 += 1;
      }
    }
  }
  
  public void setItemBackgroundRes(int paramInt)
  {
    this.x = paramInt;
    BottomNavigationItemView[] arrayOfBottomNavigationItemView = this.n;
    if (arrayOfBottomNavigationItemView != null)
    {
      int i2 = arrayOfBottomNavigationItemView.length;
      int i1 = 0;
      while (i1 < i2)
      {
        arrayOfBottomNavigationItemView[i1].setItemBackground(paramInt);
        i1 += 1;
      }
    }
  }
  
  public void setItemHorizontalTranslationEnabled(boolean paramBoolean)
  {
    this.l = paramBoolean;
  }
  
  public void setItemIconSize(@Dimension int paramInt)
  {
    this.r = paramInt;
    BottomNavigationItemView[] arrayOfBottomNavigationItemView = this.n;
    if (arrayOfBottomNavigationItemView != null)
    {
      int i2 = arrayOfBottomNavigationItemView.length;
      int i1 = 0;
      while (i1 < i2)
      {
        arrayOfBottomNavigationItemView[i1].setIconSize(paramInt);
        i1 += 1;
      }
    }
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public void setItemOnTouchListener(int paramInt, @Nullable View.OnTouchListener paramOnTouchListener)
  {
    if (paramOnTouchListener == null) {
      this.k.remove(paramInt);
    } else {
      this.k.put(paramInt, paramOnTouchListener);
    }
    BottomNavigationItemView[] arrayOfBottomNavigationItemView = this.n;
    if (arrayOfBottomNavigationItemView != null)
    {
      int i2 = arrayOfBottomNavigationItemView.length;
      int i1 = 0;
      while (i1 < i2)
      {
        BottomNavigationItemView localBottomNavigationItemView = arrayOfBottomNavigationItemView[i1];
        if (localBottomNavigationItemView.getItemData().getItemId() == paramInt) {
          localBottomNavigationItemView.setOnTouchListener(paramOnTouchListener);
        }
        i1 += 1;
      }
    }
  }
  
  public void setItemTextAppearanceActive(@StyleRes int paramInt)
  {
    this.v = paramInt;
    BottomNavigationItemView[] arrayOfBottomNavigationItemView = this.n;
    if (arrayOfBottomNavigationItemView != null)
    {
      int i2 = arrayOfBottomNavigationItemView.length;
      int i1 = 0;
      while (i1 < i2)
      {
        BottomNavigationItemView localBottomNavigationItemView = arrayOfBottomNavigationItemView[i1];
        localBottomNavigationItemView.setTextAppearanceActive(paramInt);
        ColorStateList localColorStateList = this.s;
        if (localColorStateList != null) {
          localBottomNavigationItemView.setTextColor(localColorStateList);
        }
        i1 += 1;
      }
    }
  }
  
  public void setItemTextAppearanceInactive(@StyleRes int paramInt)
  {
    this.u = paramInt;
    BottomNavigationItemView[] arrayOfBottomNavigationItemView = this.n;
    if (arrayOfBottomNavigationItemView != null)
    {
      int i2 = arrayOfBottomNavigationItemView.length;
      int i1 = 0;
      while (i1 < i2)
      {
        BottomNavigationItemView localBottomNavigationItemView = arrayOfBottomNavigationItemView[i1];
        localBottomNavigationItemView.setTextAppearanceInactive(paramInt);
        ColorStateList localColorStateList = this.s;
        if (localColorStateList != null) {
          localBottomNavigationItemView.setTextColor(localColorStateList);
        }
        i1 += 1;
      }
    }
  }
  
  public void setItemTextColor(ColorStateList paramColorStateList)
  {
    this.s = paramColorStateList;
    BottomNavigationItemView[] arrayOfBottomNavigationItemView = this.n;
    if (arrayOfBottomNavigationItemView != null)
    {
      int i2 = arrayOfBottomNavigationItemView.length;
      int i1 = 0;
      while (i1 < i2)
      {
        arrayOfBottomNavigationItemView[i1].setTextColor(paramColorStateList);
        i1 += 1;
      }
    }
  }
  
  public void setLabelVisibilityMode(int paramInt)
  {
    this.m = paramInt;
  }
  
  public void setPresenter(BottomNavigationPresenter paramBottomNavigationPresenter)
  {
    this.A = paramBottomNavigationPresenter;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.bottomnavigation.BottomNavigationMenuView
 * JD-Core Version:    0.7.0.1
 */