package com.tencent.biz.pubaccount.weishi_new.comment;

import NS_KING_INTERFACE.stDeleteFeedCommentRsp;
import UserGrowth.stSimpleMetaComment;
import UserGrowth.stSimpleMetaReply;
import com.tencent.biz.pubaccount.weishi_new.net.IWeishiServiceListener;
import com.tencent.biz.pubaccount.weishi_new.net.WeishiTask;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tribe.async.dispatch.Dispatcher;

class WsCommentBusiness$6
  implements IWeishiServiceListener
{
  public void a(WeishiTask paramWeishiTask)
  {
    if ((paramWeishiTask.jdField_a_of_type_JavaLangObject instanceof stDeleteFeedCommentRsp))
    {
      Object localObject = (stDeleteFeedCommentRsp)paramWeishiTask.jdField_a_of_type_JavaLangObject;
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentBusiness;
      int i = paramWeishiTask.b;
      paramWeishiTask = paramWeishiTask.jdField_a_of_type_JavaLangString;
      String str = this.jdField_a_of_type_UserGrowthStSimpleMetaComment.id;
      stSimpleMetaReply localstSimpleMetaReply = this.jdField_a_of_type_UserGrowthStSimpleMetaReply;
      paramWeishiTask = ((WsCommentBusiness)localObject).a(new Object[] { Integer.valueOf(6), Integer.valueOf(i), paramWeishiTask, str, localstSimpleMetaReply, localstSimpleMetaReply.id, Integer.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentBusiness.hashCode()) });
      StoryDispatcher.a().dispatch(paramWeishiTask);
      return;
    }
    WSLog.d(WsCommentBusiness.a(), "删除回复失败new！");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.comment.WsCommentBusiness.6
 * JD-Core Version:    0.7.0.1
 */