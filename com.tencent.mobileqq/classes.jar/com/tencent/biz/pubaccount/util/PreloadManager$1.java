package com.tencent.biz.pubaccount.util;

import android.support.v4.util.MQLruCache;
import com.tencent.mobileqq.app.AppConstants;
import java.io.File;

class PreloadManager$1
  extends Thread
{
  PreloadManager$1(PreloadManager paramPreloadManager) {}
  
  public void run()
  {
    if (PreloadManager.a(this.this$0) != null) {
      PreloadManager.a(this.this$0).releaseLargeCache();
    }
    long l = System.currentTimeMillis();
    Object localObject1 = new File(AppConstants.SDCARD_PATH_PUBLIC_ACCOUNT_PRELOAD);
    boolean bool = ((File)localObject1).exists();
    int j = 0;
    int k;
    int i;
    Object localObject2;
    if ((bool) && (((File)localObject1).isDirectory()))
    {
      localObject1 = ((File)localObject1).listFiles();
      k = localObject1.length;
      i = 0;
      while (i < k)
      {
        localObject2 = localObject1[i];
        if (l - localObject2.lastModified() > 172800000L) {
          localObject2.delete();
        }
        i += 1;
      }
    }
    localObject1 = new File(AppConstants.SDCARD_PATH_PUBLIC_ACCOUNT_PRELOAD_IMAGE);
    if ((((File)localObject1).exists()) && (((File)localObject1).isDirectory()))
    {
      localObject1 = ((File)localObject1).listFiles();
      k = localObject1.length;
      i = j;
      while (i < k)
      {
        localObject2 = localObject1[i];
        if (l - localObject2.lastModified() > 172800000L) {
          localObject2.delete();
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.PreloadManager.1
 * JD-Core Version:    0.7.0.1
 */