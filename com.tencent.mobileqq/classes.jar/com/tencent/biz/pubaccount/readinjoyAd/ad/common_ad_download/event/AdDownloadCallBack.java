package com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.event;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.TextView;
import anvx;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.data.DownloadPercent;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.view.RIJDownloadView;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.widget.QQToast;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;
import udr;
import uet;
import uev;
import ufc;
import ufd;
import ufm;
import ule;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/event/AdDownloadCallBack;", "", "(Ljava/lang/String;I)V", "doCallBack", "", "viewRIJ", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/view/RIJDownloadView;", "info", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/data/AdDownloadInfo;", "onCallBack", "onCancelDownloadUI", "onErrorDownloadUI", "onInitUI", "onInstallSucceedUI", "onPauseDownloadUI", "onProgressUpdateUI", "onQueryResultUI", "onResumeDownloadUI", "onStartDownloadUI", "onSuccessDownloadUI", "onUninstallSucceedUI", "reportPercentIfNeed", "downloadInfo", "progress", "", "OnInitDownload", "OnStartDownload", "OnReplaceUrl", "OnPauseDownload", "OnResumeDownload", "OnCancelDownload", "OnSuccessDownload", "OnErrorDownload", "OnProgressUpdate", "OnInstallSucceed", "OnUninstallSucceed", "OnQueryResult", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public enum AdDownloadCallBack
{
  static
  {
    AdDownloadCallBack.OnInitDownload localOnInitDownload = new AdDownloadCallBack.OnInitDownload("OnInitDownload", 0);
    OnInitDownload = localOnInitDownload;
    AdDownloadCallBack.OnStartDownload localOnStartDownload = new AdDownloadCallBack.OnStartDownload("OnStartDownload", 1);
    OnStartDownload = localOnStartDownload;
    AdDownloadCallBack.OnReplaceUrl localOnReplaceUrl = new AdDownloadCallBack.OnReplaceUrl("OnReplaceUrl", 2);
    OnReplaceUrl = localOnReplaceUrl;
    AdDownloadCallBack.OnPauseDownload localOnPauseDownload = new AdDownloadCallBack.OnPauseDownload("OnPauseDownload", 3);
    OnPauseDownload = localOnPauseDownload;
    AdDownloadCallBack.OnResumeDownload localOnResumeDownload = new AdDownloadCallBack.OnResumeDownload("OnResumeDownload", 4);
    OnResumeDownload = localOnResumeDownload;
    AdDownloadCallBack.OnCancelDownload localOnCancelDownload = new AdDownloadCallBack.OnCancelDownload("OnCancelDownload", 5);
    OnCancelDownload = localOnCancelDownload;
    AdDownloadCallBack.OnSuccessDownload localOnSuccessDownload = new AdDownloadCallBack.OnSuccessDownload("OnSuccessDownload", 6);
    OnSuccessDownload = localOnSuccessDownload;
    AdDownloadCallBack.OnErrorDownload localOnErrorDownload = new AdDownloadCallBack.OnErrorDownload("OnErrorDownload", 7);
    OnErrorDownload = localOnErrorDownload;
    AdDownloadCallBack.OnProgressUpdate localOnProgressUpdate = new AdDownloadCallBack.OnProgressUpdate("OnProgressUpdate", 8);
    OnProgressUpdate = localOnProgressUpdate;
    AdDownloadCallBack.OnInstallSucceed localOnInstallSucceed = new AdDownloadCallBack.OnInstallSucceed("OnInstallSucceed", 9);
    OnInstallSucceed = localOnInstallSucceed;
    AdDownloadCallBack.OnUninstallSucceed localOnUninstallSucceed = new AdDownloadCallBack.OnUninstallSucceed("OnUninstallSucceed", 10);
    OnUninstallSucceed = localOnUninstallSucceed;
    AdDownloadCallBack.OnQueryResult localOnQueryResult = new AdDownloadCallBack.OnQueryResult("OnQueryResult", 11);
    OnQueryResult = localOnQueryResult;
    $VALUES = new AdDownloadCallBack[] { localOnInitDownload, localOnStartDownload, localOnReplaceUrl, localOnPauseDownload, localOnResumeDownload, localOnCancelDownload, localOnSuccessDownload, localOnErrorDownload, localOnProgressUpdate, localOnInstallSucceed, localOnUninstallSucceed, localOnQueryResult };
  }
  
  private AdDownloadCallBack() {}
  
  public final void doCallBack(@Nullable RIJDownloadView paramRIJDownloadView, @Nullable uev paramuev)
  {
    ThreadManagerV2.getUIHandlerV2().post((Runnable)new AdDownloadCallBack.doCallBack.1(this, paramRIJDownloadView, paramuev));
  }
  
  protected abstract void onCallBack(@Nullable RIJDownloadView paramRIJDownloadView, @Nullable uev paramuev);
  
  protected final void onCancelDownloadUI(@Nullable RIJDownloadView paramRIJDownloadView)
  {
    Object localObject;
    if (paramRIJDownloadView != null)
    {
      localObject = paramRIJDownloadView.a();
      if (localObject != null) {
        ((ule)localObject).a = 0;
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
        ((ule)localObject).a = 6;
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
            QQToast.a(paramRIJDownloadView, (CharSequence)anvx.a(2131712439), 0).a();
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
        ((ule)localObject).a = 0;
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
        if ((localObject != null) && (ufc.g((AdvertisementInfo)localObject) == true))
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
  
  protected final void onPauseDownloadUI(@Nullable RIJDownloadView paramRIJDownloadView, @Nullable uev paramuev)
  {
    if (paramRIJDownloadView != null) {
      paramRIJDownloadView.b(false);
    }
    if (paramRIJDownloadView != null)
    {
      paramuev = paramRIJDownloadView.a();
      if (paramuev != null) {
        paramuev.a = 4;
      }
    }
    Object localObject;
    if (paramRIJDownloadView != null)
    {
      localObject = paramRIJDownloadView.a();
      if (localObject != null)
      {
        paramuev = paramRIJDownloadView.a();
        if (paramuev == null) {
          break label159;
        }
        paramuev = Integer.valueOf(paramuev.b);
        ((ule)localObject).b = paramuev.intValue();
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
        paramuev = "继续";
        label94:
        ((ufm)localObject).setProgressText(paramuev);
      }
    }
    if (paramRIJDownloadView != null)
    {
      paramuev = paramRIJDownloadView.a();
      if (paramuev != null)
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
    for (int i = ((ule)localObject).b;; i = 0)
    {
      paramuev.setProgress(i);
      if (paramRIJDownloadView != null)
      {
        paramRIJDownloadView = paramRIJDownloadView.a();
        if (paramRIJDownloadView != null) {
          paramRIJDownloadView.a();
        }
      }
      return;
      paramuev = null;
      break;
      paramuev = "继续下载";
      break label94;
    }
  }
  
  protected final void onProgressUpdateUI(@Nullable RIJDownloadView paramRIJDownloadView, @Nullable uev paramuev)
  {
    Object localObject = null;
    if (paramRIJDownloadView != null) {
      paramRIJDownloadView.b(true);
    }
    ule localule;
    if (paramRIJDownloadView != null)
    {
      localule = paramRIJDownloadView.a();
      if (localule != null) {
        localule.a = 3;
      }
    }
    if (paramRIJDownloadView != null)
    {
      localule = paramRIJDownloadView.a();
      if (localule != null)
      {
        if (paramuev == null) {
          break label175;
        }
        paramuev = Integer.valueOf(paramuev.b());
        localule.b = paramuev.intValue();
      }
    }
    if (paramRIJDownloadView != null)
    {
      paramuev = paramRIJDownloadView.a();
      if (paramuev != null) {
        paramuev.b();
      }
    }
    if (paramRIJDownloadView != null)
    {
      paramuev = paramRIJDownloadView.a();
      if (paramuev != null)
      {
        localule = paramRIJDownloadView.a();
        if (localule == null) {
          break label180;
        }
      }
    }
    label175:
    label180:
    for (int i = localule.b;; i = 0)
    {
      paramuev.setProgress(i);
      if (paramRIJDownloadView != null)
      {
        paramuev = paramRIJDownloadView.a();
        if (paramuev != null)
        {
          localule = paramRIJDownloadView.a();
          paramRIJDownloadView = localObject;
          if (localule != null) {
            paramRIJDownloadView = String.valueOf(localule.b);
          }
          paramuev.setProgressText(Intrinsics.stringPlus(paramRIJDownloadView, "%"));
        }
      }
      return;
      paramuev = null;
      break;
    }
  }
  
  protected final void onQueryResultUI(@Nullable RIJDownloadView paramRIJDownloadView, @Nullable uev paramuev)
  {
    if ((paramRIJDownloadView == null) || (paramuev == null)) {}
    do
    {
      return;
      if (udr.a.a(paramuev.a()))
      {
        onInstallSucceedUI(paramRIJDownloadView);
        return;
      }
      Object localObject = paramRIJDownloadView.a();
      if (localObject != null) {}
      for (localObject = ((ule)localObject).i; ((!TextUtils.isEmpty((CharSequence)localObject)) && (new File((String)localObject).exists())) || (paramuev.a() == 5); localObject = null)
      {
        onSuccessDownloadUI(paramRIJDownloadView);
        return;
      }
      if (paramuev.a() == 4)
      {
        localObject = paramRIJDownloadView.a();
        if (localObject != null)
        {
          ((ule)localObject).a = 4;
          ((ule)localObject).b = paramuev.b();
        }
        onPauseDownloadUI(paramRIJDownloadView, paramuev);
        return;
      }
    } while (paramuev.a() != 0);
    onInitUI(paramRIJDownloadView);
  }
  
  protected final void onResumeDownloadUI(@Nullable RIJDownloadView paramRIJDownloadView)
  {
    if (paramRIJDownloadView != null) {
      paramRIJDownloadView.b(true);
    }
    if (paramRIJDownloadView != null)
    {
      ule localule = paramRIJDownloadView.a();
      if (localule != null) {
        localule.a = 3;
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
  
  protected final void onStartDownloadUI(@Nullable RIJDownloadView paramRIJDownloadView, @Nullable uev paramuev)
  {
    if (paramRIJDownloadView != null) {
      paramRIJDownloadView.b(true);
    }
    if (paramRIJDownloadView != null)
    {
      paramuev = paramRIJDownloadView.a();
      if (paramuev != null) {
        paramuev.setProgress(0);
      }
    }
    if (paramRIJDownloadView != null)
    {
      paramuev = paramRIJDownloadView.a();
      if (paramuev != null) {
        paramuev.setProgressText("0%");
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
        ((ule)localObject).a = 5;
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
        localObject = ((ule)localObject).i;
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
            ((ule)localObject).a = 5;
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
  
  protected final void reportPercentIfNeed(@Nullable uev paramuev, int paramInt)
  {
    if (paramuev != null) {}
    for (String str = paramuev.a();; str = null)
    {
      if ((paramInt >= 90) && (!uet.a.a(str, DownloadPercent.PERCENT_90)))
      {
        uet.a.a(str, DownloadPercent.PERCENT_90);
        ufd.a.a("download90percent", paramuev);
      }
      if ((paramInt >= 75) && (!uet.a.a(str, DownloadPercent.PERCENT_75)))
      {
        uet.a.a(str, DownloadPercent.PERCENT_75);
        ufd.a.a("download75percent", paramuev);
      }
      if ((paramInt >= 50) && (!uet.a.a(str, DownloadPercent.PERCENT_50)))
      {
        uet.a.a(str, DownloadPercent.PERCENT_50);
        ufd.a.a("download50percent", paramuev);
      }
      if ((paramInt >= 25) && (!uet.a.a(str, DownloadPercent.PERCENT_25)))
      {
        uet.a.a(str, DownloadPercent.PERCENT_25);
        ufd.a.a("download25percent", paramuev);
      }
      if ((paramInt >= 10) && (!uet.a.a(str, DownloadPercent.PERCENT_10)))
      {
        uet.a.a(str, DownloadPercent.PERCENT_10);
        ufd.a.a("download10percent", paramuev);
      }
      if ((paramInt >= 1) && (!uet.a.a(str, DownloadPercent.PERCENT_1)))
      {
        uet.a.a(str, DownloadPercent.PERCENT_1);
        ufd.a.a("download1percent", paramuev);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.event.AdDownloadCallBack
 * JD-Core Version:    0.7.0.1
 */