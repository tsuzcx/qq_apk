package com.tencent.mobileqq.ark.vipreport;

import android.os.Build;
import android.text.TextUtils;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.mobileqq.ark.api.IArkConfig;
import com.tencent.mobileqq.ark.config.bean.ArkPlatformConfigBean;
import com.tencent.mobileqq.ark.config.config.ArkPlatformConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONObject;

public class ArkVipReporter
{
  static boolean a = true;
  static ArkVipReporter b = new ArkVipReporter();
  private static final Object c = new Object();
  private final HashMap<String, ArkVipSceneConfig> d = new HashMap(2);
  private final HashMap<String, ArkVipReportScene> e = new HashMap(2);
  
  public static ArkVipReporter a()
  {
    return b;
  }
  
  public void a(String paramString, long paramLong)
  {
    if (!a(paramString)) {
      return;
    }
    synchronized (c)
    {
      ArkVipSceneConfig localArkVipSceneConfig = c(paramString);
      if ((localArkVipSceneConfig != null) && (paramString.equals(localArkVipSceneConfig.b)))
      {
        String str = localArkVipSceneConfig.a;
        if (this.e.containsKey(str)) {
          b(str);
        }
        ArkVipReportScene localArkVipReportScene = new ArkVipReportScene();
        Object localObject1 = MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (((AppRuntime)localObject1).getAccount() == null) {
          localObject1 = "";
        } else {
          localObject1 = ((AppRuntime)localObject1).getAccount();
        }
        localArkVipReportScene.a = ((String)localObject1);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(Build.MANUFACTURER);
        ((StringBuilder)localObject1).append("_");
        ((StringBuilder)localObject1).append(Build.MODEL);
        localArkVipReportScene.b = ((StringBuilder)localObject1).toString();
        localArkVipReportScene.c = "android";
        localArkVipReportScene.d = "8.8.17_5770";
        localArkVipReportScene.e = str;
        localArkVipReportScene.f = localArkVipSceneConfig.b;
        localArkVipReportScene.g = localArkVipSceneConfig.c;
        localArkVipReportScene.h = paramLong;
        localArkVipReportScene.k = new ArrayList(8);
        this.e.put(str, localArkVipReportScene);
        QLog.d("ArkVipReporter", 1, new Object[] { "startSceneByEvent() sceneName=", str, ",evt =", paramString });
        ArkDispatchTask.getInstance().postToArkThreadDelay(new ArkVipReporter.1(this, str, localArkVipSceneConfig), localArkVipSceneConfig.d);
        return;
      }
      return;
    }
  }
  
  public void a(String paramString, ArkVipSceneConfig paramArkVipSceneConfig)
  {
    a = b();
    if ((a) && (!TextUtils.isEmpty(paramString)) && (!this.d.containsKey(paramString))) {
      this.d.put(paramString, paramArkVipSceneConfig);
    }
    QLog.d("ArkVipReporter", 1, new Object[] { "initScene() sceneName=", paramString, ", enable =", Boolean.valueOf(a) });
  }
  
  public void a(String paramString, boolean paramBoolean, long paramLong, HashMap<String, String> paramHashMap)
  {
    if (!a(paramString)) {
      return;
    }
    synchronized (c)
    {
      ArkVipSceneConfig localArkVipSceneConfig = c(paramString);
      if (localArkVipSceneConfig != null)
      {
        ArkVipReportScene localArkVipReportScene = (ArkVipReportScene)this.e.get(localArkVipSceneConfig.a);
        if (localArkVipReportScene == null) {
          return;
        }
        ArkVipReportItem localArkVipReportItem = new ArkVipReportItem();
        localArkVipReportItem.a = paramString;
        localArkVipReportItem.b = localArkVipReportScene.k.size();
        localArkVipReportItem.c = paramBoolean;
        localArkVipReportItem.e = System.currentTimeMillis();
        localArkVipReportItem.f = paramLong;
        localArkVipReportItem.d = (localArkVipReportItem.e - paramLong);
        localArkVipReportItem.g = NetworkUtil.getNetworkType(null);
        localArkVipReportItem.h = paramHashMap;
        localArkVipReportScene.k.add(localArkVipReportItem);
        QLog.d("ArkVipReporter", 1, new Object[] { "addEventToScene() evt:", paramString, ", cost time=", Long.valueOf(paramLong) });
        if (paramString.equals(localArkVipSceneConfig.c)) {
          b(localArkVipSceneConfig.a);
        }
      }
      return;
    }
  }
  
  boolean a(String paramString)
  {
    return (a) && (Utils.d()) && (!TextUtils.isEmpty(paramString));
  }
  
  void b(String paramString)
  {
    synchronized (c)
    {
      ArkVipReportScene localArkVipReportScene = (ArkVipReportScene)this.e.remove(paramString);
      if (localArkVipReportScene != null)
      {
        localArkVipReportScene.i = System.currentTimeMillis();
        localArkVipReportScene.j = (localArkVipReportScene.i - localArkVipReportScene.h);
        ??? = localArkVipReportScene.a().toString();
        QLog.d("ArkVipReporter", 1, new Object[] { "report() sceneName:", paramString, ",total cost time=", Long.valueOf(localArkVipReportScene.j) });
        ArkVipReporterIPCHandler.a((String)???);
      }
      return;
    }
  }
  
  boolean b()
  {
    ArkPlatformConfigBean localArkPlatformConfigBean = (ArkPlatformConfigBean)((IArkConfig)QRoute.api(IArkConfig.class)).loadConfig(ArkPlatformConfigBean.class);
    if ((localArkPlatformConfigBean != null) && (localArkPlatformConfigBean.b() != null)) {
      return localArkPlatformConfigBean.b().d;
    }
    return true;
  }
  
  ArkVipSceneConfig c(String paramString)
  {
    Iterator localIterator = this.d.entrySet().iterator();
    while (localIterator.hasNext())
    {
      ArkVipSceneConfig localArkVipSceneConfig = (ArkVipSceneConfig)((Map.Entry)localIterator.next()).getValue();
      if ((localArkVipSceneConfig.e != null) && (localArkVipSceneConfig.e.contains(paramString))) {
        return localArkVipSceneConfig;
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.vipreport.ArkVipReporter
 * JD-Core Version:    0.7.0.1
 */