package com.huawei.hms.support.api.opendevice;

import com.huawei.hms.api.HuaweiApiClient;
import com.huawei.hms.support.api.client.PendingResult;
import com.huawei.hms.support.api.entity.opendevice.OdidReq;
import com.huawei.hms.support.log.HMSLog;

public class HuaweiOpendeviceApiImpl
  implements HuaweiOpendeviceApi
{
  public PendingResult<OdidResult> getOdid(HuaweiApiClient paramHuaweiApiClient)
  {
    HMSLog.i("OpenIdentifierApiImpl", "Enter getOdid");
    return new HuaweiOpendeviceApiImpl.1(this, paramHuaweiApiClient, "opendevice.getodid", new OdidReq());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hms.support.api.opendevice.HuaweiOpendeviceApiImpl
 * JD-Core Version:    0.7.0.1
 */