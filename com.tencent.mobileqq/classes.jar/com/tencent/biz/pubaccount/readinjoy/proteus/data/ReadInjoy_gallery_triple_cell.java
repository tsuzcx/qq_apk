package com.tencent.biz.pubaccount.readinjoy.proteus.data;

import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;

public class ReadInjoy_gallery_triple_cell
{
  public static JSONObject a(BaseArticleInfo paramBaseArticleInfo)
  {
    JSONObject localJSONObject = new JSONObject();
    Object localObject1 = new JSONObject();
    ((JSONObject)localObject1).put("gallery_cn_text", paramBaseArticleInfo.mGalleryPicNumber + "图");
    localJSONObject.put("id_gallery_cnt", localObject1);
    localObject1 = new JSONObject();
    ((JSONObject)localObject1).put("gallery_icon", "qq_readinjoy_gallery_count");
    localJSONObject.put("id_gallery_img", localObject1);
    localJSONObject.put("id_gallery_bg", new JSONObject());
    Object localObject3;
    Object localObject2;
    label166:
    Object localObject4;
    if ((paramBaseArticleInfo.mPictures == null) || (paramBaseArticleInfo.mPictures.length <= 0))
    {
      localObject3 = ReadInJoyBaseAdapter.a(paramBaseArticleInfo.mJsonPictureList, "pictures");
      if ((localObject3 == null) || (((JSONArray)localObject3).length() < 3)) {
        return localJSONObject;
      }
      localObject1 = ((JSONArray)localObject3).optJSONObject(0);
      if (localObject1 == null)
      {
        localObject1 = paramBaseArticleInfo.mFirstPagePicUrl;
        localObject2 = ((JSONArray)localObject3).optJSONObject(1);
        if (localObject2 != null) {
          break label319;
        }
        localObject2 = paramBaseArticleInfo.mFirstPagePicUrl;
        localObject3 = ((JSONArray)localObject3).optJSONObject(2);
        if (localObject3 != null) {
          break label329;
        }
      }
      label319:
      label329:
      for (localObject3 = paramBaseArticleInfo.mFirstPagePicUrl;; localObject3 = ((JSONObject)localObject3).optString("picture"))
      {
        localObject4 = new JSONObject();
        ((JSONObject)localObject4).put("multi_img_url1", localObject1);
        localJSONObject.put("id_multi_img_1", localObject4);
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("multi_img_url2", localObject2);
        localJSONObject.put("id_multi_img_2", localObject1);
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("multi_img_url3", localObject3);
        localJSONObject.put("id_multi_img_3", localObject1);
        Util.a(paramBaseArticleInfo, localJSONObject, true);
        Util.a(paramBaseArticleInfo, localJSONObject);
        Util.b(paramBaseArticleInfo, localJSONObject);
        Util.e(paramBaseArticleInfo, localJSONObject);
        Util.d(paramBaseArticleInfo, localJSONObject);
        localJSONObject.put("style_ID", "ReadInjoy_triple_img_cell");
        Util.a(localJSONObject, paramBaseArticleInfo);
        return localJSONObject;
        localObject1 = ((JSONObject)localObject1).optString("picture");
        break;
        localObject2 = ((JSONObject)localObject2).optString("picture");
        break label166;
      }
    }
    if ((paramBaseArticleInfo.mPictures.length < 1) || (paramBaseArticleInfo.mPictures[0] == null))
    {
      localObject1 = paramBaseArticleInfo.mSinglePicture;
      label362:
      localObject2 = ((URL)localObject1).getPath();
      if ((paramBaseArticleInfo.mPictures.length >= 2) && (paramBaseArticleInfo.mPictures[1] != null)) {
        break label444;
      }
      localObject1 = paramBaseArticleInfo.mSinglePicture;
      label390:
      localObject3 = ((URL)localObject1).getPath();
      if ((paramBaseArticleInfo.mPictures.length >= 3) && (paramBaseArticleInfo.mPictures[2] != null)) {
        break label454;
      }
    }
    label444:
    label454:
    for (localObject1 = paramBaseArticleInfo.mSinglePicture;; localObject1 = paramBaseArticleInfo.mPictures[2])
    {
      localObject4 = ((URL)localObject1).getPath();
      localObject1 = localObject2;
      localObject2 = localObject3;
      localObject3 = localObject4;
      break;
      localObject1 = paramBaseArticleInfo.mPictures[0];
      break label362;
      localObject1 = paramBaseArticleInfo.mPictures[1];
      break label390;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.data.ReadInjoy_gallery_triple_cell
 * JD-Core Version:    0.7.0.1
 */