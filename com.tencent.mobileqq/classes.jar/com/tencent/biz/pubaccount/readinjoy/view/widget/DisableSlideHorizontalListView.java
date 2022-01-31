package com.tencent.biz.pubaccount.readinjoy.view.widget;

import actj;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewParent;
import baxn;
import bbdv;
import com.tencent.biz.pubaccount.readinjoy.view.BezierSideBarView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import rrk;
import rrl;

public class DisableSlideHorizontalListView
  extends HorizontalListView
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private BezierSideBarView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewBezierSideBarView;
  private rrk jdField_a_of_type_Rrk;
  private rrl jdField_a_of_type_Rrl;
  private boolean jdField_a_of_type_Boolean;
  private float b;
  
  public DisableSlideHorizontalListView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = ((int)bbdv.a(paramContext, 18.0F));
  }
  
  public DisableSlideHorizontalListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Int = ((int)bbdv.a(paramContext, 18.0F));
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewBezierSideBarView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewBezierSideBarView.a();
    }
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewBezierSideBarView != null)
    {
      int i = getMeasuredHeight() / 2;
      int j = actj.a(18.0F, getResources());
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewBezierSideBarView.a(paramInt, i - j);
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    float f1 = paramMotionEvent.getX();
    float f3 = paramMotionEvent.getY();
    if (i == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DisableSlideHorizontalListView", 2, "dispatchTouchEvent:ACTION_DOWN. mIsPress=" + this.jdField_a_of_type_Boolean);
      }
      this.jdField_a_of_type_Float = f1;
      this.b = f3;
      getParent().requestDisallowInterceptTouchEvent(true);
      this.jdField_a_of_type_Boolean = true;
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    if (i == 2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DisableSlideHorizontalListView", 2, "dispatchTouchEvent:ACTION_MOVE. mIsPress=" + this.jdField_a_of_type_Boolean);
      }
      float f2 = this.jdField_a_of_type_Float;
      f3 -= this.b;
      if ((this.jdField_a_of_type_Boolean) && (Math.abs(f3) * 5.0F > Math.abs(f1 - f2) * 4.0F) && (Math.abs(f3) > baxn.a(getContext(), 5.0F)))
      {
        getParent().requestDisallowInterceptTouchEvent(false);
        a(getScrollX() - this.jdField_a_of_type_Int);
      }
    }
    for (;;)
    {
      return super.dispatchTouchEvent(paramMotionEvent);
      getParent().requestDisallowInterceptTouchEvent(true);
      break;
      if ((i == 3) || (i == 1))
      {
        if (QLog.isColorLevel()) {
          QLog.d("DisableSlideHorizontalListView", 2, "dispatchTouchEvent:ACTION_CANCEL or UP. action=" + i + " mIsPress=" + this.jdField_a_of_type_Boolean);
        }
        this.jdField_a_of_type_Boolean = false;
        if ((this.jdField_a_of_type_Rrk != null) && (i == 1) && (getScrollX() > this.jdField_a_of_type_Int)) {
          this.jdField_a_of_type_Rrk.c();
        }
        a();
      }
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (this.jdField_a_of_type_Rrl != null) {
      this.jdField_a_of_type_Rrl.a();
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.jdField_a_of_type_Rrl != null) {
      this.jdField_a_of_type_Rrl.b();
    }
  }
  
  public void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    super.onOverScrolled(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
    if (paramInt1 <= 2)
    {
      a();
      return;
    }
    a(paramInt1 - this.jdField_a_of_type_Int);
  }
  
  public void setOnOverScrollListener(rrk paramrrk)
  {
    this.jdField_a_of_type_Rrk = paramrrk;
  }
  
  public void setOnViewWindowChangedListener(rrl paramrrl)
  {
    this.jdField_a_of_type_Rrl = paramrrl;
  }
  
  public void setSideBarView(BezierSideBarView paramBezierSideBarView)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewBezierSideBarView = paramBezierSideBarView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.widget.DisableSlideHorizontalListView
 * JD-Core Version:    0.7.0.1
 */