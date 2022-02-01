package com.tencent.biz.pubaccount.weishi_new.comment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.weishi_new.event.WSCommentShowEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleEventBus;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class WsCommentPresenter$5
  implements View.OnClickListener
{
  WsCommentPresenter$5(WsCommentPresenter paramWsCommentPresenter) {}
  
  public void onClick(View paramView)
  {
    WSLog.a("comment", "onClick hide comment");
    WsCommentPresenter.a(this.a);
    WSSimpleEventBus.a().a(new WSCommentShowEvent(false));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.comment.WsCommentPresenter.5
 * JD-Core Version:    0.7.0.1
 */