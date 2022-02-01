package com.tencent.gdtad.util;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtImageData;
import com.tencent.gdtad.basics.motivevideo.data.GdtMotiveVideoModel;
import com.tencent.gdtad.basics.motivevideo.data.GdtMotiveVideoPageData;
import com.tencent.gdtad.json.GdtJsonPbUtil;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;

public class GdtUtil
{
  public static int a(int paramInt)
  {
    int i = 1;
    if (1 == paramInt) {
      return 0;
    }
    if (2 == paramInt) {
      i = 8;
    }
    return i;
  }
  
  public static int a(GdtMotiveVideoModel paramGdtMotiveVideoModel)
  {
    if ((paramGdtMotiveVideoModel != null) && (paramGdtMotiveVideoModel.d() != null)) {
      j = paramGdtMotiveVideoModel.d().getRewardTime();
    } else {
      j = 0;
    }
    int i = j;
    if (j <= 0)
    {
      i = j;
      if (paramGdtMotiveVideoModel != null)
      {
        i = j;
        if (paramGdtMotiveVideoModel.a() != null) {
          i = paramGdtMotiveVideoModel.a().getVideoCountDown();
        }
      }
    }
    int j = i;
    if (i <= 0) {
      j = 15;
    }
    return j;
  }
  
  public static GdtMotiveVideoPageData a(qq_ad_get.QQAdGetRsp.AdInfo paramAdInfo, int paramInt)
  {
    GdtAd localGdtAd = new GdtAd(paramAdInfo);
    Object localObject1 = localGdtAd.info;
    Object localObject2 = null;
    if (localObject1 != null)
    {
      GdtMotiveVideoPageData localGdtMotiveVideoPageData = new GdtMotiveVideoPageData();
      localGdtMotiveVideoPageData.productType = localGdtAd.getProductType();
      localGdtMotiveVideoPageData.vSize = localGdtAd.getCreativeSize();
      localGdtMotiveVideoPageData.screenOrientation = paramInt;
      localGdtMotiveVideoPageData.adId = localGdtAd.getAdvertiserId();
      localGdtMotiveVideoPageData.vid = localGdtAd.getTencent_video_id();
      localGdtMotiveVideoPageData.url = localGdtAd.getVideoUrl();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("VideoUrl ");
      ((StringBuilder)localObject1).append(localGdtMotiveVideoPageData.url);
      GdtLog.d("GdtUtil", ((StringBuilder)localObject1).toString());
      localObject1 = localGdtAd.getImageData();
      String str = "";
      if (localObject1 == null) {
        localObject1 = "";
      } else {
        localObject1 = localGdtAd.getImageData().a;
      }
      localGdtMotiveVideoPageData.previewImgUrl = ((String)localObject1);
      localGdtMotiveVideoPageData.bannerImgName = localGdtAd.getAdvertiser_corporate_image_name();
      localGdtMotiveVideoPageData.bannerBaseInfoText = localGdtAd.getText();
      localGdtMotiveVideoPageData.bannerLogo = localGdtAd.getAdvertiser_corporate_logo();
      localGdtMotiveVideoPageData.exposureUrl = localGdtAd.getUrlForImpression();
      localGdtMotiveVideoPageData.appScore = Double.valueOf(localGdtAd.getAppScore()).doubleValue();
      localGdtMotiveVideoPageData.downloadNum = localGdtAd.getAppDownloadNum();
      localGdtMotiveVideoPageData.style = localGdtAd.getStyle();
      localGdtMotiveVideoPageData.endcardUrl = localGdtAd.getEndcardUrl();
      localGdtMotiveVideoPageData.endcardLoadTime = localGdtAd.getEndcardLoadTime();
      localGdtMotiveVideoPageData.bottomCardUrl = localGdtAd.getBottomCardUrl();
      localGdtMotiveVideoPageData.bottomCardLoadTime = localGdtAd.getBottomCardLoadTime();
      localObject1 = localObject2;
      if (paramAdInfo != null) {
        localObject1 = GdtJsonPbUtil.a(paramAdInfo);
      }
      if (localObject1 == null) {
        paramAdInfo = str;
      } else {
        paramAdInfo = localObject1.toString();
      }
      localGdtMotiveVideoPageData.adsContent = paramAdInfo;
      localGdtMotiveVideoPageData.processId = MobileQQ.sProcessId;
      return localGdtMotiveVideoPageData;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("createMVPageData error ");
    ((StringBuilder)localObject1).append(paramAdInfo);
    ((StringBuilder)localObject1).append(" portrait ");
    ((StringBuilder)localObject1).append(paramInt);
    QLog.e("GdtUtil", 1, ((StringBuilder)localObject1).toString());
    return null;
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    if ((paramContext != null) && (!TextUtils.isEmpty(paramString)))
    {
      boolean bool = PackageUtil.a(paramContext, paramString);
      if (QLog.isColorLevel())
      {
        paramContext = new StringBuilder();
        paramContext.append("isAppInstall pkg:");
        paramContext.append(paramString);
        paramContext.append(" ");
        paramContext.append(bool);
        QLog.d("GdtUtil", 2, paramContext.toString());
      }
      return bool;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.util.GdtUtil
 * JD-Core Version:    0.7.0.1
 */