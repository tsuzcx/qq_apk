package com.tencent.mobileqq.ark.vipreport;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.ark.ArkAppCGI;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.image.ChooseImageIPCModule;
import com.tencent.mobileqq.config.business.ArkConfBean;
import com.tencent.mobileqq.config.business.ArkConfBean.ArkPlatformConfigBean;
import com.tencent.mobileqq.config.business.ArkConfProcessor;
import com.tencent.mobileqq.config.business.ArkManageConfig.ArkPlatformConfig;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class ArkVipReporter
{
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  private static HashMap<String, ArkVipSceneConfig> jdField_a_of_type_JavaUtilHashMap = new HashMap(2);
  private static boolean jdField_a_of_type_Boolean = true;
  private static HashMap<String, ArkVipReportScene> b = new HashMap(2);
  
  private static ArkVipSceneConfig a(String paramString)
  {
    Iterator localIterator = jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      ArkVipSceneConfig localArkVipSceneConfig = (ArkVipSceneConfig)((Map.Entry)localIterator.next()).getValue();
      if ((localArkVipSceneConfig.jdField_a_of_type_JavaUtilSet != null) && (localArkVipSceneConfig.jdField_a_of_type_JavaUtilSet.contains(paramString))) {
        return localArkVipSceneConfig;
      }
    }
    return null;
  }
  
  public static void a(String paramString, long paramLong)
  {
    if ((jdField_a_of_type_Boolean) && (Utils.b()) && (!TextUtils.isEmpty(paramString))) {
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        ArkVipSceneConfig localArkVipSceneConfig = a(paramString);
        if ((localArkVipSceneConfig != null) && (paramString.equals(localArkVipSceneConfig.jdField_b_of_type_JavaLangString)))
        {
          String str = localArkVipSceneConfig.jdField_a_of_type_JavaLangString;
          if (b.containsKey(str)) {
            b(str);
          }
          ArkVipReportScene localArkVipReportScene = new ArkVipReportScene();
          localObject1 = BaseApplicationImpl.getApplication().getRuntime();
          if (((AppRuntime)localObject1).getAccount() == null)
          {
            localObject1 = "";
            localArkVipReportScene.jdField_a_of_type_JavaLangString = ((String)localObject1);
            localArkVipReportScene.jdField_b_of_type_JavaLangString = (Build.MANUFACTURER + "_" + Build.MODEL);
            localArkVipReportScene.jdField_c_of_type_JavaLangString = "android";
            localArkVipReportScene.d = "8.5.5_5105";
            localArkVipReportScene.e = str;
            localArkVipReportScene.f = localArkVipSceneConfig.jdField_b_of_type_JavaLangString;
            localArkVipReportScene.g = localArkVipSceneConfig.jdField_c_of_type_JavaLangString;
            localArkVipReportScene.jdField_a_of_type_Long = paramLong;
            localArkVipReportScene.jdField_a_of_type_JavaUtilArrayList = new ArrayList(8);
            b.put(str, localArkVipReportScene);
            QLog.d("ArkVipReporter", 1, new Object[] { "startSceneByEvent() sceneName=", str, ",evt =", paramString });
            ArkDispatchTask.getInstance().postToArkThreadDelay(new ArkVipReporter.1(str, localArkVipSceneConfig), localArkVipSceneConfig.jdField_a_of_type_Long);
          }
        }
        else
        {
          return;
        }
        Object localObject1 = ((AppRuntime)localObject1).getAccount();
      }
    }
  }
  
  public static void a(String paramString, ArkVipSceneConfig paramArkVipSceneConfig)
  {
    ArkConfBean.ArkPlatformConfigBean localArkPlatformConfigBean = ArkConfProcessor.b(380).a();
    if ((localArkPlatformConfigBean != null) && (localArkPlatformConfigBean.a() != null)) {
      jdField_a_of_type_Boolean = localArkPlatformConfigBean.a().c;
    }
    if ((jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(paramString)) && (!jdField_a_of_type_JavaUtilHashMap.containsKey(paramArkVipSceneConfig))) {
      jdField_a_of_type_JavaUtilHashMap.put(paramString, paramArkVipSceneConfig);
    }
    QLog.d("ArkVipReporter", 1, new Object[] { "initScene() sceneName=", paramString, ", enable =", Boolean.valueOf(jdField_a_of_type_Boolean) });
  }
  
  public static void a(String paramString, boolean paramBoolean, long paramLong, HashMap<String, String> paramHashMap)
  {
    if ((jdField_a_of_type_Boolean) && (Utils.b()) && (!TextUtils.isEmpty(paramString))) {
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        ArkVipSceneConfig localArkVipSceneConfig = a(paramString);
        if (localArkVipSceneConfig != null)
        {
          ArkVipReportScene localArkVipReportScene = (ArkVipReportScene)b.get(localArkVipSceneConfig.jdField_a_of_type_JavaLangString);
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
          localArkVipReportItem.d = NetworkUtil.b(null);
          localArkVipReportItem.jdField_a_of_type_JavaUtilHashMap = paramHashMap;
          localArkVipReportScene.jdField_a_of_type_JavaUtilArrayList.add(localArkVipReportItem);
          QLog.d("ArkVipReporter", 1, new Object[] { "addEventToScene() evt:", paramString, ", cost time=", Long.valueOf(paramLong) });
          if (paramString.equals(localArkVipSceneConfig.jdField_c_of_type_JavaLangString)) {
            b(localArkVipSceneConfig.jdField_a_of_type_JavaLangString);
          }
        }
        return;
      }
    }
  }
  
  private static void b(String paramString)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      ArkVipReportScene localArkVipReportScene = (ArkVipReportScene)b.remove(paramString);
      if (localArkVipReportScene != null)
      {
        localArkVipReportScene.jdField_b_of_type_Long = System.currentTimeMillis();
        localArkVipReportScene.jdField_c_of_type_Long = (localArkVipReportScene.jdField_b_of_type_Long - localArkVipReportScene.jdField_a_of_type_Long);
        ??? = localArkVipReportScene.a().toString();
        QLog.d("ArkVipReporter", 1, new Object[] { "report() sceneName:", paramString, ",total cost time=", Long.valueOf(localArkVipReportScene.jdField_c_of_type_Long) });
        if (1 != BaseApplicationImpl.sProcessId) {
          break label137;
        }
        paramString = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
        if (paramString != null)
        {
          paramString = ((ArkAppCenter)paramString.getManager(QQManagerFactory.ARK_APP_CENTER_MANAGER)).a();
          if (paramString != null) {
            paramString.b((String)???);
          }
        }
      }
      return;
    }
    label137:
    paramString = new Bundle();
    paramString.putString("reportContent", (String)???);
    ChooseImageIPCModule.a().a("callVIPReport", paramString, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.vipreport.ArkVipReporter
 * JD-Core Version:    0.7.0.1
 */