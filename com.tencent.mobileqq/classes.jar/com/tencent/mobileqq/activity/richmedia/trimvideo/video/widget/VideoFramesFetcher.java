package com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget;

import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;

public class VideoFramesFetcher
  implements OnFetchFrameListener
{
  private static long jdField_a_of_type_Long;
  private volatile int jdField_a_of_type_Int = 1;
  private FrameAdapter jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFrameAdapter;
  private BlockingQueue<VideoFramesFetcher.FrameFetchTask> jdField_a_of_type_JavaUtilConcurrentBlockingQueue;
  private ConcurrentHashMap<Integer, VideoFramesFetcher.FrameFetchTask> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private ExecutorService jdField_a_of_type_JavaUtilConcurrentExecutorService;
  private volatile boolean jdField_a_of_type_Boolean = false;
  private int b = 1000;
  private int c;
  
  private FramesProcessor.Frame b(int paramInt)
  {
    Object localObject;
    if (!a())
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("FetchFrameAtTime fail, status=");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
        QLog.d("VideoFramesFetcher", 2, ((StringBuilder)localObject).toString());
      }
      return null;
    }
    try
    {
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Integer.valueOf(paramInt)))
      {
        localObject = (VideoFramesFetcher.FrameFetchTask)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
        l = jdField_a_of_type_Long;
        jdField_a_of_type_Long = 1L + l;
        ((VideoFramesFetcher.FrameFetchTask)localObject).jdField_a_of_type_Long = l;
        return null;
      }
      long l = jdField_a_of_type_Long;
      jdField_a_of_type_Long = 1L + l;
      localObject = new VideoFramesFetcher.FrameFetchTask(this, l, paramInt, paramInt + this.b);
      if (this.jdField_a_of_type_JavaUtilConcurrentBlockingQueue != null)
      {
        this.jdField_a_of_type_JavaUtilConcurrentBlockingQueue.offer(localObject);
        return null;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  public int a(int paramInt1, int paramInt2, FrameAdapter paramFrameAdapter)
  {
    this.b = paramInt1;
    this.c = paramInt2;
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFrameAdapter = paramFrameAdapter;
    this.jdField_a_of_type_JavaUtilConcurrentBlockingQueue = new PriorityBlockingQueue();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService = Executors.newSingleThreadExecutor();
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService.submit(new VideoFramesFetcher.FrameFetchRunnable(this));
    return 0;
  }
  
  public FramesProcessor.Frame a(int paramInt)
  {
    if ((a()) && (paramInt >= 0))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFrameAdapter.a(paramInt)) {
        return this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFrameAdapter.a(paramInt);
      }
      return b(paramInt * this.b);
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("fetchFrameByIndex1 fail, status=");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      QLog.d("VideoFramesFetcher", 2, localStringBuilder.toString());
    }
    return null;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_Boolean = true;
    Object localObject = this.jdField_a_of_type_JavaUtilConcurrentBlockingQueue;
    if (localObject != null)
    {
      ((BlockingQueue)localObject).clear();
      this.jdField_a_of_type_JavaUtilConcurrentBlockingQueue = null;
    }
    localObject = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
    if (localObject != null)
    {
      ((ConcurrentHashMap)localObject).clear();
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = null;
    }
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService.shutdownNow();
    jdField_a_of_type_Long = 0L;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((a()) && (paramInt1 >= 0) && (paramInt2 >= 0))
    {
      paramInt2 -= 1;
      while (paramInt2 >= paramInt1)
      {
        a(paramInt2);
        paramInt2 -= 1;
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("fetchFrameByIndex2 fail, status=");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      QLog.d("VideoFramesFetcher", 2, localStringBuilder.toString());
    }
  }
  
  public boolean a()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.VideoFramesFetcher
 * JD-Core Version:    0.7.0.1
 */