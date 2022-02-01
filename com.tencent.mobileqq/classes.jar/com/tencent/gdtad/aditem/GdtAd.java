package com.tencent.gdtad.aditem;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.util.AdUriUtil;
import com.tencent.gdtad.json.GdtJsonPbUtil;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
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
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.OfflinePageInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.NegativeFeedbackItem;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.RewardInfo;

public class GdtAd
  implements Parcelable, Ad, Externalizable
{
  public static final Parcelable.Creator<GdtAd> CREATOR = new GdtAd.1();
  public static final int EXP_KEY_EXPERIMENT = 100329;
  public static final int EXP_KEY_PROCESS_IN_TOOL = 107054;
  public static final String EXP_VALUE_CIRCLE_BUTTON_STYLE = "2";
  public static final String EXP_VALUE_PROCESS_IN_TOOL = "1";
  public static final int REPORT_STATE_FINISHED = 2;
  public static final int REPORT_STATE_INIT = -1;
  public static final int REPORT_STATE_PENDING = 1;
  public long actionSetId = -2147483648L;
  private String canvasForXiJingOffline = "";
  public qq_ad_get.QQAdGetRsp.AdInfo info;
  public int reportState = -1;
  
  public GdtAd() {}
  
  protected GdtAd(Parcel paramParcel)
  {
    try
    {
      this.actionSetId = paramParcel.readLong();
      this.canvasForXiJingOffline = paramParcel.readString();
      int i = paramParcel.readInt();
      if (i <= 0)
      {
        GdtLog.d("GdtAd", "GdtAd(Parcel in) error");
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
      GdtLog.d("GdtAd", "GdtAd(Parcel in)", paramParcel);
    }
  }
  
  public GdtAd(qq_ad_get.QQAdGetRsp.AdInfo paramAdInfo)
  {
    this.info = paramAdInfo;
  }
  
  private boolean a()
  {
    return (!TextUtils.isEmpty(getBusinessIdForXiJingOffline())) && (!TextUtils.isEmpty(getJSONKeyForXiJingOffline())) && (!TextUtils.isEmpty(getJSONUrlForXiJingOffline())) && (!TextUtils.isEmpty(getUrlForXiJingOffline()));
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
      while (i < paramInt)
      {
        byte[] arrayOfByte = new byte[paramInt - i];
        int j = paramObjectInput.read(arrayOfByte);
        if (j < 0)
        {
          GdtLog.d("GdtAd", "readBytes error");
          break;
        }
        i += j;
        localByteArrayOutputStream.write(arrayOfByte, 0, j);
      }
      localByteArrayOutputStream.close();
      paramObjectInput = localByteArrayOutputStream.toByteArray();
      if ((i == paramInt) && (paramObjectInput.length == paramInt)) {
        return paramObjectInput;
      }
      GdtLog.d("GdtAd", "readBytes error");
      return null;
    }
    catch (Throwable paramObjectInput)
    {
      GdtLog.d("GdtAd", "readBytes", paramObjectInput);
    }
    return null;
  }
  
  public boolean canLaunchAppAfterInstalled()
  {
    if (!isValid()) {
      return false;
    }
    List localList = getExpMap();
    int i = 0;
    while (i < localList.size())
    {
      if ((((qq_ad_get.QQAdGetRsp.AdInfo.ExpParam)localList.get(i)).key.get() == 101056) && (((qq_ad_get.QQAdGetRsp.AdInfo.ExpParam)localList.get(i)).value.get().equals("1"))) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public boolean canPreloadForQQMINIProgram()
  {
    boolean bool2 = isValid();
    boolean bool1 = false;
    if (!bool2) {
      return false;
    }
    if (!isQQMINIProgram()) {
      return false;
    }
    if (this.info.ext.mini_program_preload.get() == 1) {
      return true;
    }
    if (TextUtils.isEmpty(this.info.ext_json.get())) {
      return false;
    }
    try
    {
      Object localObject = new JSONObject(this.info.ext_json.get());
      localObject = (tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.Ext)tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.Ext.class.cast(GdtJsonPbUtil.a(new tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.Ext(), localObject));
      if (localObject == null) {
        return false;
      }
      int i = ((tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.Ext)localObject).mini_program_preload.get();
      if (i == 1) {
        bool1 = true;
      }
      return bool1;
    }
    catch (Throwable localThrowable)
    {
      GdtLog.b("GdtAd", "canPreloadForQQMINIProgram", localThrowable);
    }
    return false;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean disableAutoDownload()
  {
    if ((isValid()) && (isAppProductType()))
    {
      if (this.info.ext.disable_auto_download.get() == true) {
        return true;
      }
      if (!TextUtils.isEmpty(this.info.ext_json.get())) {
        try
        {
          Object localObject = new JSONObject(this.info.ext_json.get());
          localObject = (tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.Ext)tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.Ext.class.cast(GdtJsonPbUtil.a(new tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.Ext(), localObject));
          if (localObject != null)
          {
            boolean bool = ((tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.Ext)localObject).disable_auto_download.get();
            return bool;
          }
        }
        catch (Throwable localThrowable)
        {
          GdtLog.b("GdtAd", "disableAutoDownload", localThrowable);
        }
      }
    }
    return false;
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
  
  public int getActionTypeForFeedbackItem(int paramInt)
  {
    if (isValid()) {
      return ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.NegativeFeedbackItem)this.info.report_info.neg_fb_items.get(paramInt)).action_type.get();
    }
    return -1;
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
    if ((isValid()) && (isAppProductType()))
    {
      if (!TextUtils.isEmpty(this.info.ext.market_deep_link.get())) {
        return this.info.ext.market_deep_link.get();
      }
      if (!TextUtils.isEmpty(this.info.ext_json.get())) {
        try
        {
          Object localObject = new JSONObject(this.info.ext_json.get());
          localObject = (tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.Ext)tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.Ext.class.cast(GdtJsonPbUtil.a(new tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.Ext(), localObject));
          if (localObject != null)
          {
            localObject = ((tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.Ext)localObject).market_deep_link.get();
            return localObject;
          }
        }
        catch (Throwable localThrowable)
        {
          GdtLog.b("GdtAd", "getAppMarketDeeplink", localThrowable);
        }
      }
    }
    return null;
  }
  
  public String getAppMarketPackageName()
  {
    if ((isValid()) && (isAppProductType()))
    {
      if (!TextUtils.isEmpty(this.info.ext.market_package_name.get())) {
        return this.info.ext.market_package_name.get();
      }
      if (!TextUtils.isEmpty(this.info.ext_json.get())) {
        try
        {
          Object localObject = new JSONObject(this.info.ext_json.get());
          localObject = (tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.Ext)tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.Ext.class.cast(GdtJsonPbUtil.a(new tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.Ext(), localObject));
          if (localObject != null)
          {
            localObject = ((tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.Ext)localObject).market_package_name.get();
            return localObject;
          }
        }
        catch (Throwable localThrowable)
        {
          GdtLog.b("GdtAd", "getAppMarketPackageName", localThrowable);
        }
      }
    }
    return null;
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
    if ((!isAppProductType()) && (!isJDProductType())) {
      return null;
    }
    return this.info.app_info.app_package_name.get();
  }
  
  public long getAppPackageSize()
  {
    Long localLong;
    if (isAppProductType()) {
      localLong = Long.valueOf(this.info.app_info.app_package_size.get());
    } else {
      localLong = null;
    }
    return localLong.longValue();
  }
  
  public String getAppPackageUrl()
  {
    if (isAppProductType()) {
      return this.info.app_info.pkg_url.get();
    }
    return null;
  }
  
  public String getAppRightInfoUrl()
  {
    if (isValid()) {
      return this.info.app_info.app_standard_info_url.get();
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
    if (isValid())
    {
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
        if (((qq_ad_get.QQAdGetRsp.AdInfo.ExpParam)localList.get(i)).key.get() == 101166) {
          return Integer.parseInt(((qq_ad_get.QQAdGetRsp.AdInfo.ExpParam)localList.get(i)).value.get());
        }
        i += 1;
      }
    }
    return -2147483648;
  }
  
  public String getBasic_img()
  {
    if (isValid()) {
      return this.info.display_info.basic_info.img.get();
    }
    return "";
  }
  
  public int getBottomCardLoadTime()
  {
    return 2;
  }
  
  public String getBottomCardUrl()
  {
    if (isValid()) {
      return this.info.display_info.video_info.bottom_card_url.get();
    }
    return null;
  }
  
  public String getBusinessIdForXiJingOffline()
  {
    if (isValid())
    {
      if ((this.info.ext.xj_offline.offline_id.has()) && (this.info.ext.xj_offline.offline_id.get() != 0)) {
        return String.valueOf(this.info.ext.xj_offline.offline_id.get());
      }
      if (!TextUtils.isEmpty(this.info.ext_json.get())) {
        try
        {
          Object localObject = new JSONObject(this.info.ext_json.get());
          localObject = (tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.Ext)tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.Ext.class.cast(GdtJsonPbUtil.a(new tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.Ext(), localObject));
          if (localObject != null)
          {
            int i = ((tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.Ext)localObject).xj_offline.offline_id.get();
            return String.valueOf(i);
          }
        }
        catch (Throwable localThrowable)
        {
          GdtLog.b("GdtAd", "getJSONKeyForXiJingOffline", localThrowable);
        }
      }
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
    if (!isValid()) {
      return 5;
    }
    if (this.info.display_info.video_info.endcard_load_time.has()) {
      return this.info.display_info.video_info.endcard_load_time.get();
    }
    return 5;
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
      localObject = (tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.Ext)tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.Ext.class.cast(GdtJsonPbUtil.a(new tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.Ext(), localObject));
      if (localObject == null) {
        return localArrayList;
      }
      localObject = ((tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.Ext)localObject).exp_map.get();
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      GdtLog.d("GdtAd", "getExpMap", localThrowable);
    }
    return localArrayList;
  }
  
  public int getFeedbackItemNum()
  {
    if (isValid()) {
      return this.info.report_info.neg_fb_items.size();
    }
    return -1;
  }
  
  public String getIconUrlForFeedbackItem(int paramInt)
  {
    if (isValid()) {
      return ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.NegativeFeedbackItem)this.info.report_info.neg_fb_items.get(paramInt)).icon_url.get();
    }
    return null;
  }
  
  public GdtImageData getImageData()
  {
    if (!isValid()) {
      return null;
    }
    GdtImageData localGdtImageData = new GdtImageData();
    localGdtImageData.jdField_a_of_type_JavaLangString = this.info.display_info.basic_info.img.get();
    localGdtImageData.jdField_a_of_type_Int = this.info.display_info.basic_info.pic_width.get();
    localGdtImageData.b = this.info.display_info.basic_info.pic_height.get();
    if (localGdtImageData.a()) {
      return localGdtImageData;
    }
    return null;
  }
  
  public GdtImageData getImageData(int paramInt)
  {
    if ((isValid()) && (paramInt >= 0) && (paramInt < this.info.display_info.muti_pic_text_info.image.size()))
    {
      GdtImageData localGdtImageData = new GdtImageData();
      localGdtImageData.jdField_a_of_type_JavaLangString = ((String)this.info.display_info.muti_pic_text_info.image.get(paramInt));
      localGdtImageData.jdField_a_of_type_Int = this.info.display_info.basic_info.pic_width.get();
      localGdtImageData.b = this.info.display_info.basic_info.pic_height.get();
      return localGdtImageData;
    }
    return null;
  }
  
  public int getImageHeight()
  {
    if (getImageData() == null) {
      return 0;
    }
    return getImageData().b;
  }
  
  public int getImageWidth()
  {
    if (getImageData() == null) {
      return 0;
    }
    return getImageData().jdField_a_of_type_Int;
  }
  
  public String getJSONKeyForXiJingOffline()
  {
    if (isValid())
    {
      if (!TextUtils.isEmpty(this.info.ext.xj_offline.offline_json_key.get())) {
        return this.info.ext.xj_offline.offline_json_key.get();
      }
      if (!TextUtils.isEmpty(this.info.ext_json.get())) {
        try
        {
          Object localObject = new JSONObject(this.info.ext_json.get());
          localObject = (tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.Ext)tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.Ext.class.cast(GdtJsonPbUtil.a(new tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.Ext(), localObject));
          if (localObject != null)
          {
            localObject = ((tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.Ext)localObject).xj_offline.offline_json_key.get();
            return localObject;
          }
        }
        catch (Throwable localThrowable)
        {
          GdtLog.b("GdtAd", "getJSONKeyForXiJingOffline", localThrowable);
        }
      }
    }
    return null;
  }
  
  public String getJSONUrlForXiJingOffline()
  {
    if (isValid())
    {
      if (!TextUtils.isEmpty(this.info.ext.xj_offline.offline_json_url.get())) {
        return this.info.ext.xj_offline.offline_json_url.get();
      }
      if (!TextUtils.isEmpty(this.info.ext_json.get())) {
        try
        {
          Object localObject = new JSONObject(this.info.ext_json.get());
          localObject = (tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.Ext)tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.Ext.class.cast(GdtJsonPbUtil.a(new tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.Ext(), localObject));
          if (localObject != null)
          {
            localObject = ((tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.Ext)localObject).xj_offline.offline_json_url.get();
            return localObject;
          }
        }
        catch (Throwable localThrowable)
        {
          GdtLog.b("GdtAd", "getJSONUrlForXiJingOffline", localThrowable);
        }
      }
    }
    return null;
  }
  
  public String getJumpUrlForFeedbackItem(int paramInt)
  {
    if (isValid()) {
      return ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.NegativeFeedbackItem)this.info.report_info.neg_fb_items.get(paramInt)).jump_url.get();
    }
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
        if (((qq_ad_get.QQAdGetRsp.AdInfo.ExpParam)localList.get(i)).key.get() == 101168) {
          return Long.parseLong(((qq_ad_get.QQAdGetRsp.AdInfo.ExpParam)localList.get(i)).value.get());
        }
        i += 1;
      }
    }
    return -2147483648L;
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
  
  public String getOriginalExposureUrl()
  {
    if (isValid()) {
      return this.info.report_info.original_exposure_url.get();
    }
    return null;
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
    if (localObject != null) {
      localObject = AdUriUtil.getQueryParameter((Uri)localObject, "pid");
    } else {
      localObject = null;
    }
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      return localObject;
    }
    return null;
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
    if (isValid())
    {
      if (this.info.ext.relation_target.has()) {
        return this.info.ext.relation_target.get();
      }
      if (!TextUtils.isEmpty(this.info.ext_json.get())) {
        try
        {
          Object localObject = new JSONObject(this.info.ext_json.get());
          localObject = (tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.Ext)tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.Ext.class.cast(GdtJsonPbUtil.a(new tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.Ext(), localObject));
          if (localObject != null)
          {
            int i = ((tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.Ext)localObject).relation_target.get();
            return i;
          }
        }
        catch (Throwable localThrowable)
        {
          AdLog.e("GdtAd", "getRelationTarget", localThrowable);
        }
      }
    }
    return -2147483648;
  }
  
  public int getReportTypeForFeedbackItem(int paramInt)
  {
    if (isValid()) {
      return ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.NegativeFeedbackItem)this.info.report_info.neg_fb_items.get(paramInt)).report_type.get();
    }
    return -1;
  }
  
  public int getRewardTime()
  {
    if (isValid()) {
      return this.info.reward_info.reward_time.get();
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
  
  public String getTextForFeedbackItem(int paramInt)
  {
    if (isValid()) {
      return ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.NegativeFeedbackItem)this.info.report_info.neg_fb_items.get(paramInt)).text.get();
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
    if (isValid())
    {
      if (!TextUtils.isEmpty(this.info.ext.xj_offline.offline_landing_page.get())) {
        return this.info.ext.xj_offline.offline_landing_page.get();
      }
      if (!TextUtils.isEmpty(this.info.ext_json.get())) {
        try
        {
          Object localObject = new JSONObject(this.info.ext_json.get());
          localObject = (tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.Ext)tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.Ext.class.cast(GdtJsonPbUtil.a(new tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.Ext(), localObject));
          if (localObject != null)
          {
            localObject = ((tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.Ext)localObject).xj_offline.offline_landing_page.get();
            return localObject;
          }
        }
        catch (Throwable localThrowable)
        {
          GdtLog.b("GdtAd", "getJSONUrlForXiJingOffline", localThrowable);
        }
      }
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
  
  public boolean isAppPreOrder()
  {
    if ((isValid()) && (isAppXiJingFengling()))
    {
      if (this.info.ext.is_app_preorder.has()) {
        return this.info.ext.is_app_preorder.get();
      }
      if (!TextUtils.isEmpty(this.info.ext_json.get())) {
        try
        {
          com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGetRsp.AdInfo.Ext localExt = (com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGetRsp.AdInfo.Ext)com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGetRsp.AdInfo.Ext.class.cast(new JSONObject(this.info.ext_json.get()));
          if (localExt != null)
          {
            boolean bool = localExt.is_app_preorder;
            return bool;
          }
        }
        catch (Throwable localThrowable)
        {
          AdLog.e("GdtAd", "isAppPreOder", localThrowable);
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
    return (isAppXiJing()) && (a());
  }
  
  public boolean isBannerWithRectangleNewStyle()
  {
    if (!isValid()) {
      return false;
    }
    List localList = getExpMap();
    int i = 0;
    while (i < localList.size())
    {
      if ((((qq_ad_get.QQAdGetRsp.AdInfo.ExpParam)localList.get(i)).key.get() == 94685) && (((qq_ad_get.QQAdGetRsp.AdInfo.ExpParam)localList.get(i)).value.get().equals("2"))) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public boolean isBannerWithRectangleStyle()
  {
    if (!isValid()) {
      return false;
    }
    List localList = getExpMap();
    int i = 0;
    while (i < localList.size())
    {
      if ((((qq_ad_get.QQAdGetRsp.AdInfo.ExpParam)localList.get(i)).key.get() == 94685) && (((qq_ad_get.QQAdGetRsp.AdInfo.ExpParam)localList.get(i)).value.get().equals("1"))) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public boolean isCanvas()
  {
    return ((isAppXiJingDefault()) || (isAppXiJing())) && ((!TextUtils.isEmpty(this.info.dest_info.canvas_json.get())) || ((getProductType() == 1000) && (getDestType() == 4) && (!TextUtils.isEmpty(this.info.dest_info.canvas_json.get()))));
  }
  
  public boolean isHitDownloadLayer()
  {
    if (!isValid()) {
      return false;
    }
    List localList = getExpMap();
    int i = 0;
    while (i < localList.size())
    {
      if ((((qq_ad_get.QQAdGetRsp.AdInfo.ExpParam)localList.get(i)).key.get() == 108152) && (((qq_ad_get.QQAdGetRsp.AdInfo.ExpParam)localList.get(i)).value.get().equals("1"))) {
        return true;
      }
      i += 1;
    }
    return false;
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
      if ((((qq_ad_get.QQAdGetRsp.AdInfo.ExpParam)localList.get(i)).key.get() == 95837) && (((qq_ad_get.QQAdGetRsp.AdInfo.ExpParam)localList.get(i)).value.get().equals("1"))) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public boolean isInterstitial()
  {
    boolean bool2 = isValid();
    boolean bool1 = false;
    if (!bool2) {
      return false;
    }
    if (this.info.ext.render_pos_type.get() == 2) {
      return true;
    }
    if (TextUtils.isEmpty(this.info.ext_json.get())) {
      return false;
    }
    try
    {
      Object localObject = new JSONObject(this.info.ext_json.get());
      localObject = (tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.Ext)tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.Ext.class.cast(GdtJsonPbUtil.a(new tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.Ext(), localObject));
      if (localObject == null) {
        return false;
      }
      int i = ((tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.Ext)localObject).render_pos_type.get();
      if (i == 2) {
        bool1 = true;
      }
      return bool1;
    }
    catch (Throwable localThrowable)
    {
      GdtLog.b("GdtAd", "isInterstitial", localThrowable);
    }
    return false;
  }
  
  public boolean isJDProductType()
  {
    return getProductType() == 25;
  }
  
  public boolean isMvCircleButtonStyle()
  {
    if (!isValid()) {
      return false;
    }
    List localList = getExpMap();
    if (localList == null) {
      return false;
    }
    int i = 0;
    while (i < localList.size())
    {
      if ((((qq_ad_get.QQAdGetRsp.AdInfo.ExpParam)localList.get(i)).key.get() == 100329) && (((qq_ad_get.QQAdGetRsp.AdInfo.ExpParam)localList.get(i)).value.get().equals("2"))) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public boolean isProcessInTool()
  {
    if (!isValid()) {
      return false;
    }
    List localList = getExpMap();
    if (localList == null) {
      return false;
    }
    int i = 0;
    while (i < localList.size())
    {
      if ((((qq_ad_get.QQAdGetRsp.AdInfo.ExpParam)localList.get(i)).key.get() == 107054) && (((qq_ad_get.QQAdGetRsp.AdInfo.ExpParam)localList.get(i)).value.get().equals("1"))) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public boolean isQQMINIProgram()
  {
    boolean bool3 = isValid();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
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
  
  public boolean isVideoOnTopDisabled()
  {
    if (isValid())
    {
      if (this.info.ext.disable_video_on_top.has()) {
        return this.info.ext.disable_video_on_top.get();
      }
      if (!TextUtils.isEmpty(this.info.ext_json.get())) {
        try
        {
          Object localObject = new JSONObject(this.info.ext_json.get());
          localObject = (tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.Ext)tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.Ext.class.cast(GdtJsonPbUtil.a(new tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.Ext(), localObject));
          if (localObject != null)
          {
            boolean bool = ((tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.Ext)localObject).disable_video_on_top.get();
            return bool;
          }
        }
        catch (Throwable localThrowable)
        {
          AdLog.e("GdtAd", "isVideoOnTopDisabled", localThrowable);
        }
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
  
  public boolean isWeChatMiniApp()
  {
    boolean bool2 = isValid();
    boolean bool1 = bool2;
    if (bool2)
    {
      if ((this.info.product_type.get() != 46) && ((this.info.display_info == null) || (this.info.display_info.mini_program_type.get() != 3))) {
        return false;
      }
      bool1 = true;
    }
    return bool1;
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
    boolean bool = true;
    if (i != 1)
    {
      if (i == 10) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  public void readExternal(ObjectInput paramObjectInput)
  {
    if (paramObjectInput == null)
    {
      GdtLog.d("GdtAd", "readExternal error");
      return;
    }
    try
    {
      this.actionSetId = paramObjectInput.readLong();
      int i = paramObjectInput.readInt();
      if (i > 0)
      {
        byte[] arrayOfByte = a(paramObjectInput, i);
        if ((arrayOfByte != null) && (arrayOfByte.length > 0))
        {
          qq_ad_get.QQAdGetRsp.AdInfo localAdInfo = new qq_ad_get.QQAdGetRsp.AdInfo();
          localAdInfo.mergeFrom(arrayOfByte);
          this.info = localAdInfo;
        }
      }
      i = paramObjectInput.readInt();
      if (i <= 0) {
        return;
      }
      paramObjectInput = a(paramObjectInput, i);
      if (paramObjectInput != null)
      {
        if (paramObjectInput.length <= 0) {
          return;
        }
        this.canvasForXiJingOffline = new String(paramObjectInput, "UTF-8");
        return;
      }
    }
    catch (Throwable paramObjectInput)
    {
      GdtLog.d("GdtAd", "readExternal", paramObjectInput);
    }
  }
  
  public void setActionSetId(long paramLong)
  {
    this.actionSetId = paramLong;
  }
  
  public void setCanvasForXiJingOffline(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      paramString = "";
    }
    this.canvasForXiJingOffline = paramString;
  }
  
  public String toString()
  {
    if (isValid())
    {
      Object localObject = GdtJsonPbUtil.a(this.info);
      if ((localObject != null) && (!JSONObject.NULL.equals(localObject))) {
        return localObject.toString();
      }
    }
    return null;
  }
  
  public void writeExternal(ObjectOutput paramObjectOutput)
  {
    if ((paramObjectOutput != null) && (this.info != null)) {}
    for (;;)
    {
      try
      {
        paramObjectOutput.writeLong(this.actionSetId);
        localObject1 = this.info;
        Object localObject2 = null;
        if (localObject1 == null) {
          break label156;
        }
        localObject1 = this.info.toByteArray();
        if ((localObject1 != null) && (localObject1.length > 0))
        {
          paramObjectOutput.writeInt(localObject1.length);
          paramObjectOutput.write((byte[])localObject1);
        }
        else
        {
          paramObjectOutput.writeInt(0);
        }
        localObject1 = localObject2;
        if (!TextUtils.isEmpty(this.canvasForXiJingOffline)) {
          localObject1 = this.canvasForXiJingOffline.getBytes("UTF-8");
        }
        if ((localObject1 != null) && (localObject1.length > 0))
        {
          paramObjectOutput.writeInt(localObject1.length);
          paramObjectOutput.write((byte[])localObject1);
          return;
        }
        paramObjectOutput.writeInt(0);
        return;
      }
      catch (Throwable paramObjectOutput)
      {
        GdtLog.d("GdtAd", "writeExternal", paramObjectOutput);
        return;
      }
      GdtLog.d("GdtAd", "writeExternal error");
      return;
      label156:
      Object localObject1 = null;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if ((paramParcel != null) && (this.info != null)) {}
    for (;;)
    {
      try
      {
        paramParcel.writeLong(this.actionSetId);
        paramParcel.writeString(this.canvasForXiJingOffline);
        byte[] arrayOfByte = this.info.toByteArray();
        if (arrayOfByte == null) {
          break label92;
        }
        paramInt = arrayOfByte.length;
        paramParcel.writeInt(paramInt);
        if (paramInt <= 0)
        {
          GdtLog.d("GdtAd", "writeToParcel error");
          return;
        }
        paramParcel.writeByteArray(arrayOfByte);
        return;
      }
      catch (Throwable paramParcel)
      {
        GdtLog.d("GdtAd", "writeToParcel", paramParcel);
        return;
      }
      GdtLog.d("GdtAd", "writeToParcel error");
      return;
      label92:
      paramInt = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.aditem.GdtAd
 * JD-Core Version:    0.7.0.1
 */