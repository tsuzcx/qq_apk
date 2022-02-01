package com.tencent.ad.tangram.canvas.views.canvas.components.appbutton;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.ad.tangram.downloader.AdDownloadConstants;
import com.tencent.ad.tangram.downloader.IAdDownloader;
import com.tencent.ad.tangram.downloader.IAdDownloader.Callback;

public class g
{
  private IAdDownloader mDownloader;
  
  public g(IAdDownloader paramIAdDownloader)
  {
    this.mDownloader = paramIAdDownloader;
  }
  
  public int getCurrentPkgDownloadProgress(Context paramContext, String paramString1, String paramString2)
  {
    if (this.mDownloader != null) {
      return this.mDownloader.getCurrentPkgDownloadProgress(paramContext, paramString1, paramString2);
    }
    return 0;
  }
  
  public Object getDownloadInfoByUrl(String paramString)
  {
    if (this.mDownloader != null) {
      return this.mDownloader.getDownloadInfoByUrl(paramString);
    }
    return null;
  }
  
  public void installDownload(Object paramObject)
  {
    if (this.mDownloader != null) {
      this.mDownloader.installDownload(paramObject);
    }
  }
  
  public int isPkgDownloadPaused(Context paramContext, String paramString1, String paramString2)
  {
    if (this.mDownloader != null) {
      return this.mDownloader.isPkgDownloadPaused(paramContext, paramString1, paramString2);
    }
    return -1;
  }
  
  public int isPkgDownloading(Context paramContext, String paramString1, String paramString2)
  {
    if (this.mDownloader != null) {
      return this.mDownloader.isPkgDownloading(paramContext, paramString1, paramString2);
    }
    return -1;
  }
  
  public boolean isPkgExist(Context paramContext, String paramString1, String paramString2)
  {
    if (this.mDownloader != null) {
      return this.mDownloader.isPkgExist(paramContext, paramString1, paramString2);
    }
    return false;
  }
  
  public void pauseDownload(String paramString1, String paramString2)
  {
    if (this.mDownloader != null) {
      this.mDownloader.pauseDownload(paramString1, paramString2);
    }
  }
  
  public void registerListener(IAdDownloader.Callback paramCallback)
  {
    if (this.mDownloader != null) {
      this.mDownloader.registerListener(paramCallback);
    }
  }
  
  public void startRealDownload(Activity paramActivity, AdAppBtnData paramAdAppBtnData, boolean paramBoolean)
  {
    if ((paramActivity == null) || (paramAdAppBtnData == null)) {}
    String str1;
    String str2;
    String str3;
    String str4;
    String str5;
    do
    {
      return;
      str1 = paramAdAppBtnData.packageName;
      str2 = paramAdAppBtnData.mGdtAd_appId;
      str3 = paramAdAppBtnData.apkUrlhttp;
      str4 = paramAdAppBtnData.name;
      str5 = paramAdAppBtnData.via;
      localObject = paramActivity.getIntent().getStringExtra(AdDownloadConstants.KEY_REF_ID);
      paramAdAppBtnData = (AdAppBtnData)localObject;
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        paramAdAppBtnData = paramActivity.getIntent().getStringExtra(AdDownloadConstants.KEY);
      }
    } while ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(str3)) || (TextUtils.isEmpty(str4)));
    Object localObject = new Bundle();
    ((Bundle)localObject).putString(AdDownloadConstants.PARAM_TASK_PACKNAME, str1);
    ((Bundle)localObject).putString(AdDownloadConstants.PARAM_SNG_APPID, str2);
    ((Bundle)localObject).putString(AdDownloadConstants.PARAM_URL, str3);
    ((Bundle)localObject).putString(AdDownloadConstants.PARAM_APPNAME, str4);
    ((Bundle)localObject).putInt(AdDownloadConstants.PARAM_ACTIONCODE, 2);
    ((Bundle)localObject).putInt(AdDownloadConstants.PARAM_WOWNLOAD_TYPE, 0);
    ((Bundle)localObject).putBoolean(AdDownloadConstants.PARAM_BLOCK_NOTIFY, false);
    ((Bundle)localObject).putInt(AdDownloadConstants.PARAM_SHOW_NOTIFICATION, 0);
    ((Bundle)localObject).putBoolean(AdDownloadConstants.PARAM_IS_APK, true);
    ((Bundle)localObject).putBoolean(AdDownloadConstants.PARAM_AUTO_INSTALL, true);
    ((Bundle)localObject).putBoolean(AdDownloadConstants.PARAM_SHOW_NETWORK_DIALOG, false);
    ((Bundle)localObject).putBoolean(AdDownloadConstants.PARAM_IS_AUTOINSTALL_BY_SDK, false);
    ((Bundle)localObject).putString(AdDownloadConstants.PARAM_VIA, str5);
    ((Bundle)localObject).putString(AdDownloadConstants.KEY_REF_ID, paramAdAppBtnData);
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      ((Bundle)localObject).putInt("hideInstallSuccessPage", i);
      if (this.mDownloader == null) {
        break;
      }
      this.mDownloader.doDownloadAction(paramActivity, (Bundle)localObject, "biz_src_ads", 0);
      return;
    }
  }
  
  public void unregisterListener(IAdDownloader.Callback paramCallback)
  {
    if (this.mDownloader != null) {
      this.mDownloader.unregisterListener(paramCallback);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.canvas.views.canvas.components.appbutton.g
 * JD-Core Version:    0.7.0.1
 */