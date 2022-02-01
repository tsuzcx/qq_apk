package com.tencent.biz.subscribe.account_folder.recommend_banner;

import aabg;
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
  private int jdField_a_of_type_Int;
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  private View jdField_a_of_type_AndroidViewView;
  private TopGestureLayout jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
  private int b;
  private int c;
  private int d;
  
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
    this.jdField_a_of_type_Int = ViewConfiguration.get(getContext()).getScaledTouchSlop();
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout == null)
    {
      ViewGroup localViewGroup = (ViewGroup)((Activity)getContext()).getWindow().getDecorView();
      View localView = localViewGroup.getChildAt(0);
      Object localObject = localViewGroup;
      if (localView != null)
      {
        localObject = localViewGroup;
        if ((localView instanceof DragFrameLayout)) {
          localObject = (ViewGroup)localView;
        }
      }
      localObject = ((ViewGroup)localObject).getChildAt(0);
      if ((localObject instanceof TopGestureLayout)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout = ((TopGestureLayout)localObject);
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setInterceptTouchEventListener(new aabg(this));
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    int j = paramMotionEvent.getActionIndex();
    switch (i)
    {
    case 1: 
    default: 
      return super.onInterceptTouchEvent(paramMotionEvent);
    case 0: 
      this.c = ((int)(paramMotionEvent.getX() + 0.5F));
      this.d = ((int)(paramMotionEvent.getY() + 0.5F));
      this.b = MotionEventCompat.findPointerIndex(paramMotionEvent, j);
    }
    do
    {
      return super.onInterceptTouchEvent(paramMotionEvent);
      j = (int)(paramMotionEvent.getX() + 0.5F);
      i = (int)(paramMotionEvent.getY() + 0.5F);
      j -= this.c;
      i = (int)((i - this.d) * 0.6F);
      if ((Math.abs(j) > this.jdField_a_of_type_Int) && (Math.abs(j) >= Math.abs(i))) {
        return false;
      }
    } while ((Math.abs(j) <= this.jdField_a_of_type_Int) || (Math.abs(i) <= Math.abs(j)));
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public void setConflictView(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.account_folder.recommend_banner.SubScribeSwipeRefreshLayout
 * JD-Core Version:    0.7.0.1
 */