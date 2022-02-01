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
    WSLog.a(WsCommentBusiness.a(), "评论列表请求耗时：" + l + "毫秒");
    WsBeaconReportPresenter.a().a(l, paramWeishiTask.jdField_a_of_type_ComTencentBizPubaccountWeishi_newNetWeishiRequest, "", false);
    if (!paramWeishiTask.a()) {
      WsBeaconReportPresenter.a().a(l, paramWeishiTask.jdField_a_of_type_ComTencentBizPubaccountWeishi_newNetWeishiRequest, paramWeishiTask.jdField_a_of_type_Int, paramWeishiTask.jdField_a_of_type_JavaLangString);
    }
    WsCommentBusiness.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentBusiness, this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.id, true);
    Object localObject = null;
    stGetFeedCommentListV2Rsp localstGetFeedCommentListV2Rsp;
    ArrayList localArrayList2;
    ArrayList localArrayList1;
    if ((paramWeishiTask.jdField_a_of_type_JavaLangObject instanceof stQQGetFeedCommentListV2Rsp))
    {
      localObject = (stQQGetFeedCommentListV2Rsp)paramWeishiTask.jdField_a_of_type_JavaLangObject;
      localstGetFeedCommentListV2Rsp = ((stQQGetFeedCommentListV2Rsp)localObject).rsp;
      if (localstGetFeedCommentListV2Rsp == null)
      {
        WSLog.d(WsCommentBusiness.a(), "stGetFeedCommentListRsp is null!");
        return;
      }
      localArrayList2 = localstGetFeedCommentListV2Rsp.comments;
      WSLog.d(WsCommentBusiness.a(), "-------------getCommentSize:" + localstGetFeedCommentListV2Rsp.comments.size() + ", attachInfo:" + localstGetFeedCommentListV2Rsp.attach_info + "isFinish：" + localstGetFeedCommentListV2Rsp.is_finished);
      if (this.jdField_a_of_type_Boolean)
      {
        localArrayList1 = (ArrayList)WsCommentBusiness.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentBusiness).get(this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.id);
        if (localArrayList1 == null) {
          break label607;
        }
      }
    }
    label326:
    label607:
    for (int i = localArrayList1.size();; i = 0)
    {
      localObject = WsCommentBusiness.a(localArrayList2, ((stQQGetFeedCommentListV2Rsp)localObject).comment_text, i);
      if (localArrayList1 != null)
      {
        localArrayList1.addAll((Collection)localObject);
        WsCommentBusiness.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentBusiness).put(this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.id, localArrayList1);
        WSLog.d(WsCommentBusiness.a(), "保存评论" + ((ArrayList)localObject).size() + "条");
        localstGetFeedCommentListV2Rsp.comments = ((ArrayList)localObject);
        WsCommentBusiness.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentBusiness, this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.id, localstGetFeedCommentListV2Rsp.attach_info, localstGetFeedCommentListV2Rsp.is_finished, true);
        WSLog.d(WsCommentBusiness.a(), "获取评论 dispatch responseCommentEvent");
        localObject = localstGetFeedCommentListV2Rsp;
      }
      for (;;)
      {
        paramWeishiTask = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentBusiness.a(new Object[] { Integer.valueOf(9), Integer.valueOf(paramWeishiTask.b), paramWeishiTask.jdField_a_of_type_JavaLangString, localObject, Integer.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentBusiness.hashCode()), Boolean.valueOf(this.jdField_a_of_type_Boolean), this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.id });
        StoryDispatcher.a().dispatch(paramWeishiTask);
        return;
        WsCommentBusiness.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentBusiness).put(this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.id, localObject);
        break;
        localObject = WsCommentBusiness.a(localArrayList2, ((stQQGetFeedCommentListV2Rsp)localObject).comment_text, 0);
        WsCommentBusiness.b(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentBusiness).put(this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.id, Integer.valueOf(localstGetFeedCommentListV2Rsp.total_comment_num));
        WsCommentBusiness.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentBusiness).put(this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.id, localObject);
        WSLog.d(WsCommentBusiness.a(), "保存评论" + ((ArrayList)localObject).size() + "条");
        break label326;
        WSLog.d(WsCommentBusiness.a(), "获取评论失败new！");
        WsBeaconReportPresenter.a().a(l, paramWeishiTask.jdField_a_of_type_ComTencentBizPubaccountWeishi_newNetWeishiRequest, -1, "数据无法解析或为空");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.comment.WsCommentBusiness.2
 * JD-Core Version:    0.7.0.1
 */