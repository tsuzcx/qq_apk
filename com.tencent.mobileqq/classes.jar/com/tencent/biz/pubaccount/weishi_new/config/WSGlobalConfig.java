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
    WSLog.d("WSGlobalConfigLog", "globalConfig info:stGlobalConfig: {\nis_call_weishi=" + paramstGlobalConfig.is_call_weishi + ", link_strategy_type=" + paramstGlobalConfig.link_strategy_type + ", open_4g_autodownload=" + paramstGlobalConfig.open_4g_autodownload + ", cache_size=" + paramstGlobalConfig.cache_size + ", is_direct_open=" + paramstGlobalConfig.is_direct_open + ", encrypted_deviceid=" + paramstGlobalConfig.encrypted_deviceid + "\ncommentConfig=" + paramstGlobalConfig.commentConfig + "\nlinkConfig=" + paramstGlobalConfig.linkConfig + "\ndownload=" + paramstGlobalConfig.download + "\nmapExt=" + paramstGlobalConfig.mapExt + "\n}");
  }
  
  private boolean b(int paramInt)
  {
    return (a(paramInt) == null) || (a(paramInt).linkConfig == null);
  }
  
  private boolean d()
  {
    return (this.jdField_a_of_type_UserGrowthStGlobalConfig == null) || (this.jdField_a_of_type_UserGrowthStGlobalConfig.download == null);
  }
  
  @Deprecated
  public int a()
  {
    if (this.jdField_a_of_type_UserGrowthStGlobalConfig != null) {
      return this.jdField_a_of_type_UserGrowthStGlobalConfig.link_strategy_type;
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
    if (this.jdField_a_of_type_UserGrowthStGlobalConfig == null) {
      return null;
    }
    return this.jdField_a_of_type_UserGrowthStGlobalConfig.callinfo;
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
    if (this.jdField_a_of_type_UserGrowthStGlobalConfig == null) {
      return null;
    }
    return this.jdField_a_of_type_UserGrowthStGlobalConfig.user_auth;
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
    WSLog.d("WSGlobalConfigLog", "initGlobalConfig globalConfig:" + paramstGlobalConfig);
    a(paramstGlobalConfig);
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_UserGrowthStGlobalConfig == null) || (this.jdField_a_of_type_UserGrowthStGlobalConfig.open_4g_autodownload != 0);
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
    boolean bool2 = false;
    stJumpInfo localstJumpInfo = a(paramInt2);
    boolean bool1 = bool2;
    if (localstJumpInfo != null)
    {
      bool1 = bool2;
      if (localstJumpInfo.index >= 0)
      {
        bool1 = bool2;
        if (localstJumpInfo.id > 0)
        {
          WSLog.a("WSGlobalConfigLog", "全屏阻断页是第" + localstJumpInfo.index + "个,id为：" + localstJumpInfo.id);
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
        this.jdField_a_of_type_UserGrowthStGlobalConfig.download.qqDownloadUrl = (WeishiDownloadUtil.a() + "&versioncode=" + c());
        WSLog.c("WeishiDownloadUtil", "服务器下发QQDownloadUrl失败，使用默认的:" + this.jdField_a_of_type_UserGrowthStGlobalConfig.download.qqDownloadUrl);
      }
      WSLog.d("WeishiDownloadUtil", "服务器下发QQDownloadUrl: " + this.jdField_a_of_type_UserGrowthStGlobalConfig.download.qqDownloadUrl);
      return this.jdField_a_of_type_UserGrowthStGlobalConfig.download.qqDownloadUrl;
    }
    return WeishiDownloadUtil.a();
  }
  
  public String e()
  {
    if (Thread.currentThread().getId() != Looper.getMainLooper().getThread().getId())
    {
      str = WSSharePreferencesUtil.a("encryptedDeviceId", "");
      WSLog.a("WSGlobalConfigLog", "WSSharePreferencesUtil load encrypted_deviceid:" + str);
      return str;
    }
    if (this.jdField_a_of_type_UserGrowthStGlobalConfig != null)
    {
      str = this.jdField_a_of_type_UserGrowthStGlobalConfig.encrypted_deviceid;
      if (!TextUtils.isEmpty(str))
      {
        WSSharePreferencesUtil.a("encryptedDeviceId", str);
        WSLog.a("WSGlobalConfigLog", "WSSharePreferencesUtil save encrypted_deviceid:" + str);
        return str;
      }
    }
    String str = WSSharePreferencesUtil.a("encryptedDeviceId", "");
    WSLog.a("WSGlobalConfigLog", "WSSharePreferencesUtil load encrypted_deviceid:" + str);
    return str;
  }
  
  public String f()
  {
    if ((this.jdField_a_of_type_UserGrowthStGlobalConfig != null) && (this.jdField_a_of_type_UserGrowthStGlobalConfig.commentConfig != null)) {
      return this.jdField_a_of_type_UserGrowthStGlobalConfig.commentConfig.guideText;
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.config.WSGlobalConfig
 * JD-Core Version:    0.7.0.1
 */