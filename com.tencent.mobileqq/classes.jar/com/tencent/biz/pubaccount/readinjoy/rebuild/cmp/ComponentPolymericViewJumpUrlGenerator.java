package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyConstants;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.RIJItemViewType;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.FeedsInfoUser;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicRecommendFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicRecommendFeedsInfo.TopicRecommendInfo;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class ComponentPolymericViewJumpUrlGenerator
{
  @Nullable
  public static String a(int paramInt, ArticleInfo paramArticleInfo)
  {
    Object localObject;
    if (paramArticleInfo == null)
    {
      localObject = null;
      return localObject;
    }
    String str = "";
    if (paramInt == 79) {
      str = a(paramArticleInfo);
    }
    if ((RIJItemViewType.a(paramArticleInfo)) || (RIJItemViewType.h(paramArticleInfo)) || (paramInt == 77) || (paramInt == 78)) {}
    for (str = b(paramArticleInfo);; str = c(paramArticleInfo)) {
      do
      {
        localObject = str;
        if (!TextUtils.isEmpty(str)) {
          break;
        }
        return d(paramArticleInfo);
      } while ((!RIJItemViewType.g(paramArticleInfo)) && (paramInt != 76));
    }
  }
  
  @Nullable
  private static String a(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo.mTopicRecommendFeedsInfo == null) || (paramArticleInfo.mTopicRecommendFeedsInfo.a == null) || (paramArticleInfo.mTopicRecommendFeedsInfo.a.isEmpty()))
    {
      QLog.e("HorizontalListView", 1, "articleInfo is null or topicRecommendInfo is null or topicRecommendInfoList is empty");
      paramArticleInfo = null;
    }
    String str;
    do
    {
      return paramArticleInfo;
      str = ((TopicRecommendFeedsInfo.TopicRecommendInfo)paramArticleInfo.mTopicRecommendFeedsInfo.a.get(0)).b;
      paramArticleInfo = str;
    } while (!QLog.isColorLevel());
    QLog.d("PolymericSmallVideo", 2, "ComponentPolymericView TYPE_NEW_POLYMERIC_CONTAINER_TOPIC jump account url =" + str);
    return str;
  }
  
  private static String b(ArticleInfo paramArticleInfo)
  {
    Object localObject = "";
    long l1 = 0L;
    if (!TextUtils.isEmpty(paramArticleInfo.mSubscribeID)) {}
    try
    {
      long l2 = Long.parseLong(paramArticleInfo.mSubscribeID);
      l1 = l2;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        QLog.e("HorizontalListView", 1, "generateWithSubscribeID() failed! " + paramArticleInfo.mSubscribeID);
      }
    }
    paramArticleInfo = ReadInJoyConstants.k + Base64Util.encodeToString(String.valueOf(l1).getBytes(), 2);
    localObject = paramArticleInfo;
    if (QLog.isColorLevel())
    {
      QLog.d("PolymericSmallVideo", 2, "ComponentPolymericView PGC jump account url =" + paramArticleInfo + " uin = " + l1);
      localObject = paramArticleInfo;
    }
    return localObject;
  }
  
  private static String c(ArticleInfo paramArticleInfo)
  {
    String str = "";
    Object localObject = str;
    if (paramArticleInfo.mSocialFeedInfo != null)
    {
      localObject = str;
      if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo != null)
      {
        long l = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.a;
        paramArticleInfo = ReadInJoyConstants.g + Base64Util.encodeToString(String.valueOf(l).getBytes(), 2);
        localObject = paramArticleInfo;
        if (QLog.isColorLevel())
        {
          QLog.d("PolymericSmallVideo", 2, "ComponentPolymericView UGC jump account url =" + paramArticleInfo + " uin = " + l);
          localObject = paramArticleInfo;
        }
      }
    }
    return localObject;
  }
  
  private static String d(ArticleInfo paramArticleInfo)
  {
    String str2 = "";
    long l1 = 0L;
    if (!TextUtils.isEmpty(paramArticleInfo.mSubscribeID))
    {
      try
      {
        long l2 = Long.parseLong(paramArticleInfo.mSubscribeID);
        l1 = l2;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          ArticleInfo localArticleInfo;
          QLog.e("HorizontalListView", 1, "generateByDefault() failed! " + paramArticleInfo.mSubscribeID);
        }
      }
      paramArticleInfo = ReadInJoyConstants.k + Base64Util.encodeToString(String.valueOf(l1).getBytes(), 2);
      localArticleInfo = paramArticleInfo;
      if (!QLog.isColorLevel()) {
        break label357;
      }
      QLog.d("PolymericSmallVideo", 2, "ComponentPolymericView empty url jump account url =" + paramArticleInfo + " mSubscribeID = " + l1);
    }
    String str1;
    do
    {
      do
      {
        return paramArticleInfo;
        if ((paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo == null)) {
          break;
        }
        l1 = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.a;
        str1 = ReadInJoyConstants.g + Base64Util.encodeToString(String.valueOf(l1).getBytes(), 2);
        paramArticleInfo = str1;
      } while (!QLog.isColorLevel());
      QLog.d("PolymericSmallVideo", 2, "ComponentPolymericView empty url jump account url =" + str1 + " mUGCFeedsInfo.cuin = " + l1);
      return str1;
      str1 = str2;
      if (paramArticleInfo.mSocialFeedInfo == null) {
        break;
      }
      str1 = str2;
      if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser == null) {
        break;
      }
      l1 = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser.a;
      str1 = ReadInJoyConstants.g + Base64Util.encodeToString(String.valueOf(l1).getBytes(), 2);
      paramArticleInfo = str1;
    } while (!QLog.isColorLevel());
    QLog.d("PolymericSmallVideo", 2, "ComponentPolymericView empty url jump account url =" + str1 + " mMasterUser.uin = " + l1);
    return str1;
    label357:
    return str1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentPolymericViewJumpUrlGenerator
 * JD-Core Version:    0.7.0.1
 */