package com.tencent.mobileqq.ark.API;

import android.text.TextUtils;
import com.tencent.ark.ark.Application;
import com.tencent.ark.ark.ModuleCallbackWrapper;
import com.tencent.ark.ark.ModuleRegister;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.ark.ArkAiAppCenter;
import com.tencent.mobileqq.ark.ArkAppCenter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ArkAppModuleReg
{
  public static long a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (paramString.indexOf("com.tencent.", 0) == -1) {
      return 1L;
    }
    return 0L;
  }
  
  private static QQAppInterface a()
  {
    return ArkCommonUtil.a();
  }
  
  public static void a(ark.ModuleRegister paramModuleRegister, ark.Application paramApplication)
  {
    Object localObject1 = paramApplication.GetSpecific("appName");
    if ((localObject1 != null) && (((String)localObject1).indexOf("com.tencent.", 0) == -1)) {}
    for (long l = 1L;; l = 0L)
    {
      Object localObject2 = a();
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (localObject2 != null))
      {
        localObject1 = (ArkAppCenter)((QQAppInterface)localObject2).getManager(QQManagerFactory.ARK_APP_CENTER_MANAGER);
        if (localObject1 == null) {}
      }
      for (localObject1 = ((ArkAppCenter)localObject1).a();; localObject1 = null)
      {
        localObject2 = new ArrayList();
        ((List)localObject2).add(new ArkAppQQModule(paramApplication, l));
        ((List)localObject2).add(new ArkAppDeviceModule(paramApplication, l));
        ((List)localObject2).add(new ArkAppDownloadModule(paramApplication, l));
        if (1 == BaseApplicationImpl.sProcessId) {
          ((List)localObject2).add(new ArkAppYYBDownloadModule(paramApplication, l));
        }
        if (l == 0L) {
          ((List)localObject2).add(new ArkAppMusicModule(paramApplication, l));
        }
        paramApplication = ((List)localObject2).iterator();
        while (paramApplication.hasNext())
        {
          localObject2 = (ArkAppModuleBase)paramApplication.next();
          if (localObject1 != null) {
            ((ArkAppModuleBase)localObject2).a((List)ArkAiAppCenter.a.get(((ArkAppModuleBase)localObject2).GetTypeName()));
          }
          paramModuleRegister.RegCallbackWrapper((ark.ModuleCallbackWrapper)localObject2);
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppModuleReg
 * JD-Core Version:    0.7.0.1
 */