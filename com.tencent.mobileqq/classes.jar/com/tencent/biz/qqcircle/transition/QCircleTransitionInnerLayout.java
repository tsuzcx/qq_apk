package com.tencent.biz.qqcircle.transition;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class QCircleTransitionInnerLayout
  extends FrameLayout
{
  private boolean a = true;
  
  public QCircleTransitionInnerLayout(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public QCircleTransitionInnerLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public QCircleTransitionInnerLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a(boolean paramBoolean)
  {
    QLog.d("QCircleTransitionInnerLayout", 1, "setDisallowIntercept:" + paramBoolean);
    this.a = paramBoolean;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.dispatchTouchEvent(paramMotionEvent);
      QLog.d("QCircleTransitionInnerLayout", 1, "dispatchTouchEvent mDisallowIntercept:true");
      getParent().requestDisallowInterceptTouchEvent(true);
      continue;
      QLog.d("QCircleTransitionInnerLayout", 1, "dispatchTouchEvent mDisallowIntercept:" + this.a);
      getParent().requestDisallowInterceptTouchEvent(this.a);
    }
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.transition.QCircleTransitionInnerLayout
 * JD-Core Version:    0.7.0.1
 */