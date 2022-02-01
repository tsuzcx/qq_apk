package com.tencent.biz.pubaccount.weishi_new.like;

import NS_KING_INTERFACE.stPostFeedDingRsp;
import com.tencent.biz.pubaccount.weishi_new.event.LikeRspEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleEventBus;
import com.tencent.biz.pubaccount.weishi_new.net.IWeishiServiceListener;
import com.tencent.biz.pubaccount.weishi_new.net.WeishiTask;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;

class WSLikeAnimationManger$1
  implements IWeishiServiceListener
{
  WSLikeAnimationManger$1(WSLikeAnimationManger paramWSLikeAnimationManger, String paramString, int paramInt, boolean paramBoolean) {}
  
  public void a(WeishiTask paramWeishiTask)
  {
    int j = 0;
    int i = 0;
    LikeRspEvent localLikeRspEvent = new LikeRspEvent(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
    if ((paramWeishiTask == null) || (paramWeishiTask.a == null))
    {
      WSLog.a("WSLikeAnimationManger", "点赞失败:-1");
      paramWeishiTask = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newLikeWSLikeAnimationManger;
      str = this.jdField_a_of_type_JavaLangString;
      if (this.jdField_a_of_type_Boolean)
      {
        i = 0;
        WSLikeAnimationManger.a(paramWeishiTask, str, localLikeRspEvent, i);
      }
    }
    for (;;)
    {
      WSSimpleEventBus.a().a(localLikeRspEvent);
      return;
      i = 1;
      break;
      if (!(paramWeishiTask.a instanceof stPostFeedDingRsp)) {
        break label189;
      }
      paramWeishiTask = (stPostFeedDingRsp)paramWeishiTask.a;
      if (paramWeishiTask == null)
      {
        WSLog.a("WSLikeAnimationManger", "服务器失败！！！");
        paramWeishiTask = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newLikeWSLikeAnimationManger;
        str = this.jdField_a_of_type_JavaLangString;
        if (this.jdField_a_of_type_Boolean) {}
        for (;;)
        {
          WSLikeAnimationManger.a(paramWeishiTask, str, localLikeRspEvent, i);
          break;
          i = 1;
        }
      }
      i = paramWeishiTask.is_ding;
      localLikeRspEvent.setRpsStatus(4301);
      localLikeRspEvent.setRspIsDing(i);
      if (i == 0) {
        WSLog.a("WSLikeAnimationManger", "请求后变成：没有点赞-by微视");
      } else {
        WSLog.a("WSLikeAnimationManger", "请求后变成：已经点赞-by微视");
      }
    }
    label189:
    WSLog.a("WSLikeAnimationManger", "点赞失败:-2");
    paramWeishiTask = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newLikeWSLikeAnimationManger;
    String str = this.jdField_a_of_type_JavaLangString;
    if (this.jdField_a_of_type_Boolean) {}
    for (i = j;; i = 1)
    {
      WSLikeAnimationManger.a(paramWeishiTask, str, localLikeRspEvent, i);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.like.WSLikeAnimationManger.1
 * JD-Core Version:    0.7.0.1
 */