package com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.event;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.data.AdDownloadInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.data.DownloadPercent;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.view.RIJDownloadView;
import com.tencent.biz.pubaccount.readinjoyAd.ad.video.ADVideoAppDownloadData;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdDownloadService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import java.io.File;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/event/AdDownloadStateHandler;", "", "(Ljava/lang/String;I)V", "doCallBack", "", "viewRIJ", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/view/RIJDownloadView;", "info", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/data/AdDownloadInfo;", "onCallBack", "onCancelDownloadUI", "onErrorDownloadUI", "onInitUI", "onInstallSucceedUI", "onPauseDownloadUI", "onProgressUpdateUI", "onQueryResultUI", "onResumeDownloadUI", "onStartDownloadUI", "onSuccessDownloadUI", "onUninstallSucceedUI", "reportPercentIfNeed", "downloadInfo", "progress", "", "showInitBtn", "OnInitDownload", "OnStartDownload", "OnReplaceUrl", "OnPauseDownload", "OnResumeDownload", "OnCancelDownload", "OnSuccessDownload", "OnErrorDownload", "OnProgressUpdate", "OnInstallSucceed", "OnUninstallSucceed", "OnQueryResult", "kandian-ad-api_release"}, k=1, mv={1, 1, 16})
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
        if (paramRIJDownloadView.c()) {
          paramRIJDownloadView = "下载";
        } else {
          paramRIJDownloadView = "立即下载";
        }
        ((TextView)localObject).setText((CharSequence)paramRIJDownloadView);
      }
    }
    else if (paramRIJDownloadView != null)
    {
      paramRIJDownloadView.d();
    }
  }
  
  protected final void onErrorDownloadUI(@Nullable RIJDownloadView paramRIJDownloadView)
  {
    if (paramRIJDownloadView != null)
    {
      ADVideoAppDownloadData localADVideoAppDownloadData = paramRIJDownloadView.a();
      if (localADVideoAppDownloadData != null) {
        localADVideoAppDownloadData.a = 6;
      }
    }
    showInitBtn(paramRIJDownloadView);
    if (paramRIJDownloadView != null)
    {
      paramRIJDownloadView = paramRIJDownloadView.getContext();
      if (paramRIJDownloadView != null)
      {
        paramRIJDownloadView = paramRIJDownloadView.getApplicationContext();
        if (paramRIJDownloadView != null) {
          QQToast.a(paramRIJDownloadView, (CharSequence)HardCodeUtil.a(2131712919), 0).a();
        }
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
      if (localObject != null) {
        localObject = ((AdvertisementInfo)localObject).mAdBtnTxt;
      } else {
        localObject = null;
      }
      localObject = (CharSequence)localObject;
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAppAdvertisementInfo((AbsBaseArticleInfo)paramRIJDownloadView.a()))
        {
          localObject = paramRIJDownloadView.a();
          if (localObject != null)
          {
            if (paramRIJDownloadView.c()) {
              paramRIJDownloadView = "下载";
            } else {
              paramRIJDownloadView = "立即下载";
            }
            ((TextView)localObject).setText((CharSequence)paramRIJDownloadView);
          }
        }
        else
        {
          localObject = paramRIJDownloadView.a();
          if (localObject != null)
          {
            if (paramRIJDownloadView.c()) {
              paramRIJDownloadView = "查看";
            } else {
              paramRIJDownloadView = "查看详情";
            }
            ((TextView)localObject).setText((CharSequence)paramRIJDownloadView);
          }
        }
      }
      else
      {
        paramRIJDownloadView = paramRIJDownloadView.a();
        if (paramRIJDownloadView != null) {
          paramRIJDownloadView.setText((CharSequence)localObject);
        }
      }
    }
    else if (paramRIJDownloadView != null)
    {
      paramRIJDownloadView.d();
    }
  }
  
  protected final void onInstallSucceedUI(@Nullable RIJDownloadView paramRIJDownloadView)
  {
    if (paramRIJDownloadView != null) {
      paramRIJDownloadView.e();
    }
    Object localObject1;
    if (paramRIJDownloadView != null)
    {
      localObject2 = paramRIJDownloadView.a();
      if (localObject2 != null)
      {
        if (paramRIJDownloadView.c() == true) {
          localObject1 = "打开";
        } else {
          localObject1 = "立即打开";
        }
        ((TextView)localObject2).setText((CharSequence)localObject1);
      }
    }
    Object localObject2 = (IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class);
    if (paramRIJDownloadView != null) {
      localObject1 = paramRIJDownloadView.a();
    } else {
      localObject1 = null;
    }
    if ((((IRIJAdUtilService)localObject2).isGameGiftAd((AdvertisementInfo)localObject1)) && (paramRIJDownloadView != null))
    {
      localObject1 = paramRIJDownloadView.a();
      if (localObject1 != null) {
        ((TextView)localObject1).setText((CharSequence)"领取");
      }
    }
    if (paramRIJDownloadView != null)
    {
      paramRIJDownloadView = paramRIJDownloadView.a();
      if (paramRIJDownloadView != null) {
        paramRIJDownloadView.a = 1;
      }
    }
  }
  
  protected final void onPauseDownloadUI(@Nullable RIJDownloadView paramRIJDownloadView, @Nullable AdDownloadInfo paramAdDownloadInfo)
  {
    showInitBtn(paramRIJDownloadView);
    if (paramRIJDownloadView != null)
    {
      paramAdDownloadInfo = paramRIJDownloadView.a();
      if (paramAdDownloadInfo != null) {
        paramAdDownloadInfo.a = 4;
      }
    }
    if (paramRIJDownloadView != null)
    {
      paramAdDownloadInfo = paramRIJDownloadView.a();
      if (paramAdDownloadInfo != null)
      {
        paramRIJDownloadView = paramRIJDownloadView.a();
        if (paramRIJDownloadView != null) {
          paramRIJDownloadView = Integer.valueOf(paramRIJDownloadView.b);
        } else {
          paramRIJDownloadView = null;
        }
        paramAdDownloadInfo.b = paramRIJDownloadView.intValue();
      }
    }
  }
  
  protected final void onProgressUpdateUI(@Nullable RIJDownloadView paramRIJDownloadView, @Nullable AdDownloadInfo paramAdDownloadInfo)
  {
    showInitBtn(paramRIJDownloadView);
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
        if (paramAdDownloadInfo != null) {
          paramRIJDownloadView = Integer.valueOf(paramAdDownloadInfo.b());
        } else {
          paramRIJDownloadView = null;
        }
        localADVideoAppDownloadData.b = paramRIJDownloadView.intValue();
      }
    }
  }
  
  protected final void onQueryResultUI(@Nullable RIJDownloadView paramRIJDownloadView, @Nullable AdDownloadInfo paramAdDownloadInfo)
  {
    if (paramRIJDownloadView != null)
    {
      if (paramAdDownloadInfo == null) {
        return;
      }
      if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAppInstall(paramAdDownloadInfo.a()))
      {
        onInstallSucceedUI(paramRIJDownloadView);
        return;
      }
      Object localObject = paramRIJDownloadView.a();
      if (localObject != null) {
        localObject = ((ADVideoAppDownloadData)localObject).i;
      } else {
        localObject = null;
      }
      if (((!TextUtils.isEmpty((CharSequence)localObject)) && (new File((String)localObject).exists())) || (paramAdDownloadInfo.a() == 5))
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
      if (paramAdDownloadInfo.a() == 0) {
        onInitUI(paramRIJDownloadView);
      }
    }
  }
  
  protected final void onResumeDownloadUI(@Nullable RIJDownloadView paramRIJDownloadView)
  {
    showInitBtn(paramRIJDownloadView);
    if (paramRIJDownloadView != null)
    {
      paramRIJDownloadView = paramRIJDownloadView.a();
      if (paramRIJDownloadView != null) {
        paramRIJDownloadView.a = 3;
      }
    }
  }
  
  protected final void onStartDownloadUI(@Nullable RIJDownloadView paramRIJDownloadView, @Nullable AdDownloadInfo paramAdDownloadInfo)
  {
    showInitBtn(paramRIJDownloadView);
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
      if (localObject != null)
      {
        if (paramRIJDownloadView.c() == true) {
          paramRIJDownloadView = "安装";
        } else {
          paramRIJDownloadView = "立即安装";
        }
        ((TextView)localObject).setText((CharSequence)paramRIJDownloadView);
      }
    }
  }
  
  protected final void onUninstallSucceedUI(@Nullable RIJDownloadView paramRIJDownloadView)
  {
    if (paramRIJDownloadView != null)
    {
      localObject = paramRIJDownloadView.a();
      if (localObject != null)
      {
        localObject = ((ADVideoAppDownloadData)localObject).i;
        break label23;
      }
    }
    Object localObject = null;
    label23:
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (new File((String)localObject).exists()))
    {
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
          if (paramRIJDownloadView.c() == true) {
            localObject = "安装";
          } else {
            localObject = "立即安装";
          }
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
    else
    {
      onInitUI(paramRIJDownloadView);
      if (paramRIJDownloadView != null)
      {
        paramRIJDownloadView = paramRIJDownloadView.a();
        if (paramRIJDownloadView != null) {
          paramRIJDownloadView.a = 0;
        }
      }
    }
  }
  
  protected final void reportPercentIfNeed(@Nullable AdDownloadInfo paramAdDownloadInfo, int paramInt)
  {
    String str;
    if (paramAdDownloadInfo != null) {
      str = paramAdDownloadInfo.a();
    } else {
      str = null;
    }
    if ((paramInt >= 90) && (!((IRIJAdDownloadService)QRoute.api(IRIJAdDownloadService.class)).hasReportCache(str, DownloadPercent.PERCENT_90)))
    {
      ((IRIJAdDownloadService)QRoute.api(IRIJAdDownloadService.class)).addReportCache(str, DownloadPercent.PERCENT_90);
      ((IRIJAdDownloadService)QRoute.api(IRIJAdDownloadService.class)).reportBeacon("download90percent", paramAdDownloadInfo);
    }
    if ((paramInt >= 75) && (!((IRIJAdDownloadService)QRoute.api(IRIJAdDownloadService.class)).hasReportCache(str, DownloadPercent.PERCENT_75)))
    {
      ((IRIJAdDownloadService)QRoute.api(IRIJAdDownloadService.class)).addReportCache(str, DownloadPercent.PERCENT_75);
      ((IRIJAdDownloadService)QRoute.api(IRIJAdDownloadService.class)).reportBeacon("download75percent", paramAdDownloadInfo);
    }
    if ((paramInt >= 50) && (!((IRIJAdDownloadService)QRoute.api(IRIJAdDownloadService.class)).hasReportCache(str, DownloadPercent.PERCENT_50)))
    {
      ((IRIJAdDownloadService)QRoute.api(IRIJAdDownloadService.class)).addReportCache(str, DownloadPercent.PERCENT_50);
      ((IRIJAdDownloadService)QRoute.api(IRIJAdDownloadService.class)).reportBeacon("download50percent", paramAdDownloadInfo);
    }
    if ((paramInt >= 25) && (!((IRIJAdDownloadService)QRoute.api(IRIJAdDownloadService.class)).hasReportCache(str, DownloadPercent.PERCENT_25)))
    {
      ((IRIJAdDownloadService)QRoute.api(IRIJAdDownloadService.class)).addReportCache(str, DownloadPercent.PERCENT_25);
      ((IRIJAdDownloadService)QRoute.api(IRIJAdDownloadService.class)).reportBeacon("download25percent", paramAdDownloadInfo);
    }
    if ((paramInt >= 10) && (!((IRIJAdDownloadService)QRoute.api(IRIJAdDownloadService.class)).hasReportCache(str, DownloadPercent.PERCENT_10)))
    {
      ((IRIJAdDownloadService)QRoute.api(IRIJAdDownloadService.class)).addReportCache(str, DownloadPercent.PERCENT_10);
      ((IRIJAdDownloadService)QRoute.api(IRIJAdDownloadService.class)).reportBeacon("download10percent", paramAdDownloadInfo);
    }
    if ((paramInt >= 1) && (!((IRIJAdDownloadService)QRoute.api(IRIJAdDownloadService.class)).hasReportCache(str, DownloadPercent.PERCENT_1)))
    {
      ((IRIJAdDownloadService)QRoute.api(IRIJAdDownloadService.class)).addReportCache(str, DownloadPercent.PERCENT_1);
      ((IRIJAdDownloadService)QRoute.api(IRIJAdDownloadService.class)).reportBeacon("download1percent", paramAdDownloadInfo);
    }
  }
  
  protected final void showInitBtn(@Nullable RIJDownloadView paramRIJDownloadView)
  {
    if ((paramRIJDownloadView != null) && (!paramRIJDownloadView.d()))
    {
      paramRIJDownloadView.e();
      TextView localTextView = paramRIJDownloadView.a();
      if (localTextView != null)
      {
        if (paramRIJDownloadView.c()) {
          paramRIJDownloadView = "下载";
        } else {
          paramRIJDownloadView = "立即下载";
        }
        localTextView.setText((CharSequence)paramRIJDownloadView);
      }
    }
    else if (paramRIJDownloadView != null)
    {
      paramRIJDownloadView.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.event.AdDownloadStateHandler
 * JD-Core Version:    0.7.0.1
 */