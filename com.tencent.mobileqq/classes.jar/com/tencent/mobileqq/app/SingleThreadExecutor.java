package com.tencent.mobileqq.app;

import android.support.annotation.NonNull;
import java.util.LinkedList;
import java.util.Queue;
import javax.annotation.concurrent.GuardedBy;

class SingleThreadExecutor
  extends ThreadManagerExecutor
{
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  @GuardedBy("lock")
  private final Queue<Runnable> jdField_a_of_type_JavaUtilQueue = new LinkedList();
  @GuardedBy("lock")
  private boolean jdField_a_of_type_Boolean = false;
  
  SingleThreadExecutor(int paramInt)
  {
    super(paramInt);
  }
  
  public void execute(@NonNull Runnable arg1)
  {
    SingleThreadExecutor.Task localTask = new SingleThreadExecutor.Task(this, ???, null);
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = true;
        super.execute(localTask);
      }
      else
      {
        this.jdField_a_of_type_JavaUtilQueue.offer(localTask);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.SingleThreadExecutor
 * JD-Core Version:    0.7.0.1
 */