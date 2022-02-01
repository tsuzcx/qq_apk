package androidx.core.app;

import android.content.Intent;

final class JobIntentService$CompatWorkItem
  implements JobIntentService.GenericWorkItem
{
  final Intent mIntent;
  final int mStartId;
  
  JobIntentService$CompatWorkItem(JobIntentService paramJobIntentService, Intent paramIntent, int paramInt)
  {
    this.mIntent = paramIntent;
    this.mStartId = paramInt;
  }
  
  public void complete()
  {
    this.this$0.stopSelf(this.mStartId);
  }
  
  public Intent getIntent()
  {
    return this.mIntent;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.app.JobIntentService.CompatWorkItem
 * JD-Core Version:    0.7.0.1
 */