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

public class StreamDecodeGifTask
  extends DecodeImageTask
{
  protected static ConcurrentHashMap<String, NewGifDrawable> mGifDrawableRecord = new ConcurrentHashMap();
  private static int mObjectPoolSize = 0;
  private static StreamDecodeGifTask sPool = null;
  private static final Object sPoolSync = new Object();
  private long beginTime = 0L;
  ThreadPoolExecutor executorService;
  boolean isFirstCallback = true;
  private volatile int mBaseImageCount = 1;
  private volatile int mControlLimitTimes = 3;
  private volatile int mControlTimes = 2;
  StreamDecodeGifTask.DecodeStreamTask mDecodetask;
  Future<?> mEndRes;
  StreamDecodeGifTask.EndCloseStreamTask mEndTask;
  private volatile boolean mNeedControl = false;
  Future<?> mProgressRes;
  protected List<Runnable> mResult = new ArrayList();
  private StreamDecodeGifTask next = null;
  
  protected StreamDecodeGifTask(ImageKey paramImageKey)
  {
    super(paramImageKey);
  }
  
  protected StreamDecodeGifTask(ImageTask paramImageTask)
  {
    super(paramImageTask);
  }
  
  private void decoding(ImageKey paramImageKey, String paramString1, String paramString2)
  {
    Object localObject = (NewGifDrawable)ImageManager.getInstance().getDrawbleFromCache(paramImageKey);
    StringBuilder localStringBuilder;
    if (localObject == null)
    {
      try
      {
        NewGifDecoder.Options localOptions = new NewGifDecoder.Options();
        localOptions.inPreferHeight = paramImageKey.options.clipHeight;
        localOptions.inPreferWidth = paramImageKey.options.clipWidth;
        paramString2 = new NewGifDrawable(paramString2, 4, localOptions, paramImageKey.hashCodeEx());
        try
        {
          paramString2.setUrl(paramImageKey.url);
        }
        catch (IOException localIOException1) {}
        localIOException2.printStackTrace();
      }
      catch (IOException localIOException2)
      {
        paramString2 = (String)localObject;
      }
      this.mBaseImageCount = paramString2.getImageCount();
      localObject = ImageManagerEnv.getLogger();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("RESULT_ON_STREAM_APPLY_IMAGE newFile count:");
      localStringBuilder.append(this.mBaseImageCount);
      localStringBuilder.append(" hashcode:");
      localStringBuilder.append(paramImageKey.hashCodeEx());
      localStringBuilder.append(" url:");
      localStringBuilder.append(paramString1);
      ((ILog)localObject).d("StreamDecodeGifTask-decoding-thread", new Object[] { localStringBuilder.toString() });
      setResult(15, new Object[] { paramString2 });
      this.beginTime = System.currentTimeMillis();
      localObject = ImageManagerEnv.getLogger();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("First time:");
      localStringBuilder.append(System.currentTimeMillis());
      localStringBuilder.append(" hashcode:");
      localStringBuilder.append(paramImageKey.hashCodeEx());
      localStringBuilder.append(" url:");
      localStringBuilder.append(paramString1);
      ((ILog)localObject).d("StreamDecodeGifTask-performance", new Object[] { localStringBuilder.toString() });
    }
    else if (this.mControlTimes != 0)
    {
      this.mControlTimes -= 1;
      paramString2 = (String)localObject;
    }
    else
    {
      ((NewGifDrawable)localObject).updateFile(paramString2);
      if (((NewGifDrawable)localObject).getImageCount() > this.mBaseImageCount)
      {
        this.mControlTimes = this.mControlLimitTimes;
        paramString2 = ImageManagerEnv.getLogger();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("updateFile mControlLimitTimes:");
        localStringBuilder.append(this.mControlLimitTimes);
        localStringBuilder.append(" hashcode:");
        localStringBuilder.append(paramImageKey.hashCodeEx());
        localStringBuilder.append(" url:");
        localStringBuilder.append(paramString1);
        paramString2.d("StreamDecodeGifTask-decoding-thread", new Object[] { localStringBuilder.toString() });
        paramString2 = (String)localObject;
      }
      else
      {
        this.mControlTimes = this.mControlLimitTimes;
        this.mControlLimitTimes *= 2;
        this.mControlTimes = (this.mControlLimitTimes - this.mControlTimes);
        paramString2 = (String)localObject;
      }
    }
    paramString1 = paramString2;
    if (paramImageKey != null)
    {
      paramString1 = paramString2;
      if (paramImageKey.options != null)
      {
        paramString1 = paramString2;
        if ((paramImageKey.options.extraProcessor instanceof NewGifDrawableSpecifiedRegionProcessor)) {
          paramString1 = (NewGifDrawable)paramImageKey.options.extraProcessor.doProcess(paramString2);
        }
      }
    }
    ImageManager.getInstance().putDrawableInMemoryCache(paramImageKey, paramImageKey.hashCodeEx(), null, paramString1, paramImageKey.options);
  }
  
  public static StreamDecodeGifTask obtain(ImageTask paramImageTask)
  {
    if (needRecycle) {
      synchronized (sPoolSync)
      {
        if (sPool != null)
        {
          StreamDecodeGifTask localStreamDecodeGifTask = sPool;
          sPool = sPool.next;
          localStreamDecodeGifTask.next = null;
          mObjectPoolSize -= 1;
          localStreamDecodeGifTask.setImageTask(paramImageTask);
          return localStreamDecodeGifTask;
        }
      }
    }
    return new StreamDecodeGifTask(paramImageTask);
  }
  
  public void excuteTask()
  {
    this.executorService = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
    super.excuteTask();
  }
  
  protected void onResult(int paramInt, Object... paramVarArgs)
  {
    Object localObject;
    if (paramInt != 2)
    {
      if (paramInt != 3)
      {
        if (paramInt != 14)
        {
          super.setResult(paramInt, paramVarArgs);
          return;
        }
        localObject = (String)paramVarArgs[0];
        paramVarArgs = (String)paramVarArgs[1];
        if (!this.executorService.isShutdown())
        {
          if (this.executorService.getQueue().contains(this.mDecodetask))
          {
            paramVarArgs = ImageManagerEnv.getLogger();
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("onResult RESULT_ON_STREAM_PROGRESS | contains | hashcode:");
            ((StringBuilder)localObject).append(this.mImageKey.hashCodeEx());
            paramVarArgs.d("StreamDecodeGifTask", new Object[] { ((StringBuilder)localObject).toString() });
            return;
          }
          this.mDecodetask = new StreamDecodeGifTask.DecodeStreamTask(this, this.mImageKey, (String)localObject, paramVarArgs);
          this.mProgressRes = this.executorService.submit(this.mDecodetask);
        }
      }
      else
      {
        if (this.isFirstCallback)
        {
          ImageTaskBuilder.stampMap2.put(this.mImageKey.url, Long.valueOf(System.currentTimeMillis()));
          this.isFirstCallback = false;
        }
        super.setResult(paramInt, paramVarArgs);
      }
    }
    else
    {
      paramVarArgs = (String)paramVarArgs[0];
      localObject = this.mImageKey.filePath;
      if (!this.executorService.isShutdown())
      {
        if (this.executorService.getQueue().contains(this.mEndTask))
        {
          paramVarArgs = ImageManagerEnv.getLogger();
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("onResult RESULT_ON_DONWNLOAD_SUCCEED contains | hashcode:");
          ((StringBuilder)localObject).append(this.mImageKey.hashCodeEx());
          paramVarArgs.d("StreamDecodeGifTask", new Object[] { ((StringBuilder)localObject).toString() });
          return;
        }
        this.mEndTask = new StreamDecodeGifTask.EndCloseStreamTask(this, this.mImageKey, paramVarArgs, (String)localObject);
        this.mEndRes = this.executorService.submit(this.mEndTask);
      }
      this.executorService.shutdown();
    }
  }
  
  public void recycle()
  {
    if (!needRecycle) {
      return;
    }
    reset();
    ??? = this.executorService;
    if ((??? != null) && (!((ThreadPoolExecutor)???).isShutdown()))
    {
      ImageManagerEnv.getLogger().d("StreamDecodeGifTask", new Object[] { "executorService shutdown" });
      this.executorService.shutdown();
    }
    this.mDecodetask = null;
    this.mEndTask = null;
    synchronized (sPoolSync)
    {
      if (mObjectPoolSize < 50)
      {
        this.next = sPool;
        sPool = this;
        mObjectPoolSize += 1;
      }
      return;
    }
  }
  
  protected void removeRecord(String paramString)
  {
    paramString = this.mDecodetask;
    boolean bool;
    StringBuilder localStringBuilder;
    if (paramString != null)
    {
      bool = this.executorService.remove(paramString);
      paramString = ImageManagerEnv.getLogger();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("mDecodetask remove:");
      localStringBuilder.append(bool);
      paramString.d("StreamDecodeGifTask", new Object[] { localStringBuilder.toString() });
    }
    paramString = this.mProgressRes;
    if (paramString != null) {
      try
      {
        paramString.get();
      }
      catch (ExecutionException paramString)
      {
        paramString.printStackTrace();
      }
      catch (InterruptedException paramString)
      {
        paramString.printStackTrace();
      }
    }
    paramString = this.mEndTask;
    if (paramString != null)
    {
      bool = this.executorService.remove(paramString);
      paramString = ImageManagerEnv.getLogger();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("mEndTask remove:");
      localStringBuilder.append(bool);
      paramString.d("kaedelin", new Object[] { localStringBuilder.toString() });
    }
    paramString = this.mEndRes;
    if (paramString != null) {
      try
      {
        paramString.get();
        return;
      }
      catch (ExecutionException paramString)
      {
        paramString.printStackTrace();
        return;
      }
      catch (InterruptedException paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.component.media.image.StreamDecodeGifTask
 * JD-Core Version:    0.7.0.1
 */