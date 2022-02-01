package com.bumptech.glide.load.engine.cache;

import android.content.Context;
import java.io.File;

class ExternalCacheDiskCacheFactory$1
  implements DiskLruCacheFactory.CacheDirectoryGetter
{
  public File a()
  {
    File localFile = this.a.getExternalCacheDir();
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
 * Qualified Name:     com.bumptech.glide.load.engine.cache.ExternalCacheDiskCacheFactory.1
 * JD-Core Version:    0.7.0.1
 */