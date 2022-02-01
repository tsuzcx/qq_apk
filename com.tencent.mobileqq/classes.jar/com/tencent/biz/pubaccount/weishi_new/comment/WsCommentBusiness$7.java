package com.tencent.biz.pubaccount.weishi_new.comment;

import NS_KING_INTERFACE.stPostCommentDingRsp;
import UserGrowth.stSimpleMetaComment;
import com.tencent.biz.pubaccount.weishi_new.net.IWeishiServiceListener;
import com.tencent.biz.pubaccount.weishi_new.net.WeishiTask;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tribe.async.dispatch.Dispatcher;

class WsCommentBusiness$7
  implements IWeishiServiceListener
{
  WsCommentBusiness$7(WsCommentBusiness paramWsCommentBusiness, stSimpleMetaComment paramstSimpleMetaComment) {}
  
  public void a(WeishiTask paramWeishiTask)
  {
    if ((paramWeishiTask.jdField_a_of_type_JavaLangObject instanceof stPostCommentDingRsp))
    {
      stPostCommentDingRsp localstPostCommentDingRsp = (stPostCommentDingRsp)paramWeishiTask.jdField_a_of_type_JavaLangObject;
      if (this.jdField_a_of_type_UserGrowthStSimpleMetaComment.isDing == 1) {
        WSLog.d(WsCommentBusiness.a(), "点赞成功,nothing is " + localstPostCommentDingRsp.nothing);
      }
      for (;;)
      {
        StoryDispatcher.a().dispatch(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentBusiness.a(new Object[] { Integer.valueOf(7), Integer.valueOf(paramWeishiTask.b), paramWeishiTask.jdField_a_of_type_JavaLangString, localstPostCommentDingRsp }));
        return;
        WSLog.d(WsCommentBusiness.a(), "取消点赞成功,nothing is " + localstPostCommentDingRsp.nothing);
      }
    }
    WSLog.d(WsCommentBusiness.a(), "评论点赞失败new！");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.comment.WsCommentBusiness.7
 * JD-Core Version:    0.7.0.1
 */