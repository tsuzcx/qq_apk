package com.tencent.biz.pubaccount.util;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class SwipeBackLayout$1
  extends Handler
{
  SwipeBackLayout$1(SwipeBackLayout paramSwipeBackLayout) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 1)
    {
      super.handleMessage(paramMessage);
      return;
    }
    if (!SwipeBackLayout.a(this.a))
    {
      SwipeBackLayout.a(this.a, true);
      if ((this.a.a instanceof Activity))
      {
        if (QLog.isColorLevel()) {
          QLog.d("WebLog_SwipeBackLayout", 2, "SwipeBackLayout finish()");
        }
        paramMessage = this.a;
        paramMessage.c = true;
        ((Activity)paramMessage.a).finish();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.SwipeBackLayout.1
 * JD-Core Version:    0.7.0.1
 */