package com.tencent.mobileqq.Doraemon.monitor;

import android.content.Intent;
import android.util.LruCache;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;

public class DoraemonFrequenceController
  implements DoraemonAPIReporter.OnFrequenceDataUpdateListener
{
  private static DoraemonFrequenceController jdField_a_of_type_ComTencentMobileqqDoraemonMonitorDoraemonFrequenceController;
  LruCache<String, Map<String, APIQuotaItem>> jdField_a_of_type_AndroidUtilLruCache = new LruCache(5);
  DoraemonAPIReporter jdField_a_of_type_ComTencentMobileqqDoraemonMonitorDoraemonAPIReporter;
  Map<String, Boolean> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  
  private DoraemonFrequenceController()
  {
    if (MobileQQ.sProcessId == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DoraemonOpenAPI.freqCtrl", 2, "create reporter");
      }
      this.jdField_a_of_type_ComTencentMobileqqDoraemonMonitorDoraemonAPIReporter = new DoraemonAPIReporterMain();
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("DoraemonOpenAPI.freqCtrl", 2, "create reporter proxy");
      }
      this.jdField_a_of_type_ComTencentMobileqqDoraemonMonitorDoraemonAPIReporter = new DoraemonAPIReporterProxy();
    }
    this.jdField_a_of_type_ComTencentMobileqqDoraemonMonitorDoraemonAPIReporter.a(this);
  }
  
  public static DoraemonFrequenceController a()
  {
    if (jdField_a_of_type_ComTencentMobileqqDoraemonMonitorDoraemonFrequenceController == null) {
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqDoraemonMonitorDoraemonFrequenceController == null) {
          jdField_a_of_type_ComTencentMobileqqDoraemonMonitorDoraemonFrequenceController = new DoraemonFrequenceController();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentMobileqqDoraemonMonitorDoraemonFrequenceController;
  }
  
  private Map<String, APIQuotaItem> a(String paramString1, int paramInt, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("init key=");
      ((StringBuilder)localObject).append(paramString1);
      QLog.d("DoraemonOpenAPI.freqCtrl", 2, ((StringBuilder)localObject).toString());
    }
    int i = 0;
    int j = 0;
    Map localMap = (Map)this.jdField_a_of_type_AndroidUtilLruCache.get(paramString1);
    Object localObject = localMap;
    if (localMap == null) {
      try
      {
        localMap = (Map)this.jdField_a_of_type_AndroidUtilLruCache.get(paramString1);
        i = j;
        localObject = localMap;
        if (localMap == null)
        {
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("init create cache map, key=");
            ((StringBuilder)localObject).append(paramString1);
            QLog.d("DoraemonOpenAPI.freqCtrl", 2, ((StringBuilder)localObject).toString());
          }
          localObject = new ConcurrentHashMap();
          this.jdField_a_of_type_AndroidUtilLruCache.put(paramString1, localObject);
          i = 1;
        }
      }
      finally {}
    }
    if (i != 0) {
      this.jdField_a_of_type_ComTencentMobileqqDoraemonMonitorDoraemonAPIReporter.a(paramString1, paramInt, paramString2);
    }
    return localObject;
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    a(paramString1, paramInt, paramString2);
  }
  
  public void a(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("report key=");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(", api=");
      localStringBuilder.append(paramString3);
      QLog.d("DoraemonOpenAPI.freqCtrl", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqDoraemonMonitorDoraemonAPIReporter.a(paramString1, paramInt, paramString2, paramString3);
  }
  
  public void a(String paramString1, int paramInt, String paramString2, String paramString3, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("update key=");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(", api=");
      ((StringBuilder)localObject).append(paramString3);
      ((StringBuilder)localObject).append(", remain=");
      ((StringBuilder)localObject).append(paramLong1);
      QLog.d("DoraemonOpenAPI.freqCtrl", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = (Map)this.jdField_a_of_type_AndroidUtilLruCache.get(paramString1);
    if (localObject != null)
    {
      APIQuotaItem localAPIQuotaItem = (APIQuotaItem)((Map)localObject).get(paramString3);
      if (localAPIQuotaItem == null)
      {
        localAPIQuotaItem = new APIQuotaItem();
        localAPIQuotaItem.remainTimes = paramLong1;
        localAPIQuotaItem.expireTimeMillis = paramLong2;
        ((Map)localObject).put(paramString3, localAPIQuotaItem);
      }
      else
      {
        localAPIQuotaItem.remainTimes = paramLong1;
        localAPIQuotaItem.expireTimeMillis = paramLong2;
      }
    }
    if ((MobileQQ.sProcessId == 1) && (this.jdField_a_of_type_JavaUtilMap.containsKey(paramString1)))
    {
      localObject = new Intent("com.tencent.mobileqq.Doraemon.monitor.update");
      ((Intent)localObject).putExtra("key", paramString1);
      ((Intent)localObject).putExtra("type", paramInt);
      ((Intent)localObject).putExtra("appid", paramString2);
      ((Intent)localObject).putExtra("api", paramString3);
      ((Intent)localObject).putExtra("remain", paramLong1);
      ((Intent)localObject).putExtra("time", paramLong2);
      BaseApplication.getContext().sendBroadcast((Intent)localObject, "com.tencent.msg.permission.pushnotify");
    }
  }
  
  public void a(String paramString, HashMap<String, APIQuotaItem> paramHashMap)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("update all key=");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("DoraemonOpenAPI.freqCtrl", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = (Map)this.jdField_a_of_type_AndroidUtilLruCache.get(paramString);
    if (localObject != null) {
      ((Map)localObject).putAll(paramHashMap);
    }
    if ((MobileQQ.sProcessId == 1) && (this.jdField_a_of_type_JavaUtilMap.containsKey(paramString)))
    {
      localObject = new Intent("com.tencent.mobileqq.Doraemon.monitor.update_batch");
      ((Intent)localObject).putExtra("key", paramString);
      ((Intent)localObject).putExtra("map", paramHashMap);
      BaseApplication.getContext().sendBroadcast((Intent)localObject, "com.tencent.msg.permission.pushnotify");
    }
  }
  
  public boolean a(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    Map localMap = (Map)this.jdField_a_of_type_AndroidUtilLruCache.get(paramString1);
    Object localObject = localMap;
    if (localMap == null) {
      localObject = a(paramString1, paramInt, paramString2);
    }
    paramString2 = (APIQuotaItem)((Map)localObject).get(paramString3);
    long l = NetConnInfoCenter.getServerTimeMillis();
    if (paramString2 == null)
    {
      if (QLog.isColorLevel())
      {
        paramString2 = new StringBuilder();
        paramString2.append("no record use default key=");
        paramString2.append(paramString1);
        paramString2.append(", api=");
        paramString2.append(paramString3);
        QLog.d("DoraemonOpenAPI.freqCtrl", 2, paramString2.toString());
      }
      paramString1 = new APIQuotaItem();
      paramString1.remainTimes = 10L;
      paramString1.expireTimeMillis = (l + 60000L);
      ((Map)localObject).put(paramString3, paramString1);
      return true;
    }
    if (paramString2.remainTimes > 0L)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("has quota key=");
        ((StringBuilder)localObject).append(paramString1);
        ((StringBuilder)localObject).append(", api=");
        ((StringBuilder)localObject).append(paramString3);
        ((StringBuilder)localObject).append(", remain=");
        ((StringBuilder)localObject).append(paramString2.remainTimes);
        QLog.d("DoraemonOpenAPI.freqCtrl", 2, ((StringBuilder)localObject).toString());
      }
      return true;
    }
    if (paramString2.expireTimeMillis < l)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("expired use default key=");
        ((StringBuilder)localObject).append(paramString1);
        ((StringBuilder)localObject).append(", api=");
        ((StringBuilder)localObject).append(paramString3);
        QLog.d("DoraemonOpenAPI.freqCtrl", 2, ((StringBuilder)localObject).toString());
      }
      paramString2.remainTimes = 10L;
      paramString2.expireTimeMillis = (l + 60000L);
      return true;
    }
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append("no quota key=");
      paramString2.append(paramString1);
      paramString2.append(", api=");
      paramString2.append(paramString3);
      QLog.d("DoraemonOpenAPI.freqCtrl", 2, paramString2.toString());
    }
    return false;
  }
  
  public void b(String paramString1, int paramInt, String paramString2)
  {
    if (MobileQQ.sProcessId != 1) {
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("load from proxy key=");
      localStringBuilder.append(paramString1);
      QLog.d("DoraemonOpenAPI.freqCtrl", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_JavaUtilMap.put(paramString1, Boolean.TRUE);
    this.jdField_a_of_type_ComTencentMobileqqDoraemonMonitorDoraemonAPIReporter.a(paramString1, paramInt, paramString2);
  }
  
  public void b(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    if (MobileQQ.sProcessId != 1) {
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("report from proxy key=");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(", api=");
      localStringBuilder.append(paramString3);
      QLog.d("DoraemonOpenAPI.freqCtrl", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_JavaUtilMap.put(paramString1, Boolean.TRUE);
    this.jdField_a_of_type_ComTencentMobileqqDoraemonMonitorDoraemonAPIReporter.a(paramString1, paramInt, paramString2, paramString3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.monitor.DoraemonFrequenceController
 * JD-Core Version:    0.7.0.1
 */