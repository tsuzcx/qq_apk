package com.tencent.biz.pubaccount.weishi_new.comment;

import UserGrowth.stSimpleMetaFeed;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.subscribe.comment.OnCommentElementClickListener;

class WsCommentAdapter$1
  implements View.OnClickListener
{
  WsCommentAdapter$1(WsCommentAdapter paramWsCommentAdapter, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (WsCommentAdapter.a(this.b) != null)
    {
      String str = WsCommentAdapter.b(this.b);
      if (WsCommentAdapter.c(this.b) != null) {
        str = WsCommentAdapter.c(this.b).id;
      }
      WsCommentAdapter.a(this.b).a(paramView, 12, this.a, str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.comment.WsCommentAdapter.1
 * JD-Core Version:    0.7.0.1
 */