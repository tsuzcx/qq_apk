package com.tencent.aelight.camera.ae.flashshow.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.aelight.camera.log.AEQLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TabLayout
  extends FrameLayout
{
  private View a;
  private LinearLayout b;
  private final List<TabLayout.TabItemHolder> c = new ArrayList();
  private int d = 1;
  private int e;
  private TabLayout.OnTabSelectedCallback f;
  private ValueAnimator g = null;
  private int h = 0;
  private int i = 0;
  
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
    setLayerType(1, null);
    a(paramContext);
    b(paramContext);
  }
  
  private void a()
  {
    int j = this.e;
    if (j >= 0)
    {
      if (j >= this.c.size()) {
        return;
      }
      if (this.a.getVisibility() != 0) {
        return;
      }
      Object localObject = (TabLayout.TabItemHolder)this.c.get(this.e);
      if (this.g == null) {
        j = ((TabLayout.TabItemHolder)localObject).d.getTop() + ((TabLayout.TabItemHolder)localObject).b.getTop();
      } else {
        j = this.i;
      }
      int k;
      if (this.g == null) {
        k = ((TabLayout.TabItemHolder)localObject).d.getLeft() + ((TabLayout.TabItemHolder)localObject).b.getLeft();
      } else {
        k = this.h;
      }
      localObject = this.a;
      ((View)localObject).offsetLeftAndRight(k - ((View)localObject).getLeft());
      localObject = this.a;
      ((View)localObject).offsetTopAndBottom(j - ((View)localObject).getTop());
    }
  }
  
  private void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.e = paramInt;
    Object localObject1 = this.c.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      TabLayout.TabItemHolder localTabItemHolder = (TabLayout.TabItemHolder)((Iterator)localObject1).next();
      Object localObject2 = localTabItemHolder.b;
      boolean bool;
      if (localTabItemHolder.a == paramInt) {
        bool = true;
      } else {
        bool = false;
      }
      ((View)localObject2).setSelected(bool);
      localObject2 = localTabItemHolder.c;
      int j = localTabItemHolder.a;
      ((TextView)localObject2).setTextSize(1, 16.0F);
    }
    if (paramBoolean1) {
      b();
    }
    if (paramBoolean2)
    {
      localObject1 = this.f;
      if (localObject1 != null) {
        ((TabLayout.OnTabSelectedCallback)localObject1).a(paramInt);
      }
    }
  }
  
  private void a(Context paramContext)
  {
    this.b = new LinearLayout(paramContext);
    this.b.setOrientation(0);
    addView(this.b, new FrameLayout.LayoutParams(-1, -1));
  }
  
  private void b()
  {
    Object localObject = this.g;
    if (localObject != null) {
      ((ValueAnimator)localObject).cancel();
    }
    localObject = (TabLayout.TabItemHolder)this.c.get(this.e);
    int j = this.a.getLeft();
    int k = this.a.getTop();
    int m = ((TabLayout.TabItemHolder)localObject).d.getLeft() + ((TabLayout.TabItemHolder)localObject).b.getLeft();
    int n = ((TabLayout.TabItemHolder)localObject).d.getTop();
    int i1 = ((TabLayout.TabItemHolder)localObject).b.getTop();
    this.i = k;
    this.h = j;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("start animate dot view: initLeft = ");
    ((StringBuilder)localObject).append(j);
    ((StringBuilder)localObject).append(", finalLeft = ");
    ((StringBuilder)localObject).append(m);
    AEQLog.b("FS_TabLayout", ((StringBuilder)localObject).toString());
    this.g = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.g.setDuration(150L);
    this.g.setRepeatCount(0);
    this.g.addListener(new TabLayout.3(this));
    this.g.addUpdateListener(new TabLayout.4(this, j, m, k, n + i1));
    this.g.start();
  }
  
  private void b(int paramInt)
  {
    Object localObject = this.a;
    int j;
    if (paramInt == 0) {
      j = 2063925556;
    } else {
      j = 2063925555;
    }
    ((View)localObject).setBackgroundResource(j);
    localObject = this.c.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((TabLayout.TabItemHolder)((Iterator)localObject).next()).a(paramInt);
    }
  }
  
  private void b(Context paramContext)
  {
    this.a = new View(paramContext);
    paramContext = new FrameLayout.LayoutParams(a(6.0F), a(6.0F));
    addView(this.a, paramContext);
    this.a.setVisibility(8);
    getViewTreeObserver().addOnGlobalLayoutListener(new TabLayout.1(this));
  }
  
  public int a(float paramFloat)
  {
    return (int)TypedValue.applyDimension(1, paramFloat, getResources().getDisplayMetrics());
  }
  
  public void a(int paramInt)
  {
    if (this.d != paramInt)
    {
      this.d = paramInt;
      b(paramInt);
    }
  }
  
  public void setCallback(TabLayout.OnTabSelectedCallback paramOnTabSelectedCallback)
  {
    this.f = paramOnTabSelectedCallback;
  }
  
  public void setTabSelectCallback(TabLayout.OnTabSelectedCallback paramOnTabSelectedCallback)
  {
    this.f = paramOnTabSelectedCallback;
  }
  
  public void setTabs(@NonNull List<String> paramList, int paramInt)
  {
    Object localObject1 = this.a;
    if (paramList.size() > 0) {
      j = 0;
    } else {
      j = 8;
    }
    ((View)localObject1).setVisibility(j);
    localObject1 = this.c.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (TabLayout.TabItemHolder)((Iterator)localObject1).next();
      this.b.removeView(((TabLayout.TabItemHolder)localObject2).b);
    }
    this.c.clear();
    int j = 0;
    while (j < paramList.size())
    {
      localObject1 = (String)paramList.get(j);
      localObject2 = LayoutInflater.from(getContext()).inflate(2064056471, this.b, false);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, -1);
      localLayoutParams.weight = 1.0F;
      this.b.addView((View)localObject2, localLayoutParams);
      this.c.add(new TabLayout.TabItemHolder(this, (View)localObject2, (String)localObject1, j));
      ((View)localObject2).setOnClickListener(new TabLayout.2(this, j));
      j += 1;
    }
    b(this.d);
    a(paramInt, false, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.flashshow.view.TabLayout
 * JD-Core Version:    0.7.0.1
 */