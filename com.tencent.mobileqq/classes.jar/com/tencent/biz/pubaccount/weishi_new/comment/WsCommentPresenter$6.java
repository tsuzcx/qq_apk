package com.tencent.biz.pubaccount.weishi_new.comment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.weishi_new.event.WSCommentShowEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleEventBus;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;

class WsCommentPresenter$6
  implements View.OnClickListener
{
  WsCommentPresenter$6(WsCommentPresenter paramWsCommentPresenter) {}
  
  public void onClick(View paramView)
  {
    WSLog.a("comment", "onClick hide comment");
    this.a.k();
    WSSimpleEventBus.a().a(new WSCommentShowEvent(false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.comment.WsCommentPresenter.6
 * JD-Core Version:    0.7.0.1
 */