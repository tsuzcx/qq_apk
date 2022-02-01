package com.tencent.biz.pubaccount.readinjoyAd.ad.jump.liujin;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdvertisementSoftInfo;
import org.json.JSONObject;

 enum LiujinAdJump$1
{
  LiujinAdJump$1()
  {
    super(str, i, null);
  }
  
  protected LiujinAdJump parseJumpData(AdvertisementInfo paramAdvertisementInfo)
  {
    paramAdvertisementInfo = paramAdvertisementInfo.mAdvertisementSoftInfo;
    this.jumpType = LiujinAdJump.access$100(paramAdvertisementInfo);
    this.violaUrl = paramAdvertisementInfo.f;
    this.webViewUrl = paramAdvertisementInfo.f;
    this.qqMiniProSchema = paramAdvertisementInfo.h;
    this.downloadJumpUrl = paramAdvertisementInfo.f;
    this.deepLinkUrl = paramAdvertisementInfo.f;
    this.packageName = paramAdvertisementInfo.o;
    paramAdvertisementInfo = new JSONObject(paramAdvertisementInfo.n).optString("ads_ext");
    if (!TextUtils.isEmpty(paramAdvertisementInfo))
    {
      paramAdvertisementInfo = new JSONObject(paramAdvertisementInfo);
      this.wxAppId = paramAdvertisementInfo.optString("wxappid");
      this.wxAppPath = paramAdvertisementInfo.optString("wechat_app_path");
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.jump.liujin.LiujinAdJump.1
 * JD-Core Version:    0.7.0.1
 */