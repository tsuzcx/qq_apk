package com.huawei.hms.push.ups;

import android.content.Context;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.aaid.HmsInstanceId;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.push.HmsMessaging;
import com.huawei.hms.push.s;
import com.huawei.hms.push.ups.entity.ICallbackResult;
import com.huawei.hms.push.ups.entity.TokenResult;
import com.huawei.hms.push.ups.entity.UPSRegisterCallBack;
import com.huawei.hms.push.ups.entity.UPSTurnCallBack;
import com.huawei.hms.push.ups.entity.UPSUnRegisterCallBack;
import com.huawei.hms.support.log.HMSLog;

public final class UPSService
{
  public static void registerToken(Context paramContext, String paramString1, String paramString2, String paramString3, UPSRegisterCallBack paramUPSRegisterCallBack)
  {
    HMSLog.i("UPSService", "invoke registerToken");
    Preconditions.checkNotNull(paramUPSRegisterCallBack);
    if (!s.b())
    {
      paramUPSRegisterCallBack.onResult(new TokenResult(ErrorEnum.ERROR_OPERATION_NOT_SUPPORTED.getExternalCode()));
      return;
    }
    try
    {
      paramUPSRegisterCallBack.onResult(new TokenResult(HmsInstanceId.getInstance(paramContext).getToken(paramString1, null)));
      return;
    }
    catch (ApiException paramContext)
    {
      paramUPSRegisterCallBack.onResult(new TokenResult(paramContext.getStatusCode(), paramContext.getMessage()));
    }
  }
  
  public static void turnOffPush(Context paramContext, UPSTurnCallBack paramUPSTurnCallBack)
  {
    HMSLog.i("UPSService", "invoke turnOffPush");
    Preconditions.checkNotNull(paramUPSTurnCallBack);
    if (!s.b())
    {
      paramUPSTurnCallBack.onResult(new TokenResult(ErrorEnum.ERROR_OPERATION_NOT_SUPPORTED.getExternalCode()));
      return;
    }
    HmsMessaging.getInstance(paramContext).turnOffPush().addOnCompleteListener(new UPSService.2(paramUPSTurnCallBack));
  }
  
  public static void turnOnPush(Context paramContext, UPSTurnCallBack paramUPSTurnCallBack)
  {
    HMSLog.i("UPSService", "invoke turnOnPush");
    Preconditions.checkNotNull(paramUPSTurnCallBack);
    if (!s.b())
    {
      paramUPSTurnCallBack.onResult(new TokenResult(ErrorEnum.ERROR_OPERATION_NOT_SUPPORTED.getExternalCode()));
      return;
    }
    HmsMessaging.getInstance(paramContext).turnOnPush().addOnCompleteListener(new UPSService.1(paramUPSTurnCallBack));
  }
  
  public static void unRegisterToken(Context paramContext, UPSUnRegisterCallBack paramUPSUnRegisterCallBack)
  {
    HMSLog.i("UPSService", "invoke unRegisterToken");
    Preconditions.checkNotNull(paramUPSUnRegisterCallBack);
    if (!s.b())
    {
      paramUPSUnRegisterCallBack.onResult(new TokenResult(ErrorEnum.ERROR_OPERATION_NOT_SUPPORTED.getExternalCode()));
      return;
    }
    try
    {
      HmsInstanceId.getInstance(paramContext).deleteToken(null, null);
      paramUPSUnRegisterCallBack.onResult(new TokenResult());
      return;
    }
    catch (ApiException paramContext)
    {
      paramUPSUnRegisterCallBack.onResult(new TokenResult(paramContext.getStatusCode(), paramContext.getMessage()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.push.ups.UPSService
 * JD-Core Version:    0.7.0.1
 */