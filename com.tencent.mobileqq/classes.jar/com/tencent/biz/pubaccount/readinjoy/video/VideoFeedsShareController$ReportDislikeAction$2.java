package com.tencent.biz.pubaccount.readinjoy.video;

import android.app.Activity;
import android.content.res.Resources;
import android.view.View;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.biz.pubaccount.readinjoy.video.report.VideoR5;
import com.tencent.biz.pubaccount.readinjoy.video.report.VideoR5.Builder;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyDisLikeDialogView.OnUninterestConfirmListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.ActionSheet;
import java.util.ArrayList;
import org.json.JSONObject;

class VideoFeedsShareController$ReportDislikeAction$2
  implements ReadInJoyDisLikeDialogView.OnUninterestConfirmListener
{
  VideoFeedsShareController$ReportDislikeAction$2(VideoFeedsShareController.ReportDislikeAction paramReportDislikeAction, VideoInfo paramVideoInfo, JSONObject paramJSONObject) {}
  
  public boolean a(View paramView, ArrayList<DislikeInfo> paramArrayList, Object paramObject)
  {
    paramView = ReadInJoyUtils.a();
    if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) {
      ReadInJoyLogicEngine.a().a(Long.valueOf(paramView).longValue(), VideoFeedsShareController.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsShareController$ReportDislikeAction.a).a.makeDislikeParam(paramArrayList, VideoFeedsShareController.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsShareController$ReportDislikeAction.a).g));
    }
    QQToast.a(VideoFeedsShareController.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsShareController$ReportDislikeAction.a), -1, VideoFeedsShareController.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsShareController$ReportDislikeAction.a).getString(2131699744), 0).b(VideoFeedsShareController.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsShareController$ReportDislikeAction.a).getResources().getDimensionPixelSize(2131299166));
    VideoFeedsShareController.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsShareController$ReportDislikeAction.a).dismiss();
    VideoFeedsShareController.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsShareController$ReportDislikeAction.a, false);
    paramView = new VideoR5.Builder(VideoReporter.a(null, null, null, null, this.jdField_a_of_type_OrgJsonJSONObject)).i(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g).a(paramArrayList);
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).videoDataReportWithFansInfoInR5(null, null, "0X800913C", "0X800913C", 0, 0, null, null, null, paramView.a().a(), false);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsShareController.ReportDislikeAction.2
 * JD-Core Version:    0.7.0.1
 */