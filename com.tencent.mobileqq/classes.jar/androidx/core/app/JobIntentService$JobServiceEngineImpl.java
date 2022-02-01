package androidx.core.app;

import android.app.job.JobParameters;
import android.app.job.JobServiceEngine;
import android.app.job.JobWorkItem;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.RequiresApi;

@RequiresApi(26)
final class JobIntentService$JobServiceEngineImpl
  extends JobServiceEngine
  implements JobIntentService.CompatJobEngine
{
  static final boolean DEBUG = false;
  static final String TAG = "JobServiceEngineImpl";
  final Object mLock = new Object();
  JobParameters mParams;
  final JobIntentService mService;
  
  JobIntentService$JobServiceEngineImpl(JobIntentService paramJobIntentService)
  {
    super(paramJobIntentService);
    this.mService = paramJobIntentService;
  }
  
  public IBinder compatGetBinder()
  {
    return getBinder();
  }
  
  public JobIntentService.GenericWorkItem dequeueWork()
  {
    synchronized (this.mLock)
    {
      if (this.mParams == null) {
        return null;
      }
      JobWorkItem localJobWorkItem = this.mParams.dequeueWork();
      if (localJobWorkItem != null)
      {
        localJobWorkItem.getIntent().setExtrasClassLoader(this.mService.getClassLoader());
        return new JobIntentService.JobServiceEngineImpl.WrapperWorkItem(this, localJobWorkItem);
      }
    }
    return null;
  }
  
  public boolean onStartJob(JobParameters paramJobParameters)
  {
    this.mParams = paramJobParameters;
    this.mService.ensureProcessorRunningLocked(false);
    return true;
  }
  
  public boolean onStopJob(JobParameters arg1)
  {
    boolean bool = this.mService.doStopCurrentWork();
    synchronized (this.mLock)
    {
      this.mParams = null;
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     androidx.core.app.JobIntentService.JobServiceEngineImpl
 * JD-Core Version:    0.7.0.1
 */