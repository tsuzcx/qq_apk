package com.tencent.ad.tangram.preorder;

import android.content.Context;
import com.tencent.ad.tangram.log.AdLog;

class AdAppPreOrderManager$11
  implements Runnable
{
  AdAppPreOrderManager$11(AdAppPreOrderManager paramAdAppPreOrderManager, Context paramContext, String paramString) {}
  
  public void run()
  {
    AdAppPreOrderManager.access$300(this.this$0);
    AdLog.i("AdAppPreOrderManager", "init registerListeners finish");
    AdAppPreOrderManager.access$400(this.this$0).init(this.val$context, this.val$uin);
    try
    {
      AdAppPreOrderManager.access$502(this.this$0, 1);
      AdLog.i("AdAppPreOrderManager", "init status = STATUS_READY finish");
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.preorder.AdAppPreOrderManager.11
 * JD-Core Version:    0.7.0.1
 */