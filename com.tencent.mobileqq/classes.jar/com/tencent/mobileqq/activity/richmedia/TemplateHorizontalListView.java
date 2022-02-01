package com.tencent.mobileqq.activity.richmedia;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.widget.HorizontalListView;
import com.tencent.widget.OverScroller;

public class TemplateHorizontalListView
  extends HorizontalListView
{
  public TemplateHorizontalListView(Context paramContext)
  {
    super(paramContext);
  }
  
  public TemplateHorizontalListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean checkScrollToChild()
  {
    if (!this.mStayDisplayOffsetZero) {}
    for (;;)
    {
      return false;
      if (getChildAt(0) != null)
      {
        int i = this.mNextX;
        if (this.mNextX != 0)
        {
          int j = getChildAt(1).getMeasuredWidth();
          int k = i % j;
          if (k <= j * 0.5D) {
            i -= k;
          }
          while (this.mScroller.springBack(this.mNextX + getScrollX(), 0, i, i, 0, 0))
          {
            invalidate();
            return true;
            i = i - k + j;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.TemplateHorizontalListView
 * JD-Core Version:    0.7.0.1
 */