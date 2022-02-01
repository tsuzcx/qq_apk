package com.tencent.biz.pubaccount.weishi_new.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;

public class WSFeedsLinearLayout
  extends LinearLayout
{
  private float jdField_a_of_type_Float = 0.0F;
  private int jdField_a_of_type_Int = 0;
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  private WSFeedsLinearLayout.OnActionListener jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSFeedsLinearLayout$OnActionListener;
  private float b = 0.0F;
  private float c = 0.0F;
  private float d = 0.0F;
  
  public WSFeedsLinearLayout(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public WSFeedsLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public WSFeedsLinearLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private int a()
  {
    int i = this.jdField_a_of_type_Int;
    if (i == 1) {}
    for (float f = this.jdField_a_of_type_Float;; f = this.b)
    {
      return (int)f;
      if (i != 2) {
        break;
      }
    }
    return 0;
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(new WSFeedsLinearLayout.1(this));
  }
  
  private void a(float paramFloat)
  {
    this.d = 0.0F;
    this.c += paramFloat;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[WSFeedsLinearLayout.java][handleGestureOnScrollDown] SCROLL_DOWN!! distanceY:");
    ((StringBuilder)localObject).append(paramFloat);
    ((StringBuilder)localObject).append(", mDistanceDown:");
    ((StringBuilder)localObject).append(this.b);
    ((StringBuilder)localObject).append(", mDistanceDownSlop:");
    ((StringBuilder)localObject).append(this.c);
    WSLog.e("WSFeedsLinearLayoutLog", ((StringBuilder)localObject).toString());
    if (Math.abs(this.c) > 8.0F)
    {
      this.jdField_a_of_type_Float = 0.0F;
      this.b += paramFloat;
      this.jdField_a_of_type_Int = 2;
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSFeedsLinearLayout$OnActionListener;
      if (localObject != null) {
        ((WSFeedsLinearLayout.OnActionListener)localObject).b((int)this.b);
      }
    }
  }
  
  private void a(float paramFloat1, float paramFloat2)
  {
    if (Math.abs(paramFloat1) < Math.abs(paramFloat2))
    {
      if (paramFloat2 > 0.0F)
      {
        b(paramFloat2);
        return;
      }
      a(paramFloat2);
    }
  }
  
  private void b()
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSFeedsLinearLayout$OnActionListener;
    if (localObject != null) {
      ((WSFeedsLinearLayout.OnActionListener)localObject).a(this.jdField_a_of_type_Int, a());
    }
    d();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[WSFeedsLinearLayout.java][handleActionUp] ACTION_UP!! mMoveState:");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
    WSLog.b("WSFeedsLinearLayoutLog", ((StringBuilder)localObject).toString());
  }
  
  private void b(float paramFloat)
  {
    this.c = 0.0F;
    this.d += paramFloat;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[WSFeedsLinearLayout.java][handleGestureOnScrollUp] SCROLL_UP!! distanceY:");
    ((StringBuilder)localObject).append(paramFloat);
    ((StringBuilder)localObject).append(", mDistanceUp:");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_Float);
    ((StringBuilder)localObject).append(", mDistanceUpSlop:");
    ((StringBuilder)localObject).append(this.d);
    WSLog.e("WSFeedsLinearLayoutLog", ((StringBuilder)localObject).toString());
    if (Math.abs(this.d) > 8.0F)
    {
      this.b = 0.0F;
      this.jdField_a_of_type_Float += paramFloat;
      this.jdField_a_of_type_Int = 1;
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSFeedsLinearLayout$OnActionListener;
      if (localObject != null) {
        ((WSFeedsLinearLayout.OnActionListener)localObject).a((int)this.jdField_a_of_type_Float);
      }
    }
  }
  
  private void c()
  {
    WSLog.b("WSFeedsLinearLayoutLog", "[WSFeedsLinearLayout.java][handleActionDown] ACTION_DOWN!!");
    d();
  }
  
  private void d()
  {
    this.jdField_a_of_type_Float = 0.0F;
    this.b = 0.0F;
    this.d = 0.0F;
    this.c = 0.0F;
    this.jdField_a_of_type_Int = 0;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if (i == 1) {
        b();
      }
    }
    else {
      c();
    }
    this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void setOnActionListener(WSFeedsLinearLayout.OnActionListener paramOnActionListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSFeedsLinearLayout$OnActionListener = paramOnActionListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.view.WSFeedsLinearLayout
 * JD-Core Version:    0.7.0.1
 */