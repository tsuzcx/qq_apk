package com.tencent.biz.pubaccount.weishi_new.verticalvideo.data;

import UserGrowth.stSimpleGetFeedListRsp;
import com.tencent.biz.pubaccount.weishi_new.data.IFetchDataRspListener;
import com.tencent.biz.pubaccount.weishi_new.net.RspHeaderBean;
import com.tencent.biz.pubaccount.weishi_new.net.common.ServiceCallback;
import com.tencent.biz.pubaccount.weishi_new.net.common.WSRequest;
import com.tencent.biz.pubaccount.weishi_new.net.common.WSServiceErrorInfo;

class WSVerticalDataManager$1
  extends ServiceCallback<stSimpleGetFeedListRsp, WSVerticalDataManager.ResponseModel>
{
  WSVerticalDataManager$1(WSVerticalDataManager paramWSVerticalDataManager, boolean paramBoolean1, IFetchDataRspListener paramIFetchDataRspListener, boolean paramBoolean2, Object paramObject, long paramLong) {}
  
  protected WSVerticalDataManager.ResponseModel a(WSRequest<stSimpleGetFeedListRsp> paramWSRequest, stSimpleGetFeedListRsp paramstSimpleGetFeedListRsp, RspHeaderBean paramRspHeaderBean)
  {
    return WSVerticalDataManager.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDataWSVerticalDataManager, paramWSRequest, paramstSimpleGetFeedListRsp, paramRspHeaderBean, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDataIFetchDataRspListener, this.b, this.jdField_a_of_type_JavaLangObject, this.jdField_a_of_type_Long);
  }
  
  protected void a(WSServiceErrorInfo paramWSServiceErrorInfo) {}
  
  protected void a(WSVerticalDataManager.ResponseModel paramResponseModel)
  {
    super.a(paramResponseModel);
    WSVerticalDataManager.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDataWSVerticalDataManager, paramResponseModel, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDataIFetchDataRspListener);
  }
  
  protected void b(WSServiceErrorInfo paramWSServiceErrorInfo)
  {
    super.b(paramWSServiceErrorInfo);
    WSVerticalDataManager.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDataWSVerticalDataManager, this.jdField_a_of_type_Boolean, this.b, paramWSServiceErrorInfo, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDataIFetchDataRspListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalDataManager.1
 * JD-Core Version:    0.7.0.1
 */