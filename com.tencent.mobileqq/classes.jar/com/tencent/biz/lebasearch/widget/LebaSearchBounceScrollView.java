package com.tencent.biz.lebasearch.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.widget.BounceScrollView;

public class LebaSearchBounceScrollView
  extends BounceScrollView
{
  float a;
  int b;
  int c;
  boolean d = false;
  boolean e = true;
  
  public LebaSearchBounceScrollView(Context paramContext)
  {
    super(paramContext);
    AccessibilityUtil.a(this, false);
    this.a = paramContext.getResources().getDisplayMetrics().density;
    this.b = ((int)(this.a * 320.0F));
    this.c = 0;
  }
  
  public LebaSearchBounceScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.a = paramContext.getResources().getDisplayMetrics().density;
    this.b = ((int)(this.a * 320.0F));
    this.c = 0;
  }
  
  public boolean a()
  {
    return this.d;
  }
  
  public void fling(int paramInt)
  {
    this.d = true;
    super.fling(paramInt);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1) {
      this.d = false;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  protected boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
  {
    if (this.e) {
      return super.overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, this.c, paramInt7, this.b, paramBoolean);
    }
    return super.overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, 0, paramBoolean);
  }
  
  public void setMaxOverScrollY(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void setUseBounce(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.lebasearch.widget.LebaSearchBounceScrollView
 * JD-Core Version:    0.7.0.1
 */