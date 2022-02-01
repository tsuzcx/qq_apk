package com.tencent.mobileqq.app;

class ThreadExcutor$3
  implements Runnable
{
  ThreadExcutor$3(ThreadExcutor paramThreadExcutor, int paramInt, Runnable paramRunnable, ThreadExcutor.IThreadListener paramIThreadListener, boolean paramBoolean) {}
  
  public void run()
  {
    Object localObject = ThreadExcutor.buildJob(this.val$priority, this.val$job, this.val$listener, this.val$canAutoRetrieve);
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("postDownLoadTask -1:w == null");
      ((StringBuilder)localObject).append(this.val$job);
      ThreadLog.printQLog("ThreadManager", ((StringBuilder)localObject).toString());
      return;
    }
    ((Job)localObject).poolNum = 5;
    ThreadExcutor.access$600(this.this$0).execute((Runnable)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.ThreadExcutor.3
 * JD-Core Version:    0.7.0.1
 */