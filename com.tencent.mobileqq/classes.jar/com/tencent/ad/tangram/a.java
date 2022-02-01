package com.tencent.ad.tangram;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGetRsp.AdInfo;
import com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGetRsp.AdInfo.AppInfo;
import com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGetRsp.AdInfo.DestInfo;
import com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo;
import com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.AdvertiserInfo;
import com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.VideoInfo;
import com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGetRsp.AdInfo.ExpParam;
import com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGetRsp.AdInfo.Ext;
import com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo;
import com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo;
import com.tencent.ad.tangram.util.AdUriUtil;
import java.io.Serializable;
import java.util.List;
import org.json.JSONObject;

public final class a
  implements Ad, Serializable
{
  public static final int REPORT_STATE_FINISHED = 2;
  public static final int REPORT_STATE_INIT = -1;
  public static final int REPORT_STATE_PENDING = 1;
  private static final String TAG = "AdImplementation";
  public long actionSetId = -2147483648L;
  private qq_ad_get.QQAdGetRsp.AdInfo info;
  public int reportState = -1;
  
  public a() {}
  
  public a(qq_ad_get.QQAdGetRsp.AdInfo paramAdInfo)
  {
    this.info = paramAdInfo;
  }
  
  private boolean isXiJingOffline()
  {
    if (TextUtils.isEmpty(getJSONKeyForXiJingOffline())) {}
    while ((TextUtils.isEmpty(getJSONUrlForXiJingOffline())) || (TextUtils.isEmpty(getUrlForXiJingOffline()))) {
      return false;
    }
    return true;
  }
  
  public boolean disableAutoDownload()
  {
    return false;
  }
  
  public long getAId()
  {
    if (isValid()) {
      return this.info.report_info.trace_info.aid;
    }
    return -2147483648L;
  }
  
  public long getActionSetId()
  {
    return this.actionSetId;
  }
  
  public long getAdvertiserId()
  {
    if (isValid()) {
      return this.info.display_info.advertiser_info.advertiser_id;
    }
    return -2147483648L;
  }
  
  public String getAdvertiser_corporate_image_name()
  {
    if (isValid()) {
      return this.info.display_info.advertiser_info.corporate_image_name;
    }
    return "";
  }
  
  public String getAdvertiser_corporate_logo()
  {
    if (isValid()) {
      return this.info.display_info.advertiser_info.corporate_logo;
    }
    return "";
  }
  
  public String getAppChannelId()
  {
    if (isAppProductType()) {
      return this.info.app_info.channel_id;
    }
    return null;
  }
  
  public String getAppDeeplink()
  {
    if (isValid()) {
      return this.info.app_info.customized_invoke_url;
    }
    return null;
  }
  
  public String getAppId()
  {
    if (isAppProductType()) {
      return this.info.app_info.android_app_id;
    }
    return null;
  }
  
  public String getAppMarketDeeplink()
  {
    return null;
  }
  
  public String getAppMarketPackageName()
  {
    return null;
  }
  
  public String getAppName()
  {
    if (isAppProductType()) {
      return this.info.app_info.app_name;
    }
    return null;
  }
  
  public String getAppPackageName()
  {
    if ((isAppProductType()) || (isJDProductType())) {
      return this.info.app_info.app_package_name;
    }
    return null;
  }
  
  public String getAppPackageUrl()
  {
    if (isAppProductType()) {
      return this.info.app_info.pkg_url;
    }
    return null;
  }
  
  public int getBannerInvalidClickXPercent()
  {
    if (!isValid()) {}
    for (;;)
    {
      return -2147483648;
      List localList = getExpMap();
      int i = 0;
      while (i < localList.size())
      {
        if (((qq_ad_get.QQAdGetRsp.AdInfo.ExpParam)localList.get(i)).key == 101164) {
          return Integer.parseInt(((qq_ad_get.QQAdGetRsp.AdInfo.ExpParam)localList.get(i)).value);
        }
        i += 1;
      }
    }
  }
  
  public int getBannerInvalidClickYPercent()
  {
    if (!isValid()) {}
    for (;;)
    {
      return -2147483648;
      List localList = getExpMap();
      int i = 0;
      while (i < localList.size())
      {
        if (((qq_ad_get.QQAdGetRsp.AdInfo.ExpParam)localList.get(i)).key == 101166) {
          return Integer.parseInt(((qq_ad_get.QQAdGetRsp.AdInfo.ExpParam)localList.get(i)).value);
        }
        i += 1;
      }
    }
  }
  
  public String getBusinessIdForXiJingOffline()
  {
    return null;
  }
  
  public String getCanvas()
  {
    if (isCanvas()) {
      return this.info.dest_info.canvas_json;
    }
    return null;
  }
  
  public String getCanvasForXiJingOffline()
  {
    return null;
  }
  
  public int getCreativeSize()
  {
    if (isValid()) {
      return this.info.display_info.creative_size;
    }
    return -2147483648;
  }
  
  public int getDestType()
  {
    if (isValid()) {
      return this.info.dest_info.dest_type;
    }
    return -2147483648;
  }
  
  public List getExpMap()
  {
    return null;
  }
  
  public String getJSONKeyForXiJingOffline()
  {
    return null;
  }
  
  public String getJSONUrlForXiJingOffline()
  {
    return null;
  }
  
  public long getMinIntervalMillisBetweenExposureAndClick()
  {
    if (!isValid()) {}
    for (;;)
    {
      return -2147483648L;
      List localList = getExpMap();
      int i = 0;
      while (i < localList.size())
      {
        if (((qq_ad_get.QQAdGetRsp.AdInfo.ExpParam)localList.get(i)).key == 101168)
        {
          if (Integer.parseInt(((qq_ad_get.QQAdGetRsp.AdInfo.ExpParam)localList.get(i)).value) >= 1000) {
            return 1000L;
          }
          return Integer.parseInt(((qq_ad_get.QQAdGetRsp.AdInfo.ExpParam)localList.get(i)).value);
        }
        i += 1;
      }
    }
  }
  
  public String getPosId()
  {
    Object localObject = getUrlForClick();
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      localObject = null;
    }
    while (!TextUtils.isEmpty((CharSequence)localObject))
    {
      return localObject;
      localObject = AdUriUtil.parse((String)localObject);
      if (localObject == null) {
        localObject = null;
      } else {
        localObject = AdUriUtil.getQueryParameter((Uri)localObject, "pid");
      }
    }
    return null;
  }
  
  public String getProductId()
  {
    if (isValid()) {
      return this.info.report_info.trace_info.product_id;
    }
    return null;
  }
  
  public int getProductType()
  {
    if (isValid()) {
      return this.info.product_type;
    }
    return -2147483648;
  }
  
  public int getRelationTarget()
  {
    if (!isValid()) {}
    for (;;)
    {
      return 0;
      if (this.info.ext.relation_target >= 0) {
        return this.info.ext.relation_target;
      }
      if (!TextUtils.isEmpty(this.info.ext_json)) {
        try
        {
          qq_ad_get.QQAdGetRsp.AdInfo.Ext localExt = (qq_ad_get.QQAdGetRsp.AdInfo.Ext)qq_ad_get.QQAdGetRsp.AdInfo.Ext.class.cast(new JSONObject(this.info.ext_json));
          if (localExt != null)
          {
            int i = localExt.relation_target;
            return i;
          }
        }
        catch (Throwable localThrowable)
        {
          AdLog.e("AdImplementation", "getRelationTarget", localThrowable);
        }
      }
    }
  }
  
  public String getTencent_video_id()
  {
    if (isValid()) {
      return this.info.display_info.video_info.tencent_video_id;
    }
    return null;
  }
  
  public String getTraceId()
  {
    if (isValid()) {
      return this.info.report_info.trace_info.traceid;
    }
    return null;
  }
  
  public String getUrlForAction()
  {
    if (isValid()) {
      return this.info.report_info.landing_page_report_url;
    }
    return null;
  }
  
  public String getUrlForClick()
  {
    if (isValid()) {
      return this.info.report_info.click_url;
    }
    return null;
  }
  
  public String getUrlForEffect()
  {
    if (isValid()) {
      return this.info.report_info.effect_url;
    }
    return null;
  }
  
  public String getUrlForFeedBack()
  {
    if (isValid()) {
      return this.info.report_info.negative_feedback_url;
    }
    return null;
  }
  
  public String getUrlForImpression()
  {
    if (isValid()) {
      return this.info.report_info.exposure_url;
    }
    return null;
  }
  
  public String getUrlForLandingPage()
  {
    if (isValid()) {
      return this.info.dest_info.landing_page;
    }
    return null;
  }
  
  public String getUrlForXiJingOffline()
  {
    return null;
  }
  
  public String getVia()
  {
    if (isValid()) {
      return this.info.report_info.trace_info.via;
    }
    return null;
  }
  
  public String getVideoUrl()
  {
    if (isValid()) {
      return this.info.display_info.video_info.video_url;
    }
    return null;
  }
  
  public String getVideoUrl2()
  {
    if (isValid()) {
      return this.info.display_info.video_info2.video_url;
    }
    return null;
  }
  
  public boolean isAppProductType()
  {
    return getProductType() == 12;
  }
  
  public boolean isAppXiJing()
  {
    return (isAppProductType()) && (getDestType() == 1);
  }
  
  public boolean isAppXiJingDefault()
  {
    return (isAppProductType()) && (getDestType() == 0);
  }
  
  public boolean isAppXiJingOffline()
  {
    return (isAppXiJing()) && (isXiJingOffline());
  }
  
  public boolean isCanvas()
  {
    return ((isAppXiJing()) && (!TextUtils.isEmpty(this.info.dest_info.canvas_json))) || ((getProductType() == 1000) && (getDestType() == 4) && (!TextUtils.isEmpty(this.info.dest_info.canvas_json)));
  }
  
  public boolean isHitCanvasVideoCeilingExp()
  {
    boolean bool = true;
    if (!isValid()) {}
    for (;;)
    {
      bool = false;
      do
      {
        return bool;
      } while (this.info.ext.landing_page_style == 1);
      if (TextUtils.isEmpty(this.info.ext_json)) {
        continue;
      }
      try
      {
        qq_ad_get.QQAdGetRsp.AdInfo.Ext localExt = (qq_ad_get.QQAdGetRsp.AdInfo.Ext)qq_ad_get.QQAdGetRsp.AdInfo.Ext.class.cast(new JSONObject(this.info.ext_json));
        if (localExt == null) {
          continue;
        }
        int i = localExt.landing_page_style;
        if (i == 1) {}
        for (bool = true;; bool = false) {
          return bool;
        }
      }
      catch (Throwable localThrowable)
      {
        AdLog.e("AdImplementation", "isHitCanvasVideoCeilingExp", localThrowable);
      }
    }
  }
  
  public boolean isHitFirstLoadImageExp()
  {
    if (!isValid()) {}
    for (;;)
    {
      return false;
      List localList = getExpMap();
      int i = 0;
      while (i < localList.size())
      {
        if ((((qq_ad_get.QQAdGetRsp.AdInfo.ExpParam)localList.get(i)).key == 95837) && (((qq_ad_get.QQAdGetRsp.AdInfo.ExpParam)localList.get(i)).value.equals("1"))) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  public boolean isHitRelationTargetInstallExp()
  {
    if (!isValid()) {}
    for (;;)
    {
      return false;
      List localList = getExpMap();
      int i = 0;
      while (i < localList.size())
      {
        if ((((qq_ad_get.QQAdGetRsp.AdInfo.ExpParam)localList.get(i)).key == 94735) && (((qq_ad_get.QQAdGetRsp.AdInfo.ExpParam)localList.get(i)).value.equals("1"))) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  public boolean isHitWithoutInstallSuccessPage()
  {
    if (!isValid()) {}
    for (;;)
    {
      return false;
      List localList = getExpMap();
      int i = 0;
      while (i < localList.size())
      {
        if ((((qq_ad_get.QQAdGetRsp.AdInfo.ExpParam)localList.get(i)).key == 101056) && (((qq_ad_get.QQAdGetRsp.AdInfo.ExpParam)localList.get(i)).value.equals("1"))) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  public boolean isJDProductType()
  {
    return getProductType() == 25;
  }
  
  public boolean isQQMINIProgram()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (isValid())
    {
      bool1 = bool2;
      if (this.info.display_info.mini_program_type == 11) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean isValid()
  {
    return this.info != null;
  }
  
  public boolean isVideoSplice()
  {
    return ((getProductType() == 1000) || (getProductType() == 12) || (getProductType() == 25) || (getProductType() == 30)) && ((getDestType() == 0) || (getDestType() == 4) || (getDestType() == 1)) && ((getCreativeSize() == 585) || (getCreativeSize() == 930));
  }
  
  public boolean isWebXiJing()
  {
    return (getProductType() == 1000) && (getDestType() == 4);
  }
  
  public boolean isWebXiJingOffline()
  {
    return (isWebXiJing()) && (isXiJingOffline());
  }
  
  public void setActionSetId(long paramLong)
  {
    this.actionSetId = paramLong;
  }
  
  public void setCanvasForXiJingOffline(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ad.tangram.a
 * JD-Core Version:    0.7.0.1
 */