package com.tencent.biz.publicAccountImageCollection;

import alof;
import android.support.v4.util.MQLruCache;
import java.io.File;

class PublicAccountImageCollectionPreloadManager$6
  extends Thread
{
  PublicAccountImageCollectionPreloadManager$6(PublicAccountImageCollectionPreloadManager paramPublicAccountImageCollectionPreloadManager) {}
  
  public void run()
  {
    if (this.this$0.a != null) {
      this.this$0.a.releaseLargeCache();
    }
    long l = System.currentTimeMillis();
    Object localObject1 = new File(alof.cN);
    if ((((File)localObject1).exists()) && (((File)localObject1).isDirectory()))
    {
      localObject1 = ((File)localObject1).listFiles();
      int j = localObject1.length;
      int i = 0;
      while (i < j)
      {
        Object localObject2 = localObject1[i];
        if (l - localObject2.lastModified() > 172800000L) {
          localObject2.delete();
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionPreloadManager.6
 * JD-Core Version:    0.7.0.1
 */