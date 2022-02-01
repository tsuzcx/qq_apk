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
    if (!TextUtils.isEmpty(paramString))
    {
      this.mContext = paramContext.getApplicationContext();
      paramContext = new StringBuilder();
      paramContext.append("file");
      paramContext.append(File.separator);
      paramContext.append(paramString);
      this.mName = paramContext.toString();
      this.mPersist = paramBoolean;
      int i = paramInt2;
      if (paramInt2 < 0) {
        i = 0;
      }
      if (paramInt1 <= 0) {
        paramInt1 = 2147483647;
      }
      this.mExternalCache = new FileCache(paramInt1);
      this.mInternalCache = new FileCache(i);
      init();
      return;
    }
    throw new NullPointerException("file cache: name can NOT be empty!");
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
    try
    {
      str = getDir(paramBoolean);
      localFileCache = getCache(paramBoolean);
      paramBoolean = TextUtils.isEmpty(str);
      if (paramBoolean) {
        return;
      }
      String[] arrayOfString = new File(str).list();
      if ((arrayOfString == null) || (arrayOfString.length == 0)) {
        break label163;
      }
      arrayOfFileEntry = new FileCacheService.FileEntry[arrayOfString.length];
      int j = 0;
      i = 0;
      while (i < arrayOfFileEntry.length)
      {
        arrayOfFileEntry[i] = new FileCacheService.FileEntry(str, arrayOfString[i]);
        i += 1;
      }
      Arrays.sort(arrayOfFileEntry, sFileComparator);
      k = arrayOfFileEntry.length;
      i = j;
    }
    finally
    {
      for (;;)
      {
        String str;
        FileCache localFileCache;
        FileCacheService.FileEntry[] arrayOfFileEntry;
        int i;
        int k;
        for (;;)
        {
          label163:
          throw localObject;
        }
        label179:
        if (i < k)
        {
          str = arrayOfFileEntry[i];
          if (str != null) {}
        }
      }
    }
    if (!str.isFile) {
      FileUtils.delete(str.path);
    } else {
      localFileCache.put(str.name, str.path);
    }
    i += 1;
    break label179;
    return;
  }
  
  private void ensureStorage(boolean paramBoolean)
  {
    if (this.mStorageCounter.getAndIncrement() < 3) {
      return;
    }
    this.mStorageCounter.set(0);
    for (Object localObject = new File(getDir(paramBoolean)); !((File)localObject).exists(); localObject = ((File)localObject).getParentFile()) {}
    localObject = new StatFs(((File)localObject).getAbsolutePath());
    long l1 = ((StatFs)localObject).getBlockCount();
    long l2 = ((StatFs)localObject).getBlockSize();
    long l3 = ((StatFs)localObject).getAvailableBlocks() * ((StatFs)localObject).getBlockSize();
    localObject = this.mStorageHandler;
    if ((l3 < 10485760L) && (localObject != null)) {
      ((FileCacheService.StorageHandler)localObject).onLowStorage(this, l1 * l2, l3, paramBoolean);
    }
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
    if (localObject == null) {
      return false;
    }
    localObject = new File((String)localObject);
    if (((File)localObject).isDirectory()) {
      FileUtils.delete((File)localObject);
    }
    if (!isFileValid((File)localObject)) {
      return false;
    }
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
    FileCache localFileCache;
    if (paramBoolean) {
      localFileCache = this.mExternalCache;
    } else {
      localFileCache = this.mInternalCache;
    }
    return localFileCache.maxSize();
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
    if (localObject1 == null) {
      localObject2 = null;
    } else {
      localObject2 = new File((String)localObject1);
    }
    localObject1 = localObject2;
    if (!isFileValid((File)localObject2))
    {
      localObject1 = localObject2;
      if (bool)
      {
        localObject1 = (String)getCache(false).get(paramString);
        if (localObject1 == null) {
          localObject1 = null;
        } else {
          localObject1 = new File((String)localObject1);
        }
      }
    }
    if ((paramBoolean) && (!isFileValid((File)localObject1)))
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
    else
    {
      localObject2 = localObject1;
    }
    if (isFileValid((File)localObject2)) {
      return localObject2;
    }
    return null;
  }
  
  public String getPath(String paramString)
  {
    return getPath(paramString, CacheManager.isExternalAvailable());
  }
  
  public String getPath(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    String str = getDir(paramBoolean);
    if (str == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public int getSize(boolean paramBoolean)
  {
    FileCache localFileCache;
    if (paramBoolean) {
      localFileCache = this.mExternalCache;
    } else {
      localFileCache = this.mInternalCache;
    }
    return localFileCache.size();
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
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    boolean bool3 = CacheManager.isExternalAvailable();
    boolean bool2 = putFile(paramString, bool3);
    boolean bool1 = bool2;
    if (!bool2)
    {
      bool1 = bool2;
      if (bool3) {
        bool1 = putFile(paramString, false);
      }
    }
    return bool1;
  }
  
  public void setStorageHandler(FileCacheService.StorageHandler paramStorageHandler)
  {
    this.mStorageHandler = paramStorageHandler;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AlbumUtil#");
    localStringBuilder.append(this.mName);
    localStringBuilder.append("#capacity=");
    localStringBuilder.append(getCapacity(true));
    localStringBuilder.append(",");
    localStringBuilder.append(getCapacity(false));
    localStringBuilder.append("#size=");
    localStringBuilder.append(getSize(true));
    localStringBuilder.append(",");
    localStringBuilder.append(getSize(false));
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.module.cache.file.FileCacheService
 * JD-Core Version:    0.7.0.1
 */