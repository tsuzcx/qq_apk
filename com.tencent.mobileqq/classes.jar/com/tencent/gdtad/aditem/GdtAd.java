package com.tencent.gdtad.aditem;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.util.AdUriUtil;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.io.ByteArrayOutputStream;
import java.io.Externalizable;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.AppInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DestInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.AdvertiserInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.MutiPicTextInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.VideoInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ExpInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.Ext;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo;
import yjt;
import ynv;
import yny;

public class GdtAd
  implements Ad, Externalizable
{
  public static final int REPORT_STATE_FINISHED = 2;
  public static final int REPORT_STATE_INIT = -1;
  public static final int REPORT_STATE_PENDING = 1;
  public long actionSetId = -2147483648L;
  public qq_ad_get.QQAdGetRsp.AdInfo info;
  public int reportState = -1;
  
  public GdtAd() {}
  
  public GdtAd(qq_ad_get.QQAdGetRsp.AdInfo paramAdInfo)
  {
    this.info = paramAdInfo;
  }
  
  public boolean canPreloadForQQMINIProgram()
  {
    boolean bool = true;
    if (!isValid()) {}
    for (;;)
    {
      bool = false;
      do
      {
        return bool;
        if (!isQQMINIProgram()) {
          break;
        }
      } while (this.info.ext.mini_program_preload.get() == 1);
      if (TextUtils.isEmpty(this.info.ext_json.get())) {
        continue;
      }
      try
      {
        Object localObject = new JSONObject(this.info.ext_json.get());
        localObject = (qq_ad_get.QQAdGetRsp.AdInfo.Ext)qq_ad_get.QQAdGetRsp.AdInfo.Ext.class.cast(ynv.a(new qq_ad_get.QQAdGetRsp.AdInfo.Ext(), localObject));
        if (localObject == null) {
          continue;
        }
        int i = ((qq_ad_get.QQAdGetRsp.AdInfo.Ext)localObject).mini_program_preload.get();
        if (i == 1) {}
        for (bool = true;; bool = false) {
          return bool;
        }
      }
      catch (Throwable localThrowable)
      {
        yny.b("GdtAd", "canPreloadForQQMINIProgram", localThrowable);
      }
    }
  }
  
  public boolean disableAutoDownload()
  {
    boolean bool = true;
    if (!isValid()) {}
    for (;;)
    {
      bool = false;
      do
      {
        return bool;
        if (!isAppProductType()) {
          break;
        }
      } while (this.info.ext.disable_auto_download.get() == true);
      if (!TextUtils.isEmpty(this.info.ext_json.get())) {
        try
        {
          Object localObject = new JSONObject(this.info.ext_json.get());
          localObject = (qq_ad_get.QQAdGetRsp.AdInfo.Ext)qq_ad_get.QQAdGetRsp.AdInfo.Ext.class.cast(ynv.a(new qq_ad_get.QQAdGetRsp.AdInfo.Ext(), localObject));
          if (localObject != null)
          {
            bool = ((qq_ad_get.QQAdGetRsp.AdInfo.Ext)localObject).disable_auto_download.get();
            return bool;
          }
        }
        catch (Throwable localThrowable)
        {
          yny.b("GdtAd", "disableAutoDownload", localThrowable);
        }
      }
    }
  }
  
  public long getAId()
  {
    if (isValid()) {
      return this.info.report_info.trace_info.aid.get();
    }
    return -2147483648L;
  }
  
  public long getAdvertiserId()
  {
    if (isValid()) {
      return this.info.display_info.advertiser_info.advertiser_id.get();
    }
    return -2147483648L;
  }
  
  public String getAdvertiser_corporate_image_name()
  {
    if (isValid()) {
      return this.info.display_info.advertiser_info.corporate_image_name.get();
    }
    return "";
  }
  
  public String getAdvertiser_corporate_logo()
  {
    if (isValid()) {
      return this.info.display_info.advertiser_info.corporate_logo.get();
    }
    return "";
  }
  
  public String getAppChannelId()
  {
    if (isAppProductType()) {
      return this.info.app_info.channel_id.get();
    }
    return null;
  }
  
  public String getAppDeeplink()
  {
    if (isValid()) {
      return this.info.app_info.customized_invoke_url.get();
    }
    return null;
  }
  
  public long getAppDownloadNum()
  {
    if (isValid()) {
      return this.info.app_info.download_num.get();
    }
    return 0L;
  }
  
  public String getAppId()
  {
    if (isAppProductType()) {
      return this.info.app_info.android_app_id.get();
    }
    return null;
  }
  
  public String getAppMarketDeeplink()
  {
    if (!isValid()) {}
    for (;;)
    {
      return null;
      if (isAppProductType())
      {
        if (!TextUtils.isEmpty(this.info.ext.market_deep_link.get())) {
          return this.info.ext.market_deep_link.get();
        }
        if (!TextUtils.isEmpty(this.info.ext_json.get())) {
          try
          {
            Object localObject = new JSONObject(this.info.ext_json.get());
            localObject = (qq_ad_get.QQAdGetRsp.AdInfo.Ext)qq_ad_get.QQAdGetRsp.AdInfo.Ext.class.cast(ynv.a(new qq_ad_get.QQAdGetRsp.AdInfo.Ext(), localObject));
            if (localObject != null)
            {
              localObject = ((qq_ad_get.QQAdGetRsp.AdInfo.Ext)localObject).market_deep_link.get();
              return localObject;
            }
          }
          catch (Throwable localThrowable)
          {
            yny.b("GdtAd", "getAppMarketDeeplink", localThrowable);
          }
        }
      }
    }
  }
  
  public String getAppMarketPackageName()
  {
    if (!isValid()) {}
    for (;;)
    {
      return null;
      if (isAppProductType())
      {
        if (!TextUtils.isEmpty(this.info.ext.market_package_name.get())) {
          return this.info.ext.market_package_name.get();
        }
        if (!TextUtils.isEmpty(this.info.ext_json.get())) {
          try
          {
            Object localObject = new JSONObject(this.info.ext_json.get());
            localObject = (qq_ad_get.QQAdGetRsp.AdInfo.Ext)qq_ad_get.QQAdGetRsp.AdInfo.Ext.class.cast(ynv.a(new qq_ad_get.QQAdGetRsp.AdInfo.Ext(), localObject));
            if (localObject != null)
            {
              localObject = ((qq_ad_get.QQAdGetRsp.AdInfo.Ext)localObject).market_package_name.get();
              return localObject;
            }
          }
          catch (Throwable localThrowable)
          {
            yny.b("GdtAd", "getAppMarketPackageName", localThrowable);
          }
        }
      }
    }
  }
  
  public String getAppName()
  {
    if (isAppProductType()) {
      return this.info.app_info.app_name.get();
    }
    return null;
  }
  
  public String getAppPackageName()
  {
    if (isAppProductType()) {
      return this.info.app_info.app_package_name.get();
    }
    return null;
  }
  
  public long getAppPackageSize()
  {
    if (isAppProductType()) {}
    for (Long localLong = Long.valueOf(this.info.app_info.app_package_size.get());; localLong = null) {
      return localLong.longValue();
    }
  }
  
  public String getAppPackageUrl()
  {
    if (isAppProductType()) {
      return this.info.app_info.pkg_url.get();
    }
    return null;
  }
  
  public int getAppScore()
  {
    if (isValid()) {
      return this.info.app_info.app_score_num.get();
    }
    return 0;
  }
  
  public String getAppVersion()
  {
    if (isAppProductType()) {
      return this.info.app_info.app_package_version.get();
    }
    return null;
  }
  
  public String getCanvas()
  {
    if (isCanvas()) {
      return this.info.dest_info.canvas_json.get();
    }
    return null;
  }
  
  public int getCreativeSize()
  {
    if (isValid()) {
      return this.info.display_info.creative_size.get();
    }
    return -2147483648;
  }
  
  public String getDescription()
  {
    if (isValid()) {
      return this.info.display_info.basic_info.desc.get();
    }
    return null;
  }
  
  public int getDestType()
  {
    if (isValid()) {
      return this.info.dest_info.dest_type.get();
    }
    return -2147483648;
  }
  
  public yjt getImageData()
  {
    if (!isValid()) {
      return null;
    }
    yjt localyjt = new yjt();
    localyjt.jdField_a_of_type_JavaLangString = this.info.display_info.basic_info.img.get();
    localyjt.jdField_a_of_type_Int = this.info.display_info.basic_info.pic_width.get();
    localyjt.b = this.info.display_info.basic_info.pic_height.get();
    if (localyjt.a()) {}
    for (;;)
    {
      return localyjt;
      localyjt = null;
    }
  }
  
  public yjt getImageData(int paramInt)
  {
    if ((!isValid()) || (paramInt < 0) || (paramInt >= this.info.display_info.muti_pic_text_info.image.size())) {
      return null;
    }
    yjt localyjt = new yjt();
    localyjt.jdField_a_of_type_JavaLangString = ((String)this.info.display_info.muti_pic_text_info.image.get(paramInt));
    localyjt.jdField_a_of_type_Int = this.info.display_info.basic_info.pic_width.get();
    localyjt.b = this.info.display_info.basic_info.pic_height.get();
    return localyjt;
  }
  
  public String getNetLogId()
  {
    if (isValid()) {
      return this.info.report_info.trace_info.net_log_req_id.get();
    }
    return null;
  }
  
  public long getNocoId()
  {
    if (isValid()) {
      return this.info.report_info.trace_info.noco_id.get();
    }
    return -2147483648L;
  }
  
  public String getPosId()
  {
    Object localObject = getUrlForClick();
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      AdLog.e("GdtAd", "getPosId error");
      return null;
    }
    localObject = AdUriUtil.parse((String)localObject);
    if (localObject != null)
    {
      localObject = AdUriUtil.getQueryParameter((Uri)localObject, "pid");
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label53;
      }
    }
    for (;;)
    {
      return localObject;
      localObject = null;
      break;
      label53:
      localObject = null;
    }
  }
  
  public String getProductId()
  {
    if (isValid()) {
      return this.info.report_info.trace_info.product_id.get();
    }
    return null;
  }
  
  public int getProductType()
  {
    if (isValid()) {
      return this.info.product_type.get();
    }
    return -2147483648;
  }
  
  public int getStyle()
  {
    if (isValid()) {
      return this.info.exp_info.qq_game_video_ad_style.get();
    }
    return 0;
  }
  
  public String getTencent_video_id()
  {
    if (isValid()) {
      return this.info.display_info.video_info.tencent_video_id.get();
    }
    return null;
  }
  
  public String getText()
  {
    if (isValid()) {
      return this.info.display_info.basic_info.txt.get();
    }
    return null;
  }
  
  public String getTraceId()
  {
    if (isValid()) {
      return this.info.report_info.trace_info.traceid.get();
    }
    return null;
  }
  
  public String getUrlForAction()
  {
    if (isValid()) {
      return this.info.report_info.landing_page_report_url.get();
    }
    return null;
  }
  
  public String getUrlForClick()
  {
    if (isValid()) {
      return this.info.report_info.click_url.get();
    }
    return null;
  }
  
  public String getUrlForEffect()
  {
    if (isValid()) {
      return this.info.report_info.effect_url.get();
    }
    return null;
  }
  
  public String getUrlForImpression()
  {
    if (isValid()) {
      return this.info.report_info.exposure_url.get();
    }
    return null;
  }
  
  public String getUrlForLandingPage()
  {
    if (isValid()) {
      return this.info.dest_info.landing_page.get();
    }
    return null;
  }
  
  public String getVia()
  {
    if (isValid()) {
      return this.info.report_info.trace_info.via.get();
    }
    return null;
  }
  
  public String getVideoUrl()
  {
    if (isValid()) {
      return this.info.display_info.video_info.video_url.get();
    }
    return null;
  }
  
  public String getVideoUrl2()
  {
    if (isValid()) {
      return this.info.display_info.video_info2.video_url.get();
    }
    return null;
  }
  
  public String getViewId()
  {
    if (isValid()) {
      return this.info.report_info.trace_info.view_id.get();
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
    return ((isAppXiJing()) && (!TextUtils.isEmpty(this.info.dest_info.canvas_json.get()))) || ((getProductType() == 1000) && (getDestType() == 4) && (!TextUtils.isEmpty(this.info.dest_info.canvas_json.get())));
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
      } while (this.info.ext.landing_page_style.get() == 1);
      if (TextUtils.isEmpty(this.info.ext_json.get())) {
        continue;
      }
      try
      {
        Object localObject = new JSONObject(this.info.ext_json.get());
        localObject = (qq_ad_get.QQAdGetRsp.AdInfo.Ext)qq_ad_get.QQAdGetRsp.AdInfo.Ext.class.cast(ynv.a(new qq_ad_get.QQAdGetRsp.AdInfo.Ext(), localObject));
        if (localObject == null) {
          continue;
        }
        int i = ((qq_ad_get.QQAdGetRsp.AdInfo.Ext)localObject).landing_page_style.get();
        if (i == 1) {}
        for (bool = true;; bool = false) {
          return bool;
        }
      }
      catch (Throwable localThrowable)
      {
        yny.b("GdtAd", "isHitCanvasVideoCeilingExp", localThrowable);
      }
    }
  }
  
  public boolean isHitJumpExperiment()
  {
    if (!isValid()) {}
    for (;;)
    {
      return false;
      if (this.info.ext.no_clkcgi_jump.get()) {
        return true;
      }
      if (!TextUtils.isEmpty(this.info.ext_json.get())) {
        try
        {
          Object localObject = new JSONObject(this.info.ext_json.get());
          localObject = (qq_ad_get.QQAdGetRsp.AdInfo.Ext)qq_ad_get.QQAdGetRsp.AdInfo.Ext.class.cast(ynv.a(new qq_ad_get.QQAdGetRsp.AdInfo.Ext(), localObject));
          if (localObject != null)
          {
            boolean bool = ((qq_ad_get.QQAdGetRsp.AdInfo.Ext)localObject).no_clkcgi_jump.get();
            return bool;
          }
        }
        catch (Throwable localThrowable)
        {
          yny.b("GdtAd", "isHitJumpExperiment", localThrowable);
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
      if (this.info.display_info.mini_program_type.get() == 11) {
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
  
  public void readExternal(ObjectInput paramObjectInput)
  {
    int i = 0;
    if (paramObjectInput == null)
    {
      yny.d("GdtAd", "readExternal error");
      return;
    }
    int j;
    try
    {
      this.actionSetId = paramObjectInput.readLong();
      j = paramObjectInput.readInt();
      if (j <= 0)
      {
        yny.d("GdtAd", "readExternal error");
        return;
      }
    }
    catch (Throwable paramObjectInput)
    {
      yny.d("GdtAd", "readExternal", paramObjectInput);
      return;
    }
    Object localObject = new ByteArrayOutputStream();
    for (;;)
    {
      byte[] arrayOfByte;
      int k;
      if (i < j)
      {
        arrayOfByte = new byte[j - i];
        k = paramObjectInput.read(arrayOfByte);
        if (k < 0) {
          yny.d("GdtAd", "readExternal error");
        }
      }
      else
      {
        ((ByteArrayOutputStream)localObject).close();
        paramObjectInput = ((ByteArrayOutputStream)localObject).toByteArray();
        if ((i == j) && (paramObjectInput.length == j)) {
          break;
        }
        yny.d("GdtAd", "readExternal error");
        return;
      }
      i += k;
      ((ByteArrayOutputStream)localObject).write(arrayOfByte, 0, k);
    }
    localObject = new qq_ad_get.QQAdGetRsp.AdInfo();
    try
    {
      ((qq_ad_get.QQAdGetRsp.AdInfo)localObject).mergeFrom(paramObjectInput);
      this.info = ((qq_ad_get.QQAdGetRsp.AdInfo)localObject);
      return;
    }
    catch (InvalidProtocolBufferMicroException paramObjectInput)
    {
      yny.d("GdtAd", "readExternal", paramObjectInput);
    }
  }
  
  public void writeExternal(ObjectOutput paramObjectOutput)
  {
    if ((paramObjectOutput == null) || (this.info == null))
    {
      yny.d("GdtAd", "writeExternal error");
      return;
    }
    byte[] arrayOfByte;
    try
    {
      paramObjectOutput.writeLong(this.actionSetId);
      arrayOfByte = this.info.toByteArray();
      if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
      {
        yny.d("GdtAd", "writeExternal error");
        return;
      }
    }
    catch (Throwable paramObjectOutput)
    {
      yny.d("GdtAd", "writeExternal", paramObjectOutput);
      return;
    }
    paramObjectOutput.writeInt(arrayOfByte.length);
    paramObjectOutput.write(arrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.gdtad.aditem.GdtAd
 * JD-Core Version:    0.7.0.1
 */