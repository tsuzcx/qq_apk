package com.tencent.biz.pubaccount.readinjoyAd.ad.jump.liujin;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import org.json.JSONObject;

 enum LiujinAdJump$2
{
  LiujinAdJump$2()
  {
    super(str, i, null);
  }
  
  protected LiujinAdJump parseJumpData(AdvertisementInfo paramAdvertisementInfo)
  {
    this.jumpType = LiujinAdJump.access$200(paramAdvertisementInfo);
    this.violaUrl = paramAdvertisementInfo.mAdLandingPage;
    this.webViewUrl = paramAdvertisementInfo.mAdLandingPage;
    this.qqMiniProSchema = paramAdvertisementInfo.mAdLandingPage;
    this.downloadJumpUrl = paramAdvertisementInfo.mAdLandingPage;
    this.deepLinkUrl = paramAdvertisementInfo.mAdLandingPage;
    this.packageName = new JSONObject(paramAdvertisementInfo.mAdExt).optString("pkg_name");
    try
    {
      paramAdvertisementInfo = paramAdvertisementInfo.mAdExtInfo;
      if (!TextUtils.isEmpty(paramAdvertisementInfo))
      {
        paramAdvertisementInfo = new JSONObject(paramAdvertisementInfo);
        this.wxAppId = paramAdvertisementInfo.optString("wxappid");
        this.wxAppPath = paramAdvertisementInfo.optString("wechat_app_path");
      }
      return this;
    }
    catch (Throwable paramAdvertisementInfo) {}
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.jump.liujin.LiujinAdJump.2
 * JD-Core Version:    0.7.0.1
 */