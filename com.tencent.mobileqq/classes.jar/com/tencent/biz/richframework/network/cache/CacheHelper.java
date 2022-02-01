package com.tencent.biz.richframework.network.cache;

import android.content.Context;
import com.tencent.biz.richframework.delegate.impl.RFApplication;
import com.tencent.biz.richframework.delegate.impl.RFLog;
import java.io.File;

public class CacheHelper
{
  private static final String TAG = CacheHelper.class.getName();
  private static String mAppCacheDir = null;
  private static volatile Cache mFileCache = null;
  private static String mPackgeName = null;
  
  public static Cache fileCache()
  {
    if (mFileCache == null) {}
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
      return mFileCache;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.richframework.network.cache.CacheHelper
 * JD-Core Version:    0.7.0.1
 */