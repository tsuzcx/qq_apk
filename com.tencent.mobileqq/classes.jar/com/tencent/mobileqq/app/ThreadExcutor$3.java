package com.tencent.mobileqq.app;

class ThreadExcutor$3
  implements Runnable
{
  ThreadExcutor$3(ThreadExcutor paramThreadExcutor, int paramInt, Runnable paramRunnable, ThreadExcutor.IThreadListener paramIThreadListener, boolean paramBoolean) {}
  
  public void run()
  {
    Job localJob = ThreadExcutor.buildJob(this.val$priority, this.val$job, this.val$listener, this.val$canAutoRetrieve);
    if (localJob == null)
    {
      ThreadLog.printQLog("ThreadManager", "postDownLoadTask -1:w == null" + this.val$job);
      return;
    }
    localJob.poolNum = 5;
    ThreadExcutor.access$600(this.this$0).execute(localJob);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.ThreadExcutor.3
 * JD-Core Version:    0.7.0.1
 */