package com.tencent.ad.tangram.views.canvas.components.appbutton;

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
    IAdDownloader localIAdDownloader = this.mDownloader;
    if (localIAdDownloader != null) {
      return localIAdDownloader.getCurrentPkgDownloadProgress(paramContext, paramString1, paramString2);
    }
    return 0;
  }
  
  public Object getDownloadInfoByUrl(String paramString)
  {
    IAdDownloader localIAdDownloader = this.mDownloader;
    if (localIAdDownloader != null) {
      return localIAdDownloader.getDownloadInfoByUrl(paramString);
    }
    return null;
  }
  
  public void installDownload(Object paramObject)
  {
    IAdDownloader localIAdDownloader = this.mDownloader;
    if (localIAdDownloader != null) {
      localIAdDownloader.installDownload(paramObject);
    }
  }
  
  public int isPkgDownloadPaused(Context paramContext, String paramString1, String paramString2)
  {
    IAdDownloader localIAdDownloader = this.mDownloader;
    if (localIAdDownloader != null) {
      return localIAdDownloader.isPkgDownloadPaused(paramContext, paramString1, paramString2);
    }
    return -1;
  }
  
  public int isPkgDownloading(Context paramContext, String paramString1, String paramString2)
  {
    IAdDownloader localIAdDownloader = this.mDownloader;
    if (localIAdDownloader != null) {
      return localIAdDownloader.isPkgDownloading(paramContext, paramString1, paramString2);
    }
    return -1;
  }
  
  public boolean isPkgExist(Context paramContext, String paramString1, String paramString2)
  {
    IAdDownloader localIAdDownloader = this.mDownloader;
    if (localIAdDownloader != null) {
      return localIAdDownloader.isPkgExist(paramContext, paramString1, paramString2);
    }
    return false;
  }
  
  public void pauseDownload(String paramString1, String paramString2)
  {
    IAdDownloader localIAdDownloader = this.mDownloader;
    if (localIAdDownloader != null) {
      localIAdDownloader.pauseDownload(paramString1, paramString2);
    }
  }
  
  public void registerListener(IAdDownloader.Callback paramCallback)
  {
    IAdDownloader localIAdDownloader = this.mDownloader;
    if (localIAdDownloader != null) {
      localIAdDownloader.registerListener(paramCallback);
    }
  }
  
  public void startRealDownload(Activity paramActivity, AdAppBtnData paramAdAppBtnData)
  {
    if (paramActivity != null)
    {
      if (paramAdAppBtnData == null) {
        return;
      }
      String str1 = paramAdAppBtnData.packageName;
      String str2 = paramAdAppBtnData.mGdtAd_appId;
      String str3 = paramAdAppBtnData.apkUrlhttp;
      String str4 = paramAdAppBtnData.name;
      String str5 = paramAdAppBtnData.via;
      Object localObject = paramActivity.getIntent().getStringExtra(AdDownloadConstants.KEY_REF_ID);
      paramAdAppBtnData = (AdAppBtnData)localObject;
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        paramAdAppBtnData = paramActivity.getIntent().getStringExtra(AdDownloadConstants.KEY);
      }
      if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str3)))
      {
        if (TextUtils.isEmpty(str4)) {
          return;
        }
        localObject = new Bundle();
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
        ((Bundle)localObject).putInt("hideInstallSuccessPage", 1);
        paramAdAppBtnData = this.mDownloader;
        if (paramAdAppBtnData != null) {
          paramAdAppBtnData.doDownloadAction(paramActivity, (Bundle)localObject, "biz_src_ads", 0);
        }
      }
    }
  }
  
  public void unregisterListener(IAdDownloader.Callback paramCallback)
  {
    IAdDownloader localIAdDownloader = this.mDownloader;
    if (localIAdDownloader != null) {
      localIAdDownloader.unregisterListener(paramCallback);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.views.canvas.components.appbutton.g
 * JD-Core Version:    0.7.0.1
 */