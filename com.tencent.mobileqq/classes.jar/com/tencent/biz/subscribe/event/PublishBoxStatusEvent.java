package com.tencent.biz.subscribe.event;

import android.os.Bundle;

public class PublishBoxStatusEvent
  extends SimpleBaseEvent
{
  public boolean hasOfflineWaitingTask;
  public boolean hasRunningTask;
  public int taskCount;
  
  public PublishBoxStatusEvent(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      this.taskCount = paramBundle.getInt("taskCount", 0);
      this.hasRunningTask = paramBundle.getBoolean("hasRunningTask", false);
      this.hasOfflineWaitingTask = paramBundle.getBoolean("hasOfflineWaitingTask", false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.subscribe.event.PublishBoxStatusEvent
 * JD-Core Version:    0.7.0.1
 */