package com.huawei.hms.api;

import android.app.Activity;
import com.huawei.hms.support.api.ResolveResult;
import com.huawei.hms.support.api.client.ResultCallback;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.core.JosGetNoticeResp;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.Util;
import java.lang.ref.WeakReference;

class HuaweiApiClientImpl$c
  implements ResultCallback<ResolveResult<JosGetNoticeResp>>
{
  private HuaweiApiClientImpl$c(HuaweiApiClientImpl paramHuaweiApiClientImpl) {}
  
  public void a(ResolveResult<JosGetNoticeResp> paramResolveResult)
  {
    Object localObject;
    if ((paramResolveResult != null) && (paramResolveResult.getStatus().isSuccess()))
    {
      localObject = (JosGetNoticeResp)paramResolveResult.getValue();
      paramResolveResult = ((JosGetNoticeResp)localObject).getNoticeIntent();
      if ((paramResolveResult != null) && (((JosGetNoticeResp)localObject).getStatusCode() == 0))
      {
        HMSLog.i("HuaweiApiClientImpl", "get notice has intent.");
        localObject = Util.getValidActivity((Activity)HuaweiApiClientImpl.d(this.a).get(), this.a.getTopActivity());
        if (localObject != null) {
          break label81;
        }
        HMSLog.e("HuaweiApiClientImpl", "showNotice no valid activity!");
      }
    }
    return;
    label81:
    HuaweiApiClientImpl.a(this.a, true);
    ((Activity)localObject).startActivity(paramResolveResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.api.HuaweiApiClientImpl.c
 * JD-Core Version:    0.7.0.1
 */