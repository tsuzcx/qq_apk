package com.tencent.biz.pubaccount.util.monitor;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;

class FPSSuspendedBall$SuspendedBallTouchListener
  implements View.OnTouchListener
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  
  private FPSSuspendedBall$SuspendedBallTouchListener(FPSSuspendedBall paramFPSSuspendedBall) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if ((i != 1) && (i == 2))
      {
        FPSSuspendedBall.a(this.jdField_a_of_type_ComTencentBizPubaccountUtilMonitorFPSSuspendedBall).x = (this.jdField_a_of_type_Int + (int)(this.jdField_a_of_type_Float - paramMotionEvent.getRawX()));
        FPSSuspendedBall.a(this.jdField_a_of_type_ComTencentBizPubaccountUtilMonitorFPSSuspendedBall).y = (this.jdField_b_of_type_Int + (int)(paramMotionEvent.getRawY() - this.jdField_b_of_type_Float));
        FPSSuspendedBall.a(this.jdField_a_of_type_ComTencentBizPubaccountUtilMonitorFPSSuspendedBall).updateViewLayout(paramView, FPSSuspendedBall.a(this.jdField_a_of_type_ComTencentBizPubaccountUtilMonitorFPSSuspendedBall));
      }
    }
    else
    {
      this.jdField_a_of_type_Int = FPSSuspendedBall.a(this.jdField_a_of_type_ComTencentBizPubaccountUtilMonitorFPSSuspendedBall).x;
      this.jdField_b_of_type_Int = FPSSuspendedBall.a(this.jdField_a_of_type_ComTencentBizPubaccountUtilMonitorFPSSuspendedBall).y;
      this.jdField_a_of_type_Float = paramMotionEvent.getRawX();
      this.jdField_b_of_type_Float = paramMotionEvent.getRawY();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.monitor.FPSSuspendedBall.SuspendedBallTouchListener
 * JD-Core Version:    0.7.0.1
 */