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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setDisallowIntercept:");
    localStringBuilder.append(paramBoolean);
    QLog.d("QCircleTransitionInnerLayout", 1, localStringBuilder.toString());
    this.a = paramBoolean;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    StringBuilder localStringBuilder;
    if (i != 0)
    {
      if ((i == 1) || (i == 2))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramMotionEvent.getAction());
        localStringBuilder.append(":dispatchTouchEvent mDisallowIntercept:");
        localStringBuilder.append(this.a);
        QLog.d("QCircleTransitionInnerLayout", 1, localStringBuilder.toString());
        if (getParent() != null) {
          getParent().requestDisallowInterceptTouchEvent(this.a);
        }
      }
    }
    else
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramMotionEvent.getAction());
      localStringBuilder.append(":dispatchTouchEvent mDisallowIntercept:");
      localStringBuilder.append(true);
      QLog.d("QCircleTransitionInnerLayout", 1, localStringBuilder.toString());
      if (getParent() != null) {
        getParent().requestDisallowInterceptTouchEvent(true);
      }
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.transition.QCircleTransitionInnerLayout
 * JD-Core Version:    0.7.0.1
 */