package androidx.core.app;

import android.app.job.JobInfo;
import android.app.job.JobInfo.Builder;
import android.app.job.JobScheduler;
import android.app.job.JobWorkItem;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.RequiresApi;

@RequiresApi(26)
final class JobIntentService$JobWorkEnqueuer
  extends JobIntentService.WorkEnqueuer
{
  private final JobInfo mJobInfo;
  private final JobScheduler mJobScheduler;
  
  JobIntentService$JobWorkEnqueuer(Context paramContext, ComponentName paramComponentName, int paramInt)
  {
    super(paramComponentName);
    ensureJobId(paramInt);
    this.mJobInfo = new JobInfo.Builder(paramInt, this.mComponentName).setOverrideDeadline(0L).build();
    this.mJobScheduler = ((JobScheduler)paramContext.getApplicationContext().getSystemService("jobscheduler"));
  }
  
  void enqueueWork(Intent paramIntent)
  {
    this.mJobScheduler.enqueue(this.mJobInfo, new JobWorkItem(paramIntent));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.app.JobIntentService.JobWorkEnqueuer
 * JD-Core Version:    0.7.0.1
 */