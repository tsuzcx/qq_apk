package com.tencent.biz.qqcircle.richframework.widget.drag;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants._AppSetting;
import com.tencent.qphone.base.util.QLog;

class DragTextView$DragTouchDelegate
  extends TouchDelegate
{
  public DragTextView$DragTouchDelegate(DragTextView paramDragTextView, Rect paramRect, View paramView)
  {
    super(paramRect, paramView);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.a.getVisibility() != 0) {
      return false;
    }
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if ((!QCircleHostConstants._AppSetting.isPublicVersion()) && (QLog.isColorLevel()) && (paramMotionEvent.getAction() == 0))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("TouchDelegate onTouchEvent: ");
      localStringBuilder.append(paramMotionEvent);
      localStringBuilder.append("; cur Rect:");
      localStringBuilder.append(DragTextView.a(this.a));
      QLog.d("DragTextView", 2, localStringBuilder.toString());
    }
    boolean bool = super.onTouchEvent(paramMotionEvent);
    paramMotionEvent.setLocation(f1, f2);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.richframework.widget.drag.DragTextView.DragTouchDelegate
 * JD-Core Version:    0.7.0.1
 */