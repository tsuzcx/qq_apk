import android.os.Handler;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239.10;
import com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239.14;
import com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239.3;
import com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239.8;
import com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239.9;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class bdsx
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
      bdnw.b("MiniProgramLpReportDC04239", "deleteRecordDurationMsg");
    }
    bdsr.a().a().removeCallbacks(jdField_a_of_type_JavaLangRunnable);
  }
  
  public static void a(MiniAppInfo paramMiniAppInfo, String paramString)
  {
    bdsr.a().a().post(new SDKMiniProgramLpReportDC04239.8(paramString, paramMiniAppInfo));
  }
  
  public static void a(MiniAppInfo paramMiniAppInfo, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    bdsr.a().a().post(new SDKMiniProgramLpReportDC04239.3(paramString3, paramString4, paramString1, paramMiniAppInfo, paramString2));
  }
  
  public static void a(MiniAppInfo paramMiniAppInfo, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    bdsr.a().a().post(new SDKMiniProgramLpReportDC04239.9(paramMiniAppInfo, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6));
  }
  
  public static boolean a(String paramString)
  {
    return ("click".equals(paramString)) || ("load".equals(paramString)) || ("load_fail".equals(paramString)) || ("show".equals(paramString)) || ("show_fail".equals(paramString)) || ("finishshow".equals(paramString)) || ("hide".equals(paramString)) || ("unload".equals(paramString)) || ("close".equals(paramString));
  }
  
  private static void b(MiniAppInfo paramMiniAppInfo, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    b(paramMiniAppInfo, paramString1, paramString2, paramString3, paramString4, paramString5, "");
  }
  
  public static void b(MiniAppInfo paramMiniAppInfo, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    if (a(paramString4))
    {
      bdsr.a().a().post(new SDKMiniProgramLpReportDC04239.10(paramMiniAppInfo, paramString3, paramString4, paramString2, paramString5, paramString6, paramString1));
      if (("unload".equals(paramString4)) || ("close".equals(paramString4)) || ("hide".equals(paramString4)) || ("finishshow".equals(paramString4)))
      {
        bdsr.a().b();
        if (((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).isDebugVersion()) {
          bdnw.a("MiniProgramLpReportDC04239", "reportPageView() called flush()");
        }
      }
      if (!"show".equals(paramString4)) {
        break label229;
      }
      jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo = paramMiniAppInfo;
      c();
    }
    label229:
    while ((!"unload".equals(paramString4)) && (!"hide".equals(paramString4)) && (!"close".equals(paramString4)))
    {
      return;
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(bdsq.a());
      String str = bdgj.a(paramString2);
      if ((paramMiniAppInfo != null) && (paramMiniAppInfo.launchParam != null)) {}
      for (paramString2 = String.valueOf(paramMiniAppInfo.launchParam.a);; paramString2 = null)
      {
        localArrayList.addAll(bdsq.a(paramMiniAppInfo, str, paramString2, paramString3, paramString4, paramString5, paramString6, null, null, null, paramString1, null));
        localArrayList.addAll(bdsq.b());
        paramString1 = bdsq.a(2, localArrayList, null);
        bdsr.a().a(paramString1);
        break;
      }
    }
    a();
  }
  
  private static void b(String paramString1, String paramString2, String paramString3)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(bdsq.a());
    localArrayList.addAll(bdsq.a(paramString1, paramString2, paramString3, null, null, null, null));
    localArrayList.addAll(bdsq.b());
    paramString1 = bdsq.a(2, localArrayList, null);
    bdsr.a().a(paramString1);
    bdsr.a().b();
  }
  
  private static void b(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(bdsq.a());
    localArrayList.addAll(bdsq.a(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, null));
    localArrayList.addAll(bdsq.b());
    paramString1 = bdsq.a(2, localArrayList, null);
    bdsr.a().a(paramString1);
    bdsr.a().b();
  }
  
  private static void c()
  {
    if (((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).isDebugVersion()) {
      bdnw.b("MiniProgramLpReportDC04239", "sendRecordDurationMsg");
    }
    bdsr.a().a().removeCallbacks(jdField_a_of_type_JavaLangRunnable);
    bdsr.a().a().postDelayed(jdField_a_of_type_JavaLangRunnable, jdField_a_of_type_Long);
  }
  
  private static void c(MiniAppInfo paramMiniAppInfo, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(bdsq.a());
    String str1 = "0";
    if (paramMiniAppInfo != null) {
      str1 = a(paramMiniAppInfo);
    }
    if ((paramMiniAppInfo != null) && (paramMiniAppInfo.launchParam != null)) {}
    for (String str2 = String.valueOf(paramMiniAppInfo.launchParam.a);; str2 = null)
    {
      localArrayList.addAll(bdsq.a(paramMiniAppInfo, null, str2, paramString1, paramString2, paramString3, paramString4, null, null, null, str1, ""));
      localArrayList.addAll(bdsq.b());
      paramMiniAppInfo = bdsq.a(2, localArrayList, null);
      bdsr.a().a(paramMiniAppInfo);
      bdsr.a().b();
      return;
    }
  }
  
  public static void c(MiniAppInfo paramMiniAppInfo, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(bdsq.a());
    String str = bdgj.a(paramString2);
    if ((paramMiniAppInfo != null) && (paramMiniAppInfo.launchParam != null)) {}
    for (paramString2 = String.valueOf(paramMiniAppInfo.launchParam.a);; paramString2 = null)
    {
      localArrayList.addAll(bdsq.a(paramMiniAppInfo, str, paramString2, paramString3, paramString4, paramString5, paramString6, null, null, null, paramString1, ""));
      localArrayList.addAll(bdsq.b());
      if ((paramMiniAppInfo != null) && (paramMiniAppInfo.reportData != null) && (paramMiniAppInfo.reportData.size() > 0)) {
        localArrayList.addAll(bdsq.a(paramMiniAppInfo.reportData));
      }
      paramMiniAppInfo = bdsq.a(2, localArrayList, null);
      bdsr.a().a(paramMiniAppInfo);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdsx
 * JD-Core Version:    0.7.0.1
 */