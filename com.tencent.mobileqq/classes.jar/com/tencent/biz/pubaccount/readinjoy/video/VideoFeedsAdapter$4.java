package com.tencent.biz.pubaccount.readinjoy.video;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v4.os.TraceCompat;
import android.support.v7.widget.RecyclerView.ViewHolder;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.readinjoy.dt.RIJDtParamBuilder;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo.VideoExtraRepoerData;
import com.tencent.biz.pubaccount.readinjoy.video.videofeeds.BaseItemHolder;
import com.tencent.biz.pubaccount.readinjoy.video.videofeeds.BaseVideoItemHolder;
import com.tencent.biz.pubaccount.readinjoy.video.videofeeds.FooterItemHolder;
import com.tencent.biz.pubaccount.readinjoy.video.videofeeds.VideoItemHolder;
import com.tencent.biz.pubaccount.readinjoyAd.ad.video.strategy.VideoAdExposureManager;
import com.tencent.common.config.AppSetting;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;

class VideoFeedsAdapter$4
  implements VideoFeedsRecyclerView.ListEventListener
{
  VideoFeedsAdapter$4(VideoFeedsAdapter paramVideoFeedsAdapter) {}
  
  private void a(BaseVideoItemHolder paramBaseVideoItemHolder)
  {
    this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder = paramBaseVideoItemHolder;
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "onCenterViewChanged() videoInfo = " + this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.a.b());
    }
    VideoReport.setElementParams(paramBaseVideoItemHolder.itemView, new RIJDtParamBuilder().a(paramBaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.a).a("area", "list").a());
    if ((VideoFeedsAdapter.a(this.a) != null) && (this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam != null)) {
      VideoFeedsAdapter.a(this.a).a(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.a);
    }
    boolean bool;
    ReportInfo.VideoExtraRepoerData localVideoExtraRepoerData;
    if (!this.a.jdField_a_of_type_Boolean)
    {
      this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoIVideoFeedsItemUIDelegate.a(false, VideoFeedsAdapter.a(this.a));
      this.a.jdField_a_of_type_Boolean = true;
      bool = false;
      if ((this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder != null) && (this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam != null) && (!VideoFeedsAdapter.a()))
      {
        localVideoExtraRepoerData = new ReportInfo.VideoExtraRepoerData();
        if (this.a.jdField_a_of_type_AndroidAppActivity == null) {
          break label468;
        }
        localVideoExtraRepoerData.b = this.a.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
      }
    }
    label468:
    for (int i = this.a.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("REPORT_VIDEO_FEEDS_CHANNEL_ID", -1);; i = -1)
    {
      VideoReporter.b(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.a, i, 7, -1, localVideoExtraRepoerData, VideoFeedsAdapter.a(this.a).g);
      if (VideoFeedsAdapter.b(this.a))
      {
        TraceCompat.beginSection("playVideo");
        this.a.a(paramBaseVideoItemHolder);
        TraceCompat.endSection();
        VideoFeedsAdapter.a(this.a, false);
      }
      for (;;)
      {
        if (this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCommentManager != null) {
          this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCommentManager.a(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.a);
        }
        VideoFeedsAdapter.a(this.a).a(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder, bool);
        VideoFeedsAdapter.a(this.a, System.currentTimeMillis());
        if ((this.a.jdField_a_of_type_AndroidOsHandler != null) && (!AppSetting.d))
        {
          this.a.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
          this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, 3000L);
        }
        return;
        this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoIVideoFeedsItemUIDelegate.e(true);
        bool = true;
        break;
        VideoFeedsAdapter.a(this.a, true);
      }
    }
  }
  
  public void E_() {}
  
  public void a(RecyclerView.ViewHolder paramViewHolder)
  {
    this.a.jdField_a_of_type_AndroidOsHandler.removeMessages(7);
    BaseVideoItemHolder localBaseVideoItemHolder = this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder;
    if ((paramViewHolder instanceof BaseItemHolder))
    {
      BaseItemHolder localBaseItemHolder = (BaseItemHolder)paramViewHolder;
      if ((localBaseVideoItemHolder != null) && (localBaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoIVideoFeedsItemUIDelegate != null)) {
        localBaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoIVideoFeedsItemUIDelegate.e(false);
      }
      if ((localBaseItemHolder.c >= this.a.getItemCount() - 5) && (this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter$AdapterEventListener != null))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "onCenterViewChanged() holder.position = " + localBaseItemHolder.c + ", getCount() = " + this.a.getItemCount() + ", 推荐视频列表提前预拉取");
        }
        this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter$AdapterEventListener.d();
      }
    }
    if (((paramViewHolder instanceof FooterItemHolder)) && (((FooterItemHolder)paramViewHolder).a == 6))
    {
      VideoFeedsAdapter.f(this.a);
      this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder = null;
    }
    if ((paramViewHolder instanceof BaseVideoItemHolder)) {
      a((BaseVideoItemHolder)paramViewHolder);
    }
    VideoFeedsAccessibilityHelper.a(paramViewHolder);
    if (VideoFeedsAdapter.a(this.a) != null) {
      VideoFeedsAdapter.a(this.a).a(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder);
    }
    if (VideoFeedsAdapter.a(this.a) != null)
    {
      VideoFeedsAdapter.a(this.a, VideoFeedsAdapter.a(this.a).a, false);
      VideoFeedsAdapter.a(this.a, VideoFeedsAdapter.a(this.a).b, false);
    }
    if ((paramViewHolder instanceof VideoItemHolder))
    {
      VideoFeedsAdapter.a(this.a, ((VideoItemHolder)paramViewHolder).a, true);
      VideoFeedsAdapter.a(this.a, ((VideoItemHolder)paramViewHolder).b, true);
      VideoFeedsAdapter.a(this.a, (VideoItemHolder)paramViewHolder);
    }
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, boolean paramBoolean)
  {
    VideoFeedsAdapter.b(this.a, paramBoolean);
    if ((paramViewHolder instanceof BaseVideoItemHolder)) {
      ((BaseVideoItemHolder)paramViewHolder).jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoIVideoFeedsItemUIDelegate.g(VideoFeedsAdapter.c(this.a));
    }
  }
  
  public void b(RecyclerView.ViewHolder paramViewHolder) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter.4
 * JD-Core Version:    0.7.0.1
 */