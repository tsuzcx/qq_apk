package com.tencent.biz.pubaccount.weishi_new.comment;

import android.view.View;
import android.view.View.OnFocusChangeListener;

class WsCommentInputPopupWindow$5
  implements View.OnFocusChangeListener
{
  WsCommentInputPopupWindow$5(WsCommentInputPopupWindow paramWsCommentInputPopupWindow) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramView = this.a;
      paramView.onClick(WsCommentInputPopupWindow.a(paramView));
      return;
    }
    WsCommentInputPopupWindow.a(this.a, 0, 8);
    this.a.b(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.comment.WsCommentInputPopupWindow.5
 * JD-Core Version:    0.7.0.1
 */