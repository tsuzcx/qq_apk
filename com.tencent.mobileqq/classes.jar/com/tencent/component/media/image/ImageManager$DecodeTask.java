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
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      ImageManager.access$900(this.this$0).remove(Integer.valueOf(this.key.hashCodeEx()));
    }
    if ((ImageManager.access$1000(this.this$0)) && (ImageManager.access$1100(this.this$0).containsKey(this.key.urlKey)))
    {
      File localFile = new File(this.key.filePath);
      if (localFile.exists())
      {
        boolean bool = localFile.delete();
        String str = ImageManager.TAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("ImageManager.DecodeTask, delete nocache file is: ");
        localStringBuilder.append(bool);
        localStringBuilder.append(", url=");
        localStringBuilder.append(this.key.url);
        localStringBuilder.append(", file length=");
        localStringBuilder.append(localFile.length());
        ImageManagerLog.d(str, localStringBuilder.toString());
      }
    }
    this.key = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.image.ImageManager.DecodeTask
 * JD-Core Version:    0.7.0.1
 */