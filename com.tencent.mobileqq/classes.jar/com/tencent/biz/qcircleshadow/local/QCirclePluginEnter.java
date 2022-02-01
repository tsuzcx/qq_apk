package com.tencent.biz.qcircleshadow.local;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.tencent.biz.qcircleshadow.lib.QCircleHostClassHelper;
import com.tencent.biz.qcircleshadow.lib.QCirclePluginInitBean;
import com.tencent.biz.qcircleshadow.lib.delegate.ILoadPluginDelegate;
import com.tencent.biz.qcircleshadow.local.fragment.QCirclePluginLoadingFragment;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.jump.api.IJumpApi;
import com.tencent.mobileqq.mqq.api.IThreadManagerApi;
import com.tencent.mobileqq.qcircle.api.impl.QCircleServiceImpl;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.beans.QCircleSchemeBean;
import cooperation.qqcircle.proxy.QCircleInvokeProxy;
import cooperation.qqcircle.report.QCircleReportFirstLogin;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import mqq.app.MobileQQ;

public class QCirclePluginEnter
{
  private static final String TAG = "QCirclePluginEnter";
  private static Handler sHandler;
  
  static
  {
    HandlerThread localHandlerThread = new HandlerThread("qcircle_plugin_enter");
    localHandlerThread.start();
    sHandler = new Handler(localHandlerThread.getLooper());
  }
  
  public static void enterByScheme(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    Intent localIntent = new Intent(paramContext, QCircleHostClassHelper.getJumpActivityClass());
    localIntent.setData(Uri.parse(paramString));
    if (!(paramContext instanceof Activity)) {
      localIntent.addFlags(268435456);
    }
    paramContext.startActivity(localIntent);
  }
  
  public static void enterBySchemeAction(Context paramContext, String paramString, HashMap<String, String> paramHashMap)
  {
    enterBySchemeAction(paramContext, paramString, paramHashMap, null);
  }
  
  public static void enterBySchemeAction(Context paramContext, String paramString, HashMap<String, String> paramHashMap, HashMap<String, byte[]> paramHashMap1)
  {
    QCircleReportFirstLogin.recordFirstLoginSource(paramHashMap);
    if (isMainProcess())
    {
      QLog.d("QCirclePluginEnter", 1, "enter from main process");
      QCirclePluginInitBean localQCirclePluginInitBean = new QCirclePluginInitBean();
      localQCirclePluginInitBean.setLoadAction(1003);
      QCircleSchemeBean localQCircleSchemeBean = new QCircleSchemeBean();
      localQCircleSchemeBean.setSchemeAction(paramString);
      localQCircleSchemeBean.setAttrs(paramHashMap);
      long l = System.currentTimeMillis();
      localQCircleSchemeBean.setEnterTime(l);
      if (paramHashMap1 != null) {
        localQCircleSchemeBean.setByteAttrs(paramHashMap1);
      }
      localQCirclePluginInitBean.setInitBean(localQCircleSchemeBean);
      localQCirclePluginInitBean.setStartTime(l);
      if (!QCircleShadow.a().a())
      {
        QLog.d("QCirclePluginEnter", 1, "plugin not load");
        paramString = new Intent();
        paramString.addFlags(268435456);
        paramString.setClass(MobileQQ.getContext(), QPublicTransFragmentActivity.class);
        paramString.putExtra("public_fragment_class", QCirclePluginLoadingFragment.class.getCanonicalName());
        paramString.putExtra("public_fragment_window_feature", 1);
        paramString.putExtra("KEY_Q_CIRCLE_PLUGIN_INIT_BEAN", localQCirclePluginInitBean);
        paramContext.startActivity(paramString);
        return;
      }
      QLog.d("QCirclePluginEnter", 1, "plugin has load");
      enterQCirclePlugin(paramContext, localQCirclePluginInitBean);
      return;
    }
    QLog.d("QCirclePluginEnter", 1, "enter from other process");
    jumpByJumpActivity(paramContext, paramString, paramHashMap);
  }
  
