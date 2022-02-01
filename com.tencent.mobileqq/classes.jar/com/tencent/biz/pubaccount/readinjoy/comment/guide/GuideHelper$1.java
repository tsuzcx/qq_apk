package com.tencent.biz.pubaccount.readinjoy.comment.guide;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.comment.data.CommentViewItem;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class GuideHelper$1
  implements View.OnClickListener
{
  GuideHelper$1(GuideHelper paramGuideHelper, CommentViewItem paramCommentViewItem, Context paramContext) {}
  
  public void onClick(View paramView)
  {
    QLog.d("GuideHelper", 1, "getBottomGuideView : " + GuideHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentGuideGuideHelper));
    GuideHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentGuideGuideHelper, "0X8009FEA", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommentViewItem.a);
    ReadInJoyUtils.a(this.jdField_a_of_type_AndroidContentContext, GuideHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentGuideGuideHelper));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.guide.GuideHelper.1
 * JD-Core Version:    0.7.0.1
 */