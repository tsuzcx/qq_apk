package com.tencent.biz.pubaccount.weishi_new.comment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class WsCommentInputPopupWindow$2
  implements View.OnClickListener
{
  WsCommentInputPopupWindow$2(WsCommentInputPopupWindow paramWsCommentInputPopupWindow) {}
  
  public void onClick(View paramView)
  {
    this.a.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.comment.WsCommentInputPopupWindow.2
 * JD-Core Version:    0.7.0.1
 */