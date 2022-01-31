package com.tencent.mobileqq.bgprobe;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class BackgroundService
  extends Service
{
  private long a;
  
  @Nullable
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.a = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.i("BackgroundService", 2, "onCreate: invoked.  mCreateTimeMs: " + this.a);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    long l = (System.currentTimeMillis() - this.a) / 1000L;
    if (QLog.isColorLevel()) {
      QLog.i("BackgroundService", 2, "onDestroy: invoked.  durationSecond: " + l);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.bgprobe.BackgroundService
 * JD-Core Version:    0.7.0.1
 */