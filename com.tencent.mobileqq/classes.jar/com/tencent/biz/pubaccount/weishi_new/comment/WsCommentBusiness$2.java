package com.tencent.biz.pubaccount.weishi_new.comment;

import NS_KING_INTERFACE.stGetFeedCommentListV2Rsp;
import UserGrowth.stQQGetFeedCommentListV2Rsp;
import UserGrowth.stSimpleMetaFeed;
import com.tencent.biz.pubaccount.weishi_new.net.IWeishiServiceListener;
import com.tencent.biz.pubaccount.weishi_new.net.WeishiTask;
import com.tencent.biz.pubaccount.weishi_new.report.WsBeaconReportPresenter;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

class WsCommentBusiness$2
  implements IWeishiServiceListener
{
  WsCommentBusiness$2(WsCommentBusiness paramWsCommentBusiness, long paramLong, stSimpleMetaFeed paramstSimpleMetaFeed, boolean paramBoolean) {}
  
  public void a(WeishiTask paramWeishiTask)
  {
    long l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
    Object localObject1 = WsCommentBusiness.a();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("评论列表请求耗时：");
    ((StringBuilder)localObject2).append(l);
    ((StringBuilder)localObject2).append("毫秒");
    WSLog.a((String)localObject1, ((StringBuilder)localObject2).toString());
    WsBeaconReportPresenter.a().a(l, paramWeishiTask.jdField_a_of_type_ComTencentBizPubaccountWeishi_newNetWeishiRequest, "", false);
    if (!paramWeishiTask.a()) {
      WsBeaconReportPresenter.a().a(l, paramWeishiTask.jdField_a_of_type_ComTencentBizPubaccountWeishi_newNetWeishiRequest, paramWeishiTask.jdField_a_of_type_Int, paramWeishiTask.jdField_a_of_type_JavaLangString);
    }
    WsCommentBusiness.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentBusiness, this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.id, true);
    localObject1 = null;
    if ((paramWeishiTask.jdField_a_of_type_JavaLangObject instanceof stQQGetFeedCommentListV2Rsp))
    {
      localObject1 = (stQQGetFeedCommentListV2Rsp)paramWeishiTask.jdField_a_of_type_JavaLangObject;
      localObject2 = ((stQQGetFeedCommentListV2Rsp)localObject1).rsp;
      if (localObject2 == null)
      {
        WSLog.d(WsCommentBusiness.a(), "stGetFeedCommentListRsp is null!");
        return;
      }
      Object localObject3 = ((stGetFeedCommentListV2Rsp)localObject2).comments;
      Object localObject4 = WsCommentBusiness.a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("-------------getCommentSize:");
      localStringBuilder.append(((stGetFeedCommentListV2Rsp)localObject2).comments.size());
      localStringBuilder.append(", attachInfo:");
      localStringBuilder.append(((stGetFeedCommentListV2Rsp)localObject2).attach_info);
      localStringBuilder.append("isFinish：");
      localStringBuilder.append(((stGetFeedCommentListV2Rsp)localObject2).is_finished);
      WSLog.d((String)localObject4, localStringBuilder.toString());
      if (this.jdField_a_of_type_Boolean)
      {
        localObject4 = (ArrayList)WsCommentBusiness.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentBusiness).get(this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.id);
        int i;
        if (localObject4 != null) {
          i = ((ArrayList)localObject4).size();
        } else {
          i = 0;
        }
        localObject1 = WsCommentBusiness.a((ArrayList)localObject3, ((stQQGetFeedCommentListV2Rsp)localObject1).comment_text, i);
        if (localObject4 != null)
        {
          ((ArrayList)localObject4).addAll((Collection)localObject1);
          WsCommentBusiness.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentBusiness).put(this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.id, localObject4);
        }
        else
        {
          WsCommentBusiness.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentBusiness).put(this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.id, localObject1);
        }
        localObject3 = WsCommentBusiness.a();
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("保存评论");
        ((StringBuilder)localObject4).append(((ArrayList)localObject1).size());
        ((StringBuilder)localObject4).append("条");
        WSLog.d((String)localObject3, ((StringBuilder)localObject4).toString());
      }
      else
      {
        localObject1 = WsCommentBusiness.a((ArrayList)localObject3, ((stQQGetFeedCommentListV2Rsp)localObject1).comment_text, 0);
        WsCommentBusiness.b(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentBusiness).put(this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.id, Integer.valueOf(((stGetFeedCommentListV2Rsp)localObject2).total_comment_num));
        WsCommentBusiness.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentBusiness).put(this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.id, localObject1);
        localObject3 = WsCommentBusiness.a();
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("保存评论");
        ((StringBuilder)localObject4).append(((ArrayList)localObject1).size());
        ((StringBuilder)localObject4).append("条");
        WSLog.d((String)localObject3, ((StringBuilder)localObject4).toString());
      }
      ((stGetFeedCommentListV2Rsp)localObject2).comments = ((ArrayList)localObject1);
      WsCommentBusiness.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentBusiness, this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.id, ((stGetFeedCommentListV2Rsp)localObject2).attach_info, ((stGetFeedCommentListV2Rsp)localObject2).is_finished, true);
      WSLog.d(WsCommentBusiness.a(), "获取评论 dispatch responseCommentEvent");
      localObject1 = localObject2;
    }
    else
    {
      WSLog.d(WsCommentBusiness.a(), "获取评论失败new！");
      WsBeaconReportPresenter.a().a(l, paramWeishiTask.jdField_a_of_type_ComTencentBizPubaccountWeishi_newNetWeishiRequest, -1, "数据无法解析或为空");
    }
    paramWeishiTask = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentBusiness.a(new Object[] { Integer.valueOf(9), Integer.valueOf(paramWeishiTask.b), paramWeishiTask.jdField_a_of_type_JavaLangString, localObject1, Integer.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentBusiness.hashCode()), Boolean.valueOf(this.jdField_a_of_type_Boolean), this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.id });
    StoryDispatcher.a().dispatch(paramWeishiTask);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.comment.WsCommentBusiness.2
 * JD-Core Version:    0.7.0.1
 */