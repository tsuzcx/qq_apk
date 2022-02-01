package com.tencent.biz.pubaccount.readinjoy.common;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;

class ReadInJoyCardViewCostBall$SuspendedBallTouchListener
  implements View.OnTouchListener
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  
  private ReadInJoyCardViewCostBall$SuspendedBallTouchListener(ReadInJoyCardViewCostBall paramReadInJoyCardViewCostBall) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return false;
      this.jdField_a_of_type_Int = ReadInJoyCardViewCostBall.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoyCardViewCostBall).x;
      this.jdField_b_of_type_Int = ReadInJoyCardViewCostBall.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoyCardViewCostBall).y;
      this.jdField_a_of_type_Float = paramMotionEvent.getRawX();
      this.jdField_b_of_type_Float = paramMotionEvent.getRawY();
      continue;
      ReadInJoyCardViewCostBall.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoyCardViewCostBall).x = (this.jdField_a_of_type_Int + (int)(this.jdField_a_of_type_Float - paramMotionEvent.getRawX()));
      ReadInJoyCardViewCostBall.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoyCardViewCostBall).y = (this.jdField_b_of_type_Int + (int)(paramMotionEvent.getRawY() - this.jdField_b_of_type_Float));
      ReadInJoyCardViewCostBall.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoyCardViewCostBall).updateViewLayout(paramView, ReadInJoyCardViewCostBall.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoyCardViewCostBall));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyCardViewCostBall.SuspendedBallTouchListener
 * JD-Core Version:    0.7.0.1
 */