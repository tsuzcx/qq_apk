package androidx.core.app;

import android.os.IBinder;

abstract interface JobIntentService$CompatJobEngine
{
  public abstract IBinder compatGetBinder();
  
  public abstract JobIntentService.GenericWorkItem dequeueWork();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.app.JobIntentService.CompatJobEngine
 * JD-Core Version:    0.7.0.1
 */