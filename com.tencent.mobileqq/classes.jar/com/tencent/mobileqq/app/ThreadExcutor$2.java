package com.tencent.mobileqq.app;

class ThreadExcutor$2
  implements Runnable
{
  ThreadExcutor$2(ThreadExcutor paramThreadExcutor, int paramInt, Runnable paramRunnable, ThreadExcutor.IThreadListener paramIThreadListener, boolean paramBoolean) {}
  
  public void run()
  {
    Job localJob = ThreadExcutor.buildJob(this.val$type, this.val$job, this.val$listener, this.val$canAutoRetrieve);
    Object localObject;
    if (localJob == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("w_NONE_job");
      ((StringBuilder)localObject).append(this.val$job.getClass().getName());
      ThreadExcutor.doRdmReport("ThreadManagerV2_excute_Job_NULL", ((StringBuilder)localObject).toString());
      return;
    }
    int i = this.val$type;
    if ((i & 0x80) != 0)
    {
      localJob.poolNum = 9;
      localObject = ThreadExcutor.access$200(this.this$0);
    }
    else if ((i & 0x40) != 0)
    {
      localJob.poolNum = 8;
      localObject = ThreadExcutor.access$300(this.this$0);
    }
    else if ((i & 0x20) != 0)
    {
      localJob.poolNum = 7;
      localObject = ThreadExcutor.access$400(this.this$0);
    }
    else
    {
      if ((i & 0x10) == 0) {
        return;
      }
      localJob.poolNum = 6;
      localObject = ThreadExcutor.access$500(this.this$0);
    }
    ((ThreadSmartPool)localObject).execute(localJob);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.ThreadExcutor.2
 * JD-Core Version:    0.7.0.1
 */