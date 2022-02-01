package com.tencent.component.network.module.cache.file;

import android.content.Context;
import android.os.Looper;
import android.os.StatFs;
import android.text.TextUtils;
import com.tencent.component.network.module.base.QDLog;
import com.tencent.component.network.module.cache.CacheManager;
import com.tencent.component.network.utils.FileUtils;
import com.tencent.component.network.utils.thread.PriorityThreadPool;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.atomic.AtomicInteger;

public class FileCacheService
{
  private static final String DIR_NAME = "file";
  private static final long MEGABYTES = 1048576L;
  private static final int STORAGE_CHECK_INTERVAL = 3;
  private static final long STORAGE_LOW_BOUNDS = 10485760L;
  private static Comparator<FileCacheService.FileEntry> sFileComparator = new FileCacheService.2();
  private final Context mContext;
  private final FileCache<String> mExternalCache;
  private final FileCache<String> mInternalCache;
  private final String mName;
  private final boolean mPersist;
  private AtomicInteger mStorageCounter = new AtomicInteger(0);
  private FileCacheService.StorageHandler mStorageHandler;
  
  public FileCacheService(Context paramContext, String paramString, int paramInt)
  {
    this(paramContext, paramString, paramInt, false);
  }
  
  public FileCacheService(Context paramContext, String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new NullPointerException("file cache: name can NOT be empty!");
    }
    this.mContext = paramContext.getApplicationContext();
    this.mName = ("file" + File.separator + paramString);
    this.mPersist = paramBoolean;
    int i = paramInt2;
    if (paramInt2 < 0) {
      i = 0;
    }
    if (paramInt1 > 0) {}
    for (;;)
    {
      this.mExternalCache = new FileCache(paramInt1);
      this.mInternalCache = new FileCache(i);
      init();
      return;
      paramInt1 = 2147483647;
    }
  }
  
  public FileCacheService(Context paramContext, String paramString, int paramInt, boolean paramBoolean)
  {
    this(paramContext, paramString, paramInt, 0, paramBoolean);
  }
  
  private File createFile(String paramString, boolean paramBoolean)
  {
    paramString = getPath(paramString, paramBoolean);
    if (paramString == null) {
      return null;
    }
    paramString = new File(paramString);
    if (!isFileValid(paramString)) {
      FileUtils.delete(paramString);
    }
    try
    {
      paramString.createNewFile();
      return paramString;
    }
    catch (IOException localIOException)
    {
      QDLog.e("FileCacheService", "", localIOException);
    }
    return paramString;
  }
  
  private void ensureCache(boolean paramBoolean)
  {
    int j = 0;
    label182:
    for (;;)
    {
      String str;
      FileCacheService.FileEntry[] arrayOfFileEntry;
      int i;
      int k;
      try
      {
        str = getDir(paramBoolean);
        FileCache localFileCache = getCache(paramBoolean);
        paramBoolean = TextUtils.isEmpty(str);
        if (paramBoolean) {
          return;
        }
        String[] arrayOfString = new File(str).list();
        if ((arrayOfString == null) || (arrayOfString.length == 0)) {
          continue;
        }
        arrayOfFileEntry = new FileCacheService.FileEntry[arrayOfString.length];
        i = 0;
        if (i < arrayOfFileEntry.length)
        {
          arrayOfFileEntry[i] = new FileCacheService.FileEntry(str, arrayOfString[i]);
          i += 1;
          continue;
        }
        Arrays.sort(arrayOfFileEntry, sFileComparator);
        k = arrayOfFileEntry.length;
        i = j;
      }
      finally {}
      if (!str.isFile) {
        FileUtils.delete(str.path);
      } else {
        localObject.put(str.name, str.path);
      }
      for (;;)
      {
        if (i >= k) {
          break label182;
        }
        str = arrayOfFileEntry[i];
        if (str != null) {
          break;
        }
        i += 1;
      }
    }
  }
  
  private void ensureStorage(boolean paramBoolean)
  {
    if (this.mStorageCounter.getAndIncrement() < 3) {}
    Object localObject;
    long l1;
    long l2;
    long l3;
    do
    {
      return;
      this.mStorageCounter.set(0);
      for (localObject = new File(getDir(paramBoolean)); !((File)localObject).exists(); localObject = ((File)localObject).getParentFile()) {}
      localObject = new StatFs(((File)localObject).getAbsolutePath());
      l1 = ((StatFs)localObject).getBlockCount();
      l2 = ((StatFs)localObject).getBlockSize();
      l3 = ((StatFs)localObject).getAvailableBlocks() * ((StatFs)localObject).getBlockSize();
      localObject = this.mStorageHandler;
    } while ((l3 >= 10485760L) || (localObject == null));
    ((FileCacheService.StorageHandler)localObject).onLowStorage(this, l1 * l2, l3, paramBoolean);
  }
  
  private FileCache<String> getCache(boolean paramBoolean)
  {
    if (paramBoolean) {
      return this.mExternalCache;
    }
    return this.mInternalCache;
  }
  
  private String getDir(boolean paramBoolean)
  {
    if (paramBoolean) {
      return CacheManager.getExternalCacheDir(this.mContext, this.mName, this.mPersist);
    }
    return CacheManager.getInternalCacheDir(this.mContext, this.mName, this.mPersist);
  }
  
  private void init()
  {
    if (isMainThread())
    {
      PriorityThreadPool.getDefault().submit(new FileCacheService.1(this));
      return;
    }
    ensureCache(false);
    ensureCache(true);
  }
  
  private static boolean isFileValid(File paramFile)
  {
    return (paramFile != null) && (paramFile.exists()) && (paramFile.isFile());
  }
  
  private boolean putFile(String paramString, boolean paramBoolean)
  {
    FileCache localFileCache = getCache(paramBoolean);
    Object localObject = getPath(paramString, paramBoolean);
    if (localObject == null) {}
    do
    {
      return false;
      localObject = new File((String)localObject);
      if (((File)localObject).isDirectory()) {
        FileUtils.delete((File)localObject);
      }
    } while (!isFileValid((File)localObject));
    localFileCache.put(paramString, ((File)localObject).getAbsolutePath());
    ensureStorage(paramBoolean);
    return true;
  }
  
  public void clear()
  {
    try
    {
      getCache(false).evictAll();
      getCache(true).evictAll();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void clear(boolean paramBoolean)
  {
    try
    {
      getCache(paramBoolean).evictAll();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void clear(boolean paramBoolean, int paramInt)
  {
    try
    {
      getCache(paramBoolean).trimToSize(paramInt);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void deleteFile(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    getCache(false).remove(paramString);
    getCache(true).remove(paramString);
    String str = getPath(paramString, false);
    paramString = getPath(paramString, true);
    FileUtils.delete(str);
    FileUtils.delete(paramString);
  }
  
  public int getCapacity(boolean paramBoolean)
  {
    if (paramBoolean) {
      return this.mExternalCache.maxSize();
    }
    return this.mInternalCache.maxSize();
  }
  
  public Context getContext()
  {
    return this.mContext;
  }
  
  public File getFile(String paramString)
  {
    return getFile(paramString, false);
  }
  
  public File getFile(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    boolean bool = CacheManager.isExternalAvailable();
    Object localObject1 = (String)getCache(bool).get(paramString);
    Object localObject2;
    if (localObject1 == null)
    {
      localObject2 = null;
      localObject1 = localObject2;
      if (!isFileValid((File)localObject2))
      {
        localObject1 = localObject2;
        if (bool)
        {
          localObject1 = (String)getCache(false).get(paramString);
          if (localObject1 != null) {
            break label172;
          }
          localObject1 = null;
        }
      }
      label77:
      localObject2 = localObject1;
      if (paramBoolean)
      {
        localObject2 = localObject1;
        if (!isFileValid((File)localObject1))
        {
          localObject2 = createFile(paramString, bool);
          localObject1 = localObject2;
          if (!isFileValid((File)localObject2)) {
            localObject1 = createFile(paramString, false);
          }
          localObject2 = localObject1;
          if (isFileValid((File)localObject1))
          {
            putFile(paramString);
            localObject2 = localObject1;
          }
        }
      }
      if (!isFileValid((File)localObject2)) {
        break label186;
      }
    }
    for (;;)
    {
      return localObject2;
      localObject2 = new File((String)localObject1);
      break;
      label172:
      localObject1 = new File((String)localObject1);
      break label77;
      label186:
      localObject2 = null;
    }
  }
  
  public String getPath(String paramString)
  {
    return getPath(paramString, CacheManager.isExternalAvailable());
  }
  
  public String getPath(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {}
    String str;
    do
    {
      return null;
      str = getDir(paramBoolean);
    } while (str == null);
    return str + File.separator + paramString;
  }
  
  public int getSize(boolean paramBoolean)
  {
    if (paramBoolean) {
      return this.mExternalCache.size();
    }
    return this.mInternalCache.size();
  }
  
  public boolean isMainThread()
  {
    return Looper.getMainLooper().getThread() == Thread.currentThread();
  }
  
  public boolean isPersist()
  {
    return this.mPersist;
  }
  
  public boolean putFile(String paramString)
  {
    boolean bool1;
    if (TextUtils.isEmpty(paramString)) {
      bool1 = false;
    }
    boolean bool3;
    do
    {
      boolean bool2;
      do
      {
        return bool1;
        bool3 = CacheManager.isExternalAvailable();
        bool2 = putFile(paramString, bool3);
        bool1 = bool2;
      } while (bool2);
      bool1 = bool2;
    } while (!bool3);
    return putFile(paramString, false);
  }
  
  public void setStorageHandler(FileCacheService.StorageHandler paramStorageHandler)
  {
    this.mStorageHandler = paramStorageHandler;
  }
  
  public String toString()
  {
    return "AlbumUtil#" + this.mName + "#capacity=" + getCapacity(true) + "," + getCapacity(false) + "#size=" + getSize(true) + "," + getSize(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.component.network.module.cache.file.FileCacheService
 * JD-Core Version:    0.7.0.1
 */