package com.tencent.biz.richframework.network.cache;

import com.tencent.common.app.BaseApplicationImpl;
import java.io.File;
import ykq;

public class CacheHelper
{
  private static final String TAG = CacheHelper.class.getName();
  private static String mAppCacheDir;
  private static volatile Cache mFileCache;
  private static String mPackgeName;
  
  public static Cache fileCache()
  {
    if (mFileCache == null) {}
    try
    {
      if (mFileCache == null)
      {
        if (mPackgeName == null) {
          mPackgeName = BaseApplicationImpl.getApplication().getPackageName();
        }
        if (mAppCacheDir == null) {
          mAppCacheDir = BaseApplicationImpl.getApplication().getCacheDir().getAbsolutePath();
        }
        mFileCache = new DiskCache(mPackgeName, mAppCacheDir);
      }
      ykq.b(TAG, "init FileCache");
      return mFileCache;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.richframework.network.cache.CacheHelper
 * JD-Core Version:    0.7.0.1
 */