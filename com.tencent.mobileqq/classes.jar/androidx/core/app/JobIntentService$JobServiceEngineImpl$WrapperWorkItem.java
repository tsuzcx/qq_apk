package androidx.core.app;

import android.app.job.JobParameters;
import android.app.job.JobWorkItem;
import android.content.Intent;

final class JobIntentService$JobServiceEngineImpl$WrapperWorkItem
  implements JobIntentService.GenericWorkItem
{
  final JobWorkItem mJobWork;
  
  JobIntentService$JobServiceEngineImpl$WrapperWorkItem(JobIntentService.JobServiceEngineImpl paramJobServiceEngineImpl, JobWorkItem paramJobWorkItem)
  {
    this.mJobWork = paramJobWorkItem;
  }
  
  public void complete()
  {
    synchronized (this.this$0.mLock)
    {
      if (this.this$0.mParams != null) {
        this.this$0.mParams.completeWork(this.mJobWork);
      }
      return;
    }
  }
  
  public Intent getIntent()
  {
    return this.mJobWork.getIntent();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.app.JobIntentService.JobServiceEngineImpl.WrapperWorkItem
 * JD-Core Version:    0.7.0.1
 */