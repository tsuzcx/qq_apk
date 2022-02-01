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
      PublicView.a(this.a).sendEmptyMessage(1);
      PublicView.a(this.a).sendEmptyMessage(3);
      return;
    }
    PublicView.a(this.a).springBackOverScrollHeaderView();
    PublicView.a(this.a, 1, 2131719247);
    PublicView.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.publicaccount.PublicView.1
 * JD-Core Version:    0.7.0.1
 */