package com.tencent.biz.pubaccount.readinjoy.proteus.data;

import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.json.RIJR5JsonManager;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;

public class ReadInJoyGalleryChannelDoubleCell
{
  public static JSONObject a(BaseArticleInfo paramBaseArticleInfo)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramBaseArticleInfo.mGalleryPicNumber > 2)
    {
      localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("gallery_cn_text", paramBaseArticleInfo.mGalleryPicNumber + HardCodeUtil.a(2131712934));
      localJSONObject.put("id_gallery_cnt", localObject1);
      localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("gallery_icon", "qq_readinjoy_gallery_count");
      localJSONObject.put("id_gallery_img", localObject1);
      localJSONObject.put("id_gallery_bg", new JSONObject());
    }
    Object localObject2;
    Object localObject3;
    if ((paramBaseArticleInfo.mPictures == null) || (paramBaseArticleInfo.mPictures.length <= 0))
    {
      localObject2 = RIJR5JsonManager.a(paramBaseArticleInfo.mJsonPictureList, "pictures");
      if ((localObject2 == null) || (((JSONArray)localObject2).length() < 2)) {
        return localJSONObject;
      }
      localObject1 = ((JSONArray)localObject2).optJSONObject(0);
      if (localObject1 == null)
      {
        localObject1 = paramBaseArticleInfo.mFirstPagePicUrl;
        localObject2 = ((JSONArray)localObject2).optJSONObject(1);
        if (localObject2 != null) {
          break label280;
        }
      }
      label280:
      for (localObject2 = paramBaseArticleInfo.mFirstPagePicUrl;; localObject2 = ((JSONObject)localObject2).optString("picture"))
      {
        localObject3 = new JSONObject();
        ((JSONObject)localObject3).put("multi_img_url1", localObject1);
        localJSONObject.put("id_multi_img_1", localObject3);
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("multi_img_url2", localObject2);
        localJSONObject.put("id_multi_img_2", localObject1);
        Util.a(paramBaseArticleInfo, localJSONObject, true);
        Util.n(paramBaseArticleInfo, localJSONObject);
        Util.k(paramBaseArticleInfo, localJSONObject);
        Util.a(localJSONObject);
        localJSONObject.put("style_ID", "ReadInjoy_gallery_channel_double_img_cell");
        Util.a(localJSONObject, paramBaseArticleInfo);
        return localJSONObject;
        localObject1 = ((JSONObject)localObject1).optString("picture");
        break;
      }
    }
    if ((paramBaseArticleInfo.mPictures.length < 1) || (paramBaseArticleInfo.mPictures[0] == null))
    {
      localObject1 = paramBaseArticleInfo.mSinglePicture;
      label313:
      localObject2 = ((URL)localObject1).getFile();
      if ((paramBaseArticleInfo.mPictures.length >= 2) && (paramBaseArticleInfo.mPictures[1] != null)) {
        break label363;
      }
    }
    label363:
    for (Object localObject1 = paramBaseArticleInfo.mSinglePicture;; localObject1 = paramBaseArticleInfo.mPictures[1])
    {
      localObject3 = ((URL)localObject1).getFile();
      localObject1 = localObject2;
      localObject2 = localObject3;
      break;
      localObject1 = paramBaseArticleInfo.mPictures[0];
      break label313;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.data.ReadInJoyGalleryChannelDoubleCell
 * JD-Core Version:    0.7.0.1
 */