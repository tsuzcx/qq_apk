package com.tencent.biz.pubaccount.weishi_new.drama.cache;

import com.tencent.biz.pubaccount.weishi_new.data.IFetchDataRspListener;
import com.tencent.biz.pubaccount.weishi_new.drama.episode.WSDramaEpisodeEntity;
import java.util.List;

class WSDramaDataManager$2
  implements IFetchDataRspListener<String>
{
  WSDramaDataManager$2(WSDramaDataManager paramWSDramaDataManager, String paramString, IFetchDataRspListener paramIFetchDataRspListener) {}
  
  public void a(int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    IFetchDataRspListener localIFetchDataRspListener = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDataIFetchDataRspListener;
    if (localIFetchDataRspListener != null) {
      localIFetchDataRspListener.a(paramInt, paramString, paramBoolean1, paramBoolean2);
    }
  }
  
  public void a(List<String> paramList, boolean paramBoolean1, boolean paramBoolean2, Object paramObject)
  {
    WSDramaDataManager.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaCacheWSDramaDataManager).a(this.jdField_a_of_type_JavaLangString).addAll(paramList);
    paramList = WSDramaDataManager.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaCacheWSDramaDataManager).a(this.jdField_a_of_type_JavaLangString);
    paramObject = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDataIFetchDataRspListener;
    if (paramObject != null) {
      paramObject.a(paramList.a(), paramBoolean1, paramBoolean2, paramList.a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.drama.cache.WSDramaDataManager.2
 * JD-Core Version:    0.7.0.1
 */