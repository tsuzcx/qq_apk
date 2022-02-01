package com.tencent.biz.pubaccount.weishi_new.comment;

import android.widget.PopupWindow.OnDismissListener;
import com.tencent.biz.pubaccount.weishi_new.event.WSCommentShowEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleEventBus;

class WsCommentPresenter$2
  implements PopupWindow.OnDismissListener
{
  WsCommentPresenter$2(WsCommentPresenter paramWsCommentPresenter) {}
  
  public void onDismiss()
  {
    this.a.k();
    WSSimpleEventBus.a().a(new WSCommentShowEvent(false));
    WsCommentPresenter.a(this.a, null);
    WsCommentPresenter.b(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.comment.WsCommentPresenter.2
 * JD-Core Version:    0.7.0.1
 */