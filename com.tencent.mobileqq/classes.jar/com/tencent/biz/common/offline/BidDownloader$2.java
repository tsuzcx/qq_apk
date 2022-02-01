package com.tencent.biz.common.offline;

import com.tencent.biz.common.offline.util.IOfflineDownloader;
import java.util.HashMap;

class BidDownloader$2
  implements Runnable
{
  BidDownloader$2(BidDownloader paramBidDownloader) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("Accept-Encoding", "gzip");
    BidDownloader.jdField_a_of_type_ComTencentBizCommonOfflineUtilIOfflineDownloader.a(BidDownloader.jdField_a_of_type_AndroidContentContext, this.this$0.c, this.this$0.jdField_a_of_type_JavaLangString, this.this$0.b, this.this$0.jdField_a_of_type_ComTencentBizCommonOfflineAsyncBack, localHashMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.common.offline.BidDownloader.2
 * JD-Core Version:    0.7.0.1
 */