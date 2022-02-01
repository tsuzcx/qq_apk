package com.tencent.biz.pubaccount.weishi_new.comment;

import UserGrowth.stPostFeedCommentV2Rsp;
import UserGrowth.stSimpleMetaComment;
import com.tencent.biz.pubaccount.weishi_new.net.IWeishiServiceListener;
import com.tencent.biz.pubaccount.weishi_new.net.WeishiTask;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tribe.async.dispatch.Dispatcher;

class WsCommentBusiness$3
  implements IWeishiServiceListener
{
  WsCommentBusiness$3(WsCommentBusiness paramWsCommentBusiness, stSimpleMetaComment paramstSimpleMetaComment) {}
  
  public void a(WeishiTask paramWeishiTask)
  {
    if ((paramWeishiTask.jdField_a_of_type_JavaLangObject instanceof stPostFeedCommentV2Rsp))
    {
      stPostFeedCommentV2Rsp localstPostFeedCommentV2Rsp = (stPostFeedCommentV2Rsp)paramWeishiTask.jdField_a_of_type_JavaLangObject;
      stSimpleMetaComment localstSimpleMetaComment = localstPostFeedCommentV2Rsp.comment;
      WSLog.c(WsCommentBusiness.a(), "---CommentEvent, addFeedComment！");
      paramWeishiTask = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentBusiness.a(new Object[] { Integer.valueOf(3), Integer.valueOf(paramWeishiTask.b), paramWeishiTask.jdField_a_of_type_JavaLangString, localstPostFeedCommentV2Rsp, localstSimpleMetaComment.id, Integer.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentBusiness.hashCode()) });
      StoryDispatcher.a().dispatch(paramWeishiTask);
      WsCommentBusiness.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentBusiness).a(this.jdField_a_of_type_UserGrowthStSimpleMetaComment);
      return;
    }
    WSLog.d(WsCommentBusiness.a(), "添加评论失败new！");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.comment.WsCommentBusiness.3
 * JD-Core Version:    0.7.0.1
 */