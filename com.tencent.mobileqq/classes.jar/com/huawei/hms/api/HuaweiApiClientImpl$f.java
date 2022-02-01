package com.huawei.hms.api;

import android.os.Handler;
import android.os.Looper;
import com.huawei.hms.support.api.ResolveResult;
import com.huawei.hms.support.api.client.ResultCallback;
import com.huawei.hms.support.api.entity.core.ConnectResp;

class HuaweiApiClientImpl$f
  implements ResultCallback<ResolveResult<ConnectResp>>
{
  private HuaweiApiClientImpl$f(HuaweiApiClientImpl paramHuaweiApiClientImpl) {}
  
  public void a(ResolveResult<ConnectResp> paramResolveResult)
  {
    new Handler(Looper.getMainLooper()).post(new HuaweiApiClientImpl.f.a(this, paramResolveResult));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.api.HuaweiApiClientImpl.f
 * JD-Core Version:    0.7.0.1
 */