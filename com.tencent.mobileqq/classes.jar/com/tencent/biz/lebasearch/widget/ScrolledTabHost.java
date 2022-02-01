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
  int jdField_a_of_type_Int = 0;
  Context jdField_a_of_type_AndroidContentContext;
  View jdField_a_of_type_AndroidViewView;
  ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  HorizontalScrollView jdField_a_of_type_AndroidWidgetHorizontalScrollView;
  ScrolledTabHost.OnTabSelectedListener jdField_a_of_type_ComTencentBizLebasearchWidgetScrolledTabHost$OnTabSelectedListener;
  List<View> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public ScrolledTabHost(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    c();
  }
  
  public ScrolledTabHost(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    c();
  }
  
  public ScrolledTabHost(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    c();
  }
  
  private void c()
  {
    LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560890, this);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131378229));
    this.jdField_a_of_type_AndroidWidgetHorizontalScrollView = ((HorizontalScrollView)findViewById(2131378242));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131366979);
  }
  
  public View a(int paramInt)
  {
    return this.jdField_a_of_type_AndroidViewViewGroup.getChildAt(paramInt);
  }
  
  public void a()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_AndroidViewViewGroup.getChildCount())
    {
      View localView = this.jdField_a_of_type_AndroidViewViewGroup.getChildAt(i);
      localView.findViewById(2131378216).setVisibility(4);
      this.jdField_a_of_type_JavaUtilList.add(localView);
      i += 1;
    }
    a(0);
    this.jdField_a_of_type_AndroidViewViewGroup.removeAllViews();
    this.jdField_a_of_type_Int = 0;
  }
  
  public void a(int paramInt)
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
    int k = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().widthPixels;
    if (m < 0)
    {
      this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.smoothScrollBy(m, 0);
      i = j;
    }
    else
    {
      m += i;
      i = j;
      if (m > k)
      {
        this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.smoothScrollBy(m - k, 0);
        i = j;
      }
    }
    while (i < this.jdField_a_of_type_AndroidViewViewGroup.getChildCount())
    {
      localObject = (TextView)this.jdField_a_of_type_AndroidViewViewGroup.getChildAt(i).findViewById(2131379930);
      if (i == paramInt) {
        ((TextView)localObject).setTextColor(getResources().getColor(2131167061));
      } else {
        ((TextView)localObject).setTextColor(getResources().getColor(2131167139));
      }
      i += 1;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    View localView1 = a(paramInt1);
    View localView2 = a(paramInt2);
    localView1 = localView1.findViewById(2131378216);
    localView2 = localView2.findViewById(2131378216);
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
    this.jdField_a_of_type_AndroidViewViewGroup.getLocationInWindow((int[])localObject2);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    localLayoutParams.leftMargin = (localObject1[0] - localObject2[0]);
    localLayoutParams.width = localView2.getMeasuredWidth();
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
    localObject2 = new AnimationSet(false);
    localObject1 = new TranslateAnimation(0.0F, arrayOfInt[0] - localObject1[0], 0.0F, 0.0F);
    ((TranslateAnimation)localObject1).setDuration(300L);
    ((TranslateAnimation)localObject1).setFillAfter(false);
    ((AnimationSet)localObject2).addAnimation((Animation)localObject1);
    ((AnimationSet)localObject2).setAnimationListener(new ScrolledTabHost.1(this, localView1, localView2, paramInt2));
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    localView1.setVisibility(4);
    this.jdField_a_of_type_AndroidViewView.startAnimation((Animation)localObject2);
  }
  
  public void a(String paramString)
  {
    View localView;
    if (this.jdField_a_of_type_JavaUtilList.size() == 0) {
      localView = LayoutInflater.from(getContext()).inflate(2131560894, null);
    } else {
      localView = (View)this.jdField_a_of_type_JavaUtilList.remove(0);
    }
    ((TextView)localView.findViewById(2131379930)).setText(paramString);
    localView.setTag(-3, paramString);
    if (localView.getParent() != null) {
      return;
    }
    localView.findViewById(2131378216).setVisibility(4);
    this.jdField_a_of_type_AndroidViewViewGroup.addView(localView);
    localView.setOnClickListener(this);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      this.jdField_a_of_type_Int = 0;
      int i = 0;
      while (i < this.jdField_a_of_type_AndroidViewViewGroup.getChildCount())
      {
        localObject = this.jdField_a_of_type_AndroidViewViewGroup.getChildAt(i).findViewById(2131378216);
        if (i == 0) {
          ((View)localObject).setVisibility(0);
        } else {
          ((View)localObject).setVisibility(4);
        }
        i += 1;
      }
      Object localObject = this.jdField_a_of_type_ComTencentBizLebasearchWidgetScrolledTabHost$OnTabSelectedListener;
      if (localObject != null) {
        ((ScrolledTabHost.OnTabSelectedListener)localObject).a(0);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    ScrolledTabHost.OnTabSelectedListener localOnTabSelectedListener = this.jdField_a_of_type_ComTencentBizLebasearchWidgetScrolledTabHost$OnTabSelectedListener;
    if (localOnTabSelectedListener != null)
    {
      localOnTabSelectedListener.a(this.jdField_a_of_type_AndroidViewViewGroup.indexOfChild(paramView));
      this.jdField_a_of_type_ComTencentBizLebasearchWidgetScrolledTabHost$OnTabSelectedListener.b(this.jdField_a_of_type_AndroidViewViewGroup.indexOfChild(paramView));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void setCurrentTab(int paramInt)
  {
    if (paramInt >= 0)
    {
      if (paramInt >= this.jdField_a_of_type_AndroidViewViewGroup.getChildCount()) {
        return;
      }
      int j = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_Int = paramInt;
      Object localObject = this.jdField_a_of_type_ComTencentBizLebasearchWidgetScrolledTabHost$OnTabSelectedListener;
      if (localObject != null) {
        ((ScrolledTabHost.OnTabSelectedListener)localObject).a(paramInt);
      }
      int i = 0;
      while (i < this.jdField_a_of_type_AndroidViewViewGroup.getChildCount())
      {
        localObject = (TextView)this.jdField_a_of_type_AndroidViewViewGroup.getChildAt(i).findViewById(2131379930);
        if (i == paramInt) {
          ((TextView)localObject).setTextColor(getResources().getColor(2131167061));
        } else {
          ((TextView)localObject).setTextColor(getResources().getColor(2131167139));
        }
        i += 1;
      }
      a(j, this.jdField_a_of_type_Int);
    }
  }
  
  public void setOnTabSelectedListener(ScrolledTabHost.OnTabSelectedListener paramOnTabSelectedListener)
  {
    this.jdField_a_of_type_ComTencentBizLebasearchWidgetScrolledTabHost$OnTabSelectedListener = paramOnTabSelectedListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.lebasearch.widget.ScrolledTabHost
 * JD-Core Version:    0.7.0.1
 */