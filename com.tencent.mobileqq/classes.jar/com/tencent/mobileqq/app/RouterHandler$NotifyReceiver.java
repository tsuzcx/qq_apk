package com.tencent.mobileqq.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.qphone.base.util.BaseApplication;

public class RouterHandler$NotifyReceiver
  extends BroadcastReceiver
{
  public RouterHandler$NotifyReceiver(RouterHandler paramRouterHandler) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    paramContext = paramIntent.getAction();
    if (paramContext != null)
    {
      int i;
      byte[] arrayOfByte;
      boolean bool;
      if (paramContext.equals("SmartDevice_receiveDatalineCSReply"))
      {
        paramContext = paramIntent.getExtras();
        i = paramContext.getInt("nCookie");
        paramIntent = paramContext.getByteArray("reqBuff");
        arrayOfByte = paramContext.getByteArray("rspBuff");
        bool = paramContext.getBoolean("isTimeout");
        RouterHandler.a(this.a, i, paramIntent, arrayOfByte, bool);
        return;
      }
      if (paramContext.equals("SmartDevice_receiveDatalineCCPush"))
      {
        paramContext = paramIntent.getExtras();
        long l = paramContext.getLong("fromDin");
        paramContext = paramContext.getByteArray("reqBuff");
        RouterHandler.a(this.a, l, paramContext);
        return;
      }
      if (paramContext.equals("SmartDevice_receiveDatalineCCReply"))
      {
        paramContext = paramIntent.getExtras();
        i = paramContext.getInt("nCookie");
        paramIntent = paramContext.getByteArray("reqBuff");
        arrayOfByte = paramContext.getByteArray("rspBuff");
        bool = paramContext.getBoolean("isTimeout");
        RouterHandler.b(this.a, i, paramIntent, arrayOfByte, bool);
        return;
      }
      if ((!paramContext.equals("com.tencent.mobileqq.intent.logout")) && (!paramContext.equals("mqq.intent.action.ACCOUNT_CHANGED")) && (!paramContext.equals("mqq.intent.action.ACCOUNT_KICKED")) && (!paramContext.equals("mqq.intent.action.FORCE_LOGOUT")))
      {
        paramIntent = new StringBuilder();
        paramIntent.append("mqq.intent.action.EXIT_");
        paramIntent.append(this.a.i.getApp().getPackageName());
        if ((!paramContext.equals(paramIntent.toString())) && (!paramContext.equals("mqq.intent.action.LOGOUT"))) {}
      }
      else
      {
        this.a.a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.RouterHandler.NotifyReceiver
 * JD-Core Version:    0.7.0.1
 */