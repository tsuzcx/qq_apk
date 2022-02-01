package androidx.core.app;

import android.content.ComponentName;
import android.content.Intent;

abstract class JobIntentService$WorkEnqueuer
{
  final ComponentName mComponentName;
  boolean mHasJobId;
  int mJobId;
  
  JobIntentService$WorkEnqueuer(ComponentName paramComponentName)
  {
    this.mComponentName = paramComponentName;
  }
  
  abstract void enqueueWork(Intent paramIntent);
  
  void ensureJobId(int paramInt)
  {
    if (!this.mHasJobId)
    {
      this.mHasJobId = true;
      this.mJobId = paramInt;
      return;
    }
    if (this.mJobId == paramInt) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Given job ID ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" is different than previous ");
    localStringBuilder.append(this.mJobId);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public void serviceProcessingFinished() {}
  
  public void serviceProcessingStarted() {}
  
  public void serviceStartReceived() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.app.JobIntentService.WorkEnqueuer
 * JD-Core Version:    0.7.0.1
 */