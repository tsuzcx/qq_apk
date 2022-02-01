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
    BidDownloader.r.a(BidDownloader.v, this.this$0.m, this.this$0.b, this.this$0.k, this.this$0.l, localHashMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.common.offline.BidDownloader.2
 * JD-Core Version:    0.7.0.1
 */