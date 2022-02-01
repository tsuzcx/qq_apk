package com.tencent.biz.pubaccount.weishi_new.comment;

import android.widget.PopupWindow.OnDismissListener;
import com.tencent.biz.pubaccount.weishi_new.event.WSCommentShowEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleEventBus;

class WsCommentPresenter$1
  implements PopupWindow.OnDismissListener
{
  WsCommentPresenter$1(WsCommentPresenter paramWsCommentPresenter) {}
  
  public void onDismiss()
  {
    WsCommentPresenter.a(this.a);
    WSSimpleEventBus.a().a(new WSCommentShowEvent(false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.comment.WsCommentPresenter.1
 * JD-Core Version:    0.7.0.1
 */