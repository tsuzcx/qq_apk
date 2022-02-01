package com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.comment;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.ReadInJoyMedalInfo;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.RIJItemViewType;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJJumpUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class RIJMedalUtils
{
  public static void a(Context paramContext, ReadInJoyMedalInfo paramReadInJoyMedalInfo)
  {
    if ((paramContext != null) && (paramReadInJoyMedalInfo != null) && (!TextUtils.isEmpty(paramReadInJoyMedalInfo.jdField_c_of_type_JavaLangString)))
    {
      if (1 == paramReadInJoyMedalInfo.jdField_b_of_type_Int) {
        RIJJumpUtils.a(paramContext, paramReadInJoyMedalInfo.jdField_c_of_type_JavaLangString);
      }
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, null, "0X8009BD5", "0X8009BD5", 0, 0, "", "", "", paramReadInJoyMedalInfo.a(), false);
    }
  }
  
  public static void a(Context paramContext, BaseArticleInfo paramBaseArticleInfo)
  {
    if ((paramContext != null) && (paramBaseArticleInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo != null)) {}
    try
    {
      ReadInJoyMedalInfo localReadInJoyMedalInfo = paramBaseArticleInfo.mSocialFeedInfo.a;
      b(localReadInJoyMedalInfo, paramBaseArticleInfo);
      a(paramContext, localReadInJoyMedalInfo);
      return;
    }
    catch (Exception paramContext)
    {
      QLog.e("RIJMedalUtils", 2, paramContext.getMessage());
    }
  }
  
  public static void a(ReadInJoyMedalInfo paramReadInJoyMedalInfo)
  {
    if (paramReadInJoyMedalInfo == null) {
      return;
    }
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, null, "0X8009BD4", "0X8009BD4", 0, 0, "", "", "", paramReadInJoyMedalInfo.a(), false);
  }
  
  public static void a(ReadInJoyMedalInfo paramReadInJoyMedalInfo, BaseArticleInfo paramBaseArticleInfo)
  {
    if ((paramReadInJoyMedalInfo != null) && (paramBaseArticleInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo != null))
    {
      b(paramReadInJoyMedalInfo, paramBaseArticleInfo);
      a(paramReadInJoyMedalInfo);
    }
  }
  
  public static void a(JSONObject paramJSONObject, ReadInJoyMedalInfo paramReadInJoyMedalInfo)
  {
    if ((paramJSONObject == null) || (paramReadInJoyMedalInfo == null)) {
      return;
    }
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(paramReadInJoyMedalInfo.jdField_b_of_type_JavaLangString))
        {
          QLog.d("RIJMedalUtils", 1, "bindMedalData : " + paramJSONObject.toString());
          return;
        }
      }
      catch (Exception paramJSONObject)
      {
        QLog.e("RIJMedalUtils", 2, paramJSONObject.getMessage());
        return;
      }
      if ((paramReadInJoyMedalInfo.jdField_c_of_type_Int > 0) && (paramReadInJoyMedalInfo.jdField_d_of_type_Int > 0))
      {
        paramJSONObject.put("header_medal_jump_url", paramReadInJoyMedalInfo.jdField_c_of_type_JavaLangString);
        paramJSONObject.put("header_medal_wh_rate", Double.valueOf(paramReadInJoyMedalInfo.jdField_c_of_type_Int).doubleValue() / paramReadInJoyMedalInfo.jdField_d_of_type_Int);
        paramJSONObject.put("header_medal_image_url", paramReadInJoyMedalInfo.jdField_b_of_type_JavaLangString);
      }
    }
  }
  
  public static void b(ReadInJoyMedalInfo paramReadInJoyMedalInfo, BaseArticleInfo paramBaseArticleInfo)
  {
    if (paramReadInJoyMedalInfo != null) {
      for (;;)
      {
        try
        {
          paramReadInJoyMedalInfo.jdField_d_of_type_JavaLangString = String.valueOf(paramBaseArticleInfo.mChannelID);
          paramReadInJoyMedalInfo.g = String.valueOf(paramBaseArticleInfo.mFeedId);
          paramBaseArticleInfo = (ArticleInfo)paramBaseArticleInfo;
          paramReadInJoyMedalInfo.h = String.valueOf(paramBaseArticleInfo.mSubscribeID);
          if ((RIJItemViewType.g(paramBaseArticleInfo)) || (RIJItemViewType.a(paramBaseArticleInfo)))
          {
            paramReadInJoyMedalInfo.f = "5";
            paramReadInJoyMedalInfo.e = "2";
            return;
          }
          if (RIJItemViewType.e(paramBaseArticleInfo)) {
            paramReadInJoyMedalInfo.f = "4";
          } else {
            paramReadInJoyMedalInfo.f = "0";
          }
        }
        catch (Exception paramReadInJoyMedalInfo)
        {
          QLog.e("RIJMedalUtils", 2, paramReadInJoyMedalInfo.getMessage());
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.comment.RIJMedalUtils
 * JD-Core Version:    0.7.0.1
 */