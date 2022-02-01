package com.tencent.biz.pubaccount.util;

import android.text.TextUtils;
import aqju;
import arta;
import bdmc;
import bioy;
import bnrf;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.config.beans.AchillesParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.RockDownloadInfo;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.NetworkState;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.app.AppRuntime;
import org.json.JSONObject;
import ozs;

public class Achilles
{
  private static final Runnable jdField_a_of_type_JavaLangRunnable = new Achilles.1();
  private static String jdField_a_of_type_JavaLangString;
  private static Map<String, Long> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  static
  {
    jdField_a_of_type_JavaLangString = "biz_src_feeds_kandian_tab";
  }
  
  public static int a(String paramString1, String paramString2)
  {
    paramString1 = paramString1.split("\\.");
    paramString2 = paramString2.split("\\.");
    int i;
    int j;
    if (paramString1.length < paramString2.length)
    {
      i = paramString1.length;
      j = 0;
    }
    for (;;)
    {
      if (j >= i) {
        break label78;
      }
      int k = Integer.parseInt(paramString1[j]);
      int m = Integer.parseInt(paramString2[j]);
      if (k > m)
      {
        return 1;
        i = paramString2.length;
        break;
      }
      if (k < m) {
        return -1;
      }
      j += 1;
    }
    label78:
    return 0;
  }
  
  public static RockDownloadInfo a(String paramString)
  {
    List localList = a(paramString);
    QLog.d("Achilles", 1, "[installIfDownloaded] downloadInfoList: " + localList);
    Iterator localIterator = null;
    paramString = null;
    Object localObject = localIterator;
    if (localList != null)
    {
      localObject = localIterator;
      if (localList.size() > 0)
      {
        int i = -1;
        localIterator = localList.iterator();
        localObject = paramString;
        if (localIterator.hasNext())
        {
          localObject = (RockDownloadInfo)localIterator.next();
          if (((RockDownloadInfo)localObject).getRealVersionCode() <= i) {
            break label106;
          }
          i = ((RockDownloadInfo)localObject).getRealVersionCode();
          paramString = (String)localObject;
        }
      }
    }
    label106:
    for (;;)
    {
      break;
      return localObject;
    }
  }
  
  public static String a(String paramString)
  {
    Object localObject1 = null;
    for (;;)
    {
      try
      {
        bnrf.e();
        Object localObject2 = a();
        if ((localObject2 == null) || (((Set)localObject2).isEmpty()))
        {
          QLog.e("Achilles", 1, "[queryPreDownloadInfoAladdin] empty param set.");
          return "";
        }
        Object localObject3 = ((Set)localObject2).iterator();
        if (((Iterator)localObject3).hasNext())
        {
          localObject2 = (AchillesParams)((Iterator)localObject3).next();
          if (!TextUtils.equals(((AchillesParams)localObject2).getPackageName(), paramString)) {
            break label297;
          }
          localObject1 = localObject2;
          break label300;
        }
        if (localObject1 == null)
        {
          QLog.e("Achilles", 1, "[queryPreDownloadInfoAladdin] param not found for " + paramString);
          return "";
        }
        localObject3 = a(paramString);
        if (localObject3 != null)
        {
          bool = true;
          QLog.i("Achilles", 1, "[queryPreDownloadInfoAladdin] download info pkgExist:" + bool + " packageName:" + ((AchillesParams)localObject1).getPackageName());
          localObject2 = new JSONObject();
          ((JSONObject)localObject2).put("app_id", ((AchillesParams)localObject1).getAppId());
          if (localObject3 == null) {
            break label303;
          }
          paramString = ((RockDownloadInfo)localObject3).getDownloadURL();
          ((JSONObject)localObject2).put("download_url", paramString);
          if (!bool) {
            break label309;
          }
          i = 1;
          ((JSONObject)localObject2).put("download_finished", i);
          if (!((AchillesParams)localObject1).isEnable()) {
            break label314;
          }
          i = 1;
          ((JSONObject)localObject2).put("enable_predownload", i);
          if (!bool) {
            break label319;
          }
          paramString = "1";
          if (localObject3 != null)
          {
            localObject1 = ((RockDownloadInfo)localObject3).getPackageName();
            AchillesFragmentUtils.a("query", paramString, (String)localObject1, null);
            return ((JSONObject)localObject2).toString();
          }
          localObject1 = "";
          continue;
        }
        boolean bool = false;
      }
      catch (Exception paramString)
      {
        QLog.e("Achilles", 1, "[queryPreDownloadInfoAladdin] ", paramString);
        return "";
      }
      continue;
      label297:
      label300:
      continue;
      label303:
      paramString = "";
      continue;
      label309:
      int i = 0;
      continue;
      label314:
      i = 0;
      continue;
      label319:
      paramString = "0";
    }
  }
  
