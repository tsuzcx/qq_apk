package com.tencent.biz.subscribe.widget.textview;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import com.tencent.biz.pubaccount.api.IPublicAccountObserver.OnCallback;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.subscribe.event.FollowUpdateEvent;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.widget.QQToast;

class FollowTextView$1
  extends IPublicAccountObserver.OnCallback
{
  FollowTextView$1(FollowTextView paramFollowTextView) {}
  
  public void onFollowPublicAccount(boolean paramBoolean, String paramString)
  {
    super.onFollowPublicAccount(paramBoolean, paramString);
    FollowTextView.a(this.a, true);
    if (paramBoolean)
    {
      if (!FollowTextView.a(this.a))
      {
        paramString = this.a;
        FollowTextView.a(paramString, true, FollowTextView.b(paramString));
      }
      this.a.a(1);
      if (FollowTextView.b(this.a) != null)
      {
        if (FollowTextView.c(this.a) != null) {
          FollowTextView.c(this.a).a(true, FollowTextView.b(this.a));
        }
        SimpleEventBus.getInstance().dispatchEvent(new FollowUpdateEvent(1, FollowTextView.b(this.a).poster.id.get()));
      }
    }
    else
    {
      QQToast.makeText(this.a.getContext(), 2131887691, 0).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.textview.FollowTextView.1
 * JD-Core Version:    0.7.0.1
 */