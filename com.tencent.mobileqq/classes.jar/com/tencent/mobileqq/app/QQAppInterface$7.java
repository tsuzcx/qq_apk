package com.tencent.mobileqq.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hitrate.PreloadProcHitMgr;
import com.tencent.mobileqq.notification.modularize.OnlineModulePushReceiverKt;
import com.tencent.mobileqq.onlinestatus.auto.AutoStatusManager;

class QQAppInterface$7
  extends BroadcastReceiver
{
  QQAppInterface$7(QQAppInterface paramQQAppInterface) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (paramContext == null) {}
    do
    {
      do
      {
        do
        {
          return;
          if ((paramContext.equals("mqq.intent.action.ACCOUNT_CHANGED")) || (paramContext.equals("mqq.intent.action.ACCOUNT_KICKED")) || (paramContext.equals("mqq.intent.action.ACCOUNT_EXPIRED")) || (paramContext.equals("mqq.intent.action.FORCE_LOGOUT")) || (paramContext.equals("mqq.intent.action.LOGOUT")) || (paramContext.equals("mqq.intent.action.EXIT_" + BaseApplicationImpl.getApplication().getPackageName())))
          {
            PreloadProcHitMgr.a();
            OnlineModulePushReceiverKt.a();
            AutoStatusManager.c();
            return;
          }
        } while (!paramContext.equals("com.tencent.mobileqq.kickedLogin.otherDevice"));
        paramContext = paramIntent.getStringExtra("kickedUin");
      } while ((TextUtils.isEmpty(paramContext)) || (!paramContext.equals(this.this$0.getAccount())));
      paramContext = this.this$0.getKickIntent();
    } while (paramContext == null);
    paramContext.putExtra("isSameDevice", false);
    paramIntent = paramIntent.getStringExtra("msg");
    if (!TextUtils.isEmpty(paramIntent)) {
      paramContext.putExtra("msg", paramIntent);
    }
    this.this$0.setKickIntent(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.QQAppInterface.7
 * JD-Core Version:    0.7.0.1
 */