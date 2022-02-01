package com.tencent.biz.pubaccount.weishi_new.comment;

import NS_KING_INTERFACE.stPostCommentDingRsp;
import com.tencent.biz.pubaccount.weishi_new.net.IWeishiServiceListener;
import com.tencent.biz.pubaccount.weishi_new.net.WeishiTask;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tribe.async.dispatch.Dispatcher;

class WsCommentBusiness$9
  implements IWeishiServiceListener
{
  WsCommentBusiness$9(WsCommentBusiness paramWsCommentBusiness) {}
  
  public void a(WeishiTask paramWeishiTask)
  {
    if ((paramWeishiTask.jdField_a_of_type_JavaLangObject instanceof stPostCommentDingRsp))
    {
      stPostCommentDingRsp localstPostCommentDingRsp = (stPostCommentDingRsp)paramWeishiTask.jdField_a_of_type_JavaLangObject;
      WSLog.d(WsCommentBusiness.a(), "回复点赞/取消成功,nothing is " + localstPostCommentDingRsp.nothing);
      StoryDispatcher.a().dispatch(this.a.a(new Object[] { Integer.valueOf(7), Integer.valueOf(paramWeishiTask.b), paramWeishiTask.jdField_a_of_type_JavaLangString, localstPostCommentDingRsp }));
      return;
    }
    WSLog.d(WsCommentBusiness.a(), "回复点赞失败new！");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.comment.WsCommentBusiness.9
 * JD-Core Version:    0.7.0.1
 */