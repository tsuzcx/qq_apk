package com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.event;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.download_action.AdAppDownloadUtil;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.RIJAdDownloadCache;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.data.AdDownloadInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.data.DownloadPercent;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.util.RIJAdDownloadExKt;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.util.RIJAdDownloadReport;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.view.IProgressView;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.view.RIJDownloadView;
import com.tencent.biz.pubaccount.readinjoyAd.ad.video.ADVideoAppDownloadData;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.widget.QQToast;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/event/AdDownloadStateHandler;", "", "(Ljava/lang/String;I)V", "doCallBack", "", "viewRIJ", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/view/RIJDownloadView;", "info", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/data/AdDownloadInfo;", "onCallBack", "onCancelDownloadUI", "onErrorDownloadUI", "onInitUI", "onInstallSucceedUI", "onPauseDownloadUI", "onProgressUpdateUI", "onQueryResultUI", "onResumeDownloadUI", "onStartDownloadUI", "onSuccessDownloadUI", "onUninstallSucceedUI", "reportPercentIfNeed", "downloadInfo", "progress", "", "OnInitDownload", "OnStartDownload", "OnReplaceUrl", "OnPauseDownload", "OnResumeDownload", "OnCancelDownload", "OnSuccessDownload", "OnErrorDownload", "OnProgressUpdate", "OnInstallSucceed", "OnUninstallSucceed", "OnQueryResult", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public enum AdDownloadStateHandler
{
  static
  {
    AdDownloadStateHandler.OnInitDownload localOnInitDownload = new AdDownloadStateHandler.OnInitDownload("OnInitDownload", 0);
    OnInitDownload = localOnInitDownload;
    AdDownloadStateHandler.OnStartDownload localOnStartDownload = new AdDownloadStateHandler.OnStartDownload("OnStartDownload", 1);
    OnStartDownload = localOnStartDownload;
    AdDownloadStateHandler.OnReplaceUrl localOnReplaceUrl = new AdDownloadStateHandler.OnReplaceUrl("OnReplaceUrl", 2);
    OnReplaceUrl = localOnReplaceUrl;
    AdDownloadStateHandler.OnPauseDownload localOnPauseDownload = new AdDownloadStateHandler.OnPauseDownload("OnPauseDownload", 3);
    OnPauseDownload = localOnPauseDownload;
    AdDownloadStateHandler.OnResumeDownload localOnResumeDownload = new AdDownloadStateHandler.OnResumeDownload("OnResumeDownload", 4);
    OnResumeDownload = localOnResumeDownload;
    AdDownloadStateHandler.OnCancelDownload localOnCancelDownload = new AdDownloadStateHandler.OnCancelDownload("OnCancelDownload", 5);
    OnCancelDownload = localOnCancelDownload;
    AdDownloadStateHandler.OnSuccessDownload localOnSuccessDownload = new AdDownloadStateHandler.OnSuccessDownload("OnSuccessDownload", 6);
    OnSuccessDownload = localOnSuccessDownload;
    AdDownloadStateHandler.OnErrorDownload localOnErrorDownload = new AdDownloadStateHandler.OnErrorDownload("OnErrorDownload", 7);
    OnErrorDownload = localOnErrorDownload;
    AdDownloadStateHandler.OnProgressUpdate localOnProgressUpdate = new AdDownloadStateHandler.OnProgressUpdate("OnProgressUpdate", 8);
    OnProgressUpdate = localOnProgressUpdate;
    AdDownloadStateHandler.OnInstallSucceed localOnInstallSucceed = new AdDownloadStateHandler.OnInstallSucceed("OnInstallSucceed", 9);
    OnInstallSucceed = localOnInstallSucceed;
    AdDownloadStateHandler.OnUninstallSucceed localOnUninstallSucceed = new AdDownloadStateHandler.OnUninstallSucceed("OnUninstallSucceed", 10);
    OnUninstallSucceed = localOnUninstallSucceed;
    AdDownloadStateHandler.OnQueryResult localOnQueryResult = new AdDownloadStateHandler.OnQueryResult("OnQueryResult", 11);
    OnQueryResult = localOnQueryResult;
    $VALUES = new AdDownloadStateHandler[] { localOnInitDownload, localOnStartDownload, localOnReplaceUrl, localOnPauseDownload, localOnResumeDownload, localOnCancelDownload, localOnSuccessDownload, localOnErrorDownload, localOnProgressUpdate, localOnInstallSucceed, localOnUninstallSucceed, localOnQueryResult };
  }
  
  private AdDownloadStateHandler() {}
  
  public final void doCallBack(@Nullable RIJDownloadView paramRIJDownloadView, @Nullable AdDownloadInfo paramAdDownloadInfo)
  {
    ThreadManagerV2.getUIHandlerV2().post((Runnable)new AdDownloadStateHandler.doCallBack.1(this, paramRIJDownloadView, paramAdDownloadInfo));
  }
  
  protected abstract void onCallBack(@Nullable RIJDownloadView paramRIJDownloadView, @Nullable AdDownloadInfo paramAdDownloadInfo);
  
  protected final void onCancelDownloadUI(@Nullable RIJDownloadView paramRIJDownloadView)
  {
    Object localObject;
    if (paramRIJDownloadView != null)
    {
      localObject = paramRIJDownloadView.a();
      if (localObject != null) {
        ((ADVideoAppDownloadData)localObject).a = 0;
      }
    }
    if ((paramRIJDownloadView != null) && (!paramRIJDownloadView.d()))
    {
      paramRIJDownloadView.e();
      localObject = paramRIJDownloadView.a();
      if (localObject != null)
      {
        if (!paramRIJDownloadView.c()) {
          break label61;
        }
        paramRIJDownloadView = (CharSequence)"下载";
        ((TextView)localObject).setText(paramRIJDownloadView);
      }
    }
    label61:
    while (paramRIJDownloadView == null) {
      for (;;)
      {
        return;
        paramRIJDownloadView = (CharSequence)"立即下载";
      }
    }
    paramRIJDownloadView.d();
  }
  
  protected final void onErrorDownloadUI(@Nullable RIJDownloadView paramRIJDownloadView)
  {
    Object localObject;
    if (paramRIJDownloadView != null)
    {
      localObject = paramRIJDownloadView.a();
      if (localObject != null) {
        ((ADVideoAppDownloadData)localObject).a = 6;
      }
    }
    if ((paramRIJDownloadView != null) && (!paramRIJDownloadView.d()))
    {
      paramRIJDownloadView.e();
      TextView localTextView = paramRIJDownloadView.a();
      if (localTextView != null)
      {
        if (!paramRIJDownloadView.c()) {
          break label101;
        }
        localObject = (CharSequence)"下载";
        localTextView.setText((CharSequence)localObject);
      }
    }
    for (;;)
    {
      if (paramRIJDownloadView != null)
      {
        paramRIJDownloadView = paramRIJDownloadView.getContext();
        if (paramRIJDownloadView != null)
        {
          paramRIJDownloadView = paramRIJDownloadView.getApplicationContext();
          if (paramRIJDownloadView != null) {
            QQToast.a(paramRIJDownloadView, (CharSequence)HardCodeUtil.a(2131712944), 0).a();
          }
        }
      }
      return;
      label101:
      localObject = (CharSequence)"立即下载";
      break;
      if (paramRIJDownloadView != null) {
        paramRIJDownloadView.d();
      }
    }
  }
  
  protected final void onInitUI(@Nullable RIJDownloadView paramRIJDownloadView)
  {
    Object localObject;
    if (paramRIJDownloadView != null)
    {
      localObject = paramRIJDownloadView.a();
      if (localObject != null) {
        ((ADVideoAppDownloadData)localObject).a = 0;
      }
    }
    if ((paramRIJDownloadView != null) && (!paramRIJDownloadView.d()))
    {
      paramRIJDownloadView.e();
      localObject = paramRIJDownloadView.a();
      if (localObject != null)
      {
        localObject = ((AdvertisementInfo)localObject).mAdBtnTxt;
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          break label151;
        }
        if (!AdvertisementInfo.isAppAdvertisementInfo((BaseArticleInfo)paramRIJDownloadView.a())) {
          break label112;
        }
        localObject = paramRIJDownloadView.a();
        if (localObject != null)
        {
          if (!paramRIJDownloadView.c()) {
            break label103;
          }
          paramRIJDownloadView = (CharSequence)"下载";
          ((TextView)localObject).setText(paramRIJDownloadView);
        }
      }
    }
    label103:
    label112:
    while (paramRIJDownloadView == null)
    {
      do
      {
        do
        {
          for (;;)
          {
            return;
            localObject = null;
            continue;
            paramRIJDownloadView = (CharSequence)"立即下载";
          }
          localObject = paramRIJDownloadView.a();
        } while (localObject == null);
        if (paramRIJDownloadView.c()) {}
        for (paramRIJDownloadView = (CharSequence)"查看";; paramRIJDownloadView = (CharSequence)"查看详情")
        {
          ((TextView)localObject).setText(paramRIJDownloadView);
          return;
        }
        paramRIJDownloadView = paramRIJDownloadView.a();
      } while (paramRIJDownloadView == null);
      paramRIJDownloadView.setText((CharSequence)localObject);
      return;
    }
    label151:
    paramRIJDownloadView.d();
  }
  
  protected final void onInstallSucceedUI(@Nullable RIJDownloadView paramRIJDownloadView)
  {
    if (paramRIJDownloadView != null) {
      paramRIJDownloadView.e();
    }
    TextView localTextView;
    if (paramRIJDownloadView != null)
    {
      localTextView = paramRIJDownloadView.a();
      if (localTextView != null) {
        if (paramRIJDownloadView.c() != true) {
          break label100;
        }
      }
    }
    label100:
    for (Object localObject = (CharSequence)"打开";; localObject = (CharSequence)"立即打开")
    {
      localTextView.setText((CharSequence)localObject);
      if (paramRIJDownloadView != null)
      {
        localObject = paramRIJDownloadView.a();
        if ((localObject != null) && (RIJAdDownloadExKt.g((AdvertisementInfo)localObject) == true))
        {
          localObject = paramRIJDownloadView.a();
          if (localObject != null) {
            ((TextView)localObject).setText((CharSequence)"领取");
          }
        }
      }
      if (paramRIJDownloadView != null)
      {
        paramRIJDownloadView = paramRIJDownloadView.a();
        if (paramRIJDownloadView != null) {
          paramRIJDownloadView.a = 1;
        }
      }
      return;
    }
  }
  
  protected final void onPauseDownloadUI(@Nullable RIJDownloadView paramRIJDownloadView, @Nullable AdDownloadInfo paramAdDownloadInfo)
  {
    if (paramRIJDownloadView != null) {
      paramRIJDownloadView.b(false);
    }
    if (paramRIJDownloadView != null)
    {
      paramAdDownloadInfo = paramRIJDownloadView.a();
      if (paramAdDownloadInfo != null) {
        paramAdDownloadInfo.a = 4;
      }
    }
    Object localObject;
    if (paramRIJDownloadView != null)
    {
      localObject = paramRIJDownloadView.a();
      if (localObject != null)
      {
        paramAdDownloadInfo = paramRIJDownloadView.a();
        if (paramAdDownloadInfo == null) {
          break label159;
        }
        paramAdDownloadInfo = Integer.valueOf(paramAdDownloadInfo.b);
        ((ADVideoAppDownloadData)localObject).b = paramAdDownloadInfo.intValue();
      }
    }
    if (paramRIJDownloadView != null)
    {
      localObject = paramRIJDownloadView.a();
      if (localObject != null)
      {
        if (!paramRIJDownloadView.c()) {
          break label164;
        }
        paramAdDownloadInfo = "继续";
        label94:
        ((IProgressView)localObject).setProgressText(paramAdDownloadInfo);
      }
    }
    if (paramRIJDownloadView != null)
    {
      paramAdDownloadInfo = paramRIJDownloadView.a();
      if (paramAdDownloadInfo != null)
      {
        localObject = paramRIJDownloadView.a();
        if (localObject == null) {
          break label171;
        }
      }
    }
    label159:
    label164:
    label171:
    for (int i = ((ADVideoAppDownloadData)localObject).b;; i = 0)
    {
      paramAdDownloadInfo.setProgress(i);
      if (paramRIJDownloadView != null)
      {
        paramRIJDownloadView = paramRIJDownloadView.a();
        if (paramRIJDownloadView != null) {
          paramRIJDownloadView.a();
        }
      }
      return;
      paramAdDownloadInfo = null;
      break;
      paramAdDownloadInfo = "继续下载";
      break label94;
    }
  }
  
  protected final void onProgressUpdateUI(@Nullable RIJDownloadView paramRIJDownloadView, @Nullable AdDownloadInfo paramAdDownloadInfo)
  {
    Object localObject = null;
    if (paramRIJDownloadView != null) {
      paramRIJDownloadView.b(true);
    }
    ADVideoAppDownloadData localADVideoAppDownloadData;
    if (paramRIJDownloadView != null)
    {
      localADVideoAppDownloadData = paramRIJDownloadView.a();
      if (localADVideoAppDownloadData != null) {
        localADVideoAppDownloadData.a = 3;
      }
    }
    if (paramRIJDownloadView != null)
    {
      localADVideoAppDownloadData = paramRIJDownloadView.a();
      if (localADVideoAppDownloadData != null)
      {
        if (paramAdDownloadInfo == null) {
          break label175;
        }
        paramAdDownloadInfo = Integer.valueOf(paramAdDownloadInfo.b());
        localADVideoAppDownloadData.b = paramAdDownloadInfo.intValue();
      }
    }
    if (paramRIJDownloadView != null)
    {
      paramAdDownloadInfo = paramRIJDownloadView.a();
      if (paramAdDownloadInfo != null) {
        paramAdDownloadInfo.b();
      }
    }
    if (paramRIJDownloadView != null)
    {
      paramAdDownloadInfo = paramRIJDownloadView.a();
      if (paramAdDownloadInfo != null)
      {
        localADVideoAppDownloadData = paramRIJDownloadView.a();
        if (localADVideoAppDownloadData == null) {
          break label180;
        }
      }
    }
    label175:
    label180:
    for (int i = localADVideoAppDownloadData.b;; i = 0)
    {
      paramAdDownloadInfo.setProgress(i);
      if (paramRIJDownloadView != null)
      {
        paramAdDownloadInfo = paramRIJDownloadView.a();
        if (paramAdDownloadInfo != null)
        {
          localADVideoAppDownloadData = paramRIJDownloadView.a();
          paramRIJDownloadView = localObject;
          if (localADVideoAppDownloadData != null) {
            paramRIJDownloadView = String.valueOf(localADVideoAppDownloadData.b);
          }
          paramAdDownloadInfo.setProgressText(Intrinsics.stringPlus(paramRIJDownloadView, "%"));
        }
      }
      return;
      paramAdDownloadInfo = null;
      break;
    }
  }
  
  protected final void onQueryResultUI(@Nullable RIJDownloadView paramRIJDownloadView, @Nullable AdDownloadInfo paramAdDownloadInfo)
  {
    if ((paramRIJDownloadView == null) || (paramAdDownloadInfo == null)) {}
    do
    {
      return;
      if (AdAppDownloadUtil.a.a(paramAdDownloadInfo.a()))
      {
        onInstallSucceedUI(paramRIJDownloadView);
        return;
      }
      Object localObject = paramRIJDownloadView.a();
      if (localObject != null) {}
      for (localObject = ((ADVideoAppDownloadData)localObject).i; ((!TextUtils.isEmpty((CharSequence)localObject)) && (new File((String)localObject).exists())) || (paramAdDownloadInfo.a() == 5); localObject = null)
      {
        onSuccessDownloadUI(paramRIJDownloadView);
        return;
      }
      if (paramAdDownloadInfo.a() == 4)
      {
        localObject = paramRIJDownloadView.a();
        if (localObject != null)
        {
          ((ADVideoAppDownloadData)localObject).a = 4;
          ((ADVideoAppDownloadData)localObject).b = paramAdDownloadInfo.b();
        }
        onPauseDownloadUI(paramRIJDownloadView, paramAdDownloadInfo);
        return;
      }
    } while (paramAdDownloadInfo.a() != 0);
    onInitUI(paramRIJDownloadView);
  }
  
  protected final void onResumeDownloadUI(@Nullable RIJDownloadView paramRIJDownloadView)
  {
    if (paramRIJDownloadView != null) {
      paramRIJDownloadView.b(true);
    }
    if (paramRIJDownloadView != null)
    {
      ADVideoAppDownloadData localADVideoAppDownloadData = paramRIJDownloadView.a();
      if (localADVideoAppDownloadData != null) {
        localADVideoAppDownloadData.a = 3;
      }
    }
    if (paramRIJDownloadView != null)
    {
      paramRIJDownloadView = paramRIJDownloadView.a();
      if (paramRIJDownloadView != null) {
        paramRIJDownloadView.b();
      }
    }
  }
  
  protected final void onStartDownloadUI(@Nullable RIJDownloadView paramRIJDownloadView, @Nullable AdDownloadInfo paramAdDownloadInfo)
  {
    if (paramRIJDownloadView != null) {
      paramRIJDownloadView.b(true);
    }
    if (paramRIJDownloadView != null)
    {
      paramAdDownloadInfo = paramRIJDownloadView.a();
      if (paramAdDownloadInfo != null) {
        paramAdDownloadInfo.setProgress(0);
      }
    }
    if (paramRIJDownloadView != null)
    {
      paramAdDownloadInfo = paramRIJDownloadView.a();
      if (paramAdDownloadInfo != null) {
        paramAdDownloadInfo.setProgressText("0%");
      }
    }
    if (paramRIJDownloadView != null)
    {
      paramRIJDownloadView = paramRIJDownloadView.a();
      if (paramRIJDownloadView != null) {
        paramRIJDownloadView.b();
      }
    }
  }
  
  protected final void onSuccessDownloadUI(@Nullable RIJDownloadView paramRIJDownloadView)
  {
    if (paramRIJDownloadView != null) {
      paramRIJDownloadView.e();
    }
    Object localObject;
    if (paramRIJDownloadView != null)
    {
      localObject = paramRIJDownloadView.a();
      if (localObject != null) {
        ((ADVideoAppDownloadData)localObject).a = 5;
      }
    }
    if (paramRIJDownloadView != null)
    {
      localObject = paramRIJDownloadView.a();
      if (localObject != null) {
        if (paramRIJDownloadView.c() != true) {
          break label60;
        }
      }
    }
    label60:
    for (paramRIJDownloadView = (CharSequence)"安装";; paramRIJDownloadView = (CharSequence)"立即安装")
    {
      ((TextView)localObject).setText(paramRIJDownloadView);
      return;
    }
  }
  
  protected final void onUninstallSucceedUI(@Nullable RIJDownloadView paramRIJDownloadView)
  {
    Object localObject;
    if (paramRIJDownloadView != null)
    {
      localObject = paramRIJDownloadView.a();
      if (localObject != null)
      {
        localObject = ((ADVideoAppDownloadData)localObject).i;
        if ((TextUtils.isEmpty((CharSequence)localObject)) || (!new File((String)localObject).exists())) {
          break label135;
        }
        if (paramRIJDownloadView != null) {
          paramRIJDownloadView.e();
        }
        if (paramRIJDownloadView != null)
        {
          localObject = paramRIJDownloadView.a();
          if (localObject != null) {
            ((ADVideoAppDownloadData)localObject).a = 5;
          }
        }
        if (paramRIJDownloadView != null)
        {
          TextView localTextView = paramRIJDownloadView.a();
          if (localTextView != null)
          {
            if (paramRIJDownloadView.c() != true) {
              break label125;
            }
            localObject = (CharSequence)"安装";
            label96:
            localTextView.setText((CharSequence)localObject);
          }
        }
        if (paramRIJDownloadView != null)
        {
          paramRIJDownloadView = paramRIJDownloadView.a();
          if (paramRIJDownloadView != null) {
            paramRIJDownloadView.a = 5;
          }
        }
      }
    }
    label125:
    do
    {
      do
      {
        return;
        localObject = null;
        break;
        localObject = (CharSequence)"立即安装";
        break label96;
        onInitUI(paramRIJDownloadView);
      } while (paramRIJDownloadView == null);
      paramRIJDownloadView = paramRIJDownloadView.a();
    } while (paramRIJDownloadView == null);
    label135:
    paramRIJDownloadView.a = 0;
  }
  
  protected final void reportPercentIfNeed(@Nullable AdDownloadInfo paramAdDownloadInfo, int paramInt)
  {
    if (paramAdDownloadInfo != null) {}
    for (String str = paramAdDownloadInfo.a();; str = null)
    {
      if ((paramInt >= 90) && (!RIJAdDownloadCache.a.a(str, DownloadPercent.PERCENT_90)))
      {
        RIJAdDownloadCache.a.a(str, DownloadPercent.PERCENT_90);
        RIJAdDownloadReport.a.a("download90percent", paramAdDownloadInfo);
      }
      if ((paramInt >= 75) && (!RIJAdDownloadCache.a.a(str, DownloadPercent.PERCENT_75)))
      {
        RIJAdDownloadCache.a.a(str, DownloadPercent.PERCENT_75);
        RIJAdDownloadReport.a.a("download75percent", paramAdDownloadInfo);
      }
      if ((paramInt >= 50) && (!RIJAdDownloadCache.a.a(str, DownloadPercent.PERCENT_50)))
      {
        RIJAdDownloadCache.a.a(str, DownloadPercent.PERCENT_50);
        RIJAdDownloadReport.a.a("download50percent", paramAdDownloadInfo);
      }
      if ((paramInt >= 25) && (!RIJAdDownloadCache.a.a(str, DownloadPercent.PERCENT_25)))
      {
        RIJAdDownloadCache.a.a(str, DownloadPercent.PERCENT_25);
        RIJAdDownloadReport.a.a("download25percent", paramAdDownloadInfo);
      }
      if ((paramInt >= 10) && (!RIJAdDownloadCache.a.a(str, DownloadPercent.PERCENT_10)))
      {
        RIJAdDownloadCache.a.a(str, DownloadPercent.PERCENT_10);
        RIJAdDownloadReport.a.a("download10percent", paramAdDownloadInfo);
      }
      if ((paramInt >= 1) && (!RIJAdDownloadCache.a.a(str, DownloadPercent.PERCENT_1)))
      {
        RIJAdDownloadCache.a.a(str, DownloadPercent.PERCENT_1);
        RIJAdDownloadReport.a.a("download1percent", paramAdDownloadInfo);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.event.AdDownloadStateHandler
 * JD-Core Version:    0.7.0.1
 */