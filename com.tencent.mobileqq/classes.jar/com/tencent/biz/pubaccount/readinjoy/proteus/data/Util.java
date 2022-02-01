package com.tencent.biz.pubaccount.readinjoy.proteus.data;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.VisibleForTesting;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.av.utils.UITools;
import com.tencent.biz.pubaccount.NativeAd.util.NativeAdUtils;
import com.tencent.biz.pubaccount.NativeAd.util.ParseUtil;
import com.tencent.biz.pubaccount.VideoInfo.RichTitleInfo;
import com.tencent.biz.pubaccount.readinjoy.common.ArticleInfoHelper;
import com.tencent.biz.pubaccount.readinjoy.common.RIJJsonUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyDisplayUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyTimeUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.DailyModeConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.json.RIJR5JsonManager;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.comment.RIJMedalUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.RIJItemViewType;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.preparse.RIJPreParseData;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJAladdinUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJFeedsType;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJJumpUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJSmartCropUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJStringUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.proteus.item.TripleProteusItem;
import com.tencent.biz.pubaccount.readinjoy.proteus.listeners.OnSocialAvatarClickListener;
import com.tencent.biz.pubaccount.readinjoy.proteus.listeners.OnSocialAvatarClickListener.SocialAvatarData;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.ReadInjoyTextView;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.CmpCtxt;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentSocialOperation;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.AnswerDetailInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.AwesomeCommentInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ExtraBiuBriefInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.FamilyCommentInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.LocalInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.MultiBiuSameContent;
import com.tencent.biz.pubaccount.readinjoy.struct.NewPolymericInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.NewPolymericInfo.PackArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.NewPolymericInfo.PackVideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.AccountProfileInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.BiuCommentInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.BiuInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.BuluoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.FeedsInfoUser;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.GalleryPGCFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.GameLiveInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.IconWordingInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.LocationInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.LongContentInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.PGCFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.PGCVideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.PrivacyShowInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.WendaInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicRecommendFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicRecommendFeedsInfo.TopicRecommendInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.VideoColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHelper;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.biz.pubaccount.util.ReadinjoyReportUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.map.geolocation.TencentLocationUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vip.CUKingCardHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import pb.unite.search.RequestSearchWord.Rcmd;
import tencent.im.oidb.articlesummary.articlesummary.PartnerAccountInfo;

public class Util
{
  static void A(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    Object localObject = BaseApplicationImpl.getContext();
    if ((!g(paramBaseArticleInfo)) || (localObject == null))
    {
      QLog.d("Util", 1, "bindTopicPackHeader failed, not topicInfo.");
      return;
    }
    paramJSONObject.put("id_topic_recommend_header", new JSONObject());
    TopicRecommendFeedsInfo.TopicRecommendInfo localTopicRecommendInfo = (TopicRecommendFeedsInfo.TopicRecommendInfo)paramBaseArticleInfo.mTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList.get(0);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("topic_name", localTopicRecommendInfo.jdField_c_of_type_JavaLangString + " " + localTopicRecommendInfo.jdField_a_of_type_JavaLangString);
    paramJSONObject.put("id_topic_name", localJSONObject);
    localJSONObject = new JSONObject();
    localJSONObject.put("topic_avator_url", localTopicRecommendInfo.jdField_d_of_type_JavaLangString);
    paramJSONObject.put("id_topic_avator", localJSONObject);
    localJSONObject = new JSONObject();
    localJSONObject.put("biu_time_text", String.format(((Context)localObject).getString(2131718399), new Object[] { ReadInJoyHelper.b(localTopicRecommendInfo.jdField_b_of_type_Int) }));
    paramJSONObject.put("id_topic_recommend_biu_time", localJSONObject);
    localObject = new JSONObject();
    int i;
    if (((TopicRecommendFeedsInfo.TopicRecommendInfo)paramBaseArticleInfo.mTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_c_of_type_Int == 1)
    {
      i = 1;
      if (i == 0) {
        break label284;
      }
      paramBaseArticleInfo = HardCodeUtil.a(2131715844);
      label233:
      ((JSONObject)localObject).put("button_status", paramBaseArticleInfo);
      if (i == 0) {
        break label293;
      }
    }
    label284:
    label293:
    for (paramBaseArticleInfo = "1";; paramBaseArticleInfo = "0")
    {
      ((JSONObject)localObject).put("selected_status", paramBaseArticleInfo);
      paramJSONObject.put("id_follow_button", localObject);
      paramJSONObject.put("id_header_line", new JSONObject());
      return;
      i = 0;
      break;
      paramBaseArticleInfo = HardCodeUtil.a(2131715834);
      break label233;
    }
  }
  
  static void B(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    if (!g(paramBaseArticleInfo))
    {
      QLog.d("Util", 1, "bindTopicTimeAndReason failed, not topicInfo.");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    if ((RIJFeedsType.d((ArticleInfo)paramBaseArticleInfo)) || (RIJFeedsType.g((ArticleInfo)paramBaseArticleInfo)))
    {
      if (paramBaseArticleInfo.mTime > 0L) {
        localStringBuilder.append(ReadInJoyTimeUtils.a(paramBaseArticleInfo.mRecommendTime, true));
      }
    }
    else if (paramBaseArticleInfo.mTopicRecommendFeedsInfo != null)
    {
      if (localStringBuilder.length() > 0) {
        localStringBuilder.append(" ");
      }
      if (TextUtils.isEmpty(paramBaseArticleInfo.mTopicRecommendFeedsInfo.jdField_b_of_type_JavaLangString)) {
        break label151;
      }
      localStringBuilder.append(paramBaseArticleInfo.mTopicRecommendFeedsInfo.jdField_b_of_type_JavaLangString);
    }
    for (;;)
    {
      paramBaseArticleInfo = new JSONObject();
      paramBaseArticleInfo.put("biu_time_text", HardCodeUtil.a(2131715841));
      paramJSONObject.put("id_topic_recommend_biu_time", paramBaseArticleInfo);
      return;
      localStringBuilder.append("刚刚");
      break;
      label151:
      if (paramBaseArticleInfo.mTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList.get(0) != null) {
        localStringBuilder.append(ReadInJoyHelper.a(((TopicRecommendFeedsInfo.TopicRecommendInfo)paramBaseArticleInfo.mTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_b_of_type_Int) + "人参与");
      }
    }
  }
  
  static void C(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    JSONArray localJSONArray = null;
    if ((paramBaseArticleInfo == null) || (paramJSONObject == null))
    {
      QLog.d("Util", 1, "bindCommonInfo, info or outData is null.");
      return;
    }
    a(paramBaseArticleInfo, paramJSONObject, true);
    Object localObject1 = new JSONObject();
    ((JSONObject)localObject1).put("article_large_imge_url", paramBaseArticleInfo.mFirstPagePicUrl);
    paramJSONObject.put("id_article_large_imge", localObject1);
    localObject1 = new JSONObject();
    ((JSONObject)localObject1).put("article_small_imge_url", paramBaseArticleInfo.mFirstPagePicUrl);
    paramJSONObject.put("id_article_small_imge", localObject1);
    localObject1 = new JSONObject();
    ((JSONObject)localObject1).put("text", paramBaseArticleInfo.mSubscribeName);
    paramJSONObject.put("id_subcribe_name", localObject1);
    Object localObject4 = "";
    Object localObject5 = "";
    String str = "";
    Object localObject2;
    Object localObject3;
    if ((paramBaseArticleInfo.mPictures == null) || (paramBaseArticleInfo.mPictures.length <= 0))
    {
      localJSONArray = RIJR5JsonManager.a(paramBaseArticleInfo.mJsonPictureList, "pictures");
      localObject2 = localObject4;
      localObject3 = localObject5;
      localObject1 = str;
      if (localJSONArray != null)
      {
        localObject2 = localObject4;
        localObject3 = localObject5;
        localObject1 = str;
        if (localJSONArray.length() >= 3)
        {
          localObject1 = localJSONArray.optJSONObject(0);
          if (localObject1 != null) {
            break label308;
          }
          localObject2 = paramBaseArticleInfo.mFirstPagePicUrl;
          localObject1 = localJSONArray.optJSONObject(1);
          if (localObject1 != null) {
            break label318;
          }
          localObject3 = paramBaseArticleInfo.mFirstPagePicUrl;
          label212:
          localObject1 = localJSONArray.optJSONObject(2);
          if (localObject1 != null) {
            break label329;
          }
        }
      }
      label308:
      label318:
      label329:
      for (localObject1 = paramBaseArticleInfo.mFirstPagePicUrl;; localObject1 = ((JSONObject)localObject1).optString("picture"))
      {
        paramBaseArticleInfo = (BaseArticleInfo)localObject1;
        localObject4 = localObject2;
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("multi_img_url1", localObject4);
        paramJSONObject.put("id_multi_img_1", localObject1);
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("multi_img_url2", localObject3);
        paramJSONObject.put("id_multi_img_2", localObject1);
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("multi_img_url3", paramBaseArticleInfo);
        paramJSONObject.put("id_multi_img_3", localObject1);
        return;
        localObject2 = ((JSONObject)localObject1).optString("picture");
        break;
        localObject3 = ((JSONObject)localObject1).optString("picture");
        break label212;
      }
    }
    if ((paramBaseArticleInfo.mPictures.length < 1) || (paramBaseArticleInfo.mPictures[0] == null))
    {
      localObject1 = paramBaseArticleInfo.mSinglePicture;
      label362:
      if (localObject1 == null) {
        break label466;
      }
      localObject1 = ((URL)localObject1).getFile();
      label371:
      if ((paramBaseArticleInfo.mPictures.length >= 2) && (paramBaseArticleInfo.mPictures[1] != null)) {
        break label471;
      }
      localObject2 = paramBaseArticleInfo.mSinglePicture;
      label394:
      if (localObject2 == null) {
        break label481;
      }
      localObject2 = ((URL)localObject2).getFile();
      label403:
      if ((paramBaseArticleInfo.mPictures.length >= 3) && (paramBaseArticleInfo.mPictures[2] != null)) {
        break label486;
      }
    }
    label466:
    label471:
    label481:
    label486:
    for (localObject5 = paramBaseArticleInfo.mSinglePicture;; localObject5 = paramBaseArticleInfo.mPictures[2])
    {
      localObject4 = localObject1;
      localObject3 = localObject2;
      paramBaseArticleInfo = localJSONArray;
      if (localObject5 == null) {
        break;
      }
      paramBaseArticleInfo = ((URL)localObject5).getFile();
      localObject4 = localObject1;
      localObject3 = localObject2;
      break;
      localObject1 = paramBaseArticleInfo.mPictures[0];
      break label362;
      localObject1 = null;
      break label371;
      localObject2 = paramBaseArticleInfo.mPictures[1];
      break label394;
      localObject2 = null;
      break label403;
    }
  }
  
  public static void D(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    if (paramBaseArticleInfo == null) {
      return;
    }
    ae(paramBaseArticleInfo, paramJSONObject);
  }
  
  static void E(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    paramJSONObject.put("url", RIJJumpUtils.a(paramBaseArticleInfo, paramBaseArticleInfo.mArticleContentUrl));
    new JSONObject();
    paramJSONObject.put("article_large_imge_url", paramBaseArticleInfo.mFirstPagePicUrl);
    paramJSONObject.put("rowkey", paramBaseArticleInfo.innerUniqueID);
    Object localObject1 = paramBaseArticleInfo.mTitle;
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      paramJSONObject.put("artilce_title_text", localObject1);
    }
    if (paramBaseArticleInfo.getVideoDuration() > 0) {
      paramJSONObject.put("video_play_duration", UITools.a(paramBaseArticleInfo.getVideoDuration()));
    }
    if (paramBaseArticleInfo.getVideoDuration() <= 0) {
      paramJSONObject.put("subcribe_name_text", paramBaseArticleInfo.mSubscribeName);
    }
    F(paramBaseArticleInfo, paramJSONObject);
    D(paramBaseArticleInfo, paramJSONObject);
    ArrayList localArrayList1;
    ArrayList localArrayList2;
    NewPolymericInfo.PackArticleInfo localPackArticleInfo;
    JSONObject localJSONObject;
    Object localObject2;
    BaseArticleInfo localBaseArticleInfo;
    if ((paramBaseArticleInfo.mNewPolymericInfo != null) && (paramBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList != null))
    {
      localArrayList1 = new ArrayList();
      localObject1 = new JSONArray();
      localArrayList2 = new ArrayList();
      Iterator localIterator = paramBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList.iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          localPackArticleInfo = (NewPolymericInfo.PackArticleInfo)localIterator.next();
          if (localPackArticleInfo != null)
          {
            localJSONObject = new JSONObject();
            localJSONObject.put("style_ID", localPackArticleInfo.i);
            new JSONObject();
            localJSONObject.put("article_large_imge_url", localPackArticleInfo.jdField_c_of_type_JavaLangString);
            if (localPackArticleInfo.jdField_c_of_type_Int == 1) {
              localJSONObject.put("gallery_cnt", localPackArticleInfo.jdField_d_of_type_Int + HardCodeUtil.a(2131715833));
            }
            localJSONObject.put("rowkey", localPackArticleInfo.g);
            localArrayList1.add(localPackArticleInfo.g);
            localJSONObject.put("subcribe_name_text", localPackArticleInfo.jdField_f_of_type_JavaLangString);
            localJSONObject.put("subscribe_id", localPackArticleInfo.jdField_e_of_type_JavaLangString);
            localJSONObject.put("artilce_title_text", localPackArticleInfo.jdField_a_of_type_JavaLangString);
            if (RIJJumpUtils.a(localPackArticleInfo.jdField_d_of_type_JavaLangString))
            {
              localObject2 = RIJJumpUtils.a(localPackArticleInfo.jdField_d_of_type_JavaLangString, localPackArticleInfo, paramBaseArticleInfo);
              localBaseArticleInfo = new BaseArticleInfo();
              localBaseArticleInfo.mArticleContentUrl = localPackArticleInfo.jdField_d_of_type_JavaLangString;
              localBaseArticleInfo.mSubscribeName = localPackArticleInfo.jdField_f_of_type_JavaLangString;
              localBaseArticleInfo.mSubscribeID = localPackArticleInfo.jdField_e_of_type_JavaLangString;
              localBaseArticleInfo.mTitle = localPackArticleInfo.jdField_a_of_type_JavaLangString;
              if (localPackArticleInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructNewPolymericInfo$PackVideoInfo != null)
              {
                localJSONObject.put("video_play_duration", UITools.a(localPackArticleInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructNewPolymericInfo$PackVideoInfo.jdField_d_of_type_Int));
                localBaseArticleInfo.mVideoDuration = localPackArticleInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructNewPolymericInfo$PackVideoInfo.jdField_d_of_type_Int;
                localBaseArticleInfo.busiType = localPackArticleInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructNewPolymericInfo$PackVideoInfo.jdField_a_of_type_Int;
                localBaseArticleInfo.mVideoVid = localPackArticleInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructNewPolymericInfo$PackVideoInfo.jdField_a_of_type_JavaLangString;
                localBaseArticleInfo.mVideoJsonWidth = localPackArticleInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructNewPolymericInfo$PackVideoInfo.jdField_b_of_type_Int;
                localBaseArticleInfo.mVideoJsonHeight = localPackArticleInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructNewPolymericInfo$PackVideoInfo.jdField_c_of_type_Int;
              }
            }
          }
        }
      }
    }
    label799:
    for (;;)
    {
      try
      {
        localBaseArticleInfo.mVideoCoverUrl = new URL(localPackArticleInfo.jdField_c_of_type_JavaLangString);
        if ((paramBaseArticleInfo.isPGCShortContent()) && (localPackArticleInfo.jdField_e_of_type_Int == 1)) {
          localJSONObject.put("image_type_text", HardCodeUtil.a(2131715848));
        }
        localArrayList2.add(localBaseArticleInfo);
        localJSONObject.put("url", localObject2);
        ((JSONArray)localObject1).put(localJSONObject);
        if (TextUtils.isEmpty(paramBaseArticleInfo.proteusItemsData)) {
          break label799;
        }
        localObject2 = new JSONObject(paramBaseArticleInfo.proteusItemsData);
        if (localObject2 != null)
        {
          localObject2 = ((JSONObject)localObject2).getJSONArray("remoteDatas");
          localObject1 = RIJJsonUtils.a((JSONArray)localObject1, (JSONArray)localObject2);
          break;
          localObject2 = localPackArticleInfo.jdField_d_of_type_JavaLangString;
        }
      }
      catch (MalformedURLException localMalformedURLException)
      {
        localMalformedURLException.printStackTrace();
        QLog.d("Util", 2, localMalformedURLException.getMessage());
        continue;
        localObject2 = null;
        continue;
      }
      paramJSONObject.put("jump_url", paramBaseArticleInfo.mNewPolymericInfo.jdField_d_of_type_JavaLangString);
      paramJSONObject.put("datas", localObject1);
      paramBaseArticleInfo.mGroupSubArticleList = localArrayList2;
      paramJSONObject.put("all_rowkey", localArrayList1.toString());
      QLog.d("Util", 1, "bindDynamicCommonInfo polymetric card : " + paramJSONObject.toString() + ", packType : " + paramBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_Int);
      QLog.d("Util", 1, "bindDynamicCommonInfo : " + paramJSONObject.toString());
      return;
    }
  }
  
