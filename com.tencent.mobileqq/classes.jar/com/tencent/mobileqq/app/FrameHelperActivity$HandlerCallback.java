package com.tencent.mobileqq.app;

import android.os.Handler.Callback;
import android.os.Message;
import java.lang.ref.WeakReference;

class FrameHelperActivity$HandlerCallback
  implements Handler.Callback
{
  private WeakReference<FrameHelperActivity> a;
  
  FrameHelperActivity$HandlerCallback(FrameHelperActivity paramFrameHelperActivity)
  {
    this.a = new WeakReference(paramFrameHelperActivity);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    FrameHelperActivity localFrameHelperActivity = (FrameHelperActivity)this.a.get();
    if (localFrameHelperActivity != null) {
      localFrameHelperActivity.a(paramMessage);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.FrameHelperActivity.HandlerCallback
 * JD-Core Version:    0.7.0.1
 */