package com.tencent.biz.qqcircle.bizparts;

import android.text.TextUtils;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.utils.HardCodeUtil;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudRead.StGetBusiInfoRsp;

class QCircleGoHomeButtonPart$4
  implements VSDispatchObserver.onVSRspCallBack<FeedCloudRead.StGetBusiInfoRsp>
{
  QCircleGoHomeButtonPart$4(QCircleGoHomeButtonPart paramQCircleGoHomeButtonPart) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, FeedCloudRead.StGetBusiInfoRsp paramStGetBusiInfoRsp)
  {
    paramStGetBusiInfoRsp = new StringBuilder();
    paramStGetBusiInfoRsp.append("QCircleGoHomeButtonPart->onReceive: dispatch Success:");
    paramStGetBusiInfoRsp.append(paramBoolean);
    paramStGetBusiInfoRsp.append(" |CmdName:");
    paramStGetBusiInfoRsp.append(paramBaseRequest.getCmdName());
    paramStGetBusiInfoRsp.append(" | TraceId:");
    paramStGetBusiInfoRsp.append(paramBaseRequest.getTraceId());
    paramStGetBusiInfoRsp.append(" | SeqId:");
    paramStGetBusiInfoRsp.append(paramBaseRequest.getCurrentSeq());
    paramStGetBusiInfoRsp.append(" | retCode:");
    paramStGetBusiInfoRsp.append(paramLong);
    paramStGetBusiInfoRsp.append(" | retMessage:");
    paramStGetBusiInfoRsp.append(paramString);
    QLog.d("QCircleGoHomeButtonPart", 1, paramStGetBusiInfoRsp.toString());
    if ((paramBoolean) && (paramLong == 0L))
    {
      QCircleGoHomeButtonPart.d(this.a);
      return;
    }
    paramBaseRequest = paramString;
    if (TextUtils.isEmpty(paramString)) {
      paramBaseRequest = HardCodeUtil.a(2131892107);
    }
    QCircleToast.a(paramBaseRequest, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCircleGoHomeButtonPart.4
 * JD-Core Version:    0.7.0.1
 */