package com.tencent.biz.webviewbase;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class AbsBaseWebViewActivity$7
  implements View.OnTouchListener
{
  AbsBaseWebViewActivity$7(AbsBaseWebViewActivity paramAbsBaseWebViewActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if (i != 1) {
        return false;
      }
      if (paramView == AbsBaseWebViewActivity.access$200(this.a))
      {
        if (QLog.isColorLevel()) {
          QLog.d("WebLog_WebViewBase", 2, "vg onTouch");
        }
        paramView = new HashMap(2);
        paramView.put("X", Integer.valueOf((int)paramMotionEvent.getX()));
        paramView.put("Y", Integer.valueOf((int)paramMotionEvent.getY()));
        this.a.dispatchPluginEvent(8589934606L, paramView);
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.webviewbase.AbsBaseWebViewActivity.7
 * JD-Core Version:    0.7.0.1
 */