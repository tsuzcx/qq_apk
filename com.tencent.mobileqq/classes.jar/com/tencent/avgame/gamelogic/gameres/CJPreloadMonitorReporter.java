package com.tencent.avgame.gamelogic.gameres;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.qwallet.utils.QWalletTools;
import com.tencent.mobileqq.activity.springfestival.Utils;
import com.tencent.mobileqq.activity.springfestival.report.ReportConstant.ConfigConstant;
import com.tencent.mobileqq.activity.springfestival.report.ReportConstant.Event;
import com.tencent.mobileqq.activity.springfestival.report.ReportConstant.Res;
import com.tencent.mobileqq.activity.springfestival.report.SpringHbReporter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qwallet.preload.IPreloadModule;
import com.tencent.mobileqq.qwallet.preload.IPreloadResource;
import com.tencent.mobileqq.qwallet.preload.IPreloadService;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import eipc.EIPCResult;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class CJPreloadMonitorReporter
{
  public static int a(int paramInt)
  {
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (localObject != null)
    {
      localObject = ((QQAppInterface)localObject).getCurrentUin();
      return a("conf_taskid_cjpreload_" + paramInt + "_" + (String)localObject, 0);
    }
    return 0;
  }
  
  private static int a(String paramString, int paramInt)
  {
    try
    {
      int i = BaseApplicationImpl.sApplication.getSharedPreferences("spring_hb_report", 0).getInt(paramString, paramInt);
      return i;
    }
    catch (Exception paramString)
    {
      QLog.e("CJPreloadMonitorReporter", 1, "[getValueFromSP] fail.", paramString);
    }
    return paramInt;
  }
  
  public static String a(int paramInt)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (localQQAppInterface != null)
    {
      String str = localQQAppInterface.getCurrentUin();
      return c(localQQAppInterface, "conf_content_md5_cjpreload_" + paramInt + "_" + str);
    }
    return "";
  }
  
  private static String a(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    return String.format("%s_%s_%s_%s_%s", new Object[] { "shua2021_cjpreload_", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(paramInt3) });
  }
  
  private static String a(AppInterface paramAppInterface)
  {
    try
    {
      paramAppInterface = c(paramAppInterface, "res_cover_tag_cjpreload_" + paramAppInterface.getCurrentAccountUin());
      return paramAppInterface;
    }
    catch (Exception paramAppInterface)
    {
      QLog.e("CJPreloadMonitorReporter", 1, "[getResCoverStrFromSP] fail.", paramAppInterface);
    }
    return null;
  }
  
  private static String a(boolean paramBoolean, int paramInt)
  {
    return String.format("%s_%s_%s", new Object[] { "shua2021_cjpreload_", Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
  }
  
  public static void a()
  {
    a(false);
  }
  
  public static void a(int paramInt1, int paramInt2)
  {
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (localObject != null)
    {
      localObject = ((QQAppInterface)localObject).getCurrentUin();
      a("conf_taskid_cjpreload_" + paramInt1 + "_" + (String)localObject, paramInt2);
    }
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean, String... paramVarArgs)
  {
    try
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("ext1", "" + paramInt3);
      localHashMap.put("ext2", "" + paramInt4);
      localHashMap.put("ext3", "" + paramInt5);
      if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
        localHashMap.put("ext4", "" + paramVarArgs[0]);
      }
      SpringHbReporter.a(ReportConstant.Event.b, paramInt1, paramInt2, localHashMap, ReportConstant.ConfigConstant.a(paramInt1), paramBoolean);
      return;
    }
    catch (Throwable paramVarArgs)
    {
      QLog.e("CJPreloadMonitorReporter", 1, "configReport: " + paramVarArgs);
    }
  }
  
  public static void a(int paramInt, String paramString)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (localQQAppInterface != null)
    {
      String str = localQQAppInterface.getCurrentUin();
      c(localQQAppInterface, "conf_content_md5_cjpreload_" + paramInt + "_" + str, paramString);
    }
  }
  
  public static void a(int paramInt1, String paramString, int paramInt2)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    ThreadManager.getSubThreadHandler().post(new CJPreloadMonitorReporter.4(paramString, paramInt2, paramInt1));
  }
  
  public static void a(AppInterface paramAppInterface, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean, String paramString)
  {
    if (paramInt4 == 0) {}
    try
    {
      if (!QLog.isColorLevel()) {
        return;
      }
      QLog.i("CJPreloadMonitorReporter", 2, "[reportConfigCoverageDaily] taskid == 0");
      return;
    }
    catch (Exception paramAppInterface)
    {
      QLog.e("CJPreloadMonitorReporter", 1, "[reportConfigCoverageDaily] fail.", paramAppInterface);
      return;
    }
    String str = c(paramAppInterface);
    paramString = a(paramInt3, paramInt5, paramString, paramInt2);
    if (QLog.isColorLevel()) {
      QLog.i("CJPreloadMonitorReporter", 2, "[reportConfigCoverageDaily] currentCfgTags == " + paramString + " cfgTags: " + str);
    }
    if (a(str, paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.i("CJPreloadMonitorReporter", 2, "[reportConfigCoverageDaily] no need to report " + paramInt3);
      }
    }
    else
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("ext1", "" + paramInt3);
      localHashMap.put("ext2", "" + paramInt4);
      localHashMap.put("ext3", "" + paramInt5);
      SpringHbReporter.a(ReportConstant.Event.b, paramInt1, paramInt2, localHashMap, ReportConstant.ConfigConstant.a(paramInt1), paramBoolean);
      if (StringUtil.a(str)) {}
      for (;;)
      {
        c(paramAppInterface, paramString);
        return;
        paramString = str + "|" + paramString;
      }
    }
  }
  
  private static void a(AppInterface paramAppInterface, String paramString)
  {
    try
    {
      c(paramAppInterface, "res_cover_tag_cjpreload_" + paramAppInterface.getCurrentAccountUin(), paramString);
      return;
    }
    catch (Exception paramAppInterface)
    {
      QLog.e("CJPreloadMonitorReporter", 1, "saveConfigCoverageToSP fail.", paramAppInterface);
    }
  }
  
  public static void a(IPreloadModule paramIPreloadModule, int paramInt1, String paramString, int paramInt2)
  {
    if ((paramIPreloadModule == null) || (TextUtils.isEmpty(paramIPreloadModule.getName()))) {}
    do
    {
      do
      {
        return;
      } while (!paramIPreloadModule.getName().equals("2021_cjavgame"));
      if (QLog.isColorLevel()) {
        QLog.i("CJPreloadMonitorReporter", 2, "[reportResPreload] result=" + paramInt1 + ",url=" + paramString);
      }
      paramIPreloadModule = QWalletTools.c(paramString);
      if (!TextUtils.isEmpty(paramIPreloadModule))
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("ext1", paramIPreloadModule);
        localHashMap.put("ext2", a(721) + "");
        localHashMap.put("ext3", c(721) + "");
        localHashMap.put("ext4", paramInt2 + "");
        SpringHbReporter.a(ReportConstant.Event.jdField_a_of_type_JavaLangString, 2, paramInt1, localHashMap, ReportConstant.Res.a(2));
      }
      if (paramInt1 == 0)
      {
        a();
        return;
      }
    } while (paramInt2 != 404);
    a(paramString, 1, true);
  }
  
  private static void a(String paramString, int paramInt)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("CJPreloadMonitorReporter", 2, String.format("[saveIntValueToSP] key=%s value=%s", new Object[] { paramString, Integer.valueOf(paramInt) }));
      }
      BaseApplicationImpl.sApplication.getSharedPreferences("spring_hb_report", 0).edit().putInt(paramString, paramInt).apply();
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("CJPreloadMonitorReporter", 1, "[saveIntValueToSP] fail.", paramString);
    }
  }
  
  public static void a(String paramString, int paramInt1, int paramInt2)
  {
    a(paramString, paramInt1, paramInt2, false);
  }
  
  public static void a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    for (;;)
    {
      Object localObject1;
      Object localObject2;
      try
      {
        if (StringUtil.a(paramString)) {
          break label472;
        }
        new StringBuilder().append(BaseApplicationImpl.sApplication.getRuntime().getLongAccountUin()).append("").toString();
        localObject1 = paramString.split("\\|");
        if ((localObject1 == null) || (localObject1.length <= 0)) {
          break label472;
        }
        int j = localObject1.length;
        i = 0;
        if (i >= j) {
          break label466;
        }
        if (Utils.a(localObject1[i])) {
          break label473;
        }
        bool = false;
        localObject1 = QWalletTools.a();
        if (localObject1 == null) {
          return;
        }
        if (paramBoolean)
        {
          localObject2 = new HashMap();
          ((Map)localObject2).put("ext1", "" + paramString);
          ((Map)localObject2).put("ext2", "" + paramInt1);
          ((Map)localObject2).put("ext3", "" + paramInt2);
          localObject3 = ReportConstant.Event.f;
          if (bool)
          {
            i = 0;
            SpringHbReporter.a((String)localObject3, 2, i, (Map)localObject2, "", false);
          }
        }
        else
        {
          localObject3 = b((AppInterface)localObject1);
          localObject2 = a(bool, paramInt2);
          if (QLog.isColorLevel()) {
            QLog.i("CJPreloadMonitorReporter", 2, String.format("[reportOfflinePakcageCoverage] lastTag=%s curTag=%s isFromHit=%s", new Object[] { localObject3, localObject2, Boolean.valueOf(paramBoolean) }));
          }
          if (!TextUtils.equals((CharSequence)localObject3, (CharSequence)localObject2)) {
            break label335;
          }
          if (!QLog.isColorLevel()) {
            break label472;
          }
          QLog.i("CJPreloadMonitorReporter", 2, "[reportOfflinePakcageCoverage] no need to report.");
          return;
        }
      }
      catch (Throwable paramString)
      {
        QLog.e("CJPreloadMonitorReporter", 1, "reportOfflinePakcageCoverage: " + paramString);
        return;
      }
      int i = 1;
      continue;
      label335:
      Object localObject3 = new HashMap();
      ((Map)localObject3).put("ext1", "" + paramString);
      ((Map)localObject3).put("ext2", "" + paramInt1);
      ((Map)localObject3).put("ext3", "" + paramInt2);
      paramString = ReportConstant.Event.c;
      if (bool) {}
      for (paramInt1 = 0;; paramInt1 = 1)
      {
        SpringHbReporter.a(paramString, 1, paramInt1, (Map)localObject3, "", true);
        b((AppInterface)localObject1, (String)localObject2);
        return;
      }
      label466:
      boolean bool = true;
      continue;
      label472:
      return;
      label473:
      i += 1;
    }
  }
  
  public static void a(String paramString, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      ThreadManager.getSubThreadHandler().post(new CJPreloadMonitorReporter.5(paramString, paramInt));
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("ext1", paramString);
    SpringHbReporter.a(ReportConstant.Event.jdField_a_of_type_JavaLangString, 4, paramInt, localHashMap, ReportConstant.Res.a(4));
  }
  
  public static void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CJPreloadMonitorReporter", 2, "[checkResCover] begin, isFromHitReport=" + paramBoolean);
    }
    ThreadManagerV2.executeOnFileThread(new CJPreloadMonitorReporter.3(paramBoolean));
  }
  
  public static void a(boolean paramBoolean1, int paramInt, AppInterface paramAppInterface, boolean paramBoolean2)
  {
    Object localObject1;
    if (paramBoolean2)
    {
      localObject1 = new HashMap();
      ((Map)localObject1).put("ext1", paramInt + "");
      ((Map)localObject1).put("ext2", a(721) + "");
      ((Map)localObject1).put("ext3", c(721) + "");
      localObject2 = ReportConstant.Event.f;
      if (!paramBoolean1) {
        break label218;
      }
    }
    label218:
    for (int i = 0;; i = 1)
    {
      SpringHbReporter.a((String)localObject2, 1, i, (Map)localObject1, "", false);
      localObject2 = a(paramAppInterface);
      localObject1 = a(paramBoolean1, c(721));
      if (QLog.isColorLevel()) {
        QLog.i("CJPreloadMonitorReporter", 2, String.format("[reportResCover] lastTag=%s curTag=%s isFromHit=%s", new Object[] { localObject2, localObject1, Boolean.valueOf(paramBoolean2) }));
      }
      if (!TextUtils.equals((CharSequence)localObject2, (CharSequence)localObject1)) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.i("CJPreloadMonitorReporter", 2, "[reportResCover] no need to report.");
      }
      return;
    }
    Object localObject2 = new HashMap();
    ((Map)localObject2).put("ext1", paramInt + "");
    ((Map)localObject2).put("ext2", a(721) + "");
    ((Map)localObject2).put("ext3", c(721) + "");
    String str = ReportConstant.Event.jdField_a_of_type_JavaLangString;
    if (paramBoolean1) {}
    for (paramInt = 0;; paramInt = 1)
    {
      SpringHbReporter.a(str, 1, paramInt, (Map)localObject2, ReportConstant.Res.a(1), true);
      a(paramAppInterface, (String)localObject1);
      return;
    }
  }
  
  public static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    Object localObject = QWalletTools.a();
    if (localObject == null) {
      return false;
    }
    localObject = (IPreloadService)((QQAppInterface)localObject).getRuntimeService(IPreloadService.class, "");
    if (localObject != null)
    {
      localObject = ((IPreloadService)localObject).getModuleByName("2021_cjavgame");
      if (localObject != null)
      {
        Iterator localIterator = ((IPreloadModule)localObject).getResApiList().iterator();
        while (localIterator.hasNext()) {
          if (TextUtils.equals(((IPreloadResource)localIterator.next()).getResDownloadUrl((IPreloadModule)localObject), paramString)) {
            return true;
          }
        }
      }
    }
    return false;
  }
  
  private static boolean a(String paramString1, String paramString2)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    if (StringUtil.a(paramString1)) {
      return bool2;
    }
    paramString1 = paramString1.split("\\|");
    int j = paramString1.length;
    int i = 0;
    for (;;)
    {
      bool2 = bool1;
      if (i >= j) {
        break;
      }
      if (paramString1[i].equals(paramString2)) {
        bool1 = true;
      }
      i += 1;
    }
  }
  
  @NonNull
  private static CJPreloadMonitorReporter.OfflineReportInfo b(AppRuntime paramAppRuntime)
  {
    CJPreloadMonitorReporter.OfflineReportInfo localOfflineReportInfo = new CJPreloadMonitorReporter.OfflineReportInfo(null);
    Object localObject = "";
    int j;
    int i;
    if ((paramAppRuntime instanceof QQAppInterface))
    {
      paramAppRuntime = (QQAppInterface)paramAppRuntime;
      j = 0;
      paramAppRuntime = "";
      i = -1;
    }
    for (;;)
    {
      localOfflineReportInfo.jdField_a_of_type_JavaLangString = paramAppRuntime;
      localOfflineReportInfo.b = i;
      localOfflineReportInfo.jdField_a_of_type_Int = j;
      return localOfflineReportInfo;
      EIPCResult localEIPCResult = QIPCClientHelper.getInstance().getClient().callServer("SpringHbIPCModule", "GetHtmlOffline", null);
      paramAppRuntime = (AppRuntime)localObject;
      if (localEIPCResult != null)
      {
        paramAppRuntime = (AppRuntime)localObject;
        if (localEIPCResult.data != null) {
          paramAppRuntime = localEIPCResult.data.getString("bids");
        }
      }
      localObject = QIPCClientHelper.getInstance().getClient().callServer("SpringHbIPCModule", "GetCfgInfo", null);
      if ((localObject != null) && (((EIPCResult)localObject).data != null))
      {
        j = ((EIPCResult)localObject).data.getInt("task_id");
        i = ((EIPCResult)localObject).data.getInt("cfg_version");
      }
      else
      {
        j = 0;
        i = -1;
      }
    }
  }
  
  private static String b(AppInterface paramAppInterface)
  {
    try
    {
      paramAppInterface = c(paramAppInterface, "offline_cover_tag_cjpreload_" + paramAppInterface.getCurrentAccountUin());
      return paramAppInterface;
    }
    catch (Exception paramAppInterface)
    {
      QLog.e("CJPreloadMonitorReporter", 1, "[getResCoverStrFromSP] fail.", paramAppInterface);
    }
    return null;
  }
  
  private static String b(AppInterface paramAppInterface, String paramString)
  {
    try
    {
      paramAppInterface = c(paramAppInterface, "offline_report_tag_cjpreload_" + paramAppInterface.getCurrentAccountUin() + "_" + paramString);
      return paramAppInterface;
    }
    catch (Exception paramAppInterface)
    {
      QLog.e("CJPreloadMonitorReporter", 1, "[getOfflineTagFromSP] fail.", paramAppInterface);
    }
    return null;
  }
  
  private static String b(boolean paramBoolean, String paramString)
  {
    return String.format("%s_%s_%s", new Object[] { "shua2021_cjpreload_", Boolean.valueOf(paramBoolean), paramString });
  }
  
  private static void b(AppInterface paramAppInterface, String paramString)
  {
    try
    {
      c(paramAppInterface, "offline_cover_tag_cjpreload_" + paramAppInterface.getCurrentAccountUin(), paramString);
      return;
    }
    catch (Exception paramAppInterface)
    {
      QLog.e("CJPreloadMonitorReporter", 1, "saveConfigCoverageToSP fail.", paramAppInterface);
    }
  }
  
  private static void b(AppInterface paramAppInterface, String paramString1, String paramString2)
  {
    try
    {
      c(paramAppInterface, "offline_report_tag_cjpreload_" + paramAppInterface.getCurrentAccountUin() + "_" + paramString2, paramString1);
      return;
    }
    catch (Exception paramAppInterface)
    {
      QLog.e("CJPreloadMonitorReporter", 1, "saveOfflineTagToSP fail.", paramAppInterface);
    }
  }
  
  private static int c(int paramInt)
  {
    QQAppInterface localQQAppInterface = QWalletTools.a();
    if (localQQAppInterface == null) {
      return 0;
    }
    return QConfigManager.a().a(paramInt, localQQAppInterface.getCurrentAccountUin());
  }
  
  private static String c(AppInterface paramAppInterface)
  {
    try
    {
      paramAppInterface = c(paramAppInterface, "cfg_cover_tag_cjpreload_" + paramAppInterface.getCurrentAccountUin());
      return paramAppInterface;
    }
    catch (Exception paramAppInterface)
    {
      QLog.e("CJPreloadMonitorReporter", 1, "[getResCoverStrFromSP] fail.", paramAppInterface);
    }
    return null;
  }
  
  private static String c(AppInterface paramAppInterface, String paramString)
  {
    try
    {
      paramAppInterface = paramAppInterface.getApp().getSharedPreferences("spring_hb_report_cjpreload", 0).getString(paramString, "");
      return paramAppInterface;
    }
    catch (Exception paramAppInterface)
    {
      QLog.e("CJPreloadMonitorReporter", 1, "[getValueFromSP] fail.", paramAppInterface);
    }
    return null;
  }
  
  private static void c(AppInterface paramAppInterface, String paramString)
  {
    try
    {
      c(paramAppInterface, "cfg_cover_tag_cjpreload_" + paramAppInterface.getCurrentAccountUin(), paramString);
      return;
    }
    catch (Exception paramAppInterface)
    {
      QLog.e("CJPreloadMonitorReporter", 1, "saveConfigCoverageToSP fail.", paramAppInterface);
    }
  }
  
  private static void c(AppInterface paramAppInterface, String paramString1, String paramString2)
  {
    try
    {
      paramAppInterface.getApp().getSharedPreferences("spring_hb_report_cjpreload", 0).edit().putString(paramString1, paramString2).apply();
      return;
    }
    catch (Exception paramAppInterface)
    {
      QLog.e("CJPreloadMonitorReporter", 1, "[saveValueToSP] fail.", paramAppInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.gameres.CJPreloadMonitorReporter
 * JD-Core Version:    0.7.0.1
 */