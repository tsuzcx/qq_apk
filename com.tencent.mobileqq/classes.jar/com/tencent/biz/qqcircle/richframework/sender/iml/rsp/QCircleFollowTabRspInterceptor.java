package com.tencent.biz.qqcircle.richframework.sender.iml.rsp;

import android.os.Bundle;
import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.qcircle.api.utils.EeveeRedpointUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.sender.chain.BaseSenderChain;
import com.tencent.richframework.sender.interceptor.RspInterceptor;
import feedcloud.FeedCloudRead.StGetFeedListRsp;
import qqcircle.QQCircleFeedBase.StFeedListBusiRspData;

public class QCircleFollowTabRspInterceptor
  implements RspInterceptor<QCircleBaseRequest, BaseSenderChain<QCircleBaseRequest>>
{
  public void a(boolean paramBoolean, long paramLong, String paramString, QCircleBaseRequest paramQCircleBaseRequest, Object paramObject, BaseSenderChain<QCircleBaseRequest> paramBaseSenderChain)
  {
    paramBaseSenderChain.a(paramBoolean, paramLong, paramString, paramQCircleBaseRequest, paramObject);
    paramString = paramBaseSenderChain.b();
    if ((paramObject instanceof FeedCloudRead.StGetFeedListRsp))
    {
      if (paramString == null) {
        return;
      }
      paramQCircleBaseRequest = (FeedCloudRead.StGetFeedListRsp)paramObject;
      paramBoolean = paramString.getBoolean("extra_key_is_load_more");
      if (paramString.getInt("extra_key_tab_type") == 1)
      {
        if (paramBoolean) {
          return;
        }
        int i = paramString.getInt("extra_key_pull_scene_type");
        if (paramQCircleBaseRequest.busiRspData.has()) {
          try
          {
            paramString = new QQCircleFeedBase.StFeedListBusiRspData();
            paramString.mergeFrom(paramQCircleBaseRequest.busiRspData.get().toByteArray());
            if (paramString.rspTimestamp.has())
            {
              if (i == 1)
              {
                EeveeRedpointUtil.saveFollowTabFeedListLastPreRspTimestamp(paramString.rspTimestamp.get());
                paramQCircleBaseRequest = new StringBuilder();
                paramQCircleBaseRequest.append("[requestFeedsData] preload response: ");
                paramQCircleBaseRequest.append(", followTabFeedListLastPreRspTimestamp: ");
                paramQCircleBaseRequest.append(paramString.rspTimestamp.get());
                paramQCircleBaseRequest.append(", followTabFeedListLastRspTimestamp: ");
                paramQCircleBaseRequest.append(EeveeRedpointUtil.getFollowTabFeedListLastRspTimestamp());
                QLog.d("QCircleEeveeRedPoint_QCircleFollowTabRspInterceptor", 1, new Object[] { paramQCircleBaseRequest });
                return;
              }
              EeveeRedpointUtil.saveFollowTabFeedListLastRspTimestamp(paramString.rspTimestamp.get());
              return;
            }
          }
          catch (InvalidProtocolBufferMicroException paramString)
          {
            paramString.printStackTrace();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.richframework.sender.iml.rsp.QCircleFollowTabRspInterceptor
 * JD-Core Version:    0.7.0.1
 */