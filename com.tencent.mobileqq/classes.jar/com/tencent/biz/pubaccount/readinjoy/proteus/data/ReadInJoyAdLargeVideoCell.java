package com.tencent.biz.pubaccount.readinjoy.proteus.data;

import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyDisplayUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import java.net.URL;
import org.json.JSONObject;

public class ReadInJoyAdLargeVideoCell
{
  public static JSONObject a(int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    JSONObject localJSONObject1 = new JSONObject();
    Object localObject = new JSONObject();
    ((JSONObject)localObject).put("large_video_icon", "pa_video_play.png");
    localJSONObject1.put("id_large_video_icon", localObject);
    localObject = new JSONObject();
    ((JSONObject)localObject).put("large_video_cover", "mengceng.png");
    localJSONObject1.put("id_large_video_cover", localObject);
    JSONObject localJSONObject2 = new JSONObject();
    localObject = paramBaseArticleInfo.getVideoCoverUrlWithSmartCut(false);
    if (localObject != null)
    {
      localObject = ((URL)localObject).getFile();
      localJSONObject2.put("article_large_imge_url", localObject);
      localJSONObject1.put("id_article_large_imge", localJSONObject2);
      localJSONObject2 = new JSONObject();
      if ((!AdvertisementInfo.isAdvertisementInfo(paramBaseArticleInfo)) || (((AdvertisementInfo)paramBaseArticleInfo).mImaxShowAdType != 1001) || (paramBaseArticleInfo.mVideoDuration != 0)) {
        break label346;
      }
    }
    label346:
    for (localObject = "";; localObject = ReadInJoyDisplayUtils.a(paramBaseArticleInfo.mVideoDuration))
    {
      localJSONObject2.put("large_video_duration", localObject);
      localJSONObject1.put("id_large_video_duration", localJSONObject2);
      localObject = new JSONObject();
      ((JSONObject)localObject).put("video_play_icon", "video_play_icon");
      localJSONObject1.put("id_video_play_icon", localObject);
      localJSONObject1.put("id_video_paly_text", new JSONObject());
      if (!ReadInJoyAdUtils.b(paramBaseArticleInfo)) {
        break label357;
      }
      ReadInJoyAdUtils.f(paramBaseArticleInfo, localJSONObject1);
      localJSONObject1.put("id_large_video_activity_wrapper", new JSONObject());
      localObject = new JSONObject();
      ((JSONObject)localObject).put("activity_img_path", "free_netflow_icon");
      localJSONObject1.put("id_large_video_activity_img", localObject);
      localJSONObject1.put("id_large_video_activity_label", new JSONObject());
      localJSONObject1.put("id_view_Ad_CompleteGudie", new JSONObject());
      localJSONObject1.put("id_video_cell_container", new JSONObject());
      Util.a(localJSONObject1, paramBaseArticleInfo);
      ReadInJoyAdUtils.g(paramBaseArticleInfo, localJSONObject1);
      Util.n(paramBaseArticleInfo, localJSONObject1);
      Util.g(paramBaseArticleInfo, localJSONObject1);
      ReadInJoyAdUtils.c(paramBaseArticleInfo, localJSONObject1);
      ReadInJoyAdUtils.e(paramBaseArticleInfo, localJSONObject1);
      return localJSONObject1;
      localObject = null;
      break;
    }
    label357:
    if ((((AdvertisementInfo)paramBaseArticleInfo).isIMaxAndNewStyle) && (paramInt == 115))
    {
      paramInt = 1;
      label375:
      if (paramInt != 0) {
        break label519;
      }
    }
    label519:
    for (boolean bool = true;; bool = false)
    {
      Util.a(paramBaseArticleInfo, localJSONObject1, bool, "3");
      if (AdvertisementInfo.isAdvertisementInfo(paramBaseArticleInfo))
      {
        Util.f(paramBaseArticleInfo, localJSONObject1);
        localObject = new JSONObject();
        ((JSONObject)localObject).put("article_model", paramBaseArticleInfo);
        if (((AdvertisementInfo)paramBaseArticleInfo).mShowAdButton) {
          localJSONObject1.put("id_view_AdDownloadView", localObject);
        }
        if (!TextUtils.isEmpty(((AdvertisementInfo)paramBaseArticleInfo).mImaxImg))
        {
          localObject = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = true;
          ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = new ColorDrawable(-16777216);
          localObject = URLDrawable.getDrawable(((AdvertisementInfo)paramBaseArticleInfo).mImaxImg, (URLDrawable.URLDrawableOptions)localObject);
          if (localObject != null) {
            ((URLDrawable)localObject).startDownload();
          }
        }
      }
      ReadInJoyAdUtils.a(paramBaseArticleInfo, localJSONObject1);
      ReadInJoyAdUtils.i(paramBaseArticleInfo, localJSONObject1);
      ReadInJoyAdUtils.h(paramBaseArticleInfo, localJSONObject1);
      break;
      paramInt = 0;
      break label375;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.data.ReadInJoyAdLargeVideoCell
 * JD-Core Version:    0.7.0.1
 */