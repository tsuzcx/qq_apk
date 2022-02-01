package com.huawei.hms.api;

import com.huawei.hms.core.aidl.ResponseHeader;
import com.huawei.hms.core.aidl.a;
import com.huawei.hms.core.aidl.b;
import com.huawei.hms.core.aidl.c.a;
import com.huawei.hms.core.aidl.e;
import com.huawei.hms.support.api.client.BundleResult;
import com.huawei.hms.support.api.client.ResultCallback;
import com.huawei.hms.support.log.HMSLog;

class HuaweiApiClientImpl$5
  extends c.a
{
  HuaweiApiClientImpl$5(HuaweiApiClientImpl paramHuaweiApiClientImpl, ResultCallback paramResultCallback) {}
  
  public void call(b paramb)
  {
    if (paramb != null)
    {
      e locale = a.a(paramb.c());
      ResponseHeader localResponseHeader = new ResponseHeader();
      locale.a(paramb.b, localResponseHeader);
      paramb = new BundleResult(localResponseHeader.getStatusCode(), paramb.a());
      HMSLog.i("HuaweiApiClientImpl", "Exit asyncRequest onResult");
      this.a.onResult(paramb);
      return;
    }
    HMSLog.i("HuaweiApiClientImpl", "Exit asyncRequest onResult -1");
    this.a.onResult(new BundleResult(-1, null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.api.HuaweiApiClientImpl.5
 * JD-Core Version:    0.7.0.1
 */