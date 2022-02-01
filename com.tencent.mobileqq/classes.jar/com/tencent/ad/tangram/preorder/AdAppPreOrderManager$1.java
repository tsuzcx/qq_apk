package com.tencent.ad.tangram.preorder;

import com.tencent.ad.tangram.account.AdAccountListener;
import com.tencent.ad.tangram.log.AdLog;

class AdAppPreOrderManager$1
  implements AdAccountListener
{
  AdAppPreOrderManager$1(AdAppPreOrderManager paramAdAppPreOrderManager) {}
  
  public void onAccountStatusChanged(String paramString1, String paramString2)
  {
    AdLog.i("AdAppPreOrderManager", "onAccountStatusChanged:" + paramString1);
    this.this$0.stopTasks(paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.preorder.AdAppPreOrderManager.1
 * JD-Core Version:    0.7.0.1
 */