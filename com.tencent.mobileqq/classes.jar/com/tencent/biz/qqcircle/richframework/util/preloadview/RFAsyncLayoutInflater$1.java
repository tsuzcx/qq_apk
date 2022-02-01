package com.tencent.biz.qqcircle.richframework.util.preloadview;

import android.os.Handler.Callback;
import android.os.Message;
import android.view.LayoutInflater;
import com.tencent.biz.qqcircle.QCirclePluginConfig;

class RFAsyncLayoutInflater$1
  implements Handler.Callback
{
  RFAsyncLayoutInflater$1(RFAsyncLayoutInflater paramRFAsyncLayoutInflater) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    paramMessage = (RFAsyncLayoutInflater.InflateRequest)paramMessage.obj;
    if (paramMessage.d == null) {
      try
      {
        paramMessage.d = this.a.a.inflate(paramMessage.c, paramMessage.b, false);
      }
      catch (RuntimeException paramMessage)
      {
        QCirclePluginConfig.a().a(false);
        throw paramMessage;
      }
    }
    paramMessage.e.a(paramMessage.d, paramMessage.c, paramMessage.b);
    this.a.a(paramMessage);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.richframework.util.preloadview.RFAsyncLayoutInflater.1
 * JD-Core Version:    0.7.0.1
 */