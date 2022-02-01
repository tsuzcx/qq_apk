package com.tencent.gdtad.aditem;

import abko;
import abkv;
import abrk;
import abrl;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import bcef;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.util.AdClickUtil.Result;
import com.tencent.ad.tangram.util.AdUriUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram.Req;
import com.tencent.mm.opensdk.modelbiz.WXPreloadMiniProgram.Req;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.Externalizable;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.List;
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
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ExpParam;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.Ext;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.OfflinePageInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.WeChatAppInfo;

public class GdtAd
  implements Parcelable, Ad, Externalizable
{
  public static final Parcelable.Creator<GdtAd> CREATOR = new abko();
  public static final int EXP_KEY_CELLING_STYLE = 100329;
  public static final String EXP_VALUE_CELLING_STYLE = "1";
  public static final int REPORT_STATE_FINISHED = 2;
  public static final int REPORT_STATE_INIT = -1;
  public static final int REPORT_STATE_PENDING = 1;
  public long actionSetId = -2147483648L;
  private String canvasForXiJingOffline = "";
  public qq_ad_get.QQAdGetRsp.AdInfo info;
  public int reportState = -1;
  
  public GdtAd() {}
  
  public GdtAd(Parcel paramParcel)
  {
    try
    {
      this.actionSetId = paramParcel.readLong();
      this.canvasForXiJingOffline = paramParcel.readString();
      int i = paramParcel.readInt();
      if (i <= 0)
      {
        abrl.d("GdtAd", "GdtAd(Parcel in) error");
        return;
      }
      byte[] arrayOfByte = new byte[i];
      paramParcel.readByteArray(arrayOfByte);
      paramParcel = new qq_ad_get.QQAdGetRsp.AdInfo();
      paramParcel.mergeFrom(arrayOfByte);
      this.info = paramParcel;
      return;
    }
    catch (Throwable paramParcel)
    {
      abrl.d("GdtAd", "GdtAd(Parcel in)", paramParcel);
    }
  }
  
  public GdtAd(qq_ad_get.QQAdGetRsp.AdInfo paramAdInfo)
  {
    this.info = paramAdInfo;
  }
  
  private String a(String paramString)
  {
    String str;
    if ("wxf0a80d0ac2e82aa7".equals(paramString)) {
      str = "same";
    }
    do
    {
      do
      {
        return str;
        str = paramString;
      } while (paramString == null);
      str = paramString;
    } while (paramString.length() <= 4);
    return paramString.substring(4);
  }
  
  private void a(Handler paramHandler, int paramInt)
  {
    paramHandler.post(new GdtAd.2(this, paramInt));
  }
  
  private boolean a()
  {
    if (TextUtils.isEmpty(getBusinessIdForXiJingOffline())) {}
    while ((TextUtils.isEmpty(getJSONKeyForXiJingOffline())) || (TextUtils.isEmpty(getJSONUrlForXiJingOffline())) || (TextUtils.isEmpty(getUrlForXiJingOffline()))) {
      return false;
    }
    return true;
  }
  
  private byte[] a(ObjectInput paramObjectInput, int paramInt)
  {
    if (paramInt <= 0) {
      return null;
    }
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      int i = 0;
      for (;;)
      {
        byte[] arrayOfByte;
        int j;
        if (i < paramInt)
        {
          arrayOfByte = new byte[paramInt - i];
          j = paramObjectInput.read(arrayOfByte);
          if (j < 0) {
            abrl.d("GdtAd", "readBytes error");
          }
        }
        else
        {
          localByteArrayOutputStream.close();
          paramObjectInput = localByteArrayOutputStream.toByteArray();
          if ((i != paramInt) || (paramObjectInput.length != paramInt)) {
            break;
          }
          return paramObjectInput;
        }
        localByteArrayOutputStream.write(arrayOfByte, 0, j);
        i += j;
      }
      abrl.d("GdtAd", "readBytes error");
      return null;
    }
    catch (Throwable paramObjectInput)
    {
      abrl.d("GdtAd", "readBytes", paramObjectInput);
    }
    return null;
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
        localObject = (qq_ad_get.QQAdGetRsp.AdInfo.Ext)qq_ad_get.QQAdGetRsp.AdInfo.Ext.class.cast(abrk.a(new qq_ad_get.QQAdGetRsp.AdInfo.Ext(), localObject));
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
        abrl.b("GdtAd", "canPreloadForQQMINIProgram", localThrowable);
      }
    }
  }
  
  public int describeContents()
  {
    return 0;
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
          localObject = (qq_ad_get.QQAdGetRsp.AdInfo.Ext)qq_ad_get.QQAdGetRsp.AdInfo.Ext.class.cast(abrk.a(new qq_ad_get.QQAdGetRsp.AdInfo.Ext(), localObject));
          if (localObject != null)
          {
            bool = ((qq_ad_get.QQAdGetRsp.AdInfo.Ext)localObject).disable_auto_download.get();
            return bool;
          }
        }
        catch (Throwable localThrowable)
        {
          abrl.b("GdtAd", "disableAutoDownload", localThrowable);
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
  
  public long getActionSetId()
  {
    return this.actionSetId;
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
            localObject = (qq_ad_get.QQAdGetRsp.AdInfo.Ext)qq_ad_get.QQAdGetRsp.AdInfo.Ext.class.cast(abrk.a(new qq_ad_get.QQAdGetRsp.AdInfo.Ext(), localObject));
            if (localObject != null)
            {
              localObject = ((qq_ad_get.QQAdGetRsp.AdInfo.Ext)localObject).market_deep_link.get();
              return localObject;
            }
          }
          catch (Throwable localThrowable)
          {
            abrl.b("GdtAd", "getAppMarketDeeplink", localThrowable);
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
            localObject = (qq_ad_get.QQAdGetRsp.AdInfo.Ext)qq_ad_get.QQAdGetRsp.AdInfo.Ext.class.cast(abrk.a(new qq_ad_get.QQAdGetRsp.AdInfo.Ext(), localObject));
            if (localObject != null)
            {
              localObject = ((qq_ad_get.QQAdGetRsp.AdInfo.Ext)localObject).market_package_name.get();
              return localObject;
            }
          }
          catch (Throwable localThrowable)
          {
            abrl.b("GdtAd", "getAppMarketPackageName", localThrowable);
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
    if ((isAppProductType()) || (isJDProductType())) {
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
        if (((qq_ad_get.QQAdGetRsp.AdInfo.ExpParam)localList.get(i)).key.get() == 101164) {
          return Integer.parseInt(((qq_ad_get.QQAdGetRsp.AdInfo.ExpParam)localList.get(i)).value.get());
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
        if (((qq_ad_get.QQAdGetRsp.AdInfo.ExpParam)localList.get(i)).key.get() == 101166) {
          return Integer.parseInt(((qq_ad_get.QQAdGetRsp.AdInfo.ExpParam)localList.get(i)).value.get());
        }
        i += 1;
      }
    }
  }
  
  public String getBusinessIdForXiJingOffline()
  {
    if (!isValid()) {}
    for (;;)
    {
      return null;
      if ((this.info.ext.xj_offline.offline_id.has()) && (this.info.ext.xj_offline.offline_id.get() != 0)) {
        return String.valueOf(this.info.ext.xj_offline.offline_id.get());
      }
      if (!TextUtils.isEmpty(this.info.ext_json.get())) {
        try
        {
          Object localObject = new JSONObject(this.info.ext_json.get());
          localObject = (qq_ad_get.QQAdGetRsp.AdInfo.Ext)qq_ad_get.QQAdGetRsp.AdInfo.Ext.class.cast(abrk.a(new qq_ad_get.QQAdGetRsp.AdInfo.Ext(), localObject));
          if (localObject != null)
          {
            int i = ((qq_ad_get.QQAdGetRsp.AdInfo.Ext)localObject).xj_offline.offline_id.get();
            return String.valueOf(i);
          }
        }
        catch (Throwable localThrowable)
        {
          abrl.b("GdtAd", "getJSONKeyForXiJingOffline", localThrowable);
        }
      }
    }
  }
  
  public String getCanvas()
  {
    if (isCanvas()) {
      return this.info.dest_info.canvas_json.get();
    }
    return null;
  }
  
  public String getCanvasForXiJingOffline()
  {
    if (!TextUtils.isEmpty(this.canvasForXiJingOffline)) {
      return this.canvasForXiJingOffline;
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
  
  public int getEndcardDirection()
  {
    if (isValid()) {
      return this.info.display_info.video_info.endcard_direction.get();
    }
    return 0;
  }
  
  public int getEndcardLoadTime()
  {
    if (!isValid()) {}
    while (!this.info.display_info.video_info.endcard_load_time.has()) {
      return 5;
    }
    return this.info.display_info.video_info.endcard_load_time.get();
  }
  
  public String getEndcardUrl()
  {
    if (isValid()) {
      return this.info.display_info.video_info.endcard.get();
    }
    return null;
  }
  
  public List getExpMap()
  {
    ArrayList localArrayList = new ArrayList();
    if (!isValid()) {
      return localArrayList;
    }
    if (this.info.ext.exp_map.get().size() > 0) {
      return this.info.ext.exp_map.get();
    }
    if (TextUtils.isEmpty(this.info.ext_json.get())) {
      return localArrayList;
    }
    try
    {
      Object localObject = new JSONObject(this.info.ext_json.get());
      localObject = (qq_ad_get.QQAdGetRsp.AdInfo.Ext)qq_ad_get.QQAdGetRsp.AdInfo.Ext.class.cast(abrk.a(new qq_ad_get.QQAdGetRsp.AdInfo.Ext(), localObject));
      if (localObject == null) {
        return localArrayList;
      }
      localObject = ((qq_ad_get.QQAdGetRsp.AdInfo.Ext)localObject).exp_map.get();
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      abrl.d("GdtAd", "getExpMap", localThrowable);
    }
    return localArrayList;
  }
  
  public abkv getImageData()
  {
    if (!isValid()) {
      return null;
    }
    abkv localabkv = new abkv();
    localabkv.jdField_a_of_type_JavaLangString = this.info.display_info.basic_info.img.get();
    localabkv.jdField_a_of_type_Int = this.info.display_info.basic_info.pic_width.get();
    localabkv.b = this.info.display_info.basic_info.pic_height.get();
    if (localabkv.a()) {}
    for (;;)
    {
      return localabkv;
      localabkv = null;
    }
  }
  
  public abkv getImageData(int paramInt)
  {
    if ((!isValid()) || (paramInt < 0) || (paramInt >= this.info.display_info.muti_pic_text_info.image.size())) {
      return null;
    }
    abkv localabkv = new abkv();
    localabkv.jdField_a_of_type_JavaLangString = ((String)this.info.display_info.muti_pic_text_info.image.get(paramInt));
    localabkv.jdField_a_of_type_Int = this.info.display_info.basic_info.pic_width.get();
    localabkv.b = this.info.display_info.basic_info.pic_height.get();
    return localabkv;
  }
  
  public String getJSONKeyForXiJingOffline()
  {
    if (!isValid()) {}
    for (;;)
    {
      return null;
      if (!TextUtils.isEmpty(this.info.ext.xj_offline.offline_json_key.get())) {
        return this.info.ext.xj_offline.offline_json_key.get();
      }
      if (!TextUtils.isEmpty(this.info.ext_json.get())) {
        try
        {
          Object localObject = new JSONObject(this.info.ext_json.get());
          localObject = (qq_ad_get.QQAdGetRsp.AdInfo.Ext)qq_ad_get.QQAdGetRsp.AdInfo.Ext.class.cast(abrk.a(new qq_ad_get.QQAdGetRsp.AdInfo.Ext(), localObject));
          if (localObject != null)
          {
            localObject = ((qq_ad_get.QQAdGetRsp.AdInfo.Ext)localObject).xj_offline.offline_json_key.get();
            return localObject;
          }
        }
        catch (Throwable localThrowable)
        {
          abrl.b("GdtAd", "getJSONKeyForXiJingOffline", localThrowable);
        }
      }
    }
  }
  
  public String getJSONUrlForXiJingOffline()
  {
    if (!isValid()) {}
    for (;;)
    {
      return null;
      if (!TextUtils.isEmpty(this.info.ext.xj_offline.offline_json_url.get())) {
        return this.info.ext.xj_offline.offline_json_url.get();
      }
      if (!TextUtils.isEmpty(this.info.ext_json.get())) {
        try
        {
          Object localObject = new JSONObject(this.info.ext_json.get());
          localObject = (qq_ad_get.QQAdGetRsp.AdInfo.Ext)qq_ad_get.QQAdGetRsp.AdInfo.Ext.class.cast(abrk.a(new qq_ad_get.QQAdGetRsp.AdInfo.Ext(), localObject));
          if (localObject != null)
          {
            localObject = ((qq_ad_get.QQAdGetRsp.AdInfo.Ext)localObject).xj_offline.offline_json_url.get();
            return localObject;
          }
        }
        catch (Throwable localThrowable)
        {
          abrl.b("GdtAd", "getJSONUrlForXiJingOffline", localThrowable);
        }
      }
    }
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
        if (((qq_ad_get.QQAdGetRsp.AdInfo.ExpParam)localList.get(i)).key.get() == 101168) {
          return Long.parseLong(((qq_ad_get.QQAdGetRsp.AdInfo.ExpParam)localList.get(i)).value.get());
        }
        i += 1;
      }
    }
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
  
  public int getRelationTarget()
  {
    if (!isValid()) {}
    for (;;)
    {
      return -2147483648;
      if (this.info.ext.relation_target.has()) {
        return this.info.ext.relation_target.get();
      }
      if (!TextUtils.isEmpty(this.info.ext_json.get())) {
        try
        {
          Object localObject = new JSONObject(this.info.ext_json.get());
          localObject = (qq_ad_get.QQAdGetRsp.AdInfo.Ext)qq_ad_get.QQAdGetRsp.AdInfo.Ext.class.cast(abrk.a(new qq_ad_get.QQAdGetRsp.AdInfo.Ext(), localObject));
          if (localObject != null)
          {
            int i = ((qq_ad_get.QQAdGetRsp.AdInfo.Ext)localObject).relation_target.get();
            return i;
          }
        }
        catch (Throwable localThrowable)
        {
          AdLog.e("GdtAd", "getRelationTarget", localThrowable);
        }
      }
    }
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
  
  public String getUrlForFeedBack()
  {
    if (isValid()) {
      return this.info.report_info.negative_feedback_url.get();
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
  
  public String getUrlForXiJingOffline()
  {
    if (!isValid()) {}
    for (;;)
    {
      return null;
      if (!TextUtils.isEmpty(this.info.ext.xj_offline.offline_landing_page.get())) {
        return this.info.ext.xj_offline.offline_landing_page.get();
      }
      if (!TextUtils.isEmpty(this.info.ext_json.get())) {
        try
        {
          Object localObject = new JSONObject(this.info.ext_json.get());
          localObject = (qq_ad_get.QQAdGetRsp.AdInfo.Ext)qq_ad_get.QQAdGetRsp.AdInfo.Ext.class.cast(abrk.a(new qq_ad_get.QQAdGetRsp.AdInfo.Ext(), localObject));
          if (localObject != null)
          {
            localObject = ((qq_ad_get.QQAdGetRsp.AdInfo.Ext)localObject).xj_offline.offline_landing_page.get();
            return localObject;
          }
        }
        catch (Throwable localThrowable)
        {
          abrl.b("GdtAd", "getJSONUrlForXiJingOffline", localThrowable);
        }
      }
    }
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
  
  public boolean isAppXiJingOffline()
  {
    return (isAppXiJing()) && (a());
  }
  
  public boolean isBannerWithRectangleStyle()
  {
    if (!isValid()) {}
    for (;;)
    {
      return false;
      List localList = getExpMap();
      if (localList != null)
      {
        int i = 0;
        while (i < localList.size())
        {
          if ((((qq_ad_get.QQAdGetRsp.AdInfo.ExpParam)localList.get(i)).key.get() == 94685) && (((qq_ad_get.QQAdGetRsp.AdInfo.ExpParam)localList.get(i)).value.get().equals("1"))) {
            return true;
          }
          i += 1;
        }
      }
    }
  }
  
  public boolean isCanvas()
  {
    return ((!isAppXiJingDefault()) && (!isAppXiJing())) || ((!TextUtils.isEmpty(this.info.dest_info.canvas_json.get())) || ((getProductType() == 1000) && (getDestType() == 4) && (!TextUtils.isEmpty(this.info.dest_info.canvas_json.get()))));
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
        localObject = (qq_ad_get.QQAdGetRsp.AdInfo.Ext)qq_ad_get.QQAdGetRsp.AdInfo.Ext.class.cast(abrk.a(new qq_ad_get.QQAdGetRsp.AdInfo.Ext(), localObject));
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
        abrl.b("GdtAd", "isHitCanvasVideoCeilingExp", localThrowable);
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
        if ((((qq_ad_get.QQAdGetRsp.AdInfo.ExpParam)localList.get(i)).key.get() == 95837) && (((qq_ad_get.QQAdGetRsp.AdInfo.ExpParam)localList.get(i)).value.get().equals("1"))) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  public boolean isHitPreloadCanvasJsonExp()
  {
    if (!isValid()) {}
    for (;;)
    {
      return false;
      List localList = getExpMap();
      int i = 0;
      while (i < localList.size())
      {
        if ((((qq_ad_get.QQAdGetRsp.AdInfo.ExpParam)localList.get(i)).key.get() == 101766) && (((qq_ad_get.QQAdGetRsp.AdInfo.ExpParam)localList.get(i)).value.get().equals("1"))) {
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
        if ((((qq_ad_get.QQAdGetRsp.AdInfo.ExpParam)localList.get(i)).key.get() == 94735) && (((qq_ad_get.QQAdGetRsp.AdInfo.ExpParam)localList.get(i)).value.get().equals("1"))) {
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
        if ((((qq_ad_get.QQAdGetRsp.AdInfo.ExpParam)localList.get(i)).key.get() == 101056) && (((qq_ad_get.QQAdGetRsp.AdInfo.ExpParam)localList.get(i)).value.get().equals("1"))) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  public boolean isInterstitial()
  {
    boolean bool = true;
    if (!isValid()) {}
    for (;;)
    {
      bool = false;
      do
      {
        return bool;
      } while (this.info.ext.render_pos_type.get() == 2);
      if (TextUtils.isEmpty(this.info.ext_json.get())) {
        continue;
      }
      try
      {
        Object localObject = new JSONObject(this.info.ext_json.get());
        localObject = (qq_ad_get.QQAdGetRsp.AdInfo.Ext)qq_ad_get.QQAdGetRsp.AdInfo.Ext.class.cast(abrk.a(new qq_ad_get.QQAdGetRsp.AdInfo.Ext(), localObject));
        if (localObject == null) {
          continue;
        }
        int i = ((qq_ad_get.QQAdGetRsp.AdInfo.Ext)localObject).render_pos_type.get();
        if (i == 2) {}
        for (bool = true;; bool = false) {
          return bool;
        }
      }
      catch (Throwable localThrowable)
      {
        abrl.b("GdtAd", "isInterstitial", localThrowable);
      }
    }
  }
  
  public boolean isJDProductType()
  {
    return getProductType() == 25;
  }
  
  public boolean isMvCellingStyle()
  {
    if (!isValid()) {}
    for (;;)
    {
      return false;
      List localList = getExpMap();
      if (localList != null)
      {
        int i = 0;
        while (i < localList.size())
        {
          if ((((qq_ad_get.QQAdGetRsp.AdInfo.ExpParam)localList.get(i)).key.get() == 100329) && (((qq_ad_get.QQAdGetRsp.AdInfo.ExpParam)localList.get(i)).value.get().equals("1"))) {
            return true;
          }
          i += 1;
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
  
  public boolean isWeChatMiniApp()
  {
    boolean bool2 = isValid();
    boolean bool1 = bool2;
    if (bool2) {
      if ((this.info.product_type.get() != 46) && ((this.info.display_info == null) || (this.info.display_info.mini_program_type.get() != 3))) {
        break label61;
      }
    }
    label61:
    for (bool1 = true;; bool1 = false)
    {
      if (bool1) {}
      return bool1;
    }
  }
  
  public boolean isWebXiJing()
  {
    return (getProductType() == 1000) && (getDestType() == 4);
  }
  
  public boolean isWebXiJingOffline()
  {
    return (isWebXiJing()) && (a());
  }
  
  public boolean isXiJinDestType()
  {
    int i = getDestType();
    return (i == 1) || (i == 10);
  }
  
  public AdClickUtil.Result jumpToWechatMiniApp(Handler paramHandler)
  {
    localObject2 = "wxf0a80d0ac2e82aa7";
    localObject1 = localObject2;
    for (;;)
    {
      try
      {
        if (this.info.wechat_app_info.app_id.has())
        {
          localObject1 = localObject2;
          if (this.info.wechat_app_info.app_id.get().length() > 0) {
            localObject1 = this.info.wechat_app_info.app_id.get();
          }
        }
        localObject2 = WXAPIFactory.createWXAPI(BaseApplicationImpl.sApplication, (String)localObject1);
        if (((IWXAPI)localObject2).isWXAppInstalled()) {
          continue;
        }
        a(paramHandler, 2131692664);
        paramHandler = null;
      }
      catch (Exception paramHandler)
      {
        try
        {
          JSONObject localJSONObject1 = new JSONObject();
          localJSONObject1.put("pathType", 2);
          JSONObject localJSONObject2 = new JSONObject();
          localJSONObject2.put("ad_trace_data", this.info.wechat_app_info.ad_trace_data.get());
          localJSONObject2.put("token", this.info.wechat_app_info.app_token.get());
          localJSONObject1.put("invokeData", localJSONObject2);
          paramHandler.extData = localJSONObject1.toString();
          QLog.i("GdtAd", 1, "navigateToMiniProgram openMiniGame, make extData json success: name = " + paramHandler.userName + ",path=" + paramHandler.path + ",extData=" + paramHandler.extData + ",appId=" + a((String)localObject1));
          paramHandler.miniprogramType = 0;
          ((IWXAPI)localObject2).sendReq(paramHandler);
          paramHandler = new AdClickUtil.Result(0, 9);
          continue;
          paramHandler = paramHandler;
          paramHandler = new AdClickUtil.Result(4, 9);
        }
        catch (Exception localException)
        {
          QLog.e("GdtAd", 1, "navigateToMiniProgram  openMiniGame, make extData json failed!", localException);
          continue;
        }
      }
      bcef.b(null, "dc00898", "", "", "0X800AA79", "0X800AA79", 0, 0, "", "", String.valueOf(this.info.wechat_app_info.pos_id.get()), "");
      return paramHandler;
      if (((IWXAPI)localObject2).getWXAppSupportAPI() >= 621086464) {
        continue;
      }
      a(paramHandler, 2131692665);
      paramHandler = null;
    }
    paramHandler = new WXLaunchMiniProgram.Req();
    paramHandler.userName = this.info.wechat_app_info.app_username.get();
    paramHandler.path = this.info.wechat_app_info.app_path.get();
  }
  
  public void preloadMiniApp()
  {
    WXPreloadMiniProgram.Req localReq;
    if (isWeChatMiniApp())
    {
      localReq = new WXPreloadMiniProgram.Req();
      localReq.userName = this.info.wechat_app_info.app_username.get();
      localReq.path = this.info.wechat_app_info.app_path.get();
    }
    try
    {
      localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("pathType", 2);
      localObject3 = new JSONObject();
      ((JSONObject)localObject3).put("ad_trace_data", this.info.wechat_app_info.ad_trace_data.get());
      ((JSONObject)localObject3).put("token", this.info.wechat_app_info.app_token.get());
      ((JSONObject)localObject1).put("invokeData", localObject3);
      localReq.extData = ((JSONObject)localObject1).toString();
      AdLog.d("navigateToMiniProgram", "openMiniGame, make extData json success: " + localReq.extData);
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        try
        {
          ContentResolver localContentResolver = BaseApplicationImpl.sApplication.getContentResolver();
          Object localObject3 = Uri.parse("content://com.tencent.mm.sdk.comm.provider/preloadWXMiniprogram");
          if (this.info.wechat_app_info.app_id.has())
          {
            localObject1 = this.info.wechat_app_info.app_id.get();
            localObject1 = localContentResolver.query((Uri)localObject3, null, null, new String[] { localObject1, localReq.userName, localReq.path, localReq.miniprogramType + "", localReq.extData }, null);
            if (localObject1 == null) {}
          }
        }
        catch (Throwable localThrowable)
        {
          Object localObject1;
          String str;
          QLog.e("GdtAd", 1, "preloadMiniApp resolver.query", localThrowable);
          if (0 == 0) {
            continue;
          }
          try
          {
            throw new NullPointerException();
          }
          catch (Exception localException3)
          {
            QLog.e("GdtAd", 1, "preloadMiniApp cursor.close", localException3);
            return;
          }
        }
        finally
        {
          if (0 == 0) {
            break label361;
          }
        }
        try
        {
          ((Cursor)localObject1).close();
          return;
        }
        catch (Exception localException2)
        {
          QLog.e("GdtAd", 1, "preloadMiniApp cursor.close", localException2);
          return;
        }
        localException1 = localException1;
        AdLog.e("navigateToMiniProgram", "openMiniGame, make extData json failed!");
        continue;
        str = "wxf0a80d0ac2e82aa7";
      }
    }
    try
    {
      throw new NullPointerException();
      label361:
      throw localObject2;
    }
    catch (Exception localException4)
    {
      for (;;)
      {
        QLog.e("GdtAd", 1, "preloadMiniApp cursor.close", localException4);
      }
    }
  }
  
  public void readExternal(ObjectInput paramObjectInput)
  {
    if (paramObjectInput == null)
    {
      abrl.d("GdtAd", "readExternal error");
      return;
    }
    for (;;)
    {
      int i;
      try
      {
        this.actionSetId = paramObjectInput.readLong();
        i = paramObjectInput.readInt();
        if (i <= 0)
        {
          i = paramObjectInput.readInt();
          if (i <= 0) {
            break;
          }
          paramObjectInput = a(paramObjectInput, i);
          if ((paramObjectInput == null) || (paramObjectInput.length <= 0)) {
            break;
          }
          this.canvasForXiJingOffline = new String(paramObjectInput, "UTF-8");
          return;
        }
      }
      catch (Throwable paramObjectInput)
      {
        abrl.d("GdtAd", "readExternal", paramObjectInput);
        return;
      }
      byte[] arrayOfByte = a(paramObjectInput, i);
      if ((arrayOfByte != null) && (arrayOfByte.length > 0))
      {
        qq_ad_get.QQAdGetRsp.AdInfo localAdInfo = new qq_ad_get.QQAdGetRsp.AdInfo();
        localAdInfo.mergeFrom(arrayOfByte);
        this.info = localAdInfo;
      }
    }
  }
  
  public void setActionSetId(long paramLong)
  {
    this.actionSetId = paramLong;
  }
  
  public void setCanvasForXiJingOffline(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      this.canvasForXiJingOffline = paramString;
      return;
      paramString = "";
    }
  }
  
  public String toString()
  {
    if (!isValid()) {}
    Object localObject;
    do
    {
      return null;
      localObject = abrk.a(this.info);
    } while ((localObject == null) || (JSONObject.NULL.equals(localObject)));
    return localObject.toString();
  }
  
  public boolean useExposureChecker()
  {
    if (!isValid()) {}
    for (;;)
    {
      return false;
      List localList = getExpMap();
      int i = 0;
      while (i < localList.size())
      {
        if ((((qq_ad_get.QQAdGetRsp.AdInfo.ExpParam)localList.get(i)).key.get() == 95807) && (((qq_ad_get.QQAdGetRsp.AdInfo.ExpParam)localList.get(i)).value.get().equals("1"))) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  public void writeExternal(ObjectOutput paramObjectOutput)
  {
    Object localObject2 = null;
    if ((paramObjectOutput == null) || (this.info == null))
    {
      abrl.d("GdtAd", "writeExternal error");
      return;
    }
    for (;;)
    {
      try
      {
        paramObjectOutput.writeLong(this.actionSetId);
        if (this.info != null)
        {
          localObject1 = this.info.toByteArray();
          if ((localObject1 == null) || (localObject1.length <= 0)) {
            break label135;
          }
          paramObjectOutput.writeInt(localObject1.length);
          paramObjectOutput.write((byte[])localObject1);
          localObject1 = localObject2;
          if (!TextUtils.isEmpty(this.canvasForXiJingOffline)) {
            localObject1 = this.canvasForXiJingOffline.getBytes("UTF-8");
          }
          if ((localObject1 == null) || (localObject1.length <= 0)) {
            break;
          }
          paramObjectOutput.writeInt(localObject1.length);
          paramObjectOutput.write((byte[])localObject1);
          return;
        }
      }
      catch (Throwable paramObjectOutput)
      {
        abrl.d("GdtAd", "writeExternal", paramObjectOutput);
        return;
      }
      Object localObject1 = null;
      continue;
      label135:
      paramObjectOutput.writeInt(0);
    }
    paramObjectOutput.writeInt(0);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if ((paramParcel == null) || (this.info == null))
    {
      abrl.d("GdtAd", "writeToParcel error");
      return;
    }
    byte[] arrayOfByte;
    for (;;)
    {
      try
      {
        paramParcel.writeLong(this.actionSetId);
        paramParcel.writeString(this.canvasForXiJingOffline);
        arrayOfByte = this.info.toByteArray();
        if (arrayOfByte != null)
        {
          paramInt = arrayOfByte.length;
          paramParcel.writeInt(paramInt);
          if (paramInt > 0) {
            break;
          }
          abrl.d("GdtAd", "writeToParcel error");
          return;
        }
      }
      catch (Throwable paramParcel)
      {
        abrl.d("GdtAd", "writeToParcel", paramParcel);
        return;
      }
      paramInt = 0;
    }
    paramParcel.writeByteArray(arrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.gdtad.aditem.GdtAd
 * JD-Core Version:    0.7.0.1
 */