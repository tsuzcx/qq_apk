package com.tencent.biz.qqcircle.fragments.person.control;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.qphone.base.util.QLog;

class QCirclePersonHeaderPymkControl$1
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  QCirclePersonHeaderPymkControl$1(QCirclePersonHeaderPymkControl paramQCirclePersonHeaderPymkControl) {}
  
  public void onGlobalLayout()
  {
    QCirclePersonHeaderPymkControl.a(this.a).getViewTreeObserver().removeGlobalOnLayoutListener(this);
    int i = QCirclePersonHeaderPymkControl.a(this.a).getMeasuredHeight();
    if (i > QCirclePersonHeaderPymkControl.b(this.a))
    {
      QCirclePersonHeaderPymkControl.a(this.a, i);
      QLog.d("PYMK-QCirclePersonHeaderPymkControl", 1, new Object[] { "[onGlobalLayout] personal base info height: ", Integer.valueOf(QCirclePersonHeaderPymkControl.b(this.a)) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.person.control.QCirclePersonHeaderPymkControl.1
 * JD-Core Version:    0.7.0.1
 */