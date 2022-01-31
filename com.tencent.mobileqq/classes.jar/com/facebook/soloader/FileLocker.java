package com.facebook.soloader;

import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public final class FileLocker
  implements Closeable
{
  private final FileLock mLock;
  private final FileOutputStream mLockFileOutputStream;
  
  private FileLocker(File paramFile)
    throws IOException
  {
    this.mLockFileOutputStream = new FileOutputStream(paramFile);
    try
    {
      paramFile = this.mLockFileOutputStream.getChannel().lock();
      if (paramFile == null) {
        this.mLockFileOutputStream.close();
      }
      this.mLock = paramFile;
      return;
    }
    finally
    {
      if (0 == 0) {
        this.mLockFileOutputStream.close();
      }
    }
  }
  
  public static FileLocker lock(File paramFile)
    throws IOException
  {
    return new FileLocker(paramFile);
  }
  
  public void close()
    throws IOException
  {
    try
    {
      this.mLock.release();
      return;
    }
    finally
    {
      this.mLockFileOutputStream.close();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.facebook.soloader.FileLocker
 * JD-Core Version:    0.7.0.1
 */