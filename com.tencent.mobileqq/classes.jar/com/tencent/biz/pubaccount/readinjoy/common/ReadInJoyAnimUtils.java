package com.tencent.biz.pubaccount.readinjoy.common;

import android.app.Activity;
import android.text.TextPaint;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.UtilsForComponent;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadinjoyVideoReportData;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.VideoPlayParam;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyArticleAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.VideoFeedsViewHolder;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyVideoInfoViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.VideoViewGroup;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import java.net.URL;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class ReadInJoyAnimUtils
{
  public static VideoPlayManager.VideoPlayParam a(BaseArticleInfo paramBaseArticleInfo)
  {
    VideoPlayManager.VideoPlayParam localVideoPlayParam = new VideoPlayManager.VideoPlayParam();
    localVideoPlayParam.jdField_a_of_type_JavaLangString = paramBaseArticleInfo.mVideoVid;
    localVideoPlayParam.jdField_a_of_type_Long = paramBaseArticleInfo.mArticleID;
    localVideoPlayParam.jdField_a_of_type_Int = paramBaseArticleInfo.mVideoDuration;
    localVideoPlayParam.jdField_b_of_type_Int = paramBaseArticleInfo.mVideoJsonWidth;
    localVideoPlayParam.jdField_c_of_type_Int = paramBaseArticleInfo.mVideoJsonHeight;
    if (paramBaseArticleInfo.mVideoCoverUrl == null) {}
    for (Object localObject = null;; localObject = paramBaseArticleInfo.mVideoCoverUrl.getFile())
    {
      localVideoPlayParam.jdField_b_of_type_JavaLangString = ((String)localObject);
      localVideoPlayParam.j = paramBaseArticleInfo.mSubscribeID;
      localVideoPlayParam.g = paramBaseArticleInfo.mStrategyId;
      localVideoPlayParam.jdField_f_of_type_Long = paramBaseArticleInfo.mAlgorithmID;
      localObject = new ReadinjoyVideoReportData();
      ((ReadinjoyVideoReportData)localObject).jdField_a_of_type_JavaLangLong = Long.valueOf(paramBaseArticleInfo.mArticleID);
      ((ReadinjoyVideoReportData)localObject).jdField_a_of_type_JavaLangString = paramBaseArticleInfo.mVideoVid;
      ((ReadinjoyVideoReportData)localObject).jdField_a_of_type_Int = paramBaseArticleInfo.busiType;
      localVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData = ((ReadinjoyVideoReportData)localObject);
      localVideoPlayParam.jdField_c_of_type_JavaLangString = paramBaseArticleInfo.thirdIcon;
      localVideoPlayParam.d = paramBaseArticleInfo.thirdName;
      localVideoPlayParam.jdField_e_of_type_JavaLangString = paramBaseArticleInfo.thirdAction;
      localVideoPlayParam.jdField_e_of_type_Int = paramBaseArticleInfo.busiType;
      localVideoPlayParam.i = paramBaseArticleInfo.innerUniqueID;
      localVideoPlayParam.jdField_e_of_type_Long = paramBaseArticleInfo.mChannelID;
      return localVideoPlayParam;
    }
  }
  
  public static void a(ImageView paramImageView, int paramInt1, int paramInt2)
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.leftMargin = (paramInt1 - 100);
    localLayoutParams.topMargin = (paramInt2 - 100);
    paramImageView.setLayoutParams(localLayoutParams);
    paramImageView.setRotation(new Random().nextInt(30) - 15);
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
    ReadInJoyBaseAdapter.VideoFeedsViewHolder localVideoFeedsViewHolder = new ReadInJoyBaseAdapter.VideoFeedsViewHolder();
    localVideoFeedsViewHolder.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramLinearLayout.findViewById(2131367093));
    localVideoFeedsViewHolder.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramLinearLayout.findViewById(2131367210));
    localVideoFeedsViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)paramLinearLayout.findViewById(2131361846));
    localVideoFeedsViewHolder.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramLinearLayout.findViewById(2131362701));
    localVideoFeedsViewHolder.b = ((TextView)paramLinearLayout.findViewById(2131362204));
    localVideoFeedsViewHolder.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramLinearLayout.findViewById(2131364171));
    localVideoFeedsViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup = ((VideoViewGroup)paramLinearLayout.findViewById(2131367094));
    localVideoFeedsViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyVideoInfoViewGroup = ((ReadInJoyVideoInfoViewGroup)paramLinearLayout.findViewById(2131367369));
    a(localVideoFeedsViewHolder, paramArticleInfo, paramLinearLayout, paramActivity, paramReadInJoyArticleAdapter, paramInt1, paramInt2, paramInt3);
  }
  
  public static void a(KandianUrlImageView paramKandianUrlImageView, URL paramURL, boolean paramBoolean, Activity paramActivity)
  {
    UtilsForComponent.a(paramActivity, paramKandianUrlImageView);
    ReadInJoyDisplayUtils.a(paramKandianUrlImageView, paramURL, paramActivity, paramBoolean);
  }
  
  public static void a(ReadInJoyBaseAdapter.VideoFeedsViewHolder paramVideoFeedsViewHolder, BaseArticleInfo paramBaseArticleInfo)
  {
    VideoPlayManager.VideoPlayParam localVideoPlayParam = a(paramBaseArticleInfo);
    localVideoPlayParam.jdField_a_of_type_AndroidViewView = paramVideoFeedsViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
    localVideoPlayParam.jdField_f_of_type_Int = paramVideoFeedsViewHolder.jdField_a_of_type_Int;
    localVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo = paramBaseArticleInfo;
    paramVideoFeedsViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam = localVideoPlayParam;
  }
  
  public static void a(ReadInJoyBaseAdapter.VideoFeedsViewHolder paramVideoFeedsViewHolder, BaseArticleInfo paramBaseArticleInfo, LinearLayout paramLinearLayout, Activity paramActivity, ReadInJoyArticleAdapter paramReadInJoyArticleAdapter, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramBaseArticleInfo == null) {
      return;
    }
    a(paramVideoFeedsViewHolder, paramBaseArticleInfo);
    VideoPlayManager.VideoPlayParam localVideoPlayParam = paramVideoFeedsViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam;
    paramVideoFeedsViewHolder.jdField_c_of_type_AndroidWidgetTextView.setText(ReadInJoyDisplayUtils.a(localVideoPlayParam.jdField_a_of_type_Int));
    a(paramVideoFeedsViewHolder.jdField_a_of_type_ComTencentImageURLImageView);
    paramVideoFeedsViewHolder.jdField_a_of_type_ComTencentImageURLImageView.setTag(paramBaseArticleInfo);
    paramVideoFeedsViewHolder.jdField_a_of_type_ComTencentImageURLImageView.setContentDescription(paramBaseArticleInfo.mSubscribeName);
    Object localObject = paramBaseArticleInfo.mSubscribeName;
    if (paramBaseArticleInfo.mSubscribeName.length() > 18) {
      localObject = paramBaseArticleInfo.mSubscribeName.substring(0, 17) + "…";
    }
    paramVideoFeedsViewHolder.b.setVisibility(0);
    paramVideoFeedsViewHolder.b.setText((CharSequence)localObject);
    paramVideoFeedsViewHolder.b.setContentDescription(paramBaseArticleInfo.mSubscribeName);
    paramVideoFeedsViewHolder.b.getPaint().setFakeBoldText(true);
    paramVideoFeedsViewHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(4);
    localObject = new HashSet();
    paramVideoFeedsViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyVideoInfoViewGroup.setArticleInfo(paramBaseArticleInfo, paramReadInJoyArticleAdapter, paramInt1, (Set)localObject);
    paramReadInJoyArticleAdapter = paramVideoFeedsViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
    if (paramBaseArticleInfo.mSinglePicture != null) {
      paramBaseArticleInfo = paramBaseArticleInfo.mSinglePicture;
    }
    for (;;)
    {
      a(paramReadInJoyArticleAdapter, paramBaseArticleInfo, false, paramActivity);
      paramVideoFeedsViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      paramVideoFeedsViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup.setCustomSize(1.0F, ReadInJoyDisplayUtils.a(localVideoPlayParam.jdField_b_of_type_Int, localVideoPlayParam.jdField_c_of_type_Int));
      float f1 = (float)DeviceInfoUtil.j();
      float f2 = f1 * ReadInJoyDisplayUtils.a(localVideoPlayParam.jdField_b_of_type_Int, localVideoPlayParam.jdField_c_of_type_Int);
      paramBaseArticleInfo = paramVideoFeedsViewHolder.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
      paramBaseArticleInfo.width = ((int)f1);
      paramBaseArticleInfo.height = ((int)f2);
      paramVideoFeedsViewHolder.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams(paramBaseArticleInfo);
      a(paramLinearLayout, (int)f1, (int)f2, paramActivity, paramInt2, paramInt3);
      return;
      if (paramBaseArticleInfo.mVideoCoverUrl != null) {
        paramBaseArticleInfo = paramBaseArticleInfo.mVideoCoverUrl;
      } else {
        paramBaseArticleInfo = ReadInJoyUtils.b(paramBaseArticleInfo.mFirstPagePicUrl);
      }
    }
  }
  
  public static void a(URLImageView paramURLImageView)
  {
    paramURLImageView.setImageDrawable(ImageUtil.b());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyAnimUtils
 * JD-Core Version:    0.7.0.1
 */