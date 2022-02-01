package com.huawei.hms.opendevice;

import android.app.Activity;
import android.content.Context;
import com.huawei.hms.utils.Checker;

public class OpenDevice
{
  public static OpenDeviceClient getOpenDeviceClient(Activity paramActivity)
  {
    Checker.assertNonNull(paramActivity);
    return new OpenDeviceClientImpl(paramActivity);
  }
  
  public static OpenDeviceClient getOpenDeviceClient(Context paramContext)
  {
    Checker.assertNonNull(paramContext);
    return new OpenDeviceClientImpl(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hms.opendevice.OpenDevice
 * JD-Core Version:    0.7.0.1
 */