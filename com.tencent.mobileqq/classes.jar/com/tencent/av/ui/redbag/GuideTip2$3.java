package com.tencent.av.ui.redbag;

import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.qphone.base.util.QLog;

class GuideTip2$3
  implements View.OnTouchListener
{
  GuideTip2$3(GuideTip2 paramGuideTip2) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    try
    {
      QLog.w(this.a.i, 1, "OnTouch Close, view[" + paramView.getResources().getResourceName(paramView.getId()) + "]");
      this.a.a(false, 3);
      return true;
    }
    catch (Exception paramMotionEvent)
    {
      for (;;)
      {
        QLog.w(this.a.i, 1, "OnTouch Close, view[" + paramView.getId() + "]");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.redbag.GuideTip2.3
 * JD-Core Version:    0.7.0.1
 */