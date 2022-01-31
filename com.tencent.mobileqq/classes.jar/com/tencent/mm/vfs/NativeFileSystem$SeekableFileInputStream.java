package com.tencent.mm.vfs;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

class NativeFileSystem$SeekableFileInputStream
  extends FileInputStream
{
  private long mMarkPosition = 0L;
  
  NativeFileSystem$SeekableFileInputStream(String paramString)
  {
    super(paramString);
  }
  
  public void mark(int paramInt)
  {
    try
    {
      this.mMarkPosition = getChannel().position();
      return;
    }
    catch (IOException localIOException)
    {
      throw new RuntimeException(localIOException);
    }
  }
  
  public boolean markSupported()
  {
    return true;
  }
  
  public void reset()
  {
    getChannel().position(this.mMarkPosition);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mm.vfs.NativeFileSystem.SeekableFileInputStream
 * JD-Core Version:    0.7.0.1
 */