package com.tencent.biz.pubaccount.util;

import ajsd;
import android.support.v4.util.MQLruCache;
import java.io.File;

class PreloadManager$1
  extends Thread
{
  PreloadManager$1(PreloadManager paramPreloadManager) {}
  
  public void run()
  {
    int j = 0;
    if (PreloadManager.a(this.this$0) != null) {
      PreloadManager.a(this.this$0).releaseLargeCache();
    }
    long l = System.currentTimeMillis();
    Object localObject1 = new File(ajsd.cG);
    int k;
    int i;
    Object localObject2;
    if ((((File)localObject1).exists()) && (((File)localObject1).isDirectory()))
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
    localObject1 = new File(ajsd.cH);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.PreloadManager.1
 * JD-Core Version:    0.7.0.1
 */