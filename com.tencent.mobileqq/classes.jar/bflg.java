import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.appstore.report.AppCenterReporter.1;
import com.tencent.open.appstore.report.AppCenterReporter.2;
import com.tencent.open.appstore.report.AppCenterReporter.3;
import com.tencent.open.appstore.report.AppCenterReporter.4;
import com.tencent.open.appstore.report.AppCenterReporter.5;
import com.tencent.open.appstore.report.AppCenterReporter.6;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.replacemonitor.MonitorStep;
import com.tencent.replacemonitor.MonitorTask;
import com.tencent.replacemonitor.replace.ReplaceMonitor;
import com.tencent.tmassistant.st.SDKReportManager2;
import com.tencent.tmassistantbase.util.GlobalUtil;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class bflg
{
  private static MonitorTask a(DownloadInfo paramDownloadInfo)
  {
    MonitorTask localMonitorTask = new MonitorTask();
    localMonitorTask.appName = paramDownloadInfo.f;
    localMonitorTask.packageName = paramDownloadInfo.e;
    localMonitorTask.versionCode = paramDownloadInfo.jdField_b_of_type_Int;
    localMonitorTask.fileMd5 = paramDownloadInfo.p;
    try
    {
      localMonitorTask.yybApkId = Long.parseLong(paramDownloadInfo.k);
      localMonitorTask.yybAppId = Long.parseLong(paramDownloadInfo.c);
      label62:
      localMonitorTask.downloadUrl = paramDownloadInfo.d;
      localMonitorTask.additionalId = paramDownloadInfo.jdField_b_of_type_JavaLangString;
      localMonitorTask.filePath = paramDownloadInfo.l;
      localMonitorTask.traceId = paramDownloadInfo.x;
      localMonitorTask.externalParams = new HashMap();
      localMonitorTask.externalParams.put("via", paramDownloadInfo.h);
      return localMonitorTask;
    }
    catch (Throwable localThrowable)
    {
      break label62;
    }
  }
  
  private static String a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    return bflj.a().i(paramString5).k(paramString1).j(paramString2).l(paramString3).m(paramString4).b();
  }
  
  public static void a(int paramInt, String paramString)
  {
    bflp.b("AppCenterReporter", "[report] type=" + paramInt + "\ndata=" + paramString);
    SDKReportManager2.getInstance().postReport(paramInt, paramString);
  }
  
  public static void a(bflj parambflj)
  {
    parambflj = parambflj.a();
    bflp.b("AppCenterReporter", "[reportExposure] type=3002\ndata=" + parambflj);
    SDKReportManager2.getInstance().postReport(3002, parambflj);
  }
  
  public static void a(DownloadInfo paramDownloadInfo)
  {
    ThreadManager.excute(new AppCenterReporter.1(paramDownloadInfo), 16, null, true);
  }
  
  public static void a(DownloadInfo paramDownloadInfo, int paramInt)
  {
    ThreadManager.excute(new AppCenterReporter.5(paramDownloadInfo, paramInt), 16, null, true);
  }
  
  public static void a(DownloadInfo paramDownloadInfo, int paramInt, String paramString)
  {
    ThreadManager.excute(new AppCenterReporter.3(paramDownloadInfo, paramInt, paramString), 16, null, true);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    paramString1 = a(paramString1, paramString2, paramString3, paramString4, paramString5);
    bflp.b("AppCenterReporter", "[reportNormalExposure] type=3001\ndata=" + paramString1);
    SDKReportManager2.getInstance().postReport(3001, paramString1);
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    bflp.b("AppCenterReporter", ">notifyInstallFinish " + paramString + "|" + paramBoolean);
    ThreadManager.excute(new AppCenterReporter.6(paramString, paramBoolean), 16, null, true);
  }
  
  private static long b(String paramString)
  {
    if (apao.a(paramString, bfbm.a().a())) {}
    try
    {
      long l = new File(GlobalUtil.getInstance().getContext().getPackageManager().getPackageInfo(paramString, 0).applicationInfo.sourceDir).length();
      return l;
    }
    catch (Throwable paramString)
    {
      label77:
      break label77;
    }
    bflp.b("AppCenterReporter", "[getInstalledAppFileSize]" + paramString + ": NOT INSTALLED!");
    return 0L;
  }
  
  public static void b(bflj parambflj)
  {
    parambflj = parambflj.a();
    bflp.b("AppCenterReporter", "[reportClick] type=3003\ndata=" + parambflj);
    SDKReportManager2.getInstance().postReport(3003, parambflj);
  }
  
  public static void b(DownloadInfo paramDownloadInfo)
  {
    ThreadManager.excute(new AppCenterReporter.2(paramDownloadInfo), 16, null, true);
  }
  
  public static void b(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    paramString1 = a(paramString1, paramString2, paramString3, paramString4, paramString5) + "|" + bflj.a().d() + "|" + "200";
    bflp.b("AppCenterReporter", "[reportClick] type=3003\ndata=" + paramString1);
    SDKReportManager2.getInstance().postReport(3003, paramString1);
  }
  
  private static String c(DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfo == null) {
      return "";
    }
    return bflj.a().i(paramDownloadInfo.o).k(paramDownloadInfo.t).j(paramDownloadInfo.u).l(paramDownloadInfo.v).m(paramDownloadInfo.h).b();
  }
  
  public static void c(DownloadInfo paramDownloadInfo)
  {
    g(paramDownloadInfo);
    ThreadManager.excute(new AppCenterReporter.4(paramDownloadInfo), 16, null, true);
  }
  
  private static String d(DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfo == null) {
      return "";
    }
    return bflj.a().a(paramDownloadInfo.f).b(paramDownloadInfo.e).a(paramDownloadInfo.jdField_b_of_type_Int).c(paramDownloadInfo.c).d(paramDownloadInfo.k).e(paramDownloadInfo.r).f(paramDownloadInfo.s).g(paramDownloadInfo.d).h(paramDownloadInfo.q).c();
  }
  
  public static void d(DownloadInfo paramDownloadInfo)
  {
    bflp.b("AppCenterReporter", ">tryInitMonitorTask info:" + paramDownloadInfo);
    if (paramDownloadInfo == null) {
      return;
    }
    MonitorTask localMonitorTask = ReplaceMonitor.get().getTask(paramDownloadInfo.jdField_b_of_type_JavaLangString);
    bflp.b("AppCenterReporter", ">tryInitMonitorTask info=" + paramDownloadInfo);
    if (localMonitorTask == null) {}
    for (paramDownloadInfo = a(paramDownloadInfo);; paramDownloadInfo = localMonitorTask)
    {
      ReplaceMonitor.get().addTask(paramDownloadInfo);
      return;
      if (TextUtils.isEmpty(localMonitorTask.filePath)) {
        localMonitorTask.filePath = paramDownloadInfo.l;
      }
      bflp.b("AppCenterReporter", ">tryInitMonitorTask 已有task2:" + localMonitorTask);
    }
  }
  
  public static void e(DownloadInfo paramDownloadInfo)
  {
    bflp.b("AppCenterReporter", ">downloadSuccCheck info:" + paramDownloadInfo);
    if (paramDownloadInfo == null) {
      return;
    }
    MonitorTask localMonitorTask2 = ReplaceMonitor.get().getTask(paramDownloadInfo.jdField_b_of_type_JavaLangString);
    MonitorTask localMonitorTask1;
    if (localMonitorTask2 == null)
    {
      localMonitorTask1 = a(paramDownloadInfo);
      ReplaceMonitor.get().addTask(localMonitorTask1);
    }
    for (;;)
    {
      bflp.b("AppCenterReporter", ">downloadSuccCheck task:" + localMonitorTask1);
      if (localMonitorTask1 == null) {
        break;
      }
      ReplaceMonitor.get().execSync(localMonitorTask1, MonitorStep.DOWNLOADING);
      return;
      localMonitorTask1 = localMonitorTask2;
      if (TextUtils.isEmpty(localMonitorTask2.filePath))
      {
        localMonitorTask2.filePath = paramDownloadInfo.l;
        localMonitorTask1 = localMonitorTask2;
      }
    }
  }
  
  public static void f(DownloadInfo paramDownloadInfo)
  {
    bflp.b("AppCenterReporter", ">deleteCheck info:" + paramDownloadInfo);
    if (paramDownloadInfo == null) {}
    do
    {
      return;
      paramDownloadInfo = ReplaceMonitor.get().getTask(paramDownloadInfo.jdField_b_of_type_JavaLangString);
    } while (paramDownloadInfo == null);
    ReplaceMonitor.get().deleteTask(paramDownloadInfo);
  }
  
  public static void g(DownloadInfo paramDownloadInfo)
  {
    bflp.b("AppCenterReporter", ">installStartCheck ,info:" + paramDownloadInfo);
    if (paramDownloadInfo == null) {
      return;
    }
    MonitorTask localMonitorTask2 = ReplaceMonitor.get().getTask(paramDownloadInfo.jdField_b_of_type_JavaLangString);
    MonitorTask localMonitorTask1;
    if (localMonitorTask2 == null)
    {
      localMonitorTask1 = a(paramDownloadInfo);
      ReplaceMonitor.get().addTask(localMonitorTask1);
    }
    for (;;)
    {
      bflp.b("AppCenterReporter", ">installStartCheck task:" + localMonitorTask1);
      if (localMonitorTask1 == null) {
        break;
      }
      ReplaceMonitor.get().execSync(localMonitorTask1, MonitorStep.BEFORE_INSTALL);
      return;
      localMonitorTask1 = localMonitorTask2;
      if (TextUtils.isEmpty(localMonitorTask2.filePath))
      {
        localMonitorTask2.filePath = paramDownloadInfo.l;
        localMonitorTask1 = localMonitorTask2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bflg
 * JD-Core Version:    0.7.0.1
 */