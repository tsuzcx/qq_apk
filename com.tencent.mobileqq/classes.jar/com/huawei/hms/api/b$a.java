package com.huawei.hms.api;

import android.app.Activity;
import android.content.Intent;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.activity.internal.BusResponseCallback;
import com.huawei.hms.activity.internal.BusResponseResult;
import com.huawei.hms.common.api.AvailabilityException;
import com.huawei.hms.support.log.HMSLog;

class b$a
  implements BusResponseCallback
{
  b$a(b paramb, TaskCompletionSource[] paramArrayOfTaskCompletionSource) {}
  
  public BusResponseResult innerError(Activity paramActivity, int paramInt, String paramString)
  {
    paramActivity = new StringBuilder();
    paramActivity.append("Test foreground bus error: resultCode ");
    paramActivity.append(paramInt);
    paramActivity.append(", errMessage");
    paramActivity.append(paramString);
    HMSLog.e("HuaweiApiAvailabilityImpl", paramActivity.toString());
    this.a[0].setException(new AvailabilityException());
    return null;
  }
  
  public BusResponseResult succeedReturn(Activity paramActivity, int paramInt, Intent paramIntent)
  {
    paramActivity = new StringBuilder();
    paramActivity.append("Test foreground bus success: resultCode ");
    paramActivity.append(paramInt);
    paramActivity.append(", data");
    paramActivity.append(paramIntent);
    HMSLog.i("HuaweiApiAvailabilityImpl", paramActivity.toString());
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.api.b.a
 * JD-Core Version:    0.7.0.1
 */