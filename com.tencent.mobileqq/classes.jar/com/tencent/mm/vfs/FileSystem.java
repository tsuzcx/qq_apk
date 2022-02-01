package com.tencent.mm.vfs;

import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.ByteChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.List;
import java.util.Map;

public abstract interface FileSystem
  extends Parcelable
{
  public static final int CAP_DIRECTORIES = 8;
  public static final int CAP_DIRECT_ACCESS = 2;
  public static final int CAP_LISTABLE = 4;
  public static final int CAP_SEEKABLE = 16;
  public static final int CAP_WRITABLE = 1;
  
  public abstract int batchDelete(List<String> paramList);
  
  public abstract int capabilityFlags();
  
  public abstract void configure(Map<String, String> paramMap);
  
  public abstract long copyFile(String paramString1, FileSystem paramFileSystem, String paramString2);
  
  public abstract boolean delete(String paramString);
  
  public abstract boolean deleteDir(String paramString, boolean paramBoolean);
  
  public abstract boolean exists(String paramString);
  
  public abstract FileSystem.FsStat fileSystemStat(String paramString);
  
  public abstract Iterable<FileSystem.FileEntry> list(String paramString, boolean paramBoolean);
  
  public abstract void maintain(CancellationSignalCompat paramCancellationSignalCompat);
  
  public abstract boolean mkdirs(String paramString);
  
  public abstract boolean moveFile(String paramString1, FileSystem paramFileSystem, String paramString2);
  
  public abstract ParcelFileDescriptor openParcelFd(String paramString1, String paramString2);
  
  public abstract InputStream openRead(String paramString);
  
  public abstract ReadableByteChannel openReadChannel(String paramString);
  
  public abstract ByteChannel openReadWriteChannel(String paramString);
  
  public abstract OutputStream openWrite(String paramString, boolean paramBoolean);
  
  public abstract WritableByteChannel openWriteChannel(String paramString, boolean paramBoolean);
  
  public abstract String realPath(String paramString, boolean paramBoolean);
  
  public abstract boolean setModifiedTime(String paramString, long paramLong);
  
  public abstract FileSystem.FileEntry stat(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mm.vfs.FileSystem
 * JD-Core Version:    0.7.0.1
 */