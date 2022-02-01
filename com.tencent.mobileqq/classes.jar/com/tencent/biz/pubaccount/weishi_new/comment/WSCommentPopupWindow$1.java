package com.tencent.biz.pubaccount.weishi_new.comment;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;

final class WSCommentPopupWindow$1
  implements View.OnKeyListener
{
  WSCommentPopupWindow$1(WSCommentPopupWindow paramWSCommentPopupWindow) {}
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      this.a.dismiss();
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.comment.WSCommentPopupWindow.1
 * JD-Core Version:    0.7.0.1
 */