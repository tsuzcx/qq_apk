package com.tencent.featuretoggle;

import android.content.Context;
import android.text.TextUtils;
import android.util.LruCache;
import com.tencent.featuretoggle.models.AbTestInfo;
import com.tencent.featuretoggle.models.DatasetEntity;
import com.tencent.featuretoggle.models.FeatureResult;
import com.tencent.featuretoggle.models.FeatureTriggered;
import com.tencent.featuretoggle.models.TimeLimit;
import com.tencent.featuretoggle.net.CacheManager;
import com.tencent.featuretoggle.strategy.ActivityLifeCycleListener;
import com.tencent.featuretoggle.strategy.NetworkChangeReceiver;
import com.tencent.featuretoggle.strategy.ReportController;
import com.tencent.featuretoggle.strategy.TimeChangeReceiver;
import com.tencent.featuretoggle.utils.AppUtils;
import com.tencent.featuretoggle.utils.LogUtils;
import com.tencent.featuretoggle.utils.RepeatEventUtil;
import com.tencent.featuretoggle.utils.ThreadUtil;
import com.tencent.featuretoggle.utils.TimeUtil;
import com.tencent.featuretoggle.utils.Utils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class ToggleImpl
{
  private static volatile ToggleImpl jdField_a_of_type_ComTencentFeaturetoggleToggleImpl;
  private static volatile boolean jdField_a_of_type_Boolean = false;
  public Set<OnObtainToggleListener> a;
  
  private ToggleImpl()
  {
    this.jdField_a_of_type_JavaUtilSet = new CopyOnWriteArraySet();
  }
  
  public static ToggleImpl a()
  {
    if (jdField_a_of_type_ComTencentFeaturetoggleToggleImpl == null) {
      try
      {
        if (jdField_a_of_type_ComTencentFeaturetoggleToggleImpl == null) {
          jdField_a_of_type_ComTencentFeaturetoggleToggleImpl = new ToggleImpl();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentFeaturetoggleToggleImpl;
  }
  
  private void a(long paramLong)
  {
    if (!ToggleSetting.c()) {
      return;
    }
    LogUtils.b("[SDKInit] 'isDebug' is true , so running in debug model , close it when you release!", new Object[0]);
    LogUtils.b("[SDKInit] toggle in debug mode, will print log.", new Object[0]);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[SDKInit] Toggle init finished.");
    localStringBuilder.append("\n\t");
    localStringBuilder.append("SDK_Version is:");
    localStringBuilder.append(ToggleSetting.g());
    localStringBuilder.append("\n\t");
    localStringBuilder.append("Product_ID is:");
    localStringBuilder.append(ToggleSetting.b());
    localStringBuilder.append("\n\t");
    localStringBuilder.append("ProductNameEn is:");
    localStringBuilder.append(ToggleSetting.c());
    localStringBuilder.append("\n\t");
    localStringBuilder.append("MODULE_ID is:");
    localStringBuilder.append(ToggleSetting.d());
    localStringBuilder.append("\n\t");
    localStringBuilder.append("APP_Channel is:");
    localStringBuilder.append(ToggleSetting.e());
    localStringBuilder.append("\n\t");
    localStringBuilder.append("Init duration:");
    localStringBuilder.append(System.currentTimeMillis() - paramLong);
    localStringBuilder.append("\n\t");
    LogUtils.b(localStringBuilder.toString(), new Object[0]);
  }
  
  public static void a(FeatureTriggered paramFeatureTriggered, DatasetEntity paramDatasetEntity)
  {
    try
    {
      if (!RepeatEventUtil.a(paramFeatureTriggered.a())) {
        return;
      }
      ThreadUtil.a(new ToggleImpl.2(paramFeatureTriggered, paramDatasetEntity));
      long l = ToggleSetting.c();
      ToggleSetting.c(1L + l);
      if ((l >= 2000L) && (ToggleSetting.b() == 0))
      {
        ReportController.a().a(2006);
        return;
      }
    }
    catch (Throwable paramFeatureTriggered)
    {
      if (!LogUtils.a(paramFeatureTriggered)) {
        paramFeatureTriggered.printStackTrace();
      }
    }
  }
  
  private static boolean a(int paramInt, String paramString1, String paramString2, long paramLong)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return true;
    }
    boolean bool2 = false;
    boolean bool1 = false;
    try
    {
      paramLong = System.currentTimeMillis() - paramLong;
      String str = paramString1;
      if (paramInt == 2) {
        str = String.format("%s %s", new Object[] { TimeUtil.a("yyyy-MM-dd", paramLong), paramString1 });
      }
      long l = TimeUtil.a(str);
      boolean bool3 = "startTime".equals(paramString2);
      if (bool3)
      {
        if (paramLong >= l) {
          bool1 = true;
        }
        return bool1;
      }
      bool1 = bool2;
      if (paramLong <= l) {
        bool1 = true;
      }
      return bool1;
    }
    catch (Throwable paramString1)
    {
      if (!LogUtils.a(paramString1)) {
        paramString1.printStackTrace();
      }
    }
    return false;
  }
  
  private boolean a(String paramString, AbTestInfo paramAbTestInfo)
  {
    return (paramAbTestInfo != null) && (paramAbTestInfo.a() != null) && (paramAbTestInfo.a().containsKey(paramString));
  }
  
  private void b()
  {
    try
    {
      if (ToggleSetting.a())
      {
        ToggleSetting.c(SpManager.a().c());
        a(ToggleSetting.f());
        a(ToggleSetting.i());
        ReportController.a().a(2001);
        LogUtils.c("Send init event ", new Object[0]);
        return;
      }
      ReportController.a().a(2009);
      return;
    }
    catch (Throwable localThrowable)
    {
      if (!LogUtils.a(localThrowable)) {
        localThrowable.printStackTrace();
      }
    }
  }
  
  public FeatureResult a(String paramString)
  {
    if (ToggleSetting.a() == null)
    {
      LogUtils.b("SDK not init ,return defaultValue", new Object[0]);
      return null;
    }
    for (;;)
    {
      try
      {
        if (Utils.a(paramString)) {
          return null;
        }
        localObject1 = CacheManager.a().a();
        if ((localObject1 != null) && (((LruCache)localObject1).size() > 0))
        {
          Object localObject2 = (FeatureResult)((LruCache)localObject1).get(paramString);
          localObject1 = localObject2;
          if (localObject2 != null)
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("ToggleIImpl get toggle from Memory, toggleName=");
            ((StringBuilder)localObject1).append(paramString);
            LogUtils.c(((StringBuilder)localObject1).toString(), new Object[0]);
            localObject1 = localObject2;
          }
          localObject2 = localObject1;
          if (localObject1 == null)
          {
            localObject2 = localObject1;
            if (SpManager.a().a(paramString))
            {
              localObject2 = CacheManager.a().a(paramString);
              if (localObject2 != null) {
                CacheManager.a().a().put(paramString, localObject2);
              }
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("ToggleImpl get toggle from Sp, toggleName=");
              ((StringBuilder)localObject1).append(paramString);
              LogUtils.c(((StringBuilder)localObject1).toString(), new Object[0]);
            }
          }
          return localObject2;
        }
      }
      catch (Throwable paramString)
      {
        if (!LogUtils.a(paramString)) {
          paramString.printStackTrace();
        }
        return null;
      }
      Object localObject1 = null;
    }
  }
  
  FeatureTriggered a(String paramString1, AbTestInfo paramAbTestInfo, String paramString2)
  {
    Object localObject = a(paramString1);
    if (localObject == null)
    {
      paramString2 = new FeatureResult(-1, paramString1, paramString2);
      localObject = paramString2;
      if (a(paramString1, paramAbTestInfo))
      {
        paramString2.result = ((String)paramAbTestInfo.a().get(paramString1));
        paramString1 = paramAbTestInfo.a();
        localObject = paramString2;
        i = 2;
        break label144;
      }
    }
    for (;;)
    {
      paramString1 = "-1";
      i = 3;
      break label144;
      if ((((FeatureResult)localObject).getIsAbtFirst()) && (a(paramString1, paramAbTestInfo)))
      {
        ((FeatureResult)localObject).result = ((String)paramAbTestInfo.a().get(paramString1));
        paramString1 = paramAbTestInfo.a();
        break;
      }
      if (a((FeatureResult)localObject)) {
        break label137;
      }
      ((FeatureResult)localObject).result = paramString2;
    }
    label137:
    paramString1 = "-1";
    int i = 1;
    label144:
    paramString2 = ((FeatureResult)localObject).getDataset();
    int j = ((FeatureResult)localObject).id;
    String str = ((FeatureResult)localObject).name;
    localObject = ((FeatureResult)localObject).result;
    if (paramString2 != null) {
      paramAbTestInfo = paramString2.getData();
    } else {
      paramAbTestInfo = null;
    }
    paramString1 = new FeatureTriggered(j, str, (String)localObject, i, paramString1, paramAbTestInfo);
    a(paramString1, paramString2);
    return paramString1;
  }
  
  Map<String, String> a()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.clear();
    String[] arrayOfString = SpManager.a().a();
    if (arrayOfString == null) {
      return localHashMap;
    }
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfString[i];
      Object localObject = CacheManager.a().a(str);
      if (localObject != null)
      {
        localHashMap.put(str, ((FeatureResult)localObject).result);
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("ToggleImpl 读取开关值失败 ：toggleName=");
        ((StringBuilder)localObject).append(str);
        LogUtils.b(((StringBuilder)localObject).toString(), new Object[0]);
      }
      i += 1;
    }
    return localHashMap;
  }
  
  void a()
  {
    if (!a())
    {
      LogUtils.b("SDK not init ,updateToggle fail!!!", new Object[0]);
      return;
    }
    ToggleSetting.c(SpManager.a().c());
    ReportController.a().a(2008);
  }
  
  public void a(Context paramContext, ToggleConfig paramToggleConfig)
  {
    try
    {
      if (ToggleSetting.a() != null)
      {
        LogUtils.b("[SDKInit] toggle sdk already inited ! nothing to do !", new Object[0]);
        return;
      }
      long l = System.currentTimeMillis();
      Context localContext = AppUtils.a(paramContext);
      if (localContext != null)
      {
        paramContext = paramToggleConfig;
        if (paramToggleConfig == null) {
          paramContext = new ToggleConfig();
        }
        if ((Utils.a(paramContext.a())) || (Utils.a(paramContext.c())) || (Utils.a(paramContext.b())))
        {
          paramContext.e(AppUtils.a(localContext, "TOGGLE_PRODUCT_ID"));
          paramContext.g(AppUtils.a(localContext, "TOGGLE_MODULE_ID"));
          paramContext.f(AppUtils.a(localContext, "TOGGLE_PRODUCT_NAME_EN"));
        }
        ToggleSetting.a(localContext, paramContext);
        if ((!Utils.a(paramContext.a())) && (!Utils.a(paramContext.c())) && (!Utils.a(paramContext.b())))
        {
          ToggleSetting.a(paramContext.b().trim());
          ActivityLifeCycleListener.a().a(localContext);
          NetworkChangeReceiver.a().a(localContext);
          TimeChangeReceiver.a().a(localContext);
          ThreadUtil.a(new ToggleImpl.1(this));
          a(l);
          jdField_a_of_type_Boolean = true;
          return;
        }
        throw new RuntimeException("[SDKInit] 'productId' , 'moduleId' , 'productNameEn' must be config");
      }
      throw new RuntimeException("[SDKInit] arg 'appContext' should not be null!");
    }
    catch (Throwable paramContext)
    {
      LogUtils.a("[SDKInit] Failed to initialize! please running in debug model", new Object[0]);
      if (!LogUtils.a(paramContext)) {
        paramContext.printStackTrace();
      }
    }
  }
  
  void a(OnObtainToggleListener paramOnObtainToggleListener)
  {
    if (paramOnObtainToggleListener != null)
    {
      Set localSet = this.jdField_a_of_type_JavaUtilSet;
      if (localSet != null)
      {
        localSet.add(paramOnObtainToggleListener);
        LogUtils.c("Add OnObtainToggleListener success", new Object[0]);
        return;
      }
    }
    LogUtils.c("Add OnObtainToggleListener fail", new Object[0]);
  }
  
  public void a(String paramString)
  {
    if (Utils.a(paramString)) {
      return;
    }
    if (!SpManager.a().e().equals(paramString))
    {
      SpManager.a().a(0L);
      SpManager.a().e(paramString);
    }
  }
  
  void a(String paramString, boolean paramBoolean)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    ToggleSetting.b(str);
    LogUtils.b("Set userId=%s", new Object[] { str });
    if ((a()) && (paramBoolean) && (a(str))) {
      a();
    }
  }
  
  public boolean a()
  {
    return (jdField_a_of_type_Boolean) && (ToggleSetting.a() != null);
  }
  
  public boolean a(FeatureResult paramFeatureResult)
  {
    if ((paramFeatureResult.timeLimitType != 2) && (paramFeatureResult.timeLimitType != 3)) {
      return true;
    }
    if (paramFeatureResult.getTimeLimits() != null)
    {
      if (paramFeatureResult.getTimeLimits().isEmpty()) {
        return false;
      }
      long l = SpManager.a().b();
      Object localObject = paramFeatureResult.timeLimits.iterator();
      while (((Iterator)localObject).hasNext())
      {
        TimeLimit localTimeLimit = (TimeLimit)((Iterator)localObject).next();
        if ((a(paramFeatureResult.timeLimitType, localTimeLimit.getStartTime(), "startTime", l)) && (a(paramFeatureResult.timeLimitType, localTimeLimit.getEndTime(), "endTime", l)))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("timeLimits hit toggleResult");
          ((StringBuilder)localObject).append(paramFeatureResult.name);
          LogUtils.c(((StringBuilder)localObject).toString(), new Object[0]);
          return true;
        }
      }
    }
    return false;
  }
  
  public boolean a(String paramString)
  {
    String str = SpManager.a().d();
    if ((paramString != null) && (!paramString.equals(str)))
    {
      SpManager.a().a(0L);
      SpManager.a().d(paramString);
      return true;
    }
    return false;
  }
  
  boolean a(String paramString, boolean paramBoolean)
  {
    return Boolean.parseBoolean(a(paramString, null, String.valueOf(paramBoolean)).b());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.featuretoggle.ToggleImpl
 * JD-Core Version:    0.7.0.1
 */