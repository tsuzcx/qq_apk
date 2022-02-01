package com.tencent.avgame.gamelogic.gameres;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.business.BaseQQAppInterface;
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
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.IQWalletApi;
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
    int i = 0;
    if (localObject != null)
    {
      localObject = ((QQAppInterface)localObject).getCurrentUin();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("conf_taskid_cjpreload_");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("_");
      localStringBuilder.append((String)localObject);
      i = a(localStringBuilder.toString(), 0);
    }
    return i;
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("conf_content_md5_cjpreload_");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("_");
      localStringBuilder.append(str);
      return c(localQQAppInterface, localStringBuilder.toString());
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("res_cover_tag_cjpreload_");
      localStringBuilder.append(paramAppInterface.getCurrentAccountUin());
      paramAppInterface = c(paramAppInterface, localStringBuilder.toString());
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("conf_taskid_cjpreload_");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("_");
      localStringBuilder.append((String)localObject);
      a(localStringBuilder.toString(), paramInt2);
    }
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean, String... paramVarArgs)
  {
    try
    {
      localObject = new HashMap();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(paramInt3);
      ((Map)localObject).put("ext1", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(paramInt4);
      ((Map)localObject).put("ext2", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(paramInt5);
      ((Map)localObject).put("ext3", localStringBuilder.toString());
      if ((paramVarArgs != null) && (paramVarArgs.length > 0))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(paramVarArgs[0]);
        ((Map)localObject).put("ext4", localStringBuilder.toString());
      }
      SpringHbReporter.a(ReportConstant.Event.b, paramInt1, paramInt2, (Map)localObject, ReportConstant.ConfigConstant.a(paramInt1), paramBoolean);
      return;
    }
    catch (Throwable paramVarArgs)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("configReport: ");
      ((StringBuilder)localObject).append(paramVarArgs);
      QLog.e("CJPreloadMonitorReporter", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  public static void a(int paramInt, String paramString)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (localQQAppInterface != null)
    {
      String str = localQQAppInterface.getCurrentUin();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("conf_content_md5_cjpreload_");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("_");
      localStringBuilder.append(str);
      c(localQQAppInterface, localStringBuilder.toString(), paramString);
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
        break label359;
      }
      QLog.i("CJPreloadMonitorReporter", 2, "[reportConfigCoverageDaily] taskid == 0");
      return;
    }
    catch (Exception paramAppInterface)
    {
      String str;
      Object localObject;
      StringBuilder localStringBuilder;
      QLog.e("CJPreloadMonitorReporter", 1, "[reportConfigCoverageDaily] fail.", paramAppInterface);
      return;
    }
    str = c(paramAppInterface);
    paramString = a(paramInt3, paramInt5, paramString, paramInt2);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[reportConfigCoverageDaily] currentCfgTags == ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" cfgTags: ");
      ((StringBuilder)localObject).append(str);
      QLog.i("CJPreloadMonitorReporter", 2, ((StringBuilder)localObject).toString());
    }
    if (a(str, paramString))
    {
      if (QLog.isColorLevel())
      {
        paramAppInterface = new StringBuilder();
        paramAppInterface.append("[reportConfigCoverageDaily] no need to report ");
        paramAppInterface.append(paramInt3);
        QLog.i("CJPreloadMonitorReporter", 2, paramAppInterface.toString());
      }
    }
    else
    {
      localObject = new HashMap();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(paramInt3);
      ((Map)localObject).put("ext1", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(paramInt4);
      ((Map)localObject).put("ext2", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(paramInt5);
      ((Map)localObject).put("ext3", localStringBuilder.toString());
      SpringHbReporter.a(ReportConstant.Event.b, paramInt1, paramInt2, (Map)localObject, ReportConstant.ConfigConstant.a(paramInt1), paramBoolean);
      if (StringUtil.a(str)) {
        break label361;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append("|");
      ((StringBuilder)localObject).append(paramString);
      paramString = ((StringBuilder)localObject).toString();
      break label361;
    }
    label359:
    label361:
    for (;;)
    {
      c(paramAppInterface, paramString);
      return;
      return;
      return;
    }
  }
  
  private static void a(AppInterface paramAppInterface, String paramString)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("res_cover_tag_cjpreload_");
      localStringBuilder.append(paramAppInterface.getCurrentAccountUin());
      c(paramAppInterface, localStringBuilder.toString(), paramString);
      return;
    }
    catch (Exception paramAppInterface)
    {
      QLog.e("CJPreloadMonitorReporter", 1, "saveConfigCoverageToSP fail.", paramAppInterface);
    }
  }
  
  public static void a(IPreloadModule paramIPreloadModule, int paramInt1, String paramString, int paramInt2)
  {
    if (paramIPreloadModule != null)
    {
      if (TextUtils.isEmpty(paramIPreloadModule.getName())) {
        return;
      }
      if (paramIPreloadModule.getName().equals("2021_cjavgame"))
      {
        if (QLog.isColorLevel())
        {
          paramIPreloadModule = new StringBuilder();
          paramIPreloadModule.append("[reportResPreload] result=");
          paramIPreloadModule.append(paramInt1);
          paramIPreloadModule.append(",url=");
          paramIPreloadModule.append(paramString);
          QLog.i("CJPreloadMonitorReporter", 2, paramIPreloadModule.toString());
        }
        Object localObject = ((IQWalletApi)QRoute.api(IQWalletApi.class)).getEncodeUrl(paramString);
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          paramIPreloadModule = new HashMap();
          paramIPreloadModule.put("ext1", localObject);
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(a(721));
          ((StringBuilder)localObject).append("");
          paramIPreloadModule.put("ext2", ((StringBuilder)localObject).toString());
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(c(721));
          ((StringBuilder)localObject).append("");
          paramIPreloadModule.put("ext3", ((StringBuilder)localObject).toString());
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(paramInt2);
          ((StringBuilder)localObject).append("");
          paramIPreloadModule.put("ext4", ((StringBuilder)localObject).toString());
          SpringHbReporter.a(ReportConstant.Event.jdField_a_of_type_JavaLangString, 2, paramInt1, paramIPreloadModule, ReportConstant.Res.a(2));
        }
        if (paramInt1 == 0)
        {
          a();
          return;
        }
        if (paramInt2 == 404) {
          a(paramString, 1, true);
        }
      }
    }
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
      try
      {
        if (!StringUtil.a(paramString))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(BaseApplicationImpl.sApplication.getRuntime().getLongAccountUin());
          ((StringBuilder)localObject1).append("");
          ((StringBuilder)localObject1).toString();
          localObject1 = paramString.split("\\|");
          if ((localObject1 != null) && (localObject1.length > 0))
          {
            int j = localObject1.length;
            i = 0;
            if (i >= j) {
              break label556;
            }
            if (Utils.a(localObject1[i])) {
              break label547;
            }
            bool = false;
            localObject1 = ((IQWalletApi)QRoute.api(IQWalletApi.class)).getQQAppInterface();
            if (localObject1 == null) {
              return;
            }
            if (paramBoolean)
            {
              localObject2 = new HashMap();
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("");
              ((StringBuilder)localObject3).append(paramString);
              ((Map)localObject2).put("ext1", ((StringBuilder)localObject3).toString());
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("");
              ((StringBuilder)localObject3).append(paramInt1);
              ((Map)localObject2).put("ext2", ((StringBuilder)localObject3).toString());
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("");
              ((StringBuilder)localObject3).append(paramInt2);
              ((Map)localObject2).put("ext3", ((StringBuilder)localObject3).toString());
              localObject3 = ReportConstant.Event.f;
              if (!bool) {
                break label562;
              }
              i = 0;
              SpringHbReporter.a((String)localObject3, 2, i, (Map)localObject2, "", false);
            }
            Object localObject3 = b((AppInterface)localObject1);
            Object localObject2 = a(bool, paramInt2);
            if (QLog.isColorLevel()) {
              QLog.i("CJPreloadMonitorReporter", 2, String.format("[reportOfflinePakcageCoverage] lastTag=%s curTag=%s isFromHit=%s", new Object[] { localObject3, localObject2, Boolean.valueOf(paramBoolean) }));
            }
            if (TextUtils.equals((CharSequence)localObject3, (CharSequence)localObject2))
            {
              if (!QLog.isColorLevel()) {
                break label568;
              }
              QLog.i("CJPreloadMonitorReporter", 2, "[reportOfflinePakcageCoverage] no need to report.");
              return;
            }
            localObject3 = new HashMap();
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("");
            localStringBuilder.append(paramString);
            ((Map)localObject3).put("ext1", localStringBuilder.toString());
            paramString = new StringBuilder();
            paramString.append("");
            paramString.append(paramInt1);
            ((Map)localObject3).put("ext2", paramString.toString());
            paramString = new StringBuilder();
            paramString.append("");
            paramString.append(paramInt2);
            ((Map)localObject3).put("ext3", paramString.toString());
            paramString = ReportConstant.Event.c;
            if (!bool) {
              break label569;
            }
            paramInt1 = 0;
            SpringHbReporter.a(paramString, 1, paramInt1, (Map)localObject3, "", true);
            b((AppInterface)localObject1, (String)localObject2);
            return;
          }
        }
      }
      catch (Throwable paramString)
      {
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("reportOfflinePakcageCoverage: ");
        ((StringBuilder)localObject1).append(paramString);
        QLog.e("CJPreloadMonitorReporter", 1, ((StringBuilder)localObject1).toString());
      }
      return;
      label547:
      i += 1;
      continue;
      label556:
      boolean bool = true;
      continue;
      label562:
      int i = 1;
      continue;
      label568:
      return;
      label569:
      paramInt1 = 1;
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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[checkResCover] begin, isFromHitReport=");
      localStringBuilder.append(paramBoolean);
      QLog.i("CJPreloadMonitorReporter", 2, localStringBuilder.toString());
    }
    ThreadManagerV2.executeOnFileThread(new CJPreloadMonitorReporter.3(paramBoolean));
  }
  
  public static void a(boolean paramBoolean1, int paramInt, AppInterface paramAppInterface, boolean paramBoolean2)
  {
    if (paramBoolean2)
    {
      localObject1 = new HashMap();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramInt);
      ((StringBuilder)localObject2).append("");
      ((Map)localObject1).put("ext1", ((StringBuilder)localObject2).toString());
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(a(721));
      ((StringBuilder)localObject2).append("");
      ((Map)localObject1).put("ext2", ((StringBuilder)localObject2).toString());
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(c(721));
      ((StringBuilder)localObject2).append("");
      ((Map)localObject1).put("ext3", ((StringBuilder)localObject2).toString());
      SpringHbReporter.a(ReportConstant.Event.f, 1, paramBoolean1 ^ true, (Map)localObject1, "", false);
    }
    Object localObject2 = a(paramAppInterface);
    Object localObject1 = a(paramBoolean1, c(721));
    if (QLog.isColorLevel()) {
      QLog.i("CJPreloadMonitorReporter", 2, String.format("[reportResCover] lastTag=%s curTag=%s isFromHit=%s", new Object[] { localObject2, localObject1, Boolean.valueOf(paramBoolean2) }));
    }
    if (TextUtils.equals((CharSequence)localObject2, (CharSequence)localObject1))
    {
      if (QLog.isColorLevel()) {
        QLog.i("CJPreloadMonitorReporter", 2, "[reportResCover] no need to report.");
      }
      return;
    }
    localObject2 = new HashMap();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append("");
    ((Map)localObject2).put("ext1", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(a(721));
    localStringBuilder.append("");
    ((Map)localObject2).put("ext2", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(c(721));
    localStringBuilder.append("");
    ((Map)localObject2).put("ext3", localStringBuilder.toString());
    SpringHbReporter.a(ReportConstant.Event.jdField_a_of_type_JavaLangString, 1, paramBoolean1 ^ true, (Map)localObject2, ReportConstant.Res.a(1), true);
    a(paramAppInterface, (String)localObject1);
  }
  
  public static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    Object localObject = ((IQWalletApi)QRoute.api(IQWalletApi.class)).getQQAppInterface();
    if (localObject == null) {
      return false;
    }
    localObject = (IPreloadService)((BaseQQAppInterface)localObject).getRuntimeService(IPreloadService.class, "");
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
    boolean bool = StringUtil.a(paramString1);
    int i = 0;
    if (bool) {
      return false;
    }
    paramString1 = paramString1.split("\\|");
    int j = paramString1.length;
    bool = false;
    while (i < j)
    {
      if (paramString1[i].equals(paramString2)) {
        bool = true;
      }
      i += 1;
    }
    return bool;
  }
  
  @NonNull
  private static CJPreloadMonitorReporter.OfflineReportInfo b(AppRuntime paramAppRuntime)
  {
    CJPreloadMonitorReporter.OfflineReportInfo localOfflineReportInfo = new CJPreloadMonitorReporter.OfflineReportInfo(null);
    boolean bool = paramAppRuntime instanceof QQAppInterface;
    Object localObject = "";
    int k = 0;
    int m = -1;
    int j;
    int i;
    if (bool)
    {
      paramAppRuntime = (QQAppInterface)paramAppRuntime;
      j = k;
      i = m;
    }
    else
    {
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
      localObject = paramAppRuntime;
      j = k;
      i = m;
      if (localEIPCResult != null)
      {
        localObject = paramAppRuntime;
        j = k;
        i = m;
        if (localEIPCResult.data != null)
        {
          j = localEIPCResult.data.getInt("task_id");
          i = localEIPCResult.data.getInt("cfg_version");
          localObject = paramAppRuntime;
        }
      }
    }
    localOfflineReportInfo.jdField_a_of_type_JavaLangString = ((String)localObject);
    localOfflineReportInfo.b = i;
    localOfflineReportInfo.jdField_a_of_type_Int = j;
    return localOfflineReportInfo;
  }
  
  private static String b(AppInterface paramAppInterface)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("offline_cover_tag_cjpreload_");
      localStringBuilder.append(paramAppInterface.getCurrentAccountUin());
      paramAppInterface = c(paramAppInterface, localStringBuilder.toString());
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("offline_report_tag_cjpreload_");
      localStringBuilder.append(paramAppInterface.getCurrentAccountUin());
      localStringBuilder.append("_");
      localStringBuilder.append(paramString);
      paramAppInterface = c(paramAppInterface, localStringBuilder.toString());
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("offline_cover_tag_cjpreload_");
      localStringBuilder.append(paramAppInterface.getCurrentAccountUin());
      c(paramAppInterface, localStringBuilder.toString(), paramString);
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("offline_report_tag_cjpreload_");
      localStringBuilder.append(paramAppInterface.getCurrentAccountUin());
      localStringBuilder.append("_");
      localStringBuilder.append(paramString2);
      c(paramAppInterface, localStringBuilder.toString(), paramString1);
      return;
    }
    catch (Exception paramAppInterface)
    {
      QLog.e("CJPreloadMonitorReporter", 1, "saveOfflineTagToSP fail.", paramAppInterface);
    }
  }
  
  private static int c(int paramInt)
  {
    BaseQQAppInterface localBaseQQAppInterface = ((IQWalletApi)QRoute.api(IQWalletApi.class)).getQQAppInterface();
    if (localBaseQQAppInterface == null) {
      return 0;
    }
    return QConfigManager.a().a(paramInt, localBaseQQAppInterface.getCurrentAccountUin());
  }
  
  private static String c(AppInterface paramAppInterface)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("cfg_cover_tag_cjpreload_");
      localStringBuilder.append(paramAppInterface.getCurrentAccountUin());
      paramAppInterface = c(paramAppInterface, localStringBuilder.toString());
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("cfg_cover_tag_cjpreload_");
      localStringBuilder.append(paramAppInterface.getCurrentAccountUin());
      c(paramAppInterface, localStringBuilder.toString(), paramString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.gameres.CJPreloadMonitorReporter
 * JD-Core Version:    0.7.0.1
 */