package com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.event;

import androidx.annotation.UiThread;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.view.RIJDownloadView;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/event/AdDownloadLifeEvent;", "", "(Ljava/lang/String;I)V", "onEvent", "", "viewRIJ", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/view/RIJDownloadView;", "OnAttachedToWindow", "OnDetachedFromWindow", "Companion", "kandian_ad_feature_impl_release"}, k=1, mv={1, 1, 16})
public enum AdDownloadLifeEvent
{
  public static final AdDownloadLifeEvent.Companion Companion = new AdDownloadLifeEvent.Companion(null);
  @NotNull
  public static final String TAG = "AD_DOWNLOAD_TAG";
  
  static
  {
    AdDownloadLifeEvent.OnAttachedToWindow localOnAttachedToWindow = new AdDownloadLifeEvent.OnAttachedToWindow("OnAttachedToWindow", 0);
    OnAttachedToWindow = localOnAttachedToWindow;
    AdDownloadLifeEvent.OnDetachedFromWindow localOnDetachedFromWindow = new AdDownloadLifeEvent.OnDetachedFromWindow("OnDetachedFromWindow", 1);
    OnDetachedFromWindow = localOnDetachedFromWindow;
    $VALUES = new AdDownloadLifeEvent[] { localOnAttachedToWindow, localOnDetachedFromWindow };
  }
  
  private AdDownloadLifeEvent() {}
  
  @UiThread
  public abstract void onEvent(@Nullable RIJDownloadView paramRIJDownloadView);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.event.AdDownloadLifeEvent
 * JD-Core Version:    0.7.0.1
 */