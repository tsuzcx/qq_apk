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
  private TabLayout.TabAdapter a;
  private Map<Integer, View> b = new HashMap();
  private Map<Integer, Integer> c = new HashMap();
  private boolean d = false;
  private Function1<Canvas, Unit> e = new TabLayout.3(this);
  private Function1<Canvas, Unit> f = new TabLayout.4(this);
  
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
  
  @Nullable
  public View a(int paramInt)
  {
    return (View)this.b.get(Integer.valueOf(paramInt));
  }
  
  public void a()
  {
    TabLayout.TabAdapter localTabAdapter = this.a;
    if ((localTabAdapter != null) && (!this.d)) {
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
      this.d = false;
      a();
      return;
    }
    this.d = true;
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
    this.d = false;
    a();
  }
  
  public int b(int paramInt)
  {
    if (paramInt < this.b.size())
    {
      View localView = (View)this.b.get(Integer.valueOf(paramInt));
      if (localView != null) {
        return localView.getMeasuredWidth();
      }
    }
    return 0;
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    ((IRIJBlackWhiteModeHelper)QRoute.api(IRIJBlackWhiteModeHelper.class)).addBlackWhiteMode(paramCanvas, true, this.f);
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
    ((IRIJBlackWhiteModeHelper)QRoute.api(IRIJBlackWhiteModeHelper.class)).addBlackWhiteMode(paramCanvas, true, this.e);
  }
  
  public int getChildSize()
  {
    return this.b.size();
  }
  
  public void setAdapter(TabLayout.TabAdapter paramTabAdapter)
  {
    super.setAdapter(paramTabAdapter);
    this.a = paramTabAdapter;
    this.a.a(this);
  }
  
  public void setChildView(int paramInt, View paramView)
  {
    this.b.put(Integer.valueOf(paramInt), paramView);
  }
  
  public void setChildWidth(int paramInt1, int paramInt2)
  {
    this.c.put(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
  }
  
  public void setSwappingAnimation()
  {
    this.d = true;
  }
  
  public void smoothScrollToPositionFromLeftOrRight(int paramInt1, int paramInt2, int paramInt3)
  {
    super.smoothScrollToPositionFromLeftOrRight(paramInt1, paramInt2, paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.widgets.TabLayout
 * JD-Core Version:    0.7.0.1
 */