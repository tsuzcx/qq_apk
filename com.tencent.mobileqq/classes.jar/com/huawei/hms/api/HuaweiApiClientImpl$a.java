package com.huawei.hms.api;

import android.os.Handler;
import android.os.Looper;
import com.huawei.hms.support.api.ResolveResult;
import com.huawei.hms.support.api.client.ResultCallback;
import com.huawei.hms.support.api.entity.core.ConnectResp;

class HuaweiApiClientImpl$a
  implements ResultCallback<ResolveResult<ConnectResp>>
{
  private HuaweiApiClientImpl$a(HuaweiApiClientImpl paramHuaweiApiClientImpl) {}
  
  public void a(ResolveResult<ConnectResp> paramResolveResult)
  {
    new Handler(Looper.getMainLooper()).post(new HuaweiApiClientImpl.a.1(this, paramResolveResult));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hms.api.HuaweiApiClientImpl.a
 * JD-Core Version:    0.7.0.1
 */