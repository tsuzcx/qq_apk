package com.tencent.biz.pubaccount.readinjoy.comment;

import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.qroute.QRoute;

class ReadInJoyCommentComponentFragment$TopicReportRunnable
  implements Runnable
{
  private ReadInJoyCommentComponentFragment$TopicReportRunnable(ReadInJoyCommentComponentFragment paramReadInJoyCommentComponentFragment) {}
  
  public void run()
  {
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, ReadInJoyCommentUtils.a(ReadInJoyCommentComponentFragment.a(this.this$0)), "0X800B9E0", "0X800B9E0", 0, 0, "", "", "", ReadInJoyCommentComponentFragment.a(this.this$0), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentComponentFragment.TopicReportRunnable
 * JD-Core Version:    0.7.0.1
 */