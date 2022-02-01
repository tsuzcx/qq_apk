package com.tencent.biz.common.offline;

import android.os.Handler;
import com.tencent.biz.common.offline.util.IOfflineDownloader;
import com.tencent.qphone.base.util.QLog;

class BidDownloader$4
  implements Runnable
{
  BidDownloader$4(BidDownloader paramBidDownloader) {}
  
  public void run()
  {
    int i = BidDownloader.jdField_a_of_type_ComTencentBizCommonOfflineUtilIOfflineDownloader.a(BidDownloader.jdField_a_of_type_AndroidContentContext, this.this$0.c);
    if (QLog.isColorLevel()) {
      QLog.i(BidDownloader.d, 2, "state = " + i);
    }
    if (i != 2) {
      this.this$0.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.common.offline.BidDownloader.4
 * JD-Core Version:    0.7.0.1
 */