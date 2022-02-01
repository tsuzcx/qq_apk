package com.tencent.biz.pubaccount.readinjoy.view;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.NativeAd.util.NativeAdUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInjoyFeedsUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.util.RIJQQAppInterfaceUtil;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.RIJItemViewType;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.preparse.RIJPreParseData;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJFeedsType;
import com.tencent.biz.pubaccount.readinjoy.proteus.utils.DynamicItemViewHelper;
import com.tencent.biz.pubaccount.readinjoy.pts.lite.PTSLiteItemViewBuilder;
import com.tencent.biz.pubaccount.readinjoy.pts.util.PTSLiteSwitchManager;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentGridImage;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianLiveInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.MultiVideoColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.RecommendFollowInfos;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.PGCFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.ShareWebPageInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicRecommendFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHelper;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdUtils;
import com.tencent.mobileqq.pb.PBEnumField;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.gallery.galleryFeeds.GalleryFeedsInfo;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapterUtil;", "", "()V", "getBaseItemViewType", "", "article", "Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;", "channelType", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ReadInJoyBaseAdapterUtil
{
  public static final ReadInJoyBaseAdapterUtil a = new ReadInJoyBaseAdapterUtil();
  
  public final int a(@Nullable ArticleInfo paramArticleInfo, int paramInt)
  {
    if (paramArticleInfo == null) {
      paramInt = 0;
    }
    do
    {
      return paramInt;
      PTSLiteSwitchManager localPTSLiteSwitchManager = PTSLiteSwitchManager.a();
      Intrinsics.checkExpressionValueIsNotNull(localPTSLiteSwitchManager, "PTSLiteSwitchManager.getInstance()");
      if ((localPTSLiteSwitchManager.a()) && (PTSLiteItemViewBuilder.a((BaseArticleInfo)paramArticleInfo))) {
        return PTSLiteItemViewBuilder.a(paramArticleInfo);
      }
      if (DynamicItemViewHelper.a(paramArticleInfo)) {
        return ReadInJoyBaseAdapter.a.a(paramArticleInfo);
      }
      if (RIJItemViewType.o((BaseArticleInfo)paramArticleInfo)) {
        return 147;
      }
      if (paramArticleInfo.mFeedType != 20) {
        break;
      }
      paramInt = 82;
    } while (paramArticleInfo.mRecommendFollowInfos == null);
    switch (paramArticleInfo.mRecommendFollowInfos.jdField_a_of_type_Int)
    {
    default: 
      return 82;
    case 0: 
      return 82;
    case 1: 
      return 87;
    }
    return 88;
    if (paramArticleInfo.mFeedType == 36)
    {
      if (paramArticleInfo.isPGCShortContent()) {
        return 139;
      }
      if (RIJFeedsType.z((BaseArticleInfo)paramArticleInfo)) {
        return 138;
      }
      return 137;
    }
    if ((paramArticleInfo.mFeedType == 21) || (paramArticleInfo.mFeedType == 22)) {
      return RIJFeedsType.a(paramArticleInfo, false);
    }
    if (paramArticleInfo.mFeedType == 28) {
      return 93;
    }
    if (paramArticleInfo.mFeedType == 24) {
      return RIJFeedsType.b((BaseArticleInfo)paramArticleInfo);
    }
    if (paramArticleInfo.mFeedType == 34) {
      return 123;
    }
    if ((paramArticleInfo.mGroupSubArticleList != null) && (paramArticleInfo.mFeedType != 29)) {
      return 53;
    }
    if (paramArticleInfo.mFeedType == 25) {
      return 89;
    }
    if (paramArticleInfo.mFeedType == 15) {
      return 38;
    }
    if ((paramArticleInfo.mFeedType == 3) || (paramArticleInfo.mFeedType == 13)) {
      return 15;
    }
    if (paramArticleInfo.mFeedType == 30) {
      return 107;
    }
    if ((paramArticleInfo.mFeedType == 1) && (paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mChannelID != 56))
    {
      paramInt = ReadInjoyFeedsUtils.a((BaseArticleInfo)paramArticleInfo);
      if ((paramInt == 21) || (paramInt == 22)) {
        return RIJFeedsType.a(paramArticleInfo, true);
      }
      if (paramInt == 11) {
        return 33;
      }
      if (RIJFeedsType.h(paramArticleInfo))
      {
        switch (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int)
        {
        default: 
          return 12;
        case 1: 
          return 10;
        case 2: 
          return 27;
        }
        return 35;
      }
      if (RIJFeedsType.i(paramArticleInfo))
      {
        switch (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_Int)
        {
        default: 
          return 24;
        case 1: 
          return 24;
        case 2: 
        case 3: 
          return 25;
        }
        return 26;
      }
      if (RIJFeedsType.e(paramArticleInfo)) {
        if ((paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo.jdField_a_of_type_JavaUtilArrayList == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo.jdField_a_of_type_JavaUtilArrayList.size() <= 0)) {
          break label2409;
        }
      }
    }
    label2406:
    label2409:
    for (paramInt = ComponentContentGridImage.a(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo.jdField_a_of_type_JavaUtilArrayList.size(), paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int);; paramInt = 0)
    {
      if (paramInt != 0)
      {
        switch (paramInt)
        {
        default: 
          return 0;
        case 1: 
          return 49;
        case 3: 
          return 62;
        }
        return 63;
      }
      switch (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int)
      {
      default: 
        return 12;
      case 9: 
        return 63;
      case 3: 
        return 62;
      }
      return 49;
      if (paramInt == 25) {
        return 92;
      }
      if ((paramInt == 27) && (paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$ShareWebPageInfo != null))
      {
        if (!TextUtils.isEmpty((CharSequence)paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$ShareWebPageInfo.c)) {
          return 94;
        }
        return 95;
      }
      if ((paramInt == 32) && (paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$GameLiveInfo != null)) {
        return 26;
      }
      if (!RIJItemViewType.i(paramArticleInfo))
      {
        if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int == 0)
        {
          paramInt = 12;
          if (!paramArticleInfo.isPGCShortContent()) {
            break;
          }
          return 112;
        }
        if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int == 1)
        {
          paramInt = 10;
          if (!paramArticleInfo.isPGCShortContent()) {
            break;
          }
          return 113;
        }
        if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int == 5) {
          return 11;
        }
        if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int == 2)
        {
          paramInt = 27;
          if (!paramArticleInfo.isPGCShortContent()) {
            break;
          }
          return 113;
        }
        if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int == 6) {
          return 28;
        }
        if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int == 9)
        {
          paramInt = 35;
          if (!paramArticleInfo.isPGCShortContent()) {
            break;
          }
          return 114;
        }
        paramInt = 12;
        if (!paramArticleInfo.isPGCShortContent()) {
          break;
        }
        return 112;
      }
      if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_Int == 1)
      {
        if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.c.size() > 0) {
          return 108;
        }
        return 24;
      }
      if ((paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_Int == 3) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_Int == 2))
      {
        if ((paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int == 9) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_JavaUtilArrayList.size() > 1)) {
          return 37;
        }
        if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$IconWordingInfo != null) {
          return 81;
        }
        return 25;
      }
      return 26;
      if (((paramArticleInfo.mFeedType == 11) || (paramArticleInfo.mFeedType == 14)) && (paramArticleInfo.mTopicRecommendFeedsInfo != null) && (paramArticleInfo.mTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList != null) && (paramArticleInfo.mTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList.size() > 0))
      {
        if (paramArticleInfo.mTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList.size() > 1) {
          return 30;
        }
        return 29;
      }
      if (RIJItemViewType.a(paramArticleInfo))
      {
        if (paramArticleInfo.mSocialFeedInfo == null) {
          break label2406;
        }
        switch (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int)
        {
        default: 
          return 16;
        case 0: 
          paramInt = 20;
          if (!paramArticleInfo.isPGCShortContent()) {
            break;
          }
          return 109;
        case 5: 
          return 17;
        case 2: 
          paramInt = 18;
          if (!paramArticleInfo.isPGCShortContent()) {
            break;
          }
          return 110;
        case 6: 
          paramInt = 19;
          if (!paramArticleInfo.isPGCShortContent()) {
            break;
          }
          return 133;
        case 9: 
          paramInt = 34;
          if (!paramArticleInfo.isPGCShortContent()) {
            break;
          }
          return 111;
        case 3: 
          if (!paramArticleInfo.isPGCShortContent()) {
            break label2406;
          }
          return 111;
        case 8: 
          return 16;
        case 1: 
          if (!paramArticleInfo.isPGCShortContent()) {
            break label2406;
          }
          return 132;
        case 19191924: 
          if (!paramArticleInfo.isPGCShortContent()) {
            break label2406;
          }
          return 134;
        }
      }
      if ((paramArticleInfo.mFeedType == 32) && (paramArticleInfo.mSocialFeedInfo != null)) {
        return 120;
      }
      if ((RIJItemViewType.g((BaseArticleInfo)paramArticleInfo)) && (paramArticleInfo.mSocialFeedInfo != null)) {
        return RIJItemViewType.b(paramArticleInfo);
      }
      if ((RIJFeedsType.c(paramArticleInfo)) || (RIJFeedsType.d(paramArticleInfo)))
      {
        paramInt = 40;
        if (paramArticleInfo.mSocialFeedInfo == null) {
          break;
        }
        switch (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int)
        {
        default: 
          return 40;
        case 2: 
          return 40;
        case 1: 
          return 41;
        }
        return 42;
      }
      if ((RIJFeedsType.f(paramArticleInfo)) || (RIJFeedsType.g(paramArticleInfo))) {
        return RIJItemViewType.c(paramArticleInfo);
      }
      if (RIJItemViewType.h(paramArticleInfo))
      {
        paramInt = 31;
        if (paramArticleInfo.mSocialFeedInfo == null) {
          break;
        }
        switch (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int)
        {
        case 3: 
        case 4: 
        case 7: 
        case 8: 
        default: 
          paramInt = 86;
          if (!paramArticleInfo.isPGCShortContent()) {
            break;
          }
          return 109;
        case 2: 
          paramInt = 31;
          if (!paramArticleInfo.isPGCShortContent()) {
            break;
          }
          return 110;
        case 6: 
          return 32;
        case 1: 
          paramInt = 83;
          if (!paramArticleInfo.isPGCShortContent()) {
            break;
          }
          return 111;
        case 5: 
          return 84;
        case 9: 
          paramInt = 85;
          if (!paramArticleInfo.isPGCShortContent()) {
            break;
          }
          return 111;
        case 0: 
          paramInt = 86;
          if (!paramArticleInfo.isPGCShortContent()) {
            break;
          }
          return 109;
        }
      }
      if (paramArticleInfo.mFeedType == 23)
      {
        if (paramArticleInfo.mSocialFeedInfo != null)
        {
          switch (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int)
          {
          default: 
            return 16;
          case 9: 
            return 65;
          case 3: 
            return 64;
          }
          return 48;
        }
      }
      else
      {
        if ((paramArticleInfo.mChannelID == 0L) && (paramArticleInfo.mSimpleVideoColumnInfo != null) && (RIJFeedsType.a((BaseArticleInfo)paramArticleInfo))) {
          return 128;
        }
        if ((paramArticleInfo.mChannelID == 0L) && (paramArticleInfo.mVideoColumnInfo != null) && (RIJFeedsType.a((BaseArticleInfo)paramArticleInfo))) {
          return 118;
        }
        if (paramArticleInfo.multiVideoColumnInfo != null)
        {
          if (paramArticleInfo.columnStyle == 1) {
            return 142;
          }
          if (paramArticleInfo.multiVideoColumnInfo.a) {
            return 125;
          }
          return 124;
        }
        if (paramArticleInfo.mKdLiveInfo != null)
        {
          if (paramArticleInfo.mKdLiveInfo.jdField_a_of_type_Int == 4) {
            return 130;
          }
          return 129;
        }
        if (paramArticleInfo.isWeishiGridTwoItemFeed()) {
          return 70;
        }
        if (paramArticleInfo.isTwoItemVideoFeed())
        {
          if ((paramArticleInfo.mFeedType == 33) && (paramArticleInfo.mChannelID != 56) && (paramArticleInfo.mChannelID != 70)) {
            return 121;
          }
          return 46;
        }
        if (paramArticleInfo.isWormhole()) {
          return 136;
        }
        if ((RIJFeedsType.a((BaseArticleInfo)paramArticleInfo)) && (paramArticleInfo.mPictures != null) && (paramArticleInfo.mPictures.length >= 3) && (paramArticleInfo.mChannelID == 0L)) {
          return 14;
        }
        if (RIJFeedsType.a((BaseArticleInfo)paramArticleInfo))
        {
          if (paramArticleInfo.mVideoType == 0)
          {
            if (RIJQQAppInterfaceUtil.a())
            {
              if ((paramArticleInfo.mChannelID == 56) || (paramInt == 3)) {
                return 4;
              }
              if (AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)paramArticleInfo))
              {
                if (((AdvertisementInfo)paramArticleInfo).isIMaxAndNewStyle) {
                  return 115;
                }
                return 66;
              }
              if (VideoFeedsHelper.f() == 0) {
                return 126;
              }
              return 6;
            }
            if (AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)paramArticleInfo))
            {
              if (((AdvertisementInfo)paramArticleInfo).isIMaxAndNewStyle) {
                return 115;
              }
              return 66;
            }
            if (VideoFeedsHelper.f() == 0) {
              return 126;
            }
            return 6;
          }
          if (paramArticleInfo.mChannelID == 56) {
            return 4;
          }
          return 5;
        }
        if (RIJPreParseData.a((BaseArticleInfo)paramArticleInfo))
        {
          if (paramArticleInfo.mGalleryFeedsInfo.enum_article_style.get() == 3) {
            return 103;
          }
          if (paramArticleInfo.mGalleryFeedsInfo.enum_article_style.get() == 2) {
            return 102;
          }
          return 101;
        }
        if (paramArticleInfo.mShowBigPicture)
        {
          if (paramArticleInfo.mIsGallery == 0)
          {
            if (paramArticleInfo.mTopicPicWHRatio != 0.0D) {
              return 9;
            }
            if (AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)paramArticleInfo)) {
              return ReadInJoyAdUtils.b((AdvertisementInfo)paramArticleInfo);
            }
            return 2;
          }
          if (paramArticleInfo.articleStyle == 3) {
            return 47;
          }
          if (paramArticleInfo.articleStyle == 4) {
            return 60;
          }
          if (paramArticleInfo.articleStyle == 5) {
            return 61;
          }
          if (paramArticleInfo.articleStyle == 6) {
            return 96;
          }
          return 8;
        }
        if ((AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)paramArticleInfo)) && (ReadInJoyAdUtils.e((AdvertisementInfo)paramArticleInfo))) {
          return 116;
        }
        if ((AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)paramArticleInfo)) && (ReadInJoyAdUtils.f((AdvertisementInfo)paramArticleInfo))) {
          return 39;
        }
        if (RIJFeedsType.j(paramArticleInfo))
        {
          if (RIJFeedsType.k(paramArticleInfo)) {
            return 91;
          }
          return 90;
        }
        if ((AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)paramArticleInfo)) && (ReadInJoyAdUtils.g((AdvertisementInfo)paramArticleInfo))) {
          return 127;
        }
        if (ReadInJoyAdUtils.e((BaseArticleInfo)paramArticleInfo)) {
          return 140;
        }
        if (ReadInJoyAdUtils.g((BaseArticleInfo)paramArticleInfo)) {
          return 144;
        }
        if (ReadInJoyAdUtils.i((BaseArticleInfo)paramArticleInfo)) {
          return 145;
        }
        if (ReadInJoyAdUtils.f((BaseArticleInfo)paramArticleInfo)) {
          return 146;
        }
        if (ReadInJoyAdUtils.j((BaseArticleInfo)paramArticleInfo)) {
          return 143;
        }
        if (ReadInJoyAdUtils.h((BaseArticleInfo)paramArticleInfo)) {
          return 141;
        }
        if ((paramArticleInfo.mPictures != null) && (paramArticleInfo.mPictures.length >= 3))
        {
          if (AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)paramArticleInfo)) {
            return 105;
          }
          return 3;
        }
        if (TextUtils.isEmpty((CharSequence)paramArticleInfo.mFirstPagePicUrl)) {
          return 0;
        }
        if (paramArticleInfo.mFeedType == 37) {
          return 135;
        }
        if (paramArticleInfo.mIsGallery == 0)
        {
          if (AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)paramArticleInfo))
          {
            if (NativeAdUtils.a((BaseArticleInfo)paramArticleInfo)) {
              return 106;
            }
            return 104;
          }
          return 1;
        }
        return 7;
      }
      return 16;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapterUtil
 * JD-Core Version:    0.7.0.1
 */