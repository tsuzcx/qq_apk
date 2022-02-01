package com.tencent.biz.pubaccount.readinjoy.comment.data;

import android.graphics.Color;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.qroute.QRoute;
import org.jetbrains.annotations.NotNull;

class CommentViewItem$4
  extends ClickableSpan
{
  CommentViewItem$4(CommentViewItem paramCommentViewItem, BaseCommentData paramBaseCommentData, String paramString1, String paramString2) {}
  
  public void onClick(@NotNull View paramView)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.isAuthorReply()) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.ksHomePage))) {
      ReadInJoyCommentUtils.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.ksHomePage, BaseActivity.sTopActivity);
    }
    for (;;)
    {
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, ReadInJoyCommentUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommentViewItem.a), "0X800900D", "0X800900D", 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommentViewItem.a.mArticleID), String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommentViewItem.a.mAlgorithmID), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommentViewItem.a.innerUniqueID, this.b, false);
      return;
      ReadInJoyCommentUtils.a(this.jdField_a_of_type_JavaLangString, BaseActivity.sTopActivity);
    }
  }
  
  public void updateDrawState(@NotNull TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setColor(Color.parseColor("#376099"));
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.data.CommentViewItem.4
 * JD-Core Version:    0.7.0.1
 */