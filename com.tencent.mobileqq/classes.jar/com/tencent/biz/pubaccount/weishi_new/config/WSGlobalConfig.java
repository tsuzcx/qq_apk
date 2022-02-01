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
  private stGlobalConfig a;
  private SparseArray<stGlobalConfig> b = new SparseArray();
  
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
  
  private boolean g(int paramInt)
  {
    return (a(paramInt) == null) || (a(paramInt).linkConfig == null);
  }
  
  private stPopWindowsConfig h(int paramInt)
  {
    stGlobalConfig localstGlobalConfig = a(paramInt);
    if ((localstGlobalConfig != null) && (localstGlobalConfig.windows_config != null) && (localstGlobalConfig.windows_config.size() > 0)) {
      return (stPopWindowsConfig)localstGlobalConfig.windows_config.get(0);
    }
    return null;
  }
  
  private boolean q()
  {
    stGlobalConfig localstGlobalConfig = this.a;
    return (localstGlobalConfig == null) || (localstGlobalConfig.download == null);
  }
  
  public stGlobalConfig a(int paramInt)
  {
    return (stGlobalConfig)this.b.get(paramInt);
  }
  
  public void a(int paramInt, stGlobalConfig paramstGlobalConfig)
  {
    this.b.put(paramInt, paramstGlobalConfig);
    this.a = paramstGlobalConfig;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("initGlobalConfig globalConfig:");
    localStringBuilder.append(paramstGlobalConfig);
    WSLog.d("WSGlobalConfigLog", localStringBuilder.toString());
    a(paramstGlobalConfig);
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    stJumpInfo localstJumpInfo = f(paramInt2);
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
  
  public int b(int paramInt)
  {
    stGlobalConfig localstGlobalConfig = a(paramInt);
    if (localstGlobalConfig != null) {
      return localstGlobalConfig.link_strategy_type;
    }
    return 1;
  }
  
  public stCallInfo b()
  {
    stGlobalConfig localstGlobalConfig = this.a;
    if (localstGlobalConfig == null) {
      return null;
    }
    return localstGlobalConfig.callinfo;
  }
  
  public int c(int paramInt)
  {
    if (!g(paramInt)) {
      return a(paramInt).linkConfig.callCount;
    }
    return 10000;
  }
  
  public stUserAuth c()
  {
    stGlobalConfig localstGlobalConfig = this.a;
    if (localstGlobalConfig == null) {
      return null;
    }
    return localstGlobalConfig.user_auth;
  }
  
  @Deprecated
  public int d()
  {
    stGlobalConfig localstGlobalConfig = this.a;
    if (localstGlobalConfig != null) {
      return localstGlobalConfig.link_strategy_type;
    }
    return 1;
  }
  
  public boolean d(int paramInt)
  {
    if (!g(paramInt)) {
      return a(paramInt).linkConfig.isOpenVideoPage;
    }
    return true;
  }
  
  public int e(int paramInt)
  {
    stPopWindowsConfig localstPopWindowsConfig = h(paramInt);
    if (localstPopWindowsConfig != null) {
      return localstPopWindowsConfig.index;
    }
    return -1;
  }
  
  public boolean e()
  {
    stGlobalConfig localstGlobalConfig = this.a;
    return (localstGlobalConfig == null) || (localstGlobalConfig.open_4g_autodownload != 0);
  }
  
  public stJumpInfo f(int paramInt)
  {
    stGlobalConfig localstGlobalConfig = a(paramInt);
    if (localstGlobalConfig != null) {
      return localstGlobalConfig.jumpinfo;
    }
    return null;
  }
  
  public boolean f()
  {
    return (!q()) && (this.a.download.appStoreSwitch);
  }
  
  public boolean g()
  {
    return (!q()) && (this.a.download.enableRock);
  }
  
  public String h()
  {
    if (!q()) {
      return this.a.download.packageName;
    }
    return "";
  }
  
  public int i()
  {
    if (!q()) {
      return this.a.download.vendorId;
    }
    return 0;
  }
  
  public String j()
  {
    if (!q()) {
      return this.a.download.downloadUrl;
    }
    return "";
  }
  
  public String k()
  {
    if (!q()) {
      return this.a.download.preloadDownloadUrl;
    }
    return "";
  }
  
  public String l()
  {
    if (!q())
    {
      if (TextUtils.isEmpty(this.a.download.qqDownloadUrl))
      {
        localObject = this.a.download;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(WeishiDownloadUtil.b());
        localStringBuilder.append("&versioncode=");
        localStringBuilder.append(m());
        ((downloadConfig)localObject).qqDownloadUrl = localStringBuilder.toString();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("服务器下发QQDownloadUrl失败，使用默认的:");
        ((StringBuilder)localObject).append(this.a.download.qqDownloadUrl);
        WSLog.c("WeishiDownloadUtil", ((StringBuilder)localObject).toString());
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("服务器下发QQDownloadUrl: ");
      ((StringBuilder)localObject).append(this.a.download.qqDownloadUrl);
      WSLog.d("WeishiDownloadUtil", ((StringBuilder)localObject).toString());
      return this.a.download.qqDownloadUrl;
    }
    return WeishiDownloadUtil.b();
  }
  
  public int m()
  {
    if (!q()) {
      return this.a.download.versionCode;
    }
    return 0;
  }
  
  public int n()
  {
    stGlobalConfig localstGlobalConfig = a(1);
    if (localstGlobalConfig != null) {
      return localstGlobalConfig.cache_size;
    }
    return 14;
  }
  
  public String o()
  {
    if (Thread.currentThread().getId() != Looper.getMainLooper().getThread().getId())
    {
      localObject = WSSharePreferencesUtil.b("encryptedDeviceId", "");
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("WSSharePreferencesUtil load encrypted_deviceid:");
      localStringBuilder.append((String)localObject);
      WSLog.a("WSGlobalConfigLog", localStringBuilder.toString());
      return localObject;
    }
    Object localObject = this.a;
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
    localObject = WSSharePreferencesUtil.b("encryptedDeviceId", "");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WSSharePreferencesUtil load encrypted_deviceid:");
    localStringBuilder.append((String)localObject);
    WSLog.a("WSGlobalConfigLog", localStringBuilder.toString());
    return localObject;
  }
  
  public String p()
  {
    stGlobalConfig localstGlobalConfig = this.a;
    if ((localstGlobalConfig != null) && (localstGlobalConfig.commentConfig != null)) {
      return this.a.commentConfig.guideText;
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.config.WSGlobalConfig
 * JD-Core Version:    0.7.0.1
 */