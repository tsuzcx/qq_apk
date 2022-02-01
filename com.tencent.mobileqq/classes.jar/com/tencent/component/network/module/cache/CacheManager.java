package com.tencent.component.network.module.cache;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.component.network.downloader.common.Utils;
import com.tencent.component.network.module.base.QDLog;
import com.tencent.component.network.module.cache.file.FileCacheService;
import com.tencent.component.network.module.cache.file.FileStorageHandler;
import com.tencent.component.network.utils.AssertUtil;
import com.tencent.component.network.utils.FileUtils;
import java.io.File;
import java.util.HashMap;

public class CacheManager
{
  public static final int AUDIO_EXTERNAL_CAPACITY = 100;
  public static final String AUDIO_FILE_CACHE_NAME = "audio";
  public static final int AUDIO_INTERNAL_CAPACITY = 100;
  private static final String BLOB_DIR = "blob";
  private static final boolean FILE_CLEAR_PERSIST = false;
  private static final int FILE_VERSION = 1;
  public static final int IMAGE_EXTERNAL_CAPACITY = 3000;
  public static final String IMAGE_FILE_CACHE_NAME = "image";
  public static final int IMAGE_INTERNAL_CAPACITY = 800;
  private static final String PREFERENCE_FILE = "_cache_file";
  private static final String PREFERENCE_FILE_VERSION = "_version";
  public static final int TMP_EXTERNAL_CAPACITY = 500;
  public static final String TMP_FILE_CACHE_NAME = "tmp";
  public static final int TMP_INTERNAL_CAPACITY = 200;
  private static final HashMap<String, FileCacheService> sFileCacheService = new HashMap();
  private static final FileStorageHandler sStorageHandler = new FileStorageHandler(new CacheManager.1());
  
  public static void clear(Context paramContext)
  {
    try
    {
      clear(paramContext, 0L);
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public static void clear(Context paramContext, long paramLong)
  {
    try
    {
      clearFiles(paramContext);
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  private static void clearFiles(Context paramContext)
  {
    String str1 = getExternalCacheDir(paramContext, false);
    if (str1 != null) {
      FileUtils.delete(str1, true);
    }
    String str2 = getExternalCacheDirExt(paramContext, false);
    if (str1 != null) {
      FileUtils.delete(str2, true);
    }
    paramContext = getInternalCacheDir(paramContext, false);
    if (paramContext != null) {
      FileUtils.delete(paramContext, true);
    }
  }
  
  public static String getExternalCacheDir(Context paramContext, String paramString, boolean paramBoolean)
  {
    String str = getExternalCacheDir(paramContext, paramBoolean);
    if (str == null) {
      paramContext = null;
    }
    do
    {
      return paramContext;
      paramContext = str;
    } while (TextUtils.isEmpty(paramString));
    paramContext = new File(str + File.separator + paramString);
    try
    {
      if (paramContext.isFile()) {
        FileUtils.delete(paramContext);
      }
      if (!paramContext.exists()) {
        paramContext.mkdirs();
      }
      return paramContext.getAbsolutePath();
    }
    finally {}
  }
  
  private static String getExternalCacheDir(Context paramContext, boolean paramBoolean)
  {
    if (!isExternalAvailable()) {}
    for (;;)
    {
      return null;
      if (!paramBoolean) {}
      for (paramContext = CacheManager.InnerEnvironment.getExternalCacheDir(paramContext, false); paramContext != null; paramContext = CacheManager.InnerEnvironment.getExternalFilesDir(paramContext, "cache", false)) {
        return paramContext.getAbsolutePath();
      }
    }
  }
  
  public static String getExternalCacheDirExt(Context paramContext, String paramString, boolean paramBoolean)
  {
    String str = getExternalCacheDirExt(paramContext, paramBoolean);
    if (str == null) {
      paramContext = null;
    }
    do
    {
      return paramContext;
      paramContext = str;
    } while (TextUtils.isEmpty(paramString));
    paramContext = new File(str + File.separator + paramString);
    try
    {
      if (paramContext.isFile()) {
        FileUtils.delete(paramContext);
      }
      if (!paramContext.exists()) {
        paramContext.mkdirs();
      }
      return paramContext.getAbsolutePath();
    }
    finally {}
  }
  
  private static String getExternalCacheDirExt(Context paramContext, boolean paramBoolean)
  {
    if (!isExternalAvailable()) {}
    for (;;)
    {
      return null;
      if (!paramBoolean) {}
      for (paramContext = CacheManager.InnerEnvironment.getExternalCacheDir(paramContext, true); paramContext != null; paramContext = CacheManager.InnerEnvironment.getExternalFilesDir(paramContext, "cache", true)) {
        return paramContext.getAbsolutePath();
      }
    }
  }
  
  public static FileCacheService getFileCacheService(Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    return getFileCacheService(paramContext, paramString, paramInt1, paramInt2, false);
  }
  
  public static FileCacheService getFileCacheService(Context paramContext, String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    for (boolean bool = true;; bool = false)
    {
      AssertUtil.assertTrue(bool);
      synchronized (sFileCacheService)
      {
        FileCacheService localFileCacheService2 = (FileCacheService)sFileCacheService.get(paramString);
        FileCacheService localFileCacheService1 = localFileCacheService2;
        if (localFileCacheService2 == null)
        {
          localFileCacheService1 = new FileCacheService(paramContext, paramString, paramInt1, paramInt2, paramBoolean);
          localFileCacheService1.setStorageHandler(sStorageHandler);
          sFileCacheService.put(paramString, localFileCacheService1);
        }
        return localFileCacheService1;
      }
    }
  }
  
  public static String getInternalCacheDir(Context paramContext, String paramString, boolean paramBoolean)
  {
    paramContext = getInternalCacheDir(paramContext, paramBoolean);
    if (TextUtils.isEmpty(paramString)) {
      return paramContext;
    }
    paramContext = new File(paramContext + File.separator + paramString);
    if (paramContext.isFile()) {
      FileUtils.delete(paramContext);
    }
    if (!paramContext.exists()) {
      paramContext.mkdirs();
    }
    return paramContext.getAbsolutePath();
  }
  
  public static String getInternalCacheDir(Context paramContext, boolean paramBoolean)
  {
    if (!paramBoolean) {
      return paramContext.getCacheDir().getAbsolutePath();
    }
    return paramContext.getFilesDir().getAbsolutePath() + File.separator + "cache";
  }
  
  public static FileCacheService getTmpFileCacheService(Context paramContext)
  {
    String str2 = "tmp";
    String str3 = Utils.getCurrentProcessName(paramContext);
    String str1 = str2;
    if (str3 != null)
    {
      str1 = str2;
      if (str3.contains(":"))
      {
        int i = str3.lastIndexOf(":");
        str1 = str2;
        if (i > 0) {
          str1 = "tmp" + "_" + str3.substring(i + 1);
        }
      }
    }
    return getFileCacheService(paramContext, str1, 500, 200);
  }
  
  public static FileCacheService getTmpFileCacheService(Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return getFileCacheService(paramContext, paramString, 500, 200);
  }
  
  public static boolean isExternalAvailable()
  {
    try
    {
      boolean bool = "mounted".equals(Environment.getExternalStorageState());
      return bool;
    }
    catch (Exception localException)
    {
      QDLog.e("CacheManager", "Downloader ", localException);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.component.network.module.cache.CacheManager
 * JD-Core Version:    0.7.0.1
 */