package com.tencent.common.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.AIOConfigData;
import com.tencent.mobileqq.activity.aio.AIOConfigManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.PrivacyPolicyHelper;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.haoliyou.IATHandler;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.ProcessUtil;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.monitor.crash.catchedexception.CaughtExceptionReport;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.IBrowserThirdAppReport;
import mqq.app.IThirdAppOpenReport;

public class ThirdAppReportImpl
  implements IThirdAppOpenReport
{
  public static void a()
  {
    Object localObject = AIOConfigManager.a;
    if ((localObject != null) && (((AIOConfigData)localObject).e == 1) && (!ProcessUtil.a(BaseApplicationImpl.getContext())))
    {
      localObject = new Throwable("background_start_activity");
      StackTraceElement[] arrayOfStackTraceElement = ((Throwable)localObject).getStackTrace();
      StringBuilder localStringBuilder = new StringBuilder();
      int j = arrayOfStackTraceElement.length;
      int i = 0;
      while (i < j)
      {
        localStringBuilder.append(arrayOfStackTraceElement[i].toString());
        i += 1;
      }
      CaughtExceptionReport.a((Throwable)localObject);
      if (QLog.isColorLevel()) {
        QLog.d("ThirdAppReport", 2, QLog.getStackTraceString(new Throwable("background_start_activity")));
      }
    }
  }
  
  public static void a(Intent paramIntent, String paramString1, int paramInt, String paramString2, String paramString3)
  {
    if (!PrivacyPolicyHelper.d()) {
      return;
    }
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    String str4 = BaseApplicationImpl.processName;
    String str5 = paramIntent.getAction();
    String str3 = "";
    String str1;
    if (paramString2 == null) {
      str1 = "";
    } else {
      str1 = paramString2;
    }
    String str2;
    if (paramString3 == null) {
      str2 = "";
    } else {
      str2 = paramString3;
    }
    paramString2 = paramIntent.getType();
    boolean bool1;
    boolean bool2;
    Object localObject1;
    if (("android.intent.action.VIEW".equals(str5)) && ("application/vnd.android.package-archive".equalsIgnoreCase(paramString2)))
    {
      paramIntent = paramIntent.getData();
      str3 = FileProvider7Helper.getRealPathFromContentURI(localBaseApplication, paramIntent);
      bool1 = new File(str3).exists();
      if (QLog.isDevelopLevel())
      {
        paramString2 = new StringBuilder();
        paramString2.append("install data-uri ");
        paramString2.append(paramIntent.toString());
        paramString2.append(" real filePath = ");
        paramString2.append(str3);
        paramString2.append("isFileExists = ");
        paramString2.append(bool1);
        QLog.d("ThirdAppReport", 4, paramString2.toString());
      }
      if (bool1)
      {
        paramIntent = localBaseApplication.getPackageManager().getPackageArchiveInfo(str3, 0);
        if (paramIntent != null) {
          paramIntent = paramIntent.packageName;
        } else {
          paramIntent = "";
        }
        bool1 = true;
        paramString2 = paramIntent;
      }
      else
      {
        paramString2 = "";
        bool1 = false;
      }
      bool2 = bool1;
      bool1 = true;
      paramIntent = "";
      localObject1 = paramIntent;
      paramString3 = paramString2;
    }
    else
    {
      paramString3 = paramIntent.getPackage();
      if (paramIntent.getComponent() != null) {
        paramString2 = paramIntent.getComponent().getClassName();
      } else {
        paramString2 = "";
      }
      localObject1 = paramIntent.getDataString();
      paramIntent = localBaseApplication.getPackageManager().queryIntentActivities(paramIntent, 65536);
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("dPkgName = ");
      ((StringBuilder)localObject2).append(paramString3);
      ((StringBuilder)localObject2).append(" dInfoList = ");
      ((StringBuilder)localObject2).append(paramIntent);
      QLog.d("ThirdAppReport", 4, ((StringBuilder)localObject2).toString());
      if (TextUtils.isEmpty(paramString3))
      {
        if ((paramIntent != null) && (paramIntent.size() > 0))
        {
          paramIntent = (ResolveInfo)paramIntent.get(0);
          paramString3 = paramIntent.activityInfo;
          if (paramString3 != null) {
            paramIntent = paramString3.name;
          }
          for (paramString2 = paramString3.packageName;; paramString2 = paramString3)
          {
            break;
            if (paramIntent.serviceInfo != null)
            {
              paramString2 = paramIntent.serviceInfo;
              paramIntent = paramString2.name;
              paramString2 = paramString2.packageName;
              break;
            }
            paramString3 = paramIntent.resolvePackageName;
            paramIntent = paramString2;
          }
        }
      }
      else {
        for (;;)
        {
          bool1 = false;
          bool2 = true;
          paramString3 = paramString2;
          break label556;
          if ((paramIntent == null) || (paramIntent.size() <= 0)) {
            break;
          }
          paramIntent = paramIntent.iterator();
          do
          {
            if (!paramIntent.hasNext()) {
              break;
            }
            localObject2 = (ResolveInfo)paramIntent.next();
          } while (!paramString3.equalsIgnoreCase(((ResolveInfo)localObject2).resolvePackageName));
          paramIntent = ((ResolveInfo)localObject2).activityInfo;
          if (paramIntent != null)
          {
            paramIntent = paramIntent.name;
            paramString2 = paramString3;
          }
          else
          {
            paramIntent = paramString2;
            paramString2 = paramString3;
            if (((ResolveInfo)localObject2).serviceInfo != null)
            {
              paramIntent = ((ResolveInfo)localObject2).serviceInfo.name;
              paramString2 = paramString3;
            }
          }
        }
      }
      bool1 = false;
      bool2 = false;
      paramIntent = paramString2;
    }
    label556:
    if (QLog.isDevelopLevel()) {
      QLog.d("ThirdAppReport", 4, String.format("params:sProcessName = %s,sComponentName = %s,dPkgName = %s,dAction = %s,dComponentName = %s,dScheme = %s,isInstall = %b,sInstallFilePath = = %s,fromType = %d,isValid = %b,sOriginalUrl = %s,sCurrentUrl = %s", new Object[] { str4, paramString1, paramString3, str5, paramIntent, localObject1, Boolean.valueOf(bool1), str3, Integer.valueOf(paramInt), Boolean.valueOf(bool2), str1, str2 }));
    }
    if ((bool2) && (!TextUtils.isEmpty(paramString3)))
    {
      if (localBaseApplication.getPackageName().equalsIgnoreCase(paramString3)) {
        return;
      }
      paramString2 = new HashMap();
      paramString2.put("sComponentName", paramString1);
      paramString2.put("sProcessName", str4);
      paramString2.put("sFrom", String.valueOf(paramInt));
      paramString2.put("dPkgName", paramString3);
      if (bool1)
      {
        paramString2.put("installFilePath", str3);
      }
      else
      {
        paramString2.put("dActionName", str5);
        paramString2.put("dCompomentName", paramIntent);
        paramString2.put("dSchema", localObject1);
      }
      paramString2.put("sOriginalUrl", str1);
      paramString2.put("sCurrentUrl", str2);
      if (bool1) {
        paramIntent = "ThirdAppInstall";
      } else {
        paramIntent = "ThirdAppOpen";
      }
      paramString1 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      if (QLog.isColorLevel()) {
        QLog.d("ThirdAppReport", 2, "report real... ");
      }
      StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance(paramString1, paramIntent, true, 0L, 0L, paramString2, null);
    }
  }
  
  public void report(Context paramContext, Intent paramIntent, int paramInt)
  {
    if (paramContext != null)
    {
      if (paramIntent == null) {
        return;
      }
      int i = 0;
      try
      {
        if (Build.VERSION.SDK_INT >= 21) {
          a();
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("ThirdAppReport", 1, localThrowable, new Object[0]);
      }
      Object localObject1 = paramIntent.getComponent();
      if (localObject1 != null)
      {
        localObject1 = ((ComponentName)localObject1).getPackageName();
        if (paramContext.getPackageName().equalsIgnoreCase((String)localObject1)) {}
      }
      else
      {
        i = 1;
      }
      if (i != 0)
      {
        if ((paramContext instanceof BaseActivity)) {
          localObject1 = ((BaseActivity)paramContext).getCIOPageName();
        }
        for (;;)
        {
          break;
          if ((paramContext instanceof PluginProxyActivity)) {
            localObject1 = ((PluginProxyActivity)paramContext).getPluginActivity();
          } else {
            localObject1 = paramContext.getClass().getName();
          }
        }
        Object localObject2;
        if ((paramContext instanceof IBrowserThirdAppReport))
        {
          localObject2 = (IBrowserThirdAppReport)paramContext;
          paramContext = ((IBrowserThirdAppReport)localObject2).getOriginalUrl();
          localObject2 = ((IBrowserThirdAppReport)localObject2).getCurrentUrl();
        }
        else
        {
          paramContext = null;
          localObject2 = paramContext;
        }
        ThreadManager.excute(new ThirdAppReportImpl.1(this, paramIntent, (String)localObject1, paramInt, paramContext, (String)localObject2), 64, null, true);
      }
    }
  }
  
  public void startActivityForResult(Activity paramActivity, Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    if (paramInt >= 0) {
      i = paramInt + 0;
    } else {
      i = 0;
    }
    int j = i + 1 - 1;
    int i = j;
    if (paramBundle != null) {
      i = j | 0x1;
    }
    j = i;
    if (paramActivity != null) {
      j = i >> 1;
    }
    i = j;
    if (paramIntent != null) {
      i = j + 1;
    }
    j = i;
    if (paramInt >= 0) {
      j = i + paramInt;
    }
    j = j + 1 - 1;
    i = j;
    if (paramBundle != null) {
      i = j | 0x1;
    }
    j = i;
    if (paramActivity != null) {
      j = i >> 1;
    }
    i = j;
    if (paramIntent != null) {
      i = j + 1;
    }
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(i);
      localStringBuilder.append("");
      QLog.i("ThirdAppReport", 4, localStringBuilder.toString());
    }
    if (paramIntent == null)
    {
      QLog.e("ThirdAppReport", 1, "intent is null! could not start activity!");
      return;
    }
    IATHandler.a(paramActivity, paramIntent, paramInt, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.common.app.ThirdAppReportImpl
 * JD-Core Version:    0.7.0.1
 */