package com.huawei.hiar;

import android.content.Context;
import android.os.Handler;
import android.util.Log;

class l
  extends k
{
  private static final String a = l.class.getSimpleName();
  
  public void a(Context paramContext, HuaweiArApkBase.ICheckAvailabilityCallback paramICheckAvailabilityCallback)
  {
    Log.d(a, "checkAvailability: start to access config server");
    d locald = new d("config access Thread");
    locald.start();
    new g(paramContext, paramICheckAvailabilityCallback, new Handler(locald.getLooper(), locald)).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.huawei.hiar.l
 * JD-Core Version:    0.7.0.1
 */