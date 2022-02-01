package com.tencent.biz.pubaccount.weishi_new.comment;

import UserGrowth.stSimpleMetaComment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.biz.subscribe.comment.OnCommentElementClickListener;
import java.util.ArrayList;

class WsCommentView$1
  implements View.OnClickListener
{
  WsCommentView$1(WsCommentView paramWsCommentView) {}
  
  public void onClick(View paramView)
  {
    if ((WsCommentView.a(this.a) != null) && (WsCommentView.a(this.a).replyList.size() > 0))
    {
      WsCommentView.a(this.a).a(paramView, 10, WsCommentView.a(this.a), WsCommentView.a(this.a));
      this.a.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentView$MoreCommentHolder.b.setVisibility(8);
      this.a.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentView$MoreCommentHolder.a.setVisibility(8);
      this.a.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsReplyContainer.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.comment.WsCommentView.1
 * JD-Core Version:    0.7.0.1
 */