package com.tencent.biz.pubaccount.weishi_new.drama.history;

import com.tencent.biz.pubaccount.weishi_new.data.FetcherParams;
import com.tencent.biz.pubaccount.weishi_new.data.IFetchDataRspListener;
import java.util.List;

class WSDramaHistoryPresenter$1
  implements IFetchDataRspListener<WSDramaHistoryData>
{
  WSDramaHistoryPresenter$1(WSDramaHistoryPresenter paramWSDramaHistoryPresenter, FetcherParams paramFetcherParams) {}
  
  public void a(int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (WSDramaHistoryPresenter.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaHistoryWSDramaHistoryPresenter) != null) {
      WSDramaHistoryPresenter.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaHistoryWSDramaHistoryPresenter).a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDataFetcherParams.a(), paramInt, paramString);
    }
  }
  
  public void a(List<WSDramaHistoryData> paramList, boolean paramBoolean1, boolean paramBoolean2, Object paramObject)
  {
    if ((paramObject instanceof Boolean)) {
      WSDramaHistoryPresenter.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaHistoryWSDramaHistoryPresenter, ((Boolean)paramObject).booleanValue());
    }
    if (WSDramaHistoryPresenter.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaHistoryWSDramaHistoryPresenter) != null)
    {
      paramObject = WSDramaHistoryPresenter.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaHistoryWSDramaHistoryPresenter);
      if (!this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDataFetcherParams.a()) {
        paramList = WSDramaHistoryPresenter.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaHistoryWSDramaHistoryPresenter, paramList);
      }
      paramObject.a(paramList, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDataFetcherParams.a(), WSDramaHistoryPresenter.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaHistoryWSDramaHistoryPresenter));
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDataFetcherParams.a()) && (WSDramaHistoryPresenter.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaHistoryWSDramaHistoryPresenter) != null))
    {
      if (WSDramaHistoryPresenter.b(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaHistoryWSDramaHistoryPresenter))
      {
        paramList = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaHistoryWSDramaHistoryPresenter;
        WSDramaHistoryPresenter.a(paramList, WSDramaHistoryPresenter.a(paramList).a);
        return;
      }
      paramList = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaHistoryWSDramaHistoryPresenter;
      WSDramaHistoryPresenter.b(paramList, WSDramaHistoryPresenter.a(paramList).a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.drama.history.WSDramaHistoryPresenter.1
 * JD-Core Version:    0.7.0.1
 */