package com.nostra13.universalimageloader.core;

import com.nostra13.universalimageloader.cache.disc.DiskCache;
import java.io.File;
import java.util.concurrent.Executor;

class ImageLoaderEngine$1
  implements Runnable
{
  ImageLoaderEngine$1(ImageLoaderEngine paramImageLoaderEngine, LoadAndDisplayImageTask paramLoadAndDisplayImageTask) {}
  
  public void run()
  {
    File localFile = this.this$0.configuration.diskCache.get(this.val$task.getLoadingUri());
    if ((localFile != null) && (localFile.exists())) {}
    for (int i = 1;; i = 0)
    {
      ImageLoaderEngine.access$000(this.this$0);
      if (i == 0) {
        break;
      }
      ImageLoaderEngine.access$100(this.this$0).execute(this.val$task);
      return;
    }
    ImageLoaderEngine.access$200(this.this$0).execute(this.val$task);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.nostra13.universalimageloader.core.ImageLoaderEngine.1
 * JD-Core Version:    0.7.0.1
 */