package com.tencent.biz.qqcircle.fragments.content;

import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class QCircleContentOperationView$12
  implements View.OnTouchListener
{
  QCircleContentOperationView$12(QCircleContentOperationView paramQCircleContentOperationView) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0) {
      this.a.y = new Point((int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY());
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.content.QCircleContentOperationView.12
 * JD-Core Version:    0.7.0.1
 */