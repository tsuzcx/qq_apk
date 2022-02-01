import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.ToolAppRuntime;
import com.tencent.mobileqq.WebSsoBody.WebSsoResponseBody;
import com.tencent.mobileqq.apollo.ApolloStoreStabilityReportManager.1;
import com.tencent.mobileqq.apollo.ApolloStoreStabilityReportManager.2;
import com.tencent.mobileqq.apollo.ApolloStoreStabilityReportManager.3;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import mqq.app.AppRuntime;
import mqq.observer.BusinessObserver;

public class amur
  implements BusinessObserver
{
  private static amur jdField_a_of_type_Amur;
  private long jdField_a_of_type_Long;
  private Runnable jdField_a_of_type_JavaLangRunnable = new ApolloStoreStabilityReportManager.3(this);
  private ArrayList<HashMap> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  
  public static amur a()
  {
    try
    {
      if (jdField_a_of_type_Amur == null) {
        jdField_a_of_type_Amur = new amur();
      }
      amur localamur = jdField_a_of_type_Amur;
      return localamur;
    }
    finally {}
  }
  
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
    if (paramInt == 1000) {}
    for (int i = 1;; i = 0)
    {
      int j;
      if (paramInt == -1001)
      {
        j = 3001;
        i = 1;
      }
      for (;;)
      {
        if (paramInt == -1002)
        {
          j = 3000;
          i = 1;
        }
        if (i != 0)
        {
          anmq.a(40);
          anmq.a(40, 1, j, new Object[] { paramString });
          anmq.b(40);
        }
        return;
        j = 0;
      }
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
    if (QLog.isColorLevel()) {
      QLog.d("ApolloStoreStabilityReportManager_apollo_store_stability_", 2, "addTaskToApolloStoreStabilityQueue. add one task. count:" + this.jdField_a_of_type_JavaUtilArrayList.size());
    }
    a(paramString1, paramInt1);
    if (!bhnv.g(null)) {
      QLog.e("ApolloStoreStabilityReportManager_apollo_store_stability_", 1, "reportApolloStoreStabilityData. network not available. cmd:" + paramString1);
    }
    while (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    ThreadManagerV2.getUIHandlerV2().postDelayed(new ApolloStoreStabilityReportManager.2(this), 10000L);
  }
  
  public boolean a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      HashSet localHashSet = annr.a();
      if (localHashSet != null)
      {
        if (localHashSet.contains(paramString)) {
          break label103;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ApolloStoreStabilityReportManager_apollo_store_stability_", 2, "addTaskToApolloStoreStabilityQueue. filter one cmd:" + paramString + " cmdSet:" + localHashSet.toString());
        }
      }
      do
      {
        return false;
        if (QLog.isColorLevel()) {
          QLog.d("ApolloStoreStabilityReportManager_apollo_store_stability_", 2, "addTaskToApolloStoreStabilityQueue.  cmdSet is null. filter all reporting cmd");
        }
      } while (System.currentTimeMillis() - this.jdField_a_of_type_Long <= 30000L);
      a();
      return false;
    }
    label103:
    return true;
  }
  
  public boolean b(String paramString)
  {
    HashSet localHashSet;
    if (!TextUtils.isEmpty(paramString))
    {
      localHashSet = annr.b();
      if (localHashSet != null)
      {
        Iterator localIterator = localHashSet.iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
        } while (!paramString.contains((String)localIterator.next()));
      }
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloStoreStabilityReportManager_apollo_store_stability_", 2, "addTaskToApolloStoreStabilityQueue. filter one url:" + paramString + " urlSet:" + localHashSet.toString());
        }
        return false;
        if (QLog.isColorLevel()) {
          QLog.d("ApolloStoreStabilityReportManager_apollo_store_stability_", 2, "addTaskToApolloStoreStabilityQueue.  urlSet is null. filter all reporting url");
        }
        if (System.currentTimeMillis() - this.jdField_a_of_type_Long > 30000L) {
          a();
        }
        return false;
      }
      return true;
    }
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
          QLog.d("ApolloStoreStabilityReportManager_apollo_store_stability_", 2, ((StringBuilder)localObject).toString());
          return;
        }
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.d("ApolloStoreStabilityReportManager_apollo_store_stability_", 2, "onReceive upload success. data is null");
        return;
      }
      catch (Exception paramBundle)
      {
        QLog.e("ApolloStoreStabilityReportManager_apollo_store_stability_", 1, "onReceive upload success. parse response failed.", paramBundle);
        return;
      }
    } else {
      QLog.e("ApolloStoreStabilityReportManager_apollo_store_stability_", 1, "onReceive upload failed.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amur
 * JD-Core Version:    0.7.0.1
 */