package com.tencent.mobileqq.activity.contact.addcontact.publicaccount;

import com.tencent.mobileqq.app.PublicAccountObserver;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.widget.XListView;

class PublicView$2
  extends PublicAccountObserver
{
  PublicView$2(PublicView paramPublicView) {}
  
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
    PublicView.a(this.a, 1, 2131719529);
    PublicView.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.publicaccount.PublicView.2
 * JD-Core Version:    0.7.0.1
 */