  public static void enterQCirclePlugin(Context paramContext, QCirclePluginInitBean paramQCirclePluginInitBean)
  {
    if (sHandler == null)
    {
      QLog.d("QCirclePluginEnter", 1, "handler is empty");
      return;
    }
    QLog.d("QCirclePluginEnter", 1, "post start runnable");
    sHandler.post(new QCirclePluginEnter.1(paramQCirclePluginInitBean, paramContext));
  }
  
  private static String generateQCircleScheme(String paramString, HashMap<String, String> paramHashMap)
  {
    paramString = new StringBuilder("mqqapi://" + QCircleServiceImpl.getJumpApi().getJumpActionQCircle() + "/" + paramString + "?");
    if (paramHashMap != null)
    {
      Iterator localIterator = paramHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str1 = (String)localIterator.next();
        String str2 = (String)paramHashMap.get(str1);
        paramString.append(str1).append("=").append(str2).append("&");
      }
    }
    return paramString.toString();
  }
  
  public static boolean isMainProcess()
  {
    return MobileQQ.sProcessId == 1;
  }
  
  private static void jumpByJumpActivity(Context paramContext, String paramString, HashMap<String, String> paramHashMap)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    Intent localIntent = new Intent(paramContext, QCircleHostClassHelper.getJumpActivityClass());
    localIntent.setData(Uri.parse(generateQCircleScheme(paramString, paramHashMap)));
    if (!(paramContext instanceof Activity)) {
      localIntent.addFlags(268435456);
    }
    paramContext.startActivity(localIntent);
  }
  
  private static void load(Context paramContext, QCirclePluginEnterManger paramQCirclePluginEnterManger, int paramInt, QCirclePluginInitBean paramQCirclePluginInitBean)
  {
    QCircleInvokeProxy.invoke(2, 3, new Object[0]);
    Object localObject = paramQCirclePluginEnterManger.getPluginInfo();
    Bundle localBundle = new Bundle();
    localBundle.putString("pluginZipPath", ((QCircleSampleInfo)localObject).a());
    localBundle.putString("KEY_PLUGIN_PART_KEY", "qcircle-plugin");
    if (paramInt == 1000) {
      localBundle.putString("KEY_SPLASH_ENTER", "com.tencent.qcircle.activity.QCirclePreloadService");
    }
    for (;;)
    {
      if (paramQCirclePluginInitBean != null)
      {
        localObject = new Bundle();
        ((Bundle)localObject).putSerializable("KEY_Q_CIRCLE_PLUGIN_INIT_BEAN", paramQCirclePluginInitBean);
        localBundle.putBundle("KEY_EXTRAS", (Bundle)localObject);
      }
      paramQCirclePluginEnterManger.enter(paramContext, paramInt, localBundle, null);
      return;
      localBundle.putString("KEY_SPLASH_ENTER", "com.tencent.qcircle.activity.QCircleSplashActivity");
    }
  }
  
  public static void preloadQCirclePlugin(Context paramContext, ILoadPluginDelegate paramILoadPluginDelegate)
  {
    if ((paramContext == null) || (sHandler == null))
    {
      QLog.i("QCIRCLE_PLUGIN", 1, "context or handler is null");
      return;
    }
    if (!QCircleShadow.a().a())
    {
      sHandler.post(new QCirclePluginEnter.2(paramILoadPluginDelegate, paramContext));
      return;
    }
    ((IThreadManagerApi)QRoute.api(IThreadManagerApi.class)).getUIHandlerV2().post(new QCirclePluginEnter.3(paramILoadPluginDelegate));
    QLog.i("QCIRCLE_PLUGIN", 1, "preloadQCirclePlugin()has preload");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.local.QCirclePluginEnter
 * JD-Core Version:    0.7.0.1
 */