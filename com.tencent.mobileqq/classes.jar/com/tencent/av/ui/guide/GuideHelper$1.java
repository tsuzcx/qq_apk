package com.tencent.av.ui.guide;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.qphone.base.util.QLog;

class GuideHelper$1
  implements View.OnTouchListener
{
  GuideHelper$1(GuideHelper paramGuideHelper, long paramLong) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    paramView = new StringBuilder();
    paramView.append("onTouch to hide, seq[");
    paramView.append(this.a);
    paramView.append("]");
    QLog.w("GuideHelper", 1, paramView.toString());
    GuideHelper.a(this.b, this.a);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.guide.GuideHelper.1
 * JD-Core Version:    0.7.0.1
 */