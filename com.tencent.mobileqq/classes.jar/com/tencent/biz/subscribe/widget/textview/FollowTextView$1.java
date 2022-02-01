package com.tencent.biz.subscribe.widget.textview;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.subscribe.event.FollowUpdateEvent;
import com.tencent.mobileqq.app.PublicAccountObserver;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.widget.QQToast;

class FollowTextView$1
  extends PublicAccountObserver
{
  FollowTextView$1(FollowTextView paramFollowTextView) {}
  
  public void onFollowPublicAccount(boolean paramBoolean, String paramString)
  {
    super.onFollowPublicAccount(paramBoolean, paramString);
    FollowTextView.a(this.a, true);
    if (paramBoolean)
    {
      if (!FollowTextView.a(this.a)) {
        FollowTextView.a(this.a, true, FollowTextView.a(this.a));
      }
      this.a.a(1);
      if (FollowTextView.a(this.a) != null)
      {
        if (FollowTextView.a(this.a) != null) {
          FollowTextView.a(this.a).a(true, FollowTextView.a(this.a));
        }
        SimpleEventBus.getInstance().dispatchEvent(new FollowUpdateEvent(1, FollowTextView.a(this.a).poster.id.get()));
      }
      return;
    }
    QQToast.a(this.a.getContext(), 2131690841, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.textview.FollowTextView.1
 * JD-Core Version:    0.7.0.1
 */