package com.tencent.biz.pubaccount.weishi_new.config;

import UserGrowth.downloadConfig;
import UserGrowth.stCallInfo;
import UserGrowth.stCommentConfig;
import UserGrowth.stGlobalConfig;
import UserGrowth.stJumpInfo;
import UserGrowth.stLinkConfig;
import UserGrowth.stPopWindowsConfig;
import UserGrowth.stUserAuth;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.biz.pubaccount.weishi_new.download.WeishiDownloadUtil;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WSSharePreferencesUtil;
import java.util.ArrayList;

public class WSGlobalConfig
{
  private stGlobalConfig jdField_a_of_type_UserGrowthStGlobalConfig;
  private SparseArray<stGlobalConfig> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  
  private stPopWindowsConfig a(int paramInt)
  {
    stGlobalConfig localstGlobalConfig = a(paramInt);
    if ((localstGlobalConfig != null) && (localstGlobalConfig.windows_config != null) && (localstGlobalConfig.windows_config.size() > 0)) {
      return (stPopWindowsConfig)localstGlobalConfig.windows_config.get(0);
    }
    return null;
  }
  
  public static WSGlobalConfig a()
  {
    return WSGlobalConfig.SingletonHolder.a();
  }
  
  private void a(stGlobalConfig paramstGlobalConfig)
  {
    if (paramstGlobalConfig == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("globalConfig info:stGlobalConfig: {\nis_call_weishi=");
    localStringBuilder.append(paramstGlobalConfig.is_call_weishi);
    localStringBuilder.append(", link_strategy_type=");
    localStringBuilder.append(paramstGlobalConfig.link_strategy_type);
    localStringBuilder.append(", open_4g_autodownload=");
    localStringBuilder.append(paramstGlobalConfig.open_4g_autodownload);
    localStringBuilder.append(", cache_size=");
    localStringBuilder.append(paramstGlobalConfig.cache_size);
    localStringBuilder.append(", is_direct_open=");
    localStringBuilder.append(paramstGlobalConfig.is_direct_open);
    localStringBuilder.append(", encrypted_deviceid=");
    localStringBuilder.append(paramstGlobalConfig.encrypted_deviceid);
    localStringBuilder.append("\ncommentConfig=");
    localStringBuilder.append(paramstGlobalConfig.commentConfig);
    localStringBuilder.append("\nlinkConfig=");
    localStringBuilder.append(paramstGlobalConfig.linkConfig);
    localStringBuilder.append("\ndownload=");
    localStringBuilder.append(paramstGlobalConfig.download);
    localStringBuilder.append("\nmapExt=");
    localStringBuilder.append(paramstGlobalConfig.mapExt);
    localStringBuilder.append("\n}");
    WSLog.d("WSGlobalConfigLog", localStringBuilder.toString());
  }
  
  private boolean b(int paramInt)
  {
    return (a(paramInt) == null) || (a(paramInt).linkConfig == null);
  }
  
  private boolean d()
  {
    stGlobalConfig localstGlobalConfig = this.jdField_a_of_type_UserGrowthStGlobalConfig;
    return (localstGlobalConfig == null) || (localstGlobalConfig.download == null);
  }
  
  @Deprecated
  public int a()
  {
    stGlobalConfig localstGlobalConfig = this.jdField_a_of_type_UserGrowthStGlobalConfig;
    if (localstGlobalConfig != null) {
      return localstGlobalConfig.link_strategy_type;
    }
    return 1;
  }
  
  public int a(int paramInt)
  {
    stGlobalConfig localstGlobalConfig = a(paramInt);
    if (localstGlobalConfig != null) {
      return localstGlobalConfig.link_strategy_type;
    }
    return 1;
  }
  
  public stCallInfo a()
  {
    stGlobalConfig localstGlobalConfig = this.jdField_a_of_type_UserGrowthStGlobalConfig;
    if (localstGlobalConfig == null) {
      return null;
    }
    return localstGlobalConfig.callinfo;
  }
  
  public stGlobalConfig a(int paramInt)
  {
    return (stGlobalConfig)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
  }
  
  public stJumpInfo a(int paramInt)
  {
    stGlobalConfig localstGlobalConfig = a(paramInt);
    if (localstGlobalConfig != null) {
      return localstGlobalConfig.jumpinfo;
    }
    return null;
  }
  
  public stUserAuth a()
  {
    stGlobalConfig localstGlobalConfig = this.jdField_a_of_type_UserGrowthStGlobalConfig;
    if (localstGlobalConfig == null) {
      return null;
    }
    return localstGlobalConfig.user_auth;
  }
  
  public String a()
  {
    if (!d()) {
      return this.jdField_a_of_type_UserGrowthStGlobalConfig.download.packageName;
    }
    return "";
  }
  
  public void a(int paramInt, stGlobalConfig paramstGlobalConfig)
  {
    this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, paramstGlobalConfig);
    this.jdField_a_of_type_UserGrowthStGlobalConfig = paramstGlobalConfig;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("initGlobalConfig globalConfig:");
    localStringBuilder.append(paramstGlobalConfig);
    WSLog.d("WSGlobalConfigLog", localStringBuilder.toString());
    a(paramstGlobalConfig);
  }
  
  public boolean a()
  {
    stGlobalConfig localstGlobalConfig = this.jdField_a_of_type_UserGrowthStGlobalConfig;
    return (localstGlobalConfig == null) || (localstGlobalConfig.open_4g_autodownload != 0);
  }
  
