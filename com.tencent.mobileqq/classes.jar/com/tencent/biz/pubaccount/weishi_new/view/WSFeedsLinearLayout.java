package com.tencent.biz.pubaccount.weishi_new.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.LinearLayout;

public class WSFeedsLinearLayout
  extends LinearLayout
{
  private byte jdField_a_of_type_Byte = 0;
  private final int jdField_a_of_type_Int;
  private WSFeedsLinearLayout.DispatchTouchEventListener jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSFeedsLinearLayout$DispatchTouchEventListener;
  private int b;
  private int c;
  
  public WSFeedsLinearLayout(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = ViewConfiguration.get(paramContext).getScaledTouchSlop();
  }
  
  public WSFeedsLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Int = ViewConfiguration.get(paramContext).getScaledTouchSlop();
  }
  
  public WSFeedsLinearLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Int = ViewConfiguration.get(paramContext).getScaledTouchSlop();
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.dispatchTouchEvent(paramMotionEvent);
      this.b = ((int)paramMotionEvent.getX());
      this.c = ((int)paramMotionEvent.getY());
      continue;
      int i = (int)paramMotionEvent.getX();
      int k = (int)paramMotionEvent.getY();
      if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSFeedsLinearLayout$DispatchTouchEventListener != null)
      {
        int j = this.b;
        k -= this.c;
        if (Math.abs(i - j) < Math.abs(k)) {
          if (k > 0)
          {
            this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSFeedsLinearLayout$DispatchTouchEventListener.b(k);
          }
          else
          {
            this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSFeedsLinearLayout$DispatchTouchEventListener.a(k);
            continue;
            this.jdField_a_of_type_Byte = 0;
          }
        }
      }
    }
  }
  
  public void setDispatchTouchEventListener(WSFeedsLinearLayout.DispatchTouchEventListener paramDispatchTouchEventListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSFeedsLinearLayout$DispatchTouchEventListener = paramDispatchTouchEventListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.view.WSFeedsLinearLayout
 * JD-Core Version:    0.7.0.1
 */