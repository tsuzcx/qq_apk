package com.tencent.biz.pubaccount.weishi_new.download;

import UserGrowth.stReportItem;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.biz.pubaccount.weishi_new.WSRecommendAdapter;
import com.tencent.biz.pubaccount.weishi_new.config.WSGlobalConfig;
import com.tencent.biz.pubaccount.weishi_new.config.experiment.WSExpABTestManager;
import com.tencent.biz.pubaccount.weishi_new.report.UserActionReportPresenter;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi_new.report.WSReportDc00898;
import com.tencent.biz.pubaccount.weishi_new.report.dc898.WSReportDC898Vertical;
import com.tencent.biz.pubaccount.weishi_new.util.AppMarketUtils;
import com.tencent.biz.pubaccount.weishi_new.util.WSDeviceUtils;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.biz.qqstory.utils.NetworkUtils;
import com.tencent.biz.qqstory.utils.WeishiGuideUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mm.vfs.FileSystemManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.bigbrother.RockDownloader.RockDownloaderProxy;
import com.tencent.mobileqq.data.RockDownloadInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.appstore.dl.DownloadInfoReport;
import com.tencent.open.appstore.dl.DownloadManagerV2;
import com.tencent.open.appstore.dl.DownloadProxy;
import com.tencent.open.business.base.AppUtil;
import com.tencent.open.downloadnew.DownloadConstants;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.qzone.LocalMultiProcConfig;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

public class WeishiDownloadUtil
{
  private static WSDownloadListenerWrapper jdField_a_of_type_ComTencentBizPubaccountWeishi_newDownloadWSDownloadListenerWrapper;
  private static WSDownloadParams jdField_a_of_type_ComTencentBizPubaccountWeishi_newDownloadWSDownloadParams;
  public static final String a;
  public static HashMap<String, String> a;
  public static boolean a;
  private static WSDownloadListenerWrapper jdField_b_of_type_ComTencentBizPubaccountWeishi_newDownloadWSDownloadListenerWrapper;
  private static String jdField_b_of_type_JavaLangString;
  private static HashMap<String, Integer> jdField_b_of_type_JavaUtilHashMap = new HashMap();
  
  static
  {
    jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131716378);
    jdField_a_of_type_Boolean = false;
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public static int a()
  {
    return LocalMultiProcConfig.getInt("eventId", -1);
  }
  
  public static int a(String paramString)
  {
    int j = -1;
    int i = j;
    try
    {
      Object localObject = BaseApplicationImpl.getApplication().getPackageManager().getPackageArchiveInfo(paramString, 1);
      if (localObject != null)
      {
        i = j;
        j = ((PackageInfo)localObject).versionCode;
        i = j;
        paramString = new StringBuilder();
        i = j;
        paramString.append("versionName:");
        i = j;
        paramString.append(((PackageInfo)localObject).versionName);
        i = j;
        paramString.append(",versionCode:");
        i = j;
        paramString.append(((PackageInfo)localObject).versionCode);
        i = j;
        WSLog.a("WeishiDownloadUtil", paramString.toString());
        return j;
      }
      i = j;
      localObject = new StringBuilder();
      i = j;
      ((StringBuilder)localObject).append(paramString);
      i = j;
      ((StringBuilder)localObject).append("获取 PackageInfo 失败");
      i = j;
      WSLog.c("WeishiDownloadUtil", ((StringBuilder)localObject).toString());
      return -1;
    }
    catch (Exception paramString)
    {
      WSLog.a("WeishiDownloadUtil", paramString.getLocalizedMessage());
    }
    return i;
  }
  
  public static WSDownloadListenerWrapper a(int paramInt1, int paramInt2)
  {
    if (b()) {
      return c(paramInt1, paramInt2);
    }
    return b(paramInt1, paramInt2);
  }
  
