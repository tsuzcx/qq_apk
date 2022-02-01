package com.tencent.biz.subscribe.widget.textview;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import com.tencent.biz.pubaccount.api.IPublicAccountObserver.OnCallback;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.subscribe.event.FollowUpdateEvent;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.widget.QQToast;

class FollowTextView$2
  extends IPublicAccountObserver.OnCallback
{
  FollowTextView$2(FollowTextView paramFollowTextView) {}
  
  public void onUnfollowPublicAccount(boolean paramBoolean, String paramString)
  {
    super.onUnfollowPublicAccount(paramBoolean, paramString);
    FollowTextView.a(this.a, true);
    if (paramBoolean)
    {
      if (!FollowTextView.a(this.a))
      {
        paramString = this.a;
        FollowTextView.a(paramString, false, FollowTextView.a(paramString));
      }
      this.a.a(0);
      if (FollowTextView.a(this.a) != null)
      {
        if (FollowTextView.a(this.a) != null) {
          FollowTextView.a(this.a).a(false, FollowTextView.a(this.a));
        }
        SimpleEventBus.getInstance().dispatchEvent(new FollowUpdateEvent(0, FollowTextView.a(this.a).poster.id.get()));
      }
    }
    else
    {
      QQToast.a(this.a.getContext(), 2131690778, 0).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.textview.FollowTextView.2
 * JD-Core Version:    0.7.0.1
 */