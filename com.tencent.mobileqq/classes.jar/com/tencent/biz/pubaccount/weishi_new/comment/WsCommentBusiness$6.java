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
      stDeleteFeedCommentRsp localstDeleteFeedCommentRsp = (stDeleteFeedCommentRsp)paramWeishiTask.jdField_a_of_type_JavaLangObject;
      paramWeishiTask = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentBusiness.a(new Object[] { Integer.valueOf(6), Integer.valueOf(paramWeishiTask.b), paramWeishiTask.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_UserGrowthStSimpleMetaComment.id, this.jdField_a_of_type_UserGrowthStSimpleMetaReply, this.jdField_a_of_type_UserGrowthStSimpleMetaReply.id, Integer.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentBusiness.hashCode()) });
      StoryDispatcher.a().dispatch(paramWeishiTask);
      return;
    }
    WSLog.d(WsCommentBusiness.a(), "删除回复失败new！");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.comment.WsCommentBusiness.6
 * JD-Core Version:    0.7.0.1
 */