package com.tencent.aelight.camera.ae.camera.ui.bottom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.aelight.camera.ae.util.AECommonUtil;
import com.tencent.aelight.camera.log.AEQLog;

public class AECircleBottomWrapLayout
  extends RelativeLayout
{
  private boolean a = false;
  private boolean b = false;
  private View c;
  private AEBottomListScrollView d;
  private VelocityTracker e;
  
  public AECircleBottomWrapLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AECircleBottomWrapLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AECircleBottomWrapLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    this.e.addMovement(paramMotionEvent);
    this.e.computeCurrentVelocity(1000);
    if (paramMotionEvent.getAction() == 0)
    {
      this.a = false;
      this.b = false;
      this.e.clear();
    }
    if ((Math.abs(this.e.getXVelocity()) > 100.0F) && (paramMotionEvent.getEventTime() - paramMotionEvent.getDownTime() < 100L) && (AECommonUtil.a(this.c, paramMotionEvent)) && (!this.a))
    {
      this.a = true;
      this.b = true;
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.e = VelocityTracker.obtain();
    this.c = findViewById(2063991100);
    this.d = ((AEBottomListScrollView)findViewById(2063991400));
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.e.recycle();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.b)
    {
      AEQLog.a("AECircleBottomLayout", "in onInterceptTouchEvent true.");
      paramMotionEvent.setAction(0);
      this.d.dispatchTouchEvent(paramMotionEvent);
      this.b = false;
      return true;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.a) {
      return super.onTouchEvent(paramMotionEvent);
    }
    return this.d.onTouchEvent(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.bottom.AECircleBottomWrapLayout
 * JD-Core Version:    0.7.0.1
 */