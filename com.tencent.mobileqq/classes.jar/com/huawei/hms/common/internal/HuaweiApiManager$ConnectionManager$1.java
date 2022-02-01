package com.huawei.hms.common.internal;

import android.text.TextUtils;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.hianalytics.b;
import com.huawei.hms.support.log.HMSLog;

class HuaweiApiManager$ConnectionManager$1
  implements AnyClient.CallBack
{
  HuaweiApiManager$ConnectionManager$1(HuaweiApiManager.ConnectionManager paramConnectionManager, TaskApiCallWrapper paramTaskApiCallWrapper) {}
  
  public void onCallback(IMessageEntity paramIMessageEntity, String paramString)
  {
    if (!(paramIMessageEntity instanceof ResponseHeader))
    {
      HMSLog.e("HuaweiApiManager", "header is not instance of ResponseHeader");
      return;
    }
    paramIMessageEntity = (ResponseHeader)paramIMessageEntity;
    if (!TextUtils.isEmpty(paramIMessageEntity.getResolution())) {
      HMSLog.e("HuaweiApiManager", "Response has resolution: " + paramIMessageEntity.getResolution());
    }
    b.a(HuaweiApiManager.ConnectionManager.a(this.b).getContext(), paramIMessageEntity, String.valueOf(HuaweiApiManager.ConnectionManager.a(this.b).getKitSdkVersion()));
    this.a.getTaskApiCall().onResponse(HuaweiApiManager.ConnectionManager.b(this.b), paramIMessageEntity, paramString, this.a.getTaskCompletionSource());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hms.common.internal.HuaweiApiManager.ConnectionManager.1
 * JD-Core Version:    0.7.0.1
 */