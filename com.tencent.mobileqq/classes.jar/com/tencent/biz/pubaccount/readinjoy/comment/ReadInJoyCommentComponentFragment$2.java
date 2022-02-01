package com.tencent.biz.pubaccount.readinjoy.comment;

import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.qroute.QRoute;

class ReadInJoyCommentComponentFragment$2
  implements Runnable
{
  ReadInJoyCommentComponentFragment$2(ReadInJoyCommentComponentFragment paramReadInJoyCommentComponentFragment) {}
  
  public void run()
  {
    String str = "";
    if (ReadInJoyCommentComponentFragment.a(this.this$0) == 1) {
      str = "0X80094C4";
    }
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "", str, 0, 0, String.valueOf(this.this$0.d), "", "", ReadInJoyCommentComponentFragment.a(this.this$0, true), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentComponentFragment.2
 * JD-Core Version:    0.7.0.1
 */