package com.tencent.mobileqq.apollo.activity;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

public class ApolloLayout
  extends RelativeLayout
{
  private boolean a;
  
  public ApolloLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public ApolloLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ApolloLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    if ((bool) && (!this.a)) {
      onTouchEvent(paramMotionEvent);
    }
    this.a = false;
    return bool;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    this.a = true;
    return super.onTouchEvent(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.activity.ApolloLayout
 * JD-Core Version:    0.7.0.1
 */