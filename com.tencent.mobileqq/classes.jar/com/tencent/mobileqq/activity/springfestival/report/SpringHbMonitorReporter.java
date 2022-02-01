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
import com.tencent.common.app.business.BaseQQAppInterface;
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
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.IQWalletApi;
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
    int i = 0;
    if (localObject != null)
    {
      localObject = ((QQAppInterface)localObject).getCurrentUin();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("conf_taskid_");
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("conf_content_md5");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("_");
      localStringBuilder.append(str);
      return c(localQQAppInterface, localStringBuilder.toString());
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("res_cover_tag");
      localStringBuilder.append(paramAppInterface.getCurrentAccountUin());
      paramAppInterface = c(paramAppInterface, localStringBuilder.toString());
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("res_hit_tag");
      localStringBuilder.append(paramAppInterface.getCurrentAccountUin());
      localStringBuilder.append("_");
      localStringBuilder.append(paramInt);
      paramAppInterface = c(paramAppInterface, localStringBuilder.toString());
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("conf_taskid_");
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
      QLog.e("shua2021report_SpringHbMonitorReporter", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  private static void a(int paramInt, AppInterface paramAppInterface)
  {
    if (paramAppInterface == null) {
      return;
    }
    if ((paramInt != 1) && (paramInt != 2)) {
      return;
    }
    Object localObject = a(paramAppInterface, paramInt);
    String str = a();
    if (QLog.isColorLevel()) {
      QLog.i("shua2021report_SpringHbMonitorReporter", 2, String.format("[reportResHitInner] lastTag=%s curTag=%s hitAction=%s", new Object[] { localObject, str, Integer.valueOf(paramInt) }));
    }
    if (TextUtils.equals((CharSequence)localObject, str))
    {
      if (QLog.isColorLevel()) {
        QLog.i("shua2021report_SpringHbMonitorReporter", 2, "[reportResHitInner] no need to report.");
      }
      return;
    }
    if (paramInt == 1)
    {
      a(true);
    }
    else
    {
      if (paramInt != 2) {
        return;
      }
      localObject = b(BaseApplicationImpl.sApplication.getRuntime());
      if (localObject != null) {
        ThreadManagerV2.executeOnFileThread(new SpringHbMonitorReporter.1((SpringHbMonitorReporter.OfflineReportInfo)localObject));
      }
    }
    a(paramAppInterface, paramInt, str);
  }
  
  public static void a(int paramInt, String paramString)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (localQQAppInterface != null)
    {
      String str = localQQAppInterface.getCurrentUin();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("conf_content_md5");
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
    ThreadManager.getSubThreadHandler().post(new SpringHbMonitorReporter.4(paramString, paramInt2, paramInt1));
  }
  
  public static void a(int paramInt, Throwable paramThrowable, String... paramVarArgs)
  {
    Object localObject;
    try
    {
      localObject = ((SpringFestivalRedpacketConfigManager)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(QQManagerFactory.SPRING_FESTIVAL_RED_PACKET_MANAGER)).b();
      k = 0;
      if (localObject == null) {
        i = 0;
      } else {
        i = ((EntryConfigBean)localObject).version;
      }
    }
    catch (Exception paramThrowable)
    {
      int k;
      int i;
      QLog.e("shua2021report_SpringHbMonitorReporter", 1, "[reportExCatch] fail.", paramThrowable);
      return;
    }
    for (int j = ((EntryConfigBean)localObject).taskId;; j = 0)
    {
      if (QLog.isColorLevel()) {
        QLog.i("shua2021report_SpringHbMonitorReporter", 2, String.format("[reportExCatch] pos=[%d] ver=%d taskId=%d e.msg=%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(j), paramThrowable.getMessage() }));
      }
      localObject = new HashMap();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(paramInt);
      ((Map)localObject).put("ext1", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(j);
      ((Map)localObject).put("ext2", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(i);
      ((Map)localObject).put("ext3", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(paramThrowable.getMessage());
      ((Map)localObject).put("ext4", localStringBuilder.toString());
      if ((paramVarArgs != null) && (paramVarArgs.length > 0))
      {
        paramThrowable = new StringBuilder();
        i = paramVarArgs.length;
        paramInt = k;
        while (paramInt < i)
        {
          paramThrowable.append(paramVarArgs[paramInt]);
          paramThrowable.append(";");
          paramInt += 1;
        }
        paramVarArgs = new StringBuilder();
        paramVarArgs.append("");
        paramVarArgs.append(paramThrowable.toString());
        ((Map)localObject).put("ext5", paramVarArgs.toString());
      }
      SpringHbReporter.a(ReportConstant.Event.q, 0, 0, (Map)localObject, "excp", false);
      return;
      if (localObject != null) {
        break;
      }
    }
  }
  
  public static void a(AppInterface paramAppInterface, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean, String paramString)
  {
    if (paramInt4 == 0) {}
    try
    {
      if (!QLog.isColorLevel()) {
        break label404;
      }
      QLog.i("shua2021report_SpringHbMonitorReporter", 2, "[reportConfigCoverageDaily] taskid == 0");
      return;
    }
    catch (Exception paramAppInterface)
    {
      String str;
      Object localObject;
      StringBuilder localStringBuilder;
      QLog.e("shua2021report_SpringHbMonitorReporter", 1, "[reportConfigCoverageDaily] fail.", paramAppInterface);
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
      QLog.i("shua2021report_SpringHbMonitorReporter", 2, ((StringBuilder)localObject).toString());
    }
    if (a(str, paramString))
    {
      if (QLog.isColorLevel())
      {
        paramAppInterface = new StringBuilder();
        paramAppInterface.append("[reportConfigCoverageDaily] no need to report ");
        paramAppInterface.append(paramInt3);
        QLog.i("shua2021report_SpringHbMonitorReporter", 2, paramAppInterface.toString());
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
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(paramInt2);
      ((Map)localObject).put("ext4", localStringBuilder.toString());
      SpringHbReporter.a(ReportConstant.Event.b, paramInt1, paramInt2, (Map)localObject, ReportConstant.ConfigConstant.a(paramInt1), paramBoolean);
      if (StringUtil.a(str)) {
        break label406;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append("|");
      ((StringBuilder)localObject).append(paramString);
      paramString = ((StringBuilder)localObject).toString();
      break label406;
    }
    label404:
    label406:
    for (;;)
    {
      c(paramAppInterface, paramString);
      return;
      return;
      return;
    }
  }
  
  private static void a(AppInterface paramAppInterface, int paramInt, String paramString)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("res_hit_tag");
      localStringBuilder.append(paramAppInterface.getCurrentAccountUin());
      localStringBuilder.append("_");
      localStringBuilder.append(paramInt);
      c(paramAppInterface, localStringBuilder.toString(), paramString);
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("res_cover_tag");
      localStringBuilder.append(paramAppInterface.getCurrentAccountUin());
      c(paramAppInterface, localStringBuilder.toString(), paramString);
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
    if (paramReportInfo != null)
    {
      if ((localObject instanceof QQAppInterface)) {
        return;
      }
      localObject = (QQAppInterface)localObject;
      if (("sy.zhc.ym".equals(paramReportInfo.eventName)) && (paramReportInfo.action == 0)) {
        System.currentTimeMillis();
      }
    }
  }
  
  public static void a(IPreloadModule paramIPreloadModule, int paramInt1, String paramString, int paramInt2)
  {
    if (paramIPreloadModule != null)
    {
      if (TextUtils.isEmpty(paramIPreloadModule.getName())) {
        return;
      }
      if (paramIPreloadModule.getName().equals("2021_shuayishua"))
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("[reportResPreload] result=");
          ((StringBuilder)localObject1).append(paramInt1);
          ((StringBuilder)localObject1).append(",url=");
          ((StringBuilder)localObject1).append(paramString);
          QLog.i("shua2021report_SpringHbMonitorReporter", 2, ((StringBuilder)localObject1).toString());
        }
        Object localObject1 = ((IQWalletApi)QRoute.api(IQWalletApi.class)).getEncodeUrl(paramString);
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(a(719));
        ((StringBuilder)localObject2).append("");
        localObject2 = ((StringBuilder)localObject2).toString();
        Object localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(c(719));
        ((StringBuilder)localObject3).append("");
        localObject3 = ((StringBuilder)localObject3).toString();
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          HashMap localHashMap = new HashMap();
          localHashMap.put("ext1", localObject1);
          localHashMap.put("ext2", localObject2);
          localHashMap.put("ext3", localObject3);
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(paramInt2);
          ((StringBuilder)localObject1).append("");
          localHashMap.put("ext4", ((StringBuilder)localObject1).toString());
          SpringHbReporter.a(ReportConstant.Event.jdField_a_of_type_JavaLangString, 2, paramInt1, localHashMap, ReportConstant.Res.a(2));
        }
        if (paramInt1 == 0) {
          a();
        } else if (paramInt2 == 404) {
          a(paramString, 1, true, (String)localObject2, (String)localObject3);
        }
      }
      CJPreloadMonitorReporter.a(paramIPreloadModule, paramInt1, paramString, paramInt2);
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
              QLog.i("shua2021report_SpringHbMonitorReporter", 2, String.format("[reportOfflinePakcageCoverage] lastTag=%s curTag=%s isFromHit=%s", new Object[] { localObject3, localObject2, Boolean.valueOf(paramBoolean) }));
            }
            if (TextUtils.equals((CharSequence)localObject3, (CharSequence)localObject2))
            {
              if (!QLog.isColorLevel()) {
                break label568;
              }
              QLog.i("shua2021report_SpringHbMonitorReporter", 2, "[reportOfflinePakcageCoverage] no need to report.");
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
        QLog.e("shua2021report_SpringHbMonitorReporter", 1, ((StringBuilder)localObject1).toString());
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
    String str = "";
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    localHashMap.put("ext2", paramString1);
    if (paramString3 == null) {
      paramString3 = str;
    }
    localHashMap.put("ext3", paramString3);
    SpringHbReporter.a(ReportConstant.Event.jdField_a_of_type_JavaLangString, 4, paramInt, localHashMap, ReportConstant.Res.a(4));
  }
  
  public static void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[checkResCover] begin, isFromHitReport=");
      localStringBuilder.append(paramBoolean);
      QLog.i("shua2021report_SpringHbMonitorReporter", 2, localStringBuilder.toString());
    }
    ThreadManagerV2.executeOnFileThread(new SpringHbMonitorReporter.3(paramBoolean));
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
      ((StringBuilder)localObject2).append(a(719));
      ((StringBuilder)localObject2).append("");
      ((Map)localObject1).put("ext2", ((StringBuilder)localObject2).toString());
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(c(719));
      ((StringBuilder)localObject2).append("");
      ((Map)localObject1).put("ext3", ((StringBuilder)localObject2).toString());
      SpringHbReporter.a(ReportConstant.Event.f, 1, paramBoolean1 ^ true, (Map)localObject1, "", false);
    }
    Object localObject2 = a(paramAppInterface);
    Object localObject1 = a(paramBoolean1, c(719));
    if (QLog.isColorLevel()) {
      QLog.i("shua2021report_SpringHbMonitorReporter", 2, String.format("[reportResCover] lastTag=%s curTag=%s isFromHit=%s", new Object[] { localObject2, localObject1, Boolean.valueOf(paramBoolean2) }));
    }
    if (TextUtils.equals((CharSequence)localObject2, (CharSequence)localObject1))
    {
      if (QLog.isColorLevel()) {
        QLog.i("shua2021report_SpringHbMonitorReporter", 2, "[reportResCover] no need to report.");
      }
      return;
    }
    localObject2 = new HashMap();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append("");
    ((Map)localObject2).put("ext1", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(a(719));
    localStringBuilder.append("");
    ((Map)localObject2).put("ext2", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(c(719));
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
  private static SpringHbMonitorReporter.OfflineReportInfo b(AppRuntime paramAppRuntime)
  {
    Object localObject2 = null;
    SpringHbMonitorReporter.OfflineReportInfo localOfflineReportInfo = new SpringHbMonitorReporter.OfflineReportInfo(null);
    boolean bool = paramAppRuntime instanceof QQAppInterface;
    Object localObject1 = "";
    int n = 0;
    int k = 0;
    int m = -1;
    int i;
    int j;
    if (bool)
    {
      Object localObject3 = (SpringFestivalRedpacketConfigManager)((QQAppInterface)paramAppRuntime).getManager(QQManagerFactory.SPRING_FESTIVAL_RED_PACKET_MANAGER);
      paramAppRuntime = (AppRuntime)localObject1;
      i = n;
      j = m;
      if (localObject3 != null)
      {
        localObject3 = ((SpringFestivalRedpacketConfigManager)localObject3).a();
        if (localObject3 != null) {
          localObject2 = ((EntryConfigBean)localObject3).htmlOfflineCheckConfig;
        }
        paramAppRuntime = (AppRuntime)localObject1;
        if (localObject2 != null) {
          paramAppRuntime = ((HtmlOfflineCheckConfig)localObject2).bids;
        }
        if (localObject3 == null) {
          i = 0;
        } else {
          i = ((EntryConfigBean)localObject3).taskId;
        }
        if (localObject3 == null) {
          j = k;
        } else {
          j = ((EntryConfigBean)localObject3).version;
        }
      }
    }
    else
    {
      paramAppRuntime = QIPCClientHelper.getInstance().getClient().callServer("SpringHbIPCModule", "GetHtmlOffline", null);
      localObject2 = localObject1;
      if (paramAppRuntime != null)
      {
        localObject2 = localObject1;
        if (paramAppRuntime.data != null) {
          localObject2 = paramAppRuntime.data.getString("bids");
        }
      }
      localObject1 = QIPCClientHelper.getInstance().getClient().callServer("SpringHbIPCModule", "GetCfgInfo", null);
      paramAppRuntime = (AppRuntime)localObject2;
      i = n;
      j = m;
      if (localObject1 != null)
      {
        paramAppRuntime = (AppRuntime)localObject2;
        i = n;
        j = m;
        if (((EIPCResult)localObject1).data != null)
        {
          i = ((EIPCResult)localObject1).data.getInt("task_id");
          j = ((EIPCResult)localObject1).data.getInt("cfg_version");
          paramAppRuntime = (AppRuntime)localObject2;
        }
      }
    }
    localOfflineReportInfo.jdField_a_of_type_JavaLangString = paramAppRuntime;
    localOfflineReportInfo.b = j;
    localOfflineReportInfo.jdField_a_of_type_Int = i;
    return localOfflineReportInfo;
  }
  
  private static String b(AppInterface paramAppInterface)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("offline_cover_tag");
      localStringBuilder.append(paramAppInterface.getCurrentAccountUin());
      paramAppInterface = c(paramAppInterface, localStringBuilder.toString());
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("offline_report_tag");
      localStringBuilder.append(paramAppInterface.getCurrentAccountUin());
      localStringBuilder.append("_");
      localStringBuilder.append(paramString);
      paramAppInterface = c(paramAppInterface, localStringBuilder.toString());
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("offline_cover_tag");
      localStringBuilder.append(paramAppInterface.getCurrentAccountUin());
      c(paramAppInterface, localStringBuilder.toString(), paramString);
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("offline_report_tag");
      localStringBuilder.append(paramAppInterface.getCurrentAccountUin());
      localStringBuilder.append("_");
      localStringBuilder.append(paramString2);
      c(paramAppInterface, localStringBuilder.toString(), paramString1);
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
      localStringBuilder.append("cfg_cover_tag");
      localStringBuilder.append(paramAppInterface.getCurrentAccountUin());
      paramAppInterface = c(paramAppInterface, localStringBuilder.toString());
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("cfg_cover_tag");
      localStringBuilder.append(paramAppInterface.getCurrentAccountUin());
      c(paramAppInterface, localStringBuilder.toString(), paramString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.report.SpringHbMonitorReporter
 * JD-Core Version:    0.7.0.1
 */