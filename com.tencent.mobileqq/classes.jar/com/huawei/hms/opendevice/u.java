package com.huawei.hms.opendevice;

import com.huawei.hms.core.aidl.AbstractMessageEntity;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.api.PendingResultImpl;
import com.huawei.hms.support.api.client.ApiClient;
import com.huawei.hms.support.api.client.Result;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.opendevice.OdidResp;
import com.huawei.hms.support.api.opendevice.HuaweiOpendeviceApiImpl;
import com.huawei.hms.support.api.opendevice.OdidResult;
import com.huawei.hms.support.log.HMSLog;

public class u
  extends PendingResultImpl<OdidResult, OdidResp>
{
  public u(HuaweiOpendeviceApiImpl paramHuaweiOpendeviceApiImpl, ApiClient paramApiClient, String paramString, IMessageEntity paramIMessageEntity)
  {
    super(paramApiClient, paramString, paramIMessageEntity);
  }
  
  public OdidResult a(OdidResp paramOdidResp)
  {
    if (paramOdidResp == null)
    {
      HMSLog.e("OpenIdentifierApiImpl", "getOdid OaidResp is null");
      return null;
    }
    Status localStatus = paramOdidResp.getCommonStatus();
    if (localStatus == null)
    {
      HMSLog.e("OpenIdentifierApiImpl", "getOdid commonStatus is null");
      return null;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getOdid onComplete:");
    ((StringBuilder)localObject).append(localStatus.getStatusCode());
    HMSLog.i("OpenIdentifierApiImpl", ((StringBuilder)localObject).toString());
    localObject = new OdidResult();
    ((Result)localObject).setStatus(localStatus);
    ((OdidResult)localObject).setId(paramOdidResp.getId());
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.opendevice.u
 * JD-Core Version:    0.7.0.1
 */