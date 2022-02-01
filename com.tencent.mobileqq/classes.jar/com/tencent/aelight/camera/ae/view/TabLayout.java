package com.tencent.aelight.camera.ae.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.DrawableRes;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;
import com.tencent.aelight.camera.ae.util.AEThemeUtil;
import java.util.ArrayList;
import java.util.List;

public class TabLayout
  extends RelativeLayout
{
  private List<TabLayout.TabView> a = new ArrayList();
  private View b = new View(getContext());
  private LinearLayout c = new LinearLayout(getContext());
  private int d;
  private ViewPager e;
  private ViewPager2 f;
  private TabLayout.OnTabSelectedCallback g;
  private boolean h = AEThemeUtil.b();
  private boolean i = false;
  @DrawableRes
  private int j;
  
  public TabLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TabLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TabLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = new RelativeLayout.LayoutParams(-1, -1);
    addView(this.c, paramContext);
  }
  
  public static int a(Context paramContext, float paramFloat)
  {
    if (paramContext == null) {
      return 0;
    }
    return (int)(paramFloat * paramContext.getResources().getDisplayMetrics().density + 0.5F);
  }
  
  private void a()
  {
    this.j = 2063925373;
    this.b.setBackgroundResource(this.j);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(a(getContext(), 7.0F), a(getContext(), 7.0F));
    localLayoutParams.addRule(12);
    addView(this.b, localLayoutParams);
  }
  
  private void b(int paramInt)
  {
    Object localObject = this.g;
    if (localObject != null) {
      ((TabLayout.OnTabSelectedCallback)localObject).a(paramInt);
    }
    int k = 0;
    while (k < this.a.size())
    {
      localObject = (TabLayout.TabView)this.a.get(k);
      boolean bool2 = true;
      boolean bool1 = true;
      if (paramInt == 0)
      {
        if (paramInt != k) {
          bool1 = false;
        }
        ((TabLayout.TabView)localObject).a(bool1, false);
      }
      else
      {
        if (paramInt == k) {
          bool1 = bool2;
        } else {
          bool1 = false;
        }
        ((TabLayout.TabView)localObject).a(bool1, this.i);
      }
      k += 1;
    }
    if (this.d == 0) {
      k = this.j;
    } else if (this.i) {
      k = 2063925372;
    } else {
      k = this.j;
    }
    this.b.setBackgroundResource(k);
    localObject = this.e;
    if (localObject != null) {
      ((ViewPager)localObject).setCurrentItem(paramInt);
    }
    localObject = this.f;
    if (localObject != null) {
      ((ViewPager2)localObject).setCurrentItem(paramInt);
    }
  }
  
  private void c(int paramInt)
  {
    float f1 = this.b.getX();
    float f2 = ((TabLayout.TabView)this.a.get(paramInt)).getX();
    float f3 = ((TabLayout.TabView)this.a.get(paramInt)).getWidth() / 2.0F;
    float f4 = this.b.getWidth() / 2.0F;
    ObjectAnimator.ofFloat(this.b, "x", new float[] { f1, f2 + f3 - f4 }).setDuration(250L).start();
  }
  
  public void a(int paramInt)
  {
    if (paramInt >= this.a.size()) {
      return;
    }
    if (paramInt == this.d) {
      return;
    }
    TabLayout.OnTabSelectedCallback localOnTabSelectedCallback = this.g;
    if ((localOnTabSelectedCallback != null) && (!localOnTabSelectedCallback.b(paramInt)))
    {
      this.g.a(paramInt);
      return;
    }
    this.d = paramInt;
    c(paramInt);
    b(paramInt);
  }
  
  public void a(ViewPager paramViewPager)
  {
    this.e = paramViewPager;
    paramViewPager.setOnPageChangeListener(new TabLayout.3(this));
  }
  
  public void a(boolean paramBoolean)
  {
    this.i = paramBoolean;
    int k = 0;
    while (k < this.a.size())
    {
      TabLayout.TabView localTabView = (TabLayout.TabView)this.a.get(k);
      int m = this.d;
      boolean bool = true;
      paramBoolean = true;
      if (m == 0)
      {
        if (m != k) {
          paramBoolean = false;
        }
        localTabView.a(paramBoolean, false);
      }
      else
      {
        if (m == k) {
          paramBoolean = bool;
        } else {
          paramBoolean = false;
        }
        localTabView.a(paramBoolean, this.i);
      }
      k += 1;
    }
    if (this.d == 0) {
      k = this.j;
    } else if (this.i) {
      k = 2063925372;
    } else {
      k = this.j;
    }
    this.b.setBackgroundResource(k);
  }
  
  public void setTabSelectedCallback(TabLayout.OnTabSelectedCallback paramOnTabSelectedCallback)
  {
    this.g = paramOnTabSelectedCallback;
  }
  
  public void setTabs(List<String> paramList, int paramInt)
  {
    if (paramList != null)
    {
      if (paramList.size() < 1) {
        return;
      }
      int m = paramList.size();
      this.c.setWeightSum(m);
      int k = 0;
      while (k < m)
      {
        TabLayout.TabView localTabView = new TabLayout.TabView(getContext(), this.h);
        localTabView.a().setText((CharSequence)paramList.get(k));
        boolean bool;
        if (paramInt == k) {
          bool = true;
        } else {
          bool = false;
        }
        localTabView.a(bool, this.i);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -1);
        localLayoutParams.weight = 1.0F;
        this.c.addView(localTabView, localLayoutParams);
        this.a.add(localTabView);
        localTabView.setOnClickListener(new TabLayout.1(this, k));
        k += 1;
      }
      a();
      if (paramList.size() > 1) {
        ((TabLayout.TabView)this.a.get(0)).post(new TabLayout.2(this, paramInt));
      }
      this.d = paramInt;
      paramInt = this.d;
      if (paramInt != 0) {
        b(paramInt);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.view.TabLayout
 * JD-Core Version:    0.7.0.1
 */