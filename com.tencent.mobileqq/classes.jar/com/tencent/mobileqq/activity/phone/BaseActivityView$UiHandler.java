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
    Object localObject = (BaseActivityView)this.a.get();
    if (localObject == null) {
      return;
    }
    int i = paramMessage.what;
    boolean bool = true;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i == 3)
        {
          ((BaseActivityView)localObject).j();
          return;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Unknown message: ");
        ((StringBuilder)localObject).append(paramMessage.what);
        throw new RuntimeException(((StringBuilder)localObject).toString());
      }
      ((BaseActivityView)localObject).g();
      return;
    }
    i = paramMessage.arg1;
    if (paramMessage.arg2 != 1) {
      bool = false;
    }
    ((BaseActivityView)localObject).b(i, bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.BaseActivityView.UiHandler
 * JD-Core Version:    0.7.0.1
 */