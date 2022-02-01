package com.tencent.biz.pubaccount.readinjoyAd.ad.proteus.data;

import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdvertisementExtInfo;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.biz.pts.api.IReadInJoyProteusBindUtil;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.qroute.QRoute;
import java.net.URL;
import org.json.JSONObject;

public class ReadInjoyAdExpandLiveCell
{
  public static JSONObject a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    JSONObject localJSONObject1 = new JSONObject();
    Object localObject2 = new JSONObject();
    Object localObject1;
    if (paramAbsBaseArticleInfo.mSinglePicture != null) {
      localObject1 = paramAbsBaseArticleInfo.mSinglePicture.getFile();
    } else {
      localObject1 = null;
    }
    ((JSONObject)localObject2).put("article_large_imge_url", localObject1);
    ((JSONObject)localObject2).put("article_model", paramAbsBaseArticleInfo);
    localJSONObject1.put("id_article_double_image", localObject2);
    localObject2 = new JSONObject();
    ((JSONObject)localObject2).put("article_large_imge_url", localObject1);
    localJSONObject1.put("id_article_large_imge", localObject2);
    if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isEducationLargeImgAd(paramAbsBaseArticleInfo))
    {
      ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).bindEducationAd(paramAbsBaseArticleInfo, localJSONObject1);
    }
    else
    {
      if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdvertisementInfo(paramAbsBaseArticleInfo))
      {
        ((IReadInJoyProteusBindUtil)QRoute.api(IReadInJoyProteusBindUtil.class)).bindADBanner(paramAbsBaseArticleInfo, localJSONObject1);
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("article_model", paramAbsBaseArticleInfo);
        localObject1 = (AdvertisementInfo)paramAbsBaseArticleInfo;
        if (((AdvertisementInfo)localObject1).mShowAdButton) {
          localJSONObject1.put("id_view_AdDownloadView", localObject2);
        }
        if (!TextUtils.isEmpty(((AdvertisementInfo)localObject1).mImaxImg))
        {
          localObject2 = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject2).mPlayGifImage = true;
          ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = new ColorDrawable(-16777216);
          localObject1 = URLDrawable.getDrawable(((AdvertisementInfo)localObject1).mImaxImg, (URLDrawable.URLDrawableOptions)localObject2);
          if (localObject1 != null) {
            ((URLDrawable)localObject1).startDownload();
          }
        }
      }
      ((IReadInJoyProteusBindUtil)QRoute.api(IReadInJoyProteusBindUtil.class)).bindTitle(paramAbsBaseArticleInfo, localJSONObject1, true, "3");
      ((IReadInJoyProteusBindUtil)QRoute.api(IReadInJoyProteusBindUtil.class)).bindADPositionInfo(paramAbsBaseArticleInfo, localJSONObject1);
      ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).bindSourceText(paramAbsBaseArticleInfo, localJSONObject1);
      ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).bindDownloadAdStar(paramAbsBaseArticleInfo, localJSONObject1);
      if (!((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).hasColorIcon(paramAbsBaseArticleInfo)) {
        ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).bindAdSourceTag(paramAbsBaseArticleInfo, localJSONObject1);
      } else {
        ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).bindAdColorIcon(paramAbsBaseArticleInfo, localJSONObject1);
      }
      ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).bindBubble(paramAbsBaseArticleInfo, localJSONObject1);
      ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).bindAtmosphere(paramAbsBaseArticleInfo, localJSONObject1);
      ((IReadInJoyProteusBindUtil)QRoute.api(IReadInJoyProteusBindUtil.class)).addProteusDynamicData(localJSONObject1, paramAbsBaseArticleInfo);
    }
    ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).bindAdStatus(paramAbsBaseArticleInfo, localJSONObject1);
    ((IReadInJoyProteusBindUtil)QRoute.api(IReadInJoyProteusBindUtil.class)).bindSeparator(paramAbsBaseArticleInfo, localJSONObject1);
    ((IReadInJoyProteusBindUtil)QRoute.api(IReadInJoyProteusBindUtil.class)).bindDislikeButton(paramAbsBaseArticleInfo, localJSONObject1);
    if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdvertisementInfo(paramAbsBaseArticleInfo))
    {
      localObject1 = (AdvertisementInfo)paramAbsBaseArticleInfo;
      localObject2 = ((AdvertisementInfo)localObject1).mTitle;
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("article_model", paramAbsBaseArticleInfo);
      localJSONObject1.put("id_ad_expand_back", localJSONObject2);
      paramAbsBaseArticleInfo = new JSONObject();
      paramAbsBaseArticleInfo.put("close_image_url", "https://img.nfa.qq.com/gmaster_prod/16104096/gmaster_b5gbv9fgqyg_adtagclose.png");
      localJSONObject1.put("id_ad_tag_view", paramAbsBaseArticleInfo);
      paramAbsBaseArticleInfo = new JSONObject();
      paramAbsBaseArticleInfo.put("close_image_url", "https://img.nfa.qq.com/gmaster_prod/16104096/gmaster_b5gbv9fgqyg_adtagclose.png");
      localJSONObject1.put("id_ad_tag_small_view", paramAbsBaseArticleInfo);
      paramAbsBaseArticleInfo = new JSONObject();
      paramAbsBaseArticleInfo.put("small_title", localObject2);
      localJSONObject1.put("id_small_title", paramAbsBaseArticleInfo);
      paramAbsBaseArticleInfo = new JSONObject();
      paramAbsBaseArticleInfo.put("bottom_title", localObject2);
      localJSONObject1.put("id_bottom_title", paramAbsBaseArticleInfo);
      paramAbsBaseArticleInfo = new JSONObject();
      paramAbsBaseArticleInfo.put("caption_text", ((AdvertisementInfo)localObject1).mAdvertisementExtInfo.i);
      localJSONObject1.put("id_ad_left_bottom_wenzi_back", paramAbsBaseArticleInfo);
      paramAbsBaseArticleInfo = new JSONObject();
      paramAbsBaseArticleInfo.put("caption_text", ((AdvertisementInfo)localObject1).mAdvertisementExtInfo.i);
      localJSONObject1.put("id_ad_left_bottom_wenzi_back_small", paramAbsBaseArticleInfo);
      paramAbsBaseArticleInfo = new JSONObject();
      paramAbsBaseArticleInfo.put("fu_title", ((AdvertisementInfo)localObject1).mAdDesc);
      localJSONObject1.put("id_ad_fu_title_text", paramAbsBaseArticleInfo);
      paramAbsBaseArticleInfo = new JSONObject();
      paramAbsBaseArticleInfo.put("fu_title", ((AdvertisementInfo)localObject1).mAdDesc);
      localJSONObject1.put("id_ad_fu_title_small_text", paramAbsBaseArticleInfo);
      paramAbsBaseArticleInfo = new JSONObject();
      paramAbsBaseArticleInfo.put("small_img_url", ((AdvertisementInfo)localObject1).mAdvertisementExtInfo.j);
      localJSONObject1.put("id_ad_zhibo_small", paramAbsBaseArticleInfo);
      paramAbsBaseArticleInfo = new JSONObject();
      paramAbsBaseArticleInfo.put("large_video_icon", "pa_video_play.png");
      localJSONObject1.put("id_large_video_icon", paramAbsBaseArticleInfo);
    }
    localJSONObject1.put("style_ID", "ReadInjoy_ad_live_expand_card_cell");
    return localJSONObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.proteus.data.ReadInjoyAdExpandLiveCell
 * JD-Core Version:    0.7.0.1
 */