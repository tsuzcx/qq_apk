import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppEnv;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239.1;
import com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239.10;
import com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239.14;
import com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239.15;
import com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239.3;
import com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239.8;
import com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239.9;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import java.util.ArrayList;
import java.util.List;

public class bhcn
{
  private static long jdField_a_of_type_Long = 5000L;
  private static MiniAppInfo jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo;
  private static Runnable jdField_a_of_type_JavaLangRunnable = new SDKMiniProgramLpReportDC04239.14();
  
  public static String a(MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo != null)
    {
      if (paramMiniAppInfo.isReportTypeMiniGame()) {
        return "1";
      }
      return "0";
    }
    return "0";
  }
  
  public static void a()
  {
    if (((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).isDebugVersion()) {
      QMLog.i("MiniProgramLpReportDC04239", "deleteRecordDurationMsg");
    }
    bhch.a().a().removeCallbacks(jdField_a_of_type_JavaLangRunnable);
  }
  
  public static void a(MiniAppInfo paramMiniAppInfo, long paramLong)
  {
    ThreadManager.a(new SDKMiniProgramLpReportDC04239.15(paramMiniAppInfo, paramLong), 16, null, false);
  }
  
  public static void a(MiniAppInfo paramMiniAppInfo, String paramString)
  {
    bhch.a().a().post(new SDKMiniProgramLpReportDC04239.8(paramString, paramMiniAppInfo));
  }
  
  public static void a(MiniAppInfo paramMiniAppInfo, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    bhch.a().a().post(new SDKMiniProgramLpReportDC04239.3(paramString3, paramString4, paramString1, paramMiniAppInfo, paramString2));
  }
  
  public static void a(MiniAppInfo paramMiniAppInfo, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    bhch.a().a().post(new SDKMiniProgramLpReportDC04239.1(paramString3, paramString4, paramString5, paramString1, paramMiniAppInfo, paramString2));
  }
  
  public static void a(MiniAppInfo paramMiniAppInfo, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    bhch.a().a().post(new SDKMiniProgramLpReportDC04239.9(paramMiniAppInfo, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6));
  }
  
  public static void a(MiniAppInfo paramMiniAppInfo, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10)
  {
    if ((a(paramString4)) && (!bhbs.a))
    {
      bhch.a().a().post(new SDKMiniProgramLpReportDC04239.10(paramMiniAppInfo, paramString3, paramString4, paramString2, paramString5, paramString6, paramString1));
      if (("unload".equals(paramString4)) || ("close".equals(paramString4)) || ("hide".equals(paramString4)) || ("finishshow".equals(paramString4)) || ("sys_alert".equals(paramString3)))
      {
        bhch.a().b();
        if (((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).isDebugVersion()) {
          QMLog.d("MiniProgramLpReportDC04239", "reportPageView() called flush()");
        }
      }
      if (!"show".equals(paramString4)) {
        break label283;
      }
      jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo = paramMiniAppInfo;
      c();
    }
    label183:
    while ((!"unload".equals(paramString4)) && (!"hide".equals(paramString4)) && (!"close".equals(paramString4)))
    {
      return;
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(bhcg.b());
      String str = bgos.a(paramString2);
      if ((paramMiniAppInfo != null) && (paramMiniAppInfo.launchParam != null))
      {
        paramString2 = String.valueOf(paramMiniAppInfo.launchParam.scene);
        localArrayList.addAll(bhcg.a(paramMiniAppInfo, str, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8, paramString9, paramString10, paramString1, null));
        localArrayList.addAll(bhcg.c());
        if (!QUAUtil.isQQApp()) {
          localArrayList.addAll(bhcg.a());
        }
        if (!QUAUtil.isQQApp()) {
          break label276;
        }
      }
      for (int i = 2;; i = 12)
      {
        paramString1 = bhcg.a(i, localArrayList, null);
        bhch.a().a(paramString1);
        break;
        paramString2 = null;
        break label183;
      }
    }
    label276:
    label283:
    a();
  }
  
  public static boolean a(String paramString)
  {
    return ("click".equals(paramString)) || ("load".equals(paramString)) || ("load_fail".equals(paramString)) || ("show".equals(paramString)) || ("show_fail".equals(paramString)) || ("finishshow".equals(paramString)) || ("hide".equals(paramString)) || ("unload".equals(paramString)) || ("close".equals(paramString));
  }
  
  private static SharedPreferences b(String paramString1, String paramString2)
  {
    return AppLoaderFactory.g().getMiniAppEnv().getContext().getSharedPreferences(paramString1 + "_" + paramString2, 0);
  }
  
  private static String b(String paramString1, String paramString2)
  {
    return paramString1 + "_" + paramString2 + "_duration";
  }
  
  public static void b(MiniAppInfo paramMiniAppInfo, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(bhcg.b());
    String str = bgos.a(paramString2);
    if ((paramMiniAppInfo != null) && (paramMiniAppInfo.launchParam != null))
    {
      paramString2 = String.valueOf(paramMiniAppInfo.launchParam.scene);
      localArrayList.addAll(bhcg.a(paramMiniAppInfo, str, paramString2, paramString3, paramString4, paramString5, paramString6, null, null, null, null, paramString1, ""));
      localArrayList.addAll(bhcg.c());
      if ((paramMiniAppInfo != null) && (paramMiniAppInfo.reportData != null) && (!TextUtils.isEmpty(paramMiniAppInfo.reportData))) {
        localArrayList.addAll(bhcg.a(paramMiniAppInfo.reportData));
      }
      if (!QUAUtil.isQQApp()) {
        localArrayList.addAll(bhcg.a());
      }
      if (!QUAUtil.isQQApp()) {
        break label173;
      }
    }
    label173:
    for (int i = 2;; i = 12)
    {
      paramMiniAppInfo = bhcg.a(i, localArrayList, null);
      bhch.a().a(paramMiniAppInfo);
      return;
      paramString2 = null;
      break;
    }
  }
  
  private static void b(String paramString1, String paramString2, String paramString3)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(bhcg.b());
    localArrayList.addAll(bhcg.a(paramString1, paramString2, paramString3, null, null, null, null));
    localArrayList.addAll(bhcg.c());
    if (!QUAUtil.isQQApp()) {
      localArrayList.addAll(bhcg.a());
    }
    if (QUAUtil.isQQApp()) {}
    for (int i = 2;; i = 12)
    {
      paramString1 = bhcg.a(i, localArrayList, null);
      bhch.a().a(paramString1);
      bhch.a().b();
      return;
    }
  }
  
  private static void b(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(bhcg.b());
    localArrayList.addAll(bhcg.a(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, null));
    localArrayList.addAll(bhcg.c());
    if (!QUAUtil.isQQApp()) {
      localArrayList.addAll(bhcg.a());
    }
    if (QUAUtil.isQQApp()) {}
    for (int i = 2;; i = 12)
    {
      paramString1 = bhcg.a(i, localArrayList, null);
      bhch.a().a(paramString1);
      bhch.a().b();
      return;
    }
  }
  
  private static String c(MiniAppInfo paramMiniAppInfo)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramMiniAppInfo != null)
    {
      localObject1 = localObject2;
      if (paramMiniAppInfo.launchParam != null) {
        localObject1 = paramMiniAppInfo.launchParam.miniAppId;
      }
    }
    localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject2 = paramMiniAppInfo.appId;
    }
    return localObject2;
  }
  
  private static void c()
  {
    if (((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).isDebugVersion()) {
      QMLog.i("MiniProgramLpReportDC04239", "sendRecordDurationMsg");
    }
    bhch.a().a().removeCallbacks(jdField_a_of_type_JavaLangRunnable);
    bhch.a().a().postDelayed(jdField_a_of_type_JavaLangRunnable, jdField_a_of_type_Long);
  }
  
  private static void c(MiniAppInfo paramMiniAppInfo, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(bhcg.b());
    String str1 = "0";
    if (paramMiniAppInfo != null) {
      str1 = a(paramMiniAppInfo);
    }
    String str2;
    if ((paramMiniAppInfo != null) && (paramMiniAppInfo.launchParam != null))
    {
      str2 = String.valueOf(paramMiniAppInfo.launchParam.scene);
      localArrayList.addAll(bhcg.a(paramMiniAppInfo, null, str2, paramString1, paramString2, paramString3, paramString4, null, null, null, null, str1, ""));
      localArrayList.addAll(bhcg.c());
      if (!QUAUtil.isQQApp()) {
        localArrayList.addAll(bhcg.a());
      }
      if (!QUAUtil.isQQApp()) {
        break label152;
      }
    }
    label152:
    for (int i = 2;; i = 12)
    {
      paramMiniAppInfo = bhcg.a(i, localArrayList, null);
      bhch.a().a(paramMiniAppInfo);
      bhch.a().b();
      return;
      str2 = null;
      break;
    }
  }
  
  private static void c(MiniAppInfo paramMiniAppInfo, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    a(paramMiniAppInfo, paramString1, paramString2, paramString3, paramString4, paramString5, "", null, null, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhcn
 * JD-Core Version:    0.7.0.1
 */