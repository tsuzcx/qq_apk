package com.huawei.hms.opendevice;

import com.huawei.hmf.tasks.Task;
import com.huawei.hms.support.api.opendevice.OdidResult;

public abstract interface OpenDeviceClient
{
  public abstract Task<OdidResult> getOdid();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.opendevice.OpenDeviceClient
 * JD-Core Version:    0.7.0.1
 */