package com.tencent.mm.vfs;

import android.os.ParcelFileDescriptor;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.ByteChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public abstract class DelegateFileSystem
  extends AbstractFileSystem
{
  protected static final int DELEGATE_MAIN = 0;
  protected static final int DELEGATE_READ = 1;
  protected static final int DELEGATE_WRITE = 2;
  protected static final int DELEGATE_WRITE_EXISTING = 3;
  
  protected abstract Iterable<FileSystem> allFileSystems();
  
  public int batchDelete(List<String> paramList)
  {
    Iterator localIterator = allFileSystems().iterator();
    for (int i = 0; localIterator.hasNext(); i = ((FileSystem)localIterator.next()).batchDelete(paramList) + i) {}
    return i;
  }
  
  public int capabilityFlags()
  {
    return delegate("", 0).capabilityFlags();
  }
  
  public void configure(Map<String, String> paramMap)
  {
    Iterator localIterator = allFileSystems().iterator();
    while (localIterator.hasNext()) {
      ((FileSystem)localIterator.next()).configure(paramMap);
    }
  }
  
  protected final long copyFileImpl(String paramString1, FileSystem paramFileSystem, String paramString2)
  {
    throw new AssertionError();
  }
  
  protected abstract FileSystem delegate(String paramString, int paramInt);
  
  public boolean delete(String paramString)
  {
    Iterator localIterator = allFileSystems().iterator();
    for (boolean bool = false; localIterator.hasNext(); bool = ((FileSystem)localIterator.next()).delete(paramString) | bool) {}
    return bool;
  }
  
  public boolean deleteDir(String paramString, boolean paramBoolean)
  {
    Iterator localIterator = allFileSystems().iterator();
    for (boolean bool = false; localIterator.hasNext(); bool = ((FileSystem)localIterator.next()).deleteDir(paramString, paramBoolean) | bool) {}
    return bool;
  }
  
  public boolean exists(String paramString)
  {
    FileSystem localFileSystem = delegate(paramString, 1);
    return (localFileSystem != null) && (localFileSystem.exists(paramString));
  }
  
  public FileSystem.FsStat fileSystemStat(String paramString)
  {
    FileSystem localFileSystem = delegate(paramString, 0);
    if (localFileSystem == null) {
      throw new RuntimeException("Cannot delegate path to filesystem: " + paramString);
    }
    return localFileSystem.fileSystemStat(paramString);
  }
  
  public Iterable<FileSystem.FileEntry> list(String paramString, boolean paramBoolean)
  {
    return new DelegateFileSystem.1(this, paramString, paramBoolean);
  }
  
  public void maintain(CancellationSignalCompat paramCancellationSignalCompat)
  {
    Iterator localIterator = allFileSystems().iterator();
    while (localIterator.hasNext())
    {
      FileSystem localFileSystem = (FileSystem)localIterator.next();
      paramCancellationSignalCompat.throwIfCanceled();
      localFileSystem.maintain(paramCancellationSignalCompat);
    }
  }
  
  public boolean mkdirs(String paramString)
  {
    FileSystem localFileSystem = delegate(paramString, 2);
    return (localFileSystem != null) && (localFileSystem.mkdirs(paramString));
  }
  
  protected final boolean moveFileImpl(String paramString1, FileSystem paramFileSystem, String paramString2)
  {
    throw new AssertionError();
  }
  
  public ParcelFileDescriptor openParcelFd(String paramString1, String paramString2)
  {
    int i;
    if (paramString2.contains("rw")) {
      i = 3;
    }
    FileSystem localFileSystem;
    for (;;)
    {
      localFileSystem = delegate(paramString1, i);
      if (localFileSystem != null) {
        break;
      }
      throw new FileNotFoundException("Path not found on any filesystems: " + paramString1);
      if (paramString2.contains("w")) {
        i = 2;
      } else {
        i = 1;
      }
    }
    return localFileSystem.openParcelFd(paramString1, paramString2);
  }
  
  public InputStream openRead(String paramString)
  {
    FileSystem localFileSystem = delegate(paramString, 1);
    if (localFileSystem == null) {
      throw new FileNotFoundException("Path not found on any filesystems: " + paramString);
    }
    return localFileSystem.openRead(paramString);
  }
  
  public ReadableByteChannel openReadChannel(String paramString)
  {
    FileSystem localFileSystem = delegate(paramString, 1);
    if (localFileSystem == null) {
      throw new FileNotFoundException("Path not found on any filesystems: " + paramString);
    }
    return localFileSystem.openReadChannel(paramString);
  }
  
  public ByteChannel openReadWriteChannel(String paramString)
  {
    FileSystem localFileSystem = delegate(paramString, 3);
    if (localFileSystem == null) {
      throw new FileNotFoundException("Path not found on any filesystems: " + paramString);
    }
    return localFileSystem.openReadWriteChannel(paramString);
  }
  
  public OutputStream openWrite(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {}
    FileSystem localFileSystem;
    for (int i = 3;; i = 2)
    {
      localFileSystem = delegate(paramString, i);
      if (localFileSystem != null) {
        break;
      }
      throw new FileNotFoundException("Path not found on any filesystems: " + paramString);
    }
    return localFileSystem.openWrite(paramString, paramBoolean);
  }
  
  public WritableByteChannel openWriteChannel(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {}
    FileSystem localFileSystem;
    for (int i = 3;; i = 2)
    {
      localFileSystem = delegate(paramString, i);
      if (localFileSystem != null) {
        break;
      }
      throw new FileNotFoundException("Path not found on any filesystems: " + paramString);
    }
    return localFileSystem.openWriteChannel(paramString, paramBoolean);
  }
  
  public String realPath(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {}
    FileSystem localFileSystem;
    for (int i = 2;; i = 1)
    {
      localFileSystem = delegate(paramString, i);
      if (localFileSystem != null) {
        break;
      }
      return null;
    }
    return localFileSystem.realPath(paramString, paramBoolean);
  }
  
  public boolean setModifiedTime(String paramString, long paramLong)
  {
    FileSystem localFileSystem = delegate(paramString, 3);
    return (localFileSystem != null) && (localFileSystem.setModifiedTime(paramString, paramLong));
  }
  
  public FileSystem.FileEntry stat(String paramString)
  {
    FileSystem localFileSystem = delegate(paramString, 1);
    if (localFileSystem == null) {
      return null;
    }
    return localFileSystem.stat(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.vfs.DelegateFileSystem
 * JD-Core Version:    0.7.0.1
 */