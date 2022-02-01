package com.tencent.biz.webviewbase;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class WebAIOController$2
  extends BroadcastReceiver
{
  WebAIOController$2(WebAIOController paramWebAIOController) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("com.tencent.msg.newmessage".equals(paramIntent.getAction()))
    {
      WebAIOController.b = false;
      WebAIOController.c = true;
      this.a.a(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.webviewbase.WebAIOController.2
 * JD-Core Version:    0.7.0.1
 */