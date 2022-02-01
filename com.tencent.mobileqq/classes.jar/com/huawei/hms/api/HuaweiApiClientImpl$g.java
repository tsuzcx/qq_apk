package com.huawei.hms.api;

import android.os.Handler;
import android.os.Looper;
import com.huawei.hms.support.api.ResolveResult;
import com.huawei.hms.support.api.client.ResultCallback;
import com.huawei.hms.support.api.entity.core.DisconnectResp;

class HuaweiApiClientImpl$g
  implements ResultCallback<ResolveResult<DisconnectResp>>
{
  private HuaweiApiClientImpl$g(HuaweiApiClientImpl paramHuaweiApiClientImpl) {}
  
  public void a(ResolveResult<DisconnectResp> paramResolveResult)
  {
    new Handler(Looper.getMainLooper()).post(new HuaweiApiClientImpl.g.a(this, paramResolveResult));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.api.HuaweiApiClientImpl.g
 * JD-Core Version:    0.7.0.1
 */