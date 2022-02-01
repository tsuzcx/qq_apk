package com.tencent.mobileqq.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hitrate.PreloadProcHitMgr;
import com.tencent.mobileqq.notification.modularize.OnlineModulePushReceiverKt;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusManagerService;
import com.tencent.mobileqq.onlinestatus.manager.IAutoStatusManager;

class QQAppInterface$7
  extends BroadcastReceiver
{
  QQAppInterface$7(QQAppInterface paramQQAppInterface) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (paramContext == null) {
      return;
    }
    if ((!paramContext.equals("mqq.intent.action.ACCOUNT_CHANGED")) && (!paramContext.equals("mqq.intent.action.ACCOUNT_KICKED")) && (!paramContext.equals("mqq.intent.action.ACCOUNT_EXPIRED")) && (!paramContext.equals("mqq.intent.action.FORCE_LOGOUT")) && (!paramContext.equals("mqq.intent.action.LOGOUT")))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("mqq.intent.action.EXIT_");
      localStringBuilder.append(BaseApplicationImpl.getApplication().getPackageName());
      if (!paramContext.equals(localStringBuilder.toString()))
      {
        if (!paramContext.equals("com.tencent.mobileqq.kickedLogin.otherDevice")) {
          return;
        }
        paramContext = paramIntent.getStringExtra("kickedUin");
        if ((TextUtils.isEmpty(paramContext)) || (!paramContext.equals(this.this$0.getAccount()))) {
          return;
        }
        paramContext = this.this$0.getKickIntent();
        if (paramContext == null) {
          return;
        }
        paramContext.putExtra("isSameDevice", false);
        paramIntent = paramIntent.getStringExtra("msg");
        if (!TextUtils.isEmpty(paramIntent)) {
          paramContext.putExtra("msg", paramIntent);
        }
        this.this$0.setKickIntent(paramContext);
        return;
      }
    }
    PreloadProcHitMgr.a();
    OnlineModulePushReceiverKt.a();
    paramContext = (IAutoStatusManager)((IOnlineStatusManagerService)this.this$0.getRuntimeService(IOnlineStatusManagerService.class)).getManager(IAutoStatusManager.class);
    if (paramContext != null) {
      paramContext.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.QQAppInterface.7
 * JD-Core Version:    0.7.0.1
 */