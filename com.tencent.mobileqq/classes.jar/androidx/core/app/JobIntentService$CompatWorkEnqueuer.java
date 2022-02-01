package androidx.core.app;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;

final class JobIntentService$CompatWorkEnqueuer
  extends JobIntentService.WorkEnqueuer
{
  private final Context mContext;
  private final PowerManager.WakeLock mLaunchWakeLock;
  boolean mLaunchingService;
  private final PowerManager.WakeLock mRunWakeLock;
  boolean mServiceProcessing;
  
  JobIntentService$CompatWorkEnqueuer(Context paramContext, ComponentName paramComponentName)
  {
    super(paramComponentName);
    this.mContext = paramContext.getApplicationContext();
    paramContext = (PowerManager)paramContext.getSystemService("power");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramComponentName.getClassName());
    localStringBuilder.append(":launch");
    this.mLaunchWakeLock = paramContext.newWakeLock(1, localStringBuilder.toString());
    this.mLaunchWakeLock.setReferenceCounted(false);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramComponentName.getClassName());
    localStringBuilder.append(":run");
    this.mRunWakeLock = paramContext.newWakeLock(1, localStringBuilder.toString());
    this.mRunWakeLock.setReferenceCounted(false);
  }
  
  void enqueueWork(Intent paramIntent)
  {
    paramIntent = new Intent(paramIntent);
    paramIntent.setComponent(this.mComponentName);
    if (this.mContext.startService(paramIntent) != null) {
      try
      {
        if (!this.mLaunchingService)
        {
          this.mLaunchingService = true;
          if (!this.mServiceProcessing) {
            this.mLaunchWakeLock.acquire(60000L);
          }
        }
        return;
      }
      finally {}
    }
  }
  
  public void serviceProcessingFinished()
  {
    try
    {
      if (this.mServiceProcessing)
      {
        if (this.mLaunchingService) {
          this.mLaunchWakeLock.acquire(60000L);
        }
        this.mServiceProcessing = false;
        this.mRunWakeLock.release();
      }
      return;
    }
    finally {}
  }
  
  public void serviceProcessingStarted()
  {
    try
    {
      if (!this.mServiceProcessing)
      {
        this.mServiceProcessing = true;
        this.mRunWakeLock.acquire(600000L);
        this.mLaunchWakeLock.release();
      }
      return;
    }
    finally {}
  }
  
  public void serviceStartReceived()
  {
    try
    {
      this.mLaunchingService = false;
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.app.JobIntentService.CompatWorkEnqueuer
 * JD-Core Version:    0.7.0.1
 */