  public boolean a(int paramInt)
  {
    if (!b(paramInt)) {
      return a(paramInt).linkConfig.isOpenVideoPage;
    }
    return true;
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    stJumpInfo localstJumpInfo = a(paramInt2);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localstJumpInfo != null)
    {
      bool1 = bool2;
      if (localstJumpInfo.index >= 0)
      {
        bool1 = bool2;
        if (localstJumpInfo.id > 0)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("全屏阻断页是第");
          localStringBuilder.append(localstJumpInfo.index);
          localStringBuilder.append("个,id为：");
          localStringBuilder.append(localstJumpInfo.id);
          WSLog.a("WSGlobalConfigLog", localStringBuilder.toString());
          bool1 = bool2;
          if (paramInt1 == localstJumpInfo.index) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public int b()
  {
    if (!d()) {
      return this.jdField_a_of_type_UserGrowthStGlobalConfig.download.vendorId;
    }
    return 0;
  }
  
  public int b(int paramInt)
  {
    if (!b(paramInt)) {
      return a(paramInt).linkConfig.callCount;
    }
    return 10000;
  }
  
  public String b()
  {
    if (!d()) {
      return this.jdField_a_of_type_UserGrowthStGlobalConfig.download.downloadUrl;
    }
    return "";
  }
  
  public boolean b()
  {
    return (!d()) && (this.jdField_a_of_type_UserGrowthStGlobalConfig.download.appStoreSwitch);
  }
  
  public int c()
  {
    if (!d()) {
      return this.jdField_a_of_type_UserGrowthStGlobalConfig.download.versionCode;
    }
    return 0;
  }
  
  public int c(int paramInt)
  {
    if (!b(paramInt)) {
      return a(paramInt).linkConfig.downloadCount;
    }
    return 10000;
  }
  
  public String c()
  {
    if (!d()) {
      return this.jdField_a_of_type_UserGrowthStGlobalConfig.download.preloadDownloadUrl;
    }
    return "";
  }
  
  public boolean c()
  {
    return (!d()) && (this.jdField_a_of_type_UserGrowthStGlobalConfig.download.enableRock);
  }
  
  public int d()
  {
    stGlobalConfig localstGlobalConfig = a(1);
    if (localstGlobalConfig != null) {
      return localstGlobalConfig.cache_size;
    }
    return 14;
  }
  
  public int d(int paramInt)
  {
    stPopWindowsConfig localstPopWindowsConfig = a(paramInt);
    if (localstPopWindowsConfig != null) {
      return localstPopWindowsConfig.index;
    }
    return -1;
  }
  
  public String d()
  {
    if (!d())
    {
      if (TextUtils.isEmpty(this.jdField_a_of_type_UserGrowthStGlobalConfig.download.qqDownloadUrl))
      {
        localObject = this.jdField_a_of_type_UserGrowthStGlobalConfig.download;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(WeishiDownloadUtil.a());
        localStringBuilder.append("&versioncode=");
        localStringBuilder.append(c());
        ((downloadConfig)localObject).qqDownloadUrl = localStringBuilder.toString();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("服务器下发QQDownloadUrl失败，使用默认的:");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_UserGrowthStGlobalConfig.download.qqDownloadUrl);
        WSLog.c("WeishiDownloadUtil", ((StringBuilder)localObject).toString());
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("服务器下发QQDownloadUrl: ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_UserGrowthStGlobalConfig.download.qqDownloadUrl);
      WSLog.d("WeishiDownloadUtil", ((StringBuilder)localObject).toString());
      return this.jdField_a_of_type_UserGrowthStGlobalConfig.download.qqDownloadUrl;
    }
    return WeishiDownloadUtil.a();
  }
  
  public String e()
  {
    if (Thread.currentThread().getId() != Looper.getMainLooper().getThread().getId())
    {
      localObject = WSSharePreferencesUtil.a("encryptedDeviceId", "");
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("WSSharePreferencesUtil load encrypted_deviceid:");
      localStringBuilder.append((String)localObject);
      WSLog.a("WSGlobalConfigLog", localStringBuilder.toString());
      return localObject;
    }
    Object localObject = this.jdField_a_of_type_UserGrowthStGlobalConfig;
    if (localObject != null)
    {
      localObject = ((stGlobalConfig)localObject).encrypted_deviceid;
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        WSSharePreferencesUtil.a("encryptedDeviceId", (String)localObject);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("WSSharePreferencesUtil save encrypted_deviceid:");
        localStringBuilder.append((String)localObject);
        WSLog.a("WSGlobalConfigLog", localStringBuilder.toString());
        return localObject;
      }
    }
    localObject = WSSharePreferencesUtil.a("encryptedDeviceId", "");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WSSharePreferencesUtil load encrypted_deviceid:");
    localStringBuilder.append((String)localObject);
    WSLog.a("WSGlobalConfigLog", localStringBuilder.toString());
    return localObject;
  }
  
  public String f()
  {
    stGlobalConfig localstGlobalConfig = this.jdField_a_of_type_UserGrowthStGlobalConfig;
    if ((localstGlobalConfig != null) && (localstGlobalConfig.commentConfig != null)) {
      return this.jdField_a_of_type_UserGrowthStGlobalConfig.commentConfig.guideText;
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.config.WSGlobalConfig
 * JD-Core Version:    0.7.0.1
 */