package com.tencent.mobileqq.apollo.game;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class ApolloGamePlugin$GameEventReceiver
  extends BroadcastReceiver
{
  public ApolloGamePlugin$GameEventReceiver(ApolloGamePlugin paramApolloGamePlugin) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null)
    {
      QLog.e("[cmshow]ApolloGamePlugin", 1, "[onReceive] intent null");
      return;
    }
    paramContext = paramIntent.getAction();
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloGamePlugin", 2, new Object[] { "[onReceive] action=", paramContext });
    }
    if (!"com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT".equals(paramContext)) {
      return;
    }
    if (!"apolloGameWebMessage".equals(paramIntent.getStringExtra("event"))) {
      return;
    }
    paramContext = paramIntent.getStringExtra("data");
    if (!TextUtils.isEmpty(ApolloGamePlugin.a(this.a))) {
      this.a.a(0, "sc.apolloGameWebMessage.local", paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.ApolloGamePlugin.GameEventReceiver
 * JD-Core Version:    0.7.0.1
 */