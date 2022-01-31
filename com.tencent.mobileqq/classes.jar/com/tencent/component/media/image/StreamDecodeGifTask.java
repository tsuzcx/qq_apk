package com.tencent.component.media.image;

import com.tencent.component.media.ILog;
import com.tencent.component.media.ImageManagerEnv;
import com.tencent.component.media.gif.NewGifDecoder.Options;
import com.tencent.component.media.gif.NewGifDrawable;
import com.tencent.component.media.image.processor.NewGifDrawableSpecifiedRegionProcessor;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import pfn;
import pft;
import pfu;

public class StreamDecodeGifTask
  extends DecodeImageTask
{
  private static StreamDecodeGifTask jdField_a_of_type_ComTencentComponentMediaImageStreamDecodeGifTask = null;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private static int d = 0;
  protected static ConcurrentHashMap mGifDrawableRecord = new ConcurrentHashMap();
  private volatile int jdField_a_of_type_Int = 2;
  private long jdField_a_of_type_Long = 0L;
  Future jdField_a_of_type_JavaUtilConcurrentFuture;
  ThreadPoolExecutor jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor;
  pft jdField_a_of_type_Pft;
  pfu jdField_a_of_type_Pfu;
  boolean jdField_a_of_type_Boolean = true;
  private volatile int jdField_b_of_type_Int = 3;
  private StreamDecodeGifTask jdField_b_of_type_ComTencentComponentMediaImageStreamDecodeGifTask = null;
  Future jdField_b_of_type_JavaUtilConcurrentFuture;
  private volatile boolean jdField_b_of_type_Boolean = false;
  private volatile int c = 1;
  protected List mResult = new ArrayList();
  
  protected StreamDecodeGifTask(ImageKey paramImageKey)
  {
    super(paramImageKey);
  }
  
  protected StreamDecodeGifTask(pfn parampfn)
  {
    super(parampfn);
  }
  
  private void a(ImageKey paramImageKey, String paramString1, String paramString2)
  {
    localObject = (NewGifDrawable)ImageManager.getInstance().a(paramImageKey);
    if (localObject == null) {}
    for (;;)
    {
      try
      {
        NewGifDecoder.Options localOptions = new NewGifDecoder.Options();
        localOptions.inPreferHeight = paramImageKey.options.clipHeight;
        localOptions.inPreferWidth = paramImageKey.options.clipWidth;
        paramString2 = new NewGifDrawable(paramString2, 4, localOptions, paramImageKey.hashCodeEx());
        if (paramString2 == null) {
          return;
        }
        paramString2.printStackTrace();
      }
      catch (IOException paramString2)
      {
        try
        {
          paramString2.setUrl(paramImageKey.url);
          localObject = paramString2;
          this.c = ((NewGifDrawable)localObject).getImageCount();
          ImageManagerEnv.getLogger().d("StreamDecodeGifTask-decoding-thread", new Object[] { "RESULT_ON_STREAM_APPLY_IMAGE newFile count:" + this.c + " hashcode:" + paramImageKey.hashCodeEx() + " url:" + paramString1 });
          setResult(15, new Object[] { localObject });
          this.jdField_a_of_type_Long = System.currentTimeMillis();
          ImageManagerEnv.getLogger().d("StreamDecodeGifTask-performance", new Object[] { "First time:" + System.currentTimeMillis() + " hashcode:" + paramImageKey.hashCodeEx() + " url:" + paramString1 });
          paramString1 = (String)localObject;
          paramString2 = paramString1;
          if (paramImageKey != null)
          {
            paramString2 = paramString1;
            if (paramImageKey.options != null)
            {
              paramString2 = paramString1;
              if ((paramImageKey.options.extraProcessor instanceof NewGifDrawableSpecifiedRegionProcessor)) {
                paramString2 = (NewGifDrawable)paramImageKey.options.extraProcessor.doProcess(paramString1);
              }
            }
          }
          ImageManager.getInstance().a(paramImageKey.urlKey, paramImageKey.hashCodeEx(), null, paramString2, paramImageKey.options);
          return;
        }
        catch (IOException localIOException)
        {
          for (;;)
          {
            localObject = paramString2;
            paramString2 = localIOException;
          }
        }
        paramString2 = paramString2;
      }
      continue;
      if (this.jdField_a_of_type_Int != 0)
      {
        this.jdField_a_of_type_Int -= 1;
        paramString1 = (String)localObject;
      }
      else
      {
        ((NewGifDrawable)localObject).updateFile(paramString2);
        if (((NewGifDrawable)localObject).getImageCount() > this.c)
        {
          this.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
          ImageManagerEnv.getLogger().d("StreamDecodeGifTask-decoding-thread", new Object[] { "updateFile mControlLimitTimes:" + this.jdField_b_of_type_Int + " hashcode:" + paramImageKey.hashCodeEx() + " url:" + paramString1 });
          paramString1 = (String)localObject;
        }
        else
        {
          this.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
          this.jdField_b_of_type_Int *= 2;
          this.jdField_a_of_type_Int = (this.jdField_b_of_type_Int - this.jdField_a_of_type_Int);
          paramString1 = (String)localObject;
        }
      }
    }
  }
  
  public static StreamDecodeGifTask obtain(pfn parampfn)
  {
    if (needRecycle) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_ComTencentComponentMediaImageStreamDecodeGifTask != null)
      {
        StreamDecodeGifTask localStreamDecodeGifTask = jdField_a_of_type_ComTencentComponentMediaImageStreamDecodeGifTask;
        jdField_a_of_type_ComTencentComponentMediaImageStreamDecodeGifTask = jdField_a_of_type_ComTencentComponentMediaImageStreamDecodeGifTask.jdField_b_of_type_ComTencentComponentMediaImageStreamDecodeGifTask;
        localStreamDecodeGifTask.jdField_b_of_type_ComTencentComponentMediaImageStreamDecodeGifTask = null;
        d -= 1;
        localStreamDecodeGifTask.setImageTask(parampfn);
        return localStreamDecodeGifTask;
      }
      return new StreamDecodeGifTask(parampfn);
    }
  }
  
  public void excuteTask()
  {
    this.jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
    super.excuteTask();
  }
  
  protected void onResult(int paramInt, Object... paramVarArgs)
  {
    String str;
    switch (paramInt)
    {
    default: 
      super.setResult(paramInt, paramVarArgs);
    case 14: 
      do
      {
        return;
        str = (String)paramVarArgs[0];
        paramVarArgs = (String)paramVarArgs[1];
      } while (this.jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor.isShutdown());
      if (this.jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor.getQueue().contains(this.jdField_a_of_type_Pft))
      {
        ImageManagerEnv.getLogger().d("StreamDecodeGifTask", new Object[] { "onResult RESULT_ON_STREAM_PROGRESS | contains | hashcode:" + this.mImageKey.hashCodeEx() });
        return;
      }
      this.jdField_a_of_type_Pft = new pft(this, this.mImageKey, str, paramVarArgs);
      this.jdField_a_of_type_JavaUtilConcurrentFuture = this.jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor.submit(this.jdField_a_of_type_Pft);
      return;
    case 2: 
      paramVarArgs = (String)paramVarArgs[0];
      str = this.mImageKey.filePath;
      if (!this.jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor.isShutdown())
      {
        if (this.jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor.getQueue().contains(this.jdField_a_of_type_Pfu))
        {
          ImageManagerEnv.getLogger().d("StreamDecodeGifTask", new Object[] { "onResult RESULT_ON_DONWNLOAD_SUCCEED contains | hashcode:" + this.mImageKey.hashCodeEx() });
          return;
        }
        this.jdField_a_of_type_Pfu = new pfu(this, this.mImageKey, paramVarArgs, str);
        this.jdField_b_of_type_JavaUtilConcurrentFuture = this.jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor.submit(this.jdField_a_of_type_Pfu);
      }
      this.jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor.shutdown();
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      ImageTaskBuilder.stampMap2.put(this.mImageKey.url, Long.valueOf(System.currentTimeMillis()));
      this.jdField_a_of_type_Boolean = false;
    }
    super.setResult(paramInt, paramVarArgs);
  }
  
  public void recycle()
  {
    if (!needRecycle) {
      return;
    }
    reset();
    if ((this.jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor != null) && (!this.jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor.isShutdown()))
    {
      ImageManagerEnv.getLogger().d("StreamDecodeGifTask", new Object[] { "executorService shutdown" });
      this.jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor.shutdown();
    }
    this.jdField_a_of_type_Pft = null;
    this.jdField_a_of_type_Pfu = null;
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (d < 50)
      {
        this.jdField_b_of_type_ComTencentComponentMediaImageStreamDecodeGifTask = jdField_a_of_type_ComTencentComponentMediaImageStreamDecodeGifTask;
        jdField_a_of_type_ComTencentComponentMediaImageStreamDecodeGifTask = this;
        d += 1;
      }
      return;
    }
  }
  
  public void removeRecord(String paramString)
  {
    boolean bool;
    if (this.jdField_a_of_type_Pft != null)
    {
      bool = this.jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor.remove(this.jdField_a_of_type_Pft);
      ImageManagerEnv.getLogger().d("StreamDecodeGifTask", new Object[] { "mDecodetask remove:" + bool });
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentFuture != null) {}
    try
    {
      this.jdField_a_of_type_JavaUtilConcurrentFuture.get();
      if (this.jdField_a_of_type_Pfu != null)
      {
        bool = this.jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor.remove(this.jdField_a_of_type_Pfu);
        ImageManagerEnv.getLogger().d("kaedelin", new Object[] { "mEndTask remove:" + bool });
      }
      if (this.jdField_b_of_type_JavaUtilConcurrentFuture == null) {}
    }
    catch (InterruptedException paramString)
    {
      for (;;)
      {
        try
        {
          this.jdField_b_of_type_JavaUtilConcurrentFuture.get();
          return;
        }
        catch (InterruptedException paramString)
        {
          paramString.printStackTrace();
          return;
        }
        catch (ExecutionException paramString)
        {
          paramString.printStackTrace();
        }
        paramString = paramString;
        paramString.printStackTrace();
      }
    }
    catch (ExecutionException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.image.StreamDecodeGifTask
 * JD-Core Version:    0.7.0.1
 */