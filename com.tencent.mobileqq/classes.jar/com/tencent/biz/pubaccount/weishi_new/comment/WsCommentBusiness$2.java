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
    long l = System.currentTimeMillis() - this.a;
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("评论列表请求耗时：");
    ((StringBuilder)localObject1).append(l);
    ((StringBuilder)localObject1).append("毫秒");
    WSLog.a("WsCommentBusiness", ((StringBuilder)localObject1).toString());
    WsBeaconReportPresenter.a().a(l, paramWeishiTask.g, "", false);
    if (!paramWeishiTask.b()) {
      WsBeaconReportPresenter.a().a(l, paramWeishiTask.g, paramWeishiTask.d, paramWeishiTask.c);
    }
    WsCommentBusiness.a(this.d, this.b.id, true);
    localObject1 = null;
    if ((paramWeishiTask.m instanceof stQQGetFeedCommentListV2Rsp))
    {
      localObject1 = (stQQGetFeedCommentListV2Rsp)paramWeishiTask.m;
      stGetFeedCommentListV2Rsp localstGetFeedCommentListV2Rsp = ((stQQGetFeedCommentListV2Rsp)localObject1).rsp;
      if (localstGetFeedCommentListV2Rsp == null)
      {
        WSLog.d("WsCommentBusiness", "stGetFeedCommentListRsp is null!");
        return;
      }
      Object localObject2 = localstGetFeedCommentListV2Rsp.comments;
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("-------------getCommentSize:");
      ((StringBuilder)localObject3).append(localstGetFeedCommentListV2Rsp.comments.size());
      ((StringBuilder)localObject3).append(", attachInfo:");
      ((StringBuilder)localObject3).append(localstGetFeedCommentListV2Rsp.attach_info);
      ((StringBuilder)localObject3).append("isFinish：");
      ((StringBuilder)localObject3).append(localstGetFeedCommentListV2Rsp.is_finished);
      WSLog.d("WsCommentBusiness", ((StringBuilder)localObject3).toString());
      if (this.c)
      {
        localObject3 = (ArrayList)WsCommentBusiness.b(this.d).get(this.b.id);
        int i;
        if (localObject3 != null) {
          i = ((ArrayList)localObject3).size();
        } else {
          i = 0;
        }
        localObject1 = WsCommentBusiness.a((ArrayList)localObject2, ((stQQGetFeedCommentListV2Rsp)localObject1).comment_text, i);
        if (localObject3 != null)
        {
          ((ArrayList)localObject3).addAll((Collection)localObject1);
          WsCommentBusiness.b(this.d).put(this.b.id, localObject3);
        }
        else
        {
          WsCommentBusiness.b(this.d).put(this.b.id, localObject1);
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("保存评论");
        ((StringBuilder)localObject2).append(((ArrayList)localObject1).size());
        ((StringBuilder)localObject2).append("条");
        WSLog.d("WsCommentBusiness", ((StringBuilder)localObject2).toString());
      }
      else
      {
        localObject1 = WsCommentBusiness.a((ArrayList)localObject2, ((stQQGetFeedCommentListV2Rsp)localObject1).comment_text, 0);
        WsCommentBusiness.c(this.d).put(this.b.id, Integer.valueOf(localstGetFeedCommentListV2Rsp.total_comment_num));
        WsCommentBusiness.b(this.d).put(this.b.id, localObject1);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("保存评论");
        ((StringBuilder)localObject2).append(((ArrayList)localObject1).size());
        ((StringBuilder)localObject2).append("条");
        WSLog.d("WsCommentBusiness", ((StringBuilder)localObject2).toString());
      }
      localstGetFeedCommentListV2Rsp.comments = ((ArrayList)localObject1);
      WsCommentBusiness.a(this.d, this.b.id, localstGetFeedCommentListV2Rsp.attach_info, localstGetFeedCommentListV2Rsp.is_finished, true);
      WSLog.d("WsCommentBusiness", "获取评论 dispatch responseCommentEvent");
      localObject1 = localstGetFeedCommentListV2Rsp;
    }
    else
    {
      WSLog.d("WsCommentBusiness", "获取评论失败new！");
      WsBeaconReportPresenter.a().a(l, paramWeishiTask.g, -1, "数据无法解析或为空");
    }
    paramWeishiTask = this.d.a(new Object[] { Integer.valueOf(9), Integer.valueOf(paramWeishiTask.e), paramWeishiTask.c, localObject1, Integer.valueOf(this.d.hashCode()), Boolean.valueOf(this.c), this.b.id });
    StoryDispatcher.a().dispatch(paramWeishiTask);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.comment.WsCommentBusiness.2
 * JD-Core Version:    0.7.0.1
 */