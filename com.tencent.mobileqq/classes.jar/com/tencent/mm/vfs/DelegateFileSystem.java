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
    int i = 0;
    while (localIterator.hasNext()) {
      i += ((FileSystem)localIterator.next()).batchDelete(paramList);
    }
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
    boolean bool = false;
    while (localIterator.hasNext()) {
      bool |= ((FileSystem)localIterator.next()).delete(paramString);
    }
    return bool;
  }
  
  public boolean deleteDir(String paramString, boolean paramBoolean)
  {
    Iterator localIterator = allFileSystems().iterator();
    boolean bool = false;
    while (localIterator.hasNext()) {
      bool |= ((FileSystem)localIterator.next()).deleteDir(paramString, paramBoolean);
    }
    return bool;
  }
  
  public boolean exists(String paramString)
  {
    FileSystem localFileSystem = delegate(paramString, 1);
    return (localFileSystem != null) && (localFileSystem.exists(paramString));
  }
  
  public FileSystem.FsStat fileSystemStat(String paramString)
  {
    Object localObject = delegate(paramString, 0);
    if (localObject != null) {
      return ((FileSystem)localObject).fileSystemStat(paramString);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Cannot delegate path to filesystem: ");
    ((StringBuilder)localObject).append(paramString);
    throw new RuntimeException(((StringBuilder)localObject).toString());
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
    } else if (paramString2.contains("w")) {
      i = 2;
    } else {
      i = 1;
    }
    FileSystem localFileSystem = delegate(paramString1, i);
    if (localFileSystem != null) {
      return localFileSystem.openParcelFd(paramString1, paramString2);
    }
    paramString2 = new StringBuilder();
    paramString2.append("Path not found on any filesystems: ");
    paramString2.append(paramString1);
    throw new FileNotFoundException(paramString2.toString());
  }
  
  public InputStream openRead(String paramString)
  {
    Object localObject = delegate(paramString, 1);
    if (localObject != null) {
      return ((FileSystem)localObject).openRead(paramString);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Path not found on any filesystems: ");
    ((StringBuilder)localObject).append(paramString);
    throw new FileNotFoundException(((StringBuilder)localObject).toString());
  }
  
  public ReadableByteChannel openReadChannel(String paramString)
  {
    Object localObject = delegate(paramString, 1);
    if (localObject != null) {
      return ((FileSystem)localObject).openReadChannel(paramString);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Path not found on any filesystems: ");
    ((StringBuilder)localObject).append(paramString);
    throw new FileNotFoundException(((StringBuilder)localObject).toString());
  }
  
  public ByteChannel openReadWriteChannel(String paramString)
  {
    Object localObject = delegate(paramString, 3);
    if (localObject != null) {
      return ((FileSystem)localObject).openReadWriteChannel(paramString);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Path not found on any filesystems: ");
    ((StringBuilder)localObject).append(paramString);
    throw new FileNotFoundException(((StringBuilder)localObject).toString());
  }
  
  public OutputStream openWrite(String paramString, boolean paramBoolean)
  {
    int i;
    if (paramBoolean) {
      i = 3;
    } else {
      i = 2;
    }
    Object localObject = delegate(paramString, i);
    if (localObject != null) {
      return ((FileSystem)localObject).openWrite(paramString, paramBoolean);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Path not found on any filesystems: ");
    ((StringBuilder)localObject).append(paramString);
    throw new FileNotFoundException(((StringBuilder)localObject).toString());
  }
  
  public WritableByteChannel openWriteChannel(String paramString, boolean paramBoolean)
  {
    int i;
    if (paramBoolean) {
      i = 3;
    } else {
      i = 2;
    }
    Object localObject = delegate(paramString, i);
    if (localObject != null) {
      return ((FileSystem)localObject).openWriteChannel(paramString, paramBoolean);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Path not found on any filesystems: ");
    ((StringBuilder)localObject).append(paramString);
    throw new FileNotFoundException(((StringBuilder)localObject).toString());
  }
  
  public String realPath(String paramString, boolean paramBoolean)
  {
    int i;
    if (paramBoolean) {
      i = 2;
    } else {
      i = 1;
    }
    FileSystem localFileSystem = delegate(paramString, i);
    if (localFileSystem == null) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mm.vfs.DelegateFileSystem
 * JD-Core Version:    0.7.0.1
 */