package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;

public class DuplicateEventLayout
  extends FrameLayout
{
  int jdField_a_of_type_Int;
  Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  ClipDianDianTouchAreaLayout jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout;
  boolean jdField_a_of_type_Boolean = false;
  boolean b;
  
  public DuplicateEventLayout(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public DuplicateEventLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Int = ViewConfiguration.get(paramContext).getScaledTouchSlop();
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    int i = getScrollX() - this.jdField_a_of_type_AndroidViewViewGroup.getLeft();
    int j = getScrollY() - this.jdField_a_of_type_AndroidViewViewGroup.getTop();
    paramMotionEvent.offsetLocation(i, j);
    this.jdField_a_of_type_AndroidViewViewGroup.dispatchTouchEvent(paramMotionEvent);
    paramMotionEvent.offsetLocation(-i, -j);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.jdField_a_of_type_AndroidViewViewGroup == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout == null)) {
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    if (paramMotionEvent.getAction() == 0)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout.getHitRect(this.jdField_a_of_type_AndroidGraphicsRect);
      int i = (int)paramMotionEvent.getX();
      int j = (int)paramMotionEvent.getY();
      if (this.jdField_a_of_type_AndroidGraphicsRect.contains(i, j))
      {
        bool = super.dispatchTouchEvent(paramMotionEvent);
        if (bool) {
          this.b = true;
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_Boolean = false;
        return bool;
        this.b = false;
        continue;
        bool = super.dispatchTouchEvent(paramMotionEvent);
        this.b = false;
      }
    }
    MotionEvent localMotionEvent = MotionEvent.obtain(paramMotionEvent);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    if ((this.b) && ((!bool) || ((bool) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout.jdField_a_of_type_Boolean))))
    {
      if (!this.jdField_a_of_type_Boolean)
      {
        paramMotionEvent = MotionEvent.obtain(paramMotionEvent);
        paramMotionEvent.setAction(0);
        a(paramMotionEvent);
        this.jdField_a_of_type_Boolean = true;
        paramMotionEvent.recycle();
      }
      a(localMotionEvent);
    }
    localMotionEvent.recycle();
    return bool;
  }
  
  public void setViews(ViewGroup paramViewGroup, ClipDianDianTouchAreaLayout paramClipDianDianTouchAreaLayout)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout = paramClipDianDianTouchAreaLayout;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.DuplicateEventLayout
 * JD-Core Version:    0.7.0.1
 */