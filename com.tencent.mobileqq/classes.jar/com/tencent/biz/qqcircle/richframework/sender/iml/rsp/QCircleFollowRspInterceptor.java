package com.tencent.biz.qqcircle.richframework.sender.iml.rsp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.datacenter.convert.QFSUserFollowDataConverter;
import com.tencent.biz.qqcircle.datacenter.data.QFSUserFollowData;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.biz.qqcircle.requests.QCircleDoFollowRequest;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.event.QCircleFollowUpdateEvent;
import com.tencent.mobileqq.qcircle.api.event.QCircleFuelAnimationEvent;
import com.tencent.qcircle.application.QCircleApplication;
import com.tencent.richframework.sender.chain.BaseSenderChain;
import com.tencent.richframework.sender.interceptor.RspInterceptor;
import cooperation.qqcircle.helpers.QCircleFollowManager;
import cooperation.qqcircle.relation.QCircleRelationGroupManager;
import feedcloud.FeedCloudMeta.StUser;
import feedcloud.FeedCloudWrite.StDoFollowReq;
import feedcloud.FeedCloudWrite.StDoFollowRsp;

public class QCircleFollowRspInterceptor
  implements RspInterceptor<QCircleBaseRequest, BaseSenderChain>
{
  public static String a = "req_extra_key_new_follow_state";
  
  private void a(Context paramContext, String paramString, int paramInt)
  {
    if (paramContext == null) {
      return;
    }
    Intent localIntent = new Intent("action_update_web_user_follow_state");
    localIntent.putExtra("uin", paramString);
    localIntent.putExtra("followstate", paramInt);
    paramContext.sendBroadcast(localIntent);
  }
  
  public void a(boolean paramBoolean, long paramLong, String paramString, QCircleBaseRequest paramQCircleBaseRequest, Object paramObject, BaseSenderChain paramBaseSenderChain)
  {
    if (((paramObject instanceof FeedCloudWrite.StDoFollowRsp)) && ((paramQCircleBaseRequest instanceof QCircleDoFollowRequest)))
    {
      Object localObject = (FeedCloudWrite.StDoFollowRsp)paramObject;
      localObject = (QCircleDoFollowRequest)paramQCircleBaseRequest;
      int i = paramBaseSenderChain.b().getInt(a);
      boolean bool = false;
      if ((paramBoolean) && (paramLong == 0L))
      {
        SimpleEventBus.getInstance().dispatchEvent(new QCircleFuelAnimationEvent());
        localObject = ((QCircleDoFollowRequest)localObject).getReq().user;
        if (i == 1) {
          bool = true;
        }
        QCircleRelationGroupManager.instance().updateFollowFriendListToDB(((FeedCloudMeta.StUser)localObject).id.get(), ((FeedCloudMeta.StUser)localObject).nick.get(), bool);
        QFSUserFollowDataConverter.b(new QFSUserFollowData(((FeedCloudMeta.StUser)localObject).id.get(), i));
        QCircleFollowUpdateEvent localQCircleFollowUpdateEvent = new QCircleFollowUpdateEvent(i, ((FeedCloudMeta.StUser)localObject).id.get());
        if (paramBaseSenderChain.a() != null) {
          localQCircleFollowUpdateEvent.mHashCode = paramBaseSenderChain.a().hashCode();
        }
        SimpleEventBus.getInstance().dispatchEvent(localQCircleFollowUpdateEvent);
        QCircleFollowManager.getInstance().setUinFollowed(((FeedCloudMeta.StUser)localObject).id.get(), i);
        a(QCircleApplication.APP, ((FeedCloudMeta.StUser)localObject).id.get(), i);
      }
      else
      {
        int j = QCircleToast.c;
        if (QCirclePluginUtil.c(i)) {
          i = 2131895730;
        } else {
          i = 2131895939;
        }
        QCircleToast.a(j, i, 0);
      }
    }
    paramBaseSenderChain.a(paramBoolean, paramLong, paramString, paramQCircleBaseRequest, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.richframework.sender.iml.rsp.QCircleFollowRspInterceptor
 * JD-Core Version:    0.7.0.1
 */