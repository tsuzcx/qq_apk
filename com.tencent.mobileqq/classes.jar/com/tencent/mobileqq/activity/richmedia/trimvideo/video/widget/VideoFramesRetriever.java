package com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget;

import android.annotation.TargetApi;
import android.media.MediaMetadataRetriever;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;

@TargetApi(10)
public class VideoFramesRetriever
  implements OnFetchFrameListener
{
  private static long jdField_a_of_type_Long;
  private float jdField_a_of_type_Float;
  private volatile int jdField_a_of_type_Int = 1;
  private MediaMetadataRetriever jdField_a_of_type_AndroidMediaMediaMetadataRetriever;
  private FrameAdapter jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFrameAdapter;
  private String jdField_a_of_type_JavaLangString;
  private BlockingQueue<VideoFramesRetriever.FrameFetchTask> jdField_a_of_type_JavaUtilConcurrentBlockingQueue;
  private ConcurrentHashMap<Integer, VideoFramesRetriever.FrameFetchTask> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private ExecutorService jdField_a_of_type_JavaUtilConcurrentExecutorService;
  private volatile boolean jdField_a_of_type_Boolean = false;
  private int b = 1000;
  private int c;
  
  public VideoFramesRetriever(String paramString, float paramFloat)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Float = paramFloat;
  }
  
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
        QLog.d("VideoFramesRetriever", 2, ((StringBuilder)localObject).toString());
      }
      return null;
    }
    try
    {
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Integer.valueOf(paramInt)))
      {
        localObject = (VideoFramesRetriever.FrameFetchTask)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
        l = jdField_a_of_type_Long;
        jdField_a_of_type_Long = 1L + l;
        ((VideoFramesRetriever.FrameFetchTask)localObject).jdField_a_of_type_Long = l;
        return null;
      }
      long l = jdField_a_of_type_Long;
      jdField_a_of_type_Long = 1L + l;
      localObject = new VideoFramesRetriever.FrameFetchTask(this, l, paramInt, paramInt + this.b);
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
    this.jdField_a_of_type_AndroidMediaMediaMetadataRetriever = new MediaMetadataRetriever();
    this.jdField_a_of_type_AndroidMediaMediaMetadataRetriever.setDataSource(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService = Executors.newSingleThreadExecutor();
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService.submit(new VideoFramesRetriever.FrameFetchRunnable(this));
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
      QLog.d("VideoFramesRetriever", 2, localStringBuilder.toString());
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
    localObject = this.jdField_a_of_type_AndroidMediaMediaMetadataRetriever;
    if (localObject != null) {
      ((MediaMetadataRetriever)localObject).release();
    }
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
      QLog.d("VideoFramesRetriever", 2, localStringBuilder.toString());
    }
  }
  
  public boolean a()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.VideoFramesRetriever
 * JD-Core Version:    0.7.0.1
 */