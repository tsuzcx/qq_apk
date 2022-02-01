package com.tencent.mobileqq.adapter;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ThreadPoolParams
{
  public int a;
  public String a;
  public BlockingQueue<Runnable> a;
  public int b = 3;
  public int c = 5;
  public int d = 1;
  
  public ThreadPoolParams()
  {
    this.jdField_a_of_type_JavaLangString = "default_name";
    this.jdField_a_of_type_Int = 5;
    this.jdField_a_of_type_JavaUtilConcurrentBlockingQueue = new LinkedBlockingQueue(128);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.ThreadPoolParams
 * JD-Core Version:    0.7.0.1
 */