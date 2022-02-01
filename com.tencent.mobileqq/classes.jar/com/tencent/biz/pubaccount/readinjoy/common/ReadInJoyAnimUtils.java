package com.tencent.biz.pubaccount.readinjoy.common;

import android.app.Activity;
import android.text.TextPaint;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.RIJItemViewType;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.UtilsForComponent;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadinjoyVideoReportData;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.VideoPlayParam;
import com.tencent.biz.pubaccount.readinjoy.video.viewholder.VideoFeedsViewHolder;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyArticleAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyHeadImageView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNickNameTextView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyVideoInfoViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.VideoViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.widget.RoundAngleFrameLayout;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

public class ReadInJoyAnimUtils
{
  public static VideoPlayManager.VideoPlayParam a(BaseArticleInfo paramBaseArticleInfo)
  {
    VideoPlayManager.VideoPlayParam localVideoPlayParam = new VideoPlayManager.VideoPlayParam();
    localVideoPlayParam.jdField_c_of_type_JavaLangString = paramBaseArticleInfo.mVideoVid;
    localVideoPlayParam.jdField_c_of_type_Long = paramBaseArticleInfo.mArticleID;
    localVideoPlayParam.jdField_b_of_type_Int = paramBaseArticleInfo.mVideoDuration;
    localVideoPlayParam.jdField_c_of_type_Int = paramBaseArticleInfo.mVideoJsonWidth;
    localVideoPlayParam.jdField_d_of_type_Int = paramBaseArticleInfo.mVideoJsonHeight;
    if (paramBaseArticleInfo.mVideoCoverUrl == null) {}
    for (Object localObject = null;; localObject = paramBaseArticleInfo.mVideoCoverUrl.getFile())
    {
      localVideoPlayParam.jdField_b_of_type_JavaLangString = ((String)localObject);
      localVideoPlayParam.k = paramBaseArticleInfo.mSubscribeID;
      localVideoPlayParam.jdField_g_of_type_Int = paramBaseArticleInfo.mStrategyId;
      localVideoPlayParam.jdField_g_of_type_Long = paramBaseArticleInfo.mAlgorithmID;
      localObject = new ReadinjoyVideoReportData();
      ((ReadinjoyVideoReportData)localObject).jdField_a_of_type_JavaLangLong = Long.valueOf(paramBaseArticleInfo.mArticleID);
      ((ReadinjoyVideoReportData)localObject).jdField_a_of_type_JavaLangString = paramBaseArticleInfo.innerUniqueID;
      ((ReadinjoyVideoReportData)localObject).jdField_b_of_type_JavaLangString = paramBaseArticleInfo.mVideoVid;
      ((ReadinjoyVideoReportData)localObject).jdField_a_of_type_Int = paramBaseArticleInfo.busiType;
      localVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData = ((ReadinjoyVideoReportData)localObject);
      localVideoPlayParam.jdField_d_of_type_JavaLangString = paramBaseArticleInfo.thirdIcon;
      localVideoPlayParam.e = paramBaseArticleInfo.thirdName;
      localVideoPlayParam.jdField_f_of_type_JavaLangString = paramBaseArticleInfo.thirdAction;
      localVideoPlayParam.jdField_f_of_type_Int = paramBaseArticleInfo.busiType;
      localVideoPlayParam.j = paramBaseArticleInfo.innerUniqueID;
      localVideoPlayParam.jdField_b_of_type_Long = paramBaseArticleInfo.mChannelID;
      return localVideoPlayParam;
    }
  }
  
