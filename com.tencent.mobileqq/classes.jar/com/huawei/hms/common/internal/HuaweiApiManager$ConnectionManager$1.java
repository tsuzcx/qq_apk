package com.huawei.hms.common.internal;

import android.text.TextUtils;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.hianalytics.b;
import com.huawei.hms.support.log.HMSLog;
import java.util.concurrent.atomic.AtomicBoolean;

class HuaweiApiManager$ConnectionManager$1
  implements AnyClient.CallBack
{
  private AtomicBoolean isFirstRsp = new AtomicBoolean(true);
  
  HuaweiApiManager$ConnectionManager$1(HuaweiApiManager.ConnectionManager paramConnectionManager, TaskApiCallWrapper paramTaskApiCallWrapper) {}
  
  public void onCallback(IMessageEntity paramIMessageEntity, String paramString)
  {
    if (!(paramIMessageEntity instanceof ResponseHeader))
    {
      HMSLog.e("HuaweiApiManager", "header is not instance of ResponseHeader");
      return;
    }
    paramIMessageEntity = (ResponseHeader)paramIMessageEntity;
    if (!TextUtils.isEmpty(paramIMessageEntity.getResolution()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Response has resolution: ");
      localStringBuilder.append(paramIMessageEntity.getResolution());
      HMSLog.e("HuaweiApiManager", localStringBuilder.toString());
    }
    if (this.isFirstRsp.compareAndSet(true, false)) {
      b.a(HuaweiApiManager.ConnectionManager.access$200(this.this$1).getContext(), paramIMessageEntity, String.valueOf(HuaweiApiManager.ConnectionManager.access$200(this.this$1).getKitSdkVersion()));
    }
    this.val$req.getTaskApiCall().onResponse(HuaweiApiManager.ConnectionManager.access$300(this.this$1), paramIMessageEntity, paramString, this.val$req.getTaskCompletionSource());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.common.internal.HuaweiApiManager.ConnectionManager.1
 * JD-Core Version:    0.7.0.1
 */