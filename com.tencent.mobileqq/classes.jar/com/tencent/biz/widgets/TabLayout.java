package com.tencent.biz.widgets;

import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import com.tencent.widget.HorizontalListView;
import java.util.HashMap;
import java.util.Map;
import zhl;
import zhm;
import zhn;

public class TabLayout
  extends HorizontalListView
{
  private Map<Integer, View> jdField_a_of_type_JavaUtilMap = new HashMap();
  private zhn jdField_a_of_type_Zhn;
  private boolean jdField_a_of_type_Boolean;
  private Map<Integer, Integer> b = new HashMap();
  
  public TabLayout(Context paramContext)
  {
    super(paramContext);
    b();
  }
  
  public TabLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b();
  }
  
  public TabLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, false);
    b();
  }
  
  private void b()
  {
    setHorizontalScrollBarEnabled(false);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilMap.size();
  }
  
  public int a(int paramInt)
  {
    if (paramInt < this.jdField_a_of_type_JavaUtilMap.size()) {
      return ((View)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt))).getMeasuredWidth();
    }
    return 0;
  }
  
  public View a(int paramInt)
  {
    return (View)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_Zhn != null) && (!this.jdField_a_of_type_Boolean)) {
      this.jdField_a_of_type_Zhn.notifyDataSetChanged();
    }
  }
  
  public void a(int paramInt1, int paramInt2, Animator.AnimatorListener paramAnimatorListener)
  {
    int i = 0;
    if (paramInt2 < getFirstVisiblePosition())
    {
      paramAnimatorListener.onAnimationEnd(null);
      this.jdField_a_of_type_Boolean = false;
      a();
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    int j = getFirstVisiblePosition();
    int m = paramInt2 - getFirstVisiblePosition();
    View localView = getChildAt(paramInt1 - j);
    if (localView != null)
    {
      int n = localView.getWidth();
      int k;
      for (j = 0; i < paramInt1 - paramInt2; j = k)
      {
        localObject = getChildAt(i + m);
        k = j;
        if (localObject != null) {
          k = j + ((View)localObject).getWidth();
        }
        i += 1;
      }
      Object localObject = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      ((ValueAnimator)localObject).setDuration(500L);
      ((ValueAnimator)localObject).addUpdateListener(new zhl(this, paramInt1, paramInt2, m, n, localView, j));
      ((ValueAnimator)localObject).addListener(new zhm(this, paramAnimatorListener));
      ((ValueAnimator)localObject).start();
      return;
    }
    paramAnimatorListener.onAnimationEnd(null);
    this.jdField_a_of_type_Boolean = false;
    a();
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.dispatchTouchEvent(paramMotionEvent);
      getParent().requestDisallowInterceptTouchEvent(true);
      continue;
      getParent().requestDisallowInterceptTouchEvent(true);
    }
  }
  
  public void setAdapter(zhn paramzhn)
  {
    super.setAdapter(paramzhn);
    this.jdField_a_of_type_Zhn = paramzhn;
    this.jdField_a_of_type_Zhn.a(this);
  }
  
  public void setChildView(int paramInt, View paramView)
  {
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), paramView);
  }
  
  public void setChildWidth(int paramInt1, int paramInt2)
  {
    this.b.put(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
  }
  
  public void setSwappingAnimation()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void smoothScrollToPositionFromLeftOrRight(int paramInt1, int paramInt2, int paramInt3)
  {
    super.smoothScrollToPositionFromLeftOrRight(paramInt1, paramInt2, paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.widgets.TabLayout
 * JD-Core Version:    0.7.0.1
 */