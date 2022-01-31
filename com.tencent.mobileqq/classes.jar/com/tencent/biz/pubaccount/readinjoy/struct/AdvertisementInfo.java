package com.tencent.biz.pubaccount.readinjoy.struct;

import android.os.Parcelable.Creator;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.AdInfo;
import tencent.im.oidb.cmd0x886.oidb_cmd0x886.AdInfo;

public class AdvertisementInfo
  extends ArticleInfo
{
  public static final int APP_STATE_DOWNLOAD = 0;
  public static final int APP_STATE_OPEN = 1;
  public static final Parcelable.Creator CREATOR = makeArticleInfoCreator();
  public static final int PRODUCT_TYPE_APP = 12;
  public static final String TABLE_NAME = AdvertisementInfo.class.getSimpleName();
  public long mAdAid;
  public String mAdAppJson;
  public String mAdApurl;
  public String mAdBtnTxt;
  public String mAdCl;
  public String mAdCorporateImageName;
  public String mAdCorporateLogo;
  public String mAdCorporationName;
  public int mAdCostType;
  public String mAdCustomizedInvokeUrl;
  public String mAdDesc;
  public String mAdExt;
  public long mAdFetchTime;
  public String mAdImg;
  public String mAdImgs;
  public int mAdJumpMode;
  public int mAdKdPos;
  public String mAdLandingPage;
  public int mAdLayout;
  public int mAdMaterialId;
  public long mAdPosID;
  public int mAdPosLayout;
  public String mAdPrice;
  public String mAdProductId;
  public int mAdProductType;
  public String mAdRl;
  public String mAdTraceId;
  public String mAdTxt;
  public int mAdType;
  public long mAdUin;
  public String mAdVideoUrl;
  public String mAdViewId;
  
  public AdvertisementInfo() {}
  
  public AdvertisementInfo(oidb_cmd0x68b.AdInfo paramAdInfo)
  {
    this.mAdKdPos = paramAdInfo.int32_kd_pos.get();
    this.mAdCl = paramAdInfo.bytes_cl.get().toStringUtf8();
    this.mAdImg = paramAdInfo.bytes_img.get().toStringUtf8();
    this.mAdImgs = paramAdInfo.bytes_img_s.get().toStringUtf8();
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
    this.mAdVideoUrl = paramAdInfo.bytes_video_url.get().toStringUtf8();
    this.mAdCostType = paramAdInfo.uint32_cost_type.get();
    this.mAdAid = paramAdInfo.uint64_aid.get();
    this.mAdLayout = paramAdInfo.enum_ad_layout.get();
    this.mAdMaterialId = paramAdInfo.uint32_ad_material_id.get();
    this.mAdJumpMode = paramAdInfo.enum_ad_jump_mode.get();
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo
 * JD-Core Version:    0.7.0.1
 */