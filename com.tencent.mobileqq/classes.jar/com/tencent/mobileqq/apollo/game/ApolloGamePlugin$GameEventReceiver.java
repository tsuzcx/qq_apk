package com.tencent.mobileqq.apollo.game;

import ajac;
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
    if (paramIntent == null) {
      QLog.e("ApolloGamePlugin", 1, "[onReceive] intent null");
    }
    do
    {
      do
      {
        return;
        paramContext = paramIntent.getAction();
        if (QLog.isColorLevel()) {
          QLog.d("ApolloGamePlugin", 2, new Object[] { "[onReceive] action=", paramContext });
        }
      } while ((ajac.a() == null) || (!"com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT".equals(paramContext)) || (!"apolloGameWebMessage".equals(paramIntent.getStringExtra("event"))));
      paramContext = paramIntent.getStringExtra("data");
    } while (TextUtils.isEmpty(ApolloGamePlugin.a(this.a)));
    this.a.a(0, "sc.apolloGameWebMessage.local", paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.ApolloGamePlugin.GameEventReceiver
 * JD-Core Version:    0.7.0.1
 */