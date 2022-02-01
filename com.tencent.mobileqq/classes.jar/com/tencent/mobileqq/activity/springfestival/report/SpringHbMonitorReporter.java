package com.tencent.mobileqq.activity.springfestival.report;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.avgame.gamelogic.gameres.CJPreloadMonitorReporter;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.qwallet.utils.QWalletTools;
import com.tencent.mobileqq.activity.springfestival.Utils;
import com.tencent.mobileqq.activity.springfestival.config.SpringFestivalRedpacketConfigManager;
import com.tencent.mobileqq.activity.springfestival.entry.model.EntryConfigBean;
import com.tencent.mobileqq.activity.springfestival.entry.model.HtmlOfflineCheckConfig;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qwallet.preload.IPreloadModule;
import com.tencent.mobileqq.qwallet.preload.IPreloadResource;
import com.tencent.mobileqq.qwallet.preload.IPreloadService;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import eipc.EIPCResult;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class SpringHbMonitorReporter
{
  public static int a(int paramInt)
  {
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (localObject != null)
    {
      localObject = ((QQAppInterface)localObject).getCurrentUin();
      return a("conf_taskid_" + paramInt + "_" + (String)localObject, 0);
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
      QLog.e("shua2021report_SpringHbMonitorReporter", 1, "[getValueFromSP] fail.", paramString);
    }
    return paramInt;
  }
  
  private static String a()
  {
    Date localDate = new Date(NetConnInfoCenter.getServerTimeMillis());
    return String.format("%s", new Object[] { new SimpleDateFormat("yyyyMMdd", Locale.getDefault()).format(localDate) });
  }
  
  public static String a(int paramInt)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (localQQAppInterface != null)
    {
      String str = localQQAppInterface.getCurrentUin();
      return c(localQQAppInterface, "conf_content_md5" + paramInt + "_" + str);
    }
    return "";
  }
  
  private static String a(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    return String.format("%s_%s_%s_%s_%s", new Object[] { "shua2021_", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(paramInt3) });
  }
  
  private static String a(AppInterface paramAppInterface)
  {
    try
    {
      paramAppInterface = c(paramAppInterface, "res_cover_tag" + paramAppInterface.getCurrentAccountUin());
      return paramAppInterface;
    }
    catch (Exception paramAppInterface)
    {
      QLog.e("shua2021report_SpringHbMonitorReporter", 1, "[getResCoverStrFromSP] fail.", paramAppInterface);
    }
    return null;
  }
  
  private static String a(AppInterface paramAppInterface, int paramInt)
  {
    try
    {
      paramAppInterface = c(paramAppInterface, "res_hit_tag" + paramAppInterface.getCurrentAccountUin() + "_" + paramInt);
      return paramAppInterface;
    }
    catch (Exception paramAppInterface)
    {
      QLog.e("shua2021report_SpringHbMonitorReporter", 1, "[getHitReportTagFromSP] fail.", paramAppInterface);
    }
    return null;
  }
  
  private static String a(boolean paramBoolean, int paramInt)
  {
    return String.format("%s_%s_%s", new Object[] { "shua2021_", Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
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
      a("conf_taskid_" + paramInt1 + "_" + (String)localObject, paramInt2);
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
      QLog.e("shua2021report_SpringHbMonitorReporter", 1, "configReport: " + paramVarArgs);
    }
  }
  
  private static void a(int paramInt, AppInterface paramAppInterface)
  {
    if (paramAppInterface == null) {}
    Object localObject;
    String str;
    do
    {
      do
      {
        return;
      } while ((paramInt != 1) && (paramInt != 2));
      localObject = a(paramAppInterface, paramInt);
      str = a();
      if (QLog.isColorLevel()) {
        QLog.i("shua2021report_SpringHbMonitorReporter", 2, String.format("[reportResHitInner] lastTag=%s curTag=%s hitAction=%s", new Object[] { localObject, str, Integer.valueOf(paramInt) }));
      }
      if (!TextUtils.equals((CharSequence)localObject, str)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("shua2021report_SpringHbMonitorReporter", 2, "[reportResHitInner] no need to report.");
    return;
    if (paramInt == 1) {
      a(true);
    }
    for (;;)
    {
      a(paramAppInterface, paramInt, str);
      return;
      if (paramInt != 2) {
        break;
      }
      localObject = b(BaseApplicationImpl.sApplication.getRuntime());
      if (localObject != null) {
        ThreadManagerV2.executeOnFileThread(new SpringHbMonitorReporter.1((SpringHbMonitorReporter.OfflineReportInfo)localObject));
      }
    }
  }
  
  public static void a(int paramInt, String paramString)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (localQQAppInterface != null)
    {
      String str = localQQAppInterface.getCurrentUin();
      c(localQQAppInterface, "conf_content_md5" + paramInt + "_" + str, paramString);
    }
  }
  
  public static void a(int paramInt1, String paramString, int paramInt2)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    ThreadManager.getSubThreadHandler().post(new SpringHbMonitorReporter.4(paramString, paramInt2, paramInt1));
  }
  
  public static void a(int paramInt, Throwable paramThrowable, String... paramVarArgs)
  {
    for (;;)
    {
      Object localObject;
      int j;
      try
      {
        localObject = ((SpringFestivalRedpacketConfigManager)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(QQManagerFactory.SPRING_FESTIVAL_RED_PACKET_MANAGER)).b();
        int i;
        if (localObject == null)
        {
          i = 0;
          break label340;
          if (QLog.isColorLevel()) {
            QLog.i("shua2021report_SpringHbMonitorReporter", 2, String.format("[reportExCatch] pos=[%d] ver=%d taskId=%d e.msg=%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(j), paramThrowable.getMessage() }));
          }
          localObject = new HashMap();
          ((Map)localObject).put("ext1", "" + paramInt);
          ((Map)localObject).put("ext2", "" + j);
          ((Map)localObject).put("ext3", "" + i);
          ((Map)localObject).put("ext4", "" + paramThrowable.getMessage());
          if ((paramVarArgs == null) || (paramVarArgs.length <= 0)) {
            continue;
          }
          paramThrowable = new StringBuilder();
          i = paramVarArgs.length;
          paramInt = 0;
          if (paramInt < i)
          {
            paramThrowable.append(paramVarArgs[paramInt]).append(";");
            paramInt += 1;
            continue;
          }
        }
        else
        {
          i = ((EntryConfigBean)localObject).version;
          break label340;
          j = ((EntryConfigBean)localObject).taskId;
          continue;
        }
        ((Map)localObject).put("ext5", "" + paramThrowable.toString());
        SpringHbReporter.a(ReportConstant.Event.q, 0, 0, (Map)localObject, "excp", false);
        return;
      }
      catch (Exception paramThrowable)
      {
        QLog.e("shua2021report_SpringHbMonitorReporter", 1, "[reportExCatch] fail.", paramThrowable);
        return;
      }
      label340:
      if (localObject == null) {
        j = 0;
      }
    }
  }
  
  public static void a(AppInterface paramAppInterface, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean, String paramString)
  {
    if (paramInt4 == 0) {}
    try
    {
      if (!QLog.isColorLevel()) {
        return;
      }
      QLog.i("shua2021report_SpringHbMonitorReporter", 2, "[reportConfigCoverageDaily] taskid == 0");
      return;
    }
    catch (Exception paramAppInterface)
    {
      QLog.e("shua2021report_SpringHbMonitorReporter", 1, "[reportConfigCoverageDaily] fail.", paramAppInterface);
      return;
    }
    String str = c(paramAppInterface);
    paramString = a(paramInt3, paramInt5, paramString, paramInt2);
    if (QLog.isColorLevel()) {
      QLog.i("shua2021report_SpringHbMonitorReporter", 2, "[reportConfigCoverageDaily] currentCfgTags == " + paramString + " cfgTags: " + str);
    }
    if (a(str, paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.i("shua2021report_SpringHbMonitorReporter", 2, "[reportConfigCoverageDaily] no need to report " + paramInt3);
      }
    }
    else
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("ext1", "" + paramInt3);
      localHashMap.put("ext2", "" + paramInt4);
      localHashMap.put("ext3", "" + paramInt5);
      localHashMap.put("ext4", "" + paramInt2);
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
  
  private static void a(AppInterface paramAppInterface, int paramInt, String paramString)
  {
    try
    {
      c(paramAppInterface, "res_hit_tag" + paramAppInterface.getCurrentAccountUin() + "_" + paramInt, paramString);
      return;
    }
    catch (Exception paramAppInterface)
    {
      QLog.e("shua2021report_SpringHbMonitorReporter", 1, "saveHitReportTagToSp fail.", paramAppInterface);
    }
  }
  
  private static void a(AppInterface paramAppInterface, String paramString)
  {
    try
    {
      c(paramAppInterface, "res_cover_tag" + paramAppInterface.getCurrentAccountUin(), paramString);
      return;
    }
    catch (Exception paramAppInterface)
    {
      QLog.e("shua2021report_SpringHbMonitorReporter", 1, "saveConfigCoverageToSP fail.", paramAppInterface);
    }
  }
  
  public static void a(SpringHbReportManager.ReportInfo paramReportInfo)
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((paramReportInfo == null) || ((localObject instanceof QQAppInterface))) {}
    do
    {
      return;
      localObject = (QQAppInterface)localObject;
    } while ((!"sy.zhc.ym".equals(paramReportInfo.eventName)) || (paramReportInfo.action != 0));
    System.currentTimeMillis();
  }
  
  public static void a(IPreloadModule paramIPreloadModule, int paramInt1, String paramString, int paramInt2)
  {
    if ((paramIPreloadModule == null) || (TextUtils.isEmpty(paramIPreloadModule.getName()))) {
      return;
    }
    String str2;
    String str3;
    if (paramIPreloadModule.getName().equals("2021_shuayishua"))
    {
      if (QLog.isColorLevel()) {
        QLog.i("shua2021report_SpringHbMonitorReporter", 2, "[reportResPreload] result=" + paramInt1 + ",url=" + paramString);
      }
      String str1 = QWalletTools.c(paramString);
      str2 = a(719) + "";
      str3 = c(719) + "";
      if (!TextUtils.isEmpty(str1))
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("ext1", str1);
        localHashMap.put("ext2", str2);
        localHashMap.put("ext3", str3);
        localHashMap.put("ext4", paramInt2 + "");
        SpringHbReporter.a(ReportConstant.Event.jdField_a_of_type_JavaLangString, 2, paramInt1, localHashMap, ReportConstant.Res.a(2));
      }
      if (paramInt1 != 0) {
        break label243;
      }
      a();
    }
    for (;;)
    {
      CJPreloadMonitorReporter.a(paramIPreloadModule, paramInt1, paramString, paramInt2);
      return;
      label243:
      if (paramInt2 == 404) {
        a(paramString, 1, true, str2, str3);
      }
    }
  }
  
  private static void a(String paramString, int paramInt)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("shua2021report_SpringHbMonitorReporter", 2, String.format("[saveIntValueToSP] key=%s value=%s", new Object[] { paramString, Integer.valueOf(paramInt) }));
      }
      BaseApplicationImpl.sApplication.getSharedPreferences("spring_hb_report", 0).edit().putInt(paramString, paramInt).apply();
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("shua2021report_SpringHbMonitorReporter", 1, "[saveIntValueToSP] fail.", paramString);
    }
  }
  
  public static void a(String paramString, int paramInt1, int paramInt2)
  {
    ThreadManagerV2.excute(new SpringHbMonitorReporter.2(paramString, paramInt1, paramInt2), 16, null, true);
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
            QLog.i("shua2021report_SpringHbMonitorReporter", 2, String.format("[reportOfflinePakcageCoverage] lastTag=%s curTag=%s isFromHit=%s", new Object[] { localObject3, localObject2, Boolean.valueOf(paramBoolean) }));
          }
          if (!TextUtils.equals((CharSequence)localObject3, (CharSequence)localObject2)) {
            break label335;
          }
          if (!QLog.isColorLevel()) {
            break label472;
          }
          QLog.i("shua2021report_SpringHbMonitorReporter", 2, "[reportOfflinePakcageCoverage] no need to report.");
          return;
        }
      }
      catch (Throwable paramString)
      {
        QLog.e("shua2021report_SpringHbMonitorReporter", 1, "reportOfflinePakcageCoverage: " + paramString);
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
  
  public static void a(String paramString1, int paramInt, boolean paramBoolean, String paramString2, String paramString3)
  {
    if (paramBoolean)
    {
      ThreadManager.getSubThreadHandler().post(new SpringHbMonitorReporter.5(paramString1, paramString2, paramString3, paramInt));
      CJPreloadMonitorReporter.a(paramString1, paramInt, paramBoolean);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("ext1", paramString1);
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    localHashMap.put("ext2", paramString1);
    paramString1 = paramString3;
    if (paramString3 == null) {
      paramString1 = "";
    }
    localHashMap.put("ext3", paramString1);
    SpringHbReporter.a(ReportConstant.Event.jdField_a_of_type_JavaLangString, 4, paramInt, localHashMap, ReportConstant.Res.a(4));
  }
  
  public static void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("shua2021report_SpringHbMonitorReporter", 2, "[checkResCover] begin, isFromHitReport=" + paramBoolean);
    }
    ThreadManagerV2.executeOnFileThread(new SpringHbMonitorReporter.3(paramBoolean));
  }
  
  public static void a(boolean paramBoolean1, int paramInt, AppInterface paramAppInterface, boolean paramBoolean2)
  {
    Object localObject1;
    if (paramBoolean2)
    {
      localObject1 = new HashMap();
      ((Map)localObject1).put("ext1", paramInt + "");
      ((Map)localObject1).put("ext2", a(719) + "");
      ((Map)localObject1).put("ext3", c(719) + "");
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
      localObject1 = a(paramBoolean1, c(719));
      if (QLog.isColorLevel()) {
        QLog.i("shua2021report_SpringHbMonitorReporter", 2, String.format("[reportResCover] lastTag=%s curTag=%s isFromHit=%s", new Object[] { localObject2, localObject1, Boolean.valueOf(paramBoolean2) }));
      }
      if (!TextUtils.equals((CharSequence)localObject2, (CharSequence)localObject1)) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.i("shua2021report_SpringHbMonitorReporter", 2, "[reportResCover] no need to report.");
      }
      return;
    }
    Object localObject2 = new HashMap();
    ((Map)localObject2).put("ext1", paramInt + "");
    ((Map)localObject2).put("ext2", a(719) + "");
    ((Map)localObject2).put("ext3", c(719) + "");
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
      localObject = ((IPreloadService)localObject).getModuleByName("2021_shuayishua");
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
  private static SpringHbMonitorReporter.OfflineReportInfo b(AppRuntime paramAppRuntime)
  {
    int m = 0;
    int i = 0;
    SpringHbMonitorReporter.OfflineReportInfo localOfflineReportInfo = new SpringHbMonitorReporter.OfflineReportInfo(null);
    Object localObject = "";
    int k = -1;
    label68:
    label75:
    int j;
    if ((paramAppRuntime instanceof QQAppInterface))
    {
      paramAppRuntime = (SpringFestivalRedpacketConfigManager)((QQAppInterface)paramAppRuntime).getManager(QQManagerFactory.SPRING_FESTIVAL_RED_PACKET_MANAGER);
      if (paramAppRuntime == null) {
        break label266;
      }
      localObject = paramAppRuntime.a();
      if (localObject == null)
      {
        paramAppRuntime = null;
        if (paramAppRuntime == null) {
          break label116;
        }
        paramAppRuntime = paramAppRuntime.bids;
        if (localObject != null) {
          break label122;
        }
        i = 0;
        if (localObject != null) {
          break label131;
        }
        j = 0;
      }
    }
    for (;;)
    {
      label82:
      localObject = paramAppRuntime;
      for (;;)
      {
        localOfflineReportInfo.jdField_a_of_type_JavaLangString = ((String)localObject);
        localOfflineReportInfo.b = j;
        localOfflineReportInfo.jdField_a_of_type_Int = i;
        return localOfflineReportInfo;
        paramAppRuntime = ((EntryConfigBean)localObject).htmlOfflineCheckConfig;
        break;
        label116:
        paramAppRuntime = "";
        break label68;
        label122:
        i = ((EntryConfigBean)localObject).taskId;
        break label75;
        label131:
        j = ((EntryConfigBean)localObject).version;
        break label82;
        EIPCResult localEIPCResult = QIPCClientHelper.getInstance().getClient().callServer("SpringHbIPCModule", "GetHtmlOffline", null);
        paramAppRuntime = (AppRuntime)localObject;
        if (localEIPCResult != null)
        {
          paramAppRuntime = (AppRuntime)localObject;
          if (localEIPCResult.data != null) {
            paramAppRuntime = localEIPCResult.data.getString("bids");
          }
        }
        localEIPCResult = QIPCClientHelper.getInstance().getClient().callServer("SpringHbIPCModule", "GetCfgInfo", null);
        i = m;
        j = k;
        localObject = paramAppRuntime;
        if (localEIPCResult != null)
        {
          i = m;
          j = k;
          localObject = paramAppRuntime;
          if (localEIPCResult.data != null)
          {
            i = localEIPCResult.data.getInt("task_id");
            j = localEIPCResult.data.getInt("cfg_version");
            localObject = paramAppRuntime;
          }
        }
      }
      label266:
      j = -1;
      paramAppRuntime = "";
    }
  }
  
  private static String b(AppInterface paramAppInterface)
  {
    try
    {
      paramAppInterface = c(paramAppInterface, "offline_cover_tag" + paramAppInterface.getCurrentAccountUin());
      return paramAppInterface;
    }
    catch (Exception paramAppInterface)
    {
      QLog.e("shua2021report_SpringHbMonitorReporter", 1, "[getResCoverStrFromSP] fail.", paramAppInterface);
    }
    return null;
  }
  
  private static String b(AppInterface paramAppInterface, String paramString)
  {
    try
    {
      paramAppInterface = c(paramAppInterface, "offline_report_tag" + paramAppInterface.getCurrentAccountUin() + "_" + paramString);
      return paramAppInterface;
    }
    catch (Exception paramAppInterface)
    {
      QLog.e("shua2021report_SpringHbMonitorReporter", 1, "[getOfflineTagFromSP] fail.", paramAppInterface);
    }
    return null;
  }
  
  private static String b(boolean paramBoolean, String paramString)
  {
    return String.format("%s_%s_%s", new Object[] { "shua2021_", Boolean.valueOf(paramBoolean), paramString });
  }
  
  private static void b(AppInterface paramAppInterface, String paramString)
  {
    try
    {
      c(paramAppInterface, "offline_cover_tag" + paramAppInterface.getCurrentAccountUin(), paramString);
      return;
    }
    catch (Exception paramAppInterface)
    {
      QLog.e("shua2021report_SpringHbMonitorReporter", 1, "saveConfigCoverageToSP fail.", paramAppInterface);
    }
  }
  
  private static void b(AppInterface paramAppInterface, String paramString1, String paramString2)
  {
    try
    {
      c(paramAppInterface, "offline_report_tag" + paramAppInterface.getCurrentAccountUin() + "_" + paramString2, paramString1);
      return;
    }
    catch (Exception paramAppInterface)
    {
      QLog.e("shua2021report_SpringHbMonitorReporter", 1, "saveOfflineTagToSP fail.", paramAppInterface);
    }
  }
  
  public static void b(String paramString, int paramInt1, int paramInt2)
  {
    a(paramString, paramInt1, paramInt2, false);
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
      paramAppInterface = c(paramAppInterface, "cfg_cover_tag" + paramAppInterface.getCurrentAccountUin());
      return paramAppInterface;
    }
    catch (Exception paramAppInterface)
    {
      QLog.e("shua2021report_SpringHbMonitorReporter", 1, "[getResCoverStrFromSP] fail.", paramAppInterface);
    }
    return null;
  }
  
  private static String c(AppInterface paramAppInterface, String paramString)
  {
    try
    {
      paramAppInterface = paramAppInterface.getApp().getSharedPreferences("spring_hb_report", 0).getString(paramString, "");
      return paramAppInterface;
    }
    catch (Exception paramAppInterface)
    {
      QLog.e("shua2021report_SpringHbMonitorReporter", 1, "[getValueFromSP] fail.", paramAppInterface);
    }
    return null;
  }
  
  private static void c(AppInterface paramAppInterface, String paramString)
  {
    try
    {
      c(paramAppInterface, "cfg_cover_tag" + paramAppInterface.getCurrentAccountUin(), paramString);
      return;
    }
    catch (Exception paramAppInterface)
    {
      QLog.e("shua2021report_SpringHbMonitorReporter", 1, "saveConfigCoverageToSP fail.", paramAppInterface);
    }
  }
  
  private static void c(AppInterface paramAppInterface, String paramString1, String paramString2)
  {
    try
    {
      paramAppInterface.getApp().getSharedPreferences("spring_hb_report", 0).edit().putString(paramString1, paramString2).apply();
      return;
    }
    catch (Exception paramAppInterface)
    {
      QLog.e("shua2021report_SpringHbMonitorReporter", 1, "[saveValueToSP] fail.", paramAppInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.report.SpringHbMonitorReporter
 * JD-Core Version:    0.7.0.1
 */