  public static void a(LinearLayout paramLinearLayout, int paramInt1, int paramInt2, Activity paramActivity, int paramInt3, int paramInt4)
  {
    paramLinearLayout.setVisibility(0);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)paramLinearLayout.getLayoutParams();
    localLayoutParams.leftMargin = paramInt3;
    localLayoutParams.topMargin = paramInt4;
    localLayoutParams.width = paramInt1;
    localLayoutParams.height = (AIOUtils.a(42.0F, paramActivity.getResources()) + paramInt2);
    paramLinearLayout.setLayoutParams(localLayoutParams);
  }
  
  public static void a(LinearLayout paramLinearLayout, ArticleInfo paramArticleInfo, Activity paramActivity, ReadInJoyArticleAdapter paramReadInJoyArticleAdapter, int paramInt1, int paramInt2, int paramInt3)
  {
    VideoFeedsViewHolder localVideoFeedsViewHolder = new VideoFeedsViewHolder(paramActivity);
    localVideoFeedsViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetRoundAngleFrameLayout = ((RoundAngleFrameLayout)paramLinearLayout.findViewById(2131381485));
    localVideoFeedsViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)paramLinearLayout.findViewById(2131368729));
    localVideoFeedsViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView = ((ReadInJoyHeadImageView)paramLinearLayout.findViewById(2131368603));
    localVideoFeedsViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView = ((ReadInJoyNickNameTextView)paramLinearLayout.findViewById(2131376552));
    localVideoFeedsViewHolder.b = ((TextView)paramLinearLayout.findViewById(2131366079));
    localVideoFeedsViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup = ((VideoViewGroup)paramLinearLayout.findViewById(2131381401));
    localVideoFeedsViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyVideoInfoViewGroup = ((ReadInJoyVideoInfoViewGroup)paramLinearLayout.findViewById(2131370039));
    a(localVideoFeedsViewHolder, paramArticleInfo, paramLinearLayout, paramActivity, paramReadInJoyArticleAdapter, paramInt1, paramInt2, paramInt3);
  }
  
  public static void a(VideoFeedsViewHolder paramVideoFeedsViewHolder, ArticleInfo paramArticleInfo, LinearLayout paramLinearLayout, Activity paramActivity, ReadInJoyArticleAdapter paramReadInJoyArticleAdapter, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramArticleInfo == null) {
      return;
    }
    a(paramVideoFeedsViewHolder, paramArticleInfo);
    VideoPlayManager.VideoPlayParam localVideoPlayParam = paramVideoFeedsViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam;
    paramVideoFeedsViewHolder.b.setText(ReadInJoyDisplayUtils.a(localVideoPlayParam.jdField_b_of_type_Int));
    a(paramVideoFeedsViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView);
    paramVideoFeedsViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setTag(paramArticleInfo);
    paramVideoFeedsViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setContentDescription(paramArticleInfo.mSubscribeName);
    Object localObject = paramArticleInfo.mSubscribeName;
    if (paramArticleInfo.mSubscribeName.length() > 18) {
      localObject = paramArticleInfo.mSubscribeName.substring(0, 17) + "…";
    }
    paramVideoFeedsViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setVisibility(0);
    paramVideoFeedsViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setText((CharSequence)localObject);
    paramVideoFeedsViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setContentDescription(paramArticleInfo.mSubscribeName);
    paramVideoFeedsViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.getPaint().setFakeBoldText(true);
    localObject = new HashSet();
    paramVideoFeedsViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyVideoInfoViewGroup.setArticleInfo(paramArticleInfo, paramReadInJoyArticleAdapter, paramInt1, (Set)localObject);
    a(paramVideoFeedsViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, paramArticleInfo.getVideoCoverUrlWithSmartCut(false), false, paramActivity, paramArticleInfo);
    paramVideoFeedsViewHolder.b.setVisibility(0);
    paramVideoFeedsViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup.setCustomSize(1.0F, ReadInJoyDisplayUtils.a(localVideoPlayParam.jdField_c_of_type_Int, localVideoPlayParam.jdField_d_of_type_Int));
    float f1 = DeviceInfoUtil.b(paramActivity);
    float f2 = f1 * ReadInJoyDisplayUtils.a(localVideoPlayParam.jdField_c_of_type_Int, localVideoPlayParam.jdField_d_of_type_Int);
    paramArticleInfo = paramVideoFeedsViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetRoundAngleFrameLayout.getLayoutParams();
    paramArticleInfo.width = ((int)f1);
    paramArticleInfo.height = ((int)f2);
    paramVideoFeedsViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetRoundAngleFrameLayout.setLayoutParams(paramArticleInfo);
    a(paramLinearLayout, (int)f1, (int)f2, paramActivity, paramInt2, paramInt3);
  }
  
  public static void a(VideoFeedsViewHolder paramVideoFeedsViewHolder, BaseArticleInfo paramBaseArticleInfo)
  {
    VideoPlayManager.VideoPlayParam localVideoPlayParam = a(paramBaseArticleInfo);
    localVideoPlayParam.jdField_a_of_type_AndroidViewView = paramVideoFeedsViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
    localVideoPlayParam.jdField_a_of_type_Int = paramVideoFeedsViewHolder.jdField_a_of_type_Int;
    localVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo = paramBaseArticleInfo;
    paramVideoFeedsViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam = localVideoPlayParam;
  }
  
  public static void a(KandianUrlImageView paramKandianUrlImageView, URL paramURL, boolean paramBoolean, Activity paramActivity, ArticleInfo paramArticleInfo)
  {
    UtilsForComponent.a(paramActivity, paramKandianUrlImageView);
    if (RIJItemViewType.a(paramArticleInfo) == 71) {
      paramURL = paramArticleInfo.getVideoCoverUrlWithSmartCut(false);
    }
    ReadInJoyDisplayUtils.a(paramKandianUrlImageView, paramURL, paramActivity, paramBoolean);
  }
  
  public static void a(ReadInJoyHeadImageView paramReadInJoyHeadImageView)
  {
    paramReadInJoyHeadImageView.setImageDrawable(ImageUtil.c());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyAnimUtils
 * JD-Core Version:    0.7.0.1
 */