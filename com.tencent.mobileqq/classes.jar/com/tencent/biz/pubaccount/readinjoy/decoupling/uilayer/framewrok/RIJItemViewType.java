package com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJFeedsType;
import com.tencent.biz.pubaccount.readinjoy.proteus.utils.DynamicItemViewHelper;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.BiuInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.FeedsInfoUser;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicRecommendFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapterUtil;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import tencent.im.oidb.articlesummary.articlesummary.PartnerAccountInfo;

public class RIJItemViewType
{
  public static int a(ArticleInfo paramArticleInfo)
  {
    return a(paramArticleInfo, 0);
  }
  
  public static int a(ArticleInfo paramArticleInfo, int paramInt)
  {
    return ReadInJoyBaseAdapterUtil.a.a(paramArticleInfo, paramInt);
  }
  
  public static long a(ArticleInfo paramArticleInfo, int paramInt)
  {
    long l2 = 0L;
    long l1;
    if ((a(paramArticleInfo)) || (paramInt == 77) || (paramInt == 78))
    {
      l1 = l2;
      if (TextUtils.isEmpty(paramArticleInfo.mSubscribeID)) {}
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  try
                  {
                    l1 = Long.parseLong(paramArticleInfo.mSubscribeID);
                    return l1;
                  }
                  catch (NumberFormatException paramArticleInfo)
                  {
                    paramArticleInfo.printStackTrace();
                    return 0L;
                  }
                  if ((!g(paramArticleInfo)) && (paramInt != 72) && (paramInt != 74)) {
                    break;
                  }
                  l1 = l2;
                } while (paramArticleInfo.mSocialFeedInfo == null);
                l1 = l2;
              } while (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo == null);
              return paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_Long;
              if (paramInt != 76) {
                break;
              }
              l1 = l2;
            } while (paramArticleInfo.mSocialFeedInfo == null);
            l1 = l2;
          } while (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser == null);
          return paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser.jdField_a_of_type_Long;
          if ((f(paramArticleInfo)) || (paramInt == 73)) {
            break;
          }
          l1 = l2;
        } while (paramInt != 75);
        l1 = l2;
      } while (paramArticleInfo.mSocialFeedInfo == null);
      l1 = l2;
    } while (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser == null);
    return paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser.jdField_a_of_type_Long;
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt == 49) || (paramInt == 62) || (paramInt == 63);
  }
  
  public static boolean a(int paramInt, long paramLong)
  {
    return (paramInt == 4) || (paramInt == 5) || (paramInt == 25) || (paramInt == 32) || ((paramInt == 1) && ((paramLong == 4L) || (paramLong == 5L) || (paramLong == 25L) || (paramLong == 32L)));
  }
  
  @Deprecated
  public static boolean a(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {
      return false;
    }
    switch (paramArticleInfo.mFeedType)
    {
    case 10: 
    case 11: 
    default: 
      return false;
    }
    return true;
  }
  
  public static boolean a(BaseArticleInfo paramBaseArticleInfo)
  {
    return (paramBaseArticleInfo != null) && (paramBaseArticleInfo.mFeedType == 36);
  }
  
  public static int b(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo == null) || (paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("RIJItemViewType", 2, "ugc feeds info is null");
      }
      return 21;
    }
    switch (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_Int)
    {
    case 1: 
    default: 
      return 21;
    case 2: 
    case 3: 
      if ((paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int == 9) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_JavaUtilArrayList.size() > 1)) {
        return 36;
      }
      if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$IconWordingInfo != null) {
        return 80;
      }
      return 22;
    case 4: 
    case 5: 
      return 23;
    }
    if (paramArticleInfo.isWeishiGridTwoItemFeed()) {
      return 70;
    }
    if (paramArticleInfo.isTwoItemVideoFeed()) {
      return 46;
    }
    if (paramArticleInfo.mChannelID == 0L) {
      return 71;
    }
    if ((paramArticleInfo.mChannelID == 70L) || (paramArticleInfo.mChannelID == 41403L)) {
      return 23;
    }
    return 4;
  }
  
  public static boolean b(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {
      return false;
    }
    switch (a(paramArticleInfo))
    {
    default: 
      return false;
    }
    return true;
  }
  
  public static boolean b(BaseArticleInfo paramBaseArticleInfo)
  {
    return (paramBaseArticleInfo != null) && (paramBaseArticleInfo.isAccountShown);
  }
  
  public static int c(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo == null) || (paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo == null))
    {
      QLog.d("RIJItemViewType", 1, "getTopicRecommendAndUpdateUGCType ugc feeds info is null. article info is: " + paramArticleInfo);
      return 54;
    }
    switch (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_Int)
    {
    case 1: 
    default: 
      return 54;
    case 2: 
    case 3: 
      return 55;
    }
    return 56;
  }
  
  public static boolean c(ArticleInfo paramArticleInfo)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramArticleInfo != null)
    {
      bool1 = bool2;
      if (paramArticleInfo.mSocialFeedInfo != null)
      {
        bool1 = bool2;
        if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int == 9) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static boolean c(BaseArticleInfo paramBaseArticleInfo)
  {
    return (paramBaseArticleInfo != null) && (paramBaseArticleInfo.mKdLiveInfo != null);
  }
  
  public static int d(ArticleInfo paramArticleInfo)
  {
    SocializeFeedsInfo localSocializeFeedsInfo = paramArticleInfo.mSocialFeedInfo;
    if (f(paramArticleInfo)) {
      if (d(paramArticleInfo)) {
        switch (localSocializeFeedsInfo.jdField_a_of_type_Int)
        {
        }
      }
    }
    do
    {
      do
      {
        return 0;
        return 4;
        return 3;
        if (RIJFeedsType.e(paramArticleInfo)) {
          return 6;
        }
        if (RIJFeedsType.q(paramArticleInfo)) {
          return 10;
        }
      } while (!RIJFeedsType.p(paramArticleInfo));
      return 8;
      if ((!a(paramArticleInfo)) && (paramArticleInfo.mFeedType != 10)) {
        break;
      }
    } while (localSocializeFeedsInfo == null);
    switch (localSocializeFeedsInfo.jdField_a_of_type_Int)
    {
    default: 
      return 0;
    case 1: 
      return 1;
    }
    return 2;
    switch (paramArticleInfo.mFeedType)
    {
    default: 
      return 0;
    case 21: 
      return 7;
    case 23: 
      return 5;
    }
    return 9;
  }
  
  public static boolean d(ArticleInfo paramArticleInfo)
  {
    if ((!f(paramArticleInfo)) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.b == null)) {
      return false;
    }
    switch (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.b.intValue())
    {
    default: 
      return false;
    }
    return true;
  }
  
  public static boolean d(BaseArticleInfo paramBaseArticleInfo)
  {
    if (!(paramBaseArticleInfo instanceof ArticleInfo)) {
      return false;
    }
    if ((paramBaseArticleInfo.mChannelID == 0L) && ((i((ArticleInfo)paramBaseArticleInfo)) || (e((ArticleInfo)paramBaseArticleInfo)) || (b((ArticleInfo)paramBaseArticleInfo)) || (a(paramBaseArticleInfo)) || (b(paramBaseArticleInfo)) || (c(paramBaseArticleInfo)))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static boolean e(ArticleInfo paramArticleInfo)
  {
    return (f(paramArticleInfo)) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo != null);
  }
  
  public static boolean e(BaseArticleInfo paramBaseArticleInfo)
  {
    return (paramBaseArticleInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser.c == 1);
  }
  
  public static boolean f(ArticleInfo paramArticleInfo)
  {
    boolean bool = true;
    if (paramArticleInfo == null) {
      return false;
    }
    if ((paramArticleInfo.mFeedType == 1) && (paramArticleInfo.mSocialFeedInfo != null)) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public static boolean f(BaseArticleInfo paramBaseArticleInfo)
  {
    return (paramBaseArticleInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser.c == 0) && (b((ArticleInfo)paramBaseArticleInfo));
  }
  
  public static boolean g(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo == null) || (paramArticleInfo.mSocialFeedInfo == null)) {
      return false;
    }
    switch (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public static boolean g(BaseArticleInfo paramBaseArticleInfo)
  {
    if (paramBaseArticleInfo == null) {
      return false;
    }
    switch (paramBaseArticleInfo.mFeedType)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public static boolean h(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {}
    while (paramArticleInfo.mFeedType != 10) {
      return false;
    }
    return true;
  }
  
  public static boolean h(BaseArticleInfo paramBaseArticleInfo)
  {
    return (paramBaseArticleInfo.mFeedType == 1) && (paramBaseArticleInfo.mSocialFeedInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.b != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.b.longValue() == 11L);
  }
  
  public static boolean i(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo == null) || (paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.b == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo == null)) {
      return false;
    }
    switch (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.b.intValue())
    {
    default: 
      return false;
    }
    return true;
  }
  
  public static boolean i(BaseArticleInfo paramBaseArticleInfo)
  {
    return (paramBaseArticleInfo.mFeedType == 11) && (paramBaseArticleInfo.mTopicRecommendFeedsInfo != null) && (paramBaseArticleInfo.mTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList != null);
  }
  
  public static boolean j(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {}
    while ((paramArticleInfo.mFeedType != 18) && (paramArticleInfo.mFeedType != 19)) {
      return false;
    }
    return true;
  }
  
  public static boolean j(BaseArticleInfo paramBaseArticleInfo)
  {
    return ((paramBaseArticleInfo instanceof ArticleInfo)) && (q((ArticleInfo)paramBaseArticleInfo));
  }
  
  public static boolean k(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo == null) || (paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.b == null)) {
      return false;
    }
    switch (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.b.intValue())
    {
    default: 
      return false;
    }
    return true;
  }
  
  public static boolean k(BaseArticleInfo paramBaseArticleInfo)
  {
    return (paramBaseArticleInfo.mFeedType != 30) && ((paramBaseArticleInfo.mSocialFeedInfo == null) || (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo == null) || (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.c.isEmpty()));
  }
  
  public static boolean l(ArticleInfo paramArticleInfo)
  {
    return (k(paramArticleInfo)) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_Int == 1);
  }
  
  public static boolean l(BaseArticleInfo paramBaseArticleInfo)
  {
    return (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo == null) || (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList == null) || (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList.isEmpty());
  }
  
  public static boolean m(ArticleInfo paramArticleInfo)
  {
    return (i(paramArticleInfo)) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_Int == 1);
  }
  
  public static boolean m(BaseArticleInfo paramBaseArticleInfo)
  {
    return (paramBaseArticleInfo != null) && (paramBaseArticleInfo.isAccountShown) && (paramBaseArticleInfo.mPartnerAccountInfo != null);
  }
  
  public static boolean n(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {}
    while ((paramArticleInfo.mFeedType != 16) && (paramArticleInfo.mFeedType != 17)) {
      return false;
    }
    return true;
  }
  
  public static boolean n(BaseArticleInfo paramBaseArticleInfo)
  {
    if (paramBaseArticleInfo == null) {
      return false;
    }
    int i = a((ArticleInfo)paramBaseArticleInfo);
    if ((paramBaseArticleInfo instanceof AdvertisementInfo)) {
      return false;
    }
    switch (i)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public static boolean o(ArticleInfo paramArticleInfo)
  {
    return (paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo == null);
  }
  
  public static boolean o(BaseArticleInfo paramBaseArticleInfo)
  {
    return (paramBaseArticleInfo != null) && (paramBaseArticleInfo.mPartnerAccountInfo != null) && (paramBaseArticleInfo.mPartnerAccountInfo.uint32_is_wechat_video.get() == 1);
  }
  
  public static boolean p(ArticleInfo paramArticleInfo)
  {
    return (paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_JavaUtilArrayList.size() == 0);
  }
  
  public static boolean p(BaseArticleInfo paramBaseArticleInfo)
  {
    return (paramBaseArticleInfo != null) && (!TextUtils.isEmpty(paramBaseArticleInfo.miniProgramName));
  }
  
  public static boolean q(ArticleInfo paramArticleInfo)
  {
    return (paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.b.size() == 0);
  }
  
  public static boolean q(BaseArticleInfo paramBaseArticleInfo)
  {
    return (paramBaseArticleInfo != null) && ("ReadInjoy_hot_news_account_cell".equals(DynamicItemViewHelper.a(paramBaseArticleInfo)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.RIJItemViewType
 * JD-Core Version:    0.7.0.1
 */