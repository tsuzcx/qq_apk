package com.huawei.hms.push.ups;

import com.huawei.hmf.tasks.OnCompleteListener;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.push.ups.entity.CodeResult;
import com.huawei.hms.push.ups.entity.UPSTurnCallBack;

final class UPSService$2
  implements OnCompleteListener<Void>
{
  UPSService$2(UPSTurnCallBack paramUPSTurnCallBack) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.push.ups.UPSService.2
 * JD-Core Version:    0.7.0.1
 */