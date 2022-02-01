package com.tencent.biz.qqcircle.publish.viewmodel;

import circlesearch.CircleSearchExhibition.StMoreDataRsp;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.qphone.base.util.QLog;

class QCircleLabelViewModel$1
  implements VSDispatchObserver.onVSRspCallBack<CircleSearchExhibition.StMoreDataRsp>
{
  QCircleLabelViewModel$1(QCircleLabelViewModel paramQCircleLabelViewModel, boolean paramBoolean) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, CircleSearchExhibition.StMoreDataRsp paramStMoreDataRsp)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QCircleGetAssociateTagRequest onReceive isSuccess:");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(" retCode:");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(" errMsg:");
    localStringBuilder.append(paramString);
    QLog.i("[QcirclePublish]QCircleLabelViewModel", 1, localStringBuilder.toString());
    QCircleLabelViewModel.a(this.b, paramBaseRequest, this.a, paramBoolean, paramLong, paramString, paramStMoreDataRsp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.viewmodel.QCircleLabelViewModel.1
 * JD-Core Version:    0.7.0.1
 */