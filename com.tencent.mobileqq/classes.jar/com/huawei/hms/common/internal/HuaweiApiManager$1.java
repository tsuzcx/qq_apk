package com.huawei.hms.common.internal;

import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.common.HuaweiApi;

class HuaweiApiManager$1
  implements Runnable
{
  HuaweiApiManager$1(HuaweiApiManager paramHuaweiApiManager, HuaweiApi paramHuaweiApi, TaskCompletionSource paramTaskCompletionSource) {}
  
  public void run()
  {
    HuaweiApiManager.access$000(this.this$0, this.val$api, this.val$completionSource);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.common.internal.HuaweiApiManager.1
 * JD-Core Version:    0.7.0.1
 */