package com.tencent.mobileqq.ark.module;

import android.text.TextUtils;
import com.tencent.ark.ark.Application;
import com.tencent.ark.ark.ModuleRegister;
import com.tencent.mobileqq.ark.api.IArkConfig;
import com.tencent.mobileqq.ark.api.module.ArkAppDownloadModule;
import com.tencent.mobileqq.ark.api.module.ArkAppMusicModule;
import com.tencent.mobileqq.ark.api.module.ArkAppQQModule;
import com.tencent.mobileqq.ark.api.module.ArkAppYYBDownloadModule;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.MobileQQ;

public class ArkAppModuleReg
{
  @ConfigInject(configPath="Business/qqark-impl/src/main/resources/Inject_Modules.yml", version=1)
  private static final ArrayList<Class<? extends ArkAppModuleBase>> a = new ArrayList();
  
  static
  {
    a.add(ArkAppQQModule.class);
    a.add(ArkAppDeviceModule.class);
    a.add(ArkAppDownloadModule.class);
    a.add(ArkAppYYBDownloadModule.class);
    a.add(ArkAppMusicModule.class);
  }
  
  static int a(ark.Application paramApplication)
  {
    return a(paramApplication.GetSpecific("appName"));
  }
  
  static int a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return 1;
    }
    if (paramString.indexOf("com.tencent.", 0) != -1) {
      return 0;
    }
    return 1;
  }
  
  public static void a(ark.ModuleRegister paramModuleRegister, ark.Application paramApplication)
  {
    int i = a(paramApplication);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = a.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Class)localIterator.next();
      try
      {
        localObject = (ArkAppModuleBase)((Class)localObject).getConstructor(new Class[] { ark.Application.class, Integer.TYPE }).newInstance(new Object[] { paramApplication, Integer.valueOf(i) });
        if (((((ArkAppModuleBase)localObject).a()) || (i == 0)) && ((((ArkAppModuleBase)localObject).b()) || (MobileQQ.sProcessId == 1))) {
          localArrayList.add(localObject);
        }
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("register module fail, ");
        localStringBuilder.append(localException.toString());
        QLog.i("ArkApp.ArkAppModuleReg", 1, localStringBuilder.toString());
      }
    }
    a(paramModuleRegister, localArrayList);
  }
  
  private static void a(ark.ModuleRegister paramModuleRegister, List<ArkAppModuleBase> paramList)
  {
    IArkConfig localIArkConfig = (IArkConfig)QRoute.api(IArkConfig.class);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ArkAppModuleBase localArkAppModuleBase = (ArkAppModuleBase)paramList.next();
      if (localIArkConfig != null) {
        localArkAppModuleBase.a((List)localIArkConfig.getAPIFrequencyConfig().get(localArkAppModuleBase.GetTypeName()));
      }
      paramModuleRegister.RegCallbackWrapper(localArkAppModuleBase);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.module.ArkAppModuleReg
 * JD-Core Version:    0.7.0.1
 */