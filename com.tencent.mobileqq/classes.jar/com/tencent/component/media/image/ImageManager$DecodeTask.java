package com.tencent.component.media.image;

import com.tencent.component.media.utils.ImageManagerLog;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;

class ImageManager$DecodeTask
  implements Runnable
{
  private ImageKey key = null;
  
  public ImageManager$DecodeTask(ImageManager paramImageManager, ImageKey paramImageKey)
  {
    this.key = paramImageKey;
  }
  
  public void run()
  {
    try
    {
      ImageManager.access$800(this.this$0, this.key);
      if ((ImageManager.access$1000(this.this$0)) && (ImageManager.access$1100(this.this$0).containsKey(this.key.urlKey)))
      {
        File localFile = new File(this.key.filePath);
        if (localFile.exists())
        {
          boolean bool = localFile.delete();
          ImageManagerLog.d(ImageManager.TAG, "ImageManager.DecodeTask, delete nocache file is: " + bool + ", url=" + this.key.url + ", file length=" + localFile.length());
        }
      }
      this.key = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
        ImageManager.access$900(this.this$0).remove(Integer.valueOf(this.key.hashCodeEx()));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.component.media.image.ImageManager.DecodeTask
 * JD-Core Version:    0.7.0.1
 */