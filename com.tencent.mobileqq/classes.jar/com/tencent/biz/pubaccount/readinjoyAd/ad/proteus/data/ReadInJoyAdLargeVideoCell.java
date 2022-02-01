package com.tencent.biz.pubaccount.readinjoyAd.ad.proteus.data;

import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.base.utils.api.IReadInJoyDisplayUtils;
import com.tencent.mobileqq.kandian.biz.pts.api.IReadInJoyProteusBindUtil;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.qroute.QRoute;
import java.net.URL;
import org.json.JSONObject;

public class ReadInJoyAdLargeVideoCell
{
  public static JSONObject a(int paramInt, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    JSONObject localJSONObject = new JSONObject();
    Object localObject1 = new JSONObject();
    ((JSONObject)localObject1).put("large_video_icon", "pa_video_play.png");
    localJSONObject.put("id_large_video_icon", localObject1);
    localObject1 = new JSONObject();
    ((JSONObject)localObject1).put("large_video_cover", "mengceng.png");
    localJSONObject.put("id_large_video_cover", localObject1);
    Object localObject2 = new JSONObject();
    int j = 0;
    localObject1 = paramAbsBaseArticleInfo.getVideoCoverUrlWithSmartCut(false);
    if (localObject1 != null) {
      localObject1 = ((URL)localObject1).getFile();
    } else {
      localObject1 = null;
    }
    ((JSONObject)localObject2).put("article_large_imge_url", localObject1);
    localJSONObject.put("id_article_large_imge", localObject2);
    localObject2 = new JSONObject();
    if ((((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdvertisementInfo(paramAbsBaseArticleInfo)) && (((AdvertisementInfo)paramAbsBaseArticleInfo).mImaxShowAdType == 1001) && (paramAbsBaseArticleInfo.mVideoDuration == 0)) {
      localObject1 = "";
    } else {
      localObject1 = ((IReadInJoyDisplayUtils)QRoute.api(IReadInJoyDisplayUtils.class)).getDisplayDuration(paramAbsBaseArticleInfo.mVideoDuration);
    }
    ((JSONObject)localObject2).put("large_video_duration", localObject1);
    localJSONObject.put("id_large_video_duration", localObject2);
    localObject1 = new JSONObject();
    ((JSONObject)localObject1).put("video_play_icon", "video_play_icon");
    localJSONObject.put("id_video_play_icon", localObject1);
    localJSONObject.put("id_video_paly_text", new JSONObject());
    if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isEducationLargeVideoAd(paramAbsBaseArticleInfo))
    {
      ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).bindEducationAd(paramAbsBaseArticleInfo, localJSONObject);
    }
    else
    {
      localObject1 = (AdvertisementInfo)paramAbsBaseArticleInfo;
      int i = j;
      if (((AdvertisementInfo)localObject1).isIMaxAndNewStyle)
      {
        i = j;
        if (paramInt == 115) {
          i = 1;
        }
      }
      ((IReadInJoyProteusBindUtil)QRoute.api(IReadInJoyProteusBindUtil.class)).bindTitle(paramAbsBaseArticleInfo, localJSONObject, i ^ 0x1, "3");
      if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdvertisementInfo(paramAbsBaseArticleInfo))
      {
        ((IReadInJoyProteusBindUtil)QRoute.api(IReadInJoyProteusBindUtil.class)).bindADBanner(paramAbsBaseArticleInfo, localJSONObject);
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("article_model", paramAbsBaseArticleInfo);
        if (((AdvertisementInfo)localObject1).mShowAdButton) {
          localJSONObject.put("id_view_AdDownloadView", localObject2);
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
      ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).bindSourceText(paramAbsBaseArticleInfo, localJSONObject);
      ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).bindDownloadAdStar(paramAbsBaseArticleInfo, localJSONObject);
      ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).bindAdColorIcon(paramAbsBaseArticleInfo, localJSONObject);
      ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).bindBubble(paramAbsBaseArticleInfo, localJSONObject);
    }
    localJSONObject.put("id_large_video_activity_wrapper", new JSONObject());
    localObject1 = new JSONObject();
    ((JSONObject)localObject1).put("activity_img_path", "free_netflow_icon");
    localJSONObject.put("id_large_video_activity_img", localObject1);
    localJSONObject.put("id_large_video_activity_label", new JSONObject());
    localJSONObject.put("id_view_Ad_CompleteGudie", new JSONObject());
    localJSONObject.put("id_video_cell_container", new JSONObject());
    ((IReadInJoyProteusBindUtil)QRoute.api(IReadInJoyProteusBindUtil.class)).addProteusDynamicData(localJSONObject, paramAbsBaseArticleInfo);
    ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).bindAdStatus(paramAbsBaseArticleInfo, localJSONObject);
    ((IReadInJoyProteusBindUtil)QRoute.api(IReadInJoyProteusBindUtil.class)).bindSeparator(paramAbsBaseArticleInfo, localJSONObject);
    ((IReadInJoyProteusBindUtil)QRoute.api(IReadInJoyProteusBindUtil.class)).bindDislikeButton(paramAbsBaseArticleInfo, localJSONObject);
    ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).bindAtmosphere(paramAbsBaseArticleInfo, localJSONObject);
    ReadInJoyAdUtils.k(paramAbsBaseArticleInfo, localJSONObject);
    ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).bindVideoStyleID(paramAbsBaseArticleInfo, localJSONObject);
    return localJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.proteus.data.ReadInJoyAdLargeVideoCell
 * JD-Core Version:    0.7.0.1
 */