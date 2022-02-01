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
  private TabLayout.Tab b;
  private TextView c;
  private ImageView d;
  @Nullable
  private View e;
  @Nullable
  private BadgeDrawable f;
  @Nullable
  private View g;
  @Nullable
  private TextView h;
  @Nullable
  private ImageView i;
  @Nullable
  private Drawable j;
  private int k = 2;
  
  public TabLayout$TabView(TabLayout paramTabLayout, @NonNull Context paramContext)
  {
    super(paramContext);
    a(paramContext);
    ViewCompat.setPaddingRelative(this, paramTabLayout.b, paramTabLayout.c, paramTabLayout.d, paramTabLayout.e);
    setGravity(17);
    setOrientation(paramTabLayout.t ^ true);
    setClickable(true);
    ViewCompat.setPointerIcon(this, PointerIconCompat.getSystemIcon(getContext(), 1002));
  }
  
  private float a(@NonNull Layout paramLayout, int paramInt, float paramFloat)
  {
    return paramLayout.getLineWidth(paramInt) * (paramFloat / paramLayout.getPaint().getTextSize());
  }
  
  private void a(Context paramContext)
  {
    if (this.a.n != 0)
    {
      this.j = AppCompatResources.getDrawable(paramContext, this.a.n);
      paramContext = this.j;
      if ((paramContext != null) && (paramContext.isStateful())) {
        this.j.setState(getDrawableState());
      }
    }
    else
    {
      this.j = null;
    }
    GradientDrawable localGradientDrawable = new GradientDrawable();
    ((GradientDrawable)localGradientDrawable).setColor(0);
    paramContext = localGradientDrawable;
    if (this.a.i != null)
    {
      paramContext = new GradientDrawable();
      paramContext.setCornerRadius(1.0E-005F);
      paramContext.setColor(-1);
      ColorStateList localColorStateList = RippleUtils.a(this.a.i);
      if (Build.VERSION.SDK_INT >= 21)
      {
        if (this.a.w) {
          localGradientDrawable = null;
        }
        if (this.a.w) {
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
    this.a.invalidate();
  }
  
  private void a(@NonNull Canvas paramCanvas)
  {
    Drawable localDrawable = this.j;
    if (localDrawable != null)
    {
      localDrawable.setBounds(getLeft(), getTop(), getRight(), getBottom());
      this.j.draw(paramCanvas);
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
    Object localObject1 = this.b;
    Object localObject2 = null;
    Drawable localDrawable;
    if ((localObject1 != null) && (((TabLayout.Tab)localObject1).b() != null)) {
      localDrawable = DrawableCompat.wrap(this.b.b()).mutate();
    } else {
      localDrawable = null;
    }
    localObject1 = this.b;
    if (localObject1 != null) {
      localObject1 = ((TabLayout.Tab)localObject1).d();
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
        if (TabLayout.Tab.d(this.b) == 1) {
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
      int m;
      if ((bool) && (paramImageView.getVisibility() == 0)) {
        m = (int)ViewUtils.a(getContext(), 8);
      } else {
        m = 0;
      }
      if (this.a.t)
      {
        if (m != MarginLayoutParamsCompat.getMarginEnd(paramTextView))
        {
          MarginLayoutParamsCompat.setMarginEnd(paramTextView, m);
          paramTextView.bottomMargin = 0;
          paramImageView.setLayoutParams(paramTextView);
          paramImageView.requestLayout();
        }
      }
      else if (m != paramTextView.bottomMargin)
      {
        paramTextView.bottomMargin = m;
        MarginLayoutParamsCompat.setMarginEnd(paramTextView, 0);
        paramImageView.setLayoutParams(paramTextView);
        paramImageView.requestLayout();
      }
    }
    paramImageView = this.b;
    paramTextView = localObject2;
    if (paramImageView != null) {
      paramTextView = TabLayout.Tab.b(paramImageView);
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
  
  private void b(@Nullable View paramView)
  {
    if (!i()) {
      return;
    }
    if (paramView != null)
    {
      a(false);
      BadgeUtils.a(this.f, paramView, d(paramView));
      this.e = paramView;
    }
  }
  
  private void c(@NonNull View paramView)
  {
    if ((i()) && (paramView == this.e)) {
      BadgeUtils.b(this.f, paramView, d(paramView));
    }
  }
  
  @Nullable
  private FrameLayout d(@NonNull View paramView)
  {
    ImageView localImageView = this.d;
    FrameLayout localFrameLayout = null;
    if ((paramView != localImageView) && (paramView != this.c)) {
      return null;
    }
    if (BadgeUtils.a) {
      localFrameLayout = (FrameLayout)paramView.getParent();
    }
    return localFrameLayout;
  }
  
  private void d()
  {
    Object localObject;
    if (BadgeUtils.a)
    {
      localObject = f();
      addView((View)localObject, 0);
    }
    else
    {
      localObject = this;
    }
    this.d = ((ImageView)LayoutInflater.from(getContext()).inflate(R.layout.c, (ViewGroup)localObject, false));
    ((ViewGroup)localObject).addView(this.d, 0);
  }
  
  private void e()
  {
    Object localObject;
    if (BadgeUtils.a)
    {
      localObject = f();
      addView((View)localObject);
    }
    else
    {
      localObject = this;
    }
    this.c = ((TextView)LayoutInflater.from(getContext()).inflate(R.layout.d, (ViewGroup)localObject, false));
    ((ViewGroup)localObject).addView(this.c);
  }
  
  @NonNull
  private FrameLayout f()
  {
    FrameLayout localFrameLayout = new FrameLayout(getContext());
    localFrameLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    return localFrameLayout;
  }
  
  private void g()
  {
    if (!i()) {
      return;
    }
    if (this.g != null)
    {
      h();
      return;
    }
    Object localObject1;
    Object localObject2;
    if (this.d != null)
    {
      localObject1 = this.b;
      if ((localObject1 != null) && (((TabLayout.Tab)localObject1).b() != null))
      {
        localObject1 = this.e;
        localObject2 = this.d;
        if (localObject1 != localObject2)
        {
          h();
          b(this.d);
          return;
        }
        c((View)localObject2);
        return;
      }
    }
    if (this.c != null)
    {
      localObject1 = this.b;
      if ((localObject1 != null) && (((TabLayout.Tab)localObject1).e() == 1))
      {
        localObject1 = this.e;
        localObject2 = this.c;
        if (localObject1 != localObject2)
        {
          h();
          b(this.c);
          return;
        }
        c((View)localObject2);
        return;
      }
    }
    h();
  }
  
  @Nullable
  private BadgeDrawable getBadge()
  {
    return this.f;
  }
  
  @NonNull
  private BadgeDrawable getOrCreateBadge()
  {
    if (this.f == null) {
      this.f = BadgeDrawable.a(getContext());
    }
    g();
    BadgeDrawable localBadgeDrawable = this.f;
    if (localBadgeDrawable != null) {
      return localBadgeDrawable;
    }
    throw new IllegalStateException("Unable to create badge");
  }
  
  private void h()
  {
    if (!i()) {
      return;
    }
    a(true);
    View localView = this.e;
    if (localView != null)
    {
      BadgeUtils.a(this.f, localView);
      this.e = null;
    }
  }
  
  private boolean i()
  {
    return this.f != null;
  }
  
  void a()
  {
    setTab(null);
    setSelected(false);
  }
  
  final void b()
  {
    TabLayout.Tab localTab = this.b;
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
      this.g = ((View)localObject1);
      localObject3 = this.c;
      if (localObject3 != null) {
        ((TextView)localObject3).setVisibility(8);
      }
      localObject3 = this.d;
      if (localObject3 != null)
      {
        ((ImageView)localObject3).setVisibility(8);
        this.d.setImageDrawable(null);
      }
      this.h = ((TextView)((View)localObject1).findViewById(16908308));
      localObject3 = this.h;
      if (localObject3 != null) {
        this.k = TextViewCompat.getMaxLines((TextView)localObject3);
      }
      this.i = ((ImageView)((View)localObject1).findViewById(16908294));
    }
    else
    {
      localObject1 = this.g;
      if (localObject1 != null)
      {
        removeView((View)localObject1);
        this.g = null;
      }
      this.h = null;
      this.i = null;
    }
    if (this.g == null)
    {
      if (this.d == null) {
        d();
      }
      localObject1 = localObject2;
      if (localTab != null)
      {
        localObject1 = localObject2;
        if (localTab.b() != null) {
          localObject1 = DrawableCompat.wrap(localTab.b()).mutate();
        }
      }
      if (localObject1 != null)
      {
        DrawableCompat.setTintList((Drawable)localObject1, this.a.h);
        if (this.a.k != null) {
          DrawableCompat.setTintMode((Drawable)localObject1, this.a.k);
        }
      }
      if (this.c == null)
      {
        e();
        this.k = TextViewCompat.getMaxLines(this.c);
      }
      TextViewCompat.setTextAppearance(this.c, this.a.f);
      if (this.a.g != null) {
        this.c.setTextColor(this.a.g);
      }
      a(this.c, this.d);
      g();
      a(this.d);
      a(this.c);
    }
    else if ((this.h != null) || (this.i != null))
    {
      a(this.h, this.i);
    }
    if ((localTab != null) && (!TextUtils.isEmpty(TabLayout.Tab.b(localTab)))) {
      setContentDescription(TabLayout.Tab.b(localTab));
    }
    boolean bool;
    if ((localTab != null) && (localTab.g())) {
      bool = true;
    } else {
      bool = false;
    }
    setSelected(bool);
  }
  
  final void c()
  {
    setOrientation(this.a.t ^ true);
    if ((this.h == null) && (this.i == null))
    {
      a(this.c, this.d);
      return;
    }
    a(this.h, this.i);
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    int[] arrayOfInt = getDrawableState();
    Drawable localDrawable = this.j;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localDrawable != null)
    {
      bool1 = bool2;
      if (localDrawable.isStateful()) {
        bool1 = false | this.j.setState(arrayOfInt);
      }
    }
    if (bool1)
    {
      invalidate();
      this.a.invalidate();
    }
  }
  
  int getContentHeight()
  {
    View[] arrayOfView = new View[3];
    Object localObject = this.c;
    int i1 = 0;
    arrayOfView[0] = localObject;
    arrayOfView[1] = this.d;
    arrayOfView[2] = this.g;
    int i6 = arrayOfView.length;
    int i2 = 0;
    int m = 0;
    int i3;
    for (int n = 0; i1 < i6; n = i3)
    {
      localObject = arrayOfView[i1];
      int i5 = i2;
      int i4 = m;
      i3 = n;
      if (localObject != null)
      {
        i5 = i2;
        i4 = m;
        i3 = n;
        if (((View)localObject).getVisibility() == 0)
        {
          if (n != 0) {
            m = Math.min(m, ((View)localObject).getTop());
          } else {
            m = ((View)localObject).getTop();
          }
          if (n != 0) {
            n = Math.max(i2, ((View)localObject).getBottom());
          } else {
            n = ((View)localObject).getBottom();
          }
          i3 = 1;
          i4 = m;
          i5 = n;
        }
      }
      i1 += 1;
      i2 = i5;
      m = i4;
    }
    return i2 - m;
  }
  
  int getContentWidth()
  {
    View[] arrayOfView = new View[3];
    Object localObject = this.c;
    int i1 = 0;
    arrayOfView[0] = localObject;
    arrayOfView[1] = this.d;
    arrayOfView[2] = this.g;
    int i6 = arrayOfView.length;
    int i2 = 0;
    int m = 0;
    int i3;
    for (int n = 0; i1 < i6; n = i3)
    {
      localObject = arrayOfView[i1];
      int i5 = i2;
      int i4 = m;
      i3 = n;
      if (localObject != null)
      {
        i5 = i2;
        i4 = m;
        i3 = n;
        if (((View)localObject).getVisibility() == 0)
        {
          if (n != 0) {
            m = Math.min(m, ((View)localObject).getLeft());
          } else {
            m = ((View)localObject).getLeft();
          }
          if (n != 0) {
            n = Math.max(i2, ((View)localObject).getRight());
          } else {
            n = ((View)localObject).getRight();
          }
          i3 = 1;
          i4 = m;
          i5 = n;
        }
      }
      i1 += 1;
      i2 = i5;
      m = i4;
    }
    return i2 - m;
  }
  
  @Nullable
  public TabLayout.Tab getTab()
  {
    return this.b;
  }
  
  public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    Object localObject = this.f;
    if ((localObject != null) && (((BadgeDrawable)localObject).isVisible()))
    {
      localObject = getContentDescription();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(localObject);
      localStringBuilder.append(", ");
      localStringBuilder.append(this.f.g());
      paramAccessibilityNodeInfo.setContentDescription(localStringBuilder.toString());
    }
    paramAccessibilityNodeInfo = AccessibilityNodeInfoCompat.wrap(paramAccessibilityNodeInfo);
    paramAccessibilityNodeInfo.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(0, 1, this.b.c(), 1, false, isSelected()));
    if (isSelected())
    {
      paramAccessibilityNodeInfo.setClickable(false);
      paramAccessibilityNodeInfo.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLICK);
    }
    paramAccessibilityNodeInfo.setRoleDescription(getResources().getString(R.string.h));
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    int n = View.MeasureSpec.getSize(paramInt1);
    int i1 = View.MeasureSpec.getMode(paramInt1);
    int i2 = this.a.getTabMaxWidth();
    int m = paramInt1;
    if (i2 > 0) {
      if (i1 != 0)
      {
        m = paramInt1;
        if (n <= i2) {}
      }
      else
      {
        m = View.MeasureSpec.makeMeasureSpec(this.a.o, -2147483648);
      }
    }
    super.onMeasure(m, paramInt2);
    if (this.c != null)
    {
      float f2 = this.a.l;
      n = this.k;
      Object localObject = this.d;
      i1 = 1;
      float f1;
      if ((localObject != null) && (((ImageView)localObject).getVisibility() == 0))
      {
        paramInt1 = 1;
        f1 = f2;
      }
      else
      {
        localObject = this.c;
        f1 = f2;
        paramInt1 = n;
        if (localObject != null)
        {
          f1 = f2;
          paramInt1 = n;
          if (((TextView)localObject).getLineCount() > 1)
          {
            f1 = this.a.m;
            paramInt1 = n;
          }
        }
      }
      f2 = this.c.getTextSize();
      i2 = this.c.getLineCount();
      n = TextViewCompat.getMaxLines(this.c);
      if ((f1 != f2) || ((n >= 0) && (paramInt1 != n)))
      {
        n = i1;
        if (this.a.s == 1)
        {
          n = i1;
          if (f1 > f2)
          {
            n = i1;
            if (i2 == 1)
            {
              localObject = this.c.getLayout();
              if (localObject != null)
              {
                n = i1;
                if (a((Layout)localObject, 0, f1) <= getMeasuredWidth() - getPaddingLeft() - getPaddingRight()) {}
              }
              else
              {
                n = 0;
              }
            }
          }
        }
        if (n != 0)
        {
          this.c.setTextSize(0, f1);
          this.c.setMaxLines(paramInt1);
          super.onMeasure(m, paramInt2);
        }
      }
    }
  }
  
  public boolean performClick()
  {
    boolean bool2 = super.performClick();
    boolean bool1 = bool2;
    if (this.b != null)
    {
      if (!bool2) {
        playSoundEffect(0);
      }
      this.b.f();
      bool1 = true;
    }
    return bool1;
  }
  
  public void setSelected(boolean paramBoolean)
  {
    int m;
    if (isSelected() != paramBoolean) {
      m = 1;
    } else {
      m = 0;
    }
    super.setSelected(paramBoolean);
    if ((m != 0) && (paramBoolean) && (Build.VERSION.SDK_INT < 16)) {
      sendAccessibilityEvent(4);
    }
    Object localObject = this.c;
    if (localObject != null) {
      ((TextView)localObject).setSelected(paramBoolean);
    }
    localObject = this.d;
    if (localObject != null) {
      ((ImageView)localObject).setSelected(paramBoolean);
    }
    localObject = this.g;
    if (localObject != null) {
      ((View)localObject).setSelected(paramBoolean);
    }
  }
  
  void setTab(@Nullable TabLayout.Tab paramTab)
  {
    if (paramTab != this.b)
    {
      this.b = paramTab;
      b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.tabs.TabLayout.TabView
 * JD-Core Version:    0.7.0.1
 */