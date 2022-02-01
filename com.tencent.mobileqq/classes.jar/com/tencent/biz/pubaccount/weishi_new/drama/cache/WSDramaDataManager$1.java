package com.tencent.biz.pubaccount.weishi_new.drama.cache;

import com.tencent.biz.pubaccount.weishi_new.data.IFetchDataRspListener;
import com.tencent.biz.pubaccount.weishi_new.drama.data.WSDramaItemData;
import java.util.List;

class WSDramaDataManager$1
  implements IFetchDataRspListener<WSDramaItemData>
{
  WSDramaDataManager$1(WSDramaDataManager paramWSDramaDataManager, IFetchDataRspListener paramIFetchDataRspListener) {}
  
  public void a(int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    IFetchDataRspListener localIFetchDataRspListener = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDataIFetchDataRspListener;
    if (localIFetchDataRspListener != null) {
      localIFetchDataRspListener.a(paramInt, paramString, paramBoolean1, paramBoolean2);
    }
  }
  
  public void a(List<WSDramaItemData> paramList, boolean paramBoolean1, boolean paramBoolean2, Object paramObject)
  {
    WSDramaDataManager.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaCacheWSDramaDataManager).a(paramList);
    IFetchDataRspListener localIFetchDataRspListener = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDataIFetchDataRspListener;
    if (localIFetchDataRspListener != null) {
      localIFetchDataRspListener.a(paramList, paramBoolean1, paramBoolean2, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.drama.cache.WSDramaDataManager.1
 * JD-Core Version:    0.7.0.1
 */