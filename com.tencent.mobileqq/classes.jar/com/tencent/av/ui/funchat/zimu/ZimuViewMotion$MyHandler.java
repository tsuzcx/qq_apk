package com.tencent.av.ui.funchat.zimu;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

final class ZimuViewMotion$MyHandler
  extends Handler
{
  WeakReference<ZimuViewMotion> a;
  
  ZimuViewMotion$MyHandler(ZimuViewMotion paramZimuViewMotion)
  {
    this.a = new WeakReference(paramZimuViewMotion);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 1) {
      return;
    }
    paramMessage = (ZimuViewMotion)this.a.get();
    if (paramMessage != null) {
      paramMessage.e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.funchat.zimu.ZimuViewMotion.MyHandler
 * JD-Core Version:    0.7.0.1
 */