package com.tencent.biz.pubaccount.weishi_new.comment;

import android.text.Editable;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.guide.WSCommentAtHelper;
import com.tencent.biz.subscribe.comment.CommentEditText;
import com.tencent.mobileqq.data.Friends;
import java.util.List;

class WsCommentInputPopupWindow$7
  extends WSCommentTextChangedListener
{
  WsCommentInputPopupWindow$7(WsCommentInputPopupWindow paramWsCommentInputPopupWindow, CommentEditText paramCommentEditText)
  {
    super(paramCommentEditText);
  }
  
  void a()
  {
    if (WSCommentAtHelper.a.b()) {
      WsCommentInputPopupWindow.i(this.a);
    }
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    WsCommentInputPopupWindow.f(this.a).a();
    super.afterTextChanged(paramEditable);
  }
  
  List<Friends> b()
  {
    return WsCommentInputPopupWindow.j(this.a).a();
  }
  
  int c()
  {
    return WsCommentInputPopupWindow.j(this.a).c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.comment.WsCommentInputPopupWindow.7
 * JD-Core Version:    0.7.0.1
 */