  static void F(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    if ((paramBaseArticleInfo == null) || (paramJSONObject == null))
    {
      QLog.d("Util", 1, "bindTripleImageData, info is null or outData is null.");
      return;
    }
    paramJSONObject.put("gallery_cnt", paramBaseArticleInfo.mGalleryPicNumber + HardCodeUtil.a(2131715827));
    ArrayList localArrayList = new ArrayList();
    Object localObject;
    if ((paramBaseArticleInfo.mPictures == null) || (paramBaseArticleInfo.mPictures.length <= 0))
    {
      JSONArray localJSONArray = RIJR5JsonManager.a(paramBaseArticleInfo.mJsonPictureList, "pictures");
      QLog.d("Util", 1, new Object[] { "bindTripleImageData, info.mJsonPictureList = ", paramBaseArticleInfo.mJsonPictureList });
      if ((localJSONArray == null) || (localJSONArray.length() <= 0))
      {
        QLog.d("Util", 1, "bindTripleImageData, json picture list is empty.");
        return;
      }
      i = 0;
      if (i < localJSONArray.length())
      {
        localObject = localJSONArray.optJSONObject(i);
        if (localObject == null) {}
        for (localObject = paramBaseArticleInfo.mFirstPagePicUrl;; localObject = ((JSONObject)localObject).optString("picture"))
        {
          localArrayList.add(localObject);
          i += 1;
          break;
        }
      }
    }
    else
    {
      QLog.d("Util", 1, new Object[] { "bindTripleImageData, mPictures length = ", Integer.valueOf(paramBaseArticleInfo.mPictures.length) });
      i = 0;
      if (i < paramBaseArticleInfo.mPictures.length)
      {
        if (paramBaseArticleInfo.mPictures[i] == null) {}
        for (localObject = paramBaseArticleInfo.mSinglePicture;; localObject = paramBaseArticleInfo.mPictures[i])
        {
          if (localObject != null) {
            localArrayList.add(((URL)localObject).getFile());
          }
          i += 1;
          break;
        }
      }
    }
    int i = 0;
    label273:
    if (i < localArrayList.size())
    {
      localObject = "gallery_triple_img_url_" + (i + 1);
      if (!TextUtils.isEmpty((CharSequence)localArrayList.get(i))) {
        break label371;
      }
    }
    label371:
    for (paramBaseArticleInfo = "";; paramBaseArticleInfo = (String)localArrayList.get(i))
    {
      QLog.d("Util", 1, new Object[] { "bindTripleImageData, key = ", localObject, ", value = ", paramBaseArticleInfo });
      paramJSONObject.put((String)localObject, paramBaseArticleInfo);
      i += 1;
      break label273;
      break;
    }
  }
  
  static void G(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    if ((!j(paramBaseArticleInfo)) || (((paramBaseArticleInfo instanceof ArticleInfo)) && (!RIJAladdinUtils.a()))) {
      return;
    }
    SocializeFeedsInfo localSocializeFeedsInfo = paramBaseArticleInfo.mSocialFeedInfo;
    int i = localSocializeFeedsInfo.jdField_b_of_type_Int;
    int j = localSocializeFeedsInfo.jdField_d_of_type_Int;
    if (QLog.isColorLevel()) {
      QLog.d("Util", 2, new Object[] { "bindSocialData, articleId = ", Long.valueOf(paramBaseArticleInfo.mArticleID), " likeCount = ", Integer.valueOf(i), " commentCount = ", Integer.valueOf(j) });
    }
    boolean bool = h(paramBaseArticleInfo);
    H(paramBaseArticleInfo, paramJSONObject);
    paramJSONObject.put("like_count", "");
    Object localObject1;
    Object localObject2;
    label142:
    label161:
    String str;
    if (bool)
    {
      localObject1 = "like_selected_state";
      if (localSocializeFeedsInfo.jdField_c_of_type_Int != 1) {
        break label347;
      }
      localObject2 = "1";
      paramJSONObject.put((String)localObject1, localObject2);
      if (!bool) {
        break label354;
      }
      localObject2 = "like_text";
      str = ReadInJoyHelper.b(i);
      if (!bool) {
        break label362;
      }
      localObject1 = HardCodeUtil.a(2131715846);
      label180:
      if (i <= 0) {
        break label373;
      }
      localObject1 = str;
      label188:
      paramJSONObject.put((String)localObject2, localObject1);
      if (!bool) {
        break label376;
      }
      localObject1 = "comment_text";
      label207:
      localObject2 = ReadInJoyHelper.b(j);
      str = HardCodeUtil.a(2131715842);
      if (j <= 0) {
        break label384;
      }
      label225:
      paramJSONObject.put((String)localObject1, localObject2);
      a(paramBaseArticleInfo, paramJSONObject, localSocializeFeedsInfo, bool);
      paramJSONObject.put("setArticleInfo", paramBaseArticleInfo);
      b(paramJSONObject, paramBaseArticleInfo);
      localObject2 = HardCodeUtil.a(2131715781);
      if (!bool) {
        break label391;
      }
      localObject1 = "share_text";
      label275:
      paramJSONObject.put((String)localObject1, localObject2);
      localObject2 = new JSONObject();
      if (!bool) {
        break label399;
      }
      localObject1 = "id_social_bottom_style_a";
      label303:
      paramJSONObject.put((String)localObject1, localObject2);
      c(paramJSONObject, paramBaseArticleInfo);
      if (localSocializeFeedsInfo.jdField_c_of_type_Int != 0) {
        break label407;
      }
    }
    label384:
    label391:
    label399:
    label407:
    for (paramBaseArticleInfo = "cancel_like";; paramBaseArticleInfo = "click_like")
    {
      paramJSONObject.put("dt_like_btn_actionId", paramBaseArticleInfo);
      return;
      localObject1 = "selected_state";
      break;
      label347:
      localObject2 = "0";
      break label142;
      label354:
      localObject2 = "like_count";
      break label161;
      label362:
      localObject1 = HardCodeUtil.a(2131715822);
      break label180;
      label373:
      break label188;
      label376:
      localObject1 = "comment_count";
      break label207;
      localObject2 = str;
      break label225;
      localObject1 = "share_title";
      break label275;
      localObject1 = "id_social_bottom";
      break label303;
    }
  }
  
  public static void H(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    String str;
    if (paramBaseArticleInfo.mPartnerAccountInfo != null)
    {
      if (paramBaseArticleInfo.mPartnerAccountInfo.uint32_watch_see_later.get() == 1)
      {
        str = "已添加";
        if (paramBaseArticleInfo.mPartnerAccountInfo.uint32_watch_see_later.get() != 1) {
          break label68;
        }
      }
      label68:
      for (paramBaseArticleInfo = "1";; paramBaseArticleInfo = "0")
      {
        paramJSONObject.put("watch_later_text", str);
        paramJSONObject.put("watch_later_selected", paramBaseArticleInfo);
        return;
        str = "稍后看";
        break;
      }
    }
    if (paramBaseArticleInfo.isWatchLater)
    {
      str = "已添加";
      if (!paramBaseArticleInfo.isWatchLater) {
        break label121;
      }
    }
    label121:
    for (paramBaseArticleInfo = "1";; paramBaseArticleInfo = "0")
    {
      paramJSONObject.put("watch_later_text", str);
      paramJSONObject.put("watch_later_selected", paramBaseArticleInfo);
      return;
      str = "稍后看";
      break;
    }
  }
  
  static void I(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    int j = 0;
    if ((paramBaseArticleInfo == null) || ((paramBaseArticleInfo instanceof ArticleInfo))) {}
    label271:
    for (;;)
    {
      return;
      Object localObject = paramBaseArticleInfo.mSocialFeedInfo;
      int i;
      if (localObject != null)
      {
        j = ((SocializeFeedsInfo)localObject).jdField_b_of_type_Int;
        i = ((SocializeFeedsInfo)localObject).jdField_f_of_type_Int;
        QLog.d("Util", 2, new Object[] { "bindSocialData, articleId = ", Long.valueOf(paramBaseArticleInfo.mArticleID), " likeCount = ", Integer.valueOf(j), " biuCount = ", Integer.valueOf(i) });
      }
      for (;;)
      {
        if ((j <= 0) && (i <= 0)) {
          break label271;
        }
        paramJSONObject.put("id_social_separator_line", new JSONObject());
        paramJSONObject.put("id_social_data_wrapper", new JSONObject());
        if (j > 0)
        {
          paramBaseArticleInfo = ReadInJoyHelper.b(j) + HardCodeUtil.a(2131715846);
          localObject = new JSONObject();
          paramJSONObject.put("social_data_like", paramBaseArticleInfo);
          paramJSONObject.put("id_social_data_like", localObject);
        }
        if ((j > 0) && (i > 0)) {
          paramJSONObject.put("id_social_data_dot", new JSONObject());
        }
        if (i <= 0) {
          break;
        }
        paramBaseArticleInfo = ReadInJoyHelper.b(i) + "Biu";
        localObject = new JSONObject();
        ((JSONObject)localObject).put("social_data_biu", paramBaseArticleInfo);
        paramJSONObject.put("id_social_data_biu", localObject);
        return;
        i = 0;
      }
    }
  }
  
  static void J(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    if ((paramBaseArticleInfo == null) || (paramBaseArticleInfo.mSocialFeedInfo == null)) {}
    SocializeFeedsInfo localSocializeFeedsInfo;
    do
    {
      return;
      localSocializeFeedsInfo = paramBaseArticleInfo.mSocialFeedInfo;
    } while (((localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo == null) || (localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.jdField_a_of_type_JavaUtilList == null) || (localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.jdField_a_of_type_JavaUtilList.size() <= 0) || ((localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.jdField_a_of_type_JavaUtilList.size() == 1) && ((TextUtils.isEmpty(((SocializeFeedsInfo.BiuCommentInfo)localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.jdField_a_of_type_JavaUtilList.get(0)).mBiuComment)) || (TextUtils.equals(((SocializeFeedsInfo.BiuCommentInfo)localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.jdField_a_of_type_JavaUtilList.get(0)).mBiuComment, ":")) || (TextUtils.equals(((SocializeFeedsInfo.BiuCommentInfo)localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.jdField_a_of_type_JavaUtilList.get(0)).mBiuComment, "："))))) && (TextUtils.isEmpty(localSocializeFeedsInfo.jdField_a_of_type_JavaLangString)));
    JSONObject localJSONObject = new JSONObject();
    long l = 0L;
    if (localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser != null) {
      l = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser.jdField_a_of_type_Long;
    }
    localJSONObject.put("pre_account_uin", String.valueOf(l));
    if ((RIJItemViewType.d(paramBaseArticleInfo)) && (e(paramBaseArticleInfo))) {
      localJSONObject.put("feeds_pre_account_uin", String.valueOf(l));
    }
    paramJSONObject.put("id_biu_comment", localJSONObject);
  }
  
  static void K(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    if ((paramBaseArticleInfo == null) || (paramBaseArticleInfo.mSocialFeedInfo == null)) {}
    SocializeFeedsInfo.UGCFeedsInfo localUGCFeedsInfo;
    do
    {
      do
      {
        return;
      } while (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo == null);
      localUGCFeedsInfo = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo;
    } while (((!CmpCtxt.c((ArticleInfo)paramBaseArticleInfo)) || (RIJItemViewType.j(paramBaseArticleInfo))) && (!RIJFeedsType.a(localUGCFeedsInfo)) && (TextUtils.isEmpty(localUGCFeedsInfo.jdField_a_of_type_JavaLangString)));
    paramJSONObject.put("id_article_comment", new JSONObject());
  }
  
  static void L(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    paramJSONObject.put("id_middle_body_wrapper", new JSONObject());
  }
  
  static void M(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    paramJSONObject.put("id_summary", new JSONObject());
  }
  
