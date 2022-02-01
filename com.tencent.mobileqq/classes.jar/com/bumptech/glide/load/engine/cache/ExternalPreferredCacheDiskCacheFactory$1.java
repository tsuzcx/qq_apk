package com.bumptech.glide.load.engine.cache;

import android.content.Context;
import android.support.annotation.Nullable;
import java.io.File;

class ExternalPreferredCacheDiskCacheFactory$1
  implements DiskLruCacheFactory.CacheDirectoryGetter
{
  @Nullable
  private File b()
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
  
  public File a()
  {
    Object localObject = b();
    if ((localObject != null) && (((File)localObject).exists())) {
      return localObject;
    }
    File localFile = this.a.getExternalCacheDir();
    if (localFile != null)
    {
      if (!localFile.canWrite()) {
        return localObject;
      }
      localObject = this.b;
      if (localObject != null) {
        return new File(localFile, (String)localObject);
      }
      return localFile;
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.engine.cache.ExternalPreferredCacheDiskCacheFactory.1
 * JD-Core Version:    0.7.0.1
 */