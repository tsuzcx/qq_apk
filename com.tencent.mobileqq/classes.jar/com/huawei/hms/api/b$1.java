package com.huawei.hms.api;

import android.app.Activity;
import android.content.Intent;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.activity.internal.BusResponseCallback;
import com.huawei.hms.activity.internal.BusResponseResult;
import com.huawei.hms.common.api.AvailabilityException;
import com.huawei.hms.support.log.HMSLog;

class b$1
  implements BusResponseCallback
{
  b$1(b paramb, TaskCompletionSource[] paramArrayOfTaskCompletionSource) {}
  
  public BusResponseResult innerError(Activity paramActivity, int paramInt, String paramString)
  {
    HMSLog.e("HuaweiApiAvailabilityImpl", "Test foreground bus error: resultCode " + paramInt + ", errMessage" + paramString);
    this.a[0].setException(new AvailabilityException());
    return null;
  }
  
  public BusResponseResult succeedReturn(Activity paramActivity, int paramInt, Intent paramIntent)
  {
    HMSLog.i("HuaweiApiAvailabilityImpl", "Test foreground bus success: resultCode " + paramInt + ", data" + paramIntent);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hms.api.b.1
 * JD-Core Version:    0.7.0.1
 */