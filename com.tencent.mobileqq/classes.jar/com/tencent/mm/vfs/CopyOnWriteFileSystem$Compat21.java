package com.tencent.mm.vfs;

import android.annotation.TargetApi;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.system.StructStat;
import java.io.IOException;
import java.io.RandomAccessFile;

@TargetApi(21)
final class CopyOnWriteFileSystem$Compat21
{
  static long getINode(RandomAccessFile paramRandomAccessFile)
  {
    try
    {
      long l = Os.fstat(paramRandomAccessFile.getFD()).st_ino;
      return l;
    }
    catch (ErrnoException paramRandomAccessFile)
    {
      throw new IOException(paramRandomAccessFile);
    }
  }
  
  static FileSystem.FileEntry toFileEntry(String paramString1, FileSystem paramFileSystem, String paramString2, String paramString3)
  {
    try
    {
      paramString1 = Os.stat(paramString1);
      if (paramString1 == null) {
        return null;
      }
      boolean bool = OsConstants.S_ISDIR(paramString1.st_mode);
      paramString1 = new FileSystem.FileEntry(paramFileSystem, paramString2, paramString3, paramString1.st_size, paramString1.st_blocks * 512L, 1000L * paramString1.st_mtime, bool);
      return paramString1;
    }
    catch (ErrnoException paramString1) {}
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mm.vfs.CopyOnWriteFileSystem.Compat21
 * JD-Core Version:    0.7.0.1
 */