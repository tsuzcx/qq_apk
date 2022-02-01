package com.google.android.material.tabs;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout.LayoutParams;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout.LayoutParams;
import androidx.annotation.BoolRes;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.util.Pools.Pool;
import androidx.core.util.Pools.SimplePool;
import androidx.core.util.Pools.SynchronizedPool;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat.CollectionInfoCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager.DecorView;
import androidx.viewpager.widget.ViewPager.OnAdapterChangeListener;
import com.google.android.material.R.attr;
import com.google.android.material.R.dimen;
import com.google.android.material.R.style;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.util.ArrayList;
import java.util.Iterator;

@ViewPager.DecorView
public class TabLayout
  extends HorizontalScrollView
{
  private static final Pools.Pool<TabLayout.Tab> jdField_a_of_type_AndroidxCoreUtilPools$Pool = new Pools.SynchronizedPool(16);
  private static final int m = R.style.o;
  float jdField_a_of_type_Float;
  int jdField_a_of_type_Int;
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  ColorStateList jdField_a_of_type_AndroidContentResColorStateList;
  private DataSetObserver jdField_a_of_type_AndroidDatabaseDataSetObserver;
  PorterDuff.Mode jdField_a_of_type_AndroidGraphicsPorterDuff$Mode;
  @NonNull
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable = new GradientDrawable();
  @Nullable
  private PagerAdapter jdField_a_of_type_AndroidxViewpagerWidgetPagerAdapter;
  @Nullable
  ViewPager jdField_a_of_type_AndroidxViewpagerWidgetViewPager;
  private TabIndicatorInterpolator jdField_a_of_type_ComGoogleAndroidMaterialTabsTabIndicatorInterpolator;
  private TabLayout.AdapterChangeListener jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout$AdapterChangeListener;
  @Nullable
  private TabLayout.BaseOnTabSelectedListener jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout$BaseOnTabSelectedListener;
  @NonNull
  final TabLayout.SlidingTabIndicator jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout$SlidingTabIndicator;
  @Nullable
  private TabLayout.Tab jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout$Tab;
  private TabLayout.TabLayoutOnPageChangeListener jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout$TabLayoutOnPageChangeListener;
  private final ArrayList<TabLayout.Tab> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  boolean jdField_a_of_type_Boolean;
  float jdField_b_of_type_Float;
  int jdField_b_of_type_Int;
  ColorStateList jdField_b_of_type_AndroidContentResColorStateList;
  private final Pools.Pool<TabLayout.TabView> jdField_b_of_type_AndroidxCoreUtilPools$Pool = new Pools.SimplePool(12);
  @Nullable
  private TabLayout.BaseOnTabSelectedListener jdField_b_of_type_ComGoogleAndroidMaterialTabsTabLayout$BaseOnTabSelectedListener;
  private final ArrayList<TabLayout.BaseOnTabSelectedListener> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  boolean jdField_b_of_type_Boolean;
  int jdField_c_of_type_Int;
  ColorStateList jdField_c_of_type_AndroidContentResColorStateList;
  boolean jdField_c_of_type_Boolean;
  int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean;
  int e;
  final int f;
  int g = 2147483647;
  int h;
  int i;
  int j;
  int k;
  int l;
  private int n = 0;
  private final int o;
  private final int p;
  private final int q;
  private int r;
  
  public TabLayout(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TabLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.Q);
  }
  
  public TabLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(MaterialThemeOverlay.a(paramContext, paramAttributeSet, paramInt, m), paramAttributeSet, paramInt);
    paramContext = getContext();
    setHorizontalScrollBarEnabled(false);
    this.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout$SlidingTabIndicator = new TabLayout.SlidingTabIndicator(this, paramContext);
    super.addView(this.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout$SlidingTabIndicator, 0, new FrameLayout.LayoutParams(-2, -1));
    paramAttributeSet = ThemeEnforcement.a(paramContext, paramAttributeSet, com.google.android.material.R.styleable.ay, paramInt, m, new int[] { com.google.android.material.R.styleable.fq });
    if ((getBackground() instanceof ColorDrawable))
    {
      localObject = (ColorDrawable)getBackground();
      MaterialShapeDrawable localMaterialShapeDrawable = new MaterialShapeDrawable();
      localMaterialShapeDrawable.g(ColorStateList.valueOf(((ColorDrawable)localObject).getColor()));
      localMaterialShapeDrawable.a(paramContext);
      localMaterialShapeDrawable.r(ViewCompat.getElevation(this));
      ViewCompat.setBackground(this, localMaterialShapeDrawable);
    }
    setSelectedTabIndicator(MaterialResources.a(paramContext, paramAttributeSet, com.google.android.material.R.styleable.eY));
    setSelectedTabIndicatorColor(paramAttributeSet.getColor(com.google.android.material.R.styleable.fb, 0));
    this.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout$SlidingTabIndicator.a(paramAttributeSet.getDimensionPixelSize(com.google.android.material.R.styleable.fe, -1));
    setSelectedTabIndicatorGravity(paramAttributeSet.getInt(com.google.android.material.R.styleable.fd, 0));
    setTabIndicatorFullWidth(paramAttributeSet.getBoolean(com.google.android.material.R.styleable.fc, true));
    setTabIndicatorAnimationMode(paramAttributeSet.getInt(com.google.android.material.R.styleable.fa, 0));
    paramInt = paramAttributeSet.getDimensionPixelSize(com.google.android.material.R.styleable.fj, 0);
    this.jdField_d_of_type_Int = paramInt;
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Int = paramAttributeSet.getDimensionPixelSize(com.google.android.material.R.styleable.fm, this.jdField_a_of_type_Int);
    this.jdField_b_of_type_Int = paramAttributeSet.getDimensionPixelSize(com.google.android.material.R.styleable.fn, this.jdField_b_of_type_Int);
    this.jdField_c_of_type_Int = paramAttributeSet.getDimensionPixelSize(com.google.android.material.R.styleable.fl, this.jdField_c_of_type_Int);
    this.jdField_d_of_type_Int = paramAttributeSet.getDimensionPixelSize(com.google.android.material.R.styleable.fk, this.jdField_d_of_type_Int);
    this.e = paramAttributeSet.getResourceId(com.google.android.material.R.styleable.fq, R.style.e);
    Object localObject = paramContext.obtainStyledAttributes(this.e, androidx.appcompat.R.styleable.TextAppearance);
    try
    {
      this.jdField_a_of_type_Float = ((TypedArray)localObject).getDimensionPixelSize(androidx.appcompat.R.styleable.TextAppearance_android_textSize, 0);
      this.jdField_a_of_type_AndroidContentResColorStateList = MaterialResources.a(paramContext, (TypedArray)localObject, androidx.appcompat.R.styleable.TextAppearance_android_textColor);
      ((TypedArray)localObject).recycle();
      if (paramAttributeSet.hasValue(com.google.android.material.R.styleable.fr)) {
        this.jdField_a_of_type_AndroidContentResColorStateList = MaterialResources.a(paramContext, paramAttributeSet, com.google.android.material.R.styleable.fr);
      }
      if (paramAttributeSet.hasValue(com.google.android.material.R.styleable.fp))
      {
        paramInt = paramAttributeSet.getColor(com.google.android.material.R.styleable.fp, 0);
        this.jdField_a_of_type_AndroidContentResColorStateList = a(this.jdField_a_of_type_AndroidContentResColorStateList.getDefaultColor(), paramInt);
      }
      this.jdField_b_of_type_AndroidContentResColorStateList = MaterialResources.a(paramContext, paramAttributeSet, com.google.android.material.R.styleable.eW);
      this.jdField_a_of_type_AndroidGraphicsPorterDuff$Mode = ViewUtils.a(paramAttributeSet.getInt(com.google.android.material.R.styleable.eX, -1), null);
      this.jdField_c_of_type_AndroidContentResColorStateList = MaterialResources.a(paramContext, paramAttributeSet, com.google.android.material.R.styleable.fo);
      this.i = paramAttributeSet.getInt(com.google.android.material.R.styleable.eZ, 300);
      this.o = paramAttributeSet.getDimensionPixelSize(com.google.android.material.R.styleable.fh, -1);
      this.p = paramAttributeSet.getDimensionPixelSize(com.google.android.material.R.styleable.fg, -1);
      this.f = paramAttributeSet.getResourceId(com.google.android.material.R.styleable.eT, 0);
      this.r = paramAttributeSet.getDimensionPixelSize(com.google.android.material.R.styleable.eU, 0);
      this.k = paramAttributeSet.getInt(com.google.android.material.R.styleable.fi, 1);
      this.h = paramAttributeSet.getInt(com.google.android.material.R.styleable.eV, 0);
      this.jdField_a_of_type_Boolean = paramAttributeSet.getBoolean(com.google.android.material.R.styleable.ff, false);
      this.jdField_c_of_type_Boolean = paramAttributeSet.getBoolean(com.google.android.material.R.styleable.fs, false);
      paramAttributeSet.recycle();
      paramContext = getResources();
      this.jdField_b_of_type_Float = paramContext.getDimensionPixelSize(R.dimen.r);
      this.q = paramContext.getDimensionPixelSize(R.dimen.q);
      e();
      return;
    }
    finally
    {
      ((TypedArray)localObject).recycle();
    }
  }
  
  private int a(int paramInt, float paramFloat)
  {
    int i2 = this.k;
    int i1 = 0;
    if ((i2 != 0) && (i2 != 2)) {
      return 0;
    }
    View localView2 = this.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout$SlidingTabIndicator.getChildAt(paramInt);
    paramInt += 1;
    View localView1;
    if (paramInt < this.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout$SlidingTabIndicator.getChildCount()) {
      localView1 = this.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout$SlidingTabIndicator.getChildAt(paramInt);
    } else {
      localView1 = null;
    }
    if (localView2 != null) {
      paramInt = localView2.getWidth();
    } else {
      paramInt = 0;
    }
    if (localView1 != null) {
      i1 = localView1.getWidth();
    }
    i2 = localView2.getLeft() + paramInt / 2 - getWidth() / 2;
    paramInt = (int)((paramInt + i1) * 0.5F * paramFloat);
    if (ViewCompat.getLayoutDirection(this) == 0) {
      return i2 + paramInt;
    }
    return i2 - paramInt;
  }
  
  @NonNull
  private static ColorStateList a(int paramInt1, int paramInt2)
  {
    return new ColorStateList(new int[][] { SELECTED_STATE_SET, EMPTY_STATE_SET }, new int[] { paramInt2, paramInt1 });
  }
  
  @NonNull
  private LinearLayout.LayoutParams a()
  {
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -1);
    a(localLayoutParams);
    return localLayoutParams;
  }
  
  @NonNull
  private TabLayout.TabView a(@NonNull TabLayout.Tab paramTab)
  {
    Object localObject1 = this.jdField_b_of_type_AndroidxCoreUtilPools$Pool;
    if (localObject1 != null) {
      localObject1 = (TabLayout.TabView)((Pools.Pool)localObject1).acquire();
    } else {
      localObject1 = null;
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = new TabLayout.TabView(this, getContext());
    }
    ((TabLayout.TabView)localObject2).a(paramTab);
    ((TabLayout.TabView)localObject2).setFocusable(true);
    ((TabLayout.TabView)localObject2).setMinimumWidth(f());
    if (TextUtils.isEmpty(TabLayout.Tab.a(paramTab)))
    {
      ((TabLayout.TabView)localObject2).setContentDescription(TabLayout.Tab.b(paramTab));
      return localObject2;
    }
    ((TabLayout.TabView)localObject2).setContentDescription(TabLayout.Tab.a(paramTab));
    return localObject2;
  }
  
  private void a(int paramInt)
  {
    TabLayout.TabView localTabView = (TabLayout.TabView)this.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout$SlidingTabIndicator.getChildAt(paramInt);
    this.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout$SlidingTabIndicator.removeViewAt(paramInt);
    if (localTabView != null)
    {
      localTabView.a();
      this.jdField_b_of_type_AndroidxCoreUtilPools$Pool.release(localTabView);
    }
    requestLayout();
  }
  
  private void a(View paramView)
  {
    if ((paramView instanceof TabItem))
    {
      a((TabItem)paramView);
      return;
    }
    throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
  }
  
  private void a(@NonNull LinearLayout.LayoutParams paramLayoutParams)
  {
    if ((this.k == 1) && (this.h == 0))
    {
      paramLayoutParams.width = 0;
      paramLayoutParams.weight = 1.0F;
      return;
    }
    paramLayoutParams.width = -2;
    paramLayoutParams.weight = 0.0F;
  }
  
  private void a(@Nullable ViewPager paramViewPager, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager;
    if (localObject != null)
    {
      TabLayout.TabLayoutOnPageChangeListener localTabLayoutOnPageChangeListener = this.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout$TabLayoutOnPageChangeListener;
      if (localTabLayoutOnPageChangeListener != null) {
        ((ViewPager)localObject).removeOnPageChangeListener(localTabLayoutOnPageChangeListener);
      }
      localObject = this.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout$AdapterChangeListener;
      if (localObject != null) {
        this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager.removeOnAdapterChangeListener((ViewPager.OnAdapterChangeListener)localObject);
      }
    }
    localObject = this.jdField_b_of_type_ComGoogleAndroidMaterialTabsTabLayout$BaseOnTabSelectedListener;
    if (localObject != null)
    {
      b((TabLayout.BaseOnTabSelectedListener)localObject);
      this.jdField_b_of_type_ComGoogleAndroidMaterialTabsTabLayout$BaseOnTabSelectedListener = null;
    }
    if (paramViewPager != null)
    {
      this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager = paramViewPager;
      if (this.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout$TabLayoutOnPageChangeListener == null) {
        this.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout$TabLayoutOnPageChangeListener = new TabLayout.TabLayoutOnPageChangeListener(this);
      }
      this.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout$TabLayoutOnPageChangeListener.a();
      paramViewPager.addOnPageChangeListener(this.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout$TabLayoutOnPageChangeListener);
      this.jdField_b_of_type_ComGoogleAndroidMaterialTabsTabLayout$BaseOnTabSelectedListener = new TabLayout.ViewPagerOnTabSelectedListener(paramViewPager);
      a(this.jdField_b_of_type_ComGoogleAndroidMaterialTabsTabLayout$BaseOnTabSelectedListener);
      localObject = paramViewPager.getAdapter();
      if (localObject != null) {
        a((PagerAdapter)localObject, paramBoolean1);
      }
      if (this.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout$AdapterChangeListener == null) {
        this.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout$AdapterChangeListener = new TabLayout.AdapterChangeListener(this);
      }
      this.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout$AdapterChangeListener.a(paramBoolean1);
      paramViewPager.addOnAdapterChangeListener(this.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout$AdapterChangeListener);
      setScrollPosition(paramViewPager.getCurrentItem(), 0.0F, true);
    }
    else
    {
      this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager = null;
      a(null, false);
    }
    this.jdField_d_of_type_Boolean = paramBoolean2;
  }
  
  private void a(@NonNull TabItem paramTabItem)
  {
    TabLayout.Tab localTab = a();
    if (paramTabItem.jdField_a_of_type_JavaLangCharSequence != null) {
      localTab.a(paramTabItem.jdField_a_of_type_JavaLangCharSequence);
    }
    if (paramTabItem.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
      localTab.a(paramTabItem.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    }
    if (paramTabItem.jdField_a_of_type_Int != 0) {
      localTab.a(paramTabItem.jdField_a_of_type_Int);
    }
    if (!TextUtils.isEmpty(paramTabItem.getContentDescription())) {
      localTab.b(paramTabItem.getContentDescription());
    }
    a(localTab);
  }
  
  private void a(@NonNull TabLayout.Tab paramTab, int paramInt)
  {
    paramTab.a(paramInt);
    this.jdField_a_of_type_JavaUtilArrayList.add(paramInt, paramTab);
    int i1 = this.jdField_a_of_type_JavaUtilArrayList.size();
    for (;;)
    {
      paramInt += 1;
      if (paramInt >= i1) {
        break;
      }
      ((TabLayout.Tab)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).a(paramInt);
    }
  }
  
  private void b(int paramInt)
  {
    if (paramInt == -1) {
      return;
    }
    if ((getWindowToken() != null) && (ViewCompat.isLaidOut(this)) && (!this.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout$SlidingTabIndicator.a()))
    {
      int i1 = getScrollX();
      int i2 = a(paramInt, 0.0F);
      if (i1 != i2)
      {
        d();
        this.jdField_a_of_type_AndroidAnimationValueAnimator.setIntValues(new int[] { i1, i2 });
        this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
      }
      this.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout$SlidingTabIndicator.a(paramInt, this.i);
      return;
    }
    setScrollPosition(paramInt, 0.0F, true);
  }
  
  private void c()
  {
    int i2 = this.jdField_a_of_type_JavaUtilArrayList.size();
    int i1 = 0;
    while (i1 < i2)
    {
      ((TabLayout.Tab)this.jdField_a_of_type_JavaUtilArrayList.get(i1)).b();
      i1 += 1;
    }
  }
  
  private void c(int paramInt)
  {
    int i2 = this.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout$SlidingTabIndicator.getChildCount();
    if (paramInt < i2)
    {
      int i1 = 0;
      while (i1 < i2)
      {
        View localView = this.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout$SlidingTabIndicator.getChildAt(i1);
        boolean bool2 = true;
        boolean bool1;
        if (i1 == paramInt) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        localView.setSelected(bool1);
        if (i1 == paramInt) {
          bool1 = bool2;
        } else {
          bool1 = false;
        }
        localView.setActivated(bool1);
        i1 += 1;
      }
    }
  }
  
  private void c(@NonNull TabLayout.Tab paramTab)
  {
    TabLayout.TabView localTabView = paramTab.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout$TabView;
    localTabView.setSelected(false);
    localTabView.setActivated(false);
    this.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout$SlidingTabIndicator.addView(localTabView, paramTab.a(), a());
  }
  
  private int d()
  {
    return Math.max(0, this.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout$SlidingTabIndicator.getWidth() - getWidth() - getPaddingLeft() - getPaddingRight());
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator == null)
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator = new ValueAnimator();
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setInterpolator(AnimationUtils.b);
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(this.i);
      this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new TabLayout.1(this));
    }
  }
  
  private void d(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt == 2) {}
      }
      else {
        this.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout$SlidingTabIndicator.setGravity(1);
      }
    }
    else {
      Log.w("TabLayout", "MODE_SCROLLABLE + GRAVITY_FILL is not supported, GRAVITY_START will be used instead");
    }
    this.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout$SlidingTabIndicator.setGravity(8388611);
  }
  
  private void d(@NonNull TabLayout.Tab paramTab)
  {
    int i1 = this.jdField_b_of_type_JavaUtilArrayList.size() - 1;
    while (i1 >= 0)
    {
      ((TabLayout.BaseOnTabSelectedListener)this.jdField_b_of_type_JavaUtilArrayList.get(i1)).a(paramTab);
      i1 -= 1;
    }
  }
  
  @Dimension(unit=0)
  private int e()
  {
    int i4 = this.jdField_a_of_type_JavaUtilArrayList.size();
    int i3 = 0;
    int i1 = 0;
    int i2;
    for (;;)
    {
      i2 = i3;
      if (i1 >= i4) {
        break;
      }
      TabLayout.Tab localTab = (TabLayout.Tab)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
      if ((localTab != null) && (localTab.a() != null) && (!TextUtils.isEmpty(localTab.a())))
      {
        i2 = 1;
        break;
      }
      i1 += 1;
    }
    if ((i2 != 0) && (!this.jdField_a_of_type_Boolean)) {
      return 72;
    }
    return 48;
  }
  
  private void e()
  {
    int i1 = this.k;
    if ((i1 != 0) && (i1 != 2)) {
      i1 = 0;
    } else {
      i1 = Math.max(0, this.r - this.jdField_a_of_type_Int);
    }
    ViewCompat.setPaddingRelative(this.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout$SlidingTabIndicator, i1, 0, 0, 0);
    i1 = this.k;
    if (i1 != 0)
    {
      if ((i1 == 1) || (i1 == 2))
      {
        if (this.h == 2) {
          Log.w("TabLayout", "GRAVITY_START is not supported with the current tab mode, GRAVITY_CENTER will be used instead");
        }
        this.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout$SlidingTabIndicator.setGravity(1);
      }
    }
    else {
      d(this.h);
    }
    a(true);
  }
  
  private void e(@NonNull TabLayout.Tab paramTab)
  {
    int i1 = this.jdField_b_of_type_JavaUtilArrayList.size() - 1;
    while (i1 >= 0)
    {
      ((TabLayout.BaseOnTabSelectedListener)this.jdField_b_of_type_JavaUtilArrayList.get(i1)).b(paramTab);
      i1 -= 1;
    }
  }
  
  private int f()
  {
    int i1 = this.o;
    if (i1 != -1) {
      return i1;
    }
    i1 = this.k;
    if ((i1 != 0) && (i1 != 2)) {
      return 0;
    }
    return this.q;
  }
  
  private void f(@NonNull TabLayout.Tab paramTab)
  {
    int i1 = this.jdField_b_of_type_JavaUtilArrayList.size() - 1;
    while (i1 >= 0)
    {
      ((TabLayout.BaseOnTabSelectedListener)this.jdField_b_of_type_JavaUtilArrayList.get(i1)).c(paramTab);
      i1 -= 1;
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  @NonNull
  public TabLayout.Tab a()
  {
    TabLayout.Tab localTab = b();
    localTab.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout = this;
    localTab.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout$TabView = a(localTab);
    if (TabLayout.Tab.a(localTab) != -1) {
      localTab.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout$TabView.setId(TabLayout.Tab.a(localTab));
    }
    return localTab;
  }
  
  @Nullable
  public TabLayout.Tab a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < a())) {
      return (TabLayout.Tab)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    }
    return null;
  }
  
  public void a()
  {
    int i1 = this.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout$SlidingTabIndicator.getChildCount() - 1;
    while (i1 >= 0)
    {
      a(i1);
      i1 -= 1;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      TabLayout.Tab localTab = (TabLayout.Tab)localIterator.next();
      localIterator.remove();
      localTab.c();
      a(localTab);
    }
    this.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout$Tab = null;
  }
  
  void a(@Nullable PagerAdapter paramPagerAdapter, boolean paramBoolean)
  {
    PagerAdapter localPagerAdapter = this.jdField_a_of_type_AndroidxViewpagerWidgetPagerAdapter;
    if (localPagerAdapter != null)
    {
      DataSetObserver localDataSetObserver = this.jdField_a_of_type_AndroidDatabaseDataSetObserver;
      if (localDataSetObserver != null) {
        localPagerAdapter.unregisterDataSetObserver(localDataSetObserver);
      }
    }
    this.jdField_a_of_type_AndroidxViewpagerWidgetPagerAdapter = paramPagerAdapter;
    if ((paramBoolean) && (paramPagerAdapter != null))
    {
      if (this.jdField_a_of_type_AndroidDatabaseDataSetObserver == null) {
        this.jdField_a_of_type_AndroidDatabaseDataSetObserver = new TabLayout.PagerAdapterObserver(this);
      }
      paramPagerAdapter.registerDataSetObserver(this.jdField_a_of_type_AndroidDatabaseDataSetObserver);
    }
    b();
  }
  
  @Deprecated
  public void a(@Nullable TabLayout.BaseOnTabSelectedListener paramBaseOnTabSelectedListener)
  {
    if (!this.jdField_b_of_type_JavaUtilArrayList.contains(paramBaseOnTabSelectedListener)) {
      this.jdField_b_of_type_JavaUtilArrayList.add(paramBaseOnTabSelectedListener);
    }
  }
  
  public void a(@NonNull TabLayout.Tab paramTab)
  {
    a(paramTab, this.jdField_a_of_type_JavaUtilArrayList.isEmpty());
  }
  
  public void a(@NonNull TabLayout.Tab paramTab, int paramInt, boolean paramBoolean)
  {
    if (paramTab.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout == this)
    {
      a(paramTab, paramInt);
      c(paramTab);
      if (paramBoolean) {
        paramTab.a();
      }
      return;
    }
    throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
  }
  
  public void a(@NonNull TabLayout.Tab paramTab, boolean paramBoolean)
  {
    a(paramTab, this.jdField_a_of_type_JavaUtilArrayList.size(), paramBoolean);
  }
  
  void a(boolean paramBoolean)
  {
    int i1 = 0;
    while (i1 < this.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout$SlidingTabIndicator.getChildCount())
    {
      View localView = this.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout$SlidingTabIndicator.getChildAt(i1);
      localView.setMinimumWidth(f());
      a((LinearLayout.LayoutParams)localView.getLayoutParams());
      if (paramBoolean) {
        localView.requestLayout();
      }
      i1 += 1;
    }
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  protected boolean a(TabLayout.Tab paramTab)
  {
    return jdField_a_of_type_AndroidxCoreUtilPools$Pool.release(paramTab);
  }
  
  public void addView(View paramView)
  {
    a(paramView);
  }
  
  public void addView(View paramView, int paramInt)
  {
    a(paramView);
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    a(paramView);
  }
  
  public void addView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    a(paramView);
  }
  
  public int b()
  {
    TabLayout.Tab localTab = this.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout$Tab;
    if (localTab != null) {
      return localTab.a();
    }
    return -1;
  }
  
  protected TabLayout.Tab b()
  {
    TabLayout.Tab localTab2 = (TabLayout.Tab)jdField_a_of_type_AndroidxCoreUtilPools$Pool.acquire();
    TabLayout.Tab localTab1 = localTab2;
    if (localTab2 == null) {
      localTab1 = new TabLayout.Tab();
    }
    return localTab1;
  }
  
  void b()
  {
    a();
    Object localObject = this.jdField_a_of_type_AndroidxViewpagerWidgetPagerAdapter;
    if (localObject != null)
    {
      int i2 = ((PagerAdapter)localObject).getCount();
      int i1 = 0;
      while (i1 < i2)
      {
        a(a().a(this.jdField_a_of_type_AndroidxViewpagerWidgetPagerAdapter.getPageTitle(i1)), false);
        i1 += 1;
      }
      localObject = this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager;
      if ((localObject != null) && (i2 > 0))
      {
        i1 = ((ViewPager)localObject).getCurrentItem();
        if ((i1 != b()) && (i1 < a())) {
          b(a(i1));
        }
      }
    }
  }
  
  @Deprecated
  public void b(@Nullable TabLayout.BaseOnTabSelectedListener paramBaseOnTabSelectedListener)
  {
    this.jdField_b_of_type_JavaUtilArrayList.remove(paramBaseOnTabSelectedListener);
  }
  
  public void b(@Nullable TabLayout.Tab paramTab)
  {
    b(paramTab, true);
  }
  
  public void b(@Nullable TabLayout.Tab paramTab, boolean paramBoolean)
  {
    TabLayout.Tab localTab = this.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout$Tab;
    if (localTab == paramTab)
    {
      if (localTab != null)
      {
        f(paramTab);
        b(paramTab.a());
      }
    }
    else
    {
      int i1;
      if (paramTab != null) {
        i1 = paramTab.a();
      } else {
        i1 = -1;
      }
      if (paramBoolean)
      {
        if (((localTab == null) || (localTab.a() == -1)) && (i1 != -1)) {
          setScrollPosition(i1, 0.0F, true);
        } else {
          b(i1);
        }
        if (i1 != -1) {
          c(i1);
        }
      }
      this.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout$Tab = paramTab;
      if (localTab != null) {
        e(localTab);
      }
      if (paramTab != null) {
        d(paramTab);
      }
    }
  }
  
  int c()
  {
    return this.g;
  }
  
  public FrameLayout.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return generateDefaultLayoutParams();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    MaterialShapeUtils.a(this);
    if (this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager == null)
    {
      ViewParent localViewParent = getParent();
      if ((localViewParent instanceof ViewPager)) {
        a((ViewPager)localViewParent, true, true);
      }
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.jdField_d_of_type_Boolean)
    {
      setupWithViewPager(null);
      this.jdField_d_of_type_Boolean = false;
    }
  }
  
  protected void onDraw(@NonNull Canvas paramCanvas)
  {
    int i1 = 0;
    while (i1 < this.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout$SlidingTabIndicator.getChildCount())
    {
      View localView = this.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout$SlidingTabIndicator.getChildAt(i1);
      if ((localView instanceof TabLayout.TabView)) {
        TabLayout.TabView.a((TabLayout.TabView)localView, paramCanvas);
      }
      i1 += 1;
    }
    super.onDraw(paramCanvas);
  }
  
  public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    AccessibilityNodeInfoCompat.wrap(paramAccessibilityNodeInfo).setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(1, a(), false, 1));
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i3 = Math.round(ViewUtils.a(getContext(), e()));
    int i1 = View.MeasureSpec.getMode(paramInt2);
    int i2 = 0;
    if (i1 != -2147483648)
    {
      if (i1 != 0) {
        i1 = paramInt2;
      } else {
        i1 = View.MeasureSpec.makeMeasureSpec(i3 + getPaddingTop() + getPaddingBottom(), 1073741824);
      }
    }
    else
    {
      i1 = paramInt2;
      if (getChildCount() == 1)
      {
        i1 = paramInt2;
        if (View.MeasureSpec.getSize(paramInt2) >= i3)
        {
          getChildAt(0).setMinimumHeight(i3);
          i1 = paramInt2;
        }
      }
    }
    i3 = View.MeasureSpec.getSize(paramInt1);
    if (View.MeasureSpec.getMode(paramInt1) != 0)
    {
      paramInt2 = this.p;
      if (paramInt2 <= 0) {
        paramInt2 = (int)(i3 - ViewUtils.a(getContext(), 56));
      }
      this.g = paramInt2;
    }
    super.onMeasure(paramInt1, i1);
    if (getChildCount() == 1)
    {
      View localView = getChildAt(0);
      paramInt1 = this.k;
      if (paramInt1 != 0) {
        if (paramInt1 != 1)
        {
          if (paramInt1 != 2)
          {
            paramInt1 = i2;
            break label224;
          }
        }
        else
        {
          paramInt1 = i2;
          if (localView.getMeasuredWidth() == getMeasuredWidth()) {
            break label224;
          }
        }
      }
      do
      {
        paramInt1 = 1;
        break;
        paramInt1 = i2;
      } while (localView.getMeasuredWidth() < getMeasuredWidth());
      label224:
      if (paramInt1 != 0)
      {
        paramInt1 = getChildMeasureSpec(i1, getPaddingTop() + getPaddingBottom(), localView.getLayoutParams().height);
        localView.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), paramInt1);
      }
    }
  }
  
  @RequiresApi(21)
  public void setElevation(float paramFloat)
  {
    super.setElevation(paramFloat);
    MaterialShapeUtils.a(this, paramFloat);
  }
  
  public void setInlineLabel(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean != paramBoolean)
    {
      this.jdField_a_of_type_Boolean = paramBoolean;
      int i1 = 0;
      while (i1 < this.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout$SlidingTabIndicator.getChildCount())
      {
        View localView = this.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout$SlidingTabIndicator.getChildAt(i1);
        if ((localView instanceof TabLayout.TabView)) {
          ((TabLayout.TabView)localView).c();
        }
        i1 += 1;
      }
      e();
    }
  }
  
  public void setInlineLabelResource(@BoolRes int paramInt)
  {
    setInlineLabel(getResources().getBoolean(paramInt));
  }
  
  @Deprecated
  public void setOnTabSelectedListener(@Nullable TabLayout.BaseOnTabSelectedListener paramBaseOnTabSelectedListener)
  {
    TabLayout.BaseOnTabSelectedListener localBaseOnTabSelectedListener = this.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout$BaseOnTabSelectedListener;
    if (localBaseOnTabSelectedListener != null) {
      b(localBaseOnTabSelectedListener);
    }
    this.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout$BaseOnTabSelectedListener = paramBaseOnTabSelectedListener;
    if (paramBaseOnTabSelectedListener != null) {
      a(paramBaseOnTabSelectedListener);
    }
  }
  
  @Deprecated
  public void setOnTabSelectedListener(@Nullable TabLayout.OnTabSelectedListener paramOnTabSelectedListener)
  {
    setOnTabSelectedListener(paramOnTabSelectedListener);
  }
  
  public void setScrollPosition(int paramInt, float paramFloat, boolean paramBoolean)
  {
    setScrollPosition(paramInt, paramFloat, paramBoolean, true);
  }
  
  public void setScrollPosition(int paramInt, float paramFloat, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i1 = Math.round(paramInt + paramFloat);
    if (i1 >= 0)
    {
      if (i1 >= this.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout$SlidingTabIndicator.getChildCount()) {
        return;
      }
      if (paramBoolean2) {
        this.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout$SlidingTabIndicator.a(paramInt, paramFloat);
      }
      ValueAnimator localValueAnimator = this.jdField_a_of_type_AndroidAnimationValueAnimator;
      if ((localValueAnimator != null) && (localValueAnimator.isRunning())) {
        this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
      }
      scrollTo(a(paramInt, paramFloat), 0);
      if (paramBoolean1) {
        c(i1);
      }
    }
  }
  
  public void setSelectedTabIndicator(@DrawableRes int paramInt)
  {
    if (paramInt != 0)
    {
      setSelectedTabIndicator(AppCompatResources.getDrawable(getContext(), paramInt));
      return;
    }
    setSelectedTabIndicator(null);
  }
  
  public void setSelectedTabIndicator(@Nullable Drawable paramDrawable)
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != paramDrawable)
    {
      if (paramDrawable == null) {
        paramDrawable = new GradientDrawable();
      }
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    }
  }
  
  public void setSelectedTabIndicatorColor(@ColorInt int paramInt)
  {
    this.n = paramInt;
  }
  
  public void setSelectedTabIndicatorGravity(int paramInt)
  {
    if (this.j != paramInt)
    {
      this.j = paramInt;
      ViewCompat.postInvalidateOnAnimation(this.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout$SlidingTabIndicator);
    }
  }
  
  @Deprecated
  public void setSelectedTabIndicatorHeight(int paramInt)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout$SlidingTabIndicator.a(paramInt);
  }
  
  public void setTabGravity(int paramInt)
  {
    if (this.h != paramInt)
    {
      this.h = paramInt;
      e();
    }
  }
  
  public void setTabIconTint(@Nullable ColorStateList paramColorStateList)
  {
    if (this.jdField_b_of_type_AndroidContentResColorStateList != paramColorStateList)
    {
      this.jdField_b_of_type_AndroidContentResColorStateList = paramColorStateList;
      c();
    }
  }
  
  public void setTabIconTintResource(@ColorRes int paramInt)
  {
    setTabIconTint(AppCompatResources.getColorStateList(getContext(), paramInt));
  }
  
  public void setTabIndicatorAnimationMode(int paramInt)
  {
    this.l = paramInt;
    if (paramInt != 0)
    {
      if (paramInt == 1)
      {
        this.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabIndicatorInterpolator = new ElasticTabIndicatorInterpolator();
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" is not a valid TabIndicatorAnimationMode");
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabIndicatorInterpolator = new TabIndicatorInterpolator();
  }
  
  public void setTabIndicatorFullWidth(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    ViewCompat.postInvalidateOnAnimation(this.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout$SlidingTabIndicator);
  }
  
  public void setTabMode(int paramInt)
  {
    if (paramInt != this.k)
    {
      this.k = paramInt;
      e();
    }
  }
  
  public void setTabRippleColor(@Nullable ColorStateList paramColorStateList)
  {
    if (this.jdField_c_of_type_AndroidContentResColorStateList != paramColorStateList)
    {
      this.jdField_c_of_type_AndroidContentResColorStateList = paramColorStateList;
      int i1 = 0;
      while (i1 < this.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout$SlidingTabIndicator.getChildCount())
      {
        paramColorStateList = this.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout$SlidingTabIndicator.getChildAt(i1);
        if ((paramColorStateList instanceof TabLayout.TabView)) {
          TabLayout.TabView.a((TabLayout.TabView)paramColorStateList, getContext());
        }
        i1 += 1;
      }
    }
  }
  
  public void setTabRippleColorResource(@ColorRes int paramInt)
  {
    setTabRippleColor(AppCompatResources.getColorStateList(getContext(), paramInt));
  }
  
  public void setTabTextColors(int paramInt1, int paramInt2)
  {
    setTabTextColors(a(paramInt1, paramInt2));
  }
  
  public void setTabTextColors(@Nullable ColorStateList paramColorStateList)
  {
    if (this.jdField_a_of_type_AndroidContentResColorStateList != paramColorStateList)
    {
      this.jdField_a_of_type_AndroidContentResColorStateList = paramColorStateList;
      c();
    }
  }
  
  @Deprecated
  public void setTabsFromPagerAdapter(@Nullable PagerAdapter paramPagerAdapter)
  {
    a(paramPagerAdapter, false);
  }
  
  public void setUnboundedRipple(boolean paramBoolean)
  {
    if (this.jdField_c_of_type_Boolean != paramBoolean)
    {
      this.jdField_c_of_type_Boolean = paramBoolean;
      int i1 = 0;
      while (i1 < this.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout$SlidingTabIndicator.getChildCount())
      {
        View localView = this.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout$SlidingTabIndicator.getChildAt(i1);
        if ((localView instanceof TabLayout.TabView)) {
          TabLayout.TabView.a((TabLayout.TabView)localView, getContext());
        }
        i1 += 1;
      }
    }
  }
  
  public void setUnboundedRippleResource(@BoolRes int paramInt)
  {
    setUnboundedRipple(getResources().getBoolean(paramInt));
  }
  
  public void setupWithViewPager(@Nullable ViewPager paramViewPager)
  {
    setupWithViewPager(paramViewPager, true);
  }
  
  public void setupWithViewPager(@Nullable ViewPager paramViewPager, boolean paramBoolean)
  {
    a(paramViewPager, paramBoolean, false);
  }
  
  public boolean shouldDelayChildPressedState()
  {
    return d() > 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.tabs.TabLayout
 * JD-Core Version:    0.7.0.1
 */