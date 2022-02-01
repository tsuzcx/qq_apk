import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
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
public final class apds
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
    localList = (List)new ArrayList();
    try
    {
      paramContext = paramContext.getPackageManager().queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse("https://www.qq.com")), 65536);
      Intrinsics.checkExpressionValueIsNotNull(paramContext, "queryIntentActivities");
      Iterator localIterator = ((Iterable)paramContext).iterator();
      if (localIterator.hasNext())
      {
        ResolveInfo localResolveInfo = (ResolveInfo)localIterator.next();
        if (localResolveInfo != null) {}
        for (paramContext = localResolveInfo.activityInfo;; paramContext = null)
        {
          if (paramContext != null)
          {
            paramContext = localResolveInfo.activityInfo.processName;
            if (!TextUtils.isEmpty((CharSequence)paramContext))
            {
              Intrinsics.checkExpressionValueIsNotNull(paramContext, "pkgName");
              localList.add(paramContext);
            }
            QLog.d("[BrowserOpt] BrowserUtil", 2, new Object[] { "systemLocalBrowsers: called. ", "pkgName: " + paramContext });
          }
          break;
        }
      }
      return localList;
    }
    catch (Exception paramContext)
    {
      QLog.e("[BrowserOpt] BrowserUtil", 1, "systemLocalBrowsers failed", (Throwable)paramContext);
    }
  }
  
  @NotNull
  public static final List<apdr> a(@NotNull Context paramContext, @Nullable apwy paramapwy)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    List localList = (List)new ArrayList();
    Set localSet = (Set)new LinkedHashSet();
    if (paramapwy != null)
    {
      Object localObject1 = ((Iterable)paramapwy.a()).iterator();
      Object localObject2;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (apdr)((Iterator)localObject1).next();
        localList.add(localObject2);
        localSet.add(((apdr)localObject2).e());
      }
      paramContext = ((Iterable)a(paramContext)).iterator();
      for (;;)
      {
        if (paramContext.hasNext())
        {
          localObject1 = (String)paramContext.next();
          try
          {
            bool1 = bjnn.a((Context)BaseApplication.context, (String)localObject1);
            boolean bool2 = localSet.contains(localObject1);
            boolean bool3 = paramapwy.b().contains(localObject1);
            if ((bool1) && (!bool3) && (!bool2))
            {
              localObject2 = bjnn.a((Context)BaseApplication.context, (String)localObject1);
              if (localObject2 != null) {
                localList.add(new apdr((String)localObject2, "", "", "", (String)localObject1, true));
              }
            }
            if (QLog.isColorLevel()) {
              QLog.d("[BrowserOpt] BrowserUtil", 2, new Object[] { "loadValidBrowserList: called. ", "topBrowsers: " + paramapwy.a() + "  " + "packageInstalled: " + bool1 + "  inBlackList: " + bool3 + " inTopBrowserList: " + bool2 });
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              QLog.e("[BrowserOpt] BrowserUtil", 1, new Object[] { "convertToTopBrowserList: called. ", "topBrowsers: " + paramapwy.a(), localException });
              boolean bool1 = false;
            }
          }
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
    Bundle localBundle = new Bundle();
    localBundle.putString("_open_with_qq_browser_", paramString2);
    localBundle.putInt("_download_qqbrowser_business_", 1);
    aszt.a(paramContext, paramString1, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apds
 * JD-Core Version:    0.7.0.1
 */