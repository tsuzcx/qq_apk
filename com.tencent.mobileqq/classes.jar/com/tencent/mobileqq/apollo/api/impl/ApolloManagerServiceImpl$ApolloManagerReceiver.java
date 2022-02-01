package com.tencent.mobileqq.apollo.api.impl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.handler.ApolloExtensionHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.qphone.base.util.QLog;

class ApolloManagerServiceImpl$ApolloManagerReceiver
  extends BroadcastReceiver
{
  private ApolloManagerServiceImpl$ApolloManagerReceiver(ApolloManagerServiceImpl paramApolloManagerServiceImpl) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null)
    {
      QLog.e("[cmshow]ApolloManager", 1, "[onReceive] intent null");
      return;
    }
    paramContext = paramIntent.getAction();
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloManager", 2, new Object[] { "[onReceive] action=", paramContext });
    }
    if ("com.tencent.mobileqq.action.ACTION_APOLLO_STORE_CRASH_EVENT".equals(paramContext))
    {
      paramContext = BaseApplicationImpl.getApplication().getSharedPreferences("apollo_user_config", 0).getString("apollo_store_watch_current_url", "");
      paramIntent = ApolloManagerServiceImpl.access$200(this.a);
      if (paramIntent != null) {
        ((ApolloExtensionHandler)paramIntent.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER)).a(null, paramContext, -1003, 0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl.ApolloManagerReceiver
 * JD-Core Version:    0.7.0.1
 */