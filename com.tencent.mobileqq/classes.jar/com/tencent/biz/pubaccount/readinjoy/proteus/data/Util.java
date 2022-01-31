package com.tencent.biz.pubaccount.readinjoy.proteus.data;

import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyTimeUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.BiuCommentInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.BiuInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.FeedsInfoUser;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicRecommendFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicRecommendFeedsInfo.TopicRecommendInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class Util
{
  public static String a(int paramInt, String paramString)
  {
    if (paramInt == 0) {
      return paramString;
    }
    if (paramInt < 10000) {
      return String.valueOf(paramInt);
    }
    if (paramInt < 100000000)
    {
      paramInt /= 10000;
      return String.valueOf(paramInt) + "万";
    }
    paramInt /= 100000000;
    return String.valueOf(paramInt) + "亿";
  }
  
  private static String a(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  static void a(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    if (!TextUtils.isEmpty(paramBaseArticleInfo.mArticleSubscriptText))
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("info_status_text", a(paramBaseArticleInfo.mArticleSubscriptText));
      localJSONObject.put("info_status_text_color", paramBaseArticleInfo.mArticleSubscriptColor);
      paramJSONObject.put("id_info_status", localJSONObject);
    }
  }
  
  static void a(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject, Long paramLong)
  {
    paramBaseArticleInfo = new JSONObject();
    paramBaseArticleInfo.put("info_avator_uin", paramLong);
    paramJSONObject.put("id_info_avator", paramBaseArticleInfo);
  }
  
  static void a(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject, boolean paramBoolean)
  {
    String str = paramBaseArticleInfo.mTitle;
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("artilce_title_text", str);
    boolean bool = ReadInJoyLogicEngine.a().a(paramBaseArticleInfo.mArticleID);
    if (paramBoolean) {
      if (!bool) {
        break label66;
      }
    }
    label66:
    for (paramBaseArticleInfo = "#999999";; paramBaseArticleInfo = "#000000")
    {
      localJSONObject.put("title_text_color", paramBaseArticleInfo);
      paramJSONObject.put("id_artilce_title", localJSONObject);
      return;
    }
  }
  
  static void a(JSONObject paramJSONObject)
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
  
  static void a(JSONObject paramJSONObject, BaseArticleInfo paramBaseArticleInfo)
  {
    if (paramBaseArticleInfo.proteusItemsData == null) {}
    for (;;)
    {
      return;
      try
      {
        paramBaseArticleInfo = new JSONObject(paramBaseArticleInfo.proteusItemsData);
        Iterator localIterator = paramBaseArticleInfo.keys();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          paramJSONObject.put(str, paramBaseArticleInfo.getJSONObject(str));
        }
        return;
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
      }
    }
  }
  
  private static boolean a(BaseArticleInfo paramBaseArticleInfo)
  {
    return (paramBaseArticleInfo.mTopicRecommendFeedsInfo != null) && (paramBaseArticleInfo.mTopicRecommendFeedsInfo.a.size() > 0);
  }
  
  static void b(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("info_source_text", a(paramBaseArticleInfo.mSubscribeName));
    paramJSONObject.put("id_info_source", localJSONObject);
  }
  
  static void c(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    String str2 = "";
    String str1 = str2;
    if (AdvertisementInfo.isAppAdvertisementInfo(paramBaseArticleInfo)) {
      paramBaseArticleInfo = (AdvertisementInfo)paramBaseArticleInfo;
    }
    try
    {
      paramBaseArticleInfo = new JSONObject(paramBaseArticleInfo.mAdExt).optString("pkg_name");
      if (PackageUtil.a(BaseApplicationImpl.getContext(), paramBaseArticleInfo)) {}
      for (str1 = BaseApplicationImpl.getContext().getResources().getString(2131438668);; str1 = BaseApplicationImpl.getContext().getResources().getString(2131438667))
      {
        if (!TextUtils.isEmpty(str1))
        {
          paramBaseArticleInfo = new JSONObject();
          paramBaseArticleInfo.put("view_app_text", str1);
          paramJSONObject.put("id_view_app", paramBaseArticleInfo);
        }
        return;
      }
    }
    catch (JSONException paramBaseArticleInfo)
    {
      for (;;)
      {
        QLog.d("Util", 2, "bindAppButton: fail to bind advertisement");
        str1 = str2;
      }
    }
  }
  
  static void d(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    paramJSONObject.put("id_dislike_button", new JSONObject());
  }
  
  static void e(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    paramJSONObject.put("id_separator", new JSONObject());
  }
  
  static void f(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("nickname_text", ReadInJoyUtils.d(paramBaseArticleInfo.mSubscribeName));
    paramJSONObject.put("id_nickname", localJSONObject);
  }
  
  static void g(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    paramBaseArticleInfo = ContactUtils.b((QQAppInterface)ReadInJoyUtils.a(), String.valueOf(paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser.a), true);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("nickname_text", ReadInJoyUtils.d(paramBaseArticleInfo));
    paramJSONObject.put("id_nickname", localJSONObject);
  }
  
  static void h(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramBaseArticleInfo.mTime > 0L) {}
    for (paramBaseArticleInfo = ReadInJoyTimeUtils.a(paramBaseArticleInfo.mTime, true);; paramBaseArticleInfo = "刚刚")
    {
      localJSONObject.put("biu_time_text", paramBaseArticleInfo);
      paramJSONObject.put("id_biu_time", localJSONObject);
      return;
    }
  }
  
  static void i(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    if (!a(paramBaseArticleInfo))
    {
      QLog.d("Util", 1, "bindTopicRecommendHeader failed, not topicInfo.");
      return;
    }
    paramJSONObject.put("id_topic_recommend_header", new JSONObject());
    Object localObject = new JSONObject();
    ((JSONObject)localObject).put("topic_name", paramBaseArticleInfo.businessNamePrefix + paramBaseArticleInfo.businessName);
    paramJSONObject.put("id_topic_name", localObject);
    localObject = new JSONObject();
    ((JSONObject)localObject).put("topic_avator_url", ((TopicRecommendFeedsInfo.TopicRecommendInfo)paramBaseArticleInfo.mTopicRecommendFeedsInfo.a.get(0)).d);
    paramJSONObject.put("id_topic_avator", localObject);
    j(paramBaseArticleInfo, paramJSONObject);
    JSONObject localJSONObject;
    int i;
    if ((ReadInJoyUtils.b((ArticleInfo)paramBaseArticleInfo)) || (ReadInJoyUtils.d((ArticleInfo)paramBaseArticleInfo)))
    {
      localJSONObject = new JSONObject();
      if (((TopicRecommendFeedsInfo.TopicRecommendInfo)paramBaseArticleInfo.mTopicRecommendFeedsInfo.a.get(0)).c != 1) {
        break label343;
      }
      i = 1;
      if (i == 0) {
        break label348;
      }
      localObject = "已关注";
      label188:
      localJSONObject.put("button_status", localObject);
      if (i == 0) {
        break label355;
      }
    }
    label343:
    label348:
    label355:
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
      localObject = "关注";
      break label188;
    }
  }
  
  static void j(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    if (!a(paramBaseArticleInfo))
    {
      QLog.d("Util", 1, "bindTopicTimeAndReason failed, not topicInfo.");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    if ((ReadInJoyUtils.c((ArticleInfo)paramBaseArticleInfo)) || (ReadInJoyUtils.e((ArticleInfo)paramBaseArticleInfo)))
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
      if (TextUtils.isEmpty(paramBaseArticleInfo.mTopicRecommendFeedsInfo.b)) {
        break label155;
      }
      localStringBuilder.append(paramBaseArticleInfo.mTopicRecommendFeedsInfo.b);
    }
    for (;;)
    {
      paramBaseArticleInfo = new JSONObject();
      paramBaseArticleInfo.put("biu_time_text", localStringBuilder.toString());
      paramJSONObject.put("id_biu_time", paramBaseArticleInfo);
      return;
      localStringBuilder.append("刚刚");
      break;
      label155:
      if (paramBaseArticleInfo.mTopicRecommendFeedsInfo.a.get(0) != null) {
        localStringBuilder.append(ReadInJoyHelper.a(((TopicRecommendFeedsInfo.TopicRecommendInfo)paramBaseArticleInfo.mTopicRecommendFeedsInfo.a.get(0)).b) + "人参与");
      }
    }
  }
  
  static void k(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    paramBaseArticleInfo = paramBaseArticleInfo.mSocialFeedInfo;
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("like_count", a(paramBaseArticleInfo.b, "赞"));
    if (paramBaseArticleInfo.c == 1) {
      localJSONObject.put("selected_state", "1");
    }
    for (;;)
    {
      paramJSONObject.put("id_like_button", localJSONObject);
      localJSONObject = new JSONObject();
      localJSONObject.put("comment_count", a(paramBaseArticleInfo.d, "评论"));
      paramJSONObject.put("id_comment_button", localJSONObject);
      localJSONObject = new JSONObject();
      localJSONObject.put("biu_count", a(paramBaseArticleInfo.f, "Biu"));
      paramJSONObject.put("id_biu_button", localJSONObject);
      return;
      localJSONObject.put("selected_state", "0");
    }
  }
  
  static void l(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    paramBaseArticleInfo = paramBaseArticleInfo.mSocialFeedInfo;
    if (((paramBaseArticleInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo != null) && (paramBaseArticleInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.a != null) && (paramBaseArticleInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.a.size() > 0) && ((paramBaseArticleInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.a.size() != 1) || ((!TextUtils.isEmpty(((SocializeFeedsInfo.BiuCommentInfo)paramBaseArticleInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.a.get(0)).jdField_a_of_type_JavaLangString)) && (!TextUtils.equals(((SocializeFeedsInfo.BiuCommentInfo)paramBaseArticleInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.a.get(0)).jdField_a_of_type_JavaLangString, ":")) && (!TextUtils.equals(((SocializeFeedsInfo.BiuCommentInfo)paramBaseArticleInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.a.get(0)).jdField_a_of_type_JavaLangString, "："))))) || (!TextUtils.isEmpty(paramBaseArticleInfo.jdField_a_of_type_JavaLangString))) {
      paramJSONObject.put("id_biu_comment", new JSONObject());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.data.Util
 * JD-Core Version:    0.7.0.1
 */