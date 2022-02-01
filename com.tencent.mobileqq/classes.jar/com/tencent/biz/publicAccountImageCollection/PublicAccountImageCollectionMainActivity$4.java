package com.tencent.biz.publicAccountImageCollection;

import com.tencent.biz.pubaccount.PublicAccountArticleHandler;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.ArrayList;

class PublicAccountImageCollectionMainActivity$4
  implements Runnable
{
  PublicAccountImageCollectionMainActivity$4(PublicAccountImageCollectionMainActivity paramPublicAccountImageCollectionMainActivity) {}
  
  public void run()
  {
    PublicAccountImageCollectionMainActivity.a(this.this$0).c(this.this$0.b);
    PublicAccountImageCollectionMainActivity.a(this.this$0).e(this.this$0.b);
    PublicAccountImageCollectionMainActivity.a(this.this$0).b(this.this$0.b);
    PublicAccountImageCollectionMainActivity.a(this.this$0).d(this.this$0.b);
    if (PublicAccountImageCollectionMainActivity.c(this.this$0))
    {
      PublicAccountImageCollectionMainActivity.a(this.this$0).a(this.this$0.b, PublicAccountImageCollectionMainActivity.a(this.this$0), PublicAccountImageCollectionMainActivity.e(this.this$0), PublicAccountImageCollectionMainActivity.f(this.this$0));
      return;
    }
    if ((PublicAccountImageCollectionMainActivity.a(this.this$0) != null) && (PublicAccountImageCollectionMainActivity.a(this.this$0).a != null)) {}
    for (int i = PublicAccountImageCollectionMainActivity.a(this.this$0).a.size();; i = 0)
    {
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, this.this$0.a, "0X8007B8A", "0X8007B8A", 0, 0, this.this$0.b, this.this$0.c, "" + PublicAccountImageCollectionMainActivity.b(this.this$0, PublicAccountImageCollectionMainActivity.a(this.this$0)), "" + i, false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionMainActivity.4
 * JD-Core Version:    0.7.0.1
 */