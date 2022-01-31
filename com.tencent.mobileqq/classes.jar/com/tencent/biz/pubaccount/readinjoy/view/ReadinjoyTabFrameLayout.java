package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import azkz;
import com.tencent.mobileqq.app.FrameHelperActivity;
import java.util.ArrayList;
import java.util.List;

public class ReadinjoyTabFrameLayout
  extends FrameLayout
{
  private int jdField_a_of_type_Int;
  private List<View> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private int b;
  
  public ReadinjoyTabFrameLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public ReadinjoyTabFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private boolean a(View paramView, float paramFloat1, float paramFloat2)
  {
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    Rect localRect = new Rect();
    paramView.getLocalVisibleRect(localRect);
    int i = arrayOfInt[0] + localRect.left;
    int j = localRect.width();
    int k = arrayOfInt[1] + localRect.top;
    int m = localRect.height();
    return (i < paramFloat1) && (paramFloat1 < j + i) && (k < paramFloat2) && (paramFloat2 < m + k);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i == 0)
    {
      this.jdField_a_of_type_Int = ((int)(paramMotionEvent.getX() + 0.5F));
      this.b = ((int)(paramMotionEvent.getY() + 0.5F));
      i = 0;
      if (i < this.jdField_a_of_type_JavaUtilList.size()) {
        if (a((View)this.jdField_a_of_type_JavaUtilList.get(i), paramMotionEvent.getRawX(), paramMotionEvent.getRawY())) {
          FrameHelperActivity.c(false);
        }
      }
    }
    for (;;)
    {
      return false;
      i += 1;
      break;
      this.jdField_a_of_type_Boolean = true;
      i = 0;
      if (i == 0) {}
      try
      {
        boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
        if (bool) {
          return true;
        }
      }
      catch (Exception paramMotionEvent)
      {
        int j;
        int k;
        label245:
        return false;
      }
    }
    if (i == 2)
    {
      i = (int)(paramMotionEvent.getX() + 0.5F);
      j = (int)(paramMotionEvent.getY() + 0.5F);
      i = Math.abs(i - this.jdField_a_of_type_Int);
      j = Math.abs(j - this.b);
      k = ViewConfiguration.get(getContext()).getScaledTouchSlop();
      if ((!this.jdField_a_of_type_Boolean) || (i <= k)) {
        break label245;
      }
      if ((j / i >= 0.6F) || (this.jdField_a_of_type_Int <= (int)(azkz.jdField_a_of_type_Int * 0.1F))) {
        break label253;
      }
    }
    label253:
    for (i = 1;; i = 0)
    {
      if (i == 0) {
        FrameHelperActivity.c(true);
      }
      this.jdField_a_of_type_Boolean = false;
      break;
      if ((i == 1) || (i == 3))
      {
        FrameHelperActivity.c(true);
        this.jdField_a_of_type_Boolean = false;
      }
      i = 0;
      break;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i == 0) {
      FrameHelperActivity.c(false);
    }
    for (;;)
    {
      try
      {
        boolean bool = super.onTouchEvent(paramMotionEvent);
        return bool;
      }
      catch (Exception paramMotionEvent) {}
      if ((i == 1) || (i == 3))
      {
        FrameHelperActivity.c(true);
        this.jdField_a_of_type_Boolean = false;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrameLayout
 * JD-Core Version:    0.7.0.1
 */