package com.tencent.biz.webviewplugin;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.webview.webso.WebSoUtils;

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
      WebSoUtils.m("handle MSG_WNS_HTTP_GET_DATA");
      paramMessage = (Bundle)paramMessage.obj;
      WebSoPlugin.a(this.a, paramMessage);
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WnsProxyHandler");
    localStringBuilder.append(super.toString());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.WebSoPlugin.1
 * JD-Core Version:    0.7.0.1
 */