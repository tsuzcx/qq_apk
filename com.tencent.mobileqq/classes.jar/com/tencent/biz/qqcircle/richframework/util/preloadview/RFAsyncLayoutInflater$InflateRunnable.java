package com.tencent.biz.qqcircle.richframework.util.preloadview;

import android.os.Message;
import android.view.LayoutInflater;
import com.tencent.qphone.base.util.QLog;

class RFAsyncLayoutInflater$InflateRunnable
  implements Runnable
{
  private RFAsyncLayoutInflater.InflateRequest a;
  private boolean b;
  
  public RFAsyncLayoutInflater$InflateRunnable(RFAsyncLayoutInflater.InflateRequest paramInflateRequest)
  {
    this.a = paramInflateRequest;
  }
  
  public void run()
  {
    this.b = true;
    try
    {
      this.a.d = this.a.a.a.inflate(this.a.c, this.a.b, false);
    }
    catch (RuntimeException localRuntimeException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Failed to inflate resource in the background! Retrying on the UI thread ");
      localStringBuilder.append(localRuntimeException.toString());
      QLog.w("RFAsyncLayoutInflater", 1, localStringBuilder.toString());
    }
    Message.obtain(this.a.a.b, 0, this.a).sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.richframework.util.preloadview.RFAsyncLayoutInflater.InflateRunnable
 * JD-Core Version:    0.7.0.1
 */