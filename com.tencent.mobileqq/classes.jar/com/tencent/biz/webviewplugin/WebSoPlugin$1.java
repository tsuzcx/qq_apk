package com.tencent.biz.webviewplugin;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class WebSoPlugin$1
  extends Handler
{
  WebSoPlugin$1(WebSoPlugin paramWebSoPlugin, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if ((paramMessage.what == 203) && ((paramMessage.obj instanceof Bundle)))
    {
      paramMessage = (Bundle)paramMessage.obj;
      WebSoPlugin.a(this.a, paramMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.WebSoPlugin.1
 * JD-Core Version:    0.7.0.1
 */