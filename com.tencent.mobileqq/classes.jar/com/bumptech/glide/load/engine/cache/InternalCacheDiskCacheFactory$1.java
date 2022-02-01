package com.bumptech.glide.load.engine.cache;

import android.content.Context;
import java.io.File;

class InternalCacheDiskCacheFactory$1
  implements DiskLruCacheFactory.CacheDirectoryGetter
{
  InternalCacheDiskCacheFactory$1(Context paramContext, String paramString) {}
  
  public File a()
  {
    File localFile = this.a.getCacheDir();
    if (localFile == null) {
      return null;
    }
    String str = this.b;
    if (str != null) {
      return new File(localFile, str);
    }
    return localFile;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory.1
 * JD-Core Version:    0.7.0.1
 */