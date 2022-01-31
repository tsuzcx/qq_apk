package com.tencent.biz.pubaccount.readinjoy.struct;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import awdg;
import bjxj;
import com.tencent.biz.pubaccount.VideoInfo.GameAdComData;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import obl;
import obm;
import oed;
import org.json.JSONArray;
import org.json.JSONObject;
import qkd;
import qlg;
import tencent.im.oidb.articlesummary.articlesummary.AdInfo;
import tencent.im.oidb.articlesummary.articlesummary.NegFeedback;
import tencent.im.oidb.cmd0x886.oidb_cmd0x886.AdInfo;

public class AdvertisementInfo
  extends ArticleInfo
  implements Parcelable
{
  public static final long ADVERTISEMENT_ALGORITHM_ID_MASK = 3L;
  public static final int AD_STYLE_0 = 0;
  public static final int AD_STYLE_1 = 1;
  public static final int AD_STYLE_2 = 2;
  public static final int AD_STYLE_3 = 3;
  public static final int APP_STATE_DOWNLOAD = 0;
  public static final int APP_STATE_OPEN = 1;
  public static final Parcelable.Creator<AdvertisementInfo> CREATOR = new qkd();
  public static final int IMAX_IMG_TYPE = 1002;
  public static final int IMAX_VIDEO_TYPE = 1001;
  public static final int PRODUCT_TYPE_APP = 12;
  public static final String TABLE_NAME = AdvertisementInfo.class.getSimpleName();
  @awdg
  public int adStrategyType;
  @awdg
  public int adbt;
  @awdg
  public int adpa;
  @awdg
  public int adpb;
  public int clickPos = -1;
  public int clickType;
  @awdg
  public int downloadState = 0;
  @awdg
  public VideoInfo.GameAdComData gameAdComData;
  @awdg
  public boolean hasAddExposure;
  public boolean isClickFromPkFragment;
  @awdg
  public boolean isHideForAnimate;
  @awdg
  public boolean isIMaxAndNewStyle;
  public boolean isMultiyVideo;
  public boolean isShowBrandAnimate;
  @awdg
  public boolean isShowingGuide;
  public long mADVideoAutoPlay;
  public long mAdAdvertiseId;
  public long mAdAid;
  public String mAdAppDownLoadSchema;
  public String mAdAppJson;
  public String mAdApurl;
  public String mAdBtnTxt;
  public String mAdCanvasJson;
  public String mAdCl;
  public String mAdCorporateImageName;
  public String mAdCorporateLogo;
  public String mAdCorporationName;
  public int mAdCostType;
  public String mAdCustomizedInvokeUrl;
  public String mAdDesc;
  public int mAdDestType;
  @awdg
  public ArrayList<AdDislikeInfo> mAdDislikeInfos;
  public String mAdDownloadApiUrl;
  public String mAdEffectUrl;
  public String mAdExt;
  public String mAdExtInfo;
  public long mAdFeedId;
  public long mAdFetchTime;
  public String mAdImg;
  public ArrayList<String> mAdImgList = new ArrayList();
  public String mAdImgs;
  public String mAdInteractionReportUrl;
  public int mAdJumpMode;
  public int mAdKdPos;
  public String mAdLandingPage;
  public String mAdLandingPageReportUrl;
  public int mAdLayout;
  @awdg
  public int mAdLocalSource = 1;
  public int mAdMaterialHeight;
  public int mAdMaterialId;
  public int mAdMaterialWidth;
  public long mAdNocoId;
  public long mAdPosID;
  public int mAdPosLayout;
  public String mAdPrice;
  public String mAdProductId;
  public int mAdProductType;
  public String mAdRl;
  public int mAdScoreNum;
  public String mAdTraceId;
  public String mAdTxt;
  public int mAdType;
  public long mAdUin;
  public String mAdVia;
  public long mAdVideoFileSize;
  public String mAdVideoUrl;
  public String mAdViewId;
  @awdg
  public obl mAdvertisementExtInfo;
  @awdg
  public obm mAdvertisementSoftInfo;
  @awdg
  public ArrayList<String> mC2SClickUrl;
  @awdg
  public ArrayList<String> mC2SExposureUrl;
  public int mC2SReportTriggerTime;
  @awdg
  public int mC2SSwitch;
  @awdg
  public ArrayList<String> mC2SVideoPlayUrl;
  @awdg
  public String mImaxImg;
  @awdg
  public int mImaxImgDisplayMs = 5000;
  @awdg
  public int mImaxJumpLandingPage = 1;
  @awdg
  public int mImaxShowAdType;
  @awdg
  public int mImaxShowSlipAllowMs = 3000;
  @awdg
  public String mImaxStyle = "0";
  @awdg
  public String mImaxVideoUrl;
  public int mInteractEffectType;
  public String mInteractImageList = "";
  public int mInteractType;
  public qlg mLocalInfo;
  @awdg
  public int mOrigin;
  public int mPhoneComponetId;
  public String mPopFormH5Url;
  @awdg
  public boolean mProgressFromFeeds;
  public int mRevisionVideoType = 1;
  @awdg
  public String mRowKey;
  public boolean mShowAdButton = true;
  public String mSoftAdData;
  public int mSoftAdType;
  public String mSubordinateProductId;
  public int materialGroup;
  public int miniProgramType;
  @awdg
  public int progress;
  @awdg
  public int replay;
  
  public AdvertisementInfo() {}
  
  public AdvertisementInfo(Parcel paramParcel)
  {
    super(paramParcel);
    this.mAdFetchTime = paramParcel.readLong();
    this.mAdPosLayout = paramParcel.readInt();
    this.mAdPosID = paramParcel.readLong();
    this.mADVideoAutoPlay = paramParcel.readLong();
    this.mAdKdPos = paramParcel.readInt();
    this.mAdCl = paramParcel.readString();
    this.mAdImg = paramParcel.readString();
    this.mAdImgs = paramParcel.readString();
    this.mAdTxt = paramParcel.readString();
    this.mAdDesc = paramParcel.readString();
    this.mAdRl = paramParcel.readString();
    this.mAdApurl = paramParcel.readString();
    this.mAdTraceId = paramParcel.readString();
    this.mAdProductId = paramParcel.readString();
    this.mAdProductType = paramParcel.readInt();
    this.mAdType = paramParcel.readInt();
    this.mAdLandingPage = paramParcel.readString();
    this.mAdPrice = paramParcel.readString();
    this.mAdBtnTxt = paramParcel.readString();
    this.mAdViewId = paramParcel.readString();
    this.mAdCustomizedInvokeUrl = paramParcel.readString();
    this.mAdCorporationName = paramParcel.readString();
    this.mAdCorporateImageName = paramParcel.readString();
    this.mAdCorporateLogo = paramParcel.readString();
    this.mAdUin = paramParcel.readLong();
    this.mAdExt = paramParcel.readString();
    this.mAdVideoUrl = paramParcel.readString();
    this.mAdCostType = paramParcel.readInt();
    this.mAdAid = paramParcel.readLong();
    this.mAdLayout = paramParcel.readInt();
    this.mAdMaterialId = paramParcel.readInt();
    this.mAdMaterialWidth = paramParcel.readInt();
    this.mAdMaterialHeight = paramParcel.readInt();
    this.mAdJumpMode = paramParcel.readInt();
    this.mAdAppJson = paramParcel.readString();
    this.mAdExtInfo = paramParcel.readString();
    this.mAdAppDownLoadSchema = paramParcel.readString();
    this.mAdCanvasJson = paramParcel.readString();
    this.mAdLandingPageReportUrl = paramParcel.readString();
    this.mAdAdvertiseId = paramParcel.readLong();
    this.mAdDestType = paramParcel.readInt();
    this.mAdEffectUrl = paramParcel.readString();
    this.mAdNocoId = paramParcel.readLong();
    this.mAdVia = paramParcel.readString();
    this.mAdFeedId = paramParcel.readLong();
    this.mAdInteractionReportUrl = paramParcel.readString();
    this.mAdScoreNum = paramParcel.readInt();
    this.mAdDownloadApiUrl = paramParcel.readString();
    this.mAdVideoFileSize = paramParcel.readLong();
    this.mInteractEffectType = paramParcel.readInt();
    this.mInteractImageList = paramParcel.readString();
    this.mInteractType = paramParcel.readInt();
    this.clickPos = paramParcel.readInt();
    this.mAdLocalSource = paramParcel.readInt();
    this.mSoftAdType = paramParcel.readInt();
    this.mSoftAdData = paramParcel.readString();
    this.mRevisionVideoType = paramParcel.readInt();
    this.mAdvertisementExtInfo = new obl(this.mAdExtInfo);
    processAdExtraDataInfo(this.mAdExtInfo);
  }
  
  public AdvertisementInfo(articlesummary.AdInfo paramAdInfo)
  {
    this.mAdKdPos = paramAdInfo.int32_kd_pos.get();
    this.mAdCl = paramAdInfo.bytes_cl.get().toStringUtf8();
    this.mAdImg = paramAdInfo.bytes_img.get().toStringUtf8();
    this.mAdImgs = paramAdInfo.bytes_img_s.get().toStringUtf8();
    Iterator localIterator;
    Object localObject;
    if ((paramAdInfo.bytes_image_list.has()) && (paramAdInfo.bytes_image_list.get() != null))
    {
      localIterator = paramAdInfo.bytes_image_list.get().iterator();
      while (localIterator.hasNext())
      {
        localObject = (ByteStringMicro)localIterator.next();
        this.mAdImgList.add(((ByteStringMicro)localObject).toStringUtf8());
      }
    }
    this.mAdTxt = paramAdInfo.bytes_txt.get().toStringUtf8();
    this.mAdDesc = paramAdInfo.bytes_desc.get().toStringUtf8();
    this.mAdRl = paramAdInfo.bytes_rl.get().toStringUtf8();
    this.mAdApurl = paramAdInfo.bytes_apurl.get().toStringUtf8();
    this.mAdTraceId = paramAdInfo.bytes_trace_id.get().toStringUtf8();
    this.mAdProductId = paramAdInfo.bytes_product_id.get().toStringUtf8();
    this.mAdProductType = paramAdInfo.int32_product_type.get();
    this.mAdType = paramAdInfo.uint32_ad_type.get();
    this.mAdLandingPage = paramAdInfo.bytes_landing_page.get().toStringUtf8();
    this.mAdPrice = paramAdInfo.bytes_price.get().toStringUtf8();
    this.mAdBtnTxt = paramAdInfo.bytes_button_txt.get().toStringUtf8();
    this.mAdViewId = paramAdInfo.bytes_view_id.get().toStringUtf8();
    this.mAdCustomizedInvokeUrl = paramAdInfo.bytes_customized_invoke_url.get().toStringUtf8();
    this.mAdCorporationName = paramAdInfo.bytes_corporation_name.get().toStringUtf8();
    this.mAdCorporateImageName = paramAdInfo.bytes_corporate_image_name.get().toStringUtf8();
    this.mAdCorporateLogo = paramAdInfo.bytes_corporate_logo.get().toStringUtf8();
    this.mAdUin = paramAdInfo.uint64_ad_uin.get();
    this.mAdExt = paramAdInfo.bytes_ext.get().toStringUtf8();
    if (TextUtils.isEmpty(this.mAdExt)) {
      this.mAdExt = new JSONObject().toString();
    }
    this.mAdVideoUrl = paramAdInfo.bytes_video_url.get().toStringUtf8();
    this.mAdCostType = paramAdInfo.uint32_cost_type.get();
    this.mAdAid = paramAdInfo.uint64_aid.get();
    this.mAdLayout = paramAdInfo.enum_ad_layout.get();
    this.mAdMaterialId = paramAdInfo.uint32_ad_material_id.get();
    this.mAdMaterialWidth = paramAdInfo.uint32_ad_material_width.get();
    this.mAdMaterialHeight = paramAdInfo.uint32_ad_material_height.get();
    this.mAdJumpMode = paramAdInfo.enum_ad_jump_mode.get();
    this.mAdExtInfo = paramAdInfo.bytes_extra_data.get().toStringUtf8();
    if (TextUtils.isEmpty(this.mAdExtInfo)) {
      this.mAdExtInfo = new JSONObject().toString();
    }
    this.mAdAppDownLoadSchema = paramAdInfo.bytes_app_download_schema.get().toStringUtf8();
    this.mAdCanvasJson = paramAdInfo.string_canvas_json.get();
    this.mAdLandingPageReportUrl = paramAdInfo.bytes_landing_page_report_url.get().toStringUtf8();
    this.mAdAdvertiseId = paramAdInfo.uint64_advertiser_id.get();
    this.mAdDestType = paramAdInfo.uint32_dest_type.get();
    this.mAdEffectUrl = paramAdInfo.string_effect_url.get();
    this.mAdNocoId = paramAdInfo.int64_noco_id.get();
    this.mAdVia = paramAdInfo.bytes_via.get().toStringUtf8();
    this.mAdFeedId = paramAdInfo.uint64_feeds_id.get();
    this.mAdInteractionReportUrl = paramAdInfo.string_interaction_report_url.get();
    if (paramAdInfo.rpt_msg_neg_feedback.has())
    {
      this.mAdDislikeInfos = new ArrayList();
      localIterator = paramAdInfo.rpt_msg_neg_feedback.get().iterator();
      while (localIterator.hasNext())
      {
        localObject = (articlesummary.NegFeedback)localIterator.next();
        if (localObject != null) {
          this.mAdDislikeInfos.add(new AdDislikeInfo((articlesummary.NegFeedback)localObject));
        }
      }
    }
    this.mAdScoreNum = paramAdInfo.uint32_app_score_num.get();
    if (paramAdInfo.string_download_api_url.has()) {
      this.mAdDownloadApiUrl = paramAdInfo.string_download_api_url.get();
    }
    this.mAdVideoFileSize = paramAdInfo.uint64_video_file_size.get();
    processAdExtraDataInfo(this.mAdExtInfo);
    this.mLocalInfo = new qlg(paramAdInfo.local_info);
    this.mInteractEffectType = paramAdInfo.uint32_interact_effect_type.get();
    if (paramAdInfo.string_interact_image_list.has()) {
      this.mInteractImageList = paramAdInfo.string_interact_image_list.get();
    }
    this.mInteractType = paramAdInfo.uint32_interact_type.get();
    this.mAdvertisementExtInfo = new obl(this.mAdExtInfo);
    processAdExt(this.mAdExt);
  }
  
  public static int getAdStyle(AdvertisementInfo paramAdvertisementInfo)
  {
    if (isAdvertisementInfo(paramAdvertisementInfo)) {
      return oed.b(paramAdvertisementInfo);
    }
    return 0;
  }
  
  public static int getBigAppAdStyle(AdvertisementInfo paramAdvertisementInfo)
  {
    if (isAppAdvertisementInfo(paramAdvertisementInfo)) {
      return oed.b(paramAdvertisementInfo);
    }
    return 0;
  }
  
  public static boolean isAdvertisementInfo(BaseArticleInfo paramBaseArticleInfo)
  {
    return AdvertisementInfo.class.isInstance(paramBaseArticleInfo);
  }
  
  public static boolean isAppAdvertisementInfo(BaseArticleInfo paramBaseArticleInfo)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (isAdvertisementInfo(paramBaseArticleInfo))
    {
      bool1 = bool2;
      if (((AdvertisementInfo)paramBaseArticleInfo).mAdProductType == 12) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public int getAdbf()
  {
    if (this.adbt == 0) {
      return 1;
    }
    return 0;
  }
  
  public int getClickPos()
  {
    return this.clickPos;
  }
  
  public boolean isGameAdSource()
  {
    return (this.mAdvertisementExtInfo != null) && (this.mAdvertisementExtInfo.j == 32768);
  }
  
  public String logAdString()
  {
    StringBuilder localStringBuilder = new StringBuilder("AdvertisementInfo[");
    localStringBuilder.append("mAdMaterialId:" + this.mAdMaterialId).append(",");
    localStringBuilder.append("mAdKdPos:" + this.mAdKdPos).append(",");
    localStringBuilder.append("mAdExtInfo:" + this.mAdExtInfo).append(",");
    localStringBuilder.append("mAdTraceId:" + this.mAdTraceId).append(",");
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public oidb_cmd0x886.AdInfo makeReportAdInfo(int paramInt)
  {
    oidb_cmd0x886.AdInfo localAdInfo = new oidb_cmd0x886.AdInfo();
    localAdInfo.bytes_trace_id.set(ByteStringMicro.copyFromUtf8(this.mAdTraceId));
    localAdInfo.uint64_pull_time.set(this.mAdFetchTime);
    localAdInfo.enum_report_type.set(paramInt);
    localAdInfo.bytes_apurl.set(ByteStringMicro.copyFromUtf8(this.mAdApurl));
    localAdInfo.bytes_rl.set(ByteStringMicro.copyFromUtf8(this.mAdRl));
    localAdInfo.bytes_view_id.set(ByteStringMicro.copyFromUtf8(this.mAdViewId));
    localAdInfo.uint64_pos_id.set(this.mAdPosID);
    localAdInfo.uint64_channel_id.set(this.mChannelID);
    localAdInfo.int32_kd_pos.set(this.mAdKdPos);
    localAdInfo.bytes_cl.set(ByteStringMicro.copyFromUtf8(this.mAdCl));
    localAdInfo.enum_pos_layout.set(this.mAdPosLayout);
    localAdInfo.bytes_product_id.set(ByteStringMicro.copyFromUtf8(this.mAdProductId));
    localAdInfo.int32_product_type.set(this.mAdProductType);
    localAdInfo.uint32_ad_type.set(this.mAdType);
    localAdInfo.bytes_price.set(ByteStringMicro.copyFromUtf8(this.mAdPrice));
    localAdInfo.bytes_customized_invoke_url.set(ByteStringMicro.copyFromUtf8(this.mAdCustomizedInvokeUrl));
    localAdInfo.bytes_corporation_name.set(ByteStringMicro.copyFromUtf8(this.mAdCorporationName));
    localAdInfo.bytes_corporate_image_name.set(ByteStringMicro.copyFromUtf8(this.mAdCorporateImageName));
    localAdInfo.bytes_corporate_logo.set(ByteStringMicro.copyFromUtf8(this.mAdCorporateLogo));
    localAdInfo.uint64_ad_uin.set(this.mAdUin);
    localAdInfo.bytes_ext.set(ByteStringMicro.copyFromUtf8(this.mAdExt));
    localAdInfo.bytes_video_url.set(ByteStringMicro.copyFromUtf8(this.mAdVideoUrl));
    localAdInfo.uint32_cost_type.set(this.mAdCostType);
    localAdInfo.uint64_aid.set(this.mAdAid);
    localAdInfo.bytes_img.set(ByteStringMicro.copyFromUtf8(this.mAdImg));
    localAdInfo.bytes_img_s.set(ByteStringMicro.copyFromUtf8(this.mAdImgs));
    localAdInfo.bytes_txt.set(ByteStringMicro.copyFromUtf8(this.mAdTxt));
    localAdInfo.bytes_desc.set(ByteStringMicro.copyFromUtf8(this.mAdDesc));
    localAdInfo.enum_ad_layout.set(this.mAdLayout);
    localAdInfo.uint32_ad_material_id.set(this.mAdMaterialId);
    return localAdInfo;
  }
  
  public void processAdExt(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      for (;;)
      {
        return;
        try
        {
          paramString = new JSONObject(paramString);
          if (paramString.has("subordinate_product_id")) {
            this.mSubordinateProductId = paramString.optString("subordinate_product_id");
          }
          if (QLog.isColorLevel())
          {
            QLog.d("processAdExt", 2, " processAdExt mSubordinateProductId = " + this.mSubordinateProductId);
            return;
          }
        }
        catch (Exception paramString) {}
      }
    } while (!QLog.isColorLevel());
    QLog.e("processAdExt", 1, "processAdExt exception " + paramString.toString());
  }
  
  public void processAdExtraDataInfo(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        if (paramString.has("mini_program_type")) {
          this.miniProgramType = paramString.optInt("mini_program_type");
        }
        if (paramString.has("c2s_switch")) {
          this.mC2SSwitch = paramString.optInt("c2s_switch");
        }
        Object localObject;
        int j;
        ArrayList localArrayList;
        int i;
        String str;
        if (paramString.has("c2s_click_url"))
        {
          localObject = paramString.optJSONArray("c2s_click_url");
          if ((localObject != null) && (((JSONArray)localObject).length() > 0))
          {
            j = ((JSONArray)localObject).length();
            localArrayList = new ArrayList();
            i = 0;
            if (i < j)
            {
              str = (String)((JSONArray)localObject).opt(i);
              if (QLog.isColorLevel()) {
                QLog.d("processAdExtraDataInfo", 2, " processAdExtraDataInfo clickUrl = " + str);
              }
              localArrayList.add(str);
              i += 1;
              continue;
            }
            this.mC2SClickUrl = localArrayList;
          }
        }
        if (paramString.has("c2s_exposure_url"))
        {
          localObject = paramString.optJSONArray("c2s_exposure_url");
          if ((localObject != null) && (((JSONArray)localObject).length() > 0))
          {
            j = ((JSONArray)localObject).length();
            localArrayList = new ArrayList();
            i = 0;
            if (i < j)
            {
              str = (String)((JSONArray)localObject).opt(i);
              if (QLog.isColorLevel()) {
                QLog.d("processAdExtraDataInfo", 2, " processAdExtraDataInfo exposureUrl = " + str);
              }
              localArrayList.add(str);
              i += 1;
              continue;
            }
            this.mC2SExposureUrl = localArrayList;
          }
        }
        if (paramString.has("c2s_video_play_url"))
        {
          localObject = paramString.optJSONArray("c2s_video_play_url");
          if ((localObject != null) && (((JSONArray)localObject).length() > 0))
          {
            j = ((JSONArray)localObject).length();
            localArrayList = new ArrayList();
            i = 0;
            if (i < j)
            {
              str = (String)((JSONArray)localObject).opt(i);
              if (QLog.isColorLevel()) {
                QLog.d("processAdExtraDataInfo", 2, " processAdExtraDataInfo videoPlayUrl = " + str);
              }
              localArrayList.add(str);
              i += 1;
              continue;
            }
            this.mC2SVideoPlayUrl = localArrayList;
          }
        }
        if (paramString.has("video_play_duration")) {
          this.mC2SReportTriggerTime = paramString.optInt("video_play_duration");
        }
        if (paramString.has("pop_sheet"))
        {
          localObject = new JSONObject(paramString.optString("pop_sheet")).getString("h5Url");
          if (QLog.isColorLevel()) {
            QLog.d("processAdExtraDataInfo", 2, "h5Url = " + (String)localObject);
          }
          this.mPopFormH5Url = ((String)localObject);
        }
        if (paramString.has("button_flag"))
        {
          localObject = paramString.optString("button_flag", "1");
          if (QLog.isColorLevel()) {
            QLog.d("processAdExtraDataInfo", 2, "buttonFlag = " + (String)localObject);
          }
          if (!((String)localObject).equals("0"))
          {
            bool = true;
            this.mShowAdButton = bool;
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("processAdExtraDataInfo", 2, " processAdExtraDataInfo mAdCorporateImageName = " + this.mAdCorporateImageName + " mAdTraceId = " + this.mAdTraceId + "c2s_switch = " + this.mC2SSwitch);
          }
          if (paramString.has("phone_component_id")) {
            this.mPhoneComponetId = paramString.optInt("phone_component_id");
          }
          if (paramString.has("showAdType")) {
            this.mImaxShowAdType = paramString.optInt("showAdType");
          }
          if (paramString.has("imaxVideoUrl")) {
            this.mImaxVideoUrl = paramString.optString("imaxVideoUrl");
          }
          if (paramString.has("imaxImg")) {
            this.mImaxImg = paramString.optString("imaxImg");
          }
          if (paramString.has("imaxImgDisplayMs")) {
            this.mImaxImgDisplayMs = paramString.optInt("imaxImgDisplayMs", 5000);
          }
          if (paramString.has("imaxJumpLandingPage")) {
            this.mImaxJumpLandingPage = paramString.optInt("imaxJumpLandingPage", 1);
          }
          if (paramString.has("imaxShowSlipAllowMs")) {
            this.mImaxShowSlipAllowMs = paramString.optInt("imaxShowSlipAllowMs", 3000);
          }
          this.mImaxStyle = bjxj.a("sp_key_ad_imax_style");
          if ((this.mImaxShowAdType != 1001) || (!"1".equals(this.mImaxStyle))) {
            break;
          }
          this.isIMaxAndNewStyle = true;
          return;
        }
      }
      catch (Exception paramString)
      {
        QLog.e("processAdExtraDataInfo", 1, "processAdExtraDataInfo exception " + paramString.toString());
        return;
      }
      boolean bool = false;
    }
  }
  
  public void processSoftDataInfo(String paramString)
  {
    this.mAdvertisementSoftInfo = new obm(paramString);
  }
  
  public void processSoftDataInfo(JSONObject paramJSONObject)
  {
    this.mAdvertisementSoftInfo = new obm(paramJSONObject);
  }
  
  public void resetClickPos()
  {
    this.clickPos = -1;
  }
  
  public void setClickPos(int paramInt)
  {
    this.clickPos = paramInt;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeLong(this.mAdFetchTime);
    paramParcel.writeInt(this.mAdPosLayout);
    paramParcel.writeLong(this.mAdPosID);
    paramParcel.writeLong(this.mADVideoAutoPlay);
    paramParcel.writeInt(this.mAdKdPos);
    paramParcel.writeString(this.mAdCl);
    paramParcel.writeString(this.mAdImg);
    paramParcel.writeString(this.mAdImgs);
    paramParcel.writeString(this.mAdTxt);
    paramParcel.writeString(this.mAdDesc);
    paramParcel.writeString(this.mAdRl);
    paramParcel.writeString(this.mAdApurl);
    paramParcel.writeString(this.mAdTraceId);
    paramParcel.writeString(this.mAdProductId);
    paramParcel.writeInt(this.mAdProductType);
    paramParcel.writeInt(this.mAdType);
    paramParcel.writeString(this.mAdLandingPage);
    paramParcel.writeString(this.mAdPrice);
    paramParcel.writeString(this.mAdBtnTxt);
    paramParcel.writeString(this.mAdViewId);
    paramParcel.writeString(this.mAdCustomizedInvokeUrl);
    paramParcel.writeString(this.mAdCorporationName);
    paramParcel.writeString(this.mAdCorporateImageName);
    paramParcel.writeString(this.mAdCorporateLogo);
    paramParcel.writeLong(this.mAdUin);
    paramParcel.writeString(this.mAdExt);
    paramParcel.writeString(this.mAdVideoUrl);
    paramParcel.writeInt(this.mAdCostType);
    paramParcel.writeLong(this.mAdAid);
    paramParcel.writeInt(this.mAdLayout);
    paramParcel.writeInt(this.mAdMaterialId);
    paramParcel.writeInt(this.mAdMaterialWidth);
    paramParcel.writeInt(this.mAdMaterialHeight);
    paramParcel.writeInt(this.mAdJumpMode);
    paramParcel.writeString(this.mAdAppJson);
    paramParcel.writeString(this.mAdExtInfo);
    paramParcel.writeString(this.mAdAppDownLoadSchema);
    paramParcel.writeString(this.mAdCanvasJson);
    paramParcel.writeString(this.mAdLandingPageReportUrl);
    paramParcel.writeLong(this.mAdAdvertiseId);
    paramParcel.writeInt(this.mAdDestType);
    paramParcel.writeString(this.mAdEffectUrl);
    paramParcel.writeLong(this.mAdNocoId);
    paramParcel.writeString(this.mAdVia);
    paramParcel.writeLong(this.mAdFeedId);
    paramParcel.writeString(this.mAdInteractionReportUrl);
    paramParcel.writeInt(this.mAdScoreNum);
    paramParcel.writeString(this.mAdDownloadApiUrl);
    paramParcel.writeLong(this.mAdVideoFileSize);
    paramParcel.writeInt(this.mInteractEffectType);
    paramParcel.writeString(this.mInteractImageList);
    paramParcel.writeInt(this.mInteractType);
    paramParcel.writeInt(this.clickPos);
    paramParcel.writeInt(this.mAdLocalSource);
    paramParcel.writeInt(this.mSoftAdType);
    paramParcel.writeString(this.mSoftAdData);
    paramParcel.writeInt(this.mRevisionVideoType);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo
 * JD-Core Version:    0.7.0.1
 */