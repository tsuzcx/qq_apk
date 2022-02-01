package com.tencent.biz.pubaccount.weishi_new.comment;

import UserGrowth.stPostCommentReplyV2Rsp;
import UserGrowth.stSimpleMetaReply;
import com.tencent.biz.pubaccount.weishi_new.net.IWeishiServiceListener;
import com.tencent.biz.pubaccount.weishi_new.net.WeishiTask;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tribe.async.dispatch.Dispatcher;

class WsCommentBusiness$5
  implements IWeishiServiceListener
{
  WsCommentBusiness$5(WsCommentBusiness paramWsCommentBusiness, stSimpleMetaReply paramstSimpleMetaReply) {}
  
  public void a(WeishiTask paramWeishiTask)
  {
    if ((paramWeishiTask.jdField_a_of_type_JavaLangObject instanceof stPostCommentReplyV2Rsp))
    {
      stPostCommentReplyV2Rsp localstPostCommentReplyV2Rsp = (stPostCommentReplyV2Rsp)paramWeishiTask.jdField_a_of_type_JavaLangObject;
      WsCommentBusiness localWsCommentBusiness = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentBusiness;
      int i = paramWeishiTask.b;
      paramWeishiTask = paramWeishiTask.jdField_a_of_type_JavaLangString;
      stSimpleMetaReply localstSimpleMetaReply = this.jdField_a_of_type_UserGrowthStSimpleMetaReply;
      paramWeishiTask = localWsCommentBusiness.a(new Object[] { Integer.valueOf(4), Integer.valueOf(i), paramWeishiTask, localstPostCommentReplyV2Rsp, localstSimpleMetaReply, localstSimpleMetaReply.id, Integer.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentBusiness.hashCode()) });
      StoryDispatcher.a().dispatch(paramWeishiTask);
      return;
    }
    WSLog.d(WsCommentBusiness.a(), "添加回复失败new！");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.comment.WsCommentBusiness.5
 * JD-Core Version:    0.7.0.1
 */