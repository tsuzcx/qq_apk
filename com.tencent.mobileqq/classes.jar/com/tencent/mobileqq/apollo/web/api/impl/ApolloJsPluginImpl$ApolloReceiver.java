package com.tencent.mobileqq.apollo.web.api.impl;

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
      QLog.d("[cmshow]ApolloJsPlugin", 2, "onApolloJsCreated mJsList.isEmpty() registerReceiver");
    }
    int i = 0;
    while (i < this.a.size())
    {
      localObject = (ApolloJsPluginImpl)((WeakReference)this.a.get(i)).get();
      if ((localObject != null) && (((ApolloJsPluginImpl)localObject).mRuntime != null) && (paramApolloJsPluginImpl.mRuntime != null) && (((ApolloJsPluginImpl)localObject).mRuntime.a() == paramApolloJsPluginImpl.mRuntime.a()))
      {
        i = 1;
        break label130;
      }
      i += 1;
    }
    i = 0;
    label130:
    if (i == 0) {
      this.a.add(new WeakReference(paramApolloJsPluginImpl));
    }
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloJsPlugin", 2, new Object[] { "onApolloJsCreated add apolloJsPlugin:", paramApolloJsPluginImpl });
    }
  }
  
  public void b(ApolloJsPluginImpl paramApolloJsPluginImpl)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.a.size())
    {
      WeakReference localWeakReference = (WeakReference)this.a.get(i);
      ApolloJsPluginImpl localApolloJsPluginImpl = (ApolloJsPluginImpl)localWeakReference.get();
      if (localApolloJsPluginImpl == null) {
        localArrayList.add(localWeakReference);
      } else if (localApolloJsPluginImpl == paramApolloJsPluginImpl) {
        localArrayList.add(localWeakReference);
      }
      i += 1;
    }
    if (!localArrayList.isEmpty()) {
      this.a.removeAll(localArrayList);
    }
    if (this.a.isEmpty()) {
      try
      {
        BaseApplicationImpl.getContext().unregisterReceiver(this);
        QLog.d("[cmshow]ApolloJsPlugin", 2, "onApolloJsDestroy mJsList.isEmpty() unregisterReceiver");
      }
      catch (Exception localException)
      {
        QLog.e("[cmshow]ApolloJsPlugin", 1, "[onDestroy] exception=", localException);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloJsPlugin", 2, new Object[] { "onApolloJsDestroy remove apolloJsPlugin:", paramApolloJsPluginImpl });
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null)
    {
      QLog.e("[cmshow]ApolloJsPlugin", 1, "[onReceive] intent null");
      return;
    }
    paramContext = paramIntent.getAction();
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloJsPlugin", 2, new Object[] { "[onReceive] action=", paramContext });
    }
    Object localObject;
    if ("action_apollo_game_event_notify".equals(paramContext))
    {
      try
      {
        paramIntent = paramIntent.getStringExtra("data");
        paramContext = new JSONObject(paramIntent);
        if (QLog.isColorLevel()) {
          QLog.d("[cmshow]ApolloJsPlugin", 2, new Object[] { "[onReceive] data=", paramIntent });
        }
        if (this.a.isEmpty()) {
          return;
        }
        paramIntent = new ArrayList();
        int i = this.a.size() - 1;
        while (i >= 0)
        {
          localObject = (ApolloJsPluginImpl)((WeakReference)this.a.get(i)).get();
          if ((localObject != null) && (((ApolloJsPluginImpl)localObject).mRuntime != null))
          {
            CustomWebView localCustomWebView = ((ApolloJsPluginImpl)localObject).mRuntime.a();
            if ((localCustomWebView != null) && (!paramIntent.contains(localCustomWebView)))
            {
              ((ApolloJsPluginImpl)localObject).dispatchJsEvent("apolloGameWebMessage", paramContext, null);
              paramIntent.add(localCustomWebView);
              if (QLog.isColorLevel()) {
                QLog.d("[cmshow]ApolloJsPlugin", 2, new Object[] { "jsPlugin.dispatchJsEvent, jsPlugin:", localObject, "webview:", localCustomWebView });
              }
            }
          }
          i -= 1;
        }
        if (!"action_apollo_cmshow_content_update".equals(paramContext)) {
          return;
        }
      }
      catch (Exception paramContext)
      {
        QLog.e("[cmshow]ApolloJsPlugin", 1, "[onReceive] exception=", paramContext);
        return;
      }
    }
    else
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("rscContent_ApolloRscCacheManager onReceive action:");
        ((StringBuilder)localObject).append(paramContext);
        QLog.i("[cmshow]ApolloJsPlugin", 2, ((StringBuilder)localObject).toString());
      }
      paramContext = paramIntent.getStringExtra("key_content_update_zip_name");
      paramIntent = new StringBuilder();
      paramIntent.append("rscContent_ApolloRscCacheManager onReceive zipName:");
      paramIntent.append(paramContext);
      QLog.i("[cmshow]ApolloJsPlugin", 1, paramIntent.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.web.api.impl.ApolloJsPluginImpl.ApolloReceiver
 * JD-Core Version:    0.7.0.1
 */