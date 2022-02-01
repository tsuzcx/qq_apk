package com.tencent.biz.pubaccount.readinjoy.video;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.RIJItemViewType;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.BiuInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCVideoInfo;
import com.tencent.biz.pubaccount.util.api.IPublicAccountHttpDownloader;
import com.tencent.mobileqq.qroute.QRoute;
import java.net.URL;
import java.util.ArrayList;

public class FeedsChannelDataHelper
{
  public static VideoInfo a(BaseArticleInfo paramBaseArticleInfo)
  {
    VideoInfo localVideoInfo = new VideoInfo();
    localVideoInfo.g = paramBaseArticleInfo.getInnerUniqueID();
    localVideoInfo.jdField_b_of_type_Boolean = RIJItemViewType.g(paramBaseArticleInfo);
    localVideoInfo.jdField_d_of_type_Long = paramBaseArticleInfo.mFeedId;
    localVideoInfo.jdField_h_of_type_Int = paramBaseArticleInfo.mFeedType;
    return localVideoInfo;
  }
  
  public static BaseArticleInfo a(VideoInfo paramVideoInfo)
  {
    if ((paramVideoInfo != null) && (paramVideoInfo.jdField_a_of_type_Int != 0))
    {
      ArticleInfo localArticleInfo = new ArticleInfo();
      try
      {
        localArticleInfo.rawkey = paramVideoInfo.g;
        localArticleInfo.mArticleID = paramVideoInfo.jdField_c_of_type_Long;
        localArticleInfo.innerUniqueID = paramVideoInfo.g;
        localArticleInfo.mTitle = paramVideoInfo.jdField_c_of_type_JavaLangString;
        localArticleInfo.mSubscribeName = paramVideoInfo.k;
        localArticleInfo.mSubscribeID = paramVideoInfo.j;
        localArticleInfo.mFirstPagePicUrl = paramVideoInfo.jdField_b_of_type_JavaLangString;
        localArticleInfo.mVideoDuration = paramVideoInfo.jdField_d_of_type_Int;
        localArticleInfo.mVideoCoverUrl = ((IPublicAccountHttpDownloader)QRoute.api(IPublicAccountHttpDownloader.class)).makeURL(paramVideoInfo.jdField_b_of_type_JavaLangString, paramVideoInfo.jdField_a_of_type_Int);
        localArticleInfo.mVideoVid = paramVideoInfo.jdField_a_of_type_JavaLangString;
        localArticleInfo.mFeedType = paramVideoInfo.jdField_h_of_type_Int;
        localArticleInfo.mFeedId = paramVideoInfo.jdField_d_of_type_Long;
        localArticleInfo.mXGFileSize = paramVideoInfo.jdField_b_of_type_Long;
        localArticleInfo.busiType = paramVideoInfo.jdField_a_of_type_Int;
        localArticleInfo.mJsonVideoList = paramVideoInfo.l;
        localArticleInfo.mVideoCommentCount = paramVideoInfo.jdField_e_of_type_Int;
        localArticleInfo.mVideoJsonWidth = paramVideoInfo.jdField_b_of_type_Int;
        localArticleInfo.mVideoJsonHeight = paramVideoInfo.jdField_c_of_type_Int;
        localArticleInfo.mArticleContentUrl = paramVideoInfo.jdField_f_of_type_JavaLangString;
        localArticleInfo.aioShareUrl = paramVideoInfo.m;
        localArticleInfo.thirdIcon = paramVideoInfo.p;
        localArticleInfo.thirdName = paramVideoInfo.k;
        localArticleInfo.thirdAction = paramVideoInfo.o;
        localArticleInfo.thirdUin = paramVideoInfo.j;
        localArticleInfo.thirdUinName = paramVideoInfo.q;
        localArticleInfo.mVideoPlayCount = paramVideoInfo.t;
        localArticleInfo.mRecommentdReason = paramVideoInfo.jdField_h_of_type_JavaLangString;
        localArticleInfo.videoReportInfo = paramVideoInfo.w;
        localArticleInfo.mSummary = paramVideoInfo.jdField_d_of_type_JavaLangString;
        localArticleInfo.mTime = paramVideoInfo.jdField_a_of_type_Long;
        localArticleInfo.mAlgorithmID = paramVideoInfo.jdField_f_of_type_Long;
        localArticleInfo.mDiskLikeInfoString = DislikeInfo.a(paramVideoInfo.jdField_a_of_type_JavaUtilArrayList);
        localArticleInfo.mRecommendSeq = paramVideoInfo.jdField_e_of_type_Long;
        localArticleInfo.mVideoLogoUrl = paramVideoInfo.u;
        if (paramVideoInfo.jdField_b_of_type_Boolean)
        {
          paramVideoInfo.jdField_a_of_type_Int = 6;
          localArticleInfo.mSocialFeedInfo = new SocializeFeedsInfo();
          localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo = new SocializeFeedsInfo.UGCFeedsInfo();
          if (!TextUtils.isEmpty(paramVideoInfo.j)) {
            localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_Long = Long.valueOf(paramVideoInfo.j).longValue();
          }
          localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_Int = paramVideoInfo.jdField_h_of_type_Int;
          localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_b_of_type_JavaLangString = paramVideoInfo.k;
          localArticleInfo.mSocialFeedInfo.jdField_d_of_type_Int = paramVideoInfo.jdField_e_of_type_Int;
          localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
          SocializeFeedsInfo.UGCVideoInfo localUGCVideoInfo = new SocializeFeedsInfo.UGCVideoInfo();
          localUGCVideoInfo.jdField_d_of_type_JavaLangString = paramVideoInfo.jdField_b_of_type_JavaLangString;
          localUGCVideoInfo.jdField_e_of_type_JavaLangString = paramVideoInfo.jdField_c_of_type_JavaLangString;
          localUGCVideoInfo.jdField_a_of_type_Long = (paramVideoInfo.jdField_d_of_type_Int * 1000);
          localUGCVideoInfo.jdField_a_of_type_Int = paramVideoInfo.jdField_b_of_type_Int;
          localUGCVideoInfo.jdField_b_of_type_Int = paramVideoInfo.jdField_c_of_type_Int;
          localUGCVideoInfo.g = paramVideoInfo.g;
          if (paramVideoInfo.jdField_e_of_type_JavaLangString != null) {
            localUGCVideoInfo.jdField_e_of_type_Int = Integer.parseInt(paramVideoInfo.jdField_e_of_type_JavaLangString);
          }
          localUGCVideoInfo.jdField_h_of_type_JavaLangString = paramVideoInfo.jdField_f_of_type_JavaLangString;
          localUGCVideoInfo.f = paramVideoInfo.jdField_a_of_type_Int;
          localUGCVideoInfo.i = paramVideoInfo.jdField_a_of_type_JavaLangString;
          localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_b_of_type_JavaUtilArrayList.add(localUGCVideoInfo);
          localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser.jdField_a_of_type_Long = Long.parseLong(paramVideoInfo.j);
          paramVideoInfo = new SocializeFeedsInfo.BiuInfo();
          paramVideoInfo.a = Long.valueOf(localArticleInfo.mFeedId);
          paramVideoInfo.b = Long.valueOf(localArticleInfo.mFeedType);
          localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo = paramVideoInfo;
        }
      }
      catch (Throwable paramVideoInfo)
      {
        for (;;)
        {
          paramVideoInfo.printStackTrace();
        }
      }
      return localArticleInfo;
    }
    return null;
  }
  
  public static String a(URL paramURL)
  {
    if ((paramURL == null) || (TextUtils.isEmpty(paramURL.toString()))) {
      return "";
    }
    return paramURL.toString().replace("pubaccountimage:", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.FeedsChannelDataHelper
 * JD-Core Version:    0.7.0.1
 */