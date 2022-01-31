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
    if (paramIntent == null) {}
    do
    {
      do
      {
        return;
        paramContext = paramIntent.getAction();
      } while (paramContext == null);
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
    } while ((!paramContext.equals("com.tencent.mobileqq.intent.logout")) && (!paramContext.equals("mqq.intent.action.ACCOUNT_CHANGED")) && (!paramContext.equals("mqq.intent.action.ACCOUNT_KICKED")) && (!paramContext.equals("mqq.intent.action.FORCE_LOGOUT")) && (!paramContext.equals("mqq.intent.action.EXIT_" + this.a.b.getApp().getPackageName())) && (!paramContext.equals("mqq.intent.action.LOGOUT")));
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.RouterHandler.NotifyReceiver
 * JD-Core Version:    0.7.0.1
 */