package com.tencent.biz.pubaccount.readinjoy.engine;

import android.os.SystemClock;
import android.support.annotation.NonNull;

class MonitorTimeExecutor$TimeTrackedRunnable
  implements Runnable
{
  private final long jdField_a_of_type_Long;
  private final Runnable jdField_a_of_type_JavaLangRunnable;
  private Thread jdField_a_of_type_JavaLangThread;
  private long b;
  private long c;
  
  private MonitorTimeExecutor$TimeTrackedRunnable(@NonNull Runnable paramRunnable)
  {
    this.jdField_a_of_type_JavaLangRunnable = paramRunnable;
    this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
  }
  
  public Runnable a()
  {
    return this.jdField_a_of_type_JavaLangRunnable;
  }
  
  public Thread a()
  {
    return this.jdField_a_of_type_JavaLangThread;
  }
  
  public void run()
  {
    this.b = SystemClock.uptimeMillis();
    this.c = (this.b - this.jdField_a_of_type_Long);
    this.jdField_a_of_type_JavaLangThread = Thread.currentThread();
    this.jdField_a_of_type_JavaLangRunnable.run();
  }
  
  public String toString()
  {
    return "TimeTrackedRunnable{timestampAdded=" + this.jdField_a_of_type_Long + ", timestampStarted=" + this.b + ", task=" + this.jdField_a_of_type_JavaLangRunnable + ", timeWaited=" + this.c + ", currentThread=" + this.jdField_a_of_type_JavaLangThread + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.MonitorTimeExecutor.TimeTrackedRunnable
 * JD-Core Version:    0.7.0.1
 */