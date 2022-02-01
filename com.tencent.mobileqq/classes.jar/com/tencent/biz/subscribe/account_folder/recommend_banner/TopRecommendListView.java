package com.tencent.biz.subscribe.account_folder.recommend_banner;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.tencent.biz.subscribe.account_folder.top_pannel.TopPanelView;
import com.tencent.widget.SwipListView;

public class TopRecommendListView
  extends SwipListView
{
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private int b;
  private int c;
  private int d;
  
  public TopRecommendListView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public TopRecommendListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, 16842868);
    a();
  }
  
  public TopRecommendListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    this.jdField_a_of_type_Int = ViewConfiguration.get(getContext()).getScaledTouchSlop();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if (i != 2) {
        return super.onInterceptTouchEvent(paramMotionEvent);
      }
      if ((this.jdField_a_of_type_AndroidViewView instanceof TopPanelView))
      {
        if (this.b < 0) {
          return false;
        }
        int j = (int)(paramMotionEvent.getX() + 0.5F);
        i = (int)(paramMotionEvent.getY() + 0.5F);
        j -= this.c;
        i = (int)((i - this.d) * 0.6F);
        if ((Math.abs(j) > this.jdField_a_of_type_Int) && (Math.abs(j) >= Math.abs(i))) {
          return false;
        }
        if ((Math.abs(j) > this.jdField_a_of_type_Int) && (Math.abs(i) > Math.abs(j))) {
          return super.onInterceptTouchEvent(paramMotionEvent);
        }
      }
      else
      {
        return super.onInterceptTouchEvent(paramMotionEvent);
      }
    }
    else
    {
      this.c = ((int)(paramMotionEvent.getX() + 0.5F));
      this.d = ((int)(paramMotionEvent.getY() + 0.5F));
      this.b = pointToPosition(this.c, this.d);
      this.jdField_a_of_type_AndroidViewView = getChildAt(this.b - getFirstVisiblePosition());
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.account_folder.recommend_banner.TopRecommendListView
 * JD-Core Version:    0.7.0.1
 */