package com.tencent.biz.richframework.network.cache;

import com.jakewharton.disklrucache.DiskLruCache;
import com.jakewharton.disklrucache.DiskLruCache.Editor;
import com.jakewharton.disklrucache.DiskLruCache.Snapshot;
import com.tencent.biz.richframework.delegate.impl.RFLog;
import com.tencent.biz.richframework.network.util.Encrypt;
import com.tencent.biz.richframework.network.util.SdCardUtil;
import com.tencent.biz.richframework.network.util.StringUtils;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

public abstract class LruCache
  extends Cache
{
  protected static long CacheSize = 15728640L;
  protected static final int DISK_CACHE_INDEX = 0;
  private static final long INTERNAL_FILE_CACHE_SIZE = 15728640L;
  protected static int IO_BUFFER_SIZE = 8192;
  private static final String TAG = "LruCache";
  private static String mAppCacheDir;
  private static String mPackgeName;
  private String mCurrentCacheName = "";
  protected DiskLruCache mDiskLruCache = null;
  private boolean mIsWriting = false;
  private Object mWriteLock = new Object();
  
  public LruCache(String paramString1, String paramString2)
  {
    mPackgeName = paramString1;
    mAppCacheDir = paramString2;
    initDiskCache();
  }
  
  private int getInstanceHashCode()
  {
    if (getInstance() == null) {
      return 0;
    }
    return getInstance().hashCode();
  }
  
  private void initDiskCache()
  {
    try
    {
      if ((getInstance() == null) || (getInstance().isClosed()))
      {
        if (!SdCardUtil.sdCardExists()) {
          CacheSize = 15728640L;
        }
        String str = getCacheDir();
        File localFile = new File(str);
        int i;
        StringBuilder localStringBuilder;
        if (!localFile.exists())
        {
          i = RFLog.DEV;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("Dir: \"");
          localStringBuilder.append(str);
          localStringBuilder.append("\" not exists, create dir. cache size: ");
          localStringBuilder.append(StringUtils.formatSize(CacheSize));
          RFLog.w("LruCache", i, localStringBuilder.toString());
          localFile.mkdirs();
        }
        else
        {
          i = RFLog.DEV;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("Dir: \"");
          localStringBuilder.append(str);
          localStringBuilder.append("\" exists. cache size: ");
          localStringBuilder.append(StringUtils.formatSize(CacheSize));
          RFLog.d("LruCache", i, localStringBuilder.toString());
        }
        open(localFile);
      }
      return;
    }
    finally {}
  }
  
  public boolean cacheExists(String paramString)
  {
    initDiskCache();
    Object localObject1 = getInstance();
    boolean bool4 = false;
    boolean bool2 = false;
    boolean bool5 = false;
    boolean bool6 = false;
    boolean bool3 = false;
    boolean bool1;
    if (localObject1 != null)
    {
      bool2 = bool5;
      bool1 = bool6;
    }
    try
    {
      String str = getCacheName(paramString);
      bool2 = bool5;
      bool1 = bool6;
      localObject1 = this.mDiskLruCache;
      bool2 = bool5;
      bool1 = bool6;
      bool1 = bool4;
      try
      {
        Object localObject3 = getInstance().get(str);
        if (localObject3 != null)
        {
          bool1 = bool4;
          ((DiskLruCache.Snapshot)localObject3).close();
          bool2 = true;
        }
        else
        {
          bool1 = bool4;
          i = RFLog.DEV;
          bool1 = bool4;
          localObject3 = new StringBuilder();
          bool1 = bool4;
          ((StringBuilder)localObject3).append("check cache exists error: snapshot is null. Cache name: ");
          bool1 = bool4;
          ((StringBuilder)localObject3).append(str);
          bool1 = bool4;
          ((StringBuilder)localObject3).append(", Url: ");
          bool1 = bool4;
          ((StringBuilder)localObject3).append(paramString);
          bool1 = bool4;
          RFLog.w("LruCache", i, ((StringBuilder)localObject3).toString());
          bool2 = bool3;
        }
        bool1 = bool2;
        return bool2;
      }
      finally
      {
        bool2 = bool1;
      }
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      int i;
      break label241;
    }
    catch (IOException localIOException)
    {
      label200:
      break label200;
    }
    i = RFLog.DEV;
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("check cache exists IO error: ");
    ((StringBuilder)localObject1).append(paramString);
    RFLog.w("LruCache", i, ((StringBuilder)localObject1).toString());
    return bool1;
    label241:
    i = RFLog.DEV;
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("check cache exists error: ");
    ((StringBuilder)localObject1).append(paramString);
    RFLog.w("LruCache", i, ((StringBuilder)localObject1).toString());
    return bool2;
  }
  
  public void clear()
  {
    initDiskCache();
    try
    {
      synchronized (this.mDiskLruCache)
      {
        getInstance().delete();
        return;
      }
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
  }
  
  public String get(String paramString)
  {
    initDiskCache();
    Object localObject = getInstance();
    String str1 = "";
    String str2 = str1;
    String str3;
    if (localObject != null)
    {
      try
      {
        paramString = getCacheName(paramString);
        localObject = getInstance().get(paramString);
        str2 = str1;
        if (localObject == null) {
          return ???;
        }
        paramString = Encrypt.decrypt(((DiskLruCache.Snapshot)localObject).getString(0));
        try
        {
          ((DiskLruCache.Snapshot)localObject).close();
          return paramString;
        }
        catch (IOException localIOException)
        {
          str1 = paramString;
          paramString = localIOException;
        }
        catch (NumberFormatException localNumberFormatException)
        {
          str1 = paramString;
          paramString = localNumberFormatException;
        }
        paramString.printStackTrace();
      }
      catch (IOException paramString)
      {
        paramString.printStackTrace();
        return str1;
      }
      catch (NumberFormatException paramString) {}
      str3 = str1;
    }
    return str3;
  }
  
  public String getCacheDir()
  {
    Object localObject;
    if (SdCardUtil.sdCardExists())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(SdCardUtil.getSdCardDirectory());
      ((StringBuilder)localObject).append(File.separator);
      ((StringBuilder)localObject).append("Android");
      ((StringBuilder)localObject).append(File.separator);
      ((StringBuilder)localObject).append("data");
      ((StringBuilder)localObject).append(File.separator);
      ((StringBuilder)localObject).append(mPackgeName);
      ((StringBuilder)localObject).append(File.separator);
      ((StringBuilder)localObject).append("cache");
      ((StringBuilder)localObject).append(File.separator);
      ((StringBuilder)localObject).append(getCacheTag());
      localObject = ((StringBuilder)localObject).toString();
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(mAppCacheDir);
      ((StringBuilder)localObject).append(File.separator);
      ((StringBuilder)localObject).append("cache");
      ((StringBuilder)localObject).append(File.separator);
      ((StringBuilder)localObject).append(getCacheTag());
      localObject = ((StringBuilder)localObject).toString();
    }
    int i = RFLog.DEV;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Init cache dir: ");
    localStringBuilder.append((String)localObject);
    RFLog.d("LruCache", i, localStringBuilder.toString());
    return localObject;
  }
  
  protected abstract String getCacheTag();
  
  protected DiskLruCache getInstance()
  {
    return this.mDiskLruCache;
  }
  
  public Cache.CacheInputStream getStream(String paramString)
  {
    initDiskCache();
    Cache.CacheInputStream localCacheInputStream = new Cache.CacheInputStream(this);
    String str = getCacheName(paramString);
    if ((getInstance() != null) && (str != null)) {
      localObject1 = null;
    }
    try
    {
      localObject2 = getInstance().get(str);
      localObject1 = localObject2;
    }
    catch (IOException localIOException)
    {
      Object localObject2;
      label52:
      int i;
      break label52;
    }
    i = RFLog.DEV;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("Get cache error: Cache name: ");
    ((StringBuilder)localObject2).append(str);
    ((StringBuilder)localObject2).append(", Url: ");
    ((StringBuilder)localObject2).append(paramString);
    RFLog.w("LruCache", i, ((StringBuilder)localObject2).toString());
    if (localObject1 != null)
    {
      localCacheInputStream.setSnapshot((DiskLruCache.Snapshot)localObject1);
      localCacheInputStream.setInputStream(((DiskLruCache.Snapshot)localObject1).getInputStream(0));
      if (localCacheInputStream.getInputStream() == null)
      {
        i = RFLog.DEV;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("Get cache error: InputStream is null. Cache name: ");
        ((StringBuilder)localObject1).append(str);
        ((StringBuilder)localObject1).append(", Url: ");
        ((StringBuilder)localObject1).append(paramString);
        RFLog.w("LruCache", i, ((StringBuilder)localObject1).toString());
        return localCacheInputStream;
      }
      i = RFLog.DEV;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Get cache success: Cache name: ");
      ((StringBuilder)localObject1).append(str);
      ((StringBuilder)localObject1).append(", Url: ");
      ((StringBuilder)localObject1).append(paramString);
      RFLog.i("LruCache", i, ((StringBuilder)localObject1).toString());
      return localCacheInputStream;
    }
    i = RFLog.DEV;
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("Get cache error: snapshot is null. Cache name: ");
    ((StringBuilder)localObject1).append(str);
    ((StringBuilder)localObject1).append(", Url: ");
    ((StringBuilder)localObject1).append(paramString);
    ((StringBuilder)localObject1).append(",instance hashCode:");
    ((StringBuilder)localObject1).append(getInstanceHashCode());
    RFLog.w("LruCache", i, ((StringBuilder)localObject1).toString());
    return localCacheInputStream;
    i = RFLog.DEV;
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("Get cache error: DiskCache or cacheName is null. Cache name: ");
    ((StringBuilder)localObject1).append(str);
    ((StringBuilder)localObject1).append(", Url: ");
    ((StringBuilder)localObject1).append(paramString);
    RFLog.w("LruCache", i, ((StringBuilder)localObject1).toString());
    return localCacheInputStream;
  }
  
  public void interrupt(String paramString)
  {
    synchronized (this.mWriteLock)
    {
      if ((this.mCurrentCacheName.equals(paramString)) && (this.mIsWriting)) {
        this.mIsWriting = false;
      }
      return;
    }
  }
  
  protected boolean open(File paramFile)
  {
    RFLog.d("LruCache", RFLog.DEV, "Open cache dir.");
    try
    {
      this.mDiskLruCache = DiskLruCache.open(paramFile, 1, 1, CacheSize);
    }
    catch (IOException paramFile)
    {
      paramFile.printStackTrace();
    }
    return false;
  }
  
  public void remove(String paramString)
  {
    initDiskCache();
    try
    {
      synchronized (this.mDiskLruCache)
      {
        getInstance().remove(getCacheName(paramString));
        return;
      }
      return;
    }
    catch (NullPointerException paramString)
    {
      paramString.printStackTrace();
      return;
    }
    catch (IOException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public boolean set(String paramString1, String paramString2)
  {
    initDiskCache();
    String str = getCacheName(paramString1);
    Object localObject1 = getInstance();
    boolean bool2 = false;
    DiskLruCache localDiskLruCache;
    if ((localObject1 != null) && (str != null))
    {
      localDiskLruCache = this.mDiskLruCache;
      localObject1 = null;
    }
    try
    {
      try
      {
        localObject2 = getInstance().edit(str);
        localObject1 = localObject2;
      }
      finally
      {
        break label209;
      }
    }
    catch (IOException localIOException)
    {
      Object localObject2;
      label64:
      boolean bool1;
      int i;
      break label64;
    }
    RFLog.w("LruCache", RFLog.DEV, "Set cache error: Exception ");
    bool1 = bool2;
    if (localObject1 != null)
    {
      i = RFLog.DEV;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("name: ");
      ((StringBuilder)localObject2).append(paramString1);
      ((StringBuilder)localObject2).append(", Cache name: ");
      ((StringBuilder)localObject2).append(str);
      ((StringBuilder)localObject2).append(", value length: ");
      ((StringBuilder)localObject2).append(paramString2.length());
      RFLog.i("LruCache", i, ((StringBuilder)localObject2).toString());
    }
    try
    {
      ((DiskLruCache.Editor)localObject1).set(0, Encrypt.encrypt(paramString2));
      ((DiskLruCache.Editor)localObject1).commit();
      bool1 = true;
    }
    catch (IOException paramString1)
    {
      label181:
      break label181;
    }
    RFLog.w("LruCache", RFLog.DEV, "Commit cache error: Exception ");
    bool1 = bool2;
    this.mDiskLruCache.notifyAll();
    return bool1;
    label209:
    throw paramString1;
    return false;
  }
  
  public boolean setStream(String arg1, InputStream paramInputStream)
  {
    localObject1 = this.mWriteLock;
    bool1 = true;
    try
    {
      this.mIsWriting = true;
      this.mCurrentCacheName = ???;
      initDiskCache();
      str = getCacheName(???);
      if ((getInstance() != null) && (str != null) && (paramInputStream != null))
      {
        localDiskLruCache = this.mDiskLruCache;
        localStringBuilder = null;
        localObject1 = null;
      }
    }
    finally
    {
      String str;
      DiskLruCache localDiskLruCache;
      DiskLruCache.Editor localEditor;
      label85:
      int i;
      Object localObject2;
      for (;;)
      {
        throw ???;
      }
    }
    try
    {
      try
      {
        localEditor = getInstance().edit(str);
      }
      finally
      {
        break label614;
      }
    }
    catch (IOException localIOException)
    {
      break label85;
    }
    i = RFLog.DEV;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("Edit diskcache cache error. Cache name: ");
    ((StringBuilder)localObject2).append(str);
    ((StringBuilder)localObject2).append(", Uri: ");
    ((StringBuilder)localObject2).append(???);
    RFLog.w("LruCache", i, ((StringBuilder)localObject2).toString());
    localEditor = null;
    if (localEditor != null) {}
    try
    {
      label300:
      try
      {
        localObject2 = new BufferedOutputStream(localEditor.newOutputStream(0), IO_BUFFER_SIZE);
      }
      finally
      {
        label175:
        localObject2 = localObject1;
      }
    }
    catch (IOException paramInputStream)
    {
      for (;;)
      {
        boolean bool2;
        paramInputStream = localStringBuilder;
      }
    }
    try
    {
      try
      {
        localObject1 = new byte[IO_BUFFER_SIZE];
        i = paramInputStream.read((byte[])localObject1);
        if (i != -1) {
          if (!this.mIsWriting)
          {
            RFLog.e("LruCache", RFLog.DEV, "Interrupt write cache.");
          }
          else
          {
            int j = RFLog.DEV;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(str);
            localStringBuilder.append(" Write buff, size ");
            localStringBuilder.append(i);
            RFLog.d("LruCache", j, localStringBuilder.toString());
            ((OutputStream)localObject2).write((byte[])localObject1, 0, i);
            break label175;
          }
        }
        ((OutputStream)localObject2).flush();
        localEditor.commit();
        try
        {
          ((OutputStream)localObject2).close();
        }
        catch (IOException paramInputStream)
        {
          paramInputStream.printStackTrace();
        }
        paramInputStream = (InputStream)localObject2;
      }
      finally
      {
        break label507;
      }
    }
    catch (IOException paramInputStream)
    {
      break label300;
      bool1 = false;
      break label436;
    }
    localObject1 = paramInputStream;
    i = RFLog.DEV;
    localObject1 = paramInputStream;
    localObject2 = new StringBuilder();
    localObject1 = paramInputStream;
    ((StringBuilder)localObject2).append("Set diskcache cache error. Cache name: ");
    localObject1 = paramInputStream;
    ((StringBuilder)localObject2).append(str);
    localObject1 = paramInputStream;
    ((StringBuilder)localObject2).append(", Uri: ");
    localObject1 = paramInputStream;
    ((StringBuilder)localObject2).append(???);
    localObject1 = paramInputStream;
    ((StringBuilder)localObject2).append(", hashCode:");
    localObject1 = paramInputStream;
    ((StringBuilder)localObject2).append(getInstanceHashCode());
    localObject1 = paramInputStream;
    RFLog.w("LruCache", i, ((StringBuilder)localObject2).toString());
    if (paramInputStream != null)
    {
      try
      {
        paramInputStream.close();
      }
      catch (IOException paramInputStream)
      {
        paramInputStream.printStackTrace();
      }
      label436:
      i = RFLog.DEV;
      paramInputStream = new StringBuilder();
      paramInputStream.append("Set Cache file success. Cache name: ");
      paramInputStream.append(str);
      paramInputStream.append(", Uri: ");
      paramInputStream.append(???);
      paramInputStream.append(", hashCode:");
      paramInputStream.append(getInstanceHashCode());
      RFLog.i("LruCache", i, paramInputStream.toString());
      break label581;
      label507:
      if (localObject2 != null) {
        try
        {
          ((OutputStream)localObject2).close();
        }
        catch (IOException paramInputStream)
        {
          paramInputStream.printStackTrace();
        }
      }
      throw ???;
      i = RFLog.DEV;
      paramInputStream = new StringBuilder();
      paramInputStream.append("Editor is null. Cache name: ");
      paramInputStream.append(str);
      paramInputStream.append(", Uri: ");
      paramInputStream.append(???);
      RFLog.w("LruCache", i, paramInputStream.toString());
      bool1 = false;
      label581:
      this.mDiskLruCache.notifyAll();
      bool2 = bool1;
      if (!this.mIsWriting)
      {
        remove(???);
        bool2 = bool1;
        break label673;
        label614:
        throw ???;
        i = RFLog.DEV;
        paramInputStream = new StringBuilder();
        paramInputStream.append("DiskCache or cacheName is null. Cache name: ");
        paramInputStream.append(str);
        paramInputStream.append(", Uri: ");
        paramInputStream.append(???);
        RFLog.w("LruCache", i, paramInputStream.toString());
        bool2 = false;
      }
      label673:
      synchronized (this.mWriteLock)
      {
        this.mIsWriting = false;
        this.mCurrentCacheName = "";
        return bool2;
      }
    }
  }
  
  public long size()
  {
    initDiskCache();
    return getInstance().size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.richframework.network.cache.LruCache
 * JD-Core Version:    0.7.0.1
 */