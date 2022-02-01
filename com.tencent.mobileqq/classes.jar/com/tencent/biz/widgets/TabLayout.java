package com.tencent.biz.widgets;

import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.kandian.biz.common.api.IRIJBlackWhiteModeHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.widget.HorizontalListView;
import java.util.HashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

public class TabLayout
  extends HorizontalListView
{
  private TabLayout.TabAdapter jdField_a_of_type_ComTencentBizWidgetsTabLayout$TabAdapter;
  private Map<Integer, View> jdField_a_of_type_JavaUtilMap = new HashMap();
  private Function1<Canvas, Unit> jdField_a_of_type_KotlinJvmFunctionsFunction1 = new TabLayout.3(this);
  private boolean jdField_a_of_type_Boolean = false;
  private Map<Integer, Integer> jdField_b_of_type_JavaUtilMap = new HashMap();
  private Function1<Canvas, Unit> jdField_b_of_type_KotlinJvmFunctionsFunction1 = new TabLayout.4(this);
  
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
    if (paramInt < this.jdField_a_of_type_JavaUtilMap.size())
    {
      View localView = (View)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
      if (localView != null) {
        return localView.getMeasuredWidth();
      }
    }
    return 0;
  }
  
  @Nullable
  public View a(int paramInt)
  {
    return (View)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
  }
  
  public void a()
  {
    TabLayout.TabAdapter localTabAdapter = this.jdField_a_of_type_ComTencentBizWidgetsTabLayout$TabAdapter;
    if ((localTabAdapter != null) && (!this.jdField_a_of_type_Boolean)) {
      localTabAdapter.notifyDataSetChanged();
    }
  }
  
  public void a(int paramInt1, int paramInt2, Animator.AnimatorListener paramAnimatorListener)
  {
    int j = getFirstVisiblePosition();
    int i = 0;
    if (paramInt2 < j)
    {
      paramAnimatorListener.onAnimationEnd(null);
      this.jdField_a_of_type_Boolean = false;
      a();
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    j = getFirstVisiblePosition();
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
      ((ValueAnimator)localObject).addUpdateListener(new TabLayout.1(this, paramInt1, paramInt2, m, n, localView, j));
      ((ValueAnimator)localObject).addListener(new TabLayout.2(this, paramAnimatorListener));
      ((ValueAnimator)localObject).start();
      return;
    }
    paramAnimatorListener.onAnimationEnd(null);
    this.jdField_a_of_type_Boolean = false;
    a();
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    ((IRIJBlackWhiteModeHelper)QRoute.api(IRIJBlackWhiteModeHelper.class)).addBlackWhiteMode(paramCanvas, true, this.jdField_b_of_type_KotlinJvmFunctionsFunction1);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if (i == 2) {
        getParent().requestDisallowInterceptTouchEvent(true);
      }
    }
    else {
      getParent().requestDisallowInterceptTouchEvent(true);
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void draw(Canvas paramCanvas)
  {
    ((IRIJBlackWhiteModeHelper)QRoute.api(IRIJBlackWhiteModeHelper.class)).addBlackWhiteMode(paramCanvas, true, this.jdField_a_of_type_KotlinJvmFunctionsFunction1);
  }
  
  public void setAdapter(TabLayout.TabAdapter paramTabAdapter)
  {
    super.setAdapter(paramTabAdapter);
    this.jdField_a_of_type_ComTencentBizWidgetsTabLayout$TabAdapter = paramTabAdapter;
    this.jdField_a_of_type_ComTencentBizWidgetsTabLayout$TabAdapter.a(this);
  }
  
  public void setChildView(int paramInt, View paramView)
  {
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), paramView);
  }
  
  public void setChildWidth(int paramInt1, int paramInt2)
  {
    this.jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.widgets.TabLayout
 * JD-Core Version:    0.7.0.1
 */