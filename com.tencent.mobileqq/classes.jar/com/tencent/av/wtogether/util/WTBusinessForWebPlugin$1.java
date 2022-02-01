package com.tencent.av.wtogether.util;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;
import java.util.Stack;

class WTBusinessForWebPlugin$1
  extends BroadcastReceiver
{
  WTBusinessForWebPlugin$1(WTBusinessForWebPlugin paramWTBusinessForWebPlugin) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = WTBusinessForWebPlugin.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("receive[");
    localStringBuilder.append(paramIntent.getAction());
    localStringBuilder.append("]");
    QLog.i(paramContext, 1, localStringBuilder.toString());
    if (!WTBusinessForWebPlugin.a().empty())
    {
      paramContext = (Activity)WTBusinessForWebPlugin.a().peek();
      paramContext.setResult(4660);
      paramContext.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.wtogether.util.WTBusinessForWebPlugin.1
 * JD-Core Version:    0.7.0.1
 */