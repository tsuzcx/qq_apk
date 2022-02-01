package com.tencent.biz.subscribe.comment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SubscribeCommentInputPopupWindow$2
  implements View.OnClickListener
{
  SubscribeCommentInputPopupWindow$2(SubscribeCommentInputPopupWindow paramSubscribeCommentInputPopupWindow) {}
  
  public void onClick(View paramView)
  {
    this.a.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.comment.SubscribeCommentInputPopupWindow.2
 * JD-Core Version:    0.7.0.1
 */