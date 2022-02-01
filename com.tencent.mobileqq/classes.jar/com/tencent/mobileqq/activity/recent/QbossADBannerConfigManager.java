package com.tencent.mobileqq.activity.recent;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.DownloaderFactory;
import com.tencent.component.network.downloader.Downloader;
import com.tencent.image.Utils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qbosssplash.common.QbossSplashUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.ad.TianshuSplashUtils;
import cooperation.vip.pb.TianShuAccess.AdItem;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;

public class QbossADBannerConfigManager
{
  private static QbossADBannerConfigManager jdField_a_of_type_ComTencentMobileqqActivityRecentQbossADBannerConfigManager = null;
  private Downloader jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader = DownloaderFactory.getInstance(BaseApplicationImpl.getContext()).getCommonDownloader();
  private File jdField_a_of_type_JavaIoFile = new File(BaseApplicationImpl.getApplication().getCacheDir(), "qboss_ad");
  private HashMap<String, Long> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private Map<String, QbossADBannerConfigInfo> jdField_a_of_type_JavaUtilMap = new HashMap();
  private volatile boolean jdField_a_of_type_Boolean = false;
  
  public static QbossADBannerConfigManager a()
  {
    if (jdField_a_of_type_ComTencentMobileqqActivityRecentQbossADBannerConfigManager == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqActivityRecentQbossADBannerConfigManager == null) {
        jdField_a_of_type_ComTencentMobileqqActivityRecentQbossADBannerConfigManager = new QbossADBannerConfigManager();
      }
      return jdField_a_of_type_ComTencentMobileqqActivityRecentQbossADBannerConfigManager;
    }
    finally {}
  }
  
  private String a(int paramInt)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    String str = "";
    if (localAppRuntime != null) {
      str = localAppRuntime.getAccount();
    }
    return paramInt + "_" + str;
  }
  
  private void a(QbossADBannerConfigInfo paramQbossADBannerConfigInfo, String paramString, boolean paramBoolean)
  {
    if ((paramQbossADBannerConfigInfo == null) || (TextUtils.isEmpty(paramString)) || (paramQbossADBannerConfigInfo.a == null)) {
      return;
    }
    int i = 0;
    label22:
    QbossADBannerConfigInfo.ResourceInfo localResourceInfo;
    if (i < paramQbossADBannerConfigInfo.a.size())
    {
      localResourceInfo = (QbossADBannerConfigInfo.ResourceInfo)paramQbossADBannerConfigInfo.a.valueAt(i);
      if ((localResourceInfo != null) && (!TextUtils.isEmpty(localResourceInfo.a))) {
        break label73;
      }
    }
    for (;;)
    {
      i += 1;
      break label22;
      break;
      label73:
      if (localResourceInfo.a.equalsIgnoreCase(paramString)) {
        localResourceInfo.a(paramBoolean);
      }
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Boolean = false;
    if (paramQQAppInterface == null) {
      return;
    }
    QLog.i("QbossADBannerConfigManager", 1, "notifyBannerShow");
    BannerManager.a().b(23, 3000);
  }
  
  private void b(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Boolean = false;
    if (paramQQAppInterface == null) {
      return;
    }
    QLog.i("QbossADBannerConfigManager", 1, "notifyBannerHide");
    BannerManager.a().b(23, 3001);
  }
  
  private void b(QQAppInterface paramQQAppInterface, QbossADBannerConfigInfo paramQbossADBannerConfigInfo)
  {
    if ((paramQbossADBannerConfigInfo == null) || (paramQbossADBannerConfigInfo.a == null) || (paramQbossADBannerConfigInfo.a.size() == 0))
    {
      b(paramQQAppInterface);
      return;
    }
    QbossADBannerConfigManager.QbossDownloadListener localQbossDownloadListener = new QbossADBannerConfigManager.QbossDownloadListener(this, paramQQAppInterface, paramQbossADBannerConfigInfo, paramQbossADBannerConfigInfo.a.size());
    int i = 0;
    label48:
    QbossADBannerConfigInfo.ResourceInfo localResourceInfo;
    if (i < paramQbossADBannerConfigInfo.a.size())
    {
      localResourceInfo = (QbossADBannerConfigInfo.ResourceInfo)paramQbossADBannerConfigInfo.a.valueAt(i);
      if ((localResourceInfo == null) || (TextUtils.isEmpty(localResourceInfo.a)))
      {
        QLog.e("QbossADBannerConfigManager", 1, "download data = null");
        b(paramQQAppInterface);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("QbossADBannerConfigManager", 2, "start downloadFile , url = " + localResourceInfo.a);
      }
      if (!FileUtil.a(localResourceInfo.c)) {
        break label201;
      }
      localQbossDownloadListener.onDownloadSucceed(localResourceInfo.a, null);
      if (QLog.isColorLevel()) {
        QLog.i("QbossADBannerConfigManager", 2, "current res has download , onsuccess, url = " + localResourceInfo.a);
      }
    }
    for (;;)
    {
      i += 1;
      break label48;
      break;
      label201:
      if (this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader != null) {
        this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader.download(localResourceInfo.a, localResourceInfo.c, false, localQbossDownloadListener);
      }
    }
  }
  
  public QbossADBannerConfigInfo a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.i("QbossADBannerConfigManager", 1, "getQBossADBannerConfig uin is empty. return.");
      return null;
    }
    if (this.jdField_a_of_type_JavaUtilMap.isEmpty())
    {
      ??? = TianshuSplashUtils.a(BaseApplicationImpl.getContext(), paramString);
      String str = TianshuSplashUtils.a(paramString);
      QLog.i("QbossADBannerConfigManager", 1, "getCurrentUnionBannerInfoFromSp adId: " + str);
      if (!TextUtils.isEmpty(str))
      {
        Object localObject2 = ((SharedPreferences)???).getString("splash_union_banner_type_" + str, "-1");
        localObject2 = QbossADBannerConfigInfo.a(new TianShuAccess.AdItem(), (String)localObject2);
        ((QbossADBannerConfigInfo)localObject2).a((SharedPreferences)???, str);
        this.jdField_a_of_type_JavaUtilMap.put(paramString, localObject2);
      }
    }
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      paramString = (QbossADBannerConfigInfo)this.jdField_a_of_type_JavaUtilMap.get(paramString);
      return paramString;
    }
  }
  
  public String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    return this.jdField_a_of_type_JavaIoFile.getAbsolutePath() + File.separator + Utils.Crc64String(paramString) + paramString.substring(paramString.lastIndexOf("."));
  }
  
  public void a(long paramLong)
  {
    a(paramLong, 2741);
    a(paramLong, 2742);
  }
  
  public void a(long paramLong, int paramInt)
  {
    long l2 = NetConnInfoCenter.getServerTime();
    long l1 = paramLong;
    if (paramLong > l2 + 86400L)
    {
      paramLong = l2 + 86400L;
      l1 = paramLong;
      if (QLog.isDevelopLevel())
      {
        QLog.i("QbossADBannerConfigManager", 4, "saveQbossNextRequestTime nextRequestTime upper limit 24 " + paramLong);
        l1 = paramLong;
      }
    }
    if (paramInt == 2741) {
      this.jdField_a_of_type_JavaUtilHashMap.put(a(paramInt), Long.valueOf(l1));
    }
    for (;;)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("QbossADBannerConfigManager", 4, "saveQbossNextRequestTime appid = " + paramInt + " nextRequestTime =  " + l1);
      }
      return;
      SharedPreferences.Editor localEditor = QbossSplashUtil.a().edit();
      localEditor.putLong("qbossNextRequestTime_" + paramInt, l1);
      localEditor.commit();
    }
  }
  
  public void a(QbossADBannerConfigInfo paramQbossADBannerConfigInfo, String paramString)
  {
    localMap = this.jdField_a_of_type_JavaUtilMap;
    if (paramQbossADBannerConfigInfo == null) {}
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_JavaUtilMap.remove(paramString);
        return;
      }
      finally {}
      this.jdField_a_of_type_JavaUtilMap.put(paramString, paramQbossADBannerConfigInfo);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, QbossADBannerConfigInfo paramQbossADBannerConfigInfo)
  {
    if (paramQQAppInterface == null)
    {
      QLog.i("QbossADBannerConfigManager", 1, "saveQBossADBannerConfigAndNotify app is null. return.");
      return;
    }
    String str = paramQQAppInterface.getCurrentUin();
    if (TextUtils.isEmpty(str))
    {
      QLog.i("QbossADBannerConfigManager", 1, "saveQBossADBannerConfigAndNotify uin is empty. return.");
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      QLog.i("QbossADBannerConfigManager", 1, "saveQBossADBannerConfigAndNotify mIsDownloading = " + this.jdField_a_of_type_Boolean + " multi banner show");
      return;
    }
    a(paramQbossADBannerConfigInfo, str);
    a(paramQQAppInterface, paramQbossADBannerConfigInfo, true);
  }
  
  public void a(QQAppInterface paramQQAppInterface, QbossADBannerConfigInfo paramQbossADBannerConfigInfo, boolean paramBoolean)
  {
    if (paramQQAppInterface == null) {}
    do
    {
      return;
      if (paramQbossADBannerConfigInfo == null)
      {
        QLog.i("QbossADBannerConfigManager", 1, "saveQBossADBannerConfigAndNotify QBossADBannerConfigInfo = null notifyBannerHide");
        b(paramQQAppInterface);
        return;
      }
      if (!paramQbossADBannerConfigInfo.b()) {
        break;
      }
    } while (!paramBoolean);
    QLog.i("QbossADBannerConfigManager", 1, "checkIsFileExist exist , notifyBannerShow ");
    a(paramQQAppInterface);
    return;
    QLog.i("QbossADBannerConfigManager", 1, "checkIsFileExist is not exist , start downloadFile ");
    this.jdField_a_of_type_Boolean = true;
    b(paramQQAppInterface, paramQbossADBannerConfigInfo);
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.i("QbossADBannerConfigManager", 1, "removeQBossADBannerConfig uin is empty. return.");
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      this.jdField_a_of_type_JavaUtilMap.remove(paramString);
      return;
    }
  }
  
  public boolean a(int paramInt)
  {
    long l1 = 0L;
    long l2 = NetConnInfoCenter.getServerTime();
    StringBuilder localStringBuilder;
    if (paramInt == 2741)
    {
      if (this.jdField_a_of_type_JavaUtilHashMap.get(a(paramInt)) != null) {
        l1 = ((Long)this.jdField_a_of_type_JavaUtilHashMap.get(a(paramInt))).longValue();
      }
      localStringBuilder = new StringBuilder().append("isQbossRequestEnable ");
      if (l2 <= l1) {
        break label141;
      }
    }
    label141:
    for (boolean bool = true;; bool = false)
    {
      QLog.e("QbossADBannerConfigManager", 1, bool + " appid = " + paramInt);
      if (l2 <= l1) {
        break label147;
      }
      return true;
      l1 = QbossSplashUtil.a().getLong("qbossNextRequestTime_" + paramInt, 0L);
      break;
    }
    label147:
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.QbossADBannerConfigManager
 * JD-Core Version:    0.7.0.1
 */