package com.tencent.mm.vfs;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.ByteChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.List;
import java.util.Map;

public abstract class WrapperFileSystem<T extends FileSystem>
  extends AbstractFileSystem
{
  private static final int VERSION = 1;
  protected final T mFS;
  
  protected WrapperFileSystem(Parcel paramParcel)
  {
    VFSUtils.checkFileSystemVersion(paramParcel, WrapperFileSystem.class, 1);
    this.mFS = ((FileSystem)paramParcel.readParcelable(getClass().getClassLoader()));
    if (this.mFS != null) {
      return;
    }
    throw new IllegalArgumentException("Wrong wrapped filesystem.");
  }
  
  protected WrapperFileSystem(T paramT)
  {
    this.mFS = paramT;
  }
  
  public int batchDelete(List<String> paramList)
  {
    return this.mFS.batchDelete(paramList);
  }
  
  public int capabilityFlags()
  {
    return this.mFS.capabilityFlags();
  }
  
  public void configure(Map<String, String> paramMap)
  {
    this.mFS.configure(paramMap);
  }
  
  protected long copyFileImpl(String paramString1, FileSystem paramFileSystem, String paramString2)
  {
    FileSystem localFileSystem = this.mFS;
    if ((localFileSystem instanceof AbstractFileSystem)) {
      return ((AbstractFileSystem)localFileSystem).copyFileImpl(paramString1, paramFileSystem, paramString2);
    }
    return localFileSystem.copyFile(paramString1, paramFileSystem, paramString2);
  }
  
  public boolean delete(String paramString)
  {
    return this.mFS.delete(paramString);
  }
  
  public boolean deleteDir(String paramString, boolean paramBoolean)
  {
    return this.mFS.deleteDir(paramString, paramBoolean);
  }
  
  public boolean exists(String paramString)
  {
    return this.mFS.exists(paramString);
  }
  
  public FileSystem.FsStat fileSystemStat(String paramString)
  {
    return this.mFS.fileSystemStat(paramString);
  }
  
  public Iterable<FileSystem.FileEntry> list(String paramString, boolean paramBoolean)
  {
    return this.mFS.list(paramString, paramBoolean);
  }
  
  public void maintain(CancellationSignalCompat paramCancellationSignalCompat)
  {
    this.mFS.maintain(paramCancellationSignalCompat);
  }
  
  public boolean mkdirs(String paramString)
  {
    return this.mFS.mkdirs(paramString);
  }
  
  protected boolean moveFileImpl(String paramString1, FileSystem paramFileSystem, String paramString2)
  {
    FileSystem localFileSystem = this.mFS;
    if ((localFileSystem instanceof AbstractFileSystem)) {
      return ((AbstractFileSystem)localFileSystem).moveFileImpl(paramString1, paramFileSystem, paramString2);
    }
    return false;
  }
  
  public ParcelFileDescriptor openParcelFd(String paramString1, String paramString2)
  {
    return this.mFS.openParcelFd(paramString1, paramString2);
  }
  
  public InputStream openRead(String paramString)
  {
    return this.mFS.openRead(paramString);
  }
  
  public ReadableByteChannel openReadChannel(String paramString)
  {
    return this.mFS.openReadWriteChannel(paramString);
  }
  
  public ByteChannel openReadWriteChannel(String paramString)
  {
    return this.mFS.openReadWriteChannel(paramString);
  }
  
  public OutputStream openWrite(String paramString, boolean paramBoolean)
  {
    return this.mFS.openWrite(paramString, paramBoolean);
  }
  
  public WritableByteChannel openWriteChannel(String paramString, boolean paramBoolean)
  {
    return this.mFS.openWriteChannel(paramString, paramBoolean);
  }
  
  public String realPath(String paramString, boolean paramBoolean)
  {
    return this.mFS.realPath(paramString, paramBoolean);
  }
  
  public boolean setModifiedTime(String paramString, long paramLong)
  {
    return this.mFS.setModifiedTime(paramString, paramLong);
  }
  
  public FileSystem.FileEntry stat(String paramString)
  {
    return this.mFS.stat(paramString);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    VFSUtils.writeFileSystemVersion(paramParcel, WrapperFileSystem.class, 1);
    paramParcel.writeParcelable(this.mFS, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mm.vfs.WrapperFileSystem
 * JD-Core Version:    0.7.0.1
 */