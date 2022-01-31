package com.tencent.biz.pubaccount.readinjoy.preload;

import com.tencent.qphone.base.util.QLog;
import ota;
import pcs;

public class FeedsPreloadManager$2
  implements Runnable
{
  public FeedsPreloadManager$2(pcs parampcs) {}
  
  public void run()
  {
    QLog.d("FeedsPreloadManager", 1, "add foreground, background callback.");
    ota.a(pcs.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.preload.FeedsPreloadManager.2
 * JD-Core Version:    0.7.0.1
 */