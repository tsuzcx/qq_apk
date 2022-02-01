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
  private WSFeedsLinearLayout.OnActionListener a;
  private GestureDetector b;
  private float c = 0.0F;
  private float d = 0.0F;
  private float e = 0.0F;
  private float f = 0.0F;
  private int g = 0;
  
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
  
  private void a()
  {
    this.b = new GestureDetector(new WSFeedsLinearLayout.1(this));
  }
  
  private void a(float paramFloat)
  {
    this.f = 0.0F;
    this.e += paramFloat;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[WSFeedsLinearLayout.java][handleGestureOnScrollDown] SCROLL_DOWN!! distanceY:");
    ((StringBuilder)localObject).append(paramFloat);
    ((StringBuilder)localObject).append(", mDistanceDown:");
    ((StringBuilder)localObject).append(this.d);
    ((StringBuilder)localObject).append(", mDistanceDownSlop:");
    ((StringBuilder)localObject).append(this.e);
    WSLog.e("WSFeedsLinearLayoutLog", ((StringBuilder)localObject).toString());
    if (Math.abs(this.e) > 8.0F)
    {
      this.c = 0.0F;
      this.d += paramFloat;
      this.g = 2;
      localObject = this.a;
      if (localObject != null) {
        ((WSFeedsLinearLayout.OnActionListener)localObject).b((int)this.d);
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
    Object localObject = this.a;
    if (localObject != null) {
      ((WSFeedsLinearLayout.OnActionListener)localObject).a(this.g, getMoveDistance());
    }
    d();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[WSFeedsLinearLayout.java][handleActionUp] ACTION_UP!! mMoveState:");
    ((StringBuilder)localObject).append(this.g);
    WSLog.b("WSFeedsLinearLayoutLog", ((StringBuilder)localObject).toString());
  }
  
  private void b(float paramFloat)
  {
    this.e = 0.0F;
    this.f += paramFloat;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[WSFeedsLinearLayout.java][handleGestureOnScrollUp] SCROLL_UP!! distanceY:");
    ((StringBuilder)localObject).append(paramFloat);
    ((StringBuilder)localObject).append(", mDistanceUp:");
    ((StringBuilder)localObject).append(this.c);
    ((StringBuilder)localObject).append(", mDistanceUpSlop:");
    ((StringBuilder)localObject).append(this.f);
    WSLog.e("WSFeedsLinearLayoutLog", ((StringBuilder)localObject).toString());
    if (Math.abs(this.f) > 8.0F)
    {
      this.d = 0.0F;
      this.c += paramFloat;
      this.g = 1;
      localObject = this.a;
      if (localObject != null) {
        ((WSFeedsLinearLayout.OnActionListener)localObject).a((int)this.c);
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
    this.c = 0.0F;
    this.d = 0.0F;
    this.f = 0.0F;
    this.e = 0.0F;
    this.g = 0;
  }
  
  private int getMoveDistance()
  {
    int i = this.g;
    if (i == 1) {}
    for (float f1 = this.c;; f1 = this.d)
    {
      return (int)f1;
      if (i != 2) {
        break;
      }
    }
    return 0;
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
    this.b.onTouchEvent(paramMotionEvent);
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void setOnActionListener(WSFeedsLinearLayout.OnActionListener paramOnActionListener)
  {
    this.a = paramOnActionListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.view.WSFeedsLinearLayout
 * JD-Core Version:    0.7.0.1
 */