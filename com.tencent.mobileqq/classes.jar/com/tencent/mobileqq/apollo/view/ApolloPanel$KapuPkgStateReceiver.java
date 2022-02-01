package com.tencent.mobileqq.apollo.view;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class ApolloPanel$KapuPkgStateReceiver
  extends BroadcastReceiver
{
  public ApolloPanel$KapuPkgStateReceiver(ApolloPanel paramApolloPanel) {}
  
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
        QLog.d("ApolloPanel", 1, new Object[] { "kapu package state changed=", paramContext });
        if (!"android.intent.action.PACKAGE_REMOVED".equals(paramContext)) {
          break;
        }
      } while (!ApolloPanel.f(this.a));
      ApolloPanel.d(this.a, false);
      QLog.d("ApolloPanel", 1, "kapu remove, refresh");
      this.a.b(this.a.a.app.getCurrentUin());
      return;
    } while ((!"android.intent.action.PACKAGE_ADDED".equals(paramContext)) || (ApolloPanel.f(this.a)));
    ApolloPanel.d(this.a, true);
    QLog.d("ApolloPanel", 1, "kapu installed, refresh");
    this.a.b(this.a.a.app.getCurrentUin());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ApolloPanel.KapuPkgStateReceiver
 * JD-Core Version:    0.7.0.1
 */