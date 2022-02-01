package com.tencent.biz.pubaccount.readinjoy.struct;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.NativeAd.report.constant.AdClickPos;
import com.tencent.biz.pubaccount.readinjoy.video.playfeeds.GameAdComData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdDislikeInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdvertisementExtInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdvertisementSoftInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.CommentAdParams;
import com.tencent.biz.pubaccount.readinjoyAd.ad.experiment.AdExperimentData;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.ad.api.IRIJCommonService;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.video.IVideoCardUIModel;
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
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.pts.core.PTSComposer.IPTSUpdateDataListener;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import tencent.im.oidb.articlesummary.articlesummary.AdInfo;
import tencent.im.oidb.articlesummary.articlesummary.NegFeedback;
import tencent.im.oidb.cmd0x886.oidb_cmd0x886.AdInfo;

public class AdvertisementInfo
  extends AbsBaseArticleInfo
{
  public static final long ADVERTISEMENT_ALGORITHM_ID_MASK = 3L;
  public static final int AD_STYLE_0 = 0;
  public static final int AD_STYLE_1 = 1;
  public static final int AD_STYLE_2 = 2;
  public static final int AD_STYLE_3 = 3;
  public static final int APP_STATE_DOWNLOAD = 0;
  public static final int APP_STATE_OPEN = 1;
  public static final Parcelable.Creator<AdvertisementInfo> CREATOR = new AdvertisementInfo.1();
  public static final int IMAX_IMG_TYPE = 1002;
  public static final int IMAX_VIDEO_TYPE = 1001;
  public static final int PRODUCT_TYPE_APP = 12;
  public static final String TABLE_NAME = "AdvertisementInfo";
  public AdClickPos adClickPos;
  @notColumn
  public AdExperimentData adExperimentData = new AdExperimentData();
  @notColumn
  public int adPosType;
  @notColumn
  public int adStrategyType = 0;
  @notColumn
  public int adbt = 0;
  @notColumn
  public int adpa = 0;
  @notColumn
  public int adpb = 0;
  @notColumn
  public String amsNfbUrl;
  public int clickPos = -1;
  public int clickType = 0;
  @notColumn
  public int downloadState = 0;
  @notColumn
  public double ecpm;
  @notColumn
  public GameAdComData gameAdComData;
  @notColumn
  public boolean hasAddExposure;
  @notColumn
  public boolean isBottomAd = false;
  @notColumn
  public boolean isClickClose;
  public boolean isClickFromPkFragment = false;
  @notColumn
  public boolean isClickReplay;
  @notColumn
  public int isContract;
  @notColumn
  public boolean isHideForAnimate = false;
  @notColumn
  public boolean isIMaxAndNewStyle = false;
  @notColumn
  public boolean isKolGame;
  public boolean isMultiyVideo = false;
  public boolean isShowBrandAnimate = false;
  @notColumn
  public boolean isShowingGuide = false;
  @notColumn
  public boolean isSmallCard;
  @notColumn
  public String liujinReportUrl;
  public long mADVideoAutoPlay = 0L;
  public long mAdAdvertiseId = 0L;
  public long mAdAid = 0L;
  public String mAdAppDownLoadSchema = null;
  public String mAdAppJson = null;
  public String mAdApurl = null;
  public String mAdBtnTxt = null;
  public String mAdCanvasJson = null;
  public String mAdCl = null;
  public String mAdCorporateImageName = null;
  public String mAdCorporateLogo = null;
  public String mAdCorporationName = null;
  public int mAdCostType = 0;
  public String mAdCustomizedInvokeUrl = null;
  public String mAdDesc = null;
  public int mAdDestType = 0;
  @notColumn
  public ArrayList<AdDislikeInfo> mAdDislikeInfos = null;
  public String mAdDownloadApiUrl;
  public String mAdEffectUrl = null;
  public String mAdExt = null;
  public String mAdExtInfo = null;
  public long mAdFeedId = 0L;
  public long mAdFetchTime = 0L;
  public String mAdImg = null;
  public ArrayList<String> mAdImgList = new ArrayList();
  public String mAdImgs = null;
  public String mAdInteractionReportUrl = null;
  public int mAdJumpMode = 0;
  public int mAdKdPos = 0;
  public String mAdLandingPage = null;
  public String mAdLandingPageReportUrl = null;
  public int mAdLayout = 0;
  @notColumn
  public int mAdLocalSource = 1;
  public int mAdMaterialHeight = 0;
  public int mAdMaterialId = 0;
  public int mAdMaterialWidth = 0;
  public long mAdNocoId = 0L;
  public long mAdPosID = 0L;
  public int mAdPosLayout = 0;
  public String mAdPrice = null;
  public String mAdProductId = null;
  public int mAdProductType = 0;
  public String mAdRl = null;
  public int mAdScoreNum;
  public String mAdTraceId = null;
  public String mAdTxt = null;
  public int mAdType = 0;
  public long mAdUin = 0L;
  public String mAdVia = null;
  public long mAdVideoFileSize = 0L;
  public String mAdVideoUrl = null;
  public String mAdViewId = null;
  @notColumn
  public AdvertisementExtInfo mAdvertisementExtInfo;
  @notColumn
  public AdvertisementSoftInfo mAdvertisementSoftInfo;
  @notColumn
  public JSONObject mBusiJson;
  @notColumn
  public ArrayList<String> mC2SClickUrl = null;
  @notColumn
  public ArrayList<String> mC2SExposureUrl = null;
  public int mC2SReportTriggerTime;
  @notColumn
  public int mC2SSwitch = 0;
  @notColumn
  public ArrayList<String> mC2SVideoPlayUrl = null;
  @notColumn
  public CommentAdParams mCommentAdParams;
  @notColumn
  public String mImaxImg;
  @notColumn
  public int mImaxImgDisplayMs = 5000;
  @notColumn
  public int mImaxJumpLandingPage = 1;
  @notColumn
  public int mImaxShowAdType;
  @notColumn
  public int mImaxShowSlipAllowMs = 3000;
  @notColumn
  public String mImaxStyle = "0";
  @notColumn
  public String mImaxVideoUrl;
  public int mInteractEffectType;
  public String mInteractImageList = "";
  public int mInteractType;
  public LocalInfo mLocalInfo = null;
  @notColumn
  public int mOrigin;
  public int mPhoneComponetId;
  public String mPopFormH5Url;
  @notColumn
  public JSONObject mReportDataJson;
  public int mRevisionVideoType = 1;
  @notColumn
  public String mRowKey;
  public boolean mShowAdButton = true;
  public String mSoftAdData;
  public int mSoftAdType;
  public String mSubordinateProductId;
  public int materialGroup = 0;
  public int miniProgramType;
  @notColumn
  public String originalExposureUrl;
  @notColumn
  public String packageName;
  @notColumn
  public int progress;
  @notColumn
  public int replay;
  @notColumn
  public String scene;
  @notColumn
  public String ticket;
  @notColumn
  public int videoReplayCount;
  
  public AdvertisementInfo() {}
  
  public AdvertisementInfo(Parcel paramParcel)
  {
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
    this.mChannelID = paramParcel.readLong();
    this.mAdvertisementExtInfo = new AdvertisementExtInfo(this.mAdExtInfo);
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
    processAdExtInfo(this.mAdExtInfo);
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
    this.mLocalInfo = new LocalInfo(paramAdInfo.local_info);
    this.mInteractEffectType = paramAdInfo.uint32_interact_effect_type.get();
    if (paramAdInfo.string_interact_image_list.has()) {
      this.mInteractImageList = paramAdInfo.string_interact_image_list.get();
    }
    this.mInteractType = paramAdInfo.uint32_interact_type.get();
    this.mAdvertisementExtInfo = new AdvertisementExtInfo(this.mAdExtInfo);
    processAdExt(this.mAdExt);
  }
  
  private void parseC2SClickUrl(JSONObject paramJSONObject)
  {
    if (paramJSONObject.has("c2s_click_url"))
    {
      paramJSONObject = paramJSONObject.optJSONArray("c2s_click_url");
      if ((paramJSONObject != null) && (paramJSONObject.length() > 0))
      {
        int j = paramJSONObject.length();
        ArrayList localArrayList = new ArrayList();
        int i = 0;
        while (i < j)
        {
          String str = (String)paramJSONObject.opt(i);
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(" processAdExtraDataInfo clickUrl = ");
            localStringBuilder.append(str);
            QLog.d("processAdExtraDataInfo", 2, localStringBuilder.toString());
          }
          localArrayList.add(str);
          i += 1;
        }
        this.mC2SClickUrl = localArrayList;
      }
    }
  }
  
  private void parseC2SExposureUrl(JSONObject paramJSONObject)
  {
    if (paramJSONObject.has("c2s_exposure_url"))
    {
      paramJSONObject = paramJSONObject.optJSONArray("c2s_exposure_url");
      if ((paramJSONObject != null) && (paramJSONObject.length() > 0))
      {
        int j = paramJSONObject.length();
        ArrayList localArrayList = new ArrayList();
        int i = 0;
        while (i < j)
        {
          String str = (String)paramJSONObject.opt(i);
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(" processAdExtraDataInfo exposureUrl = ");
            localStringBuilder.append(str);
            QLog.d("processAdExtraDataInfo", 2, localStringBuilder.toString());
          }
          localArrayList.add(str);
          i += 1;
        }
        this.mC2SExposureUrl = localArrayList;
      }
    }
  }
  
  private void parseC2SVideoPlayUrl(JSONObject paramJSONObject)
  {
    if (paramJSONObject.has("c2s_video_play_url"))
    {
      paramJSONObject = paramJSONObject.optJSONArray("c2s_video_play_url");
      if ((paramJSONObject != null) && (paramJSONObject.length() > 0))
      {
        int j = paramJSONObject.length();
        ArrayList localArrayList = new ArrayList();
        int i = 0;
        while (i < j)
        {
          String str = (String)paramJSONObject.opt(i);
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(" processAdExtraDataInfo videoPlayUrl = ");
            localStringBuilder.append(str);
            QLog.d("processAdExtraDataInfo", 2, localStringBuilder.toString());
          }
          localArrayList.add(str);
          i += 1;
        }
        this.mC2SVideoPlayUrl = localArrayList;
      }
    }
  }
  
  private void parsePopFormH5Url(JSONObject paramJSONObject)
  {
    if (paramJSONObject.has("pop_sheet"))
    {
      paramJSONObject = new JSONObject(paramJSONObject.optString("pop_sheet")).getString("h5Url");
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("h5Url = ");
        localStringBuilder.append(paramJSONObject);
        QLog.d("processAdExtraDataInfo", 2, localStringBuilder.toString());
      }
      this.mPopFormH5Url = paramJSONObject;
    }
  }
  
  private void parseShowAdButton(JSONObject paramJSONObject)
  {
    if (paramJSONObject.has("button_flag"))
    {
      paramJSONObject = paramJSONObject.optString("button_flag", "1");
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("buttonFlag = ");
        localStringBuilder.append(paramJSONObject);
        QLog.d("processAdExtraDataInfo", 2, localStringBuilder.toString());
      }
      this.mShowAdButton = (paramJSONObject.equals("0") ^ true);
    }
  }
  
  private void processAdExtInfo(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      if (TextUtils.isEmpty(this.packageName))
      {
        this.packageName = paramString.optString("game_pkg_name");
        if (TextUtils.isEmpty(this.packageName)) {
          this.packageName = paramString.optString("pkg_name");
        }
      }
      if (TextUtils.isEmpty(this.liujinReportUrl)) {
        this.liujinReportUrl = paramString.optString("liujinReportUrl");
      }
      if (TextUtils.isEmpty(this.ticket))
      {
        this.ticket = paramString.optString("ticket");
        if (TextUtils.isEmpty(this.ticket)) {
          this.ticket = paramString.optString("ad_encrypted_ticket");
        }
      }
      if (TextUtils.isEmpty(this.amsNfbUrl)) {
        this.amsNfbUrl = paramString.optString("amsNfbUrl");
      }
      if (TextUtils.isEmpty(this.originalExposureUrl)) {
        this.originalExposureUrl = paramString.optString("original_exposure_url");
      }
      return;
    }
    catch (Throwable paramString) {}
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int getAdbf()
  {
    if (this.adbt == 0) {
      return 1;
    }
    return 0;
  }
  
  public String getAmsNfbUrl()
  {
    processAdExtInfo(this.mAdExtInfo);
    if (!TextUtils.isEmpty(this.amsNfbUrl)) {
      return this.amsNfbUrl;
    }
    Object localObject = this.mAdvertisementSoftInfo;
    if ((localObject != null) && (!TextUtils.isEmpty(((AdvertisementSoftInfo)localObject).W)))
    {
      this.amsNfbUrl = this.mAdvertisementSoftInfo.W;
      return this.amsNfbUrl;
    }
    localObject = this.gameAdComData;
    if ((localObject != null) && (!TextUtils.isEmpty(((GameAdComData)localObject).H)))
    {
      this.amsNfbUrl = this.gameAdComData.H;
      return this.amsNfbUrl;
    }
    return null;
  }
  
  public int getClickPos()
  {
    return this.clickPos;
  }
  
  public String getExtraParam(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      if (TextUtils.isEmpty(this.mAdExtInfo)) {
        return "";
      }
    }
    try
    {
      paramString = new JSONObject(this.mAdExtInfo).optString(paramString, "");
      return paramString;
    }
    catch (Exception paramString) {}
    return "";
    return "";
  }
  
  protected IVideoCardUIModel getLazyModel()
  {
    return ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).getVideoCardUIModel(this);
  }
  
  public String getLiujinReportUrl()
  {
    processAdExtInfo(this.mAdExtInfo);
    if (!TextUtils.isEmpty(this.liujinReportUrl)) {
      return this.liujinReportUrl;
    }
    Object localObject = this.mAdvertisementSoftInfo;
    if ((localObject != null) && (!TextUtils.isEmpty(((AdvertisementSoftInfo)localObject).U)))
    {
      this.liujinReportUrl = this.mAdvertisementSoftInfo.U;
      return this.liujinReportUrl;
    }
    localObject = this.gameAdComData;
    if ((localObject != null) && (!TextUtils.isEmpty(((GameAdComData)localObject).F)))
    {
      this.liujinReportUrl = this.gameAdComData.F;
      return this.liujinReportUrl;
    }
    return null;
  }
  
  public int getNextAdPosition()
  {
    String str = this.mAdExtInfo;
    if (str != null) {
      try
      {
        int i = new JSONObject(str).optInt("next_ad_position");
        return i;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    return 0;
  }
  
  public PTSComposer.IPTSUpdateDataListener getPTSUpdateDataListener()
  {
    return null;
  }
  
  public String getPackageName()
  {
    processAdExtInfo(this.mAdExtInfo);
    if (!TextUtils.isEmpty(this.packageName)) {
      return this.packageName;
    }
    Object localObject = this.mAdvertisementSoftInfo;
    if ((localObject != null) && (!TextUtils.isEmpty(((AdvertisementSoftInfo)localObject).o)))
    {
      this.packageName = this.mAdvertisementSoftInfo.o;
      return this.packageName;
    }
    localObject = this.gameAdComData;
    if ((localObject != null) && (!TextUtils.isEmpty(((GameAdComData)localObject).d)))
    {
      this.packageName = this.gameAdComData.d;
      return this.packageName;
    }
    return null;
  }
  
  public String getTicket()
  {
    processAdExtInfo(this.mAdExtInfo);
    if (!TextUtils.isEmpty(this.ticket)) {
      return this.ticket;
    }
    Object localObject = this.mAdvertisementSoftInfo;
    if ((localObject != null) && (!TextUtils.isEmpty(((AdvertisementSoftInfo)localObject).V)))
    {
      this.ticket = this.mAdvertisementSoftInfo.V;
      return this.ticket;
    }
    localObject = this.gameAdComData;
    if ((localObject != null) && (!TextUtils.isEmpty(((GameAdComData)localObject).G)))
    {
      this.ticket = this.gameAdComData.G;
      return this.ticket;
    }
    return null;
  }
  
  public boolean isCommentAd()
  {
    CommentAdParams localCommentAdParams = this.mCommentAdParams;
    if (localCommentAdParams != null) {
      return localCommentAdParams.jdField_a_of_type_Boolean;
    }
    return false;
  }
  
  public boolean isGameAd()
  {
    return (this.gameAdComData != null) && (this.mSoftAdType == 1);
  }
  
  public boolean isGameDownload()
  {
    return (isGameAd()) && (this.gameAdComData.s != null) && (this.gameAdComData.s.equals("2"));
  }
  
  public boolean isKolSoftAd()
  {
    return (isSoftAd()) && (this.mAdvertisementSoftInfo.jdField_c_of_type_Int == 3);
  }
  
  public boolean isSoftAd()
  {
    return (this.mAdvertisementSoftInfo != null) && (this.mSoftAdType == 2);
  }
  
  public String logAdString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder("AdvertisementInfo[");
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("mAdMaterialId:");
    localStringBuilder2.append(this.mAdMaterialId);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder1.append(",");
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("mAdKdPos:");
    localStringBuilder2.append(this.mAdKdPos);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder1.append(",");
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("mAdExtInfo:");
    localStringBuilder2.append(this.mAdExtInfo);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder1.append(",");
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("mAdTraceId:");
    localStringBuilder2.append(this.mAdTraceId);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder1.append(",");
    localStringBuilder1.append("]");
    return localStringBuilder1.toString();
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
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString.has("subordinate_product_id")) {
        this.mSubordinateProductId = paramString.optString("subordinate_product_id");
      }
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append(" processAdExt mSubordinateProductId = ");
        paramString.append(this.mSubordinateProductId);
        QLog.d("processAdExt", 2, paramString.toString());
        return;
      }
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("processAdExt exception ");
        localStringBuilder.append(paramString.toString());
        QLog.e("processAdExt", 1, localStringBuilder.toString());
      }
    }
  }
  
  public void processAdExtraDataInfo(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString.has("mini_program_type")) {
        this.miniProgramType = paramString.optInt("mini_program_type");
      }
      if (paramString.has("c2s_switch")) {
        this.mC2SSwitch = paramString.optInt("c2s_switch");
      }
      parseC2SClickUrl(paramString);
      parseC2SExposureUrl(paramString);
      parseC2SVideoPlayUrl(paramString);
      if (paramString.has("video_play_duration")) {
        this.mC2SReportTriggerTime = paramString.optInt("video_play_duration");
      }
      parsePopFormH5Url(paramString);
      parseShowAdButton(paramString);
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(" processAdExtraDataInfo mAdCorporateImageName = ");
        localStringBuilder.append(this.mAdCorporateImageName);
        localStringBuilder.append(" mAdTraceId = ");
        localStringBuilder.append(this.mAdTraceId);
        localStringBuilder.append("c2s_switch = ");
        localStringBuilder.append(this.mC2SSwitch);
        QLog.d("processAdExtraDataInfo", 2, localStringBuilder.toString());
      }
      if (paramString.has("phone_component_id")) {
        this.mPhoneComponetId = paramString.optInt("phone_component_id");
      }
      if (paramString.has("ecpm")) {
        this.ecpm = paramString.optDouble("ecpm");
      }
      if (paramString.has("isContract")) {
        this.isContract = paramString.optInt("isContract", 0);
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
      this.mImaxStyle = ((IRIJCommonService)QRoute.api(IRIJCommonService.class)).getProteusOfflineBid("sp_key_ad_imax_style");
      if ((this.mImaxShowAdType == 1001) && ("1".equals(this.mImaxStyle))) {
        this.isIMaxAndNewStyle = true;
      }
      this.mCommentAdParams = new CommentAdParams();
      this.mCommentAdParams.jdField_a_of_type_Boolean = paramString.optBoolean("comment_get_ads");
      this.mCommentAdParams.jdField_b_of_type_Boolean = paramString.optBoolean("comment_show_comment");
      this.mCommentAdParams.jdField_c_of_type_Boolean = paramString.optBoolean("comment_button_flag");
      this.mCommentAdParams.jdField_a_of_type_Int = paramString.optInt("comment_card_style");
      this.mCommentAdParams.jdField_b_of_type_Int = paramString.optInt("comment_exposure_time_limit");
      this.mCommentAdParams.jdField_c_of_type_Int = paramString.optInt("comment_exposure_count_limit");
      this.mCommentAdParams.jdField_a_of_type_Long = paramString.optInt("ad_start_time");
      return;
    }
    catch (Exception paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("processAdExtraDataInfo exception ");
      localStringBuilder.append(paramString.toString());
      QLog.e("processAdExtraDataInfo", 1, localStringBuilder.toString());
    }
  }
  
  public void processSoftDataInfo(String paramString)
  {
    this.mAdvertisementSoftInfo = new AdvertisementSoftInfo(paramString);
  }
  
  public void processSoftDataInfo(JSONObject paramJSONObject)
  {
    this.mAdvertisementSoftInfo = new AdvertisementSoftInfo(paramJSONObject);
  }
  
  public void resetClickPos()
  {
    this.clickPos = -1;
  }
  
  public void setAdClickPos(AdClickPos paramAdClickPos)
  {
    this.adClickPos = paramAdClickPos;
  }
  
  public void setClickPos(int paramInt)
  {
    this.clickPos = paramInt;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
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
    paramParcel.writeLong(this.mChannelID);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo
 * JD-Core Version:    0.7.0.1
 */