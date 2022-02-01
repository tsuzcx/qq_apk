package com.tencent.mobileqq.apollo.view.pannel;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import anpq;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.qphone.base.util.QLog;

public class KapuPkgStateReceiver
  extends BroadcastReceiver
{
  private anpq a;
  
  public KapuPkgStateReceiver(anpq paramanpq)
  {
    this.a = paramanpq;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    Object localObject = paramIntent.getDataString();
    if (TextUtils.isEmpty((CharSequence)localObject)) {}
    do
    {
      do
      {
        do
        {
          return;
          paramContext = "";
          localObject = ((String)localObject).split(":");
          if (localObject.length == 2) {
            paramContext = localObject[1];
          }
        } while (!ApolloUtil.c().equals(paramContext));
        paramContext = paramIntent.getAction();
        QLog.d("KapuPkgStateReceiver", 1, new Object[] { "kapu package state changed=", paramContext });
      } while (this.a == null);
      if ("android.intent.action.PACKAGE_REMOVED".equals(paramContext))
      {
        this.a.a(1);
        return;
      }
    } while (!"android.intent.action.PACKAGE_ADDED".equals(paramContext));
    this.a.a(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.pannel.KapuPkgStateReceiver
 * JD-Core Version:    0.7.0.1
 */