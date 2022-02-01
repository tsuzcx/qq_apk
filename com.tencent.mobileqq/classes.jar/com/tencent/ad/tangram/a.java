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
    return (!TextUtils.isEmpty(getJSONKeyForXiJingOffline())) && (!TextUtils.isEmpty(getJSONUrlForXiJingOffline())) && (!TextUtils.isEmpty(getUrlForXiJingOffline()));
  }
  
  public boolean disableAutoDownload()
  {
    return false;
  }
  
  public boolean disableLaunchApp()
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
    if ((!isAppProductType()) && (!isJDProductType())) {
      return null;
    }
    return this.info.app_info.app_package_name;
  }
  
  public String getAppPackageUrl()
  {
    if (isAppProductType()) {
      return this.info.app_info.pkg_url;
    }
    return null;
  }
  
  public String getAppRightInfoUrl()
  {
    if (isValid()) {
      return this.info.app_info.app_standard_info_url;
    }
    return null;
  }
  
  public int getBannerInvalidClickXPercent()
  {
    if (isValid())
    {
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
    return -2147483648;
  }
  
  public int getBannerInvalidClickYPercent()
  {
    if (isValid())
    {
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
    return -2147483648;
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
  
  public List<?> getFeedbackItems()
  {
    return null;
  }
  
  public int getInnerShowType()
  {
    return 0;
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
    if (isValid())
    {
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
    return -2147483648L;
  }
  
  public String getPosId()
  {
    Object localObject = getUrlForClick();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = AdUriUtil.parse((String)localObject);
      if (localObject != null) {}
    }
    else
    {
      localObject = null;
      break label36;
    }
    localObject = AdUriUtil.getQueryParameter((Uri)localObject, "pid");
    label36:
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      return localObject;
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
    if (isValid())
    {
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
    return 0;
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
  
  public boolean isAppPreOrder()
  {
    if ((isValid()) && ((isAppXiJing()) || (isAppXiJingFengling())))
    {
      if (this.info.ext != null) {
        return this.info.ext.is_app_preorder;
      }
      if (!TextUtils.isEmpty(this.info.ext_json)) {
        try
        {
          qq_ad_get.QQAdGetRsp.AdInfo.Ext localExt = (qq_ad_get.QQAdGetRsp.AdInfo.Ext)qq_ad_get.QQAdGetRsp.AdInfo.Ext.class.cast(new JSONObject(this.info.ext_json));
          if (localExt != null)
          {
            boolean bool = localExt.is_app_preorder;
            return bool;
          }
        }
        catch (Throwable localThrowable)
        {
          AdLog.e("AdImplementation", "isAppPreOder", localThrowable);
        }
      }
    }
    return false;
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
  
  public boolean isAppXiJingFengling()
  {
    return (isAppProductType()) && (getDestType() == 4);
  }
  
  public boolean isAppXiJingOffline()
  {
    return (isAppXiJing()) && (isXiJingOffline());
  }
  
  public boolean isCanvas()
  {
    return ((isAppXiJing()) && (!TextUtils.isEmpty(this.info.dest_info.canvas_json))) || ((getProductType() == 1000) && (getDestType() == 4) && (!TextUtils.isEmpty(this.info.dest_info.canvas_json)));
  }
  
  public boolean isHitFirstLoadImageExp()
  {
    if (!isValid()) {
      return false;
    }
    List localList = getExpMap();
    int i = 0;
    while (i < localList.size())
    {
      if ((((qq_ad_get.QQAdGetRsp.AdInfo.ExpParam)localList.get(i)).key == 95837) && (((qq_ad_get.QQAdGetRsp.AdInfo.ExpParam)localList.get(i)).value.equals("1"))) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public boolean isJDProductType()
  {
    return getProductType() == 25;
  }
  
  public boolean isQQMINIProgram()
  {
    boolean bool3 = isValid();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
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
  
  public boolean isVideoOnTopDisabled()
  {
    if ((isValid()) && (!TextUtils.isEmpty(this.info.ext_json))) {
      try
      {
        qq_ad_get.QQAdGetRsp.AdInfo.Ext localExt = (qq_ad_get.QQAdGetRsp.AdInfo.Ext)qq_ad_get.QQAdGetRsp.AdInfo.Ext.class.cast(new JSONObject(this.info.ext_json));
        if (localExt != null)
        {
          boolean bool = localExt.disable_video_on_top;
          return bool;
        }
      }
      catch (Throwable localThrowable)
      {
        AdLog.e("AdImplementation", "isVideoOnTopDisabled", localThrowable);
      }
    }
    return false;
  }
  
  public boolean isVideoSplice()
  {
    int i = getProductType();
    boolean bool = true;
    if (((i == 1000) || (getProductType() == 12) || (getProductType() == 25) || (getProductType() == 30)) && ((getDestType() == 0) || (getDestType() == 4) || (getDestType() == 1)))
    {
      if (getCreativeSize() == 585) {
        return bool;
      }
      if (getCreativeSize() == 930) {
        return true;
      }
    }
    bool = false;
    return bool;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.a
 * JD-Core Version:    0.7.0.1
 */