package com.tencent.component.media.image;

import com.tencent.component.media.IDownloader;
import com.tencent.component.media.ImageManagerEnv;
import com.tencent.component.media.ImageManagerEnv.ImageDownloaderListener;
import com.tencent.component.media.utils.ImageManagerLog;
import com.tencent.sharpP.SharpPUtils;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;
import plc;
import plz;

public class DownloadImageTask
  extends plz
{
  private static int jdField_a_of_type_Int;
  private static IDownloader jdField_a_of_type_ComTencentComponentMediaIDownloader = null;
  private static ImageManagerEnv.ImageDownloaderListener jdField_a_of_type_ComTencentComponentMediaImageManagerEnv$ImageDownloaderListener;
  private static DownloadImageTask jdField_a_of_type_ComTencentComponentMediaImageDownloadImageTask;
  private static final Object jdField_a_of_type_JavaLangObject;
  private static ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private DownloadImageTask b = null;
  
  static
  {
    jdField_a_of_type_ComTencentComponentMediaImageManagerEnv$ImageDownloaderListener = new plc();
    a();
    jdField_a_of_type_ComTencentComponentMediaImageDownloadImageTask = null;
    jdField_a_of_type_JavaLangObject = new Object();
    jdField_a_of_type_Int = 0;
    clearAndInitSize();
  }
  
  private DownloadImageTask(ImageKey paramImageKey)
  {
    super(paramImageKey);
  }
  
  private DownloadImageTask(plz paramplz)
  {
    super(paramplz);
  }
  
  private static void a()
  {
    jdField_a_of_type_ComTencentComponentMediaIDownloader = ImageManagerEnv.g().getDownloader(jdField_a_of_type_ComTencentComponentMediaImageManagerEnv$ImageDownloaderListener);
  }
  
  public static void clearAndInitSize()
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      jdField_a_of_type_ComTencentComponentMediaImageDownloadImageTask = null;
      int i = 0;
      while (i < mInitAllocatedSize)
      {
        DownloadImageTask localDownloadImageTask = new DownloadImageTask(null);
        localDownloadImageTask.b = jdField_a_of_type_ComTencentComponentMediaImageDownloadImageTask;
        jdField_a_of_type_ComTencentComponentMediaImageDownloadImageTask = localDownloadImageTask;
        jdField_a_of_type_Int += 1;
        i += 1;
      }
      return;
    }
  }
  
  public static IDownloader getDownloader()
  {
    return jdField_a_of_type_ComTencentComponentMediaIDownloader;
  }
  
  public static DownloadImageTask obtain(ImageKey paramImageKey)
  {
    if (needRecycle) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_ComTencentComponentMediaImageDownloadImageTask != null)
      {
        DownloadImageTask localDownloadImageTask = jdField_a_of_type_ComTencentComponentMediaImageDownloadImageTask;
        jdField_a_of_type_ComTencentComponentMediaImageDownloadImageTask = jdField_a_of_type_ComTencentComponentMediaImageDownloadImageTask.b;
        localDownloadImageTask.b = null;
        jdField_a_of_type_Int -= 1;
        localDownloadImageTask.setImageKey(paramImageKey);
        return localDownloadImageTask;
      }
      return new DownloadImageTask(paramImageKey);
    }
  }
  
  public static DownloadImageTask obtain(plz paramplz)
  {
    if (needRecycle) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_ComTencentComponentMediaImageDownloadImageTask != null)
      {
        DownloadImageTask localDownloadImageTask = jdField_a_of_type_ComTencentComponentMediaImageDownloadImageTask;
        jdField_a_of_type_ComTencentComponentMediaImageDownloadImageTask = jdField_a_of_type_ComTencentComponentMediaImageDownloadImageTask.b;
        localDownloadImageTask.b = null;
        jdField_a_of_type_Int -= 1;
        localDownloadImageTask.setImageTask(paramplz);
        return localDownloadImageTask;
      }
      return new DownloadImageTask(paramplz);
    }
  }
  
  public void excuteTask()
  {
    Object localObject1 = ImageManager.getInstance().a(this.mImageKey);
    if (localObject1 != null)
    {
      setResult(11, new Object[] { localObject1 });
      return;
    }
    ImageManager.getInstance().c(this.mImageKey);
    localObject1 = new File(this.mImageKey.filePath);
    SharpPUtils.a((File)localObject1, this.mImageKey.url);
    if (((File)localObject1).exists())
    {
      setResult(12, new Object[0]);
      return;
    }
    boolean bool = ImageManager.getInstance().a(getImageKey());
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
          localObject2 = SharpPUtils.a((String)localObject1);
          ImageManagerLog.w("DownloadImageTask", "sharpp is not support,transfer to webp url");
        }
        jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localObject2, this);
        ImageTaskTracer.addImageDownloadRecord(this.mImageKey.urlKey);
        ImageTracer.startDownlaod(this.mImageKey.url);
        ProgressTracer.print(1, this.mImageKey.urlKey);
        jdField_a_of_type_ComTencentComponentMediaIDownloader.download((String)localObject2, this.mImageKey.filePath, bool);
        return;
      }
    }
    if ((ImageManagerEnv.g().needCheckAvatar()) && (this.mImageKey.isAvatarUrl()))
    {
      jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(this.mImageKey.url, this);
      ImageTaskTracer.addImageDownloadRecord(this.mImageKey.urlKey);
      ProgressTracer.print(1, this.mImageKey.urlKey);
      jdField_a_of_type_ComTencentComponentMediaIDownloader.download(this.mImageKey.url, "", false);
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
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_Int < 50)
      {
        this.b = jdField_a_of_type_ComTencentComponentMediaImageDownloadImageTask;
        jdField_a_of_type_ComTencentComponentMediaImageDownloadImageTask = this;
        jdField_a_of_type_Int += 1;
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.image.DownloadImageTask
 * JD-Core Version:    0.7.0.1
 */