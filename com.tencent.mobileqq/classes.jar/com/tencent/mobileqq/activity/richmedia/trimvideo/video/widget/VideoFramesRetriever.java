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
  private static long i;
  private volatile int a = 1;
  private int b = 1000;
  private int c;
  private FrameAdapter d;
  private BlockingQueue<VideoFramesRetriever.FrameFetchTask> e;
  private ConcurrentHashMap<Integer, VideoFramesRetriever.FrameFetchTask> f;
  private ExecutorService g;
  private volatile boolean h = false;
  private MediaMetadataRetriever j;
  private String k;
  private float l;
  
  public VideoFramesRetriever(String paramString, float paramFloat)
  {
    this.k = paramString;
    this.l = paramFloat;
  }
  
  private FramesProcessor.Frame b(int paramInt)
  {
    Object localObject;
    if (!b())
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("FetchFrameAtTime fail, status=");
        ((StringBuilder)localObject).append(this.a);
        QLog.d("VideoFramesRetriever", 2, ((StringBuilder)localObject).toString());
      }
      return null;
    }
    try
    {
      if (this.f.containsKey(Integer.valueOf(paramInt)))
      {
        localObject = (VideoFramesRetriever.FrameFetchTask)this.f.get(Integer.valueOf(paramInt));
        l1 = i;
        i = 1L + l1;
        ((VideoFramesRetriever.FrameFetchTask)localObject).a = l1;
        return null;
      }
      long l1 = i;
      i = 1L + l1;
      localObject = new VideoFramesRetriever.FrameFetchTask(this, l1, paramInt, paramInt + this.b);
      if (this.e != null)
      {
        this.e.offer(localObject);
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
    this.d = paramFrameAdapter;
    this.e = new PriorityBlockingQueue();
    this.f = new ConcurrentHashMap();
    this.j = new MediaMetadataRetriever();
    this.j.setDataSource(this.k);
    this.g = Executors.newSingleThreadExecutor();
    this.g.submit(new VideoFramesRetriever.FrameFetchRunnable(this));
    return 0;
  }
  
  public FramesProcessor.Frame a(int paramInt)
  {
    if ((b()) && (paramInt >= 0))
    {
      if (this.d.b(paramInt)) {
        return this.d.a(paramInt);
      }
      return b(paramInt * this.b);
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("fetchFrameByIndex1 fail, status=");
      localStringBuilder.append(this.a);
      QLog.d("VideoFramesRetriever", 2, localStringBuilder.toString());
    }
    return null;
  }
  
  public void a()
  {
    this.a = 1;
    this.h = true;
    Object localObject = this.e;
    if (localObject != null)
    {
      ((BlockingQueue)localObject).clear();
      this.e = null;
    }
    localObject = this.f;
    if (localObject != null)
    {
      ((ConcurrentHashMap)localObject).clear();
      this.f = null;
    }
    this.g.shutdownNow();
    localObject = this.j;
    if (localObject != null) {
      ((MediaMetadataRetriever)localObject).release();
    }
    i = 0L;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((b()) && (paramInt1 >= 0) && (paramInt2 >= 0))
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
      localStringBuilder.append(this.a);
      QLog.d("VideoFramesRetriever", 2, localStringBuilder.toString());
    }
  }
  
  public boolean b()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.VideoFramesRetriever
 * JD-Core Version:    0.7.0.1
 */