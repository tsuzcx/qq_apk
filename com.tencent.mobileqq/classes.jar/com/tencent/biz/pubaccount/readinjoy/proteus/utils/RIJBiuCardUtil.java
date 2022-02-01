package com.tencent.biz.pubaccount.readinjoy.proteus.utils;

import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.RIJItemViewType;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJFeedsType;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.IconWordingInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.PGCFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.PGCPicInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCPicInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCVideoInfo;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;

public class RIJBiuCardUtil
{
  private static SocializeFeedsInfo.PGCPicInfo a(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo != null) && (paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo.a != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo.a.size() > 0)) {
      return (SocializeFeedsInfo.PGCPicInfo)paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo.a.get(0);
    }
    return null;
  }
  
  private static Boolean a(@NotNull ArticleInfo paramArticleInfo)
  {
    SocializeFeedsInfo.UGCPicInfo localUGCPicInfo = (SocializeFeedsInfo.UGCPicInfo)paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.a.get(0);
    if ((localUGCPicInfo == null) || (localUGCPicInfo.b <= 0)) {
      return Boolean.valueOf(false);
    }
    float f = localUGCPicInfo.jdField_a_of_type_Int / localUGCPicInfo.b;
    if ((paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$IconWordingInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$IconWordingInfo.c == 1))
    {
      if (f <= 1.3439D) {}
      for (boolean bool = true;; bool = false) {
        return Boolean.valueOf(bool);
      }
    }
    return Boolean.valueOf(true);
  }
  
  public static boolean a(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {}
    do
    {
      do
      {
        return false;
      } while ((paramArticleInfo.mFeedType != 1) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo == null));
      if (b(paramArticleInfo)) {
        return true;
      }
    } while (!c(paramArticleInfo));
    return true;
  }
  
  private static boolean b(ArticleInfo paramArticleInfo)
  {
    if (RIJItemViewType.i(paramArticleInfo))
    {
      if (g(paramArticleInfo)) {}
      while ((h(paramArticleInfo)) || (i(paramArticleInfo))) {
        return true;
      }
    }
    return false;
  }
  
  private static boolean c(ArticleInfo paramArticleInfo)
  {
    if (RIJItemViewType.d(paramArticleInfo))
    {
      if (d(paramArticleInfo)) {}
      while ((e(paramArticleInfo)) || (f(paramArticleInfo))) {
        return true;
      }
    }
    return false;
  }
  
  private static boolean d(ArticleInfo paramArticleInfo)
  {
    return (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int == 2) && (k(paramArticleInfo));
  }
  
  private static boolean e(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int == 5) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int == 6))
    {
      int j = paramArticleInfo.mVideoJsonWidth;
      if (paramArticleInfo.mVideoJsonHeight == 0) {}
      for (int i = 1; j / i < 0.75D; i = paramArticleInfo.mVideoJsonHeight) {
        return true;
      }
    }
    return false;
  }
  
  private static boolean f(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int != 9) || (RIJFeedsType.e(paramArticleInfo))) {}
    do
    {
      do
      {
        return false;
      } while (!j(paramArticleInfo));
      if (paramArticleInfo.mChannelID == 0L) {
        return true;
      }
      paramArticleInfo = a(paramArticleInfo);
    } while ((paramArticleInfo == null) || (paramArticleInfo.b <= 0) || (paramArticleInfo.jdField_a_of_type_Int / paramArticleInfo.b >= 1.671428571428572D));
    return true;
  }
  
  private static boolean g(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int == 9) && (l(paramArticleInfo)) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.a.size() == 1))
    {
      if (paramArticleInfo.mChannelID == 0L) {
        return true;
      }
      paramArticleInfo = (SocializeFeedsInfo.UGCPicInfo)paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.a.get(0);
      if ((paramArticleInfo != null) && (paramArticleInfo.b != 0) && (paramArticleInfo.jdField_a_of_type_Int != 0) && (paramArticleInfo.jdField_a_of_type_Int / paramArticleInfo.b < 1.671428571428572D)) {
        return true;
      }
    }
    return false;
  }
  
  private static boolean h(ArticleInfo paramArticleInfo)
  {
    if (RIJItemViewType.b(paramArticleInfo) != 22) {}
    while ((!l(paramArticleInfo)) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.a.size() != 1)) {
      return false;
    }
    return a(paramArticleInfo).booleanValue();
  }
  
  private static boolean i(ArticleInfo paramArticleInfo)
  {
    if ((RIJItemViewType.b(paramArticleInfo) == 23) && (paramArticleInfo != null) && (paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.b != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.b.size() > 0))
    {
      paramArticleInfo = (SocializeFeedsInfo.UGCVideoInfo)paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.b.get(0);
      if (paramArticleInfo.d == 0) {
        paramArticleInfo.d = 1;
      }
      if (paramArticleInfo.c / paramArticleInfo.d < 0.75D) {
        return true;
      }
    }
    return false;
  }
  
  private static boolean j(ArticleInfo paramArticleInfo)
  {
    return (paramArticleInfo != null) && (paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo.a != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo.a.size() == 1);
  }
  
  private static boolean k(ArticleInfo paramArticleInfo)
  {
    return (paramArticleInfo != null) && (paramArticleInfo.isPGCShortContent()) && (paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo.a != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo.a.size() > 0);
  }
  
  private static boolean l(ArticleInfo paramArticleInfo)
  {
    return (paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.a != null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.utils.RIJBiuCardUtil
 * JD-Core Version:    0.7.0.1
 */