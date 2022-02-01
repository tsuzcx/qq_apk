package com.tencent.mobileqq.activity.qcircle;

import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudCommon.Entry;
import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import qqcircle.QQCircleSwitch.GetCircleTabBucketRsp;

class QCircleThirdTabConfig$2
  implements VSDispatchObserver.onVSRspCallBack<QQCircleSwitch.GetCircleTabBucketRsp>
{
  QCircleThirdTabConfig$2(QCircleThirdTabConfig paramQCircleThirdTabConfig, long paramLong, CountDownLatch paramCountDownLatch) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, QQCircleSwitch.GetCircleTabBucketRsp paramGetCircleTabBucketRsp)
  {
    long l = System.currentTimeMillis() - this.a;
    paramString = new StringBuilder();
    paramString.append("getQCircleTabBucketConfig traceId");
    paramString.append(paramBaseRequest.getTraceId());
    paramString.append(" retCode:");
    paramString.append(paramLong);
    paramString.append(" isSuccess:");
    paramString.append(paramBoolean);
    paramString.append(" timeCost:");
    paramString.append(l);
    QLog.d("QCircleThirdTabConfig", 1, paramString.toString());
    if ((paramLong == 0L) && (paramBoolean) && (paramGetCircleTabBucketRsp != null))
    {
      QCircleThirdTabConfig.a(paramGetCircleTabBucketRsp.sws.get());
      paramBoolean = paramGetCircleTabBucketRsp.isNewRegUid.get();
      int i = paramGetCircleTabBucketRsp.expId.get();
      paramBaseRequest = new StringBuilder();
      paramBaseRequest.append("isNewUin:");
      paramBaseRequest.append(paramBoolean);
      paramBaseRequest.append("expId:");
      paramBaseRequest.append(i);
      QLog.d("QCircleThirdTabConfig", 1, paramBaseRequest.toString());
      paramString = this.c;
      if (paramBoolean)
      {
        paramBaseRequest = new StringBuilder();
        paramBaseRequest.append("2_");
        paramBaseRequest.append(i);
        paramBaseRequest = paramBaseRequest.toString();
      }
      else
      {
        paramBaseRequest = "3";
      }
      QCircleThirdTabConfig.a(paramString, "EVENT_FETCH_QCIRCLE_THIRD_TAB_CONFIG", Arrays.asList(new FeedCloudCommon.Entry[] { QCircleThirdTabConfig.a(paramString, "ret_code", paramBaseRequest), QCircleThirdTabConfig.a(this.c, "time_cost", String.valueOf(l)) }));
    }
    else
    {
      QLog.d("QCircleThirdTabConfig", 1, "request filed notify kanDian");
      QCircleThirdTabConfig.a(this.c, true);
      paramBaseRequest = this.c;
      QCircleThirdTabConfig.a(paramBaseRequest, "EVENT_FETCH_QCIRCLE_THIRD_TAB_CONFIG", Arrays.asList(new FeedCloudCommon.Entry[] { QCircleThirdTabConfig.a(paramBaseRequest, "ret_code", "4"), QCircleThirdTabConfig.a(this.c, "time_cost", String.valueOf(l)) }));
    }
    this.b.countDown();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qcircle.QCircleThirdTabConfig.2
 * JD-Core Version:    0.7.0.1
 */