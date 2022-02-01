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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCreate: invoked.  mCreateTimeMs: ");
      localStringBuilder.append(this.a);
      QLog.i("BackgroundService", 2, localStringBuilder.toString());
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    long l = (System.currentTimeMillis() - this.a) / 1000L;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDestroy: invoked.  durationSecond: ");
      localStringBuilder.append(l);
      QLog.i("BackgroundService", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.bgprobe.BackgroundService
 * JD-Core Version:    0.7.0.1
 */