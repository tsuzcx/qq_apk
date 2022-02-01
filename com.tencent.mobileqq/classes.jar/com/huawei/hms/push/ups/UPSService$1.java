package com.huawei.hms.push.ups;

import com.huawei.hmf.tasks.OnCompleteListener;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.push.ups.entity.CodeResult;
import com.huawei.hms.push.ups.entity.ICallbackResult;
import com.huawei.hms.push.ups.entity.UPSTurnCallBack;

public final class UPSService$1
  implements OnCompleteListener<Void>
{
  public UPSService$1(UPSTurnCallBack paramUPSTurnCallBack) {}
  
  public void onComplete(Task<Void> paramTask)
  {
    if (paramTask.isSuccessful())
    {
      this.a.onResult(new CodeResult());
      return;
    }
    paramTask = (ApiException)paramTask.getException();
    this.a.onResult(new CodeResult(paramTask.getStatusCode(), paramTask.getMessage()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.push.ups.UPSService.1
 * JD-Core Version:    0.7.0.1
 */