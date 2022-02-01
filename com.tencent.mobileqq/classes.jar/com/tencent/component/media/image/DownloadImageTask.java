package com.tencent.component.media.image;

import com.tencent.component.media.IDownloader;
import com.tencent.component.media.ImageManagerEnv;
import com.tencent.component.media.ImageManagerEnv.ImageDownloaderListener;
import com.tencent.component.media.utils.ImageManagerLog;
import com.tencent.sharpP.SharpPUtils;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;

public class DownloadImageTask
  extends ImageTask
{
  private static final String TAG = "DownloadImageTask";
  private static ImageManagerEnv.ImageDownloaderListener imageDownloaderListener;
  private static ConcurrentHashMap<String, DownloadImageTask> mDownloadTaskRecord;
  private static IDownloader mImageDownloader = null;
  private static int mObjectPoolSize;
  private static DownloadImageTask sPool;
  private static final Object sPoolSync;
  private DownloadImageTask next = null;
  
  static
  {
    mDownloadTaskRecord = new ConcurrentHashMap();
    imageDownloaderListener = new DownloadImageTask.1();
    initDownloader();
    sPool = null;
    sPoolSync = new Object();
    mObjectPoolSize = 0;
    clearAndInitSize();
  }
  
  private DownloadImageTask(ImageKey paramImageKey)
  {
    super(paramImageKey);
  }
  
  private DownloadImageTask(ImageTask paramImageTask)
  {
    super(paramImageTask);
  }
  
  public static void clearAndInitSize()
  {
    synchronized (sPoolSync)
    {
      sPool = null;
      int i = 0;
      while (i < mInitAllocatedSize)
      {
        DownloadImageTask localDownloadImageTask = new DownloadImageTask(null);
        localDownloadImageTask.next = sPool;
        sPool = localDownloadImageTask;
        mObjectPoolSize += 1;
        i += 1;
      }
      return;
    }
  }
  
  protected static IDownloader getDownloader()
  {
    return mImageDownloader;
  }
  
  private static void initDownloader()
  {
    mImageDownloader = ImageManagerEnv.g().getDownloader(imageDownloaderListener);
  }
  
  public static DownloadImageTask obtain(ImageKey paramImageKey)
  {
    if (needRecycle) {}
    synchronized (sPoolSync)
    {
      if (sPool != null)
      {
        DownloadImageTask localDownloadImageTask = sPool;
        sPool = sPool.next;
        localDownloadImageTask.next = null;
        mObjectPoolSize -= 1;
        localDownloadImageTask.setImageKey(paramImageKey);
        return localDownloadImageTask;
      }
      return new DownloadImageTask(paramImageKey);
    }
  }
  
  public static DownloadImageTask obtain(ImageTask paramImageTask)
  {
    if (needRecycle) {}
    synchronized (sPoolSync)
    {
      if (sPool != null)
      {
        DownloadImageTask localDownloadImageTask = sPool;
        sPool = sPool.next;
        localDownloadImageTask.next = null;
        mObjectPoolSize -= 1;
        localDownloadImageTask.setImageTask(paramImageTask);
        return localDownloadImageTask;
      }
      return new DownloadImageTask(paramImageTask);
    }
  }
  
  public void excuteTask()
  {
    Object localObject1 = ImageManager.getInstance().getDrawbleFromCache(this.mImageKey);
    if (localObject1 != null)
    {
      setResult(11, new Object[] { localObject1 });
      return;
    }
    ImageManager.getInstance().imageKeyFilePathCheck(this.mImageKey);
    localObject1 = new File(this.mImageKey.filePath);
    SharpPUtils.deleteSharppCacheFileIfNessary((File)localObject1, this.mImageKey.url);
    SharpPUtils.checkNotSharppCacheFileIfNessary((File)localObject1, this.mImageKey.url);
    if (((File)localObject1).exists())
    {
      setResult(12, new Object[0]);
      return;
    }
    boolean bool = ImageManager.getInstance().canDownloadImage(getImageKey());
    if (!bool)
    {
      if (this.mImageKey.options != null) {
        this.mImageKey.options.errCode = ImageManager.getErrorString(this.mImageKey, 801);
      }
      ImageManagerLog.e("DownloadImageTask", "image canDownload=" + bool + ", url=" + this.mImageKey.url);
      setResult(1, new Object[] { this.mImageKey.url });
      return;
    }
    if (this.mImageKey.isNetworkUrl)
    {
      if (this.mImageKey.options == null) {}
      for (bool = true;; bool = this.mImageKey.options.priority)
      {
        Object localObject2 = this.mImageKey.url;
        localObject1 = localObject2;
        if (ImageManagerEnv.g().enableSocketMonitor()) {
          localObject1 = ImageManagerEnv.g().getSocketMonitorUrl((String)localObject2, this.mImageKey.options);
        }
        localObject2 = localObject1;
        if (!ImageManagerEnv.g().isSupportSharpp())
        {
          localObject2 = SharpPUtils.getWebpUrl((String)localObject1);
          ImageManagerLog.w("DownloadImageTask", "sharpp is not support,transfer to webp url");
        }
        mDownloadTaskRecord.put(localObject2, this);
        ImageTaskTracer.addImageDownloadRecord(this.mImageKey.urlKey);
        ImageTracer.startDownlaod(this.mImageKey.url);
        ProgressTracer.print(1, this.mImageKey.urlKey);
        mImageDownloader.download((String)localObject2, this.mImageKey.filePath, bool);
        return;
      }
    }
    if ((ImageManagerEnv.g().needCheckAvatar()) && (this.mImageKey.isAvatarUrl()))
    {
      mDownloadTaskRecord.put(this.mImageKey.url, this);
      ImageTaskTracer.addImageDownloadRecord(this.mImageKey.urlKey);
      ProgressTracer.print(1, this.mImageKey.urlKey);
      mImageDownloader.download(this.mImageKey.url, "", false);
      return;
    }
    if (this.mNextTask != null)
    {
      this.mNextTask.excuteTask();
      return;
    }
    if (this.mImageKey.options != null) {
      this.mImageKey.options.errCode = ImageManager.getErrorString(this.mImageKey, 802);
    }
    setResult(1, new Object[] { this.mImageKey.url });
  }
  
  protected void onResult(int paramInt, Object... paramVarArgs) {}
  
  public void recycle()
  {
    if (!needRecycle) {
      return;
    }
    reset();
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.component.media.image.DownloadImageTask
 * JD-Core Version:    0.7.0.1
 */