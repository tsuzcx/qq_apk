package com.tencent.ad.tangram.preorder;

import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.statistics.AdAnalysisHelperForUtil;

class AdAppPreOrderManager$10$1
  implements Runnable
{
  AdAppPreOrderManager$10$1(AdAppPreOrderManager.10 param10) {}
  
  public void run()
  {
    AdLog.i("AdAppPreOrderManager", "onForeground");
    if (AdAppPreOrderManager.access$100(this.this$1.this$0) != 0L) {
      AdAnalysisHelperForUtil.reportForAppPreOrderBackgroundTimeMillis(this.this$1.this$0.getContext(), System.currentTimeMillis() - AdAppPreOrderManager.access$100(this.this$1.this$0));
    }
    AdAppPreOrderManager.access$102(this.this$1.this$0, 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.preorder.AdAppPreOrderManager.10.1
 * JD-Core Version:    0.7.0.1
 */