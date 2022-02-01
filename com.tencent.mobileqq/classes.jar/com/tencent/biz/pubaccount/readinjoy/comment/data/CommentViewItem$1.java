package com.tencent.biz.pubaccount.readinjoy.comment.data;

import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.comment.CommentReportR5Builder;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.qroute.QRoute;

class CommentViewItem$1
  extends ClickableSpan
{
  CommentViewItem$1(CommentViewItem paramCommentViewItem, SubCommentData paramSubCommentData) {}
  
  public void onClick(View paramView)
  {
    ReadInJoyCommentUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataSubCommentData.uin, BaseActivity.sTopActivity);
    paramView = new CommentReportR5Builder(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommentViewItem).a().a();
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, ReadInJoyCommentUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommentViewItem.a), "0X800900D", "0X800900D", 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommentViewItem.a.mArticleID), String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommentViewItem.a.mAlgorithmID), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommentViewItem.a.innerUniqueID, paramView, false);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataSubCommentData.isAuthorSelection()) {}
    for (String str = "#FF8444";; str = "#737373")
    {
      paramTextPaint.setColor(Color.parseColor(str));
      paramTextPaint.setUnderlineText(false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.data.CommentViewItem.1
 * JD-Core Version:    0.7.0.1
 */