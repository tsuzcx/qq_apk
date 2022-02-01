package com.tencent.biz.pubaccount.readinjoy.view;

import android.os.Looper;

public class ThreadPriorityUtil
{
  private int jdField_a_of_type_Int = this.jdField_a_of_type_JavaLangThread.getPriority();
  private Thread jdField_a_of_type_JavaLangThread = Looper.getMainLooper().getThread();
  private int jdField_b_of_type_Int;
  private Thread jdField_b_of_type_JavaLangThread;
  
  public ThreadPriorityUtil()
  {
    for (ThreadGroup localThreadGroup = Thread.currentThread().getThreadGroup(); localThreadGroup.getParent() != null; localThreadGroup = localThreadGroup.getParent()) {}
    Thread[] arrayOfThread = new Thread[localThreadGroup.activeCount()];
    localThreadGroup.enumerate(arrayOfThread);
    int i = 0;
    for (;;)
    {
      if (i < arrayOfThread.length)
      {
        if ((arrayOfThread[i] != null) && (arrayOfThread[i].isAlive()) && (arrayOfThread[i].getName().equalsIgnoreCase("RenderThread")))
        {
          this.jdField_b_of_type_JavaLangThread = arrayOfThread[i];
          this.jdField_b_of_type_Int = this.jdField_b_of_type_JavaLangThread.getPriority();
        }
      }
      else {
        return;
      }
      i += 1;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangThread.setPriority(10);
    if (this.jdField_b_of_type_JavaLangThread != null) {
      this.jdField_b_of_type_JavaLangThread.setPriority(10);
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_JavaLangThread.setPriority(this.jdField_a_of_type_Int);
    if (this.jdField_b_of_type_JavaLangThread != null) {
      this.jdField_b_of_type_JavaLangThread.setPriority(this.jdField_b_of_type_Int);
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("main:" + this.jdField_a_of_type_JavaLangThread.getPriority());
    if (this.jdField_b_of_type_JavaLangThread != null) {
      localStringBuilder.append(" render:" + this.jdField_b_of_type_JavaLangThread.getPriority());
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ThreadPriorityUtil
 * JD-Core Version:    0.7.0.1
 */