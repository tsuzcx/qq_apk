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
  private static volatile ToggleImpl b;
  private static volatile boolean c = false;
  public Set<OnObtainToggleListener> a = new CopyOnWriteArraySet();
  
  public static ToggleImpl a()
  {
    if (b == null) {
      try
      {
        if (b == null) {
          b = new ToggleImpl();
        }
      }
      finally {}
    }
    return b;
  }
  
  private void a(long paramLong)
  {
    if (!ToggleSetting.p()) {
      return;
    }
    LogUtils.b("[SDKInit] 'isDebug' is true , so running in debug model , close it when you release!", new Object[0]);
    LogUtils.b("[SDKInit] toggle in debug mode, will print log.", new Object[0]);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[SDKInit] Toggle init finished.");
    localStringBuilder.append("\n\t");
    localStringBuilder.append("SDK_Version is:");
    localStringBuilder.append(ToggleSetting.r());
    localStringBuilder.append("\n\t");
    localStringBuilder.append("Product_ID is:");
    localStringBuilder.append(ToggleSetting.k());
    localStringBuilder.append("\n\t");
    localStringBuilder.append("ProductNameEn is:");
    localStringBuilder.append(ToggleSetting.l());
    localStringBuilder.append("\n\t");
    localStringBuilder.append("MODULE_ID is:");
    localStringBuilder.append(ToggleSetting.m());
    localStringBuilder.append("\n\t");
    localStringBuilder.append("APP_Channel is:");
    localStringBuilder.append(ToggleSetting.n());
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
      if (!RepeatEventUtil.a(paramFeatureTriggered.b())) {
        return;
      }
      ThreadUtil.a(new ToggleImpl.2(paramFeatureTriggered, paramDatasetEntity));
      long l = ToggleSetting.i();
      ToggleSetting.c(1L + l);
      if ((l >= 2000L) && (ToggleSetting.A() == 0))
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
    return (paramAbTestInfo != null) && (paramAbTestInfo.b() != null) && (paramAbTestInfo.b().containsKey(paramString));
  }
  
  private void e()
  {
    try
    {
      if (ToggleSetting.f())
      {
        ToggleSetting.c(SpManager.a().c());
        b(ToggleSetting.o());
        c(ToggleSetting.t());
        ReportController.a().a(2001);
        LogUtils.e("Send init event ", new Object[0]);
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
    if (ToggleSetting.j() == null)
    {
      LogUtils.d("SDK not init ,return defaultValue", new Object[0]);
      return null;
    }
    for (;;)
    {
      try
      {
        if (Utils.a(paramString)) {
          return null;
        }
        localObject1 = CacheManager.a().c();
        if ((localObject1 != null) && (((LruCache)localObject1).size() > 0))
        {
          Object localObject2 = (FeatureResult)((LruCache)localObject1).get(paramString);
          localObject1 = localObject2;
          if (localObject2 != null)
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("ToggleIImpl get toggle from Memory, toggleName=");
            ((StringBuilder)localObject1).append(paramString);
            LogUtils.e(((StringBuilder)localObject1).toString(), new Object[0]);
            localObject1 = localObject2;
          }
          localObject2 = localObject1;
          if (localObject1 == null)
          {
            localObject2 = localObject1;
            if (SpManager.a().f(paramString))
            {
              localObject2 = CacheManager.a().a(paramString);
              if (localObject2 != null) {
                CacheManager.a().c().put(paramString, localObject2);
              }
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("ToggleImpl get toggle from Sp, toggleName=");
              ((StringBuilder)localObject1).append(paramString);
              LogUtils.e(((StringBuilder)localObject1).toString(), new Object[0]);
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
    return b(paramString1, paramAbTestInfo, paramString2);
  }
  
  public void a(Context paramContext, ToggleConfig paramToggleConfig)
  {
    try
    {
      if (ToggleSetting.j() != null)
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
          c = true;
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
      Set localSet = this.a;
      if (localSet != null)
      {
        localSet.add(paramOnObtainToggleListener);
        LogUtils.e("Add OnObtainToggleListener success", new Object[0]);
        return;
      }
    }
    LogUtils.e("Add OnObtainToggleListener fail", new Object[0]);
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
      long l = SpManager.a().g();
      Object localObject = paramFeatureResult.timeLimits.iterator();
      while (((Iterator)localObject).hasNext())
      {
        TimeLimit localTimeLimit = (TimeLimit)((Iterator)localObject).next();
        if ((a(paramFeatureResult.timeLimitType, localTimeLimit.getStartTime(), "startTime", l)) && (a(paramFeatureResult.timeLimitType, localTimeLimit.getEndTime(), "endTime", l)))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("timeLimits hit toggleResult");
          ((StringBuilder)localObject).append(paramFeatureResult.name);
          LogUtils.e(((StringBuilder)localObject).toString(), new Object[0]);
          return true;
        }
      }
    }
    return false;
  }
  
  boolean a(String paramString, boolean paramBoolean)
  {
    return Boolean.parseBoolean(b(paramString, null, String.valueOf(paramBoolean)).c());
  }
  
  FeatureTriggered b(String paramString1, AbTestInfo paramAbTestInfo, String paramString2)
  {
    Object localObject = a(paramString1);
    if (localObject == null)
    {
      paramString2 = new FeatureResult(-1, paramString1, paramString2);
      localObject = paramString2;
      if (a(paramString1, paramAbTestInfo))
      {
        paramString2.result = ((String)paramAbTestInfo.b().get(paramString1));
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
        ((FeatureResult)localObject).result = ((String)paramAbTestInfo.b().get(paramString1));
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
    DatasetEntity localDatasetEntity = ((FeatureResult)localObject).getDataset();
    int j = ((FeatureResult)localObject).id;
    String str1 = ((FeatureResult)localObject).name;
    String str2 = ((FeatureResult)localObject).result;
    localObject = null;
    if (localDatasetEntity != null) {
      paramAbTestInfo = localDatasetEntity.getData();
    } else {
      paramAbTestInfo = null;
    }
    if (localDatasetEntity != null) {
      paramString2 = localDatasetEntity.getType();
    } else {
      paramString2 = null;
    }
    if (localDatasetEntity != null) {
      localObject = localDatasetEntity.getValue();
    }
    paramString1 = new FeatureTriggered(j, str1, str2, i, paramString1, paramAbTestInfo, paramString2, (String)localObject);
    a(paramString1, localDatasetEntity);
    return paramString1;
  }
  
  public void b(String paramString)
  {
    if (Utils.a(paramString)) {
      return;
    }
    if (!SpManager.a().e().equals(paramString))
    {
      SpManager.a().a(0L);
      SpManager.a().d(paramString);
    }
  }
  
  void b(String paramString, boolean paramBoolean)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    ToggleSetting.b(str);
    LogUtils.b("Set userId=%s", new Object[] { str });
    if ((b()) && (paramBoolean) && (c(str))) {
      c();
    }
  }
  
  public boolean b()
  {
    return (c) && (ToggleSetting.j() != null);
  }
  
  void c()
  {
    if (!b())
    {
      LogUtils.d("SDK not init ,updateToggle fail!!!", new Object[0]);
      return;
    }
    ToggleSetting.c(SpManager.a().c());
    ReportController.a().a(2008);
  }
  
  public boolean c(String paramString)
  {
    String str = SpManager.a().d();
    if ((paramString != null) && (!paramString.equals(str)))
    {
      SpManager.a().a(0L);
      SpManager.a().c(paramString);
      return true;
    }
    return false;
  }
  
  Map<String, String> d()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.clear();
    String[] arrayOfString = SpManager.a().i();
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
        LogUtils.d(((StringBuilder)localObject).toString(), new Object[0]);
      }
      i += 1;
    }
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.featuretoggle.ToggleImpl
 * JD-Core Version:    0.7.0.1
 */