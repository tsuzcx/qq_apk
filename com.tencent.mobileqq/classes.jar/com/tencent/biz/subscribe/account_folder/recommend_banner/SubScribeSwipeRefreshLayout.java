package com.tencent.biz.subscribe.account_folder.recommend_banner;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;

public class SubScribeSwipeRefreshLayout
  extends SwipeRefreshLayout
{
  private Rect a;
  private int b;
  private int c;
  private int d;
  private int e;
  private View f;
  private TopGestureLayout g;
  
  public SubScribeSwipeRefreshLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SubScribeSwipeRefreshLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b();
  }
  
  private void b()
  {
    this.b = ViewConfiguration.get(getContext()).getScaledTouchSlop();
  }
  
  protected void a()
  {
    if (this.g == null)
    {
      ViewGroup localViewGroup = (ViewGroup)((Activity)getContext()).getWindow().getDecorView();
      View localView = localViewGroup.getChildAt(0);
      localObject = localViewGroup;
      if (localView != null)
      {
        localObject = localViewGroup;
        if ((localView instanceof DragFrameLayout)) {
          localObject = (ViewGroup)localView;
        }
      }
      localObject = ((ViewGroup)localObject).getChildAt(0);
      if ((localObject instanceof TopGestureLayout)) {
        this.g = ((TopGestureLayout)localObject);
      }
    }
    Object localObject = this.g;
    if (localObject != null) {
      ((TopGestureLayout)localObject).setInterceptTouchEventListener(new SubScribeSwipeRefreshLayout.1(this));
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    int j = paramMotionEvent.getActionIndex();
    if (i != 0)
    {
      if (i != 2) {
        return super.onInterceptTouchEvent(paramMotionEvent);
      }
      j = (int)(paramMotionEvent.getX() + 0.5F);
      i = (int)(paramMotionEvent.getY() + 0.5F);
      j -= this.d;
      i = (int)((i - this.e) * 0.6F);
      if ((Math.abs(j) > this.b) && (Math.abs(j) >= Math.abs(i))) {
        return false;
      }
      if ((Math.abs(j) > this.b) && (Math.abs(i) > Math.abs(j))) {
        return super.onInterceptTouchEvent(paramMotionEvent);
      }
    }
    else
    {
      this.d = ((int)(paramMotionEvent.getX() + 0.5F));
      this.e = ((int)(paramMotionEvent.getY() + 0.5F));
      this.c = MotionEventCompat.findPointerIndex(paramMotionEvent, j);
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public void setConflictView(View paramView)
  {
    this.f = paramView;
    this.a = new Rect();
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.account_folder.recommend_banner.SubScribeSwipeRefreshLayout
 * JD-Core Version:    0.7.0.1
 */