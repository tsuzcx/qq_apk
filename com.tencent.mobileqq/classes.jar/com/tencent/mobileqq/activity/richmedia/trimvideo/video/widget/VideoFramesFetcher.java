package com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget;

import amac;
import amah;
import amaj;
import aman;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;

public class VideoFramesFetcher
  implements amaj
{
  private static long jdField_a_of_type_Long;
  private volatile int jdField_a_of_type_Int = 1;
  private amac jdField_a_of_type_Amac;
  private BlockingQueue<aman> jdField_a_of_type_JavaUtilConcurrentBlockingQueue;
  private ConcurrentHashMap<Integer, aman> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private ExecutorService jdField_a_of_type_JavaUtilConcurrentExecutorService;
  private volatile boolean jdField_a_of_type_Boolean;
  private int b = 1000;
  private int c;
  
  private amah b(int paramInt)
  {
    if (!a()) {
      if (QLog.isColorLevel()) {
        QLog.d("VideoFramesFetcher", 2, "FetchFrameAtTime fail, status=" + this.jdField_a_of_type_Int);
      }
    }
    aman localaman2;
    do
    {
      return null;
      try
      {
        if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Integer.valueOf(paramInt)))
        {
          aman localaman1 = (aman)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
          l = jdField_a_of_type_Long;
          jdField_a_of_type_Long = 1L + l;
          localaman1.jdField_a_of_type_Long = l;
          return null;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return null;
      }
      long l = jdField_a_of_type_Long;
      jdField_a_of_type_Long = 1L + l;
      localaman2 = new aman(this, l, paramInt, paramInt + this.b);
    } while (this.jdField_a_of_type_JavaUtilConcurrentBlockingQueue == null);
    this.jdField_a_of_type_JavaUtilConcurrentBlockingQueue.offer(localaman2);
    return null;
  }
  
  public int a(int paramInt1, int paramInt2, amac paramamac)
  {
    this.b = paramInt1;
    this.c = paramInt2;
    this.jdField_a_of_type_Amac = paramamac;
    this.jdField_a_of_type_JavaUtilConcurrentBlockingQueue = new PriorityBlockingQueue();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService = Executors.newSingleThreadExecutor();
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService.submit(new VideoFramesFetcher.FrameFetchRunnable(this));
    return 0;
  }
  
  public amah a(int paramInt)
  {
    if ((!a()) || (paramInt < 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoFramesFetcher", 2, "fetchFrameByIndex1 fail, status=" + this.jdField_a_of_type_Int);
      }
      return null;
    }
    if (this.jdField_a_of_type_Amac.a(paramInt)) {
      return this.jdField_a_of_type_Amac.a(paramInt);
    }
    return b(this.b * paramInt);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_JavaUtilConcurrentBlockingQueue != null)
    {
      this.jdField_a_of_type_JavaUtilConcurrentBlockingQueue.clear();
      this.jdField_a_of_type_JavaUtilConcurrentBlockingQueue = null;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null)
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = null;
    }
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService.shutdownNow();
    jdField_a_of_type_Long = 0L;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((!a()) || (paramInt1 < 0) || (paramInt2 < 0)) {
      if (QLog.isColorLevel()) {
        QLog.d("VideoFramesFetcher", 2, "fetchFrameByIndex2 fail, status=" + this.jdField_a_of_type_Int);
      }
    }
    for (;;)
    {
      return;
      paramInt2 -= 1;
      while (paramInt2 >= paramInt1)
      {
        a(paramInt2);
        paramInt2 -= 1;
      }
    }
  }
  
  public boolean a()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.VideoFramesFetcher
 * JD-Core Version:    0.7.0.1
 */