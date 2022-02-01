package com.tencent.biz.pubaccount.readinjoy.proteus.data;

import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.json.RIJR5JsonManager;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.util.FluencyOptUtils;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;

public class ReadInjoyTripleImgCell
{
  public static JSONObject a(BaseArticleInfo paramBaseArticleInfo)
  {
    Object localObject3 = null;
    JSONObject localJSONObject = new JSONObject();
    Util.a(paramBaseArticleInfo, localJSONObject, true);
    Util.a(paramBaseArticleInfo, localJSONObject);
    Util.d(paramBaseArticleInfo, localJSONObject);
    Util.n(paramBaseArticleInfo, localJSONObject);
    Util.g(paramBaseArticleInfo, localJSONObject);
    Util.h(paramBaseArticleInfo, localJSONObject);
    Util.ab(paramBaseArticleInfo, localJSONObject);
    Util.ae(paramBaseArticleInfo, localJSONObject);
    Util.af(paramBaseArticleInfo, localJSONObject);
    Util.ap(paramBaseArticleInfo, localJSONObject);
    localJSONObject.put("style_ID", "ReadInjoy_triple_img_cell");
    Util.a(localJSONObject, paramBaseArticleInfo);
    Object localObject1;
    Object localObject2;
    label158:
    Object localObject4;
    if ((paramBaseArticleInfo.mPictures == null) || (paramBaseArticleInfo.mPictures.length <= 0))
    {
      localObject3 = RIJR5JsonManager.a(paramBaseArticleInfo.mJsonPictureList, "pictures");
      if ((localObject3 == null) || (((JSONArray)localObject3).length() < 3)) {
        return localJSONObject;
      }
      localObject1 = ((JSONArray)localObject3).optJSONObject(0);
      if (localObject1 == null)
      {
        localObject1 = paramBaseArticleInfo.mFirstPagePicUrl;
        localObject2 = ((JSONArray)localObject3).optJSONObject(1);
        if (localObject2 != null) {
          break label289;
        }
        localObject2 = paramBaseArticleInfo.mFirstPagePicUrl;
        localObject3 = ((JSONArray)localObject3).optJSONObject(2);
        if (localObject3 != null) {
          break label299;
        }
      }
      label289:
      label299:
      for (paramBaseArticleInfo = paramBaseArticleInfo.mFirstPagePicUrl;; paramBaseArticleInfo = ((JSONObject)localObject3).optString("picture"))
      {
        localObject3 = localObject2;
        localObject4 = localObject1;
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("multi_img_url1", localObject4);
        FluencyOptUtils.a.a(localObject4);
        localJSONObject.put("id_multi_img_1", localObject1);
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("multi_img_url2", localObject3);
        FluencyOptUtils.a.a((String)localObject3);
        localJSONObject.put("id_multi_img_2", localObject1);
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("multi_img_url3", paramBaseArticleInfo);
        FluencyOptUtils.a.a(paramBaseArticleInfo);
        localJSONObject.put("id_multi_img_3", localObject1);
        return localJSONObject;
        localObject1 = ((JSONObject)localObject1).optString("picture");
        break;
        localObject2 = ((JSONObject)localObject2).optString("picture");
        break label158;
      }
    }
    if ((paramBaseArticleInfo.mPictures.length < 1) || (paramBaseArticleInfo.mPictures[0] == null))
    {
      localObject1 = paramBaseArticleInfo.mSinglePicture;
      label332:
      if (localObject1 == null) {
        break label433;
      }
      localObject1 = ((URL)localObject1).getFile();
      label341:
      if ((paramBaseArticleInfo.mPictures.length >= 2) && (paramBaseArticleInfo.mPictures[1] != null)) {
        break label438;
      }
      localObject2 = paramBaseArticleInfo.mSinglePicture;
      label364:
      if (localObject2 == null) {
        break label448;
      }
      localObject2 = ((URL)localObject2).getFile();
      label373:
      if ((paramBaseArticleInfo.mPictures.length >= 3) && (paramBaseArticleInfo.mPictures[2] != null)) {
        break label453;
      }
    }
    label433:
    label438:
    label448:
    label453:
    for (URL localURL = paramBaseArticleInfo.mSinglePicture;; localURL = paramBaseArticleInfo.mPictures[2])
    {
      localObject4 = localObject1;
      paramBaseArticleInfo = (BaseArticleInfo)localObject3;
      localObject3 = localObject2;
      if (localURL == null) {
        break;
      }
      paramBaseArticleInfo = localURL.getFile();
      localObject4 = localObject1;
      localObject3 = localObject2;
      break;
      localObject1 = paramBaseArticleInfo.mPictures[0];
      break label332;
      localObject1 = null;
      break label341;
      localObject2 = paramBaseArticleInfo.mPictures[1];
      break label364;
      localObject2 = null;
      break label373;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.data.ReadInjoyTripleImgCell
 * JD-Core Version:    0.7.0.1
 */