  private static List<RockDownloadInfo> a(String paramString)
  {
    RockDownloadInfo localRockDownloadInfo = new RockDownloadInfo();
    localRockDownloadInfo.packageName = paramString;
    localRockDownloadInfo.businessName = "biz_src_feeds_kandian_tab";
    paramString = aqju.a(localRockDownloadInfo);
    if ((paramString != null) && (paramString.size() > 0)) {}
    ArrayList localArrayList;
    do
    {
      do
      {
        return paramString;
        localRockDownloadInfo.businessName = "biz_src_feeds_kandian_news";
        localArrayList = aqju.a(localRockDownloadInfo);
        if (localArrayList == null) {
          break;
        }
        paramString = localArrayList;
      } while (localArrayList.size() > 0);
      localRockDownloadInfo.businessName = "biz_src_feeds_kandian_daily";
      localArrayList = aqju.a(localRockDownloadInfo);
      if (localArrayList == null) {
        break;
      }
      paramString = localArrayList;
    } while (localArrayList.size() > 0);
    return null;
  }
  
  public static Set<AchillesParams> a()
  {
    return Aladdin.getConfig(140).getSet("param_set");
  }
  
  public static void a(String paramString)
  {
    QLog.d("Achilles", 2, "[maybeStart] ");
    jdField_a_of_type_JavaLangString = paramString;
    ThreadManager.executeOnFileThread(jdField_a_of_type_JavaLangRunnable);
  }
  
  public static boolean a(String paramString)
  {
    try
    {
      if (arta.a(paramString, BaseApplicationImpl.getContext()))
      {
        QLog.e("Achilles", 1, "[isInstalled] true");
        return true;
      }
    }
    catch (Exception paramString)
    {
      QLog.e("Achilles", 1, "[isInstalled] ", paramString);
      return false;
    }
    QLog.e("Achilles", 1, "[isInstalled] false");
    return false;
  }
  
  public static boolean a(String paramString1, String paramString2, bioy parambioy, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        bnrf.e();
        localObject = a();
        if ((localObject == null) || (((Set)localObject).isEmpty()))
        {
          QLog.e("Achilles", 1, "[installIfDownloaded] empty param set");
          return false;
        }
        Iterator localIterator = ((Set)localObject).iterator();
        if (localIterator.hasNext())
        {
          localObject = (AchillesParams)localIterator.next();
          if (!TextUtils.equals(((AchillesParams)localObject).getPackageName(), paramString2)) {
            continue;
          }
          if ((localObject == null) || (!((AchillesParams)localObject).isEnable()))
          {
            QLog.e("Achilles", 1, "[installIfDownloaded] no enabled found in param set, package name: " + paramString2);
            return false;
          }
          if ((paramBoolean) && (!((AchillesParams)localObject).isInstallIfJump()))
          {
            QLog.e("Achilles", 1, "[installIfDownloaded] installIfJump is false " + paramString2);
            return false;
          }
          paramBoolean = AchillesFragmentUtils.a(paramString1, paramString2, parambioy);
          return paramBoolean;
        }
      }
      catch (Exception paramString1)
      {
        QLog.e("Achilles", 1, "[installIfDownloaded] ", paramString1);
        return false;
      }
      Object localObject = null;
    }
  }
  
  public static boolean a(String paramString, boolean paramBoolean)
  {
    return a(null, paramString, null, true);
  }
  
  private static RockDownloadInfo b(AchillesParams paramAchillesParams)
  {
    RockDownloadInfo localRockDownloadInfo = new RockDownloadInfo();
    localRockDownloadInfo.packageName = paramAchillesParams.getPackageName();
    localRockDownloadInfo.businessName = jdField_a_of_type_JavaLangString;
    localRockDownloadInfo.businessScene = paramAchillesParams.getSceneId();
    localRockDownloadInfo.downloadURL = paramAchillesParams.getDownloadUrl();
    localRockDownloadInfo.versionCode = paramAchillesParams.getVersionCode();
    return localRockDownloadInfo;
  }
  
  private static void b(RockDownloadInfo paramRockDownloadInfo, AchillesParams paramAchillesParams)
  {
    QLog.d("Achilles", 1, "start download " + paramAchillesParams);
    AchillesFragmentUtils.a("download", "1", paramAchillesParams.getPackageName(), paramAchillesParams);
    aqju.a(paramRockDownloadInfo, new Achilles.AchilesRockDownloadListener(null));
  }
  
  private static void b(boolean paramBoolean, String paramString1, int paramInt, String paramString2)
  {
    Object localObject = (Long)jdField_a_of_type_JavaUtilMap.get(paramString1);
    long l2 = System.currentTimeMillis();
    long l1;
    if (localObject == null)
    {
      l1 = 0L;
      localObject = ozs.a();
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_FailCode", String.valueOf(paramInt));
      localHashMap.put("param_FailMsg", paramString2);
      localHashMap.put("uin", localObject);
      bdmc.a(ozs.a().getApplication()).a((String)localObject, "actAchilles", paramBoolean, l2 - l1, 0L, localHashMap, null, false);
      if (!paramBoolean) {
        break label130;
      }
    }
    label130:
    for (paramString2 = "1";; paramString2 = "0")
    {
      AchillesFragmentUtils.a("downloadresult", paramString2, paramString1, null);
      return;
      l1 = ((Long)localObject).longValue();
      break;
    }
  }
  
  private static boolean b()
  {
    return NetworkState.isWifiConn();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.Achilles
 * JD-Core Version:    0.7.0.1
 */