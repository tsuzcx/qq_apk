package com.tencent.biz.webviewbase;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class AbsBaseWebViewActivity$8
  implements View.OnTouchListener
{
  AbsBaseWebViewActivity$8(AbsBaseWebViewActivity paramAbsBaseWebViewActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    switch (paramMotionEvent.getAction())
    {
    default: 
      bool1 = false;
    }
    do
    {
      return bool1;
      bool1 = bool2;
    } while (paramView != AbsBaseWebViewActivity.access$100(this.a));
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewBase", 2, "vg onTouch");
    }
    paramView = new HashMap(2);
    paramView.put("X", Integer.valueOf((int)paramMotionEvent.getX()));
    paramView.put("Y", Integer.valueOf((int)paramMotionEvent.getY()));
    this.a.dispatchPluginEvent(8589934606L, paramView);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.webviewbase.AbsBaseWebViewActivity.8
 * JD-Core Version:    0.7.0.1
 */