package com.tencent.biz.pubaccount.readinjoy.view.fastweb.item;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyTimeUtils;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.MultiVideoConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.RIJItemViewType;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.preparse.RIJPreParseData;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJJumpUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadinjoyVideoReportData;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo.VideoExtraRepoerData;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.FeedsInfoUser;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCVideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoAutoPlayController;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayActivity;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.VideoPlayParam;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayUtils;
import com.tencent.biz.pubaccount.readinjoy.video.VideoVolumeControl;
import com.tencent.biz.pubaccount.readinjoy.video.multivideo.MultiVideoHelper;
import com.tencent.biz.pubaccount.readinjoy.video.videourl.ThirdVideoManager;
import com.tencent.biz.pubaccount.readinjoy.video.videourl.VideoUrlInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.VideoData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.ReportUtil;
import com.tencent.biz.pubaccount.util.api.IPublicAccountHttpDownloader;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.net.URL;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

class WebFastVideoViewCreator$VideoViewHolder
  extends BaseItemViewHolder
  implements View.OnClickListener
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private int e;
  
  public WebFastVideoViewCreator$VideoViewHolder(View paramView, BaseData paramBaseData)
  {
    super(paramView, paramBaseData);
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131381307));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131381437));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
  }
  
  public static int a(Context paramContext)
  {
    return paramContext.getResources().getDisplayMetrics().widthPixels;
  }
  
  private Bundle a(VideoPlayManager.VideoPlayParam paramVideoPlayParam, BaseArticleInfo paramBaseArticleInfo)
  {
    Bundle localBundle1 = new Bundle();
    label107:
    boolean bool;
    label278:
    label289:
    int i;
    label374:
    Bundle localBundle2;
    if (paramVideoPlayParam.jdField_f_of_type_Int == 1)
    {
      localBundle1.putString("VIDEO_PUB_ACCOUNT_UIN", paramBaseArticleInfo.mSubscribeID);
      localBundle1.putString("VIDEO_PUB_ACCOUNT_NAME", paramBaseArticleInfo.mSubscribeName);
      if (paramVideoPlayParam.jdField_f_of_type_Int != 6) {
        break label909;
      }
      localBundle1.putString("VIDEO_H5_URL", ((SocializeFeedsInfo.UGCVideoInfo)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_b_of_type_JavaUtilArrayList.get(0)).h);
      localBundle1.putString("VIDEO_CREATE_TIME", ReadInJoyTimeUtils.a(((SocializeFeedsInfo.UGCVideoInfo)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_b_of_type_JavaUtilArrayList.get(0)).jdField_e_of_type_Int, true));
      localBundle1.putString("VIDEO_TIME", String.valueOf(paramVideoPlayParam.jdField_b_of_type_Int));
      localBundle1.putString("VIDEO_WIDTH", String.valueOf(paramVideoPlayParam.jdField_c_of_type_Int));
      localBundle1.putString("VIDEO_HEIGHT", String.valueOf(paramVideoPlayParam.jdField_d_of_type_Int));
      localBundle1.putString("VIDEO_VID", paramVideoPlayParam.jdField_c_of_type_JavaLangString);
      localBundle1.putString("VIDEO_COVER", paramVideoPlayParam.jdField_b_of_type_JavaLangString);
      localBundle1.putString("VIDEO_TITLE", paramBaseArticleInfo.mTitle);
      localBundle1.putString("VIDEO_SUMMARY", paramBaseArticleInfo.mTitle);
      if (paramVideoPlayParam.jdField_f_of_type_Int != 6) {
        break label938;
      }
      localBundle1.putString("VIDEO_ARTICLE_ID", ((SocializeFeedsInfo.UGCVideoInfo)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_b_of_type_JavaUtilArrayList.get(0)).jdField_g_of_type_JavaLangString);
      localBundle1.putLong("VIDEO_FEED_ID", paramBaseArticleInfo.mFeedId);
      localBundle1.putInt("VIDEO_FEED_TYPE", paramBaseArticleInfo.mFeedType);
      localBundle1.putString("VIDEO_TITLE", ((SocializeFeedsInfo.UGCVideoInfo)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_b_of_type_JavaUtilArrayList.get(0)).jdField_e_of_type_JavaLangString);
      if (paramVideoPlayParam.jdField_f_of_type_Int != 1) {
        break label963;
      }
      bool = true;
      localBundle1.putBoolean("VIDEO_IS_FROM_PUBLIC_ACCOUNT", bool);
      localBundle1.putString("VIDEO_RECOMMEND_REASON", paramBaseArticleInfo.mRecommentdReason);
      localBundle1.putBoolean("isFromKandian", true);
      localBundle1.putLong("channelID", paramBaseArticleInfo.mChannelID);
      localBundle1.putLong("algorithmID", paramBaseArticleInfo.mAlgorithmID);
      localBundle1.putString("innderId", paramBaseArticleInfo.innerUniqueID);
      localBundle1.putLong("strategyId", paramBaseArticleInfo.mStrategyId);
      if (!TextUtils.isEmpty(paramBaseArticleInfo.mArticleFriendLikeText)) {
        break label969;
      }
      i = 0;
      localBundle1.putInt("interactionType", i);
      localBundle1.putString("VIDEO_THIRD_ICON", paramVideoPlayParam.jdField_d_of_type_JavaLangString);
      localBundle1.putString("VIDEO_THIRD_NAME", paramVideoPlayParam.jdField_e_of_type_JavaLangString);
      localBundle1.putString("VIDEO_THIRD_ACTION", paramVideoPlayParam.jdField_f_of_type_JavaLangString);
      localBundle1.putString("VIDEO_THIRD_URL", paramVideoPlayParam.jdField_g_of_type_JavaLangString);
      localBundle1.putInt("VIDEO_ARTICLE_BUSITYPE", paramVideoPlayParam.jdField_f_of_type_Int);
      localBundle2 = new Bundle();
      localBundle2.putString("VINFO", paramVideoPlayParam.jdField_c_of_type_JavaLangString);
      localBundle2.putString("TINFO", paramVideoPlayParam.jdField_c_of_type_JavaLangString);
      localBundle2.putInt("PREVIEW_VIDEO_TIME", paramVideoPlayParam.jdField_b_of_type_Int);
      localBundle2.putInt("PREVIEW_START_POSI", VideoPlayUtils.a(0, paramVideoPlayParam.jdField_b_of_type_Int));
      localBundle2.putInt("PREVIEW_VIDEO_WIDTH", paramVideoPlayParam.jdField_c_of_type_Int);
      localBundle2.putInt("PREVIEW_VIDEO_HEIGHT", paramVideoPlayParam.jdField_d_of_type_Int);
      localBundle2.putInt("FULL_VIDEO_TIME", paramVideoPlayParam.jdField_b_of_type_Int);
      localBundle2.putString("source_puin", paramBaseArticleInfo.mSubscribeID);
      if (paramVideoPlayParam.jdField_f_of_type_Int != 1) {
        break label974;
      }
      localBundle2.putString("ACCOUNT_UIN", paramBaseArticleInfo.mSubscribeID);
      localBundle2.putString("ACCOUNT_NAME", paramBaseArticleInfo.mSubscribeName);
    }
    for (;;)
    {
      localBundle2.putInt("TYPE", paramVideoPlayParam.jdField_f_of_type_Int);
      localBundle2.putString("ARTICLE_ID", paramBaseArticleInfo.innerUniqueID);
      localBundle2.putInt("layout_item", 5);
      localBundle2.putBoolean("video_url_load", false);
      localBundle2.putString("image_url_remote", paramVideoPlayParam.jdField_b_of_type_JavaLangString);
      localBundle2.putString("detail_url", paramBaseArticleInfo.mArticleContentUrl);
      localBundle2.putString("video_url", paramVideoPlayParam.jdField_c_of_type_JavaLangString);
      localBundle2.putString("title", paramBaseArticleInfo.mTitle);
      localBundle2.putString("req_create_time", ReadInJoyTimeUtils.b(paramBaseArticleInfo.mTime));
      localBundle2.putString("brief_key", paramBaseArticleInfo.mTitle);
      localBundle2.putInt("req_type", 140);
      localBundle1.putByteArray("STRUCT_MSG_BYTES", ((StructMsgForGeneralShare)StructMsgFactory.a(localBundle2)).getBytes());
      localBundle1.putString("KEY_VIDEO_JSON_LIST", paramBaseArticleInfo.mJsonVideoList);
      return localBundle1;
      if (paramVideoPlayParam.jdField_f_of_type_Int == 6)
      {
        if (RIJItemViewType.g(paramBaseArticleInfo)) {
          localBundle1.putString("VIDEO_PUB_ACCOUNT_UIN", "" + paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser.a);
        }
        for (;;)
        {
          localBundle1.putString("VIDEO_PUB_ACCOUNT_NAME", paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_b_of_type_JavaLangString);
          if (RIJItemViewType.q((ArticleInfo)paramBaseArticleInfo)) {
            break;
          }
          localBundle1.putString("VIDEO_URL", ((SocializeFeedsInfo.UGCVideoInfo)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_b_of_type_JavaUtilArrayList.get(0)).jdField_b_of_type_JavaLangString);
          break;
          localBundle1.putString("VIDEO_PUB_ACCOUNT_UIN", "" + paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.a);
        }
      }
      localBundle1.putString("VIDEO_PUB_ACCOUNT_UIN", paramBaseArticleInfo.thirdUin);
      localBundle1.putString("VIDEO_PUB_ACCOUNT_NAME", paramBaseArticleInfo.thirdUinName);
      break;
      label909:
      localBundle1.putString("VIDEO_H5_URL", paramBaseArticleInfo.mArticleContentUrl);
      localBundle1.putString("VIDEO_CREATE_TIME", ReadInJoyTimeUtils.a(paramBaseArticleInfo.mTime, true));
      break label107;
      label938:
      localBundle1.putString("VIDEO_ARTICLE_ID", paramBaseArticleInfo.innerUniqueID);
      localBundle1.putString("VIDEO_TITLE", paramBaseArticleInfo.mTitle);
      break label278;
      label963:
      bool = false;
      break label289;
      label969:
      i = 1;
      break label374;
      label974:
      localBundle2.putString("ACCOUNT_UIN", paramBaseArticleInfo.thirdUin);
      localBundle2.putString("ACCOUNT_NAME", paramBaseArticleInfo.thirdUinName);
    }
  }
  
  private void a(ArticleInfo paramArticleInfo)
  {
    VideoPlayManager.VideoPlayParam localVideoPlayParam = new VideoPlayManager.VideoPlayParam();
    localVideoPlayParam.jdField_c_of_type_Long = paramArticleInfo.mArticleID;
    localVideoPlayParam.jdField_e_of_type_Long = paramArticleInfo.mXGFileSize;
    localVideoPlayParam.h = paramArticleInfo.thirdUin;
    localVideoPlayParam.i = paramArticleInfo.thirdUinName;
    localVideoPlayParam.k = paramArticleInfo.mSubscribeID;
    localVideoPlayParam.jdField_g_of_type_Int = paramArticleInfo.mStrategyId;
    localVideoPlayParam.jdField_g_of_type_Long = paramArticleInfo.mAlgorithmID;
    ReadinjoyVideoReportData localReadinjoyVideoReportData = new ReadinjoyVideoReportData();
    localReadinjoyVideoReportData.jdField_a_of_type_JavaLangLong = Long.valueOf(paramArticleInfo.mArticleID);
    localReadinjoyVideoReportData.jdField_a_of_type_JavaLangString = paramArticleInfo.innerUniqueID;
    localVideoPlayParam.jdField_c_of_type_JavaLangString = paramArticleInfo.mVideoVid;
    localVideoPlayParam.jdField_f_of_type_Int = paramArticleInfo.busiType;
    localVideoPlayParam.jdField_c_of_type_Int = paramArticleInfo.mVideoJsonWidth;
    localVideoPlayParam.jdField_d_of_type_Int = paramArticleInfo.mVideoJsonHeight;
    localReadinjoyVideoReportData.jdField_a_of_type_Int = paramArticleInfo.busiType;
    localVideoPlayParam.jdField_b_of_type_Int = paramArticleInfo.mVideoDuration;
    if (paramArticleInfo.mVideoCoverUrl == null) {}
    for (String str = null;; str = paramArticleInfo.mVideoCoverUrl.getFile())
    {
      localVideoPlayParam.jdField_b_of_type_JavaLangString = str;
      localVideoPlayParam.j = paramArticleInfo.innerUniqueID;
      localReadinjoyVideoReportData.jdField_b_of_type_JavaLangString = paramArticleInfo.mVideoVid;
      localVideoPlayParam.a = localReadinjoyVideoReportData;
      localVideoPlayParam.jdField_d_of_type_JavaLangString = paramArticleInfo.thirdIcon;
      localVideoPlayParam.jdField_e_of_type_JavaLangString = paramArticleInfo.thirdName;
      localVideoPlayParam.jdField_f_of_type_JavaLangString = paramArticleInfo.thirdAction;
      new ReportInfo.VideoExtraRepoerData().jdField_a_of_type_Int = 409409;
      a(localVideoPlayParam, paramArticleInfo);
      return;
    }
  }
  
  public void a(VideoPlayManager.VideoPlayParam paramVideoPlayParam, BaseArticleInfo paramBaseArticleInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "open full play activity, articleID : " + paramBaseArticleInfo.mArticleID + ", playPosition : " + paramVideoPlayParam.jdField_d_of_type_Long + ",vid : " + paramVideoPlayParam.jdField_c_of_type_JavaLangString);
    }
    Bundle localBundle = a(paramVideoPlayParam, paramBaseArticleInfo);
    if (paramVideoPlayParam.jdField_f_of_type_Int == 2)
    {
      localObject = ThirdVideoManager.a(paramVideoPlayParam.jdField_c_of_type_JavaLangString);
      if (localObject != null)
      {
        localBundle.putString("VIDEO_THIRD_VID_URL", ((VideoUrlInfo)localObject).jdField_a_of_type_JavaLangString);
        localBundle.putLong("VIDEO_THIRD_VID_URL_TIME", ((VideoUrlInfo)localObject).b);
      }
    }
    localBundle.putBoolean("VIDEO_LIST_SCROLL_EXIT", true);
    localBundle.putInt("REPORT_VIDEO_FEEDS_JUMP_FROM", 3);
    localBundle.putInt("VIDEO_FROM_TYPE", 10);
    Object localObject = (Activity)this.jdField_a_of_type_AndroidViewView.getContext();
    Intent localIntent = new Intent((Context)localObject, VideoFeedsPlayActivity.class);
    localIntent.addFlags(536870912);
    if (BaseApplicationImpl.sProcessId != 1)
    {
      localBundle.putBoolean("param_needSmooth", VideoVolumeControl.a().d());
      VideoVolumeControl.a().d(true);
      localBundle.putBoolean("param_needAlertInXg", VideoAutoPlayController.d());
    }
    if (paramVideoPlayParam.jdField_f_of_type_Int == 6) {
      localBundle.putParcelable("VIDEO_ARTICLE_INFO_FOR_BIU", (ArticleInfo)paramBaseArticleInfo);
    }
    localIntent.putExtras(localBundle);
    int i = 9091;
    if (1 == paramBaseArticleInfo.mVideoType) {
      i = 1;
    }
    for (;;)
    {
      int j = 0;
      try
      {
        boolean bool = MultiVideoConfigHandler.a(localBundle.getInt("VIDEO_FROM_TYPE", -1), Integer.valueOf(localBundle.getString("VIDEO_WIDTH")).intValue(), Integer.valueOf(localBundle.getString("VIDEO_HEIGHT")).intValue(), Integer.valueOf(localBundle.getString("VIDEO_TIME")).intValue());
        j = bool;
      }
      catch (Exception paramVideoPlayParam)
      {
        label323:
        break label323;
      }
      if (j == 0) {
        break;
      }
      paramVideoPlayParam = new Intent();
      paramVideoPlayParam.putExtras(localBundle);
      MultiVideoHelper.a((Activity)localObject, paramVideoPlayParam, i);
      ((Activity)localObject).overridePendingTransition(2130772014, 2130772015);
      return;
      if (0L == paramBaseArticleInfo.mChannelID) {
        i = 1;
      }
    }
    ((Activity)localObject).startActivityForResult(localIntent, i);
    ((Activity)localObject).overridePendingTransition(2130772086, 2130772087);
  }
  
  public void b(BaseData paramBaseData1, BaseData paramBaseData2, boolean paramBoolean)
  {
    paramBaseData1 = (VideoData)paramBaseData2;
    int i = AIOUtils.a(12.0F, this.jdField_a_of_type_AndroidViewView.getContext().getResources());
    i = a(this.jdField_a_of_type_ComTencentImageURLImageView.getContext()) - i - i;
    this.jdField_e_of_type_Int = (i * 280 / 496);
    paramBaseData2 = URLDrawable.URLDrawableOptions.obtain();
    paramBaseData2.mRequestWidth = i;
    paramBaseData2.mRequestHeight = this.jdField_e_of_type_Int;
    paramBaseData2.mLoadingDrawable = new ColorDrawable(-2565414);
    paramBaseData2.mMemoryCacheKeySuffix = "fast_web";
    if (TextUtils.isEmpty(paramBaseData1.jdField_a_of_type_JavaLangString)) {
      RIJJumpUtils.a(paramBaseData1.jdField_b_of_type_JavaLangString, paramBaseData1.jdField_d_of_type_JavaLangString, paramBaseData1.jdField_c_of_type_JavaLangString, paramBaseData1.jdField_e_of_type_JavaLangString, new WebFastVideoViewCreator.VideoViewHolder.1(this, paramBaseData1));
    }
    paramBaseData2 = URLDrawable.getDrawable(((IPublicAccountHttpDownloader)QRoute.api(IPublicAccountHttpDownloader.class)).makeURL(paramBaseData1.jdField_a_of_type_JavaLangString, 4), paramBaseData2);
    if ((paramBaseData2 != null) && (paramBaseData2.getStatus() == 2)) {
      paramBaseData2.restartDownload();
    }
    this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramBaseData2);
    this.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams().width = i;
    this.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams().height = this.jdField_e_of_type_Int;
    this.jdField_a_of_type_AndroidWidgetImageView.setTag(paramBaseData1);
  }
  
  public void onClick(View paramView)
  {
    VideoData localVideoData = (VideoData)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData;
    Context localContext = this.jdField_a_of_type_AndroidViewView.getContext();
    ArticleInfo localArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData.b;
    Object localObject;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData.a.c()) {
      localObject = "2";
    }
    for (;;)
    {
      localObject = RIJTransMergeKanDianReport.a(localContext, localArticleInfo, 0, (String)localObject);
      try
      {
        ((JSONObject)localObject).put("vedio_rowkey", localVideoData.jdField_b_of_type_JavaLangString);
        ReportUtil.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData.b, "0X800898F", ((JSONObject)localObject).toString());
        localObject = new ArticleInfo();
        ((ArticleInfo)localObject).mVideoJsonWidth = localVideoData.jdField_a_of_type_Int;
        ((ArticleInfo)localObject).mVideoJsonHeight = localVideoData.jdField_b_of_type_Int;
        ((ArticleInfo)localObject).mVideoVid = localVideoData.jdField_b_of_type_JavaLangString;
        ((ArticleInfo)localObject).busiType = localVideoData.jdField_c_of_type_Int;
        ((ArticleInfo)localObject).mVideoCoverUrl = RIJPreParseData.a(localVideoData.jdField_a_of_type_JavaLangString);
        ((ArticleInfo)localObject).mArticleContentUrl = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData.b.mArticleContentUrl;
        ((ArticleInfo)localObject).mTitle = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData.b.mTitle;
        a((ArticleInfo)localObject);
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        localObject = "1";
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.item.WebFastVideoViewCreator.VideoViewHolder
 * JD-Core Version:    0.7.0.1
 */