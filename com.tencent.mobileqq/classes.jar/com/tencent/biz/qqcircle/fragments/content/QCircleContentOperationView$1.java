package com.tencent.biz.qqcircle.fragments.content;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.SeekBar;

class QCircleContentOperationView$1
  implements View.OnTouchListener
{
  QCircleContentOperationView$1(QCircleContentOperationView paramQCircleContentOperationView) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.a.p != null) {
      return this.a.p.onTouchEvent(paramMotionEvent);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.content.QCircleContentOperationView.1
 * JD-Core Version:    0.7.0.1
 */