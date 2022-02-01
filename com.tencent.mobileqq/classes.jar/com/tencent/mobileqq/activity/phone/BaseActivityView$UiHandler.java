package com.tencent.mobileqq.activity.phone;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

class BaseActivityView$UiHandler
  extends Handler
{
  private WeakReference<BaseActivityView> a;
  
  public BaseActivityView$UiHandler(BaseActivityView paramBaseActivityView)
  {
    this.a = new WeakReference(paramBaseActivityView);
  }
  
  public void handleMessage(Message paramMessage)
  {
    boolean bool = true;
    BaseActivityView localBaseActivityView = (BaseActivityView)this.a.get();
    if (localBaseActivityView == null) {
      return;
    }
    switch (paramMessage.what)
    {
    default: 
      throw new RuntimeException("Unknown message: " + paramMessage.what);
    case 1: 
      int i = paramMessage.arg1;
      if (paramMessage.arg2 == 1) {}
      for (;;)
      {
        localBaseActivityView.b(i, bool);
        return;
        bool = false;
      }
    case 2: 
      localBaseActivityView.f();
      return;
    }
    localBaseActivityView.i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.BaseActivityView.UiHandler
 * JD-Core Version:    0.7.0.1
 */