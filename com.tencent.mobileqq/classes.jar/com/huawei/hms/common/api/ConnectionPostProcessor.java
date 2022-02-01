package com.huawei.hms.common.api;

import android.app.Activity;
import com.huawei.hms.api.HuaweiApiClient;
import java.lang.ref.WeakReference;

public abstract interface ConnectionPostProcessor
{
  public abstract void run(HuaweiApiClient paramHuaweiApiClient, WeakReference<Activity> paramWeakReference);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.common.api.ConnectionPostProcessor
 * JD-Core Version:    0.7.0.1
 */