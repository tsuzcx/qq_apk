package com.tencent.component.network.utils.thread;

import java.util.concurrent.atomic.AtomicLong;

class PriorityThreadPool$PriorityJob
  implements ThreadPool.Job, Comparable
{
  private static final AtomicLong jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong = new AtomicLong(0L);
  private final int jdField_a_of_type_Int;
  private final long jdField_a_of_type_Long;
  private final ThreadPool.Job jdField_a_of_type_ComTencentComponentNetworkUtilsThreadThreadPool$Job;
  private final boolean jdField_a_of_type_Boolean;
  
  public PriorityThreadPool$PriorityJob(ThreadPool.Job paramJob, int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentComponentNetworkUtilsThreadThreadPool$Job = paramJob;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Long = jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.getAndIncrement();
  }
  
  private int a(PriorityJob paramPriorityJob)
  {
    int i;
    if (this.jdField_a_of_type_Long < paramPriorityJob.jdField_a_of_type_Long) {
      i = -1;
    }
    while (this.jdField_a_of_type_Boolean)
    {
      return i;
      if (this.jdField_a_of_type_Long > paramPriorityJob.jdField_a_of_type_Long) {
        i = 1;
      } else {
        i = 0;
      }
    }
    return -i;
  }
  
  public int compareTo(PriorityJob paramPriorityJob)
  {
    if (this.jdField_a_of_type_Int > paramPriorityJob.jdField_a_of_type_Int) {
      return -1;
    }
    if (this.jdField_a_of_type_Int < paramPriorityJob.jdField_a_of_type_Int) {
      return 1;
    }
    return a(paramPriorityJob);
  }
  
  public Object run(ThreadPool.JobContext paramJobContext)
  {
    try
    {
      String str = Thread.currentThread().getName();
      str = str.substring(0, str.indexOf(" sub:") + " sub:".length());
      Thread.currentThread().setName(str + this.jdField_a_of_type_ComTencentComponentNetworkUtilsThreadThreadPool$Job.getClass().toString());
      label58:
      return this.jdField_a_of_type_ComTencentComponentNetworkUtilsThreadThreadPool$Job.run(paramJobContext);
    }
    catch (Exception localException)
    {
      break label58;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.utils.thread.PriorityThreadPool.PriorityJob
 * JD-Core Version:    0.7.0.1
 */