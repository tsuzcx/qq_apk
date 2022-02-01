package com.tencent.biz.pubaccount.weishi_new.verticalvideo.utils;

import com.tencent.biz.pubaccount.weishi_new.data.IFetchDataRspListener;
import java.util.List;

final class WSVerticalTrendsCacheUtils$1
  implements Runnable
{
  WSVerticalTrendsCacheUtils$1(IFetchDataRspListener paramIFetchDataRspListener, List paramList) {}
  
  public void run()
  {
    IFetchDataRspListener localIFetchDataRspListener = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDataIFetchDataRspListener;
    if (localIFetchDataRspListener != null) {
      localIFetchDataRspListener.a(this.jdField_a_of_type_JavaUtilList, false, true, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.utils.WSVerticalTrendsCacheUtils.1
 * JD-Core Version:    0.7.0.1
 */