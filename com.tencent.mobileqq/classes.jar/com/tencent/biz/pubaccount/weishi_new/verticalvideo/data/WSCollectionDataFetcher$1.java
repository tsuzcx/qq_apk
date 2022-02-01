package com.tencent.biz.pubaccount.weishi_new.verticalvideo.data;

import UserGrowth.stGetCollectionRsp;
import com.tencent.biz.pubaccount.weishi_new.data.IFetchDataRspListener;
import com.tencent.biz.pubaccount.weishi_new.net.RspHeaderBean;
import com.tencent.biz.pubaccount.weishi_new.net.common.ServiceCallback;
import com.tencent.biz.pubaccount.weishi_new.net.common.WSRequest;
import com.tencent.biz.pubaccount.weishi_new.net.common.WSServiceErrorInfo;

class WSCollectionDataFetcher$1
  extends ServiceCallback<stGetCollectionRsp, WSCollectionDataFetcher.ResponseModel>
{
  WSCollectionDataFetcher$1(WSCollectionDataFetcher paramWSCollectionDataFetcher, WSCollectionRequestParams paramWSCollectionRequestParams, IFetchDataRspListener paramIFetchDataRspListener) {}
  
  protected WSCollectionDataFetcher.ResponseModel a(WSRequest<stGetCollectionRsp> paramWSRequest, stGetCollectionRsp paramstGetCollectionRsp, RspHeaderBean paramRspHeaderBean)
  {
    return WSCollectionDataFetcher.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDataWSCollectionDataFetcher, paramstGetCollectionRsp, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDataWSCollectionRequestParams);
  }
  
  protected void a(WSServiceErrorInfo paramWSServiceErrorInfo) {}
  
  protected void a(WSCollectionDataFetcher.ResponseModel paramResponseModel)
  {
    super.a(paramResponseModel);
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDataIFetchDataRspListener != null)
    {
      int i = WSCollectionDataFetcher.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDataWSCollectionDataFetcher, paramResponseModel.jdField_a_of_type_Boolean, paramResponseModel.b);
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDataIFetchDataRspListener.a(paramResponseModel.jdField_a_of_type_JavaUtilList, false, paramResponseModel.jdField_a_of_type_Boolean, Integer.valueOf(i));
    }
  }
  
  protected void b(WSServiceErrorInfo paramWSServiceErrorInfo)
  {
    super.b(paramWSServiceErrorInfo);
    IFetchDataRspListener localIFetchDataRspListener = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDataIFetchDataRspListener;
    if (localIFetchDataRspListener != null) {
      localIFetchDataRspListener.a(paramWSServiceErrorInfo.a(), paramWSServiceErrorInfo.a(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDataWSCollectionRequestParams.jdField_a_of_type_Boolean, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDataWSCollectionRequestParams.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSCollectionDataFetcher.1
 * JD-Core Version:    0.7.0.1
 */