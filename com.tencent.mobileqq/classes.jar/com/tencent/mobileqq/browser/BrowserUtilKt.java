package com.tencent.mobileqq.browser;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.config.business.BrowserOpenBean;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.pm.PackageUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"TAG", "", "downloadBrowser", "", "context", "Landroid/content/Context;", "downloadUrl", "targetUrl", "getCurrentUinIfExists", "loadValidBrowserList", "", "Lcom/tencent/mobileqq/browser/BrowserItem;", "browserOpenBean", "Lcom/tencent/mobileqq/config/business/BrowserOpenBean;", "openUrlWithBrowser", "activity", "Landroid/app/Activity;", "url", "packageName", "systemLocalBrowsers", "AQQLiteApp_release"}, k=2, mv={1, 1, 16})
public final class BrowserUtilKt
{
  @NotNull
  public static final String a()
  {
    Object localObject = BaseApplicationImpl.getApplication();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "BaseApplicationImpl.getApplication()");
    localObject = ((BaseApplicationImpl)localObject).getRuntime();
    if (localObject != null)
    {
      localObject = ((AppRuntime)localObject).getAccount();
      if (localObject != null) {
        return localObject;
      }
      return "";
    }
    return "";
  }
  
  private static final List<String> a(Context paramContext)
  {
    List localList = (List)new ArrayList();
    for (;;)
    {
      try
      {
        paramContext = paramContext.getPackageManager().queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse("https://www.qq.com")), 65536);
        Intrinsics.checkExpressionValueIsNotNull(paramContext, "queryIntentActivities");
        Iterator localIterator = ((Iterable)paramContext).iterator();
        if (localIterator.hasNext())
        {
          Object localObject = (ResolveInfo)localIterator.next();
          if (localObject != null)
          {
            paramContext = ((ResolveInfo)localObject).activityInfo;
            if (paramContext == null) {
              continue;
            }
            paramContext = ((ResolveInfo)localObject).activityInfo.processName;
            if (!TextUtils.isEmpty((CharSequence)paramContext))
            {
              Intrinsics.checkExpressionValueIsNotNull(paramContext, "pkgName");
              localList.add(paramContext);
            }
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("pkgName: ");
            ((StringBuilder)localObject).append(paramContext);
            QLog.d("[BrowserOpt] BrowserUtil", 2, new Object[] { "systemLocalBrowsers: called. ", ((StringBuilder)localObject).toString() });
          }
        }
        else
        {
          return localList;
        }
      }
      catch (Exception paramContext)
      {
        QLog.e("[BrowserOpt] BrowserUtil", 1, "systemLocalBrowsers failed", (Throwable)paramContext);
      }
      paramContext = null;
    }
  }
  
  @NotNull
  public static final List<BrowserItem> a(@NotNull Context paramContext, @Nullable BrowserOpenBean paramBrowserOpenBean)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    List localList = (List)new ArrayList();
    Set localSet = (Set)new LinkedHashSet();
    if (paramBrowserOpenBean != null)
    {
      Object localObject = ((Iterable)paramBrowserOpenBean.a()).iterator();
      while (((Iterator)localObject).hasNext())
      {
        BrowserItem localBrowserItem = (BrowserItem)((Iterator)localObject).next();
        localList.add(localBrowserItem);
        localSet.add(localBrowserItem.e());
      }
      paramContext = ((Iterable)a(paramContext)).iterator();
      while (paramContext.hasNext())
      {
        localObject = (String)paramContext.next();
        boolean bool1;
        try
        {
          bool1 = PackageUtil.a((Context)BaseApplication.context, (String)localObject);
        }
        catch (Exception localException)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("topBrowsers: ");
          localStringBuilder.append(paramBrowserOpenBean.a());
          QLog.e("[BrowserOpt] BrowserUtil", 1, new Object[] { "convertToTopBrowserList: called. ", localStringBuilder.toString(), localException });
          bool1 = false;
        }
        boolean bool2 = localSet.contains(localObject);
        boolean bool3 = paramBrowserOpenBean.b().contains(localObject);
        if ((bool1) && (!bool3) && (!bool2))
        {
          String str = PackageUtil.a((Context)BaseApplication.context, (String)localObject);
          if (str != null) {
            localList.add(new BrowserItem(str, "", "", "", (String)localObject, true));
          }
        }
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("topBrowsers: ");
          ((StringBuilder)localObject).append(paramBrowserOpenBean.a());
          ((StringBuilder)localObject).append("  ");
          ((StringBuilder)localObject).append("packageInstalled: ");
          ((StringBuilder)localObject).append(bool1);
          ((StringBuilder)localObject).append("  inBlackList: ");
          ((StringBuilder)localObject).append(bool3);
          ((StringBuilder)localObject).append(" inTopBrowserList: ");
          ((StringBuilder)localObject).append(bool2);
          QLog.d("[BrowserOpt] BrowserUtil", 2, new Object[] { "loadValidBrowserList: called. ", ((StringBuilder)localObject).toString() });
        }
      }
    }
    return localList;
  }
  
  public static final void a(@NotNull Activity paramActivity, @NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    Intrinsics.checkParameterIsNotNull(paramString1, "url");
    Intrinsics.checkParameterIsNotNull(paramString2, "packageName");
    paramString1 = new Intent("android.intent.action.VIEW", Uri.parse(paramString1));
    paramString1.setPackage(paramString2);
    paramString1.addFlags(268435456);
    paramActivity.startActivity(paramString1);
  }
  
  public static final void a(@NotNull Context paramContext, @NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramString1, "downloadUrl");
    Intrinsics.checkParameterIsNotNull(paramString2, "targetUrl");
    try
    {
      paramString1 = new Intent();
      paramString1.putExtra("url", "https://upage.imtt.qq.com/m_imtt/qq_download_middle_page/real/qq_download_middle_page.html");
      paramString1.addFlags(268435456);
      RouteUtils.a(paramContext, paramString1, "/base/browser");
      return;
    }
    catch (Throwable paramContext)
    {
      QLog.e("[BrowserOpt] BrowserUtil", 2, "startActivity er:", paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.browser.BrowserUtilKt
 * JD-Core Version:    0.7.0.1
 */