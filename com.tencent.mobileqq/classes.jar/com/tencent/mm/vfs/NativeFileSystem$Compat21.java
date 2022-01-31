package com.tencent.mm.vfs;

import android.annotation.TargetApi;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.system.StructStat;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

@TargetApi(21)
final class NativeFileSystem$Compat21
{
  static boolean rename(String paramString1, String paramString2)
  {
    try
    {
      Os.rename(paramString1, paramString2);
      return true;
    }
    catch (ErrnoException localErrnoException)
    {
      if (localErrnoException.errno == OsConstants.EXDEV) {
        return false;
      }
      if (localErrnoException.errno == OsConstants.ENOENT) {
        throw new FileNotFoundException("Cannot move file " + paramString1 + " to " + paramString2 + ": " + localErrnoException.getMessage());
      }
      throw new IOException("Cannot move file " + paramString1 + " to " + paramString2 + ": " + localErrnoException.getMessage());
    }
  }
  
  static FileSystem.FileEntry toFileEntry(File paramFile, FileSystem paramFileSystem, String paramString1, String paramString2)
  {
    try
    {
      paramFile = Os.stat(paramFile.getPath());
      if (paramFile == null) {
        return null;
      }
      boolean bool = OsConstants.S_ISDIR(paramFile.st_mode);
      paramFile = new FileSystem.FileEntry(paramFileSystem, paramString1, paramString2, paramFile.st_size, paramFile.st_blocks * 512L, 1000L * paramFile.st_mtime, bool);
      return paramFile;
    }
    catch (ErrnoException paramFile) {}
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mm.vfs.NativeFileSystem.Compat21
 * JD-Core Version:    0.7.0.1
 */