  private static RockDownloadInfo a(ArrayList<RockDownloadInfo> paramArrayList, RockDownloadInfo paramRockDownloadInfo)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      RockDownloadInfo localRockDownloadInfo = (RockDownloadInfo)paramArrayList.next();
      if ((localRockDownloadInfo.businessName.equals(paramRockDownloadInfo.businessName)) && (localRockDownloadInfo.packageName.equals(paramRockDownloadInfo.packageName)) && (localRockDownloadInfo.realVersionCode >= paramRockDownloadInfo.versionCode) && (localRockDownloadInfo.versionCode >= paramRockDownloadInfo.versionCode))
      {
        WSLog.a("WeishiDownloadUtil", "Rock包版本大于或等于要下载的版本，有效~~~");
        return localRockDownloadInfo;
      }
    }
    return null;
  }
  
  public static String a()
  {
    return "https://weseeugg.qq.com/download?channelid=204002177";
  }
  
  private static String a(int paramInt)
  {
    Object localObject2 = DownloadManagerV2.a().b("com.tencent.weishi", 4);
    Object localObject1 = localObject2;
    if (((List)localObject2).size() == 0) {
      localObject1 = DownloadManagerV2.a().a("com.tencent.weishi", 4);
    }
    localObject2 = DownloadManager.a().a("10261931");
    if (localObject2 != null)
    {
      ((DownloadInfo)localObject2).a(4);
      ((List)localObject1).add(localObject2);
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(">existValidQQDownloadWeishiApk, info:");
    ((StringBuilder)localObject2).append(localObject1);
    WSLog.a("WeishiDownloadUtil", ((StringBuilder)localObject2).toString());
    localObject2 = ((List)localObject1).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject1 = (DownloadInfo)((Iterator)localObject2).next();
      if (localObject1 != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("downloadInfo 's url: ");
        localStringBuilder.append(((DownloadInfo)localObject1).d);
        WSLog.d("WeishiDownloadUtil", localStringBuilder.toString());
        if ((((DownloadInfo)localObject1).a() == 4) && (TextUtils.equals(((DownloadInfo)localObject1).e, "com.tencent.weishi")) && (((DownloadInfo)localObject1).d != null) && (((DownloadInfo)localObject1).d.startsWith(b()))) {
          if (TextUtils.isEmpty(((DownloadInfo)localObject1).l))
          {
            WSLog.a("WeishiDownloadUtil", "QQ下载包filePath为空!!!");
          }
          else
          {
            int i = a(((DownloadInfo)localObject1).l);
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("判断QQ下载包有没有过期，apkVersionCode：");
            localStringBuilder.append(i);
            localStringBuilder.append(",targetVersion:");
            localStringBuilder.append(paramInt);
            WSLog.a("WeishiDownloadUtil", localStringBuilder.toString());
            if (i >= paramInt)
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("本地包版本(");
              ((StringBuilder)localObject2).append(i);
              ((StringBuilder)localObject2).append(")大于或等于要下载的版本");
              ((StringBuilder)localObject2).append(paramInt);
              ((StringBuilder)localObject2).append(")，直接安装~~~");
              WSLog.a("WeishiDownloadUtil", ((StringBuilder)localObject2).toString());
              return ((DownloadInfo)localObject1).l;
            }
          }
        }
      }
      else
      {
        WSLog.d("WeishiDownloadUtil", "downloadInfo is null");
      }
    }
    return "";
  }
  
  public static String a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 <= 0) {
      paramInt1 = 0;
    }
    if (paramInt2 <= 0) {
      paramInt2 = 0;
    }
    if (paramInt3 <= 0) {
      paramInt3 = 0;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(paramInt2);
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(paramInt3);
    localObject = ((StringBuilder)localObject).toString();
    localObject = (String)jdField_a_of_type_JavaUtilHashMap.get(localObject);
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      return localObject;
    }
    return "204002042";
  }
  
  private static ArrayList<RockDownloadInfo> a(RockDownloadPresenter paramRockDownloadPresenter, RockDownloadInfo paramRockDownloadInfo)
  {
    FileSystemManager.setContext(BaseApplicationImpl.sApplication);
    ArrayList localArrayList = RockDownloaderProxy.a(paramRockDownloadInfo);
    if ((localArrayList != null) && (localArrayList.size() != 0))
    {
      int i = 0;
      while (i < localArrayList.size())
      {
        Object localObject = (RockDownloadInfo)localArrayList.get(i);
        int j = ((RockDownloadInfo)localObject).versionCode;
        int k = ((RockDownloadInfo)localObject).realVersionCode;
        if ((k >= paramRockDownloadInfo.versionCode) && (j >= paramRockDownloadInfo.versionCode))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("第");
          ((StringBuilder)localObject).append(i);
          ((StringBuilder)localObject).append("个rockDownloadInfo是正确的，此info的versionCode是");
          ((StringBuilder)localObject).append(j);
          ((StringBuilder)localObject).append(",realVersionCode是:");
          ((StringBuilder)localObject).append(k);
          ((StringBuilder)localObject).append(",要下载的version是:");
          ((StringBuilder)localObject).append(paramRockDownloadInfo.versionCode);
          Log.i("WeishiDownloadUtil", ((StringBuilder)localObject).toString());
        }
        else
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("本地已经有的安装包版本太旧，报告服务器删除掉第");
          localStringBuilder.append(i);
          localStringBuilder.append("个rockDownloadInfo，此info的versionCode是");
          localStringBuilder.append(j);
          localStringBuilder.append(",realVersionCode是:");
          localStringBuilder.append(k);
          localStringBuilder.append(",要下载的version是:");
          localStringBuilder.append(paramRockDownloadInfo.versionCode);
          Log.i("WeishiDownloadUtil", localStringBuilder.toString());
          paramRockDownloadPresenter.a((RockDownloadInfo)localObject);
        }
        i += 1;
      }
      return localArrayList;
    }
    return null;
  }
  
  public static void a()
  {
    WSLog.a("WeishiDownloadUtil", "resetDownloadingMark");
    LocalMultiProcConfig.putBool("weishi_downloading_key", false);
    LocalMultiProcConfig.putLong("weishi_downloading_start_time_key", 0L);
  }
  
  public static void a(int paramInt)
  {
    LocalMultiProcConfig.putInt("eventId", paramInt);
  }
  
  public static void a(Activity paramActivity, RockDownloadPresenter paramRockDownloadPresenter, WSDownloadParams paramWSDownloadParams, boolean paramBoolean, int paramInt)
  {
    a(paramWSDownloadParams.mEventId, paramInt);
    WeishiUtils.a(paramWSDownloadParams.mScheme);
    a(paramActivity, paramWSDownloadParams, paramBoolean, paramInt);
  }
  
  public static void a(Activity paramActivity, WSDownloadParams paramWSDownloadParams)
  {
    if ((paramActivity != null) && (paramWSDownloadParams != null))
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("WSDownloadParams:");
      ((StringBuilder)localObject).append(paramWSDownloadParams.toString());
      WSLog.d("WeishiDownloadUtil", ((StringBuilder)localObject).toString());
      localObject = new RockDownloadPresenter();
      if (!NetworkUtils.b(paramActivity))
      {
        if (a(paramWSDownloadParams, (RockDownloadPresenter)localObject, ((RockDownloadPresenter)localObject).a(), 3)) {
          return;
        }
        QQToast.a(paramActivity, HardCodeUtil.a(2131716377), 0).a();
        return;
      }
      if (c())
      {
        a(true);
        WSLog.d("WeishiDownloadUtil", "当前有正在下载的任务,不响应钩子下载请求,但更改下载类型为主动下载");
        if ((WSGlobalConfig.a().c()) && (a()))
        {
          b(3);
          return;
        }
        a(paramWSDownloadParams.mEventId, 3);
        WSReportDc00898.a(true, paramWSDownloadParams);
        WSReportDc00898.a(paramWSDownloadParams, 2);
        WSPublicAccReport.getInstance().reportDownload(paramWSDownloadParams.mEventId, 3, 1, 2, 0, paramWSDownloadParams.mScene);
        WSDownloadAppDialog.a(paramActivity);
        return;
      }
      if ((WSGlobalConfig.a().b()) && (AppMarketUtils.a(paramActivity)))
      {
        WSLog.d("WeishiDownloadUtil", "主动点击 执行厂商下载-----");
        AppMarketUtils.a(paramActivity);
        b(3);
        WeishiUtils.a(paramWSDownloadParams.mScheme);
        paramWSDownloadParams.mStReportItem = UserActionReportPresenter.a();
        WSDownloadAppDialog.a(115, paramWSDownloadParams);
        WSReportDc00898.a(false, paramWSDownloadParams);
        WSReportDc00898.a(paramWSDownloadParams, 3);
        WSPublicAccReport.getInstance().reportDownload(paramWSDownloadParams.mEventId, 3, 0, 3, 0, paramWSDownloadParams.mScene);
        DownloadInfoReport.a(paramActivity, paramWSDownloadParams.mScheme, "com.tencent.weishi", "biz_src_jc_gzh_weishi");
        return;
      }
      RockDownloadInfo localRockDownloadInfo = ((RockDownloadPresenter)localObject).a();
      if (a(paramWSDownloadParams, (RockDownloadPresenter)localObject, localRockDownloadInfo, 3)) {
        return;
      }
      b(3);
      if ((!WSGlobalConfig.a().a()) && (!a()))
      {
        WSLog.a("WeishiDownloadUtil", "服务器关闭了4g开关");
        WSDownloadAppDialog.b(paramActivity, paramWSDownloadParams);
        return;
      }
      WSLog.a("WeishiDownloadUtil", "服务器打开了4g");
      if (WSGlobalConfig.a().c())
      {
        ((RockDownloadPresenter)localObject).a(paramActivity, localRockDownloadInfo, 3, paramWSDownloadParams, null);
        return;
      }
      WSDownloadAppDialog.a(paramActivity, paramWSDownloadParams);
      return;
    }
    WSLog.a("WeishiDownloadUtil", "rock download activity or params is null");
  }
  
  public static void a(Activity paramActivity, WSDownloadParams paramWSDownloadParams, WSDownloadListenerWrapper paramWSDownloadListenerWrapper, RockDownloadListenerWrapper paramRockDownloadListenerWrapper)
  {
    paramWSDownloadListenerWrapper = new RockDownloadPresenter();
    if (!NetworkUtils.b(paramActivity))
    {
      if (a(paramWSDownloadParams, paramWSDownloadListenerWrapper, paramWSDownloadListenerWrapper.a(), 3)) {
        return;
      }
      QQToast.a(paramActivity, HardCodeUtil.a(2131716377), 0).a();
      return;
    }
    if ((WSGlobalConfig.a().b()) && (AppMarketUtils.a(paramActivity)))
    {
      WSLog.d("WeishiDownloadUtil", "B链路点击 延迟执行厂商下载");
      LocalMultiProcConfig.putBool("need_appstore_download", true);
      if (c())
      {
        if ((WSGlobalConfig.a().c()) && (a()))
        {
          WSLog.c("WeishiDownloadUtil", "当前有下载的Rock任务,开始中断-----");
          paramActivity = WSGlobalConfig.a().c();
          DownloadProxy.a().b(paramActivity, false);
          return;
        }
        paramActivity = WSGlobalConfig.a().d();
        WSLog.c("WeishiDownloadUtil", "当当前有QQ下载的任务,开始中断~~");
        DownloadProxy.a().b(paramActivity, false);
      }
    }
    else
    {
      paramWSDownloadListenerWrapper = new RockDownloadPresenter();
      RockDownloadInfo localRockDownloadInfo = paramWSDownloadListenerWrapper.a();
      if (a(paramWSDownloadParams, paramWSDownloadListenerWrapper, localRockDownloadInfo, 2)) {
        return;
      }
      if ((!WSGlobalConfig.a().a()) && (!a()))
      {
        WSLog.d("WeishiDownloadUtil", "不可以在非WIFI环境下，静默下载微视");
        return;
      }
      if (c())
      {
        WSLog.d("WeishiDownloadUtil", "当前有正在下载的任务,不响应静默下载请求");
        if ((WSGlobalConfig.a().c()) && (a()))
        {
          b(2);
          return;
        }
        WSReportDc00898.a(true, paramWSDownloadParams);
        WSReportDc00898.a(paramWSDownloadParams, 2);
        WSPublicAccReport.getInstance().reportDownload(paramWSDownloadParams.mEventId, 2, 1, 2, 0, paramWSDownloadParams.mScene);
        return;
      }
      WSLog.d("WeishiDownloadUtil", "执行QQ或Rock下载");
      b(2);
      if (WSGlobalConfig.a().c())
      {
        paramWSDownloadListenerWrapper.a(paramActivity, localRockDownloadInfo, 2, paramWSDownloadParams, paramRockDownloadListenerWrapper);
        return;
      }
      a(paramActivity, paramWSDownloadParams, true, 2);
    }
  }
  
  public static void a(Activity paramActivity, WSDownloadParams paramWSDownloadParams, boolean paramBoolean)
  {
    a(paramActivity, paramWSDownloadParams);
  }
  
  private static void a(String paramString, int paramInt)
  {
    Object localObject2 = DownloadManagerV2.a().a();
    if (localObject2 == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = null;
    Iterator localIterator = ((ConcurrentHashMap)localObject2).values().iterator();
    while (localIterator.hasNext())
    {
      localObject2 = (DownloadInfo)localIterator.next();
      if ((localObject2 != null) && (((DownloadInfo)localObject2).e.equals("com.tencent.weishi")) && (((DownloadInfo)localObject2).d != null) && (((DownloadInfo)localObject2).d.startsWith(b())) && (!((DownloadInfo)localObject2).d.equals(paramString))) {
        if ((((DownloadInfo)localObject2).a() == 4) && (a(((DownloadInfo)localObject2).l) < paramInt))
        {
          localArrayList.add(localObject2);
        }
        else
        {
          Object localObject3 = localObject1;
          if (localObject1 == null) {
            localObject3 = localObject2;
          }
          localObject1 = localObject3;
          if (System.currentTimeMillis() - ((DownloadInfo)localObject2).jdField_a_of_type_Long > 2592000000L) {
            if (((DownloadInfo)localObject2).jdField_a_of_type_Long > localObject3.jdField_a_of_type_Long)
            {
              localArrayList.add(localObject3);
              localObject1 = localObject2;
            }
            else
            {
              localArrayList.add(localObject2);
              localObject1 = localObject3;
            }
          }
        }
      }
    }
    paramString = localArrayList.iterator();
    while (paramString.hasNext())
    {
      localObject1 = (DownloadInfo)paramString.next();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("删除了info:");
      ((StringBuilder)localObject2).append(((DownloadInfo)localObject1).d);
      WSLog.d("WeishiDownloadUtil", ((StringBuilder)localObject2).toString());
      DownloadManagerV2.a().b(((DownloadInfo)localObject1).d, false);
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    WSLog.a("WeishiDownloadUtil", "setPreDownloadingClick");
    LocalMultiProcConfig.putBool("preDownloadingClick", paramBoolean);
  }
  
  public static boolean a()
  {
    return WSDeviceUtils.a();
  }
  
  public static boolean a(Activity paramActivity, WSDownloadParams paramWSDownloadParams)
  {
    a(false);
    if (WeishiGuideUtils.a(paramActivity))
    {
      WSLog.d("WeishiDownloadUtil", "本地已经安装微视app");
      return false;
    }
    if (!e())
    {
      WSLog.d("WeishiDownloadUtil", "预下载开关没打开");
      return false;
    }
    RockDownloadPresenter localRockDownloadPresenter = new RockDownloadPresenter();
    RockDownloadInfo localRockDownloadInfo = localRockDownloadPresenter.a();
    b(1);
    if (a(paramWSDownloadParams, localRockDownloadPresenter, localRockDownloadInfo, 1)) {
      return false;
    }
    if ((WSGlobalConfig.a().c()) && (a()))
    {
      localRockDownloadPresenter.a(paramActivity, localRockDownloadInfo, 1, paramWSDownloadParams, null);
      return true;
    }
    WSLog.c("WeishiDownloadUtil", "用QQ预下载兜底~");
    a(99, 1);
    a(paramActivity, paramWSDownloadParams, false, 1);
    return true;
  }
  
  public static boolean a(Activity paramActivity, WSDownloadParams paramWSDownloadParams, boolean paramBoolean, int paramInt)
  {
    if ((paramActivity != null) && (paramWSDownloadParams != null))
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("downloadWeishi:");
      ((StringBuilder)localObject).append(paramWSDownloadParams);
      WSLog.a(((StringBuilder)localObject).toString());
      localObject = WSGlobalConfig.a().d();
      a(paramWSDownloadParams.mEventId, paramInt);
      WeishiUtils.a(paramWSDownloadParams.mScheme);
      return a(paramActivity, (String)localObject, paramBoolean, false, paramWSDownloadParams, paramInt);
    }
    WSLog.a("startQQDownload: activity is null Or params is null:");
    return false;
  }
  
  private static boolean a(Activity paramActivity, String paramString, boolean paramBoolean1, boolean paramBoolean2, WSDownloadParams paramWSDownloadParams, int paramInt)
  {
    WSLog.a("WeishiDownloadUtil", String.format("downloadWeishi : autoInstall = %s, showNotification = %s, mDownloadUrlStr = %s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), paramString }));
    b();
    Bundle localBundle = new Bundle();
    localBundle.putString(DownloadConstants.jdField_b_of_type_JavaLangString, "10261931");
    localBundle.putString(DownloadConstants.l, jdField_a_of_type_JavaLangString);
    localBundle.putString(DownloadConstants.f, "com.tencent.weishi");
    localBundle.putString(DownloadConstants.j, paramString);
    localBundle.putInt(DownloadConstants.k, 2);
    localBundle.putBoolean(DownloadConstants.h, false);
    localBundle.putBoolean(DownloadConstants.y, paramBoolean2 ^ true);
    DownloadProxy.a().a(paramActivity, localBundle, "biz_src_jc_gzh_weishi", null, 0);
    jdField_a_of_type_ComTencentBizPubaccountWeishi_newDownloadWSDownloadParams = paramWSDownloadParams;
    WSReportDc00898.a(true, paramWSDownloadParams);
    WSReportDc00898.a(paramWSDownloadParams, 2);
    WSPublicAccReport.getInstance().reportDownload(paramWSDownloadParams.mEventId, paramInt, 1, 2, 0, paramWSDownloadParams.mScene);
    return true;
  }
  
  private static boolean a(WSDownloadParams paramWSDownloadParams, int paramInt, String paramString)
  {
    if (AppUtil.a(CommonDataAdapter.a().a(), paramString, "biz_src_jc_gzh_weishi", ""))
    {
      WSLog.a("WeishiDownloadUtil", "本地QQ包的版本有效，启动开始安装成功！");
      WSReportDc00898.a(1, 2);
      paramString = paramWSDownloadParams;
      if (paramWSDownloadParams == null)
      {
        paramString = new WSDownloadParams();
        WSLog.d("WeishiDownloadUtil", "WSDownloadParams异常！");
      }
      WSPublicAccReport.getInstance().reportDownload(paramString.mEventId, paramInt, 2, 2, 1, paramString.mScene);
      if (paramString.mStReportItem == null) {
        paramString.mStReportItem = UserActionReportPresenter.a();
      }
      UserActionReportPresenter.a(115, paramString.mStReportItem.pagetype, paramString.mStReportItem.comment_loctaion, null);
      WeishiUtils.a(paramString.mScheme);
      return true;
    }
    WSLog.d("WeishiDownloadUtil", "本地QQ包安装失败,重新下载！");
    return false;
  }
  
  private static boolean a(WSDownloadParams paramWSDownloadParams, RockDownloadPresenter paramRockDownloadPresenter, RockDownloadInfo paramRockDownloadInfo, int paramInt)
  {
    Object localObject = a(paramRockDownloadPresenter, paramRockDownloadInfo);
    if (a((ArrayList)localObject, paramRockDownloadInfo))
    {
      WSPublicAccReport.getInstance().reportDownload(paramWSDownloadParams.mEventId, paramInt, 1, 1, 0, paramWSDownloadParams.mScene);
      paramRockDownloadInfo = a((ArrayList)localObject, paramRockDownloadInfo);
      if (paramRockDownloadInfo != null)
      {
        if (paramInt == 1)
        {
          WSLog.c("WeishiDownloadUtil", "预下载包有效也不call安装----------------");
          return true;
        }
        if (WSGlobalConfig.a().a(1) == 2)
        {
          WSRecommendAdapter.b += 1;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("CCCCCCCCC onDownloadFinish SLIENT WSRecommendAdapter.openDownloadWSCount = ");
          ((StringBuilder)localObject).append(WSRecommendAdapter.b);
          WSLog.c("WeishiDownloadUtil", ((StringBuilder)localObject).toString());
        }
        paramRockDownloadPresenter.a(paramRockDownloadInfo, 1);
        WeishiUtils.a(paramWSDownloadParams.mScheme);
        WSLog.d("WeishiDownloadUtil", "本地Rock包的版本有效，直接安装");
        return true;
      }
    }
    paramRockDownloadPresenter = a(WSGlobalConfig.a().c());
    if (!TextUtils.isEmpty(paramRockDownloadPresenter))
    {
      paramRockDownloadInfo = new StringBuilder();
      paramRockDownloadInfo.append("checkAndInstallValidApp QQDownloader apkPath = ");
      paramRockDownloadInfo.append(paramRockDownloadPresenter);
      WSLog.d("WeishiDownloadUtil", paramRockDownloadInfo.toString());
      if (paramInt == 1)
      {
        WSLog.c("WeishiDownloadUtil", "预下载包有效也不call安装----------------");
        return true;
      }
      if (WSGlobalConfig.a().a(1) == 2)
      {
        WSRecommendAdapter.b += 1;
        paramRockDownloadInfo = new StringBuilder();
        paramRockDownloadInfo.append("DDDDDDDDDDD onDownloadFinish SLIENT WSRecommendAdapter.openDownloadWSCount = ");
        paramRockDownloadInfo.append(WSRecommendAdapter.b);
        WSLog.c("WeishiDownloadUtil", paramRockDownloadInfo.toString());
      }
      WSPublicAccReport.getInstance().reportDownload(paramWSDownloadParams.mEventId, paramInt, 1, 2, 0, paramWSDownloadParams.mScene);
      a(paramWSDownloadParams.mEventId, paramInt);
      if (a(paramWSDownloadParams, paramInt, paramRockDownloadPresenter))
      {
        paramRockDownloadPresenter = new StringBuilder();
        paramRockDownloadPresenter.append("installApkByQQDownloader！eventId:");
        paramRockDownloadPresenter.append(paramWSDownloadParams.mEventId);
        paramRockDownloadPresenter.append(",eventType:");
        paramRockDownloadPresenter.append(paramInt);
        WSLog.a("WeishiDownloadUtil", paramRockDownloadPresenter.toString());
        return true;
      }
    }
    else
    {
      WSLog.a("WeishiDownloadUtil", "本地QQ包路径为空！");
    }
    return false;
  }
  
  private static boolean a(ArrayList<RockDownloadInfo> paramArrayList, RockDownloadInfo paramRockDownloadInfo)
  {
    if (paramArrayList != null)
    {
      if (paramArrayList.size() == 0) {
        return false;
      }
      paramArrayList = a(paramArrayList, paramRockDownloadInfo);
      if (paramArrayList == null) {
        return false;
      }
      paramArrayList = paramArrayList.localPath;
      if (paramArrayList != null) {
        return !TextUtils.isEmpty(paramArrayList);
      }
    }
    return false;
  }
  
  public static int b()
  {
    return LocalMultiProcConfig.getInt("eventType", -1);
  }
  
  private static WSDownloadListenerWrapper b(int paramInt1, int paramInt2)
  {
    if (jdField_a_of_type_ComTencentBizPubaccountWeishi_newDownloadWSDownloadListenerWrapper != null)
    {
      if (!c()) {
        a(paramInt1);
      }
      b(paramInt2);
      return jdField_a_of_type_ComTencentBizPubaccountWeishi_newDownloadWSDownloadListenerWrapper;
    }
    a(paramInt1);
    b(paramInt2);
    jdField_a_of_type_ComTencentBizPubaccountWeishi_newDownloadWSDownloadListenerWrapper = new WeishiDownloadUtil.1();
    DownloadManagerV2.a().a(jdField_a_of_type_ComTencentBizPubaccountWeishi_newDownloadWSDownloadListenerWrapper);
    return jdField_a_of_type_ComTencentBizPubaccountWeishi_newDownloadWSDownloadListenerWrapper;
  }
  
  public static String b()
  {
    return "https://weseeugg.qq.com/download?channelid=";
  }
  
  public static void b()
  {
    WSLog.a("WeishiDownloadUtil", "updateDownloadingMark");
    LocalMultiProcConfig.putBool("weishi_downloading_key", true);
    LocalMultiProcConfig.putLong("weishi_downloading_start_time_key", System.currentTimeMillis());
  }
  
  public static void b(int paramInt)
  {
    LocalMultiProcConfig.putInt("eventType", paramInt);
  }
  
  private static void b(DownloadInfo paramDownloadInfo, int paramInt)
  {
    if ((paramInt != 6) && (paramInt != 3))
    {
      WSLog.d("WeishiDownloadUtil", "下载器其他错误");
      return;
    }
    WSLog.d("WeishiDownloadUtil", " 下载器的DB还没准备就绪,重新注册监听，并重试下载一次");
    if (jdField_b_of_type_JavaUtilHashMap.containsKey(paramDownloadInfo.d))
    {
      localInteger = (Integer)jdField_b_of_type_JavaUtilHashMap.get(paramDownloadInfo.d);
      if (localInteger != null)
      {
        paramInt = localInteger.intValue();
        jdField_b_of_type_JavaUtilHashMap.put(paramDownloadInfo.d, Integer.valueOf(paramInt + 1));
      }
    }
    else
    {
      jdField_b_of_type_JavaUtilHashMap.put(paramDownloadInfo.d, Integer.valueOf(1));
    }
    Integer localInteger = (Integer)jdField_b_of_type_JavaUtilHashMap.get(paramDownloadInfo.d);
    if (localInteger != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDownloadError retryCount = ");
      localStringBuilder.append(localInteger);
      WSLog.d("WeishiDownloadUtil", localStringBuilder.toString());
      if (localInteger.intValue() > 3)
      {
        WSLog.d("WeishiDownloadUtil", "重试次数已经达到3次，中止！");
        return;
      }
    }
    ThreadManager.getUIHandler().postDelayed(new WeishiDownloadUtil.3(paramDownloadInfo), 2000L);
  }
  
  private static void b(DownloadInfo paramDownloadInfo, int paramInt1, int paramInt2, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(" onDownloadFinish info = ");
    localStringBuilder.append(paramDownloadInfo);
    WSLog.d("WeishiDownloadUtil", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(" onDownloadFinish eventId:");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(",eventType:");
    localStringBuilder.append(paramInt2);
    WSLog.d("WeishiDownloadUtil", localStringBuilder.toString());
    if (b(paramDownloadInfo))
    {
      int i = 0;
      if (paramInt2 == 3)
      {
        WSDownloadAppDialog.a();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append(" onDownloadFinish ACTIVE closeDownloadDialog");
        WSLog.c("WeishiDownloadUtil", localStringBuilder.toString());
      }
      else if (paramInt2 == 2)
      {
        if (WSGlobalConfig.a().a(1) == 2)
        {
          WSRecommendAdapter.b += 1;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramString);
          localStringBuilder.append(" onDownloadFinish SLIENT WSRecommendAdapter.openDownloadWSCount = ");
          localStringBuilder.append(WSRecommendAdapter.b);
          WSLog.b("WeishiDownloadUtil", localStringBuilder.toString());
        }
        else
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("processDownloadFinish, this is maybe DTest silent download,linktype is :");
          localStringBuilder.append(WSGlobalConfig.a().a(1));
          WSLog.a("WeishiDownloadUtil", localStringBuilder.toString());
        }
      }
      else
      {
        if (!d()) {
          break label322;
        }
        a(false);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append(" 预下载中用户点击了钩子，下载完成需弹起安装！！！ByQQ");
        WSLog.d("WeishiDownloadUtil", localStringBuilder.toString());
      }
      i = 1;
      break label357;
      label322:
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(" 正常预下载无需安装");
      WSLog.d("WeishiDownloadUtil", localStringBuilder.toString());
      label357:
      WSReportDC898Vertical.a(paramInt1);
      WSReportDc00898.a(2);
      WSPublicAccReport.getInstance().reportDownload(a(), paramInt2, 2, 2, 0, d());
      if (paramDownloadInfo.jdField_a_of_type_Boolean) {
        WSPublicAccReport.getInstance().reportDownload(a(), paramInt2, 2, 2, 1, d());
      }
      if (paramInt1 == 8) {
        UserActionReportPresenter.a(132, 10, null);
      } else if (paramInt1 == 401) {
        UserActionReportPresenter.a(138, 1, null);
      }
      if (jdField_b_of_type_JavaUtilHashMap.containsKey(paramDownloadInfo.d))
      {
        jdField_b_of_type_JavaUtilHashMap.remove(paramDownloadInfo.d);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append(" onDownloadFinish remove retryCount!");
        WSLog.d("WeishiDownloadUtil", localStringBuilder.toString());
      }
      if (i != 0)
      {
        paramString = a(WSGlobalConfig.a().c());
        a(jdField_a_of_type_ComTencentBizPubaccountWeishi_newDownloadWSDownloadParams, paramInt2, paramString);
      }
      a(paramDownloadInfo.d, WSGlobalConfig.a().c());
    }
  }
  
  private static void b(String paramString1, String paramString2, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("qq installSucceed appid = ");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(", packageName = ");
    localStringBuilder.append(paramString2);
    WSLog.d("WeishiDownloadUtil", localStringBuilder.toString());
    if ((TextUtils.equals(paramString1, "10261931")) && (TextUtils.equals(paramString2, "com.tencent.weishi")))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("这是统一的DownloadListener，installSucceed, appId:");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(",packName:");
      localStringBuilder.append(paramString2);
      WSLog.d("WeishiDownloadUtil", localStringBuilder.toString());
      DownloadManagerV2.a().b(jdField_a_of_type_ComTencentBizPubaccountWeishi_newDownloadWSDownloadListenerWrapper);
      WSRecommendAdapter.b = 0;
      if (paramBoolean) {
        jdField_b_of_type_ComTencentBizPubaccountWeishi_newDownloadWSDownloadListenerWrapper = null;
      } else {
        jdField_a_of_type_ComTencentBizPubaccountWeishi_newDownloadWSDownloadListenerWrapper = null;
      }
      int i = a();
      int j = b();
      WSReportDC898Vertical.b(i);
      WSReportDc00898.b(2);
      WSPublicAccReport.getInstance().reportDownload(i, j, 2, 2, 2, d());
      if (i == 8)
      {
        UserActionReportPresenter.a(133, 10, null);
        return;
      }
      if (i == 401) {
        UserActionReportPresenter.a(139, 1, null);
      }
    }
  }
  
  public static boolean b()
  {
    String str = c();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("~~~~~~~~~~~~~~~~~~~~~~~~~currentProcessName:");
    localStringBuilder.append(str);
    WSLog.b("WeishiDownloadUtil", localStringBuilder.toString());
    return "com.tencent.mobileqq:qzone".equals(str);
  }
  
  private static boolean b(DownloadInfo paramDownloadInfo)
  {
    return (paramDownloadInfo != null) && (TextUtils.equals(paramDownloadInfo.e, "com.tencent.weishi")) && (paramDownloadInfo.d != null) && (paramDownloadInfo.d.startsWith(b()));
  }
  
  private static WSDownloadListenerWrapper c(int paramInt1, int paramInt2)
  {
    WSLog.a("WeishiDownloadUtil", "createQzoneListener~~~");
    if (jdField_b_of_type_ComTencentBizPubaccountWeishi_newDownloadWSDownloadListenerWrapper != null)
    {
      if (!c()) {
        a(paramInt1);
      }
      b(paramInt2);
      return jdField_b_of_type_ComTencentBizPubaccountWeishi_newDownloadWSDownloadListenerWrapper;
    }
    a(paramInt1);
    b(paramInt2);
    jdField_b_of_type_ComTencentBizPubaccountWeishi_newDownloadWSDownloadListenerWrapper = new WeishiDownloadUtil.2();
    DownloadManagerV2.a().a(jdField_b_of_type_ComTencentBizPubaccountWeishi_newDownloadWSDownloadListenerWrapper);
    WSLog.a("WeishiDownloadUtil", "qzone registerListener");
    return jdField_b_of_type_ComTencentBizPubaccountWeishi_newDownloadWSDownloadListenerWrapper;
  }
  
  private static String c()
  {
    Object localObject = jdField_b_of_type_JavaLangString;
    if (localObject != null) {
      return localObject;
    }
    int i = Process.myPid();
    localObject = ((ActivityManager)BaseApplicationImpl.getContext().getSystemService("activity")).getRunningAppProcesses();
    if (localObject != null)
    {
      if (((List)localObject).size() <= 0) {
        return null;
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
        if (localRunningAppProcessInfo.pid == i)
        {
          localObject = localRunningAppProcessInfo.processName;
          jdField_b_of_type_JavaLangString = (String)localObject;
          return localObject;
        }
      }
    }
    return null;
  }
  
  public static boolean c()
  {
    long l = System.currentTimeMillis() - LocalMultiProcConfig.getLong("weishi_downloading_start_time_key", 0L);
    boolean bool1;
    if (l > 120000L) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool2 = LocalMultiProcConfig.getBool("weishi_downloading_key", false);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("downloading  = ");
    localStringBuilder.append(bool2);
    localStringBuilder.append(", timeout = ");
    localStringBuilder.append(bool1);
    localStringBuilder.append(", time passed = ");
    localStringBuilder.append(l / 1000L);
    localStringBuilder.append("s");
    WSLog.b("WeishiDownloadUtil", localStringBuilder.toString());
    return (bool2) && (!bool1);
  }
  
  private static int d()
  {
    WSDownloadParams localWSDownloadParams = jdField_a_of_type_ComTencentBizPubaccountWeishi_newDownloadWSDownloadParams;
    if (localWSDownloadParams != null) {
      return localWSDownloadParams.mScene;
    }
    return 1;
  }
  
  public static boolean d()
  {
    WSLog.a("WeishiDownloadUtil", "getPreDownloadingClick");
    return LocalMultiProcConfig.getBool("preDownloadingClick", false);
  }
  
  private static boolean e()
  {
    return (WSExpABTestManager.a().a()) && (!TextUtils.isEmpty(WSGlobalConfig.a().c())) && (WSGlobalConfig.a().c().startsWith("http"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.download.WeishiDownloadUtil
 * JD-Core Version:    0.7.0.1
 */