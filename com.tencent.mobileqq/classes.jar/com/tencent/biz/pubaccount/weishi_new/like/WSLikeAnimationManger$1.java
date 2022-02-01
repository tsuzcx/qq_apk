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
    LikeRspEvent localLikeRspEvent = new LikeRspEvent(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
    if ((paramWeishiTask != null) && (paramWeishiTask.a != null))
    {
      if ((paramWeishiTask.a instanceof stPostFeedDingRsp))
      {
        paramWeishiTask = (stPostFeedDingRsp)paramWeishiTask.a;
        if (paramWeishiTask == null)
        {
          WSLog.a("WSLikeAnimationManger", "服务器失败！！！");
          WSLikeAnimationManger.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newLikeWSLikeAnimationManger, this.jdField_a_of_type_JavaLangString, localLikeRspEvent, this.jdField_a_of_type_Boolean ^ true);
        }
        else
        {
          int i = paramWeishiTask.is_ding;
          localLikeRspEvent.setRpsStatus(4301);
          localLikeRspEvent.setRspIsDing(i);
          if (i == 0) {
            WSLog.a("WSLikeAnimationManger", "请求后变成：没有点赞-by微视");
          } else {
            WSLog.a("WSLikeAnimationManger", "请求后变成：已经点赞-by微视");
          }
        }
      }
      else
      {
        WSLog.a("WSLikeAnimationManger", "点赞失败:-2");
        WSLikeAnimationManger.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newLikeWSLikeAnimationManger, this.jdField_a_of_type_JavaLangString, localLikeRspEvent, this.jdField_a_of_type_Boolean ^ true);
      }
    }
    else
    {
      WSLog.a("WSLikeAnimationManger", "点赞失败:-1");
      WSLikeAnimationManger.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newLikeWSLikeAnimationManger, this.jdField_a_of_type_JavaLangString, localLikeRspEvent, this.jdField_a_of_type_Boolean ^ true);
    }
    WSSimpleEventBus.a().a(localLikeRspEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.like.WSLikeAnimationManger.1
 * JD-Core Version:    0.7.0.1
 */