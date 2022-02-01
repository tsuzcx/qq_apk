package com.tencent.ad.tangram;

import android.support.annotation.Keep;

@Keep
public abstract interface Ad
{
  public abstract boolean disableAutoDownload();
  
  public abstract long getAId();
  
  public abstract long getActionSetId();
  
  public abstract long getAdvertiserId();
  
  public abstract String getAdvertiser_corporate_image_name();
  
  public abstract String getAdvertiser_corporate_logo();
  
  public abstract String getAppChannelId();
  
  public abstract String getAppDeeplink();
  
  public abstract String getAppId();
  
  public abstract String getAppMarketDeeplink();
  
  public abstract String getAppMarketPackageName();
  
  public abstract String getAppName();
  
  public abstract String getAppPackageName();
  
  public abstract String getAppPackageUrl();
  
  public abstract int getBannerInvalidClickXPercent();
  
  public abstract int getBannerInvalidClickYPercent();
  
  public abstract String getBusinessIdForXiJingOffline();
  
  public abstract String getCanvas();
  
  public abstract String getCanvasForXiJingOffline();
  
  public abstract int getCreativeSize();
  
  public abstract int getDestType();
  
  public abstract String getJSONKeyForXiJingOffline();
  
  public abstract String getJSONUrlForXiJingOffline();
  
  public abstract long getMinIntervalMillisBetweenExposureAndClick();
  
  public abstract String getPosId();
  
  public abstract String getProductId();
  
  public abstract int getProductType();
  
  public abstract int getRelationTarget();
  
  public abstract String getTencent_video_id();
  
  public abstract String getTraceId();
  
  public abstract String getUrlForAction();
  
  public abstract String getUrlForClick();
  
  public abstract String getUrlForEffect();
  
  public abstract String getUrlForFeedBack();
  
  public abstract String getUrlForImpression();
  
  public abstract String getUrlForLandingPage();
  
  public abstract String getUrlForXiJingOffline();
  
  public abstract String getVia();
  
  public abstract String getVideoUrl();
  
  public abstract String getVideoUrl2();
  
  public abstract boolean isAppProductType();
  
  public abstract boolean isAppXiJing();
  
  public abstract boolean isAppXiJingDefault();
  
  public abstract boolean isAppXiJingOffline();
  
  public abstract boolean isCanvas();
  
  public abstract boolean isHitCanvasVideoCeilingExp();
  
  public abstract boolean isHitFirstLoadImageExp();
  
  public abstract boolean isHitRelationTargetInstallExp();
  
  public abstract boolean isHitWithoutInstallSuccessPage();
  
  public abstract boolean isJDProductType();
  
  public abstract boolean isQQMINIProgram();
  
  public abstract boolean isValid();
  
  public abstract boolean isVideoSplice();
  
  public abstract boolean isWebXiJing();
  
  public abstract boolean isWebXiJingOffline();
  
  public abstract void setActionSetId(long paramLong);
  
  public abstract void setCanvasForXiJingOffline(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ad.tangram.Ad
 * JD-Core Version:    0.7.0.1
 */