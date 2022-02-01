package com.tencent.mobileqq.activity.contacts.topentry;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.widget.HorizontalListView;

public class CTEntryListView
  extends HorizontalListView
{
  private int jdField_a_of_type_Int;
  private boolean jdField_a_of_type_Boolean;
  private int b;
  
  public CTEntryListView(Context paramContext)
  {
    super(paramContext);
  }
  
  public CTEntryListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    boolean bool1 = false;
    if (i == 0)
    {
      this.jdField_a_of_type_Int = ((int)(paramMotionEvent.getX() + 0.5F));
      this.b = ((int)(paramMotionEvent.getY() + 0.5F));
      this.jdField_a_of_type_Boolean = true;
      FrameHelperActivity.b(false);
    }
    else if (i == 2)
    {
      i = (int)(paramMotionEvent.getX() + 0.5F);
      int j = (int)(paramMotionEvent.getY() + 0.5F);
      i = Math.abs(i - this.jdField_a_of_type_Int);
      j = Math.abs(j - this.b);
      int k = ViewConfiguration.get(getContext()).getScaledTouchSlop();
      if ((this.jdField_a_of_type_Boolean) && (i > k))
      {
        if ((j / i < 0.6F) && (this.jdField_a_of_type_Int > (int)(ScreenUtil.SCREEN_WIDTH * 0.1F))) {
          i = 1;
        } else {
          i = 0;
        }
        if (i == 0) {
          FrameHelperActivity.b(true);
        }
        this.jdField_a_of_type_Boolean = false;
        break label186;
      }
    }
    else if ((i == 1) || (i == 3))
    {
      FrameHelperActivity.b(true);
      this.jdField_a_of_type_Boolean = false;
    }
    i = 0;
    label186:
    if (i == 0) {}
    try
    {
      boolean bool2 = super.onInterceptTouchEvent(paramMotionEvent);
      if (bool2) {
        bool1 = true;
      }
      return bool1;
    }
    catch (Exception paramMotionEvent) {}
    return false;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i == 0)
    {
      FrameHelperActivity.b(false);
    }
    else if ((i == 1) || (i == 3))
    {
      FrameHelperActivity.b(true);
      this.jdField_a_of_type_Boolean = false;
    }
    try
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      return bool;
    }
    catch (Exception paramMotionEvent) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.topentry.CTEntryListView
 * JD-Core Version:    0.7.0.1
 */