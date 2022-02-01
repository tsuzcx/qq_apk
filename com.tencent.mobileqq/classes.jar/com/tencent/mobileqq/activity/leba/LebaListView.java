package com.tencent.mobileqq.activity.leba;

import ajei;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import bjsd;
import com.tencent.mobileqq.fpsreport.FPSXListView;
import com.tencent.widget.ListView.OverscrollViewContainer;

public class LebaListView
  extends FPSXListView
{
  private ajei jdField_a_of_type_Ajei;
  private boolean jdField_a_of_type_Boolean;
  
  public LebaListView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public LebaListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842868);
  }
  
  public LebaListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mForHongBao = true;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.jdField_a_of_type_Ajei != null) && (this.jdField_a_of_type_Ajei.a(this, paramMotionEvent))) {}
    for (boolean bool = true;; bool = false)
    {
      if (paramMotionEvent.getAction() == 0) {
        this.jdField_a_of_type_Boolean = false;
      }
      if ((this.jdField_a_of_type_Boolean) && (!bool)) {
        paramMotionEvent.setAction(0);
      }
      this.jdField_a_of_type_Boolean = bool;
      if (bool) {
        return true;
      }
      return super.dispatchTouchEvent(paramMotionEvent);
    }
  }
  
  public int getSpringbackOffset()
  {
    int j = 0;
    int k = getScrollY();
    if ((this.mOverscrollHeaderViewContainer != null) && (k < 0)) {
      if (k <= -getOverScrollHeight() * 0.5F) {
        if (this.mOverScrollViewListener == null) {
          break label283;
        }
      }
    }
    label271:
    label277:
    label283:
    for (boolean bool = this.mOverScrollViewListener.onViewCompleteVisableAndReleased(0, this.mOverscrollHeaderViewContainer.getChildAt(0), this);; bool = false)
    {
      this.mOverscrollHeadState = 3;
      int i;
      if (bool)
      {
        i = j;
        if (this.mOverscrollHeaderViewContainer != null) {
          i = -getOverScrollHeight();
        }
      }
      do
      {
        do
        {
          do
          {
            return i;
            this.mOverscrollHeadState = 0;
            return 0;
            i = j;
          } while (this.mOverscrollHeadState >= 2);
          if (this.mOverScrollViewListener != null) {
            this.mOverScrollViewListener.onViewNotCompleteVisableAndReleased(0, this.mOverscrollHeaderViewContainer.getChildAt(0), this);
          }
          this.mOverscrollHeadState = 0;
          return 0;
          i = j;
        } while (this.mOverscrollFooterView == null);
        i = j;
      } while (k <= 0);
      if (k >= getOverScrollFooterHeight())
      {
        if (this.mOverscrollHeadState != 2) {
          break label277;
        }
        if (this.mOverScrollViewListener == null) {
          break label271;
        }
        bool = this.mOverScrollViewListener.onViewCompleteVisableAndReleased(1, this.mOverscrollFooterView.getChildAt(0), this);
        label197:
        this.mOverscrollHeadState = 3;
      }
      for (;;)
      {
        if (bool)
        {
          i = j;
          if (this.mOverscrollFooterView == null) {
            break;
          }
          return getOverScrollFooterHeight();
        }
        this.mOverscrollHeadState = 0;
        return 0;
        i = j;
        if (this.mOverscrollHeadState >= 2) {
          break;
        }
        if (this.mOverScrollViewListener != null) {
          this.mOverScrollViewListener.onViewNotCompleteVisableAndReleased(1, this.mOverscrollFooterView.getChildAt(0), this);
        }
        this.mOverscrollHeadState = 0;
        return 0;
        bool = false;
        break label197;
        bool = false;
      }
    }
  }
  
  public void setEventDispatchEventListener(ajei paramajei)
  {
    this.jdField_a_of_type_Ajei = paramajei;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.leba.LebaListView
 * JD-Core Version:    0.7.0.1
 */