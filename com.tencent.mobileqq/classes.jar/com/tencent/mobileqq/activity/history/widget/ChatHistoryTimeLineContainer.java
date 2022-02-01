package com.tencent.mobileqq.activity.history.widget;

import android.content.Context;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.AutoFitScrollView;

public class ChatHistoryTimeLineContainer
  extends RelativeLayout
{
  private AutoFitScrollView a;
  
  public ChatHistoryTimeLineContainer(Context paramContext)
  {
    super(paramContext);
  }
  
  public ChatHistoryTimeLineContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ChatHistoryTimeLineContainer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private boolean a(MotionEvent paramMotionEvent)
  {
    int[] arrayOfInt = new int[2];
    getLocationOnScreen(arrayOfInt);
    return new RectF(arrayOfInt[0], arrayOfInt[1], arrayOfInt[0] + getWidth(), arrayOfInt[1] + getHeight()).contains(paramMotionEvent.getRawX(), paramMotionEvent.getRawY());
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (a(paramMotionEvent))
    {
      if (paramMotionEvent.getAction() == 1)
      {
        AutoFitScrollView localAutoFitScrollView = this.a;
        if (localAutoFitScrollView != null) {
          localAutoFitScrollView.onTouchEvent(paramMotionEvent);
        }
      }
      getParent().requestDisallowInterceptTouchEvent(true);
      return false;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public void setScrollView(AutoFitScrollView paramAutoFitScrollView)
  {
    this.a = paramAutoFitScrollView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.widget.ChatHistoryTimeLineContainer
 * JD-Core Version:    0.7.0.1
 */