package com.tencent.biz.qqcircle.publish.viewmodel;

import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudTagcategorysvr.StTagCategoryRecomRsp;

class QCircleLabelViewModel$2
  implements VSDispatchObserver.onVSRspCallBack<FeedCloudTagcategorysvr.StTagCategoryRecomRsp>
{
  QCircleLabelViewModel$2(QCircleLabelViewModel paramQCircleLabelViewModel) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, FeedCloudTagcategorysvr.StTagCategoryRecomRsp paramStTagCategoryRecomRsp)
  {
    paramBaseRequest = new StringBuilder();
    paramBaseRequest.append("QCircleGetRecommendTagRequest onReceive isSuccess:");
    paramBaseRequest.append(paramBoolean);
    paramBaseRequest.append(" retCode:");
    paramBaseRequest.append(paramLong);
    paramBaseRequest.append(" errMsg:");
    paramBaseRequest.append(paramString);
    QLog.i("[QcirclePublish]QCircleLabelViewModel", 1, paramBaseRequest.toString());
    QCircleLabelViewModel.a(this.a, paramBoolean, paramLong, paramString, paramStTagCategoryRecomRsp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.viewmodel.QCircleLabelViewModel.2
 * JD-Core Version:    0.7.0.1
 */