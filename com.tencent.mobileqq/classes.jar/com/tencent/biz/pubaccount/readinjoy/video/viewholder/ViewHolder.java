package com.tencent.biz.pubaccount.readinjoy.video.viewholder;

import android.content.Context;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyDisplayUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJFeedsType;
import com.tencent.biz.pubaccount.readinjoy.handlers.VideoHandler;
import com.tencent.biz.pubaccount.readinjoy.handlers.VideoHandler.PlayableItem;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.VideoColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.VideoPlayParam;
import com.tencent.biz.pubaccount.readinjoy.video.VideoUIManager.OnUIChangeListener;
import com.tencent.biz.pubaccount.readinjoy.video.report.VideoR5;
import com.tencent.biz.pubaccount.readinjoy.video.report.VideoR5.Builder;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import java.net.URL;
import java.util.List;

public abstract class ViewHolder
  implements Handler.Callback, VideoUIManager.OnUIChangeListener
{
  public int a;
  protected Context a;
  protected View.OnClickListener a;
  protected VideoHandler a;
  protected ViewHolder.VideoUIHandler a;
  public View g;
  
  public ViewHolder(Context paramContext, VideoHandler paramVideoHandler)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersVideoHandler = paramVideoHandler;
  }
  
  protected static void a(VideoHandler paramVideoHandler, BaseArticleInfo paramBaseArticleInfo, VideoColumnInfo paramVideoColumnInfo, int paramInt, String paramString)
  {
    int k = paramVideoHandler.a().a();
    String str = RIJFeedsType.b(paramBaseArticleInfo);
    int i;
    if (((ArticleInfo)paramBaseArticleInfo).hasChannelInfo())
    {
      i = paramBaseArticleInfo.mChannelInfoId;
      if (!TextUtils.isEmpty(paramBaseArticleInfo.mArticleFriendLikeText)) {
        break label227;
      }
    }
    label227:
    for (int j = 0;; j = 1)
    {
      paramVideoHandler = new VideoR5.Builder(RIJTransMergeKanDianReport.a(paramBaseArticleInfo.mAlgorithmID, RIJFeedsType.a(paramBaseArticleInfo), 0, i, j, NetworkUtil.h(paramVideoHandler.a()), str, paramBaseArticleInfo.mStrCircleId, paramBaseArticleInfo.innerUniqueID, RIJFeedsType.d(paramBaseArticleInfo), 409409, (ArticleInfo)paramBaseArticleInfo));
      paramVideoHandler.i(paramBaseArticleInfo.innerUniqueID).a(k).d(paramBaseArticleInfo.mStrategyId).g(VideoReporter.a).h(409409).j(paramBaseArticleInfo.mVideoAdsJumpType).k(paramBaseArticleInfo.mVideoAdsSource).a(Boolean.valueOf(RIJFeedsType.f(paramBaseArticleInfo))).a(paramBaseArticleInfo.videoReportInfo).R(paramInt).p(paramString).f(paramBaseArticleInfo);
      if (paramVideoColumnInfo != null) {
        paramVideoHandler.Y(paramVideoColumnInfo.a);
      }
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8007625", "0X8007625", 0, 0, "2", "", "", paramVideoHandler.a().a(), false);
      return;
      i = 0;
      break;
    }
  }
  
  public abstract View a(int paramInt, ViewGroup paramViewGroup);
  
  protected final VideoHandler.PlayableItem a(View paramView)
  {
    if ((paramView == null) || (!(paramView.getTag() instanceof VideoHandler.PlayableItem))) {
      return null;
    }
    return (VideoHandler.PlayableItem)paramView.getTag();
  }
  
  protected final BaseArticleInfo a(View paramView)
  {
    return VideoHandler.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersVideoHandler, paramView);
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  public void a(VideoPlayManager.VideoPlayParam paramVideoPlayParam, int paramInt1, int paramInt2) {}
  
  public void a(ViewHolder.VideoUIHandler paramVideoUIHandler)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoViewholderViewHolder$VideoUIHandler = paramVideoUIHandler;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoViewholderViewHolder$VideoUIHandler.a.add(this);
  }
  
  protected void a(KandianUrlImageView paramKandianUrlImageView, URL paramURL)
  {
    a(paramKandianUrlImageView, paramURL, false);
  }
  
  protected void a(KandianUrlImageView paramKandianUrlImageView, URL paramURL, boolean paramBoolean)
  {
    ReadInJoyDisplayUtils.a(paramKandianUrlImageView, paramURL, this.jdField_a_of_type_AndroidContentContext, paramBoolean);
  }
  
  public boolean a()
  {
    return false;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.viewholder.ViewHolder
 * JD-Core Version:    0.7.0.1
 */