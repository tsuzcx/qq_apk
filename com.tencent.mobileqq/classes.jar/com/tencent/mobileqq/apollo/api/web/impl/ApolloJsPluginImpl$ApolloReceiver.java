package com.tencent.mobileqq.apollo.api.web.impl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

class ApolloJsPluginImpl$ApolloReceiver
  extends BroadcastReceiver
{
  private List<WeakReference<ApolloJsPluginImpl>> a = new ArrayList();
  
  public void a(ApolloJsPluginImpl paramApolloJsPluginImpl)
  {
    Object localObject;
    if (this.a.isEmpty())
    {
      localObject = new IntentFilter();
      ((IntentFilter)localObject).addAction("action_apollo_game_event_notify");
      BaseApplicationImpl.getContext().registerReceiver(this, (IntentFilter)localObject, "com.tencent.msg.permission.pushnotify", null);
      QLog.d("ApolloJsPlugin", 2, "onApolloJsCreated mJsList.isEmpty() registerReceiver");
    }
    int i = 0;
    if (i < this.a.size())
    {
      localObject = (ApolloJsPluginImpl)((WeakReference)this.a.get(i)).get();
      if ((localObject == null) || (((ApolloJsPluginImpl)localObject).mRuntime == null) || (paramApolloJsPluginImpl.mRuntime == null) || (((ApolloJsPluginImpl)localObject).mRuntime.a() != paramApolloJsPluginImpl.mRuntime.a())) {}
    }
    for (i = 1;; i = 0)
    {
      if (i == 0) {
        this.a.add(new WeakReference(paramApolloJsPluginImpl));
      }
      if (QLog.isColorLevel()) {
        QLog.d("ApolloJsPlugin", 2, new Object[] { "onApolloJsCreated add apolloJsPlugin:", paramApolloJsPluginImpl });
      }
      return;
      i += 1;
      break;
    }
  }
  
  public void b(ApolloJsPluginImpl paramApolloJsPluginImpl)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < this.a.size())
    {
      WeakReference localWeakReference = (WeakReference)this.a.get(i);
      ApolloJsPluginImpl localApolloJsPluginImpl = (ApolloJsPluginImpl)localWeakReference.get();
      if (localApolloJsPluginImpl == null) {
        localArrayList.add(localWeakReference);
      }
      for (;;)
      {
        i += 1;
        break;
        if (localApolloJsPluginImpl == paramApolloJsPluginImpl) {
          localArrayList.add(localWeakReference);
        }
      }
    }
    if (!localArrayList.isEmpty()) {
      this.a.removeAll(localArrayList);
    }
    if (this.a.isEmpty()) {}
    try
    {
      BaseApplicationImpl.getContext().unregisterReceiver(this);
      QLog.d("ApolloJsPlugin", 2, "onApolloJsDestroy mJsList.isEmpty() unregisterReceiver");
      if (QLog.isColorLevel()) {
        QLog.d("ApolloJsPlugin", 2, new Object[] { "onApolloJsDestroy remove apolloJsPlugin:", paramApolloJsPluginImpl });
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("ApolloJsPlugin", 1, "[onDestroy] exception=", localException);
      }
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {
      QLog.e("ApolloJsPlugin", 1, "[onReceive] intent null");
    }
    for (;;)
    {
      return;
      paramContext = paramIntent.getAction();
      if (QLog.isColorLevel()) {
        QLog.d("ApolloJsPlugin", 2, new Object[] { "[onReceive] action=", paramContext });
      }
      if ("action_apollo_game_event_notify".equals(paramContext)) {
        try
        {
          paramIntent = paramIntent.getStringExtra("data");
          paramContext = new JSONObject(paramIntent);
          if (QLog.isColorLevel()) {
            QLog.d("ApolloJsPlugin", 2, new Object[] { "[onReceive] data=", paramIntent });
          }
          if (!this.a.isEmpty())
          {
            paramIntent = new ArrayList();
            int i = this.a.size() - 1;
            while (i >= 0)
            {
              ApolloJsPluginImpl localApolloJsPluginImpl = (ApolloJsPluginImpl)((WeakReference)this.a.get(i)).get();
              if ((localApolloJsPluginImpl != null) && (localApolloJsPluginImpl.mRuntime != null))
              {
                CustomWebView localCustomWebView = localApolloJsPluginImpl.mRuntime.a();
                if ((localCustomWebView != null) && (!paramIntent.contains(localCustomWebView)))
                {
                  localApolloJsPluginImpl.dispatchJsEvent("apolloGameWebMessage", paramContext, null);
                  paramIntent.add(localCustomWebView);
                  if (QLog.isColorLevel()) {
                    QLog.d("ApolloJsPlugin", 2, new Object[] { "jsPlugin.dispatchJsEvent, jsPlugin:", localApolloJsPluginImpl, "webview:", localCustomWebView });
                  }
                }
              }
              i -= 1;
            }
            if (!"action_apollo_cmshow_content_update".equals(paramContext)) {}
          }
        }
        catch (Exception paramContext)
        {
          QLog.e("ApolloJsPlugin", 1, "[onReceive] exception=", paramContext);
          return;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("ApolloJsPlugin", 2, "rscContent_ApolloRscCacheManager onReceive action:" + paramContext);
    }
    paramContext = paramIntent.getStringExtra("key_content_update_zip_name");
    QLog.i("ApolloJsPlugin", 1, "rscContent_ApolloRscCacheManager onReceive zipName:" + paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.web.impl.ApolloJsPluginImpl.ApolloReceiver
 * JD-Core Version:    0.7.0.1
 */