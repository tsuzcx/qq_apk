package com.tencent.biz.pubaccount.readinjoy.comment;

import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.qroute.QRoute;

class CommentInfo$1
  extends ClickableSpan
{
  CommentInfo$1(CommentInfo paramCommentInfo1, CommentInfo paramCommentInfo2, BaseActivity paramBaseActivity) {}
  
  public void onClick(View paramView)
  {
    ReadInJoyCommentUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentCommentInfo.authorUin, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    paramView = new ReadInJoyCommentUtils.CommentReportR5Builder(this.b.articleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentCommentInfo).a(ReadInJoyCommentListAdapter.a).b(this.b.area).c(0).a().a();
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, ReadInJoyCommentUtils.a(this.b.articleInfo), "0X800900D", "0X800900D", 0, 0, String.valueOf(this.b.articleInfo.mArticleID), String.valueOf(this.b.articleInfo.mAlgorithmID), this.b.articleInfo.innerUniqueID, paramView, false);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setColor(Color.parseColor("#4D7CAF"));
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.CommentInfo.1
 * JD-Core Version:    0.7.0.1
 */