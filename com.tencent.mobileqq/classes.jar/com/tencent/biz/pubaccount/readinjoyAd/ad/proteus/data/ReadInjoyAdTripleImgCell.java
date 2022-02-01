package com.tencent.biz.pubaccount.readinjoyAd.ad.proteus.data;

import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.base.utils.api.IRIJR5JsonManager;
import com.tencent.mobileqq.kandian.biz.pts.api.IReadInJoyProteusBindUtil;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.qroute.QRoute;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;

public class ReadInjoyAdTripleImgCell
{
  public static JSONObject a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    JSONObject localJSONObject = new JSONObject();
    ((IReadInJoyProteusBindUtil)QRoute.api(IReadInJoyProteusBindUtil.class)).bindTitle(paramAbsBaseArticleInfo, localJSONObject, true);
    ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).bindAdStatus(paramAbsBaseArticleInfo, localJSONObject);
    ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).bindSourceText(paramAbsBaseArticleInfo, localJSONObject);
    ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).bindDownloadAdStar(paramAbsBaseArticleInfo, localJSONObject);
    ((IReadInJoyProteusBindUtil)QRoute.api(IReadInJoyProteusBindUtil.class)).bindSeparator(paramAbsBaseArticleInfo, localJSONObject);
    ((IReadInJoyProteusBindUtil)QRoute.api(IReadInJoyProteusBindUtil.class)).bindDislikeButton(paramAbsBaseArticleInfo, localJSONObject);
    ((IReadInJoyProteusBindUtil)QRoute.api(IReadInJoyProteusBindUtil.class)).bindCommentNumText(paramAbsBaseArticleInfo, localJSONObject);
    ((IReadInJoyProteusBindUtil)QRoute.api(IReadInJoyProteusBindUtil.class)).bindAdPositionInfoNew(paramAbsBaseArticleInfo, localJSONObject);
    ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).bindAdColorIcon(paramAbsBaseArticleInfo, localJSONObject);
    localJSONObject.put("style_ID", "ReadInjoy_ad_triple_img_cell");
    ((IReadInJoyProteusBindUtil)QRoute.api(IReadInJoyProteusBindUtil.class)).addProteusDynamicData(localJSONObject, paramAbsBaseArticleInfo);
    Object localObject2;
    Object localObject4;
    Object localObject3;
    if ((paramAbsBaseArticleInfo.mPictures != null) && (paramAbsBaseArticleInfo.mPictures.length > 0))
    {
      if ((paramAbsBaseArticleInfo.mPictures.length >= 1) && (paramAbsBaseArticleInfo.mPictures[0] != null)) {
        localObject1 = paramAbsBaseArticleInfo.mPictures[0];
      } else {
        localObject1 = paramAbsBaseArticleInfo.mSinglePicture;
      }
      Object localObject5 = null;
      if (localObject1 != null) {
        localObject1 = ((URL)localObject1).getFile();
      } else {
        localObject1 = null;
      }
      if ((paramAbsBaseArticleInfo.mPictures.length >= 2) && (paramAbsBaseArticleInfo.mPictures[1] != null)) {
        localObject2 = paramAbsBaseArticleInfo.mPictures[1];
      } else {
        localObject2 = paramAbsBaseArticleInfo.mSinglePicture;
      }
      if (localObject2 != null) {
        localObject2 = ((URL)localObject2).getFile();
      } else {
        localObject2 = null;
      }
      URL localURL;
      if ((paramAbsBaseArticleInfo.mPictures.length >= 3) && (paramAbsBaseArticleInfo.mPictures[2] != null)) {
        localURL = paramAbsBaseArticleInfo.mPictures[2];
      } else {
        localURL = paramAbsBaseArticleInfo.mSinglePicture;
      }
      localObject4 = localObject1;
      localObject3 = localObject2;
      paramAbsBaseArticleInfo = localObject5;
      if (localURL != null)
      {
        paramAbsBaseArticleInfo = localURL.getFile();
        localObject4 = localObject1;
        localObject3 = localObject2;
      }
    }
    else
    {
      localObject3 = ((IRIJR5JsonManager)QRoute.api(IRIJR5JsonManager.class)).getJSONArray(paramAbsBaseArticleInfo.mJsonPictureList, "pictures");
      if (localObject3 == null) {
        break label587;
      }
      if (((JSONArray)localObject3).length() < 3) {
        return localJSONObject;
      }
      localObject1 = ((JSONArray)localObject3).optJSONObject(0);
      if (localObject1 == null) {
        localObject1 = paramAbsBaseArticleInfo.mFirstPagePicUrl;
      } else {
        localObject1 = ((JSONObject)localObject1).optString("picture");
      }
      localObject2 = ((JSONArray)localObject3).optJSONObject(1);
      if (localObject2 == null) {
        localObject2 = paramAbsBaseArticleInfo.mFirstPagePicUrl;
      } else {
        localObject2 = ((JSONObject)localObject2).optString("picture");
      }
      localObject3 = ((JSONArray)localObject3).optJSONObject(2);
      if (localObject3 == null) {
        paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.mFirstPagePicUrl;
      } else {
        paramAbsBaseArticleInfo = ((JSONObject)localObject3).optString("picture");
      }
      localObject3 = localObject2;
      localObject4 = localObject1;
    }
    Object localObject1 = new JSONObject();
    ((JSONObject)localObject1).put("multi_img_url1", localObject4);
    localJSONObject.put("id_multi_img_1", localObject1);
    localObject1 = new JSONObject();
    ((JSONObject)localObject1).put("multi_img_url2", localObject3);
    localJSONObject.put("id_multi_img_2", localObject1);
    localObject1 = new JSONObject();
    ((JSONObject)localObject1).put("multi_img_url3", paramAbsBaseArticleInfo);
    localJSONObject.put("id_multi_img_3", localObject1);
    localJSONObject.put("id_info_operate_parent", new JSONObject());
    localJSONObject.put("id_ad_triple_container", new JSONObject());
    label587:
    return localJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.proteus.data.ReadInjoyAdTripleImgCell
 * JD-Core Version:    0.7.0.1
 */