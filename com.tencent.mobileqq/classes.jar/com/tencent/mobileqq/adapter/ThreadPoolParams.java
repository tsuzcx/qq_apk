package com.tencent.mobileqq.adapter;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ThreadPoolParams
{
  public String a = "default_name";
  public int b = 5;
  public int c = 3;
  public int d = 5;
  public int e = 1;
  public BlockingQueue<Runnable> f = new LinkedBlockingQueue(128);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.ThreadPoolParams
 * JD-Core Version:    0.7.0.1
 */