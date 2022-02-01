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
  static ArkVipReporter jdField_a_of_type_ComTencentMobileqqArkVipreportArkVipReporter = new ArkVipReporter();
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  static boolean jdField_a_of_type_Boolean = true;
  private final HashMap<String, ArkVipSceneConfig> jdField_a_of_type_JavaUtilHashMap = new HashMap(2);
  private final HashMap<String, ArkVipReportScene> b = new HashMap(2);
  
  public static ArkVipReporter a()
  {
    return jdField_a_of_type_ComTencentMobileqqArkVipreportArkVipReporter;
  }
  
  ArkVipSceneConfig a(String paramString)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      ArkVipSceneConfig localArkVipSceneConfig = (ArkVipSceneConfig)((Map.Entry)localIterator.next()).getValue();
      if ((localArkVipSceneConfig.jdField_a_of_type_JavaUtilSet != null) && (localArkVipSceneConfig.jdField_a_of_type_JavaUtilSet.contains(paramString))) {
        return localArkVipSceneConfig;
      }
    }
    return null;
  }
  
  void a(String paramString)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      ArkVipReportScene localArkVipReportScene = (ArkVipReportScene)this.b.remove(paramString);
      if (localArkVipReportScene != null)
      {
        localArkVipReportScene.jdField_b_of_type_Long = System.currentTimeMillis();
        localArkVipReportScene.jdField_c_of_type_Long = (localArkVipReportScene.jdField_b_of_type_Long - localArkVipReportScene.jdField_a_of_type_Long);
        ??? = localArkVipReportScene.a().toString();
        QLog.d("ArkVipReporter", 1, new Object[] { "report() sceneName:", paramString, ",total cost time=", Long.valueOf(localArkVipReportScene.jdField_c_of_type_Long) });
        ArkVipReporterIPCHandler.a((String)???);
      }
      return;
    }
  }
  
  public void a(String paramString, long paramLong)
  {
    if (!a(paramString)) {
      return;
    }
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      ArkVipSceneConfig localArkVipSceneConfig = a(paramString);
      if ((localArkVipSceneConfig != null) && (paramString.equals(localArkVipSceneConfig.jdField_b_of_type_JavaLangString)))
      {
        String str = localArkVipSceneConfig.jdField_a_of_type_JavaLangString;
        if (this.b.containsKey(str)) {
          a(str);
        }
        ArkVipReportScene localArkVipReportScene = new ArkVipReportScene();
        Object localObject1 = MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (((AppRuntime)localObject1).getAccount() == null) {
          localObject1 = "";
        } else {
          localObject1 = ((AppRuntime)localObject1).getAccount();
        }
        localArkVipReportScene.jdField_a_of_type_JavaLangString = ((String)localObject1);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(Build.MANUFACTURER);
        ((StringBuilder)localObject1).append("_");
        ((StringBuilder)localObject1).append(Build.MODEL);
        localArkVipReportScene.jdField_b_of_type_JavaLangString = ((StringBuilder)localObject1).toString();
        localArkVipReportScene.jdField_c_of_type_JavaLangString = "android";
        localArkVipReportScene.d = "8.7.0_5295";
        localArkVipReportScene.e = str;
        localArkVipReportScene.f = localArkVipSceneConfig.jdField_b_of_type_JavaLangString;
        localArkVipReportScene.g = localArkVipSceneConfig.jdField_c_of_type_JavaLangString;
        localArkVipReportScene.jdField_a_of_type_Long = paramLong;
        localArkVipReportScene.jdField_a_of_type_JavaUtilArrayList = new ArrayList(8);
        this.b.put(str, localArkVipReportScene);
        QLog.d("ArkVipReporter", 1, new Object[] { "startSceneByEvent() sceneName=", str, ",evt =", paramString });
        ArkDispatchTask.getInstance().postToArkThreadDelay(new ArkVipReporter.1(this, str, localArkVipSceneConfig), localArkVipSceneConfig.jdField_a_of_type_Long);
        return;
      }
      return;
    }
  }
  
  public void a(String paramString, ArkVipSceneConfig paramArkVipSceneConfig)
  {
    jdField_a_of_type_Boolean = a();
    if ((jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(paramString)) && (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString))) {
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, paramArkVipSceneConfig);
    }
    QLog.d("ArkVipReporter", 1, new Object[] { "initScene() sceneName=", paramString, ", enable =", Boolean.valueOf(jdField_a_of_type_Boolean) });
  }
  
  public void a(String paramString, boolean paramBoolean, long paramLong, HashMap<String, String> paramHashMap)
  {
    if (!a(paramString)) {
      return;
    }
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      ArkVipSceneConfig localArkVipSceneConfig = a(paramString);
      if (localArkVipSceneConfig != null)
      {
        ArkVipReportScene localArkVipReportScene = (ArkVipReportScene)this.b.get(localArkVipSceneConfig.jdField_a_of_type_JavaLangString);
        if (localArkVipReportScene == null) {
          return;
        }
        ArkVipReportItem localArkVipReportItem = new ArkVipReportItem();
        localArkVipReportItem.jdField_a_of_type_JavaLangString = paramString;
        localArkVipReportItem.jdField_a_of_type_Int = localArkVipReportScene.jdField_a_of_type_JavaUtilArrayList.size();
        localArkVipReportItem.jdField_a_of_type_Boolean = paramBoolean;
        localArkVipReportItem.jdField_b_of_type_Long = System.currentTimeMillis();
        localArkVipReportItem.jdField_c_of_type_Long = paramLong;
        localArkVipReportItem.jdField_a_of_type_Long = (localArkVipReportItem.jdField_b_of_type_Long - paramLong);
        localArkVipReportItem.d = NetworkUtil.getNetworkType(null);
        localArkVipReportItem.jdField_a_of_type_JavaUtilHashMap = paramHashMap;
        localArkVipReportScene.jdField_a_of_type_JavaUtilArrayList.add(localArkVipReportItem);
        QLog.d("ArkVipReporter", 1, new Object[] { "addEventToScene() evt:", paramString, ", cost time=", Long.valueOf(paramLong) });
        if (paramString.equals(localArkVipSceneConfig.jdField_c_of_type_JavaLangString)) {
          a(localArkVipSceneConfig.jdField_a_of_type_JavaLangString);
        }
      }
      return;
    }
  }
  
  boolean a()
  {
    ArkPlatformConfigBean localArkPlatformConfigBean = (ArkPlatformConfigBean)((IArkConfig)QRoute.api(IArkConfig.class)).loadConfig(ArkPlatformConfigBean.class);
    if ((localArkPlatformConfigBean != null) && (localArkPlatformConfigBean.a() != null)) {
      return localArkPlatformConfigBean.a().c;
    }
    return true;
  }
  
  boolean a(String paramString)
  {
    return (jdField_a_of_type_Boolean) && (Utils.b()) && (!TextUtils.isEmpty(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.vipreport.ArkVipReporter
 * JD-Core Version:    0.7.0.1
 */