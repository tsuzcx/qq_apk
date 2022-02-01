package com.huawei.hms.api;

import android.os.Handler;
import android.os.Looper;
import com.huawei.hms.support.api.ResolveResult;
import com.huawei.hms.support.api.client.ResultCallback;
import com.huawei.hms.support.api.entity.core.DisconnectResp;

class HuaweiApiClientImpl$b
  implements ResultCallback<ResolveResult<DisconnectResp>>
{
  private HuaweiApiClientImpl$b(HuaweiApiClientImpl paramHuaweiApiClientImpl) {}
  
  public void a(ResolveResult<DisconnectResp> paramResolveResult)
  {
    new Handler(Looper.getMainLooper()).post(new HuaweiApiClientImpl.b.1(this, paramResolveResult));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hms.api.HuaweiApiClientImpl.b
 * JD-Core Version:    0.7.0.1
 */