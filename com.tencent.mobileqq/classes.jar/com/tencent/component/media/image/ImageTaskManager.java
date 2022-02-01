package com.tencent.component.media.image;

import android.util.Log;
import com.tencent.component.media.IDownloader;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

class ImageTaskManager
{
  private static ConcurrentHashMap<Integer, ImageTask> mImageTaskSet = new ConcurrentHashMap();
  private static ImageTaskManager mInstance = new ImageTaskManager();
  private static ConcurrentHashMap<Integer, DecodeImageTask> mWaitToDecodeImageTaskRecord = new ConcurrentHashMap();
  private static long requestNum = 0L;
  
  public static void addImageTask(ImageTask paramImageTask)
  {
    if (paramImageTask != null)
    {
      if (paramImageTask.getImageKey() == null) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("addImageTask | imageKey:");
      localStringBuilder.append(paramImageTask.getImageKey());
      localStringBuilder.append(" url:");
      localStringBuilder.append(paramImageTask.getImageKey().url);
      Log.d("ImageTaskManager", localStringBuilder.toString());
      mImageTaskSet.put(Integer.valueOf(paramImageTask.getImageKey().hashCodeEx()), paramImageTask);
    }
  }
  
  public static void addRequest()
  {
    try
    {
      requestNum += 1L;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("requestNum: ");
      localStringBuilder.append(requestNum);
      Log.i("ttt", localStringBuilder.toString());
      return;
    }
    finally {}
  }
  
  public static void cancelImageTask(ImageKey paramImageKey)
  {
    if (paramImageKey == null) {
      return;
    }
    ImageTask localImageTask = (ImageTask)mImageTaskSet.get(Integer.valueOf(paramImageKey.hashCodeEx()));
    if (localImageTask != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("cancelImageTask | imageKey:");
      localStringBuilder.append(paramImageKey.hashCodeEx());
      localStringBuilder.append(" url:");
      localStringBuilder.append(paramImageKey.url);
      Log.d("ImageTaskManager", localStringBuilder.toString());
      localImageTask.cancel();
    }
  }
  
  public static void clearAllImageTask()
  {
    mImageTaskSet.clear();
  }
  
  public static ImageTaskManager getInstance()
  {
    return mInstance;
  }
  
  @Deprecated
  public static void removeImageTask(ImageKey paramImageKey)
  {
    if (paramImageKey == null) {
      return;
    }
    ImageTask localImageTask = (ImageTask)mImageTaskSet.remove(Integer.valueOf(paramImageKey.hashCodeEx()));
    if ((localImageTask != null) && ((localImageTask instanceof CancelStreamDecodeGifTask)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("removeImageTask | imageKey:");
      localStringBuilder.append(paramImageKey.hashCodeEx());
      localStringBuilder.append(" url:");
      localStringBuilder.append(paramImageKey.url);
      Log.d("ImageTaskManager", localStringBuilder.toString());
      ((CancelStreamDecodeGifTask)localImageTask).removeRecord(paramImageKey.url);
    }
  }
  
  public static void removeRequest()
  {
    try
    {
      requestNum -= 1L;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("requestNum: ");
      localStringBuilder.append(requestNum);
      Log.i("ttt", localStringBuilder.toString());
      return;
    }
    finally {}
  }
  
  public void addWaitToDecodeImageTask(DecodeImageTask paramDecodeImageTask)
  {
    synchronized (mWaitToDecodeImageTaskRecord)
    {
      mWaitToDecodeImageTaskRecord.put(Integer.valueOf(paramDecodeImageTask.getImageKey().hashCodeEx()), paramDecodeImageTask);
      return;
    }
  }
  
  public void cancelDownload(String paramString)
  {
    DownloadImageTask.getDownloader().cancel(paramString);
  }
  
  public boolean hasWaitToDecodeImageTask(int paramInt)
  {
    if (ImageTaskTracer.OPEN_GET_IMAGE_SUCCESS_RECORDER)
    {
      ConcurrentHashMap localConcurrentHashMap = mWaitToDecodeImageTaskRecord;
      if (localConcurrentHashMap != null) {
        return localConcurrentHashMap.containsKey(Integer.valueOf(paramInt));
      }
    }
    return false;
  }
  
  public void resumeDecodeImageTask()
  {
    synchronized (mWaitToDecodeImageTaskRecord)
    {
      Object localObject1 = mWaitToDecodeImageTaskRecord.keySet();
      if (localObject1 != null)
      {
        localObject1 = ((Set)localObject1).iterator();
        if (localObject1 != null) {
          while (((Iterator)localObject1).hasNext())
          {
            int i = ((Integer)((Iterator)localObject1).next()).intValue();
            DecodeImageTask localDecodeImageTask = (DecodeImageTask)mWaitToDecodeImageTaskRecord.get(Integer.valueOf(i));
            if (localDecodeImageTask != null) {
              localDecodeImageTask.startDecodeTask();
            }
          }
        }
      }
      mWaitToDecodeImageTaskRecord.clear();
      return;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.component.media.image.ImageTaskManager
 * JD-Core Version:    0.7.0.1
 */