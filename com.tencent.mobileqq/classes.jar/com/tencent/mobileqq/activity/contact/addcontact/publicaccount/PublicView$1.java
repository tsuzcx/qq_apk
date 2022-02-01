package com.tencent.mobileqq.activity.contact.addcontact.publicaccount;

import com.tencent.biz.pubaccount.api.IPublicAccountObserver.OnCallback;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.widget.XListView;

class PublicView$1
  extends IPublicAccountObserver.OnCallback
{
  PublicView$1(PublicView paramPublicView) {}
  
  public void onUpdateRecommendList(boolean paramBoolean)
  {
    if (true == paramBoolean)
    {
      PublicView.a(this.a).a(0);
      PublicView.b(this.a).sendEmptyMessage(1);
      PublicView.b(this.a).sendEmptyMessage(3);
      return;
    }
    PublicView.c(this.a).springBackOverScrollHeaderView();
    PublicView.a(this.a, 1, 2131916799);
    PublicView.d(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.publicaccount.PublicView.1
 * JD-Core Version:    0.7.0.1
 */