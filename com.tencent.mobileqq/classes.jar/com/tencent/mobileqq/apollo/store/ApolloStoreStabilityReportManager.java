package com.tencent.mobileqq.apollo.store;

import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.ToolAppRuntime;
import com.tencent.mobileqq.WebSsoBody.WebSsoResponseBody;
import com.tencent.mobileqq.apollo.statistics.product.ApolloConfigDataReport;
import com.tencent.mobileqq.apollo.statistics.trace.TraceReportUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import mqq.app.AppRuntime;
import mqq.observer.BusinessObserver;

public class ApolloStoreStabilityReportManager
  implements BusinessObserver
{
  private static ApolloStoreStabilityReportManager jdField_a_of_type_ComTencentMobileqqApolloStoreApolloStoreStabilityReportManager;
  private long jdField_a_of_type_Long = 0L;
  private Runnable jdField_a_of_type_JavaLangRunnable = new ApolloStoreStabilityReportManager.3(this);
  private ArrayList<HashMap> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  
  public static AppInterface a()
  {
    Object localObject = BaseApplicationImpl.getApplication();
    if (localObject != null)
    {
      localObject = ((BaseApplicationImpl)localObject).getRuntime();
      if ((localObject instanceof ToolAppRuntime))
      {
        localObject = ((AppRuntime)localObject).getAppRuntime("modular_web");
        if ((localObject instanceof AppInterface)) {
          return (AppInterface)localObject;
        }
      }
    }
    return null;
  }
  
  public static ApolloStoreStabilityReportManager a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqApolloStoreApolloStoreStabilityReportManager == null) {
        jdField_a_of_type_ComTencentMobileqqApolloStoreApolloStoreStabilityReportManager = new ApolloStoreStabilityReportManager();
      }
      ApolloStoreStabilityReportManager localApolloStoreStabilityReportManager = jdField_a_of_type_ComTencentMobileqqApolloStoreApolloStoreStabilityReportManager;
      return localApolloStoreStabilityReportManager;
    }
    finally {}
  }
  
  private void a()
  {
    ThreadManagerV2.excute(new ApolloStoreStabilityReportManager.1(this), 64, null, true);
  }
  
  private void a(HashMap paramHashMap)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramHashMap);
      return;
    }
    finally
    {
      paramHashMap = finally;
      throw paramHashMap;
    }
  }
  
  private void b()
  {
    try
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    int j;
    if (paramInt == 1000) {
      j = 1;
    } else {
      j = 0;
    }
    int i;
    if (paramInt == -1001)
    {
      j = 1;
      i = 3001;
    }
    else
    {
      i = 0;
    }
    if (paramInt == -1002)
    {
      i = 3000;
      j = 1;
    }
    if (j != 0)
    {
      TraceReportUtil.a(40);
      TraceReportUtil.a(40, 1, i, new Object[] { paramString });
      TraceReportUtil.b(40);
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("errcode", Integer.valueOf(paramInt1));
    if (!TextUtils.isEmpty(paramString1)) {
      localHashMap.put("cmd", paramString1);
    }
    if (!TextUtils.isEmpty(paramString2)) {
      localHashMap.put("url", paramString2);
    }
    localHashMap.put("cost", Integer.valueOf(paramInt2));
    a(localHashMap);
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append("addTaskToApolloStoreStabilityQueue. add one task. count:");
      paramString2.append(this.jdField_a_of_type_JavaUtilArrayList.size());
      QLog.d("[cmshow]ApolloStoreStabilityReportManager_apollo_store_stability_", 2, paramString2.toString());
    }
    a(paramString1, paramInt1);
    if (!NetworkUtil.isNetworkAvailable(null))
    {
      paramString2 = new StringBuilder();
      paramString2.append("reportApolloStoreStabilityData. network not available. cmd:");
      paramString2.append(paramString1);
      QLog.e("[cmshow]ApolloStoreStabilityReportManager_apollo_store_stability_", 1, paramString2.toString());
      return;
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      ThreadManagerV2.getUIHandlerV2().postDelayed(new ApolloStoreStabilityReportManager.2(this), 10000L);
    }
  }
  
  public boolean a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      HashSet localHashSet = ApolloConfigDataReport.a();
      if (localHashSet != null)
      {
        if (!localHashSet.contains(paramString))
        {
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("addTaskToApolloStoreStabilityQueue. filter one cmd:");
            localStringBuilder.append(paramString);
            localStringBuilder.append(" cmdSet:");
            localStringBuilder.append(localHashSet.toString());
            QLog.d("[cmshow]ApolloStoreStabilityReportManager_apollo_store_stability_", 2, localStringBuilder.toString());
          }
          return false;
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("[cmshow]ApolloStoreStabilityReportManager_apollo_store_stability_", 2, "addTaskToApolloStoreStabilityQueue.  cmdSet is null. filter all reporting cmd");
        }
        if (System.currentTimeMillis() - this.jdField_a_of_type_Long > 30000L) {
          a();
        }
        return false;
      }
    }
    return true;
  }
  
  public boolean b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      HashSet localHashSet = ApolloConfigDataReport.b();
      if (localHashSet != null)
      {
        Object localObject = localHashSet.iterator();
        while (((Iterator)localObject).hasNext()) {
          if (paramString.contains((String)((Iterator)localObject).next()))
          {
            i = 1;
            break label55;
          }
        }
        int i = 0;
        label55:
        if (i == 0)
        {
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("addTaskToApolloStoreStabilityQueue. filter one url:");
            ((StringBuilder)localObject).append(paramString);
            ((StringBuilder)localObject).append(" urlSet:");
            ((StringBuilder)localObject).append(localHashSet.toString());
            QLog.d("[cmshow]ApolloStoreStabilityReportManager_apollo_store_stability_", 2, ((StringBuilder)localObject).toString());
          }
          return false;
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("[cmshow]ApolloStoreStabilityReportManager_apollo_store_stability_", 2, "addTaskToApolloStoreStabilityQueue.  urlSet is null. filter all reporting url");
        }
        if (System.currentTimeMillis() - this.jdField_a_of_type_Long > 30000L) {
          a();
        }
        return false;
      }
    }
    return true;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBoolean) {
      try
      {
        paramBundle = paramBundle.getByteArray("data");
        if (paramBundle != null)
        {
          Object localObject = new WebSsoBody.WebSsoResponseBody();
          ((WebSsoBody.WebSsoResponseBody)localObject).mergeFrom(paramBundle);
          paramInt = ((WebSsoBody.WebSsoResponseBody)localObject).ret.get();
          paramBundle = ((WebSsoBody.WebSsoResponseBody)localObject).data.get();
          if (!QLog.isColorLevel()) {
            return;
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("onReceive upload success retcode:");
          ((StringBuilder)localObject).append(paramInt);
          ((StringBuilder)localObject).append(" retJson:");
          ((StringBuilder)localObject).append(paramBundle);
          QLog.d("[cmshow]ApolloStoreStabilityReportManager_apollo_store_stability_", 2, ((StringBuilder)localObject).toString());
          return;
        }
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.d("[cmshow]ApolloStoreStabilityReportManager_apollo_store_stability_", 2, "onReceive upload success. data is null");
        return;
      }
      catch (Exception paramBundle)
      {
        QLog.e("[cmshow]ApolloStoreStabilityReportManager_apollo_store_stability_", 1, "onReceive upload success. parse response failed.", paramBundle);
        return;
      }
    } else {
      QLog.e("[cmshow]ApolloStoreStabilityReportManager_apollo_store_stability_", 1, "onReceive upload failed.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.ApolloStoreStabilityReportManager
 * JD-Core Version:    0.7.0.1
 */