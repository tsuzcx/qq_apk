package com.tencent.mobileqq.auto.engine.loader.net;

import com.tencent.biz.qcircleshadow.remotecheck.QCircleGetRainBowRequest;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import qqcircle.QQCircleConfig.GetRainbowTableConfigRsp;

class ASNetInfoManger$1
  implements VSDispatchObserver.onVSRspCallBack<QQCircleConfig.GetRainbowTableConfigRsp>
{
  ASNetInfoManger$1(ASNetInfoManger paramASNetInfoManger, QCircleGetRainBowRequest paramQCircleGetRainBowRequest, String paramString) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, QQCircleConfig.GetRainbowTableConfigRsp paramGetRainbowTableConfigRsp)
  {
    paramBaseRequest = new StringBuilder();
    paramBaseRequest.append("getRainbow rsp traceId:");
    paramBaseRequest.append(this.a.getTraceId());
    paramBaseRequest.append(" retcode:");
    paramBaseRequest.append(paramLong);
    QLog.i("ASNetInfoManger", 1, paramBaseRequest.toString());
    ThreadManagerV2.executeOnFileThread(new ASNetInfoManger.1.1(this, paramBoolean, paramGetRainbowTableConfigRsp, paramLong));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.auto.engine.loader.net.ASNetInfoManger.1
 * JD-Core Version:    0.7.0.1
 */