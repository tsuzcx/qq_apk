package com.google.android.material.tabs;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import android.text.Layout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.TooltipCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.PointerIconCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat.CollectionItemInfoCompat;
import androidx.core.widget.TextViewCompat;
import com.google.android.material.R.layout;
import com.google.android.material.R.string;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.badge.BadgeUtils;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.ripple.RippleUtils;

public final class TabLayout$TabView
  extends LinearLayout
{
  private int jdField_a_of_type_Int = 2;
  @Nullable
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  @Nullable
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  @Nullable
  private BadgeDrawable jdField_a_of_type_ComGoogleAndroidMaterialBadgeBadgeDrawable;
  private TabLayout.Tab jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout$Tab;
  @Nullable
  private View jdField_b_of_type_AndroidViewView;
  @Nullable
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  @Nullable
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  
  public TabLayout$TabView(TabLayout paramTabLayout, @NonNull Context paramContext)
  {
    super(paramContext);
    a(paramContext);
    ViewCompat.setPaddingRelative(this, paramTabLayout.jdField_a_of_type_Int, paramTabLayout.jdField_b_of_type_Int, paramTabLayout.jdField_c_of_type_Int, paramTabLayout.d);
    setGravity(17);
    setOrientation(paramTabLayout.jdField_a_of_type_Boolean ^ true);
    setClickable(true);
    ViewCompat.setPointerIcon(this, PointerIconCompat.getSystemIcon(getContext(), 1002));
  }
  
  private float a(@NonNull Layout paramLayout, int paramInt, float paramFloat)
  {
    return paramLayout.getLineWidth(paramInt) * (paramFloat / paramLayout.getPaint().getTextSize());
  }
  
  @NonNull
  private FrameLayout a()
  {
    FrameLayout localFrameLayout = new FrameLayout(getContext());
    localFrameLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    return localFrameLayout;
  }
  
  @Nullable
  private FrameLayout a(@NonNull View paramView)
  {
    ImageView localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
    FrameLayout localFrameLayout = null;
    if ((paramView != localImageView) && (paramView != this.jdField_a_of_type_AndroidWidgetTextView)) {
      return null;
    }
    if (BadgeUtils.jdField_a_of_type_Boolean) {
      localFrameLayout = (FrameLayout)paramView.getParent();
    }
    return localFrameLayout;
  }
  
  private void a(Context paramContext)
  {
    if (this.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout.f != 0)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = AppCompatResources.getDrawable(paramContext, this.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout.f);
      paramContext = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      if ((paramContext != null) && (paramContext.isStateful())) {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setState(getDrawableState());
      }
    }
    else
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
    }
    GradientDrawable localGradientDrawable = new GradientDrawable();
    ((GradientDrawable)localGradientDrawable).setColor(0);
    paramContext = localGradientDrawable;
    if (this.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout.jdField_c_of_type_AndroidContentResColorStateList != null)
    {
      paramContext = new GradientDrawable();
      paramContext.setCornerRadius(1.0E-005F);
      paramContext.setColor(-1);
      ColorStateList localColorStateList = RippleUtils.a(this.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout.jdField_c_of_type_AndroidContentResColorStateList);
      if (Build.VERSION.SDK_INT >= 21)
      {
        if (this.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout.jdField_c_of_type_Boolean) {
          localGradientDrawable = null;
        }
        if (this.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout.jdField_c_of_type_Boolean) {
          paramContext = null;
        }
        paramContext = new RippleDrawable(localColorStateList, localGradientDrawable, paramContext);
      }
      else
      {
        paramContext = DrawableCompat.wrap(paramContext);
        DrawableCompat.setTintList(paramContext, localColorStateList);
        paramContext = new LayerDrawable(new Drawable[] { localGradientDrawable, paramContext });
      }
    }
    ViewCompat.setBackground(this, paramContext);
    this.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout.invalidate();
  }
  
  private void a(@NonNull Canvas paramCanvas)
  {
    Drawable localDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    if (localDrawable != null)
    {
      localDrawable.setBounds(getLeft(), getTop(), getRight(), getBottom());
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
    }
  }
  
  private void a(@Nullable View paramView)
  {
    if (paramView == null) {
      return;
    }
    paramView.addOnLayoutChangeListener(new TabLayout.TabView.1(this, paramView));
  }
  
  private void a(@Nullable TextView paramTextView, @Nullable ImageView paramImageView)
  {
    Object localObject1 = this.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout$Tab;
    Object localObject2 = null;
    Drawable localDrawable;
    if ((localObject1 != null) && (((TabLayout.Tab)localObject1).a() != null)) {
      localDrawable = DrawableCompat.wrap(this.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout$Tab.a()).mutate();
    } else {
      localDrawable = null;
    }
    localObject1 = this.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout$Tab;
    if (localObject1 != null) {
      localObject1 = ((TabLayout.Tab)localObject1).a();
    } else {
      localObject1 = null;
    }
    if (paramImageView != null) {
      if (localDrawable != null)
      {
        paramImageView.setImageDrawable(localDrawable);
        paramImageView.setVisibility(0);
        setVisibility(0);
      }
      else
      {
        paramImageView.setVisibility(8);
        paramImageView.setImageDrawable(null);
      }
    }
    boolean bool = TextUtils.isEmpty((CharSequence)localObject1) ^ true;
    if (paramTextView != null) {
      if (bool)
      {
        paramTextView.setText((CharSequence)localObject1);
        if (TabLayout.Tab.b(this.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout$Tab) == 1) {
          paramTextView.setVisibility(0);
        } else {
          paramTextView.setVisibility(8);
        }
        setVisibility(0);
      }
      else
      {
        paramTextView.setVisibility(8);
        paramTextView.setText(null);
      }
    }
    if (paramImageView != null)
    {
      paramTextView = (ViewGroup.MarginLayoutParams)paramImageView.getLayoutParams();
      int i;
      if ((bool) && (paramImageView.getVisibility() == 0)) {
        i = (int)ViewUtils.a(getContext(), 8);
      } else {
        i = 0;
      }
      if (this.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout.jdField_a_of_type_Boolean)
      {
        if (i != MarginLayoutParamsCompat.getMarginEnd(paramTextView))
        {
          MarginLayoutParamsCompat.setMarginEnd(paramTextView, i);
          paramTextView.bottomMargin = 0;
          paramImageView.setLayoutParams(paramTextView);
          paramImageView.requestLayout();
        }
      }
      else if (i != paramTextView.bottomMargin)
      {
        paramTextView.bottomMargin = i;
        MarginLayoutParamsCompat.setMarginEnd(paramTextView, 0);
        paramImageView.setLayoutParams(paramTextView);
        paramImageView.requestLayout();
      }
    }
    paramImageView = this.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout$Tab;
    paramTextView = localObject2;
    if (paramImageView != null) {
      paramTextView = TabLayout.Tab.a(paramImageView);
    }
    if (bool) {
      paramTextView = (TextView)localObject1;
    }
    TooltipCompat.setTooltipText(this, paramTextView);
  }
  
  private void a(boolean paramBoolean)
  {
    setClipChildren(paramBoolean);
    setClipToPadding(paramBoolean);
    ViewGroup localViewGroup = (ViewGroup)getParent();
    if (localViewGroup != null)
    {
      localViewGroup.setClipChildren(paramBoolean);
      localViewGroup.setClipToPadding(paramBoolean);
    }
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
      a(false);
      BadgeUtils.a(this.jdField_a_of_type_ComGoogleAndroidMaterialBadgeBadgeDrawable, paramView, a(paramView));
      this.jdField_a_of_type_AndroidViewView = paramView;
    }
  }
  
  private void c(@NonNull View paramView)
  {
    if ((a()) && (paramView == this.jdField_a_of_type_AndroidViewView)) {
      BadgeUtils.b(this.jdField_a_of_type_ComGoogleAndroidMaterialBadgeBadgeDrawable, paramView, a(paramView));
    }
  }
  
  private void d()
  {
    Object localObject;
    if (BadgeUtils.jdField_a_of_type_Boolean)
    {
      localObject = a();
      addView((View)localObject, 0);
    }
    else
    {
      localObject = this;
    }
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)LayoutInflater.from(getContext()).inflate(R.layout.jdField_c_of_type_Int, (ViewGroup)localObject, false));
    ((ViewGroup)localObject).addView(this.jdField_a_of_type_AndroidWidgetImageView, 0);
  }
  
  private void e()
  {
    Object localObject;
    if (BadgeUtils.jdField_a_of_type_Boolean)
    {
      localObject = a();
      addView((View)localObject);
    }
    else
    {
      localObject = this;
    }
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)LayoutInflater.from(getContext()).inflate(R.layout.d, (ViewGroup)localObject, false));
    ((ViewGroup)localObject).addView(this.jdField_a_of_type_AndroidWidgetTextView);
  }
  
  private void f()
  {
    if (!a()) {
      return;
    }
    if (this.jdField_b_of_type_AndroidViewView != null)
    {
      g();
      return;
    }
    Object localObject1;
    Object localObject2;
    if (this.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      localObject1 = this.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout$Tab;
      if ((localObject1 != null) && (((TabLayout.Tab)localObject1).a() != null))
      {
        localObject1 = this.jdField_a_of_type_AndroidViewView;
        localObject2 = this.jdField_a_of_type_AndroidWidgetImageView;
        if (localObject1 != localObject2)
        {
          g();
          b(this.jdField_a_of_type_AndroidWidgetImageView);
          return;
        }
        c((View)localObject2);
        return;
      }
    }
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      localObject1 = this.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout$Tab;
      if ((localObject1 != null) && (((TabLayout.Tab)localObject1).b() == 1))
      {
        localObject1 = this.jdField_a_of_type_AndroidViewView;
        localObject2 = this.jdField_a_of_type_AndroidWidgetTextView;
        if (localObject1 != localObject2)
        {
          g();
          b(this.jdField_a_of_type_AndroidWidgetTextView);
          return;
        }
        c((View)localObject2);
        return;
      }
    }
    g();
  }
  
  private void g()
  {
    if (!a()) {
      return;
    }
    a(true);
    View localView = this.jdField_a_of_type_AndroidViewView;
    if (localView != null)
    {
      BadgeUtils.a(this.jdField_a_of_type_ComGoogleAndroidMaterialBadgeBadgeDrawable, localView);
      this.jdField_a_of_type_AndroidViewView = null;
    }
  }
  
  int a()
  {
    View[] arrayOfView = new View[3];
    Object localObject = this.jdField_a_of_type_AndroidWidgetTextView;
    int k = 0;
    arrayOfView[0] = localObject;
    arrayOfView[1] = this.jdField_a_of_type_AndroidWidgetImageView;
    arrayOfView[2] = this.jdField_b_of_type_AndroidViewView;
    int i3 = arrayOfView.length;
    int m = 0;
    int i = 0;
    int n;
    for (int j = 0; k < i3; j = n)
    {
      localObject = arrayOfView[k];
      int i2 = m;
      int i1 = i;
      n = j;
      if (localObject != null)
      {
        i2 = m;
        i1 = i;
        n = j;
        if (((View)localObject).getVisibility() == 0)
        {
          if (j != 0) {
            i = Math.min(i, ((View)localObject).getLeft());
          } else {
            i = ((View)localObject).getLeft();
          }
          if (j != 0) {
            j = Math.max(m, ((View)localObject).getRight());
          } else {
            j = ((View)localObject).getRight();
          }
          n = 1;
          i1 = i;
          i2 = j;
        }
      }
      k += 1;
      m = i2;
      i = i1;
    }
    return m - i;
  }
  
  void a()
  {
    a(null);
    setSelected(false);
  }
  
  void a(@Nullable TabLayout.Tab paramTab)
  {
    if (paramTab != this.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout$Tab)
    {
      this.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout$Tab = paramTab;
      b();
    }
  }
  
  int b()
  {
    View[] arrayOfView = new View[3];
    Object localObject = this.jdField_a_of_type_AndroidWidgetTextView;
    int k = 0;
    arrayOfView[0] = localObject;
    arrayOfView[1] = this.jdField_a_of_type_AndroidWidgetImageView;
    arrayOfView[2] = this.jdField_b_of_type_AndroidViewView;
    int i3 = arrayOfView.length;
    int m = 0;
    int i = 0;
    int n;
    for (int j = 0; k < i3; j = n)
    {
      localObject = arrayOfView[k];
      int i2 = m;
      int i1 = i;
      n = j;
      if (localObject != null)
      {
        i2 = m;
        i1 = i;
        n = j;
        if (((View)localObject).getVisibility() == 0)
        {
          if (j != 0) {
            i = Math.min(i, ((View)localObject).getTop());
          } else {
            i = ((View)localObject).getTop();
          }
          if (j != 0) {
            j = Math.max(m, ((View)localObject).getBottom());
          } else {
            j = ((View)localObject).getBottom();
          }
          n = 1;
          i1 = i;
          i2 = j;
        }
      }
      k += 1;
      m = i2;
      i = i1;
    }
    return m - i;
  }
  
  final void b()
  {
    TabLayout.Tab localTab = this.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout$Tab;
    Object localObject2 = null;
    Object localObject1;
    if (localTab != null) {
      localObject1 = localTab.a();
    } else {
      localObject1 = null;
    }
    if (localObject1 != null)
    {
      Object localObject3 = ((View)localObject1).getParent();
      if (localObject3 != this)
      {
        if (localObject3 != null) {
          ((ViewGroup)localObject3).removeView((View)localObject1);
        }
        addView((View)localObject1);
      }
      this.jdField_b_of_type_AndroidViewView = ((View)localObject1);
      localObject3 = this.jdField_a_of_type_AndroidWidgetTextView;
      if (localObject3 != null) {
        ((TextView)localObject3).setVisibility(8);
      }
      localObject3 = this.jdField_a_of_type_AndroidWidgetImageView;
      if (localObject3 != null)
      {
        ((ImageView)localObject3).setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
      }
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(16908308));
      localObject3 = this.jdField_b_of_type_AndroidWidgetTextView;
      if (localObject3 != null) {
        this.jdField_a_of_type_Int = TextViewCompat.getMaxLines((TextView)localObject3);
      }
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject1).findViewById(16908294));
    }
    else
    {
      localObject1 = this.jdField_b_of_type_AndroidViewView;
      if (localObject1 != null)
      {
        removeView((View)localObject1);
        this.jdField_b_of_type_AndroidViewView = null;
      }
      this.jdField_b_of_type_AndroidWidgetTextView = null;
      this.jdField_b_of_type_AndroidWidgetImageView = null;
    }
    if (this.jdField_b_of_type_AndroidViewView == null)
    {
      if (this.jdField_a_of_type_AndroidWidgetImageView == null) {
        d();
      }
      localObject1 = localObject2;
      if (localTab != null)
      {
        localObject1 = localObject2;
        if (localTab.a() != null) {
          localObject1 = DrawableCompat.wrap(localTab.a()).mutate();
        }
      }
      if (localObject1 != null)
      {
        DrawableCompat.setTintList((Drawable)localObject1, this.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout.jdField_b_of_type_AndroidContentResColorStateList);
        if (this.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout.jdField_a_of_type_AndroidGraphicsPorterDuff$Mode != null) {
          DrawableCompat.setTintMode((Drawable)localObject1, this.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout.jdField_a_of_type_AndroidGraphicsPorterDuff$Mode);
        }
      }
      if (this.jdField_a_of_type_AndroidWidgetTextView == null)
      {
        e();
        this.jdField_a_of_type_Int = TextViewCompat.getMaxLines(this.jdField_a_of_type_AndroidWidgetTextView);
      }
      TextViewCompat.setTextAppearance(this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout.e);
      if (this.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout.jdField_a_of_type_AndroidContentResColorStateList != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout.jdField_a_of_type_AndroidContentResColorStateList);
      }
      a(this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_a_of_type_AndroidWidgetImageView);
      f();
      a(this.jdField_a_of_type_AndroidWidgetImageView);
      a(this.jdField_a_of_type_AndroidWidgetTextView);
    }
    else if ((this.jdField_b_of_type_AndroidWidgetTextView != null) || (this.jdField_b_of_type_AndroidWidgetImageView != null))
    {
      a(this.jdField_b_of_type_AndroidWidgetTextView, this.jdField_b_of_type_AndroidWidgetImageView);
    }
    if ((localTab != null) && (!TextUtils.isEmpty(TabLayout.Tab.a(localTab)))) {
      setContentDescription(TabLayout.Tab.a(localTab));
    }
    boolean bool;
    if ((localTab != null) && (localTab.a())) {
      bool = true;
    } else {
      bool = false;
    }
    setSelected(bool);
  }
  
  final void c()
  {
    setOrientation(this.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout.jdField_a_of_type_Boolean ^ true);
    if ((this.jdField_b_of_type_AndroidWidgetTextView == null) && (this.jdField_b_of_type_AndroidWidgetImageView == null))
    {
      a(this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_a_of_type_AndroidWidgetImageView);
      return;
    }
    a(this.jdField_b_of_type_AndroidWidgetTextView, this.jdField_b_of_type_AndroidWidgetImageView);
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    int[] arrayOfInt = getDrawableState();
    Drawable localDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localDrawable != null)
    {
      bool1 = bool2;
      if (localDrawable.isStateful()) {
        bool1 = false | this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setState(arrayOfInt);
      }
    }
    if (bool1)
    {
      invalidate();
      this.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout.invalidate();
    }
  }
  
  public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    Object localObject = this.jdField_a_of_type_ComGoogleAndroidMaterialBadgeBadgeDrawable;
    if ((localObject != null) && (((BadgeDrawable)localObject).isVisible()))
    {
      localObject = getContentDescription();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(localObject);
      localStringBuilder.append(", ");
      localStringBuilder.append(this.jdField_a_of_type_ComGoogleAndroidMaterialBadgeBadgeDrawable.a());
      paramAccessibilityNodeInfo.setContentDescription(localStringBuilder.toString());
    }
    paramAccessibilityNodeInfo = AccessibilityNodeInfoCompat.wrap(paramAccessibilityNodeInfo);
    paramAccessibilityNodeInfo.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(0, 1, this.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout$Tab.a(), 1, false, isSelected()));
    if (isSelected())
    {
      paramAccessibilityNodeInfo.setClickable(false);
      paramAccessibilityNodeInfo.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLICK);
    }
    paramAccessibilityNodeInfo.setRoleDescription(getResources().getString(R.string.h));
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    int j = View.MeasureSpec.getSize(paramInt1);
    int k = View.MeasureSpec.getMode(paramInt1);
    int m = this.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout.c();
    int i = paramInt1;
    if (m > 0) {
      if (k != 0)
      {
        i = paramInt1;
        if (j <= m) {}
      }
      else
      {
        i = View.MeasureSpec.makeMeasureSpec(this.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout.g, -2147483648);
      }
    }
    super.onMeasure(i, paramInt2);
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      float f2 = this.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout.jdField_a_of_type_Float;
      j = this.jdField_a_of_type_Int;
      Object localObject = this.jdField_a_of_type_AndroidWidgetImageView;
      k = 1;
      float f1;
      if ((localObject != null) && (((ImageView)localObject).getVisibility() == 0))
      {
        paramInt1 = 1;
        f1 = f2;
      }
      else
      {
        localObject = this.jdField_a_of_type_AndroidWidgetTextView;
        f1 = f2;
        paramInt1 = j;
        if (localObject != null)
        {
          f1 = f2;
          paramInt1 = j;
          if (((TextView)localObject).getLineCount() > 1)
          {
            f1 = this.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout.jdField_b_of_type_Float;
            paramInt1 = j;
          }
        }
      }
      f2 = this.jdField_a_of_type_AndroidWidgetTextView.getTextSize();
      m = this.jdField_a_of_type_AndroidWidgetTextView.getLineCount();
      j = TextViewCompat.getMaxLines(this.jdField_a_of_type_AndroidWidgetTextView);
      if ((f1 != f2) || ((j >= 0) && (paramInt1 != j)))
      {
        j = k;
        if (this.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout.k == 1)
        {
          j = k;
          if (f1 > f2)
          {
            j = k;
            if (m == 1)
            {
              localObject = this.jdField_a_of_type_AndroidWidgetTextView.getLayout();
              if (localObject != null)
              {
                j = k;
                if (a((Layout)localObject, 0, f1) <= getMeasuredWidth() - getPaddingLeft() - getPaddingRight()) {}
              }
              else
              {
                j = 0;
              }
            }
          }
        }
        if (j != 0)
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, f1);
          this.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(paramInt1);
          super.onMeasure(i, paramInt2);
        }
      }
    }
  }
  
  public boolean performClick()
  {
    boolean bool2 = super.performClick();
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout$Tab != null)
    {
      if (!bool2) {
        playSoundEffect(0);
      }
      this.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout$Tab.a();
      bool1 = true;
    }
    return bool1;
  }
  
  public void setSelected(boolean paramBoolean)
  {
    int i;
    if (isSelected() != paramBoolean) {
      i = 1;
    } else {
      i = 0;
    }
    super.setSelected(paramBoolean);
    if ((i != 0) && (paramBoolean) && (Build.VERSION.SDK_INT < 16)) {
      sendAccessibilityEvent(4);
    }
    Object localObject = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localObject != null) {
      ((TextView)localObject).setSelected(paramBoolean);
    }
    localObject = this.jdField_a_of_type_AndroidWidgetImageView;
    if (localObject != null) {
      ((ImageView)localObject).setSelected(paramBoolean);
    }
    localObject = this.jdField_b_of_type_AndroidViewView;
    if (localObject != null) {
      ((View)localObject).setSelected(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.tabs.TabLayout.TabView
 * JD-Core Version:    0.7.0.1
 */