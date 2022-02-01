package com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.engine;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.view.RIJDownloadView;
import com.tencent.biz.pubaccount.readinjoyAd.ad.video.ADVideoAppDownloadData;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.open.appstore.dl.DownloadManagerV2;
import com.tencent.open.downloadnew.DownloadConstants;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import com.tencent.tmassistantbase.util.GlobalUtil;
import java.io.File;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/engine/YYBDownloadEngine;", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/engine/IDownloadEngine;", "()V", "buildDownloadParams", "Landroid/os/Bundle;", "data", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/video/ADVideoAppDownloadData;", "cancelDownload", "", "viewRIJ", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/view/RIJDownloadView;", "getLocalPakPathBySDK", "", "localInfo", "Lcom/tencent/open/downloadnew/DownloadInfo;", "installApp", "", "isAppPkgExist", "needReplaceUrl", "pauseDownload", "queryDownloadState", "startDownload", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class YYBDownloadEngine
  extends IDownloadEngine
{
  public static final YYBDownloadEngine a = new YYBDownloadEngine();
  
  private final Bundle a(ADVideoAppDownloadData paramADVideoAppDownloadData)
  {
    if (paramADVideoAppDownloadData == null) {
      return new Bundle();
    }
    Bundle localBundle = new Bundle();
    localBundle.putString(DownloadConstants.f, paramADVideoAppDownloadData.d);
    localBundle.putString(DownloadConstants.b, paramADVideoAppDownloadData.a);
    localBundle.putString(DownloadConstants.j, paramADVideoAppDownloadData.c);
    localBundle.putString(DownloadConstants.l, paramADVideoAppDownloadData.e);
    localBundle.putInt(DownloadConstants.k, 2);
    localBundle.putInt(DownloadConstants.F, 0);
    localBundle.putBoolean(DownloadConstants.x, false);
    localBundle.putInt(DownloadConstants.I, 0);
    localBundle.putBoolean(DownloadConstants.y, true);
    localBundle.putBoolean(DownloadConstants.h, true);
    localBundle.putBoolean(DownloadConstants.r, false);
    localBundle.putBoolean(DownloadConstants.K, false);
    localBundle.putString("sendTime", "_" + GlobalUtil.calcMD5AsString(paramADVideoAppDownloadData.c));
    localBundle.putString(DownloadConstants.i, paramADVideoAppDownloadData.f);
    return localBundle;
  }
  
  private final String a(DownloadInfo paramDownloadInfo)
  {
    paramDownloadInfo = DownloadManagerV2.a().a(paramDownloadInfo.d);
    if ((paramDownloadInfo != null) && (paramDownloadInfo.mState == 4)) {
      return paramDownloadInfo.mSavePath;
    }
    return null;
  }
  
  private final boolean c(ADVideoAppDownloadData paramADVideoAppDownloadData)
  {
    return (TextUtils.isEmpty((CharSequence)paramADVideoAppDownloadData.c)) && (!TextUtils.isEmpty((CharSequence)paramADVideoAppDownloadData.b));
  }
  
  public void a(@Nullable RIJDownloadView paramRIJDownloadView, @Nullable ADVideoAppDownloadData paramADVideoAppDownloadData)
  {
    ThreadManagerV2.executeOnSubThread((Runnable)new YYBDownloadEngine.queryDownloadState.1(paramRIJDownloadView, paramADVideoAppDownloadData));
  }
  
  public boolean a(@Nullable ADVideoAppDownloadData paramADVideoAppDownloadData)
  {
    Object localObject3 = null;
    if (paramADVideoAppDownloadData != null) {}
    for (Object localObject1 = paramADVideoAppDownloadData.c; TextUtils.isEmpty((CharSequence)localObject1); localObject1 = null) {
      return false;
    }
    Object localObject2 = DownloadManagerV2.a().b((String)localObject1);
    label43:
    Object localObject4;
    if (localObject2 != null)
    {
      if (localObject2 == null) {
        break label193;
      }
      localObject4 = ((DownloadInfo)localObject2).l;
      localObject1 = localObject4;
      if (TextUtils.isEmpty((CharSequence)localObject4)) {
        localObject1 = a((DownloadInfo)localObject2);
      }
      if ((TextUtils.isEmpty((CharSequence)localObject1)) || (!new File((String)localObject1).exists())) {
        break label201;
      }
    }
    label193:
    label201:
    for (boolean bool = true;; bool = false)
    {
      localObject4 = new StringBuilder().append("isAppDownloaded = ").append(bool).append("  packageName = ");
      localObject2 = localObject3;
      if (paramADVideoAppDownloadData != null) {
        localObject2 = paramADVideoAppDownloadData.d;
      }
      QLog.d("AD_DOWNLOAD_TAG", 1, (String)localObject2 + " localAPKPath = " + (String)localObject1);
      return bool;
      localObject2 = DownloadManagerV2.a();
      if (paramADVideoAppDownloadData != null)
      {
        localObject1 = paramADVideoAppDownloadData.d;
        if (localObject1 == null) {}
      }
      for (;;)
      {
        localObject2 = ((DownloadManagerV2)localObject2).c((String)localObject1);
        break label43;
        break;
        localObject1 = "";
      }
    }
  }
  
  public void b(@Nullable RIJDownloadView paramRIJDownloadView, @Nullable ADVideoAppDownloadData paramADVideoAppDownloadData)
  {
    ThreadManagerV2.executeOnSubThread((Runnable)new YYBDownloadEngine.pauseDownload.1(paramADVideoAppDownloadData));
  }
  
  public boolean b(@Nullable ADVideoAppDownloadData paramADVideoAppDownloadData)
  {
    DownloadManagerV2 localDownloadManagerV2 = DownloadManagerV2.a();
    if (paramADVideoAppDownloadData != null) {}
    for (paramADVideoAppDownloadData = paramADVideoAppDownloadData.c;; paramADVideoAppDownloadData = null)
    {
      paramADVideoAppDownloadData = localDownloadManagerV2.b(paramADVideoAppDownloadData);
      return DownloadManagerV2.a().a(paramADVideoAppDownloadData);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.engine.YYBDownloadEngine
 * JD-Core Version:    0.7.0.1
 */