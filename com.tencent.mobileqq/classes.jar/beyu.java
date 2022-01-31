import android.os.Handler;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239.1;
import com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239.10;
import com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239.14;
import com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239.3;
import com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239.8;
import com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239.9;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class beyu
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
      besl.b("MiniProgramLpReportDC04239", "deleteRecordDurationMsg");
    }
    beyo.a().a().removeCallbacks(jdField_a_of_type_JavaLangRunnable);
  }
  
  public static void a(MiniAppInfo paramMiniAppInfo, String paramString)
  {
    beyo.a().a().post(new SDKMiniProgramLpReportDC04239.8(paramString, paramMiniAppInfo));
  }
  
  public static void a(MiniAppInfo paramMiniAppInfo, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    beyo.a().a().post(new SDKMiniProgramLpReportDC04239.3(paramString3, paramString4, paramString1, paramMiniAppInfo, paramString2));
  }
  
  public static void a(MiniAppInfo paramMiniAppInfo, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    beyo.a().a().post(new SDKMiniProgramLpReportDC04239.1(paramString3, paramString4, paramString5, paramString1, paramMiniAppInfo, paramString2));
  }
  
  public static void a(MiniAppInfo paramMiniAppInfo, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    beyo.a().a().post(new SDKMiniProgramLpReportDC04239.9(paramMiniAppInfo, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6));
  }
  
  public static void a(MiniAppInfo paramMiniAppInfo, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    if (a(paramString4))
    {
      beyo.a().a().post(new SDKMiniProgramLpReportDC04239.10(paramMiniAppInfo, paramString3, paramString4, paramString2, paramString5, paramString6, paramString1));
      if (("unload".equals(paramString4)) || ("close".equals(paramString4)) || ("hide".equals(paramString4)) || ("finishshow".equals(paramString4)))
      {
        beyo.a().b();
        if (((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).isDebugVersion()) {
          besl.a("MiniProgramLpReportDC04239", "reportPageView() called flush()");
        }
      }
      if (!"show".equals(paramString4)) {
        break label266;
      }
      jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo = paramMiniAppInfo;
      c();
    }
    label168:
    while ((!"unload".equals(paramString4)) && (!"hide".equals(paramString4)) && (!"close".equals(paramString4)))
    {
      return;
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(beyn.b());
      String str = bekj.a(paramString2);
      if ((paramMiniAppInfo != null) && (paramMiniAppInfo.launchParam != null))
      {
        paramString2 = String.valueOf(paramMiniAppInfo.launchParam.a);
        localArrayList.addAll(beyn.a(paramMiniAppInfo, str, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8, paramString9, paramString1, null));
        localArrayList.addAll(beyn.c());
        if (!bfgt.a()) {
          localArrayList.addAll(beyn.a());
        }
        if (!bfgt.a()) {
          break label259;
        }
      }
      for (int i = 2;; i = 12)
      {
        paramString1 = beyn.a(i, localArrayList, null);
        beyo.a().a(paramString1);
        break;
        paramString2 = null;
        break label168;
      }
    }
    label259:
    label266:
    a();
  }
  
  public static boolean a(String paramString)
  {
    return ("click".equals(paramString)) || ("load".equals(paramString)) || ("load_fail".equals(paramString)) || ("show".equals(paramString)) || ("show_fail".equals(paramString)) || ("finishshow".equals(paramString)) || ("hide".equals(paramString)) || ("unload".equals(paramString)) || ("close".equals(paramString));
  }
  
  public static void b(MiniAppInfo paramMiniAppInfo, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(beyn.b());
    String str = bekj.a(paramString2);
    if ((paramMiniAppInfo != null) && (paramMiniAppInfo.launchParam != null))
    {
      paramString2 = String.valueOf(paramMiniAppInfo.launchParam.a);
      localArrayList.addAll(beyn.a(paramMiniAppInfo, str, paramString2, paramString3, paramString4, paramString5, paramString6, null, null, null, paramString1, ""));
      localArrayList.addAll(beyn.c());
      if ((paramMiniAppInfo != null) && (paramMiniAppInfo.reportData != null) && (paramMiniAppInfo.reportData.size() > 0)) {
        localArrayList.addAll(beyn.a(paramMiniAppInfo.reportData));
      }
      if (!bfgt.a()) {
        localArrayList.addAll(beyn.a());
      }
      if (!bfgt.a()) {
        break label173;
      }
    }
    label173:
    for (int i = 2;; i = 12)
    {
      paramMiniAppInfo = beyn.a(i, localArrayList, null);
      beyo.a().a(paramMiniAppInfo);
      return;
      paramString2 = null;
      break;
    }
  }
  
  private static void b(String paramString1, String paramString2, String paramString3)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(beyn.b());
    localArrayList.addAll(beyn.a(paramString1, paramString2, paramString3, null, null, null, null));
    localArrayList.addAll(beyn.c());
    if (!bfgt.a()) {
      localArrayList.addAll(beyn.a());
    }
    if (bfgt.a()) {}
    for (int i = 2;; i = 12)
    {
      paramString1 = beyn.a(i, localArrayList, null);
      beyo.a().a(paramString1);
      beyo.a().b();
      return;
    }
  }
  
  private static void b(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(beyn.b());
    localArrayList.addAll(beyn.a(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, null));
    localArrayList.addAll(beyn.c());
    if (!bfgt.a()) {
      localArrayList.addAll(beyn.a());
    }
    if (bfgt.a()) {}
    for (int i = 2;; i = 12)
    {
      paramString1 = beyn.a(i, localArrayList, null);
      beyo.a().a(paramString1);
      beyo.a().b();
      return;
    }
  }
  
  private static void c()
  {
    if (((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).isDebugVersion()) {
      besl.b("MiniProgramLpReportDC04239", "sendRecordDurationMsg");
    }
    beyo.a().a().removeCallbacks(jdField_a_of_type_JavaLangRunnable);
    beyo.a().a().postDelayed(jdField_a_of_type_JavaLangRunnable, jdField_a_of_type_Long);
  }
  
  private static void c(MiniAppInfo paramMiniAppInfo, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(beyn.b());
    String str1 = "0";
    if (paramMiniAppInfo != null) {
      str1 = a(paramMiniAppInfo);
    }
    String str2;
    if ((paramMiniAppInfo != null) && (paramMiniAppInfo.launchParam != null))
    {
      str2 = String.valueOf(paramMiniAppInfo.launchParam.a);
      localArrayList.addAll(beyn.a(paramMiniAppInfo, null, str2, paramString1, paramString2, paramString3, paramString4, null, null, null, str1, ""));
      localArrayList.addAll(beyn.c());
      if (!bfgt.a()) {
        localArrayList.addAll(beyn.a());
      }
      if (!bfgt.a()) {
        break label150;
      }
    }
    label150:
    for (int i = 2;; i = 12)
    {
      paramMiniAppInfo = beyn.a(i, localArrayList, null);
      beyo.a().a(paramMiniAppInfo);
      beyo.a().b();
      return;
      str2 = null;
      break;
    }
  }
  
  private static void c(MiniAppInfo paramMiniAppInfo, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    a(paramMiniAppInfo, paramString1, paramString2, paramString3, paramString4, paramString5, "", null, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     beyu
 * JD-Core Version:    0.7.0.1
 */