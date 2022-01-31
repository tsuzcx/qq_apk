package com.tencent.biz.pubaccount.readinjoy.proteus.data;

import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyDisplayUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import java.net.URL;
import org.json.JSONObject;

public class ReadInjoy_large_video_cell
{
  public static JSONObject a(BaseArticleInfo paramBaseArticleInfo)
  {
    JSONObject localJSONObject1 = new JSONObject();
    Object localObject = new JSONObject();
    ((JSONObject)localObject).put("large_video_icon", "pa_video_play.png");
    localJSONObject1.put("id_large_video_icon", localObject);
    localObject = new JSONObject();
    ((JSONObject)localObject).put("large_video_cover", "mengceng.png");
    localJSONObject1.put("id_large_video_cover", localObject);
    JSONObject localJSONObject2 = new JSONObject();
    if (paramBaseArticleInfo.mVideoCoverUrl != null)
    {
      localObject = paramBaseArticleInfo.mVideoCoverUrl;
      if (localObject == null) {
        break label227;
      }
    }
    label227:
    for (localObject = ((URL)localObject).getPath();; localObject = null)
    {
      localJSONObject2.put("article_large_imge_url", localObject);
      localJSONObject1.put("id_article_large_imge", localJSONObject2);
      localObject = new JSONObject();
      ((JSONObject)localObject).put("large_video_duration", ReadInJoyDisplayUtils.a(paramBaseArticleInfo.mVideoDuration));
      localJSONObject1.put("id_large_video_duration", localObject);
      localObject = new JSONObject();
      ((JSONObject)localObject).put("video_play_icon", "small_video_play_icon");
      localJSONObject1.put("id_video_play_icon", localObject);
      localJSONObject1.put("id_video_paly_text", new JSONObject());
      Util.a(paramBaseArticleInfo, localJSONObject1, true);
      Util.a(paramBaseArticleInfo, localJSONObject1);
      Util.b(paramBaseArticleInfo, localJSONObject1);
      Util.c(paramBaseArticleInfo, localJSONObject1);
      Util.e(paramBaseArticleInfo, localJSONObject1);
      Util.d(paramBaseArticleInfo, localJSONObject1);
      localJSONObject1.put("style_ID", "ReadInjoy_large_cell");
      Util.a(localJSONObject1, paramBaseArticleInfo);
      return localJSONObject1;
      localObject = paramBaseArticleInfo.mSinglePicture;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.data.ReadInjoy_large_video_cell
 * JD-Core Version:    0.7.0.1
 */