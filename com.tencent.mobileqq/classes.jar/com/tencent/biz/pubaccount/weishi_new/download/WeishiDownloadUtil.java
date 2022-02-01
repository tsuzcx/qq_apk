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
  public static final String a = HardCodeUtil.a(2131913818);
  public static boolean b = false;
  public static HashMap<String, String> c = new HashMap();
  private static HashMap<String, Integer> d = new HashMap();
  private static WSDownloadParams e;
  private static String f;
  private static WSDownloadListenerWrapper g;
  private static WSDownloadListenerWrapper h;
  
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
    if (f()) {
      return c(paramInt1, paramInt2);
    }
    return b(paramInt1, paramInt2);
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
    localObject = (String)c.get(localObject);
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
  
  public static void a(int paramInt)
  {
    LocalMultiProcConfig.putInt("eventId", paramInt);
  }
  
  public static void a(Activity paramActivity, RockDownloadPresenter paramRockDownloadPresenter, WSDownloadParams paramWSDownloadParams, boolean paramBoolean, int paramInt)
  {
    a(paramWSDownloadParams.mEventId, paramInt);
    WeishiUtils.e(paramWSDownloadParams.mScheme);
    a(paramActivity, paramWSDownloadParams, paramBoolean, paramInt);
  }
  
  public static void a(Activity paramActivity, WSDownloadParams paramWSDownloadParams, boolean paramBoolean)
  {
    b(paramActivity, paramWSDownloadParams);
  }
  
  private static void a(String paramString, int paramInt)
  {
    Object localObject2 = DownloadManagerV2.a().d();
    if (localObject2 == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = null;
    Iterator localIterator = ((ConcurrentHashMap)localObject2).values().iterator();
    while (localIterator.hasNext())
    {
      localObject2 = (DownloadInfo)localIterator.next();
      if ((localObject2 != null) && (((DownloadInfo)localObject2).e.equals("com.tencent.weishi")) && (((DownloadInfo)localObject2).d != null) && (((DownloadInfo)localObject2).d.startsWith(c())) && (!((DownloadInfo)localObject2).d.equals(paramString))) {
        if ((((DownloadInfo)localObject2).a() == 4) && (a(((DownloadInfo)localObject2).q) < paramInt))
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
          if (System.currentTimeMillis() - ((DownloadInfo)localObject2).i > 2592000000L) {
            if (((DownloadInfo)localObject2).i > localObject3.i)
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
    return WSDeviceUtils.i();
  }
  
  public static boolean a(Activity paramActivity, WSDownloadParams paramWSDownloadParams)
  {
    a(false);
    if (WeishiGuideUtils.a(paramActivity))
    {
      WSLog.d("WeishiDownloadUtil", "本地已经安装微视app");
      return false;
    }
    if (!m())
    {
      WSLog.d("WeishiDownloadUtil", "预下载开关没打开");
      return false;
    }
    RockDownloadPresenter localRockDownloadPresenter = new RockDownloadPresenter();
    RockDownloadInfo localRockDownloadInfo = localRockDownloadPresenter.b();
    b(1);
    if (a(paramWSDownloadParams, localRockDownloadPresenter, localRockDownloadInfo, 1)) {
      return false;
    }
    if ((WSGlobalConfig.a().g()) && (a()))
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
      localObject = WSGlobalConfig.a().l();
      a(paramWSDownloadParams.mEventId, paramInt);
      WeishiUtils.e(paramWSDownloadParams.mScheme);
      return a(paramActivity, (String)localObject, paramBoolean, false, paramWSDownloadParams, paramInt);
    }
    WSLog.a("startQQDownload: activity is null Or params is null:");
    return false;
  }
  
  private static boolean a(Activity paramActivity, String paramString, boolean paramBoolean1, boolean paramBoolean2, WSDownloadParams paramWSDownloadParams, int paramInt)
  {
    WSLog.a("WeishiDownloadUtil", String.format("downloadWeishi : autoInstall = %s, showNotification = %s, mDownloadUrlStr = %s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), paramString }));
    i();
    Bundle localBundle = new Bundle();
    localBundle.putString(DownloadConstants.b, "10261931");
    localBundle.putString(DownloadConstants.l, a);
    localBundle.putString(DownloadConstants.f, "com.tencent.weishi");
    localBundle.putString(DownloadConstants.j, paramString);
    localBundle.putInt(DownloadConstants.k, 2);
    localBundle.putBoolean(DownloadConstants.h, false);
    localBundle.putBoolean(DownloadConstants.y, paramBoolean2 ^ true);
    DownloadProxy.a().a(paramActivity, localBundle, "biz_src_jc_gzh_weishi", null, 0);
    e = paramWSDownloadParams;
    WSReportDc00898.a(true, paramWSDownloadParams);
    WSReportDc00898.a(paramWSDownloadParams, 2);
    WSPublicAccReport.getInstance().reportDownload(paramWSDownloadParams.mEventId, paramInt, 1, 2, 0, paramWSDownloadParams.mScene);
    return true;
  }
  
  private static boolean a(WSDownloadParams paramWSDownloadParams, int paramInt, String paramString)
  {
    if (AppUtil.a(CommonDataAdapter.a().b(), paramString, "biz_src_jc_gzh_weishi", ""))
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
      WeishiUtils.e(paramString.mScheme);
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
      paramRockDownloadInfo = b((ArrayList)localObject, paramRockDownloadInfo);
      if (paramRockDownloadInfo != null)
      {
        if (paramInt == 1)
        {
          WSLog.c("WeishiDownloadUtil", "预下载包有效也不call安装----------------");
          return true;
        }
        if (WSGlobalConfig.a().b(1) == 2)
        {
          WSRecommendAdapter.f += 1;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("CCCCCCCCC onDownloadFinish SLIENT WSRecommendAdapter.openDownloadWSCount = ");
          ((StringBuilder)localObject).append(WSRecommendAdapter.f);
          WSLog.c("WeishiDownloadUtil", ((StringBuilder)localObject).toString());
        }
        paramRockDownloadPresenter.a(paramRockDownloadInfo, 1);
        WeishiUtils.e(paramWSDownloadParams.mScheme);
        WSLog.d("WeishiDownloadUtil", "本地Rock包的版本有效，直接安装");
        return true;
      }
    }
    paramRockDownloadPresenter = c(WSGlobalConfig.a().m());
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
      if (WSGlobalConfig.a().b(1) == 2)
      {
        WSRecommendAdapter.f += 1;
        paramRockDownloadInfo = new StringBuilder();
        paramRockDownloadInfo.append("DDDDDDDDDDD onDownloadFinish SLIENT WSRecommendAdapter.openDownloadWSCount = ");
        paramRockDownloadInfo.append(WSRecommendAdapter.f);
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
      paramArrayList = b(paramArrayList, paramRockDownloadInfo);
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
  
  private static WSDownloadListenerWrapper b(int paramInt1, int paramInt2)
  {
    if (g != null)
    {
      if (!g()) {
        a(paramInt1);
      }
      b(paramInt2);
      return g;
    }
    a(paramInt1);
    b(paramInt2);
    g = new WeishiDownloadUtil.1();
    DownloadManagerV2.a().a(g);
    return g;
  }
  
  private static RockDownloadInfo b(ArrayList<RockDownloadInfo> paramArrayList, RockDownloadInfo paramRockDownloadInfo)
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
  
  public static String b()
  {
    return "https://weseeugg.qq.com/download?channelid=204002177";
  }
  
  public static void b(int paramInt)
  {
    LocalMultiProcConfig.putInt("eventType", paramInt);
  }
  
  public static void b(Activity paramActivity, WSDownloadParams paramWSDownloadParams)
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
        if (a(paramWSDownloadParams, (RockDownloadPresenter)localObject, ((RockDownloadPresenter)localObject).b(), 3)) {
          return;
        }
        QQToast.makeText(paramActivity, HardCodeUtil.a(2131913817), 0).show();
        return;
      }
      if (g())
      {
        a(true);
        WSLog.d("WeishiDownloadUtil", "当前有正在下载的任务,不响应钩子下载请求,但更改下载类型为主动下载");
        if ((WSGlobalConfig.a().g()) && (a()))
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
      if ((WSGlobalConfig.a().f()) && (AppMarketUtils.a(paramActivity)))
      {
        WSLog.d("WeishiDownloadUtil", "主动点击 执行厂商下载-----");
        AppMarketUtils.b(paramActivity);
        b(3);
        WeishiUtils.e(paramWSDownloadParams.mScheme);
        paramWSDownloadParams.mStReportItem = UserActionReportPresenter.a();
        WSDownloadAppDialog.a(115, paramWSDownloadParams);
        WSReportDc00898.a(false, paramWSDownloadParams);
        WSReportDc00898.a(paramWSDownloadParams, 3);
        WSPublicAccReport.getInstance().reportDownload(paramWSDownloadParams.mEventId, 3, 0, 3, 0, paramWSDownloadParams.mScene);
        DownloadInfoReport.a(paramActivity, paramWSDownloadParams.mScheme, "com.tencent.weishi", "biz_src_jc_gzh_weishi");
        return;
      }
      RockDownloadInfo localRockDownloadInfo = ((RockDownloadPresenter)localObject).b();
      if (a(paramWSDownloadParams, (RockDownloadPresenter)localObject, localRockDownloadInfo, 3)) {
        return;
      }
      b(3);
      if ((!WSGlobalConfig.a().e()) && (!a()))
      {
        WSLog.a("WeishiDownloadUtil", "服务器关闭了4g开关");
        WSDownloadAppDialog.c(paramActivity, paramWSDownloadParams);
        return;
      }
      WSLog.a("WeishiDownloadUtil", "服务器打开了4g");
      if (WSGlobalConfig.a().g())
      {
        ((RockDownloadPresenter)localObject).a(paramActivity, localRockDownloadInfo, 3, paramWSDownloadParams, null);
        return;
      }
      WSDownloadAppDialog.b(paramActivity, paramWSDownloadParams);
      return;
    }
    WSLog.a("WeishiDownloadUtil", "rock download activity or params is null");
  }
  
  private static void b(DownloadInfo paramDownloadInfo, int paramInt)
  {
    if ((paramInt != 6) && (paramInt != 3))
    {
      WSLog.d("WeishiDownloadUtil", "下载器其他错误");
      return;
    }
    WSLog.d("WeishiDownloadUtil", " 下载器的DB还没准备就绪,重新注册监听，并重试下载一次");
    if (d.containsKey(paramDownloadInfo.d))
    {
      localInteger = (Integer)d.get(paramDownloadInfo.d);
      if (localInteger != null)
      {
        paramInt = localInteger.intValue();
        d.put(paramDownloadInfo.d, Integer.valueOf(paramInt + 1));
      }
    }
    else
    {
      d.put(paramDownloadInfo.d, Integer.valueOf(1));
    }
    Integer localInteger = (Integer)d.get(paramDownloadInfo.d);
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
        if (WSGlobalConfig.a().b(1) == 2)
        {
          WSRecommendAdapter.f += 1;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramString);
          localStringBuilder.append(" onDownloadFinish SLIENT WSRecommendAdapter.openDownloadWSCount = ");
          localStringBuilder.append(WSRecommendAdapter.f);
          WSLog.b("WeishiDownloadUtil", localStringBuilder.toString());
        }
        else
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("processDownloadFinish, this is maybe DTest silent download,linktype is :");
          localStringBuilder.append(WSGlobalConfig.a().b(1));
          WSLog.a("WeishiDownloadUtil", localStringBuilder.toString());
        }
      }
      else
      {
        if (!j()) {
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
      WSPublicAccReport.getInstance().reportDownload(d(), paramInt2, 2, 2, 0, n());
      if (paramDownloadInfo.w) {
        WSPublicAccReport.getInstance().reportDownload(d(), paramInt2, 2, 2, 1, n());
      }
      if (paramInt1 == 8) {
        UserActionReportPresenter.a(132, 10, null);
      } else if (paramInt1 == 401) {
        UserActionReportPresenter.a(138, 1, null);
      }
      if (d.containsKey(paramDownloadInfo.d))
      {
        d.remove(paramDownloadInfo.d);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append(" onDownloadFinish remove retryCount!");
        WSLog.d("WeishiDownloadUtil", localStringBuilder.toString());
      }
      if (i != 0)
      {
        paramString = c(WSGlobalConfig.a().m());
        a(e, paramInt2, paramString);
      }
      a(paramDownloadInfo.d, WSGlobalConfig.a().m());
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
      DownloadManagerV2.a().b(g);
      WSRecommendAdapter.f = 0;
      if (paramBoolean) {
        h = null;
      } else {
        g = null;
      }
      int i = d();
      int j = e();
      WSReportDC898Vertical.b(i);
      WSReportDc00898.b(2);
      WSPublicAccReport.getInstance().reportDownload(i, j, 2, 2, 2, n());
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
  
  private static boolean b(DownloadInfo paramDownloadInfo)
  {
    return (paramDownloadInfo != null) && (TextUtils.equals(paramDownloadInfo.e, "com.tencent.weishi")) && (paramDownloadInfo.d != null) && (paramDownloadInfo.d.startsWith(c()));
  }
  
  private static WSDownloadListenerWrapper c(int paramInt1, int paramInt2)
  {
    WSLog.a("WeishiDownloadUtil", "createQzoneListener~~~");
    if (h != null)
    {
      if (!g()) {
        a(paramInt1);
      }
      b(paramInt2);
      return h;
    }
    a(paramInt1);
    b(paramInt2);
    h = new WeishiDownloadUtil.2();
    DownloadManagerV2.a().a(h);
    WSLog.a("WeishiDownloadUtil", "qzone registerListener");
    return h;
  }
  
  public static String c()
  {
    return "https://weseeugg.qq.com/download?channelid=";
  }
  
  private static String c(int paramInt)
  {
    Object localObject2 = DownloadManagerV2.a().b("com.tencent.weishi", 4);
    Object localObject1 = localObject2;
    if (((List)localObject2).size() == 0) {
      localObject1 = DownloadManagerV2.a().a("com.tencent.weishi", 4);
    }
    localObject2 = DownloadManager.b().d("10261931");
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
        if ((((DownloadInfo)localObject1).a() == 4) && (TextUtils.equals(((DownloadInfo)localObject1).e, "com.tencent.weishi")) && (((DownloadInfo)localObject1).d != null) && (((DownloadInfo)localObject1).d.startsWith(c()))) {
          if (TextUtils.isEmpty(((DownloadInfo)localObject1).q))
          {
            WSLog.a("WeishiDownloadUtil", "QQ下载包filePath为空!!!");
          }
          else
          {
            int i = a(((DownloadInfo)localObject1).q);
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
              return ((DownloadInfo)localObject1).q;
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
  
  public static int d()
  {
    return LocalMultiProcConfig.getInt("eventId", -1);
  }
  
  public static int e()
  {
    return LocalMultiProcConfig.getInt("eventType", -1);
  }
  
  public static boolean f()
  {
    String str = l();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("~~~~~~~~~~~~~~~~~~~~~~~~~currentProcessName:");
    localStringBuilder.append(str);
    WSLog.b("WeishiDownloadUtil", localStringBuilder.toString());
    return "com.tencent.mobileqq:qzone".equals(str);
  }
  
  public static boolean g()
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
  
  public static void h()
  {
    WSLog.a("WeishiDownloadUtil", "resetDownloadingMark");
    LocalMultiProcConfig.putBool("weishi_downloading_key", false);
    LocalMultiProcConfig.putLong("weishi_downloading_start_time_key", 0L);
  }
  
  public static void i()
  {
    WSLog.a("WeishiDownloadUtil", "updateDownloadingMark");
    LocalMultiProcConfig.putBool("weishi_downloading_key", true);
    LocalMultiProcConfig.putLong("weishi_downloading_start_time_key", System.currentTimeMillis());
  }
  
  public static boolean j()
  {
    WSLog.a("WeishiDownloadUtil", "getPreDownloadingClick");
    return LocalMultiProcConfig.getBool("preDownloadingClick", false);
  }
  
  private static String l()
  {
    Object localObject = f;
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
          f = (String)localObject;
          return localObject;
        }
      }
    }
    return null;
  }
  
  private static boolean m()
  {
    return (WSExpABTestManager.a().e()) && (!TextUtils.isEmpty(WSGlobalConfig.a().k())) && (WSGlobalConfig.a().k().startsWith("http"));
  }
  
  private static int n()
  {
    WSDownloadParams localWSDownloadParams = e;
    if (localWSDownloadParams != null) {
      return localWSDownloadParams.mScene;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.download.WeishiDownloadUtil
 * JD-Core Version:    0.7.0.1
 */