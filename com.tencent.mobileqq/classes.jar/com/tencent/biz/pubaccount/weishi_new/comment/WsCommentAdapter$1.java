package com.tencent.biz.pubaccount.weishi_new.comment;

import UserGrowth.stSimpleMetaFeed;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.subscribe.comment.OnCommentElementClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class WsCommentAdapter$1
  implements View.OnClickListener
{
  WsCommentAdapter$1(WsCommentAdapter paramWsCommentAdapter, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (WsCommentAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentAdapter) != null)
    {
      String str = WsCommentAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentAdapter);
      if (WsCommentAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentAdapter) != null) {
        str = WsCommentAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentAdapter).id;
      }
      WsCommentAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentAdapter).a(paramView, 12, this.jdField_a_of_type_Int, str);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.comment.WsCommentAdapter.1
 * JD-Core Version:    0.7.0.1
 */