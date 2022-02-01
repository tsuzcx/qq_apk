package com.tencent.biz.lebasearch.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class ScrolledTabHost
  extends FrameLayout
  implements View.OnClickListener
{
  Context a;
  ViewGroup b;
  HorizontalScrollView c;
  View d;
  List<View> e = new ArrayList();
  ScrolledTabHost.OnTabSelectedListener f;
  int g = 0;
  
  public ScrolledTabHost(Context paramContext)
  {
    super(paramContext);
    this.a = paramContext;
    c();
  }
  
  public ScrolledTabHost(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.a = paramContext;
    c();
  }
  
  public ScrolledTabHost(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.a = paramContext;
    c();
  }
  
  private void c()
  {
    LayoutInflater.from(this.a).inflate(2131627231, this);
    this.b = ((ViewGroup)findViewById(2131446747));
    this.c = ((HorizontalScrollView)findViewById(2131446761));
    this.d = findViewById(2131433425);
  }
  
  public View a(int paramInt)
  {
    return this.b.getChildAt(paramInt);
  }
  
  public void a()
  {
    int i = 0;
    while (i < this.b.getChildCount())
    {
      View localView = this.b.getChildAt(i);
      localView.findViewById(2131446734).setVisibility(4);
      this.e.add(localView);
      i += 1;
    }
    b(0);
    this.b.removeAllViews();
    this.g = 0;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    View localView1 = a(paramInt1);
    View localView2 = a(paramInt2);
    localView1 = localView1.findViewById(2131446734);
    localView2 = localView2.findViewById(2131446734);
    if (paramInt1 == paramInt2)
    {
      localView2.setVisibility(0);
      return;
    }
    Object localObject1 = new int[2];
    int[] arrayOfInt = new int[2];
    localView1.getLocationInWindow((int[])localObject1);
    localView2.getLocationInWindow(arrayOfInt);
    Object localObject2 = new int[2];
    this.b.getLocationInWindow((int[])localObject2);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.d.getLayoutParams();
    localLayoutParams.leftMargin = (localObject1[0] - localObject2[0]);
    localLayoutParams.width = localView2.getMeasuredWidth();
    this.d.setLayoutParams(localLayoutParams);
    localObject2 = new AnimationSet(false);
    localObject1 = new TranslateAnimation(0.0F, arrayOfInt[0] - localObject1[0], 0.0F, 0.0F);
    ((TranslateAnimation)localObject1).setDuration(300L);
    ((TranslateAnimation)localObject1).setFillAfter(false);
    ((AnimationSet)localObject2).addAnimation((Animation)localObject1);
    ((AnimationSet)localObject2).setAnimationListener(new ScrolledTabHost.1(this, localView1, localView2, paramInt2));
    this.d.setVisibility(0);
    localView1.setVisibility(4);
    this.d.startAnimation((Animation)localObject2);
  }
  
  public void a(String paramString)
  {
    View localView;
    if (this.e.size() == 0) {
      localView = LayoutInflater.from(getContext()).inflate(2131627235, null);
    } else {
      localView = (View)this.e.remove(0);
    }
    ((TextView)localView.findViewById(2131448814)).setText(paramString);
    localView.setTag(-3, paramString);
    if (localView.getParent() != null) {
      return;
    }
    localView.findViewById(2131446734).setVisibility(4);
    this.b.addView(localView);
    localView.setOnClickListener(this);
  }
  
  public void b()
  {
    if (this.b != null)
    {
      this.g = 0;
      int i = 0;
      while (i < this.b.getChildCount())
      {
        localObject = this.b.getChildAt(i).findViewById(2131446734);
        if (i == 0) {
          ((View)localObject).setVisibility(0);
        } else {
          ((View)localObject).setVisibility(4);
        }
        i += 1;
      }
      Object localObject = this.f;
      if (localObject != null) {
        ((ScrolledTabHost.OnTabSelectedListener)localObject).a(0);
      }
    }
  }
  
  public void b(int paramInt)
  {
    Object localObject = a(paramInt);
    if (localObject == null) {
      return;
    }
    int i = ((View)localObject).getWidth();
    int[] arrayOfInt = new int[2];
    ((View)localObject).getLocationInWindow(arrayOfInt);
    int j = 0;
    int m = arrayOfInt[0];
    int k = this.a.getResources().getDisplayMetrics().widthPixels;
    if (m < 0)
    {
      this.c.smoothScrollBy(m, 0);
      i = j;
    }
    else
    {
      m += i;
      i = j;
      if (m > k)
      {
        this.c.smoothScrollBy(m - k, 0);
        i = j;
      }
    }
    while (i < this.b.getChildCount())
    {
      localObject = (TextView)this.b.getChildAt(i).findViewById(2131448814);
      if (i == paramInt) {
        ((TextView)localObject).setTextColor(getResources().getColor(2131167999));
      } else {
        ((TextView)localObject).setTextColor(getResources().getColor(2131168119));
      }
      i += 1;
    }
  }
  
  public void onClick(View paramView)
  {
    ScrolledTabHost.OnTabSelectedListener localOnTabSelectedListener = this.f;
    if (localOnTabSelectedListener != null)
    {
      localOnTabSelectedListener.a(this.b.indexOfChild(paramView));
      this.f.b(this.b.indexOfChild(paramView));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void setCurrentTab(int paramInt)
  {
    if (paramInt >= 0)
    {
      if (paramInt >= this.b.getChildCount()) {
        return;
      }
      int j = this.g;
      this.g = paramInt;
      Object localObject = this.f;
      if (localObject != null) {
        ((ScrolledTabHost.OnTabSelectedListener)localObject).a(paramInt);
      }
      int i = 0;
      while (i < this.b.getChildCount())
      {
        localObject = (TextView)this.b.getChildAt(i).findViewById(2131448814);
        if (i == paramInt) {
          ((TextView)localObject).setTextColor(getResources().getColor(2131167999));
        } else {
          ((TextView)localObject).setTextColor(getResources().getColor(2131168119));
        }
        i += 1;
      }
      a(j, this.g);
    }
  }
  
  public void setOnTabSelectedListener(ScrolledTabHost.OnTabSelectedListener paramOnTabSelectedListener)
  {
    this.f = paramOnTabSelectedListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.lebasearch.widget.ScrolledTabHost
 * JD-Core Version:    0.7.0.1
 */