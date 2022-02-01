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
import com.tencent.TMG.utils.QLog;

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
  
  private void b(MotionEvent paramMotionEvent)
  {
    int i = getScrollX() - this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout.getLeft();
    int j = getScrollY() - this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout.getTop();
    paramMotionEvent.offsetLocation(i, j);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout.dispatchTouchEvent(paramMotionEvent);
    paramMotionEvent.offsetLocation(-i, -j);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool1;
    if ((this.jdField_a_of_type_AndroidViewViewGroup == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout == null)) {
      bool1 = super.dispatchTouchEvent(paramMotionEvent);
    }
    int i;
    boolean bool2;
    do
    {
      do
      {
        return bool1;
        i = paramMotionEvent.getAction();
        if (i == 0)
        {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout.getHitRect(this.jdField_a_of_type_AndroidGraphicsRect);
          i = (int)paramMotionEvent.getX();
          int j = (int)paramMotionEvent.getY();
          if (this.jdField_a_of_type_AndroidGraphicsRect.contains(i, j)) {
            bool1 = super.dispatchTouchEvent(paramMotionEvent);
          }
          for (this.b = bool1;; this.b = false)
          {
            this.jdField_a_of_type_Boolean = false;
            return bool1;
            bool1 = super.dispatchTouchEvent(paramMotionEvent);
          }
        }
        MotionEvent localMotionEvent1 = MotionEvent.obtain(paramMotionEvent);
        bool2 = super.dispatchTouchEvent(paramMotionEvent);
        if ((this.b) && ((!bool2) || ((bool2) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout.jdField_a_of_type_Boolean))))
        {
          if (!this.jdField_a_of_type_Boolean)
          {
            MotionEvent localMotionEvent2 = MotionEvent.obtain(paramMotionEvent);
            localMotionEvent2.setAction(0);
            a(localMotionEvent2);
            this.jdField_a_of_type_Boolean = true;
            localMotionEvent2.recycle();
            paramMotionEvent = MotionEvent.obtain(paramMotionEvent);
            paramMotionEvent.setAction(3);
            b(paramMotionEvent);
          }
          a(localMotionEvent1);
        }
        localMotionEvent1.recycle();
        if (i == 1) {
          break;
        }
        bool1 = bool2;
      } while (i != 3);
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    QLog.d("DuplicateEventLayout", 0, "action = " + i);
    return bool2;
  }
  
  public void setViews(ViewGroup paramViewGroup, ClipDianDianTouchAreaLayout paramClipDianDianTouchAreaLayout)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout = paramClipDianDianTouchAreaLayout;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.DuplicateEventLayout
 * JD-Core Version:    0.7.0.1
 */