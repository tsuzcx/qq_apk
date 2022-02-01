package com.tencent.ad.tangram.preorder;

import android.os.Bundle;
import java.lang.ref.WeakReference;

class AdAppPreOrderManager$6
  implements Runnable
{
  AdAppPreOrderManager$6(AdAppPreOrderManager paramAdAppPreOrderManager, String paramString1, WeakReference paramWeakReference, String paramString2, Bundle paramBundle, String paramString3, boolean paramBoolean) {}
  
  public void run()
  {
    AdAppPreOrderTask localAdAppPreOrderTask = AdAppPreOrderManager.access$1500(this.this$0, this.val$taskId);
    c.onClicked(this.val$activity, localAdAppPreOrderTask, this.val$reminderId, this.val$extrasForIntent, this.val$url, new WeakReference(AdAppPreOrderManager.access$1600(this.this$0)), this.val$ready);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.preorder.AdAppPreOrderManager.6
 * JD-Core Version:    0.7.0.1
 */