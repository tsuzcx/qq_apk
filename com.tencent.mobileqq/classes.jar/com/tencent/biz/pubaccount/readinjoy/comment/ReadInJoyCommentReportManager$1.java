package com.tencent.biz.pubaccount.readinjoy.comment;

import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.qroute.QRoute;

class ReadInJoyCommentReportManager$1
  implements Runnable
{
  ReadInJoyCommentReportManager$1(ReadInJoyCommentReportManager paramReadInJoyCommentReportManager, String paramString1, String paramString2) {}
  
  public void run()
  {
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(ReadInJoyCommentReportManager.a(this.this$0), ReadInJoyCommentUtils.a(ReadInJoyCommentReportManager.a(this.this$0)), this.a, this.a, 0, 0, String.valueOf(ReadInJoyCommentReportManager.a(this.this$0).innerUniqueID), String.valueOf(ReadInJoyCommentReportManager.a(this.this$0).mStrategyId), ReadInJoyCommentReportManager.a(this.this$0).innerUniqueID, this.b, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentReportManager.1
 * JD-Core Version:    0.7.0.1
 */