  static void N(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramBaseArticleInfo != null)
    {
      localJSONObject.put("pre_account_uin", String.valueOf(paramBaseArticleInfo.mSubscribeID));
      if ((RIJItemViewType.d(paramBaseArticleInfo)) && (e(paramBaseArticleInfo))) {
        localJSONObject.put("feeds_pre_account_uin", String.valueOf(paramBaseArticleInfo.mSubscribeID));
      }
    }
    paramJSONObject.put("id_article_comment", localJSONObject);
  }
  
  static void O(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    if (ArticleInfoHelper.a(paramBaseArticleInfo)) {}
    while ((paramBaseArticleInfo == null) || (paramBaseArticleInfo.mSocialFeedInfo == null) || (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo == null) || (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_JavaUtilArrayList == null) || (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_JavaUtilArrayList.size() <= 0)) {
      return;
    }
    paramJSONObject.put("id_middle_body_content", new JSONObject());
  }
  
  static void P(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    if (ArticleInfoHelper.a(paramBaseArticleInfo)) {}
    while (RIJItemViewType.j(paramBaseArticleInfo)) {
      return;
    }
    paramJSONObject.put("id_middle_body_content", new JSONObject());
  }
  
  static void Q(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    if (!RIJItemViewType.k(paramBaseArticleInfo))
    {
      paramJSONObject.put("id_middle_body_content", new JSONObject());
      if (paramBaseArticleInfo.mFeedType == 30) {
        paramJSONObject.remove("id_summary");
      }
    }
  }
  
  static void R(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    if (ArticleInfoHelper.a(paramBaseArticleInfo)) {
      return;
    }
    paramJSONObject.put("id_middle_body_content", new JSONObject());
  }
  
  static void S(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    if ((paramBaseArticleInfo != null) && (!TextUtils.isEmpty(paramBaseArticleInfo.businessName)) && (!paramBaseArticleInfo.isSuperTopic))
    {
      paramJSONObject.put("id_capsule", new JSONObject());
      paramJSONObject.put("id_capsule_topic_tag", new JSONObject());
      if (!TextUtils.isEmpty(paramBaseArticleInfo.businessNamePrefix))
      {
        localJSONObject = new JSONObject();
        localJSONObject.put("capsule_topic_pre", "topic_pre_image");
        paramJSONObject.put("id_capsule_topic_pre", localJSONObject);
      }
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("capsule_topic_name", RIJStringUtils.a(paramBaseArticleInfo.businessName, a(paramBaseArticleInfo)));
      paramJSONObject.put("id_capsule_topic_name", localJSONObject);
    }
  }
  
  static void T(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    if ((paramBaseArticleInfo == null) || (paramBaseArticleInfo.mSocialFeedInfo == null)) {
      return;
    }
    SocializeFeedsInfo localSocializeFeedsInfo = paramBaseArticleInfo.mSocialFeedInfo;
    if (localSocializeFeedsInfo.h == 1)
    {
      if ((!RIJItemViewType.d(paramBaseArticleInfo)) || (i(paramBaseArticleInfo)))
      {
        paramJSONObject.put("button_status", HardCodeUtil.a(2131715821));
        paramJSONObject.put("selected_status", "0");
        paramBaseArticleInfo.bindShowFollowButton = true;
        paramBaseArticleInfo.showFollowButtonType = BaseArticleInfo.TYPE_UNFOLLOW_BUTTON;
        return;
      }
      paramBaseArticleInfo.bindShowFollowButton = false;
      return;
    }
    if (localSocializeFeedsInfo.h == 2)
    {
      if (c(paramBaseArticleInfo))
      {
        new JSONObject();
        paramJSONObject.put("button_status", HardCodeUtil.a(2131715845));
        paramJSONObject.put("selected_status", "1");
        paramBaseArticleInfo.bindShowFollowButton = true;
        paramBaseArticleInfo.showFollowButtonType = BaseArticleInfo.TYPE_FOLLOWED_BUTTON;
        return;
      }
      paramBaseArticleInfo.bindShowFollowButton = false;
      return;
    }
    paramBaseArticleInfo.bindShowFollowButton = false;
  }
  
  static void U(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    if ((paramBaseArticleInfo == null) || (paramBaseArticleInfo.mSocialFeedInfo == null)) {}
    do
    {
      do
      {
        do
        {
          return;
          paramBaseArticleInfo = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$WendaInfo;
        } while (paramBaseArticleInfo == null);
        if ((TextUtils.isEmpty(paramBaseArticleInfo.jdField_b_of_type_JavaLangString)) || (TextUtils.isEmpty(paramBaseArticleInfo.jdField_d_of_type_JavaLangString))) {
          break;
        }
        paramJSONObject.put("id_super_topic", new JSONObject());
        localJSONObject = new JSONObject();
        if (TextUtils.isEmpty(paramBaseArticleInfo.jdField_c_of_type_JavaLangString)) {
          paramBaseArticleInfo.jdField_c_of_type_JavaLangString = "https://sqimg.qq.com/qq_product_operations/kan/images/super_wenda_default.png";
        }
        localJSONObject.put("super_topic_avator_url", paramBaseArticleInfo.jdField_c_of_type_JavaLangString);
        paramJSONObject.put("id_super_topic_avator", localJSONObject);
        if (!TextUtils.isEmpty(paramBaseArticleInfo.n))
        {
          localJSONObject = new JSONObject();
          localJSONObject.put("super_topic_button_title", paramBaseArticleInfo.n);
          paramJSONObject.put("id_super_topic_button", localJSONObject);
        }
        localJSONObject = new JSONObject();
        localJSONObject.put("super_topic_name", paramBaseArticleInfo.jdField_b_of_type_JavaLangString);
        paramJSONObject.put("id_super_topic_name", localJSONObject);
        localJSONObject = new JSONObject();
        localJSONObject.put("super_topic_subname", ComponentSocialOperation.a(paramBaseArticleInfo.jdField_b_of_type_Int) + HardCodeUtil.a(2131715840) + ComponentSocialOperation.a(paramBaseArticleInfo.jdField_a_of_type_Int) + HardCodeUtil.a(2131715847));
        paramJSONObject.put("id_super_topic_subname", localJSONObject);
      } while (TextUtils.isEmpty(paramBaseArticleInfo.jdField_e_of_type_JavaLangString));
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("super_topic_hot_icon_url", paramBaseArticleInfo.jdField_e_of_type_JavaLangString);
      paramJSONObject.put("id_super_topic_hot_icon", localJSONObject);
      return;
    } while (!QLog.isColorLevel());
    QLog.i("Util", 2, "bindSuperTopic something is null,wendaInfo.wendaUrl=" + paramBaseArticleInfo.jdField_d_of_type_JavaLangString + ",wendaInfo.questionDes=" + paramBaseArticleInfo.jdField_b_of_type_JavaLangString);
  }
  
  public static void V(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    if ((paramBaseArticleInfo == null) || (!ExtraBiuBriefInfo.a(paramBaseArticleInfo))) {
      return;
    }
    paramJSONObject.put("id_pack_bottom", new JSONObject());
    paramJSONObject.put("id_pack_bottom_separator_line", new JSONObject());
    paramBaseArticleInfo = new JSONObject();
    paramBaseArticleInfo.put("pack_bottom_imageview", "qqreadinjoy_kandian_down_arrow.png");
    paramJSONObject.put("id_pack_bottom_imageview", paramBaseArticleInfo);
  }
  
  static void W(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    if ((paramBaseArticleInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$IconWordingInfo != null))
    {
      paramBaseArticleInfo = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$IconWordingInfo;
      paramJSONObject.put("id_capsule", new JSONObject());
      paramJSONObject.put("id_capsule_common_tag", new JSONObject());
      JSONObject localJSONObject;
      if (!TextUtils.isEmpty(paramBaseArticleInfo.jdField_a_of_type_JavaLangString))
      {
        localJSONObject = new JSONObject();
        localJSONObject.put("capsule_common_pre_url", paramBaseArticleInfo.jdField_a_of_type_JavaLangString);
        paramJSONObject.put("id_capsule_common_pre", localJSONObject);
      }
      if (!TextUtils.isEmpty(paramBaseArticleInfo.jdField_b_of_type_JavaLangString))
      {
        localJSONObject = new JSONObject();
        localJSONObject.put("capsule_common_name", paramBaseArticleInfo.jdField_b_of_type_JavaLangString);
        paramJSONObject.put("id_capsule_common_name", localJSONObject);
      }
    }
  }
  
  static void X(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    if ((paramBaseArticleInfo == null) || (paramBaseArticleInfo.mSocialFeedInfo == null) || (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PrivacyShowInfo == null)) {}
    int i;
    long l;
    do
    {
      return;
      paramBaseArticleInfo = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PrivacyShowInfo;
      i = paramBaseArticleInfo.jdField_a_of_type_Int;
      l = paramBaseArticleInfo.jdField_a_of_type_Long;
    } while ((ReadInJoyUtils.a() != l) || (i == 0));
    paramJSONObject.put("id_capsule", new JSONObject());
    paramJSONObject.put("id_capsule_privacy_tag", new JSONObject());
    Object localObject = "";
    paramBaseArticleInfo = "";
    if (i == 1)
    {
      localObject = "readinjoy_privacy_vis_some.png";
      paramBaseArticleInfo = HardCodeUtil.a(2131715838);
    }
    for (;;)
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("capsule_privacy_pre", localObject);
      paramJSONObject.put("id_capsule_privacy_pre", localJSONObject);
      localObject = new JSONObject();
      ((JSONObject)localObject).put("capsule_privacy_name", paramBaseArticleInfo);
      paramJSONObject.put("id_capsule_privacy_name", localObject);
      return;
      if (i == 2)
      {
        localObject = "readinjoy_privacy_vis_self.png";
        paramBaseArticleInfo = HardCodeUtil.a(2131715823);
      }
    }
  }
  
  public static void Y(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    if ((paramBaseArticleInfo == null) || (paramBaseArticleInfo.mSocialFeedInfo == null) || (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$LocationInfo == null)) {}
    SocializeFeedsInfo.LocationInfo localLocationInfo;
    do
    {
      return;
      localLocationInfo = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$LocationInfo;
    } while ((TextUtils.isEmpty(localLocationInfo.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(localLocationInfo.jdField_b_of_type_JavaLangString)));
    paramJSONObject.put("id_capsule", new JSONObject());
    paramJSONObject.put("id_capsule_lbs_tag", new JSONObject());
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("capsule_lbs_pre_url", localLocationInfo.jdField_b_of_type_JavaLangString);
    paramJSONObject.put("id_capsule_lbs_pre", localJSONObject);
    localJSONObject = new JSONObject();
    localJSONObject.put("capsule_lbs_name", RIJStringUtils.a(localLocationInfo.jdField_a_of_type_JavaLangString, a(paramBaseArticleInfo)));
    paramJSONObject.put("id_capsule_lbs_name", localJSONObject);
  }
  
  public static void Z(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    paramJSONObject.put("id_socialize_recommend_follow", new JSONObject());
  }
  
  private static int a(BaseArticleInfo paramBaseArticleInfo)
  {
    int j = b(paramBaseArticleInfo);
    int i = j;
    if (j <= 0) {
      i = 1;
    }
    QLog.d("Util", 1, new Object[] { "getCapsuleMaxStrLen, count = ", Integer.valueOf(i), "len = ", Integer.valueOf(48 / i) });
    return 48 / i;
  }
  
  public static String a(BaseArticleInfo paramBaseArticleInfo)
  {
    String str2 = "";
    long l;
    String str1;
    if ((paramBaseArticleInfo.mSocialFeedInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_e_of_type_Int > 0))
    {
      l = paramBaseArticleInfo.mSocialFeedInfo.jdField_e_of_type_Int;
      if (l <= 0L) {
        break label234;
      }
      str1 = ReadInJoyTimeUtils.a(l, true);
      label42:
      if ((!RIJItemViewType.d(paramBaseArticleInfo)) || (f(paramBaseArticleInfo))) {
        str2 = str1 + " ";
      }
      if ((paramBaseArticleInfo.mFeedType != 32) || (paramBaseArticleInfo.mSocialFeedInfo == null) || (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$GameLiveInfo == null) || (TextUtils.isEmpty(paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$GameLiveInfo.jdField_d_of_type_JavaLangString))) {
        break label244;
      }
      str1 = " · " + paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$GameLiveInfo.jdField_d_of_type_JavaLangString;
      label149:
      if (TextUtils.isEmpty(str1)) {
        break label250;
      }
    }
    for (;;)
    {
      label156:
      Object localObject = str2;
      if (paramBaseArticleInfo.mSocialFeedInfo != null)
      {
        localObject = str2;
        if (!TextUtils.isEmpty(str1))
        {
          localObject = new StringBuilder().append(str2);
          if (TextUtils.isEmpty(str2)) {
            break label326;
          }
        }
      }
      label326:
      for (paramBaseArticleInfo = " ";; paramBaseArticleInfo = "")
      {
        localObject = paramBaseArticleInfo + str1;
        return RIJStringUtils.a((String)localObject, 36);
        l = paramBaseArticleInfo.mTime;
        break;
        label234:
        str1 = HardCodeUtil.a(2131715829);
        break label42;
        label244:
        str1 = "";
        break label149;
        label250:
        if ((paramBaseArticleInfo.mSocialFeedInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser != null) && ((RIJItemViewType.b((ArticleInfo)paramBaseArticleInfo)) || (RIJItemViewType.i((ArticleInfo)paramBaseArticleInfo)) || (RIJItemViewType.c(paramBaseArticleInfo))))
        {
          str1 = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser.jdField_a_of_type_JavaLangString;
          break label156;
        }
        if (paramBaseArticleInfo.mSocialFeedInfo == null) {
          break label332;
        }
        str1 = paramBaseArticleInfo.mSocialFeedInfo.jdField_d_of_type_JavaLangString;
        break label156;
      }
      label332:
      str1 = "";
    }
  }
  
  private static String a(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  public static JSONObject a()
  {
    JSONObject localJSONObject1 = new JSONObject();
    localJSONObject1.put("name", "div");
    JSONObject localJSONObject2 = new JSONObject();
    localJSONObject2.put("style", "font-size:18px;line-height: 25px; width:351rpx;color: #242424;-webkit-line-clamp:2");
    localJSONObject1.put("attrs", localJSONObject2);
    return localJSONObject1;
  }
  
  public static JSONObject a(VideoInfo.RichTitleInfo paramRichTitleInfo, boolean paramBoolean)
  {
    JSONObject localJSONObject1 = new JSONObject();
    localJSONObject1.put("name", "a");
    Object localObject = new JSONObject();
    ((JSONObject)localObject).put("href", paramRichTitleInfo.jdField_d_of_type_JavaLangString);
    ((JSONObject)localObject).put("style", "color: #40A0FF;");
    localJSONObject1.put("attrs", localObject);
    localObject = new JSONArray();
    JSONObject localJSONObject2 = new JSONObject();
    localJSONObject2.put("type", "text");
    if (paramBoolean) {
      localJSONObject2.put("text", RIJStringUtils.a(paramRichTitleInfo.jdField_c_of_type_JavaLangString, 16));
    }
    for (;;)
    {
      ((JSONArray)localObject).put(localJSONObject2);
      localJSONObject1.put("children", localObject);
      return localJSONObject1;
      localJSONObject2.put("text", paramRichTitleInfo.jdField_c_of_type_JavaLangString);
    }
  }
  
  public static JSONObject a(VideoInfo.RichTitleInfo paramRichTitleInfo, boolean paramBoolean1, boolean paramBoolean2)
  {
    JSONObject localJSONObject1 = new JSONObject();
    localJSONObject1.put("name", "text");
    JSONObject localJSONObject2 = new JSONObject();
    localJSONObject2.put("class", "div_class");
    if (paramBoolean1) {}
    for (Object localObject = "color: #999999;";; localObject = "color: #262626")
    {
      if (paramBoolean2) {
        localObject = "color: #ffffff;";
      }
      localJSONObject2.put("style", localObject);
      localJSONObject1.put("attrs", localJSONObject2);
      localObject = new JSONArray();
      localJSONObject2 = new JSONObject();
      localJSONObject2.put("type", "text");
      localJSONObject2.put("text", paramRichTitleInfo.jdField_a_of_type_JavaLangString);
      ((JSONArray)localObject).put(localJSONObject2);
      localJSONObject1.put("children", localObject);
      return localJSONObject1;
    }
  }
  
  public static void a(BaseArticleInfo paramBaseArticleInfo, int paramInt, JSONArray paramJSONArray)
  {
    if (paramJSONArray == null)
    {
      QLog.i("Util", 1, "[bindSmallVideo], outData is null.");
      return;
    }
    if (paramBaseArticleInfo == null)
    {
      QLog.i("Util", 1, "[bindSmallVideo], info is null");
      return;
    }
    paramBaseArticleInfo = paramBaseArticleInfo.mGroupSubArticleList;
    if ((paramBaseArticleInfo != null) && (paramBaseArticleInfo.size() > 0))
    {
      paramInt = 0;
      label48:
      Object localObject;
      if (paramInt < paramBaseArticleInfo.size())
      {
        localObject = (ArticleInfo)paramBaseArticleInfo.get(paramInt);
        if (localObject != null) {
          break label91;
        }
        QLog.i("Util", 1, "[bindSmallVideo], item articleInfo is null.");
      }
      for (;;)
      {
        paramInt += 1;
        break label48;
        break;
        label91:
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("style_ID", "ReadInjoy_pack_long_video_cell");
          localObject = (NewPolymericInfo.PackArticleInfo)((ArticleInfo)localObject).mNewPolymericInfo.jdField_a_of_type_JavaUtilList.get(0);
          localJSONObject.put("article_large_imge_url", RIJSmartCropUtils.a(((NewPolymericInfo.PackArticleInfo)localObject).jdField_c_of_type_JavaLangString, Utils.dp2px(165.0D), Utils.dp2px(293.0D)));
          if (((NewPolymericInfo.PackArticleInfo)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructNewPolymericInfo$PackVideoInfo != null) {
            localJSONObject.put("video_play_duration", UITools.a(((NewPolymericInfo.PackArticleInfo)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructNewPolymericInfo$PackVideoInfo.jdField_d_of_type_Int));
          }
          QLog.i("Util", 1, "[bindSmallVideo], item = " + localJSONObject);
          paramJSONArray.put(localJSONObject);
        }
        catch (JSONException localJSONException)
        {
          QLog.e("Util", 1, "[bindSmallVideo], e = " + localJSONException);
        }
        catch (Exception localException)
        {
          QLog.e("Util", 1, "[bindSmallVideo], e = " + localException);
        }
      }
    }
    QLog.i("Util", 1, "[bindSmallVideo], dataList is empty.");
  }
  
  public static void a(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    if (!TextUtils.isEmpty(paramBaseArticleInfo.mArticleSubscriptText))
    {
      if ((paramBaseArticleInfo instanceof AdvertisementInfo))
      {
        paramJSONObject.put("id_info_operate_parent", new JSONObject());
        paramJSONObject.put("id_large_cell_container", new JSONObject());
        JSONObject localJSONObject1 = new JSONObject(((AdvertisementInfo)paramBaseArticleInfo).mAdExtInfo);
        try
        {
          if (localJSONObject1.has("AdsIconText"))
          {
            if (QLog.isColorLevel()) {
              QLog.d("Util", 2, "detail ad  bindSubscriptText adInconText:" + localJSONObject1.optString("AdsIconText"));
            }
            if (!TextUtils.isEmpty(localJSONObject1.optString("AdsIconText")))
            {
              JSONObject localJSONObject3 = new JSONObject();
              localJSONObject3.put("info_status_text", localJSONObject1.optString("AdsIconText"));
              localJSONObject3.put("info_status_text_color", paramBaseArticleInfo.mArticleSubscriptColor);
              paramJSONObject.put("id_info_status", localJSONObject3);
            }
            return;
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("info_status_text", a(paramBaseArticleInfo.mArticleSubscriptText));
      localJSONObject2.put("info_status_text_color", paramBaseArticleInfo.mArticleSubscriptColor);
      paramJSONObject.put("id_info_status", localJSONObject2);
    }
    b(paramBaseArticleInfo, paramJSONObject);
  }
  
  @VisibleForTesting
  static void a(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject, SocializeFeedsInfo paramSocializeFeedsInfo, boolean paramBoolean)
  {
    Object localObject1;
    if (RIJAladdinUtils.b())
    {
      if ((!paramSocializeFeedsInfo.a()) || (!(paramBaseArticleInfo instanceof ArticleInfo))) {
        break label211;
      }
      localObject1 = (ArticleInfo)paramBaseArticleInfo;
      if ((RIJItemViewType.f((ArticleInfo)localObject1)) || (!ArticleInfoHelper.b((BaseArticleInfo)localObject1))) {
        break label223;
      }
    }
    label198:
    label211:
    label223:
    for (int i = 0;; i = 1)
    {
      String str;
      if (i == 0)
      {
        str = "0";
        localObject1 = "0.5";
      }
      for (;;)
      {
        Object localObject2 = localObject1;
        if (paramSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PrivacyShowInfo != null)
        {
          localObject2 = localObject1;
          if (paramSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PrivacyShowInfo.jdField_a_of_type_Int != 0) {
            localObject2 = "0.5";
          }
        }
        paramJSONObject.put("biu_alpha", localObject2);
        paramJSONObject.put("biu_enable", str);
        if (paramBoolean)
        {
          localObject1 = "biu_count_style_a";
          i = paramSocializeFeedsInfo.jdField_f_of_type_Int;
          if (i <= 0) {
            break label198;
          }
          paramJSONObject.put((String)localObject1, ReadInJoyHelper.b(i));
        }
        for (;;)
        {
          paramJSONObject.put("dt_rowkey_biu", paramBaseArticleInfo.innerUniqueID);
          paramJSONObject.put("dt_content_type_biu", paramBaseArticleInfo.dtReportContentType);
          paramJSONObject.put("dt_channel_id_biu", paramBaseArticleInfo.mChannelID);
          paramJSONObject.put("dt_backend_info_biu", paramBaseArticleInfo.dtReportBackendInfo);
          return;
          localObject1 = "biu_count";
          break;
          paramJSONObject.put((String)localObject1, "Biu");
        }
        localObject1 = "1.0";
        str = "1";
      }
    }
  }
  
  static void a(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject, Long paramLong)
  {
    new JSONObject();
    paramJSONObject.put("info_avator_uin", paramLong);
    if (paramBaseArticleInfo != null) {
      c(paramJSONObject, paramBaseArticleInfo);
    }
  }
  
  static void a(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject, String paramString)
  {
    if (paramBaseArticleInfo == null) {}
    JSONObject localJSONObject;
    do
    {
      do
      {
        return;
      } while ((DailyModeConfigHandler.a((int)paramBaseArticleInfo.mChannelID)) || (paramBaseArticleInfo.isCloseDislike == 1));
      if (a(paramBaseArticleInfo))
      {
        QLog.d("Util", 1, "[bindDislikeButtonForChannel] new bottom bar has dislike btn, so return");
        return;
      }
      localJSONObject = new JSONObject();
      if (RIJItemViewType.d(paramBaseArticleInfo))
      {
        localJSONObject.put("dislike_img", "dislike_img");
        paramJSONObject.put("id_bottom_dislike_button_style_a", localJSONObject);
        return;
      }
      if (!ReadinjoyReportUtils.a(paramBaseArticleInfo.mChannelID)) {
        break;
      }
    } while ((RIJFeedsType.r(paramBaseArticleInfo)) || (RIJFeedsType.i(paramBaseArticleInfo)));
    localJSONObject.put("feeds_dislike_icon", "feedback_more");
    localJSONObject.put("bottom_dislike_img", "feedback_more");
    paramJSONObject.put(paramString, localJSONObject);
    return;
    localJSONObject.put("feeds_dislike_icon", "feeds_dislike");
    localJSONObject.put("bottom_dislike_img", "feeds_dislike");
    paramJSONObject.put(paramString, localJSONObject);
  }
  
  public static void a(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject, String paramString, Object paramObject)
  {
    try
    {
      a(paramJSONObject, paramString, paramObject);
      return;
    }
    catch (Exception paramBaseArticleInfo)
    {
      QLog.d("Util", 1, "bindSpecialData, e = ", paramBaseArticleInfo);
    }
  }
  
  public static void a(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject, String paramString1, String paramString2, boolean paramBoolean)
  {
    if ((paramBaseArticleInfo == null) || (paramJSONObject == null) || (paramBaseArticleInfo.richTitleInfoList == null) || (paramBaseArticleInfo.richTitleInfoList.size() <= 0)) {
      return;
    }
    JSONArray localJSONArray;
    try
    {
      localJSONArray = new JSONArray();
      if (paramString2.equalsIgnoreCase("nodes")) {
        localJSONArray.put(a());
      }
      boolean bool = ReadInJoyLogicEngine.a().a(paramBaseArticleInfo.mArticleID);
      paramBaseArticleInfo = paramBaseArticleInfo.richTitleInfoList.iterator();
      while (paramBaseArticleInfo.hasNext())
      {
        VideoInfo.RichTitleInfo localRichTitleInfo = (VideoInfo.RichTitleInfo)paramBaseArticleInfo.next();
        if (!TextUtils.isEmpty(localRichTitleInfo.jdField_c_of_type_JavaLangString)) {
          localJSONArray.put(a(localRichTitleInfo, paramBoolean));
        }
        if (!TextUtils.isEmpty(localRichTitleInfo.jdField_a_of_type_JavaLangString)) {
          localJSONArray.put(a(localRichTitleInfo, bool, paramBoolean));
        }
      }
      paramJSONObject.put(paramString1, 2);
    }
    catch (JSONException paramBaseArticleInfo)
    {
      QLog.e("Util", 2, paramBaseArticleInfo.getMessage());
      return;
    }
    paramJSONObject.put(paramString2, localJSONArray);
  }
  
  static void a(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject, boolean paramBoolean)
  {
    String str = paramBaseArticleInfo.mTitle;
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("artilce_title_text", str);
    boolean bool = ReadInJoyLogicEngine.a().a(paramBaseArticleInfo.mArticleID);
    if (paramBoolean) {
      if (!bool) {
        break label81;
      }
    }
    label81:
    for (paramBaseArticleInfo = "#999999";; paramBaseArticleInfo = "#262626")
    {
      localJSONObject.put("title_text_color", paramBaseArticleInfo);
      localJSONObject.put("article_title_text_line_space", "0");
      paramJSONObject.put("id_artilce_title", localJSONObject);
      return;
    }
  }
  
  static void a(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject, boolean paramBoolean, String paramString)
  {
    String str = paramBaseArticleInfo.mTitle;
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("artilce_title_text", str);
    boolean bool = ReadInJoyLogicEngine.a().a(paramBaseArticleInfo.mArticleID);
    if (paramBoolean) {
      if (bool)
      {
        paramBaseArticleInfo = "#999999";
        localJSONObject.put("title_text_color", paramBaseArticleInfo);
      }
    }
    for (;;)
    {
      localJSONObject.put("article_title_text_line_space", paramString);
      paramJSONObject.put("id_artilce_title", localJSONObject);
      return;
      paramBaseArticleInfo = "#262626";
      break;
      localJSONObject.put("title_text_color", "#ffffff");
    }
  }
  
  public static void a(ViewBase paramViewBase, IReadInJoyModel paramIReadInJoyModel)
  {
    if ((paramViewBase == null) || (paramIReadInJoyModel == null)) {}
    long l;
    do
    {
      ArticleInfo localArticleInfo;
      do
      {
        return;
        localArticleInfo = paramIReadInJoyModel.a();
      } while ((localArticleInfo == null) || (localArticleInfo.mSocialFeedInfo == null) || (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser == null));
      l = localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser.jdField_a_of_type_Long;
      paramIReadInJoyModel = (ReadInjoyTextView)paramViewBase.findViewBaseByName("id_nickname");
      if (RIJItemViewType.d(localArticleInfo)) {
        paramIReadInJoyModel = (ReadInjoyTextView)paramViewBase.findViewBaseByName("id_feeds_nickname");
      }
    } while (paramIReadInJoyModel == null);
    paramIReadInJoyModel.a(l);
  }
  
  static void a(JSONObject paramJSONObject)
  {
    paramJSONObject.put("id_comment_edit", new JSONObject());
    paramJSONObject.put("id_comment_edit_label", new JSONObject());
  }
  
  public static void a(JSONObject paramJSONObject, BaseArticleInfo paramBaseArticleInfo)
  {
    if (paramBaseArticleInfo != null) {}
    try
    {
      paramJSONObject.put("rowkey", paramBaseArticleInfo.innerUniqueID);
      paramJSONObject.put("channel_id", paramBaseArticleInfo.mChannelID);
      paramJSONObject.put("puin", paramBaseArticleInfo.getSubscribeUin());
      if (paramBaseArticleInfo != null)
      {
        if (paramBaseArticleInfo.proteusItemsData == null) {
          return;
        }
        QLog.d("Util", 2, "addProteusDynamicData" + paramBaseArticleInfo.proteusItemsData);
        JSONObject localJSONObject = new JSONObject(paramBaseArticleInfo.proteusItemsData);
        Iterator localIterator = localJSONObject.keys();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          Object localObject = localJSONObject.opt(str);
          if (localObject != null) {
            paramJSONObject.put(str, localObject);
          }
          a(paramBaseArticleInfo, paramJSONObject, str, localObject);
        }
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      QLog.d("Util", 2, "addProteusDynamicData", localJSONException);
      QLog.d("Util", 1, "addProteusDynamicData | " + paramJSONObject.toString());
      ac(paramBaseArticleInfo, paramJSONObject);
      if (paramBaseArticleInfo.mSubArtilceList != null)
      {
        paramBaseArticleInfo = paramBaseArticleInfo.mSubArtilceList.iterator();
        while (paramBaseArticleInfo.hasNext()) {
          a(paramJSONObject, (ArticleInfo)paramBaseArticleInfo.next());
        }
      }
    }
  }
  
  private static void a(JSONObject paramJSONObject, String paramString, Object paramObject)
  {
    if (("guide_card_type".equals(paramString)) && ("1".equals(String.valueOf(paramObject))))
    {
      QLog.d("Util", 1, "bindSpecialData, show flow guide separator.");
      paramJSONObject.put("flow_guide_separator_color", "#f2f2f2");
    }
  }
  
  public static boolean a(BaseArticleInfo paramBaseArticleInfo)
  {
    if (!TextUtils.isEmpty(paramBaseArticleInfo.proteusItemsData)) {
      return new JSONObject(paramBaseArticleInfo.proteusItemsData).has("module_bottom_name");
    }
    return false;
  }
  
  static void aa(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    new JSONObject();
    paramJSONObject.put("social_header_fold", "social_header_fold");
  }
  
  public static void ab(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    Object localObject = new JSONObject();
    if (paramBaseArticleInfo.hasAwesome)
    {
      if (AwesomeCommentInfo.jdField_c_of_type_Int == 1)
      {
        ((JSONObject)localObject).put("icon_awesome_url", paramBaseArticleInfo.iconUrl);
        ((JSONObject)localObject).put("icon_jump_url", paramBaseArticleInfo.jumpUrl);
        if (paramBaseArticleInfo.iconHeight != 0) {
          ((JSONObject)localObject).put("icon_awesome_wh_rate", paramBaseArticleInfo.iconWith / paramBaseArticleInfo.iconHeight);
        }
        paramJSONObject.put("id_icon_awesome", localObject);
      }
      if (AwesomeCommentInfo.jdField_c_of_type_Int == 2)
      {
        localObject = new AwesomeCommentInfo();
        ((AwesomeCommentInfo)localObject).jdField_a_of_type_JavaLangString = paramBaseArticleInfo.rawkey;
        ((AwesomeCommentInfo)localObject).jdField_b_of_type_Int = paramBaseArticleInfo.iconHeight;
        ((AwesomeCommentInfo)localObject).jdField_a_of_type_Int = paramBaseArticleInfo.iconWith;
        ((AwesomeCommentInfo)localObject).jdField_a_of_type_Long = paramBaseArticleInfo.uin;
        ((AwesomeCommentInfo)localObject).jdField_b_of_type_JavaLangString = paramBaseArticleInfo.iconUrl;
        ((AwesomeCommentInfo)localObject).jdField_d_of_type_JavaLangString = paramBaseArticleInfo.nickName;
        ((AwesomeCommentInfo)localObject).jdField_e_of_type_JavaLangString = paramBaseArticleInfo.avatar;
        ((AwesomeCommentInfo)localObject).jdField_f_of_type_JavaLangString = paramBaseArticleInfo.oldCommentId;
        ((AwesomeCommentInfo)localObject).jdField_c_of_type_JavaLangString = paramBaseArticleInfo.jumpUrl;
        ((AwesomeCommentInfo)localObject).g = paramBaseArticleInfo.content;
        ((AwesomeCommentInfo)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo = paramBaseArticleInfo;
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("awesomeCommentInfo", localObject);
        paramJSONObject.put("id_awesomeview_mutlilines", localJSONObject);
      }
      if ((!TextUtils.isEmpty(paramBaseArticleInfo.iconUrl)) && ((AwesomeCommentInfo.jdField_c_of_type_Int == 1) || (AwesomeCommentInfo.jdField_c_of_type_Int == 2))) {
        AwesomeCommentInfo.a(paramBaseArticleInfo, "0X8009B76");
      }
      QLog.d("Util", 2, "bindAwesomeCommentInfo: " + paramJSONObject);
    }
  }
  
  static void ac(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    for (;;)
    {
      boolean bool;
      try
      {
        bool = ReadInJoyLogicEngine.a().a(paramBaseArticleInfo.mArticleID);
        paramJSONObject.optString("style_ID");
        if (TextUtils.isEmpty(paramJSONObject.optString("article_main_body_text"))) {
          break label71;
        }
        if (!bool) {
          break label82;
        }
        paramBaseArticleInfo = "#999999";
        paramJSONObject.put("article_main_body_text_color", paramBaseArticleInfo);
      }
      catch (Exception paramBaseArticleInfo)
      {
        return;
      }
      paramJSONObject.put("readable_title_text_color", paramBaseArticleInfo);
      return;
      paramBaseArticleInfo = "#262626";
      continue;
      label71:
      if (bool)
      {
        paramBaseArticleInfo = "#999999";
        continue;
        label82:
        paramBaseArticleInfo = "#737373";
      }
    }
  }
  
  static void ad(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    if ((paramBaseArticleInfo == null) || (!(paramBaseArticleInfo instanceof AdvertisementInfo))) {}
    Object localObject1;
    double d;
    label25:
    Object localObject3;
    do
    {
      return;
      localObject1 = NativeAdUtils.a(paramBaseArticleInfo);
      if (localObject1 != null) {
        break;
      }
      d = 0.0D;
      localObject3 = ((AdvertisementInfo)paramBaseArticleInfo).mLocalInfo;
    } while (localObject3 == null);
    if (QLog.isColorLevel()) {
      QLog.d("Util", 2, "bindAdPositionInfoNew localInfo ->" + localObject3);
    }
    for (;;)
    {
      StringBuilder localStringBuilder;
      try
      {
        localObject1 = ((LocalInfo)localObject3).h;
        paramBaseArticleInfo = ((LocalInfo)localObject3).jdField_c_of_type_JavaLangString;
        localObject2 = ((LocalInfo)localObject3).jdField_f_of_type_JavaLangString;
        localObject3 = ((LocalInfo)localObject3).jdField_b_of_type_JavaLangString;
        i = ParseUtil.a((String)localObject1, 3000);
        if (d > 0.0D) {
          break label246;
        }
        localObject1 = "";
        d = 0.0D;
        localStringBuilder = new StringBuilder();
        if (d == 0.0D) {
          break label382;
        }
        if (d <= i) {
          break label257;
        }
      }
      catch (Exception paramBaseArticleInfo)
      {
        return;
      }
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        i = 1;
        if (i == 0) {
          break label367;
        }
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("ad_Location", paramBaseArticleInfo);
        ((JSONObject)localObject2).put("ad_Location_content", localObject1);
        ((JSONObject)localObject2).put("ad_url", localObject3);
        paramBaseArticleInfo = new JSONObject();
        paramBaseArticleInfo.put("ad_Location", localObject2);
        paramJSONObject.put("id_view_ad_locationView", paramBaseArticleInfo);
        return;
        d = NativeAdUtils.a((double[])localObject1, BaseApplicationImpl.getContext());
        break label25;
        label246:
        d = Math.ceil(d);
        localObject1 = null;
        continue;
        label257:
        if (d < 1000.0D)
        {
          localStringBuilder.append((int)d).append('m');
          localObject2 = localStringBuilder.toString();
          localObject1 = paramBaseArticleInfo;
          paramBaseArticleInfo = (BaseArticleInfo)localObject2;
          continue;
        }
        if (d >= i) {
          break label369;
        }
        long l = Math.round(d / 1000.0D);
        if (l < 1000L) {
          localStringBuilder.append(l).append("km");
        }
        for (;;)
        {
          localObject2 = localStringBuilder.toString();
          localObject1 = paramBaseArticleInfo;
          paramBaseArticleInfo = (BaseArticleInfo)localObject2;
          break;
          localStringBuilder.append("999km");
        }
      }
      int i = 0;
      continue;
      label367:
      break;
      label369:
      Object localObject2 = paramBaseArticleInfo;
      paramBaseArticleInfo = (BaseArticleInfo)localObject1;
      localObject1 = localObject2;
      continue;
      label382:
      paramBaseArticleInfo = "";
      localObject1 = localObject2;
    }
  }
  
  static void ae(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    if ((paramBaseArticleInfo == null) || (paramBaseArticleInfo.mPartnerAccountInfo == null) || (!paramBaseArticleInfo.isAccountShown)) {
      return;
    }
    paramJSONObject.put("info_avator_uin", paramBaseArticleInfo.mPartnerAccountInfo.uint64_uin.get());
    c(paramJSONObject, paramBaseArticleInfo);
    paramJSONObject.put("partner_nickname_text", RIJStringUtils.a(ReadInJoyUserInfoModule.a()));
    paramJSONObject.put("partner_info_text", RIJStringUtils.a(paramBaseArticleInfo.mPartnerAccountInfo.bytes_recommend_reason.get().toStringUtf8(), 36));
    T(paramBaseArticleInfo, paramJSONObject);
    v(paramBaseArticleInfo, paramJSONObject);
    String str1 = "";
    String str2 = str1;
    if (RIJItemViewType.m(paramBaseArticleInfo))
    {
      if (paramBaseArticleInfo.mPartnerAccountInfo.bytes_head_jump_url.has()) {
        str1 = paramBaseArticleInfo.mPartnerAccountInfo.bytes_head_jump_url.get().toStringUtf8();
      }
      str2 = str1;
      if (TextUtils.isEmpty(str1))
      {
        str2 = str1;
        if ((paramBaseArticleInfo instanceof ArticleInfo)) {
          str2 = OnSocialAvatarClickListener.a((ArticleInfo)paramBaseArticleInfo, RIJItemViewType.a((ArticleInfo)paramBaseArticleInfo)).jdField_a_of_type_JavaLangString;
        }
      }
      paramJSONObject.put("partner_head_jump_url", str2);
      paramJSONObject.put("partner_jump_url", str2);
    }
    int i = RIJTransMergeKanDianReport.a(paramBaseArticleInfo);
    paramJSONObject.put("account_expose_card", i);
    QLog.d("Util", 1, new Object[] { "bindPartnerInfo, partner_head_jump_url = ", str2, " proteusItemsData=", paramBaseArticleInfo.proteusItemsData, "  partner_jump_url=", paramBaseArticleInfo.mArticleContentUrl, " ,account_expose_card=", Integer.valueOf(i) });
  }
  
  public static void af(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    int i;
    if (TextUtils.isEmpty(paramBaseArticleInfo.mSearchWordTitle))
    {
      paramJSONObject.remove(TripleProteusItem.jdField_a_of_type_JavaLangString);
      int j = paramBaseArticleInfo.mSearchWords.size();
      i = 0;
      label28:
      if (i >= j) {
        return;
      }
      RequestSearchWord.Rcmd localRcmd = (RequestSearchWord.Rcmd)paramBaseArticleInfo.mSearchWords.get(i);
      if (localRcmd == null) {
        break label112;
      }
      paramJSONObject.put(TripleProteusItem.b[i], localRcmd.word.get().toStringUtf8());
      paramJSONObject.put(TripleProteusItem.jdField_a_of_type_ArrayOfJavaLangString[i], localRcmd.jmp_url.get());
    }
    for (;;)
    {
      i += 1;
      break label28;
      paramJSONObject.put(TripleProteusItem.jdField_a_of_type_JavaLangString, paramBaseArticleInfo.mSearchWordTitle);
      break;
      label112:
      paramJSONObject.remove(TripleProteusItem.b[i]);
      paramJSONObject.remove(TripleProteusItem.jdField_a_of_type_ArrayOfJavaLangString[i]);
    }
  }
  
  public static void ag(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    if ((paramBaseArticleInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$GameLiveInfo != null))
    {
      paramBaseArticleInfo = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$GameLiveInfo;
      if (!TextUtils.isEmpty(paramBaseArticleInfo.jdField_e_of_type_JavaLangString))
      {
        paramJSONObject.put("live_hot_icon_url", "https://pub.idqqimg.com/pc/misc/files/20191127/0be49e55346742bd847bcef3941ec4d4.png");
        paramJSONObject.put("live_hot_text", paramBaseArticleInfo.jdField_e_of_type_JavaLangString);
      }
      if (paramBaseArticleInfo.jdField_a_of_type_Int != 0) {
        break label105;
      }
      paramJSONObject.put("live_status_bg_url", "https://pub.idqqimg.com/pc/misc/files/20191127/d3d83721dfe84278a19c8927e2253f10.png");
      paramJSONObject.put("live_status_text", HardCodeUtil.a(2131718282));
    }
    for (;;)
    {
      paramJSONObject.put("live_show", "1");
      return;
      label105:
      paramJSONObject.put("live_status_icon_url", "https://pub.idqqimg.com/pc/misc/files/20191127/b7e14064b3d1417788352c8a47d1e85a.gif");
      paramJSONObject.put("live_status_bg_url", "https://pub.idqqimg.com/pc/misc/files/20191127/84cf4158acb64cc0a7bf1d3a8f1b9d27.png");
      paramJSONObject.put("live_status_text", HardCodeUtil.a(2131718283));
    }
  }
  
  public static void ah(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    if ((paramBaseArticleInfo != null) && (paramJSONObject != null)) {}
    try
    {
      paramJSONObject.put("pgc_video_content_play_icon", "ReadInJoy/rij_play_icon.png");
      return;
    }
    catch (Exception paramBaseArticleInfo)
    {
      paramBaseArticleInfo.printStackTrace();
    }
  }
  
  public static void ai(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    if ((paramBaseArticleInfo != null) && (paramJSONObject != null)) {}
    try
    {
      paramJSONObject.put("pgc_video_content_audio_icon", "video_audio_mute");
      return;
    }
    catch (Exception paramBaseArticleInfo)
    {
      paramBaseArticleInfo.printStackTrace();
    }
  }
  
  public static void aj(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    if ((paramBaseArticleInfo != null) && (paramJSONObject != null)) {}
    try
    {
      paramJSONObject.put("pgc_video_content_title", paramBaseArticleInfo.mTitle);
      return;
    }
    catch (Exception paramBaseArticleInfo)
    {
      paramBaseArticleInfo.printStackTrace();
    }
  }
  
  public static void ak(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    if ((paramBaseArticleInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$LongContentInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$LongContentInfo.a != null) && (paramJSONObject != null)) {}
    try
    {
      paramJSONObject.put("pgc_video_content_play_count", VideoFeedsHelper.c((int)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$LongContentInfo.a.jdField_a_of_type_Long) + "播放");
      return;
    }
    catch (Exception paramBaseArticleInfo)
    {
      paramBaseArticleInfo.printStackTrace();
    }
  }
  
  public static void al(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    if ((paramBaseArticleInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$LongContentInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$LongContentInfo.a != null) && (paramJSONObject != null)) {}
    try
    {
      paramJSONObject.put("pgc_video_content_duration", VideoFeedsHelper.a(paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$LongContentInfo.a.jdField_a_of_type_Int * 1000L));
      return;
    }
    catch (Exception paramBaseArticleInfo)
    {
      paramBaseArticleInfo.printStackTrace();
    }
  }
  
  public static void am(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    if ((paramBaseArticleInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$LongContentInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$LongContentInfo.a != null) && (paramJSONObject != null)) {}
    try
    {
      paramJSONObject.put("pgc_video_content_vid", paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$LongContentInfo.a.jdField_e_of_type_JavaLangString);
      paramJSONObject.put("pgc_video_content_cover", paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$LongContentInfo.a.jdField_d_of_type_JavaLangString);
      paramJSONObject.put("pgc_video_content_busitype", paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$LongContentInfo.a.jdField_b_of_type_Int);
      return;
    }
    catch (Exception paramBaseArticleInfo)
    {
      paramBaseArticleInfo.printStackTrace();
    }
  }
  
  public static void an(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    if ((paramBaseArticleInfo != null) && (paramBaseArticleInfo.columnEntrances != null) && (paramBaseArticleInfo.columnEntrances.size() > 0))
    {
      paramBaseArticleInfo.isShowColumnAnimation = true;
      paramBaseArticleInfo = (VideoColumnInfo)paramBaseArticleInfo.columnEntrances.get(0);
      if (paramBaseArticleInfo.jdField_a_of_type_Int != 0)
      {
        paramJSONObject.put("column_tips", "栏目");
        paramJSONObject.put("column_name", paramBaseArticleInfo.jdField_b_of_type_JavaLangString);
        paramJSONObject.put("readinjoy_column_icon", paramBaseArticleInfo.jdField_c_of_type_JavaLangString);
        paramJSONObject.put("readinjoy_column_arrow", "readinjoy_column_arrow");
      }
    }
  }
  
  static void ao(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    if (paramBaseArticleInfo != null) {}
    try
    {
      paramJSONObject.put("pgc_video_rowkey", paramBaseArticleInfo.innerUniqueID);
      return;
    }
    catch (JSONException paramBaseArticleInfo)
    {
      QLog.e("Util", 2, paramBaseArticleInfo.getMessage());
    }
  }
  
  public static void ap(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    if ((paramBaseArticleInfo != null) && (paramJSONObject != null)) {}
    try
    {
      if (paramBaseArticleInfo.mVideoDuration != 0) {
        paramJSONObject.put("video_bottom_duration", ReadInJoyDisplayUtils.a(paramBaseArticleInfo.mVideoDuration));
      }
      if (paramBaseArticleInfo.mVideoPlayCount != 0) {
        paramJSONObject.put("video_bottom_play_count", VideoFeedsHelper.c(paramBaseArticleInfo.mVideoPlayCount));
      }
      if (paramBaseArticleInfo.mVideoCommentCount != 0) {
        paramJSONObject.put("video_bottom_comment_count", VideoFeedsHelper.d(paramBaseArticleInfo.mVideoCommentCount));
      }
      return;
    }
    catch (JSONException paramBaseArticleInfo)
    {
      QLog.e("Util", 1, paramBaseArticleInfo.getMessage());
    }
  }
  
  public static void aq(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    if ((paramBaseArticleInfo != null) && (paramJSONObject != null)) {}
    try
    {
      paramJSONObject.put("article_model", paramBaseArticleInfo);
      return;
    }
    catch (JSONException paramBaseArticleInfo)
    {
      QLog.e("Util", 2, paramBaseArticleInfo.getMessage());
    }
  }
  
  private static void ar(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    int i = paramBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_Int;
    String str3 = "";
    String str4 = "";
    String str2;
    String str1;
    if ((RIJItemViewType.i(paramBaseArticleInfo)) || (RIJItemViewType.h(paramBaseArticleInfo)))
    {
      str2 = BaseApplicationImpl.getContext().getString(2131718397);
      str1 = "poly_topic";
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(str2))
      {
        paramJSONObject.put("corner_text", str2);
        paramJSONObject.put("corner_icon", str1);
      }
      return;
      if ((i == 27) || ((i == 18) && (!paramBaseArticleInfo.isPGCShortContent())) || (i == 31) || ((RIJFeedsType.g(paramBaseArticleInfo)) && (!RIJFeedsType.d(paramBaseArticleInfo))))
      {
        str2 = BaseApplicationImpl.getContext().getString(2131718090);
        str1 = "poly_article";
      }
      else if (i == 52)
      {
        str2 = paramBaseArticleInfo.mGalleryPicNumber + HardCodeUtil.a(2131702317);
        str1 = "poly_gallery";
      }
      else if (i != 48)
      {
        str1 = str4;
        str2 = str3;
        if (i != 49) {}
      }
      else
      {
        str1 = str4;
        str2 = str3;
        if (paramBaseArticleInfo.mSocialFeedInfo != null)
        {
          str1 = str4;
          str2 = str3;
          if (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo != null)
          {
            str1 = str4;
            str2 = str3;
            if (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo.a != null)
            {
              str2 = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo.a.jdField_a_of_type_Long + HardCodeUtil.a(2131702374);
              str1 = "poly_gallery";
            }
          }
        }
      }
    }
  }
  
  private static void as(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    if ((ReadInJoyLogicEngine.a().a(null)) && ((paramBaseArticleInfo instanceof AdvertisementInfo)))
    {
      paramBaseArticleInfo = (AdvertisementInfo)paramBaseArticleInfo;
      if (!TextUtils.isEmpty(paramBaseArticleInfo.mAdExtInfo)) {
        break label33;
      }
    }
    for (;;)
    {
      return;
      try
      {
        label33:
        paramBaseArticleInfo = new JSONObject(paramBaseArticleInfo.mAdExtInfo);
        double d1 = paramBaseArticleInfo.getDouble("latitude");
        double d2 = paramBaseArticleInfo.getDouble("longitude");
        paramBaseArticleInfo = ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).getCachedLbsInfo("readinjoy_feed_ad_distance");
        if ((paramBaseArticleInfo != null) && (paramBaseArticleInfo.mLocation != null))
        {
          double d3 = paramBaseArticleInfo.mLocation.mLat02;
          double d4 = paramBaseArticleInfo.mLocation.mLon02;
          if ((d3 >= 0.0D) && (d4 >= 0.0D) && (d1 >= 0.0D) && (d2 >= 0.0D))
          {
            paramBaseArticleInfo = NativeAdUtils.a(TencentLocationUtils.distanceBetween(d3, d4, d1, d2));
            paramJSONObject.put("id_ad_position_container", new JSONObject());
            paramJSONObject.put("ad_position", paramBaseArticleInfo);
            return;
          }
        }
      }
      catch (Exception paramBaseArticleInfo) {}
    }
  }
  
  private static int b(BaseArticleInfo paramBaseArticleInfo)
  {
    int i;
    if (paramBaseArticleInfo != null) {
      if ((!TextUtils.isEmpty(paramBaseArticleInfo.businessName)) && (!paramBaseArticleInfo.isSuperTopic))
      {
        i = 1;
        j = i;
        if (paramBaseArticleInfo.mSocialFeedInfo != null)
        {
          j = i;
          Object localObject;
          if (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$LocationInfo != null)
          {
            localObject = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$LocationInfo;
            j = i;
            if (!TextUtils.isEmpty(((SocializeFeedsInfo.LocationInfo)localObject).jdField_a_of_type_JavaLangString))
            {
              j = i;
              if (!TextUtils.isEmpty(((SocializeFeedsInfo.LocationInfo)localObject).jdField_b_of_type_JavaLangString)) {
                j = i + 1;
              }
            }
          }
          i = j;
          if (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PrivacyShowInfo != null)
          {
            localObject = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PrivacyShowInfo;
            int k = ((SocializeFeedsInfo.PrivacyShowInfo)localObject).jdField_a_of_type_Int;
            long l = ((SocializeFeedsInfo.PrivacyShowInfo)localObject).jdField_a_of_type_Long;
            i = j;
            if (ReadInJoyUtils.a() == l)
            {
              i = j;
              if (k != 0) {
                i = j + 1;
              }
            }
          }
          j = i;
          if (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BuluoInfo != null)
          {
            paramBaseArticleInfo = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BuluoInfo;
            j = i;
            if (!TextUtils.isEmpty(paramBaseArticleInfo.jdField_c_of_type_JavaLangString))
            {
              j = i;
              if (TextUtils.isEmpty(paramBaseArticleInfo.jdField_d_of_type_JavaLangString)) {}
            }
          }
        }
      }
    }
    for (int j = i + 1;; j = 0)
    {
      QLog.d("Util", 1, new Object[] { "getCapsuleCount = ", Integer.valueOf(j) });
      return j;
      i = 0;
      break;
    }
  }
  
  private static String b(BaseArticleInfo paramBaseArticleInfo)
  {
    if ((paramBaseArticleInfo.mSinglePicture != null) && (paramBaseArticleInfo.mNewPolymericInfo != null) && (!paramBaseArticleInfo.mNewPolymericInfo.b))
    {
      String str = paramBaseArticleInfo.mSinglePicture.getFile();
      Pair localPair = ReadInJoyDisplayUtils.f();
      str = RIJSmartCropUtils.a(str, ((Integer)localPair.first).intValue(), ((Integer)localPair.second).intValue());
      paramBaseArticleInfo.mSinglePicture = RIJPreParseData.a(str);
      paramBaseArticleInfo.mNewPolymericInfo.b = true;
      if (QLog.isColorLevel()) {
        QLog.e("ComponentContentBigImageVideo", 2, " handled url = " + str);
      }
    }
    if (paramBaseArticleInfo.mSinglePicture != null) {
      return paramBaseArticleInfo.mSinglePicture.getFile();
    }
    return "";
  }
  
  private static JSONObject b()
  {
    return new JSONObject();
  }
  
  public static void b(BaseArticleInfo paramBaseArticleInfo, int paramInt, JSONArray paramJSONArray)
  {
    if ((paramBaseArticleInfo.mGroupSubArticleList != null) && (paramBaseArticleInfo.mGroupSubArticleList.size() > 0))
    {
      Iterator localIterator = paramBaseArticleInfo.mGroupSubArticleList.iterator();
      if (localIterator.hasNext())
      {
        paramBaseArticleInfo = (BaseArticleInfo)localIterator.next();
        JSONObject localJSONObject = new JSONObject();
        paramInt = paramBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_Int;
        if (RIJFeedsType.d(paramBaseArticleInfo))
        {
          localJSONObject.put("style_ID", "ReadInjoy_pack_cell_big_gallery");
          label84:
          if (!RIJFeedsType.b(paramBaseArticleInfo)) {
            break label363;
          }
          localJSONObject.put("article_large_imge_url", b(paramBaseArticleInfo));
          if (NetworkUtil.h(BaseApplicationImpl.getContext())) {
            break label337;
          }
          localJSONObject.put("id_play_text_container", new JSONObject());
          localJSONObject.put("id_layout_bottom_cover", new JSONObject());
          localJSONObject.put("id_play_text_icon", new JSONObject());
          if (CUKingCardHelper.a() != 1) {
            break label269;
          }
          localJSONObject.put("play_text", HardCodeUtil.a(2131702314));
          label182:
          if (k(paramBaseArticleInfo)) {
            localJSONObject.put("artilce_title_text", ((NewPolymericInfo.PackArticleInfo)paramBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_JavaLangString);
          }
          if (!ReadInJoyLogicEngine.a().a(paramBaseArticleInfo.mArticleID)) {
            break label356;
          }
        }
        label269:
        label337:
        label356:
        for (paramBaseArticleInfo = "#999999";; paramBaseArticleInfo = "#000000")
        {
          localJSONObject.put("title_text_color", paramBaseArticleInfo);
          paramJSONArray.put(localJSONObject);
          break;
          localJSONObject.put("style_ID", "ReadInjoy_pack_cell_big_img");
          break label84;
          if (paramBaseArticleInfo.mXGFileSize > 0L)
          {
            localJSONObject.put("play_text", VideoFeedsHelper.b(paramBaseArticleInfo.mXGFileSize) + HardCodeUtil.a(2131702367));
            break label182;
          }
          localJSONObject.put("play_text", HardCodeUtil.a(2131702399));
          break label182;
          localJSONObject.put("id_play_icon", new JSONObject());
          break label182;
        }
        label363:
        if (k(paramBaseArticleInfo))
        {
          URL localURL = RIJPreParseData.a(((NewPolymericInfo.PackArticleInfo)paramBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList.get(0)).jdField_c_of_type_JavaLangString, true, true);
          if (localURL != null) {
            localJSONObject.put("article_large_imge_url", localURL.getFile());
          }
        }
        ar(paramBaseArticleInfo, localJSONObject);
        as(paramBaseArticleInfo, localJSONObject);
        if (k(paramBaseArticleInfo)) {
          localJSONObject.put("artilce_title_text", ((NewPolymericInfo.PackArticleInfo)paramBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_JavaLangString);
        }
        if (ReadInJoyLogicEngine.a().a(paramBaseArticleInfo.mArticleID)) {}
        for (paramBaseArticleInfo = "#999999";; paramBaseArticleInfo = "#000000")
        {
          localJSONObject.put("title_text_color", paramBaseArticleInfo);
          break;
        }
      }
    }
  }
  
  public static void b(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    if ((paramBaseArticleInfo == null) || (paramJSONObject == null)) {
      return;
    }
    if (paramBaseArticleInfo.subscriptLocation != 0)
    {
      QLog.d("Util", 2, "bindBottomSuscriptInfo | not the right position");
      return;
    }
    paramJSONObject.put("mark_text", paramBaseArticleInfo.subscriptWording);
    paramJSONObject.put("corner_mark", paramBaseArticleInfo.subscriptType);
    if (!TextUtils.isEmpty(paramBaseArticleInfo.subscriptWordingColor)) {
      paramJSONObject.put("mark_color", paramBaseArticleInfo.subscriptWordingColor);
    }
    if (!TextUtils.isEmpty(paramBaseArticleInfo.subscriptBgColor)) {
      paramJSONObject.put("mark_backgroundcolor", paramBaseArticleInfo.subscriptBgColor);
    }
    QLog.d("Util", 2, "bindBottomSuscriptInfo | outData : " + paramJSONObject.toString());
  }
  
  static void b(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject, String paramString)
  {
    new JSONObject();
    String str = paramString;
    if (paramBaseArticleInfo != null)
    {
      str = paramString;
      if (paramBaseArticleInfo.mSocialFeedInfo != null)
      {
        str = paramString;
        if (!TextUtils.isEmpty(paramBaseArticleInfo.mSocialFeedInfo.jdField_c_of_type_JavaLangString)) {
          str = paramBaseArticleInfo.mSocialFeedInfo.jdField_c_of_type_JavaLangString;
        }
      }
    }
    paramJSONObject.put("biu_tips_text", str);
  }
  
  public static void b(ViewBase paramViewBase, IReadInJoyModel paramIReadInJoyModel)
  {
    if ((paramViewBase == null) || (paramIReadInJoyModel == null)) {}
    ReadInjoyTextView localReadInjoyTextView;
    do
    {
      return;
      paramIReadInJoyModel = paramIReadInJoyModel.a();
      localReadInjoyTextView = (ReadInjoyTextView)paramViewBase.findViewBaseByName("id_pack_bottom_label");
      paramViewBase = paramViewBase.findViewBaseByName("id_pack_bottom");
    } while ((localReadInjoyTextView == null) || (paramViewBase == null));
    if ((paramIReadInJoyModel != null) && (paramIReadInJoyModel.mSocialFeedInfo != null) && (paramIReadInJoyModel.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser != null) && (ExtraBiuBriefInfo.a(paramIReadInJoyModel)))
    {
      long l = paramIReadInJoyModel.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser.jdField_a_of_type_Long;
      localReadInjoyTextView.a("%s还biu了" + paramIReadInJoyModel.mExtraBiuBriefInfo.jdField_a_of_type_JavaUtilArrayList.size() + HardCodeUtil.a(2131715839), l);
      localReadInjoyTextView.setVisibility(0);
      paramViewBase.setVisibility(0);
      return;
    }
    paramViewBase.setVisibility(8);
  }
  
  static void b(JSONObject paramJSONObject)
  {
    Object localObject = ReadInJoyHelper.a("kd_topic_recommend_card_jump_switch");
    if ((localObject instanceof Boolean)) {}
    for (boolean bool = ((Boolean)localObject).booleanValue();; bool = false)
    {
      QLog.d("Util", 1, new Object[] { "bindTopicRecommendCardJumpWrapper, isJumpSwitchOn = ", Boolean.valueOf(bool) });
      if (bool) {
        paramJSONObject.put("id_jump_wrapper", new JSONObject());
      }
      return;
    }
  }
  
  @VisibleForTesting
  static void b(JSONObject paramJSONObject, BaseArticleInfo paramBaseArticleInfo)
  {
    int i;
    if ((RIJAladdinUtils.c()) && (!RIJAladdinUtils.b()))
    {
      i = paramBaseArticleInfo.mShareCount;
      if (i <= 0) {
        break label36;
      }
    }
    label36:
    for (paramBaseArticleInfo = ReadInJoyHelper.b(i);; paramBaseArticleInfo = HardCodeUtil.a(2131715781))
    {
      paramJSONObject.put("share_count_style_a", paramBaseArticleInfo);
      return;
    }
  }
  
  public static boolean b(BaseArticleInfo paramBaseArticleInfo)
  {
    boolean bool = true;
    if (paramBaseArticleInfo == null) {}
    do
    {
      return false;
      paramBaseArticleInfo = paramBaseArticleInfo.mSocialFeedInfo;
    } while (paramBaseArticleInfo == null);
    if (paramBaseArticleInfo.h == 1) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public static void c(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    if ((paramBaseArticleInfo == null) || (paramJSONObject == null)) {
      return;
    }
    if (paramBaseArticleInfo.subscriptLocation != 1)
    {
      QLog.d("Util", 2, "bindTopSuscriptInfo | not the right position");
      return;
    }
    paramJSONObject.put("top_mark_text", paramBaseArticleInfo.subscriptWording);
    paramJSONObject.put("top_corner_mark", paramBaseArticleInfo.subscriptType);
    if (!TextUtils.isEmpty(paramBaseArticleInfo.subscriptWordingColor)) {
      paramJSONObject.put("top_mark_color", paramBaseArticleInfo.subscriptWordingColor);
    }
    if (!TextUtils.isEmpty(paramBaseArticleInfo.subscriptBgColor)) {
      paramJSONObject.put("top_mark_backgroundcolor", paramBaseArticleInfo.subscriptBgColor);
    }
    QLog.d("Util", 2, "bindTopSuscriptInfo | outData : " + paramJSONObject.toString());
  }
  
  static void c(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject, String paramString)
  {
    if (ArticleInfoHelper.a(paramBaseArticleInfo)) {
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    paramBaseArticleInfo = paramString;
    if (TextUtils.isEmpty(paramString)) {
      paramBaseArticleInfo = HardCodeUtil.a(2131715831);
    }
    localJSONObject.put("read_article", paramBaseArticleInfo);
    paramJSONObject.put("id_read_article", localJSONObject);
    paramJSONObject.put("id_read_article_wrapper", new JSONObject());
  }
  
  public static void c(JSONObject paramJSONObject, BaseArticleInfo paramBaseArticleInfo)
  {
    paramJSONObject.put("dt_rowkey", paramBaseArticleInfo.innerUniqueID);
    paramJSONObject.put("dt_content_type", paramBaseArticleInfo.dtReportContentType);
    paramJSONObject.put("dt_channel_id", paramBaseArticleInfo.mChannelID);
    paramJSONObject.put("dt_backend_info", paramBaseArticleInfo.dtReportBackendInfo);
  }
  
  public static boolean c(BaseArticleInfo paramBaseArticleInfo)
  {
    boolean bool2 = false;
    if (paramBaseArticleInfo != null) {}
    for (boolean bool1 = paramBaseArticleInfo.needShowFollwedButton;; bool1 = false)
    {
      if (!bool1)
      {
        bool1 = bool2;
        if (paramBaseArticleInfo != null)
        {
          bool1 = bool2;
          if (paramBaseArticleInfo.isNeedShowBtnWhenFollowed)
          {
            bool1 = bool2;
            if (RIJItemViewType.d(paramBaseArticleInfo)) {}
          }
        }
      }
      else
      {
        bool1 = true;
      }
      return bool1;
    }
  }
  
  static void d(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("info_source_text", a(paramBaseArticleInfo.mSubscribeName));
    paramJSONObject.put("id_info_source", localJSONObject);
    if (!TextUtils.isEmpty(paramBaseArticleInfo.vIconUrl)) {
      paramJSONObject.put("icon_v_url", paramBaseArticleInfo.vIconUrl);
    }
  }
  
  public static void d(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject, String paramString)
  {
    Object localObject1;
    Object localObject2;
    int i;
    if ((paramBaseArticleInfo.mSocialFeedInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$WendaInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$WendaInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAnswerDetailInfo != null))
    {
      localObject1 = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$WendaInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAnswerDetailInfo.jdField_b_of_type_JavaLangString;
      localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("artilce_title_text", localObject1);
      if (!ReadInJoyLogicEngine.a().a(paramBaseArticleInfo.mArticleID)) {
        break label504;
      }
      localObject1 = "#999999";
      ((JSONObject)localObject2).put("title_text_color", localObject1);
      paramJSONObject.put("id_artilce_title", localObject2);
      localObject1 = "";
      if (!TextUtils.isEmpty(paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$WendaInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAnswerDetailInfo.jdField_c_of_type_JavaLangString)) {
        localObject1 = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$WendaInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAnswerDetailInfo.jdField_c_of_type_JavaLangString;
      }
      ((JSONObject)localObject2).put("summary_text", localObject1);
      paramJSONObject.put("id_summary", localObject2);
      i = 12;
      if (!TextUtils.isEmpty(paramString))
      {
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("article_small_imge_url", RIJSmartCropUtils.a(paramString, Utils.rp2px(114.0D), Utils.rp2px(87.0D)));
        paramJSONObject.put("id_article_small_imge", localObject1);
        i = 7;
      }
      if (TextUtils.isEmpty(paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$WendaInfo.l)) {
        break label528;
      }
      localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("info_status_text", paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$WendaInfo.l);
      paramString = "#fe6c6c";
      if (!TextUtils.isEmpty(paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$WendaInfo.m)) {
        paramString = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$WendaInfo.m;
      }
      ((JSONObject)localObject1).put("info_status_text_color", paramString);
      ((JSONObject)localObject1).put("setBorderColorString", paramString);
      paramJSONObject.put("id_info_status", localObject1);
      i -= 3;
    }
    label528:
    for (;;)
    {
      localObject2 = new StringBuilder();
      paramString = "0";
      if (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$WendaInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAnswerDetailInfo.jdField_a_of_type_Int > 0) {
        paramString = ReadInJoyHelper.a(paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$WendaInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAnswerDetailInfo.jdField_a_of_type_Int, 990000L, "99万", "0");
      }
      if (!TextUtils.isEmpty(paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$WendaInfo.j))
      {
        localObject1 = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$WendaInfo.j;
        paramBaseArticleInfo = (BaseArticleInfo)localObject1;
        if (((String)localObject1).length() > i) {
          paramBaseArticleInfo = ((String)localObject1).substring(0, i - 1) + "...";
        }
        ((StringBuilder)localObject2).append(paramBaseArticleInfo).append("的回答 · ").append(paramString).append("赞同");
      }
      for (;;)
      {
        paramBaseArticleInfo = new JSONObject();
        paramBaseArticleInfo.put("nickname_text", ((StringBuilder)localObject2).toString());
        paramJSONObject.put("id_nickname", paramBaseArticleInfo);
        return;
        label504:
        localObject1 = "#000000";
        break;
        ((StringBuilder)localObject2).append(paramString).append("赞同");
      }
    }
  }
  
  public static boolean d(BaseArticleInfo paramBaseArticleInfo)
  {
    return (paramBaseArticleInfo != null) && (paramBaseArticleInfo.mChannelID != 70L) && (RIJItemViewType.e(paramBaseArticleInfo));
  }
  
  static void e(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    paramBaseArticleInfo = NativeAdUtils.a(paramBaseArticleInfo, BaseApplicationImpl.getContext(), "latitude", "longitude");
    if (!TextUtils.isEmpty(paramBaseArticleInfo))
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("ad_Location", paramBaseArticleInfo);
      paramJSONObject.put("id_view_ad_coordinateView", localJSONObject);
    }
  }
  
  public static boolean e(BaseArticleInfo paramBaseArticleInfo)
  {
    return (paramBaseArticleInfo != null) && (paramBaseArticleInfo.mChannelID != 70L) && (RIJItemViewType.f(paramBaseArticleInfo));
  }
  
  static void f(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    if ((paramBaseArticleInfo != null) && (AdvertisementInfo.isAdvertisementInfo(paramBaseArticleInfo)))
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("article_model", paramBaseArticleInfo);
      paramJSONObject.put("id_view_AdBanner", localJSONObject);
    }
  }
  
  private static boolean f(BaseArticleInfo paramBaseArticleInfo)
  {
    if (!(paramBaseArticleInfo instanceof ArticleInfo)) {
      return false;
    }
    String str;
    if (RIJItemViewType.i((ArticleInfo)paramBaseArticleInfo)) {
      str = "ugcShowPostTimeLabel";
    }
    for (;;)
    {
      if (((d(paramBaseArticleInfo)) || (RIJItemViewType.b(paramBaseArticleInfo))) && (Aladdin.getConfig(297).getIntegerFromString(str, 0) == 1)) {}
      for (boolean bool = true;; bool = false)
      {
        return bool;
        if (RIJItemViewType.a(paramBaseArticleInfo))
        {
          str = "commentShowPostTimeLabel";
          break;
        }
        if (RIJItemViewType.e((ArticleInfo)paramBaseArticleInfo))
        {
          str = "biuShowPostTimeLabel";
          break;
        }
        if (RIJItemViewType.b((ArticleInfo)paramBaseArticleInfo))
        {
          str = "pgcShowPostTimeLabel";
          break;
        }
        if ((RIJItemViewType.b(paramBaseArticleInfo)) && (!RIJItemViewType.o(paramBaseArticleInfo)) && (!RIJItemViewType.q(paramBaseArticleInfo)))
        {
          str = "partnerShowPostTimeLabel";
          break;
        }
        if (RIJItemViewType.c(paramBaseArticleInfo))
        {
          str = "liveSingleCardShowPostTimeLabel";
          break;
        }
        if (RIJItemViewType.o(paramBaseArticleInfo))
        {
          str = "wechatVideoCardShowPostTimeLabel";
          break;
        }
        if (!RIJItemViewType.q(paramBaseArticleInfo)) {
          break label179;
        }
        str = "HotSearchCardShowPostTimeLabel";
        break;
      }
      label179:
      str = "";
    }
  }
  
  static void g(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = new JSONObject();
    if (DailyModeConfigHandler.a((int)paramBaseArticleInfo.mChannelID)) {}
    while (paramBaseArticleInfo.isCloseDislike == 1) {
      return;
    }
    localJSONObject.put("feeds_dislike_icon", "feeds_dislike");
    paramJSONObject.put("id_dislike_button", localJSONObject);
  }
  
  private static boolean g(BaseArticleInfo paramBaseArticleInfo)
  {
    return (paramBaseArticleInfo.mTopicRecommendFeedsInfo != null) && (paramBaseArticleInfo.mTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList.size() > 0);
  }
  
  static void h(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    if ((paramBaseArticleInfo != null) && (paramBaseArticleInfo.hasFamilyCommentIcon()))
    {
      j(paramBaseArticleInfo, paramJSONObject);
      return;
    }
    i(paramBaseArticleInfo, paramJSONObject);
  }
  
  private static boolean h(BaseArticleInfo paramBaseArticleInfo)
  {
    return (RIJItemViewType.a(paramBaseArticleInfo)) || (RIJItemViewType.d(paramBaseArticleInfo)) || (RIJItemViewType.o(paramBaseArticleInfo));
  }
  
  static void i(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    long l = 0L;
    if (paramBaseArticleInfo == null) {
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramBaseArticleInfo.mCommentCount > 0L)
    {
      l = paramBaseArticleInfo.mCommentCount;
      label41:
      if (!ReadInJoyHelper.a(paramBaseArticleInfo, l)) {
        break label126;
      }
      if (l <= 99990000L) {
        break label128;
      }
      localStringBuilder.append("9999万+");
      label68:
      if (paramBaseArticleInfo.mFeedType == 39) {
        break label188;
      }
      localStringBuilder.append("评论");
    }
    for (;;)
    {
      localJSONObject.put("article_comment_num", localStringBuilder.toString());
      paramJSONObject.put("id_comment_num", localJSONObject);
      return;
      if (paramBaseArticleInfo.mVideoCommentCount <= 0) {
        break label41;
      }
      l = paramBaseArticleInfo.mVideoCommentCount;
      break label41;
      label126:
      break;
      label128:
      if (l > 10000L)
      {
        double d = l / 10000.0D;
        localStringBuilder.append(new DecimalFormat("0.0").format(d));
        localStringBuilder.append("万");
        break label68;
      }
      localStringBuilder.append(l);
      break label68;
      label188:
      localStringBuilder.append("人在玩");
    }
  }
  
  private static boolean i(BaseArticleInfo paramBaseArticleInfo)
  {
    if (!(paramBaseArticleInfo instanceof ArticleInfo)) {
      return false;
    }
    String str;
    if (RIJItemViewType.i((ArticleInfo)paramBaseArticleInfo)) {
      str = "ugcShowFollowBtn";
    }
    for (;;)
    {
      if (((d(paramBaseArticleInfo)) || (RIJItemViewType.b(paramBaseArticleInfo))) && (Aladdin.getConfig(297).getIntegerFromString(str, 0) == 1) && (paramBaseArticleInfo.isShowFollowButton == 1)) {}
      for (boolean bool = true;; bool = false)
      {
        return bool;
        if (RIJItemViewType.a(paramBaseArticleInfo))
        {
          str = "commentShowFollowBtn";
          break;
        }
        if (RIJItemViewType.e((ArticleInfo)paramBaseArticleInfo))
        {
          str = "biuShowFollowBtn";
          break;
        }
        if (RIJItemViewType.b((ArticleInfo)paramBaseArticleInfo))
        {
          str = "pgcShowFollowBtn";
          break;
        }
        if ((RIJItemViewType.b(paramBaseArticleInfo)) && (!RIJItemViewType.o(paramBaseArticleInfo)) && (!RIJItemViewType.q(paramBaseArticleInfo)))
        {
          str = "partnerShowFollowBtn";
          break;
        }
        if (RIJItemViewType.c(paramBaseArticleInfo))
        {
          str = "liveSingleCardShowFollowBtn";
          break;
        }
        if (RIJItemViewType.o(paramBaseArticleInfo))
        {
          str = "wechatVideoCardShowFollowBtn";
          break;
        }
        if (!RIJItemViewType.q(paramBaseArticleInfo)) {
          break label187;
        }
        str = "HotSearchCardShowFollowBtn";
        break;
      }
      label187:
      str = "";
    }
  }
  
  static void j(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    if ((paramBaseArticleInfo == null) || (paramBaseArticleInfo.familyCommentInfo == null)) {}
    while ((TextUtils.isEmpty(paramBaseArticleInfo.familyCommentInfo.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(paramBaseArticleInfo.familyCommentInfo.jdField_b_of_type_JavaLangString))) {
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("family_icon_url", paramBaseArticleInfo.familyCommentInfo.jdField_a_of_type_JavaLangString);
    localJSONObject.put("family_jump_schema", paramBaseArticleInfo.familyCommentInfo.jdField_b_of_type_JavaLangString);
    if (paramBaseArticleInfo.familyCommentInfo.jdField_b_of_type_Int > 0) {
      localJSONObject.put("family_icon_wh_rate", paramBaseArticleInfo.familyCommentInfo.jdField_a_of_type_Int / paramBaseArticleInfo.familyCommentInfo.jdField_b_of_type_Int);
    }
    paramJSONObject.put("id_img_family_icon", localJSONObject);
  }
  
  private static boolean j(BaseArticleInfo paramBaseArticleInfo)
  {
    if (paramBaseArticleInfo == null)
    {
      QLog.d("Util", 2, "info == null");
      return false;
    }
    if (paramBaseArticleInfo.mSocialFeedInfo == null)
    {
      QLog.d("Util", 2, "info == " + paramBaseArticleInfo);
      return false;
    }
    return true;
  }
  
  static void k(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    if (paramBaseArticleInfo.mSocialFeedInfo == null) {
      return;
    }
    localObject = new JSONObject();
    long l1;
    if (!TextUtils.isEmpty(paramBaseArticleInfo.mSubscribeID)) {
      l1 = 0L;
    }
    try
    {
      long l2 = Long.parseLong(paramBaseArticleInfo.mSubscribeID);
      l1 = l2;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        JSONObject localJSONObject;
        localNumberFormatException.printStackTrace();
        continue;
        ((JSONObject)localObject).put("selected_state", "0");
      }
    }
    ((JSONObject)localObject).put("info_avator_uin", l1);
    ((JSONObject)localObject).put("article_model", paramBaseArticleInfo);
    paramJSONObject.put("id_info_avator", localObject);
    localObject = new JSONObject();
    ((JSONObject)localObject).put("nickname_text", RIJStringUtils.a(paramBaseArticleInfo.mSubscribeName));
    paramJSONObject.put("id_nickname", localObject);
    paramJSONObject.put("id_view_nickname", new JSONObject());
    localJSONObject = new JSONObject();
    localObject = HardCodeUtil.a(2131715828);
    if (paramBaseArticleInfo.mSocialFeedInfo.jdField_d_of_type_Int > 0) {
      localObject = ReadInJoyHelper.a(paramBaseArticleInfo.mSocialFeedInfo.jdField_d_of_type_Int, 990000L, "99万", "0");
    }
    localJSONObject.put("text", localObject);
    paramJSONObject.put("id_img_comment_num", localJSONObject);
    localObject = new JSONObject();
    ((JSONObject)localObject).put("comment_count", "");
    paramJSONObject.put("id_comment_button", localObject);
    localJSONObject = new JSONObject();
    localObject = HardCodeUtil.a(2131715837);
    if (paramBaseArticleInfo.mSocialFeedInfo.jdField_b_of_type_Int > 0) {
      localObject = ReadInJoyHelper.a(paramBaseArticleInfo.mSocialFeedInfo.jdField_b_of_type_Int, 990000L, "99万", "0");
    }
    localJSONObject.put("text", localObject);
    paramJSONObject.put("id_img_like_num", localJSONObject);
    localObject = new JSONObject();
    ((JSONObject)localObject).put("like_count", "");
    if (paramBaseArticleInfo.mSocialFeedInfo.jdField_c_of_type_Int == 1)
    {
      ((JSONObject)localObject).put("selected_state", "1");
      paramJSONObject.put("id_like_button", localObject);
      paramJSONObject.put("id_share_button", new JSONObject());
      paramJSONObject.put("id_img_biu_right", new JSONObject());
      paramJSONObject.put("id_biu_separator", new JSONObject());
      paramJSONObject.put("id_view_comment", new JSONObject());
      paramJSONObject.put("id_view_like", new JSONObject());
      paramJSONObject.put("id_view_share", new JSONObject());
      paramJSONObject.put("id_img_biu_bottom", new JSONObject());
      c(paramJSONObject, paramBaseArticleInfo);
      return;
    }
  }
  
  private static boolean k(BaseArticleInfo paramBaseArticleInfo)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList != null)
    {
      bool1 = bool2;
      if (paramBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList.size() > 0)
      {
        bool1 = bool2;
        if (paramBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList.get(0) != null) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  static void l(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    if (paramBaseArticleInfo == null) {}
    while ((paramBaseArticleInfo.mSocialFeedInfo == null) || (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser == null) || (!paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser.a())) {
      return;
    }
    new JSONObject();
    paramJSONObject.put("star_postmark", "readinjoy_star_postmark.png");
  }
  
  static void m(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    if (paramBaseArticleInfo == null) {}
    while ((TextUtils.isEmpty(paramBaseArticleInfo.mDianDianLabelIconUrl)) || (TextUtils.isEmpty(paramBaseArticleInfo.mDianDianLabelText))) {
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    paramJSONObject.put("id_label_wrapper", localJSONObject);
    paramJSONObject.put("id_label_header", localJSONObject);
    paramJSONObject.put("id_label_separator_line", localJSONObject);
    localJSONObject = new JSONObject();
    localJSONObject.put("label_icon_url", paramBaseArticleInfo.mDianDianLabelIconUrl);
    paramJSONObject.put("id_label_icon", localJSONObject);
    localJSONObject = new JSONObject();
    localJSONObject.put("label_text", paramBaseArticleInfo.mDianDianLabelText);
    paramJSONObject.put("id_label_text", localJSONObject);
  }
  
  static void n(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    paramJSONObject.put("id_separator", new JSONObject());
  }
  
  static void o(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    Object localObject = paramBaseArticleInfo.multiBiuSameContentList;
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      paramBaseArticleInfo = new JSONObject();
      localObject = ((List)localObject).iterator();
      int i = 1;
      while (((Iterator)localObject).hasNext())
      {
        MultiBiuSameContent localMultiBiuSameContent = (MultiBiuSameContent)((Iterator)localObject).next();
        paramBaseArticleInfo.put(localMultiBiuSameContent.jdField_a_of_type_Long + "" + i, localMultiBiuSameContent.jdField_a_of_type_Long);
        i += 1;
      }
      localObject = new JSONObject();
      ((JSONObject)localObject).put("uin_list", paramBaseArticleInfo);
      paramJSONObject.put("id_friends_biu", localObject);
      paramJSONObject.put("id_friends_biu_wrapper", new JSONObject());
      paramJSONObject.put("id_friends_biu_separator_line", new JSONObject());
    }
  }
  
  static void p(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    if (paramBaseArticleInfo.mSocialFeedInfo != null)
    {
      Object localObject = paramBaseArticleInfo.mSocialFeedInfo;
      if (1 == ((SocializeFeedsInfo)localObject).l)
      {
        paramBaseArticleInfo = ((SocializeFeedsInfo)localObject).jdField_f_of_type_JavaLangString;
        localObject = ((SocializeFeedsInfo)localObject).g;
        if ((!TextUtils.isEmpty(paramBaseArticleInfo)) && (!TextUtils.isEmpty((CharSequence)localObject)))
        {
          JSONObject localJSONObject = b();
          localJSONObject.put("jump_channel_bar_url", paramBaseArticleInfo);
          paramJSONObject.put("id_jump_channel_bar", localJSONObject);
          paramBaseArticleInfo = b();
          paramBaseArticleInfo.put("jump_channel_name", localObject);
          paramJSONObject.put("id_jump_channel_name", paramBaseArticleInfo);
          paramJSONObject.put("id_jump_channel_separator", b());
        }
      }
    }
  }
  
  static void q(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    if (paramBaseArticleInfo.mSocialFeedInfo != null)
    {
      paramBaseArticleInfo = paramBaseArticleInfo.mSocialFeedInfo;
      if (paramBaseArticleInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyMedalInfo != null) {
        RIJMedalUtils.a(paramJSONObject, paramBaseArticleInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyMedalInfo);
      }
    }
  }
  
  static void r(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = new JSONObject();
    if (RIJItemViewType.d(paramBaseArticleInfo))
    {
      if (e(paramBaseArticleInfo))
      {
        paramJSONObject.put("id_social_header_padding_view", localJSONObject);
        return;
      }
      paramJSONObject.put("id_feeds_social_header_wrapper", localJSONObject);
      paramJSONObject.put("id_feeds_social_header", localJSONObject);
      return;
    }
    paramJSONObject.put("id_social_header_wrapper", localJSONObject);
    paramJSONObject.put("id_social_header", localJSONObject);
  }
  
  static void s(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    new JSONObject();
    paramJSONObject.put("nickname_text", RIJStringUtils.a(paramBaseArticleInfo.mSubscribeName));
    c(paramJSONObject, paramBaseArticleInfo);
  }
  
  static void t(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = new JSONObject();
    if (!TextUtils.isEmpty(paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser.jdField_a_of_type_JavaLangString))
    {
      localJSONObject.put("short_content_desc_text", paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser.jdField_a_of_type_JavaLangString);
      paramJSONObject.put("id_description_label", localJSONObject);
    }
  }
  
  static void u(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    if ((paramBaseArticleInfo == null) || (paramBaseArticleInfo.mSocialFeedInfo == null) || (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser == null)) {
      return;
    }
    String str = ReadInJoyUserInfoModule.a();
    new JSONObject();
    paramJSONObject.put("nickname_text", RIJStringUtils.a(str));
    c(paramJSONObject, paramBaseArticleInfo);
  }
  
  static void v(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    if (paramBaseArticleInfo == null) {
      return;
    }
    String str = a(paramBaseArticleInfo);
    if (!TextUtils.isEmpty(str)) {
      paramJSONObject.put("biu_time_text", str);
    }
    x(paramBaseArticleInfo, paramJSONObject);
  }
  
  public static void w(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    if (paramBaseArticleInfo == null) {
      return;
    }
    paramJSONObject.put("header_extra_info", Aladdin.getConfig(393).getString("comment_social_header_description", ""));
  }
  
  public static void x(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    if ((RIJItemViewType.d(paramBaseArticleInfo)) && (!c(paramBaseArticleInfo)) && (paramBaseArticleInfo.mSocialFeedInfo.h == 2)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        paramBaseArticleInfo.showMyFollowText = 1;
        paramJSONObject.put("user_desc_follow_text", HardCodeUtil.a(2131718469));
        return;
      }
      paramBaseArticleInfo.showMyFollowText = 0;
      c(paramBaseArticleInfo, paramJSONObject);
      return;
    }
  }
  
  static void y(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    if ((paramBaseArticleInfo.mSocialFeedInfo == null) || (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo == null) || (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$AccountProfileInfo == null)) {
      return;
    }
    paramBaseArticleInfo = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$AccountProfileInfo;
    paramJSONObject.put("id_account_card_container", b());
    paramJSONObject.put("id_cmp_account_card", b());
    JSONObject localJSONObject = b();
    localJSONObject.put("cmp_account_card_avator", paramBaseArticleInfo.jdField_b_of_type_JavaLangString);
    paramJSONObject.put("id_cmp_account_card_avator", localJSONObject);
    localJSONObject = b();
    localJSONObject.put("cmp_account_card_name", paramBaseArticleInfo.jdField_a_of_type_JavaLangString);
    paramJSONObject.put("id_cmp_account_card_name", localJSONObject);
    localJSONObject = b();
    localJSONObject.put("cmp_account_card_desc", paramBaseArticleInfo.jdField_c_of_type_JavaLangString);
    paramJSONObject.put("id_cmp_account_card_desc", localJSONObject);
  }
  
  static void z(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    if (!g(paramBaseArticleInfo))
    {
      QLog.d("Util", 1, "bindTopicRecommendHeader failed, not topicInfo.");
      return;
    }
    paramJSONObject.put("id_topic_recommend_header", new JSONObject());
    Object localObject = new JSONObject();
    ((JSONObject)localObject).put("topic_name", paramBaseArticleInfo.businessNamePrefix + paramBaseArticleInfo.businessName);
    paramJSONObject.put("id_topic_name", localObject);
    localObject = new JSONObject();
    ((JSONObject)localObject).put("topic_avator_url", ((TopicRecommendFeedsInfo.TopicRecommendInfo)paramBaseArticleInfo.mTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_d_of_type_JavaLangString);
    paramJSONObject.put("id_topic_avator", localObject);
    B(paramBaseArticleInfo, paramJSONObject);
    JSONObject localJSONObject;
    int i;
    if ((RIJFeedsType.c((ArticleInfo)paramBaseArticleInfo)) || (RIJFeedsType.f((ArticleInfo)paramBaseArticleInfo)))
    {
      localJSONObject = new JSONObject();
      if (((TopicRecommendFeedsInfo.TopicRecommendInfo)paramBaseArticleInfo.mTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_c_of_type_Int != 1) {
        break label336;
      }
      i = 1;
      if (i == 0) {
        break label341;
      }
      localObject = HardCodeUtil.a(2131715832);
      label186:
      localJSONObject.put("button_status", localObject);
      if (i == 0) {
        break label351;
      }
    }
    label336:
    label341:
    label351:
    for (localObject = "1";; localObject = "0")
    {
      localJSONObject.put("selected_status", localObject);
      paramJSONObject.put("id_follow_button", localJSONObject);
      paramJSONObject.put("id_header_line", new JSONObject());
      localObject = new JSONObject();
      ((JSONObject)localObject).put("topic_name_only", paramBaseArticleInfo.businessName);
      paramJSONObject.put("id_topic_name_only", localObject);
      paramJSONObject.put("id_topic_more", new JSONObject());
      localObject = new JSONObject();
      ((JSONObject)localObject).put("topic_pre", paramBaseArticleInfo.businessNamePrefix);
      paramJSONObject.put("id_topic_pre", localObject);
      paramBaseArticleInfo = new JSONObject();
      paramBaseArticleInfo.put("topic_arrow_img", "topic_arrow_image");
      paramJSONObject.put("id_topic_arrow_img", paramBaseArticleInfo);
      return;
      i = 0;
      break;
      localObject = HardCodeUtil.a(2131715826);
      break label186;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.data.Util
 * JD-Core Version:    0.7.0.1
 */