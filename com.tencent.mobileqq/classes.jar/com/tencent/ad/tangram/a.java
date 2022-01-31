package com.tencent.ad.tangram;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGetRsp.AdInfo;
import com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGetRsp.AdInfo.AppInfo;
import com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGetRsp.AdInfo.DestInfo;
import com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo;
import com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.VideoInfo;
import com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGetRsp.AdInfo.Ext;
import com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo;
import com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo;
import com.tencent.ad.tangram.util.AdUriUtil;
import java.io.Serializable;
import org.json.JSONObject;

public final class a
  implements Ad, Serializable
{
  private static final String TAG = "AdImplementation";
  private qq_ad_get.QQAdGetRsp.AdInfo info;
  
  public a() {}
  
  public a(qq_ad_get.QQAdGetRsp.AdInfo paramAdInfo)
  {
    this.info = paramAdInfo;
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
    if (isAppProductType()) {
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
  
  public boolean isHitJumpExperiment()
  {
    if (!isValid()) {}
    for (;;)
    {
      return false;
      if (this.info.ext.no_clkcgi_jump) {
        return true;
      }
      if (!TextUtils.isEmpty(this.info.ext_json)) {
        try
        {
          qq_ad_get.QQAdGetRsp.AdInfo.Ext localExt = (qq_ad_get.QQAdGetRsp.AdInfo.Ext)qq_ad_get.QQAdGetRsp.AdInfo.Ext.class.cast(new JSONObject(this.info.ext_json));
          if (localExt != null)
          {
            boolean bool = localExt.no_clkcgi_jump;
            return bool;
          }
        }
        catch (Throwable localThrowable)
        {
          AdLog.e("AdImplementation", "isHitJumpExperiment", localThrowable);
        }
      }
    }
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.a
 * JD-Core Version:    0.7.0.1
 */