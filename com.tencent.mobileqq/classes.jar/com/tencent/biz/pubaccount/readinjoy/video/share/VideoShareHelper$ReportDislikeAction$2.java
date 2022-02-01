package com.tencent.biz.pubaccount.readinjoy.video.share;

import android.view.View;
import android.view.animation.Animation;
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.biz.pubaccount.readinjoy.video.report.VideoR5;
import com.tencent.biz.pubaccount.readinjoy.video.report.VideoR5.Builder;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyDisLikeDialogView.OnUninterestConfirmListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.widget.ActionSheet;
import java.util.ArrayList;
import org.json.JSONObject;

class VideoShareHelper$ReportDislikeAction$2
  implements ReadInJoyDisLikeDialogView.OnUninterestConfirmListener
{
  VideoShareHelper$ReportDislikeAction$2(VideoShareHelper.ReportDislikeAction paramReportDislikeAction, BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject) {}
  
  public boolean a(View paramView, ArrayList<DislikeInfo> paramArrayList, Object paramObject)
  {
    VideoShareHelper.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoShareVideoShareHelper$ReportDislikeAction.a, true);
    ReadInJoyUtils.a();
    VideoShareHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoShareVideoShareHelper$ReportDislikeAction.a).dismiss();
    ((Animation)VideoShareHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoShareVideoShareHelper$ReportDislikeAction.a).getTag(2131369928)).setAnimationListener(new VideoShareHelper.ReportDislikeAction.2.1(this, paramArrayList));
    VideoShareHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoShareVideoShareHelper$ReportDislikeAction.a).startAnimation((Animation)VideoShareHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoShareVideoShareHelper$ReportDislikeAction.a).getTag(2131369928));
    paramView = new VideoR5.Builder(VideoReporter.a(null, null, null, null, this.jdField_a_of_type_OrgJsonJSONObject)).i(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.innerUniqueID).a(paramArrayList);
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).videoDataReportWithFansInfoInR5(null, null, "0X800913C", "0X800913C", 0, 0, null, null, null, paramView.a().a(), false);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.share.VideoShareHelper.ReportDislikeAction.2
 * JD-Core Version:    0.7.0.1
 */