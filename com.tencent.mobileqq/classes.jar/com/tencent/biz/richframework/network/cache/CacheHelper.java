package com.tencent.biz.richframework.network.cache;

import android.content.Context;
import com.tencent.biz.richframework.delegate.impl.RFApplication;
import com.tencent.biz.richframework.delegate.impl.RFLog;
import java.io.File;

public class CacheHelper
{
  private static final String TAG = "com.tencent.biz.richframework.network.cache.CacheHelper";
  private static String mAppCacheDir;
  private static volatile Cache mFileCache;
  private static String mPackgeName;
  
  public static Cache fileCache()
  {
    if (mFileCache == null) {
      try
      {
        if (mFileCache == null)
        {
          if (mPackgeName == null) {
            mPackgeName = RFApplication.getApplication().getPackageName();
          }
          if (mAppCacheDir == null) {
            mAppCacheDir = RFApplication.getApplication().getCacheDir().getAbsolutePath();
          }
          mFileCache = new DiskCache(mPackgeName, mAppCacheDir);
        }
        RFLog.d(TAG, RFLog.DEV, "init FileCache");
      }
      finally {}
    }
    return mFileCache;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.richframework.network.cache.CacheHelper
 * JD-Core Version:    0.7.0.1
 */